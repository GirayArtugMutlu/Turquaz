
package com.turquaz.engine.ui.viewers;
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
* @author  Onsel
* @version  $Id$
*/

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class TurquazTableSorter extends ViewerSorter{
	int columnIndex;
    public TurquazTableSorter(int criteria) {
		super();
		this.columnIndex = criteria;
	}    

    public int compare(Viewer arg0, Object arg1, Object arg2) {
        
        
        ITableRow row1 = (ITableRow)arg1;
        ITableRow row2 = (ITableRow)arg2;
        
       return collator.compare(row1.getColumnText(columnIndex),row2.getValue(columnIndex));
        
        
    }
}
