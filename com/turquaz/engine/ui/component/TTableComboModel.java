
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
import java.util.List;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellEditorText;

public class TTableComboModel extends TTableModel {
	private List listItems;
	public TTableComboModel(List list ){
		super();
		listItems = list;
	}
	public KTableCellEditor getCellEditor(int col, int row) {
		if (col == 0)
		{	
			TTableCellEditorInvUnitsCombo e = new TTableCellEditorInvUnitsCombo(listItems);
			return e;
		}		
		return new KTableCellEditorText();
	}

}
