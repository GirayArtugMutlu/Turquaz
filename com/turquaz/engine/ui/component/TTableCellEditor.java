/*
 * Created on 06.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.turquaz.engine.ui.component;

import de.kupzog.ktable.KTableCellEditor;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;


/**
 * @author onsel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TTableCellEditor extends KTableCellEditor{
	

	public void open(TTable table, int col, int row, Rectangle rect) {
		super.open(table, col, row, rect);
		
		
	}


	public void close(boolean save) {
		
		super.close(save);
	}


	protected Control createControl() {
		return null;
	}
	
	/* 
	 * overridden from superclass
	 */
	public void setBounds(Rectangle rect) 
	{
		super.setBounds(new Rectangle(rect.x, rect.y+(rect.height - 15)/2+1,
									  rect.width, 15));
	}

}
