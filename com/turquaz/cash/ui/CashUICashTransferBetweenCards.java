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
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.cash.ui.comp.CashCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
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
public class CashUICashTransferBetweenCards extends org.eclipse.swt.widgets.Composite implements SecureComposite
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
	private CashCardPicker txtCashCardWithCredit;
	private CLabel lblCurrentCard;
	private CashCardPicker txtCashCardWithDept;
	private TurqCurrency baseCurrency = EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate = null;
	private TurqCurrency exchangeCurrency = null;

	public CashUICashTransferBetweenCards(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(540, 267);
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
				lblCashCard.setText(Messages.getString("CashUICashTransferBetweenCards.0")); //$NON-NLS-1$
			}
			{
				txtCashCardWithDept = new CashCardPicker(this, SWT.NONE);
				GridData txtCashCardLData = new GridData();
				txtCashCardLData.widthHint = 157;
				txtCashCardLData.heightHint = 17;
				txtCashCardWithDept.setLayoutData(txtCashCardLData);
			}
			{
				lblCurrentCard = new CLabel(this, SWT.NONE);
				lblCurrentCard.setText(Messages.getString("CashUICashTransferBetweenCards.1")); //$NON-NLS-1$
			}
			{
				txtCashCardWithCredit = new CashCardPicker(this, SWT.NONE);
				GridData txtCurrentAccountLData = new GridData();
				txtCurrentAccountLData.widthHint = 157;
				txtCurrentAccountLData.heightHint = 17;
				txtCashCardWithCredit.setLayoutData(txtCurrentAccountLData);
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
			lblCurrency.setText("Para Birimi");
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
				txtDefinitionLData.widthHint = 368;
				txtDefinitionLData.heightHint = 51;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
			List currencies = AccBLTransactionSearch.getCurrencies();
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
			ex.printStackTrace();
		}
	}

	public void newForm()
	{
		CashUICashTransferBetweenCards curCard = new CashUICashTransferBetweenCards(this.getParent(), this.getStyle());
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
				CashBLCashTransactionAdd.saveTransferBetweenAccounts((TurqCashCard) txtCashCardWithDept.getData(),
						txtCashCardWithCredit.getTurqCashCard(), EngBLCommon.CASH_TRANSFER_BETWEEN_CARDS, null, curTextTotalAmount
								.getBigDecimalValue(), datePicker.getDate(), txtDefinition.getText(), txtDocumentNo.getText()
								.trim(), exchangeRate);
				msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.1")); //$NON-NLS-1$
				msg.open();
				newForm();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (txtCashCardWithDept.getData() == null)
			{
				msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.2")); //$NON-NLS-1$
				msg.open();
				txtCashCardWithDept.setFocus();
				return false;
			}
			else if (txtCashCardWithCredit.getData() == null)
			{
				msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.3")); //$NON-NLS-1$
				msg.open();
				txtCashCardWithCredit.setFocus();
				return false;
			}
			else if (curTextTotalAmount.getBigDecimalValue().equals(new BigDecimal(0)))
			{
				msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.4")); //$NON-NLS-1$
				msg.open();
				curTextTotalAmount.setFocus();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				msg.setMessage("Para birimi seçmelisiniz!");
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePicker.getDate());
				if (exchangeRate == null)
				{
					msg.setMessage("Günlük de?i?im oran? tan?mlamal?s?n?z!");
					msg.open();
					return false;
				}
			}
			else
			{
				exchangeRate = EngBLCommon.getBaseCurrencyExchangeRate();
			}
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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

	public CashCardPicker getTxtCashCardWithDept()
	{
		return txtCashCardWithDept;
	}

	public void setTxtCashCardWithDept(CashCardPicker txtCashCard)
	{
		this.txtCashCardWithDept = txtCashCard;
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
	 * @return Returns the txtCashCardWithCredit.
	 */
	public CashCardPicker getTxtCashCardWithCredit()
	{
		return txtCashCardWithCredit;
	}

	/**
	 * @param txtCashCardWithCredit
	 *             The txtCashCardWithCredit to set.
	 */
	public void setTxtCashCardWithCredit(CashCardPicker txtCashCardWithCredit)
	{
		this.txtCashCardWithCredit = txtCashCardWithCredit;
	}
}