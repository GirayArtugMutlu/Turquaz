/*
 * Created on 01.03.2004
 *
 * (c) 2004 by Friederich Kupzog Elektronik & Software
 * 
 * This program is free software; you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for 
 * more details. 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the fkmk@kupzog.de
 * www.kupzog.de/fkmk
 * 
 */
package de.kupzog.ktable;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
//import org.eclipse.swt.widgets.*;

/**
 * @author Friederich Kupzog
 */
public class PaletteExampleRenderer extends KTableCellRenderer {

	/**
	 * 
	 */
	public PaletteExampleRenderer() {
	}
	
	/* 
	 * overridden from superclass
	 */
	public int getOptimalWidth(
		GC gc,
		int col,
		int row,
		Object content,
		boolean fixed) 
	{
		return 16;
	}

	
	/* 
	 * overridden from superclass
	 */
	public void drawCell(
		GC gc,
		Rectangle rect,
		int col,
		int row,
		Object content,
		boolean focus,
		boolean fixed,
		boolean clicked)
	{
		// Performance test:
		/*
		gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		gc.fillRectangle(rect);
		
		int j=1;
		for (int i = 0; i < 10000000; i++) {
			j++;
		}
		*/
		Color color = new Color(m_Display,(RGB)content);
		gc.setBackground(m_Display.getSystemColor(SWT.COLOR_WHITE));
		rect.height++;
		rect.width++;
		gc.fillRectangle(rect);
		
		gc.setBackground(color);
		if (!focus)
		{
			rect.x += 1;
			rect.y += 1;
			rect.height -= 2;
			rect.width -= 2;
		}
		gc.fillRectangle(rect);
		color.dispose();
	}


}
