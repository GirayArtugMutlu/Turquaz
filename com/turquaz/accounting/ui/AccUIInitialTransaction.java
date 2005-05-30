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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
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
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
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
public class AccUIInitialTransaction extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
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

	//	 Set the table column property names
	private final String ACCOUNT_CODE = AccLangKeys.STR_ACCOUNT_CODE; 
	private final String ACCOUNT_NAME = AccLangKeys.STR_ACCOUNT_NAME; 
	private final String DEFINITION = EngLangCommonKeys.STR_DESCRIPTION; 
	private final String DEPT = AccLangKeys.STR_DEBIT; 
	private final String CREDIT = AccLangKeys.STR_CREDIT; 
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
	
	private HashBag accountBag=null;

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
				dateTransactionDateLData.widthHint = 168;
				dateTransactionDateLData.heightHint = 22;
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

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			accountBag = (HashBag) EngTXCommon.doSelectTX(AccBLTransactionUpdate.class
					.getName(), "getInitialTransaction", null);
			createTableViewer();
			// create a TableCursor to navigate around the table
			cursor = new TableSpreadsheetCursor(tableTransactionColumns, SWT.NONE, tableViewer, rowList, true);
			cursor.setEnabled(true);
			fillTable();
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void fillTable() throws Exception
	{
		try
		{
			if (accountBag != null)
			{
				txtDocumentNo.setText((String)accountBag.get(AccKeys.ACC_TRANSACTION_DOC_NO));
				txtTransDefinition.setText((String)accountBag.get(AccKeys.ACC_TRANSACTION_DEFINITION));
				dateTransactionDate.setDate((Date)accountBag.get(AccKeys.ACC_TRANSACTION_DATE));

				HashMap transRows=(HashMap)accountBag.get(AccKeys.ACC_TRANSACTION_ROWS);

				for(int k=0; k<transRows.size(); k++)
				{
					HashMap transRow=(HashMap)transRows.get(new Integer(k));
					ITableRow row=new AccUITransactionAddTableRow(rowList);
					row.setDBObject(transRow);
					rowList.addTask(row);
					
				}				
				AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(rowList);
				rowList.addTask(row2);
			}
		}
		catch (Exception ex)
		{
			throw ex;
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
		editors[0] = new AccountingCellEditor(tableTransactionColumns,ACCOUNT_CODE);
		editors[1] = new TextCellEditor(tableTransactionColumns);
		editors[2] = new TextCellEditor(tableTransactionColumns);
		editors[3] = new CurrencyCellEditor(tableTransactionColumns, 2);
		editors[4] = new CurrencyCellEditor(tableTransactionColumns, 2);
        
       
		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
        ((AccountingCellEditor)editors[0]).setTableViewer(tableViewer);
        
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

	public boolean verifyFields()
	{
		calculateTotalDeptAndCredit();
		if (totalCredit.doubleValue() != totalDept.doubleValue())
		{
			EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_TOTAL_CREDIT_SHOULD_EQUAL_DEBIT,SWT.ICON_INFORMATION);
			return false;
		}
		else if (tableTransactionColumns.getItems().length == 0)
		{
			EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_ENTER_AT_LEAST_ONE_ROW,SWT.ICON_INFORMATION); 
			return false;
		}
		else if (dateTransactionDate.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_ENTER_VOUCHER_DATE,SWT.ICON_INFORMATION); 
			dateTransactionDate.setFocus();
			return false;
		}
		else
		{
			return true;
		}
	}

	/** Auto-generated event handler method */
	public void save()
	{
		try
		{
			if (verifyFields())
			{
				//TODO acc trans exRate
			
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_ID,accountBag.get(AccKeys.ACC_TRANS_ID));
				argMap.put(AccKeys.ACC_DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, dateTransactionDate.getDate());
				argMap.put(AccKeys.ACC_DEFINITION,	txtTransDefinition.getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE_ID,EngBLCommon.getBaseCurrencyExchangeRate().getId());
				argMap.put(AccKeys.ACC_TRANSACTIONS,getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionUpdate.class.getName(),"updateTransaction",argMap);
				EngUICommon.showUpdatedSuccesfullyMessage(getShell());
                newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public List getTransactionColumns()
	{
		List transcolumns=new ArrayList();
		TableItem items[] = tableTransactionColumns.getItems();
		for (int i = 0; i < items.length; i++)
		{
			AccUITransactionAddTableRow row = (AccUITransactionAddTableRow) items[i].getData();
			if (row.okToSave())
			{
				transcolumns.add(row.getDBObject());
			}
		}
		return transcolumns;
	}

	void calculateTotalDeptAndCredit()
	{
		TurquazDecimalFormat df = new TurquazDecimalFormat();
		TableItem items[] = tableTransactionColumns.getItems();
		totalCredit = new BigDecimal(0);
		totalDept = new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			HashMap transRow = (HashMap) ((AccUITransactionAddTableRow) items[i].getData())
					.getDBObject();
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
        AccUIInitialTransaction curCard = new AccUIInitialTransaction(this.getParent(), this.getStyle());
        CTabFolder tabfld = (CTabFolder) this.getParent();
        tabfld.getSelection().setControl(curCard);
        this.dispose();
        
        
	}

	public void search()
	{
	}

}