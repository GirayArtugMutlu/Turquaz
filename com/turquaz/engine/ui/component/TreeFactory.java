
package com.turquaz.engine.ui.component;

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
* @author  Onsel Armagan
* @version  $Id$
*/
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

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
import com.turquaz.admin.ui.AdmUICurrencyAdd;
import com.turquaz.admin.ui.AdmUICurrencyExchangeRateAdd;
import com.turquaz.admin.ui.AdmUICurrencyExchangeRateSearch;
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
import com.turquaz.cash.ui.CashUICashOtherCollectTransaction;
import com.turquaz.cash.ui.CashUICashOtherPaymentTransaction;
import com.turquaz.cash.ui.CashUICashPaymentTransactionAdd;
import com.turquaz.cash.ui.CashUICashTransactionSearch;
import com.turquaz.cash.ui.CashUICashTransferBetweenCards;
import com.turquaz.cheque.ui.CheUIChequeCollect;
import com.turquaz.cheque.ui.CheUIChequeCollectFromBank;
import com.turquaz.cheque.ui.CheUIChequeInPayroll;
import com.turquaz.cheque.ui.CheUIChequeOutPayrollBank;
import com.turquaz.cheque.ui.CheUIChequeOutPayrollCurrent;
import com.turquaz.cheque.ui.CheUIChequeRollSearch;
import com.turquaz.cheque.ui.CheUICustomerChequeSearch;
import com.turquaz.cheque.ui.CheUIOwnChequeSearch;
import com.turquaz.consignment.ui.ConUIAddConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearch;
import com.turquaz.current.ui.CurUICurrentCardAbstract;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.current.ui.CurUICurrentCardVoucher;
import com.turquaz.current.ui.CurUIInitialTransaction;
import com.turquaz.current.ui.CurUITransactionSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLPermissions;
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

public final class TreeFactory {
	
	
	public static Tree createInventoryTree(Tree tree){
		
		TreeItem cardsRoot = new TreeItem(tree,SWT.NULL);
		
		cardsRoot.setText(Messages.getString("TreeFactory.0"));   //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(InvUICardAdd.class.getName())>0){
	    item = new TreeItem(cardsRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.1"));  //$NON-NLS-1$
		item.setData(InvUICardAdd.class.getName());
		
		}

		if(EngBLPermissions.getPermission(InvUIWarehouseAdd.class.getName())>0){
		item = new TreeItem(cardsRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.4"));  //$NON-NLS-1$
		item.setData(InvUIWarehouseAdd.class.getName());
		}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.6"));   //$NON-NLS-1$
			
		if(EngBLPermissions.getPermission(InvUICardSearch.class.getName())>0){
		item = new TreeItem(searchRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.3"));  //$NON-NLS-1$
		item.setData(InvUICardSearch.class.getName());
		}
			
		if(EngBLPermissions.getPermission(InvUITransactionSearch.class.getName())>0){
		item = new TreeItem(searchRoot,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.35"));  //$NON-NLS-1$
		item.setData(InvUITransactionSearch.class.getName());
		}
		
		if(EngBLPermissions.getPermission(InvUIWarehouseSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.5"));  //$NON-NLS-1$
			item.setData(InvUIWarehouseSearch.class.getName());
			}
		
		TreeItem reports = new TreeItem(tree,SWT.NULL);
		reports.setText(Messages.getString("TreeFactory.67")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(InvUIProfitAnalysis.class.getName())>0){
			item = new TreeItem(reports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.44"));  //$NON-NLS-1$
			item.setData(InvUIProfitAnalysis.class.getName());
			}
		
		if(EngBLPermissions.getPermission(InvUIInventoryLedger.class.getName())>0){
			item = new TreeItem(reports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.19"));  //$NON-NLS-1$
			item.setData(InvUIInventoryLedger.class.getName());
			}
		
		if(EngBLPermissions.getPermission(InvUIInventoryTransactionReport.class.getName())>0){
			item = new TreeItem(reports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.73")); //$NON-NLS-1$
			item.setData(InvUIInventoryTransactionReport.class.getName());
			}
		
		if(EngBLPermissions.getPermission(InvUITransactionsTotalReport.class.getName())>0){
			item = new TreeItem(reports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.75")); //$NON-NLS-1$
			item.setData(InvUITransactionsTotalReport.class.getName());
			}
		
		if(EngBLPermissions.getPermission(InvUIInventoryCardAbstract.class.getName())>0){
			item = new TreeItem(reports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.97")); //$NON-NLS-1$
			item.setData(InvUIInventoryCardAbstract.class.getName());
			}
		
		TreeItem adminRoot = new TreeItem(tree,SWT.NULL);
		adminRoot.setText(Messages.getString("TreeFactory.9"));   //$NON-NLS-1$
		
		
		if(EngBLPermissions.getPermission(InvUIGroupingPlan.class.getName())>0){
			item = new TreeItem(adminRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.98"));  //$NON-NLS-1$
			item.setData(InvUIGroupingPlan.class.getName());
			}
		if(EngBLPermissions.getPermission(InvUIInventoryGroupAdd.class.getName())>0){
			item = new TreeItem(adminRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.99"));   //$NON-NLS-1$
			item.setData(InvUIInventoryGroupAdd.class.getName());
			}
		
		adminRoot.setExpanded(true);
		reports.setExpanded(true);
		cardsRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		return tree;
	}
	
	public static Tree createBankTree(Tree tree){
		
		TreeItem accountsRoot = new TreeItem(tree,SWT.NULL);
		accountsRoot.setText(Messages.getString("TreeFactory.16"));  //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(BankUIBankCardAdd.class.getName())>0){
		item = new TreeItem(accountsRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.7")); //$NON-NLS-1$
		item.setData(BankUIBankCardAdd.class.getName());
		}
		
		TreeItem transactionsRoot = new TreeItem(tree,SWT.NULL);
		transactionsRoot.setText(Messages.getString("TreeFactory.21"));  //$NON-NLS-1$
		
		
		if(EngBLPermissions.getPermission(BankUIMoneyTransferIn.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.62")); //$NON-NLS-1$
			item.setData(BankUIMoneyTransferIn.class.getName());
		}
		
		if(EngBLPermissions.getPermission(BankUIMoneyTransferOut.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.63")); //$NON-NLS-1$
			item.setData(BankUIMoneyTransferOut.class.getName());
		}
		
		if(EngBLPermissions.getPermission(BankUICashFromBank.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.68"));  //$NON-NLS-1$
			item.setData(BankUICashFromBank.class.getName());
		}
		if(EngBLPermissions.getPermission(BankUICashToBank.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.69"));  //$NON-NLS-1$
			item.setData(BankUICashToBank.class.getName());
		}
		if(EngBLPermissions.getPermission(BankUIOtherTransIn.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.71"));  //$NON-NLS-1$
			item.setData(BankUIOtherTransIn.class.getName());
		}
		if(EngBLPermissions.getPermission(BankUIOtherTransOut.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.72"));  //$NON-NLS-1$
			item.setData(BankUIOtherTransOut.class.getName());
		}
		if(EngBLPermissions.getPermission(BankUITransferBetweenAccounts.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.76"));   //$NON-NLS-1$
			item.setData(BankUITransferBetweenAccounts.class.getName());
		}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.32"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(BankUIBankCardSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.8")); //$NON-NLS-1$
			item.setData(BankUIBankCardSearch.class.getName());
			}
		
		if(EngBLPermissions.getPermission(BankUISearchMoneyTransaction.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.60")); //$NON-NLS-1$
			item.setData(BankUISearchMoneyTransaction.class.getName());
		}
		
		TreeItem reportsRoot = new TreeItem(tree,SWT.NULL);
		reportsRoot.setText(Messages.getString("TreeFactory.36"));  //$NON-NLS-1$
		
			if(EngBLPermissions.getPermission(BankUIBankCardAbstract.class.getName())>0){
				item = new TreeItem(reportsRoot,SWT.NULL);
				item.setText(Messages.getString("TreeFactory.64"));  //$NON-NLS-1$
				item.setData(BankUIBankCardAbstract.class.getName());
			}
		
			TreeItem confRoot = new TreeItem(tree,SWT.NULL);
			confRoot.setText(Messages.getString("TreeFactory.39"));  //$NON-NLS-1$
			
			if(EngBLPermissions.getPermission(BankUIInitialTransaction.class.getName())>0){
				item = new TreeItem(confRoot,SWT.NULL);
				item.setText(Messages.getString("TreeFactory.74"));   //$NON-NLS-1$
				item.setData(BankUIInitialTransaction.class.getName());
			}
		
		accountsRoot.setExpanded(true);
		transactionsRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		reportsRoot.setExpanded(true);
		confRoot.setExpanded(true);
		
		return tree;
	}
	
	public static Tree createAccountingTree(Tree tree){
		
		TreeItem accountsRoot = new TreeItem(tree,SWT.NULL);
		accountsRoot.setText(Messages.getString("TreeFactory.45"));  //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(AccUIAccountingPlan.class.getName())>0){
			item = new TreeItem(accountsRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.11")); //$NON-NLS-1$
			item.setData(AccUIAccountingPlan.class.getName());
			}
		if(EngBLPermissions.getPermission(AccUIAddAccounts.class.getName())>0){
		item = new TreeItem(accountsRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.10")); //$NON-NLS-1$
		item.setData(AccUIAddAccounts.class.getName());
		}
		
		TreeItem voucherRoot = new TreeItem(tree,SWT.NULL);
		voucherRoot.setText(Messages.getString("TreeFactory.50"));  //$NON-NLS-1$
		
		
		if(EngBLPermissions.getPermission(AccUITransactionAdd.class.getName())>0){
		item = new TreeItem(voucherRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.12")); //$NON-NLS-1$
		item.setData(AccUITransactionAdd.class.getName());	
		}
		if(EngBLPermissions.getPermission(AccUITransactionCollect.class.getName())>0){
		item = new TreeItem(voucherRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.13")); //$NON-NLS-1$
		item.setData(AccUITransactionCollect.class.getName());	
		}
		
		if(EngBLPermissions.getPermission(AccUITransactionPayment.class.getName())>0){
		item = new TreeItem(voucherRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.14")); //$NON-NLS-1$
		item.setData(AccUITransactionPayment.class.getName());	
		}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.52")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUITransactionSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.15")); //$NON-NLS-1$
			item.setData(AccUITransactionSearch.class.getName());
			}
		
		TreeItem booksRoot = new TreeItem(tree,SWT.NULL);
		booksRoot.setText(Messages.getString("TreeFactory.61")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUIAccountingJournal.class.getName())>0){
			item = new TreeItem(booksRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.28")); //$NON-NLS-1$
			item.setData(AccUIAccountingJournal.class.getName());
			}
			if(EngBLPermissions.getPermission(AccUISubsidiaryLedger.class.getName())>0){
				item = new TreeItem(booksRoot,SWT.NULL);
				item.setText(Messages.getString("TreeFactory.43"));  //$NON-NLS-1$
				item.setData(AccUISubsidiaryLedger.class.getName());
				}
			
			if(EngBLPermissions.getPermission(AccUIAccountingGeneralLedger.class.getName())>0){
			item = new TreeItem(booksRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.33")); //$NON-NLS-1$
			item.setData(AccUIAccountingGeneralLedger.class.getName());
			}
			
		TreeItem reportsRoot = new TreeItem(tree,SWT.NULL);
		reportsRoot.setText(Messages.getString("TreeFactory.79")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUIAccountingAdvancedBalance.class.getName())>0){
			item = new TreeItem(reportsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.29")); //$NON-NLS-1$
			item.setData(AccUIAccountingAdvancedBalance.class.getName());
		}
		if(EngBLPermissions.getPermission(AccUIAccountingMonthlyBalance.class.getName())>0){
			item = new TreeItem(reportsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.70"));  //$NON-NLS-1$
			item.setData(AccUIAccountingMonthlyBalance.class.getName());
		}
		
		TreeItem settingsRoot = new TreeItem(tree,SWT.NULL);
		settingsRoot.setText(Messages.getString("TreeFactory.80")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUIInitialTransaction.class.getName())>0){
			item = new TreeItem(settingsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.40"));  //$NON-NLS-1$
			item.setData(AccUIInitialTransaction.class.getName());
		}
	/*	if(EngBLPermissions.getPermission(AccUITransactionSearch.class.getName())>0){
			item = new TreeItem(settingsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.41")); //$NON-NLS-1$
			item.setData(AccUISaveJournal.class.getName());
		}
	*/	
		accountsRoot.setExpanded(true);
		voucherRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		booksRoot.setExpanded(true);
		reportsRoot.setExpanded(true);
		settingsRoot.setExpanded(true);
		
		return tree;
	}
	public static Tree createCurrentTree(Tree tree){
		
		TreeItem accountsRoot = new TreeItem(tree,SWT.NULL);
		accountsRoot.setText(Messages.getString("TreeFactory.81"));  //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(CurUICurrentCardAdd.class.getName())>0){
		item = new TreeItem(accountsRoot,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.17")); //$NON-NLS-1$
		item.setData(CurUICurrentCardAdd.class.getName());
		}
		
		TreeItem transactionsRoot = new TreeItem(tree,SWT.NULL);
		transactionsRoot.setText(Messages.getString("TreeFactory.82"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(CurUICurrentCardVoucher.class.getName())>0){
			item = new TreeItem(transactionsRoot,SWT.NULL);			
			item.setText(Messages.getString("TreeFactory.58")); //$NON-NLS-1$
			item.setData(CurUICurrentCardVoucher.class.getName());		
		}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.83"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(CurUICurrentCardSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.18")); //$NON-NLS-1$
			item.setData(CurUICurrentCardSearch.class.getName());
			}
		
		if(EngBLPermissions.getPermission(CurUITransactionSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(com.turquaz.engine.Messages.getString("TreeFactory.20")); //$NON-NLS-1$
			item.setData(CurUITransactionSearch.class.getName());
			}
		
		TreeItem reportsRoot = new TreeItem(tree,SWT.NULL);
		reportsRoot.setText(Messages.getString("TreeFactory.84"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(CurUICurrentCardAbstract.class.getName())>0){
			item = new TreeItem(reportsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.48")); //$NON-NLS-1$
			item.setData(CurUICurrentCardAbstract.class.getName());
		}

		TreeItem settingsRoot = new TreeItem(tree,SWT.NULL);
		settingsRoot.setText(Messages.getString("TreeFactory.85"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(CurUIInitialTransaction.class.getName())>0){
			item = new TreeItem(settingsRoot,SWT.NULL);			
			item.setText(Messages.getString("TreeFactory.55"));  //$NON-NLS-1$			
			item.setData(CurUIInitialTransaction.class.getName());		
		}
		

		accountsRoot.setExpanded(true);
		transactionsRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		reportsRoot.setExpanded(true);
		settingsRoot.setExpanded(true);
		
		return tree;
	}
	public static Tree createAdminTree(Tree tree){
		
		
		TreeItem usersRoot = new TreeItem(tree,SWT.NULL);
		usersRoot.setText(Messages.getString("TreeFactory.86"));  //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(AdmUIUserAdd.class.getName())>0){
		item = new TreeItem(usersRoot,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.23")); //$NON-NLS-1$
		item.setData(AdmUIUserAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIGroupAdd.class.getName())>0){
		item = new TreeItem(usersRoot,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.25")); //$NON-NLS-1$
		item.setData(AdmUIGroupAdd.class.getName());
		}
		
		TreeItem permissionsRoot = new TreeItem(tree,SWT.NULL);
		permissionsRoot.setText(Messages.getString("TreeFactory.87"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AdmUIUserPermissions.class.getName())>0){
			item = new TreeItem(permissionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.27")); //$NON-NLS-1$
			item.setData(AdmUIUserPermissions.class.getName());
			}
		
		if(EngBLPermissions.getPermission(AdmUIGroupPermissions.class.getName())>0){
			item = new TreeItem(permissionsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.22")); //$NON-NLS-1$
			item.setData(AdmUIGroupPermissions.class.getName());
			}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.88")); //$NON-NLS-1$
		

		if(EngBLPermissions.getPermission(AdmUIUsers.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.24")); //$NON-NLS-1$
			item.setData(AdmUIUsers.class.getName());
			}
		
		if(EngBLPermissions.getPermission(AdmUIGroups.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.26")); //$NON-NLS-1$
			item.setData(AdmUIGroups.class.getName());
			}
		
		TreeItem settingsRoot = new TreeItem(tree,SWT.NULL);
		settingsRoot.setText(Messages.getString("TreeFactory.89")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AdmUICompanyInfo.class.getName())>0){
			item = new TreeItem(settingsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.54"));  //$NON-NLS-1$
			item.setData(AdmUICompanyInfo.class.getName());
			}
		
		TreeItem currencyRoot= new TreeItem(tree,SWT.NULL);
		currencyRoot.setText(Messages.getString("TreeFactory.41")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AdmUICurrencyAdd.class.getName())>0){
			item = new TreeItem(currencyRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.108")); //$NON-NLS-1$
			item.setData(AdmUICurrencyAdd.class.getName());
			}
		
		if(EngBLPermissions.getPermission(AdmUICurrencyExchangeRateAdd.class.getName())>0){
			item = new TreeItem(currencyRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.109")); //$NON-NLS-1$
			item.setData(AdmUICurrencyExchangeRateAdd.class.getName());
			}
		
		if(EngBLPermissions.getPermission(AdmUICurrencyExchangeRateSearch.class.getName())>0){
			item = new TreeItem(currencyRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.110")); //$NON-NLS-1$
			item.setData(AdmUICurrencyExchangeRateSearch.class.getName());
			}
		
		usersRoot.setExpanded(true);
		permissionsRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		settingsRoot.setExpanded(true);
		currencyRoot.setExpanded(true);
		
		return tree;
	}
	public static Tree createConsignmetTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(Messages.getString("TreeFactory.31")); //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(ConUIAddConsignment.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.30")); //$NON-NLS-1$
		item.setData(ConUIAddConsignment.class.getName());
		}
		if(EngBLPermissions.getPermission(ConUIConsignmentSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.34")); //$NON-NLS-1$
		item.setData(ConUIConsignmentSearch.class.getName());
		}
		root.setExpanded(true);
		return tree;
		
	}
	public static Tree createBillTree(Tree tree){
		
		TreeItem invoiceRoot = new TreeItem(tree,SWT.NULL);
		invoiceRoot.setText(Messages.getString("TreeFactory.90")); //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(BillUIAddBuyBill.class.getName())>0){
			item = new TreeItem(invoiceRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.38")); //$NON-NLS-1$
			item.setData(BillUIAddBuyBill.class.getName());
			}
		if(EngBLPermissions.getPermission(BillUIAddSellBill.class.getName())>0){
			item = new TreeItem(invoiceRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.42"));  //$NON-NLS-1$
			item.setData(BillUIAddSellBill.class.getName());
			}
		if(EngBLPermissions.getPermission(BillUIBillFromConsignment.class.getName())>0){
		item = new TreeItem(invoiceRoot,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.37")); //$NON-NLS-1$
		item.setData(BillUIBillFromConsignment.class.getName());
		}
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		searchRoot.setText(Messages.getString("TreeFactory.91")); //$NON-NLS-1$
		
	    if(EngBLPermissions.getPermission(BillUIBillSearch.class.getName())>0){
		item = new TreeItem(searchRoot,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.2")); //$NON-NLS-1$
		item.setData(BillUIBillSearch.class.getName());
	    }

		TreeItem reportsRoot=new TreeItem(tree,SWT.NULL);
		reportsRoot.setText(Messages.getString("TreeFactory.77")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(BillUIBillReport.class.getName())>0){
			item = new TreeItem(reportsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.78")); //$NON-NLS-1$
			item.setData(BillUIBillReport.class.getName());
			}
		
		invoiceRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		reportsRoot.setExpanded(true);
		
		return tree;
		
	}
	
	public static Tree createCashTree(Tree tree){
		
	    TreeItem accountsRoot = new TreeItem(tree,SWT.NULL);
		accountsRoot.setText(Messages.getString("TreeFactory.92"));   //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(CashUICashCardAdd.class.getName())>0){
			item = new TreeItem(accountsRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.46"));  //$NON-NLS-1$
			item.setData(CashUICashCardAdd.class.getName());
		}
		
	    TreeItem transRoot = new TreeItem(tree,SWT.NULL);
		transRoot.setText(Messages.getString("TreeFactory.93"));  //$NON-NLS-1$
		
		   if(EngBLPermissions.getPermission(CashUICashCollectTransactionAdd.class.getName())>0){
			item = new TreeItem(transRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.51"));  //$NON-NLS-1$
			item.setData(CashUICashCollectTransactionAdd.class.getName());
	   }
		   if(EngBLPermissions.getPermission(CashUICashPaymentTransactionAdd.class.getName())>0){
			item = new TreeItem(transRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.53"));  //$NON-NLS-1$
			item.setData(CashUICashPaymentTransactionAdd.class.getName());
	   }
		   if(EngBLPermissions.getPermission(CashUICashOtherCollectTransaction.class.getName())>0){
			item = new TreeItem(transRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.104"));   //$NON-NLS-1$
			item.setData(CashUICashOtherCollectTransaction.class.getName());
	   }
		   if(EngBLPermissions.getPermission(CashUICashOtherPaymentTransaction.class.getName())>0){
			item = new TreeItem(transRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.105"));   //$NON-NLS-1$
			item.setData(CashUICashOtherPaymentTransaction.class.getName());
	   }
		   if(EngBLPermissions.getPermission(CashUICashTransferBetweenCards.class.getName())>0){
			item = new TreeItem(transRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.106"));   //$NON-NLS-1$
			item.setData(CashUICashTransferBetweenCards.class.getName());
	   }
		   
		    TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
			searchRoot.setText(Messages.getString("TreeFactory.94"));  //$NON-NLS-1$
			
		if(EngBLPermissions.getPermission(CashUICashCardSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.47"));  //$NON-NLS-1$
			item.setData(CashUICashCardSearch.class.getName());
		}
		
		if(EngBLPermissions.getPermission(CashUICashTransactionSearch.class.getName())>0){
		    item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.49")); //$NON-NLS-1$
			item.setData(CashUICashTransactionSearch.class.getName());
		}
		
	    TreeItem reportsRoot = new TreeItem(tree,SWT.NULL);
		reportsRoot.setText(Messages.getString("TreeFactory.95"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(CashUICashCardAbstract.class.getName())>0){
			
			    item = new TreeItem(reportsRoot,SWT.NULL);
				item.setText(Messages.getString("TreeFactory.59"));  //$NON-NLS-1$
				item.setData(CashUICashCardAbstract.class.getName());
			}
		
		if(EngBLPermissions.getPermission(CashUICashCardDailyAbstract.class.getName())>0){
			
			    item = new TreeItem(reportsRoot,SWT.NULL);
				item.setText(Messages.getString("TreeFactory.96")); //$NON-NLS-1$
				item.setData(CashUICashCardDailyAbstract.class.getName());
			}
	
		

		
		accountsRoot.setExpanded(true);
		transRoot.setExpanded(true);
		searchRoot.setExpanded(true);
		reportsRoot.setExpanded(true);
		
		return tree;
	    
	}
	
	public static Tree createChequesTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText("Bordrolar");  
		TreeItem item;
		
		
		if(EngBLPermissions.getPermission(CheUIChequeInPayroll.class.getName())>0){
			item = new TreeItem(root,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.57"));   //$NON-NLS-1$
			item.setData(CheUIChequeInPayroll.class.getName());
	    }
		
		
		if(EngBLPermissions.getPermission(CheUIChequeOutPayrollCurrent.class.getName())>0){
			item = new TreeItem(root,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.66"));  //$NON-NLS-1$
			item.setData(CheUIChequeOutPayrollCurrent.class.getName());
	    }
		if(EngBLPermissions.getPermission(CheUIChequeOutPayrollBank.class.getName())>0){
			item = new TreeItem(root,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.100"));   //$NON-NLS-1$
			item.setData(CheUIChequeOutPayrollBank.class.getName());
	    }
		
		
		if(EngBLPermissions.getPermission(CheUIChequeCollectFromBank.class.getName())>0){
			item = new TreeItem(root,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.103"));    //$NON-NLS-1$
			item.setData(CheUIChequeCollectFromBank.class.getName());
	    }
		
		if(EngBLPermissions.getPermission(CheUIChequeCollect.class.getName())>0){
			item = new TreeItem(root,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.107"));     //$NON-NLS-1$
			item.setData(CheUIChequeCollect.class.getName());
	    }
		
		TreeItem searchRoot = new TreeItem(tree,SWT.NULL);
		
		searchRoot.setText("Arama");  
		
		if(EngBLPermissions.getPermission(CheUIOwnChequeSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.102"));    //$NON-NLS-1$
			item.setData(CheUIOwnChequeSearch.class.getName());
	    }
		if(EngBLPermissions.getPermission(CheUICustomerChequeSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.101"));    //$NON-NLS-1$
			item.setData(CheUICustomerChequeSearch.class.getName());
	    }
		if(EngBLPermissions.getPermission(CheUIChequeRollSearch.class.getName())>0){
			item = new TreeItem(searchRoot,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.65"));   //$NON-NLS-1$
			item.setData(CheUIChequeRollSearch.class.getName());
	    }
		
		root.setExpanded(true);
		searchRoot.setExpanded(true);
		return tree;
		
	}

}
