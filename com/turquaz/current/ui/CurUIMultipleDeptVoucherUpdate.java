package com.turquaz.current.ui;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionCollectTableRow;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


public class CurUIMultipleDeptVoucherUpdate extends org.eclipse.swt.widgets.Dialog
{
    private Shell dialogShell;
    private ToolItem toolUpdate;
    private CurUIMultipleDeptVoucher compVoucher;
    private ToolItem toolCancel;
    private ToolItem toolDelete;
    private ToolBar toolBar1;
    TurqCurrentTransaction curTrans;
    private boolean updated = false;

    public CurUIMultipleDeptVoucherUpdate(Shell parent, int style, TurqCurrentTransaction curTrans)
    {
        super(parent, style);
        this.curTrans = curTrans;
    }

    public boolean open()
    {
        try
        {
            Shell parent = getParent();
            dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
            {
                //Register as a resource user - SWTResourceManager will
                //handle the obtaining and disposing of resources
                SWTResourceManager.registerResourceUser(dialogShell);
            }
            dialogShell.setLayout(new GridLayout());
            dialogShell.layout();
            dialogShell.setText(CurLangKeys.TITLE_MULTIPLE_DEPt_VOUCHER_UPDATE); //$NON-NLS-1$
            dialogShell.setSize(677, 392);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); //$NON-NLS-1$
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolUpdate.addSelectionListener(new SelectionAdapter()
                    {
                        public void widgetSelected(SelectionEvent evt)
                        {
                            update();
                            dialogShell.close();
                        }
                    });
                }
                {
                    toolDelete = new ToolItem(toolBar1, SWT.NONE);
                    toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
                    toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                    toolDelete.addSelectionListener(new SelectionAdapter()
                    {
                        public void widgetSelected(SelectionEvent evt)
                        {
                            delete();
                            dialogShell.close();
                        }
                    });
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                    toolCancel.addSelectionListener(new SelectionAdapter()
                    {
                        public void widgetSelected(SelectionEvent evt)
                        {
                            dialogShell.close();
                        }
                    });
                }
            }
            {
                compVoucher = new CurUIMultipleDeptVoucher(dialogShell, SWT.NONE);
                GridData compVoucherLData = new GridData();
                compVoucherLData.horizontalAlignment = GridData.FILL;
                compVoucherLData.grabExcessHorizontalSpace = true;
                compVoucherLData.verticalAlignment = GridData.FILL;
                compVoucherLData.grabExcessVerticalSpace = true;
                compVoucher.setLayoutData(compVoucherLData);
            }
            postInitGUI();
            dialogShell.open();
            Display display = dialogShell.getDisplay();
            while (!dialogShell.isDisposed())
            {
                if (!display.readAndDispatch())
                    display.sleep();
            }
            return updated;
        }
        catch (Exception e)
        {
            EngBLLogger.log(this.getClass(),e,getParent());
            return true;
        }
    }

    public void postInitGUI()
    {
        compVoucher.tableViewer.removeAll();
        EngUICommon.centreWindow(dialogShell);
        compVoucher.getCurrentPicker().setData(curTrans.getTurqCurrentCard());
        
        try
        {
            HashMap argMap = new HashMap();
            argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
            
            EngTXCommon.doSelectTX(CurBLTransactionUpdate.class.getName(),"initCurTrans",argMap);
            Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
            if (it.hasNext())
            {         
                TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
                 argMap = new HashMap();
                argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
                EngTXCommon.doSelectTX(AccBLTransactionUpdate.class.getName(),"initiliazeTransactionRows",argMap);
                
                Iterator accIt = accTrans.getTurqAccountingTransactionColumns().iterator();
                while (accIt.hasNext())
                {
                    TurqAccountingTransactionColumn transRow = (TurqAccountingTransactionColumn)accIt.next();
                    if(transRow.getCreditAmount().doubleValue()>0)
                    {
                        ITableRow row = new AccUITransactionCollectTableRow(compVoucher.tableViewer.getRowList());
                        row.setDBObject(transRow);
                        compVoucher.tableViewer.addRow(row);                
                        
                    }            
                    
                }
                
                
            }
        }
        catch(Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getParent());
        }
            
        
       
       
    }

    public void update()
    {
        try
        {
            updated = true;
            HashMap argMap = new HashMap();
            argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
            EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteCurTrans",argMap);
            compVoucher.saveTrans();
            
            
        }
        catch(Exception ex)
        {
            EngBLLogger.log(getClass(),ex,getParent());
        }
      
        
    }

    public void delete()
    {
        try
        {
            if (EngUICommon.okToDelete(getParent()))
            {
                
                updated = true;
                HashMap argMap = new HashMap();
                argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
                EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteCurTrans",argMap);
                
            }
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getParent());
        }
    }
}