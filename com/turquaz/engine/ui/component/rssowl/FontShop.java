/*   **********************************************************************  **
 **	 	Copyright notice																											 **
 **                                                                          **
 **   (c) 2003-2004 RSSOwl Development Team                                  **
 **   http://www.rssowl.org/                                                 **
 **                                                                          **
 **   All rights reserved                                                    **
 **																																					 **
 **		This program and the accompanying materials are made available under 	 **
 **	 	the terms of the Common Public License v1.0 which accompanies this		 **
 **	 	distribution, and is available at:																		 **
 **		http://www.rssowl.org/legal/cpl-v10.html															 **
 **																																					 **
 **   A copy is found in the file cpl-v10.html and important notices to the  **
 **   license from the team is found in the textfile LICENSE.txt distributed **
 **   in this package.                                                       **
 **	 																																				 **
 **		This copyright notice MUST APPEAR in all copies of the file!					 **
 **																																					 **
 **	 	Contributors:																													 **
 **	  	RSSOwl - initial API and implementation (bpasero@rssowl.org)				 **
 **																																					 **
 **	 **********************************************************************	 */

package com.turquaz.engine.ui.component.rssowl;



import java.util.Locale;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import com.turquaz.engine.ui.EngUIMainFrame;

/**
 * Factory class for some Font / -style concerns in RSSOwl
 * 
 * @author <a href="mailto:bpasero@rssowl.org">Benjamin Pasero </a>
 * @version 1.0
 */
public class FontShop {

	
	public static final int DEFAULT_FONT_BASE = 0;

	/** Dialog bold font */
	public static Font dialogBoldFont = null;

	/** Font for the Dialogs */
	public static Font dialogFont = new Font(EngUIMainFrame.display, EngUIMainFrame.display.getSystemFont().getFontData()[0].getName(), EngUIMainFrame.display.getSystemFont().getFontData()[0].getHeight() + DEFAULT_FONT_BASE, 0);

	/** Font for the ViewForm headers and TabItem titles */
	public static Font headerFont = new Font(EngUIMainFrame.display, EngUIMainFrame.display.getSystemFont().getFontData()[0].getName(), EngUIMainFrame.display.getSystemFont().getFontData()[0].getHeight() + DEFAULT_FONT_BASE + 1, 0);

	/** Bold Font for the table holding news */
	public static Font tableBoldFont = null;

	/** Font for the table holding news */
	public static Font tableFont = new Font(EngUIMainFrame.display, EngUIMainFrame.display.getSystemFont().getFontData()[0].getName(), EngUIMainFrame.display.getSystemFont().getFontData()[0].getHeight() + DEFAULT_FONT_BASE, 0);

	/** Bold font for the Text */
	public static Font textBoldFont = null;

	/** Font for the newstext */
	public static Font textFont = new Font(EngUIMainFrame.display, EngUIMainFrame.display.getSystemFont().getFontData()[0].getName(), EngUIMainFrame.display.getSystemFont().getFontData()[0].getHeight() + DEFAULT_FONT_BASE + 1, 0);

	/** Font for the tree holding favorites (Bold) */
	public static Font treeBoldFont = null;

	/** Font for the tree holding favorites */
	public static Font treeFont = new Font(EngUIMainFrame.display, EngUIMainFrame.display.getSystemFont().getFontData()[0].getName(), EngUIMainFrame.display.getSystemFont().getFontData()[0].getHeight() + DEFAULT_FONT_BASE, 0);

	/** This utility class constructor is hidden */
	private FontShop() {
	//Protect default constructor
	}

	/** Dispose fonts */
	public static void disposeFonts() {
		if (isset(dialogBoldFont))
			dialogBoldFont.dispose();

		if (isset(dialogFont))
			dialogFont.dispose();

		if (isset(headerFont))
			headerFont.dispose();

		if (isset(tableFont))
			tableFont.dispose();

		if (isset(tableBoldFont))
			tableBoldFont.dispose();

		if (isset(textBoldFont))
			textBoldFont.dispose();

		if (isset(textFont))
			textFont.dispose();

		if (isset(treeFont))
			treeFont.dispose();

		if (isset(treeBoldFont))
			treeBoldFont.dispose();
	}

	/**
	 * Check the given Font for being NULL or disposed. Return false in that case.
	 * 
	 * @param font The font to check
	 * @return boolean TRUE if the font is available
	 */
	public static boolean isset(Font font) {
		return (font != null && !font.isDisposed());
	}

	

	/**
	 * Update styled fonts and the dialog font used by JFace dialogs
	 */
	public static void updateFonts() {
		initStyledFonts();
		JFaceResources.getFontRegistry().put(JFaceResources.DIALOG_FONT, FontShop.dialogFont.getFontData());
	}

	/**
	 * Init the bold font
	 */
	private static void initDialogBoldFont() {
		FontData[] fontData = dialogFont.getFontData();
		fontData[0].setStyle(SWT.BOLD);
		fontData[0].setLocale(Locale.getDefault().toString());
		dialogBoldFont = new Font(EngUIMainFrame.display, fontData);
	}

	/**
	 * Init all styled (bold) fonts
	 */
	private static void initStyledFonts() {
		initDialogBoldFont();
		initTableBoldFont();
		initTextBoldFont();
		initTreeBoldFont();
	}

	/**
	 * Init the table bold font
	 */
	private static void initTableBoldFont() {
		FontData[] fontData = tableFont.getFontData();
		fontData[0].setStyle(SWT.BOLD);
		fontData[0].setLocale(Locale.getDefault().toString());
		tableBoldFont = new Font(EngUIMainFrame.display, fontData);
	}

	/**
	 * Init the bold font
	 */
	private static void initTextBoldFont() {
		FontData[] fontData = textFont.getFontData();
		fontData[0].setStyle(SWT.BOLD);
		fontData[0].setLocale(Locale.getDefault().toString());
		textBoldFont = new Font(EngUIMainFrame.display, fontData);
	}

	/**
	 * Init the tree bold font
	 */
	private static void initTreeBoldFont() {
		FontData[] fontData = treeFont.getFontData();
		fontData[0].setStyle(SWT.BOLD);
		fontData[0].setLocale(Locale.getDefault().toString());
		treeBoldFont = new Font(EngUIMainFrame.display, fontData);
	}
}