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
import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.eclipse.swt.custom.CCombo;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;

public class CurUICurrentCardCreditVoucher extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}

	
	private CLabel lblCashTransType;
	private CurrentPicker txtCurrentCard;
	private CLabel lvlDate;
	private CLabel lblCredit;
	private CLabel lvlDefinition;
	private Text txtDefinition;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private AccountPickerLeaf accountPicker;
	private CLabel lblAcccountingAccount;
	private CurrencyText txtCredit;
	private DatePicker dateTransDate;
	private CLabel lvlCurrentCard;

	

	public CurUICurrentCardCreditVoucher(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(587, 364);
			//START >>  lblCashTransType
			lblCashTransType = new CLabel(this, SWT.NONE);
			lblCashTransType.setText(CurLangKeys.STR_CREDIT_VOUCHER); //$NON-NLS-1$
			lblCashTransType.setFont(SWTResourceManager.getFont("Tahoma", 14, 1, false, false)); //$NON-NLS-1$
			GridData lblCashTransTypeLData = new GridData();
			lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
			lblCashTransTypeLData.horizontalSpan = 2;
			lblCashTransTypeLData.grabExcessHorizontalSpace = true;
			lblCashTransType.setLayoutData(lblCashTransTypeLData);
			//END <<  lblCashTransType
			//START >>  lvlCurrentCard
			lvlCurrentCard = new CLabel(this, SWT.NONE);
			lvlCurrentCard.setText(CurLangKeys.STR_CUR_CARD); //$NON-NLS-1$
			GridData lvlCurrentCardLData = new GridData();
			lvlCurrentCardLData.widthHint = 78;
			lvlCurrentCardLData.heightHint = 15;
			lvlCurrentCard.setLayoutData(lvlCurrentCardLData);
			//END <<  lvlCurrentCard
			//START >>  txtCurrentCard
			txtCurrentCard = new CurrentPicker(this, SWT.NONE);
			GridData txtCurrentCardLData = new GridData();
			txtCurrentCardLData.widthHint = 157;
			txtCurrentCardLData.heightHint = 17;
			txtCurrentCard.setLayoutData(txtCurrentCardLData);
			//END <<  txtCurrentCard
			//START >>  lvlDate
			lvlDate = new CLabel(this, SWT.NONE);
			lvlDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
			//END <<  lvlDate
			//START >>  dateTransDate
			dateTransDate = new DatePicker(this, SWT.NONE);
			GridData dateTransDateLData = new GridData();
			dateTransDateLData.widthHint = 157;
			dateTransDateLData.heightHint = 23;
			dateTransDate.setLayoutData(dateTransDateLData);
			//END <<  dateTransDate
			//START >>  lblCredit
			lblCredit = new CLabel(this, SWT.NONE);
			GridData lblCreditLData = new GridData();
			lblCredit.setText("Tutar\u0131:"); //$NON-NLS-1$
			lblCreditLData.widthHint = 81;
			lblCreditLData.heightHint = 18;
			lblCredit.setLayoutData(lblCreditLData);
			//END <<  lblCredit
			//START >>  txtCredit
			txtCredit = new CurrencyText(this, SWT.NONE);
			GridData txtCreditLData = new GridData();
			txtCreditLData.widthHint = 150;
			txtCreditLData.heightHint = 17;
			txtCredit.setLayoutData(txtCreditLData);
			//END <<  txtCredit
			//START >>  lblAcccountingAccount
			lblAcccountingAccount = new CLabel(this, SWT.NONE);
			lblAcccountingAccount.setText(EngLangCommonKeys.STR_ACCOUNTING_ACCOUNT); //$NON-NLS-1$
			//END <<  lblAcccountingAccount
			//START >>  accountPicker
			accountPicker = new AccountPickerLeaf(this, SWT.NONE);
			GridData accountPickerLData = new GridData();
			accountPickerLData.widthHint = 157;
			accountPickerLData.heightHint = 17;
			accountPicker.setLayoutData(accountPickerLData);
			//END <<  accountPicker
			//START >>  lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(EngLangCommonKeys.STR_CURRENCY); //$NON-NLS-1$
			//END <<  lblCurrency
			//START >>  comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END <<  comboCurrencyType
			//START >>  lvlDefinition
			lvlDefinition = new CLabel(this, SWT.NONE);
			lvlDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
			//END <<  lvlDefinition
			//START >>  txtDefinition
			txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
			GridData txtDefinitionLData = new GridData();
			txtDefinitionLData.widthHint = 383;
			txtDefinitionLData.heightHint = 56;
			txtDefinition.setLayoutData(txtDefinitionLData);
			//END <<  txtDefinition
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
		
		HashBag currencyBag = (HashBag)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getCurrencies",null);
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
		CurUICurrentCardCreditVoucher curCard = new CurUICurrentCardCreditVoucher(this.getParent(), this.getStyle());
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
				BigDecimal credit = txtCredit.getBigDecimalValue();
				boolean isCredit = true;
				
				
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CARD_ID, txtCurrentCard.getCardId());
				argMap.put(AccKeys.ACC_ACCOUNT_ID, accountPicker.getId());
				argMap.put(EngKeys.DATE,dateTransDate.getDate());
				argMap.put(EngKeys.DOCUMENT_NO,""); //$NON-NLS-1$
				argMap.put(CurKeys.CUR_IS_CREDIT,new Boolean(isCredit));
				argMap.put(CurKeys.CUR_TRANS_AMOUNT,credit);
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,new BigDecimal(0));
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CURRENT_TRANS_OTHERS));
				argMap.put(EngKeys.ENG_SEQ_ID,null);
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText());
				argMap.put(EngKeys.CURRENCY_ID,comboCurrencyType.getData(comboCurrencyType.getText().trim()));
								
				EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveOtherCurrentTransaction",argMap); //$NON-NLS-1$
				
				if (EngUICommon.showQuestion(getShell(), CurLangKeys.MSG_WANT_TO_PRINT_VOUCHER)) //$NON-NLS-1$
				{
					EngBLUtils.printCurrentTrans(txtCurrentCard.getCardCode(),txtCurrentCard.getCardName(),txtDefinition.getText().trim(),dateTransDate.getDate(),credit,isCredit);
					
				}
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
			if (txtCurrentCard.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),CurLangKeys.MSG_SELECT_CUR_CARD,SWT.ICON_WARNING); 		
				txtCurrentCard.setFocus();
				return false;
			}
			else if (txtCredit.getBigDecimalValue().intValue()==0)
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_ENTER_AMOUNT,SWT.ICON_WARNING);
				txtCredit.setFocus();
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

	public DatePicker getDateTransDate()
	{
		return dateTransDate;
	}

	public CurrencyText getTxtCredit()
	{
		return txtCredit;
	}

	public CurrentPicker getTxtCurrentCard()
	{
		return txtCurrentCard;
	}

	public Text getTxtDefinition()
	{
		return txtDefinition;
	}


	/**
	 * @return Returns the accountPicker.
	 */
	public AccountPickerLeaf getAccountPicker()
	{
		return accountPicker;
	}
}