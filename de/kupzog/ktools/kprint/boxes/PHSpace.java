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

//import org.eclipse.swt.SWT;

/**
 * Horizontal white space 
 * @author Friederich Kupzog
 */
public class PHSpace
extends PBox
{

	private double cm;
	/**
	 * Creates a new Space
	 */
	public PHSpace(PContainer parent, int style, double cm) {
		super(parent, style);
		this.cm = cm;
		//getBoxStyle().backColor = SWT.COLOR_GREEN;
	}

	/* 
	 * overridden from superclass
	 */
	public int getWidth() {
		if (grabbing) return grabWidth;
		return PBox.pixelX(cm);
	}

	public int getHeight() {
		if (forcedHeight > 0) return forcedHeight;
		// return 2;
		return 0;
	}


}
