package com.turquaz.cash.ui;

import java.math.BigDecimal;
import java.util.Iterator;
import org.eclipse.swt.layout.GridLayout;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
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
public class CashUICashCollectTransactionUpdate extends Dialog {
    private Shell dialogShell;
   

	private CoolBar coolBar1;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ToolItem tooldelete;
	private CashUICashCollectTransactionAdd compTransAdd;
	private ToolItem toolCancel;
	private ToolBar toolBar1;

	CashBLCashTransactionUpdate  blUpdate = new CashBLCashTransactionUpdate();
	
    TurqCashTransaction cashTrans ;  

	public CashUICashCollectTransactionUpdate(Shell parent, int style, TurqCashTransaction cashTrans) {
		super(parent, style);
		this.cashTrans = cashTrans;
		
	}

	public void open() {
		try {
		    Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			 {
			        //Register as a resource user - SWTResourceManager will
			        //handle the obtaining and disposing of resources
			        SWTResourceManager.registerResourceUser(this.dialogShell);
			    }
			dialogShell.setLayout(new GridLayout());
			dialogShell.setSize(633, 353);
            {
                coolBar1 = new CoolBar(dialogShell, SWT.NONE);
                GridData coolBar1LData = new GridData();
                coolBar1LData.heightHint = 49;
                coolBar1LData.grabExcessHorizontalSpace = true;
                coolBar1LData.horizontalAlignment = GridData.FILL;
                coolBar1.setLayoutData(coolBar1LData);
                {
                    coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                    coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 53));
                    coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 53));
                    coolItem1.setSize(45, 53);
                    {
                        toolBar1 = new ToolBar(coolBar1, SWT.NONE);
                        coolItem1.setControl(toolBar1);
                        {
                            toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                            toolUpdate.setText(Messages.getString("CashUICashCollectTransactionUpdate.0")); //$NON-NLS-1$
                            toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                            toolUpdate
                            .addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                               
                            update();
                            }
                            });
                        }
                        {
                            tooldelete = new ToolItem(toolBar1, SWT.NONE);
                            tooldelete.setText(Messages.getString("CashUICashCollectTransactionUpdate.2")); //$NON-NLS-1$
                            tooldelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                            tooldelete
                                .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                   
                                delete();
                                }
                                });
                        }
                        {
                            toolCancel = new ToolItem(toolBar1, SWT.NONE);
                            toolCancel.setText(Messages.getString("CashUICashCollectTransactionUpdate.4")); //$NON-NLS-1$
                            toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                            toolCancel
                                .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                dialogShell.close();   
                                
                                }
                                });
                        }
                    }
                }
            }
            {
                compTransAdd = new CashUICashCollectTransactionAdd(dialogShell, SWT.NONE);
                GridData compTransAddLData = new GridData();
                compTransAddLData.grabExcessHorizontalSpace = true;
                compTransAddLData.horizontalAlignment = GridData.FILL;
                compTransAddLData.grabExcessVerticalSpace = true;
                compTransAddLData.verticalAlignment = GridData.FILL;
                compTransAdd.setLayoutData(compTransAddLData);
            }
            postInitGUI();
			dialogShell.layout();
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
	
	    compTransAdd.getTxtDocumentNo().setText(cashTrans.getDocumentNo());
	    compTransAdd.getDatePicker().setDate(cashTrans.getTransactionDate());
	    compTransAdd.getTxtCashCard().setText(cashTrans.getTurqCashCard().getCashCardName());
        compTransAdd.getTxtDefinition().setText(cashTrans.getTransactionDefinition());
	    
	    /**
	    * TODO Cari hesabi bul 
	    */
        try{
        TurqCurrentCard curCard = blUpdate.getCurrentCard(cashTrans.getTurqEngineSequence());
        
        if(curCard!=null){
        
            compTransAdd.getTxtCurrentAccount().setText(curCard.getCardsCurrentCode());
            
        }
        
        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
	    Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
	    if(it.hasNext()){
	     
	        TurqCashTransactionRow row = (TurqCashTransactionRow)it.next();
	        
	        if(row.getDeptAmount().compareTo(new BigDecimal(0))==1){
	            
	            compTransAdd.getCurTextTotalAmount().setText(row.getDeptAmount().toString());
	            
	        }
	        else
	        {
	            compTransAdd.getCurTextTotalAmount().setText(row.getCreditAmount().toString() );
	        }
	   }
	    
	    
	}
	public void delete(){
	    try{
	        MessageBox msg = new MessageBox(this.getParent(),SWT.ICON_QUESTION|SWT.YES|SWT.NO);
	        msg.setMessage(Messages.getString("CashUICashCollectTransactionUpdate.1")); //$NON-NLS-1$
	        int answer = msg.open();
	        
	        if(answer == SWT.YES){
	          blUpdate.deleteCashTrans(cashTrans);
	          MessageBox msg2 = new MessageBox(this.getParent(),SWT.ICON_INFORMATION);
	          msg2.setMessage(Messages.getString("CashUICashCollectTransactionUpdate.3")); //$NON-NLS-1$
	          msg2.open();          
	          
	          dialogShell.close();
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	}
	public void update(){
	    try{
	        MessageBox msg = new MessageBox(this.getParent(),SWT.ICON_INFORMATION);
	        if(compTransAdd.verifyFields()){
	        
	        blUpdate.updateCashTrans(cashTrans,(TurqCashCard)compTransAdd.getTxtCashCard().getData(),
	                                (TurqCurrentCard)compTransAdd.getTxtCurrentAccount().getData(),
	                                compTransAdd.getCurTextTotalAmount().getBigDecimalValue(),
	                                compTransAdd.getDatePicker().getDate(),
	                                compTransAdd.getTxtDefinition().getText(),
	                                compTransAdd.getTxtDocumentNo().getText());
	        }
	        msg.setMessage(Messages.getString("CashUICashCollectTransactionUpdate.5")); //$NON-NLS-1$
	        msg.open();
	        
	        dialogShell.close();
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}

}
