
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

import com.turquaz.current.Messages;
import com.turquaz.current.dal.CurDALCurrentCardAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentAccountingType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;


public class CurBLCurrentCardAdd {
	
	public CurBLCurrentCardAdd(){
	}
	
	
	private Calendar cal=Calendar.getInstance();
	private CurDALCurrentCardAdd currentAdd=new CurDALCurrentCardAdd();
	CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	public Integer saveCurrentCard(String currentCode, String cardName, String cardDefinition,
								String cardAddress, BigDecimal cardDiscountRate,
								BigDecimal cardDiscountPayment,	BigDecimal cardCreditLimit,
								BigDecimal cardRiskLimit, String cardTaxDepartment,
								String cardTaxNumber, Map accountingAccounts, int daysToValue) throws Exception {
		try{
		
		    
			TurqCurrentCard currentCard=new TurqCurrentCard();
			currentCard.setCardsCurrentCode(currentCode);
			currentCard.setCardsName(cardName);
			currentCard.setCardsDefinition(cardDefinition);
			currentCard.setCardsAddress(cardAddress);
			currentCard.setCardsDiscountRate(cardDiscountRate);
			currentCard.setCardsDiscountPayment(cardDiscountPayment);
			currentCard.setCardsCreditLimit(cardCreditLimit);
			currentCard.setCardsRiskLimit(cardRiskLimit);
			currentCard.setCardsTaxDepartment(cardTaxDepartment);
			currentCard.setCardsTaxNumber(cardTaxNumber);
		    currentCard.setDaysToValue(daysToValue);
		    
			currentCard.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			currentCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			currentCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			currentCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		
			currentAdd.saveObject(currentCard);	
		
			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR),0,1);
//	          TODO current trans exRate
			blTransAdd.saveCurrentTransaction(currentCard,
					cal.getTime(),"",false,new BigDecimal(0),new BigDecimal(0),
					EngBLCommon.CURRENT_TRANS_INITIAL,new Integer(-1),
					Messages.getString("CurBLCurrentCardAdd.3"),
					EngBLCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$ //$NON-NLS-2$
			
			saveCurrentAccountingAccounts(currentCard,accountingAccounts);
			
			//new CurBLCurrentTransactionAdd().saveInitialTransaction(currentCard);
			
			return currentCard.getId();
		}
		catch(Exception ex){
			throw ex;
		}
	}

	
	public void saveCurrentAccountingAccounts(TurqCurrentCard curCard, Map accounts)throws Exception{
	
		
		Iterator it = accounts.keySet().iterator();
		while(it.hasNext())
		{
			
			Integer type = (Integer)it.next();
			
			if(accounts.get(type)!=null)
			{
				
			
		    TurqCurrentAccountingAccount curAccount = new TurqCurrentAccountingAccount();
			
			curAccount.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			curAccount.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			curAccount.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			curAccount.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			curAccount.setTurqCurrentCard(curCard);
			curAccount.setTurqAccountingAccount((TurqAccountingAccount)accounts.get(type));
			
			TurqCurrentAccountingType accType = new TurqCurrentAccountingType();
			accType.setId(type);
			
			curAccount.setTurqCurrentAccountingType(accType);
			
			
			currentAdd.saveObject(curAccount);	
			
			
			
			}
			
			
			
		}
		
		
		
		
	}
	
public void saveCardPhone(int countryCode, int cityCode, int phoneNumber, Integer curCard)
throws Exception{
	
	try{
	TurqCurrentCardsPhone phone = new TurqCurrentCardsPhone();
	phone.setPhonesCityCode(cityCode);
	phone.setPhonesCountryCode(countryCode);
	phone.setPhonesNumber(phoneNumber);
	phone.setPhonesType(""); //$NON-NLS-1$
	TurqCurrentCard card = new TurqCurrentCard();
	card.setId(curCard);
	phone.setTurqCurrentCard(card);
	phone.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
	phone.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
	phone.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	phone.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
	
	currentAdd.saveObject(phone);	
	}
	catch(Exception ex){
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
	contact.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
	contact.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
	contact.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	contact.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
	currentAdd.saveObject(contact);
	
}

	
public void registerGroup(Integer cardId, Object grp) throws Exception {
		try {

			TurqCurrentCardsGroup cardGroup = new TurqCurrentCardsGroup();
			TurqCurrentGroup group = (TurqCurrentGroup) grp;
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(cardId);
			cardGroup.setTurqCurrentCard(card);
			cardGroup.setTurqCurrentGroup(group);

			cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cardGroup
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			currentAdd.saveObject(cardGroup);

		} catch (Exception ex) {
			throw ex;
		}

	}	
public List getCurrentGroups() throws Exception {

	try {

		return currentAdd.getCurrentGroups();

	} catch (Exception ex) {
		throw ex;
	}

}

public void deleteObject(Object obj)throws Exception{
	try{
		
	currentAdd.deleteObject(obj);	
		
		
	}
	catch(Exception ex){
		throw ex;
	}
}

public void saveCurGroup(String groupName, String groupDescription)
throws Exception {
try {
	
TurqCurrentGroup curGroup = new TurqCurrentGroup();

curGroup.setGroupsName(groupName);
curGroup.setGroupsDescription(groupDescription);

curGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
curGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
curGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
curGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

currentAdd.saveObject(curGroup);





} catch (Exception ex) {
throw ex;
}

}
public void updateObject(Object obj)throws Exception{
	try{
		
	currentAdd.updateObject(obj);	
		
	}
	catch(Exception ex){
		throw ex;
	}
	
}

public boolean isCurrentCodePresent(String Code)throws Exception{
try{
	
	return currentAdd.isCurrentCodePresent(Code);
}

catch(Exception ex){
throw ex;

}
}
public boolean isCurrentNamePresent(String name)throws Exception{
	try{
		
		return currentAdd.isCurrentNamePresent(name);
	}

	catch(Exception ex){
	throw ex;

	}
	}
	

}
