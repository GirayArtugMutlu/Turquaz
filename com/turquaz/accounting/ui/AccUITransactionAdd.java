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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;

import com.turquaz.engine.ui.component.TurquazDecimalFormat;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.bl.AccBLTransactionSearch;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;


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
	 * @return Returns the exchangeRate.
	 */
	public TurqCurrencyExchangeRate getExchangeRate() {
		return exchangeRate;
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

	private TurqCurrency baseCurrency;
	private TurqCurrency exchangeCurrency;
	private TurqCurrencyExchangeRate exchangeRate;
	
	BigDecimal totalCredit ;
	private CLabel lblDate;
	private DatePicker dateTransactionDate;
	private TableColumn tableColumnDefinition;
	private Text txtTransDefinition;
	private CLabel lblTransactionDefinition;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccoutCode;
	private Table tableTransactionColumns;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	BigDecimal totalDept ;
//	 Set the table column property names
	private final String ACCOUNT_CODE 		= Messages.getString("AccUITransactionAdd.3"); //$NON-NLS-1$
	private final String ACCOUNT_NAME   	= Messages.getString("AccUITransactionAdd.4"); //$NON-NLS-1$
	private final String DEFINITION         = Messages.getString("AccUITransactionAdd.5"); //$NON-NLS-1$
	private final String DEPT     			= Messages.getString("AccUITransactionAdd.6"); //$NON-NLS-1$
	private final String CREDIT 		    = Messages.getString("AccUITransactionAdd.7"); //$NON-NLS-1$
	public TableSpreadsheetCursor cursor;
	private List columnList = new ArrayList();
	private TableItem tableItemBalance;
	private TableItem tableItemSpace;
	private TableItem tableItemCredit;
	private TableItem tableItemDept;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnTitle;
	private Table table1;
	TableRowList rowList = new TableRowList();
	// Set column names
	private String[] columnNames = new String[] { 
			ACCOUNT_CODE, 
			ACCOUNT_NAME,
			DEFINITION,
			DEPT,
			CREDIT
			
			};
	public TableViewer tableViewer;
	
	
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

			this.setSize(688, 540);


			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(Messages.getString("AccUITransactionAdd.0")); //$NON-NLS-1$
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
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNoLData.verticalAlignment = GridData.BEGINNING;
				txtDocumentNoLData.widthHint = 150;
				txtDocumentNoLData.heightHint = 17;
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
				dateTransactionDateLData.widthHint = 170;
				dateTransactionDateLData.heightHint = 22;
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
			}
			{
				txtTransDefinition = new Text(this, SWT.MULTI
					| SWT.WRAP
					| SWT.V_SCROLL);
				GridData text1LData = new GridData();
				txtTransDefinition.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						if (evt.keyCode == SWT.TAB) {
							tableTransactionColumns.setFocus();
							evt.doit = false;

						}
					}
				});
				txtTransDefinition.setTextLimit(250);
				text1LData.heightHint = 27;
				text1LData.horizontalSpan = 3;
				text1LData.widthHint = 381;
				txtTransDefinition.setLayoutData(text1LData);
			}
			//START >>  lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(Messages.getString("AccUITransactionAdd.9")); //$NON-NLS-1$
			//END <<  lblCurrency
			//START >>  comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 130;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END <<  comboCurrencyType
			{
				tableTransactionColumns = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
				tableTransactionColumns.setHeaderVisible(true);
				tableTransactionColumns.setLinesVisible(true);
				GridData tableTransactionColumnsLData = new GridData();
				tableTransactionColumnsLData.verticalAlignment = GridData.FILL;
				tableTransactionColumnsLData.horizontalAlignment = GridData.FILL;
				tableTransactionColumnsLData.horizontalSpan = 4;
				tableTransactionColumnsLData.grabExcessHorizontalSpace = true;
				tableTransactionColumnsLData.grabExcessVerticalSpace = true;
				tableTransactionColumns.setLayoutData(tableTransactionColumnsLData);
				{
					tableColumnAccoutCode = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnAccoutCode.setText(ACCOUNT_CODE); //$NON-NLS-1$
					tableColumnAccoutCode.setWidth(121);
				}
				{
					tableColumnAccountName = new TableColumn(
						tableTransactionColumns,
						SWT.NONE);
					tableColumnAccountName.setText(ACCOUNT_NAME); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
                {
                    tableColumnDefinition = new TableColumn(
                        tableTransactionColumns,
                        SWT.NONE);
                    tableColumnDefinition.setText(DEFINITION); //$NON-NLS-1$
                    tableColumnDefinition.setWidth(150);
                }
				{
					tableColumnDept = new TableColumn(tableTransactionColumns, SWT.RIGHT);
					tableColumnDept.setText(DEPT); //$NON-NLS-1$
					tableColumnDept.setWidth(106);
				}
				{
					tableColumnCredit = new TableColumn(tableTransactionColumns, SWT.RIGHT);
					tableColumnCredit.setText(CREDIT); //$NON-NLS-1$
					tableColumnCredit.setWidth(97);
				}
			}
            {
                table1 = new Table(this, SWT.HIDE_SELECTION);
                GridData table1LData = new GridData();
                table1.setLinesVisible(true);
                table1LData.horizontalSpan = 4;
                table1LData.horizontalAlignment = GridData.END;
                table1LData.grabExcessHorizontalSpace = true;
                table1LData.widthHint = 247;
                table1LData.heightHint = 59;
                table1.setLayoutData(table1LData);
                {
                    tableColumnTitle = new TableColumn(table1, SWT.NONE);
                    tableColumnTitle.setWidth(80);
                }
                {
                    tableColumnAmount = new TableColumn(table1, SWT.RIGHT);
                    tableColumnAmount.setText(Messages.getString("AccUITransactionAdd.22")); //$NON-NLS-1$
                    tableColumnAmount.setWidth(100);
                }
                {
                    tableItemDept = new TableItem(table1, SWT.NONE);
                    tableItemDept.setText(Messages.getString("AccUITransactionAdd.23")); //$NON-NLS-1$
                }
                {
                    tableItemCredit = new TableItem(table1, SWT.NONE);
                    tableItemCredit.setText(Messages.getString("AccUITransactionAdd.24")); //$NON-NLS-1$
                }
                {
                    tableItemSpace = new TableItem(table1, SWT.NONE);
                }
                {
                    tableItemBalance = new TableItem(table1, SWT.NONE);
                    tableItemBalance.setText(Messages.getString("AccUITransactionAdd.25")); //$NON-NLS-1$
                }
            }
			thisLayout.numColumns = 4;
			tableTransactionColumns.setEnabled(true);
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
	
	public void postInitGUI()
	{
	   
		createTableViewer();    
		fillCurrencyCombo();
		 for(int i=0;i<EngBLCommon.TABLE_ROW_COUNT;i++)
		 {
//			enter empty table rows.
		 	AccUITransactionAddTableRow row = new AccUITransactionAddTableRow(rowList);
	      	rowList.addTask(row);
		}
	}
	
	
	public void fillCurrencyCombo()
	{
		try
		{
			List currencies=AccBLTransactionSearch.getCurrencies();
			for (int k=0; k<currencies.size(); k++)
			{
				TurqCurrency currency=(TurqCurrency)currencies.get(k);
				comboCurrencyType.add(currency.getCurrenciesAbbreviation());
				comboCurrencyType.setData(currency.getCurrenciesAbbreviation(),currency);
				if (currency.isDefaultCurrency())
				{
					comboCurrencyType.setText(currency.getCurrenciesAbbreviation());
					baseCurrency=currency;
				}
			
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	public void createTableViewer(){
	       columnList.add(ACCOUNT_CODE);
	       columnList.add(ACCOUNT_NAME);
	       columnList.add(DEFINITION);
	       columnList.add(DEPT);
	       columnList.add(CREDIT);
	       tableViewer = new TableViewer(tableTransactionColumns);
	       tableViewer.setUseHashlookup(true);
	       tableViewer.setColumnProperties(columnNames);
	       //     Create the cell editors
		   CellEditor[] editors = new CellEditor[columnNames.length];
	       editors[0] = new AccountingCellEditor(tableTransactionColumns);
	       editors[1] = new TextCellEditor(tableTransactionColumns);
	       editors[2] = new TextCellEditor(tableTransactionColumns);
	       editors[3] = new CurrencyCellEditor(tableTransactionColumns,2);
	       editors[4] = new CurrencyCellEditor(tableTransactionColumns,2);
	    
	       // Assign the cell editors to the viewer 
			tableViewer.setCellEditors(editors);
	       
			TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer,rowList);
			tableViewer.setCellModifier(new TurquazCellModifier(columnList,contentProvider));    
			tableViewer.setContentProvider(contentProvider);
			tableViewer.setLabelProvider(new TurquazLabelProvider());			
			tableViewer.setInput(rowList);
			
			// create a TableCursor to navigate around the table
			 cursor = new TableSpreadsheetCursor(tableTransactionColumns, SWT.NONE,tableViewer,rowList,true);
	         cursor.setEnabled(true);	 
		
		    rowList.addChangeListener(new ITableRowListViewer(){
			       public void updateRow(ITableRow row){
			           
			           calculateTotalDeptAndCredit();
			          
						
			           Vector vec = rowList.getTasks();
			           int index = vec.indexOf(row);
			           if(index==vec.size()-1){
			           		if(row.okToSave()){
			           			
			                    AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(rowList);
			                    rowList.addTask(row2);
			                   
			           			

			           		}
			           	
			           }
			           
			      }
			       public void removeRow(ITableRow row){
			           calculateTotalDeptAndCredit();
			                 
			       }
			       public void addRow(ITableRow row){
			           calculateTotalDeptAndCredit();
			       }
			    });
	
	    
	}
	
	public boolean okToDelete(){
	    
	    MessageBox msg = new MessageBox(this.getShell(),SWT.ICON_WARNING|SWT.OK|SWT.CANCEL);
	       msg.setMessage(Messages.getString("AccUITransactionAdd.8"));   //$NON-NLS-1$
	       if(msg.open()==SWT.OK){
	           return true;
	       }
	       else
	       {
	           return false;
	       }
	       
	       
	}
	
	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	
			calculateTotalDeptAndCredit();
			if(totalCredit.doubleValue()<=0)
			{
				msg.setMessage(Messages.getString("AccUITransactionAdd.15"));  //$NON-NLS-1$
				msg.open();	
				return false;
				
			}
	
			if(totalCredit.doubleValue()!=totalDept.doubleValue())
			{
				msg.setMessage(Messages.getString("AccUITransactionAdd.12")); //$NON-NLS-1$	
				msg.open();	
				return false;
			}
			else if(tableTransactionColumns.getItems().length==0)
			{
				msg.setMessage(Messages.getString("AccUITransactionAdd.13")); //$NON-NLS-1$	
				msg.open();
	
				return false;
	
			}
			else if(dateTransactionDate.getData()==null)
			{
				msg.setMessage(Messages.getString("AccUITransactionAdd.14")); //$NON-NLS-1$	
				msg.open();
				dateTransactionDate.setFocus();
	
				return false;
			}	
			else if ((exchangeCurrency=(TurqCurrency)comboCurrencyType.getData(comboCurrencyType.getText()))==null)
			{
				msg.setMessage(Messages.getString("AccUITransactionAdd.10")); //$NON-NLS-1$
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() !=exchangeCurrency.getId().intValue())
			{
					exchangeRate=EngBLCommon.getCurrencyExchangeRate(baseCurrency,
							exchangeCurrency,dateTransactionDate.getDate());
					if (exchangeRate == null)
					{
						msg.setMessage(Messages.getString("AccUITransactionAdd.11")); //$NON-NLS-1$
						msg.open();
						return false;	
				
					}
				
			}
			else
			{
				exchangeRate=EngBLCommon.getBaseCurrencyExchangeRate();
			}
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}

    public void prepareAccountingMaps(Map creditAccounts, Map deptAccounts)throws Exception
	{
    	creditAccounts.clear();
    	deptAccounts.clear();
    	   	
    	try
		{
    
    		TableItem items[] = tableTransactionColumns.getItems();
    
    		for(int i=0; i<items.length;i++)
    		{
   
    			AccUITransactionAddTableRow row =(AccUITransactionAddTableRow)items[i].getData();
    
    			if(row.okToSave())
    			{
    			
    				TurqAccountingTransactionColumn transColumn=(TurqAccountingTransactionColumn)row.getDBObject();
    				if(transColumn.getCreditAmount().doubleValue()>0)
    				{
    					List ls = (List)creditAccounts.get(transColumn.getTurqAccountingAccount().getId());
    					if(ls == null)
    					{
    						ls = new ArrayList();
    					}
    					ls.add(transColumn.getCreditAmount());
    					creditAccounts.put(transColumn.getTurqAccountingAccount().getId(),ls);    					
    					
    				}
    				else
    				{
    					List ls = (List)deptAccounts.get(transColumn.getTurqAccountingAccount().getId());
    					if(ls == null)
    					{
    						ls = new ArrayList();
    					}
    					ls.add(transColumn.getDeptAmount());
    					deptAccounts.put(transColumn.getTurqAccountingAccount().getId(),ls);    				   					
    				}
    				
    				
    			
    			}
    
    		}
    
    
    
		}
    	catch(Exception ex)
		{
    		throw ex;
    
		}
    
    
    }
    
    public void clearFields(){
    
    	 
        AccUITransactionAdd curCard = new AccUITransactionAdd(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();

    	
    }
    
    
	public void save()
	{
	
		if(verifyFields())
		{
	
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			try
			{
				
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				
				prepareAccountingMaps(creditAccounts,deptAccounts);
				
				blTransAdd.saveAccTransaction(dateTransactionDate.getDate(),txtDocumentNo.getText().trim(),2,1,null,txtTransDefinition.getText().trim(),exchangeRate,creditAccounts,deptAccounts,false);
	
			
				msg.setMessage(Messages.getString("AccUITransactionAdd.16")); //$NON-NLS-1$
				msg.open();
				clearFields();
			}

			catch(Exception ex)
			{
				ex.printStackTrace();
				msg.setMessage(Messages.getString("AccUITransactionAdd.17")); //$NON-NLS-1$
				msg.open();
	
			}
		}
	
	
	}
	
	
	
	
	
	void calculateTotalDeptAndCredit()
	{
	    TurquazDecimalFormat df = new TurquazDecimalFormat();
	    TableItem items[] = tableTransactionColumns.getItems();
	    totalCredit=new BigDecimal(0);
	    totalDept =new BigDecimal(0);
    
		for(int i=0; i<items.length;i++){
		TurqAccountingTransactionColumn column = (TurqAccountingTransactionColumn)((AccUITransactionAddTableRow)items[i].getData()).getDBObject();
		if(column!=null&&((AccUITransactionAddTableRow)items[i].getData()).okToSave())
		{
			totalCredit =totalCredit.add(column.getCreditAmount());
			totalDept = totalDept.add(column.getDeptAmount());
		}
    
		}
	
	tableItemDept.setText(new String[]{Messages.getString("AccUITransactionAdd.19"),df.format(totalDept)}); //$NON-NLS-1$
	tableItemCredit.setText(new String[]{Messages.getString("AccUITransactionAdd.20"),df.format(totalCredit)}); //$NON-NLS-1$
	tableItemBalance.setText(new String[]{Messages.getString("AccUITransactionAdd.21"),df.format(totalCredit.subtract(totalDept))}); //$NON-NLS-1$
	
	
	}
	
	public void delete(){
	
	}
	
	public void newForm(){
		clearFields();
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
							accTransRow.getCreditAmount().toString(),accTransRow.getTransactionDefinition().toString()});
	
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
	
	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType() {
		return comboCurrencyType;
	}
	/**
	 * @param comboCurrencyType The comboCurrencyType to set.
	 */
	public void setComboCurrencyType(CCombo comboCurrencyType) {
		this.comboCurrencyType = comboCurrencyType;
	}
}
