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

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolItem;

/**
 * Disposemanagement in RSSOwl
 * 
 * @author <a href="mailto:bpasero@rssowl.org">Benjamin Pasero </a>
 * @version 1.0
 */
public class DisposeListenerImpl implements DisposeListener {

	/** Singleton instance of DisposeListenerImpl */
	private static DisposeListenerImpl disposeListenerImpl;

	/**
	 * Protect this constructor
	 */
	private DisposeListenerImpl() {
	// Force to use static getInstance() Method
	}

	/**
	 * Singleton to retrieve either an existing instance of DisposeListenerImpl or
	 * a new created one.
	 * 
	 * @return DisposeListenerImpl An instance of DisposeListenerImpl
	 */
	public static DisposeListenerImpl getInstance() {
		if (disposeListenerImpl == null)
			disposeListenerImpl = new DisposeListenerImpl();
		return disposeListenerImpl;
	}

	/**
	 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
	 */
	public void widgetDisposed(DisposeEvent e) {

		/** Handle CLabel */
		if (e.widget instanceof CLabel) {
			if (((CLabel) e.widget).getImage() != null)
				((CLabel) e.widget).getImage().dispose();
		}

		/** Handle Label */
		if (e.widget instanceof Label) {
			if (((Label) e.widget).getImage() != null)
				((Label) e.widget).getImage().dispose();
		}

		/** Handle CTabItem */
		if (e.widget instanceof CTabItem) {
			if (((CTabItem) e.widget).getImage() != null)
				((CTabItem) e.widget).getImage().dispose();
		}

		/** Handle MenuItem */
		if (e.widget instanceof MenuItem) {
			if (((MenuItem) e.widget).getImage() != null)
				((MenuItem) e.widget).getImage().dispose();
		}

		/** Handle ToolItem */
		if (e.widget instanceof ToolItem) {
			if (((ToolItem) e.widget).getImage() != null)
				((ToolItem) e.widget).getImage().dispose();

			if (((ToolItem) e.widget).getDisabledImage() != null)
				((ToolItem) e.widget).getImage().dispose();
		}

		/** Handle Button */
		if (e.widget instanceof Button) {
			if (((Button) e.widget).getImage() != null)
				((Button) e.widget).getImage().dispose();
		}
	}
}