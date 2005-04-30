package com.turquaz.accounting.ui.reports;

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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.eclipse.swt.custom.CCombo;

public class AccUIAccountingMonthlyBalance extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnRemain;
	private Button checkOnlyTransactions;
	private Button radioUseRemainder;
	private Button radioUseMainAccounts;
	private Group groupRemainder;
	private CLabel lblMonth;
	private CCombo comboMonth;
	private AccountPickerLeaf accountPickerEnd;
	private CLabel lblAccEnd;
	private CLabel lblAccStart;
	private AccountPickerLeaf accountPickerStart;
	private TableColumn tableColumnCreditRemaining;
	private TableTree tableTreeAccounts;
	private Composite compTable;
	private Button checkSubAccounts;
	private Composite compAdvanced;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private static String[] months = {
			EngLangCommonKeys.STR_MONTHS_JANUARY, EngLangCommonKeys.STR_MONTHS_FEBRUARY, EngLangCommonKeys.STR_MONTHS_MARCH, EngLangCommonKeys.STR_MONTHS_APRIL, EngLangCommonKeys.STR_MONTHS_MAY, EngLangCommonKeys.STR_MONTHS_JUNE, EngLangCommonKeys.STR_MONTHS_JULY, 
			EngLangCommonKeys.STR_MONTHS_AUGUST, EngLangCommonKeys.STR_MONTHS_SEPTEMBER, EngLangCommonKeys.STR_MONTHS_OCTOBER, EngLangCommonKeys.STR_MONTHS_NOVEMBER, EngLangCommonKeys.STR_MONTHS_DECEMBER}; 
	private Calendar cal = Calendar.getInstance();
	private Map treeItems;
	private Map accountsMap;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AccUIAccountingMonthlyBalance inst = new AccUIAccountingMonthlyBalance(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AccUIAccountingMonthlyBalance(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(654, 402);
			{
				compAdvanced = new Composite(this, SWT.NONE);
				GridLayout compAdvancedLayout = new GridLayout();
				GridData compAdvancedLData1 = new GridData();
				compAdvancedLData1.horizontalAlignment = GridData.FILL;
				compAdvancedLData1.verticalAlignment = GridData.FILL;
				compAdvancedLData1.horizontalSpan = 3;
				compAdvanced.setLayoutData(compAdvancedLData1);
				compAdvancedLayout.numColumns = 5;
				compAdvanced.setLayout(compAdvancedLayout);
				{
					lblMonth = new CLabel(compAdvanced, SWT.NONE);
					lblMonth.setText(AccLangKeys.STR_SELECT_MONTH); 
					GridData lblMonthLData = new GridData();
					lblMonthLData.widthHint = 68;
					lblMonthLData.heightHint = 16;
					lblMonth.setLayoutData(lblMonthLData);
				}
				{
					comboMonth = new CCombo(compAdvanced, SWT.NONE);
					GridData comboMonthLData = new GridData();
					comboMonthLData.widthHint = 89;
					comboMonthLData.heightHint = 16;
					comboMonthLData.horizontalSpan = 4;
					comboMonth.setLayoutData(comboMonthLData);
				}
				{
					lblAccStart = new CLabel(compAdvanced, SWT.NONE);
					lblAccStart.setText(AccLangKeys.STR_START_ACCOUNT); 
				}
				{
					accountPickerStart = new AccountPickerLeaf(compAdvanced, SWT.NONE);
					GridData accountPickerStartLData = new GridData();
					accountPickerStartLData.widthHint = 248;
					accountPickerStartLData.heightHint = 18;
					accountPickerStartLData.horizontalSpan = 4;
					accountPickerStart.setLayoutData(accountPickerStartLData);
				}
				{
					lblAccEnd = new CLabel(compAdvanced, SWT.NONE);
					lblAccEnd.setText(AccLangKeys.STR_END_ACCOUNT); 
				}
				{
					accountPickerEnd = new AccountPickerLeaf(compAdvanced, SWT.NONE);
					GridData accountPickerEndLData = new GridData();
					accountPickerEndLData.widthHint = 249;
					accountPickerEndLData.heightHint = 17;
					accountPickerEndLData.horizontalSpan = 3;
					accountPickerEnd.setLayoutData(accountPickerEndLData);
				}
				//START >> groupRemainder
				groupRemainder = new Group(compAdvanced, SWT.NONE);
				GridLayout groupRemainderLayout = new GridLayout();
				groupRemainderLayout.numColumns = 4;
				groupRemainderLayout.horizontalSpacing = 4;
				groupRemainder.setText(AccLangKeys.STR_BALANCE_CALC_METHOD); 
				GridData groupRemainderLData = new GridData();
				groupRemainder.setLayout(groupRemainderLayout);
				groupRemainderLData.widthHint = 256;
				groupRemainderLData.heightHint = 32;
				groupRemainderLData.horizontalSpan = 2;
				groupRemainder.setLayoutData(groupRemainderLData);
				//START >> radioUseMainAccounts
				radioUseMainAccounts = new Button(groupRemainder, SWT.RADIO | SWT.LEFT);
				radioUseMainAccounts.setText(AccLangKeys.STR_DIFF_LEDGER_ACCOUNTS); 
				radioUseMainAccounts.setSelection(true);
				//END << radioUseMainAccounts
				//START >> radioUseRemainder
				radioUseRemainder = new Button(groupRemainder, SWT.RADIO | SWT.LEFT);
				radioUseRemainder.setText(AccLangKeys.STR_BALANCE_SUMS); 
				GridData radioUseRemainderLData = new GridData();
				radioUseRemainderLData.widthHint = 103;
				radioUseRemainderLData.heightHint = 13;
				radioUseRemainder.setLayoutData(radioUseRemainderLData);
				//END << radioUseRemainder
				//END << groupRemainder
				{
					checkSubAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkSubAccounts.setText(AccLangKeys.STR_SHOW_SUBSIDIARY_ACCOUNTS); 
					GridData checkSubAccountsLData = new GridData();
					checkSubAccountsLData.widthHint = 116;
					checkSubAccountsLData.heightHint = 16;
					checkSubAccounts.setLayoutData(checkSubAccountsLData);
					checkSubAccounts.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							boolean expand = checkSubAccounts.getSelection();
							TableTreeItem[] subItems = tableTreeAccounts.getItems();
							for (int k = 0; k < subItems.length; k++)
							{
								expandTree(subItems[k], expand);
							}
						}
					});
				}
				//START >>  checkOnlyTransactions
				checkOnlyTransactions = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
				checkOnlyTransactions.setText(AccLangKeys.STR_SHOW_ONLY_WITH_TRANSACTIONS);
				GridData checkOnlyTransactionsLData = new GridData();
				checkOnlyTransactionsLData.widthHint = 175;
				checkOnlyTransactionsLData.heightHint = 16;
				checkOnlyTransactions.setLayoutData(checkOnlyTransactionsLData);
				//END <<  checkOnlyTransactions
			}
			{
				compTable = new Composite(this, SWT.NONE);
				GridLayout compTableLayout = new GridLayout();
				GridData compTableLData = new GridData();
				compTableLData.grabExcessVerticalSpace = true;
				compTableLData.grabExcessHorizontalSpace = true;
				compTableLData.horizontalAlignment = GridData.FILL;
				compTableLData.horizontalSpan = 3;
				compTableLData.verticalAlignment = GridData.FILL;
				compTable.setLayoutData(compTableLData);
				compTableLayout.makeColumnsEqualWidth = true;
				compTable.setLayout(compTableLayout);
				{
					tableTreeAccounts = new TableTree(compTable, SWT.NONE);
					GridData tableTreeAccountsLData = new GridData();
					{
						tableColumnAccountCode = new TableColumn(tableTreeAccounts.getTable(), SWT.NONE);
						tableColumnAccountCode.setText(AccLangKeys.STR_ACCOUNT_CODE); 
						tableColumnAccountCode.setWidth(100);
					}
					{
						tableColumnAccountName = new TableColumn(tableTreeAccounts.getTable(), SWT.NONE);
						tableColumnAccountName.setText(AccLangKeys.STR_ACCOUNT_NAME); 
						tableColumnAccountName.setWidth(150);
					}
					{
						tableColumnTotalDept = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnTotalDept.setText(AccLangKeys.STR_TOTAL_DEBIT); 
						tableColumnTotalDept.setWidth(85);
					}
					{
						tableColumnTotalCredit = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnTotalCredit.setText(AccLangKeys.STR_TOTAL_CREDIT); 
						tableColumnTotalCredit.setWidth(85);
					}
					tableTreeAccountsLData.grabExcessHorizontalSpace = true;
					tableTreeAccountsLData.grabExcessVerticalSpace = true;
					tableTreeAccountsLData.horizontalAlignment = GridData.FILL;
					tableTreeAccountsLData.verticalAlignment = GridData.FILL;
					tableTreeAccounts.setLayoutData(tableTreeAccountsLData);
					tableTreeAccounts.getTable().setLinesVisible(true);
					tableTreeAccounts.getTable().setHeaderVisible(true);
					{
						tableColumnRemain = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnRemain.setText(AccLangKeys.STR_BALANCE_DEBIT);
						tableColumnRemain.setWidth(85);
					}
					{
						tableColumnCreditRemaining = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnCreditRemaining.setText(AccLangKeys.STR_BALANCE_CREDIT); 
						tableColumnCreditRemaining.setWidth(85);
					}
				}
			}
			this.layout();
			PostInit();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void PostInit()
	{
		int month = cal.get(Calendar.MONTH);
		for (int k = 0; k <= month; k++)
		{
			comboMonth.add(months[k]);
			comboMonth.setData(months[k], new Integer(k + 1));
		}
		comboMonth.setText(months[month]);
	}

	public void search()
	{
		try
		{
			tableTreeAccounts.removeAll();
			treeItems = new HashMap();
			TableTreeItem item;
			int month = ((Integer) comboMonth.getData(comboMonth.getText())).intValue();
			Calendar startCal = Calendar.getInstance();
			startCal.set(startCal.get(Calendar.YEAR), month - 1, 1);
			Calendar endCal = Calendar.getInstance();
			endCal.set(endCal.get(Calendar.YEAR), month - 1, 1);
			endCal.add(2, 1);
			endCal.add(Calendar.DATE, -1);
			
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_START,accountPickerStart.getData());
			argMap.put(AccKeys.ACC_ACCOUNT_END, accountPickerEnd.getData());
			argMap.put(AccKeys.ACC_INITIAL_TRANS,new Boolean(false));
			argMap.put(AccKeys.ACC_START_DATE,startCal.getTime());
			argMap.put(AccKeys.ACC_END_DATE,endCal.getTime());
			
			List allAccounts =(List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getTransactions",argMap);
			
			Integer parentId, accountId;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalDeptRemain = new BigDecimal(0);
			BigDecimal totalCreditRemain = new BigDecimal(0);
			Object[] accountInfo;
			boolean useMainAccountsRemain = radioUseMainAccounts.getSelection();
			
			accountsMap=new HashMap();
			
			for (int k=0; k<allAccounts.size(); k++)
			{
				accountInfo=(Object[])allAccounts.get(k);
				accountsMap.put(accountInfo[0],accountInfo);
			}
			
			boolean showOnlyTrans=checkOnlyTransactions.getSelection();
			for (int i = 0; i < allAccounts.size(); i++)
			{
				accountInfo=(Object[])allAccounts.get(i);
				accountId=(Integer)accountInfo[0];
				if (accountId.intValue() == -1)
					continue;				
				String accountCode=(String)accountInfo[1];
				String accountName=(String)accountInfo[2];
				parentId=(Integer)accountInfo[3];
				Integer topAccountId=(Integer)accountInfo[4];
				BigDecimal transDept=(accountInfo[5]==null) ? new BigDecimal(0) : (BigDecimal)accountInfo[5];
				BigDecimal transCredit=(accountInfo[6]==null) ? new BigDecimal(0) : (BigDecimal)accountInfo[6];
				
				
				if (showOnlyTrans)
				{
					if (transDept.doubleValue()==0 && transCredit.doubleValue()==0)
						continue;
				}
				
				totalCredit = totalCredit.add(transCredit);
				totalDept = totalDept.add(transDept);
				
				LocateAccountToTable(accountInfo);
				TableTreeItem accountItem = (TableTreeItem) treeItems.get(accountId);
				BigDecimal dept = cf.getBigDecimal(accountItem.getText(2));
				BigDecimal credit = cf.getBigDecimal(accountItem.getText(3));
				dept = dept.add(transDept);
				credit = credit.add(transCredit);
				accountItem.setText(2, cf.format(dept));
				accountItem.setText(3, cf.format(credit));
				BigDecimal remaining = transCredit.subtract(transDept);
				if (!useMainAccountsRemain)
				{
					if (remaining.doubleValue() < 0)
						totalDeptRemain = totalDeptRemain.add(remaining);
					else if (remaining.doubleValue() > 0)
						totalCreditRemain = totalCreditRemain.add(remaining);
				}
				accountItem.setText(4, (remaining.doubleValue() <= 0) ? cf.format(remaining.abs()) : "0,00"); //$NON-NLS-1$
				accountItem.setText(5, (remaining.doubleValue() > 0) ? cf.format(remaining) : "0,00"); //$NON-NLS-1$
				
				while (parentId.intValue() != -1)
				{
					Object[] parentInfo = (Object[])accountsMap.get(parentId);
					accountItem = (TableTreeItem) treeItems.get(parentId);
					dept = cf.getBigDecimal(accountItem.getText(2));
					credit = cf.getBigDecimal(accountItem.getText(3));
					dept = dept.add(transDept);
					credit = credit.add(transCredit);
					accountItem.setText(2, cf.format(dept));
					accountItem.setText(3, cf.format(credit));
					BigDecimal newremaining;
					if (!useMainAccountsRemain)
					{
						String remainDept = accountItem.getText(4);
						String remainCredit = accountItem.getText(5);
						BigDecimal initDept;
						BigDecimal initCredit;
						if (remainDept != null && !remainDept.equals("")) //$NON-NLS-1$
						{
							initDept = cf.getBigDecimal(remainDept);
							if (remaining.doubleValue() < 0)
								initDept = initDept.add(remaining.abs());
						}
						else
							initDept = remaining;
						if (remainCredit != null && !remainCredit.equals("")) //$NON-NLS-1$
						{
							initCredit = cf.getBigDecimal(remainCredit);
							if (remaining.doubleValue() > 0)
								initCredit = initCredit.add(remaining);
						}
						else
							initCredit = new BigDecimal(0);
						accountItem.setText(4, cf.format(initDept)); //$NON-NLS-1$
						accountItem.setText(5, cf.format(initCredit)); //$NON-NLS-1$
					}
					else
					{
						newremaining = credit.subtract(dept);
						accountItem.setText(4, (newremaining.doubleValue() <= 0) ? cf.format(newremaining.abs()) : "0,00"); //$NON-NLS-1$
						accountItem.setText(5, (newremaining.doubleValue() > 0) ? cf.format(newremaining) : "0,00"); //$NON-NLS-1$
					}
					parentId =(Integer) parentInfo[3];
				}
			}
			if (useMainAccountsRemain)
			{
				TableTreeItem[] allitems = tableTreeAccounts.getItems();
				for (int k = 0; k < allitems.length; k++)
				{
					TableTreeItem titem = allitems[k];
					String remain = titem.getText(4);
					BigDecimal initRemain;
					if (remain != null && !remain.equals("")) //$NON-NLS-1$
						initRemain = cf.getBigDecimal(remain).negate();
					else
						initRemain = cf.getBigDecimal(titem.getText(5));
					if (initRemain.doubleValue() <= 0)
						totalDeptRemain = totalDeptRemain.add(initRemain);
					else
						totalCreditRemain = totalCreditRemain.add(initRemain);
				}
			}
			new TableTreeItem(tableTreeAccounts, SWT.NULL);
			TableTreeItem totals = new TableTreeItem(tableTreeAccounts, SWT.RIGHT);
			totals.setText(1, AccLangKeys.STR_TOTAL); 
			totals.setText(2, cf.format(totalDept));
			totals.setText(3, cf.format(totalCredit));
			totals.setText(4, cf.format(totalDeptRemain.abs()));
			totals.setText(5, cf.format(totalCreditRemain));
			boolean expand = checkSubAccounts.getSelection();
			if (expand)
			{
				TableTreeItem[] subItems = tableTreeAccounts.getItems();
				for (int k = 0; k < subItems.length; k++)
				{
					expandTree(subItems[k], expand);
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	private void LocateAccountToTable(Object[] accountInfo)throws Exception
	{
		
		Integer accountId=(Integer)accountInfo[0];
		Integer topAccountId=(Integer)accountInfo[4];
		BigDecimal transDept=(accountInfo[5]==null) ? new BigDecimal(0) : (BigDecimal)accountInfo[5];
		BigDecimal transCredit=(accountInfo[6]==null) ? new BigDecimal(0) : (BigDecimal)accountInfo[6];
		
		if (!treeItems.containsKey(accountId))
		{			
			String accountCode=(String)accountInfo[1];
			String accountName=(String)accountInfo[2];
			Integer parentId=(Integer)accountInfo[3];
			if (parentId.intValue() != -1)
			{
				Object[] parentInfo =(Object[])accountsMap.get(parentId);
				LocateAccountToTable(parentInfo);
				TableTreeItem parentItem = (TableTreeItem) treeItems.get(parentId);
				int k;				
				TableTreeItem parentItems[] = parentItem.getItems();
				for (k = 0; k < parentItems.length; k++)
				{
					TableTreeItem pItem = parentItems[k];
					if (accountCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				TableTreeItem item = new TableTreeItem(parentItem, SWT.NULL, k);
				item.setText(0, accountCode);
				item.setText(1, accountName);
				item.setText(2, "0.00"); //$NON-NLS-1$
				item.setText(3, "0.00"); //$NON-NLS-1$
				item.setText(4, "0.00"); //$NON-NLS-1$
				item.setText(5, "0.00"); //$NON-NLS-1$
				item.setData(accountInfo);
				treeItems.put(accountId, item);
			}
			else
			{
				TableTreeItem parentItems[] = tableTreeAccounts.getItems();
				int k;
				for (k = 0; k < parentItems.length; k++)
				{
					TableTreeItem pItem = parentItems[k];
					if (accountCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				TableTreeItem item = new TableTreeItem(tableTreeAccounts, SWT.NULL, k);
				item.setText(0, accountCode);
				item.setText(1, accountName);
				item.setText(2, "0.00"); //$NON-NLS-1$
				item.setText(3, "0.00"); //$NON-NLS-1$
				item.setText(4, "0.00"); //$NON-NLS-1$
				item.setText(5, "0.00"); //$NON-NLS-1$
				item.setData(accountInfo);
				treeItems.put(accountId, item);
			}
		}
	}

	public void expandTree(TableTreeItem tableItem, boolean expand)
	{
		tableItem.setExpanded(expand);
		TableTreeItem[] subTree = tableItem.getItems();
		for (int k = 0; k < subTree.length; k++)
		{
			expandTree(subTree[k], expand);
		}
	}

	public void printTable()
	{
		Calendar cal = Calendar.getInstance();
		Map props = new HashMap();
		props.put("start_account_code", accountPickerStart.getText()); //$NON-NLS-1$
		props.put("end_account_code", accountPickerEnd.getText()); //$NON-NLS-1$
		props.put("report_date", DatePicker.formatter.format(cal.getTime())); //$NON-NLS-1$
		props.put("month", comboMonth.getText()); //$NON-NLS-1$
		EngBLUtils.printMonthlyAccountingBalance(tableTreeAccounts.getTable(),
				AccLangKeys.STR_MONTHLY_TRIAL_BALANCE, props);
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableTreeAccounts.getTable());
	}

	public void delete()
	{
	}
}