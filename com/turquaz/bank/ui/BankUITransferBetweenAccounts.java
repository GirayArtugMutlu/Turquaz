package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.bank.ui.comp.BankCardPicker;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
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
public class BankUITransferBetweenAccounts extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private CLabel lblDocNo;
	private CLabel lblBankCard;
	private CCombo comboCurrencyType;
	private Text txtDefinition;
	private CLabel lblCurrency;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private BankCardPicker bankCardPickerWithCredit;
	private CLabel lblCurrentCard;
	private BankCardPicker bankCardPickerWithDept;
	private DatePicker datePick;
	private CLabel lblDate;
	private Text txtDocNo;
	
	private TurqCurrency baseCurrency=EngBLCommon.getBaseCurrency();
	private TurqCurrencyExchangeRate exchangeRate=null;
	private TurqCurrency exchangeCurrency=null;

	

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
	public BankUITransferBetweenAccounts(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(539, 224);
            {
                lblDocNo = new CLabel(this, SWT.NONE);
                lblDocNo.setText("Belge No");
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
                lblDate.setText("Tarih");
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
                lblBankCard.setText("Banka Kart\u0131 (Bor�lu)");
            }
            {
                bankCardPickerWithDept = new BankCardPicker(this, SWT.NONE);
                GridData txtBankCardLData = new GridData();
                txtBankCardLData.widthHint = 157;
                txtBankCardLData.heightHint = 17;
                bankCardPickerWithDept.setLayoutData(txtBankCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText("Banka Kart\u0131 (Alacakl\u0131)");
            }
            {
                bankCardPickerWithCredit = new BankCardPicker(this, SWT.NONE);
                GridData currentPickerLData = new GridData();
                currentPickerLData.widthHint = 157;
                currentPickerLData.heightHint = 17;
                bankCardPickerWithCredit.setLayoutData(currentPickerLData);
            }
            {
                lblAmount = new CLabel(this, SWT.NONE);
                lblAmount.setText("Tutar\u0131");
            }
            {
                curAmount = new CurrencyText(this, SWT.NONE);
                GridData curAmountLData = new GridData();
                curAmountLData.widthHint = 150;
                curAmountLData.heightHint = 17;
                curAmount.setLayoutData(curAmountLData);
            }
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
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText("A�\u0131klama");
            }
            {
                txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 362;
                txtDefinitionLData.heightHint = 51;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
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
	

	public boolean verifyFields(){
		try
		{
		   
		        if(bankCardPickerWithDept.getData()==null){
		           EngUICommon.showMessageBox(getShell(),"L�tfen Bor�lu Banka Kart? Se�iniz",SWT.ICON_WARNING); 
		           bankCardPickerWithDept.setFocus();
		           return false;
		            
		        }
		        else if(bankCardPickerWithCredit.getData()==null){
			           EngUICommon.showMessageBox(getShell(),"L�tfen Alacakl? Banka Kart? Se�iniz",SWT.ICON_WARNING); 
			           bankCardPickerWithCredit.setFocus();
			           return false;
			            
			        }
		        else if(curAmount.getBigDecimalValue().compareTo(new BigDecimal(0))!=1)
		        {
		            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferIn.8"),SWT.ICON_WARNING); //$NON-NLS-1$
		             curAmount.setFocus();
		            return false;
		            
		        }
	    		else if ((exchangeCurrency=(TurqCurrency)comboCurrencyType.getData(comboCurrencyType.getText()))==null)
	    		{
	    			EngUICommon.showMessageBox(getShell(),"Para birimi se�melisiniz!",SWT.ICON_WARNING);
	        		comboCurrencyType.setFocus();
	        		return false;
	    		}
	    		if (baseCurrency.getId().intValue() !=exchangeCurrency.getId().intValue())
	    		{
					exchangeRate=EngBLCommon.getCurrencyExchangeRate(baseCurrency,
							exchangeCurrency,datePick.getDate());
					if (exchangeRate == null)
					{
						EngUICommon.showMessageBox(getShell(),"G�nl�k kur tan?mlamal?s?n?z!",SWT.ICON_WARNING);
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
	

public void newForm() {
  BankUITransferBetweenAccounts curCard = new BankUITransferBetweenAccounts(this.getParent(),this.getStyle());
	 CTabFolder tabfld = (CTabFolder)this.getParent();
	 tabfld.getSelection().setControl(curCard);	 
	 this.dispose();


}
public void save() {
  try{
	       if(verifyFields())
	       {
	           BankBLTransactionAdd.saveTransferBetweenBanks(bankCardPickerWithDept.getTurqBank(),
	           		bankCardPickerWithCredit.getTurqBank(),
					null,curAmount.getBigDecimalValue(),datePick.getDate(),
					txtDefinition.getText().trim(),txtDocNo.getText().trim(),
					exchangeRate);
	           EngUICommon.showSavedSuccesfullyMessage(getShell());
	           newForm();
	           
	       }
	        }
	        catch(Exception ex){
	            ex.printStackTrace();
	            EngUICommon.showMessageBox(getShell(),ex.getMessage(),SWT.ICON_ERROR);
	        }


}

    public CurrencyText getCurAmount() {
        return curAmount;
    }
    public void setCurAmount(CurrencyText curAmount) {
        this.curAmount = curAmount;
    }
    public BankCardPicker getBankCardPickerWithCredit() {
        return bankCardPickerWithCredit;
    }
    public void setBankCardPickerWithCredit(BankCardPicker currentPicker) {
        this.bankCardPickerWithCredit = currentPicker;
    }
    public DatePicker getDatePick() {
        return datePick;
    }
    public void setDatePick(DatePicker datePick) {
        this.datePick = datePick;
    }
    public BankCardPicker getBankCardPickerWithDept() {
        return bankCardPickerWithDept;
    }
    public void setBankCardPickerWithDept(BankCardPicker txtBankCard) {
        this.bankCardPickerWithDept = txtBankCard;
    }
    public Text getTxtDefinition() {
        return txtDefinition;
    }
    public void setTxtDefinition(Text txtDefinition) {
        this.txtDefinition = txtDefinition;
    }
    public Text getTxtDocNo() {
        return txtDocNo;
    }
    public void setTxtDocNo(Text txtDocNo) {
        this.txtDocNo = txtDocNo;
    }
}
