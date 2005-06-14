package com.turquaz.cash.ui;

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
 * @author  Onsel
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.common.HashBag;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

public class CashUICashTransactionSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compSearchPanel;
	private CLabel lblCashCard;
	private CLabel lblEndDate;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnType;
	private TableColumn tableColumnDate;
	private DatePicker datePickerEnd;
	private DatePicker datePickerStart;
	private CLabel lblStartDate;
	private CashCardPicker txtCashCard;
	private Text txtDefinition;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDefinition;
	private CLabel lblDefinition;
	private Table tableCashTransactions;
	private Calendar cal = Calendar.getInstance();
	private SearchTableViewer tableViewer = null;

	public CashUICashTransactionSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(627, 377);
			{
				compSearchPanel = new Composite(this, SWT.NONE);
				GridLayout compSearchPanelLayout = new GridLayout();
				GridData compSearchPanelLData = new GridData();
				compSearchPanelLData.grabExcessHorizontalSpace = true;
				compSearchPanelLData.horizontalAlignment = GridData.FILL;
				compSearchPanelLData.heightHint = 74;
				compSearchPanel.setLayoutData(compSearchPanelLData);
				compSearchPanelLayout.numColumns = 4;
				compSearchPanel.setLayout(compSearchPanelLayout);
				{
					lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
					lblCashCard.setText(CashLangKeys.STR_CASH_CARD);
					GridData lblCashCardLData = new GridData();
					lblCashCardLData.widthHint = 59;
					lblCashCardLData.heightHint = 18;
					lblCashCard.setLayoutData(lblCashCardLData);
				}
				{
					txtCashCard = new CashCardPicker(compSearchPanel, SWT.NONE);
					GridData txtCashCardLData = new GridData();
					txtCashCardLData.widthHint = 191;
					txtCashCardLData.heightHint = 16;
					txtCashCard.setLayoutData(txtCashCardLData);
				}
				{
					lblDefinition = new CLabel(compSearchPanel, SWT.NONE);
					lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
				}
				{
					txtDefinition = new Text(compSearchPanel, SWT.NONE);
					GridData txtDefinitionLData = new GridData();
					txtDefinitionLData.widthHint = 214;
					txtDefinitionLData.heightHint = 17;
					txtDefinition.setLayoutData(txtDefinitionLData);
				}
				{
					lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
				}
				{
					datePickerStart = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePickerStartLData = new GridData();
					datePickerStartLData.widthHint = 125;
					datePickerStartLData.heightHint = 22;
					datePickerStart.setLayoutData(datePickerStartLData);
				}
				{
					lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
				}
				{
					datePickerEnd = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePickerEndLData = new GridData();
					datePickerEndLData.widthHint = 125;
					datePickerEndLData.heightHint = 22;
					datePickerEnd.setLayoutData(datePickerEndLData);
				}
			}
			{
				tableCashTransactions = new Table(this, SWT.FULL_SELECTION);
				GridData tableCashTransactionsLData = new GridData();
				tableCashTransactions.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableMouseDoubleClick();
					}
				});
				tableCashTransactions.setHeaderVisible(true);
				tableCashTransactions.setLinesVisible(true);
				tableCashTransactionsLData.grabExcessVerticalSpace = true;
				tableCashTransactionsLData.grabExcessHorizontalSpace = true;
				tableCashTransactionsLData.horizontalAlignment = GridData.FILL;
				tableCashTransactionsLData.verticalAlignment = GridData.FILL;
				tableCashTransactions.setLayoutData(tableCashTransactionsLData);
				{
					tableColumnDate = new TableColumn(tableCashTransactions, SWT.NONE);
					tableColumnDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnDate.setWidth(95);
				}
				{
					tableColumnDefinition = new TableColumn(tableCashTransactions, SWT.NONE);
					tableColumnDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
					tableColumnDefinition.setWidth(120);
				}
				{
					tableColumnType = new TableColumn(tableCashTransactions, SWT.NONE);
					tableColumnType.setText(EngLangCommonKeys.STR_TYPE);
					tableColumnType.setWidth(95);
				}
				{
					tableColumnDept = new TableColumn(tableCashTransactions, SWT.RIGHT);
					tableColumnDept.setWidth(103);
					tableColumnDept.setText(EngLangCommonKeys.STR_DEPT);
				}
				//START >>  tableColumnCredit
				tableColumnCredit = new TableColumn(tableCashTransactions, SWT.RIGHT);
				tableColumnCredit.setText(EngLangCommonKeys.STR_CREDIT);
				tableColumnCredit.setWidth(100);
				//END <<  tableColumnCredit
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGUI()
	{
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		datePickerStart.setDate(cal.getTime());
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCashTransactions, columnTypes, true);
	}

	public void delete()
	{
		
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCashTransactions, CashLangKeys.STR_CASH_TRANSACTIONS);
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			
			HashMap argMap = new HashMap();
			argMap.put(CashKeys.CASH_CARD_ID,txtCashCard.getCashCardId());
			argMap.put(EngKeys.DATE_START,datePickerStart.getDate());
			argMap.put(EngKeys.DATE_END,datePickerEnd.getDate());
			argMap.put(EngKeys.DEFINITION,txtDefinition.getText());
				
			List list =(List)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"searchCashTransactions",argMap); //$NON-NLS-1$
				
			Object[] row;
			BigDecimal deptAmount = new BigDecimal(0);
			BigDecimal creditAmount = new BigDecimal(0);
			String cardName, transDefinition;
			Date transDate = null;
			String type;
			Integer id;
			for (int i = 0; i < list.size(); i++)
			{
				row = (Object[]) list.get(i);
				id = (Integer) row[0];
				// cardName = row[1].toString();
				type = row[1].toString();
				if (row[2] != null)
				{
					deptAmount = (BigDecimal) row[2];
				}
				if (row[3] != null)
				{
					creditAmount = (BigDecimal) row[3];
				}
				transDate = (Date) row[4];
				transDefinition = row[5].toString();
				TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
				tableViewer.addRow(new String[]{DatePicker.formatter.format(transDate), transDefinition, type, cf.format(deptAmount),cf.format(creditAmount)}, id);
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public static boolean updateCashTransaction(Integer transId, Shell shell) throws Exception
	{
		HashMap argMap = new HashMap();
		argMap.put(EngKeys.TRANS_ID,transId);
		
		HashBag cashBag = (HashBag)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"getTransactionInfo",argMap); //$NON-NLS-1$
        
		if (((Integer)cashBag.get(CashKeys.CASH_TRANS_MODULE_ID)).intValue() != EngBLCommon.MODULE_CASH)
		{
			EngUICommon.showMessageBox(shell, CashLangKeys.MSG_ONLY_CASH_TRANSACTIONS_ARE_ALLOWED_TO_EDIT,SWT.ICON_INFORMATION);
			return false;
		}
		boolean updated = false;
        
		if (((Integer)cashBag.get(CashKeys.CASH_TRANS_TYPE_ID)).intValue() == EngBLCommon.CASH_CURRENT_COLLECT)
		{
			updated = new CashUICashCollectTransactionUpdate(shell, SWT.NULL, transId).open();
		}
		else if (((Integer)cashBag.get(CashKeys.CASH_TRANS_TYPE_ID)).intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
		{
			updated = new CashUICashPaymentTransactionUpdate(shell, SWT.NULL, transId).open();
		}
		else if (((Integer)cashBag.get(CashKeys.CASH_TRANS_TYPE_ID)).intValue() == EngBLCommon.CASH_OTHER_COLLECT)
		{
			updated = new CashUICashOtherCollectTransactionUpdate(shell, SWT.NULL, transId).open();
		}
		else if (((Integer)cashBag.get(CashKeys.CASH_TRANS_TYPE_ID)).intValue() == EngBLCommon.CASH_OTHER_PAYMENT)
		{
			updated = new CashUICashOtherPaymentTransactionUpdate(shell, SWT.NULL, transId).open();
		}
		else if (((Integer)cashBag.get(CashKeys.CASH_TRANS_TYPE_ID)).intValue() == EngBLCommon.CASH_TRANSFER_BETWEEN_CARDS)
		{
			updated = new CashUICashTransferBetweenCardsUpdate(shell, SWT.NULL, transId).open();
		}
		return updated;
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem selection[] = tableCashTransactions.getSelection();
			if (selection.length > 0)
			{
				TableItem item = selection[0];
				Integer id = (Integer) ((ITableRow) item.getData()).getDBObject();
				boolean updated = updateCashTransaction(id, getShell());
				if (updated)
					search();
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}