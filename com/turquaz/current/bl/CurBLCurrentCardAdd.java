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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALCurrentCardAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentAccountingType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;

public class CurBLCurrentCardAdd
{

	public static void saveCurrentCard(HashMap argMap) throws Exception
	{	
		
		String currentCode = (String) argMap.get(CurKeys.CUR_CURRENT_CODE);
		String cardName = (String) argMap.get(CurKeys.CUR_CURRENT_NAME);
		String cardDefinition = (String) argMap.get(EngKeys.DEFINITION);
		String cardAddress = (String) argMap.get(CurKeys.CUR_ADDRESS);
		BigDecimal cardDiscountRate = (BigDecimal) argMap.get(CurKeys.CUR_DISCOUNT_RATE);
		BigDecimal cardDiscountPayment = (BigDecimal) argMap.get(CurKeys.CUR_DISCOUNT_PAYMENT);
		BigDecimal cardCreditLimit = (BigDecimal) argMap.get(CurKeys.CUR_CREDIT_LIMIT);
		BigDecimal cardRiskLimit = (BigDecimal) argMap.get(CurKeys.CUR_RISK_LIMIT);
		String cardTaxDepartment = (String) argMap.get(CurKeys.CUR_TAX_DEPARTMENT);
		String cardTaxNumber = (String) argMap.get(CurKeys.CUR_TAX_NUMBER);
		Integer daysToValue = (Integer) argMap.get(CurKeys.CUR_DAYS_TO_VALUE);
		Map accountingAccounts = (Map) argMap.get(CurKeys.CUR_ACCOUNTING_LIST);
		List phoneList = (List) argMap.get(CurKeys.CUR_PHONE_LIST);
		Map contactInfo = (Map) argMap.get(CurKeys.CUR_CONTACT_INFO);
		List groupList = (List) argMap.get(CurKeys.CUR_GROUP_LIST);
		
		TurqCurrentCard currentCard = registerCurrentCard(currentCode, cardName, cardDefinition, cardAddress,
				cardDiscountRate, cardDiscountPayment, cardCreditLimit, cardRiskLimit, cardTaxDepartment,
				cardTaxNumber, daysToValue.intValue());
		
		saveCurrentAccountingAccounts(currentCard, accountingAccounts);
		saveCurrentCardPhones(currentCard.getId(), phoneList);
		saveCurrentCardContact(currentCard.getId(), contactInfo);
		saveCurrentCardGroups(currentCard.getId(), groupList);
		createInitialTransaction(currentCard);
		
	}

	private static TurqCurrentCard registerCurrentCard(String currentCode, String cardName, String cardDefinition,
			String cardAddress, BigDecimal cardDiscountRate, BigDecimal cardDiscountPayment, BigDecimal cardCreditLimit,
			BigDecimal cardRiskLimit, String cardTaxDepartment, String cardTaxNumber, int daysToValue) throws Exception
	{
		try
		{
			TurqCurrentCard currentCard = new TurqCurrentCard();
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
			Calendar cal = Calendar.getInstance();
			currentCard.setLastModified(cal.getTime());
			currentCard.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(currentCard);
			return currentCard;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void createInitialTransaction(TurqCurrentCard currentCard) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			CurBLCurrentTransactionAdd.saveCurrentTransaction(currentCard, cal.getTime(), "", false, new BigDecimal(0),
					new BigDecimal(0), EngBLCommon.CURRENT_TRANS_INITIAL, new Integer(-1), "",
					EngDALCommon.getBaseCurrencyExchangeRate());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveCurrentCardPhones(Integer curCardId, List phoneList) throws Exception
	{
		for (int k = 0; k < phoneList.size(); k++)
		{
			int[] phoneInfo = (int[]) phoneList.get(k);
			registerCurrentCardPhone(curCardId, phoneInfo[0], phoneInfo[1], phoneInfo[2]);
		}
	}

	public static void registerCurrentCardPhone(Integer curCardId, int countryCode, int cityCode, int phoneNumber)
			throws Exception
	{
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
			Calendar cal = Calendar.getInstance();
			phone.setLastModified(cal.getTime());
			phone.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(phone);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveCurrentAccountingAccounts(TurqCurrentCard curCard, Map accounts) throws Exception
	{
		Iterator it = accounts.keySet().iterator();
		while (it.hasNext())
		{
			Integer type = (Integer) it.next();
			if (accounts.get(type) != null)
			{
				TurqCurrentAccountingAccount curAccount = new TurqCurrentAccountingAccount();
				curAccount.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
				curAccount.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				Calendar cal = Calendar.getInstance();
				curAccount.setLastModified(cal.getTime());
				curAccount.setCreationDate(cal.getTime());
				curAccount.setTurqCurrentCard(curCard);
				
				TurqAccountingAccount account = new TurqAccountingAccount();
				account.setId((Integer) accounts.get(type));
				curAccount.setTurqAccountingAccount(account);
				TurqCurrentAccountingType accType = new TurqCurrentAccountingType();
				accType.setId(type);
				curAccount.setTurqCurrentAccountingType(accType);
				EngDALCommon.saveObject(curAccount);
			}
		}
	}

	public static void saveCurrentCardContact(Integer currentCardId, Map contactInfo) throws Exception
	{
		TurqCurrentCard card = new TurqCurrentCard();
		card.setId(currentCardId);
		TurqCurrentContact contact = new TurqCurrentContact();
		contact.setContactsName((String) contactInfo.get("ContactName"));
		contact.setContactAddress((String) contactInfo.get("ContactAddress"));
		contact.setContactsPhone1((String) contactInfo.get("ContactPhone"));
		contact.setContactsPhone2((String) contactInfo.get("ContactPhone2"));
		contact.setContactsFaxNumber((String) contactInfo.get("ContactFaxNumber"));
		contact.setContactsEmail((String) contactInfo.get("ContactEmail"));
		contact.setContactsWebSite((String) contactInfo.get("ContactWebSite"));
		contact.setTurqCurrentCard(card);
		contact.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		contact.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		Calendar cal = Calendar.getInstance();
		contact.setLastModified(cal.getTime());
		contact.setCreationDate(cal.getTime());
		EngDALCommon.saveObject(contact);
	}

	public static void saveCurrentCardGroups(Integer curCardId, List groupList) throws Exception
	{
		for (int k = 0; k < groupList.size(); k++)
		{
			TurqCurrentGroup curGroup = new TurqCurrentGroup();
			curGroup.setId((Integer)groupList.get(k));
			registerCurrentCardGroup(curCardId, curGroup);
		}
	}

	public static void registerCurrentCardGroup(Integer curCardId, TurqCurrentGroup group) throws Exception
	{
		try
		{
			TurqCurrentCardsGroup cardGroup = new TurqCurrentCardsGroup();
			TurqCurrentCard card = new TurqCurrentCard();
			card.setId(curCardId);
			cardGroup.setTurqCurrentCard(card);
			cardGroup.setTurqCurrentGroup(group);
			cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			cardGroup.setLastModified(cal.getTime());
			cardGroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(cardGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getCurrentGroups() throws Exception
	{
		try
		{
			HashBag  groupBag = new HashBag();
			groupBag.put(AdmKeys.ADM_GROUPS,new HashMap());
			
			List list = CurDALCurrentCardAdd.getCurrentGroups();
			 for(int i=0;i<list.size();i++)
			 {
				 TurqCurrentGroup group = (TurqCurrentGroup)list.get(i);
				 groupBag.put(AdmKeys.ADM_GROUPS,i,AdmKeys.ADM_GROUP_NAME,group.getGroupsName());
				 groupBag.put(AdmKeys.ADM_GROUPS,i,AdmKeys.ADM_GROUP_DESCRIPTION,group.getGroupsDescription());
				 groupBag.put(AdmKeys.ADM_GROUPS,i,AdmKeys.ADM_GROUP_ID,group.getId());
				 
			 }
			 
			 
			
			return groupBag; 
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	

	public static void saveCurrentGroup(HashMap argMap) throws Exception
	{
	
		 	String groupName = (String)argMap.get(CurKeys.CUR_GROUP_NAME);
		    String groupDescription = (String)argMap.get(EngKeys.DEFINITION);
			
			TurqCurrentGroup curGroup = new TurqCurrentGroup();
			curGroup.setGroupsName(groupName);
			curGroup.setGroupsDescription(groupDescription);
			curGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			curGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			curGroup.setLastModified(cal.getTime());
			curGroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(curGroup);
	
	}

	public static void updateGroup(HashMap argMap) throws Exception
	{
		Integer curGroupId = (Integer)argMap.get(CurKeys.CUR_GROUP_ID);
		TurqCurrentGroup invGroup = (TurqCurrentGroup)EngDALSessionFactory.getSession().load(TurqCurrentGroup.class,curGroupId);
		
		String name = (String)argMap.get(CurKeys.CUR_GROUP_NAME);
		String definition = (String)argMap.get(EngKeys.DEFINITION);
	
		Calendar cal = Calendar.getInstance();
		invGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		invGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		invGroup.setGroupsName(name);
		invGroup.setGroupsDescription(definition);
		EngDALCommon.updateObject(invGroup);
	}

	public static Boolean isCurrentCodePresent(HashMap argMap) throws Exception
	{
		String Code = (String)argMap.get(CurKeys.CUR_CURRENT_CODE);
		
		
			return new Boolean(CurDALCurrentCardAdd.isCurrentCodePresent(Code));
	
	}
	public static void deleteGroup(HashMap argMap)throws Exception
	{
		
		Integer groupId = (Integer)argMap.get(CurKeys.CUR_GROUP_ID);
		TurqCurrentGroup group = (TurqCurrentGroup)EngDALSessionFactory.getSession().load(TurqCurrentGroup.class,groupId);
		
		EngDALCommon.deleteObject(group);
		
	}

	public static Boolean isCurrentNamePresent(HashMap argMap) throws Exception
	{
		String name = (String)argMap.get(CurKeys.CUR_CURRENT_NAME);
			return new Boolean(CurDALCurrentCardAdd.isCurrentNamePresent(name));
		
	}
}