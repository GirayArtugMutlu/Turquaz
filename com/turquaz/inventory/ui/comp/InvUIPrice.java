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
import com.turquaz.inventory.Messages;


public class InvUIPrice {
	public String priceType=Messages.getString("InvUIPrice.0"); //$NON-NLS-1$
    public String amount="0.0"; //$NON-NLS-1$
    public String abrev ="YTL"; //$NON-NLS-1$
    public InvUIPrice(){
    	super();
    }
  

	/**
	 * @return String task description
	 */
	public String getPriceType() {
		return priceType;
	}

	/**
	 * @return String task owner
	 */
	public String getAmount() {
		return amount;
	}

	
	/**
	 * @return Returns the abrev.
	 */
	public String getAbrev() {
		return abrev;
	}
	/**
	 * @param abrev The abrev to set.
	 */
	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}
	/**
	 * @param amount The amount to set.
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @param priceType The priceType to set.
	 */
	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}
}
