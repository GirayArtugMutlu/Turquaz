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


import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;


import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.VerifyEvent;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;


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
public class CurUITransactionAdd extends Composite implements SecureComposite{
    
	private AccountPicker accPickerCashAccount;
	private CLabel lblCashAccount;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateTransDate;
	private CLabel lblTransDate;
	private CurrencyText decTxtAmount;
	private CLabel lblAmount;
	private CCombo comboTransType;
	private CLabel comboType;
	private Text txtCurrentCode;
	private CLabel lblCurrentCode;
    private CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	public CurUITransactionAdd(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			
			
			{
				lblCurrentCode = new CLabel(this, SWT.NONE);
				GridData lblCurrentCodeLData = new GridData();
				lblCurrentCodeLData.widthHint = 102;
				lblCurrentCodeLData.heightHint = 16;
				lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				lblCurrentCode.setText(Messages.getString("CurUITransactionAdd.0")); //$NON-NLS-1$
				lblCurrentCode.setSize(new org.eclipse.swt.graphics.Point(
					102,
					16));
			}
			{
				txtCurrentCode = new Text(this, SWT.NONE);
				GridData comboCurrentCodeLData = new GridData();
                txtCurrentCode.addModifyListener(new ModifyListener() {
                    public void modifyText(ModifyEvent evt) {
                        try {
							txtCurrentCode
								.setData(EngBLCurrentCards
									.getCards(txtCurrentCode
										.getText().trim()));
							
                        } catch (Exception ex) {
							ex.printStackTrace();
						}
                   }
                });
				txtCurrentCode.setSize(235, 20);
				comboCurrentCodeLData.widthHint = 235;
				comboCurrentCodeLData.heightHint = 20;
				txtCurrentCode.setLayoutData(comboCurrentCodeLData);
			}
			lblDocumentNo = new CLabel(this,SWT.NULL);
			txtDocumentNo = new Text(this,SWT.NULL);
			comboType = new CLabel(this,SWT.NULL);
			comboTransType = new CCombo(this,SWT.NULL);
			lblAmount = new CLabel(this,SWT.NULL);
			decTxtAmount = new CurrencyText(this,SWT.NULL);
			lblTransDate = new CLabel(this,SWT.NULL);
			dateTransDate = new DatePicker(this,SWT.NULL);
			lblCashAccount = new CLabel(this,SWT.NULL);
			accPickerCashAccount = new AccountPicker(this, SWT.NONE);
	
			this.setSize(476, 357);

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
			lblDocumentNo.setText(Messages.getString("CurUITransactionAdd.2")); //$NON-NLS-1$
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.widthHint = 235;
			txtDocumentNoLData.heightHint = 20;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(235, 20);
	
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
			comboType.setText(Messages.getString("CurUITransactionAdd.3")); //$NON-NLS-1$
			comboType.setSize(new org.eclipse.swt.graphics.Point(138,17));
	
			GridData comboTransTypeLData = new GridData();
			comboTransTypeLData.verticalAlignment = GridData.CENTER;
			comboTransTypeLData.horizontalAlignment = GridData.BEGINNING;
			comboTransTypeLData.widthHint = 200;
			comboTransTypeLData.heightHint = 19;
			comboTransTypeLData.horizontalIndent = 0;
			comboTransTypeLData.horizontalSpan = 1;
			comboTransTypeLData.verticalSpan = 1;
			comboTransTypeLData.grabExcessHorizontalSpace = false;
			comboTransTypeLData.grabExcessVerticalSpace = false;
			comboTransType.setLayoutData(comboTransTypeLData);
			comboTransType.setText(Messages.getString("CurUITransactionAdd.4")); //$NON-NLS-1$
			comboTransType.setSize(new org.eclipse.swt.graphics.Point(200,19));
	
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
			lblAmount.setText(Messages.getString("CurUITransactionAdd.5")); //$NON-NLS-1$
			lblAmount.setSize(new org.eclipse.swt.graphics.Point(88,21));
	
			GridData decTxtAmountLData = new GridData();
			decTxtAmount.setTextLimit(26);
			decTxtAmountLData.widthHint = 235;
			decTxtAmountLData.heightHint = 20;
			decTxtAmount.setLayoutData(decTxtAmountLData);
			decTxtAmount.setText(new BigDecimal(0)); 
			decTxtAmount.setSize(235, 20);
	
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
			lblTransDate.setText(Messages.getString("CurUITransactionAdd.7")); //$NON-NLS-1$
			lblTransDate.setSize(new org.eclipse.swt.graphics.Point(100,19));
	
			GridData dateTransDateLData = new GridData();
			dateTransDateLData.verticalAlignment = GridData.CENTER;
			dateTransDateLData.horizontalAlignment = GridData.BEGINNING;
			dateTransDateLData.widthHint = 152;
			dateTransDateLData.heightHint = 24;
			dateTransDateLData.horizontalIndent = 0;
			dateTransDateLData.horizontalSpan = 1;
			dateTransDateLData.verticalSpan = 1;
			dateTransDateLData.grabExcessHorizontalSpace = false;
			dateTransDateLData.grabExcessVerticalSpace = false;
			dateTransDate.setLayoutData(dateTransDateLData);
			dateTransDate.setSize(new org.eclipse.swt.graphics.Point(152,24));
			dateTransDate.layout();
	
			GridData lblCashAccountLData = new GridData();
			lblCashAccountLData.widthHint = 88;
			lblCashAccountLData.heightHint = 19;
			lblCashAccount.setLayoutData(lblCashAccountLData);
			lblCashAccount.setText(Messages.getString("CurUITransactionAdd.8")); //$NON-NLS-1$

			GridData accPickerCashAccountLData = new GridData();
			accPickerCashAccountLData.widthHint = 241;
			accPickerCashAccountLData.heightHint = 20;
			accPickerCashAccount.setLayoutData(accPickerCashAccountLData);
			accPickerCashAccount.setSize(new org.eclipse.swt.graphics.Point(241,20));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	comboTransType.add(Messages.getString("CurUITransactionAdd.4")); //$NON-NLS-1$
	comboTransType.add(Messages.getString("CurUITransactionAdd.10")); //$NON-NLS-1$
//	content assistant
	TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(txtCurrentCode);
	final TurquazContentAssistant assistant = new TurquazContentAssistant(adapter,3);
	adapter.appendVerifyKeyListener( new VerifyKeyListener() {
                 public void verifyKey(VerifyEvent event) {

                 // Check for Ctrl+Spacebar
                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
             
                  assistant.showPossibleCompletions();    
                   event.doit = false;

                 }
              }
	});
	
	}
	

	
	 public boolean verifyFields(){
	 
	 MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	if(txtCurrentCode.getData()==null){
	
	msg.setMessage(Messages.getString("CurUITransactionAdd.12")); //$NON-NLS-1$
    msg.open();	
    txtCurrentCode.setFocus();
	
	return false;
	}
	else if(dateTransDate.getData()==null){
	msg.setMessage(Messages.getString("CurUITransactionAdd.13")); //$NON-NLS-1$
    msg.open();	
    dateTransDate.setFocus();
	return false;
	}
	else if(decTxtAmount.getText().equals("")){ //$NON-NLS-1$
	msg.setMessage(Messages.getString("CurUITransactionAdd.15")); //$NON-NLS-1$
    msg.open();	
    decTxtAmount.setFocus();
	return false;
	}
	else if (accPickerCashAccount.getData()==null){
	msg.setMessage(Messages.getString("CurUITransactionAdd.16")); //$NON-NLS-1$
    msg.open();	
    accPickerCashAccount.setFocus();
	return false;
	}
	
	return true;
	
	
	
	

	}
	public void save(){
	try{
	if(verifyFields()){
	
	boolean isCredit =false;
	if(comboTransType.getText().equals(Messages.getString("CurUITransactionAdd.4"))){ //$NON-NLS-1$
		isCredit =false;
	}
	else if(comboTransType.getText().equals(Messages.getString("CurUITransactionAdd.10"))){ //$NON-NLS-1$
		isCredit =true;
	
	}
	
	//Transaction Type is Cash 
	//4,at the end means cash, it is a cash Transaction 
	blTransAdd.saveCurrentCashTransaction((TurqCurrentCard)txtCurrentCode.getData(),
									  dateTransDate.getDate(),txtDocumentNo.getText().trim(),isCredit,
									  decTxtAmount.getBigDecimalValue(),new BigDecimal(0),4,(TurqAccountingAccount)accPickerCashAccount.getData());
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	msg.setMessage(Messages.getString("CurUITransactionAdd.19")); //$NON-NLS-1$
    msg.open();	
	newForm();
	}
	
	
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(ex.getMessage());
	msg.open();
	}
		
	}
	public void delete(){
	
	}
	
	public void search(){
	
	}
	
	public void newForm(){
		
	    CurUITransactionAdd  curCard = new CurUITransactionAdd(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();
		
	
	}
	
	
	/**
	 * @return Returns the accPickerCashAccount.
	 */
	public AccountPicker getAccPickerCashAccount() {
		return accPickerCashAccount;
	}
	/**
	 * @param accPickerCashAccount The accPickerCashAccount to set.
	 */
	public void setAccPickerCashAccount(
			AccountPicker accPickerCashAccount) {
		this.accPickerCashAccount = accPickerCashAccount;
	}
	/**
	 * @return Returns the txtCurrentCode.
	 */
	public Text getTxtCurrentCode() {
		return txtCurrentCode;
	}
	/**
	 * @param txtCurrentCode The txtCurrentCode to set.
	 */
	public void setTxtCurrentCode(Text comboCurrentCode) {
		this.txtCurrentCode = comboCurrentCode;
	}
	/**
	 * @return Returns the comboTransType.
	 */
	public CCombo getComboTransType() {
		return comboTransType;
	}
	/**
	 * @param comboTransType The comboTransType to set.
	 */
	public void setComboTransType(CCombo comboTransType) {
		this.comboTransType = comboTransType;
	}
	/**
	 * @return Returns the dateTransDate.
	 */
	public DatePicker getDateTransDate() {
		return dateTransDate;
	}
	/**
	 * @param dateTransDate The dateTransDate to set.
	 */
	public void setDateTransDate(DatePicker dateTransDate) {
		this.dateTransDate = dateTransDate;
	}
	/**
	 * @return Returns the comboType.
	 */
	public CLabel getComboType() {
		return comboType;
	}
	/**
	 * @param comboType The comboType to set.
	 */
	public void setComboType(CLabel comboType) {
		this.comboType = comboType;
	}
	/**
	 * @return Returns the decTxtAmount.
	 */
	public CurrencyText getDecTxtAmount() {
		return decTxtAmount;
	}
	/**
	 * @param decTxtAmount The decTxtAmount to set.
	 */
	public void setDecTxtAmount(CurrencyText decTxtAmount) {
		this.decTxtAmount = decTxtAmount;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	/**
	 * @param txtDocumentNo The txtDocumentNo to set.
	 */
	public void setTxtDocumentNo(Text txtDocumentNo) {
		this.txtDocumentNo = txtDocumentNo;
	}
}
