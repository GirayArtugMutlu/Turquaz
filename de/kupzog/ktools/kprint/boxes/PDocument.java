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
import org.eclipse.swt.printing.*;
import de.kupzog.ktools.kprint.gui.PageSetup;

/**
 * Class that represents a document to print. To print a document an a GC, the folowing steps are neccessary: (1) create the document's
 * content by creating a PDocument object and adding children. (2) setting the GC and its resulution by using the static method
 * PDocument.setParameters (3) layoutouting the children by a call to PDocument.layout() (4) drawing the documents pages on a GC by calling
 * PDocument.draw(int page) (5) disposing the GC and all Font objects by calling PTextStyle.disposeAll. Note that all this (except (1)) is
 * done by the PrintPreview class. Example code: <code>
 * 		Image newImage = new Image(
 Display.getCurrent(),
 9*40,13*40);
 GC gc = new GC(newImage);
 PBox.setParameters(gc, Display.getCurrent(), d.getDPI());
 PDocument c = new PDocument(9,13);
 
 PTextBox t = new PTextBox(c, PBox.BEGINNING);
 t.setText("This is text.");
 
 c.layout();		
 c.draw(1);
 
 gc.dispose();
 
 PTextStyle.disposeAll();
 

 * </code>
 * 
 * @author Friederich Kupzog
 */
public class PDocument extends PContainer
{
	public double pageHeight;
	public double pageWidth;
	public PContainer firstHeader;
	public PContainer firstFooter;
	public PContainer header;
	public PContainer footer;
	public double[] margins;
	public int numOfPages;
	public Point originOnFirstPage;
	public Point originOnOtherPages;
	public Point originOfPage;
	public Point originFirstFooter;
	public Point originOtherFooters;
	public String documentTitle;
	public double scale;

	/**
	 * @param pageWidth
	 *             absolute paper width in cm
	 * @param pageHeight
	 *             absolute paper height in cm
	 * @param top
	 * @param right
	 * @param bottom
	 * @param left
	 * @param scale
	 *             Scale factor: 1.0 = normal. If you e.g. specify A4 paper size and scale factor 0.712, then the document will be printed
	 *             like on A3 but scaled on an A4 sheet.
	 */
	public PDocument(double pageWidth, double pageHeight, double top, double right, double bottom, double left, double scale,
			String docTitle)
	{
		super(null);
		this.doc = this;
		this.scale = scale;
		this.pageHeight = pageHeight * 1 / scale;
		this.pageWidth = pageWidth * 1 / scale;
		this.documentTitle = docTitle;
		numOfPages = -1;
		margins = new double[4];
		margins[0] = top;
		margins[1] = right;
		margins[2] = bottom;
		margins[3] = left;
		firstFooter = new PContainer(this);
		footer = new PContainer(this);
		firstHeader = new PContainer(this);
		header = new PContainer(this);
	}

	/**
	 * Fills parameters with values from PageSetup.
	 * 
	 * @param pageWidth
	 * @param pageHeight
	 */
	public PDocument(String docname)
	{
		this(PageSetup.paperWidth, PageSetup.paperHeight, 0, 0, 0, 0, (double) PageSetup.scaling / 100, docname);
		double margin = 2.5;
		if (PageSetup.marginStyle == PageSetup.MARGIN_HUGE)
			margin = 4;
		if (PageSetup.marginStyle == PageSetup.MARGIN_SMALL)
			margin = 1;
		margins[0] = margin;
		margins[1] = margin;
		margins[2] = margin;
		margins[3] = margin;
	}

	public void readMeasuresFromPageSetup()
	{
		pageWidth = PageSetup.paperWidth;
		pageHeight = PageSetup.paperHeight;
		scale = (double) PageSetup.scaling / 100;
		double margin = 2.5;
		if (PageSetup.marginStyle == PageSetup.MARGIN_HUGE)
			margin = 4;
		if (PageSetup.marginStyle == PageSetup.MARGIN_SMALL)
			margin = 1;
		margins[0] = margin;
		margins[1] = margin;
		margins[2] = margin;
		margins[3] = margin;
	}

	/**
	 * returns the size of the page area in pixels given the current dpi setting set by PBox.setParameters. The page borders are not
	 * included.
	 */
	public Point getPageSize(int page)
	{
		Point erg = new Point(PBox.pixelX(pageWidth - margins[1] - margins[3]), PBox.pixelY(pageHeight - margins[0] - margins[2]));
		if (getFooter(page) != null)
		{
			erg.y -= getFooter(page).getHeight();
		}
		if (getHeader(page) != null)
		{
			erg.y -= getHeader(page).getHeight();
		}
		return erg;
	}

	public String getTitle()
	{
		return documentTitle;
	}

	/**
	 * use this method to make all tuning variables of this document and all its children unvalid and so force a recalculation of these
	 * variables.
	 */
	public void layoutResetTuning()
	{
		super.layoutResetTuning();
		firstHeader.layoutResetTuning();
		firstFooter.layoutResetTuning();
		header.layoutResetTuning();
		footer.layoutResetTuning();
	}

	/**
	 * Determines all positions of elements and calculates page break positions
	 */
	public void layout()
	{
		layoutResetTuning();
		int offsetX = 0, offsetY = 0;
		if (PBox.device instanceof Printer)
		{
			/*
			 * Rectangle trim = ((Printer) PBox.device).computeTrim(0, 0, PBox.pixelX(pageWidth), PBox.pixelY(pageHeight)); offsetX =
			 * trim.x; offsetY = trim.y; System.out.println(" Trim: "+trim); System.out.println("Vorher Page: " + pageHeight + " x " +
			 * pageWidth + " cm"); System.out.println("ClientArea: " + clientArea); pageHeight =
			 * (double)(clientArea.height/PBox.device.getDPI().y)*2.54; pageWidth =
			 * (double)(clientArea.width/PBox.device.getDPI().x)*2.54; System.out.println("Nachher Page: " + pageHeight + " x " +
			 * pageWidth + " cm");
			 */
			/*
			 * Rectangle trim = ((Printer) PBox.device).computeTrim(0, 0, 0, 0); System.out.println(" Trim: "+trim); System.out.println("
			 * DPI: "+PBox.device.getDPI()); double[] unprintableMargin = new double[4]; unprintableMargin[0] = -trim.y;
			 * unprintableMargin[1] = trim.width + trim.x; unprintableMargin[2] = trim.height + trim.y; unprintableMargin[3] = -trim.x;
			 * unprintableMargin[0] = (double)(unprintableMargin[0]/PBox.device.getDPI().y)*2.54; unprintableMargin[1] =
			 * (double)(unprintableMargin[1]/PBox.device.getDPI().x)*2.54; unprintableMargin[2] =
			 * (double)(unprintableMargin[2]/PBox.device.getDPI().y)*2.54; unprintableMargin[3] =
			 * (double)(unprintableMargin[3]/PBox.device.getDPI().x)*2.54; for (int i = 0; i < unprintableMargin.length; i++) {
			 * System.out.print("Rand " + i + " Vorher: "+margins[i]); margins[i] -= unprintableMargin[i]; if (margins[i] < 0) margins[i] =
			 * 0; System.out.println(" nachher: "+margins[i]); }
			 */
		}
		int maxHeightForFirstPage = PBox.pixelY(getPageHeight() - margins[0] - margins[2]);
		int maxHeightForOtherPages = PBox.pixelY(getPageHeight() - margins[0] - margins[2]);
		// Annahme hier: Header passen auf jeden Fall auf die Seite
		firstHeader.layout(maxHeightForFirstPage, maxHeightForOtherPages);
		firstFooter.layout(maxHeightForFirstPage, maxHeightForOtherPages);
		maxHeightForFirstPage -= firstHeader.getHeight();
		maxHeightForFirstPage -= firstFooter.getHeight();
		header.layout(maxHeightForOtherPages, maxHeightForOtherPages);
		footer.layout(maxHeightForOtherPages, maxHeightForOtherPages);
		maxHeightForOtherPages -= header.getHeight();
		maxHeightForOtherPages -= footer.getHeight();
		originOfPage = new Point(PBox.pixelX(margins[3]) + offsetX, PBox.pixelY(margins[0]) + offsetY);
		//System.out.println(" originOfPage: "+originOfPage);
		originOnFirstPage = new Point(PBox.pixelX(margins[3]) + offsetX, PBox.pixelY(margins[0]) + getFirstHeader().getHeight() + offsetY);
		//System.out.println(" originOnFirstPage: "+originOnFirstPage);
		originOnOtherPages = new Point(PBox.pixelX(margins[3]) + offsetX, PBox.pixelY(margins[0]) + getHeader().getHeight() + offsetY);
		//System.out.println(" originOnOtherPages: "+originOnOtherPages);
		originFirstFooter = new Point(PBox.pixelX(margins[3]) + offsetX, PBox.pixelY(getPageHeight() - margins[2])
				- getFirstFooter().getHeight() + offsetY);
		//System.out.println(" originFirstFooter: "+originFirstFooter);
		originOtherFooters = new Point(PBox.pixelX(margins[3]) + offsetX, PBox.pixelY(getPageHeight() - margins[2])
				- getFooter().getHeight() + offsetY);
		//System.out.println(" originOtherFooters: "+originOtherFooters);
		numOfPages = layout(maxHeightForFirstPage, maxHeightForOtherPages);
	}

	/**
	 * Returns the number of pages to be printed. Before calling this function, you have to call PDocument.layout()
	 * 
	 * @return int
	 */
	public int getNumOfPages()
	{
		/*
		 * if (numOfPages == -1) throw new NullPointerException("Please call layout() first.");
		 */
		return numOfPages;
	}

	/**
	 * Draws the given page number on the GC set by PBox.setParameters Before calling this function, you have to call PDocument.layout()
	 */
	public void draw(int page)
	{
		PPageNumber.pageNumber = page;
		if (page == 1)
		{
			if (getHeader(page) != null)
				getHeader(page).draw(1, originOfPage);
			super.draw(page, originOnFirstPage);
			if (getFooter(page) != null)
				getFooter(page).draw(1, originFirstFooter);
		}
		else
		{
			if (getHeader(page) != null)
				getHeader(page).draw(1, originOfPage);
			super.draw(page, originOnOtherPages);
			if (getFooter(page) != null)
				getFooter(page).draw(1, originOtherFooters);
		}
	}

	/**
	 * @return PBox
	 */
	public PContainer getFooter(int page)
	{
		if (page == 1)
			return firstFooter;
		return footer;
	}

	/**
	 * @return PBox
	 */
	public PContainer getHeader(int page)
	{
		if (page == 1)
			return firstHeader;
		return header;
	}

	/**
	 * @return PContainer
	 */
	public PContainer getFirstFooter()
	{
		return firstFooter;
	}

	/**
	 * @return PContainer
	 */
	public PContainer getFirstHeader()
	{
		return firstHeader;
	}

	/**
	 * @return PContainer
	 */
	public PContainer getFooter()
	{
		return footer;
	}

	/**
	 * @return PContainer
	 */
	public PContainer getHeader()
	{
		return header;
	}

	/**
	 * @return double
	 */
	public double getPageHeight()
	{
		return pageHeight;
	}

	/**
	 * @return double
	 */
	public double getPageWidth()
	{
		return pageWidth;
	}

	/**
	 * Sets the pageheight.
	 * 
	 * @param pageheight
	 *             The pageheight to set
	 */
	public void setPageHeight(double pageHeight)
	{
		this.pageHeight = pageHeight;
	}

	/**
	 * Sets the pageWidth.
	 * 
	 * @param pageWidth
	 *             The pageWidth to set
	 */
	public void setPageWidth(double pageWidth)
	{
		this.pageWidth = pageWidth;
	}

	/**
	 * If you have already set the first footer, you can use this method to make all footers equal to this first footer.
	 */
	public void setAllFootersLikeFirst()
	{
		footer = firstFooter;
	}

	/**
	 * If you have already set the first header, you can use this method to make all headers equal to this first header.
	 */
	public void setAllHeadersLikeFirst()
	{
		header = firstHeader;
	}

	/**
	 * @return
	 */
	public double getScale()
	{
		return scale;
	}
}