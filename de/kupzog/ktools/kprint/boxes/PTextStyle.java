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

import java.util.*;

/**
 * A style for printable objects that that contain text.
 * @author Friederich Kupzog
 */
public class PTextStyle {

	public static final int ALIGN_LEFT = 1;
	public static final int ALIGN_RIGHT = 2;
	public static final int ALIGN_CENTER = 3;
	
	protected static HashMap fonts = new HashMap();

	public int fontSize;
	public String fontName;
	public int fontStyle;
	public int fontColor;
	public int textAlign;
	protected double marginLeft;
	protected double marginRight;
	protected double marginTop;
	protected double marginBottom;
	

	public PTextStyle() {
		fontName = "Arial";
		fontStyle = SWT.NORMAL;
		fontSize = 10;
		fontColor = SWT.COLOR_BLACK;
		textAlign = ALIGN_LEFT;
		
		marginLeft = 0.0;
		marginRight = 0.0;
		
		marginTop = 0.0;
		marginBottom = 0.0;
		
	}
	
	
	
	public static void disposeFonts()
	{
		for (Iterator iter = fonts.values().iterator(); iter.hasNext();) {
			Font element = (Font) iter.next();
			element.dispose();
		}
		fonts.clear();
	}
	
	public static PTextStyle getDefaultStyle()
	{
		return new PTextStyle();
	}
	
	public Font getFont()
	{
		int height = Math.abs(fontSize*PBox.scalingPercent/100);
		String key = PBox.device.getDPI().x + "|" + PBox.device.getDPI().y
			+ "|" + fontName + "|" + height + "|" + fontStyle;
		Font font = (Font)fonts.get(key);
		if (font != null) return font; 
		font = new Font(
			PBox.device,
			fontName,
			Math.abs(fontSize*PBox.scalingPercent/100),
			fontStyle);
		fonts.put(key, font);
		return font;
	}
	
	public Color getFontColor()
	{
		return PBox.device.getSystemColor(fontColor);
	}


	/**
	 * @return double
	 */
	public double getMarginLeft() {
		return marginLeft;
	}

	/**
	 * @return double
	 */
	public double getMarginRight() {
		return marginRight;
	}

	/**
	 * Sets the marginLeft.
	 * @param marginLeft The marginLeft to set
	 */
	public void setMarginLeft(double marginLeft) {
		this.marginLeft = marginLeft;
	}

	/**
	 * Sets the marginRight.
	 * @param marginRight The marginRight to set
	 */
	public void setMarginRight(double marginRight) {
		this.marginRight = marginRight;
	}

	/**
	 * @return double
	 */
	public double getMarginBottom() {
		return marginBottom;
	}

	/**
	 * @return double
	 */
	public double getMarginTop() {
		return marginTop;
	}

	/**
	 * Sets the marginBottom.
	 * @param marginBottom The marginBottom to set
	 */
	public void setMarginBottom(double marginBottom) {
		this.marginBottom = marginBottom;
	}

	/**
	 * Sets the marginTop.
	 * @param marginTop The marginTop to set
	 */
	public void setMarginTop(double marginTop) {
		this.marginTop = marginTop;
	}

}
