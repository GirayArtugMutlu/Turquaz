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
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.bank.ui.BankUIBankCardSearch;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.current.ui.CurUICurrentCardSearch;
import com.turquaz.inventory.Messages;
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
		root.setText(Messages.getString("InvUITree.0")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("InvUITree.1")); //$NON-NLS-1$
		item.setData(InvUICardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("InvUITree.2")); //$NON-NLS-1$
		item.setData(InvUITransactionAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("InvUITree.3")); //$NON-NLS-1$
		item.setData(InvUICardSearch.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("InvUITree.4")); //$NON-NLS-1$
		item.setData(InvUIWarehouseAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("InvUITree.5")); //$NON-NLS-1$
		item.setData(InvUIWarehouseSearch.class.getName());
	
		return tree;
	}
	
	public static Tree createBankTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText("Banks");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("Bank Card Add");
		item.setData(BankUIBankCardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText("Bank Card Search");
		item.setData(BankUIBankCardSearch.class.getName());
		return tree;
	}
	public static Tree createAccountingTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText("Accounting");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("New Account");
		item.setData(AccUIAddAccounts.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText("Accounting Plan");
		item.setData(AccUIAccountingPlan.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText("Accounting Transaction Add");
		item.setData(AccUITransactionAdd.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText("Collect Transaction");
		item.setData(AccUITransactionCollect.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText("Payment Transaction");
		item.setData(AccUITransactionPayment.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText("Transaction Search");
		item.setData(AccUITransactionSearch.class.getName());
		return tree;
	}
	public static Tree createCurrentTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText("Current");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("Current Card Add");
		item.setData(CurUICurrentCardAdd.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText("Current Card Search");
		item.setData(CurUICurrentCardSearch.class.getName());		
		return tree;
	}
	public static Tree createAdminTree(Tree tree){
		TreeItem root = new TreeItem(tree,SWT.NULL);
		root.setText("Administrator");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("User Permissions");
		item.setData(AdmUIPermPanel.class.getName());
		return tree;
	}
	

}
