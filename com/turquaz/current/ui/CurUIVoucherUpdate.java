package com.turquaz.current.ui;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CurUIVoucherUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private CurUICurrentCardVoucher compVoucher;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
    TurqCurrentTransaction curTrans;


	public CurUIVoucherUpdate(Shell parent, int style, TurqCurrentTransaction curTrans){
		super(parent, style);
		this.curTrans = curTrans;
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
	
			dialogShell.setSize(672, 316);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setText(Messages.getString("CurUIVoucherUpdate.0")); //$NON-NLS-1$
                    toolUpdate.setImage(SWTResourceManager
                        .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                        toolUpdate.addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                              
                            update();
                            dialogShell.close();
                            }
                        });
                }
                {
                    toolDelete = new ToolItem(toolBar1, SWT.NONE);
                    toolDelete.setText(Messages.getString("CurUIVoucherUpdate.2")); //$NON-NLS-1$
                    toolDelete.setImage(SWTResourceManager
                        .getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                        toolDelete.addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                                
                              delete();
                              dialogShell.close();
                              }
                        
                        
                        });
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText(Messages.getString("CurUIVoucherUpdate.4")); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager
                        .getImage("icons/cancel.jpg")); //$NON-NLS-1$
                        toolCancel.addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                            dialogShell.close(); 
                            }
                        });
                }
                {
                    toolPrint = new ToolItem(toolBar1, SWT.NONE);
                    toolPrint.setText(Messages.getString("CurUIVoucherUpdate.3")); //$NON-NLS-1$
                    toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif")); //$NON-NLS-1$
                    toolPrint.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            dialogShell.close();
                            EngBLUtils.printCurrentTrans(curTrans);
                        
                        }
                    });
                }
            }
            {
                compVoucher = new CurUICurrentCardVoucher(dialogShell, SWT.NONE);
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
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
        EngUICommon.centreWindow(dialogShell);
	    
	    
	    if(curTrans.getTransactionsTotalDept().doubleValue()>0){
	        compVoucher.getTxtDept().setText(curTrans.getTransactionsTotalDept());
	        
	    }
	    else
	    {
	        compVoucher.getTxtCredit().setText(curTrans.getTransactionsTotalCredit());
	    }
	    
	    compVoucher.getDateTransDate().setDate(curTrans.getTransactionsDate());
	    compVoucher.getTxtCurrentCard().setText(curTrans.getTurqCurrentCard().getCardsName()+" {"+curTrans.getTurqCurrentCard().getCardsCurrentCode()+"}"); //$NON-NLS-1$ //$NON-NLS-2$
	    compVoucher.getTxtDefinition().setText(curTrans.getTransactionsDefinition());
	    
	}
	
	public void update(){
	if(compVoucher.verifyFields())
	{
	    curTrans.setTurqCurrentCard((TurqCurrentCard)compVoucher.getTxtCurrentCard().getData());
	    curTrans.setTransactionsDate(compVoucher.getDateTransDate().getDate());
	    curTrans.setTransactionsDefinition(compVoucher.getTxtDefinition().getText().trim());
	    curTrans.setTransactionsTotalCredit(compVoucher.getTxtCredit().getBigDecimalValue());
	    curTrans.setTransactionsTotalDept(compVoucher.getTxtDept().getBigDecimalValue());
	    try{
	       CurBLTransactionUpdate.updateTrans(curTrans);
	       EngUICommon.showMessageBox(getParent(),Messages.getString("CurUIVoucherUpdate.1")); //$NON-NLS-1$
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	    
	    
	}
	public void delete(){
	    try{
	        
	        if(EngUICommon.okToDelete(getParent()))
	        {
	            CurBLTransactionUpdate.delete(curTrans);
	        }
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	
}
