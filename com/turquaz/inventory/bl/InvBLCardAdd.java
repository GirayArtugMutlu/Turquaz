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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLInventoryGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
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
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALCardAdd;

public class InvBLCardAdd
{	

	public static TurqInventoryUnit getBaseUnitFromCardUnits(List invCardUnits)
	{
		for (int k = 0; k < invCardUnits.size(); k++)
		{
			Object[] invCardUnit = (Object[]) invCardUnits.get(k);
			TurqInventoryUnit invUnit = (TurqInventoryUnit) invCardUnit[0];
			BigDecimal factor = (BigDecimal) invCardUnit[1];
			if (factor.doubleValue() == 1)
			{
				return invUnit;
			}
		}
		return null;
	}

	public static HashBag getInventoryUnits() throws Exception
	{
		try
		{
			HashBag invUnitsBag=new HashBag();
			List invUnits=InvDALCardAdd.getAllInventoryUnits();
			
			invUnitsBag.put(InvKeys.INV_UNITS, new HashMap());
			
			for(int k=0; k<invUnits.size() ; k++)
			{
				TurqInventoryUnit invUnit=(TurqInventoryUnit)invUnits.get(k);

				invUnitsBag.put(InvKeys.INV_UNITS,k,InvKeys.INV_UNIT_ID,invUnit.getId());
				invUnitsBag.put(InvKeys.INV_UNITS,k,InvKeys.INV_UNIT_NAME,invUnit.getUnitsName());
			}
			
			return invUnitsBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryUnits(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			return InvDALCardAdd.getInventoryUnits(invCard);
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

	private static void registerInvCardAccount(TurqInventoryAccountingAccount invAcc, TurqInventoryCard card)
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
			EngDALCommon.saveObject(invAcc);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	private static void registerInvCardGroup(TurqInventoryCard card, TurqInventoryGroup group) throws Exception
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
			EngDALCommon.saveObject(cardGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void registerInvCardPrice(TurqInventoryCard card, boolean price_type, String currency_abrev,
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
			EngDALCommon.saveObject(invPrice);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void registerInvCardUnit(TurqInventoryCard card, TurqInventoryUnit unit, BigDecimal factor)
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
		EngDALCommon.saveObject(cardUnit);
	}

	private static TurqInventoryCard registerInventoryCard(String invCode, String cardName, String cardDefinition,
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
			EngDALCommon.saveObject(card);
			return card;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInitialTransaction(TurqInventoryCard invCard, TurqInventoryUnit unit) throws Exception
	{
		try
		{
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
			invTrans.setDefinition(InvLangKeys.STR_INITIAL_TRANSACTION);
			invTrans.setDocumentNo(""); //$NON-NLS-1$
			invTrans.setAmountIn(new BigDecimal(0));
			invTrans.setAmountOut(new BigDecimal(0));
			invTrans.setTotalPrice(new BigDecimal(0));
			invTrans.setTotalPriceInForeignCurrency(new BigDecimal(0));
			invTrans.setDiscountAmount(new BigDecimal(0));
			invTrans.setDiscountAmountInForeignCurrency(new BigDecimal(0));
			invTrans.setDiscountRate(new BigDecimal(0));
			invTrans.setCumilativePrice(new BigDecimal(0));
			invTrans.setCumilativePriceInForeignCurrency(new BigDecimal(0));
			invTrans.setUnitPrice(new BigDecimal(0));
			invTrans.setUnitPriceInForeignCurrency(new BigDecimal(0));
			invTrans.setVatRate(new BigDecimal(0));
			invTrans.setVatAmount(new BigDecimal(0));
			invTrans.setVatAmountInForeignCurrency(new BigDecimal(0));
			invTrans.setVatSpecialUnitPrice(new BigDecimal(0));
			invTrans.setVatSpecialUnitPriceInForeignCurrency(new BigDecimal(0));
			invTrans.setVatSpecialRate(new BigDecimal(0));
			invTrans.setVatSpecialAmount(new BigDecimal(0));
			invTrans.setVatSpecialAmountInForeignCurrency(new BigDecimal(0));
			invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setLastModified(cal.getTime());
			invTrans.setCreationDate(cal.getTime());
			invTrans.setTurqCurrencyExchangeRate(EngBLClient.getBaseCurrencyExchangeRate());
			TurqCurrentCard curCard=new TurqCurrentCard();
			curCard.setId(new Integer(-1));
			invTrans.setTurqCurrentCard(curCard);
			EngDALCommon.saveObject(invTrans);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInvCardAccounts(TurqInventoryCard card, List invAccounts) throws Exception
	{
		for (int k = 0; k < invAccounts.size(); k++)
		{
			TurqInventoryAccountingAccount invAcc = (TurqInventoryAccountingAccount) invAccounts.get(k);
			invAcc.setTurqInventoryCard(card);
			registerInvCardAccount(invAcc, card);
		}
	}

	public static void saveInvCardGroups(TurqInventoryCard card, Map groupMap) throws Exception
	{
		try
		{
			Iterator it = groupMap.values().iterator();
			while (it.hasNext())
			{
				TurqInventoryGroup group = (TurqInventoryGroup) it.next();
				if (group != null)
				{
					registerInvCardGroup(card, group);
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInvCardPrices(TurqInventoryCard card, List invPrices) throws Exception
	{
		for (int k = 0; k < invPrices.size(); k++)
		{
			Object[] invPrice = (Object[]) invPrices.get(k);
			registerInvCardPrice(card, ((Boolean) invPrice[0]).booleanValue(), (String) invPrice[1], (String) invPrice[2]);
		}
	}

	public static void saveInvCardUnits(TurqInventoryCard card, List invCardUnits) throws Exception
	{
		for (int k = 0; k < invCardUnits.size(); k++)
		{
			Object[] invCardUnit = (Object[]) invCardUnits.get(k);
			TurqInventoryUnit invUnit = (TurqInventoryUnit) invCardUnit[0];
			BigDecimal factor = (BigDecimal) invCardUnit[1];
			registerInvCardUnit(card, invUnit, factor);
		}
	}

	public static void saveInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			String invCode=(String)argMap.get(InvKeys.INV_CARD_CODE);
			String cardName=(String)argMap.get(InvKeys.INV_CARD_NAME);
			String cardDefinition=(String)argMap.get(InvKeys.INV_CARD_DEFINITION);
			Integer minAmount=(Integer)argMap.get(InvKeys.INV_CARD_MIN_AMOUNT);
			Integer maxAmount=(Integer)argMap.get(InvKeys.INV_CARD_MAX_AMOUNT);
			Integer cardVat=(Integer)argMap.get(InvKeys.INV_CARD_VAT_RATE);
			Integer discount=(Integer)argMap.get(InvKeys.INV_CARD_DISCOUNT_RATE);
			Integer cardSpecialVat=(Integer)argMap.get(InvKeys.INV_CARD_SPECIAL_VAT_RATE);
			BigDecimal cardSpecialVatEach=(BigDecimal)argMap.get(InvKeys.INV_CARD_SPECIAL_FOR_EACH);
			Boolean isSpecAmount=(Boolean)argMap.get(InvKeys.INV_CARD_IS_SPEC_AMOUNT);
			Map invGroups=(Map)argMap.get(InvKeys.INV_CARD_INV_GROUPS);
			List invCardUnits=(List)argMap.get(InvKeys.INV_CARD_UNITS);
			List invPrices=(List)argMap.get(InvKeys.INV_CARD_PRICES);
			List invAccounts=(List)argMap.get(InvKeys.INV_CARD_ACCOUNTS);
			
			
			TurqInventoryCard card = registerInventoryCard(invCode, cardName, cardDefinition, minAmount.intValue(), maxAmount.intValue(), cardVat.intValue(),
					discount.intValue(), cardSpecialVat.intValue(), cardSpecialVatEach, isSpecAmount.booleanValue());
			saveInvCardGroups(card, invGroups);
			saveInvCardUnits(card, invCardUnits);
			saveInvCardPrices(card, invPrices);
			saveInvCardAccounts(card, invAccounts);
			saveInitialTransaction(card, getBaseUnitFromCardUnits(invCardUnits));
			
			EngBLInventoryCards.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInvGroup(HashMap argMap) throws Exception
	{
		try
		{
			String groupName=(String)argMap.get(InvKeys.INV_GROUP_NAME);
			String groupDescription=(String)argMap.get(InvKeys.INV_GROUP_DESCRIPTION);
			TurqInventoryGroup parent=(TurqInventoryGroup)argMap.get(InvKeys.INV_GROUP_PARENT);
			
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
			EngBLInventoryGroups.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveUnit(HashMap argMap) throws Exception
	{
		try
		{
			String unitName=(String)argMap.get(InvKeys.INV_UNIT_NAME);
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
	
	public static void updateInvGroup(HashMap argMap) throws Exception
	{
		try
		{
			String groupName=(String)argMap.get(InvKeys.INV_GROUP_NAME);
			String groupDescription=(String)argMap.get(InvKeys.INV_GROUP_DESCRIPTION);
			TurqInventoryGroup invGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_GROUP);
			invGroup.setGroupsName(groupName);
			invGroup.setGroupsDescription(groupDescription);
			invGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal = Calendar.getInstance();
			invGroup.setLastModified(cal.getTime());
			invGroup.setCreationDate(cal.getTime());
			EngDALCommon.updateObject(invGroup);
			EngBLInventoryGroups.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}