/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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


import java.util.Calendar;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.inventory.dal.InvDALCardSearch;
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
	public void updateInvCard(String invCode, String invSpecialCode,
			String cardName, String cardDefinition, int minAmount,
			int maxAmount, int cardVat, int discount, int accountIdBuy,
			int accountIdSell,TurqInventoryCard card) throws Exception{
		try {

		
			TurqAccountingAccount accountBuy = new TurqAccountingAccount();
			TurqAccountingAccount accountSell = new TurqAccountingAccount();
			accountBuy.setAccountingAccountsId(new Integer(accountIdBuy));
			accountSell.setAccountingAccountsId(new Integer(accountIdSell));

			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardSpecialCode(invSpecialCode);
			card.setCardVat(cardVat);
		
			card.setUpdatedBy(System.getProperty("user"));
			card.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
		
			card.setTurqAccountingAccountByAccountingAccountsIdBuy(accountBuy);
			card.setTurqAccountingAccountByAccountingAccountsIdSell(accountSell);
		

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
	
	

}
