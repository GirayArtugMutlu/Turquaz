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

import org.eclipse.swt.graphics.Point;

/**
 * A text box that shows the current page number.
 * @author Friederich Kupzog
 */
public class PPageNumber extends PTextBox {
	protected static int pageNumber = 0;

	/**
	 * @param parent
	 * @param style
	 */
	public PPageNumber(PContainer parent, int style) {
		super(parent, style, -1, 0);
		setText("    ");
	}
	
	public void draw(int page, Point originOffset)
	{
		
		if (layoutIsOnPage(page))
		{
			super.draw(page, originOffset);
			gc.setFont(textStyle.getFont());
			gc.setForeground(textStyle.getFontColor());
			gc.drawText(
					""+pageNumber,
					origin.x + originOffset.x + pixelX(textStyle.getMarginLeft()), 
					origin.y + originOffset.y, 
					true);
		}
	}

	
	


}
