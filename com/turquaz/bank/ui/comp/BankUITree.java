/*
 * Created on Oct 15, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.ui.comp;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.admin.ui.AdmUIPermPanel;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankUITree extends Tree{
	public BankUITree(Composite comp, int style){
	super(comp,style);
	TreeItem root = new TreeItem(this,SWT.NULL);
	root.setText("Banks");
	TreeItem item = new TreeItem(root,SWT.NULL);
	item.setText("Bank Card Add");
	item.setData(AdmUIPermPanel.class.getName());
	}

}
