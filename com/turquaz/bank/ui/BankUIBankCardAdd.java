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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabItem;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLBankCardAdd;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIBankCardAdd extends Composite implements SecureComposite
{
	/**
	 * @return Returns the comboCurrency.
	 */
	public CCombo getComboCurrency()
	{
		return comboCurrency;
	}

	/**
	 * @return Returns the txtBankAccountNo.
	 */
	public Text getTxtBankAccountNo()
	{
		return txtBankAccountNo;
	}

	/**
	 * @return Returns the txtBankBranchName.
	 */
	public Text getTxtBankBranchName()
	{
		return txtBankBranchName;
	}

	/**
	 * @return Returns the txtBankName.
	 */
	public Text getTxtBankName()
	{
		return txtBankName;
	}

	public BankUIBankCardAdd(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	public AccountPickerLeaf getAccountPicker()
	{
		return accountPicker;
	}

	public Text getTxtBankCode()
	{
		return txtBankCode;
	}
	private BankBLBankCardAdd bankBLBankCardAdd = new BankBLBankCardAdd();
	private CLabel lblBankName;
	private Text txtDefinition;
	private CLabel lblChequesCollect;
	private AccountPickerLeaf accountPickerChequesCollect;
	private AccountPickerLeaf accountPickerChequesGiven;
	private CLabel lblChequesGiven;
	private Composite composite;
	private CTabItem tabAccountingAccounts;
	private Composite compGeneralInfo;
	private CTabItem tabGeneralInfo;
	private CTabFolder cTabFolder1;
	private CLabel lblDefinition;
	private AccountPickerLeaf accountPicker;
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

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(634, 380);
			GridLayout thisLayout = new GridLayout();
			this.setEnabled(false);
			this.setLayout(thisLayout);
			//START >> cTabFolder1
			cTabFolder1 = new CTabFolder(this, SWT.NONE);
			//START >> tabGeneralInfo
			tabGeneralInfo = new CTabItem(cTabFolder1, SWT.NONE);
			tabGeneralInfo.setText("Genel Bilgiler");
			//START >> compGeneralInfo
			compGeneralInfo = new Composite(cTabFolder1, SWT.NONE);
			GridLayout compGeneralInfoLayout = new GridLayout();
			compGeneralInfoLayout.numColumns = 2;
			compGeneralInfo.setLayout(compGeneralInfoLayout);
			tabGeneralInfo.setControl(compGeneralInfo);
			{
				lblBankCode = new CLabel(compGeneralInfo, SWT.NONE);
				lblBankCode.setText(Messages.getString("BankUIBankCardAdd.9")); //$NON-NLS-1$
			}
			{
				txtBankCode = new Text(compGeneralInfo, SWT.NONE);
				GridData txtBankCodeLData = new GridData();
				txtBankCodeLData.widthHint = 255;
				txtBankCodeLData.heightHint = 17;
				txtBankCode.setLayoutData(txtBankCodeLData);
			}
			{
				lblBankName = new CLabel(compGeneralInfo, SWT.NONE);
				lblBankName.setText(Messages.getString("BankUIBankCardAdd.0"));//$NON-NLS-1$
				GridData lblBankNameLData = new GridData();
				lblBankName.setLayoutData(lblBankNameLData);
			}
			{
				txtBankName = new Text(compGeneralInfo, SWT.NONE);
				txtBankName.setTextLimit(50);
				GridData txtBankNameLData = new GridData();
				txtBankNameLData.widthHint = 255;
				txtBankNameLData.heightHint = 17;
				txtBankName.setLayoutData(txtBankNameLData);
			}
			{
				lblBankBranchName = new CLabel(compGeneralInfo, SWT.NONE);
				lblBankBranchName.setText(Messages.getString("BankUIBankCardAdd.1"));//$NON-NLS-1$
				lblBankBranchName.setSize(new org.eclipse.swt.graphics.Point(95, 19));
				GridData lblBankBranchNameLData = new GridData();
				lblBankBranchNameLData.widthHint = 95;
				lblBankBranchNameLData.heightHint = 19;
				lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			}
			{
				txtBankBranchName = new Text(compGeneralInfo, SWT.NONE);
				txtBankBranchName.setTextLimit(50);
				GridData txtBankBranchNameLData = new GridData();
				txtBankBranchNameLData.widthHint = 255;
				txtBankBranchNameLData.heightHint = 17;
				txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			}
			{
				lvlBanckAccountNo = new CLabel(compGeneralInfo, SWT.NONE);
				lvlBanckAccountNo.setText(Messages.getString("BankUIBankCardAdd.2"));//$NON-NLS-1$
				GridData lvlBanckAccountNoLData = new GridData();
				lvlBanckAccountNo.setLayoutData(lvlBanckAccountNoLData);
			}
			{
				txtBankAccountNo = new Text(compGeneralInfo, SWT.NONE);
				txtBankAccountNo.setTextLimit(50);
				GridData txtBankAccountNoLData = new GridData();
				txtBankAccountNoLData.widthHint = 255;
				txtBankAccountNoLData.heightHint = 17;
				txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
			}
			{
				lblDefinition = new CLabel(compGeneralInfo, SWT.NONE);
				lblDefinition.setText(Messages.getString("BankUIBankCardAdd.7")); //$NON-NLS-1$
				GridData lblDefinitionLData = new GridData();
				lblDefinitionLData.widthHint = 68;
				lblDefinitionLData.heightHint = 19;
				lblDefinitionLData.verticalSpan = 2;
				lblDefinition.setLayoutData(lblDefinitionLData);
			}
			{
				txtDefinition = new Text(compGeneralInfo, SWT.MULTI | SWT.V_SCROLL);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.horizontalAlignment = GridData.FILL;
				txtDefinitionLData.verticalSpan = 2;
				txtDefinitionLData.heightHint = 49;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			{
				lblCurrency = new CLabel(compGeneralInfo, SWT.NONE);
				lblCurrency.setText(Messages.getString("BankUIBankCardAdd.3"));//$NON-NLS-1$
				GridData lblCurrencyLData = new GridData();
				lblCurrency.setLayoutData(lblCurrencyLData);
			}
			{
				comboCurrency = new CCombo(compGeneralInfo, SWT.NONE);
				comboCurrency.setText(Messages.getString("BankUIBankCardAdd.16"));//$NON-NLS-1$
				GridData comboCurrencyLData = new GridData();
				comboCurrencyLData.widthHint = 135;
				comboCurrencyLData.heightHint = 17;
				comboCurrency.setLayoutData(comboCurrencyLData);
			}
			//END << compGeneralInfo
			GridData cTabFolder1LData = new GridData();
			cTabFolder1LData.horizontalAlignment = GridData.FILL;
			cTabFolder1LData.grabExcessHorizontalSpace = true;
			cTabFolder1LData.grabExcessVerticalSpace = true;
			cTabFolder1LData.verticalAlignment = GridData.FILL;
			cTabFolder1.setLayoutData(cTabFolder1LData);
			//END << tabGeneralInfo
			//START >> tabAccountingAccounts
			tabAccountingAccounts = new CTabItem(cTabFolder1, SWT.NONE);
			tabAccountingAccounts.setText("Muhasebe Hesaplar\u0131");
			//START >> composite
			composite = new Composite(cTabFolder1, SWT.NONE);
			tabAccountingAccounts.setControl(composite);
			GridLayout compositeLayout = new GridLayout();
			compositeLayout.numColumns = 2;
			composite.setLayout(compositeLayout);
			{
				lblAccCode = new CLabel(composite, SWT.NONE);
				lblAccCode.setText(Messages.getString("BankUIBankCardAdd.10")); //$NON-NLS-1$
			}
			{
				accountPicker = new AccountPickerLeaf(composite, SWT.NONE);
				GridData accountPickerLData = new GridData();
				accountPickerLData.widthHint = 255;
				accountPickerLData.heightHint = 17;
				accountPicker.setLayoutData(accountPickerLData);
			}
			//START >> lblChequesGiven
			lblChequesGiven = new CLabel(composite, SWT.NONE);
			lblChequesGiven.setText("Verilen Çekler Hesab\u0131");
			//END << lblChequesGiven
			//START >> accountPickerChequesGiven
			accountPickerChequesGiven = new AccountPickerLeaf(composite, SWT.NONE);
			GridData accountPickerChequesGivenLData = new GridData();
			accountPickerChequesGivenLData.widthHint = 255;
			accountPickerChequesGivenLData.heightHint = 17;
			accountPickerChequesGiven.setLayoutData(accountPickerChequesGivenLData);
			//END << accountPickerChequesGiven
			//START >> lblChequesCollect
			lblChequesCollect = new CLabel(composite, SWT.NONE);
			lblChequesCollect.setText("Tahsildeki Çekler Hesab\u0131");
			//END << lblChequesCollect
			//START >> accountPickerChequesCollect
			accountPickerChequesCollect = new AccountPickerLeaf(composite, SWT.NONE);
			GridData accountPickerChequesCollectLData = new GridData();
			accountPickerChequesCollectLData.widthHint = 253;
			accountPickerChequesCollectLData.heightHint = 17;
			accountPickerChequesCollect.setLayoutData(accountPickerChequesCollectLData);
			//END << accountPickerChequesCollect
			//END << composite
			cTabFolder1.setSelection(0);
			//END << tabAccountingAccounts
			//END << cTabFolder1
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private boolean verifyfields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (txtBankCode.getText().trim().equals("")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.13")); //$NON-NLS-1$
			msg.open();
			txtBankCode.setFocus();
			return false;
		}
		else if (txtBankName.getText().trim().equals("")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.6")); //$NON-NLS-1$
			msg.open();
			txtBankName.setFocus();
			return false;
		}
		else if (txtBankBranchName.getText().trim().equals("")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.8")); //$NON-NLS-1$
			msg.open();
			txtBankBranchName.setFocus();
			return false;
		}
		else if (txtBankAccountNo.getText().trim().equals("")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("BankUIBankCardAdd.5")); //$NON-NLS-1$
			msg.open();
			txtBankAccountNo.setFocus();
			return false;
		}
		else if (comboCurrency.getData(comboCurrency.getText()) == null)
		{
			msg.setMessage(Messages.getString("BankUIBankCardAdd.11")); //$NON-NLS-1$
			msg.open();
			comboCurrency.setFocus();
			return false;
		}
		else if (accountPicker.getData() == null)
		{
			msg.setMessage(Messages.getString("BankUIBankCardAdd.14")); //$NON-NLS-1$
			msg.open();
			accountPicker.setFocus();
			return false;
		}
		else
			return true;
	}

	private void FillCurrencyCombo() throws Exception
	{
		try
		{
			comboCurrency.removeAll();
			comboCurrency.setText(Messages.getString("BankUIBankCardAdd.16")); //$NON-NLS-1$
			List currencies = (List) EngTXCommon.doSelectTX(EngBLCommon.class.getName(),"getCurrencies",null);
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(), currency);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public Map getAccountingFields()
	{
		Map map = new Hashtable();
		map.put(EngBLCommon.BANK_ACC_TYPE_GENERAL, accountPicker);
		map.put(EngBLCommon.BANK_ACC_TYPE_CHEQUES_GIVEN, accountPickerChequesGiven);
		map.put(EngBLCommon.BANK_ACC_TYPE_CHEQUES_COLLECT, accountPickerChequesCollect);
		return map;
	}

	public Map createAccountingMap()
	{
		Map fieldMap = getAccountingFields();
		Map map = new Hashtable();
		Iterator it = fieldMap.keySet().iterator();
		while (it.hasNext())
		{
			Integer type = (Integer) it.next();
			AccountPickerLeaf picker = (AccountPickerLeaf) fieldMap.get(type);
			if (picker.getTurqAccountingAccount() != null)
			{
				map.put(type, picker.getTurqAccountingAccount());
			}
		}
		return map;
	}

	public void save()
	{
		try
		{
			if (verifyfields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(BankKeys.BANK_NAME,txtBankName.getText().trim());
				argMap.put(BankKeys.BANK_BRANCH_NAME,txtBankBranchName.getText().trim());
				argMap.put(BankKeys.BANK_ACCOUNT_NO,txtBankAccountNo.getText().trim());
				argMap.put(BankKeys.BANK_CURRENCY,comboCurrency.getData(comboCurrency.getText()));
				argMap.put(BankKeys.BANK_DEFINITION,txtDefinition.getText().trim());
				argMap.put(BankKeys.BANK_CODE,txtBankCode.getText().trim());
				argMap.put(BankKeys.BANK_ACCOUNTING_ACCOUNTS,createAccountingMap());
				
				EngTXCommon.doTransactionTX(BankBLBankCardAdd.class.getName(),"saveBankCard",argMap);
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("BankUIBankCardAdd.17")); //$NON-NLS-1$
				msg.open();
				newForm();
				
			}
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void search()
	{
	}

	public void newForm()
	{
		BankUIBankCardAdd curCard = new BankUIBankCardAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void delete()
	{
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			FillCurrencyCombo();
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition()
	{
		return txtDefinition;
	}
}