package com.turquaz.consignment.ui;


import java.util.Iterator;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.dal.TurqConsignment;

import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;

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
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}

				dialogShell.setSize(663, 593);
			 dialogShell.setLayout(new GridLayout());
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
							toolUpdate.setText("Update");
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText("Delete");
							toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
							toolDelete
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									delete();
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
				compAddConsignment.getTableConsignmentRows().setBounds(60, 177, 557, 106);
				compAddConsignment.getTxtBillDocumentNo().setBounds(372, 79, 137, 14);
			}
			
			postInitGui();
			
			dialogShell.layout();
			dialogShell.pack();
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
		compAddConsignment.getTxtCurrentCard().setData(consignment.getTurqCurrentCard());
		compAddConsignment.getTxtCurrentCard().setText(consignment.getTurqCurrentCard().getCardsCurrentCode()+" - " +
														consignment.getTurqCurrentCard().getCardsName());
		compAddConsignment.getTxtDocumentNo().setText(consignment.getConsignmentsDocumentNo());
		compAddConsignment.getTxtBillDocumentNo().setText(consignment.getConsignmentsBillDocumentNo());
		compAddConsignment.getDateConsignmentDate().setDate(consignment.getConsignmentsDate());
		if(consignment.getConsignmentsType()==0){
		compAddConsignment.getComboConsignmentType().setText("Buy");
		}
		else{
	    compAddConsignment.getComboConsignmentType().setText("Sell");
		}
	
		compAddConsignment.getTxtDefinition().setText(consignment.getConsignmentsDefinition());
		compAddConsignment.getTxtDiscountRate().setText(consignment.getCondignmentsDiscountRate());
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
		TableItem item;
		TurqInventoryTransaction invTrans;
		Iterator it = consignment.getTurqInventoryTransactions().iterator();
		while(it.hasNext()){
			invTrans = (TurqInventoryTransaction)it.next();
			
			item = new TableItem(compAddConsignment.getTableConsignmentRows(),SWT.NULL);
			
			item.setData(invTrans);
			item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
									   invTrans.getTurqInventoryCard().getCardName(),
									   invTrans.getTransactionsAmountIn()+"",
									   invTrans.getTurqInventoryUnit().getUnitsName(),
									   invTrans.getTransactionsUnitPrice().toString(),
									   invTrans.getTransactionsTotalPrice().toString(),
									   invTrans.getTransactionsVat()+"",
									   invTrans.getTransactionsVatAmount().toString(),
									   invTrans.getTransactionsVatSpecialAmount().toString(),
									   invTrans.getTransactionsCumilativePrice().toString()});
			
		}
		compAddConsignment.calculateTotals();
		
	}
	public void delete(){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.CANCEL|SWT.OK);
		msg2.setMessage("Really Delete?");
		try{
			if(msg2.open()==SWT.OK){
				
				//delete Consignment Group
				Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
				while(it.hasNext()){
					blCons.deleteObject(it.next());
										
				}
				
//				delete Inventory Transaction
				it = consignment.getTurqInventoryTransactions().iterator();
				while(it.hasNext()){
					blCons.deleteObject(it.next());
										
				}
				
				blCons.deleteObject(consignment);
				
				msg.setMessage("Deleted Succesfully!");
				msg.open();
				
				dialogShell.close();			
				
				//delete consignment 
				
			}
			
			
			
		}
		catch(Exception ex){
			
		}
		
	}
	public void update(){
		
	}
	
	
}
