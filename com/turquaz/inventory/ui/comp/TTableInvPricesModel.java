/*
 * Created on Sep 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui.comp;

import java.util.List;

import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.component.TTableCellEditor;
import com.turquaz.engine.ui.component.TTableCellEditorCombo;
import com.turquaz.engine.ui.component.TTableCellEditorDecimalText;
import com.turquaz.engine.ui.component.TTableModel;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellEditorText;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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

			return e;
		}	
		else if(col==0){
			TTableCellEditorCombo e = new TTableCellEditorCombo();
			e.setItems(new String[]{"Buy","Sell"});
			return e;
		}
		
		return new KTableCellEditorText();
	}

}
