package com.turquaz.accounting.ui;
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
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.accounting.Messages;
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
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
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

public class AccUITransactionCollect extends  Composite implements SecureComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private AccBLTransactionAdd blTransAdd= new AccBLTransactionAdd();
	private CLabel lblDate;
	private CCombo comboDeptor;
	private Composite composite2;
	private TableItem item;
	private TableColumn txtTransactionDefinition;
	private TableColumn tableColumnCreditAmount;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private Table tableTransactionRows;
	private Button btnRemoveTransactionRow;
	private Button btnAddTransactionRow;
	private Text txtTransDefinition;
	private CLabel lblTransDefinition;
	private CLabel lblDeptor;
	private Text txtDocumentNo;
	private CLabel lbldocumentNo;
	private DatePicker datePickerTransactionDate;
	private BigDecimal totalDept;
	public AccUITransactionCollect(Composite parent, int style) {
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

			this.setSize(new org.eclipse.swt.graphics.Point(520,452));


			
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lbldocumentNo = new CLabel(this, SWT.NONE);
				lbldocumentNo.setText(Messages
					.getString("AccUITransactionCollect.0")); //$NON-NLS-1$
				GridData lbldocumentNoLData = new GridData();
				lbldocumentNoLData.verticalAlignment = GridData.BEGINNING;
				lbldocumentNoLData.widthHint = 79;
				lbldocumentNoLData.heightHint = 19;
				lbldocumentNo.setLayoutData(lbldocumentNoLData);
			}
			{
				txtDocumentNo = new Text(this, SWT.NONE);
				txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(
					155,
					19));
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNoLData.verticalAlignment = GridData.BEGINNING;
				txtDocumentNoLData.widthHint = 149;
				txtDocumentNoLData.heightHint = 19;
				txtDocumentNo.setLayoutData(txtDocumentNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText(Messages.getString("AccUITransactionCollect.3"));  //$NON-NLS-1$
				GridData lblDateLData = new GridData();
				lblDate.setLayoutData(lblDateLData);
			}
			{
				datePickerTransactionDate = new DatePicker(this, SWT.NONE);
				datePickerTransactionDate
					.setSize(new org.eclipse.swt.graphics.Point(157, 25));
				GridData datePickerTransactionDateLData = new GridData();
				datePickerTransactionDateLData.widthHint = 157;
				datePickerTransactionDateLData.heightHint = 25;
				datePickerTransactionDate
					.setLayoutData(datePickerTransactionDateLData);
			}
			{
				lblDeptor = new CLabel(this, SWT.NONE);
				lblDeptor.setText(Messages
					.getString("AccUITransactionCollect.2")); //$NON-NLS-1$
				GridData lblDeptorLData = new GridData();
				lblDeptorLData.widthHint = 105;
				lblDeptorLData.heightHint = 22;
				lblDeptor.setLayoutData(lblDeptorLData);
			}
			{
				comboDeptor = new CCombo(this, SWT.NONE);
				comboDeptor
					.setSize(new org.eclipse.swt.graphics.Point(136, 16));
				GridData comboDeptorLData = new GridData();
				comboDeptorLData.widthHint = 114;
				comboDeptorLData.heightHint = 16;
				comboDeptor.setLayoutData(comboDeptorLData);
			}
			{
				lblTransDefinition = new CLabel(this, SWT.NONE);
				lblTransDefinition.setText(Messages
					.getString("AccUITransactionCollect.1")); //$NON-NLS-1$
				GridData lblTransDefinitionLData = new GridData();
				lblTransDefinitionLData.widthHint = 59;
				lblTransDefinitionLData.heightHint = 19;
				lblTransDefinitionLData.verticalAlignment = GridData.BEGINNING;
				lblTransDefinition.setLayoutData(lblTransDefinitionLData);
			}
			{
				txtTransDefinition = new Text(this, SWT.MULTI
					| SWT.WRAP
					| SWT.V_SCROLL);
				GridData txtTransDefinitionLData = new GridData();
				txtTransDefinition.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						if (evt.character == SWT.TAB) {
							btnAddTransactionRow.setFocus();
							evt.doit = false;
						}
					}
				});

				txtTransDefinitionLData.widthHint = 184;
				txtTransDefinitionLData.heightHint = 19;
				txtTransDefinition.setLayoutData(txtTransDefinitionLData);
			}
			{
				composite2 = new Composite(this, SWT.NONE);
				GridLayout composite2Layout = new GridLayout();
				composite2Layout.makeColumnsEqualWidth = true;
				composite2.setSize(new org.eclipse.swt.graphics.Point(70, 72));
				GridData composite2LData = new GridData();
				composite2.setLayout(composite2Layout);
				composite2LData.verticalAlignment = GridData.BEGINNING;
				composite2LData.widthHint = 70;
				composite2LData.heightHint = 72;
				composite2.setLayoutData(composite2LData);
				{
					btnAddTransactionRow = new Button(composite2, SWT.PUSH | SWT.CENTER);
					btnAddTransactionRow.setImage(SWTResourceManager
						.getImage("icons/plus.gif")); //$NON-NLS-1$
					btnAddTransactionRow
						.setSize(new org.eclipse.swt.graphics.Point(26, 24));
					GridData btnAddTransactionRowLData = new GridData();
					btnAddTransactionRow.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnAddTransactionRowMouseUp(evt);
						}
					});
					btnAddTransactionRowLData.horizontalAlignment = GridData.CENTER;
					btnAddTransactionRowLData.widthHint = 26;
					btnAddTransactionRowLData.heightHint = 24;
					btnAddTransactionRow.setLayoutData(btnAddTransactionRowLData);
				}
				{
					btnRemoveTransactionRow = new Button(composite2, SWT.PUSH | SWT.CENTER);
					//$NON-NLS-1$
					GridData btnRemoveTransactionRowLData = new GridData();
					btnRemoveTransactionRow.setImage(SWTResourceManager
						.getImage("icons/minus.gif")); //$NON-NLS-1$
					btnRemoveTransactionRow
						.addMouseListener(new MouseAdapter() {
							public void mouseUp(MouseEvent evt) {
								btnRemoveTransactionRowMouseUp(evt);
							}
						});
					btnRemoveTransactionRowLData.horizontalAlignment = GridData.CENTER;
					btnRemoveTransactionRowLData.widthHint = 28;
					btnRemoveTransactionRowLData.heightHint = 23;
					btnRemoveTransactionRow.setLayoutData(btnRemoveTransactionRowLData);
				}
				composite2.layout();
			}
			{
				tableTransactionRows = new Table(this, SWT.FULL_SELECTION
					| SWT.BORDER);
				tableTransactionRows.setHeaderVisible(true);
				tableTransactionRows.setLinesVisible(true);
				tableTransactionRows
					.setSize(new org.eclipse.swt.graphics.Point(415, 344));
				GridData tableTransactionRowsLData = new GridData();
				tableTransactionRowsLData.verticalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalSpan = 3;
				tableTransactionRowsLData.verticalSpan = 3;
				tableTransactionRowsLData.grabExcessHorizontalSpace = true;
				tableTransactionRowsLData.grabExcessVerticalSpace = true;
				tableTransactionRows.setLayoutData(tableTransactionRowsLData);
				
				{
					tableColumnAccountCode = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnAccountCode.setText(Messages
						.getString("AccUITransactionCollect.5")); //$NON-NLS-1$
					tableColumnAccountCode.setWidth(126);
				}
				{
					tableColumnAccountName = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnAccountName.setText(Messages
						.getString("AccUITransactionCollect.6")); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
				{
					tableColumnCreditAmount = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnCreditAmount.setText(Messages
						.getString("AccUITransactionCollect.7")); //$NON-NLS-1$
					tableColumnCreditAmount.setWidth(100);
				}
				{
					txtTransactionDefinition = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					txtTransactionDefinition.setText(Messages.getString("AccUITransactionCollect.4")); //$NON-NLS-1$
					txtTransactionDefinition.setWidth(150);
				}
			}
			thisLayout.numColumns = 4;
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
	
	totalDept = new BigDecimal(0);
	fillCombo();
	
	
	}
	
	public void fillCombo(){
	try{
	AccBLAccountAdd blaccountAdd = new AccBLAccountAdd();
	comboDeptor.setText(Messages.getString("AccUITransactionCollect.8")); //$NON-NLS-1$
	List accList = blaccountAdd.getAccount(-1,"100"); //$NON-NLS-1$
	TurqAccountingAccount account;
	for(int i=0;i<accList.size();i++){
	account = (TurqAccountingAccount)accList.get(i);
	comboDeptor.add(account.getAccountCode()+" "+account.getAccountName()); //$NON-NLS-1$
	comboDeptor.setData(account.getAccountCode()+" "+account.getAccountName(),account); //$NON-NLS-1$
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

	List accList = blaccountAdd.getAccount(parentId,""); //$NON-NLS-1$
	TurqAccountingAccount account;
	for(int i=0;i<accList.size();i++){
	account = (TurqAccountingAccount)accList.get(i);
	comboDeptor.add(account.getAccountCode()+" "+account.getAccountName()); //$NON-NLS-1$
	comboDeptor.setData(account.getAccountCode()+" "+account.getAccountName(),account); //$NON-NLS-1$
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
	msg.setMessage(Messages.getString("AccUITransactionCollect.15")); //$NON-NLS-1$
	
	msg.open();
	
	return false;
	
	}
	else if(datePickerTransactionDate.getData()==null){
	msg.setMessage(Messages.getString("AccUITransactionCollect.16")); //$NON-NLS-1$
	
	msg.open();
	
	return false;
	}
	else if(comboDeptor.getSelectionIndex()==-1){
	msg.setMessage(Messages.getString("AccUITransactionCollect.17")); //$NON-NLS-1$
	
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
	Integer transId =blTransAdd.saveAccTransaction(datePickerTransactionDate.getDate(),txtDocumentNo.getText().trim(),0,1,null,txtTransDefinition.getText().trim());
	
	saveTransactionRows(transId);
	msg.setMessage(Messages.getString("AccUITransactionCollect.18")); //$NON-NLS-1$
	msg.open();
	clearFields();
	}

	catch(Exception ex){
	ex.printStackTrace();
	msg.setMessage(Messages.getString("AccUITransactionCollect.19")); //$NON-NLS-1$
	msg.open();
	
	}
	
	
	
	
	
	
	}
		
	}
	
		
	public void clearFields(){
    txtDocumentNo.setText(""); //$NON-NLS-1$
    tableTransactionRows.removeAll();
    
    }
    
	public void saveTransactionRows(Integer transId)throws Exception{
    try{
    
    calculateTotalDept();
    TableItem items[] = tableTransactionRows.getItems();
    
    //First save the deptor Account
    TurqAccountingTransactionColumn transRow = new TurqAccountingTransactionColumn();
    transRow.setCreditAmount(new BigDecimal(0));
    transRow.setDeptAmount(totalDept);
    transRow.setTurqAccountingAccount((TurqAccountingAccount)comboDeptor.getData(comboDeptor.getText()));
    transRow.setTransactionDefinition("Kasa - Borç");
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
			AccUITransactionCollect inst = new AccUITransactionCollect(shell, SWT.NULL);
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
		Object o = new AccUITransactionRowAddDialog(this.getShell(),SWT.NULL,0).showDialog();
		if (o != null)
		{
		TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn) o;

		TableItem item = new TableItem(
			tableTransactionRows,
			SWT.NONE);
		item.setData(accTransRow);
		item.setText(new String[] {
				accTransRow.getTurqAccountingAccount()
					.getAccountCode(),
				accTransRow.getTurqAccountingAccount()
					.getAccountName(),
				accTransRow.getCreditAmount().toString(),accTransRow.getTransactionDefinition().toString() });
		}
	}
    
    
	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt){
		TableItem selection[] = tableTransactionRows.getSelection();
		if(selection.length>0){
		selection[0].dispose();
		
		
		}
		
	}
	void calculateTotalDept(){
	TableItem items[] = tableTransactionRows.getItems();
      totalDept =new BigDecimal(0);
    
		for(int i=0; i<items.length;i++){
		
		totalDept = totalDept.add(new BigDecimal(items[i].getText(2)));
    
		}
   	
	}
	/**
	 * @return Returns the comboDeptor.
	 */
	public CCombo getComboDeptor() {
		return comboDeptor;
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
	 * @return Returns the btnAddTransactionRow.
	 */
	public Button getBtnAddTransactionRow() {
		return btnAddTransactionRow;
	}
	/**
	 * @return Returns the btnRemoveTransactionRow.
	 */
	public Button getBtnRemoveTransactionRow() {
		return btnRemoveTransactionRow;
	}
	/**
	 * @param comboDeptor The comboDeptor to set.
	 */
	public void setComboDeptor(CCombo comboDeptor) {
		this.comboDeptor = comboDeptor;
	}
	/**
	 * @return Returns the txtTransDefinition.
	 */
	public Text getTxtTransDefinition() {
		return txtTransDefinition;
	}
	/**
	 * @param txtTransDefinition The txtTransDefinition to set.
	 */
	public void setTxtTransDefinition(Text txtTransDefinition) {
		this.txtTransDefinition = txtTransDefinition;
	}
}
