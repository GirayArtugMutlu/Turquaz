/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui.comp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvUIPriceList {


	private Vector prices = new Vector();
	private Set changeListeners = new HashSet();

	// Combo box choices
	String[] CURRENCIES ;
	String[] PRICE_TYPES =new String[]{"Buy","Sell"};
	
	
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
