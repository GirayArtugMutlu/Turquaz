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
 * A horzontal line
 * 
 * @author Friederich Kupzog
 */
public class PHLine extends PBox
{
	protected double thickness;
	protected int color;

	/**
	 * Creates a horizontal line with the given thickness and color.
	 */
	public PHLine(PContainer parent, double thickness, int color)
	{
		super(parent, POS_BELOW, 1.0, 0.0);
		this.thickness = thickness;
		boxStyle.lines = new double[]{0.0, 0.0, 0.0, 0.0};
		boxStyle.backColor = color;
	}

	/**
	 * Creates a black thin horizontal line.
	 */
	public PHLine(PContainer parent)
	{
		super(parent, POS_BELOW, 1.0, 0.0);
		this.thickness = 0.01;
		boxStyle.lines = new double[]{0.0, 0.0, 0.0, 0.0};
		boxStyle.backColor = SWT.COLOR_BLACK;
	}

	public int getHeight()
	{
		if (forcedHeight > 0)
			return forcedHeight;
		int erg = PBox.pixelY(thickness);
		if (erg == 0)
			return 1;
		return erg;
	}
}