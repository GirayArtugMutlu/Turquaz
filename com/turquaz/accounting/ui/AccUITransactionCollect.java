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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Text;
import com.turquaz.accounting.ui.comp.CashAccountPicker;
import com.turquaz.common.HashBag;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class AccUITransactionCollect extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private CLabel lblDate;
	private CashAccountPicker comboDeptor;
	private TableItem item;
	private CLabel lblCurrency;
	private CCombo comboCurrencyType;
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
	private BigDecimal totalCredit;
	//	 Set the table column property names
	private final String ACCOUNT_CODE = AccLangKeys.STR_ACCOUNT_CODE; 
	private final String ACCOUNT_NAME = AccLangKeys.STR_ACCOUNT_NAME; 
	private final String DEFINITION = EngLangCommonKeys.STR_DESCRIPTION;
	private final String CREDIT = AccLangKeys.STR_CREDIT;
	TableCursor cursor;
	private List columnList = new ArrayList();
	// Set column names
	private String[] columnNames = new String[]{ACCOUNT_CODE, ACCOUNT_NAME, DEFINITION, CREDIT};
	public SaveTableViewer tableViewer;

	public AccUITransactionCollect(Composite parent, int style)
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
			preInitGUI();
			this.setSize(722, 471);
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lbldocumentNo = new CLabel(this, SWT.NONE);
				lbldocumentNo.setText(AccLangKeys.STR_DOCUMENT_NO); 
				GridData lbldocumentNoLData = new GridData();
				lbldocumentNoLData.verticalAlignment = GridData.BEGINNING;
				lbldocumentNoLData.widthHint = 79;
				lbldocumentNoLData.heightHint = 19;
				lbldocumentNo.setLayoutData(lbldocumentNoLData);
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
				lblDate.setLayoutData(lblDateLData);
			}
			{
				datePickerTransactionDate = new DatePicker(this, SWT.NONE);
				GridData datePickerTransactionDateLData = new GridData();
				datePickerTransactionDateLData.widthHint = 157;
				datePickerTransactionDateLData.heightHint = 23;
				datePickerTransactionDate.setLayoutData(datePickerTransactionDateLData);
			}
			{
				lblDeptor = new CLabel(this, SWT.NONE);
				lblDeptor.setText(AccLangKeys.STR_DEBTOR_ACCOUNT);
				GridData lblDeptorLData = new GridData();
				lblDeptorLData.widthHint = 105;
				lblDeptorLData.heightHint = 22;
				lblDeptor.setLayoutData(lblDeptorLData);
			}
			{
				comboDeptor = new CashAccountPicker(this, SWT.NONE);
				GridData comboDeptorLData = new GridData();
				comboDeptorLData.widthHint = 156;
				comboDeptorLData.heightHint = 17;
				comboDeptor.setLayoutData(comboDeptorLData);
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
				lblTransDefinition = new CLabel(this, SWT.NONE);
				lblTransDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); 
				GridData lblTransDefinitionLData = new GridData();
				lblTransDefinitionLData.widthHint = 78;
				lblTransDefinitionLData.heightHint = 19;
				lblTransDefinition.setLayoutData(lblTransDefinitionLData);
			}
			{
				txtTransDefinition = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
				GridData txtTransDefinitionLData = new GridData();
				txtTransDefinition.addVerifyListener(new VerifyListener()
				{
					public void verifyText(VerifyEvent evt)
					{
						if (evt.character == SWT.TAB)
						{
							tableTransactionRows.setFocus();
							evt.doit = false;
						}
					}
				});
				txtTransDefinitionLData.widthHint = 356;
				txtTransDefinitionLData.heightHint = 21;
				txtTransDefinitionLData.horizontalSpan = 3;
				txtTransDefinition.setLayoutData(txtTransDefinitionLData);
			}
			{
				tableTransactionRows = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.BORDER);
				tableTransactionRows.setHeaderVisible(true);
				tableTransactionRows.setLinesVisible(true);
				tableTransactionRows.setSize(new org.eclipse.swt.graphics.Point(415, 344));
				GridData tableTransactionRowsLData = new GridData();
				tableTransactionRowsLData.verticalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalSpan = 4;
				tableTransactionRowsLData.verticalSpan = 3;
				tableTransactionRowsLData.grabExcessHorizontalSpace = true;
				tableTransactionRowsLData.grabExcessVerticalSpace = true;
				tableTransactionRows.setLayoutData(tableTransactionRowsLData);
				{
					tableColumnAccountCode = new TableColumn(tableTransactionRows, SWT.NONE);
					tableColumnAccountCode.setText(ACCOUNT_CODE); //$NON-NLS-1$
					tableColumnAccountCode.setWidth(126);
				}
				{
					tableColumnAccountName = new TableColumn(tableTransactionRows, SWT.NONE);
					tableColumnAccountName.setText(ACCOUNT_NAME); //$NON-NLS-1$
					tableColumnAccountName.setWidth(150);
				}
				{
					txtTransactionDefinition = new TableColumn(tableTransactionRows, SWT.NONE);
					txtTransactionDefinition.setText(DEFINITION); //$NON-NLS-1$
					txtTransactionDefinition.setWidth(150);
				}
				{
					tableColumnCreditAmount = new TableColumn(tableTransactionRows, SWT.RIGHT);
					tableColumnCreditAmount.setText(CREDIT); //$NON-NLS-1$
					tableColumnCreditAmount.setWidth(100);
				}
			}
			thisLayout.numColumns = 4;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		totalCredit = new BigDecimal(0);
		fillCurrencyCombo();
		createTableViewer();
		for (int i = 0; i < EngBLCommon.TABLE_ROW_COUNT; i++)
		{
			//				enter empty table rows.
			AccUITransactionCollectTableRow row = new AccUITransactionCollectTableRow(tableViewer.getRowList());
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
		columnList.add(CREDIT);
		//     Create the cell editors
        
       
        
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new AccountingCellEditor(tableTransactionRows,ACCOUNT_CODE);
		editors[1] = new TextCellEditor(tableTransactionRows);
		editors[2] = new TextCellEditor(tableTransactionRows);
		editors[3] = new CurrencyCellEditor(tableTransactionRows, 2);
		
        tableViewer = new SaveTableViewer(tableTransactionRows,editors);
        ((AccountingCellEditor)editors[0]).setTableViewer(tableViewer.getViewer());
        
		// Assign the cell editors to the viewer
		// create a TableCursor to navigate around the table
		cursor = new TableSpreadsheetCursor(tableTransactionRows, SWT.NONE, tableViewer, true);
		cursor.setEnabled(true);
		cursor.addSelectionListener(new SelectionAdapter()
		{
			// when the TableEditor is over a cell, select the corresponding
			// rowtable
			public void widgetSelected(SelectionEvent e)
			{
			}

			// when the user hits "ENTER" in the TableCursor, pop up a
			// text/combo editor
			// so that they can change the text of the cell for
			// controlType=="input" || "select1"<br>
			// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
			public void widgetDefaultSelected(SelectionEvent e)
			{
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}
		});
		tableViewer.addChangeListener(new ITableRowListViewer()
		{
			public void updateRow(ITableRow row)
			{
				Vector vec = tableViewer.getRowList().getTasks();
				int index = vec.indexOf(row);
				if (index == vec.size() - 1)
				{
					if (row.okToSave())
					{
						AccUITransactionCollectTableRow row2 = new AccUITransactionCollectTableRow(tableViewer.getRowList());
						tableViewer.addRow(row2);
					}
				}
			}

			public void removeRow(ITableRow row)
			{
			}

			public void addRow(ITableRow row)
			{
			}
		});
		
		int columnTypes[] = new int[4];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer.addSortingSupport(columnTypes);
	}

	public boolean okToDelete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); 
		if (msg.open() == SWT.OK)
		{
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
			calculateTotalDept();
			if (totalCredit.doubleValue() <= 0)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_VOUCHER_AMOUNT_NOT_ZERO); 
				return false;
			}
			else if (tableTransactionRows.getItems().length == 0)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_ENTER_AT_LEAST_ONE_ROW); 
				return false;
			}
			else if (datePickerTransactionDate.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_ENTER_VOUCHER_DATE); 
				return false;
			}
			else if (comboDeptor.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_SELECT_DEPTOR_ACCOUNT); 
				return false;
			}
			else if (comboCurrencyType.getData(comboCurrencyType.getText().trim())==null)
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_SELECT_CURRENCY);
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

	public void save()
	{
		if (verifyFields())
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			try
			{
				/**
				 * 0 -Tahsil Fisi 1- Tediye Fisi 2- Mahsup Fisi
				 */				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_DATE,datePickerTransactionDate.getDate());
				argMap.put(AccKeys.ACC_DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(AccKeys.ACC_TYPE,new Integer(0));
				argMap.put(AccKeys.ACC_MODULE_ID,new Integer(1));
				argMap.put(AccKeys.ACC_SEQUENCE_ID,null);
				argMap.put(AccKeys.ACC_DEFINITION,txtTransDefinition.getText().trim());
				argMap.put(EngKeys.CURRENCY_ID,comboCurrencyType.getData(comboCurrencyType.getText().trim()));
				argMap.put(AccKeys.ACC_TRANSACTIONS,getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionAdd.class.getName(),"saveAccTransactionFromUI",argMap);			
				
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); 
				msg.open();
				clearFields();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}

	public void clearFields()
	{
		AccUITransactionCollect curCard = new AccUITransactionCollect(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}
	
	public List getTransactionColumns()
	{
		List transColumns=new ArrayList();		
		TableItem items[] = tableTransactionRows.getItems();
		BigDecimal total=new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			AccUITransactionCollectTableRow row = (AccUITransactionCollectTableRow) items[i].getData();
			if (row.okToSave())
			{
				HashMap transRow=(HashMap)row.getDBObject();
				transColumns.add(transRow);
				total=total.add((BigDecimal)transRow.get(EngKeys.CREDIT_AMOUNT));
			}
		}		
		if (transColumns.size() > 0)
		{
			HashMap counterRow=new HashMap();
			counterRow.put(EngKeys.CREDIT_AMOUNT, new BigDecimal(0));
			counterRow.put(EngKeys.DEPT_AMOUNT, total);
			counterRow.put(AccKeys.ACC_TRANS_ROW_DEFINITION,"");
			
			HashMap accountMap=(HashMap)comboDeptor.getData();
			counterRow.put(AccKeys.ACC_ACCOUNT,accountMap);
			
			transColumns.add(counterRow);
		}
		return transColumns;
	}

	public void search()
	{
	}

	public void newForm()
	{
		clearFields();
	}

	public void delete()
	{
	}

	void calculateTotalDept()
	{
		TableItem items[] = tableTransactionRows.getItems();
		totalCredit = new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			
			HashMap transRow = (HashMap)((AccUITransactionCollectTableRow) items[i].getData()).getDBObject();
			if (transRow != null && ((AccUITransactionCollectTableRow) items[i].getData()).okToSave())
			{
				totalCredit = totalCredit.add((BigDecimal)transRow.get(EngKeys.CREDIT_AMOUNT));
			}
		}
	}

	/**
	 * @return Returns the comboDeptor.
	 */
	public CashAccountPicker getComboDeptor()
	{
		return comboDeptor;
	}

	/**
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}

	/**
	 * @return Returns the datePickerTransactionDate.
	 */
	public DatePicker getDatePickerTransactionDate()
	{
		return datePickerTransactionDate;
	}

	/**
	 * @return Returns the tableTransactionRows.
	 */
	public Table getTableTransactionRows()
	{
		return tableTransactionRows;
	}

	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo()
	{
		return txtDocumentNo;
	}

	/**
	 * @return Returns the txtTransDefinition.
	 */
	public Text getTxtTransDefinition()
	{
		return txtTransDefinition;
	}

}