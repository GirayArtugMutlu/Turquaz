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
 * @author  Onsel
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.bank.ui.comp.BankCardPicker;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.BankLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIMoneyTransferIn extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblBankCard;
	private CCombo comboCurrencyType;
	private Text txtDefinition;
	private CLabel lblCurrency;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private DatePicker datePick;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private CurrentPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;
	private TurqCurrency baseCurrency = EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate = null;
	private TurqCurrency exchangeCurrency = null;

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

	public BankUIMoneyTransferIn(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(507, 227);
			{
				lblDocNo = new CLabel(this, SWT.NONE);
				lblDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
			}
			{
				txtDocNo = new Text(this, SWT.NONE);
				GridData txtDocNoLData = new GridData();
				txtDocNoLData.widthHint = 150;
				txtDocNoLData.heightHint = 17;
				txtDocNo.setLayoutData(txtDocNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText(EngLangCommonKeys.STR_DATE);
			}
			{
				datePick = new DatePicker(this, SWT.NONE);
				GridData datePickLData = new GridData();
				datePickLData.widthHint = 157;
				datePickLData.heightHint = 23;
				datePick.setLayoutData(datePickLData);
			}
			{
				{
				}
				lblBankCard = new CLabel(this, SWT.NONE);
				lblBankCard.setText(BankLangKeys.STR_BANK_CARD);
			}
			{
				txtBankCard = new BankCardPicker(this, SWT.NONE);
				GridData txtBankCardLData = new GridData();
				txtBankCardLData.widthHint = 157;
				txtBankCardLData.heightHint = 17;
				txtBankCard.setLayoutData(txtBankCardLData);
			}
			{
				lblCurrentCard = new CLabel(this, SWT.NONE);
				lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD);
			}
			{
				currentPicker = new CurrentPicker(this, SWT.NONE);
				GridData currentPickerLData = new GridData();
				currentPickerLData.widthHint = 157;
				currentPickerLData.heightHint = 17;
				currentPicker.setLayoutData(currentPickerLData);
			}
			{
				lblAmount = new CLabel(this, SWT.NONE);
				lblAmount.setText(EngLangCommonKeys.STR_TOTALPRICE);
			}
			{
				curAmount = new CurrencyText(this, SWT.NONE);
				GridData curAmountLData = new GridData();
				curAmountLData.widthHint = 150;
				curAmountLData.heightHint = 17;
				curAmount.setLayoutData(curAmountLData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(EngLangCommonKeys.STR_CURRENCY);
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
				lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 368;
				txtDefinitionLData.heightHint = 52;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			this.layout();
			PostInit();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void PostInit()
	{
		fillCurrencyCombo();
	}

	public void fillCurrencyCombo()
	{
		try
		{
			List currencies = (List)EngTXCommon.doSelectTX(EngBLCommon.class.getName(),"getCurrencies",null);
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
		BankUIMoneyTransferIn curCard = new BankUIMoneyTransferIn(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public boolean verifyFields()
	{
		try
		{
			if (txtBankCard.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),BankLangKeys.MSG_SELECT_BANK_CARD, SWT.ICON_WARNING); 
				txtBankCard.setFocus();
				return false;
			}
			if (currentPicker.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(), CurLangKeys.MSG_SELECT_CUR_CARD, SWT.ICON_WARNING); //$NON-NLS-1$
				currentPicker.setFocus();
				return false;
			}
			if (curAmount.getBigDecimalValue().compareTo(new BigDecimal(0)) != 1)
			{
				EngUICommon.showMessageBox(getShell(), EngLangCommonKeys.MSG_ENTER_AMOUNT, SWT.ICON_WARNING); //$NON-NLS-1$
				curAmount.setFocus();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				EngUICommon.showMessageBox(getShell(), EngLangCommonKeys.MSG_SELECT_CURRENCY, SWT.ICON_WARNING); //$NON-NLS-1$
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePick.getDate());
				if (exchangeRate == null)
				{
					EngUICommon.showMessageBox(getShell(), EngLangCommonKeys.MSG_DEFINE_DAILY_EXCHANGE_RATE, SWT.ICON_WARNING); //$NON-NLS-1$
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
            EngBLLogger.log(this.getClass(),ex,getShell());
			return false;
		}
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(BankKeys.BANK_ID,txtBankCard.getBankId());
				argMap.put(EngKeys.CURRENT_CARD,currentPicker.getData());
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.BANK_TRANS_RECIEVE_MONEY));
				argMap.put(EngKeys.ENG_SEQ,null);
				argMap.put(EngKeys.TOTAL_AMOUNT,curAmount.getBigDecimalValue());
				argMap.put(EngKeys.TRANS_DATE,datePick.getDate());
				argMap.put(EngKeys.DEFINITION,txtDefinition.getText().trim());
				argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,exchangeRate);			
				
				EngTXCommon.doTransactionTX(BankBLTransactionAdd.class.getName(),"saveTransaction",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
        }
	}

	public CurrencyText getCurAmount()
	{
		return curAmount;
	}

	public void setCurAmount(CurrencyText curAmount)
	{
		this.curAmount = curAmount;
	}

	public CurrentPicker getCurrentPicker()
	{
		return currentPicker;
	}

	public void setCurrentPicker(CurrentPicker currentPicker)
	{
		this.currentPicker = currentPicker;
	}

	public DatePicker getDatePick()
	{
		return datePick;
	}

	public void setDatePick(DatePicker datePick)
	{
		this.datePick = datePick;
	}

	public BankCardPicker getTxtBankCard()
	{
		return txtBankCard;
	}

	public void setTxtBankCard(BankCardPicker txtBankCard)
	{
		this.txtBankCard = txtBankCard;
	}

	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	public void setTxtDefinition(Text txtDefinition)
	{
		this.txtDefinition = txtDefinition;
	}

	public Text getTxtDocNo()
	{
		return txtDocNo;
	}

	public void setTxtDocNo(Text txtDocNo)
	{
		this.txtDocNo = txtDocNo;
	}
}