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
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.cash.ui.comp.CashCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashUICashCollectTransactionAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lblCashTransType;
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
	private CurrentPicker txtCurrentAccount;
	private CLabel lblCurrentCard;
	private CashCardPicker txtCashCard;
	private TurqCurrency baseCurrency = EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate =EngBLCommon.getBaseCurrencyExchangeRate();
	private TurqCurrency exchangeCurrency = EngBLCommon.getBaseCurrency();

	public CashUICashCollectTransactionAdd(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(645, 280);
			{
				lblCashTransType = new CLabel(this, SWT.NONE);
				lblCashTransType.setText(Messages.getString("CashUICashCollectTransactionAdd.0")); //$NON-NLS-1$
				GridData lblCashTransTypeLData = new GridData();
				lblCashTransType.setFont(SWTResourceManager.getFont("Tahoma", 14, 1, false, false)); //$NON-NLS-1$
				lblCashTransTypeLData.widthHint = 166;
				lblCashTransTypeLData.heightHint = 43;
				lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
				lblCashTransTypeLData.horizontalSpan = 2;
				lblCashTransTypeLData.grabExcessHorizontalSpace = true;
				lblCashTransType.setLayoutData(lblCashTransTypeLData);
			}
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(Messages.getString("CashUICashCollectTransactionAdd.2")); //$NON-NLS-1$
			}
			{
				txtDocumentNo = new Text(this, SWT.NONE);
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNoLData.widthHint = 150;
				txtDocumentNoLData.heightHint = 17;
				txtDocumentNo.setLayoutData(txtDocumentNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText(Messages.getString("CashUICashCollectTransactionAdd.3")); //$NON-NLS-1$
			}
			{
				datePicker = new DatePicker(this, SWT.NONE);
				GridData datePickerLData = new GridData();
				datePickerLData.widthHint = 157;
				datePickerLData.heightHint = 23;
				datePicker.setLayoutData(datePickerLData);
			}
			{
				lblCashCard = new CLabel(this, SWT.NONE);
				lblCashCard.setText(Messages.getString("CashUICashCollectTransactionAdd.4")); //$NON-NLS-1$
			}
			{
				txtCashCard = new CashCardPicker(this, SWT.NONE);
				GridData txtCashCardLData = new GridData();
				txtCashCardLData.widthHint = 157;
				txtCashCardLData.heightHint = 17;
				txtCashCard.setLayoutData(txtCashCardLData);
			}
			{
				lblCurrentCard = new CLabel(this, SWT.NONE);
				lblCurrentCard.setText(Messages.getString("CashUICashCollectTransactionAdd.5")); //$NON-NLS-1$
			}
			{
				txtCurrentAccount = new CurrentPicker(this, SWT.NONE);
				GridData txtCurrentAccountLData = new GridData();
				txtCurrentAccountLData.widthHint = 157;
				txtCurrentAccountLData.heightHint = 17;
				txtCurrentAccount.setLayoutData(txtCurrentAccountLData);
			}
			{
				lblTotalAmount = new CLabel(this, SWT.NONE);
				lblTotalAmount.setText(Messages.getString("CashUICashCollectTransactionAdd.6")); //$NON-NLS-1$
				GridData lblTotalAmountLData = new GridData();
				lblTotalAmountLData.widthHint = 42;
				lblTotalAmountLData.heightHint = 19;
				lblTotalAmount.setLayoutData(lblTotalAmountLData);
			}
			{
				curTextTotalAmount = new CurrencyText(this, SWT.NONE);
				GridData curTextTotalAmountLData = new GridData();
				curTextTotalAmountLData.widthHint = 150;
				curTextTotalAmountLData.heightHint = 17;
				curTextTotalAmount.setLayoutData(curTextTotalAmountLData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(Messages.getString("CashUICashCollectTransactionAdd.11")); //$NON-NLS-1$
			//END << lblCurrency
			//START >> comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END << comboCurrencyType
			{
				lblDefinition = new CLabel(this, SWT.NONE);
				lblDefinition.setText(Messages.getString("CashUICashCollectTransactionAdd.7")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 343;
				txtDefinitionLData.heightHint = 38;
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
			List currencies = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getCurrencies",null);
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				comboCurrencyType.add(currency.getCurrenciesAbbreviation());
				comboCurrencyType.setData(currency.getCurrenciesAbbreviation(), currency);
				if (currency.isDefaultCurrency())
				{
					comboCurrencyType.setText(currency.getCurrenciesAbbreviation());
					baseCurrency = currency;
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
		CashUICashCollectTransactionAdd curCard = new CashUICashCollectTransactionAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD,txtCashCard.getData());
				argMap.put(EngKeys.CURRENT_CARD,txtCurrentAccount.getData());
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CASH_CURRENT_COLLECT));
				argMap.put(EngKeys.ENG_SEQ,null);
				argMap.put(CashKeys.CASH_TOTAL_AMOUNT,curTextTotalAmount.getBigDecimalValue());
				argMap.put(EngKeys.DATE,datePicker.getDate());
				argMap.put(EngKeys.DEFINITION,txtDefinition.getText());
				argMap.put(EngKeys.DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE, exchangeRate);
				
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionAdd.class.getName(),"saveCurrentTransaction",argMap);
				
				msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.1")); //$NON-NLS-1$
				msg.open();
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
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (txtCashCard.getData() == null)
			{
				msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.8")); //$NON-NLS-1$
				msg.open();
				txtCashCard.setFocus();
				return false;
			}
			else if (txtCurrentAccount.getData() == null)
			{
				msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.9")); //$NON-NLS-1$
				msg.open();
				txtCurrentAccount.setFocus();
				return false;
			}
			else if (curTextTotalAmount.getBigDecimalValue().equals(new BigDecimal(0)))
			{
				msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.10")); //$NON-NLS-1$
				msg.open();
				curTextTotalAmount.setFocus();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.12")); //$NON-NLS-1$
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePicker.getDate());
				if (exchangeRate == null)
				{
					msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.13")); //$NON-NLS-1$
					msg.open();
					return false;
				}
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

	public CurrentPicker getTxtCurrentAccount()
	{
		return txtCurrentAccount;
	}

	public void setTxtCurrentAccount(CurrentPicker txtCurrentAccount)
	{
		this.txtCurrentAccount = txtCurrentAccount;
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
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}

	/**
	 * @return Returns the exchangeRate.
	 */
	public TurqCurrencyExchangeRate getExchangeRate()
	{
		return exchangeRate;
	}
}