
package com.turquaz.current.bl;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turquaz.current.dal.CurDALCurrentCardUpdate;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

public class CurBLCurrentCardUpdate {
	
	private CurDALCurrentCardUpdate currentUpdate=new CurDALCurrentCardUpdate();	
	private Calendar cal=Calendar.getInstance();
	
	public CurBLCurrentCardUpdate(){
		
	}
	
	public void updateCurrentCard(String currentCode, String cardName, String cardDefinition,
			String cardAddress, BigDecimal cardDiscountRate,
			BigDecimal cardDiscountPayment,	BigDecimal cardCreditLimit,
			BigDecimal cardRiskLimit, String cardTaxDepartment,
			String cardTaxNumber, Map AccountingAccounts,int daysToValue, TurqCurrentCard currentCard) throws Exception {
		try{
		    
			currentCard.setCardsCurrentCode(currentCode);
			currentCard.setCardsName(cardName);
			currentCard.setCardsDefinition(cardDefinition);
			currentCard.setCardsAddress(cardAddress);
			currentCard.setCardsDiscountRate(cardDiscountRate);
			currentCard.setCardsDiscountPayment(cardDiscountPayment);
			currentCard.setCardsCreditLimit(cardCreditLimit);
			currentCard.setDaysToValue(daysToValue);
			currentCard.setCardsRiskLimit(cardRiskLimit);
			currentCard.setCardsTaxDepartment(cardTaxDepartment);
			currentCard.setCardsTaxNumber(cardTaxNumber);
			
			
			currentCard.setUpdatedBy(System.getProperty("user"));
			currentCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			
			updateAccounts(currentCard,AccountingAccounts);
			currentUpdate.updateObject(currentCard);
			
	
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	public void updateAccounts(TurqCurrentCard curCard, Map accounts)throws Exception{
		
		Iterator it = curCard.getTurqCurrentAccountingAccounts().iterator();
		
		while(it.hasNext()){
			currentUpdate.deleteObject(it.next());
		}
		new CurBLCurrentCardAdd().saveCurrentAccountingAccounts(curCard,accounts);
		
		
		
		
	}
	
	
	public void saveCardPhone(int countryCode, int cityCode, int phoneNumber, Integer curCard)
	throws Exception{
		
		try{
			TurqCurrentCardsPhone phone = new TurqCurrentCardsPhone();
			phone.setPhonesCityCode(cityCode);
			phone.setPhonesCountryCode(countryCode);
			phone.setPhonesNumber(phoneNumber);
			phone.setPhonesType("");
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(curCard);
			phone.setTurqCurrentCard(card);
			phone.setCreatedBy(System.getProperty("user"));
			phone.setUpdatedBy(System.getProperty("user"));
			phone.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			phone.setCreationDate(new java.sql.Date(cal.getTime().getTime()));		
			currentUpdate.saveObject(phone);	
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public void registerGroup(Integer cardId, Object grp) throws Exception {
		try {

			TurqCurrentCardsGroup cardGroup = new TurqCurrentCardsGroup();
			TurqCurrentGroup group = (TurqCurrentGroup) grp;
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(cardId);
			cardGroup.setTurqCurrentCard(card);
			cardGroup.setTurqCurrentGroup(group);
			cardGroup.setCreatedBy(System.getProperty("user"));
			cardGroup.setUpdatedBy(System.getProperty("user"));
			cardGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cardGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			currentUpdate.saveObject(cardGroup);
		} 
		catch (Exception ex) {
			throw ex;
		}

	}	
	public List getCurrentGroups() throws Exception {

		try {
			return currentUpdate.getCurrentGroups();

		} catch (Exception ex) {
			throw ex;
		}

	}
	public void saveContact(Integer cardID, String name, String address, 
							String phone1, String phone2, String faxNumber,
							String email, String website)throws Exception
							{
		
		TurqCurrentCard card = new TurqCurrentCard();
		card.setId(cardID);
		TurqCurrentContact contact = new TurqCurrentContact();
		contact.setContactsName(name);
		contact.setContactAddress(address);
		contact.setContactsPhone1(phone1);
		contact.setContactsPhone2(phone2);
		contact.setContactsFaxNumber(faxNumber);
		contact.setContactsEmail(email);
		contact.setContactsWebSite(website);
		contact.setTurqCurrentCard(card);
		contact.setCreatedBy(System.getProperty("user"));
		contact.setUpdatedBy(System.getProperty("user"));
		contact.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		contact.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		currentUpdate.saveObject(contact);
	}
	
	public List getCurrentTransactionBalances(TurqCurrentCard curCard, int type)throws Exception{
	
		try{
		TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
		transType.setId(new Integer(type));
		
		return currentUpdate.getCurrentTransactionBalances(transType,curCard);
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public void deleteObject(Object obj) throws Exception{
 		try{
			
 			currentUpdate.deleteObject(obj); 			
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
