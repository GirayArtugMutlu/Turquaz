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


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;
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
public class AccUITransactionAdd extends  Composite implements SecureComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
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
	 * @return Returns the tableTransactionColumns.
	 */
	public Table getTableTransactionColumns() {
		return tableTransactionColumns;
	}
	/**
	 * @return Returns the totalCredit.
	 */
	public BigDecimal getTotalCredit() {
		return totalCredit;
	}
	/**
	 * @return Returns the totalDept.
	 */
	public BigDecimal getTotalDept() {
		return totalDept;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	private CLabel lblTotalDeptAmount;
	private CLabel lblTotalCredit;
	private CLabel lblTotalCreditAmount;
	private CLabel cLabel1;
	private Button btnRemoveTransactionRow;
	private Button btnAddTransactionRow;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnAccountName;
	private Composite composite1;
	private TableColumn tableColumnAccoutCode;
	private Table tableTransactionColumns;
	private CLabel lblDate;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateTransactionDate;
	private AccBLTransactionAdd blTransAdd = new AccBLTransactionAdd();
	BigDecimal totalCredit ;
	BigDecimal totalDept ;
	
	
	public AccUITransactionAdd(Composite parent, int style) {
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
	
			lblDocumentNo = new CLabel(this,SWT.NULL);
			txtDocumentNo = new Text(this,SWT.NULL);
			lblDate = new CLabel(this,SWT.NULL);
			dateTransactionDate = new DatePicker(this,SWT.NULL);
			composite1 = new Composite(this,SWT.NULL);
			btnAddTransactionRow = new Button(composite1,SWT.PUSH| SWT.CENTER);
			btnRemoveTransactionRow = new Button(composite1,SWT.PUSH| SWT.CENTER);
			tableTransactionColumns = new Table(this,SWT.FULL_SELECTION| SWT.BORDER);
			tableColumnAccoutCode = new TableColumn(tableTransactionColumns,SWT.NULL);
			tableColumnAccountName = new TableColumn(tableTransactionColumns,SWT.NULL);
			tableColumnCredit = new TableColumn(tableTransactionColumns,SWT.NULL);
			tableColumnDept = new TableColumn(tableTransactionColumns,SWT.NULL);
			lblTotalCredit = new CLabel(this,SWT.NULL);
			lblTotalCreditAmount = new CLabel(this,SWT.NULL);
			cLabel1 = new CLabel(this,SWT.NULL);
			lblTotalDeptAmount = new CLabel(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(621,531));
	
			GridData lblDocumentNoLData = new GridData();
			lblDocumentNoLData.verticalAlignment = GridData.CENTER;
			lblDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			lblDocumentNoLData.widthHint = 70;
			lblDocumentNoLData.heightHint = 19;
			lblDocumentNoLData.horizontalIndent = 0;
			lblDocumentNoLData.horizontalSpan = 1;
			lblDocumentNoLData.verticalSpan = 1;
			lblDocumentNoLData.grabExcessHorizontalSpace = false;
			lblDocumentNoLData.grabExcessVerticalSpace = false;
			lblDocumentNo.setLayoutData(lblDocumentNoLData);
			lblDocumentNo.setText("Document No");
			lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(70,19));
	
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
			lblDateLData.widthHint = 29;
			lblDateLData.heightHint = 19;
			lblDateLData.horizontalIndent = 0;
			lblDateLData.horizontalSpan = 1;
			lblDateLData.verticalSpan = 1;
			lblDateLData.grabExcessHorizontalSpace = false;
			lblDateLData.grabExcessVerticalSpace = false;
			lblDate.setLayoutData(lblDateLData);
			lblDate.setText("Date");
			lblDate.setSize(new org.eclipse.swt.graphics.Point(29,19));
	
			GridData dateTransactionDateLData = new GridData();
			dateTransactionDateLData.verticalAlignment = GridData.CENTER;
			dateTransactionDateLData.horizontalAlignment = GridData.BEGINNING;
			dateTransactionDateLData.widthHint = 159;
			dateTransactionDateLData.heightHint = 23;
			dateTransactionDateLData.horizontalIndent = 0;
			dateTransactionDateLData.horizontalSpan = 1;
			dateTransactionDateLData.verticalSpan = 1;
			dateTransactionDateLData.grabExcessHorizontalSpace = false;
			dateTransactionDateLData.grabExcessVerticalSpace = false;
			dateTransactionDate.setLayoutData(dateTransactionDateLData);
			dateTransactionDate.setSize(new org.eclipse.swt.graphics.Point(159,23));
			dateTransactionDate.layout();
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.BEGINNING;
			composite1LData.horizontalAlignment = GridData.BEGINNING;
			composite1LData.widthHint = 70;
			composite1LData.heightHint = 72;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(70,72));
	
			GridData btnAddTransactionRowLData = new GridData();
			btnAddTransactionRow.setImage(SWTResourceManager.getImage("icons/plus.gif"));
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
			btnAddTransactionRow.setSize(new org.eclipse.swt.graphics.Point(26,24));
			btnAddTransactionRow.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnAddTransactionRowMouseUp(evt);
				}
			});
	
			GridData btnRemoveTransactionRowLData = new GridData();
			btnRemoveTransactionRow.setImage(SWTResourceManager.getImage("icons/minus.gif"));
			btnRemoveTransactionRowLData.horizontalAlignment = GridData.CENTER;
			btnRemoveTransactionRowLData.widthHint = 24;
			btnRemoveTransactionRowLData.heightHint = 23;
			btnRemoveTransactionRow.setLayoutData(btnRemoveTransactionRowLData);
			btnRemoveTransactionRow.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnRemoveTransactionRowMouseUp(evt);
				}
			});
			GridLayout composite1Layout = new GridLayout(1, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 1;
			composite1Layout.makeColumnsEqualWidth = true;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableTransactionColumnsLData = new GridData();
			tableTransactionColumnsLData.verticalAlignment = GridData.FILL;
			tableTransactionColumnsLData.horizontalAlignment = GridData.FILL;
			tableTransactionColumnsLData.widthHint = -1;
			tableTransactionColumnsLData.heightHint = -1;
			tableTransactionColumnsLData.horizontalIndent = 0;
			tableTransactionColumnsLData.horizontalSpan = 1;
			tableTransactionColumnsLData.verticalSpan = 1;
			tableTransactionColumnsLData.grabExcessHorizontalSpace = true;
			tableTransactionColumnsLData.grabExcessVerticalSpace = true;
			tableTransactionColumns.setLayoutData(tableTransactionColumnsLData);
			tableTransactionColumns.setHeaderVisible(true);
			tableTransactionColumns.setLinesVisible(true);
			tableTransactionColumns.setSize(new org.eclipse.swt.graphics.Point(516,401));
	
			tableColumnAccoutCode.setText("Account Code");
			tableColumnAccoutCode.setWidth(121);
	
			tableColumnAccountName.setText("Account Name");
			tableColumnAccountName.setWidth(150);
	
			tableColumnCredit.setText("Credit");
			tableColumnCredit.setWidth(100);
	
			tableColumnDept.setText("Dept ");
			tableColumnDept.setWidth(106);
	
			GridData lblTotalCreditLData = new GridData();
			lblTotalCreditLData.verticalAlignment = GridData.CENTER;
			lblTotalCreditLData.horizontalAlignment = GridData.END;
			lblTotalCreditLData.widthHint = 62;
			lblTotalCreditLData.heightHint = 19;
			lblTotalCreditLData.horizontalIndent = 0;
			lblTotalCreditLData.horizontalSpan = 1;
			lblTotalCreditLData.verticalSpan = 1;
			lblTotalCreditLData.grabExcessHorizontalSpace = false;
			lblTotalCreditLData.grabExcessVerticalSpace = false;
			lblTotalCredit.setLayoutData(lblTotalCreditLData);
			lblTotalCredit.setText("Total Credit");
			lblTotalCredit.setSize(new org.eclipse.swt.graphics.Point(62,19));
	
			GridData lblTotalCreditAmountLData = new GridData();
			lblTotalCreditAmountLData.verticalAlignment = GridData.CENTER;
			lblTotalCreditAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblTotalCreditAmountLData.widthHint = 321;
			lblTotalCreditAmountLData.heightHint = 15;
			lblTotalCreditAmountLData.horizontalIndent = 0;
			lblTotalCreditAmountLData.horizontalSpan = 1;
			lblTotalCreditAmountLData.verticalSpan = 1;
			lblTotalCreditAmountLData.grabExcessHorizontalSpace = false;
			lblTotalCreditAmountLData.grabExcessVerticalSpace = false;
			lblTotalCreditAmount.setLayoutData(lblTotalCreditAmountLData);
			lblTotalCreditAmount.setText("0");
			lblTotalCreditAmount.setSize(new org.eclipse.swt.graphics.Point(321,15));
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.END;
			cLabel1LData.widthHint = 58;
			cLabel1LData.heightHint = 19;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Total Debit");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(58,19));
	
			GridData lblTotalDeptAmountLData = new GridData();
			lblTotalDeptAmountLData.verticalAlignment = GridData.CENTER;
			lblTotalDeptAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblTotalDeptAmountLData.widthHint = 345;
			lblTotalDeptAmountLData.heightHint = 17;
			lblTotalDeptAmountLData.horizontalIndent = 0;
			lblTotalDeptAmountLData.horizontalSpan = 1;
			lblTotalDeptAmountLData.verticalSpan = 1;
			lblTotalDeptAmountLData.grabExcessHorizontalSpace = false;
			lblTotalDeptAmountLData.grabExcessVerticalSpace = false;
			lblTotalDeptAmount.setLayoutData(lblTotalDeptAmountLData);
			lblTotalDeptAmount.setText("0");
			lblTotalDeptAmount.setSize(new org.eclipse.swt.graphics.Point(345,17));
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
	
	}
	public boolean verifyFields(){
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	
	calculateTotalDeptAndCredit();
	
	if(totalCredit.doubleValue()!=totalDept.doubleValue()){
	msg.setMessage("Total credit must be equal to total dept!");
	
	msg.open();
	
	return false;
	}
	else if(tableTransactionColumns.getItems().length==0){
	msg.setMessage("You have to add rows to table!");
	
	msg.open();
	
	return false;
	
	}
	else if(dateTransactionDate.getData()==null){
	msg.setMessage("Please Enter Transaction Date");
	
	msg.open();
	
	return false;
	}
	
	else{
	return true;
	}
	
	
	
	
	}

    public void saveTransactionRows(Integer transId)throws Exception{
    try{
    
    TableItem items[] = tableTransactionColumns.getItems();
    
    for(int i=0; i<items.length;i++){
    blTransAdd.saveAccTransactionRow((TurqAccountingTransactionColumn)items[i].getData(),transId);
    
    }
    
    
    
    }
    catch(Exception ex){
    throw ex;
    
    }
    
    
    }
    
    public void clearFields(){
    txtDocumentNo.setText("");
    tableTransactionColumns.removeAll();
    calculateTotalDeptAndCredit();
    }
    
    
	public void save(){
	
	if(verifyFields()){
	
	MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
	try{
	
	Integer transId =blTransAdd.saveAccTransaction(dateTransactionDate.getDate(),txtDocumentNo.getText().trim(),2,1);
	
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
	
	void calculateTotalDeptAndCredit(){
	TableItem items[] = tableTransactionColumns.getItems();
    totalCredit=new BigDecimal(0);
    totalDept =new BigDecimal(0);
    
		for(int i=0; i<items.length;i++){
		totalCredit =totalCredit.add(new BigDecimal(items[i].getText(2)));
		totalDept = totalDept.add(new BigDecimal(items[i].getText(3)));
    
		}
    lblTotalDeptAmount.setText(totalDept.toString());
    lblTotalCreditAmount.setText(totalCredit.toString());
	
	}
	
	public void delete(){
	
	}
	
	public void newForm(){
	
	}
	
	public void search(){
	
	}
	
	

	/** Auto-generated event handler method */
	protected void btnAddTransactionRowMouseUp(MouseEvent evt){
    
    Object o = new AccUITransactionRowAddDialog(this.getShell(),SWT.NULL,2).showDialog();
    
    if(o!=null){
    TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn)o;
    
    
    TableItem item = new TableItem(tableTransactionColumns,SWT.NULL);    
	item.setData(accTransRow);
	item.setText(new String[]{accTransRow.getTurqAccountingAccount().getAccountCode(),
							 accTransRow.getTurqAccountingAccount().getAccountName(),
							 accTransRow.getCreditAmount().toString(),
							 accTransRow.getDeptAmount().toString()});
	
	calculateTotalDeptAndCredit();
	
	}
	
	}

	

	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt){
		TableItem selection[] = tableTransactionColumns.getSelection();
		if(selection.length>0){
		selection[0].dispose();
		calculateTotalDeptAndCredit();
		
		}
		
		
	}
	/**
	 * @return Returns the dateTransactionDate.
	 */
	public DatePicker getDateTransactionDate() {
		return dateTransactionDate;
	}
}
