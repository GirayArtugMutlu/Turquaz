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
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALCardUpdate;

public class InvBLCardUpdate
{
	public static void updateInventoryCard(String invCode, String cardName, String cardDefinition, Integer minAmount, Integer maxAmount,
			Integer cardVat, Integer discount, Integer cardSpecialVat, BigDecimal cardSpecialVatEach, TurqInventoryCard card, Map invGroups,
			List invCardUnits, List invPrices, List invAccounts) throws Exception
	{
		try
		{
			updateInvCard(invCode, cardName, cardDefinition, minAmount.intValue(), maxAmount.intValue(), cardVat.intValue(), discount.intValue(), cardSpecialVat.intValue(),
					cardSpecialVatEach, card);
			updateInvGroups(card, invGroups);
			updateInvCardUnits(card, invCardUnits);
			updateInvPrices(card, invPrices);
			updateInvAccounts(card, invAccounts);
			if (!InvDALCardUpdate.hasInitialTransaction(card))
			{
				InvBLCardAdd.saveInitialTransaction(card, InvBLCardAdd.getBaseUnitFromCardUnits(invCardUnits));
			}
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
}