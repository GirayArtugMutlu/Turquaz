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


import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;


/**
 * Factory class for some Paint / Icon concerns in RSSOwl
 * 
 * @author <a href="mailto:bpasero@rssowl.org">Benjamin Pasero </a>
 * @version 1.0
 */
public class PaintShop {

	/** Gray ViewForm color */
	public static Color grayViewFormColor = new Color(Display.getCurrent(), 241, 240, 234);

	/** Make the headerColor accessible from all Objects */
	public static Color headerColor;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconAddToFavorites;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconBackward;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconBlueStripes;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconCancelOperation;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconCancelOperationDisabled;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconCopy;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconError;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconErrorLense;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconFind;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconFolder;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconFolderSubscribe;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconFolderSubscribeUnread;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconFolderUnread;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconForward;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconHTML;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconLense;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconLenseUnread;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconMail;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconNotRated;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconOwl[] = new Image[4];

	/** Some multiple used Icons in RSSOwl */
	public static Image iconPDF;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconPrint;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconRateSuccess;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconRead;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconReload;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconReloadBrowser;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconRTF;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconSearch;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconSkip;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconSkipDisabled;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconStop;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconUnread;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconValidate;

	/** Some multiple used Icons in RSSOwl */
	public static Image iconWarning;

	/** Make the linkColor accessible from all Objects */
	public static Color linkColor;

	/** Make the syntaxHighlightColor accessible from all Objects */
	public static Color syntaxHighlightColor;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress0;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress100;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress20;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress40;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress60;

	/** Some multiple used Icons in RSSOwl */
	private static Image iconProgress80;

	/** This utility class constructor is hidden */
	private PaintShop() {
	// Protect default constructor
	}

	/** Dispose icons */
	public static void disposeIcons() {
		iconFolder.dispose();
		iconFolderUnread.dispose();
		iconFolderSubscribe.dispose();
		iconFolderSubscribeUnread.dispose();
		iconLense.dispose();
		iconLenseUnread.dispose();
		iconErrorLense.dispose();
		iconForward.dispose();
		iconBackward.dispose();
		iconStop.dispose();
		iconPDF.dispose();
		iconRTF.dispose();
		iconHTML.dispose();
		iconCopy.dispose();
		iconPrint.dispose();
		iconSearch.dispose();
		iconReload.dispose();
		iconFind.dispose();
		iconAddToFavorites.dispose();
		iconMail.dispose();
		iconReloadBrowser.dispose();
		iconRead.dispose();
		iconCancelOperation.dispose();
		iconCancelOperationDisabled.dispose();
		iconSkip.dispose();
		iconNotRated.dispose();
		iconSkipDisabled.dispose();
		iconRateSuccess.dispose();
		iconBlueStripes.dispose();
		iconProgress0.dispose();
		iconProgress20.dispose();
		iconProgress40.dispose();
		iconProgress60.dispose();
		iconProgress80.dispose();
		iconProgress100.dispose();
		iconUnread.dispose();
		headerColor.dispose();
		grayViewFormColor.dispose();
		linkColor.dispose();
		syntaxHighlightColor.dispose();

		/** Application icons */
		for (int a = 0; a < iconOwl.length; a++)
			iconOwl[a].dispose();
	}

	/**
	 * Fill an Image with a given color
	 * 
	 * @param display The display as device for the color
	 * @param color The color to display
	 * @param width Width of the image
	 * @param height Height of the image
	 * @return Image Filled image
	 */
	public static Image getFilledImage(Display display, RGB color, int width, int height) {
		Image filledImage = new Image(display, width, height);
		Color selectedColor = new Color(display, color);

		/** Paint the image */
		GC gc = new GC(filledImage);
		gc.setBackground(selectedColor);
		gc.fillRectangle(0, 0, width, height);
		gc.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.drawRectangle(0, 0, width - 1, height - 1);

		/** Cleanup */
		gc.dispose();
		selectedColor.dispose();

		return filledImage;
	}

	/**
	 * Get the correct flag for the given language. If a flag for the given
	 * language is not found, return the "unknown" flag.
	 * 
	 * @param locale The language
	 * @param curClass Current class
	 * @return An image that displays the flag
	 */
	

	/**
	 * Get the progress icon for the given value.
	 * 
	 * @param value The value (20, 40, 60, 80, 100)
	 * @return Image The image of the progress bar
	 */
	public static Image getProgressIcon(int value) {
		switch (value) {

			/** Progress Bar indicating 0% */
			case 0:
				return iconProgress0;

			/** Progress Bar indicating 20% */
			case 20:
				return iconProgress20;

			/** Progress Bar indicating 40% */
			case 40:
				return iconProgress40;

			/** Progress Bar indicating 60% */
			case 60:
				return iconProgress60;

			/** Progress Bar indicating 80% */
			case 80:
				return iconProgress80;

			/** Progress Bar indicating 100% */
			case 100:
				return iconProgress100;

			/** Default Progress Bar indicating 0% */
			default:
				return iconProgress0;
		}
	}

	/**
	 * Set the color for the header of the ViewForms in RSSOwl
	 * 
	 * @param display The display
	 */
	public static void initHeaderColor(Display display) {
		headerColor = new Color(display, GlobalSettings.headerColor);
	}

	/**
	 * Initialize the multiple used icons
	 * 
	 * @param display The display
	 * @param mainClass to access the JAR
	 */
	public static void initIcons(Display display, Class mainClass) {

		/** Single used icons */
		iconFolder = new Image(display, mainClass.getResourceAsStream("/icons/folder.gif"));
		iconFolderUnread = new Image(display, mainClass.getResourceAsStream("/icons/folder_unread.gif"));
		iconFolderSubscribe = new Image(display, mainClass.getResourceAsStream("/icons/folder_subscribe.gif"));
		iconFolderSubscribeUnread = new Image(display, mainClass.getResourceAsStream("/icons/folder_subscribe_unread.gif"));
		iconLense = new Image(display, mainClass.getResourceAsStream("/icons/feed.gif"));
		iconLenseUnread = new Image(display, mainClass.getResourceAsStream("/icons/feed_unread.gif"));
		iconErrorLense = new Image(display, mainClass.getResourceAsStream("/icons/feed_error.gif"));
		iconForward = new Image(display, mainClass.getResourceAsStream("/icons/forward.gif"));
		iconBackward = new Image(display, mainClass.getResourceAsStream("/icons/backward.gif"));
		iconStop = new Image(display, mainClass.getResourceAsStream("/icons/stop.gif"));
		iconWarning = new Image(display, mainClass.getResourceAsStream("/icons/warning.gif"));
		iconError = new Image(display, mainClass.getResourceAsStream("/icons/error_round.gif"));
		iconPDF = new Image(display, mainClass.getResourceAsStream("/icons/pdf.gif"));
		iconRTF = new Image(display, mainClass.getResourceAsStream("/icons/rtf.gif"));
		iconHTML = new Image(display, mainClass.getResourceAsStream("/icons/html.gif"));
		iconCopy = new Image(display, mainClass.getResourceAsStream("/icons/copy.gif"));
		iconPrint = new Image(display, mainClass.getResourceAsStream("/icons/print.gif"));
		iconSearch = new Image(display, mainClass.getResourceAsStream("/icons/search_feed.gif"));
		iconReload = new Image(display, mainClass.getResourceAsStream("/icons/reload.gif"));
		iconFind = new Image(display, mainClass.getResourceAsStream("/icons/search.gif"));
		iconAddToFavorites = new Image(display, mainClass.getResourceAsStream("/icons/add_feed.gif"));
		iconMail = new Image(display, mainClass.getResourceAsStream("/icons/mail.gif"));
		iconReloadBrowser = new Image(display, mainClass.getResourceAsStream("/icons/reload_browser.gif"));
		iconRead = new Image(display, mainClass.getResourceAsStream("/icons/read.gif"));
		iconUnread = new Image(display, mainClass.getResourceAsStream("/icons/unread.gif"));
		iconCancelOperation = new Image(display, mainClass.getResourceAsStream("/icons/cancel_operation.gif"));
		iconCancelOperationDisabled = new Image(display, mainClass.getResourceAsStream("/icons/cancel_operation_disabled.gif"));
		iconValidate = new Image(display, mainClass.getResourceAsStream("/icons/validate.gif"));
		iconSkip = new Image(display, mainClass.getResourceAsStream("/icons/skip.gif"));
		iconSkipDisabled = new Image(display, mainClass.getResourceAsStream("/icons/skip_disabled.gif"));
		iconRateSuccess = new Image(display, mainClass.getResourceAsStream("/icons/rate_success.gif"));
		iconNotRated = new Image(display, mainClass.getResourceAsStream("/icons/rate_norate.gif"));
		iconBlueStripes = new Image(display, mainClass.getResourceAsStream("/icons/pref.gif"));

		/** Progress icons */
		iconProgress0 = new Image(display, mainClass.getResourceAsStream("/icons/progress0.gif"));
		iconProgress20 = new Image(display, mainClass.getResourceAsStream("/icons/progress20.gif"));
		iconProgress40 = new Image(display, mainClass.getResourceAsStream("/icons/progress40.gif"));
		iconProgress60 = new Image(display, mainClass.getResourceAsStream("/icons/progress60.gif"));
		iconProgress80 = new Image(display, mainClass.getResourceAsStream("/icons/progress80.gif"));
		iconProgress100 = new Image(display, mainClass.getResourceAsStream("/icons/progress100.gif"));

	
	}

	/**
	 * Set the color for the links
	 * 
	 * @param display The display
	 */
	public static void initLinkColor(Display display) {
		linkColor = new Color(display, GlobalSettings.linkColor);
	}

	/**
	 * Set the color for the syntaxhighlight
	 * 
	 * @param display The display
	 */
	public static void initSyntaxHighlightColor(Display display) {
		syntaxHighlightColor = new Color(display, GlobalSettings.syntaxHighlightColor);
	}

	/**
	 * Check the given Image for being NULL or disposed. Return false in that
	 * case.
	 * 
	 * @param image The image to check
	 * @return boolean TRUE if the Image is available
	 */
	public static boolean isset(Image image) {
		return (image != null && !image.isDisposed());
	}
}