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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALCurrentCardUpdate;
import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

public class CurBLCurrentCardUpdate
{
	
	
	public static HashBag getCurrentcardInfo(HashMap argMap)throws Exception
	{
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard currentCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		HashBag currentBag = new HashBag();
		currentBag.put(CurKeys.CUR_CURRENT_CODE,currentCard.getCardsCurrentCode());
		currentBag.put(CurKeys.CUR_CURRENT_NAME,currentCard.getCardsName());
		currentBag.put(EngKeys.DEFINITION,currentCard.getCardsDefinition());
		currentBag.put(CurKeys.CUR_TAX_DEPARTMENT,currentCard.getCardsTaxDepartment());
		currentBag.put(CurKeys.CUR_DISCOUNT_RATE,currentCard.getCardsDiscountRate());
		currentBag.put(CurKeys.CUR_RISK_LIMIT,currentCard.getCardsRiskLimit());
		currentBag.put(CurKeys.CUR_TAX_NUMBER,currentCard.getCardsTaxNumber());
		currentBag.put(CurKeys.CUR_CREDIT_LIMIT,currentCard.getCardsCreditLimit());
		currentBag.put(CurKeys.CUR_DISCOUNT_PAYMENT,currentCard.getCardsDiscountPayment());
		currentBag.put(CurKeys.CUR_ADDRESS,currentCard.getCardsAddress());
		currentBag.put(CurKeys.CUR_DAYS_TO_VALUE,new Integer(currentCard.getDaysToValue()));
		
		currentBag.put(CurKeys.CUR_CONTACT_INFO,new HashMap());
		Iterator it = currentCard.getTurqCurrentContacts().iterator();
		if (it.hasNext())
		{
			TurqCurrentContact curContact = (TurqCurrentContact) it.next();
			
			currentBag.put(CurKeys.CUR_CONTACT_WEBSITE,curContact.getContactsWebSite());
			currentBag.put(CurKeys.CUR_CONTACT_NAME,curContact.getContactsName());
			currentBag.put(CurKeys.CUR_CONTACT_ADDRESS,curContact.getContactAddress());
			currentBag.put(CurKeys.CUR_CONTACT_EMAIL,curContact.getContactsEmail());
			currentBag.put(CurKeys.CUR_CONTACT_FAX_NUMBER,curContact.getContactsFaxNumber());
			currentBag.put(CurKeys.CUR_CONTACT_PHONE1,curContact.getContactsPhone1());
			currentBag.put(CurKeys.CUR_CONTACT_PHONE2,curContact.getContactsPhone2());		
		}
		
		
		currentBag.put(CurKeys.CUR_PHONE_NUMBER1,"0");
		currentBag.put(CurKeys.CUR_PHONE_CITY_CODE1,"0");
		currentBag.put(CurKeys.CUR_PHONE_COUNTRY_CODE1,"0");
		
		currentBag.put(CurKeys.CUR_PHONE_NUMBER2,"0");
		currentBag.put(CurKeys.CUR_PHONE_CITY_CODE2,"0");
		currentBag.put(CurKeys.CUR_PHONE_COUNTRY_CODE2,"0");
		

		List phoneList = new ArrayList(currentCard.getTurqCurrentCardsPhones()); 
		EngBLHibernateComparer comp = new EngBLHibernateComparer();
		Collections.sort(phoneList,comp);
		it = phoneList.iterator();
		int phones = 0;
		while (it.hasNext())
		{
			TurqCurrentCardsPhone currentPhone = (TurqCurrentCardsPhone) it.next();
			if (phones == 0)
			{
				phones++;
				currentBag.put(CurKeys.CUR_PHONE_NUMBER1,currentPhone.getPhonesNumber()+"");
				currentBag.put(CurKeys.CUR_PHONE_CITY_CODE1,currentPhone.getPhonesCityCode()+"");
				currentBag.put(CurKeys.CUR_PHONE_COUNTRY_CODE1,currentPhone.getPhonesCountryCode()+"");
			}
			else if (phones == 1)
			{
				currentBag.put(CurKeys.CUR_PHONE_NUMBER2,currentPhone.getPhonesNumber()+"");
				currentBag.put(CurKeys.CUR_PHONE_CITY_CODE2,currentPhone.getPhonesCityCode()+"");
				currentBag.put(CurKeys.CUR_PHONE_COUNTRY_CODE2,currentPhone.getPhonesCountryCode()+"");
				break;
			}
		}
		
		it = currentCard.getTurqCurrentAccountingAccounts().iterator();
		
		currentBag.put(CurKeys.CUR_ACCOUNTING_LIST,new HashMap());
		while (it.hasNext())
		{
			TurqCurrentAccountingAccount curAccount = (TurqCurrentAccountingAccount) it.next();
			Integer type = (Integer) curAccount.getTurqCurrentAccountingType().getId();
			currentBag.put(CurKeys.CUR_ACCOUNTING_LIST,type.intValue(),curAccount.getTurqAccountingAccount().getAccountCode());
				
		}
		
		it = currentCard.getTurqCurrentCardsGroups().iterator();
		currentBag.put(AdmKeys.ADM_GROUPS,new HashMap());
		int i=0;
		while (it.hasNext())
		{
			TurqCurrentCardsGroup currentCardGroup = (TurqCurrentCardsGroup) it.next();
			currentBag.put(AdmKeys.ADM_GROUPS,i,currentCardGroup.getTurqCurrentGroup().getId());
			i++;
		}		
		
		return currentBag;
	}
	

	public static void updateCurrentCard(HashMap argMap) throws Exception
	{

		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard currentCard=null;
		if(curCardId!=null)
		{
			currentCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		 String currentCode = (String)argMap.get(CurKeys.CUR_CURRENT_CODE);	
		 String cardName = (String)argMap.get(CurKeys.CUR_CURRENT_NAME);
		 String cardDefinition = (String)argMap.get(EngKeys.DEFINITION);
		 String cardAddress = (String)argMap.get(CurKeys.CUR_ADDRESS);
		 BigDecimal cardDiscountRate = (BigDecimal)argMap.get(CurKeys.CUR_DISCOUNT_RATE);
		 BigDecimal cardDiscountPayment = (BigDecimal)argMap.get(CurKeys.CUR_DISCOUNT_PAYMENT);
		 BigDecimal cardCreditLimit = (BigDecimal)argMap.get(CurKeys.CUR_CREDIT_LIMIT);
		 BigDecimal cardRiskLimit = (BigDecimal)argMap.get(CurKeys.CUR_RISK_LIMIT);
		 String cardTaxDepartment = (String)argMap.get(CurKeys.CUR_TAX_DEPARTMENT);
		 String cardTaxNumber = (String)argMap.get(CurKeys.CUR_TAX_NUMBER);
		 Integer daysToValue = (Integer)argMap.get(CurKeys.CUR_DAYS_TO_VALUE);
		 Map accountingAccounts = (Map)argMap.get(CurKeys.CUR_ACCOUNTING_LIST);
		 List phoneList = (List)argMap.get(CurKeys.CUR_PHONE_LIST);
		 Map contactInfo = (Map)argMap.get(CurKeys.CUR_CONTACT_INFO);
		 List groupList = (List) argMap.get(CurKeys.CUR_GROUP_LIST);
		 
		 
		 updateCurrentCardInfo(currentCard, currentCode, cardName, cardDefinition, cardAddress,
				cardDiscountRate, cardDiscountPayment, cardCreditLimit, cardRiskLimit, cardTaxDepartment,
				cardTaxNumber, daysToValue.intValue());
		updateCurrentCardAccounts(currentCard, accountingAccounts);
		updateCurrentCardPhones(currentCard, phoneList);
		updateCurrentCardContact(currentCard, contactInfo);
		updateCurrentCardGroups(currentCard, groupList);
		
		EngBLCurrentCards.RefreshContentAsistantMap();
	
	}

	private static void updateCurrentCardInfo(TurqCurrentCard currentCard, String currentCode, String cardName,
			String cardDefinition, String cardAddress, BigDecimal cardDiscountRate, BigDecimal cardDiscountPayment,
			BigDecimal cardCreditLimit, BigDecimal cardRiskLimit, String cardTaxDepartment, String cardTaxNumber, int daysToValue)
			throws Exception
	{
		try
		{
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
			Calendar cal = Calendar.getInstance();
			currentCard.setLastModified(cal.getTime());
			EngDALCommon.updateObject(currentCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateCurrentCardAccounts(TurqCurrentCard currentCard, Map accounts) throws Exception
	{
		deleteCurrentCardAccounts(currentCard);
		CurBLCurrentCardAdd.saveCurrentAccountingAccounts(currentCard, accounts);
	}

	private static void deleteCurrentCardAccounts(TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentAccountingAccounts().iterator();
		while (it.hasNext())
		{
			TurqCurrentAccountingAccount curAcc = (TurqCurrentAccountingAccount) it.next();
			EngDALCommon.deleteObject(curAcc);
		}
	}

	private static void updateCurrentCardPhones(TurqCurrentCard currentCard, List phoneList) throws Exception
	{
		deleteCurrentCardPhones(currentCard);
		CurBLCurrentCardAdd.saveCurrentCardPhones(currentCard.getId(), phoneList);
	}

	private static void deleteCurrentCardPhones(TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentCardsPhones().iterator();
		while (it.hasNext())
		{
			TurqCurrentCardsPhone curPhone = (TurqCurrentCardsPhone) it.next();
			EngDALCommon.deleteObject( curPhone);
		}
	}

	private static void updateCurrentCardContact(TurqCurrentCard currentCard, Map contactInfo) throws Exception
	{
		deleteCurrentCardContact(currentCard);
		CurBLCurrentCardAdd.saveCurrentCardContact(currentCard.getId(), contactInfo);
	}

	private static void deleteCurrentCardContact(TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentContacts().iterator();
		while (it.hasNext())
		{
			TurqCurrentContact curContact = (TurqCurrentContact) it.next();
			EngDALCommon.deleteObject(curContact);
		}
	}

	private static void updateCurrentCardGroups(TurqCurrentCard currentCard, List groupList) throws Exception
	{
		deleteCurrentCardGroups(currentCard);
		CurBLCurrentCardAdd.saveCurrentCardGroups(currentCard.getId(), groupList);
	}

	private static void deleteCurrentCardGroups(TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentCardsGroups().iterator();
		while (it.hasNext())
		{
			TurqCurrentCardsGroup curGroup = (TurqCurrentCardsGroup) it.next();
			EngDALCommon.deleteObject(curGroup);
		}
	}

	public static void deleteCurrentCard(HashMap argMap) throws Exception
	{

		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard currentCard=null;
		if(curCardId!=null)
		{
			currentCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
			deleteCurrentCardAccounts(currentCard);
			deleteCurrentCardContact(currentCard);
			deleteCurrentCardGroups(currentCard);
			deleteCurrentCardPhones(currentCard);
			CurDALSearchTransaction.deleteInitialTransactions(currentCard);
			EngDALCommon.deleteObject(currentCard);
			
			EngBLCurrentCards.RefreshContentAsistantMap();
	
	}



	public static List getCurrentTransactionBalances(HashMap argMap) throws Exception
	{

		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		Integer type = (Integer)argMap.get(EngKeys.TYPE);
		
			TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
			transType.setId(type);
			return CurDALCurrentCardUpdate.getCurrentTransactionBalances(transType, curCard);
		
	}

	
}