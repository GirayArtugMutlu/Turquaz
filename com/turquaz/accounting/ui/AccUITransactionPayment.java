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
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.SWT;
/**
 *		Tahsil Fisi 
 */
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUITransactionPayment extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private TurqCurrency baseCurrency;
	private TurqCurrency exchangeCurrency;
	private TurqCurrencyExchangeRate exchangeRate;
	private CLabel lblDate;
	private CLabel lblCreditor;
	private Text txtDefinition;
	private TableColumn tableColumnDefinition;
	private TableItem item;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private CLabel lblDefinition;
	private TableColumn tableColumnDeptAmount;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private Table tableTransactionRows;
	private CashAccountPicker comboCreditor;

	/**
	 * @return Returns the exchangeRate.
	 */
	public TurqCurrencyExchangeRate getExchangeRate()
	{
		return exchangeRate;
	}
	private Text txtDocumentNo;
	private CLabel lbldocumentNo;
	private BigDecimal totalCredit;
	private DatePicker datePickerTransactionDate;
	//	 Set the table column property names
	private final String ACCOUNT_CODE = Messages.getString("AccUITransactionPayment.4"); //$NON-NLS-1$
	private final String ACCOUNT_NAME = Messages.getString("AccUITransactionPayment.9"); //$NON-NLS-1$
	private final String DEFINITION = Messages.getString("AccUITransactionPayment.10"); //$NON-NLS-1$
	private final String DEBIT = Messages.getString("AccUITransactionPayment.11"); //$NON-NLS-1$
	TableCursor cursor;
	private List columnList = new ArrayList();
	// Set column names
	private String[] columnNames = new String[]{ACCOUNT_CODE, ACCOUNT_NAME, DEFINITION, DEBIT};
	public SaveTableViewer tableViewer;

	public AccUITransactionPayment(Composite parent, int style)
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
			this.setSize(600, 451);
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			{
				lbldocumentNo = new CLabel(this, SWT.NONE);
				lbldocumentNo.setText(Messages.getString("AccUITransactionPayment.0")); //$NON-NLS-1$
				lbldocumentNo.setSize(new org.eclipse.swt.graphics.Point(93, 18));
				GridData lbldocumentNoLData = new GridData();
				lbldocumentNoLData.widthHint = 93;
				lbldocumentNoLData.heightHint = 18;
				lbldocumentNo.setLayoutData(lbldocumentNoLData);
			}
			{
				txtDocumentNo = new Text(this, SWT.NONE);
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNoLData.widthHint = 150;
				txtDocumentNoLData.heightHint = 17;
				txtDocumentNo.setLayoutData(txtDocumentNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText(Messages.getString("AccUITransactionPayment.1")); //$NON-NLS-1$
				lblDate.setSize(new org.eclipse.swt.graphics.Point(49, 19));
				GridData lblDateLData = new GridData();
				lblDateLData.widthHint = 49;
				lblDateLData.heightHint = 19;
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
				lblCreditor = new CLabel(this, SWT.NONE);
				lblCreditor.setText(Messages.getString("AccUITransactionPayment.2")); //$NON-NLS-1$
				GridData lblCreditorLData = new GridData();
				lblCreditorLData.widthHint = 105;
				lblCreditorLData.heightHint = 19;
				lblCreditor.setLayoutData(lblCreditorLData);
			}
			{
				comboCreditor = new CashAccountPicker(this, SWT.NONE);
				GridData comboCreditorLData = new GridData();
				comboCreditorLData.widthHint = 156;
				comboCreditorLData.heightHint = 17;
				comboCreditor.setLayoutData(comboCreditorLData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(this, SWT.NONE);
			lblCurrency.setText(Messages.getString("AccUITransactionPayment.5")); //$NON-NLS-1$
			//END << lblCurrency
			//START >> comboCurrencyType
			comboCurrencyType = new CCombo(this, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END << comboCurrencyType
			{
				lblDefinition = new CLabel(this, SWT.NONE);
				lblDefinition.setText(Messages.getString("AccUITransactionPayment.3")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.V_SCROLL);
				GridData txtDefinitionLData = new GridData();
				txtDefinition.addVerifyListener(new VerifyListener()
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
				txtDefinitionLData.verticalAlignment = GridData.FILL;
				txtDefinitionLData.horizontalSpan = 3;
				txtDefinitionLData.widthHint = 355;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			{
				tableTransactionRows = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.BORDER);
				tableTransactionRows.setHeaderVisible(true);
				tableTransactionRows.setLinesVisible(true);
				tableTransactionRows.setSize(new org.eclipse.swt.graphics.Point(392, 347));
				GridData tableTransactionRowsLData = new GridData();
				tableTransactionRowsLData.verticalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
				tableTransactionRowsLData.horizontalSpan = 4;
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
					tableColumnDefinition = new TableColumn(tableTransactionRows, SWT.NONE);
					tableColumnDefinition.setText(DEFINITION); //$NON-NLS-1$
					tableColumnDefinition.setWidth(150);
				}
				{
					tableColumnDeptAmount = new TableColumn(tableTransactionRows, SWT.RIGHT);
					tableColumnDeptAmount.setText(DEBIT); //$NON-NLS-1$
					tableColumnDeptAmount.setWidth(100);
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
			//			enter empty table rows.
			AccUITransactionPaymentTableRow row = new AccUITransactionPaymentTableRow(tableViewer.getRowList());
			tableViewer.addRow(row);
		}
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
						AccUITransactionPaymentTableRow row2 = new AccUITransactionPaymentTableRow(tableViewer.getRowList());
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

	public void fillCurrencyCombo()
	{
		try
		{
			List currencies = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getCurrencies",null);
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				comboCurrencyType.add(currency.getCurrenciesAbbreviation());
				comboCurrencyType.setData(currency.getCurrenciesAbbreviation(), currency);
				if (currency.isDefaultCurrency())
				{
					comboCurrencyType.setText(currency.getCurrenciesAbbreviation());
					baseCurrency = currency;
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		try
		{
			calculateTotalCredit();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (totalCredit.doubleValue() <= 0)
			{
				msg.setMessage(Messages.getString("AccUITransactionPayment.8")); //$NON-NLS-1$
				msg.open();
				return false;
			}
			else if (tableTransactionRows.getItems().length == 0)
			{
				msg.setMessage(Messages.getString("AccUITransactionPayment.15")); //$NON-NLS-1$
				msg.open();
				return false;
			}
			else if (datePickerTransactionDate.getData() == null)
			{
				msg.setMessage(Messages.getString("AccUITransactionPayment.16")); //$NON-NLS-1$
				msg.open();
				return false;
			}
			else if (comboCreditor.getData() == null)
			{
				msg.setMessage(Messages.getString("AccUITransactionPayment.17")); //$NON-NLS-1$
				msg.open();
				return false;
			}
			else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
			{
				msg.setMessage(Messages.getString("AccUITransactionPayment.6")); //$NON-NLS-1$
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
			{
				exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePickerTransactionDate.getDate());
				if (exchangeRate == null)
				{
					msg.setMessage(Messages.getString("AccUITransactionPayment.7")); //$NON-NLS-1$
					msg.open();
					return false;
				}
			}
			else
			{
				exchangeRate = EngBLCommon.getBaseCurrencyExchangeRate();
			}
			return true;
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
			return false;
		}
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

	public void createTableViewer()
	{
		columnList.add(ACCOUNT_CODE);
		columnList.add(ACCOUNT_NAME);
		columnList.add(DEFINITION);
		columnList.add(DEBIT);
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
			// when the TableEditor is over a cell, select the corresponding rowtable
			public void widgetSelected(SelectionEvent e)
			{
			}

			// when the user hits "ENTER" in the TableCursor, pop up a text/combo editor
			// so that they can change the text of the cell for controlType=="input" || "select1"<br>
			// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
			public void widgetDefaultSelected(SelectionEvent e)
			{
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}
		});
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
				argMap.put(AccKeys.ACC_TYPE,new Integer(1));
				argMap.put(AccKeys.ACC_MODULE_ID,new Integer(1));
				argMap.put(AccKeys.ACC_SEQUENCE_ID,null);
				argMap.put(AccKeys.ACC_DEFINITION,txtDefinition.getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,exchangeRate);
				argMap.put(AccKeys.ACC_TRANSACTIONS,getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionAdd.class.getName(),"saveAccTransactionFromUI",argMap);			
				
				msg.setMessage(Messages.getString("AccUITransactionPayment.18")); //$NON-NLS-1$
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
		AccUITransactionPayment curCard = new AccUITransactionPayment(this.getParent(), this.getStyle());
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
			AccUITransactionPaymentTableRow row = (AccUITransactionPaymentTableRow) items[i].getData();
			if (row.okToSave())
			{
				TurqAccountingTransactionColumn tcol=(TurqAccountingTransactionColumn)row.getDBObject();
				transColumns.add(tcol);
				total=total.add(tcol.getDeptAmount());
			}
		}
		if (transColumns.size() > 0)
		{
			TurqAccountingTransactionColumn counterCol=new TurqAccountingTransactionColumn();
			counterCol.setCreditAmount(total);
			counterCol.setDeptAmount(new BigDecimal(0));
			counterCol.setTransactionDefinition("");
			counterCol.setTurqAccountingAccount((TurqAccountingAccount)comboCreditor.getData());
			transColumns.add(counterCol);
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

	

	/** Auto-generated event handler method */
	protected void btnAddTransactionRowMouseUp(MouseEvent evt)
	{
		//1 - Tediye Fisi
		Object o = new AccUITransactionRowAddDialog(this.getShell(), SWT.NULL, 1).showDialog();
		if (o != null)
		{
			TurqAccountingTransactionColumn accTransRow = (TurqAccountingTransactionColumn) o;
			TableItem item = new TableItem(tableTransactionRows, SWT.NONE);
			item.setData(accTransRow);
			item.setText(new String[]{accTransRow.getTurqAccountingAccount().getAccountCode(),
					accTransRow.getTurqAccountingAccount().getAccountName(), accTransRow.getDeptAmount().toString(),
					accTransRow.getTransactionDefinition().toString()});
		}
	}

	/** Auto-generated event handler method */
	protected void btnRemoveTransactionRowMouseUp(MouseEvent evt)
	{
		TableItem selection[] = tableTransactionRows.getSelection();
		if (selection.length > 0)
		{
			selection[0].dispose();
		}
	}

	void calculateTotalCredit()
	{
		TableItem items[] = tableTransactionRows.getItems();
		totalCredit = new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			TurqAccountingTransactionColumn column = (TurqAccountingTransactionColumn) ((AccUITransactionPaymentTableRow) items[i]
					.getData()).getDBObject();
			if (column != null && ((AccUITransactionPaymentTableRow) items[i].getData()).okToSave())
			{
				totalCredit = totalCredit.add(column.getDeptAmount());
			}
		}
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
	 * @return Returns the comboCurrencyType.
	 */
	public CCombo getComboCurrencyType()
	{
		return comboCurrencyType;
	}

	/**
	 * @param comboCurrencyType
	 *             The comboCurrencyType to set.
	 */
	public void setComboCurrencyType(CCombo comboCurrencyType)
	{
		this.comboCurrencyType = comboCurrencyType;
	}

	/**
	 * @return Returns the comboCreditor.
	 */
	public CashAccountPicker getComboCreditor()
	{
		return comboCreditor;
	}

	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	/**
	 * @param txtDefinition
	 *             The txtDefinition to set.
	 */
	public void setTxtDefinition(Text txtDefinition)
	{
		this.txtDefinition = txtDefinition;
	}
}