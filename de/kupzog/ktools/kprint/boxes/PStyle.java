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

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.*;

/**
 * A style for printable objects.
 * 
 * @author Friederich Kupzog
 */
public class PStyle
{
	public double[] lines;
	public int lineColor;
	public int backColor;

	public PStyle()
	{
		lines = new double[4];
		lines[0] = 0.0;
		lines[1] = 0.0;
		lines[2] = 0.0;
		lines[3] = 0.0;
		lineColor = SWT.COLOR_BLACK;
		backColor = SWT.COLOR_WHITE;
		//setDebugStyle();
	}

	public static PStyle getDefaultStyle()
	{
		return new PStyle();
	}

	public int getLineWidth(int num)
	{
		int pixel = 0;
		if (num == 0 || num == 2)
			pixel = PBox.pixelY(lines[num]);
		if (num == 1 || num == 3)
			pixel = PBox.pixelX(lines[num]);
		if (pixel < 0)
			return 0;
		if (pixel == 0)
			return 1;
		return pixel;
	}

	public boolean hasLine(int num)
	{
		return lines[num] > 0;
	}

	public Color getLineColor()
	{
		return PBox.device.getSystemColor(lineColor);
	}

	public Color getBackColor()
	{
		return PBox.device.getSystemColor(backColor);
	}
}