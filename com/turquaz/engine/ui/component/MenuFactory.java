package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import com.turquaz.accounting.ui.AccUIAccountingPlan;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.accounting.ui.AccUIInitialTransaction;
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
import com.turquaz.bill.ui.BillUIAddReturnBuyBill;
import com.turquaz.bill.ui.BillUIAddReturnSellBill;
import com.turquaz.bill.ui.BillUIAddSellBill;
import com.turquaz.bill.ui.BillUIBillFromConsignment;
import com.turquaz.bill.ui.BillUIBillReport;
import com.turquaz.bill.ui.BillUIBillSearch;
import com.turquaz.cash.ui.CashUICashCardAbstract;
import com.turquaz.cash.ui.CashUICashCardAdd;
import com.turquaz.cash.ui.CashUICashCardDailyAbstract;
import com.turquaz.cash.ui.CashUICashCardSearch;
import com.turquaz.cash.ui.CashUICashCollectTransactionAdd;
import com.turquaz.cash.ui.CashUICashOtherCollectTransaction;
import com.turquaz.cash.ui.CashUICashOtherPaymentTransaction;
import com.turquaz.cash.ui.CashUICashPaymentTransactionAdd;
import com.turquaz.cash.ui.CashUICashTransactionSearch;
import com.turquaz.cash.ui.CashUICashTransferBetweenCards;
import com.turquaz.cash.ui.CashUIInitialTransactions;
import com.turquaz.cheque.ui.CheUIChequeCollect;
import com.turquaz.cheque.ui.CheUIChequeCollectFromBank;
import com.turquaz.cheque.ui.CheUIChequeInPayroll;
import com.turquaz.cheque.ui.CheUIChequeOutPayrollBank;
import com.turquaz.cheque.ui.CheUIChequeOutPayrollCurrent;
import com.turquaz.cheque.ui.CheUIChequeRollSearch;
import com.turquaz.cheque.ui.CheUICustomerChequeSearch;
import com.turquaz.cheque.ui.CheUIOwnChequeCollect;
import com.turquaz.cheque.ui.CheUIOwnChequeSearch;
import com.turquaz.cheque.ui.CheUIReturnFromCurrent;
import com.turquaz.cheque.ui.CheUIReturnFromGivenCheques;
import com.turquaz.consignment.ui.ConUIAddBuyConsignment;
import com.turquaz.consignment.ui.ConUIAddSellConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearch;
import com.turquaz.current.ui.CurUICurCardBalanceReport;
import com.turquaz.current.ui.CurUICurCardCreditList;
import com.turquaz.current.ui.CurUICurCardDeptList;
import com.turquaz.current.ui.CurUICurrentCardAbstract;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardCreditVoucher;
import com.turquaz.current.ui.CurUICurrentCardDeptVoucher;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.current.ui.CurUICurrentTransfer;
import com.turquaz.current.ui.CurUIInitialTransaction;
import com.turquaz.current.ui.CurUIMultipleCreditVoucher;
import com.turquaz.current.ui.CurUIMultipleDeptVoucher;
import com.turquaz.current.ui.CurUITransactionSearch;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.InvUICardSearch;
import com.turquaz.inventory.ui.InvUIGroupingPlan;
import com.turquaz.inventory.ui.InvUIInitialTransacions;
import com.turquaz.inventory.ui.InvUIInventoryCardAbstract;
import com.turquaz.inventory.ui.InvUIInventoryGroupAdd;
import com.turquaz.inventory.ui.InvUIInventoryLedger;
import com.turquaz.inventory.ui.InvUIInventoryTransactionReport;
import com.turquaz.inventory.ui.InvUIOtherTransactionIn;
import com.turquaz.inventory.ui.InvUIOtherTransactionOut;
import com.turquaz.inventory.ui.InvUIProfitAnalysis;
import com.turquaz.inventory.ui.InvUITransactionSearch;
import com.turquaz.inventory.ui.InvUITransactionsTotalReport;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import com.turquaz.inventory.ui.InvUIWarehouseSearch;

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
public class MenuFactory
{

	public static MenuItem createFinanceMenu(MenuItem menuItem)
	{
		Menu menuFinance = new Menu(menuItem);
		menuItem.setMenu(menuFinance);
		MenuItem mit;
		MenuItem sps;
		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(EngLangCommonKeys.STR_MODULE_CURRENT); //$NON-NLS-1$
		Menu currentMenu = new Menu(mit);
		mit.setMenu(currentMenu);
		// current menu items
		if (EngBLPermissions.getPermission(CurUICurrentCardAdd.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_CURRENT_CARD); //$NON-NLS-1$
			mit.setData(CurUICurrentCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(currentMenu, SWT.SEPARATOR);
        
		if (EngBLPermissions.getPermission(CurUICurrentCardDeptVoucher.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_DEPT_VOUCHER); //$NON-NLS-1$
			mit.setData(CurUICurrentCardDeptVoucher.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CurUICurrentCardCreditVoucher.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_CREDIT_VOUCHER); //$NON-NLS-1$
			mit.setData(CurUICurrentCardCreditVoucher.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}	
        if (EngBLPermissions.getPermission(CurUICurrentTransfer.class.getName()) > 0)
        {
            mit = new MenuItem(currentMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CUR_TRANSFER_BETWEEN_ACCS); //$NON-NLS-1$
            mit.setData(CurUICurrentTransfer.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(CurUIMultipleDeptVoucher.class.getName()) > 0)
        {
            mit = new MenuItem(currentMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CUR_MULTIPLE_DEPT_VOUCHER); //$NON-NLS-1$
            mit.setData(CurUIMultipleDeptVoucher.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(CurUIMultipleCreditVoucher.class.getName()) > 0)
        {
            mit = new MenuItem(currentMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CUR_MULTIPLE_CREDIT_VOUCHER); //$NON-NLS-1$
            mit.setData(CurUIMultipleCreditVoucher.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        
		sps = new MenuItem(currentMenu, SWT.SEPARATOR);
        
		if (EngBLPermissions.getPermission(CurUICurrentCardSearch.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CUR_CARD); //$NON-NLS-1$
			mit.setData(CurUICurrentCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CurUITransactionSearch.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CUR_TRANS); //$NON-NLS-1$
			mit.setData(CurUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CurUICurCardDeptList.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_CARD_WITH_DEPT); //$NON-NLS-1$
			mit.setData(CurUICurCardDeptList.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CurUICurCardCreditList.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_CARD_WITH_CREDIT); //$NON-NLS-1$
			mit.setData(CurUICurCardCreditList.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(currentMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CurUICurrentCardAbstract.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_CARD_ABSTRACT); //$NON-NLS-1$
			mit.setData(CurUICurrentCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CurUICurCardBalanceReport.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_CARD_BALANCE); //$NON-NLS-1$
			mit.setData(CurUICurCardBalanceReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(currentMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CurUIInitialTransaction.class.getName()) > 0)
		{
			mit = new MenuItem(currentMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CUR_INITIAL_VALUES); //$NON-NLS-1$
			mit.setData(CurUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		
        mit = new MenuItem(menuFinance, SWT.CASCADE);
		
        mit.setText(EngLangCommonKeys.STR_MODULE_CHEQUE); //$NON-NLS-1$
		Menu chequeMenu = new Menu(mit);
		mit.setMenu(chequeMenu);
		//	cheque menu items
		if (EngBLPermissions.getPermission(CheUIChequeInPayroll.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_ROLL_IN); //$NON-NLS-1$
			mit.setData(CheUIChequeInPayroll.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUIChequeOutPayrollCurrent.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_ROLL_OUT_TO_CURRENT); //$NON-NLS-1$
			mit.setData(CheUIChequeOutPayrollCurrent.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUIChequeOutPayrollBank.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_ROLL_OUT_TO_BANK); //$NON-NLS-1$
			mit.setData(CheUIChequeOutPayrollBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUIChequeCollectFromBank.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_COLLECT_FROM_BANK); //$NON-NLS-1$
			mit.setData(CheUIChequeCollectFromBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
        if (EngBLPermissions.getPermission(CheUIReturnFromCurrent.class.getName()) > 0)
        {
            mit = new MenuItem(chequeMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CHEQUE_RETURN_FROM_CURRENT); //$NON-NLS-1$
            mit.setData(CheUIReturnFromCurrent.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(CheUIReturnFromGivenCheques.class.getName()) > 0)
        {
            mit = new MenuItem(chequeMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CHEQUE_RETURN_FROM_CURRENT); //$NON-NLS-1$
            mit.setData(CheUIReturnFromGivenCheques.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
		if (EngBLPermissions.getPermission(CheUIChequeCollect.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_COLLECT_FROM_CURRENT); //$NON-NLS-1$
			mit.setData(CheUIChequeCollect.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUIOwnChequeCollect.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CHEQUE_COLLECT_OF_OWN_CHEQUE);  //$NON-NLS-1$
			mit.setData(CheUIOwnChequeCollect.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(chequeMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CheUIChequeRollSearch.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CHEQUE_ROLL); //$NON-NLS-1$
			mit.setData(CheUIChequeRollSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUICustomerChequeSearch.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CUSTOMER_CHEQUE); //$NON-NLS-1$
			mit.setData(CheUICustomerChequeSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CheUIOwnChequeSearch.class.getName()) > 0)
		{
			mit = new MenuItem(chequeMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_OWN_CHEQUE); //$NON-NLS-1$
			mit.setData(CheUIOwnChequeSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(EngLangCommonKeys.STR_MODULE_BANK); //$NON-NLS-1$
		Menu bankMenu = new Menu(mit);
		mit.setMenu(bankMenu);
		//	bank menu items
		if (EngBLPermissions.getPermission(BankUIBankCardAdd.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_BANK_CARD); //$NON-NLS-1$
			mit.setData(BankUIBankCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(bankMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BankUIMoneyTransferIn.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_TRANSFER_IN); //$NON-NLS-1$
			mit.setData(BankUIMoneyTransferIn.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUIMoneyTransferOut.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_TRANSFER_OUT); //$NON-NLS-1$
			mit.setData(BankUIMoneyTransferOut.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUICashFromBank.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_FROM_BANK); //$NON-NLS-1$
			mit.setData(BankUICashFromBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUICashToBank.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_TO_BANK); //$NON-NLS-1$
			mit.setData(BankUICashToBank.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUIOtherTransIn.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_OTHER_TRANSFER_DEPT); //$NON-NLS-1$
			mit.setData(BankUIOtherTransIn.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUIOtherTransOut.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_OTHER_TRANSFER_CREDIT); //$NON-NLS-1$
			mit.setData(BankUIOtherTransOut.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUITransferBetweenAccounts.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_TRANSFER_BETWEEN_ACCOUNTS); //$NON-NLS-1$
			mit.setData(BankUITransferBetweenAccounts.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(bankMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BankUIBankCardSearch.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_BANK_CARD); //$NON-NLS-1$
			mit.setData(BankUIBankCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BankUISearchMoneyTransaction.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_BANK_TRANS); //$NON-NLS-1$
			mit.setData(BankUISearchMoneyTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(bankMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BankUIBankCardAbstract.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_BANK_CARD_ABSTRACT); //$NON-NLS-1$
			mit.setData(BankUIBankCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(bankMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BankUIInitialTransaction.class.getName()) > 0)
		{
			mit = new MenuItem(bankMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_BANK_INITIAL_TRANSACTIONS); //$NON-NLS-1$
			mit.setData(BankUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		mit = new MenuItem(menuFinance, SWT.CASCADE);
		mit.setText(EngLangCommonKeys.STR_MODULE_CASH); //$NON-NLS-1$
		Menu cashMenu = new Menu(mit);
		mit.setMenu(cashMenu);
		if (EngBLPermissions.getPermission(CashUICashCardAdd.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_CASH_CARD); //$NON-NLS-1$
			mit.setData(CashUICashCardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(cashMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CashUICashCollectTransactionAdd.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_COLLECT_FROM_CURRENT); //$NON-NLS-1$
			mit.setData(CashUICashCollectTransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CashUICashPaymentTransactionAdd.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_PAYMENT_TO_CURRENT); //$NON-NLS-1$
			mit.setData(CashUICashPaymentTransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
        if (EngBLPermissions.getPermission(CashUICashOtherCollectTransaction.class.getName()) > 0)
        {
            mit = new MenuItem(cashMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_OTHER_COLLECT); //$NON-NLS-1$
            mit.setData(CashUICashOtherCollectTransaction.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(CashUICashOtherPaymentTransaction.class.getName()) > 0)
        {
            mit = new MenuItem(cashMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_OTHER_PAYMENT); //$NON-NLS-1$
            mit.setData(CashUICashOtherPaymentTransaction.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(CashUICashTransferBetweenCards.class.getName()) > 0)
        {
            mit = new MenuItem(cashMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_CASH_TRANSFER_BETWEEN_ACCOUNTS); //$NON-NLS-1$
            mit.setData(CashUICashTransferBetweenCards.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
		if (EngBLPermissions.getPermission(CashUIInitialTransactions.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_INITIAL_VALUES);  //$NON-NLS-1$
			mit.setData(CashUIInitialTransactions.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(cashMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CashUICashCardSearch.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CASH_CARD); //$NON-NLS-1$
			mit.setData(CashUICashCardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CashUICashTransactionSearch.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CASH_TRANS); //$NON-NLS-1$
			mit.setData(CashUICashTransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(cashMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(CashUICashCardAbstract.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CASH_CARD_ABSTRACT); //$NON-NLS-1$
			mit.setData(CashUICashCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(CashUICashCardDailyAbstract.class.getName()) > 0)
		{
			mit = new MenuItem(cashMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_DAILY_CASH_CARD_ABSTRACT); //$NON-NLS-1$
			mit.setData(CashUICashCardDailyAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		return menuItem;
	}

	public static MenuItem createAccountingMenu(MenuItem menuItem)
	{
		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);
		MenuItem mit;
		MenuItem sps;
		//accounting Menu Items
		if (EngBLPermissions.getPermission(AccUIAccountingPlan.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACCOUNTING_PLAN); //$NON-NLS-1$
			mit.setData(AccUIAccountingPlan.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUIAddAccounts.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_NEW_ACCOUNT); //$NON-NLS-1$
			mit.setData(AccUIAddAccounts.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AccUITransactionAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_GENERAL_VOUCHER); //$NON-NLS-1$
			mit.setData(AccUITransactionAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUITransactionCollect.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_COLLECT_VOUCHER); //$NON-NLS-1$
			mit.setData(AccUITransactionCollect.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUITransactionPayment.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_PAYMENT_VOUCHER); //$NON-NLS-1$
			mit.setData(AccUITransactionPayment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AccUITransactionSearch.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_ACC_VOUCHER); //$NON-NLS-1$
			mit.setData(AccUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AccUIAccountingJournal.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACC_JOURNAL); //$NON-NLS-1$
			mit.setData(AccUIAccountingJournal.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUISubsidiaryLedger.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACC_SUBSIDIARY_LEDGER); //$NON-NLS-1$
			mit.setData(AccUISubsidiaryLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUIAccountingGeneralLedger.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACC_GENERAL_LEDGER); //$NON-NLS-1$
			mit.setData(AccUIAccountingGeneralLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AccUIAccountingAdvancedBalance.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACC_BALANCE); //$NON-NLS-1$
			mit.setData(AccUIAccountingAdvancedBalance.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AccUIAccountingMonthlyBalance.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ACC_MONTHLY_BALANCE); //$NON-NLS-1$
			mit.setData(AccUIAccountingMonthlyBalance.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AccUIInitialTransaction.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INITIAL_VOUCHER); //$NON-NLS-1$
			mit.setData(AccUIInitialTransaction.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		/*
		 * if (EngBLPermissions.getPermission(AccUIInitialTransaction.class .getName()) > 0) { mit = new MenuItem(menuAcc, SWT.PUSH);
		 * mit.setText(Messages.getString("MenuFactory.41")); //$NON-NLS-1$ mit.setData(AccUISaveJournal.class.getName());
		 * mit.addSelectionListener(new MenuSelectionAdapter()); }
		 */
		return menuItem;
	}

	public static MenuItem createSalesMenu(MenuItem menuItem)
	{
		Menu menuSales = new Menu(menuItem);
		menuItem.setMenu(menuSales);
		MenuItem mit;
		MenuItem sps;
		mit = new MenuItem(menuSales, SWT.CASCADE);
		mit.setText(EngLangCommonKeys.STR_MODULE_BILL); //$NON-NLS-1$
		Menu invoiceMenu = new Menu(mit);
		mit.setMenu(invoiceMenu);
		//Invoice Menu Items
		if (EngBLPermissions.getPermission(BillUIAddBuyBill.class.getName()) > 0)
		{
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_BUY_BILL); //$NON-NLS-1$
			mit.setData(BillUIAddBuyBill.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(BillUIAddSellBill.class.getName()) > 0)
		{
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_SELL_BILL); //$NON-NLS-1$
			mit.setData(BillUIAddSellBill.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
        if (EngBLPermissions.getPermission(BillUIAddReturnSellBill.class.getName()) > 0)
        {
            mit = new MenuItem(invoiceMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_ADD_RETURN_SELL_BILL); //$NON-NLS-1$
            mit.setData(BillUIAddReturnSellBill.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(BillUIAddReturnBuyBill.class.getName()) > 0)
        {
            mit = new MenuItem(invoiceMenu, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_ADD_RETURN_BUY_BILL); //$NON-NLS-1$
            mit.setData(BillUIAddReturnBuyBill.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
		if (EngBLPermissions.getPermission(BillUIBillFromConsignment.class.getName()) > 0)
		{
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_BILL_FROM_CONSIGNMENT); //$NON-NLS-1$
			mit.setData(BillUIBillFromConsignment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(invoiceMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BillUIBillSearch.class.getName()) > 0)
		{
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_BILL); //$NON-NLS-1$
			mit.setData(BillUIBillSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(invoiceMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(BillUIBillReport.class.getName()) > 0)
		{
			mit = new MenuItem(invoiceMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_BILL_REPORT); //$NON-NLS-1$
			mit.setData(BillUIBillReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		mit = new MenuItem(menuSales, SWT.CASCADE);
		mit.setText(EngLangCommonKeys.STR_MODULE_CONSIGNMENT); //$NON-NLS-1$
		Menu despatchMenu = new Menu(mit);
		mit.setMenu(despatchMenu);
		if (EngBLPermissions.getPermission(ConUIAddBuyConsignment.class.getName()) > 0)
		{
			mit = new MenuItem(despatchMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_BUY_CONSIGNMENT);  //$NON-NLS-1$
			mit.setData(ConUIAddBuyConsignment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(ConUIAddSellConsignment.class.getName()) > 0)
		{
			mit = new MenuItem(despatchMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_SELL_CONSIGNMENT);  //$NON-NLS-1$
			mit.setData(ConUIAddSellConsignment.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(despatchMenu, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(ConUIConsignmentSearch.class.getName()) > 0)
		{
			mit = new MenuItem(despatchMenu, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_CONSIGNMENT); //$NON-NLS-1$
			mit.setData(ConUIConsignmentSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		return menuItem;
	}

	public static MenuItem createInventoryMenu(MenuItem menuItem)
	{
		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);
		MenuItem mit;
		MenuItem sps;
		//Inventory Menu Items
		if (EngBLPermissions.getPermission(InvUICardAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_INV_CARD); //$NON-NLS-1$
			mit.setData(InvUICardAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIWarehouseAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_WAREHOUSE); //$NON-NLS-1$
			mit.setData(InvUIWarehouseAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
        sps = new MenuItem(menuAcc, SWT.SEPARATOR);
        
        if (EngBLPermissions.getPermission(InvUIOtherTransactionIn.class.getName()) > 0)
        {
            mit = new MenuItem(menuAcc, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_INV_OTHER_TRANS_IN); //$NON-NLS-1$
            mit.setData(InvUIOtherTransactionIn.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(InvUIOtherTransactionOut.class.getName()) > 0)
        {
            mit = new MenuItem(menuAcc, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_INV_OTHER_TRANS_OUT); //$NON-NLS-1$
            mit.setData(InvUIOtherTransactionOut.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
        if (EngBLPermissions.getPermission(InvUIInitialTransacions.class.getName()) > 0)
        {
            mit = new MenuItem(menuAcc, SWT.PUSH);
            mit.setText(EngLangCommonKeys.STR_INITIAL_TRANSACTION); //$NON-NLS-1$
            mit.setData(InvUIInitialTransacions.class.getName());
            mit.addSelectionListener(new MenuSelectionAdapter());
        }
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(InvUICardSearch.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_INV_CARD); //$NON-NLS-1$
			mit.setData(InvUICardSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUITransactionSearch.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_INV_TRANS); //$NON-NLS-1$
			mit.setData(InvUITransactionSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIWarehouseSearch.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_SEARCH_WAREHOUSE); //$NON-NLS-1$
			mit.setData(InvUIWarehouseSearch.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(InvUIProfitAnalysis.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_PROFIT_ANALYSIS); //$NON-NLS-1$
			mit.setData(InvUIProfitAnalysis.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIInventoryLedger.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_LEDGER); //$NON-NLS-1$
			mit.setData(InvUIInventoryLedger.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIInventoryTransactionReport.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_TRANSACTIONS_REPORT); //$NON-NLS-1$
			mit.setData(InvUIInventoryTransactionReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUITransactionsTotalReport.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_TRANSACTION_TOTALS); //$NON-NLS-1$
			mit.setData(InvUITransactionsTotalReport.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIInventoryCardAbstract.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_CARD_ABSTRACT); //$NON-NLS-1$
			mit.setData(InvUIInventoryCardAbstract.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(InvUIGroupingPlan.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_GROUPS); //$NON-NLS-1$
			mit.setData(InvUIGroupingPlan.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(InvUIInventoryGroupAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_INV_GROUP_ADD); //$NON-NLS-1$
			mit.setData(InvUIInventoryGroupAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		return menuItem;
	}

	public static MenuItem createSettingsMenu(MenuItem menuItem)
	{
		Menu menuAcc = new Menu(menuItem);
		menuItem.setMenu(menuAcc);
		MenuItem mit;
		MenuItem sps;
		//accounting Menu Items
		if (EngBLPermissions.getPermission(AdmUIUserAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_USER); //$NON-NLS-1$
			mit.setData(AdmUIUserAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AdmUIGroupAdd.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_ADD_GROUP); //$NON-NLS-1$
			mit.setData(AdmUIGroupAdd.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AdmUIUserPermissions.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_USER_PERMISSIONS); //$NON-NLS-1$
			mit.setData(AdmUIUserPermissions.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AdmUIGroupPermissions.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_GROUP_PERMISSIONS); //$NON-NLS-1$
			mit.setData(AdmUIGroupPermissions.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AdmUIUsers.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_USERS); //$NON-NLS-1$
			mit.setData(AdmUIUsers.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		if (EngBLPermissions.getPermission(AdmUIGroups.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_GROUPS); //$NON-NLS-1$
			mit.setData(AdmUIGroups.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		if (EngBLPermissions.getPermission(AdmUICompanyInfo.class.getName()) > 0)
		{
			mit = new MenuItem(menuAcc, SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_COMPANY_INFO); //$NON-NLS-1$
			mit.setData(AdmUICompanyInfo.class.getName());
			mit.addSelectionListener(new MenuSelectionAdapter());
		}
		return menuItem;
	}
	
	public static void addTabFolderMenu(final CTabFolder tabfld){
		
		Menu menu = new Menu(tabfld.getShell(),SWT.POP_UP);
		
		MenuItem mit = new MenuItem(menu,SWT.PUSH);
		mit.setText(EngLangCommonKeys.STR_CLOSE); //$NON-NLS-1$
		mit.addSelectionListener(new SelectionAdapter(){
			
			public void widgetSelected(SelectionEvent arg0)
			{
				CTabItem item =tabfld.getSelection();
			    if(item != null)
			    {
			    	EngUIMainFrame.tabfldMainItemClosed(item);
			    	item.dispose();
			    	
			    }
				EngUIMainFrame.arrangeIcons();
			    
			
			}
			
			});
		
		
		 mit = new MenuItem(menu,SWT.PUSH);
		mit.setText(EngLangCommonKeys.STR_CLOSE_ALL); //$NON-NLS-1$
		mit.addSelectionListener(new SelectionAdapter(){
			
			public void widgetSelected(SelectionEvent arg0)
			{
				CTabItem items[] =tabfld.getItems();
			    for(int i=0;i<items.length;i++)
			    {
			    	EngUIMainFrame.tabfldMainItemClosed(items[i]);
			    	items[i].dispose();
			    	
			    }
			    EngUIMainFrame.arrangeIcons();
			
			}
			
			});
		
		 mit = new MenuItem(menu,SWT.PUSH);
			mit.setText(EngLangCommonKeys.STR_CLOSE_OTHERS); //$NON-NLS-1$
			mit.addSelectionListener(new SelectionAdapter(){
				
				public void widgetSelected(SelectionEvent arg0)
				{
					int index = tabfld.getSelectionIndex();
					CTabItem items[] =tabfld.getItems();
				    for(int i=0;i<items.length;i++)
				    {
				    	if(i!=index)
				    	{
				    	EngUIMainFrame.tabfldMainItemClosed(items[i]);
				    	items[i].dispose();
				    	}
				    	
				    }
				    EngUIMainFrame.arrangeIcons();
				
				}
				
				});
			
		tabfld.setMenu(menu);
		
		
	}
}

class MenuSelectionAdapter extends SelectionAdapter
{
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent arg0)
	{
		super.widgetDefaultSelected(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent arg0)
	{
		EngUIMainFrame.openNewTab(((MenuItem) arg0.widget).getText(), arg0.widget.getData().toString());
	}
}