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
 * @author  Cem Dayanik
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCashTransaction;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashUICashCardDailyAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compSearchPanel;
	private CLabel lblCashCard;
	private TableColumn tableColumnPayment;
	private TableColumn tableColumnCollect;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnTransType;
	private TableColumn tableColumnDate;
	private Table tableCashTrans;
	private DatePicker datePicker;
	private CLabel lblStartDate;
	private CashCardPicker cashCardPicker;
	private SearchTableViewer tableViewer = null;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public CashUICashCardDailyAbstract(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(631, 395);
			{
				compSearchPanel = new Composite(this, SWT.NONE);
				GridLayout compSearchPanelLayout = new GridLayout();
				compSearchPanelLayout.numColumns = 2;
				GridData compSearchPanelLData = new GridData();
				compSearchPanelLData.heightHint = 72;
				compSearchPanelLData.grabExcessHorizontalSpace = true;
				compSearchPanelLData.horizontalAlignment = GridData.FILL;
				compSearchPanel.setLayoutData(compSearchPanelLData);
				compSearchPanel.setLayout(compSearchPanelLayout);
				{
					lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
					lblCashCard.setText(CashLangKeys.STR_CASH_CARD);
				}
				{
					cashCardPicker = new CashCardPicker(compSearchPanel, SWT.NONE);
					GridData cashCardPickerLData = new GridData();
					cashCardPickerLData.widthHint = 157;
					cashCardPickerLData.heightHint = 17;
					cashCardPicker.setLayoutData(cashCardPickerLData);
				}
				{
					lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_DATE);
				}
				{
					datePicker = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePickerLData = new GridData();
					datePickerLData.widthHint = 157;
					datePickerLData.heightHint = 23;
					datePicker.setLayoutData(datePickerLData);
				}
			}
			{
				tableCashTrans = new Table(this, SWT.FULL_SELECTION);
				GridData tableCashTransLData = new GridData();
				tableCashTrans.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableCashTransMouseDoubleClick(evt);
					}
				});
				tableCashTrans.setHeaderVisible(true);
				tableCashTrans.setLinesVisible(true);
				tableCashTransLData.grabExcessHorizontalSpace = true;
				tableCashTransLData.horizontalAlignment = GridData.FILL;
				tableCashTransLData.grabExcessVerticalSpace = true;
				tableCashTransLData.verticalAlignment = GridData.FILL;
				tableCashTrans.setLayoutData(tableCashTransLData);
				{
					tableColumnDate = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnDate.setWidth(67);
				}
				{
					tableColumnTransType = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnTransType.setText(EngLangCommonKeys.STR_TYPE);
					tableColumnTransType.setWidth(100);
				}
				{
					tableColumnDefinition = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
					tableColumnDefinition.setWidth(208);
				}
				{
					tableColumnCollect = new TableColumn(tableCashTrans, SWT.RIGHT);
					tableColumnCollect.setText(EngLangCommonKeys.STR_DEPT);
					tableColumnCollect.setWidth(100);
				}
				{
					tableColumnPayment = new TableColumn(tableCashTrans, SWT.RIGHT);
					tableColumnPayment.setText(EngLangCommonKeys.STR_CREDIT);
					tableColumnPayment.setWidth(100);
				}
			}
			this.layout();
			PostInitGui();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void PostInitGui()
	{
		createTableViewer();
	}

	public boolean verifyFields()
	{
		if (cashCardPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(),CashLangKeys.MSG_SELECT_CASH_CARD,SWT.ICON_WARNING);
			cashCardPicker.setFocus();
			return false;
		}
		return true;
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCashTrans, columnTypes, true);
	}

	private void tableCashTransMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem selection[] = tableCashTrans.getSelection();
			if (selection.length > 0)
			{
				TableItem item = selection[0];
				Integer id = (Integer) ((ITableRow) item.getData()).getDBObject();
				if (id == null)
				{
					return;
				}
				HashMap argMap = new HashMap();
				argMap.put(EngKeys.TRANS_ID,id);
				
				TurqCashTransaction cashTrans =(TurqCashTransaction)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"initializeCashTransaction",argMap);
				
				if (cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue() != EngBLCommon.MODULE_CASH)
				{
					EngUICommon.showMessageBox(this.getShell(), CashLangKeys.MSG_ONLY_CASH_TRANSACTIONS_ARE_ALLOWED_TO_EDIT);
					return;
				}
				boolean updated = false;
				if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_COLLECT)
				{
					updated = new CashUICashCollectTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
				{
					updated = new CashUICashPaymentTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_COLLECT)
				{
					updated = new CashUICashOtherCollectTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_PAYMENT)
				{
					updated = new CashUICashOtherPaymentTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_TRANSFER_BETWEEN_CARDS)
				{
					updated = new CashUICashTransferBetweenCardsUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				if (updated)
					search();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void delete()
	{
		//TODO should be implemented..
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCashTrans, CashLangKeys.TITLE_DAILY_CASH_CARD_ABSTRACT);
	}

	public void search()
	{
		if (verifyFields())
		{
			try
			{
				tableViewer.removeAll();
				TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
				BigDecimal total_dept = new BigDecimal(0);
				BigDecimal total_credit = new BigDecimal(0);
				BigDecimal deferred_dept = new BigDecimal(0);
				BigDecimal deferred_credit = new BigDecimal(0);
				
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD,cashCardPicker.getData());
				argMap.put(EngKeys.DATE_END,datePicker.getDate());
				List deferred =(List)EngTXCommon.doSelectTX( CashBLCashTransactionSearch.class.getName(),"getDeferredTotal",argMap);
				
				if (deferred.size() != 0)
				{
					Object[] amounts = (Object[]) deferred.get(0);
					BigDecimal dept = (BigDecimal) amounts[0];
					BigDecimal credit = (BigDecimal) amounts[1];
					if (dept.compareTo(credit) == 1)
					{
						dept = dept.subtract(credit);
						credit = new BigDecimal(0);
					}
					else
					{
						credit = credit.subtract(dept);
						dept = new BigDecimal(0);
					}
					deferred_dept = deferred_dept.add(dept);
					deferred_credit = deferred_credit.add(credit);
				}
				 argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD, cashCardPicker.getData());
				argMap.put(EngKeys.DATE_START,datePicker.getDate());
				argMap.put(EngKeys.DATE_END,datePicker.getDate());
				
				
				List ls =(List)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"getTransactions",argMap);
					BigDecimal credit;
				BigDecimal dept;
				for (int i = 0; i < ls.size(); i++)
				{
					credit = new BigDecimal(0);
					dept = new BigDecimal(0);
					Object results[] = (Object[]) ls.get(i);
					if (results[3] != null)
					{
						dept = (BigDecimal) results[3];
					}
					if (results[4] != null)
					{
						credit = (BigDecimal) results[4];
					}
					Integer id = (Integer) results[0];
					tableViewer.addRow(new String[]{DatePicker.formatter.format((Date) results[1]), results[5].toString(),
							results[2].toString(), cf.format(dept), cf.format(credit)}, id);
					total_dept = total_dept.add(dept);
					total_credit = total_credit.add(credit);
				}
				tableViewer.addRow(new String[]{"", "", "", "", ""}, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
				tableViewer.addRow(new String[]{"", "", CashLangKeys.STR_CASH_TOTAL,
						cf.format(total_dept), cf.format(total_credit)}, null);
				tableViewer.addRow(new String[]{"", "", EngLangCommonKeys.STR_TRANSOVER_CAPITAL,
						cf.format(deferred_dept), cf.format(deferred_credit)}, null);
				BigDecimal finalDept = deferred_dept.add(total_dept);
				BigDecimal finalCredit = deferred_credit.add(total_credit);
				tableViewer.addRow(new String[]{"", "", EngLangCommonKeys.STR_TOTAL_CAPITAL,
						cf.format(finalDept), cf.format(finalCredit)}, null);
				BigDecimal finalBalance = finalCredit.subtract(finalDept);
				if (finalBalance.doubleValue() > 0)
					tableViewer.addRow(new String[]{
							"", "", EngLangCommonKeys.STR_BALANCE_CAPITAL, "", cf.format(finalBalance)}, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				else
					tableViewer.addRow(new String[]{
							"", "", EngLangCommonKeys.STR_BALANCE_CAPITAL, cf.format(finalBalance.abs()), ""}, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}
}