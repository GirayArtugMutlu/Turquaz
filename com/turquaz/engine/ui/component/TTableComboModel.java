/*
 * Created on Sep 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellEditorText;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TTableComboModel extends TTableModel {
	public TTableComboModel(){
		super();
	}
	public KTableCellEditor getCellEditor(int col, int row) {
		if (col == 1)
		{
			TTableCellEditorCombo e = new TTableCellEditorCombo();
			e.setItems(new String[] {"First text","Second text","third text"});
			return e;
		}		
		return new KTableCellEditorText();
	}

}
