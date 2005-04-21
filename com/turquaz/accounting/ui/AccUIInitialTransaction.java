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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
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
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUIInitialTransaction extends Composite implements SecureComposite
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
	private AccBLTransactionAdd blTransAdd = new AccBLTransactionAdd();
	private TurqCurrency baseCurrency;
	private TurqCurrency exchangeCurrency;
	private BigDecimal exchangeRatio;
	BigDecimal totalCredit;
	private CLabel lblDate;
	private DatePicker dateTransactionDate;
	private TableColumn tableColumnDefinition;
	private Text txtTransDefinition;
	private CLabel lblTransactionDefinition;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccoutCode;
	private Table tableTransactionColumns;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	BigDecimal totalDept;
	TurqAccountingTransaction accTrans = null;
	//	 Set the table column property names
	private final String ACCOUNT_CODE = Messages.getString("AccUITransactionAdd.3"); //$NON-NLS-1$
	private final String ACCOUNT_NAME = Messages.getString("AccUITransactionAdd.4"); //$NON-NLS-1$
	private final String DEFINITION = Messages.getString("AccUITransactionAdd.5"); //$NON-NLS-1$
	private final String DEPT = Messages.getString("AccUITransactionAdd.6"); //$NON-NLS-1$
	private final String CREDIT = Messages.getString("AccUITransactionAdd.7"); //$NON-NLS-1$
	TableCursor cursor;
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
	private String[] columnNames = new String[]{ACCOUNT_CODE, ACCOUNT_NAME, DEFINITION, DEPT, CREDIT};
	public TableViewer tableViewer;

	public AccUIInitialTransaction(Composite parent, int style)
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
			this.setSize(688, 540);
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				lblDocumentNo.setText(Messages.getString("AccUITransactionAdd.0")); //$NON-NLS-1$
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
				dateTransactionDateLData.widthHint = 168;
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
				text1LData.heightHint = 30;
				text1LData.horizontalSpan = 3;
				text1LData.widthHint = 381;
				txtTransDefinition.setLayoutData(text1LData);
			}
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
			
			accTrans = (TurqAccountingTransaction)EngTXCommon.doSingleTX(AccBLTransactionUpdate.class.getName(),"getInitialTransaction",null);
			
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		createTableViewer();
		// create a TableCursor to navigate around the table
		cursor = new TableSpreadsheetCursor(tableTransactionColumns, SWT.NONE, tableViewer, rowList, true);
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
			}
		});
		fillTable();
	}

	public void fillTable()
	{
		try
		{
			if (accTrans != null)
			{
				txtDocumentNo.setText(accTrans.getTransactionDocumentNo());
				txtTransDefinition.setText(accTrans.getTransactionDescription());
				dateTransactionDate.setDate(accTrans.getTransactionsDate());
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doSingleTX(AccBLTransactionUpdate.class.getName(),"initiliazeTransactionRows",argMap);
				
				Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
				Iterator it = transactionRows.iterator();
				TurqAccountingTransactionColumn transRow;
				TableItem item;
				while (it.hasNext())
				{
					transRow = (TurqAccountingTransactionColumn) it.next();
					ITableRow row = new AccUITransactionAddTableRow(rowList);
					row.setDBObject(transRow);
					rowList.addTask(row);
				}
				// add last empty row
				AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(rowList);
				rowList.addTask(row2);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void createTableViewer()
	{
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
		editors[3] = new CurrencyCellEditor(tableTransactionColumns, 2);
		editors[4] = new CurrencyCellEditor(tableTransactionColumns, 2);
		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer, rowList);
		tableViewer.setCellModifier(new TurquazCellModifier(columnList, contentProvider));
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(new TurquazLabelProvider());
		tableViewer.setInput(rowList);
		rowList.addChangeListener(new ITableRowListViewer()
		{
			public void updateRow(ITableRow row)
			{
				calculateTotalDeptAndCredit();
				Vector vec = rowList.getTasks();
				int index = vec.indexOf(row);
				if (index == vec.size() - 1)
				{
					if (row.okToSave())
					{
						AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(rowList);
						rowList.addTask(row2);
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
	}

	public boolean okToDelete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		msg.setMessage(Messages.getString("AccUITransactionAdd.8")); //$NON-NLS-1$
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
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		calculateTotalDeptAndCredit();
		if (totalCredit.doubleValue() != totalDept.doubleValue())
		{
			msg.setMessage(Messages.getString("AccUITransactionAdd.12")); //$NON-NLS-1$	
			msg.open();
			return false;
		}
		else if (tableTransactionColumns.getItems().length == 0)
		{
			msg.setMessage(Messages.getString("AccUITransactionAdd.13")); //$NON-NLS-1$	
			msg.open();
			return false;
		}
		else if (dateTransactionDate.getData() == null)
		{
			msg.setMessage(Messages.getString("AccUITransactionAdd.14")); //$NON-NLS-1$	
			msg.open();
			dateTransactionDate.setFocus();
			return false;
		}
		else
		{
			return true;
		}
	}

	public void saveTransactionRows(Integer transId) throws Exception
	{
		try
		{
			TableItem items[] = tableTransactionColumns.getItems();
			for (int i = 0; i < items.length; i++)
			{
				AccUITransactionAddTableRow row = (AccUITransactionAddTableRow) items[i].getData();
				//TODO acc trans column exRate
				if (row.okToSave())
				{
					
					HashMap argMap = new HashMap();
					argMap.put(AccKeys.ACC_TRANS_ROW,row.getDBObject());
					argMap.put(AccKeys.ACC_TRANS_ID,transId);
					argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
					
					EngTXCommon.doTransactionTX(AccBLTransactionAdd.class.getName(),"saveAccountingTransactionRow",argMap);
					
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/** Auto-generated event handler method */
	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				//TODO acc trans exRate
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				prepareAccountingMaps(creditAccounts, deptAccounts);
			
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				argMap.put(AccKeys.ACC_DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, dateTransactionDate.getDate());
				argMap.put(AccKeys.ACC_DEFINITION,	txtTransDefinition.getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(AccKeys.ACC_DEPT_ACCOUNT_MAP,deptAccounts);
				argMap.put(AccKeys.ACC_CREDIT_ACCOUNT_MAP,creditAccounts);
				argMap.put(AccKeys.ACC_SUM_ROWS,new Boolean(false));
				
				EngTXCommon.doTransactionTX(AccBLTransactionUpdate.class.getName(),"updateTransaction",argMap);
				
				msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.2")); //$NON-NLS-1$
				msg.open();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.3")); //$NON-NLS-1$
			msg.open();
		}
	}

	public void prepareAccountingMaps(Map creditAccounts, Map deptAccounts) throws Exception
	{
		creditAccounts.clear();
		deptAccounts.clear();
		try
		{
			TableItem items[] = tableTransactionColumns.getItems();
			for (int i = 0; i < items.length; i++)
			{
				AccUITransactionAddTableRow row = (AccUITransactionAddTableRow) items[i].getData();
				if (row.okToSave())
				{
					TurqAccountingTransactionColumn transColumn = (TurqAccountingTransactionColumn) row.getDBObject();
					if (transColumn.getCreditAmount().doubleValue() > 0)
					{
						List ls = (List) creditAccounts.get(transColumn.getTurqAccountingAccount().getId());
						if (ls == null)
						{
							ls = new ArrayList();
						}
						ls.add(transColumn.getCreditAmount());
						creditAccounts.put(transColumn.getTurqAccountingAccount().getId(), ls);
					}
					else
					{
						List ls = (List) deptAccounts.get(transColumn.getTurqAccountingAccount().getId());
						if (ls == null)
						{
							ls = new ArrayList();
						}
						ls.add(transColumn.getDeptAmount());
						deptAccounts.put(transColumn.getTurqAccountingAccount().getId(), ls);
					}
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
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
			TurqAccountingTransactionColumn column = (TurqAccountingTransactionColumn) ((AccUITransactionAddTableRow) items[i].getData())
					.getDBObject();
			if (column != null && ((AccUITransactionAddTableRow) items[i].getData()).okToSave())
			{
				totalCredit = totalCredit.add(column.getCreditAmount());
				totalDept = totalDept.add(column.getDeptAmount());
			}
		}
		tableItemDept.setText(new String[]{Messages.getString("AccUITransactionAdd.19"), df.format(totalDept)}); //$NON-NLS-1$
		tableItemCredit.setText(new String[]{Messages.getString("AccUITransactionAdd.20"), df.format(totalCredit)}); //$NON-NLS-1$
		tableItemBalance.setText(new String[]{Messages.getString("AccUITransactionAdd.21"), df.format(totalCredit.subtract(totalDept))}); //$NON-NLS-1$
	}

	public void delete()
	{
	}

	public void newForm()
	{
	}

	public void search()
	{
	}

	/** Auto-generated event handler method */
	protected void btnAddTransactionRowMouseUp(MouseEvent evt)
	{
		Object o = new AccUITransactionRowAddDialog(this.getShell(), SWT.NULL, 2).showDialog();
		if (o != null)
		{
			TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn) o;
			TableItem item = new TableItem(tableTransactionColumns, SWT.NULL);
			item.setData(accTransRow);
			item.setText(new String[]{accTransRow.getTurqAccountingAccount().getAccountCode(),
					accTransRow.getTurqAccountingAccount().getAccountName(), accTransRow.getDeptAmount().toString(),
					accTransRow.getCreditAmount().toString(), accTransRow.getTransactionDefinition().toString()});
			calculateTotalDeptAndCredit();
		}
	}

	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt)
	{
		TableItem selection[] = tableTransactionColumns.getSelection();
		if (selection.length > 0)
		{
			selection[0].dispose();
			calculateTotalDeptAndCredit();
		}
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
	 * @param txtTransDefinition
	 *             The txtTransDefinition to set.
	 */
	public void setTxtTransDefinition(Text txtTransDefinition)
	{
		this.txtTransDefinition = txtTransDefinition;
	}
}