package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;

import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DecimalText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUITransactionAdd extends SecureComposite {
    
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
	
			this.setSize(new org.eclipse.swt.graphics.Point(529,214));
	
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCodeLData.widthHint = 102;
			lblCurrentCodeLData.heightHint = 16;
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			lblCurrentCode.setText("Current Code");
			lblCurrentCode.setSize(new org.eclipse.swt.graphics.Point(102,16));
	
			GridData comboCurrentCodeLData = new GridData();
			comboCurrentCodeLData.widthHint = 207;
			comboCurrentCodeLData.heightHint = 20;
			comboCurrentCode.setLayoutData(comboCurrentCodeLData);
			comboCurrentCode.setText("Choose Current Code");
			comboCurrentCode.setSize(new org.eclipse.swt.graphics.Point(207,20));
	
			lblDocumentNo.setText("Document No");
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.widthHint = 220;
			txtDocumentNoLData.heightHint = 20;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(220,20));
	
			comboType.setText("Debit / Credit");
	
			GridData comboTransTypeLData = new GridData();
			comboTransTypeLData.widthHint = 67;
			comboTransTypeLData.heightHint = 19;
			comboTransType.setLayoutData(comboTransTypeLData);
			comboTransType.setText("Debit");
			comboTransType.setSize(new org.eclipse.swt.graphics.Point(67,19));
	
			GridData lblAmountLData = new GridData();
			lblAmountLData.widthHint = 88;
			lblAmountLData.heightHint = 21;
			lblAmount.setLayoutData(lblAmountLData);
			lblAmount.setText("Amount");
			lblAmount.setSize(new org.eclipse.swt.graphics.Point(88,21));
	
			GridData decTxtAmountLData = new GridData();
			decTxtAmountLData.widthHint = 217;
			decTxtAmountLData.heightHint = 19;
			decTxtAmount.setLayoutData(decTxtAmountLData);
			decTxtAmount.setText("decimalText1");
			decTxtAmount.setSize(new org.eclipse.swt.graphics.Point(217,19));
	
			GridData lblTransDateLData = new GridData();
			lblTransDateLData.widthHint = 100;
			lblTransDateLData.heightHint = 19;
			lblTransDate.setLayoutData(lblTransDateLData);
			lblTransDate.setText("Transaction Date");
			lblTransDate.setSize(new org.eclipse.swt.graphics.Point(100,19));
	
			GridData dateTransDateLData = new GridData();
			dateTransDateLData.widthHint = 152;
			dateTransDateLData.heightHint = 25;
			dateTransDate.setLayoutData(dateTransDateLData);
			dateTransDate.setSize(new org.eclipse.swt.graphics.Point(152,25));
			dateTransDate.layout();
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
									  dept,credit,new BigDecimal(0),4);
	
	
	
	
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
