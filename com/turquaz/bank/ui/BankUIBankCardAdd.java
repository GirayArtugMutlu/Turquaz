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

import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrency;

import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLBankCardAdd;



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
public class BankUIBankCardAdd extends  Composite implements SecureComposite {

	/**
	 * @return Returns the comboCurrency.
	 */
	public CCombo getComboCurrency() {
		return comboCurrency;
	}
	/**
	 * @return Returns the txtBankAccountNo.
	 */
	public Text getTxtBankAccountNo() {
		return txtBankAccountNo;
	}
	/**
	 * @return Returns the txtBankBranchName.
	 */
	public Text getTxtBankBranchName() {
		return txtBankBranchName;
	}
	/**
	 * @return Returns the txtBankName.
	 */
	public Text getTxtBankName() {
		return txtBankName;
	}
	public BankUIBankCardAdd(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
    public AccountPicker getAccountPicker() {
        return accountPicker;
    }
    public void setAccountPicker(AccountPicker accountPicker) {
        this.accountPicker = accountPicker;
    }
    public Text getTxtBankCode() {
        return txtBankCode;
    }
    public void setTxtBankCode(Text txtBankCode) {
        this.txtBankCode = txtBankCode;
    }
	private BankBLBankCardAdd bankBLBankCardAdd=new BankBLBankCardAdd();
	private CLabel lblBankName;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private AccountPicker accountPicker;
	private CLabel lblAccCode;
	private CCombo comboCurrency;
	private CLabel lblCurrency;
	private Text txtBankAccountNo;
	private CLabel lvlBanckAccountNo;
	private Text txtBankBranchName;
	private CLabel lblBankBranchName;
	private Text txtBankName;
	private Text txtBankCode;
	private CLabel lblBankCode;
	private EngBLCommon engBLCom= new EngBLCommon();
	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();

			this.setSize(496, 254);


			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
            {
                lblBankCode = new CLabel(this, SWT.NONE);
                lblBankCode.setText(Messages.getString("BankUIBankCardAdd.9")); //$NON-NLS-1$
            }
            {
                txtBankCode = new Text(this, SWT.NONE);
                GridData txtBankCodeLData = new GridData();
              
                txtBankCodeLData.widthHint = 255;
                txtBankCodeLData.heightHint = 19;
                txtBankCode.setLayoutData(txtBankCodeLData);
            }
            {
                lblBankName = new CLabel(this, SWT.NONE);
                lblBankName.setText(Messages.getString("BankUIBankCardAdd.0"));//$NON-NLS-1$
                GridData lblBankNameLData = new GridData();
                lblBankName.setLayoutData(lblBankNameLData);
            }
            {
                txtBankName = new Text(this, SWT.NONE);
                txtBankName.setTextLimit(50);
                GridData txtBankNameLData = new GridData();
                txtBankNameLData.widthHint = 255;
                txtBankNameLData.heightHint = 19;
                txtBankName.setLayoutData(txtBankNameLData);
            }
            {
                lblBankBranchName = new CLabel(this, SWT.NONE);
                lblBankBranchName.setText(Messages
                    .getString("BankUIBankCardAdd.1"));//$NON-NLS-1$
                lblBankBranchName.setSize(new org.eclipse.swt.graphics.Point(
                    95,
                    19));
                GridData lblBankBranchNameLData = new GridData();
                lblBankBranchNameLData.widthHint = 95;
                lblBankBranchNameLData.heightHint = 19;
                lblBankBranchName.setLayoutData(lblBankBranchNameLData);
            }
            {
                txtBankBranchName = new Text(this, SWT.NONE);
                txtBankBranchName.setTextLimit(50);
                GridData txtBankBranchNameLData = new GridData();
                txtBankBranchNameLData.widthHint = 255;
                txtBankBranchNameLData.heightHint = 19;
                txtBankBranchName.setLayoutData(txtBankBranchNameLData);
            }
            {
                lvlBanckAccountNo = new CLabel(this, SWT.NONE);
                lvlBanckAccountNo.setText(Messages
                    .getString("BankUIBankCardAdd.2"));//$NON-NLS-1$
                GridData lvlBanckAccountNoLData = new GridData();
                lvlBanckAccountNo.setLayoutData(lvlBanckAccountNoLData);
            }
            {
                txtBankAccountNo = new Text(this, SWT.NONE);
                txtBankAccountNo.setTextLimit(50);
                GridData txtBankAccountNoLData = new GridData();
                txtBankAccountNoLData.widthHint = 255;
                txtBankAccountNoLData.heightHint = 19;
                txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
            }
            {
                lblCurrency = new CLabel(this, SWT.NONE);
                lblCurrency.setText(Messages.getString("BankUIBankCardAdd.3"));//$NON-NLS-1$
                GridData lblCurrencyLData = new GridData();
                lblCurrency.setLayoutData(lblCurrencyLData);
            }
            {
                comboCurrency = new CCombo(this, SWT.NONE);
                comboCurrency.setText(Messages
                    .getString("BankUIBankCardAdd.16"));//$NON-NLS-1$
                GridData comboCurrencyLData = new GridData();
                comboCurrencyLData.widthHint = 109;
                comboCurrencyLData.heightHint = 16;
                comboCurrency.setLayoutData(comboCurrencyLData);
            }
            {
                lblAccCode = new CLabel(this, SWT.NONE);
                lblAccCode.setText(Messages.getString("BankUIBankCardAdd.10")); //$NON-NLS-1$
            }
            {
                accountPicker = new AccountPicker(this, SWT.NONE);
                GridData accountPickerLData = new GridData();
                accountPickerLData.widthHint = 255;
                accountPickerLData.heightHint = 19;
                accountPicker.setLayoutData(accountPickerLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition
                    .setText(Messages.getString("BankUIBankCardAdd.7")); //$NON-NLS-1$
                GridData lblDefinitionLData = new GridData();
                lblDefinitionLData.widthHint = 68;
                lblDefinitionLData.heightHint = 19;
                lblDefinition.setLayoutData(lblDefinitionLData);
            }
            {
                txtDefinition = new Text(this, SWT.MULTI | SWT.V_SCROLL);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.horizontalAlignment = GridData.FILL;
                txtDefinitionLData.verticalSpan = 2;
                txtDefinitionLData.heightHint = 49;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
private boolean verifyfields()
	{
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	    if (txtBankCode.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.13"));  //$NON-NLS-1$
			msg.open();
			txtBankCode.setFocus();
			return false;
			}
		else if (txtBankName.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.6")); //$NON-NLS-1$
			msg.open();
			txtBankName.setFocus();
			return false;
			}
		else if(txtBankBranchName.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.8")); //$NON-NLS-1$
			msg.open();
			txtBankBranchName.setFocus();
			return false;
			}
		else if (txtBankAccountNo.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.5")); //$NON-NLS-1$
			msg.open();
			txtBankAccountNo.setFocus();
			return false;
			}
		else if (comboCurrency.getData(comboCurrency.getText())==null){
			msg.setMessage(Messages.getString("BankUIBankCardAdd.11")); //$NON-NLS-1$
			msg.open();
			comboCurrency.setFocus();
			return false;
			}
		else if (accountPicker.getData()==null){
			msg.setMessage(Messages.getString("BankUIBankCardAdd.14"));  //$NON-NLS-1$
			msg.open();
			accountPicker.setFocus();
			return false;
			}
		
		else
			return true;
		
	}
	
	private void clearFields()
	{
		try{
			txtBankName.setText(""); //$NON-NLS-1$
			txtBankBranchName.setText(""); //$NON-NLS-1$
			txtBankAccountNo.setText(""); //$NON-NLS-1$
			txtDefinition.setText(""); //$NON-NLS-1$
			comboCurrency.setText(Messages.getString("BankUIBankCardAdd.15")); //$NON-NLS-1$
		}
		catch(Exception ex){
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
			ex.printStackTrace();			
		}
	}
	
	private void FillCurrencyCombo() throws Exception
	{
		try{
			comboCurrency.removeAll();
			comboCurrency.setText(Messages.getString("BankUIBankCardAdd.16")); //$NON-NLS-1$
			List currencies=engBLCom.getCurrencies();
			for(int k=0; k<currencies.size(); k++){
				TurqCurrency currency=(TurqCurrency)currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(),currency);
			}
		}
		catch(Exception ex){
			throw ex;
		}
		
	
	}
	public void save()
	{
		try
		{
			if (verifyfields())
			{
				bankBLBankCardAdd.saveBankCard(txtBankName.getText().trim(),
												txtBankBranchName.getText().trim(),
													txtBankAccountNo.getText().trim(),
													(TurqCurrency)(comboCurrency.getData(comboCurrency.getText())),txtDefinition.getText().trim(),
													txtBankCode.getText().trim(),(TurqAccountingAccount)accountPicker.getData());
													
				MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
				msg.setMessage(Messages.getString("BankUIBankCardAdd.17")); //$NON-NLS-1$
				msg.open();
				clearFields();
			}
		}
		catch(Exception ex)
		{
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
			ex.printStackTrace();
		}
	}
	
	public void search(){
	    
	}
	
	public void newForm(){
	  BankUIBankCardAdd curCard = new BankUIBankCardAdd(this.getParent(),this.getStyle());
	 CTabFolder tabfld = (CTabFolder)this.getParent();
	 tabfld.getSelection().setControl(curCard);	 
	 this.dispose();
	}
	
	public void delete(){
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		try{
			FillCurrencyCombo();
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}
	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition() {
		return txtDefinition;
	}
	/**
	 * @param txtDefinition The txtDefinition to set.
	 */
	public void setTxtDefinition(Text txtDefinition) {
		this.txtDefinition = txtDefinition;
	}
}
