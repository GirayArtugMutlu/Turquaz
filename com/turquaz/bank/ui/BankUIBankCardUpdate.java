package com.turquaz.bank.ui;

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
* @author  Ceday
* @version  $Id$
*/


import java.util.List;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;

import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLBankCardUpdate;
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class BankUIBankCardUpdate extends org.eclipse.swt.widgets.Dialog {
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private BankUIBankCardAdd compBankCard;
	private Shell dialogShell;
	private TurqBanksCard bankCard;
	private BankBLBankCardUpdate bankBLBankCardUpdate=new BankBLBankCardUpdate();
	private EngBLCommon engBLCommon= new EngBLCommon();

	public BankUIBankCardUpdate(Shell parent, int style,TurqBanksCard bc) {
		super(parent, style);
		bankCard = bc;
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
			dialogShell.setText(getText());
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compBankCard = new BankUIBankCardAdd(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(486,208));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = false;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText(Messages.getString("BankUIBankCardUpdate.0")); //$NON-NLS-1$
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText(Messages.getString("BankUIBankCardUpdate.1")); //$NON-NLS-1$
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.setImage(toolDeleteýmage);
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compBankCardLData = new GridData();
			compBankCardLData.verticalAlignment = GridData.FILL;
			compBankCardLData.horizontalAlignment = GridData.FILL;
			compBankCardLData.widthHint = -1;
			compBankCardLData.heightHint = -1;
			compBankCardLData.horizontalIndent = 0;
			compBankCardLData.horizontalSpan = 1;
			compBankCardLData.verticalSpan = 1;
			compBankCardLData.grabExcessHorizontalSpace = true;
			compBankCardLData.grabExcessVerticalSpace = true;
			compBankCard.setLayoutData(compBankCardLData);
			compBankCard.setSize(new org.eclipse.swt.graphics.Point(476,155));
			compBankCard.layout();
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 486,208);
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
		try{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			    
			if(EngBLPermissions.getPermission(compBankCard.getClass().getName())==2){
			    toolUpdate.setEnabled(true); 
			}
			else if(EngBLPermissions.getPermission(compBankCard.getClass().getName())==3){
			    toolDelete.setEnabled(true);
			    toolUpdate.setEnabled(true); 
			}
		    
		    
			compBankCard.getTxtBankName().setText(bankCard.getBankName());
			compBankCard.getTxtBankBranchName().setText(bankCard.getBankBranchName());
			compBankCard.getTxtBankAccountNo().setText(bankCard.getBankAccountNo());
			FillCurrencyCombo();
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
			
	
	
	}
	
	private void FillCurrencyCombo() throws Exception
	{
		try{
			CCombo comboCurrency=compBankCard.getComboCurrency();
			comboCurrency.removeAll();
			List currencies=engBLCommon.getCurrencies();
			for(int k=0; k<currencies.size(); k++){
				TurqCurrency currency=(TurqCurrency)currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(),currency);
			}
			comboCurrency.setText(bankCard.getTurqCurrency().getCurrenciesAbbreviation());
		}
		catch(Exception ex){
			throw ex;
		}
		
	
	}



	/** Auto-generated event handler method */
	
	private void update(){
		try{
			bankBLBankCardUpdate.updateBankCard(compBankCard.getTxtBankName().getText(),
											compBankCard.getTxtBankBranchName().getText(),
											compBankCard.getTxtBankAccountNo().getText(),
											(TurqCurrency)(compBankCard.getComboCurrency().getData(compBankCard.getComboCurrency().getText())),
											bankCard);
		
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(Messages.getString("BankUIBankCardUpdate.3")); //$NON-NLS-1$
			msg.open();
			this.dialogShell.close();
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
		update();

	}
	
	private void delete(){
		try{
			bankBLBankCardUpdate.deleteObject(bankCard);
			this.dialogShell.close();
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
		
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
		delete();
	}
}
