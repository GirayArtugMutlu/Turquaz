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
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.inventory.dal.InvDALCardUpdate;

public class InvBLCardUpdate
{
	public static void updateInventoryCard(String invCode, String cardName, String cardDefinition, int minAmount, int maxAmount,
			int cardVat, int discount, int cardSpecialVat, BigDecimal cardSpecialVatEach, TurqInventoryCard card, Map invGroups,
			List invCardUnits, List invPrices, List invAccounts) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			updateInvCard(session, invCode, cardName, cardDefinition, minAmount, maxAmount, cardVat, discount, cardSpecialVat,
					cardSpecialVatEach, card);
			updateInvGroups(session, card, invGroups);
			updateInvCardUnits(session, card, invCardUnits);
			updateInvPrices(session, card, invPrices);
			updateInvAccounts(session, card, invAccounts);
			if (!InvDALCardUpdate.hasInitialTransaction(card))
			{
				InvBLCardAdd.saveInitialTransaction(card, InvBLCardAdd.getBaseUnitFromCardUnits(invCardUnits), session);
			}
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

	public static void updateInvAccounts(Session session, TurqInventoryCard invCard, List invAccounts) throws Exception
	{
		try
		{
			deleteInvCardAccounts(session, invCard);
			session.flush();
			InvBLCardAdd.saveInvCardAccounts(session, invCard, invAccounts);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateInvPrices(Session session, TurqInventoryCard invCard, List invPrices) throws Exception
	{
		try
		{
			deleteInvCardPrices(session, invCard);
			session.flush();
			InvBLCardAdd.saveInvCardPrices(session, invCard, invPrices);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateInvCardUnits(Session session, TurqInventoryCard invCard, List invCardUnits) throws Exception
	{
		try
		{
			deleteInvCardUnits(session, invCard);
			session.flush();
			InvBLCardAdd.saveInvCardUnits(session, invCard, invCardUnits);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateInvGroups(Session session, TurqInventoryCard invCard, Map invGroups) throws Exception
	{
		try
		{
			deleteInvCardGroups(session, invCard);
			session.flush();
			InvBLCardAdd.saveInvCardGroups(session, invCard, invGroups);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateInvCard(Session session, String invCode, String cardName, String cardDefinition, int minAmount,
			int maxAmount, int cardVat, int discount, int cardSpecialVat, BigDecimal cardSpecialVatEach, TurqInventoryCard card)
			throws Exception
	{
		try
		{
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
			card.setUpdateDate(Calendar.getInstance().getTime());
			EngDALCommon.updateObject(session, card);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInventoryCard(TurqInventoryCard card) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			deleteInvCardAccounts(session, card);
			deleteInvCardGroups(session, card);
			deleteInvCardPrices(session, card);
			deleteInvCardUnits(session, card);
			InvDALCardUpdate.deleteInitialTransactions(card);
			EngDALCommon.deleteObject(session, card);
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

	public static void deleteInvCardGroups(Session session, TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryCardGroups().iterator();
			TurqInventoryCardGroup cardGroup;
			while (it.hasNext())
			{
				cardGroup = (TurqInventoryCardGroup) it.next();
				EngDALCommon.deleteObject(session, cardGroup);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInvCardAccounts(Session session, TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryAccountingAccounts().iterator();
			TurqInventoryAccountingAccount invAccount;
			while (it.hasNext())
			{
				invAccount = (TurqInventoryAccountingAccount) it.next();
				EngDALCommon.deleteObject(session, invAccount);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInvCardUnits(Session session, TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryCardUnits().iterator();
			TurqInventoryCardUnit cardUnit;
			while (it.hasNext())
			{
				cardUnit = (TurqInventoryCardUnit) it.next();
				EngDALCommon.deleteObject(session, cardUnit);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInvCardPrices(Session session, TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryPrices().iterator();
			TurqInventoryPrice invPrice;
			while (it.hasNext())
			{
				invPrice = (TurqInventoryPrice) it.next();
				EngDALCommon.deleteObject(session, invPrice);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static boolean hasTransactions(TurqInventoryCard card) throws Exception
	{
		try
		{
			return InvDALCardUpdate.hasTransactions(card);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}