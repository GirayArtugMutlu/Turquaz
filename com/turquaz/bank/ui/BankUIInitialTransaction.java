package com.turquaz.bank.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
//TODO Bank Initial Transaction : currency should be added???
public class BankUIInitialTransaction extends org.eclipse.swt.widgets.Composite
{
	private Table tableBankInitialTransactions;
	private TableColumn tableColumnBankName;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnAccountNo;
	private TableColumn tableColumnBankaSubesi;
	private TableColumn tableColumnBankCode;
	final static String BANK_CODE = Messages.getString("BankUIInitialTransaction.0"); //$NON-NLS-1$
	final static String BANK_NAME = Messages.getString("BankUIInitialTransaction.1"); //$NON-NLS-1$
	final static String BANK_BRANCH_NAME = Messages.getString("BankUIInitialTransaction.2"); //$NON-NLS-1$
	final static String BANK_ACCOUNT_NO = Messages.getString("BankUIInitialTransaction.3"); //$NON-NLS-1$
	final static String BANK_DEPT = Messages.getString("BankUIInitialTransaction.4"); //$NON-NLS-1$
	final static String BANK_CREDIT = Messages.getString("BankUIInitialTransaction.5"); //$NON-NLS-1$
	TableCursor cursor;
	TableRowList rowList = new TableRowList();
	private List columnList = new ArrayList();
	// Set column names
	private String[] columnNames = new String[]{BANK_CODE, BANK_NAME, BANK_BRANCH_NAME, BANK_ACCOUNT_NO, BANK_DEPT, BANK_CREDIT};
	public TableViewer tableViewer;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public BankUIInitialTransaction(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(579, 290);
			{
				tableBankInitialTransactions = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
				GridData tableBankInitialTransactionsLData = new GridData();
				tableBankInitialTransactions.setLinesVisible(true);
				tableBankInitialTransactions.setHeaderVisible(true);
				tableBankInitialTransactionsLData.grabExcessHorizontalSpace = true;
				tableBankInitialTransactionsLData.horizontalAlignment = GridData.FILL;
				tableBankInitialTransactionsLData.verticalAlignment = GridData.FILL;
				tableBankInitialTransactionsLData.grabExcessVerticalSpace = true;
				tableBankInitialTransactions.setLayoutData(tableBankInitialTransactionsLData);
				{
					tableColumnBankCode = new TableColumn(tableBankInitialTransactions, SWT.NONE);
					tableColumnBankCode.setWidth(100);
					tableColumnBankCode.setText(BANK_CODE);
				}
				{
					tableColumnBankName = new TableColumn(tableBankInitialTransactions, SWT.NONE);
					tableColumnBankName.setText(BANK_NAME);
					tableColumnBankName.setWidth(83);
				}
				{
					tableColumnBankaSubesi = new TableColumn(tableBankInitialTransactions, SWT.NONE);
					tableColumnBankaSubesi.setText(BANK_BRANCH_NAME);
					tableColumnBankaSubesi.setWidth(85);
				}
				{
					tableColumnAccountNo = new TableColumn(tableBankInitialTransactions, SWT.NONE);
					tableColumnAccountNo.setText(BANK_ACCOUNT_NO);
					tableColumnAccountNo.setWidth(87);
				}
				{
					tableColumnDept = new TableColumn(tableBankInitialTransactions, SWT.RIGHT);
					tableColumnDept.setText(BANK_DEPT);
					tableColumnDept.setWidth(100);
				}
				{
					tableColumnCredit = new TableColumn(tableBankInitialTransactions, SWT.RIGHT);
					tableColumnCredit.setText(BANK_CREDIT);
					tableColumnCredit.setWidth(100);
				}
			}
			createTableViewer();
			fillTable();
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createTableViewer()
	{
		columnList.add(BANK_CODE);
		columnList.add(BANK_NAME);
		columnList.add(BANK_BRANCH_NAME);
		columnList.add(BANK_ACCOUNT_NO);
		columnList.add(BANK_DEPT);
		columnList.add(BANK_CREDIT);
		tableViewer = new TableViewer(tableBankInitialTransactions);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);
		//     Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new TextCellEditor(tableBankInitialTransactions);
		editors[1] = new TextCellEditor(tableBankInitialTransactions);
		editors[2] = new TextCellEditor(tableBankInitialTransactions);
		editors[3] = new TextCellEditor(tableBankInitialTransactions);
		editors[4] = new CurrencyCellEditor(tableBankInitialTransactions, 2);
		editors[5] = new CurrencyCellEditor(tableBankInitialTransactions, 2);
		TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer, rowList);
		tableViewer.setCellModifier(new TurquazCellModifier(columnList, contentProvider));
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(new TurquazLabelProvider());
		tableViewer.setInput(rowList);
		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		//		 create a TableCursor to navigate around the table
		cursor = new TableCursor(tableBankInitialTransactions, SWT.NONE);
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
		cursor.addMouseListener(new MouseAdapter()
		{
			public void mouseDoubleClick(MouseEvent arg0)
			{
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}
		});
		// Listener for rowList
		rowList.addChangeListener(new ITableRowListViewer()
		{
			public void updateRow(ITableRow row)
			{
				try
				{
					HashMap argMap=new HashMap();
					argMap.put(EngKeys.OBJECT,row.getDBObject());
					EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"update",argMap);
				}
				catch (Exception ex)
				{
					Logger loger = Logger.getLogger(this.getClass());
					loger.error("Exception Caught", ex);
					ex.printStackTrace();
				}
			}

			public void removeRow(ITableRow row)
			{
			}

			public void addRow(ITableRow row)
			{
			}
		});
	}

	public void fillTable()
	{
		try
		{
			List list =(List)EngTXCommon.doSingleTX(BankBLTransactionSearch.class.getName(),"getBankInitialTransactions",null);
			TurqBanksTransaction curTrans;
			for (int i = 0; i < list.size(); i++)
			{
				curTrans = (TurqBanksTransaction) list.get(i);
				BankUIInitialTransactionTableRow row = new BankUIInitialTransactionTableRow();
				row.setDBObject(curTrans);
				rowList.addTask(row);
				rowList.taskChanged(row);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), ex.getMessage(), SWT.ICON_ERROR);
		}
	}
}