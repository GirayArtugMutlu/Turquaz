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

import java.io.InputStream;
import org.eclipse.swt.graphics.*;
import de.kupzog.ktools.kprint.gui.PagePoint;

/**
 * A printable Image info.
 * 
 * @author Friederich Kupzog For more details
 * @see PDocument
 */
public class PImageBox extends PBox
{
	protected String imgName;
	protected int imgDPI;
	protected Image image;
	protected Point imgOriginalSize;
	protected Point imgTargetSize;

	/**
	 * @param parent
	 * @param style
	 */
	public PImageBox(PContainer parent, int style)
	{
		super(parent, style);
	}

	/**
	 * Sets the Image. The size of the image will be calculated by using the dpi parameter, in which you can specify which resolution is
	 * the "native" image resulotion. If you e.g. specify 600 dpi and print on a 600 dpi printer, the image will not be resized. If you
	 * print it on an 300 dpi printer, it will be resized.
	 * 
	 * @param name
	 * @param dpi
	 */
	public void setImage(String name, int dpi)
	{
		this.imgName = name;
		this.imgDPI = dpi;
		image = null;
		imgOriginalSize = null;
		imgTargetSize = null;
	}

	/*
	 * overridden from superclass
	 */
	public void layoutResetTuning()
	{
		super.layoutResetTuning();
		image = null;
		imgOriginalSize = null;
		imgTargetSize = null;
	}

	protected Point calcSize()
	{
		try
		{
			Class clazz = new Object().getClass();
			InputStream is = clazz.getResourceAsStream(imgName);
			image = new Image(device, is);
			imgOriginalSize = new Point(0, 0);
			imgOriginalSize.x = image.getImageData().width;
			imgOriginalSize.y = image.getImageData().height;
			imgTargetSize = new Point(0, 0);
			imgTargetSize.x = (int) (imgOriginalSize.x * scalingPercent / 100 * (pixelPerInch.x / (double) imgDPI));
			imgTargetSize.y = (int) (imgOriginalSize.y * scalingPercent / 100 * (pixelPerInch.y / (double) imgDPI));
			sizeCalculatedfor = scalingPercent;
			image.getImageData().transparentPixel = -1;
			image.getImageData().maskData = null;
			return imgTargetSize;
		}
		catch (Exception e1)
		{
			System.out.println("could not open ressource " + imgName);
			imgOriginalSize = new Point(10, 10);
			imgTargetSize = new Point(10, 10);
			return imgTargetSize;
		}
	}

	/*
	 * overridden from superclass
	 */
	public int layoutHowMuchWouldYouOccupyOf(Point spaceLeft, int page)
	{
		if (layoutAlreadyFinished())
			return 0;
		if (sizeCalculatedfor != scalingPercent || image == null)
		{
			calcSize();
		}
		//System.out.println("Size: "+imgTargetSize.y+" Space: "+spaceLeft.y);
		if (imgTargetSize.y > spaceLeft.y)
			return -1;
		return imgTargetSize.y;
	}

	/*
	 * overridden from superclass
	 */
	public int getWidth()
	{
		if (sizeCalculatedfor != scalingPercent || image == null)
		{
			calcSize();
		}
		return imgTargetSize.x;
	}

	/*
	 * overridden from superclass
	 */
	public int getHeight()
	{
		if (rowAlign)
			return forcedHeight;
		if (sizeCalculatedfor != scalingPercent || image == null)
		{
			calcSize();
		}
		return imgTargetSize.y;
	}

	/*
	 * overridden from superclass
	 */
	public int layoutOccupy(Point origin, Point spaceLeft, int page)
	{
		if (layoutAlreadyFinished())
			return 0;
		if (sizeCalculatedfor != scalingPercent || image == null)
		{
			calcSize();
		}
		this.origin = new PagePoint(origin, page);
		return imgTargetSize.y;
	}

	public void draw(int page, Point originOffset)
	{
		if (layoutIsOnPage(page))
		{
			super.draw(page, originOffset);
			if (image != null)
			{
				gc.drawImage(image, 0, 0, imgOriginalSize.x, imgOriginalSize.y, origin.x + originOffset.x, origin.y + originOffset.y,
						imgTargetSize.x, imgTargetSize.y);
			}
		}
	}
}