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
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryTransactionType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.dal.InvDALCardAdd;

public class InvBLCardAdd
{
	public static void registerInvCardGroup(Session session, TurqInventoryCard card, TurqInventoryGroup group) throws Exception
	{
		try
		{
			TurqInventoryCardGroup cardGroup = new TurqInventoryCardGroup();
			cardGroup.setTurqInventoryCard(card);
			cardGroup.setTurqInventoryGroup(group);
			cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			cardGroup.setLastModified(cal.getTime());
			cardGroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(session, cardGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryUnit getBaseUnitFromCardUnits(List invCardUnits){
		for (int k = 0; k < invCardUnits.size(); k++)
		{
			Object[] invCardUnit = (Object[]) invCardUnits.get(k);
			TurqInventoryUnit invUnit = (TurqInventoryUnit) invCardUnit[0];
			BigDecimal factor = (BigDecimal) invCardUnit[1];
			if(factor.doubleValue()==1)
			{
				return invUnit;
			}
			
		}
		return null;
		
	}
	public static void saveInvCardUnits(Session session, TurqInventoryCard card, List invCardUnits) throws Exception
	{
		for (int k = 0; k < invCardUnits.size(); k++)
		{
			Object[] invCardUnit = (Object[]) invCardUnits.get(k);
			TurqInventoryUnit invUnit = (TurqInventoryUnit) invCardUnit[0];
			BigDecimal factor = (BigDecimal) invCardUnit[1];
			registerInvCardUnit(session, card, invUnit, factor);
		}
	}

	public static void saveInvCardPrices(Session session, TurqInventoryCard card, List invPrices) throws Exception
	{
		for (int k = 0; k < invPrices.size(); k++)
		{
			Object[] invPrice = (Object[]) invPrices.get(k);
			registerInvCardPrice(session, card, ((Boolean) invPrice[0]).booleanValue(), (String) invPrice[1], (String) invPrice[2]);
		}
	}

	public static void saveInvCardAccounts(Session session, TurqInventoryCard card, List invAccounts) throws Exception
	{
		for (int k = 0; k < invAccounts.size(); k++)
		{
			TurqInventoryAccountingAccount invAcc = (TurqInventoryAccountingAccount) invAccounts.get(k);
			invAcc.setTurqInventoryCard(card);
			registerInvCardAccount(session, invAcc, card);
		}
	}

	public static void registerInvCardUnit(Session session, TurqInventoryCard card, TurqInventoryUnit unit, BigDecimal factor)
			throws Exception
	{
		TurqInventoryCardUnit cardUnit = new TurqInventoryCardUnit();
		cardUnit.setCardUnitsFactor(factor);
		cardUnit.setTurqInventoryCard(card);
		cardUnit.setTurqInventoryUnit(unit);
		cardUnit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		cardUnit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		Calendar cal = Calendar.getInstance();
		cardUnit.setLastModified(cal.getTime());
		cardUnit.setCreationDate(cal.getTime());
		EngDALCommon.saveObject(session, cardUnit);
	}

	public static void registerInvCardPrice(Session session, TurqInventoryCard card, boolean price_type, String currency_abrev,
			String amount) throws Exception
	{
		try
		{
			TurqInventoryPrice invPrice = new TurqInventoryPrice();
			TurqCurrency currency = InvDALCardAdd.getCurrency(currency_abrev);
			invPrice.setPricesType(price_type);
			invPrice.setPricesAmount(new BigDecimal(amount));
			invPrice.setTurqInventoryCard(card);
			invPrice.setTurqCurrency(currency);
			invPrice.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invPrice.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			invPrice.setLastModified(cal.getTime());
			invPrice.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(session, invPrice);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void registerInvCardAccount(Session session, TurqInventoryAccountingAccount invAcc, TurqInventoryCard card)
			throws Exception
	{
		try
		{
			invAcc.setTurqInventoryCard(card);
			invAcc.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invAcc.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			invAcc.setLastModified(cal.getTime());
			invAcc.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(session, invAcc);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveObject(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.saveObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveUnit(String unitName) throws Exception
	{
		try
		{
			TurqInventoryUnit invUnit = new TurqInventoryUnit();
			invUnit.setUnitsName(unitName);
			//invGroup.setGroupsDescription(groupDescription);
			invUnit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invUnit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			invUnit.setLastModified(cal.getTime());
			invUnit.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(invUnit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInvGroup(String groupName, String groupDescription, TurqInventoryGroup parent) throws Exception
	{
		try
		{
			if (parent == null)
			{
				parent = new TurqInventoryGroup();
				parent.setId(new Integer(-1));
			}
			TurqInventoryGroup invGroup = new TurqInventoryGroup();
			invGroup.setGroupsName(groupName);
			invGroup.setGroupsDescription(groupDescription);
			invGroup.setTurqInventoryGroup(parent);
			invGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			invGroup.setLastModified(cal.getTime());
			invGroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(invGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static List getInventoryUnits(TurqInventoryCard invCard)throws Exception
	{
		try{
			
		
			return InvDALCardAdd.getInventoryUnits(invCard);
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	public static void saveInitialTransaction(TurqInventoryCard invCard, TurqInventoryUnit unit,Session session)throws Exception{
		try{
			
			Calendar cal = Calendar.getInstance();
			TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
			
			TurqInventoryTransactionType transType = new TurqInventoryTransactionType();
			transType.setId(new Integer(EngBLCommon.INV_TRANS_INITIAL));
			
			
			invTrans.setTurqInventoryTransactionType(transType);
			invTrans.setTurqInventoryCard(invCard);
			
			TurqInventoryWarehous warehous = new TurqInventoryWarehous();
			warehous.setId(new Integer(1));
			invTrans.setTurqInventoryWarehous(warehous);			
			
			invTrans.setTurqInventoryUnit(unit);

			TurqEngineSequence seq = new TurqEngineSequence();
			TurqModule module = new TurqModule();
			module.setId(new Integer(EngBLCommon.MODULE_INVENTORY));
			seq.setTurqModule(module);
			EngDALCommon.saveObject(seq);
			
			invTrans.setTurqEngineSequence(seq);
			invTrans.setTransactionsDate(DatePicker.getFirstDayOfYear());
			invTrans.setDefinition(Messages.getString("InvBLCardAdd.0"));  //$NON-NLS-1$
			invTrans.setDocumentNo(""); //$NON-NLS-1$
			invTrans.setTransactionsAmountIn(new BigDecimal(0));
			invTrans.setTransactionsTotalAmountOut(new BigDecimal(0));
			
			invTrans.setTransactionsTotalPrice(new BigDecimal(0));
			invTrans.setTransactionsDiscountAmount(new BigDecimal(0));
			invTrans.setTransactionsDiscount(new BigDecimal(0));
			invTrans.setTransactionsCumilativePrice(new BigDecimal(0));
			invTrans.setTransactionsUnitPrice(new BigDecimal(0));
			invTrans.setTransactionsVat(0);
			invTrans.setTransactionsVatAmount(new BigDecimal(0));
			invTrans.setTransactionsVatSpecialEach(new BigDecimal(0));
			invTrans.setTransactionsVatSpecial(new BigDecimal(0));
			invTrans.setTransactionsVatSpecialAmount(new BigDecimal(0));
			invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));	
			
			EngDALCommon.saveObject(session,invTrans);
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		
	}
	public static void saveInventoryCard(String invCode, String cardName, String cardDefinition, int minAmount, int maxAmount,
			int cardVat, int discount, int cardSpecialVat, BigDecimal cardSpecialVatEach, boolean isSpecAmount, Map invGroups,
			List invCardUnits, List invPrices, List invAccounts) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			TurqInventoryCard card = registerInventoryCard(session, invCode, cardName, cardDefinition, minAmount, maxAmount, cardVat,
					discount, cardSpecialVat, cardSpecialVatEach, isSpecAmount);
			session.flush();
			saveInvCardGroups(session, card, invGroups);
			saveInvCardUnits(session, card, invCardUnits);
			saveInvCardPrices(session, card, invPrices);
			saveInvCardAccounts(session, card, invAccounts);
			saveInitialTransaction(card,getBaseUnitFromCardUnits(invCardUnits),session);
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

	public static void saveInvCardGroups(Session session, TurqInventoryCard card, Map groupMap) throws Exception
	{
		try
		{
			Iterator it = groupMap.values().iterator();
			while (it.hasNext())
			{
				TurqInventoryGroup group = (TurqInventoryGroup) it.next();
				if (group != null)
				{
					registerInvCardGroup(session, card, group);
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard registerInventoryCard(Session session, String invCode, String cardName, String cardDefinition,
			int minAmount, int maxAmount, int cardVat, int discount, int cardSpecialVat, BigDecimal cardSpecialVatEach,
			boolean isSpecAmount) throws Exception
	{
		try
		{
			TurqInventoryCard card = new TurqInventoryCard();
			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardVat(cardVat);
			card.setCardSpecialVat(cardSpecialVat);
			card.setCardSpecialVatEach(cardSpecialVatEach);
			card.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			card.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			card.setUpdateDate(cal.getTime());
			card.setCreationDate(cal.getTime());
			card.setSpecVatForEach(isSpecAmount);
			EngDALCommon.saveObject(session, card);
			return card;
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

	public static List getInventoryGroups() throws Exception
	{
		try
		{
			return InvDALCardAdd.getInventoryGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getParentInventoryGroups() throws Exception
	{
		try
		{
			return InvDALCardAdd.getParentInventoryGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryUnits() throws Exception
	{
		try
		{
			return InvDALCardAdd.getAllInventoryUnits();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchInventoryCards(TurqInventoryGroup invGroup, String invName, String invCode)
	{
		try
		{
			String query = "from TurqInventoryCard as invCard"; //$NON-NLS-1$
			return null;
		}
		catch (Exception ex)
		{
			return null;
		}
	}
}