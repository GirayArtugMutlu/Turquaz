
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

package com.turquaz.engine.ui.component;

import de.kupzog.ktable.KTableCellEditor;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;


/**
 * @author onsel
 * @version $Id$
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
