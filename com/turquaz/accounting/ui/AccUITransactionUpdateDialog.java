package com.turquaz.accounting.ui;
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

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.viewers.ITableRow;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class AccUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	private AccUITransactionAdd compTransactionAdd;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();
	private boolean updated=false;

    private TurqAccountingTransaction accTrans;
	public AccUITransactionUpdateDialog(Shell parent, int style,TurqAccountingTransaction trans) {
		super(parent, style);
	    this.accTrans =trans;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public boolean open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }

			dialogShell.setText(Messages.getString("AccUITransactionUpdateDialog.9")); //$NON-NLS-1$
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);

			dialogShell.setSize(666, 425);
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.heightHint = 44;
			coolBar1.setLayoutData(coolBar1LData);
            {
                coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                coolItem1.setSize(45, 51);
                coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(
                    45,
                    51));
                coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(
                    45,
                    51));
                {
                    toolBar1 = new ToolBar(coolBar1, SWT.NONE);
                    coolItem1.setControl(toolBar1);
                }
            }
            {
                compTransactionAdd = new AccUITransactionAdd(
                    dialogShell,
                    SWT.NONE);
                GridData compTransactionAddLData = new GridData();
                compTransactionAddLData.verticalAlignment = GridData.FILL;
                compTransactionAddLData.horizontalAlignment = GridData.FILL;
                compTransactionAddLData.grabExcessHorizontalSpace = true;
                compTransactionAddLData.grabExcessVerticalSpace = true;
                compTransactionAdd.setLayoutData(compTransactionAddLData);
                compTransactionAdd.setSize(new org.eclipse.swt.graphics.Point(
                    567,
                    389));
                compTransactionAdd.getTxtDocumentNo().setBounds(80, 5, 150, 17);
                compTransactionAdd.layout();
            }

            {
                toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                toolUpdate.setText(Messages
                    .getString("AccUITransactionUpdateDialog.0")); //$NON-NLS-1$
                toolUpdate.setImage(SWTResourceManager
                    .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                toolUpdate.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        toolUpdateWidgetSelected(evt);
                    }
                });

            }
            {
                toolDelete = new ToolItem(toolBar1, SWT.NONE);
                toolDelete.setText(Messages
                    .getString("AccUITransactionUpdateDialog.1")); //$NON-NLS-1$
                toolDelete.setImage(SWTResourceManager
                    .getImage("icons/Delete16.gif")); //$NON-NLS-1$
                toolDelete.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        toolDeleteWidgetSelected(evt);
                    }
                });
            }
			{
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(Messages.getString("AccUITransactionUpdateDialog.8")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogShell.close();
					}
				});
			}
			{
				toolPrint = new ToolItem(toolBar1, SWT.NONE);
				toolPrint.setText(Messages.getString("AccUITransactionUpdateDialog.6")); //$NON-NLS-1$
				toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
				toolPrint.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						
						dialogShell.close();
						EngBLUtils.PrintTransaction(accTrans);
				

					}
				});
			}

			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
public void showDialog(TurqAccountingTransaction accTrans){
	
	
	
	
	

	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		    
		if(EngBLPermissions.getPermission(compTransactionAdd.getClass().getName())==2){
		    toolUpdate.setEnabled(true); 
		}
		else if(EngBLPermissions.getPermission(compTransactionAdd.getClass().getName())==3){
		    toolDelete.setEnabled(true);
		    toolUpdate.setEnabled(true); 
		}  
		/*Check if it has a journal entry*/
		if(accTrans.getTurqAccountingJournal().getAccountingJournalId().intValue()!=-1){
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);		    
		}
	try{
		blTransUpdate.initiliazeTransactionRows(accTrans);
	/* Check if it is entered from accountingmodule
	 * 
	 */
		//1- Muhasebe Modulu
		if(accTrans.getTurqModule().getModulesId().intValue()!=1){
		    toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);	
		    
		}
	    
	    
	    
	compTransactionAdd.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
	compTransactionAdd.getTxtTransDefinition().setText(accTrans.getTransactionDescription());
	Date date = new Date(accTrans.getTransactionsDate().getTime());
	compTransactionAdd.getDateTransactionDate().setDate(date);
	fillTable();
	compTransactionAdd.calculateTotalDeptAndCredit();
	Integer trModule=accTrans.getTurqModule().getModulesId();
	if (trModule.intValue()!=1){ //1=Transaction, only view is allowed for other modules..
	}
	}
	catch(Exception ex){
	    ex.printStackTrace();
	}
	
	}
	public void fillTable(){
	
	compTransactionAdd.rowList.removeAll();
		
	Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
	
	Iterator it = transactionRows.iterator();
	TurqAccountingTransactionColumn transRow;
	TableItem item;
	while(it.hasNext()){
	transRow =(TurqAccountingTransactionColumn)it.next();
	ITableRow row = new AccUITransactionAddTableRow(compTransactionAdd.rowList);
	row.setDBObject(transRow);
	compTransactionAdd.rowList.addTask(row);
	
	
	}
	// add last empty row
	AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(compTransactionAdd.rowList);
	compTransactionAdd.rowList.addTask(row2);
	
	}
	

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		try
		{

			if(compTransactionAdd.verifyFields())
			{
				updated=true;
			 blTransUpdate.updateTransaction(accTrans,compTransactionAdd.getTxtDocumentNo().getText().trim(),
										compTransactionAdd.getDateTransactionDate().getData(),compTransactionAdd.getTxtTransDefinition().getText().trim());
			 updateTransactionRows();
			 msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.2")); //$NON-NLS-1$
			 msg.open();
			 dialogShell.close();
			}	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.3")); //$NON-NLS-1$
			 msg.open();
		}
		
		
		
	}
  public void updateTransactionRows()throws Exception {
   try{
  
    deleteTransactionRows();
    
    compTransactionAdd.saveTransactionRows(accTrans.getAccountingTransactionsId());
    }
    
    catch(Exception ex){
       throw ex;
    }
  
  }	
	
    public void deleteTransactionRows()throws Exception{
    try{
     Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
     Iterator it = transactionRows.iterator();
     TurqAccountingTransactionColumn transRow;
     while(it.hasNext()){

     	blTransUpdate.delete(it.next());
	
	}
    
     
    
    
    }
    catch(Exception ex){
    throw ex;
    
    }
        
    }
    
    
	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.YES|SWT.NO);
		msg2.setMessage(Messages.getString("AccUITransactionUpdateDialog.4")); //$NON-NLS-1$
		int answer = msg2.open();
		if(answer ==SWT.YES){
		try{
		updated=true;
		deleteTransactionRows();
		blTransUpdate.delete(accTrans);
		msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.5")); //$NON-NLS-1$
		msg.open();	
		this.dialogShell.dispose();	
		
		}
		catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.3")); //$NON-NLS-1$
		msg.open();	
		
		}
		}
	}
}
