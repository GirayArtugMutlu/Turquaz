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

import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.swt.graphics.*;

/**
 * A printable text info. If you need page breaks within the text of a box, use PTextBox instead. CAUTION: A PLittleTextBox with too much
 * text for one entire page causes the layout process to hang in an endless loop.
 * 
 * @author Friederich Kupzog For more details
 * @see PDocument and
 * @see PBox
 */
public class PLittleTextBox extends PBox
{
	protected String text;
	protected PTextStyle textStyle;
	protected ArrayList textLines;

	/**
	 * Creates a non-wrapping text box with a fixed size according to its text.
	 * 
	 * @param parent
	 * @param style
	 */
	public PLittleTextBox(PContainer parent)
	{
		super(parent);
		init();
	}

	/**
	 * Creates a non-wrapping text box with a fixed size according to its text.
	 * 
	 * @param parent
	 * @param style
	 */
	public PLittleTextBox(PContainer parent, int style)
	{
		super(parent, style);
		init();
	}

	/**
	 * Creates a text box with wrapping capabilities if hWeight is > 0.
	 * 
	 * @param parent
	 * @param style
	 * @param hWeight
	 *             Specify -1 for a non-wrapping text box (If the text has newlines it will be a multi-line textbox). Spezify a number
	 *             between 0 and 1 for a multiline textbox that consumes the given fraction of the available document width.
	 * @param minWidth
	 *             This allows you to specify a minimum width for the text. The text box will consume some space depending to hWeight or
	 *             its text if hWeight is -1, but at least the given amount of centimeters. For a box with a fixed width for example set
	 *             hWeigth = 0 and specify a non-zero minWidth.
	 */
	public PLittleTextBox(PContainer parent, int style, double hWeight, double minWidth)
	{
		super(parent, style, hWeight, minWidth);
		init();
	}

	private void init()
	{
		text = "";
		textStyle = PTextStyle.getDefaultStyle();
		textLines = new ArrayList();
	}

	public void setText(String text)
	{
		if (text == null)
			text = "";
		this.text = text;
	}

	/*
	 * overridden from superclass
	 */
	public int getWidth()
	{
		if (grabbing)
			return grabWidth;
		if (hWeight >= 0 && hWeight <= 1 && minCm >= 0)
		{
			PDocument myDoc = getDocument();
			double maxWidthCm = (myDoc.pageWidth - myDoc.margins[1] - myDoc.margins[3]) * hWeight;
			return Math.max(pixelX(maxWidthCm), pixelX(minCm));
		}
		gc.setFont(textStyle.getFont());
		if (textLines.size() == 0)
			splitIntoLines();
		int erg = 0;
		for (Iterator iter = textLines.iterator(); iter.hasNext();)
		{
			String element = (String) iter.next();
			int w = gc.stringExtent(element).x;
			if (w > erg)
				erg = w;
		}
		erg += pixelX(textStyle.getMarginLeft());
		erg += pixelX(textStyle.getMarginRight());
		erg = Math.max(erg, pixelX(minCm));
		return erg;
	}

	protected void splitIntoLines()
	{
		textLines.clear();
		gc.setFont(textStyle.getFont());
		if ((grabWidth > 0) || (hWeight >= 0 && hWeight <= 1))
		{
			PDocument myDoc = getDocument();
			int maxWidth;
			if (grabWidth > 0)
				maxWidth = grabWidth;
			else
			{
				double maxWidthCm = (myDoc.pageWidth - myDoc.margins[1] - myDoc.margins[3]) * hWeight;
				maxWidth = Math.max(pixelX(maxWidthCm), pixelX(minCm));
			}
			maxWidth -= pixelX(textStyle.getMarginLeft());
			maxWidth -= pixelX(textStyle.getMarginRight());
			boolean fertig = false;
			int start = 0;
			int pos = 0;
			int lastPossibility = start;
			if (text.length() > 0)
			{
				while (!fertig)
				{
					int textLength = 0;
					while (!fertig && textLength < maxWidth)
					{
						if (text.charAt(pos) == ' ')
							lastPossibility = pos;
						if (text.charAt(pos) == '-')
							lastPossibility = pos;
						if (text.charAt(pos) == '\n')
						{
							textLines.add(text.substring(start, pos));
							start = pos + 1;
							pos = start;
						}
						int testPos = pos + 1;
						if (testPos > text.length())
							testPos = text.length();
						textLength = gc.stringExtent(text.substring(start, testPos)).x;
						if (textLength < maxWidth)
							pos++;
						if (pos >= text.length())
						{
							fertig = true;
						}
					}
					int umbruchPos = pos;
					if (lastPossibility > start && !fertig)
						umbruchPos = lastPossibility + 1;
					textLines.add(text.substring(start, umbruchPos));
					if (!fertig)
					{
						start = umbruchPos;
						if (start >= text.length())
						{
							fertig = true;
						}
						else
						{
							pos = start;
							lastPossibility = start;
						}
					}
				}
			}
		}
		else
		{
			textLines.add(text);
		}
	}

	/*
	 * overridden from superclass
	 */
	public void layoutResetTuning()
	{
		super.layoutResetTuning();
		textLines.clear();
	}

	/*
	 * overridden from superclass
	 */
	public int getHeight()
	{
		if (forcedHeight > 0)
			return forcedHeight;
		if (textLines.size() == 0)
			splitIntoLines();
		gc.setFont(textStyle.getFont());
		int lineHeight = gc.stringExtent("A").y;
		return (textLines.size() * lineHeight) + pixelY(textStyle.getMarginTop() + textStyle.getMarginBottom());
	}

	public void draw(int page, Point originOffset)
	{
		if (layoutIsOnPage(page))
		{
			super.draw(page, originOffset);
			Font font = textStyle.getFont();
			gc.setFont(font);
			gc.setForeground(textStyle.getFontColor());
			int lineHeight = gc.stringExtent("A").y;
			for (int i = 0; i < textLines.size(); i++)
			{
				int alignPixel = 0;
				if (textStyle.textAlign == PTextStyle.ALIGN_CENTER)
				{
					int textWidth = gc.stringExtent((String) textLines.get(i)).x;
					alignPixel = (getWidth() - pixelX(textStyle.getMarginLeft()) - pixelX(textStyle.getMarginRight()) - textWidth) / 2;
				}
				else if (textStyle.textAlign == PTextStyle.ALIGN_RIGHT)
				{
					int textWidth = gc.stringExtent((String) textLines.get(i)).x;
					alignPixel = (getWidth() - pixelX(textStyle.getMarginLeft()) - pixelX(textStyle.getMarginRight()) - textWidth);
				}
				gc.drawText((String) textLines.get(i), origin.x + alignPixel + originOffset.x + pixelX(textStyle.getMarginLeft()),
						origin.y + originOffset.y + pixelY(textStyle.getMarginTop()) + (i * lineHeight), true);
			}
		}
	}

	/**
	 * @return PTextStyle
	 */
	public PTextStyle getTextStyle()
	{
		return textStyle;
	}

	/**
	 * Sets the textStyle.
	 * 
	 * @param textStyle
	 *             The textStyle to set
	 */
	public void setTextStyle(PTextStyle textStyle)
	{
		this.textStyle = textStyle;
	}
}