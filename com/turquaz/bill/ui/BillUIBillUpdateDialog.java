package com.turquaz.bill.ui;


import java.util.Iterator;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import net.sf.hibernate.Hibernate;

import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
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
public class BillUIBillUpdateDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private BillUIAddBill compAddBill;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	private TurqBill bill;
	ConBLUpdateConsignment blUpdateCons = new ConBLUpdateConsignment();
	BillBLUpdateBill blUpdateBill = new BillBLUpdateBill();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/

	public BillUIBillUpdateDialog(Shell parent, int style, TurqBill bill) {
		super(parent, style);
		this.bill = bill;
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
			dialogShell.pack();
			dialogShell.setSize(690, 562);
            {
                coolBar1 = new CoolBar(dialogShell, SWT.NONE);
                GridData coolBar1LData = new GridData();
                coolBar1LData.heightHint = 46;
                coolBar1LData.horizontalAlignment = GridData.FILL;
                coolBar1LData.grabExcessHorizontalSpace = true;
                coolBar1.setLayoutData(coolBar1LData);
                {
                    coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                    coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 45));
                    coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 45));
                    coolItem1.setSize(45, 45);
                    {
                        toolBar1 = new ToolBar(coolBar1, SWT.NONE);
                        coolItem1.setControl(toolBar1);
                        {
                            toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                            toolUpdate.setText("Güncelle");
                            toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
                        }
                        {
                            toolDelete = new ToolItem(toolBar1, SWT.NONE);
                            toolDelete.setText("Sil");
                            toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
                        }
                    }
                }
            }
            {
                compAddBill = new BillUIAddBill(dialogShell, SWT.NONE);
                GridData compBillUIAddDialogLData = new GridData();
                compBillUIAddDialogLData.grabExcessHorizontalSpace = true;
                compBillUIAddDialogLData.horizontalAlignment = GridData.FILL;
                compBillUIAddDialogLData.verticalAlignment = GridData.FILL;
                compBillUIAddDialogLData.grabExcessVerticalSpace = true;
                compAddBill.setLayoutData(compBillUIAddDialogLData);
            }
            postInitGui();
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
	public void postInitGui(){
	    try{
	        
	        toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			    
			if(EngBLPermissions.getPermission(compAddBill.getClass().getName())==2){
			    toolUpdate.setEnabled(true); 
			}
			else if(EngBLPermissions.getPermission(compAddBill.getClass().getName())==3){
			    toolDelete.setEnabled(true);
			    toolUpdate.setEnabled(true); 
			}
			
			compAddBill.getTxtCurrentCard().setData(bill.getTurqBillConsignmentCommon().getTurqCurrentCard());
			compAddBill.getTxtCurrentCard().setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsCurrentCode()+Messages.getString("ConUIConsignmentUpdateDialog.4") + //$NON-NLS-1$
															bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName());
			;
			compAddBill.getTxtDocumentNo().setText(bill.getTurqBillConsignmentCommon().getBillDocumentNo());
			compAddBill.getDateConsignmentDate().setDate(bill.getBillsDate());
			compAddBill.getTxtConsignmentDocumentNo().setText(bill.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
		    compAddBill.getCheckIsOpen().setSelection(bill.isIsOpen());
			
			
			if(bill.getBillsType()==0){
			compAddBill.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.5")); //$NON-NLS-1$
			}
			else{
		    compAddBill.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.6")); //$NON-NLS-1$
			}
		
			compAddBill.getTxtDefinition().setText(bill.getBillsDefinition());
			compAddBill.getTxtDiscountRate().setText(bill.getTurqBillConsignmentCommon().getDiscountRate());
			fillInvTransactionColumns();
			fillRegisteredGroup();
			
			
		    
	        
	        
	        
	    
	    }	    
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	    
	    
	}
	public void fillInvTransactionColumns(){
		
	    TableItem item;
		TurqInventoryTransaction invTrans;
		
		Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
		
		if(it.hasNext()){
	    TurqConsignment cons = (TurqConsignment)it.next();
		
	    Iterator it2 = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
		
		while(it2.hasNext()){
			
		    invTrans = (TurqInventoryTransaction)it2.next();
			
			item = new TableItem(compAddBill.getTableConsignmentRows(),SWT.NULL);
			
			item.setData(invTrans);
			item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
									   invTrans.getTurqInventoryCard().getCardName(),
									   invTrans.getTransactionsAmountIn()+"", //$NON-NLS-1$
									   invTrans.getTurqInventoryUnit().getUnitsName(),
									   invTrans.getTransactionsUnitPrice().toString(),
									   invTrans.getTransactionsTotalPrice().toString(),
									   invTrans.getTransactionsVat()+"", //$NON-NLS-1$
									   invTrans.getTransactionsVatAmount().toString(),
									   invTrans.getTransactionsVatSpecialAmount().toString(),
									   invTrans.getTransactionsCumilativePrice().toString()});
			
		}
		}
		compAddBill.calculateTotals();
		
	}
	
	
	
	public void fillRegisteredGroup(){
		
			TurqBillInGroup group;
			Iterator it = bill.getTurqBillInGroups().iterator();
			while(it.hasNext()){
				group = (TurqBillInGroup)it.next();
				compAddBill.getCompRegisterGroup().RegisterGroup(group.getTurqBillGroup());
				
				
			}
			
		
		}
	
	public void update(){
	MessageBox msg;
	try{
	   if(compAddBill.verifyFields()){
	       int type=0;
			if(compAddBill.getComboConsignmentType().getText().equals("Sat??"))  //$NON-NLS-1$
			{
				type =1;
			}
	       
	       Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
			
	       //update the consignment
	       
			if(it.hasNext()){
		    TurqConsignment cons = (TurqConsignment)it.next();
	        blUpdateCons.updateConsignment(cons,
	                					compAddBill.getTxtConsignmentDocumentNo().getText(),
	                					compAddBill.getTxtDefinition().getText(),
	                					compAddBill.getDateConsignmentDate().getDate(),
	                					(TurqCurrentCard)compAddBill.getTxtCurrentCard().getData(),
	                					compAddBill.getTxtDiscountRate().getIntValue(),
	                					compAddBill.getTxtDiscountAmount().getBigDecimalValue(),
	                					compAddBill.getTxtDocumentNo().getText(),
	                					compAddBill.getTxtTotalVat().getBigDecimalValue(),
	                					compAddBill.getDecSpecialVat().getBigDecimalValue(),
	                					compAddBill.getTxtTotalAmount().getBigDecimalValue(),type);
			
   //	      Update Inventory Transactions
			 Iterator it2 = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while(it2.hasNext()){
				blUpdateCons.deleteObject(it2.next());
									
			}
			compAddBill.saveConsignmentRows(cons.getConsignmentsId());
			
			}
			//update bill now...        
	       
	       
	        
	    
	    msg = new MessageBox(this.getParent(),SWT.ICON_INFORMATION);
	    msg.setMessage("Ba?ar?yla Güncellendi!");
	    msg.open();
	    this.dialogShell.close();
	    
	    }
	}
	catch(Exception ex){
	    msg = new MessageBox(this.getParent(),SWT.ICON_ERROR);
	    
		ex.printStackTrace();
	    msg.setMessage(ex.getMessage());
	    msg.open();
	    this.dialogShell.close();
	}
 }
	
}
