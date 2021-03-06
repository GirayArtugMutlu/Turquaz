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
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUITransactionAdd extends Composite implements SecureComposite
{
	private AccountPickerLeaf accPickerCashAccount;
	private CLabel lblCashAccount;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateTransDate;
	private CLabel lblTransDate;
	private CurrencyText decTxtAmount;
	private CLabel lblAmount;
	private CCombo comboTransType;
	private CLabel comboType;
	private CurrentPicker txtCurrentCode;
	private CLabel lblCurrentCode;

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}

	

	public CurUITransactionAdd(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			{
				lblCurrentCode = new CLabel(this, SWT.NONE);
				GridData lblCurrentCodeLData = new GridData();
				lblCurrentCodeLData.widthHint = 102;
				lblCurrentCodeLData.heightHint = 16;
				lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				lblCurrentCode.setText(CurLangKeys.STR_CUR_CODE); //$NON-NLS-1$
				lblCurrentCode.setSize(new org.eclipse.swt.graphics.Point(102, 16));
			}
			{
				txtCurrentCode = new CurrentPicker(this, SWT.NONE);
				GridData comboCurrentCodeLData = new GridData();
				
				comboCurrentCodeLData.widthHint = 150;
				comboCurrentCodeLData.heightHint = 17;
				txtCurrentCode.setLayoutData(comboCurrentCodeLData);
			}
			lblDocumentNo = new CLabel(this, SWT.NULL);
			txtDocumentNo = new Text(this, SWT.NULL);
			comboType = new CLabel(this, SWT.NULL);
			comboTransType = new CCombo(this, SWT.NULL);
			lblAmount = new CLabel(this, SWT.NULL);
			decTxtAmount = new CurrencyText(this, SWT.NULL);
			lblTransDate = new CLabel(this, SWT.NULL);
			dateTransDate = new DatePicker(this, SWT.NULL);
			lblCashAccount = new CLabel(this, SWT.NULL);
			accPickerCashAccount = new AccountPickerLeaf(this, SWT.NONE);
			this.setSize(498, 290);
			GridData lblDocumentNoLData = new GridData();
			lblDocumentNoLData.verticalAlignment = GridData.CENTER;
			lblDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			lblDocumentNoLData.widthHint = -1;
			lblDocumentNoLData.heightHint = -1;
			lblDocumentNoLData.horizontalIndent = 0;
			lblDocumentNoLData.horizontalSpan = 1;
			lblDocumentNoLData.verticalSpan = 1;
			lblDocumentNoLData.grabExcessHorizontalSpace = false;
			lblDocumentNoLData.grabExcessVerticalSpace = false;
			lblDocumentNo.setLayoutData(lblDocumentNoLData);
			lblDocumentNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO); //$NON-NLS-1$
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.widthHint = 150;
			txtDocumentNoLData.heightHint = 17;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			GridData comboTypeLData = new GridData();
			comboTypeLData.verticalAlignment = GridData.CENTER;
			comboTypeLData.horizontalAlignment = GridData.BEGINNING;
			comboTypeLData.widthHint = 138;
			comboTypeLData.heightHint = 17;
			comboTypeLData.horizontalIndent = 0;
			comboTypeLData.horizontalSpan = 1;
			comboTypeLData.verticalSpan = 1;
			comboTypeLData.grabExcessHorizontalSpace = false;
			comboTypeLData.grabExcessVerticalSpace = false;
			comboType.setLayoutData(comboTypeLData);
			comboType.setText(CurLangKeys.STR_DEPT_CREDIT); //$NON-NLS-1$
			comboType.setSize(new org.eclipse.swt.graphics.Point(138, 17));
			GridData comboTransTypeLData = new GridData();
			comboTransTypeLData.widthHint = 135;
			comboTransTypeLData.heightHint = 17;
			comboTransType.setLayoutData(comboTransTypeLData);
			comboTransType.setText(EngLangCommonKeys.STR_DEPT); //$NON-NLS-1$
			GridData lblAmountLData = new GridData();
			lblAmountLData.verticalAlignment = GridData.CENTER;
			lblAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblAmountLData.widthHint = 88;
			lblAmountLData.heightHint = 21;
			lblAmountLData.horizontalIndent = 0;
			lblAmountLData.horizontalSpan = 1;
			lblAmountLData.verticalSpan = 1;
			lblAmountLData.grabExcessHorizontalSpace = false;
			lblAmountLData.grabExcessVerticalSpace = false;
			lblAmount.setLayoutData(lblAmountLData);
			lblAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
			lblAmount.setSize(new org.eclipse.swt.graphics.Point(88, 21));
			GridData decTxtAmountLData = new GridData();
			decTxtAmount.setTextLimit(26);
			decTxtAmountLData.widthHint = 150;
			decTxtAmountLData.heightHint = 17;
			decTxtAmount.setLayoutData(decTxtAmountLData);
			decTxtAmount.setText(new BigDecimal(0));
			GridData lblTransDateLData = new GridData();
			lblTransDateLData.verticalAlignment = GridData.CENTER;
			lblTransDateLData.horizontalAlignment = GridData.BEGINNING;
			lblTransDateLData.widthHint = 100;
			lblTransDateLData.heightHint = 19;
			lblTransDateLData.horizontalIndent = 0;
			lblTransDateLData.horizontalSpan = 1;
			lblTransDateLData.verticalSpan = 1;
			lblTransDateLData.grabExcessHorizontalSpace = false;
			lblTransDateLData.grabExcessVerticalSpace = false;
			lblTransDate.setLayoutData(lblTransDateLData);
			lblTransDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
			lblTransDate.setSize(new org.eclipse.swt.graphics.Point(100, 19));
			GridData dateTransDateLData = new GridData();
			dateTransDateLData.widthHint = 157;
			dateTransDateLData.heightHint = 23;
			dateTransDate.setLayoutData(dateTransDateLData);
			dateTransDate.layout();
			GridData lblCashAccountLData = new GridData();
			lblCashAccountLData.widthHint = 88;
			lblCashAccountLData.heightHint = 19;
			lblCashAccount.setLayoutData(lblCashAccountLData);
			lblCashAccount.setText(CashLangKeys.STR_CASH_ACCOUNT); //$NON-NLS-1$
			GridData accPickerCashAccountLData = new GridData();
			accPickerCashAccountLData.widthHint = 157;
			accPickerCashAccountLData.heightHint = 17;
			accPickerCashAccount.setLayoutData(accPickerCashAccountLData);
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
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		comboTransType.add(EngLangCommonKeys.STR_DEPT); //$NON-NLS-1$
		comboTransType.add(EngLangCommonKeys.STR_CREDIT); //$NON-NLS-1$
		fillCurrencyCombo();
		//	content assistant
		
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

	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (txtCurrentCode.getData() == null)
			{
				msg.setMessage(CurLangKeys.MSG_SELECT_CUR_CARD); //$NON-NLS-1$
				msg.open();
				txtCurrentCode.setFocus();
				return false;
			}
			else if (decTxtAmount.getText().equals("")) { //$NON-NLS-1$
				msg.setMessage(EngLangCommonKeys.MSG_ENTER_AMOUNT); //$NON-NLS-1$
				msg.open();
				decTxtAmount.setFocus();
				return false;
			}
			else if (accPickerCashAccount.getData() == null)
			{
				msg.setMessage(CashLangKeys.MSG_SELECT_CASH_ACCOUNT); //$NON-NLS-1$
				msg.open();
				accPickerCashAccount.setFocus();
				return false;
			}
			else if ( comboCurrencyType.getData(comboCurrencyType.getText()) == null)
			{
				msg.setMessage("Para birimi seÁmelisiniz!");
				msg.open();
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

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				boolean isCredit = false;
				if (comboTransType.getText().equals(EngLangCommonKeys.STR_DEPT)) { //$NON-NLS-1$
					isCredit = false;
				}
				else if (comboTransType.getText().equals(EngLangCommonKeys.STR_CREDIT)) { //$NON-NLS-1$
					isCredit = true;
				}
				//Transaction Type is Cash
				//4,at the end means cash, it is a cash Transaction
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CARD_ID,txtCurrentCode.getCardId());
				argMap.put(AccKeys.ACC_ACCOUNT, accPickerCashAccount.getData());
				argMap.put(EngKeys.DATE,dateTransDate.getDate());
				argMap.put(EngKeys.DOCUMENT_NO,"");
				argMap.put(CurKeys.CUR_IS_CREDIT,new Boolean(isCredit));
				argMap.put(CurKeys.CUR_TRANS_AMOUNT,decTxtAmount.getBigDecimalValue());
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,new BigDecimal(0));
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CURRENT_TRANS_OTHERS));
				argMap.put(EngKeys.ENG_SEQ_ID,null);
				argMap.put(EngKeys.CURRENCY_ID,comboCurrencyType.getData(comboCurrencyType.getText().trim()));
								
				TurqCurrentTransaction curtrans = (TurqCurrentTransaction)EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveCurrentCashTransaction",argMap);
				
				
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); //$NON-NLS-1$
				msg.open();
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void delete()
	{
	}

	public void search()
	{
	}

	public void newForm()
	{
		CurUITransactionAdd curCard = new CurUITransactionAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	/**
	 * @return Returns the accPickerCashAccount.
	 */
	public AccountPickerLeaf getAccPickerCashAccount()
	{
		return accPickerCashAccount;
	}

	/**
	 * @param accPickerCashAccount
	 *             The accPickerCashAccount to set.
	 */
	public void setAccPickerCashAccount(AccountPickerLeaf accPickerCashAccount)
	{
		this.accPickerCashAccount = accPickerCashAccount;
	}

	/**
	 * @return Returns the txtCurrentCode.
	 */
	public CurrentPicker getTxtCurrentCode()
	{
		return txtCurrentCode;
	}

	/**
	 * @param txtCurrentCode
	 *             The txtCurrentCode to set.
	 */
	public void setTxtCurrentCode(CurrentPicker comboCurrentCode)
	{
		this.txtCurrentCode = comboCurrentCode;
	}

	/**
	 * @return Returns the comboTransType.
	 */
	public CCombo getComboTransType()
	{
		return comboTransType;
	}

	/**
	 * @param comboTransType
	 *             The comboTransType to set.
	 */
	public void setComboTransType(CCombo comboTransType)
	{
		this.comboTransType = comboTransType;
	}

	/**
	 * @return Returns the dateTransDate.
	 */
	public DatePicker getDateTransDate()
	{
		return dateTransDate;
	}

	/**
	 * @param dateTransDate
	 *             The dateTransDate to set.
	 */
	public void setDateTransDate(DatePicker dateTransDate)
	{
		this.dateTransDate = dateTransDate;
	}

	/**
	 * @return Returns the comboType.
	 */
	public CLabel getComboType()
	{
		return comboType;
	}

	/**
	 * @param comboType
	 *             The comboType to set.
	 */
	public void setComboType(CLabel comboType)
	{
		this.comboType = comboType;
	}

	/**
	 * @return Returns the decTxtAmount.
	 */
	public CurrencyText getDecTxtAmount()
	{
		return decTxtAmount;
	}

	/**
	 * @param decTxtAmount
	 *             The decTxtAmount to set.
	 */
	public void setDecTxtAmount(CurrencyText decTxtAmount)
	{
		this.decTxtAmount = decTxtAmount;
	}

	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo()
	{
		return txtDocumentNo;
	}

	/**
	 * @param txtDocumentNo
	 *             The txtDocumentNo to set.
	 */
	public void setTxtDocumentNo(Text txtDocumentNo)
	{
		this.txtDocumentNo = txtDocumentNo;
	}
}