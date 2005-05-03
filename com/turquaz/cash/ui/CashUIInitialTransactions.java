package com.turquaz.cash.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
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
public class CashUIInitialTransactions extends org.eclipse.swt.widgets.Composite
{
	private Table tableBankInitialTransactions;
	private TableColumn tableColumnBankName;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnBankCode;
	final static String CASH_CODE = CashLangKeys.STR_CASH_CODE;
	final static String CASH_NAME = CashLangKeys.STR_CASH_NAME;
	final static String CASH_DEPT = EngLangCommonKeys.STR_DEPT;
	final static String CASH_CREDIT = EngLangCommonKeys.STR_CREDIT;
	TableCursor cursor;
	TableRowList rowList = new TableRowList();
	private List columnList = new ArrayList();
	// Set column names
	private String[] columnNames = new String[]{CASH_CODE, CASH_NAME, CASH_DEPT, CASH_CREDIT};
	public TableViewer tableViewer;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public CashUIInitialTransactions(org.eclipse.swt.widgets.Composite parent, int style)
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
					tableColumnBankCode.setText(CASH_CODE);
				}
				{
					tableColumnBankName = new TableColumn(tableBankInitialTransactions, SWT.NONE);
					tableColumnBankName.setText(CASH_NAME);
					tableColumnBankName.setWidth(161);
				}
				{
					tableColumnDept = new TableColumn(tableBankInitialTransactions, SWT.RIGHT);
					tableColumnDept.setText(CASH_DEPT);
					tableColumnDept.setWidth(100);
				}
				{
					tableColumnCredit = new TableColumn(tableBankInitialTransactions, SWT.RIGHT);
					tableColumnCredit.setText(CASH_CREDIT);
					tableColumnCredit.setWidth(100);
				}
			}
			createTableViewer();
			fillTable();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void createTableViewer()
	{
		columnList.add(CASH_CODE);
		columnList.add(CASH_NAME);
		columnList.add(CASH_DEPT);
		columnList.add(CASH_CREDIT);
		tableViewer = new TableViewer(tableBankInitialTransactions);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);
		//     Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new TextCellEditor(tableBankInitialTransactions);
		editors[1] = new TextCellEditor(tableBankInitialTransactions);
		editors[2] = new CurrencyCellEditor(tableBankInitialTransactions, 2);
		editors[3] = new CurrencyCellEditor(tableBankInitialTransactions, 2);
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
					EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"update",argMap); //$NON-NLS-1$
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(this.getClass(),ex,getShell());
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
			List list =(List)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"getInitialTransactions",null); //$NON-NLS-1$
			TurqCashTransactionRow curTrans;
			for (int i = 0; i < list.size(); i++)
			{
				curTrans = (TurqCashTransactionRow) list.get(i);
				CashUIInitialTransactionTableRow row = new CashUIInitialTransactionTableRow();
				row.setDBObject(curTrans);
				rowList.addTask(row);
				rowList.taskChanged(row);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
        }
	}
}