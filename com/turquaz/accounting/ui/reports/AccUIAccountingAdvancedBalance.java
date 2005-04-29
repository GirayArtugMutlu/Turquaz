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
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import org.eclipse.swt.widgets.Group;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;

public class AccUIAccountingAdvancedBalance extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private TableColumn tableColumnTotalCredit;
	private Button radioUseRemainder;
	private Label label1;
	private Button radioUseMainAccounts;
	private Group groupRemainder;
	private TableColumn tableColumnRemain;
	private AccountPicker accountPickerEnd;
	private CLabel lblAccEnd;
	private CLabel lblAccStart;
	private AccountPicker accountPickerStart;
	private TableColumn tableColumnCreditRemaining;
	private Label lblEndDate;
	private CLabel lblStartDate;
	private TableTree tableTreeAccounts;
	private Composite compTable;
	private DatePicker datePickerEnd;
	private DatePicker datePickerStart;
	private Button checkFinalAccounts;
	private Button checkInitialAccounts;
	private Button checkSubAccounts;
	private Composite compAdvanced;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private Map treeItems;

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
		AccUIAccountingAdvancedBalance inst = new AccUIAccountingAdvancedBalance(shell, SWT.NULL);
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

	public AccUIAccountingAdvancedBalance(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}
	Calendar cal = Calendar.getInstance();

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(654, 402);
			{
				compAdvanced = new Composite(this, SWT.NONE);
				GridLayout compAdvancedLayout = new GridLayout();
				compAdvancedLayout.numColumns = 4;
				GridData compAdvancedLData1 = new GridData();
				compAdvancedLData1.horizontalAlignment = GridData.FILL;
				compAdvancedLData1.verticalAlignment = GridData.FILL;
				compAdvancedLData1.horizontalSpan = 3;
				compAdvanced.setLayoutData(compAdvancedLData1);
				compAdvanced.setLayout(compAdvancedLayout);
				{
					lblStartDate = new CLabel(compAdvanced, SWT.NONE);
					lblStartDate.setText(Messages.getString("AccUIAccountingAdvancedBalance.3")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 79;
					lblStartDateLData.heightHint = 19;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					datePickerStart = new DatePicker(compAdvanced, SWT.NONE);
					//datePickerStart.setDate(new Date(cal.getTime().getYear(),0,1));
					cal.set(cal.get(Calendar.YEAR), 0, 1);
					datePickerStart.setDate(cal.getTime());
					GridData datePickerStartLData = new GridData();
					datePickerStartLData.widthHint = 130;
					datePickerStartLData.heightHint = 22;
					datePickerStart.setLayoutData(datePickerStartLData);
				}
				{
					lblEndDate = new Label(compAdvanced, SWT.NONE);
					lblEndDate.setText(Messages.getString("AccUIAccountingAdvancedBalance.4")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 48;
					lblEndDateLData.heightHint = 13;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					datePickerEnd = new DatePicker(compAdvanced, SWT.NONE);
					GridData datePickerEndLData = new GridData();
					datePickerEndLData.widthHint = 130;
					datePickerEndLData.heightHint = 22;
					datePickerEnd.setLayoutData(datePickerEndLData);
				}
				{
					lblAccStart = new CLabel(compAdvanced, SWT.NONE);
					lblAccStart.setText(Messages.getString("AccUIAccountingAdvancedBalance.10")); //$NON-NLS-1$
					GridData lblAccStartLData = new GridData();
					lblAccStartLData.widthHint = 85;
					lblAccStartLData.heightHint = 19;
					lblAccStart.setLayoutData(lblAccStartLData);
				}
				{
					accountPickerStart = new AccountPicker(compAdvanced, SWT.NONE);
					GridData accountPickerStartLData = new GridData();
					accountPickerStartLData.widthHint = 128;
					accountPickerStartLData.heightHint = 17;
					accountPickerStart.setLayoutData(accountPickerStartLData);
				}
				{
					lblAccEnd = new CLabel(compAdvanced, SWT.NONE);
					lblAccEnd.setText(Messages.getString("AccUIAccountingAdvancedBalance.11")); //$NON-NLS-1$
					GridData lblAccEndLData = new GridData();
					lblAccEndLData.widthHint = 60;
					lblAccEndLData.heightHint = 19;
					lblAccEnd.setLayoutData(lblAccEndLData);
				}
				{
					accountPickerEnd = new AccountPicker(compAdvanced, SWT.NONE);
					GridData accountPickerEndLData = new GridData();
					accountPickerEndLData.widthHint = 129;
					accountPickerEndLData.heightHint = 17;
					accountPickerEnd.setLayoutData(accountPickerEndLData);
				}
				//START >> label1
				label1 = new Label(compAdvanced, SWT.SEPARATOR | SWT.HORIZONTAL);
				label1.setText("label1"); //$NON-NLS-1$
				GridData label1LData = new GridData();
				label1LData.widthHint = 644;
				label1LData.heightHint = 2;
				label1LData.horizontalSpan = 4;
				label1.setLayoutData(label1LData);
				//END << label1
				//START >> groupRemainder
				groupRemainder = new Group(compAdvanced, SWT.NONE);
				GridLayout groupRemainderLayout = new GridLayout();
				GridData groupRemainderLData = new GridData();
				groupRemainderLData.widthHint = 153;
				groupRemainderLData.heightHint = 44;
				groupRemainderLData.verticalSpan = 2;
				groupRemainderLData.horizontalSpan = 2;
				groupRemainder.setLayoutData(groupRemainderLData);
				groupRemainderLayout.horizontalSpacing = 4;
				groupRemainder.setLayout(groupRemainderLayout);
				groupRemainder.setText(Messages.getString("AccUIAccountingAdvancedBalance.14")); //$NON-NLS-1$
				//START >> radioUseMainAccounts
				radioUseMainAccounts = new Button(groupRemainder, SWT.RADIO | SWT.LEFT);
				radioUseMainAccounts.setText(Messages.getString("AccUIAccountingAdvancedBalance.15")); //$NON-NLS-1$
				radioUseMainAccounts.setSelection(true);
				//END << radioUseMainAccounts
				//START >> radioUseRemainder
				radioUseRemainder = new Button(groupRemainder, SWT.RADIO | SWT.LEFT);
				radioUseRemainder.setText(Messages.getString("AccUIAccountingAdvancedBalance.16")); //$NON-NLS-1$
				GridData radioUseRemainderLData = new GridData();
				radioUseRemainderLData.widthHint = 103;
				radioUseRemainderLData.heightHint = 13;
				radioUseRemainder.setLayoutData(radioUseRemainderLData);
				//END << radioUseRemainder
				//END << groupRemainder
				{
					checkSubAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkSubAccounts.setText(Messages.getString("AccUIAccountingAdvancedBalance.0")); //$NON-NLS-1$
					GridData checkSubAccountsLData = new GridData();
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
				{
					checkInitialAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkInitialAccounts.setText(Messages.getString("AccUIAccountingAdvancedBalance.1")); //$NON-NLS-1$
					GridData checkInitialAccountsLData = new GridData();
					checkInitialAccounts.setLayoutData(checkInitialAccountsLData);
				}
				{
					checkFinalAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkFinalAccounts.setText(Messages.getString("AccUIAccountingAdvancedBalance.2")); //$NON-NLS-1$
					GridData checkFinalAccountsLData = new GridData();
					checkFinalAccounts.setLayoutData(checkFinalAccountsLData);
				}
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
						tableColumnAccountCode.setText(Messages.getString("AccUIAccountingAdvancedBalance.5")); //$NON-NLS-1$
						tableColumnAccountCode.setWidth(80);
					}
					{
						tableColumnAccountName = new TableColumn(tableTreeAccounts.getTable(), SWT.NONE);
						tableColumnAccountName.setText(Messages.getString("AccUIAccountingAdvancedBalance.6")); //$NON-NLS-1$
						tableColumnAccountName.setWidth(150);
					}
					{
						tableColumnTotalDept = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnTotalDept.setText(Messages.getString("AccUIAccountingAdvancedBalance.7")); //$NON-NLS-1$
						tableColumnTotalDept.setWidth(85);
					}
					{
						tableColumnTotalCredit = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnTotalCredit.setText(Messages.getString("AccUIAccountingAdvancedBalance.8")); //$NON-NLS-1$
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
						tableColumnRemain.setText(Messages.getString("AccUIAccountingAdvancedBalance.12")); //$NON-NLS-1$
						tableColumnRemain.setWidth(85);
					}
					{
						tableColumnCreditRemaining = new TableColumn(tableTreeAccounts.getTable(), SWT.RIGHT);
						tableColumnCreditRemaining.setText(Messages.getString("AccUIAccountingAdvancedBalance.13")); //$NON-NLS-1$
						tableColumnCreditRemaining.setWidth(85);
					}
				}
			}
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void search()
	{
		try
		{
			tableTreeAccounts.removeAll();
			treeItems = new HashMap();
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_START,accountPickerStart.getData());
			argMap.put(AccKeys.ACC_ACCOUNT_END, accountPickerEnd.getData());
			argMap.put(AccKeys.ACC_INITIAL_TRANS,new Boolean(checkInitialAccounts.getSelection()));
			argMap.put(AccKeys.ACC_START_DATE,datePickerStart.getDate());
			argMap.put(AccKeys.ACC_END_DATE,datePickerEnd.getDate());
			
			List allAccounts =(List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getTransactions",argMap);
			TurqAccountingAccount account;
			Integer parentId, accountId;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalDeptRemain = new BigDecimal(0);
			BigDecimal totalCreditRemain = new BigDecimal(0);
			boolean useMainAccountsRemain = radioUseMainAccounts.getSelection();
			for (int i = 0; i < allAccounts.size(); i++)
			{
				account = (TurqAccountingAccount) ((Object[]) allAccounts.get(i))[0];
				BigDecimal transDept = (BigDecimal) ((Object[]) allAccounts.get(i))[1];
				BigDecimal transCredit = (BigDecimal) ((Object[]) allAccounts.get(i))[2];
				totalCredit = totalCredit.add(transCredit);
				totalDept = totalDept.add(transDept);
				parentId = account.getTurqAccountingAccountByParentAccount().getId();
				accountId = account.getId();
				LocateAccountToTable(account);
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
				accountItem.setText(4, (remaining.doubleValue() <= 0) ? cf.format(remaining.abs()) : ""); //$NON-NLS-1$
				accountItem.setText(5, (remaining.doubleValue() > 0) ? cf.format(remaining) : ""); //$NON-NLS-1$
				TurqAccountingAccount parentAcc = account.getTurqAccountingAccountByParentAccount();
				while (parentId.intValue() != -1)
				{
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
						accountItem.setText(4, (newremaining.doubleValue() <= 0) ? cf.format(newremaining.abs()) : ""); //$NON-NLS-1$
						accountItem.setText(5, (newremaining.doubleValue() > 0) ? cf.format(newremaining) : ""); //$NON-NLS-1$
					}
					parentAcc = parentAcc.getTurqAccountingAccountByParentAccount();
					parentId = parentAcc.getId();
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
			totals.setText(1, Messages.getString("AccUIAccountingAdvancedBalance.19")); //$NON-NLS-1$
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
	
	
	public void search2()
	{
		try
		{
			tableTreeAccounts.removeAll();
			treeItems = new HashMap();
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_START,accountPickerStart.getData());
			argMap.put(AccKeys.ACC_ACCOUNT_END, accountPickerEnd.getData());
			argMap.put(AccKeys.ACC_INITIAL_TRANS,new Boolean(checkInitialAccounts.getSelection()));
			argMap.put(AccKeys.ACC_START_DATE,datePickerStart.getDate());
			argMap.put(AccKeys.ACC_END_DATE,datePickerEnd.getDate());
			
			List allAccounts =(List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getTransactions",argMap);
			TurqAccountingAccount account;
			Integer parentId, accountId;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalDeptRemain = new BigDecimal(0);
			BigDecimal totalCreditRemain = new BigDecimal(0);
			boolean useMainAccountsRemain = radioUseMainAccounts.getSelection();
			for (int i = 0; i < allAccounts.size(); i++)
			{
				account = (TurqAccountingAccount) ((Object[]) allAccounts.get(i))[0];
				BigDecimal transDept = (BigDecimal) ((Object[]) allAccounts.get(i))[1];
				BigDecimal transCredit = (BigDecimal) ((Object[]) allAccounts.get(i))[2];
				totalCredit = totalCredit.add(transCredit);
				totalDept = totalDept.add(transDept);
				parentId = account.getTurqAccountingAccountByParentAccount().getId();
				accountId = account.getId();
				LocateAccountToTable(account);
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
				accountItem.setText(4, (remaining.doubleValue() <= 0) ? cf.format(remaining.abs()) : ""); //$NON-NLS-1$
				accountItem.setText(5, (remaining.doubleValue() > 0) ? cf.format(remaining) : ""); //$NON-NLS-1$
				TurqAccountingAccount parentAcc = account.getTurqAccountingAccountByParentAccount();
				while (parentId.intValue() != -1)
				{
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
						accountItem.setText(4, (newremaining.doubleValue() <= 0) ? cf.format(newremaining.abs()) : ""); //$NON-NLS-1$
						accountItem.setText(5, (newremaining.doubleValue() > 0) ? cf.format(newremaining) : ""); //$NON-NLS-1$
					}
					parentAcc = parentAcc.getTurqAccountingAccountByParentAccount();
					parentId = parentAcc.getId();
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
			totals.setText(1, Messages.getString("AccUIAccountingAdvancedBalance.19")); //$NON-NLS-1$
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

	private void LocateAccountToTable(TurqAccountingAccount account)
	{
		//System.out.println("Locate: "+account.getAccountingAccountsId().toString());
		if (!treeItems.containsKey(account.getId()))
		{
			//System.out.println("NOT");
			Integer parentId = account.getTurqAccountingAccountByParentAccount().getId();
			if (parentId.intValue() != -1)
			{
				TurqAccountingAccount parentAcc = account.getTurqAccountingAccountByParentAccount();
				LocateAccountToTable(parentAcc);
				TableTreeItem parentItem = (TableTreeItem) treeItems.get(parentId);
				int k;
				String accCode = account.getAccountCode();
				TableTreeItem parentItems[] = parentItem.getItems();
				for (k = 0; k < parentItems.length; k++)
				{
					TableTreeItem pItem = parentItems[k];
					if (accCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				TableTreeItem item = new TableTreeItem(parentItem, SWT.NULL, k);
				item.setText(0, account.getAccountCode());
				item.setText(1, account.getAccountName());
				item.setText(2, "0.00"); //$NON-NLS-1$
				item.setText(3, "0.00"); //$NON-NLS-1$
				item.setText(4, "0.00"); //$NON-NLS-1$
				item.setText(5, "0.00"); //$NON-NLS-1$
				item.setData(account);
				treeItems.put(account.getId(), item);
				//System.out.println("PUT:"+account.getAccountingAccountsId().toString());
			}
			else
			{
				TableTreeItem parentItems[] = tableTreeAccounts.getItems();
				int k;
				String accCode = account.getAccountCode();
				for (k = 0; k < parentItems.length; k++)
				{
					TableTreeItem pItem = parentItems[k];
					if (accCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				TableTreeItem item = new TableTreeItem(tableTreeAccounts, SWT.NULL, k);
				item.setText(0, account.getAccountCode());
				item.setText(1, account.getAccountName());
				item.setText(2, "0.00"); //$NON-NLS-1$
				item.setText(3, "0.00"); //$NON-NLS-1$
				item.setText(4, "0.00"); //$NON-NLS-1$
				item.setText(5, "0.00"); //$NON-NLS-1$
				item.setData(account);
				treeItems.put(account.getId(), item);
				//System.out.println("PUT:"+account.getAccountingAccountsId().toString());
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
		props.put("start_date", DatePicker.formatter.format(datePickerStart.getDate())); //$NON-NLS-1$
		props.put("end_date", DatePicker.formatter.format(datePickerEnd.getDate())); //$NON-NLS-1$
		props.put("report_date", DatePicker.formatter.format(cal.getTime())); //$NON-NLS-1$
		EngBLUtils.printAccountingBalance(tableTreeAccounts.getTable(), Messages.getString("AccUIAccountingAdvancedBalance.23"), props); //$NON-NLS-1$
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableTreeAccounts.getTable());
	}

	public void delete()
	{
	}
}