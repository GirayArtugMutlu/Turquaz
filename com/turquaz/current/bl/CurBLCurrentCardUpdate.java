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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.current.dal.CurDALCurrentCardUpdate;
import com.turquaz.current.dal.CurDALSearchTransaction;
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
	public CurBLCurrentCardUpdate()
	{
	}

	public static void updateCurrentCard(TurqCurrentCard currentCard, String currentCode, String cardName, String cardDefinition,
			String cardAddress, BigDecimal cardDiscountRate, BigDecimal cardDiscountPayment, BigDecimal cardCreditLimit,
			BigDecimal cardRiskLimit, String cardTaxDepartment, String cardTaxNumber, int daysToValue, Map accountingAccounts,
			List phoneList, Map contactInfo, List groupList) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			updateCurrentCardInfo(session, currentCard, currentCode, cardName, cardDefinition, cardAddress, cardDiscountRate,
					cardDiscountPayment, cardCreditLimit, cardRiskLimit, cardTaxDepartment, cardTaxNumber, daysToValue);
			updateCurrentCardAccounts(session, currentCard, accountingAccounts);
			updateCurrentCardPhones(session, currentCard, phoneList);
			updateCurrentCardContact(session, currentCard, contactInfo);
			session.flush();
			tx.commit();
			session.close();
		}
		catch (Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	}

	public static void updateCurrentCardInfo(Session session, TurqCurrentCard currentCard, String currentCode, String cardName,
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
			EngDALCommon.updateObject(session, currentCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateCurrentCardAccounts(Session session, TurqCurrentCard currentCard, Map accounts) throws Exception
	{
		deleteCurrentCardAccounts(session, currentCard);
		session.flush();
		CurBLCurrentCardAdd.saveCurrentAccountingAccounts(session, currentCard, accounts);
	}

	public static void deleteCurrentCardAccounts(Session session, TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentAccountingAccounts().iterator();
		while (it.hasNext())
		{
			TurqCurrentAccountingAccount curAcc = (TurqCurrentAccountingAccount) it.next();
			EngDALCommon.deleteObject(session, curAcc);
		}
	}

	public static void updateCurrentCardPhones(Session session, TurqCurrentCard currentCard, List phoneList) throws Exception
	{
		deleteCurrentCardPhones(session, currentCard);
		session.flush();
		CurBLCurrentCardAdd.saveCurrentCardPhones(session, currentCard.getId(), phoneList);
	}

	public static void deleteCurrentCardPhones(Session session, TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentCardsPhones().iterator();
		while (it.hasNext())
		{
			TurqCurrentCardsPhone curPhone = (TurqCurrentCardsPhone) it.next();
			EngDALCommon.deleteObject(session, curPhone);
		}
	}

	public static void updateCurrentCardContact(Session session, TurqCurrentCard currentCard, Map contactInfo) throws Exception
	{
		deleteCurrentCardContact(session, currentCard);
		session.flush();
		CurBLCurrentCardAdd.saveCurrentCardContact(session, currentCard.getId(), contactInfo);
	}

	public static void deleteCurrentCardContact(Session session, TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentContacts().iterator();
		while (it.hasNext())
		{
			TurqCurrentContact curContact = (TurqCurrentContact) it.next();
			EngDALCommon.deleteObject(session, curContact);
		}
	}

	public static void updateCurrentCardGroups(Session session, TurqCurrentCard currentCard, List groupList) throws Exception
	{
		deleteCurrentCardGroups(session, currentCard);
		session.flush();
		CurBLCurrentCardAdd.saveCurrentCardGroups(session, currentCard.getId(), groupList);
	}

	public static void deleteCurrentCardGroups(Session session, TurqCurrentCard currentCard) throws Exception
	{
		Iterator it = currentCard.getTurqCurrentCardsGroups().iterator();
		while (it.hasNext())
		{
			TurqCurrentCardsGroup curGroup = (TurqCurrentCardsGroup) it.next();
			EngDALCommon.deleteObject(session, curGroup);
		}
	}

	public static void deleteCurrentCard(TurqCurrentCard currentCard) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			deleteCurrentCardAccounts(session, currentCard);
			deleteCurrentCardContact(session, currentCard);
			deleteCurrentCardGroups(session, currentCard);
			deleteCurrentCardPhones(session, currentCard);
			CurDALSearchTransaction.deleteInitialTransactions(session, currentCard);
			EngDALCommon.deleteObject(session, currentCard);
			session.flush();
			tx.commit();
			session.close();
		}
		catch (Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	}

	public static List getCurrentGroups() throws Exception
	{
		try
		{
			return CurDALCurrentCardUpdate.getCurrentGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentTransactionBalances(TurqCurrentCard curCard, int type) throws Exception
	{
		try
		{
			TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
			transType.setId(new Integer(type));
			return CurDALCurrentCardUpdate.getCurrentTransactionBalances(transType, curCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteObject(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}