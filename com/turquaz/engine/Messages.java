/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author onsel
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Messages {
	private static String BUNDLE_NAME = "com.turquaz.engine.messages";//$NON-NLS-1$

	/**
	 * @return Returns the bUNDLE_NAME.
	 */
	public static String getBUNDLE_NAME() {
		return BUNDLE_NAME;
	}

	private Messages() {
	}

	public static String getString(String key) {
		try {
			final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(
					BUNDLE_NAME, Locale.getDefault());

			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/**
	 * @param bundle_name
	 *            The bUNDLE_NAME to set.
	 */
	public static void setBUNDLE_NAME(String bundle_name) {
		BUNDLE_NAME = bundle_name;
	}
}