

package com.turquaz.inventory.ui.comp;

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


import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.InvUICardSearch;
import com.turquaz.inventory.ui.InvUITransactionAdd;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import com.turquaz.inventory.ui.InvUIWarehouseSearch;

/**
 * @author onsel
 *
 * @version $Id$
 */
public class InvUITree extends Tree {
	
	public InvUITree(org.eclipse.swt.widgets.Composite comp, int style){
		super(comp,style);
		TreeItem root = new TreeItem(this,SWT.NULL);
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
	  	}
	
	

}
