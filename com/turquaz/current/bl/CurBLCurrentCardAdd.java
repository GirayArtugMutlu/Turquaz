
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

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.current.dal.CurDALCurrentCardAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
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
	
	private CurDALCurrentCardAdd currentAdd=new CurDALCurrentCardAdd();
	//TODO remove private static
	private static CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	
	public static void saveCurrentCard(String currentCode, String cardName,
			String cardDefinition,String cardAddress, BigDecimal cardDiscountRate,
			BigDecimal cardDiscountPayment,	BigDecimal cardCreditLimit,
			BigDecimal cardRiskLimit, String cardTaxDepartment,
			String cardTaxNumber, int daysToValue, Map accountingAccounts,
			List phoneList, Map contactInfo, List groupList)
	throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{		
			TurqCurrentCard currentCard=registerCurrentCard(session,currentCode,
					cardName,cardDefinition,cardAddress,cardDiscountRate,
					cardDiscountPayment,cardCreditLimit,cardRiskLimit,
					cardTaxDepartment,cardTaxNumber,daysToValue);
			
			session.flush();
			
			saveCurrentAccountingAccounts(session,currentCard,accountingAccounts);
			saveCurrentCardPhones(session,currentCard.getId(),phoneList);
			saveCurrentCardContact(session,currentCard.getId(),contactInfo);
			saveCurrentCardGroups(session,currentCard.getId(),groupList);
	
			
			session.flush();
			tx.commit();
			
			session.close();
//			TODO SESSIONNNN
			createInitialTransaction(currentCard);
			
		}
		catch(Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	}	
	
	public static TurqCurrentCard registerCurrentCard(Session session, String currentCode, 
			String cardName, String cardDefinition,String cardAddress, 
			BigDecimal cardDiscountRate,BigDecimal cardDiscountPayment,
			BigDecimal cardCreditLimit,	BigDecimal cardRiskLimit, 
			String cardTaxDepartment,String cardTaxNumber,int daysToValue)
		throws Exception
	{
		try
		{	    
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
			
			Calendar cal=Calendar.getInstance();
			currentCard.setLastModified(cal.getTime());
			currentCard.setCreationDate(cal.getTime());
		
			CurDALCurrentCardAdd.saveObject(session,currentCard);	
			return currentCard;

		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static void createInitialTransaction(TurqCurrentCard currentCard)
	throws Exception
	{
		try
		{
			Calendar cal=Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR),0,1);
			blTransAdd.saveCurrentTransaction(currentCard,
				cal.getTime(),"",false,new BigDecimal(0),new BigDecimal(0),
				EngBLCommon.CURRENT_TRANS_INITIAL,new Integer(-1),
				"sads",
				//Messages.getString("CurBLCurrentCardAdd.3"),//$NON-NLS-1$ //$NON-NLS-2$
				EngBLCommon.getBaseCurrencyExchangeRate()); 
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public static void saveCurrentCardPhones(Session session,
			Integer curCardId, List phoneList)
	throws Exception
	{
		for(int k=0; k<phoneList.size(); k++)
		{
			int[] phoneInfo=(int[])phoneList.get(k);
			registerCurrentCardPhone(session,curCardId,phoneInfo[0],phoneInfo[1],phoneInfo[2]);
		}
		
	}
	
	public static void registerCurrentCardPhone(Session session,Integer curCardId,
			int countryCode, int cityCode, int phoneNumber)
	throws Exception{
		
		try
		{
			TurqCurrentCardsPhone phone = new TurqCurrentCardsPhone();
			phone.setPhonesCityCode(cityCode);
			phone.setPhonesCountryCode(countryCode);
			phone.setPhonesNumber(phoneNumber);
			phone.setPhonesType(""); //$NON-NLS-1$
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(curCardId);
			phone.setTurqCurrentCard(card);
			phone.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			phone.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			
			Calendar cal=Calendar.getInstance();
			phone.setLastModified(cal.getTime());
			phone.setCreationDate(cal.getTime());
		
			CurDALCurrentCardAdd.saveObject(session, phone);	
		}
		catch(Exception ex)
		{
			throw ex;
		}	
	}


	
	public static void saveCurrentAccountingAccounts(Session session,
			TurqCurrentCard curCard, Map accounts)
	throws Exception
	{
		Iterator it = accounts.keySet().iterator();
		while(it.hasNext())
		{			
			Integer type = (Integer)it.next();			
			if(accounts.get(type)!=null)
			{
				TurqCurrentAccountingAccount curAccount = new TurqCurrentAccountingAccount();
			
				curAccount.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
				curAccount.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				
				Calendar cal=Calendar.getInstance();
				curAccount.setLastModified(cal.getTime());
				curAccount.setCreationDate(cal.getTime());
			
				curAccount.setTurqCurrentCard(curCard);
				curAccount.setTurqAccountingAccount((TurqAccountingAccount)accounts.get(type));
			
				TurqCurrentAccountingType accType = new TurqCurrentAccountingType();
				accType.setId(type);
			
				curAccount.setTurqCurrentAccountingType(accType);			
				CurDALCurrentCardAdd.saveObject(session,curAccount);			
			}			
		}		
	}
	
	
	public static void saveCurrentCardContact(Session session, Integer currentCardId,
			Map contactInfo)throws Exception
	{
		
		TurqCurrentCard card = new TurqCurrentCard();
		card.setId(currentCardId);
		TurqCurrentContact contact = new TurqCurrentContact();
		contact.setContactsName((String)contactInfo.get("ContactName"));
		contact.setContactAddress((String)contactInfo.get("ContactAddress"));
		contact.setContactsPhone1((String)contactInfo.get("ContactPhone"));
		contact.setContactsPhone2((String)contactInfo.get("ContactPhone2"));
		contact.setContactsFaxNumber((String)contactInfo.get("ContactFaxNumber"));
		contact.setContactsEmail((String)contactInfo.get("ContactEmail"));
		contact.setContactsWebSite((String)contactInfo.get("ContactWebSite"));
		contact.setTurqCurrentCard(card);
		contact.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		contact.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		
		Calendar cal=Calendar.getInstance();
		contact.setLastModified(cal.getTime());
		contact.setCreationDate(cal.getTime());
		CurDALCurrentCardAdd.saveObject(session, contact);
		
	}
	
	public static void saveCurrentCardGroups(Session session, Integer curCardId,
			List groupList) throws Exception
	{
		for(int k=0; k<groupList.size(); k++)
		{
			TurqCurrentGroup curGroup=(TurqCurrentGroup)groupList.get(k);
			registerCurrentCardGroup(session,curCardId,curGroup);
		}	
	}
	
	public static void registerCurrentCardGroup(Session session, Integer curCardId,
			TurqCurrentGroup group) throws Exception
	{
		try {

			TurqCurrentCardsGroup cardGroup = new TurqCurrentCardsGroup();
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(curCardId);
			cardGroup.setTurqCurrentCard(card);
			cardGroup.setTurqCurrentGroup(group);

			cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				
			Calendar cal=Calendar.getInstance();
			cardGroup.setLastModified(cal.getTime());
			cardGroup.setCreationDate(cal.getTime());

			CurDALCurrentCardAdd.saveObject(session,cardGroup);

		} 
		catch (Exception ex)
		{
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
	
	public static void saveCurrentGroup(String groupName,
			String groupDescription)
	throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{	
			TurqCurrentGroup curGroup = new TurqCurrentGroup();

			curGroup.setGroupsName(groupName);
			curGroup.setGroupsDescription(groupDescription);

			curGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			curGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			
			Calendar cal=Calendar.getInstance();
			curGroup.setLastModified(cal.getTime());
			curGroup.setCreationDate(cal.getTime());
			
			CurDALCurrentCardAdd.saveObject(session,curGroup);	
			
			session.flush();
			tx.commit();
			session.close();
			
		}
		catch(Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	} 
	
	public void updateObject(Object obj)throws Exception
	{
		try
		{			
			currentAdd.updateObject(obj);				
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}

	public boolean isCurrentCodePresent(String Code)throws Exception
	{
		try
		{		
			return currentAdd.isCurrentCodePresent(Code);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public boolean isCurrentNamePresent(String name)throws Exception{
		try
		{			
			return currentAdd.isCurrentNamePresent(name);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
}
