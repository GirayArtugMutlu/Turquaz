package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.turquaz.accounting.ui.AccUIAccountingPlan;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.accounting.ui.AccUIInitialTransaction;
import com.turquaz.accounting.ui.AccUISaveJournal;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.accounting.ui.AccUITransactionSearch;
import com.turquaz.accounting.ui.reports.AccUIAccountingAdvancedBalance;
import com.turquaz.accounting.ui.reports.AccUIAccountingGeneralLedger;
import com.turquaz.accounting.ui.reports.AccUIAccountingJournal;
import com.turquaz.accounting.ui.reports.AccUIAccountingMonthlyBalance;
import com.turquaz.accounting.ui.reports.AccUISubsidiaryLedger;
import com.turquaz.admin.ui.AdmUICompanyInfo;
import com.turquaz.admin.ui.AdmUIGroupAdd;
import com.turquaz.admin.ui.AdmUIGroupPermissions;
import com.turquaz.admin.ui.AdmUIGroups;
import com.turquaz.admin.ui.AdmUIUserAdd;
import com.turquaz.admin.ui.AdmUIUserPermissions;
import com.turquaz.admin.ui.AdmUIUsers;
import com.turquaz.bank.ui.BankUIBankCardAbstract;
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.bank.ui.BankUIBankCardSearch;
import com.turquaz.bank.ui.BankUICashFromBank;
import com.turquaz.bank.ui.BankUICashToBank;
import com.turquaz.bank.ui.BankUIInitialTransaction;
import com.turquaz.bank.ui.BankUIMoneyTransferIn;
import com.turquaz.bank.ui.BankUIMoneyTransferOut;
import com.turquaz.bank.ui.BankUIOtherTransIn;
import com.turquaz.bank.ui.BankUIOtherTransOut;
import com.turquaz.bank.ui.BankUISearchMoneyTransaction;
import com.turquaz.bank.ui.BankUITransferBetweenAccounts;
import com.turquaz.bill.ui.BillUIAddBuyBill;
import com.turquaz.bill.ui.BillUIAddSellBill;
import com.turquaz.bill.ui.BillUIBillFromConsignment;
import com.turquaz.bill.ui.BillUIBillReport;
import com.turquaz.bill.ui.BillUIBillSearch;
import com.turquaz.cash.ui.CashUICashCardAbstract;
import com.turquaz.cash.ui.CashUICashCardAdd;
import com.turquaz.cash.ui.CashUICashCardDailyAbstract;
import com.turquaz.cash.ui.CashUICashCardSearch;
import com.turquaz.cash.ui.CashUICashCollectTransactionAdd;
import com.turquaz.cash.ui.CashUICashPaymentTransactionAdd;
import com.turquaz.cash.ui.CashUICashTransactionSearch;
import com.turquaz.consignment.ui.ConUIAddConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearch;
import com.turquaz.current.ui.CurUICurrentCardAbstract;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.current.ui.CurUICurrentCardVoucher;
import com.turquaz.current.ui.CurUIInitialTransaction;
import com.turquaz.current.ui.CurUITransactionSearch;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.InvUICardSearch;
import com.turquaz.inventory.ui.InvUIGroupingPlan;
import com.turquaz.inventory.ui.InvUIInventoryCardAbstract;
import com.turquaz.inventory.ui.InvUIInventoryGroupAdd;
import com.turquaz.inventory.ui.InvUIInventoryLedger;
import com.turquaz.inventory.ui.InvUIInventoryTransactionReport;
import com.turquaz.inventory.ui.InvUIProfitAnalysis;
import com.turquaz.inventory.ui.InvUITransactionSearch;
import com.turquaz.inventory.ui.InvUITransactionsTotalReport;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import com.turquaz.inventory.ui.InvUIWarehouseSearch;
import com.turquaz.engine.Messages;


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
 * @author Huseyin Ergun
 * @version $Id$
 */

public class MenuFactory {

	public static MenuItem createFinanceMenu(MenuItem menuItem) {

		Menu menuFinance = new Menu(menuItem);
		menuItem.setMenu(menuFinance);

		MenuItem mit;
		MenuItem sps;

		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.0")); //$NON-NLS-1$

		Menu currentMenu = new Menu(mit);
		mit.setMenu(currentMenu);

		// current menu items
		if (EngBLPermissions.getPermission(CurUICurrentCardAdd.class.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.1"));  //$NON-NLS-1$
			mit.setData(CurUICurrentCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(currentMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CurUICurrentCardVoucher.class
				.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.2"));  //$NON-NLS-1$
			mit.setData(CurUICurrentCardVoucher.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(currentMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CurUICurrentCardSearch.class
				.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.3"));  //$NON-NLS-1$
			mit.setData(CurUICurrentCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(CurUITransactionSearch.class
				.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.4"));  //$NON-NLS-1$
			mit.setData(CurUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(currentMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CurUICurrentCardAbstract.class
				.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.5"));  //$NON-NLS-1$
			mit.setData(CurUICurrentCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(currentMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CurUIInitialTransaction.class
				.getName()) > 0) {
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.6"));  //$NON-NLS-1$
			mit.setData(CurUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.7"));  //$NON-NLS-1$

		Menu chequeMenu = new Menu(mit);
		mit.setMenu(chequeMenu);

		//	cheque menu items

		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.8"));  //$NON-NLS-1$

		Menu bankMenu = new Menu(mit);
		mit.setMenu(bankMenu);

		//	bank menu items

		if (EngBLPermissions.getPermission(BankUIBankCardAdd.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.9"));  //$NON-NLS-1$
			mit.setData(BankUIBankCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(bankMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(BankUIMoneyTransferIn.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.10"));  //$NON-NLS-1$
			mit.setData(BankUIMoneyTransferIn.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUIMoneyTransferOut.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.11"));  //$NON-NLS-1$
			mit.setData(BankUIMoneyTransferOut.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUICashFromBank.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.12"));  //$NON-NLS-1$
			mit.setData(BankUICashFromBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUICashToBank.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.13"));  //$NON-NLS-1$
			mit.setData(BankUICashToBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUIOtherTransIn.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.14"));  //$NON-NLS-1$
			mit.setData(BankUIOtherTransIn.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUIOtherTransOut.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.15"));  //$NON-NLS-1$
			mit.setData(BankUIOtherTransOut.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUITransferBetweenAccounts.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.16"));  //$NON-NLS-1$
			mit.setData(BankUITransferBetweenAccounts.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(bankMenu, SWT.SEPARATOR);

		if (EngBLPermissions
				.getPermission(BankUIBankCardSearch.class.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.17"));  //$NON-NLS-1$
			mit.setData(BankUIBankCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(BankUISearchMoneyTransaction.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.18")); //$NON-NLS-1$
			mit.setData(BankUISearchMoneyTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(bankMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(BankUIBankCardAbstract.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.19"));  //$NON-NLS-1$
			mit.setData(BankUIBankCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(bankMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(BankUIInitialTransaction.class
				.getName()) > 0) {
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.20"));  //$NON-NLS-1$
			mit.setData(BankUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.21"));  //$NON-NLS-1$

		Menu cashMenu = new Menu(mit);
		mit.setMenu(cashMenu);
		
		if (EngBLPermissions.getPermission(CashUICashCardAdd.class.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.22"));  //$NON-NLS-1$
			mit.setData(CashUICashCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(cashMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CashUICashCollectTransactionAdd.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.23"));  //$NON-NLS-1$
			mit.setData(CashUICashCollectTransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(CashUICashPaymentTransactionAdd.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.24"));  //$NON-NLS-1$
			mit.setData(CashUICashPaymentTransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		sps = new MenuItem(cashMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CashUICashCardSearch.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.25"));  //$NON-NLS-1$
			mit.setData(CashUICashCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		if (EngBLPermissions.getPermission(CashUICashTransactionSearch.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.26"));  //$NON-NLS-1$
			mit.setData(CashUICashTransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		sps = new MenuItem(cashMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(CashUICashCardAbstract.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.27"));  //$NON-NLS-1$
			mit.setData(CashUICashCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		if (EngBLPermissions.getPermission(CashUICashCardDailyAbstract.class
				.getName()) > 0) {
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.28"));  //$NON-NLS-1$
			mit.setData(CashUICashCardDailyAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		return menuItem;
	}

	public static MenuItem createAccountingMenu(MenuItem menuItem) {

		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);

		MenuItem mit;
		MenuItem sps;

		//accounting Menu Items
		if (EngBLPermissions.getPermission(AccUIAccountingPlan.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.29"));  //$NON-NLS-1$
			mit.setData(AccUIAccountingPlan.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUIAddAccounts.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.30"));  //$NON-NLS-1$
			mit.setData(AccUIAddAccounts.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AccUITransactionAdd.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.31"));  //$NON-NLS-1$
			mit.setData(AccUITransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUITransactionCollect.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.32"));  //$NON-NLS-1$
			mit.setData(AccUITransactionCollect.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUITransactionPayment.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.33"));  //$NON-NLS-1$
			mit.setData(AccUITransactionPayment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AccUITransactionSearch.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.34"));  //$NON-NLS-1$
			mit.setData(AccUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AccUIAccountingJournal.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.35")); //$NON-NLS-1$
			mit.setData(AccUIAccountingJournal.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUISubsidiaryLedger.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.36"));  //$NON-NLS-1$
			mit.setData(AccUISubsidiaryLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUIAccountingGeneralLedger.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.37"));  //$NON-NLS-1$
			mit.setData(AccUIAccountingGeneralLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AccUIAccountingAdvancedBalance.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.38"));  //$NON-NLS-1$
			mit.setData(AccUIAccountingAdvancedBalance.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUIAccountingMonthlyBalance.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.39"));  //$NON-NLS-1$
			mit.setData(AccUIAccountingMonthlyBalance.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AccUIInitialTransaction.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.40"));  //$NON-NLS-1$
			mit.setData(AccUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AccUIInitialTransaction.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.41")); //$NON-NLS-1$
			mit.setData(AccUISaveJournal.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		return menuItem;
	}
	
	public static MenuItem createSalesMenu(MenuItem menuItem) {

		Menu menuSales = new Menu(menuItem);
		menuItem.setMenu(menuSales);

		MenuItem mit;
		MenuItem sps;
		
		mit = new MenuItem(menuSales, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.42"));  //$NON-NLS-1$

		Menu invoiceMenu = new Menu(mit);
		mit.setMenu(invoiceMenu);

		//Invoice Menu Items
		if (EngBLPermissions.getPermission(BillUIAddBuyBill.class.getName()) > 0) {
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.43"));  //$NON-NLS-1$
			mit.setData(BillUIAddBuyBill.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		if (EngBLPermissions.getPermission(BillUIAddSellBill.class.getName()) > 0) {
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.44"));  //$NON-NLS-1$
			mit.setData(BillUIAddSellBill.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		if (EngBLPermissions.getPermission(BillUIBillFromConsignment.class.getName()) > 0) {
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.45"));  //$NON-NLS-1$
			mit.setData(BillUIBillFromConsignment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		sps = new MenuItem(invoiceMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(BillUIBillSearch.class.getName()) > 0) {
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.46"));  //$NON-NLS-1$
			mit.setData(BillUIBillSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		sps = new MenuItem(invoiceMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(BillUIBillReport.class.getName()) > 0) {
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.47"));  //$NON-NLS-1$
			mit.setData(BillUIBillReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		
		mit = new MenuItem(menuSales, SWT.CASCADE);
		mit.setText(Messages.getString("MenuFactory.48"));  //$NON-NLS-1$

		Menu despatchMenu = new Menu(mit);
		mit.setMenu(despatchMenu);
		
		if (EngBLPermissions.getPermission(ConUIAddConsignment.class.getName()) > 0) {
			mit = new MenuItem(despatchMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.49"));  //$NON-NLS-1$
			mit.setData(ConUIAddConsignment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		sps = new MenuItem(despatchMenu, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(ConUIConsignmentSearch.class.getName()) > 0) {
			mit = new MenuItem(despatchMenu, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.50")); //$NON-NLS-1$
			mit.setData(ConUIConsignmentSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
		return menuItem;
	}
		

	public static MenuItem createInventoryMenu(MenuItem menuItem) {

		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);

		MenuItem mit;
		MenuItem sps;

		//Inventory Menu Items

		if (EngBLPermissions.getPermission(InvUICardAdd.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.51"));  //$NON-NLS-1$
			mit.setData(InvUICardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(InvUIWarehouseAdd.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.52"));  //$NON-NLS-1$
			mit.setData(InvUIWarehouseAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(InvUICardSearch.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.53"));  //$NON-NLS-1$
			mit.setData(InvUICardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(InvUITransactionSearch.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.54")); //$NON-NLS-1$
			mit.setData(InvUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions
				.getPermission(InvUIWarehouseSearch.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.55"));  //$NON-NLS-1$
			mit.setData(InvUIWarehouseSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(InvUIProfitAnalysis.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.56"));  //$NON-NLS-1$
			mit.setData(InvUIProfitAnalysis.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions
				.getPermission(InvUIInventoryLedger.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.57"));  //$NON-NLS-1$
			mit.setData(InvUIInventoryLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions
				.getPermission(InvUIInventoryTransactionReport.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.58"));  //$NON-NLS-1$
			mit.setData(InvUIInventoryTransactionReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUITransactionsTotalReport.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.59"));  //$NON-NLS-1$
			mit.setData(InvUITransactionsTotalReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIInventoryCardAbstract.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.60"));  //$NON-NLS-1$
			mit.setData(InvUIInventoryCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(InvUIGroupingPlan.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.61"));  //$NON-NLS-1$
			mit.setData(InvUIGroupingPlan.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(InvUIInventoryGroupAdd.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.62"));  //$NON-NLS-1$
			mit.setData(InvUIInventoryGroupAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		return menuItem;

	}

	
	public static MenuItem createSettingsMenu(MenuItem menuItem) {

		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);

		MenuItem mit;
		MenuItem sps;

		//accounting Menu Items
		if (EngBLPermissions.getPermission(AdmUIUserAdd.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.63"));  //$NON-NLS-1$
			mit.setData(AdmUIUserAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AdmUIGroupAdd.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.64"));  //$NON-NLS-1$
			mit.setData(AdmUIGroupAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions
				.getPermission(AdmUIUserPermissions.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.65"));  //$NON-NLS-1$
			mit.setData(AdmUIUserPermissions.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AdmUIGroupPermissions.class
				.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.66")); //$NON-NLS-1$
			mit.setData(AdmUIGroupPermissions.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AdmUIUsers.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.67"));  //$NON-NLS-1$
			mit.setData(AdmUIUsers.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		if (EngBLPermissions.getPermission(AdmUIGroups.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.68"));  //$NON-NLS-1$
			mit.setData(AdmUIGroups.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		sps = new MenuItem(menuAcc, SWT.SEPARATOR);

		if (EngBLPermissions.getPermission(AdmUICompanyInfo.class.getName()) > 0) {
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(Messages.getString("MenuFactory.69"));  //$NON-NLS-1$
			mit.setData(AdmUICompanyInfo.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}

		return menuItem;
	}
}

class MenuSelectionAdapter extends SelectionAdapter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		super.widgetDefaultSelected(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent arg0) {

		EngUIMainFrame.openNewTab(((MenuItem) arg0.widget).getText(),
				arg0.widget.getData().toString());

	}
}