package com.turquaz.consignment.ui;


import java.util.Iterator;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqConsignment;

import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.ui.InvUITransactionTableRow;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class ConUIConsignmentUpdateDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ConUIAddConsignment compAddConsignment;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	TurqConsignment consignment;
	ConBLUpdateConsignment blCons = new ConBLUpdateConsignment();


	public ConUIConsignmentUpdateDialog(Shell parent, int style, TurqConsignment cons) {
		super(parent, style);
		consignment = cons;
	}

	public void open() {
		try {
		    preInitGUI();
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
				dialogShell.setSize(663, 593);
			
			 {
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 44));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 44));
					coolItem1.setSize(45, 44);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText(Messages.getString("ConUIConsignmentUpdateDialog.0")); //$NON-NLS-1$
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
							toolUpdate
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									update();
								}
								});
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText(Messages.getString("ConUIConsignmentUpdateDialog.2")); //$NON-NLS-1$
							toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
							toolDelete
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									delete();
								}
								});
						}
						{
							toolCancel = new ToolItem(toolBar1, SWT.NONE);
							toolCancel.setText(Messages.getString("ConUIConsignmentUpdateDialog.1")); //$NON-NLS-1$
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
				compAddConsignment = new ConUIAddConsignment(dialogShell, SWT.NONE);
				GridData compAddConsignmentLData = new GridData();
				compAddConsignmentLData.grabExcessHorizontalSpace = true;
				compAddConsignmentLData.horizontalAlignment = GridData.FILL;
				compAddConsignmentLData.verticalAlignment = GridData.FILL;
				compAddConsignmentLData.grabExcessVerticalSpace = true;
				compAddConsignment.setLayoutData(compAddConsignmentLData);
	            
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
	
	public void preInitGUI(){
	    
	    
	}
	
	
	public void postInitGui(){
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		    
		if(EngBLPermissions.getPermission(compAddConsignment.getClass().getName())==2){
		    toolUpdate.setEnabled(true); 
		}
		else if(EngBLPermissions.getPermission(compAddConsignment.getClass().getName())==3){
		    toolDelete.setEnabled(true);
		    toolUpdate.setEnabled(true); 
		}
	    
	    
	    
		compAddConsignment.getTxtCurrentCard().setData(consignment.getTurqBillConsignmentCommon().getTurqCurrentCard());
		compAddConsignment.getTxtCurrentCard().setText(consignment.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsCurrentCode());
		compAddConsignment.getTxtBillDocumentNo().setText(consignment.getTurqBillConsignmentCommon().getBillDocumentNo());
		compAddConsignment.getDateConsignmentDate().setDate(consignment.getConsignmentsDate());
		compAddConsignment.getTxtDocumentNo().setText(consignment.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
		if(consignment.getConsignmentsType()==0){
		compAddConsignment.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.5")); //$NON-NLS-1$
		}
		else{
	    compAddConsignment.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.6")); //$NON-NLS-1$
		}
	
		compAddConsignment.getTxtDefinition().setText(consignment.getConsignmentsDefinition());
	
		fillInvTransactionColumns();
		fillRegisteredGroup();
	}
	public void fillRegisteredGroup(){
	
		TurqConsignmentsInGroup group;
		Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
		while(it.hasNext()){
			group = (TurqConsignmentsInGroup)it.next();
			compAddConsignment.getCompRegisterGroup().RegisterGroup(group.getTurqConsignmentGroup());
			
			
		}
		
	
	}


	public void fillInvTransactionColumns(){
		compAddConsignment.rowList.removeAll();
		
		TableItem item;
		TurqInventoryTransaction invTrans;
		Iterator it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
		while(it.hasNext()){
			invTrans = (TurqInventoryTransaction)it.next();
			
			InvUITransactionTableRow row = new InvUITransactionTableRow(compAddConsignment.rowList,consignment.getConsignmentsType(),compAddConsignment.tableViewer);
            row.setDBObject(invTrans);
			compAddConsignment.rowList.addTask(row);
			
            
			
			
		}
		 InvUITransactionTableRow row2 = new InvUITransactionTableRow(compAddConsignment.rowList,consignment.getConsignmentsType(),compAddConsignment.tableViewer);
		 compAddConsignment.rowList.addTask(row2);
		compAddConsignment.calculateTotals();
		
	}
	public void delete(){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.CANCEL|SWT.OK);
		msg2.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.9")); //$NON-NLS-1$
		try{
			if(msg2.open()==SWT.OK){
				
			    
				//delete Consignment Group
				Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
				while(it.hasNext()){
					blCons.deleteObject(it.next());
										
				}
				
//				delete Inventory Transaction
				it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
				while(it.hasNext()){
					blCons.deleteObject(it.next());
										
				}
				
				Object o = consignment.getTurqBillConsignmentCommon();
			
				blCons.deleteObject(consignment);
				blCons.deleteObject(o);
				
				msg.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.10")); //$NON-NLS-1$
				msg.open();
				
				dialogShell.close();			
				
				//delete consignment 
				
			}
			
			
			
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
	}
	
	public void updateGroups()throws Exception{
	try{
	    Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
	    
	    while(it.hasNext()){
	        blCons.deleteObject(it.next());
	    }
	    
	    compAddConsignment.saveGroups(consignment.getConsignmentsId());
	    
	     
	    
	}
	catch(Exception ex){
	  throw ex;
	    
	}
	
	
	}
	
	public void update(){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		try{
		
			//Update its groups
			Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
			while(it.hasNext()){
				blCons.deleteObject(it.next());
									
			}
			compAddConsignment.saveGroups(consignment.getConsignmentsId());
		  
			//Update Inventory Transactions
			it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while(it.hasNext()){
				blCons.deleteObject(it.next());
									
			}
			compAddConsignment.saveConsignmentRows(consignment.getConsignmentsId());
			
			//Now we can update consignment
		 int type = 0;
		 if(compAddConsignment.getComboConsignmentType().getText().equals(Messages.getString("ConUIConsignmentUpdateDialog.11"))) //$NON-NLS-1$
                type =1;
		 	

			updateGroups();
			
			blCons.updateConsignment(consignment,
									compAddConsignment.getTxtDocumentNo().getText(),
									compAddConsignment.getTxtDefinition().getText(),
									compAddConsignment.getDateConsignmentDate().getDate(),
									(TurqCurrentCard)compAddConsignment.getTxtCurrentCard().getData(),
							
									compAddConsignment.getTxtDiscountAmount().getBigDecimalValue(),
									compAddConsignment.getTxtBillDocumentNo().getText(),
									compAddConsignment.getTxtTotalVat().getBigDecimalValue(),
									compAddConsignment.getDecSpecialVat().getBigDecimalValue(),
									compAddConsignment.getTxtTotalAmount().getBigDecimalValue(),
									type);
			
			
			
			msg.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.12")); //$NON-NLS-1$
			msg.open();
			dialogShell.close();
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
	}
	
	
}
