/*
 * Created on 14.02.2004
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

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

/**
 * @author Friederich Kupzog
 */
public class TownExampleRenderer 
extends KTableCellRenderer {

	protected Display m_Display;
	
	
	public TownExampleRenderer() 
	{
		m_Display = Display.getCurrent();
	}
	
	public int getOptimalWidth(
		GC gc, 
		int col, 
		int row, 
		Object content, 
		boolean fixed)
	{
		return Math.max(gc.stringExtent(content.toString()).x + 8, 120);
	}
	
	
	public void drawCell(GC gc, 
		Rectangle rect, 
		int col, 
		int row, 
		Object content, 
		boolean focus, 
		boolean fixed,
		boolean clicked)
	{
		Color textColor;
		Color backColor;
		Color borderColor;
		TownExampleContent myContent = (TownExampleContent)content;

		if (focus) {
			textColor = m_Display.getSystemColor(SWT.COLOR_BLUE);
		} 
		else
		{
			textColor = m_Display.getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		}
		backColor = (m_Display.getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		borderColor = m_Display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
		
		gc.setForeground(borderColor);
		gc.drawLine(rect.x,rect.y+rect.height,rect.x+rect.width,rect.y+rect.height);

		gc.setForeground(borderColor);
		gc.drawLine(rect.x+rect.width,rect.y,rect.x+rect.width,rect.y+rect.height);
	
		if (col == 0)
		{
			gc.setBackground(m_Display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			textColor = m_Display.getSystemColor(SWT.COLOR_LIST_FOREGROUND);
			gc.setForeground(textColor);
			
			
			gc.drawImage((myContent.image),rect.x, rect.y);
	
			rect.y += 120;
			rect.height -= 120;
			gc.fillRectangle(rect);
			gc.drawText((myContent.name),rect.x+25, rect.y+2);
			
		}


		else if (col == 1)
		{
			gc.setBackground(backColor);
			gc.setForeground(textColor);
			
			gc.fillRectangle(rect);

			SWTX.drawTextImage(
				gc,
				myContent.country,
				SWTX.ALIGN_HORIZONTAL_LEFT | SWTX.ALIGN_VERTICAL_TOP,
				null,
				SWTX.ALIGN_HORIZONTAL_LEFT | SWTX.ALIGN_VERTICAL_CENTER,
				rect.x+3,
				rect.y,
				rect.width-3,
				rect.height
				);
			
		}
		
		else if (col == 2)
		{
			gc.setBackground(backColor);
			gc.setForeground(textColor);
			
			gc.fillRectangle(rect);
			Rectangle save = gc.getClipping();
			gc.setClipping(rect);
			gc.drawText((myContent.notes),rect.x+3, rect.y);
			gc.setClipping(save);
			
		}
		
		
		
	}
	


}
