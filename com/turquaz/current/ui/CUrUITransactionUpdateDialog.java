package com.turquaz.current.ui;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel Armagan
* @version  $Id$
*/

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.current.ui.CurUITransactionAdd;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

import com.cloudgarden.resource.SWTResourceManager;
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
public class CUrUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	private CurUITransactionAdd compTransactionAdd;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	TurqCurrentTransaction transaction;
	private ToolItem toolCancel;
	CurBLSearchTransaction blSearch = new CurBLSearchTransaction();
	

	public CUrUITransactionUpdateDialog(Shell parent, int style,TurqCurrentTransaction trans) {
		super(parent, style);
		transaction = trans;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}


	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}

			dialogShell.setText(Messages.getString("CUrUITransactionUpdateDialog.3")); //$NON-NLS-1$
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compTransactionAdd = new CurUITransactionAdd(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(546,279));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.FILL;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = true;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText(Messages.getString("CUrUITransactionUpdateDialog.0")); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText(Messages.getString("CUrUITransactionUpdateDialog.2")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(Messages.getString("CUrUITransactionUpdateDialog.1")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogShell.close();
					}
				});
			}
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compTransactionAddLData = new GridData();
			compTransactionAddLData.verticalAlignment = GridData.FILL;
			compTransactionAddLData.horizontalAlignment = GridData.FILL;
			compTransactionAddLData.widthHint = -1;
			compTransactionAddLData.heightHint = -1;
			compTransactionAddLData.horizontalIndent = 0;
			compTransactionAddLData.horizontalSpan = 1;
			compTransactionAddLData.verticalSpan = 1;
			compTransactionAddLData.grabExcessHorizontalSpace = true;
			compTransactionAddLData.grabExcessVerticalSpace = true;
			compTransactionAdd.setLayoutData(compTransactionAddLData);
			compTransactionAdd.setSize(new org.eclipse.swt.graphics.Point(536,226));
			compTransactionAdd.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 546,279);
			dialogShell.setSize(bounds.width, bounds.height);
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
/** Add your post-init code in here 	*/
	public void postInitGUI(){
	try{
	    
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		    
		if(EngBLPermissions.getPermission(compTransactionAdd.getClass().getName())==2){
		    toolUpdate.setEnabled(true); 
		}
		else if(EngBLPermissions.getPermission(compTransactionAdd.getClass().getName())==3){
		    toolDelete.setEnabled(true);
		    toolUpdate.setEnabled(true); 
		}    
	    
	// if it is not cash trasaction 
	//close 
	if(transaction.getTurqCurrentTransactionType().getCurrentTransactionTypesId().intValue()!=4){
	dialogShell.close();
	return;
	}
	
	AccBLTransactionSearch blAccTransSearch = new AccBLTransactionSearch();
	
	//else fill the composite
	
	compTransactionAdd.getTxtDocumentNo().setText(transaction.getTransactionsDocumentNo());
	compTransactionAdd.getTxtCurrentCode().setText(transaction.getTurqCurrentCard().getCardsCurrentCode());
	compTransactionAdd.getDateTransDate().setDate(transaction.getTransactionsDate());
	
	/*TurqAccountingTransaction accTrans = transaction.getTurqAccountingTransaction();
	
	boolean isCredit = false;
	//Tediye fisi
	if(transaction.getTransactionsTotalCredit().compareTo(transaction.getTransactionsTotalDept())==1){
	
	compTransactionAdd.getComboTransType().setText(Messages.getString("CUrUITransactionUpdateDialog.4")); //$NON-NLS-1$
	compTransactionAdd.getDecTxtAmount().setText(transaction.getTransactionsTotalCredit().toString());
    isCredit =true;
	
    
	}
	
	//Tahsil fisi
	else{
	isCredit = false;	
	compTransactionAdd.getComboTransType().setText(Messages.getString("CUrUITransactionUpdateDialog.5")); //$NON-NLS-1$
	compTransactionAdd.getDecTxtAmount().setText(transaction.getTransactionsTotalDept().toString());
	
	}
	
	List list = blAccTransSearch.searchTransactionRows(accTrans,isCredit);
    //get transaction row for cash account
	if(list.size()>0){
	
     TurqAccountingTransactionColumn transRow = (TurqAccountingTransactionColumn)list.get(0);
     compTransactionAdd.getAccPickerCashAccount().setData(transRow.getTurqAccountingAccount());
     
		
	}
	

	
	*/
	}
	
	catch(Exception ex){
		ex.printStackTrace();
	}
	}
	
	/** Auto-generated event handler method */
	protected void toolUpdateWidgetDefaultSelected(SelectionEvent evt){
	
		
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
	try
	{
		
			if(compTransactionAdd.verifyFields()){
			boolean isCredit =false;
			if(compTransactionAdd.getComboTransType().getText().equals(Messages.getString("CUrUITransactionUpdateDialog.5"))){ //$NON-NLS-1$
				isCredit =false;
			}
			else if(compTransactionAdd.getComboTransType().getText().equals(Messages.getString("CUrUITransactionUpdateDialog.4"))){ //$NON-NLS-1$
				isCredit =true;
			
			}
			
			
			blSearch.updateCurrentTransaction((TurqCurrentCard)compTransactionAdd.getTxtCurrentCode().getData(compTransactionAdd.getTxtCurrentCode().getText()),
											  compTransactionAdd.getDateTransDate().getDate(),
											  compTransactionAdd.getTxtDocumentNo().getText(),
											  isCredit,
											  compTransactionAdd.getDecTxtAmount().getBigDecimalValue(),
											  (TurqAccountingAccount)compTransactionAdd.getAccPickerCashAccount().getData(),
											  	transaction);
			 msg.setMessage(Messages.getString("CUrUITransactionUpdateDialog.10")); //$NON-NLS-1$
			 msg.open();	
			 this.dialogShell.close();
		}
		
		
	}
	catch(Exception ex){
			
	}
	
		
		
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
	MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
	try{
	
	 blSearch.deleteCurrentTransaction(transaction);
	
	 msg.setMessage(Messages.getString("CUrUITransactionUpdateDialog.11")); //$NON-NLS-1$
	 msg.open();
	 this.dialogShell.close();
	}
	catch(Exception ex){
	ex.printStackTrace();
		 msg.setMessage(ex.getMessage());
		 msg.open();
	}	
		
		
	
	}
}
