
package com.turquaz.accounting.ui.comp;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.ui.AccUIAccountingPlan;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.accounting.ui.AccUITransactionSearch;


public class AccUITree extends Tree {
	public AccUITree(Composite comp, int style){
		super(comp,style);
		TreeItem root = new TreeItem(this,SWT.NULL);
		root.setText(Messages.getString("AccUITree.0")); //$NON-NLS-1$
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.1")); //$NON-NLS-1$
		item.setData(AccUIAddAccounts.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.2")); //$NON-NLS-1$
		item.setData(AccUIAccountingPlan.class.getName());
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.3")); //$NON-NLS-1$
		item.setData(AccUITransactionAdd.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.4")); //$NON-NLS-1$
		item.setData(AccUITransactionCollect.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.5")); //$NON-NLS-1$
		item.setData(AccUITransactionPayment.class.getName());	
		item = new TreeItem(root,SWT.NULL);
		item.setText(Messages.getString("AccUITree.6")); //$NON-NLS-1$
		item.setData(AccUITransactionSearch.class.getName());
	
	}
}
