/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui.comp;

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.turquaz.inventory.Messages;


public class InvUIPriceList {


	private Vector prices = new Vector();
	private Set changeListeners = new HashSet();

	// Combo box choices
	String[] CURRENCIES ;
	String[] PRICE_TYPES =new String[]{Messages.getString("InvUIPriceList.0"),Messages.getString("InvUIPriceList.1")}; //$NON-NLS-1$ //$NON-NLS-2$
	
	
	/**
	 * Constructor
	 */
	public InvUIPriceList(String currencies[]) {
		super();
		CURRENCIES = currencies;
		
	}

	/**
	 * Return the array of owners   
	 */
	public String[] getCurrencies() {
		return CURRENCIES;
	}
	
	public String[] getPriceTypes(){
		return PRICE_TYPES;
	}
	
	/**
	 * Return the collection of tasks
	 */
	public Vector getPrices() {
		return prices;
	}
	
	/**
	 * Add a new task to the collection of tasks
	 */
	public void addPrice() {
		InvUIPrice price = new InvUIPrice();
		prices.add(prices.size(), price);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IPriceListViewer) iterator.next()).addPrice(price);
	}
	/**
	 * Add a new task to the collection of tasks
	 */
	public void addPrice(InvUIPrice price) {
		
		prices.add(prices.size(), price);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IPriceListViewer) iterator.next()).addPrice(price);
	}

	/**
	 * @param task
	 */
	public void removePrice(InvUIPrice price) {
		prices.remove(price);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IPriceListViewer) iterator.next()).removePrice(price);
	}

	/**
	 * @param task
	 */
	public void priceChanged(InvUIPrice price) {
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((IPriceListViewer) iterator.next()).updatePrice(price);
	}

	/**
	 * @param viewer
	 */
	public void removeChangeListener(IPriceListViewer viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(IPriceListViewer viewer) {
		changeListeners.add(viewer);
	}

}
