package com.turquaz.bank.ui;

import java.math.BigDecimal;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.bank.ui.comp.BankCardPicker;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.SecureComposite;



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
public class BankUIOtherTransOut extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private CLabel lblDocNo;
	private CLabel lblBankCard;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private AccountPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;
	private DatePicker datePick;
	private CLabel lblDate;
	private Text txtDocNo;

	public BankUIOtherTransOut(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(491, 263);
            {
                lblDocNo = new CLabel(this, SWT.NONE);
                lblDocNo.setText(Messages.getString("BankUIOtherTransOut.0")); //$NON-NLS-1$
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
                lblDate.setText(Messages.getString("BankUIOtherTransOut.1")); //$NON-NLS-1$
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
                lblBankCard.setText(Messages.getString("BankUIOtherTransOut.2")); //$NON-NLS-1$
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
                lblCurrentCard.setText(Messages.getString("BankUIOtherTransOut.3")); //$NON-NLS-1$
               
            }
            {
                currentPicker = new AccountPicker(this, SWT.NONE);
                GridData currentPickerLData = new GridData();
                currentPickerLData.widthHint = 191;
                currentPickerLData.heightHint = 18;
                currentPicker.setLayoutData(currentPickerLData);
            }
            {
                lblAmount = new CLabel(this, SWT.NONE);
                lblAmount.setText(Messages.getString("BankUIOtherTransOut.4")); //$NON-NLS-1$
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
                lblDefinition.setText(Messages.getString("BankUIOtherTransOut.5")); //$NON-NLS-1$
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
		           EngUICommon.showMessageBox(getShell(),Messages.getString("BankUICashToBank.7"),SWT.ICON_WARNING); //$NON-NLS-1$
		           txtBankCard.setFocus();
		           return false;
		            
		        }
		        if(currentPicker.getData()==null){
		            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUICashToBank.6"),SWT.ICON_WARNING); //$NON-NLS-1$
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
     BankUIOtherTransIn curCard = new BankUIOtherTransIn(this.getParent(),this.getStyle());
  	 CTabFolder tabfld = (CTabFolder)this.getParent();
  	 tabfld.getSelection().setControl(curCard);	 
  	 this.dispose();


 }
 public void save() {
     try{
	       if(verifyFields())
	       {
	           BankBLTransactionAdd.saveOtherTransaction(txtBankCard.getTurqBank(),currentPicker.getTurqAccountingAccount(),EngBLCommon.BANK_TRANS_OTHER_DRAW,null,curAmount.getBigDecimalValue(),datePick.getDate(),txtDefinition.getText().trim(),txtDocNo.getText().trim());
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
    public AccountPicker getCurrentPicker() {
        return currentPicker;
    }
    public void setCurrentPicker(AccountPicker currentPicker) {
        this.currentPicker = currentPicker;
    }
    public DatePicker getDatePick() {
        return datePick;
    }
    public void setDatePick(DatePicker datePick) {
        this.datePick = datePick;
    }
    public BankCardPicker getTxtBankCard() {
        return txtBankCard;
    }
    public void setTxtBankCard(BankCardPicker txtBankCard) {
        this.txtBankCard = txtBankCard;
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
