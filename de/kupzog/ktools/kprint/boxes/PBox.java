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
import de.kupzog.ktools.kprint.gui.PagePoint;

/**
 * Abstract superclass for all printable Objects. For more details
 * 
 * @see PDocument
 * @author Friederich Kupzog
 */
public class PBox
{
	// Styles
	/**
	 * Style flag that forces the PBox to be in a new line below the previous one Cannot be used simultaniously to POS_RIGHT.
	 */
	public static final int POS_BELOW = 1;
	/**
	 * Style flag that forces the PBox to be in line with the pre vious one. Cannot be used simultaniously to POS_BELOW.
	 */
	public static final int POS_RIGHT = 2;
	/**
	 * Style flag that can be used additionally to POS_BELOW/POS_RIGHT to tell the PBox that it shoul consume all available horizontal
	 * space on the page.
	 */
	public static final int GRAB = 4;
	/**
	 * Style flag that is mainly used by tables and forces all PBoxes in a line to have the same height. All PBoxes in the line should be
	 * constructed with this flag
	 */
	public static final int ROW_ALIGN = 8;
	// static parameters (set by setParameters())
	public static GC gc = null; // GC used thoughout the drawing system
	public static Point pixelPerCm = new Point(0, 0);
	public static Point pixelPerInch = new Point(0, 0);
	public static Device device = null; // the Device on which the GC works.
	public static int scalingPercent = 100; // The scaling factor (used for previews in different sizes)
	// member variables
	// Misc:
	public PContainer parent;
	public PStyle boxStyle;
	public boolean below;
	public boolean rowAlign;
	public int forcedHeight; // this variable is set to a value != 0 by
	// the layout method and determines a fixed pixel height
	// Positioning:
	public PagePoint origin;
	public int sizeCalculatedfor;
	public double hWeight; // -1 = fixed width, see minCm.
	public double minCm; // -1 = occupy existing space
	public boolean grabbing;
	public int grabWidth; // set by the layout function

	// which is able to calculate the width
	// of grabbing poxes.
	// Constructors
	/**
	 * Constructs a Box with default size below the previous one.
	 */
	public PBox(PContainer parent)
	{
		this.parent = parent;
		if (parent != null)
			parent.addChild(this);
		boxStyle = PStyle.getDefaultStyle();
		below = true;
		rowAlign = false;
		origin = new PagePoint();
		sizeCalculatedfor = 0;
		grabbing = false;
		grabWidth = 0;
		hWeight = -1;
		minCm = 0.0;
		forcedHeight = 0;
	}

	/**
	 * Constructs a Box with default size.
	 * 
	 * @param parent
	 * @param style
	 *             Poition: POS_BELOW or POS_RIGHT.
	 */
	public PBox(PContainer parent, int style)
	{
		this(parent);
		below = true;
		if ((style & POS_RIGHT) > 0)
			below = false;
		if ((style & POS_BELOW) > 0)
			below = true;
		if ((style & GRAB) > 0)
			grabbing = true;
		if ((style & ROW_ALIGN) > 0)
			rowAlign = true;
	}

	/**
	 * Constructs a Box with default size.
	 * 
	 * @param parent
	 * @param style
	 *             Poition: POS_BELOW or POS_RIGHT. Also GRAB and/or ROW_ALIGN.
	 * @param hWeight
	 *             Determines, how much of the existing page width should be occupied. 1.0 = full page. -1 = fiexed width, see minCm.
	 * @param minCm
	 *             Minimum width in cm. If > 0.0, the box will at least have this width.
	 */
	public PBox(PContainer parent, int style, double hWeight, double minCm)
	{
		this(parent, style);
		this.hWeight = hWeight;
		this.minCm = minCm;
	}

	public void dispose()
	{
		parent.children.remove(this);
	}

	/*
	 * Sets the forced height. This means that the PBox will have this height (in pixel) regardless of how high it wants to be.
	 */
	public void setForcedHeight(int height)
	{
		forcedHeight = height;
	}

	public void draw(int page, Point originOffset)
	{
		Point originForDrawing = new Point(this.origin.x + originOffset.x, this.origin.y + originOffset.y);
		if (layoutIsOnPage(page))
		{
			int width = getWidth();
			int height = getHeight(page);
			gc.setBackground(boxStyle.getBackColor());
			gc.fillRectangle(originForDrawing.x, originForDrawing.y, width, height);
			gc.setBackground(boxStyle.getLineColor());
			if (boxStyle.hasLine(0))
			{
				gc.fillRectangle(originForDrawing.x, originForDrawing.y, width, boxStyle.getLineWidth(0));
			}
			if (boxStyle.hasLine(1))
			{
				gc.fillRectangle(originForDrawing.x + width - boxStyle.getLineWidth(1), originForDrawing.y, boxStyle.getLineWidth(1),
						height);
			}
			if (boxStyle.hasLine(2))
			{
				gc.fillRectangle(originForDrawing.x, originForDrawing.y + height - boxStyle.getLineWidth(2), width, boxStyle
						.getLineWidth(2));
			}
			if (boxStyle.hasLine(3))
			{
				gc.fillRectangle(originForDrawing.x, originForDrawing.y, boxStyle.getLineWidth(3), height);
			}
			gc.setBackground(boxStyle.getBackColor());
		}
	}

	/**
	 * Returns the elements PDocument.
	 * 
	 * @return PDocument
	 */
	public PDocument getDocument()
	{
		return parent.doc;
	}

	///////////////////////////////////////////////////////////////////
	// LAYOUT API
	///////////////////////////////////////////////////////////////////
	/*
	 * Some elements can occupy more than one Page. Therefore this function tests if the element has a part on the given page. @param page
	 * @return boolean
	 */
	public boolean layoutIsOnPage(int page)
	{
		return (page == origin.page);
	}

	/*
	 * Returns the space in y-direction the Element would occupy of the rest of the page if told so. Convention: this method can be called
	 * several times for one page, but only until layoutOccupy is called once for this page. @param spaceLeft @return int -1, if the
	 * element deciedes not to have any part on the given page
	 */
	public int layoutHowMuchWouldYouOccupyOf(Point spaceLeft, int page)
	{
		if (layoutAlreadyFinished())
			return 0;
		if (getHeight() > spaceLeft.y)
			return -1;
		return getHeight();
	}

	public boolean layoutAlreadyFinished()
	{
		return origin.page > 0;
	}

	/*
	 * Returns true if the box would fit or at least finish into/within the given space in y-direction. Convention: this method can be
	 * called several times for one page, but only until layoutOccupy is called once for this page. @param spaceLeft
	 */
	public boolean layoutWouldYouFinishWithin(Point spaceLeft, int page)
	{
		if (getHeight() > spaceLeft.y)
			return false;
		return true;
	}

	/*
	 * Tells the element to occupy the given space on the page. Returns the space in y-direction the Element occupys of the rest of the
	 * page. Convention: this method is only called once for one page, and after this call there will be no further
	 * layoutHowMuchWouldYouOccpy-calls for this page. @param spaceLeft @return int
	 */
	public int layoutOccupy(Point origin, Point spaceLeft, int page)
	{
		if (!layoutAlreadyFinished())
		{
			this.origin.page = page;
			this.origin.x = origin.x;
			this.origin.y = origin.y;
		}
		return getHeight();
	}

	/*
	 * use this method to make all tuning variables unvalid and so force a recalculation of these variables.
	 */
	public void layoutResetTuning()
	{
		sizeCalculatedfor = 0;
		origin.page = 0;
		forcedHeight = 0;
	}

	/*
	 * Gives the horizontal size of the element. (has only to work AFTER the layout process, is used by draw().)
	 */
	public int getWidth()
	{
		if (grabbing)
			return grabWidth;
		if (hWeight < 0)
			return pixelX(minCm);
		return Math.max(pixelX(minCm), pixelX(parent.getPossibleWidth() * hWeight));
	}

	/*
	 * Gives the vertical size of the element. Used by all layout* functions. If multipage functionallity is needed, this mechanism does no
	 * longer work. Use/overwrite getHeight(int page) instead.
	 */
	public int getHeight()
	{
		if (forcedHeight > 0)
			return forcedHeight;
		return 0;
	}

	public int getHeight(int page)
	{
		if (origin.page == page)
		{
			if (rowAlign)
				return forcedHeight;
			return getHeight();
		}
		return 0;
	}

	///////////////////////////////////////////////////////////////////
	// STATIC API
	///////////////////////////////////////////////////////////////////
	public static int pixelX(double cm)
	{
		long tmp = Math.round(cm * pixelPerCm.x * scalingPercent / 100);
		return (int) tmp;
	}

	public static int pixelY(double cm)
	{
		long tmp = Math.round(cm * pixelPerCm.y * scalingPercent / 100);
		return (int) tmp;
	}

	/**
	 * Sets the main parameters for a document to print.
	 * 
	 * @param theGC
	 * @param theDevice
	 * @param dpi
	 */
	public static void setParameters(GC theGC, Device theDevice, Point dpi, int percent)
	{
		gc = theGC;
		device = theDevice;
		scalingPercent = percent;
		pixelPerInch = dpi;
		pixelPerCm = new Point((int) Math.round(dpi.x / 2.54), (int) Math.round(dpi.y / 2.54));
	}

	/**
	 * @return PStyle
	 */
	public PStyle getBoxStyle()
	{
		return boxStyle;
	}

	/**
	 * Sets the boxStyle.
	 * 
	 * @param boxStyle
	 *             The boxStyle to set
	 */
	public void setBoxStyle(PStyle boxStyle)
	{
		this.boxStyle = boxStyle;
	}
}