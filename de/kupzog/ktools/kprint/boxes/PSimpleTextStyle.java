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

//import de.kupzog.ktools.kprint.*;
import org.eclipse.swt.*;

/**
 * @author Friederich Kupzog A PTextStyle that is easy to create.
 */
public class PSimpleTextStyle extends PTextStyle
{
	public PSimpleTextStyle(String fontname, int size, boolean bold)
	{
		super();
		this.fontName = fontname;
		this.fontSize = size;
		if (bold)
			this.fontStyle = SWT.BOLD;
	}
}