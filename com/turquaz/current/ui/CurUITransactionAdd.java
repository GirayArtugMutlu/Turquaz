package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DecimalText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUITransactionAdd extends SecureComposite {
    
	private AccountPicker accPickerCashAccount;
	private CLabel lblCashAccount;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateTransDate;
	private CLabel lblTransDate;
	private DecimalText decTxtAmount;
	private CLabel lblAmount;
	private CCombo comboTransType;
	private CLabel comboType;
	private CCombo comboCurrentCode;
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
	
			lblCurrentCode = new CLabel(this,SWT.NULL);
			comboCurrentCode = new CCombo(this,SWT.NULL);
			lblDocumentNo = new CLabel(this,SWT.NULL);
			txtDocumentNo = new Text(this,SWT.NULL);
			comboType = new CLabel(this,SWT.NULL);
			comboTransType = new CCombo(this,SWT.NULL);
			lblAmount = new CLabel(this,SWT.NULL);
			decTxtAmount = new DecimalText(this,SWT.NULL);
			lblTransDate = new CLabel(this,SWT.NULL);
			dateTransDate = new DatePicker(this,SWT.NULL);
			lblCashAccount = new CLabel(this,SWT.NULL);
			accPickerCashAccount = new AccountPicker(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(539,242));
	
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCodeLData.verticalAlignment = GridData.CENTER;
			lblCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentCodeLData.widthHint = 102;
			lblCurrentCodeLData.heightHint = 16;
			lblCurrentCodeLData.horizontalIndent = 0;
			lblCurrentCodeLData.horizontalSpan = 1;
			lblCurrentCodeLData.verticalSpan = 1;
			lblCurrentCodeLData.grabExcessHorizontalSpace = false;
			lblCurrentCodeLData.grabExcessVerticalSpace = false;
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			lblCurrentCode.setText("Current Code");
			lblCurrentCode.setSize(new org.eclipse.swt.graphics.Point(102,16));
	
			GridData comboCurrentCodeLData = new GridData();
			comboCurrentCodeLData.verticalAlignment = GridData.CENTER;
			comboCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			comboCurrentCodeLData.widthHint = 207;
			comboCurrentCodeLData.heightHint = 20;
			comboCurrentCodeLData.horizontalIndent = 0;
			comboCurrentCodeLData.horizontalSpan = 1;
			comboCurrentCodeLData.verticalSpan = 1;
			comboCurrentCodeLData.grabExcessHorizontalSpace = false;
			comboCurrentCodeLData.grabExcessVerticalSpace = false;
			comboCurrentCode.setLayoutData(comboCurrentCodeLData);
			comboCurrentCode.setText("Choose Current Code");
			comboCurrentCode.setSize(new org.eclipse.swt.graphics.Point(207,20));
	
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
			lblDocumentNo.setText("Document No");
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.verticalAlignment = GridData.CENTER;
			txtDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			txtDocumentNoLData.widthHint = 220;
			txtDocumentNoLData.heightHint = 20;
			txtDocumentNoLData.horizontalIndent = 0;
			txtDocumentNoLData.horizontalSpan = 1;
			txtDocumentNoLData.verticalSpan = 1;
			txtDocumentNoLData.grabExcessHorizontalSpace = false;
			txtDocumentNoLData.grabExcessVerticalSpace = false;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(220,20));
	
			GridData comboTypeLData = new GridData();
			comboTypeLData.verticalAlignment = GridData.CENTER;
			comboTypeLData.horizontalAlignment = GridData.BEGINNING;
			comboTypeLData.widthHint = -1;
			comboTypeLData.heightHint = -1;
			comboTypeLData.horizontalIndent = 0;
			comboTypeLData.horizontalSpan = 1;
			comboTypeLData.verticalSpan = 1;
			comboTypeLData.grabExcessHorizontalSpace = false;
			comboTypeLData.grabExcessVerticalSpace = false;
			comboType.setLayoutData(comboTypeLData);
			comboType.setText("Debit / Credit");
	
			GridData comboTransTypeLData = new GridData();
			comboTransTypeLData.verticalAlignment = GridData.CENTER;
			comboTransTypeLData.horizontalAlignment = GridData.BEGINNING;
			comboTransTypeLData.widthHint = 67;
			comboTransTypeLData.heightHint = 19;
			comboTransTypeLData.horizontalIndent = 0;
			comboTransTypeLData.horizontalSpan = 1;
			comboTransTypeLData.verticalSpan = 1;
			comboTransTypeLData.grabExcessHorizontalSpace = false;
			comboTransTypeLData.grabExcessVerticalSpace = false;
			comboTransType.setLayoutData(comboTransTypeLData);
			comboTransType.setText("Debit");
			comboTransType.setSize(new org.eclipse.swt.graphics.Point(67,19));
	
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
			lblAmount.setText("Amount");
			lblAmount.setSize(new org.eclipse.swt.graphics.Point(88,21));
	
			GridData decTxtAmountLData = new GridData();
			decTxtAmountLData.verticalAlignment = GridData.CENTER;
			decTxtAmountLData.horizontalAlignment = GridData.BEGINNING;
			decTxtAmountLData.widthHint = 217;
			decTxtAmountLData.heightHint = 19;
			decTxtAmountLData.horizontalIndent = 0;
			decTxtAmountLData.horizontalSpan = 1;
			decTxtAmountLData.verticalSpan = 1;
			decTxtAmountLData.grabExcessHorizontalSpace = false;
			decTxtAmountLData.grabExcessVerticalSpace = false;
			decTxtAmount.setLayoutData(decTxtAmountLData);
			decTxtAmount.setText("decimalText1");
			decTxtAmount.setSize(new org.eclipse.swt.graphics.Point(217,19));
	
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
			lblTransDate.setText("Transaction Date");
			lblTransDate.setSize(new org.eclipse.swt.graphics.Point(100,19));
	
			GridData dateTransDateLData = new GridData();
			dateTransDateLData.verticalAlignment = GridData.CENTER;
			dateTransDateLData.horizontalAlignment = GridData.BEGINNING;
			dateTransDateLData.widthHint = 152;
			dateTransDateLData.heightHint = 25;
			dateTransDateLData.horizontalIndent = 0;
			dateTransDateLData.horizontalSpan = 1;
			dateTransDateLData.verticalSpan = 1;
			dateTransDateLData.grabExcessHorizontalSpace = false;
			dateTransDateLData.grabExcessVerticalSpace = false;
			dateTransDate.setLayoutData(dateTransDateLData);
			dateTransDate.setSize(new org.eclipse.swt.graphics.Point(152,25));
			dateTransDate.layout();
	
			GridData lblCashAccountLData = new GridData();
			lblCashAccountLData.widthHint = 72;
			lblCashAccountLData.heightHint = 19;
			lblCashAccount.setLayoutData(lblCashAccountLData);
			lblCashAccount.setText("Cash Account");
			lblCashAccount.setSize(new org.eclipse.swt.graphics.Point(72,19));
	
			GridData accPickerCashAccountLData = new GridData();
			accPickerCashAccountLData.verticalAlignment = GridData.CENTER;
			accPickerCashAccountLData.horizontalAlignment = GridData.BEGINNING;
			accPickerCashAccountLData.widthHint = 241;
			accPickerCashAccountLData.heightHint = 19;
			accPickerCashAccountLData.horizontalIndent = 0;
			accPickerCashAccountLData.horizontalSpan = 1;
			accPickerCashAccountLData.verticalSpan = 1;
			accPickerCashAccountLData.grabExcessHorizontalSpace = false;
			accPickerCashAccountLData.grabExcessVerticalSpace = false;
			accPickerCashAccount.setLayoutData(accPickerCashAccountLData);
			accPickerCashAccount.setSize(new org.eclipse.swt.graphics.Point(241,19));
			accPickerCashAccount.layout();
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
	comboTransType.add("Debit");
	comboTransType.add("Credit");
	accPickerCashAccount.setFilter("100");
	fillComboCurrentCodes();
	
	}
	
	
	
	public void fillComboCurrentCodes(){
	try{
	List list = blTransAdd.getCurrentCards();
	TurqCurrentCard curCard ;	
	for(int i =0;i<list.size();i++){

	curCard = (TurqCurrentCard)list.get(i);
	comboCurrentCode.add(curCard.getCardsCurrentCode());
	comboCurrentCode.setData(curCard.getCardsCurrentCode(),curCard);	
	
	}
	
	
	
	
	
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(ex.getMessage());
	msg.open();
	}
	
	
	}
	
	
	public boolean verifyFields(){
	 return true;

	}
	public void save(){
	try{
	if(verifyFields()){
	BigDecimal dept = new BigDecimal(0);
	BigDecimal credit = new BigDecimal(0);
	
	if(comboTransType.getText().equals("Debit")){
	dept = decTxtAmount.getBigDecimalValue();
	}
	else if(comboTransType.getText().equals("Credit")){
	credit = decTxtAmount.getBigDecimalValue();
	
	}
	
	//Transaction Type is Cash 
	//4,at the end means cash, it is a cash Transaction 
	blTransAdd.saveCurrentTransaction((TurqCurrentCard)comboCurrentCode.getData(comboCurrentCode.getText()),
									  dateTransDate.getDate(),txtDocumentNo.getText().trim(),
									  dept,credit,new BigDecimal(0),4,(TurqAccountingAccount)accPickerCashAccount.getData());
	
	
	
	
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
	
	}
	
	
}
