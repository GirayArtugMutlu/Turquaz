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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.custom.CCombo;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
public class CurUICurrentCardVoucher extends org.eclipse.swt.widgets.Composite
implements SecureComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private CLabel lvlCurrentCard;
	private CurrentPicker txtCurrentCard;
	private CLabel lvlDate;
	private DatePicker dateTransDate;
	private CLabel lvlDefinition;
	private Text txtDefinition;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private AccountPicker accountPicker;
	private CLabel lblAcccountingAccount;
	private CCombo comboType;
	private CLabel lblDept;
	private CurrencyText txtCredit;
	private CLabel lblCredit;

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType() {
		return comboCurrencyType;
	}
	/**
	 * @return Returns the exchangeRate.
	 */
	public TurqCurrencyExchangeRate getExchangeRate() {
		return exchangeRate;
	}
	private CurBLCurrentTransactionAdd curBLTransAdd=new CurBLCurrentTransactionAdd();
	
	private TurqCurrency baseCurrency=EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate=null;
	private TurqCurrency exchangeCurrency=null;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		CurUICurrentCardVoucher inst = new CurUICurrentCardVoucher(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CurUICurrentCardVoucher(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	
	
	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(588, 229);
			{
				lvlCurrentCard = new CLabel(this, SWT.NONE);
				lvlCurrentCard.setText(Messages.getString("CurUICurrentCardVoucher.0")); //$NON-NLS-1$
				GridData lvlCurrentCardLData = new GridData();
				lvlCurrentCardLData.widthHint = 78;
				lvlCurrentCardLData.heightHint = 15;
				lvlCurrentCard.setLayoutData(lvlCurrentCardLData);
			}
			{
				txtCurrentCard = new CurrentPicker(this, SWT.NONE);
				GridData txtCurrentCardLData = new GridData();
				txtCurrentCardLData.widthHint = 157;
				txtCurrentCardLData.heightHint = 17;
				txtCurrentCard.setLayoutData(txtCurrentCardLData);
			}
			{
				lvlDate = new CLabel(this, SWT.NONE);
				lvlDate.setText(Messages.getString("CurUICurrentCardVoucher.1")); //$NON-NLS-1$
			}
			{
				dateTransDate = new DatePicker(this, SWT.NONE);
				GridData dateTransDateLData = new GridData();
				dateTransDateLData.widthHint = 157;
				dateTransDateLData.heightHint = 23;
				dateTransDate.setLayoutData(dateTransDateLData);
			}
			{
				lblDept = new CLabel(this, SWT.NONE);
				lblDept.setText("Bor� / Alacak"); //$NON-NLS-1$
			}
			{
				comboType = new CCombo(this, SWT.NONE);
				
				GridData txtDeptLData = new GridData();
				comboType.setBackground(SWTResourceManager.getColor(255, 255, 255));
				txtDeptLData.widthHint = 135;
				txtDeptLData.heightHint = 17;
				comboType.setLayoutData(txtDeptLData);
			}
			{
				lblCredit = new CLabel(this, SWT.NONE);
				GridData lblCreditLData = new GridData();
				lblCredit.setText("Tutar\u0131:"); //$NON-NLS-1$
				lblCreditLData.widthHint = 81;
				lblCreditLData.heightHint = 18;
				lblCredit.setLayoutData(lblCreditLData);
			}
			{
				txtCredit = new CurrencyText(this, SWT.NONE);
				GridData txtCreditLData = new GridData();
				txtCreditLData.widthHint = 150;
				txtCreditLData.heightHint = 17;
				txtCredit.setLayoutData(txtCreditLData);
			}
			//START >>  lblAcccountingAccount
			lblAcccountingAccount = new CLabel(this, SWT.NONE);
			lblAcccountingAccount.setText("Muhasebe Hesab\u0131:");
			//END <<  lblAcccountingAccount
			//START >>  accountPicker
			accountPicker = new AccountPicker(this, SWT.NONE);
			GridData accountPickerLData = new GridData();
			accountPickerLData.widthHint = 157;
			accountPickerLData.heightHint = 17;
			accountPicker.setLayoutData(accountPickerLData);
			//END <<  accountPicker
			//START >>  lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText("Para Birimi");
			//END <<  lblCurrency
			//START >>  comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END <<  comboCurrencyType
			{
				lvlDefinition = new CLabel(this, SWT.NONE);
				lvlDefinition.setText(Messages
					.getString("CurUICurrentCardVoucher.2")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
				GridData txtDefinitionLData = new GridData();

				txtDefinitionLData.widthHint = 383;
				txtDefinitionLData.heightHint = 56;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			comboType.add(EngBLCommon.COMMON_DEPT_STRING);
			comboType.add(EngBLCommon.COMMON_CREDIT_STRING);
			comboType.setText(EngBLCommon.COMMON_DEPT_STRING);
			comboType.setEditable(false);
			
			this.layout();
			PostInit();
		} catch (Exception e) {
			e.printStackTrace();
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
			List currencies=AccBLTransactionSearch.getCurrencies();
			for (int k=0; k<currencies.size(); k++)
			{
				TurqCurrency currency=(TurqCurrency)currencies.get(k);
				comboCurrencyType.add(currency.getCurrenciesAbbreviation());
				comboCurrencyType.setData(currency.getCurrenciesAbbreviation(),currency);
				if (currency.isDefaultCurrency())
				{
					comboCurrencyType.setText(currency.getCurrenciesAbbreviation());
					baseCurrency=currency;
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
		 CurUICurrentCardVoucher  curCard = new CurUICurrentCardVoucher(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();
		
	}
	public void save()
	{
		try
		{			

			if (verifyFields())
			{
				BigDecimal credit=txtCredit.getBigDecimalValue();
				
			
				boolean isCredit = false;
				if(comboType.getText().equals(EngBLCommon.COMMON_CREDIT_STRING)){
				    isCredit=true;
				}

				TurqCurrentTransaction curtrans = curBLTransAdd.saveOtherCurrentTransaction((TurqCurrentCard)txtCurrentCard.getData(),
					accountPicker.getTurqAccountingAccount(),dateTransDate.getDate(),"",isCredit,credit, //$NON-NLS-1$
							new BigDecimal(0),EngBLCommon.CURRENT_TRANS_OTHERS,
							null,txtDefinition.getText(),exchangeRate);
				
				if(EngUICommon.okToDelete(getShell(),Messages.getString("CurUICurrentCardVoucher.4"))) //$NON-NLS-1$
				{
				    EngBLUtils.printCurrentTrans(curtrans);
				}
				newForm();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	public boolean verifyFields()
	{
		try
		{
			MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
			if (txtCurrentCard.getData()==null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardVoucher.10")); //$NON-NLS-1$
				msg.open();
				txtCurrentCard.setFocus();
				return false;
			}
			else if (txtCredit.getText().equals("") && comboType.getText().equals("")) //$NON-NLS-1$ //$NON-NLS-2$
			{
				msg.setMessage(Messages.getString("CurUICurrentCardVoucher.13")); //$NON-NLS-1$
				msg.open();
				comboType.setFocus();
				return false;
			}
			else if ((exchangeCurrency=(TurqCurrency)comboCurrencyType.getData(comboCurrencyType.getText()))==null)
			{
				msg.setMessage("Para birimi se�melisiniz!");
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() !=exchangeCurrency.getId().intValue())
			{
				exchangeRate=EngBLCommon.getCurrencyExchangeRate(baseCurrency,
					exchangeCurrency,dateTransDate.getDate());
			
				if (exchangeRate == null)
				{
					msg.setMessage("G�nl�k kur tan?mlamal?s?n?z!");
					msg.open();
					return false;	
		
				}
		
			}
			else
			{
				exchangeRate=EngBLCommon.getBaseCurrencyExchangeRate();
			}  
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

    public DatePicker getDateTransDate() {
        return dateTransDate;
    }
    public void setDateTransDate(DatePicker dateTransDate) {
        this.dateTransDate = dateTransDate;
    }
    public CurrencyText getTxtCredit() {
        return txtCredit;
    }
    public void setTxtCredit(CurrencyText txtCredit) {
        this.txtCredit = txtCredit;
    }
    public CurrentPicker getTxtCurrentCard() {
        return txtCurrentCard;
    }
    public void setTxtCurrentCard(CurrentPicker txtCurrentCard) {
        this.txtCurrentCard = txtCurrentCard;
    }
    public Text getTxtDefinition() {
        return txtDefinition;
    }
    public void setTxtDefinition(Text txtDefinition) {
        this.txtDefinition = txtDefinition;
    }
    public CCombo getComboType() {
        return comboType;
    }
  
    
	/**
	 * @return Returns the accountPicker.
	 */
	public AccountPicker getAccountPicker() {
		return accountPicker;
	}
	/**
	 * @param accountPicker The accountPicker to set.
	 */
	public void setAccountPicker(AccountPicker accountPicker) {
		this.accountPicker = accountPicker;
	}
}
