package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.bank.ui.comp.BankCardPicker;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.SecureComposite;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIOtherTransIn extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblDocNo;
	private CLabel lblBankCard;
	private CCombo comboCurrencyType;
	private Text txtDefinition;
	private CLabel lblCurrency;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private AccountPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;
	private DatePicker datePick;
	private CLabel lblDate;
	private Text txtDocNo;
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

	public BankUIOtherTransIn(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(508, 236);
			{
				lblDocNo = new CLabel(this, SWT.NONE);
				lblDocNo.setText(Messages.getString("BankUIOtherTransIn.0")); //$NON-NLS-1$
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
				lblDate.setText(Messages.getString("BankUIOtherTransIn.1")); //$NON-NLS-1$
			}
			{
				datePick = new DatePicker(this, SWT.NONE);
				GridData datePickLData = new GridData();
				datePickLData.widthHint = 157;
				datePickLData.heightHint = 23;
				datePick.setLayoutData(datePickLData);
			}
			{
				lblBankCard = new CLabel(this, SWT.NONE);
				lblBankCard.setText(Messages.getString("BankUIOtherTransIn.2")); //$NON-NLS-1$
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
				lblCurrentCard.setText(Messages.getString("BankUIOtherTransIn.3")); //$NON-NLS-1$
			}
			{
				currentPicker = new AccountPicker(this, SWT.NONE);
				GridData currentPickerLData = new GridData();
				currentPickerLData.widthHint = 157;
				currentPickerLData.heightHint = 17;
				currentPicker.setLayoutData(currentPickerLData);
			}
			{
				lblAmount = new CLabel(this, SWT.NONE);
				lblAmount.setText(Messages.getString("BankUIOtherTransIn.4")); //$NON-NLS-1$
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
			lblCurrency.setText(Messages.getString("BankUIOtherTransIn.6")); //$NON-NLS-1$
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
				lblDefinition.setText(Messages.getString("BankUIOtherTransIn.5")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 361;
				txtDefinitionLData.heightHint = 48;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			this.layout();
			PostInit();
		}
		catch (Exception e)
		{
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
			List currencies = (List)EngTXCommon.doSingleTX(AccBLTransactionSearch.class.getName(),"getCurrencies",null);
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
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		try
		{
			if (txtBankCard.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(), Messages.getString("BankUICashToBank.7"), SWT.ICON_WARNING); //$NON-NLS-1$
				txtBankCard.setFocus();
				return false;
			}
			else if (currentPicker.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(), Messages.getString("BankUICashToBank.6"), SWT.ICON_WARNING); //$NON-NLS-1$
				currentPicker.setFocus();
				return false;
			}
			else if (curAmount.getBigDecimalValue().compareTo(new BigDecimal(0)) != 1)
			{
				EngUICommon.showMessageBox(getShell(), Messages.getString("BankUIMoneyTransferIn.8"), SWT.ICON_WARNING); //$NON-NLS-1$
				curAmount.setFocus();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				EngUICommon.showMessageBox(getShell(), Messages.getString("BankUIOtherTransIn.7"), SWT.ICON_WARNING); //$NON-NLS-1$
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePick.getDate());
				if (exchangeRate == null)
				{
					EngUICommon.showMessageBox(getShell(), Messages.getString("BankUIOtherTransIn.8"), SWT.ICON_WARNING); //$NON-NLS-1$
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
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return false;
		}
	}

	public void newForm()
	{
		BankUIOtherTransIn curCard = new BankUIOtherTransIn(this.getParent(), this.getStyle());
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
				BankBLTransactionAdd.saveOtherTransaction(txtBankCard.getTurqBank(), currentPicker.getTurqAccountingAccount(),
						EngBLCommon.BANK_TRANS_OTHER_DEPOSIT, null, curAmount.getBigDecimalValue(), datePick.getDate(), txtDefinition
								.getText().trim(), txtDocNo.getText().trim(), exchangeRate);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), ex.getMessage(), SWT.ICON_ERROR);
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

	public AccountPicker getCurrentPicker()
	{
		return currentPicker;
	}

	public void setCurrentPicker(AccountPicker currentPicker)
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