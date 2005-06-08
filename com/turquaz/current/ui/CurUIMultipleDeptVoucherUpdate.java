package com.turquaz.current.ui;

import java.util.Date;
import java.util.HashMap;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.AccUITransactionCollectTableRow;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
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
	Integer transId;
    private boolean updated = false;

    public CurUIMultipleDeptVoucherUpdate(Shell parent, int style,Integer curTransId)
    {
        super(parent, style);
		 this.transId = curTransId;
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
                    toolCancel.setText(EngLangCommonKeys.STR_CANCEL); //$NON-NLS-1$
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
		
			try{
			HashMap argMap = new HashMap();
	        argMap.put(CurKeys.CUR_TRANSACTION_ID,transId);
			
			HashBag voucherInfo = (HashBag)EngTXCommon.doSelectTX(CurBLTransactionUpdate.class.getName(),"getMultipleVoucherInfo",argMap);
			
			String currentCode = (String)voucherInfo.get(CurKeys.CUR_CURRENT_CODE);
			String currentName = (String)voucherInfo.get(CurKeys.CUR_CURRENT_NAME);
			Date transDate = (Date)voucherInfo.get(EngKeys.DATE);
			String definition = (String)voucherInfo.get(EngKeys.DEFINITION);
			String docNo = (String)voucherInfo.get(EngKeys.DOCUMENT_NO);
			compVoucher.getTxtDefinition().setText(definition);
			compVoucher.getTxtDocumentNo().setText(docNo);
			compVoucher.getDatePickerTransactionDate().setDate(transDate);
			
			
			
			
			HashMap transRows = (HashMap)voucherInfo.get(AccKeys.ACC_TRANSACTION_ROWS);

			compVoucher.getCurrentPicker().setText(currentName+" {"+currentCode+"}");
	        
			
			for(int i=0;i<transRows.size();i++)
			{
				
				HashMap rowInfo = (HashMap)transRows.get(new Integer(i));
				
	            ITableRow row = new AccUITransactionCollectTableRow(compVoucher.tableViewer.getRowList());
	            row.setDBObject(rowInfo);
	            compVoucher.tableViewer.addRow(row);    
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
            argMap.put(CurKeys.CUR_TRANSACTION_ID,transId);
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
                argMap.put(CurKeys.CUR_TRANSACTION_ID,transId);
                EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteCurTrans",argMap);
                
            }
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getParent());
        }
    }
}