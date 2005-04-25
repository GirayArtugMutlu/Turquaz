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
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.eclipse.swt.custom.CCombo;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.CurKeys;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;

public class CurUICurrentCardDeptVoucher extends org.eclipse.swt.widgets.Composite implements SecureComposite
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

	/**
	 * @return Returns the exchangeRate.
	 */
	public TurqCurrencyExchangeRate getExchangeRate()
	{
		return exchangeRate;
	}
	private TurqCurrency baseCurrency = EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate = null;
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
	private TurqCurrency exchangeCurrency = null;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		CurUICurrentCardVoucher inst = new CurUICurrentCardVoucher(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CurUICurrentCardDeptVoucher(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(592, 241);
			//START >>  lblCashTransType
			lblCashTransType = new CLabel(this, SWT.NONE);
			lblCashTransType.setText(Messages.getString("CurUICurrentCardDeptVoucher.0")); //$NON-NLS-1$
			lblCashTransType.setFont(SWTResourceManager.getFont("Tahoma", 14, 1, false, false)); //$NON-NLS-1$
			GridData lblCashTransTypeLData = new GridData();
			lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
			lblCashTransTypeLData.horizontalSpan = 2;
			lblCashTransTypeLData.grabExcessHorizontalSpace = true;
			lblCashTransType.setLayoutData(lblCashTransTypeLData);
			//END <<  lblCashTransType
			//START >>  lvlCurrentCard
			lvlCurrentCard = new CLabel(this, SWT.NONE);
			lvlCurrentCard.setText(Messages.getString("CurUICurrentCardVoucher.0")); //$NON-NLS-1$
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
			lvlDate.setText(Messages.getString("CurUICurrentCardVoucher.1")); //$NON-NLS-1$
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
			lblAcccountingAccount.setText(Messages.getString("CurUICurrentCardVoucher.3")); //$NON-NLS-1$
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
			lblCurrency.setText(Messages.getString("CurUICurrentCardDeptVoucher.1")); //$NON-NLS-1$
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
			lvlDefinition.setText(Messages.getString("CurUICurrentCardVoucher.2")); //$NON-NLS-1$
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
			List currencies = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getCurrencies",null); //$NON-NLS-1$
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
		CurUICurrentCardDeptVoucher curCard = new CurUICurrentCardDeptVoucher(this.getParent(), this.getStyle());
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
				boolean isCredit = false;
				
				HashMap argMap = new HashMap();
				argMap.put(EngKeys.CURRENT_CARD,(TurqCurrentCard) txtCurrentCard.getData());
				argMap.put(AccKeys.ACC_ACCOUNT, accountPicker.getTurqAccountingAccount());
				argMap.put(EngKeys.DATE,dateTransDate.getDate());
				argMap.put(EngKeys.DOCUMENT_NO,""); //$NON-NLS-1$
				argMap.put(CurKeys.CUR_IS_CREDIT,new Boolean(isCredit));
				argMap.put(CurKeys.CUR_TRANS_AMOUNT,credit);
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,new BigDecimal(0));
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CURRENT_TRANS_OTHERS));
				argMap.put(EngKeys.ENG_SEQ_ID,null);
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText());
				argMap.put(EngKeys.EXCHANGE_RATE,exchangeRate);
								
				TurqCurrentTransaction curtrans = (TurqCurrentTransaction)EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveOtherCurrentTransaction",argMap); //$NON-NLS-1$
				
				if (EngUICommon.okToDelete(getShell(), Messages.getString("CurUICurrentCardVoucher.4"))) //$NON-NLS-1$
				{
					EngBLUtils.printCurrentTrans(curtrans);
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
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (txtCurrentCard.getData() == null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardVoucher.10")); //$NON-NLS-1$
				msg.open();
				txtCurrentCard.setFocus();
				return false;
			}
			else if (txtCredit.getBigDecimalValue().intValue()==0)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardDeptVoucher.5")); //$NON-NLS-1$
				msg.open();
				txtCredit.setFocus();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardVoucher.6")); //$NON-NLS-1$
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, dateTransDate.getDate());
				if (exchangeRate == null)
				{
					msg.setMessage(Messages.getString("CurUICurrentCardVoucher.7")); //$NON-NLS-1$
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