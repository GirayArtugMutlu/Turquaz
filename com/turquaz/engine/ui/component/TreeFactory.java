/*
 * Created on Oct 25, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.accounting.ui.AccUIAccountingPlan;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.accounting.ui.AccUITransactionSearch;
import com.turquaz.admin.ui.AdmUIPermPanel;
import com.turquaz.admin.ui.AdmUIUserAdd;
import com.turquaz.admin.ui.AdmUIUsers;
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.bank.ui.BankUIBankCardSearch;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.current.ui.CurUITransactionAdd;
import com.turquaz.current.ui.CurUITransactionSearch;
import com.turquaz.engine.Messages;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.InvUICardSearch;
import com.turquaz.inventory.ui.InvUITransactionAdd;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import com.turquaz.inventory.ui.InvUIWarehouseSearch;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public final class TreeFactory {
	
	public static Tree createInventoryTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.0"));  //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.1"));  //$NON-NLS-1$
		item.setData(InvUICardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.2"));  //$NON-NLS-1$
		item.setData(InvUITransactionAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.3"));  //$NON-NLS-1$
		item.setData(InvUICardSearch.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.4"));  //$NON-NLS-1$
		item.setData(InvUIWarehouseAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.5"));  //$NON-NLS-1$
		item.setData(InvUIWarehouseSearch.class.getName());
	
		return tree;
	}
	
	public static Tree createBankTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.6")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.7")); //$NON-NLS-1$
		item.setData(BankUIBankCardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.8")); //$NON-NLS-1$
		item.setData(BankUIBankCardSearch.class.getName());
		return tree;
	}
	
	public static Tree createAccountingTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.9")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.10")); //$NON-NLS-1$
		item.setData(AccUIAddAccounts.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.11")); //$NON-NLS-1$
		item.setData(AccUIAccountingPlan.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.12")); //$NON-NLS-1$
		item.setData(AccUITransactionAdd.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.13")); //$NON-NLS-1$
		item.setData(AccUITransactionCollect.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.14")); //$NON-NLS-1$
		item.setData(AccUITransactionPayment.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.15")); //$NON-NLS-1$
		item.setData(AccUITransactionSearch.class.getName());
	   
		return tree;
	}
	public static Tree createCurrentTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.16")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.17")); //$NON-NLS-1$
		item.setData(CurUICurrentCardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.18")); //$NON-NLS-1$
		item.setData(CurUICurrentCardSearch.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.19")); //$NON-NLS-1$
		item.setData(CurUITransactionAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.20")); //$NON-NLS-1$
		item.setData(CurUITransactionSearch.class.getName());
		return tree;
	}
	public static Tree createAdminTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText(com.turquaz.engine.Messages.getString("TreeFactory.21")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(com.turquaz.engine.Messages.getString("TreeFactory.22")); //$NON-NLS-1$
		item.setData(AdmUIPermPanel.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.23")); //$NON-NLS-1$
		item.setData(AdmUIUserAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("TreeFactory.24")); //$NON-NLS-1$
		item.setData(AdmUIUsers.class.getName());
		return tree;
	}
	

}
