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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;


import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;

import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.custom.CCombo;
public class AccUIAccountingMonthlyBalance extends org.eclipse.swt.widgets.Composite implements SearchComposite {
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnRemain;
	private Button radioUseRemainder;
	private Button radioUseMainAccounts;
	private Group groupRemainder;
	private CLabel lblMonth;
	private CCombo comboMonth;
	private AccountPicker accountPickerEnd;
	private CLabel lblAccEnd;
	private CLabel lblAccStart;
	private AccountPicker accountPickerStart;
	private TableColumn tableColumnCreditRemaining;
	private TableTree tableTreeAccounts;
	private Composite compTable;
	private Button checkSubAccounts;
	private Composite compAdvanced;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccountCode;
	private AccBLTransactionSearch blSearch=new AccBLTransactionSearch();
	private static String[] months={Messages.getString("AccUIAccountingMonthlyBalance.0"),Messages.getString("AccUIAccountingMonthlyBalance.1"),Messages.getString("AccUIAccountingMonthlyBalance.2"),Messages.getString("AccUIAccountingMonthlyBalance.3"),Messages.getString("AccUIAccountingMonthlyBalance.4"),Messages.getString("AccUIAccountingMonthlyBalance.5"),Messages.getString("AccUIAccountingMonthlyBalance.6"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			Messages.getString("AccUIAccountingMonthlyBalance.7"),Messages.getString("AccUIAccountingMonthlyBalance.8"),Messages.getString("AccUIAccountingMonthlyBalance.10"),Messages.getString("AccUIAccountingMonthlyBalance.11"),Messages.getString("AccUIAccountingMonthlyBalance.12")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	private Calendar cal=Calendar.getInstance();
	private Map treeItems;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AccUIAccountingMonthlyBalance inst = new AccUIAccountingMonthlyBalance(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AccUIAccountingMonthlyBalance(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	private void initGUI() {
		try {
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
				compAdvancedLayout.numColumns = 4;
				compAdvanced.setLayout(compAdvancedLayout);
				{
					checkSubAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkSubAccounts.setText(Messages.getString("AccUIAccountingMonthlyBalance.13")); //$NON-NLS-1$
						GridData checkSubAccountsLData = new GridData();
						checkSubAccountsLData.widthHint = 133;
						checkSubAccountsLData.heightHint = 17;
						checkSubAccounts.setLayoutData(checkSubAccountsLData);
						checkSubAccounts
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									boolean expand=checkSubAccounts.getSelection();
									TableTreeItem[] subItems = tableTreeAccounts.getItems();
									for (int k = 0; k < subItems.length; k++)
									{
										expandTree(subItems[k],expand);
									}
								}
							});
				}
				{
					lblMonth = new CLabel(compAdvanced, SWT.NONE);
					lblMonth.setText(Messages.getString("AccUIAccountingMonthlyBalance.14")); //$NON-NLS-1$
					GridData lblMonthLData = new GridData();
					lblMonthLData.widthHint = 66;
					lblMonthLData.heightHint = 16;
					lblMonth.setLayoutData(lblMonthLData);
				}
				{
					comboMonth = new CCombo(compAdvanced, SWT.NONE);
					GridData comboMonthLData = new GridData();
					comboMonthLData.horizontalSpan = 2;
					comboMonthLData.widthHint = 89;
					comboMonthLData.heightHint = 14;
					comboMonth.setLayoutData(comboMonthLData);
				}
				{
					lblAccStart = new CLabel(compAdvanced, SWT.NONE);
					lblAccStart.setText(Messages.getString("AccUIAccountingMonthlyBalance.15")); //$NON-NLS-1$
				}
				{
					accountPickerStart = new AccountPicker(
						compAdvanced,
						SWT.NONE);
					GridData accountPickerStartLData = new GridData();
					accountPickerStartLData.widthHint = 105;
					accountPickerStartLData.heightHint = 13;
					accountPickerStart.setLayoutData(accountPickerStartLData);
				}
				{
					lblAccEnd = new CLabel(compAdvanced, SWT.NONE);
					lblAccEnd.setText(Messages.getString("AccUIAccountingMonthlyBalance.16")); //$NON-NLS-1$
					GridData lblAccEndLData = new GridData();
					lblAccEndLData.widthHint = 139;
					lblAccEndLData.heightHint = 16;
					lblAccEnd.setLayoutData(lblAccEndLData);
				}
				{
					accountPickerEnd = new AccountPicker(compAdvanced, SWT.NONE);
					GridData accountPickerEndLData = new GridData();
					accountPickerEndLData.widthHint = 102;
					accountPickerEndLData.heightHint = 13;
					accountPickerEnd.setLayoutData(accountPickerEndLData);
				}
			}
			//START >>  groupRemainder
			groupRemainder = new Group(this, SWT.NONE);
			GridLayout groupRemainderLayout = new GridLayout();
			groupRemainderLayout.numColumns = 4;
			groupRemainderLayout.horizontalSpacing = 4;
			groupRemainder.setText(Messages
				.getString("AccUIAccountingAdvancedBalance.14"));
			GridData groupRemainderLData = new GridData();
			groupRemainder.setLayout(groupRemainderLayout);
			groupRemainderLData.widthHint = 253;
			groupRemainderLData.heightHint = 25;
			groupRemainder.setLayoutData(groupRemainderLData);
			//START >>  radioUseMainAccounts
			radioUseMainAccounts = new Button(groupRemainder, SWT.RADIO
				| SWT.LEFT);
			radioUseMainAccounts.setText(Messages
				.getString("AccUIAccountingAdvancedBalance.15"));
			radioUseMainAccounts.setSelection(true);
			//END <<  radioUseMainAccounts
			//START >>  radioUseRemainder
			radioUseRemainder = new Button(groupRemainder, SWT.RADIO | SWT.LEFT);
			radioUseRemainder.setText(Messages
				.getString("AccUIAccountingAdvancedBalance.16"));
			GridData radioUseRemainderLData = new GridData();
			radioUseRemainderLData.widthHint = 103;
			radioUseRemainderLData.heightHint = 13;
			radioUseRemainder.setLayoutData(radioUseRemainderLData);
			//END <<  radioUseRemainder
			//END <<  groupRemainder
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
						tableColumnAccountCode = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnAccountCode.setText(Messages.getString("AccUIAccountingMonthlyBalance.17")); //$NON-NLS-1$
						tableColumnAccountCode.setWidth(120);
					}
					{
						tableColumnAccountName = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnAccountName.setText(Messages.getString("AccUIAccountingMonthlyBalance.18")); //$NON-NLS-1$
						tableColumnAccountName.setWidth(120);
					}
					{
						tableColumnTotalDept = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.RIGHT);
						tableColumnTotalDept.setText(Messages.getString("AccUIAccountingMonthlyBalance.19")); //$NON-NLS-1$
						tableColumnTotalDept.setWidth(120);
					}
					{
						tableColumnTotalCredit = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.RIGHT);
						tableColumnTotalCredit.setText(Messages.getString("AccUIAccountingMonthlyBalance.20")); //$NON-NLS-1$
						tableColumnTotalCredit.setWidth(120);
					}
					tableTreeAccountsLData.grabExcessHorizontalSpace = true;
					tableTreeAccountsLData.grabExcessVerticalSpace = true;
					tableTreeAccountsLData.horizontalAlignment = GridData.FILL;
					tableTreeAccountsLData.verticalAlignment = GridData.FILL;
					tableTreeAccounts.setLayoutData(tableTreeAccountsLData);
					tableTreeAccounts.getTable().setLinesVisible(true);
					tableTreeAccounts.getTable().setHeaderVisible(true);
					{
						tableColumnRemain = new TableColumn(tableTreeAccounts
							.getTable(), SWT.RIGHT);
						tableColumnRemain.setText(Messages.getString("AccUIAccountingMonthlyBalance.21")); //$NON-NLS-1$
						tableColumnRemain.setWidth(120);
					}
					{
						tableColumnCreditRemaining = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.RIGHT);
						tableColumnCreditRemaining.setText(Messages.getString("AccUIAccountingMonthlyBalance.22")); //$NON-NLS-1$
						tableColumnCreditRemaining.setWidth(120);
					}

				}
			}
			this.layout();
			PostInit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void PostInit()
	{
		int month=cal.get(Calendar.MONTH);
		for(int k=0; k<=month; k++)
		{
			comboMonth.add(months[k]);
			comboMonth.setData(months[k],new Integer(k+1));
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
			int month=((Integer)comboMonth.getData(comboMonth.getText())).intValue();
			Calendar startCal=Calendar.getInstance();
			startCal.set(startCal.get(Calendar.YEAR),month-1,1);
			Calendar endCal=Calendar.getInstance();
			endCal.set(endCal.get(Calendar.YEAR),month-1,1);
			endCal.add(2,1);
			endCal.add(Calendar.DATE,-1);
			List allAccounts = blSearch.getTransactions(accountPickerStart.getData(),accountPickerEnd.getData(),false,
				false,
				startCal.getTime() ,
				 endCal.getTime() );
	
			TurqAccountingAccount account;

			Integer parentId,accountId;
		
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			
			
			BigDecimal totalCredit=new BigDecimal(0);
			BigDecimal totalDept=new BigDecimal(0);
			BigDecimal totalDeptRemain=new BigDecimal(0);
			BigDecimal totalCreditRemain=new BigDecimal(0);
			
			boolean useMainAccountsRemain=radioUseMainAccounts.getSelection();
			
			for(int i =0; i< allAccounts.size();i++)
			{
				account = (TurqAccountingAccount)((Object[])allAccounts.get(i))[0];
				BigDecimal transDept=(BigDecimal)((Object[])allAccounts.get(i))[1];
				BigDecimal transCredit=(BigDecimal)((Object[])allAccounts.get(i))[2];
				
				totalCredit=totalCredit.add(transCredit);
				totalDept=totalDept.add(transDept);
				
				
				parentId = account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId();
				accountId=account.getAccountingAccountsId();
				LocateAccountToTable(account);

				TableTreeItem accountItem=(TableTreeItem)treeItems.get(accountId);
				BigDecimal dept=cf.getBigDecimal(accountItem.getText(2));
				BigDecimal credit=cf.getBigDecimal(accountItem.getText(3));
				dept=dept.add(transDept);
				credit=credit.add(transCredit);
				accountItem.setText(2,cf.format(dept));
				accountItem.setText(3,cf.format(credit));
				
				BigDecimal remaining=transCredit.subtract(transDept);
				
				if (!useMainAccountsRemain)
				{
					if (remaining.doubleValue()< 0)
						totalDeptRemain=totalDeptRemain.add(remaining);
					else if (remaining.doubleValue() > 0)
						totalCreditRemain=totalCreditRemain.add(remaining);
						
				}
								
				
				accountItem.setText(4,(remaining.doubleValue() <= 0) ? cf.format(remaining.abs()) : ""); //$NON-NLS-1$
				accountItem.setText(5,(remaining.doubleValue() > 0) ? cf.format(remaining) : ""); //$NON-NLS-1$
				TurqAccountingAccount parentAcc=account.getTurqAccountingAccountByParentAccount();
				while(parentId.intValue()!=-1)
				{					
					accountItem=(TableTreeItem)treeItems.get(parentId);
					dept=cf.getBigDecimal(accountItem.getText(2));
					credit=cf.getBigDecimal(accountItem.getText(3));
					dept=dept.add(transDept);
					credit=credit.add(transCredit);
					accountItem.setText(2,cf.format(dept));
					accountItem.setText(3,cf.format(credit));
					
					String remain=accountItem.getText(4);
					BigDecimal initRemain;
					
					if (remain!=null && !remain.equals(""))
						initRemain=cf.getBigDecimal(remain).negate();
					else
						initRemain=cf.getBigDecimal(accountItem.getText(5));
					
					
					BigDecimal newremaining=remaining.add(initRemain);
					accountItem.setText(4,(newremaining.doubleValue() <= 0)? cf.format(newremaining.abs()):""); //$NON-NLS-1$
					accountItem.setText(5,(newremaining.doubleValue() > 0)? cf.format(newremaining):""); //$NON-NLS-1$
					parentAcc=parentAcc.getTurqAccountingAccountByParentAccount();
					parentId=parentAcc.getAccountingAccountsId();
				}
			}
			if (useMainAccountsRemain)
			{

				TableTreeItem[] allitems=tableTreeAccounts.getItems();
				for(int k=0; k<allitems.length; k++)
				{
					TableTreeItem titem=allitems[k];
					String remain=titem.getText(4);
					BigDecimal initRemain;
					if (remain!=null && !remain.equals(""))
						initRemain=cf.getBigDecimal(remain).negate();
					else
						initRemain=cf.getBigDecimal(titem.getText(5));
					if (initRemain.doubleValue() <= 0)
						totalDeptRemain=totalDeptRemain.add(initRemain);
					else
						totalCreditRemain=totalCreditRemain.add(initRemain);
				
				}
			}
			
			
			TableTreeItem dummy = new TableTreeItem(tableTreeAccounts,SWT.NULL);
			TableTreeItem totals = new TableTreeItem(tableTreeAccounts,SWT.RIGHT);
			totals.setText(1,"TOPLAM");
			totals.setText(2,cf.format(totalDept));
			totals.setText(3,cf.format(totalCredit));
			totals.setText(4,cf.format(totalDeptRemain.abs()));
			totals.setText(5,cf.format(totalCreditRemain));
			
			boolean expand=checkSubAccounts.getSelection();
			if (expand)
			{
				TableTreeItem[] subItems=tableTreeAccounts.getItems();
				for (int k=0; k<subItems.length; k++)
				{
					expandTree(subItems[k],expand);
				}
			}
			
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
			ex.printStackTrace();


		}
	}
	
	private void LocateAccountToTable(TurqAccountingAccount account)
	{
		

		if (!treeItems.containsKey(account.getAccountingAccountsId()))
		{


			Integer parentId=account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId();
			if (parentId.intValue()!=-1)
			{
				TurqAccountingAccount parentAcc=account.getTurqAccountingAccountByParentAccount();
				LocateAccountToTable(parentAcc);
				TableTreeItem parentItem=(TableTreeItem)treeItems.get(parentId);
				
				int k;
				String accCode=account.getAccountCode();
				TableTreeItem parentItems[]=parentItem.getItems();
				for(k=0; k<parentItems.length; k++)
				{
					TableTreeItem pItem=parentItems[k];
					if (accCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				
				TableTreeItem item = new TableTreeItem(parentItem,SWT.NULL,k);	
				item.setText(0,account.getAccountCode());
				item.setText(1,account.getAccountName());
				item.setText(2,"0.00"); //$NON-NLS-1$
				item.setText(3,"0.00"); //$NON-NLS-1$
				item.setText(4,"0.00"); //$NON-NLS-1$
				item.setText(5,"0.00"); //$NON-NLS-1$
				item.setData(account);	
				treeItems.put(account.getAccountingAccountsId(),item);
				
				
			}
			else
			{
				TableTreeItem parentItems[]=tableTreeAccounts.getItems();
				int k;
				String accCode=account.getAccountCode();
				for(k=0; k<parentItems.length; k++)
				{
					TableTreeItem pItem=parentItems[k];
					if (accCode.compareTo(pItem.getText(0)) < 0)
						break;
				}
				TableTreeItem item = new TableTreeItem(tableTreeAccounts,SWT.NULL,k);						
				item.setText(0,account.getAccountCode());
				item.setText(1,account.getAccountName());
				item.setText(2,"0.00"); //$NON-NLS-1$
				item.setText(3,"0.00"); //$NON-NLS-1$
				item.setText(4,"0.00"); //$NON-NLS-1$
				item.setText(5,"0.00"); //$NON-NLS-1$
				item.setData(account);	
				treeItems.put(account.getAccountingAccountsId(),item);	
				
			}
		}
	}
	
	public void expandTree(TableTreeItem tableItem, boolean expand)
	{
		tableItem.setExpanded(expand);
		TableTreeItem[] subTree=tableItem.getItems();
		for (int k=0; k<subTree.length ; k++)
		{
			expandTree(subTree[k], expand);
		}
	}
	
	public void printTable(){
	    EngBLUtils.printTable(tableTreeAccounts.getTable(),""); //$NON-NLS-1$
	    
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableTreeAccounts.getTable());		
	}
	
	public void delete()
	{
		
	}
	
}

































