
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

package com.turquaz.current.ui.comp;



import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

import com.turquaz.current.ui.CurUICurrentCardAdd;



/**
 * @author onsel
 *
 * @version $Id$
 */
public class CurUITree extends Tree {
	
	public CurUITree(org.eclipse.swt.widgets.Composite comp, int style){
		super(comp,style);
		TreeItem root = new TreeItem(this,SWT.NULL);
		root.setText("Current");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("Current Card");
		item.setData(CurUICurrentCardAdd.class.getName());
	}
	

}
