/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui.comp;

import com.turquaz.inventory.Messages;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
