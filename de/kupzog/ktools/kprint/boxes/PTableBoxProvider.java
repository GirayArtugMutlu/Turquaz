/*  Copyright (C) 2004 by Friederich Kupzog Elektronik & Software
 
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
    
    Author: Friederich Kupzog  
    fkmk@kupzog.de
    www.kupzog.de/fkmk
*/
 
 
package de.kupzog.ktools.kprint.boxes;

import org.eclipse.swt.SWT;

/**
 * Used by PTable to print KTables.
 * Comparable to KTableCellRenderer.
 * Creates a PBox for a Table cell.
 * It gets width and height information from the table
 * which are pixel values fro screen view. It may use
 * these values as a guideline. 
 * @author Friederich Kupzog
 */
public class PTableBoxProvider {
	
	public PBox createBox(
		PContainer parent,
		int style,
		int col, 
		int row,
		int widthFromModel,
		int heightFromModel, 
		boolean fixed, 
		Object content)
	{
		// create a text box
		PLittleTextBox box = new PLittleTextBox(parent, style, 0, widthFromModel*0.03);
		
		// set its border lines
		PStyle boxStyle = PStyle.getDefaultStyle();
		boxStyle.lines = new double[] {0.005, 0.0, 0.005, 0.0};
		if (row == 0) boxStyle.lines[0] = 0.00;
		if (col == 0) boxStyle.lines[3] = 0.00;
		box.setBoxStyle(boxStyle);

		// set the font		
		PTextStyle textStyle = PTextStyle.getDefaultStyle();
		if (fixed)  // Header row / column
		{
			textStyle.setMarginLeft(0.08);
			textStyle.setMarginRight(0.08);
			textStyle.setMarginTop(0.1);
			textStyle.setMarginBottom(0.1);
			textStyle.fontSize = 8;
			textStyle.fontStyle = SWT.BOLD;
			textStyle.textAlign = PTextStyle.ALIGN_LEFT;
		}
		else  // normal cell
		{
			textStyle.setMarginLeft(0.08);
			textStyle.setMarginRight(0.08);
			textStyle.setMarginTop(0.1);
			textStyle.setMarginBottom(0.1);
			textStyle.fontSize = 7;
			textStyle.textAlign = PTextStyle.ALIGN_LEFT;
		}
		box.setTextStyle(textStyle);
		
		
		// set the text
		box.setText(content.toString());
		
		// ready
		return box;
	}

	
}
