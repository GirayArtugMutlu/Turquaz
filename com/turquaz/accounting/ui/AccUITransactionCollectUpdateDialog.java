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

import org.eclipse.swt.graphics.Rectangle;
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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;

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
public class AccUITransactionCollectUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	private AccUITransactionCollect compTransactionCollect;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	private TurqAccountingTransaction accTrans;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();

	public AccUITransactionCollectUpdateDialog(Shell parent, int style,TurqAccountingTransaction trans) {
		super(parent, style);
			this.accTrans =trans;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }

			dialogShell.setText(getText());
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compTransactionCollect = new AccUITransactionCollect(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(574,434));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
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
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText(Messages.getString("AccUITransactionCollectUpdateDialog.0")); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText(Messages.getString("AccUITransactionCollectUpdateDialog.2")); //$NON-NLS-1$
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compTransactionCollectLData = new GridData();
			compTransactionCollectLData.verticalAlignment = GridData.FILL;
			compTransactionCollectLData.horizontalAlignment = GridData.FILL;
			compTransactionCollectLData.widthHint = -1;
			compTransactionCollectLData.heightHint = -1;
			compTransactionCollectLData.horizontalIndent = 0;
			compTransactionCollectLData.horizontalSpan = 1;
			compTransactionCollectLData.verticalSpan = 1;
			compTransactionCollectLData.grabExcessHorizontalSpace = true;
			compTransactionCollectLData.grabExcessVerticalSpace = true;
			compTransactionCollect.setLayoutData(compTransactionCollectLData);
			compTransactionCollect.layout();
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
					toolDeleteýmage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 574,434);
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
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	compTransactionCollect.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
	Date date = new Date(accTrans.getTransactionsDate().getTime());
	compTransactionCollect.getDatePickerTransactionDate().setDate(date);
		
	fillTableAndCombo();
		Integer trModule=accTrans.getTurqModule().getModulesId();
	if (trModule.intValue()!=1){ //1=Transaction, only view is allowed for other modules..
		compTransactionCollect.setEnabled(false);
	}
	
	}
	public void fillTableAndCombo(){
	Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
	
	Iterator it = transactionRows.iterator();
	TurqAccountingTransactionColumn transRow;
	TableItem item;
	while(it.hasNext()){
	
	transRow =(TurqAccountingTransactionColumn)it.next();
	
	if(!transRow.getCreditAmount().toString().equals("0")){ //$NON-NLS-1$
	item = new TableItem(compTransactionCollect.getTableTransactionRows(),SWT.NULL);
	item.setData(transRow);
	item.setText(new String[]{transRow.getTurqAccountingAccount().getAccountCode(),
				transRow.getTurqAccountingAccount().getAccountName(),
				transRow.getCreditAmount().toString()});
	}
	else {
	compTransactionCollect.getComboDeptor().setText(transRow.getTurqAccountingAccount().getAccountCode()+" "+transRow.getTurqAccountingAccount().getAccountName()); //$NON-NLS-1$
	}
					
	}
	
	
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		try{
		  if(compTransactionCollect.verifyFields()){
		 blTransUpdate.updateTransaction(accTrans,compTransactionCollect.getTxtDocumentNo().getText().trim(),
										compTransactionCollect.getDatePickerTransactionDate().getData());
		 updateTransactionRows();
		 msg.setMessage(Messages.getString("AccUITransactionCollectUpdateDialog.6")); //$NON-NLS-1$
		 msg.open();
		 }
			
		}
		catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage(Messages.getString("AccUITransactionCollectUpdateDialog.7")); //$NON-NLS-1$
		 msg.open();
		}
		
		
		
	}
	 public void updateTransactionRows()throws Exception {
	    try{
	   
	   
	     deleteTransactionRows();
	     
	     compTransactionCollect.saveTransactionRows(accTrans.getAccountingTransactionsId());
	     
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
		msg2.setMessage(Messages.getString("AccUITransactionCollectUpdateDialog.8")); //$NON-NLS-1$
		int answer = msg2.open();
		if(answer ==SWT.YES){
		try{
		
		deleteTransactionRows();
		blTransUpdate.delete(accTrans);
		msg.setMessage(Messages.getString("AccUITransactionCollectUpdateDialog.9")); //$NON-NLS-1$
		msg.open();	
		this.dialogShell.dispose();	
		
		}
		catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage(Messages.getString("AccUITransactionCollectUpdateDialog.10")); //$NON-NLS-1$
		msg.open();	
		
		}
		}
	}
}
