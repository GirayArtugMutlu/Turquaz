package com.turquaz.cash.ui;

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
 * @author  Onsel
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.cash.ui.comp.CashCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.SWT;


public class CashUICashOtherCollectTransaction extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lblCashCard;
	private Text txtDefinition;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private DatePicker datePicker;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CurrencyText curTextTotalAmount;
	private CLabel lblTotalAmount;
	private AccountPickerLeaf txtAccountingAccount;
	private CLabel lblCurrentCard;
	private CashCardPicker txtCashCard;

	public CashUICashOtherCollectTransaction(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(540, 265);
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
			}
			{
				txtDocumentNo = new Text(this, SWT.NONE);
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNo.setSize(150, 19);
				txtDocumentNoLData.widthHint = 150;
				txtDocumentNoLData.heightHint = 17;
				txtDocumentNo.setLayoutData(txtDocumentNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText(EngLangCommonKeys.STR_DATE);
			}
			{
				datePicker = new DatePicker(this, SWT.NONE);
				GridData datePickerLData = new GridData();
				datePickerLData.widthHint = 152;
				datePickerLData.heightHint = 23;
				datePicker.setLayoutData(datePickerLData);
			}
			{
				lblCashCard = new CLabel(this, SWT.NONE);
				lblCashCard.setText(CashLangKeys.STR_CASH_CARD);
			}
			{
				txtCashCard = new CashCardPicker(this, SWT.NONE);
				GridData txtCashCardLData = new GridData();
				txtCashCardLData.widthHint = 150;
				txtCashCardLData.heightHint = 17;
				txtCashCard.setLayoutData(txtCashCardLData);
			}
			{
				lblCurrentCard = new CLabel(this, SWT.NONE);
				lblCurrentCard.setText(AccLangKeys.STR_COUNTER_ACCOUNTING_ACCOUNT);
			}
			{
				txtAccountingAccount = new AccountPickerLeaf(this, SWT.NONE);
				GridData txtCurrentAccountLData = new GridData();
				txtCurrentAccountLData.widthHint = 150;
				txtCurrentAccountLData.heightHint = 17;
				txtAccountingAccount.setLayoutData(txtCurrentAccountLData);
			}
			{
				lblTotalAmount = new CLabel(this, SWT.NONE);
				lblTotalAmount.setText(EngLangCommonKeys.STR_TOTALPRICE);
				GridData lblTotalAmountLData = new GridData();
				lblTotalAmountLData.widthHint = 42;
				lblTotalAmountLData.heightHint = 19;
				lblTotalAmount.setLayoutData(lblTotalAmountLData);
			}
			{
				curTextTotalAmount = new CurrencyText(this, SWT.NONE);
				GridData curTextTotalAmountLData = new GridData();
				curTextTotalAmountLData.widthHint = 145;
				curTextTotalAmountLData.heightHint = 17;
				curTextTotalAmount.setLayoutData(curTextTotalAmountLData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(EngLangCommonKeys.STR_CURRENCY);
			//END << lblCurrency
			//START >> comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 130;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END << comboCurrencyType
			{
				lblDefinition = new CLabel(this, SWT.NONE);
				lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 367;
				txtDefinitionLData.heightHint = 50;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGUI()
	{
		fillCurrencyCombo();
	}

	public void fillCurrencyCombo()
	{
		try
		{
			HashBag currencyBag = (HashBag)EngTXCommon.doSelectTX(EngBLCommon.class.getName(),"getCurrencies",null);
            HashMap currencies = (HashMap)currencyBag.get(EngKeys.CURRENCIES);
            
			for (int k = 0; k < currencies.size(); k++)
			{
                HashMap currencyMap=(HashMap)currencies.get(new Integer(k));
                String abbr=(String)currencyMap.get(EngKeys.CURRENCY_ABBR);
                
				comboCurrencyType.add(abbr);
				comboCurrencyType.setData(abbr,currencyMap.get(EngKeys.CURRENCY_ID));
				if (((Boolean)currencyMap.get(EngKeys.DEFAULT)).booleanValue())
				{
					comboCurrencyType.setText((String)currencyMap.get(EngKeys.CURRENCY_ABBR));
					
				}
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
		CashUICashOtherCollectTransaction curCard = new CashUICashOtherCollectTransaction(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_ID,txtCashCard.getCashCardId());
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CASH_OTHER_COLLECT));
				argMap.put(EngKeys.ENG_SEQ,null);
				argMap.put(CashKeys.CASH_TOTAL_AMOUNT,curTextTotalAmount.getBigDecimalValue());
				argMap.put(EngKeys.DATE,datePicker.getDate());
				argMap.put(EngKeys.DEFINITION,txtDefinition.getText());
				argMap.put(EngKeys.DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(EngKeys.CURRENCY_ID, comboCurrencyType.getData(comboCurrencyType.getText().trim()));
				argMap.put(AccKeys.ACC_ACCOUNT_ID,txtAccountingAccount.getId());
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionAdd.class.getName(),"saveOtherTransaction",argMap);
				
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		try
		{
			if (txtCashCard.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(), CashLangKeys.MSG_SELECT_CASH_CARD,SWT.ICON_WARNING);
				txtCashCard.setFocus();
				return false;
			}
			else if (txtAccountingAccount.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_SELECT_ACCOUNTING_ACCOUNT,SWT.ICON_WARNING);
				txtAccountingAccount.setFocus();
				return false;
			}
			else if (curTextTotalAmount.getBigDecimalValue().equals(new BigDecimal(0)))
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_ENTER_AMOUNT,SWT.ICON_WARNING);
				curTextTotalAmount.setFocus();
				return false;
			}
			else if (comboCurrencyType.getData(comboCurrencyType.getText()) == null)
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_SELECT_CURRENCY,SWT.ICON_WARNING);
				comboCurrencyType.setFocus();
				return false;
			}
			
			return true;
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
			return false;
		}
	}

	public CurrencyText getCurTextTotalAmount()
	{
		return curTextTotalAmount;
	}

	public void setCurTextTotalAmount(CurrencyText curTextTotalAmount)
	{
		this.curTextTotalAmount = curTextTotalAmount;
	}

	public DatePicker getDatePicker()
	{
		return datePicker;
	}

	public void setDatePicker(DatePicker datePicker)
	{
		this.datePicker = datePicker;
	}

	public CashCardPicker getTxtCashCard()
	{
		return txtCashCard;
	}

	public void setTxtCashCard(CashCardPicker txtCashCard)
	{
		this.txtCashCard = txtCashCard;
	}

	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	public void setTxtDefinition(Text txtDefinition)
	{
		this.txtDefinition = txtDefinition;
	}

	public Text getTxtDocumentNo()
	{
		return txtDocumentNo;
	}

	public void setTxtDocumentNo(Text txtDocumentNo)
	{
		this.txtDocumentNo = txtDocumentNo;
	}

	/**
	 * @return Returns the txtAccountingAccount.
	 */
	public AccountPickerLeaf getTxtAccountingAccount()
	{
		return txtAccountingAccount;
	}

	/**
	 * @param txtAccountingAccount
	 *             The txtAccountingAccount to set.
	 */
	public void setTxtAccountingAccount(AccountPickerLeaf txtAccountingAccount)
	{
		this.txtAccountingAccount = txtAccountingAccount;
	}

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}


}