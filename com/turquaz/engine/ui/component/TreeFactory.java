
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
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.accounting.ui.AccUITransactionSearch;
import com.turquaz.accounting.ui.reports.AccUIAccountingBalance;
import com.turquaz.accounting.ui.reports.AccUIAccountingGeneralLedger;
import com.turquaz.accounting.ui.reports.AccUIAccountingJournal;
import com.turquaz.admin.ui.AdmUIGroupAdd;
import com.turquaz.admin.ui.AdmUIGroupPermissions;
import com.turquaz.admin.ui.AdmUIGroups;

import com.turquaz.admin.ui.AdmUIUserAdd;
import com.turquaz.admin.ui.AdmUIUserPermissions;
import com.turquaz.admin.ui.AdmUIUsers;
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.bank.ui.BankUIBankCardSearch;
import com.turquaz.bill.ui.BillUIAddBill;
import com.turquaz.bill.ui.BillUIBillFromConsignment;
import com.turquaz.bill.ui.BillUIBillSearch;
import com.turquaz.consignment.ui.ConUIAddConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearch;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.current.ui.CurUITransactionAdd;
import com.turquaz.current.ui.CurUITransactionSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.InvUICardSearch;

import com.turquaz.inventory.ui.InvUITransactionSearch;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import com.turquaz.inventory.ui.InvUIWarehouseSearch;

public final class TreeFactory {
	
	public static Tree createInventoryTree(Tree tree){
		
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.0"));  //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(InvUICardAdd.class.getName())>0){
	    item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.1"));  //$NON-NLS-1$
		item.setData(InvUICardAdd.class.getName());
		
		}
			
		if(EngBLPermissions.getPermission(InvUICardSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.3"));  //$NON-NLS-1$
		item.setData(InvUICardSearch.class.getName());
		}
		
		if(EngBLPermissions.getPermission(InvUIWarehouseAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.4"));  //$NON-NLS-1$
		item.setData(InvUIWarehouseAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(InvUIWarehouseSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.5"));  //$NON-NLS-1$
		item.setData(InvUIWarehouseSearch.class.getName());
		}
		if(EngBLPermissions.getPermission(InvUITransactionSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.35"));  //$NON-NLS-1$
		item.setData(InvUITransactionSearch.class.getName());
		}
		root.setExpanded(true);
		return tree;
	}
	
	public static Tree createBankTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.6")); //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(BankUIBankCardAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.7")); //$NON-NLS-1$
		item.setData(BankUIBankCardAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(BankUIBankCardSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.8")); //$NON-NLS-1$
		item.setData(BankUIBankCardSearch.class.getName());
		}
		
		root.setExpanded(true);
		return tree;
	}
	
	public static Tree createAccountingTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.9")); //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(AccUIAddAccounts.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.10")); //$NON-NLS-1$
		item.setData(AccUIAddAccounts.class.getName());
		}
		if(EngBLPermissions.getPermission(AccUIAccountingPlan.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.11")); //$NON-NLS-1$
		item.setData(AccUIAccountingPlan.class.getName());
		}
		if(EngBLPermissions.getPermission(AccUITransactionAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.12")); //$NON-NLS-1$
		item.setData(AccUITransactionAdd.class.getName());	
		}
		if(EngBLPermissions.getPermission(AccUITransactionCollect.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.13")); //$NON-NLS-1$
		item.setData(AccUITransactionCollect.class.getName());	
		}
		if(EngBLPermissions.getPermission(AccUITransactionPayment.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.14")); //$NON-NLS-1$
		item.setData(AccUITransactionPayment.class.getName());	
		}
		if(EngBLPermissions.getPermission(AccUITransactionSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.15")); //$NON-NLS-1$
		item.setData(AccUITransactionSearch.class.getName());
		}
		
		TreeItem books = new TreeItem(tree,SWT.NULL);
		
		books.setText(Messages.getString("TreeFactory.32")); //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUIAccountingJournal.class.getName())>0){
		item = new TreeItem(books,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.28")); //$NON-NLS-1$
		item.setData(AccUIAccountingJournal.class.getName());
		}
		
	
		
		if(EngBLPermissions.getPermission(AccUIAccountingGeneralLedger.class.getName())>0){
		item = new TreeItem(books,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.33")); //$NON-NLS-1$
		item.setData(AccUIAccountingGeneralLedger.class.getName());
		}
		
		TreeItem actionReports = new TreeItem(tree,SWT.NULL);
		actionReports.setText(Messages.getString("TreeFactory.39"));  //$NON-NLS-1$
		
		if(EngBLPermissions.getPermission(AccUIAccountingBalance.class.getName())>0){
			item = new TreeItem(actionReports,SWT.NULL);
			item.setText(Messages.getString("TreeFactory.29")); //$NON-NLS-1$
			item.setData(AccUIAccountingBalance.class.getName());
			}
		
		books.setExpanded(true);
		root.setExpanded(true);
		actionReports.setExpanded(true);
		return tree;
	}
	public static Tree createCurrentTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.16")); //$NON-NLS-1$
		
		TreeItem item;
		if(EngBLPermissions.getPermission(CurUICurrentCardAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.17")); //$NON-NLS-1$
		item.setData(CurUICurrentCardAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(CurUICurrentCardSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.18")); //$NON-NLS-1$
		item.setData(CurUICurrentCardSearch.class.getName());
		}
		if(EngBLPermissions.getPermission(CurUITransactionAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.19")); //$NON-NLS-1$
		item.setData(CurUITransactionAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(CurUITransactionSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.20")); //$NON-NLS-1$
		item.setData(CurUITransactionSearch.class.getName());
		}
		
		root.setExpanded(true);
		return tree;
	}
	public static Tree createAdminTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.21")); //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(AdmUIUserAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.23")); //$NON-NLS-1$
		item.setData(AdmUIUserAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIUsers.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.24")); //$NON-NLS-1$
		item.setData(AdmUIUsers.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIGroupAdd.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.25")); //$NON-NLS-1$
		item.setData(AdmUIGroupAdd.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIGroups.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.26")); //$NON-NLS-1$
		item.setData(AdmUIGroups.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIUserPermissions.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.27")); //$NON-NLS-1$
		item.setData(AdmUIUserPermissions.class.getName());
		}
		if(EngBLPermissions.getPermission(AdmUIGroupPermissions.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.22")); //$NON-NLS-1$
		item.setData(AdmUIGroupPermissions.class.getName());
		}
		root.setExpanded(true);
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
		TreeItem root = new TreeItem(tree,SWT.NULL);
		
		root.setText(Messages.getString("TreeFactory.36")); //$NON-NLS-1$
		
		TreeItem item;
		
		if(EngBLPermissions.getPermission(BillUIBillFromConsignment.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.37")); //$NON-NLS-1$
		item.setData(BillUIBillFromConsignment.class.getName());
		}
	    if(EngBLPermissions.getPermission(BillUIBillSearch.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.2")); //$NON-NLS-1$
		item.setData(BillUIBillSearch.class.getName());
	    }
		if(EngBLPermissions.getPermission(BillUIAddBill.class.getName())>0){
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.38")); //$NON-NLS-1$
		item.setData(BillUIAddBill.class.getName());
		}
		root.setExpanded(true);
		return tree;
		
	}
	
	

}
