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


import org.eclipse.swt.graphics.RGB;

/**
 * This class holds some settings the user has made in RSSOwl. A lot of Objects
 * in RSSOwl need to access them, thats why they are declared public and static.
 * Also contains some constants that are used in the application.
 * 
 * @author <a href="mailto:bpasero@rssowl.org">Benjamin Pasero </a>
 * @version 1.0
 */
public class GlobalSettings {


	/**
	 * Selected header color
	 */
	public static RGB headerColor = new RGB(224, 232, 246);
	public static RGB syntaxHighlightColor =new RGB(224, 232, 246) ;
	public static RGB linkColor = new RGB(224, 232, 246);

	
}