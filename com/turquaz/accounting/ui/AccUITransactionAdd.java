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

import com.turquaz.accounting.Messages;
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
	private AccBLTransactionAdd blTransAdd = new AccBLTransactionAdd();
	BigDecimal totalCredit ;
	private CLabel lblDate;
	private DatePicker dateTransactionDate;
	private CLabel lblTotalDebit;
	private Text text1;
	private Text txtTransDefinition;
	private CLabel lblTransactionDefinition;
	private CLabel lblTotalDeptAmount;
	private CLabel lblTotalCreditAmount;
	private CLabel lblTotalCredit;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccoutCode;
	private Table tableTransactionColumns;
	private Button btnRemoveTransactionRow;
	private Button btnAddTransactionRow;
	private Composite composite1;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
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

			this.setSize(new org.eclipse.swt.graphics.Point(621,531));


			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(Messages
					.getString("AccUITransactionAdd.0")); //$NON-NLS-1$
				lblDocumentNo
					.setSize(new org.eclipse.swt.graphics.Point(70, 19));
				GridData lblDocumentNoLData = new GridData();
				lblDocumentNoLData.verticalAlignment = GridData.BEGINNING;
				lblDocumentNoLData.widthHint = 70;
				lblDocumentNoLData.heightHint = 19;
				lblDocumentNo.setLayoutData(lblDocumentNoLData);
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
				lblDate.setText(Messages.getString("AccUITransactionAdd.1")); //$NON-NLS-1$
				GridData lblDateLData = new GridData();
				lblDateLData.verticalAlignment = GridData.BEGINNING;
				lblDateLData.widthHint = 70;
				lblDateLData.heightHint = 21;
				lblDate.setLayoutData(lblDateLData);
			}
			{
				dateTransactionDate = new DatePicker(this, SWT.NONE);
				GridData dateTransactionDateLData = new GridData();
				dateTransactionDateLData.verticalAlignment = GridData.BEGINNING;
				dateTransactionDateLData.widthHint = 159;
				dateTransactionDateLData.heightHint = 26;
				dateTransactionDate.setLayoutData(dateTransactionDateLData);
			}
			{
				lblTransactionDefinition = new CLabel(this, SWT.NONE);
				lblTransactionDefinition.setText(Messages.getString("AccUITransactionAdd.2")); //$NON-NLS-1$
				GridData lblTransactionDefinitionLData = new GridData();
				lblTransactionDefinitionLData.widthHint = 62;
				lblTransactionDefinitionLData.heightHint = 19;
				lblTransactionDefinitionLData.verticalAlignment = GridData.BEGINNING;
				lblTransactionDefinition
					.setLayoutData(lblTransactionDefinitionLData);
				{
					txtTransDefinition = new Text(
						lblTransactionDefinition,
						SWT.NONE);
				}
			}
			{
				text1 = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
				GridData text1LData = new GridData();
				text1.setTextLimit(250);
				text1LData.heightHint = 22;
				text1LData.horizontalSpan = 3;
				text1LData.widthHint = 364;
				text1.setLayoutData(text1LData);
			}
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.makeColumnsEqualWidth = true;
				composite1.setSize(new org.eclipse.swt.graphics.Point(70, 72));
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.verticalAlignment = GridData.BEGINNING;
				composite1LData.widthHint = 70;
				composite1LData.heightHint = 72;
				composite1.setLayoutData(composite1LData);
				{
					btnAddTransactionRow = new Button(composite1, SWT.PUSH
						| SWT.CENTER);
					btnAddTransactionRow.setImage(SWTResourceManager
						.getImage("icons/plus.gif")); //$NON-NLS-1$
					GridData btnAddTransactionRowLData = new GridData();
					btnAddTransactionRow.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnAddTransactionRowMouseUp(evt);
						}
					});
					btnAddTransactionRowLData.horizontalAlignment = GridData.CENTER;
					btnAddTransactionRowLData.widthHint = 30;
					btnAddTransactionRowLData.heightHint = 30;
					btnAddTransactionRow
						.setLayoutData(btnAddTransactionRowLData);
				}
				{
					btnRemoveTransactionRow = new Button(composite1, SWT.PUSH
						| SWT.CENTER);
					btnRemoveTransactionRow.setImage(SWTResourceManager
						.getImage("icons/minus.gif")); //$NON-NLS-1$
					GridData btnRemoveTransactionRowLData = new GridData();
					btnRemoveTransactionRow
						.addMouseListener(new MouseAdapter() {
							public void mouseUp(MouseEvent evt) {
								btnRemoveTransactionRowMouseUp(evt);
							}
						});
					btnRemoveTransactionRowLData.horizontalAlignment = GridData.CENTER;
					btnRemoveTransactionRowLData.widthHint = 31;
					btnRemoveTransactionRowLData.heightHint = 29;
					btnRemoveTransactionRow
						.setLayoutData(btnRemoveTransactionRowLData);
				}
				composite1.layout();
			}
			{
				tableTransactionColumns = new Table(this, SWT.FULL_SELECTION
					| SWT.BORDER);
				tableTransactionColumns.setHeaderVisible(true);
				tableTransactionColumns.setLinesVisible(true);
				tableTransactionColumns
					.setSize(new org.eclipse.swt.graphics.Point(516, 401));
				GridData tableTransactionColumnsLData = new GridData();
				tableTransactionColumnsLData.verticalAlignment = GridData.FILL;
				tableTransactionColumnsLData.horizontalAlignment = GridData.FILL;
				tableTransactionColumnsLData.horizontalSpan = 3;
				tableTransactionColumnsLData.grabExcessHorizontalSpace = true;
				tableTransactionColumnsLData.grabExcessVerticalSpace = true;
				tableTransactionColumns
					.setLayoutData(tableTransactionColumnsLData);
				{
					tableColumnAccoutCode = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnAccoutCode.setText(Messages
						.getString("AccUITransactionAdd.4")); //$NON-NLS-1$
					tableColumnAccoutCode.setWidth(121);
				}
				{
					tableColumnAccountName = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnAccountName.setText(Messages
						.getString("AccUITransactionAdd.5")); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
				{
					tableColumnDept = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnDept.setText(Messages
						.getString("AccUITransactionAdd.7")); //$NON-NLS-1$
					tableColumnDept.setWidth(106);
				}
				{
					tableColumnCredit = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnCredit.setText(Messages
						.getString("AccUITransactionAdd.6")); //$NON-NLS-1$
					tableColumnCredit.setWidth(97);
				}
			}
			{
				lblTotalDebit = new CLabel(this, SWT.NONE);
				lblTotalDebit.setText(Messages.getString("AccUITransactionAdd.9")); //$NON-NLS-1$
				GridData cLabel1LData = new GridData();
				cLabel1LData.horizontalAlignment = GridData.END;
				cLabel1LData.widthHint = 86;
				cLabel1LData.heightHint = 19;
				lblTotalDebit.setLayoutData(cLabel1LData);
			}
			{
				lblTotalDeptAmount = new CLabel(this, SWT.NONE);
				lblTotalDeptAmount.setText("0"); //$NON-NLS-1$
				lblTotalDeptAmount.setSize(new org.eclipse.swt.graphics.Point(
					345,
					17));
				GridData lblTotalDeptAmountLData = new GridData();
				lblTotalDeptAmountLData.widthHint = 345;
				lblTotalDeptAmountLData.heightHint = 17;
				lblTotalDeptAmountLData.horizontalSpan = 3;
				lblTotalDeptAmount.setLayoutData(lblTotalDeptAmountLData);
			}
			{
				lblTotalCredit = new CLabel(this, SWT.NONE);
				lblTotalCredit.setText(Messages
					.getString("AccUITransactionAdd.8")); //$NON-NLS-1$
				GridData lblTotalCreditLData = new GridData();
				lblTotalCreditLData.horizontalAlignment = GridData.END;
				lblTotalCreditLData.widthHint = 90;
				lblTotalCreditLData.heightHint = 16;
				lblTotalCredit.setLayoutData(lblTotalCreditLData);
			}
			{
				lblTotalCreditAmount = new CLabel(this, SWT.NONE);
				lblTotalCreditAmount.setText("0"); //$NON-NLS-1$
				lblTotalCreditAmount
					.setSize(new org.eclipse.swt.graphics.Point(321, 15));
				GridData lblTotalCreditAmountLData = new GridData();
				lblTotalCreditAmountLData.widthHint = 321;
				lblTotalCreditAmountLData.heightHint = 15;
				lblTotalCreditAmountLData.horizontalSpan = 3;
				lblTotalCreditAmount.setLayoutData(lblTotalCreditAmountLData);
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
	
	}
	public boolean verifyFields(){
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	
	calculateTotalDeptAndCredit();
	
	if(totalCredit.doubleValue()!=totalDept.doubleValue()){
	msg.setMessage(Messages.getString("AccUITransactionAdd.12")); //$NON-NLS-1$
	
	msg.open();
	
	return false;
	}
	else if(tableTransactionColumns.getItems().length==0){
	msg.setMessage(Messages.getString("AccUITransactionAdd.13")); //$NON-NLS-1$
	
	msg.open();
	
	return false;
	
	}
	else if(dateTransactionDate.getData()==null){
	msg.setMessage(Messages.getString("AccUITransactionAdd.14")); //$NON-NLS-1$
	
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
    txtDocumentNo.setText(""); //$NON-NLS-1$
    tableTransactionColumns.removeAll();
    calculateTotalDeptAndCredit();
    }
    
    
	public void save(){
	
	if(verifyFields()){
	
	MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
	try{
	
	Integer transId =blTransAdd.saveAccTransaction(dateTransactionDate.getDate(),txtDocumentNo.getText().trim(),2,1,null,txtTransDefinition.getText().trim());
	
	saveTransactionRows(transId);
	msg.setMessage(Messages.getString("AccUITransactionAdd.16")); //$NON-NLS-1$
	msg.open();
	clearFields();
	}

	catch(Exception ex){
	ex.printStackTrace();
	msg.setMessage(Messages.getString("AccUITransactionAdd.17")); //$NON-NLS-1$
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
							 accTransRow.getDeptAmount().toString(),
							accTransRow.getCreditAmount().toString()});
	
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
