/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.ui.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.accounting.ui.AccUIAccountingPlan;
import com.turquaz.accounting.ui.AccUIAddAccounts;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccUITree extends Tree {
	public AccUITree(Composite comp, int style){
		super(comp,style);
		TreeItem root = new TreeItem(this,SWT.NULL);
		root.setText("Accounting");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("New Account");
		item.setData(AccUIAddAccounts.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText("Accounting Plan");
		item.setData(AccUIAccountingPlan.class.getName());
		
		
	}
}
