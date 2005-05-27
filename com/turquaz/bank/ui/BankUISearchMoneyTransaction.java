package com.turquaz.bank.ui;

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
//TODO add curreny to bank sarch
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.BankLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.common.HashBag;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUISearchMoneyTransaction extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite compSearch;
	private Table tableMoneyTrans;
	private TableColumn tableColumnCreditAmount;
	private TableColumn tableColumnDocNo;
	private TableColumn tableColumnType;
	private TableColumn tableColumnDate;
	private DatePicker dateEnd;
	private CLabel lblEndDate;
	private TableColumn tableColumnDeptAmount;
	private TableColumn tableColumnDefintion;
	private DatePicker dateStart;
	private CLabel lblStartDate;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private SearchTableViewer tableViewer = null;

	public BankUISearchMoneyTransaction(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(677, 401);
			{
				compSearch = new Composite(this, SWT.NONE);
				GridLayout compSearchLayout = new GridLayout();
				compSearchLayout.numColumns = 2;
				GridData compSearchLData = new GridData();
				compSearchLData.horizontalAlignment = GridData.FILL;
				compSearchLData.grabExcessHorizontalSpace = true;
				compSearchLData.heightHint = 104;
				compSearch.setLayoutData(compSearchLData);
				compSearch.setLayout(compSearchLayout);
				{
					lblDocNo = new CLabel(compSearch, SWT.NONE);
					lblDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
				}
				{
					txtDocNo = new Text(compSearch, SWT.NONE);
					GridData txtDocNoLData = new GridData();
					txtDocNoLData.widthHint = 150;
					txtDocNoLData.heightHint = 17;
					txtDocNo.setLayoutData(txtDocNoLData);
				}
				{
					lblStartDate = new CLabel(compSearch, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
				}
				{
					dateStart = new DatePicker(compSearch, SWT.NONE);
					GridData dateStartLData = new GridData();
					dateStartLData.widthHint = 157;
					dateStartLData.heightHint = 23;
					dateStart.setLayoutData(dateStartLData);
				}
				{
					lblEndDate = new CLabel(compSearch, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
				}
				{
					dateEnd = new DatePicker(compSearch, SWT.NONE);
					GridData dateEndLData = new GridData();
					dateEndLData.widthHint = 157;
					dateEndLData.heightHint = 23;
					dateEnd.setLayoutData(dateEndLData);
				}
			}
			{
				tableMoneyTrans = new Table(this, SWT.FULL_SELECTION);
				GridData tableMoneyTransLData = new GridData();
				tableMoneyTrans.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableMouseDoubleClick();
					}
				});
				tableMoneyTrans.setHeaderVisible(true);
				tableMoneyTrans.setLinesVisible(true);
				tableMoneyTransLData.horizontalAlignment = GridData.FILL;
				tableMoneyTransLData.verticalAlignment = GridData.FILL;
				tableMoneyTransLData.grabExcessVerticalSpace = true;
				tableMoneyTrans.setLayoutData(tableMoneyTransLData);
				{
					tableColumnDate = new TableColumn(tableMoneyTrans, SWT.NONE);
					tableColumnDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnDate.setWidth(82);
				}
				{
					tableColumnDocNo = new TableColumn(tableMoneyTrans, SWT.NONE);
					tableColumnDocNo.setWidth(75);
					tableColumnDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
				}
				{
					tableColumnType = new TableColumn(tableMoneyTrans, SWT.NONE);
					tableColumnType.setText(EngLangCommonKeys.STR_TYPE);
					tableColumnType.setWidth(104);
				}
				//START >> tableColumnDefintion
				tableColumnDefintion = new TableColumn(tableMoneyTrans, SWT.NONE);
				tableColumnDefintion.setText(EngLangCommonKeys.STR_DESCRIPTION);
				tableColumnDefintion.setWidth(150);
				//END << tableColumnDefintion
				//START >> tableColumnDeptAmount
				tableColumnDeptAmount = new TableColumn(tableMoneyTrans, SWT.RIGHT);
				tableColumnDeptAmount.setText(EngLangCommonKeys.STR_DEPT);
				tableColumnDeptAmount.setWidth(85);
				//END << tableColumnDeptAmount
				//START >> tableColumnCreditAmount
				tableColumnCreditAmount = new TableColumn(tableMoneyTrans, SWT.RIGHT);
				tableColumnCreditAmount.setText(EngLangCommonKeys.STR_CREDIT);
				tableColumnCreditAmount.setWidth(85);
				//END << tableColumnCreditAmount
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
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStart.setDate(cal.getTime());
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[6];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableMoneyTrans, columnTypes, true);
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
		EngBLUtils.printTable(tableMoneyTrans, BankLangKeys.STR_BANK_OPERATIONS);
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			
			HashMap argMap=new HashMap();
			argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStart.getDate());
			argMap.put(EngKeys.DATE_END,dateEnd.getDate());
			
			HashBag resultBag =(HashBag) EngTXCommon.doSelectTX(BankBLTransactionSearch.class.getName(),"searchtransaction",argMap);
			
			Integer transId;
			Integer transTypeId;
			Date transDate;
			BigDecimal dept = new BigDecimal(0);
			BigDecimal credit = new BigDecimal(0);
			String docNo = ""; //$NON-NLS-1$
			String bankCode;
			String transType;
			
			HashMap rowMap = (HashMap)resultBag.get(BankKeys.BANK_TRANSACTIONS);
			for (int i = 0; i < rowMap.size(); i++)
			{
				HashMap rowInfo = (HashMap)rowMap.get(new Integer(i));				
				
				dept = new BigDecimal(0);
				credit = new BigDecimal(0);
				
				if (rowInfo.get(EngKeys.DEPT_AMOUNT) != null)
				{
					dept = (BigDecimal) rowInfo.get(EngKeys.DEPT_AMOUNT);
				}
				if (rowInfo.get(EngKeys.CREDIT_AMOUNT) != null)
				{
					credit = (BigDecimal) rowInfo.get(EngKeys.CREDIT_AMOUNT);
				}
				transId = (Integer) rowInfo.get(BankKeys.BANK_TRANS_BILL_ID);
				transTypeId = (Integer)rowInfo.get(EngKeys.TYPE_ID);
				transType = (String)rowInfo.get(EngKeys.TYPE_NAME);
				transDate = (Date)rowInfo.get(EngKeys.DATE);
				docNo = (String)rowInfo.get(EngKeys.DOCUMENT_NO);
				String definition =(String)rowInfo.get(EngKeys.DEFINITION);
				tableViewer.addRow(new String[]{DatePicker.formatter.format(transDate), docNo, transType, definition, cf.format(dept),
						cf.format(credit)}, new Object[]{transId,transTypeId});
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public static boolean updateTransaction(Integer billId,Integer transTypeId, Shell shell) throws Exception
	{
		boolean isUpdated = false;
		HashMap argMap=new HashMap();
		if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
		{
			isUpdated = new BankUIMoneyTransferInUpdate(shell, SWT.NULL, billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_SEND_MONEY)
		{
			isUpdated = new BankUIMoneyTransferOutUpdate(shell, SWT.NULL,billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_CASH_DRAW)
		{
			isUpdated = new BankUICashFromBankUpdate(shell, SWT.NULL,billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_CASH_DEPOSIT)
		{
			isUpdated = new BankUICashToBankUpdate(shell, SWT.NULL, billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_OTHER_DEPOSIT)
		{
			isUpdated = new BankUIOtherTransInUpdate(shell, SWT.NULL,billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_OTHER_DRAW)
		{
			isUpdated = new BankUIOtherTransOutUpdate(shell, SWT.NULL, billId).open();
		}
		else if (transTypeId.intValue() == EngBLCommon.BANK_TRANS_BETWEEN_BANKS)
		{
			isUpdated = new BankUITransferBetweenAccountsUpdate(shell, SWT.NULL, billId).open();
		}
		return isUpdated;
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem selection[] = tableMoneyTrans.getSelection();
			if (selection.length > 0)
			{
				boolean isUpdated = false;
				Object []data = (Object[]) ((ITableRow) selection[0].getData()).getDBObject();
				Integer billId = (Integer)data[0];
				Integer typeId = (Integer)data[1];
				isUpdated = updateTransaction(billId,typeId, getShell());
				if (isUpdated)
				{
					search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
        }
	}
}