package com.turquaz.bank.ui;

import java.math.BigDecimal;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionAdd;
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
public class BankUICashFromBank extends org.eclipse.swt.widgets.Composite implements SecureComposite{
	private CLabel lblDocNo;
	private CLabel lblBankCard;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private CashCardPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;
	private DatePicker datePick;
	private CLabel lblDate;
	private Text txtDocNo;

	

	public BankUICashFromBank(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(519, 256);
            {
                lblDocNo = new CLabel(this, SWT.NONE);
                lblDocNo.setText(Messages.getString("BankUICashFromBank.0")); //$NON-NLS-1$
            }
            {
                txtDocNo = new Text(this, SWT.NONE);
                GridData txtDocNoLData = new GridData();
                txtDocNoLData.widthHint = 128;
                txtDocNoLData.heightHint = 15;
                txtDocNo.setLayoutData(txtDocNoLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText(Messages.getString("BankUICashFromBank.1")); //$NON-NLS-1$
            }
            {
                datePick = new DatePicker(this, SWT.NONE);
                GridData datePickLData = new GridData();
                datePickLData.widthHint = 109;
                datePickLData.heightHint = 20;
                datePick.setLayoutData(datePickLData);
            }
            {
                lblBankCard = new CLabel(this, SWT.NONE);
                lblBankCard.setText(Messages.getString("BankUICashFromBank.2")); //$NON-NLS-1$
            }
            {
                txtBankCard = new BankCardPicker(this, SWT.NONE);
                GridData txtBankCardLData = new GridData();
                txtBankCardLData.widthHint = 192;
                txtBankCardLData.heightHint = 18;
                txtBankCard.setLayoutData(txtBankCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText(Messages.getString("BankUICashFromBank.3")); //$NON-NLS-1$
            }
            {
                currentPicker = new CashCardPicker(this, SWT.NONE);
                GridData currentPickerLData = new GridData();
                currentPickerLData.widthHint = 191;
                currentPickerLData.heightHint = 18;
                currentPicker.setLayoutData(currentPickerLData);
            }
            {
                lblAmount = new CLabel(this, SWT.NONE);
                lblAmount
                    .setText(Messages.getString("BankUICashFromBank.4")); //$NON-NLS-1$
            }
            {
                curAmount = new CurrencyText(this, SWT.NONE);
                GridData curAmountLData = new GridData();
                curAmountLData.widthHint = 185;
                curAmountLData.heightHint = 18;
                curAmount.setLayoutData(curAmountLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText(Messages.getString("BankUICashFromBank.5")); //$NON-NLS-1$
            }
            {
                txtDefinition = new Text(this, SWT.NONE);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 361;
                txtDefinitionLData.heightHint = 18;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyFields(){
	   
	        if(txtBankCard.getData()==null){
	           EngUICommon.showMessageBox(getShell(),"Lütfen Önce Banka Kart? Seçiniz!",SWT.ICON_WARNING); //$NON-NLS-1$
	           txtBankCard.setFocus();
	           return false;
	            
	        }
	        if(currentPicker.getData()==null){
	            EngUICommon.showMessageBox(getShell(),"Lütfen Önce Kasa Kart? Seçiniz!",SWT.ICON_WARNING); //$NON-NLS-1$
	            currentPicker.setFocus();
	            return false;
	             
	         }
	        if(curAmount.getBigDecimalValue().compareTo(new BigDecimal(0))!=1)
	        {
	            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferIn.8"),SWT.ICON_WARNING); //$NON-NLS-1$
	             curAmount.setFocus();
	            return false;
	            
	        }
	        return true;
	        
	    
	}

    public void newForm() {
        BankUICashFromBank curCard = new BankUICashFromBank(this.getParent(),this.getStyle());
      	 CTabFolder tabfld = (CTabFolder)this.getParent();
      	 tabfld.getSelection().setControl(curCard);	 
      	 this.dispose();

    }
    public void save() {
        try{
       if(verifyFields())
       {
           BankBLTransactionAdd.saveCashTransaction(txtBankCard.getTurqBank(),currentPicker.getTurqCashCard(),EngBLCommon.BANK_TRANS_CASH_DRAW,null,curAmount.getBigDecimalValue(),datePick.getDate(),txtDefinition.getText().trim(),txtDocNo.getText().trim());
           EngUICommon.showSavedSuccesfullyMessage(getShell());
           newForm();
           
       }
        }
        catch(Exception ex){
            ex.printStackTrace();
            EngUICommon.showMessageBox(getShell(),ex.getMessage(),SWT.ICON_ERROR);
        }

    }
}
