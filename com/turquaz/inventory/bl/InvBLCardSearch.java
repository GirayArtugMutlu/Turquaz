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
import java.util.HashMap;
import java.util.List;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALCardSearch;

public class InvBLCardSearch
{
	public static List searchCards(HashMap argMap) throws Exception
	{
		try
		{
			String cardName=(String)argMap.get(InvKeys.INV_CARD_NAME);
			String cardCode=(String)argMap.get(InvKeys.INV_CARD_CODE);
			TurqInventoryGroup group=(TurqInventoryGroup)argMap.get(InvKeys.INV_GROUP);
			return InvDALCardSearch.searchInventoryCards(cardName, cardCode, group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getInventoryAccount(Integer invCardId, int invAccTypeId) throws Exception
	{
		try
		{
			return InvDALCardSearch.getInventoryAccount(invCardId, invAccTypeId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInvAccountingAccs(HashMap argMap) throws Exception
	{
		try
		{
			Integer invCardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
			return InvDALCardSearch.getInvAccountingAccs(invCardId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllInvAccTypes() throws Exception
	{
		try
		{
			return InvDALCardSearch.getAllInvAccTypes();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchCardsAdvanced(HashMap argMap) throws Exception
	{
		try
		{
			String cardCodeStart=(String)argMap.get(InvKeys.INV_CARD_CODE_START);
			String cardCodeEnd=(String)argMap.get(InvKeys.INV_CARD_CODE_END);
			String cardNameStart=(String)argMap.get(InvKeys.INV_CARD_NAME_START);
			String cardNameEnd=(String)argMap.get(InvKeys.INV_CARD_NAME_END);
			TurqInventoryGroup group=(TurqInventoryGroup)argMap.get(InvKeys.INV_GROUP);
			return InvDALCardSearch.searchInventoryCardsAdvanced(cardCodeStart, cardCodeEnd, cardNameStart, cardNameEnd, group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard initializeInventoryCardById(HashMap argMap) throws Exception
	{
		try
		{
			Integer cardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
			TurqInventoryCard card=InvDALCardSearch.initializeInventoryCard(cardId);
			return card;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initializeInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			InvDALCardSearch.initializeInventoryCard(invCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqViewInventoryAmountTotal getView(HashMap argMap) throws Exception
	{
		try
		{
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			return InvDALCardSearch.getView(invCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryCards() throws Exception
	{
		try
		{
			return InvDALCardSearch.getInventoryCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard getInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			String invCode=(String)argMap.get(InvKeys.INV_CARD_CODE);
			return InvDALCardSearch.getInventoryCard(invCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}