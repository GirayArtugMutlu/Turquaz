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
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.SWT;

/**
*		Tahsil Fisi 
*/
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
	private TableItem item;
	private CLabel lblTableWarning;
	private TableColumn txtTransactionDefinition;
	private TableColumn tableColumnCreditAmount;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private Table tableTransactionRows;
	private Text txtTransDefinition;
	private CLabel lblTransDefinition;
	private CLabel lblDeptor;
	private Text txtDocumentNo;
	private CLabel lbldocumentNo;
	private DatePicker datePickerTransactionDate;
	private BigDecimal totalDept;
//	 Set the table column property names
	private final String ACCOUNT_CODE 		= Messages.getString("AccUITransactionCollect.4"); //$NON-NLS-1$
	private final String ACCOUNT_NAME   	= Messages.getString("AccUITransactionCollect.5"); //$NON-NLS-1$
	private final String DEFINITION         = Messages.getString("AccUITransactionCollect.6"); //$NON-NLS-1$
	private final String CREDIT 		    = Messages.getString("AccUITransactionCollect.7"); //$NON-NLS-1$
	TableCursor cursor;
	private List columnList = new ArrayList();
	TableRowList rowList = new TableRowList();
	// Set column names
	private String[] columnNames = new String[] { 
			ACCOUNT_CODE, 
			ACCOUNT_NAME,
			DEFINITION,
			CREDIT
			
			};
	public TableViewer tableViewer;
	
	
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

			this.setSize(722, 471);


			
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
							tableTransactionRows.setFocus();
							evt.doit = false;
						}
					}
				});

				txtTransDefinitionLData.widthHint = 184;
				txtTransDefinitionLData.heightHint = 19;
				txtTransDefinition.setLayoutData(txtTransDefinitionLData);
			}
			{
				lblTableWarning = new CLabel(this, SWT.NONE);
				lblTableWarning.setText(Messages.getString("AccUITransactionCollect.10")); //$NON-NLS-1$
				lblTableWarning.setFont(SWTResourceManager.getFont("Tahoma", 8, 1, false, false)); //$NON-NLS-1$
				GridData lblTableWarningLData = new GridData();
				lblTableWarningLData.horizontalSpan = 4;
				lblTableWarningLData.widthHint = 425;
				lblTableWarningLData.heightHint = 19;
				lblTableWarning.setLayoutData(lblTableWarningLData);
			}
			{
				tableTransactionRows = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.BORDER);
				tableTransactionRows.setHeaderVisible(true);
				tableTransactionRows.setLinesVisible(true);
				tableTransactionRows
					.setSize(new org.eclipse.swt.graphics.Point(415, 344));
				GridData tableTransactionRowsLData = new GridData();
				tableTransactionRowsLData.verticalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalSpan = 4;
				tableTransactionRowsLData.verticalSpan = 3;
				tableTransactionRowsLData.grabExcessHorizontalSpace = true;
				tableTransactionRowsLData.grabExcessVerticalSpace = true;
				tableTransactionRows.setLayoutData(tableTransactionRowsLData);
				
				{
					tableColumnAccountCode = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnAccountCode.setText(ACCOUNT_CODE); //$NON-NLS-1$
					tableColumnAccountCode.setWidth(126);
				}
				{
					tableColumnAccountName = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnAccountName.setText(ACCOUNT_NAME); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
                {
                    txtTransactionDefinition = new TableColumn(
                        tableTransactionRows,
                        SWT.NONE);
                    txtTransactionDefinition.setText(DEFINITION); //$NON-NLS-1$
                    txtTransactionDefinition.setWidth(150);
                }
				{
					tableColumnCreditAmount = new TableColumn(
						tableTransactionRows,
						SWT.NONE);
					tableColumnCreditAmount.setText(CREDIT); //$NON-NLS-1$
					tableColumnCreditAmount.setWidth(100);
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
	
	createTableViewer();
	
	
	}
	
	public void createTableViewer(){
	       columnList.add(ACCOUNT_CODE);
	       columnList.add(ACCOUNT_NAME);
	       columnList.add(DEFINITION);
	       columnList.add(CREDIT);
	       tableViewer = new TableViewer(tableTransactionRows);
	       tableViewer.setUseHashlookup(true);
	       tableViewer.setColumnProperties(columnNames);
	       //     Create the cell editors
		   CellEditor[] editors = new CellEditor[columnNames.length];
	       editors[0] = new AccountingCellEditor(tableTransactionRows);
	       editors[1] = new TextCellEditor(tableTransactionRows);
	       editors[2] = new TextCellEditor(tableTransactionRows);
	       editors[3] = new CurrencyCellEditor(tableTransactionRows);
	    
	       // Assign the cell editors to the viewer 
			tableViewer.setCellEditors(editors);
	       
			TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer,rowList);
			tableViewer.setCellModifier(new TurquazCellModifier(columnList,contentProvider));    
			tableViewer.setContentProvider(contentProvider);
			tableViewer.setLabelProvider(new TurquazLabelProvider());			
			tableViewer.setInput(rowList);
			
			 // create a TableCursor to navigate around the table
			 cursor = new TableCursor(tableTransactionRows, SWT.NONE);
	         cursor.setEnabled(true);
			 cursor.addKeyListener(new KeyAdapter(){
			     public void keyReleased(KeyEvent evt){
			         
	                 if (evt.keyCode == SWT.INSERT){
	                     AccUITransactionCollectTableRow row = new AccUITransactionCollectTableRow(
	                         rowList);
	                     rowList.addTask(row);
	                     tableViewer.editElement(row, 0);
	                     cursor.setSelection(tableTransactionRows
	                         .getItemCount() - 1, 0);
	                     cursor.setVisible(true);
	                    
	                 }
	                 else if(evt.keyCode==SWT.DEL){
	                     if(cursor.getRow()!=null){
	                         ITableRow row = (ITableRow)cursor.getRow().getData();
	                         rowList.removeTask(row);
	                         int itemCount =tableTransactionRows.getItemCount();
	                        if(itemCount>0){
	                            cursor.setSelection(itemCount-1,0);
	                        }
	                     
	                    }
	                     
	                    
	                    
	                 }
			         
			     }});
			 cursor.addSelectionListener(new SelectionAdapter() {
					// when the TableEditor is over a cell, select the corresponding rowtable
					public void widgetSelected(SelectionEvent e) {
		              
					}		
					// when the user hits "ENTER" in the TableCursor, pop up a text/combo editor 
					// so that they can change the text of the cell for controlType=="input" || "select1"<br>
					// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
					public void widgetDefaultSelected(SelectionEvent e) {
					 
					    tableViewer.editElement(cursor.getRow().getData(),cursor.getColumn());
					
					}
				});
	  
		
	        
	    
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
    transRow.setTransactionDefinition(Messages.getString("AccUITransactionCollect.9")); //$NON-NLS-1$
    blTransAdd.saveAccTransactionRow(transRow,transId);   
     
    //Save the table rows    
    for(int i=0; i<items.length;i++){
    AccUITransactionCollectTableRow row =(AccUITransactionCollectTableRow)items[i].getData();
    
    if(row.okToSave()){
        blTransAdd.saveAccTransactionRow((TurqAccountingTransactionColumn)row.getDBObject(),transId);
    }
    }
    
    
    
    }
    catch(Exception ex){
    throw ex;
    
    }
    
    
    }
	
	public void search(){
	}
	public void newForm(){
		clearFields();
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
		
		totalDept = totalDept.add(new BigDecimal(items[i].getText(3)));
    
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
