
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
import java.util.List;

import com.turquaz.engine.dal.TurqCurrency;

import com.turquaz.engine.ui.component.TTableCellEditorCombo;
import com.turquaz.engine.ui.component.TTableCellEditorDecimalText;
import com.turquaz.engine.ui.component.TTableModel;
import com.turquaz.inventory.Messages;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellEditorText;


public class TTableInvPricesModel extends TTableModel {

	private String items[];
	public TTableInvPricesModel(List list ){
		super();
		int size = list.size();
		items = new String[size];
		for(int i=0;i<size;i++){
			items[i] = ((TurqCurrency)list.get(i)).getCurrenciesAbbreviation();
		}
		
		
	}
	public KTableCellEditor getCellEditor(int col, int row) {
		if (col == 2)
		{	
			TTableCellEditorCombo e = new TTableCellEditorCombo();
			e.setItems(items);
			
			return e;
		}
		else if (col==1)
		{	
			TTableCellEditorDecimalText e = new TTableCellEditorDecimalText();
			this.setContentAt(col,row,0+""); //$NON-NLS-1$
			return e;
		}	
		else if(col==0){
			TTableCellEditorCombo e = new TTableCellEditorCombo();
			e.setItems(new String[]{Messages.getString("TTableInvPricesModel.1"),Messages.getString("TTableInvPricesModel.2")}); //$NON-NLS-1$ //$NON-NLS-2$
			
			return e;
		}
		
		return new KTableCellEditorText();
	}

}
