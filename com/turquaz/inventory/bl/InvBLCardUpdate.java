
package com.turquaz.inventory.bl;

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


import java.math.BigDecimal;
import java.util.Calendar;

import com.turquaz.engine.dal.TurqAccountingAccount;

import com.turquaz.engine.dal.TurqInventoryCard;

import com.turquaz.inventory.dal.InvDALCardUpdate;


public class InvBLCardUpdate {
	private InvDALCardUpdate cardUpdate = new InvDALCardUpdate();

	Calendar cal = Calendar.getInstance();
   
	public InvBLCardUpdate(){
		
	}
	/**
	 * 
	 * @param invCode
	 * @param invSpecialCode
	 * @param cardName
	 * @param cardDefinition
	 * @param minAmount
	 * @param maxAmount
	 * @param cardVat
	 * @param discount
	 * @param accountIdBuy
	 * @param accountIdSell
	 * @param card
	 * @throws Exception
	 */
	public void updateInvCard(String invCode, String cardName, String cardDefinition, int minAmount,
			int maxAmount, int cardVat, int discount,TurqAccountingAccount accountBuy,
			TurqAccountingAccount accountSell,int cardSpecialVat, BigDecimal cardSpecialVatEach,
			TurqInventoryCard card,TurqAccountingAccount accountVAT, TurqAccountingAccount accountSpecialVAT,
			TurqAccountingAccount accountVATSell, TurqAccountingAccount accountSpecialVATSell) throws Exception{
		try {

		

			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardVat(cardVat);
			card.setCardSpecialVat(cardSpecialVat);
			card.setCardSpecialVatEach(cardSpecialVatEach);
		
			card.setUpdatedBy(System.getProperty("user"));
			card.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
		
			card.setTurqAccountingAccountByAccountingAccountsIdBuy(accountBuy);
			card.setTurqAccountingAccountByAccountingAccountsIdSell(accountSell);
		    card.setTurqAccountingAccountByAccountingAccountsIdSpecialVat(accountSpecialVAT);
		    card.setTurqAccountingAccountByAccountingAccountsIdVat(accountVAT);
            card.setTurqAccountingAccountByAccountingAccountsIdSpecialVatSell(accountSpecialVATSell);
            card.setTurqAccountingAccountByAccountingAccountsIdVatSell(accountVATSell);
            
		    
			cardUpdate.updateObject(card);


		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param obj Serializable object
	 */
	
	public void deleteObject(Object obj)throws Exception{
 		try{
			
 			cardUpdate.deleteObject(obj);
 			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public boolean hasTransactions (TurqInventoryCard card) throws Exception{
		
		try{	
			
		return cardUpdate.hasTransactions(card);
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	

}
