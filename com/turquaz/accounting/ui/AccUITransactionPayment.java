package com.turquaz.accounting.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.SWT;

/**
*		Tahsil Fisi 
*/
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/

public class AccUITransactionPayment extends SecureComposite {

	private CCombo comboCreditor;
	private CLabel lblCreditor;
	private TableColumn tableColumnDeptAmount;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private Table tableTransactionRows;
	private Button btnRemoveTransactionRow;
	private Button btnAddTransactionRow;
	private Composite composite2;
	private DatePicker datePickerTransactionDate;
	private CLabel lblDate;
	private Text txtDocumentNo;
	private CLabel lbldocumentNo;
	private AccBLTransactionAdd blTransAdd= new AccBLTransactionAdd();
	private BigDecimal totalCredit;
	public AccUITransactionPayment(Composite parent, int style) {
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
	
			lbldocumentNo = new CLabel(this,SWT.NULL);
			txtDocumentNo = new Text(this,SWT.NULL);
			lblDate = new CLabel(this,SWT.NULL);
			datePickerTransactionDate = new DatePicker(this,SWT.NULL);
			lblCreditor = new CLabel(this,SWT.NULL);
			comboCreditor = new CCombo(this,SWT.NULL);
			composite2 = new Composite(this,SWT.NULL);
			btnAddTransactionRow = new Button(composite2,SWT.PUSH| SWT.CENTER);
			btnRemoveTransactionRow = new Button(composite2,SWT.PUSH| SWT.CENTER);
			tableTransactionRows = new Table(this,SWT.FULL_SELECTION| SWT.BORDER);
			tableColumnAccountCode = new TableColumn(tableTransactionRows,SWT.NULL);
			tableColumnAccountName = new TableColumn(tableTransactionRows,SWT.NULL);
			tableColumnDeptAmount = new TableColumn(tableTransactionRows,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(520,452));
	
			GridData lbldocumentNoLData = new GridData();
			lbldocumentNoLData.verticalAlignment = GridData.CENTER;
			lbldocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			lbldocumentNoLData.widthHint = 93;
			lbldocumentNoLData.heightHint = 18;
			lbldocumentNoLData.horizontalIndent = 0;
			lbldocumentNoLData.horizontalSpan = 1;
			lbldocumentNoLData.verticalSpan = 1;
			lbldocumentNoLData.grabExcessHorizontalSpace = false;
			lbldocumentNoLData.grabExcessVerticalSpace = false;
			lbldocumentNo.setLayoutData(lbldocumentNoLData);
			lbldocumentNo.setText("Document No");
			lbldocumentNo.setSize(new org.eclipse.swt.graphics.Point(93,18));
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.verticalAlignment = GridData.CENTER;
			txtDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			txtDocumentNoLData.widthHint = 155;
			txtDocumentNoLData.heightHint = 19;
			txtDocumentNoLData.horizontalIndent = 0;
			txtDocumentNoLData.horizontalSpan = 1;
			txtDocumentNoLData.verticalSpan = 1;
			txtDocumentNoLData.grabExcessHorizontalSpace = false;
			txtDocumentNoLData.grabExcessVerticalSpace = false;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(155,19));
	
			GridData lblDateLData = new GridData();
			lblDateLData.verticalAlignment = GridData.CENTER;
			lblDateLData.horizontalAlignment = GridData.BEGINNING;
			lblDateLData.widthHint = 49;
			lblDateLData.heightHint = 19;
			lblDateLData.horizontalIndent = 0;
			lblDateLData.horizontalSpan = 1;
			lblDateLData.verticalSpan = 1;
			lblDateLData.grabExcessHorizontalSpace = false;
			lblDateLData.grabExcessVerticalSpace = false;
			lblDate.setLayoutData(lblDateLData);
			lblDate.setText("Date");
			lblDate.setSize(new org.eclipse.swt.graphics.Point(49,19));
	
			GridData datePickerTransactionDateLData = new GridData();
			datePickerTransactionDateLData.verticalAlignment = GridData.CENTER;
			datePickerTransactionDateLData.horizontalAlignment = GridData.BEGINNING;
			datePickerTransactionDateLData.widthHint = 157;
			datePickerTransactionDateLData.heightHint = 25;
			datePickerTransactionDateLData.horizontalIndent = 0;
			datePickerTransactionDateLData.horizontalSpan = 1;
			datePickerTransactionDateLData.verticalSpan = 1;
			datePickerTransactionDateLData.grabExcessHorizontalSpace = false;
			datePickerTransactionDateLData.grabExcessVerticalSpace = false;
			datePickerTransactionDate.setLayoutData(datePickerTransactionDateLData);
			datePickerTransactionDate.setSize(new org.eclipse.swt.graphics.Point(157,25));
			datePickerTransactionDate.layout();
	
			GridData lblCreditorLData = new GridData();
			lblCreditorLData.verticalAlignment = GridData.CENTER;
			lblCreditorLData.horizontalAlignment = GridData.BEGINNING;
			lblCreditorLData.widthHint = 70;
			lblCreditorLData.heightHint = 15;
			lblCreditorLData.horizontalIndent = 0;
			lblCreditorLData.horizontalSpan = 1;
			lblCreditorLData.verticalSpan = 1;
			lblCreditorLData.grabExcessHorizontalSpace = false;
			lblCreditorLData.grabExcessVerticalSpace = false;
			lblCreditor.setLayoutData(lblCreditorLData);
			lblCreditor.setText("Creditor");
			lblCreditor.setSize(new org.eclipse.swt.graphics.Point(70,15));
	
			GridData comboCreditorLData = new GridData();
			comboCreditorLData.verticalAlignment = GridData.CENTER;
			comboCreditorLData.horizontalAlignment = GridData.BEGINNING;
			comboCreditorLData.widthHint = 136;
			comboCreditorLData.heightHint = 16;
			comboCreditorLData.horizontalIndent = 0;
			comboCreditorLData.horizontalSpan = 1;
			comboCreditorLData.verticalSpan = 1;
			comboCreditorLData.grabExcessHorizontalSpace = false;
			comboCreditorLData.grabExcessVerticalSpace = false;
			comboCreditor.setLayoutData(comboCreditorLData);
			comboCreditor.setSize(new org.eclipse.swt.graphics.Point(136,16));
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.BEGINNING;
			composite2LData.horizontalAlignment = GridData.BEGINNING;
			composite2LData.widthHint = 70;
			composite2LData.heightHint = 72;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = false;
			composite2.setLayoutData(composite2LData);
			composite2.setSize(new org.eclipse.swt.graphics.Point(70,72));
	
			GridData btnAddTransactionRowLData = new GridData();
			btnAddTransactionRowLData.verticalAlignment = GridData.CENTER;
			btnAddTransactionRowLData.horizontalAlignment = GridData.CENTER;
			btnAddTransactionRowLData.widthHint = 26;
			btnAddTransactionRowLData.heightHint = 24;
			btnAddTransactionRowLData.horizontalIndent = 0;
			btnAddTransactionRowLData.horizontalSpan = 1;
			btnAddTransactionRowLData.verticalSpan = 1;
			btnAddTransactionRowLData.grabExcessHorizontalSpace = false;
			btnAddTransactionRowLData.grabExcessVerticalSpace = false;
			btnAddTransactionRow.setLayoutData(btnAddTransactionRowLData);
			final org.eclipse.swt.graphics.Image btnAddTransactionRowimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/plus.gif"));
			btnAddTransactionRowimage.setBackground(btnAddTransactionRow.getBackground());
			btnAddTransactionRow.setImage(btnAddTransactionRowimage);
			btnAddTransactionRow.setSize(new org.eclipse.swt.graphics.Point(26,24));
			btnAddTransactionRow.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnAddTransactionRowMouseUp(evt);
				}
			});
	
			GridData btnRemoveTransactionRowLData = new GridData();
			btnRemoveTransactionRowLData.verticalAlignment = GridData.CENTER;
			btnRemoveTransactionRowLData.horizontalAlignment = GridData.CENTER;
			btnRemoveTransactionRowLData.widthHint = -1;
			btnRemoveTransactionRowLData.heightHint = -1;
			btnRemoveTransactionRowLData.horizontalIndent = 0;
			btnRemoveTransactionRowLData.horizontalSpan = 1;
			btnRemoveTransactionRowLData.verticalSpan = 1;
			btnRemoveTransactionRowLData.grabExcessHorizontalSpace = false;
			btnRemoveTransactionRowLData.grabExcessVerticalSpace = false;
			btnRemoveTransactionRow.setLayoutData(btnRemoveTransactionRowLData);
			final org.eclipse.swt.graphics.Image btnRemoveTransactionRowimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/minus.gif"));
			btnRemoveTransactionRowimage.setBackground(btnRemoveTransactionRow.getBackground());
			btnRemoveTransactionRow.setImage(btnRemoveTransactionRowimage);
			btnRemoveTransactionRow.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnRemoveTransactionRowMouseUp(evt);
				}
			});
			GridLayout composite2Layout = new GridLayout(1, true);
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 5;
			composite2Layout.marginHeight = 5;
			composite2Layout.numColumns = 1;
			composite2Layout.makeColumnsEqualWidth = true;
			composite2Layout.horizontalSpacing = 5;
			composite2Layout.verticalSpacing = 5;
			composite2.layout();
	
			GridData tableTransactionRowsLData = new GridData();
			tableTransactionRowsLData.verticalAlignment = GridData.FILL;
			tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
			tableTransactionRowsLData.widthHint = -1;
			tableTransactionRowsLData.heightHint = -1;
			tableTransactionRowsLData.horizontalIndent = 0;
			tableTransactionRowsLData.horizontalSpan = 1;
			tableTransactionRowsLData.verticalSpan = 1;
			tableTransactionRowsLData.grabExcessHorizontalSpace = true;
			tableTransactionRowsLData.grabExcessVerticalSpace = true;
			tableTransactionRows.setLayoutData(tableTransactionRowsLData);
			tableTransactionRows.setHeaderVisible(true);
			tableTransactionRows.setLinesVisible(true);
			tableTransactionRows.setSize(new org.eclipse.swt.graphics.Point(392,347));
	
			tableColumnAccountCode.setText("Account Code");
			tableColumnAccountCode.setWidth(126);
	
			tableColumnAccountName.setText("Account Name");
			tableColumnAccountName.setWidth(150);
	
			tableColumnDeptAmount.setText("Dept");
			tableColumnDeptAmount.setWidth(100);
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					btnAddTransactionRowimage.dispose();
					btnRemoveTransactionRowimage.dispose();
				}
			});
	
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
	
	totalCredit = new BigDecimal(0);
	fillCombo();
	
	
	}
	
	public void fillCombo(){
	try{
	AccBLAccountAdd blaccountAdd = new AccBLAccountAdd();
	comboCreditor.setText("Choose Account");
	List accList = blaccountAdd.getAccount(-1,"100");
	TurqAccountingAccount account;
	for(int i=0;i<accList.size();i++){
	account = (TurqAccountingAccount)accList.get(i);
	comboCreditor.add(account.getAccountCode()+" "+account.getAccountName());
	comboCreditor.setData(account.getAccountCode()+" "+account.getAccountName(),account);
	addSecondaryAccountsToCombo(account.getAccountingAccountsId().intValue());	
	}
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
		
	}
	
	public void addSecondaryAccountsToCombo(int parentId){
	try{
	AccBLAccountAdd blaccountAdd = new AccBLAccountAdd();

	List accList = blaccountAdd.getAccount(parentId,"");
	TurqAccountingAccount account;
	for(int i=0;i<accList.size();i++){
	account = (TurqAccountingAccount)accList.get(i);
	comboCreditor.add(account.getAccountCode()+" "+account.getAccountName());
	comboCreditor.setData(account.getAccountCode()+" "+account.getAccountName(),account);
	addSecondaryAccountsToCombo(account.getAccountingAccountsId().intValue());	
	
	}
	}
	catch(Exception ex){
	
	ex.printStackTrace();
	
	}
	
	
	}
	
   public boolean verifyFields(){
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	

	
	if(tableTransactionRows.getItems().length==0){
	msg.setMessage("You hava to add rows to table!");
	
	msg.open();
	
	return false;
	
	}
	else if(datePickerTransactionDate.getData()==null){
	msg.setMessage("Please Enter Transaction Date");
	
	msg.open();
	
	return false;
	}
	else if(comboCreditor.getSelectionIndex()==-1){
	msg.setMessage("Please Choose Deptor Account");
	
	msg.open();
	
	return false;
	}
	else{
	return true;
	}
		
	}
	
	
	public void save(){
	
	if(verifyFields()){
	
	MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
	try{
	
	/**
	* 0 -Tahsil Fisi
	* 1- Tediye Fisi
	* 2- Mahsup Fisi	
	*
	**/
	Integer transId =blTransAdd.saveAccTransaction(datePickerTransactionDate.getDate(),txtDocumentNo.getText().trim(),1,1);
	
	saveTransactionRows(transId);
	msg.setMessage("Successfully saved!");
	msg.open();
	clearFields();
	}

	catch(Exception ex){
	ex.printStackTrace();
	msg.setMessage("An error occurred!");
	msg.open();
	
	}
	
	
	
	
	
	
	}
		
	}
	
		
	public void clearFields(){
    txtDocumentNo.setText("");
    tableTransactionRows.removeAll();
    
    }
    
	public void saveTransactionRows(Integer transId)throws Exception{
    try{
    
    calculateTotalCredit();
    TableItem items[] = tableTransactionRows.getItems();
    
    //First save the deptor Account
    TurqAccountingTransactionColumn transRow = new TurqAccountingTransactionColumn();
    transRow.setDeptAmount(new BigDecimal(0));
    transRow.setCreditAmount(totalCredit);
    transRow.setTurqAccountingAccount((TurqAccountingAccount)comboCreditor.getData(comboCreditor.getText()));
    blTransAdd.saveAccTransactionRow(transRow,transId);   
     
    //Save the table rows    
    for(int i=0; i<items.length;i++){
    blTransAdd.saveAccTransactionRow((TurqAccountingTransactionColumn)items[i].getData(),transId);
    
    }
    
    
    
    }
    catch(Exception ex){
    throw ex;
    
    }
    
    
    }
	
	public void search(){
	}
	public void newForm(){
	}
	public void delete(){
	}
	

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			AccUITransactionPayment inst = new AccUITransactionPayment(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,520,452);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void btnAddTransactionRowMouseUp(MouseEvent evt){
	//1 - Tediye Fisi
	Object o = new AccUITransactionRowAddDialog(this.getShell(),SWT.NULL,1).showDialog();
    
    if(o!=null){
    TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn)o;
    
    
    TableItem item = new TableItem(tableTransactionRows,SWT.NULL);    
	item.setData(accTransRow);
	item.setText(new String[]{accTransRow.getTurqAccountingAccount().getAccountCode(),
							 accTransRow.getTurqAccountingAccount().getAccountName(),
							 accTransRow.getDeptAmount().toString()});
	
	

	
	}
	
	}
    
    
	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt){
		TableItem selection[] = tableTransactionRows.getSelection();
		if(selection.length>0){
		selection[0].dispose();
		
		
		}
		
	}
	void calculateTotalCredit(){
	TableItem items[] = tableTransactionRows.getItems();
      totalCredit =new BigDecimal(0);
    
		for(int i=0; i<items.length;i++){
		
		totalCredit = totalCredit.add(new BigDecimal(items[i].getText(2)));
    
		}
   	
	}
	/**
	 * @return Returns the datePickerTransactionDate.
	 */
	public DatePicker getDatePickerTransactionDate() {
		return datePickerTransactionDate;
	}
	/**
	 * @return Returns the tableTransactionRows.
	 */
	public Table getTableTransactionRows() {
		return tableTransactionRows;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	/**
	 * @return Returns the comboCreditor.
	 */
	public CCombo getComboCreditor() {
		return comboCreditor;
	}
}
