/*
 * Created on Oct 15, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.ui.comp;
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


import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.bank.ui.BankUIBankCardSearch;

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
	item.setData(BankUIBankCardAdd.class.getName());
	item = new TreeItem(root,SWT.NULL);
	item.setText("Bank Card Search");
	item.setData(BankUIBankCardSearch.class.getName());
	
	}

}
