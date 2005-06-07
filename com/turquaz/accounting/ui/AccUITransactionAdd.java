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
import java.util.Vector;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import com.turquaz.engine.ui.component.TurquazDecimalFormat;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import com.cloudgarden.resource.SWTResourceManager;


public class AccUITransactionAdd extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * @return Returns the tableTransactionColumns.
	 */
	public Table getTableTransactionColumns()
	{
		return tableTransactionColumns;
	}

	/**
	 * @return Returns the totalCredit.
	 */
	public BigDecimal getTotalCredit()
	{
		return totalCredit;
	}

	/**
	 * @return Returns the totalDept.
	 */
	public BigDecimal getTotalDept()
	{
		return totalDept;
	}

	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo()
	{
		return txtDocumentNo;
	}
	
	private BigDecimal totalCredit;
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
	BigDecimal totalDept;
	//	 Set the table column property names
	private final String ACCOUNT_CODE = AccLangKeys.STR_ACCOUNT_CODE; 
	private final String ACCOUNT_NAME = AccLangKeys.STR_ACCOUNT_NAME; 
	private final String DEFINITION = EngLangCommonKeys.STR_DESCRIPTION;
	private final String DEPT = AccLangKeys.STR_DEBIT; 
	private final String CREDIT = AccLangKeys.STR_CREDIT; 
	public TableSpreadsheetCursor cursor;
	private List columnList = new ArrayList();
	private TableItem tableItemBalance;
	private TableItem tableItemSpace;
	private TableItem tableItemCredit;
	private TableItem tableItemDept;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnTitle;
	private Table table1;
	// Set column names
	private String[] columnNames = new String[]{ACCOUNT_CODE, ACCOUNT_NAME, DEFINITION, DEPT, CREDIT};
	public SaveTableViewer tableViewer;

	public AccUITransactionAdd(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			this.setSize(688, 540);
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(AccLangKeys.STR_VOUCHER_NO);
				lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(70, 19));
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
				lblDate.setText(EngLangCommonKeys.STR_DATE); 
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
				dateTransactionDateLData.widthHint = 157;
				dateTransactionDateLData.heightHint = 23;
				dateTransactionDate.setLayoutData(dateTransactionDateLData);
			}
			{
				lblTransactionDefinition = new CLabel(this, SWT.NONE);
				lblTransactionDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); 
				GridData lblTransactionDefinitionLData = new GridData();
				lblTransactionDefinitionLData.widthHint = 62;
				lblTransactionDefinitionLData.heightHint = 19;
				lblTransactionDefinitionLData.verticalAlignment = GridData.BEGINNING;
				lblTransactionDefinition.setLayoutData(lblTransactionDefinitionLData);
			}
			{
				txtTransDefinition = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
				GridData text1LData = new GridData();
				txtTransDefinition.addVerifyListener(new VerifyListener()
				{
					public void verifyText(VerifyEvent evt)
					{
						if (evt.keyCode == SWT.TAB)
						{
							tableTransactionColumns.setFocus();
							evt.doit = false;
						}
					}
				});
				txtTransDefinition.setTextLimit(250);
				text1LData.heightHint = 27;
				text1LData.horizontalSpan = 3;
				text1LData.widthHint = 370;
				txtTransDefinition.setLayoutData(text1LData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(AccLangKeys.STR_CURRENCY_TYPE); 
			//END << lblCurrency
			//START >> comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END << comboCurrencyType
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
					tableColumnAccoutCode = new TableColumn(tableTransactionColumns, SWT.NONE);
					tableColumnAccoutCode.setText(ACCOUNT_CODE); //$NON-NLS-1$
					tableColumnAccoutCode.setWidth(121);
				}
				{
					tableColumnAccountName = new TableColumn(tableTransactionColumns, SWT.NONE);
					tableColumnAccountName.setText(ACCOUNT_NAME); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
				{
					tableColumnDefinition = new TableColumn(tableTransactionColumns, SWT.NONE);
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
					tableColumnAmount.setText(AccLangKeys.STR_PRICE); 
					tableColumnAmount.setWidth(100);
				}
				{
					tableItemDept = new TableItem(table1, SWT.NONE);
					tableItemDept.setText(AccLangKeys.STR_DEBIT); 
				}
				{
					tableItemCredit = new TableItem(table1, SWT.NONE);
					tableItemCredit.setText(AccLangKeys.STR_CREDIT); 
				}
				{
					tableItemSpace = new TableItem(table1, SWT.NONE);
				}
				{
					tableItemBalance = new TableItem(table1, SWT.NONE);
					tableItemBalance.setText(AccLangKeys.STR_BALANCE);
				}
			}
			thisLayout.numColumns = 4;
			tableTransactionColumns.setEnabled(true);
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		createTableViewer();
		fillCurrencyCombo();
		for (int i = 0; i < EngBLCommon.TABLE_ROW_COUNT; i++)
		{
			//			enter empty table rows.
			AccUITransactionAddTableRow row = new AccUITransactionAddTableRow(tableViewer.getRowList());
			tableViewer.addRow(row);
		}
	}

	public void fillCurrencyCombo()
	{
		try
		{
			HashBag currencyBag = (HashBag)EngTXCommon.doSelectTX(EngBLCommon.class.getName(),"getCurrencies",null);
			HashMap currencies = (HashMap)currencyBag.get(EngKeys.CURRENCIES);
			
			for (int k = 0; k < currencies.size(); k++)
			{
				HashMap currencyMap=(HashMap)currencies.get(new Integer(k));

				String abbr=(String)currencyMap.get(EngKeys.CURRENCY_ABBR);
				comboCurrencyType.add(abbr);
				comboCurrencyType.setData(abbr,currencyMap.get(EngKeys.CURRENCY_ID));
				
				if (((Boolean)currencyMap.get(EngKeys.DEFAULT)).booleanValue())
				{
					comboCurrencyType.setText((String)currencyMap.get(EngKeys.CURRENCY_ABBR));
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void createTableViewer()
	{
		columnList.add(ACCOUNT_CODE);
		columnList.add(ACCOUNT_NAME);
		columnList.add(DEFINITION);
		columnList.add(DEPT);
		columnList.add(CREDIT);
		//     Create the cell editors
       
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new AccountingCellEditor(tableTransactionColumns,ACCOUNT_CODE);
		editors[1] = new TextCellEditor(tableTransactionColumns);
		editors[2] = new TextCellEditor(tableTransactionColumns);
		editors[3] = new CurrencyCellEditor(tableTransactionColumns, 2);
		editors[4] = new CurrencyCellEditor(tableTransactionColumns, 2);
		// Assign the cell editors to the viewer
        tableViewer = new SaveTableViewer(tableTransactionColumns,editors);
        ((AccountingCellEditor)editors[0]).setTableViewer(tableViewer.getViewer());
        // create a TableCursor to navigate around the table
		cursor = new TableSpreadsheetCursor(tableTransactionColumns, SWT.NONE, tableViewer, true);
		cursor.setEnabled(true);
		tableViewer.addChangeListener(new ITableRowListViewer()
		{
			public void updateRow(ITableRow row)
			{
				calculateTotalDeptAndCredit();
				Vector vec = tableViewer.getRowList().getTasks();
				int index = vec.indexOf(row);
				if (index == vec.size() - 1)
				{
					if (row.okToSave())
					{
						AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(tableViewer.getRowList());
						tableViewer.addRow(row2);
					}
				}
			}

			public void removeRow(ITableRow row)
			{
				calculateTotalDeptAndCredit();
			}

			public void addRow(ITableRow row)
			{
				calculateTotalDeptAndCredit();
			}
		});
		
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer.addSortingSupport(columnTypes);
	}

	public boolean verifyFields()
	{
		try
		{
			calculateTotalDeptAndCredit();
			if (totalCredit.doubleValue() <= 0)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_VOUCHER_AMOUNT_NOT_ZERO); 
				return false;
			}
			if (totalCredit.doubleValue() != totalDept.doubleValue())
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_TOTAL_CREDIT_SHOULD_EQUAL_DEBIT); 	
				return false;
			}
			else if (tableTransactionColumns.getItems().length == 0)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_ENTER_AT_LEAST_ONE_ROW); 
				return false;
			}
			return true;
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
			return false;
		}
	}
	
	public List getTransactionColumns()
	{
		List transColumns = new ArrayList();
		TableItem items[] = tableTransactionColumns.getItems();		
		for (int i = 0; i < items.length; i++)
		{
			AccUITransactionAddTableRow row = (AccUITransactionAddTableRow) items[i].getData();
			if (row.okToSave())
			{
				transColumns.add(row.getDBObject());
			}
		}
		return transColumns;
	}

	public void clearFields()
	{
		AccUITransactionAdd curCard = new AccUITransactionAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void save()
	{
		if (verifyFields())
		{
			try
			{				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_DATE,dateTransactionDate.getDate());
				argMap.put(AccKeys.ACC_DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(AccKeys.ACC_TYPE,new Integer(2));
				argMap.put(AccKeys.ACC_MODULE_ID,new Integer(1));
				argMap.put(AccKeys.ACC_SEQUENCE_ID,null);
				argMap.put(AccKeys.ACC_DEFINITION,txtTransDefinition.getText().trim());
				argMap.put(EngKeys.CURRENCY_ID,comboCurrencyType.getData(comboCurrencyType.getText().trim()));
				argMap.put(AccKeys.ACC_TRANSACTIONS,getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionAdd.class.getName(),"saveAccTransactionFromUI",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				clearFields();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}

	void calculateTotalDeptAndCredit()
	{
		TurquazDecimalFormat df = new TurquazDecimalFormat();
		TableItem items[] = tableTransactionColumns.getItems();
		totalCredit = new BigDecimal(0);
		totalDept = new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			HashMap transRow = (HashMap)((AccUITransactionAddTableRow) items[i].getData()).getDBObject();
			if (transRow != null && ((AccUITransactionAddTableRow) items[i].getData()).okToSave())
			{
				totalCredit = totalCredit.add((BigDecimal)transRow.get(EngKeys.CREDIT_AMOUNT));
				totalDept = totalDept.add((BigDecimal)transRow.get(EngKeys.DEPT_AMOUNT));
			}
		}
		tableItemDept.setText(new String[]{AccLangKeys.STR_DEBIT, df.format(totalDept)}); 
		tableItemCredit.setText(new String[]{AccLangKeys.STR_CREDIT, df.format(totalCredit)}); 
		tableItemBalance.setText(new String[]{AccLangKeys.STR_BALANCE, df.format(totalCredit.subtract(totalDept))}); 
	}

	public void delete()
	{
	}

	public void newForm()
	{
		clearFields();
	}

	public void search()
	{
	}

	/**
	 * @return Returns the dateTransactionDate.
	 */
	public DatePicker getDateTransactionDate()
	{
		return dateTransactionDate;
	}

	/**
	 * @return Returns the txtTransDefinition.
	 */
	public Text getTxtTransDefinition()
	{
		return txtTransDefinition;
	}

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}
}