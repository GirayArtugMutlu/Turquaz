/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import java.util.List;

import com.turquaz.engine.dal.TurqInventoryUnit;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TTableCellEditorInvUnitsCombo extends TTableCellEditorCombo {

	public TTableCellEditorInvUnitsCombo(List list){
		super();
		int size = list.size();
		String [] k = new String[size];
		for(int i=0;i<size;i++){
			k[i] = ((TurqInventoryUnit)list.get(i)).getUnitsName();
		}
		this.setItems(k);
		
	}
}
