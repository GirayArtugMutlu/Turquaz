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
* @author  Cem Dayan?k
* @version  $Id$
*/

import java.math.BigDecimal;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class AccUIAccountingAdvancedBalance extends org.eclipse.swt.widgets.Composite {
	private TableColumn tableColumnTotalCredit;
	private TableTree tableTreeAccounts;
	private Composite compTable;
	private Button btnShow;
	private DatePicker datePickerEnd;
	private DatePicker datePickerStart;
	private Button checkDateRange;
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
				compAdvancedLayout.makeColumnsEqualWidth = true;
				compAdvancedLayout.numColumns = 3;
				compAdvanced.setLayout(compAdvancedLayout);
				{
					checkSubAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkSubAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.0")); //$NON-NLS-1$
						checkSubAccounts
							.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									if (checkSubAccounts.getSelection()) {
										TableTreeItem[] subItems = tableTreeAccounts
											.getItems();
										for (int k = 0; k < subItems.length; k++) {
											subItems[k].setExpanded(true);
										}
									} else {
										if (checkSubAccounts.getSelection()) {
											TableTreeItem[] subItems = tableTreeAccounts
												.getItems();
											for (int k = 0; k < subItems.length; k++) {
												subItems[k].setExpanded(false);
											}
										}
									}
								}
							});
				}
				{
					checkInitialAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkInitialAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.1")); //$NON-NLS-1$
				}
				{
					checkFinalAccounts = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkFinalAccounts.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.2")); //$NON-NLS-1$
				}
				{
					checkDateRange = new Button(compAdvanced, SWT.CHECK | SWT.LEFT);
					checkDateRange.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.3")); //$NON-NLS-1$
				}
				{
					datePickerStart = new DatePicker(compAdvanced, SWT.NONE);
				}
				{
					datePickerEnd = new DatePicker(compAdvanced, SWT.NONE);
				}
				{
					btnShow = new Button(compAdvanced, SWT.PUSH | SWT.CENTER);
					btnShow.setText(Messages
						.getString("AccUIAccountingAdvancedBalance.4")); //$NON-NLS-1$
						btnShow.addMouseListener(new MouseAdapter() {
							public void mouseUp(MouseEvent evt) {
								btnShowSingleClick();
							}
						});
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
				}
			}
			this.layout();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void btnShowSingleClick()
	{
		try
		{
			tableTreeAccounts.removeAll();
			Map treeItems = new HashMap();		
			TableTreeItem item;

			List allAccounts = blSearch.getTransactions(checkInitialAccounts.getSelection(),
				checkFinalAccounts.getSelection(),
				checkDateRange.getSelection() ? datePickerStart.getDate() : null,
				checkDateRange.getSelection() ? datePickerEnd.getDate() : null);
	
			TurqAccountingAccount account;

			Integer parentId;
		
		
			for(int i =0; i< allAccounts.size();i++)
			{
				account = (TurqAccountingAccount)((Object[])allAccounts.get(i))[0];
				BigDecimal transDept=(BigDecimal)((Object[])allAccounts.get(i))[1];
				BigDecimal transCredit=(BigDecimal)((Object[])allAccounts.get(i))[1];
				parentId = account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId();
		
				if(parentId.intValue()==-1){
					if (!treeItems.containsKey(account.getAccountingAccountsId()))
					{
						item = new TableTreeItem(tableTreeAccounts,SWT.NULL);
						item.setText(0,account.getAccountCode());
						item.setText(1,account.getAccountName());
						item.setText(2,transDept.toString());
						item.setText(3,transCredit.toString());
						item.setData(account);	
						treeItems.put(account.getAccountingAccountsId(),item);
					}
					else
					{
						item=(TableTreeItem)treeItems.get(account.getAccountingAccountsId());
						BigDecimal dept=new BigDecimal(item.getText(2));
						BigDecimal credit=new BigDecimal(item.getText(3));
						item.setText(2,dept.add(transDept).toString());
						item.setText(3,dept.add(transCredit).toString());
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
						item.setData(account);	
						
						while ((parentAccount=account.getTurqAccountingAccountByParentAccount()).getAccountingAccountsId().intValue()!=-1)
						{
							parentItem=(TableTreeItem)treeItems.get(parentAccount.getAccountingAccountsId());	
							BigDecimal dept=new BigDecimal(parentItem.getText(2));
							BigDecimal credit=new BigDecimal(parentItem.getText(3));
							parentItem.setText(2,dept.add(transDept).toString());
							parentItem.setText(3,dept.add(transCredit).toString());
							parentAccount=parentAccount.getTurqAccountingAccountByParentAccount();
						}
					}
					else
					{
						item=(TableTreeItem)treeItems.get(account.getAccountingAccountsId());
						BigDecimal dept=new BigDecimal(item.getText(2));
						BigDecimal credit=new BigDecimal(item.getText(3));
						item.setText(2,dept.add(transDept).toString());
						item.setText(3,dept.add(transCredit).toString());
						while ((parentAccount=account.getTurqAccountingAccountByParentAccount()).getAccountingAccountsId().intValue()!=-1)
						{
							parentItem=(TableTreeItem)treeItems.get(parentAccount.getAccountingAccountsId());	
							dept=new BigDecimal(parentItem.getText(2));
							credit=new BigDecimal(parentItem.getText(3));
							parentItem.setText(2,dept.add(transDept).toString());
							parentItem.setText(3,dept.add(transCredit).toString());
							parentAccount=parentAccount.getTurqAccountingAccountByParentAccount();
						}
					}
				}
			}
			
			if (checkSubAccounts.getSelection())
			{
				TableTreeItem[] subItems=tableTreeAccounts.getItems();
				for (int k=0; k<subItems.length; k++)
				{
					subItems[k].setExpanded(true);
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
	
	public void printTable(){
	    EngBLUtils.printTable(tableTreeAccounts.getTable(),"Mizan");
	    
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableTreeAccounts.getTable());
		
	 }
}
