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

import java.sql.Date;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Label;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionAdd extends SecureComposite {

	private CLabel lblTotalDeptAmount;
	private CLabel lblTotalCredit;
	private CLabel cLabel2;
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
			cLabel2 = new CLabel(this,SWT.NULL);
			cLabel1 = new CLabel(this,SWT.NULL);
			lblTotalDeptAmount = new CLabel(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(606,527));
	
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
			lblDateLData.widthHint = -1;
			lblDateLData.heightHint = -1;
			lblDateLData.horizontalIndent = 0;
			lblDateLData.horizontalSpan = 1;
			lblDateLData.verticalSpan = 1;
			lblDateLData.grabExcessHorizontalSpace = false;
			lblDateLData.grabExcessVerticalSpace = false;
			lblDate.setLayoutData(lblDateLData);
			lblDate.setText("Date");
	
			GridData dateTransactionDateLData = new GridData();
			dateTransactionDateLData.verticalAlignment = GridData.CENTER;
			dateTransactionDateLData.horizontalAlignment = GridData.BEGINNING;
			dateTransactionDateLData.widthHint = 163;
			dateTransactionDateLData.heightHint = 27;
			dateTransactionDateLData.horizontalIndent = 0;
			dateTransactionDateLData.horizontalSpan = 1;
			dateTransactionDateLData.verticalSpan = 1;
			dateTransactionDateLData.grabExcessHorizontalSpace = false;
			dateTransactionDateLData.grabExcessVerticalSpace = false;
			dateTransactionDate.setLayoutData(dateTransactionDateLData);
			dateTransactionDate.setSize(new org.eclipse.swt.graphics.Point(163,27));
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
			tableTransactionColumns.setSize(new org.eclipse.swt.graphics.Point(501,393));
	
			tableColumnAccoutCode.setText("Account Code");
			tableColumnAccoutCode.setWidth(121);
	
			tableColumnAccountName.setText("Account Name");
			tableColumnAccountName.setWidth(150);
	
			tableColumnCredit.setText("Credit");
			tableColumnCredit.setWidth(100);
	
			tableColumnDept.setText("Dept ");
			tableColumnDept.setWidth(100);
	
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
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.BEGINNING;
			cLabel2LData.widthHint = -1;
			cLabel2LData.heightHint = -1;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("0");
	
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
			lblTotalDeptAmountLData.widthHint = -1;
			lblTotalDeptAmountLData.heightHint = -1;
			lblTotalDeptAmountLData.horizontalIndent = 0;
			lblTotalDeptAmountLData.horizontalSpan = 1;
			lblTotalDeptAmountLData.verticalSpan = 1;
			lblTotalDeptAmountLData.grabExcessHorizontalSpace = false;
			lblTotalDeptAmountLData.grabExcessVerticalSpace = false;
			lblTotalDeptAmount.setLayoutData(lblTotalDeptAmountLData);
			lblTotalDeptAmount.setText("0");
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
	
	}
	public boolean verifyFields(){
	
	return true;
	
	
	}

	public void save(){
	
	if(verifyFields()){
	
	try{
	
	blTransAdd.saveAccTransaction(dateTransactionDate.getDate(),txtDocumentNo.getText().trim(),2,1);
		
	}

	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	
	
	
	
	}
	
	
	
	}
	
	public void delete(){
	
	}
	
	public void newForm(){
	
	}
	
	public void search(){
	
	}
	
	

	/** Auto-generated event handler method */
	protected void btnAddTransactionRowMouseUp(MouseEvent evt){
    
    Object o = new AccUITransactionRowAddDialog(this.getShell(),SWT.NULL).showDialog();
    
    if(o!=null){
    TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn)o;
    
    
    TableItem item = new TableItem(tableTransactionColumns,SWT.NULL);    
	item.setData(accTransRow);
	item.setText(new String[]{accTransRow.getTurqAccountingAccount().getAccountCode(),
							 accTransRow.getTurqAccountingAccount().getAccountName(),
							 accTransRow.getCreditAmount().toString(),
							 accTransRow.getDeptAmount().toString()});
	
	
	}
	
	}

	

	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt){
		TableItem selection[] = tableTransactionColumns.getSelection();
		if(selection.length>0){
		selection[0].dispose();
		}
		
		
	}
}
