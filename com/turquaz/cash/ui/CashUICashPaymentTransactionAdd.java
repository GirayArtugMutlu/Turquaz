package com.turquaz.cash.ui;

import java.math.BigDecimal;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.layout.GridData;

import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
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
public class CashUICashPaymentTransactionAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private CLabel lblCashTransType;
	private CLabel lblCashCard;
	private Text txtDefinition;
	private DatePicker datePicker;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CurrencyText curTextTotalAmount;
	private CLabel lblTotalAmount;
	private Text txtCurrentAccount;
	private CLabel lblCurrentCard;
	private Text txtCashCard;
	CashBLCashTransactionAdd blTrans = new CashBLCashTransactionAdd();

	
	public CashUICashPaymentTransactionAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(540, 265);
            {
                lblCashTransType = new CLabel(this, SWT.NONE);
                lblCashTransType.setText(Messages.getString("CashUICashPaymentTransactionAdd.0"));  //$NON-NLS-1$
                GridData lblCashTransTypeLData = new GridData();
                lblCashTransType.setFont(SWTResourceManager.getFont("Tahoma", 14, 1, false, false)); //$NON-NLS-1$
                lblCashTransTypeLData.widthHint = 180;
                lblCashTransTypeLData.heightHint = 42;
                lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
                lblCashTransTypeLData.horizontalSpan = 2;
                lblCashTransTypeLData.grabExcessHorizontalSpace = true;
                lblCashTransType.setLayoutData(lblCashTransTypeLData);
            }
            {
                lblDocumentNo = new CLabel(this, SWT.NONE);
                lblDocumentNo.setText(Messages.getString("CashUICashCollectTransactionAdd.2")); //$NON-NLS-1$
            }
            {
                txtDocumentNo = new Text(this, SWT.NONE);
                GridData txtDocumentNoLData = new GridData();
                txtDocumentNo.setSize(166, 19);
                txtDocumentNoLData.widthHint = 166;
                txtDocumentNoLData.heightHint = 19;
                txtDocumentNo.setLayoutData(txtDocumentNoLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText(Messages.getString("CashUICashCollectTransactionAdd.3")); //$NON-NLS-1$
            }
            {
                datePicker = new DatePicker(this, SWT.NONE);
                GridData datePickerLData = new GridData();
                datePickerLData.widthHint = 128;
                datePickerLData.heightHint = 23;
                datePicker.setLayoutData(datePickerLData);
            }
            {
                lblCashCard = new CLabel(this, SWT.NONE);
                lblCashCard.setText(Messages.getString("CashUICashCollectTransactionAdd.4")); //$NON-NLS-1$
            }
            {
                txtCashCard = new Text(this, SWT.NONE);
                GridData txtCashCardLData = new GridData();
                txtCashCardLData.widthHint = 164;
                txtCashCardLData.heightHint = 19;
                txtCashCard
				.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent evt) {
					try {
						txtCashCard
							.setData(EngBLCashCards
								.getCard(txtCashCard
									.getText().trim()));
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
				});
               

                txtCashCard.setLayoutData(txtCashCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText(Messages.getString("CashUICashCollectTransactionAdd.5")); //$NON-NLS-1$
            }
            {
                txtCurrentAccount = new Text(this, SWT.NONE);
                GridData txtCurrentAccountLData = new GridData();
                txtCurrentAccountLData.widthHint = 164;
                txtCurrentAccountLData.heightHint = 18;
                txtCurrentAccount.setLayoutData(txtCurrentAccountLData);
                txtCurrentAccount
				.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent evt) {
					try {
						txtCurrentAccount
							.setData(EngBLCurrentCards
								.getCards(txtCurrentAccount
									.getText().trim()));
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
				});
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
                curTextTotalAmountLData.widthHint = 165;
                curTextTotalAmountLData.heightHint = 19;
                curTextTotalAmount.setLayoutData(curTextTotalAmountLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText(Messages.getString("CashUICashCollectTransactionAdd.7")); //$NON-NLS-1$
            }
            {
                txtDefinition = new Text(this, SWT.NONE);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 359;
                txtDefinitionLData.heightHint = 18;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    
//	  content assistant
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(
				txtCurrentAccount);
		final TurquazContentAssistant assistant = new TurquazContentAssistant(
				adapter, EngBLCommon.CONTENT_ASSIST_CURRENT);
		adapter.appendVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent event) {

				// Check for Ctrl+Spacebar
				if (event.stateMask == SWT.CTRL && event.character == ' ') {

					assistant.showPossibleCompletions();
					event.doit = false;

				}
			}
		});
		
		
			TextContentAssistSubjectAdapter adapter2 = new TextContentAssistSubjectAdapter(
					txtCashCard);
			final TurquazContentAssistant assistant2 = new TurquazContentAssistant(
					adapter2, EngBLCommon.CONTENT_ASSIST_CASH);
			adapter2.appendVerifyKeyListener(new VerifyKeyListener() {
				public void verifyKey(VerifyEvent event) {

					// Check for Ctrl+Spacebar
					if (event.stateMask == SWT.CTRL && event.character == ' ') {

						assistant2.showPossibleCompletions();
						event.doit = false;

					}
				}
			});
		    
	    
	    
	}

    public void newForm() {
        CashUICashPaymentTransactionAdd curCard = new  CashUICashPaymentTransactionAdd(this.getParent(),this.getStyle());
     	 CTabFolder tabfld = (CTabFolder)this.getParent();
     	 tabfld.getSelection().setControl(curCard);	 
     	 this.dispose();

    }
    
    public void save() {
        MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
       try{
           
           if(verifyFields()){
           
               
               blTrans.saveCurrentTransaction((TurqCashCard)txtCashCard.getData(),
                       						  (TurqCurrentCard)txtCurrentAccount.getData(),
                       						  EngBLCommon.CASH_CURRENT_PAYMENT,
                       						  null,
                       						  curTextTotalAmount.getBigDecimalValue(),
                       						  datePicker.getDate(),
                       						  txtDefinition.getText(),
                       						  txtDocumentNo.getText().trim()
                       						  );
               
               msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.1")); //$NON-NLS-1$
               msg.open();
               newForm();
                
           
           }
       }
       catch(Exception ex){
           ex.printStackTrace();
           msg.setMessage(ex.getMessage());
           msg.open();
       }

    }
    public boolean verifyFields(){
        MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
        if(txtCashCard.getData()==null){
            msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.2")); //$NON-NLS-1$
            msg.open();
            txtCashCard.setFocus();
           return false;
        }
        else if(txtCurrentAccount.getData()==null){
            msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.3")); //$NON-NLS-1$
            msg.open();
            txtCurrentAccount.setFocus();
            return false;
        }
        else if(curTextTotalAmount.getBigDecimalValue().equals(new BigDecimal(0))){
            msg.setMessage(Messages.getString("CashUICashPaymentTransactionAdd.4")); //$NON-NLS-1$
            msg.open();
            curTextTotalAmount.setFocus();
            return false;
        }
        return true;
    }
    
    public CurrencyText getCurTextTotalAmount() {
        return curTextTotalAmount;
    }
    public void setCurTextTotalAmount(CurrencyText curTextTotalAmount) {
        this.curTextTotalAmount = curTextTotalAmount;
    }
    public DatePicker getDatePicker() {
        return datePicker;
    }
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
    public Text getTxtCashCard() {
        return txtCashCard;
    }
    public void setTxtCashCard(Text txtCashCard) {
        this.txtCashCard = txtCashCard;
    }
    public Text getTxtCurrentAccount() {
        return txtCurrentAccount;
    }
    public void setTxtCurrentAccount(Text txtCurrentAccount) {
        this.txtCurrentAccount = txtCurrentAccount;
    }
    public Text getTxtDefinition() {
        return txtDefinition;
    }
    public void setTxtDefinition(Text txtDefinition) {
        this.txtDefinition = txtDefinition;
    }
    public Text getTxtDocumentNo() {
        return txtDocumentNo;
    }
    public void setTxtDocumentNo(Text txtDocumentNo) {
        this.txtDocumentNo = txtDocumentNo;
    }
}
