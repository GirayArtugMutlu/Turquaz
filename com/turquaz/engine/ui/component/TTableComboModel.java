/*
 * Created on Sep 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import java.util.List;

import de.kupzog.ktable.KTableCellEditor;
import de.kupzog.ktable.KTableCellEditorText;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
