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
import java.util.Date;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;


import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;

import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
public class AccUIAccountingAdvancedBalance extends org.eclipse.swt.widgets.Composite implements SearchComposite {
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnRemain;
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
	private AccBLTransactionSearch blSearch=new AccBLTransactionSearch();

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
		AccUIAccountingAdvancedBalance inst = new AccUIAccountingAdvancedBalance(shell, SWT.NULL);
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

	public AccUIAccountingAdvancedBalance(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	Calendar cal = Calendar.getInstance();
	
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
					checkSubAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.0")); //$NON-NLS-1$
						GridData checkSubAccountsLData = new GridData();
						checkSubAccountsLData.widthHint = 156;
						checkSubAccountsLData.heightHint = 16;
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
					checkInitialAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkInitialAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.1")); //$NON-NLS-1$
						GridData checkInitialAccountsLData = new GridData();
						checkInitialAccountsLData.widthHint = 162;
						checkInitialAccountsLData.heightHint = 16;
						checkInitialAccounts.setLayoutData(checkInitialAccountsLData);
						GridData checkInitialAccountsLData1 = new GridData();
						checkInitialAccountsLData1.widthHint = 158;
						checkInitialAccountsLData1.heightHint = 16;
				}
				{
					checkFinalAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkFinalAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.2")); //$NON-NLS-1$
						GridData checkFinalAccountsLData = new GridData();
						checkFinalAccountsLData.horizontalSpan = 2;
						checkFinalAccountsLData.widthHint = 172;
						checkFinalAccountsLData.heightHint = 16;
						checkFinalAccounts.setLayoutData(checkFinalAccountsLData);
				}
				{
					lblStartDate = new CLabel(compAdvanced, SWT.NONE);
					lblStartDate.setText(Messages.getString("AccUIAccountingAdvancedBalance.3")); //$NON-NLS-1$
				}
				{
					datePickerStart = new DatePicker(compAdvanced, SWT.NONE);
					datePickerStart.setDate(new Date(cal.getTime().getYear(),0,1));
				}
				{
					lblEndDate = new Label(compAdvanced, SWT.NONE);
					lblEndDate.setText(Messages.getString("AccUIAccountingAdvancedBalance.4")); //$NON-NLS-1$
				}
				{
					datePickerEnd = new DatePicker(compAdvanced, SWT.NONE);
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
						tableColumnAccountCode = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnAccountCode.setText(Messages
							.getString("AccUIAccountingAdvancedBalance.5")); //$NON-NLS-1$
						tableColumnAccountCode.setWidth(120);
					}
					{
						tableColumnAccountName = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnAccountName.setText(Messages
							.getString("AccUIAccountingAdvancedBalance.6")); //$NON-NLS-1$
						tableColumnAccountName.setWidth(120);
					}
					{
						tableColumnTotalDept = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnTotalDept.setText(Messages
							.getString("AccUIAccountingAdvancedBalance.7")); //$NON-NLS-1$
						tableColumnTotalDept.setWidth(120);
					}
					{
						tableColumnTotalCredit = new TableColumn(
							tableTreeAccounts.getTable(),
							SWT.NONE);
						tableColumnTotalCredit.setText(Messages
							.getString("AccUIAccountingAdvancedBalance.8")); //$NON-NLS-1$
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
							.getTable(), SWT.NONE);
						tableColumnRemain.setText("Bakiye ( Borç )");
						tableColumnRemain.setWidth(120);
					}
				}
			}
			this.layout();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search()
	{
		try
		{
			tableTreeAccounts.removeAll();
			Map treeItems = new HashMap();		
			TableTreeItem item;

			List allAccounts = blSearch.getTransactions(checkInitialAccounts.getSelection(),
				checkFinalAccounts.getSelection(),
				 datePickerStart.getDate() ,
				 datePickerEnd.getDate() );
	
			TurqAccountingAccount account;

			Integer parentId;
		
		
			for(int i =0; i< allAccounts.size();i++)
			{
				account = (TurqAccountingAccount)((Object[])allAccounts.get(i))[0];
				BigDecimal transDept=(BigDecimal)((Object[])allAccounts.get(i))[1];
				BigDecimal transCredit=(BigDecimal)((Object[])allAccounts.get(i))[2];
				parentId = account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId();
		
				if(parentId.intValue()==-1){
					if (!treeItems.containsKey(account.getAccountingAccountsId()))
					{
						item = new TableTreeItem(tableTreeAccounts,SWT.NULL);
						item.setText(0,account.getAccountCode());
						item.setText(1,account.getAccountName());
						item.setText(2,transDept.toString());
						item.setText(3,transCredit.toString());
						item.setText(4,transDept.subtract(transCredit).toString());
						item.setData(account);	
						treeItems.put(account.getAccountingAccountsId(),item);
					}
					else
					{
						item=(TableTreeItem)treeItems.get(account.getAccountingAccountsId());
						BigDecimal dept=new BigDecimal(item.getText(2));
						BigDecimal credit=new BigDecimal(item.getText(3));
						dept=dept.add(transDept);
						credit=credit.add(transCredit);
						item.setText(2,dept.toString());
						item.setText(3,credit.toString());
						item.setText(4,dept.subtract(credit).toString());
					}
				}
				else
				{
				
					TableTreeItem parentItem = (TableTreeItem)treeItems.get(parentId);
					TurqAccountingAccount parentAccount;
					if (!treeItems.containsKey(account.getAccountingAccountsId()))
					{
						item = new TableTreeItem(parentItem,SWT.NULL);	
						treeItems.put(account.getAccountingAccountsId(),item);
						item.setText(0,account.getAccountCode());
						item.setText(1,account.getAccountName());
						item.setText(2,transDept.toString());
						item.setText(3,transCredit.toString());
						item.setText(4,transDept.subtract(transCredit).toString());
						item.setData(account);	
						
						while ((parentAccount=account.getTurqAccountingAccountByParentAccount()).getAccountingAccountsId().intValue()!=-1)
						{
							parentItem=(TableTreeItem)treeItems.get(parentAccount.getAccountingAccountsId());	
							BigDecimal dept=new BigDecimal(parentItem.getText(2));
							BigDecimal credit=new BigDecimal(parentItem.getText(3));
							dept=dept.add(transDept);
							credit=credit.add(transCredit);
							parentItem.setText(2,dept.toString());
							parentItem.setText(3,credit.toString());
							parentItem.setText(4,dept.subtract(credit).toString());
							parentAccount=parentAccount.getTurqAccountingAccountByParentAccount();
						}
					}
					else
					{
						item=(TableTreeItem)treeItems.get(account.getAccountingAccountsId());
						BigDecimal dept=new BigDecimal(item.getText(2));
						BigDecimal credit=new BigDecimal(item.getText(3));
						dept=dept.add(transDept);
						credit=credit.add(transCredit);
						item.setText(2,dept.toString());
						item.setText(3,credit.toString());
						item.setText(4,dept.subtract(credit).toString());
						while ((parentAccount=account.getTurqAccountingAccountByParentAccount()).getAccountingAccountsId().intValue()!=-1)
						{
							parentItem=(TableTreeItem)treeItems.get(parentAccount.getAccountingAccountsId());	
							dept=new BigDecimal(parentItem.getText(2));
							credit=new BigDecimal(parentItem.getText(3));
							dept=dept.add(transDept);
							credit=credit.add(transCredit);
							parentItem.setText(2,dept.toString());
							parentItem.setText(3,credit.toString());
							parentItem.setText(4,dept.subtract(credit).toString());
							parentAccount=parentAccount.getTurqAccountingAccountByParentAccount();
						}
					}
				}
			}
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
			msg.setMessage(ex.getMessage());
			msg.open();
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
	    EngBLUtils.printTable(tableTreeAccounts.getTable(),Messages.getString("AccUIAccountingAdvancedBalance.9")); //$NON-NLS-1$
	    
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableTreeAccounts.getTable());		
	}
	
	public void delete()
	{
		
	}
}
