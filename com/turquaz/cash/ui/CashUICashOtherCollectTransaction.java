package com.turquaz.cash.ui;
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.cash.ui.comp.CashCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;

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
public class CashUICashOtherCollectTransaction extends org.eclipse.swt.widgets.Composite implements SecureComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private CLabel lblCashCard;
	private Text txtDefinition;
	private DatePicker datePicker;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CurrencyText curTextTotalAmount;
	private CLabel lblTotalAmount;
	private AccountPicker txtAccountingAccount;
	private CLabel lblCurrentCard;
	private CashCardPicker txtCashCard;
	CashBLCashTransactionAdd blTrans = new CashBLCashTransactionAdd();

	
	public CashUICashOtherCollectTransaction(org.eclipse.swt.widgets.Composite parent, int style) {
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
                txtCashCard = new CashCardPicker(this, SWT.NONE);
                GridData txtCashCardLData = new GridData();
                txtCashCardLData.widthHint = 167;
                txtCashCardLData.heightHint = 19;

                txtCashCard.setLayoutData(txtCashCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText("Kar\u015f\u0131 Muhasebe Hesab\u0131"); //$NON-NLS-1$
            }
            {
                txtAccountingAccount = new AccountPicker(this, SWT.NONE);
                GridData txtCurrentAccountLData = new GridData();
                txtCurrentAccountLData.widthHint = 167;
                txtCurrentAccountLData.heightHint = 18;
                txtAccountingAccount.setLayoutData(txtCurrentAccountLData);
      
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
	   
	    
	}

    public void newForm() {
        CashUICashOtherCollectTransaction curCard = new  CashUICashOtherCollectTransaction(this.getParent(),this.getStyle());
      	 CTabFolder tabfld = (CTabFolder)this.getParent();
      	 tabfld.getSelection().setControl(curCard);	 
      	 this.dispose();

    }
    
    public void save() {
        MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
       try{
           
           if(verifyFields()){
           
               
               blTrans.saveOtherTransaction((TurqCashCard)txtCashCard.getData(),
                       						  (TurqAccountingAccount)txtAccountingAccount.getData(),
                       						  EngBLCommon.CASH_OTHER_COLLECT,
                       						  null,
                       						  curTextTotalAmount.getBigDecimalValue(),
                       						  datePicker.getDate(),
                       						  txtDefinition.getText(),
                       						  txtDocumentNo.getText().trim()
                       						  );
               
               msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.1")); //$NON-NLS-1$
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
            msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.8")); //$NON-NLS-1$
            msg.open();
            txtCashCard.setFocus();
           return false;
        }
        else if(txtAccountingAccount.getData()==null){
            msg.setMessage(Messages.getString("CashUICashOtherCollectTransaction.0"));  //$NON-NLS-1$
            msg.open();
            txtAccountingAccount.setFocus();
            return false;
        }
        else if(curTextTotalAmount.getBigDecimalValue().equals(new BigDecimal(0))){
            msg.setMessage(Messages.getString("CashUICashCollectTransactionAdd.10")); //$NON-NLS-1$
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
    public CashCardPicker getTxtCashCard() {
        return txtCashCard;
    }
    public void setTxtCashCard(CashCardPicker txtCashCard) {
        this.txtCashCard = txtCashCard;
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
    
	/**
	 * @return Returns the txtAccountingAccount.
	 */
	public AccountPicker getTxtAccountingAccount() {
		return txtAccountingAccount;
	}
	/**
	 * @param txtAccountingAccount The txtAccountingAccount to set.
	 */
	public void setTxtAccountingAccount(AccountPicker txtAccountingAccount) {
		this.txtAccountingAccount = txtAccountingAccount;
	}
}