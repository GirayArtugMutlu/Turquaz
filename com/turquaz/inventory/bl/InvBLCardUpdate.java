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
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALCardUpdate;

public class InvBLCardUpdate
{
	public static void updateInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
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
			
			updateInvCard(invCode, cardName, cardDefinition, minAmount.intValue(), maxAmount.intValue(), cardVat.intValue(), discount.intValue(), cardSpecialVat.intValue(),
					cardSpecialVatEach, invCard);
			updateInvGroups(invCard, invGroups);
			updateInvCardUnits(invCard, invCardUnits);
			updateInvPrices(invCard, invPrices);
			updateInvAccounts(invCard, invAccounts);
			if (!InvDALCardUpdate.hasInitialTransaction(invCard))
			{
				InvBLCardAdd.saveInitialTransaction(invCard, InvBLCardAdd.getBaseUnitFromCardUnits(invCardUnits));
			}
			EngBLInventoryCards.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateInvAccounts(TurqInventoryCard invCard, List invAccounts) throws Exception
	{
		try
		{
			deleteInvCardAccounts(invCard);
			InvBLCardAdd.saveInvCardAccounts(invCard, invAccounts);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateInvPrices(TurqInventoryCard invCard, List invPrices) throws Exception
	{
		try
		{
			deleteInvCardPrices(invCard);
			InvBLCardAdd.saveInvCardPrices(invCard, invPrices);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateInvCardUnits(TurqInventoryCard invCard, List invCardUnits) throws Exception
	{
		try
		{
			deleteInvCardUnits(invCard);
			InvBLCardAdd.saveInvCardUnits(invCard, invCardUnits);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateInvGroups(TurqInventoryCard invCard, Map invGroups) throws Exception
	{
		try
		{
			deleteInvCardGroups(invCard);
			InvBLCardAdd.saveInvCardGroups(invCard, invGroups);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateInvCard(String invCode, String cardName, String cardDefinition, int minAmount,
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
			EngDALCommon.updateObject(card);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			deleteInvCardAccounts(invCard);
			deleteInvCardGroups(invCard);
			deleteInvCardPrices(invCard);
			deleteInvCardUnits(invCard);
			InvDALCardUpdate.deleteInitialTransactions(invCard);
			EngDALCommon.deleteObject(invCard);
			EngBLInventoryCards.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteInvCardGroups(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryCardGroups().iterator();
			TurqInventoryCardGroup cardGroup;
			while (it.hasNext())
			{
				cardGroup = (TurqInventoryCardGroup) it.next();
				EngDALCommon.deleteObject(cardGroup);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteInvCardAccounts(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryAccountingAccounts().iterator();
			TurqInventoryAccountingAccount invAccount;
			while (it.hasNext())
			{
				invAccount = (TurqInventoryAccountingAccount) it.next();
				EngDALCommon.deleteObject(invAccount);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteInvCardUnits(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryCardUnits().iterator();
			TurqInventoryCardUnit cardUnit;
			while (it.hasNext())
			{
				cardUnit = (TurqInventoryCardUnit) it.next();
				EngDALCommon.deleteObject(cardUnit);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteInvCardPrices(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Iterator it = invCard.getTurqInventoryPrices().iterator();
			TurqInventoryPrice invPrice;
			while (it.hasNext())
			{
				invPrice = (TurqInventoryPrice) it.next();
				EngDALCommon.deleteObject(invPrice);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Boolean hasTransactions(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			return InvDALCardUpdate.hasTransactions(invCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void updateInvUnit(HashMap argMap)throws Exception
	{
		try
		{
			TurqInventoryUnit invUnit=(TurqInventoryUnit)argMap.get(InvKeys.INV_UNIT);
			String invUnitName=(String)argMap.get(InvKeys.INV_UNIT_NAME);
			invUnit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			Calendar cal=Calendar.getInstance();
			invUnit.setLastModified(cal.getTime());
			invUnit.setUnitsName(invUnitName);
			EngDALCommon.updateObject(invUnit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}