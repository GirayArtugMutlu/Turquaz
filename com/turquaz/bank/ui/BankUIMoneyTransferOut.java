package com.turquaz.bank.ui;
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

import com.turquaz.bank.ui.comp.BankCardPicker;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
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
public class BankUIMoneyTransferOut extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private CLabel lblBankCard;
	private Text txtDefinition;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private DatePicker datePick;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private CurrentPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;



	public BankUIMoneyTransferOut(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(458, 261);
            {
                lblDocNo = new CLabel(this, SWT.NONE);
                lblDocNo.setText(Messages.getString("BankUIMoneyTransferOut.5")); //$NON-NLS-1$
            }
            {
                txtDocNo = new Text(this, SWT.NONE);
                GridData txtDocNoLData = new GridData();
                txtDocNoLData.widthHint = 190;
                txtDocNoLData.heightHint = 16;
                txtDocNo.setLayoutData(txtDocNoLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText(Messages.getString("BankUIMoneyTransferOut.0")); //$NON-NLS-1$
            }
            {
                datePick = new DatePicker(this, SWT.NONE);
                GridData datePickLData = new GridData();
                datePickLData.widthHint = 110;
                datePickLData.heightHint = 18;
                datePick.setLayoutData(datePickLData);
            }
            {
            	{
            	}
                lblBankCard = new CLabel(this, SWT.NONE);
                lblBankCard.setText(Messages.getString("BankUIMoneyTransferOut.1")); //$NON-NLS-1$
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
                lblCurrentCard.setText(Messages.getString("BankUIMoneyTransferOut.2")); //$NON-NLS-1$
            }
            {
                currentPicker = new CurrentPicker(this, SWT.NONE);
                GridData currentPickerLData = new GridData();
                currentPickerLData.widthHint = 197;
                currentPickerLData.heightHint = 20;
                currentPicker.setLayoutData(currentPickerLData);
            }
            {
                lblAmount = new CLabel(this, SWT.NONE);
                lblAmount.setText(Messages.getString("BankUIMoneyTransferOut.3")); //$NON-NLS-1$
            }
            {
                curAmount = new CurrencyText(this, SWT.NONE);
                GridData curAmountLData = new GridData();
                curAmountLData.widthHint = 191;
                curAmountLData.heightHint = 18;
                curAmount.setLayoutData(curAmountLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText(Messages.getString("BankUIMoneyTransferOut.4")); //$NON-NLS-1$
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
	
    public void newForm() {
        BankUIMoneyTransferOut curCard = new BankUIMoneyTransferOut(this.getParent(),this.getStyle());
      	 CTabFolder tabfld = (CTabFolder)this.getParent();
      	 tabfld.getSelection().setControl(curCard);	 
      	 this.dispose();

    }
    public boolean verifyFields()
    {
        if(txtBankCard.getData()==null){
           EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferOut.6"),SWT.ICON_WARNING); //$NON-NLS-1$
           txtBankCard.setFocus();
           return false;
            
        }
        if(currentPicker.getData()==null){
            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferOut.7"),SWT.ICON_WARNING); //$NON-NLS-1$
            currentPicker.setFocus();
            return false;
             
         }
        if(curAmount.getBigDecimalValue().compareTo(new BigDecimal(0))!=1)
        {
            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferOut.8"),SWT.ICON_WARNING); //$NON-NLS-1$
             curAmount.setFocus();
            return false;
            
        }
        return true;
        
    }
    
    public void save() {
        try
        {
            if(verifyFields())
            {
                BankBLTransactionAdd.saveTransaction((TurqBanksCard)txtBankCard.getData(),
                        							   (TurqCurrentCard)currentPicker.getData(),
                        							   EngBLCommon.BANK_TRANS_SEND_MONEY,
                        							   null,
                        							   curAmount.getBigDecimalValue(),
                        							  datePick.getDate(),
                        							  txtDefinition.getText(),
                        							  txtDocNo.getText()
                        							  );
                EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIMoneyTransferOut.9"),SWT.ICON_INFORMATION); //$NON-NLS-1$
                newForm();
            }         
            
        }
        catch(Exception ex)
        {
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
    public CurrentPicker getCurrentPicker() {
        return currentPicker;
    }
    public void setCurrentPicker(CurrentPicker currentPicker) {
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