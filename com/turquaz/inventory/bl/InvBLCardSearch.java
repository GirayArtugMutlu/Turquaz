package com.turquaz.inventory.bl;

/** ********************************************************************* */
/* TURQUAZ: Higly Modular Accounting/ERP Program */
/* ============================================ */
/* Copyright (c) 2004 by Turquaz Software Development Group */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or */
/* (at your option) any later version. */
/* 																		*/
/* This program is distributed in the hope that it will be useful, */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the */
/* GNU General Public License for more details. */
/** ********************************************************************* */
/**
 * @author Onsel Armagan
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Session;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingType;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
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
			String cardName = (String) argMap.get(InvKeys.INV_CARD_NAME);
			String cardCode = (String) argMap.get(InvKeys.INV_CARD_CODE);
			TurqInventoryGroup group = (TurqInventoryGroup) argMap.get(InvKeys.INV_GROUP);
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
			Integer invCardId = (Integer) argMap.get(InvKeys.INV_CARD_ID);
			return InvDALCardSearch.getInvAccountingAccs(invCardId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getAllInvAccTypes() throws Exception
	{
		try
		{
			HashBag typeBag=new HashBag();
			List typeList=InvDALCardSearch.getAllInvAccTypes();
			
			typeBag.put(InvKeys.INV_ACC_TYPES,new HashMap());
			
			for(int k=0; k<typeList.size(); k++)
			{
				TurqInventoryAccountingType type=(TurqInventoryAccountingType)typeList.get(k);
				
				typeBag.put(InvKeys.INV_ACC_TYPES,k,InvKeys.INV_ACC_TYPE_ID,type.getId());
				typeBag.put(InvKeys.INV_ACC_TYPES,k,InvKeys.INV_ACC_TYPE_NAME,type.getTypeName());
				typeBag.put(InvKeys.INV_ACC_TYPES,k,InvKeys.INV_ACC_TYPE_DEFINITION,type.getDefinition());
			}
			return typeBag;
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
			String cardCodeStart = (String) argMap.get(InvKeys.INV_CARD_CODE_START);
			String cardCodeEnd = (String) argMap.get(InvKeys.INV_CARD_CODE_END);
			String cardNameStart = (String) argMap.get(InvKeys.INV_CARD_NAME_START);
			String cardNameEnd = (String) argMap.get(InvKeys.INV_CARD_NAME_END);
			TurqInventoryGroup group = (TurqInventoryGroup) argMap.get(InvKeys.INV_GROUP);
			return InvDALCardSearch.searchInventoryCardsAdvanced(cardCodeStart, cardCodeEnd, cardNameStart,
					cardNameEnd, group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactionTotalReport(HashMap argMap) throws Exception
	{
		String cardCodeStart = (String) argMap.get(InvKeys.INV_CARD_CODE_START);
		String cardCodeEnd = (String) argMap.get(InvKeys.INV_CARD_CODE_END);
		String cardNameStart = (String) argMap.get(InvKeys.INV_CARD_NAME_START);
		String cardNameEnd = (String) argMap.get(InvKeys.INV_CARD_NAME_END);
		Date startDate=(Date)argMap.get(EngKeys.DATE_START);
		Date endDate=(Date)argMap.get(EngKeys.DATE_END);
		String curCardStart=(String)argMap.get(EngKeys.CURRENT_CARD_START);
		String curCardEnd=(String)argMap.get(EngKeys.CURRENT_CARD_END);
		TurqInventoryGroup invMainGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_MAIN_GROUP);
		TurqInventoryGroup invSubGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_SUB_GROUP);
		
		return InvDALCardSearch.getTransactionTotalReport(cardCodeStart, cardCodeEnd, cardNameStart, cardNameEnd,
				startDate, endDate, curCardStart, curCardEnd, invMainGroup, invSubGroup);
	}

	public static TurqInventoryCard initializeInventoryCardById(HashMap argMap) throws Exception
	{
		try
		{
			Integer cardId = (Integer) argMap.get(InvKeys.INV_CARD_ID);
			TurqInventoryCard card = InvDALCardSearch.initializeInventoryCard(cardId);
			return card;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag initializeInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			Integer cardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
			
			Session session=EngDALSessionFactory.getSession();
			TurqInventoryCard invCard = (TurqInventoryCard)session.load(TurqInventoryCard.class,cardId);
			
			HashBag cardBag=new HashBag();
			
			cardBag.put(InvKeys.INV_CARD_ID, invCard.getId());
			cardBag.put(InvKeys.INV_CARD_NAME, invCard.getCardName());
			cardBag.put(InvKeys.INV_CARD_CODE, invCard.getCardInventoryCode());			
			cardBag.put(InvKeys.INV_CARD_DEFINITION, invCard.getCardDefinition());			
			cardBag.put(InvKeys.INV_IS_SPEC_VAT_FOR_EACH, new Boolean(invCard.isSpecVatForEach()));
			cardBag.put(InvKeys.INV_VAT_RATE,new BigDecimal(invCard.getCardVat()));
			cardBag.put(InvKeys.INV_VAT_SPECIAL_RATE, new BigDecimal(invCard.getCardSpecialVat()));
			cardBag.put(InvKeys.INV_SPECIAL_VAT_FOR_EACH, invCard.getCardSpecialVatEach());
			
			
			Iterator it=invCard.getTurqInventoryCardUnits().iterator();
			cardBag.put(InvKeys.INV_CARD_UNITS, new HashMap());
			int row=0;
			while (it.hasNext())
			{
				TurqInventoryCardUnit cardUnit=(TurqInventoryCardUnit)it.next();
				
				cardBag.put(InvKeys.INV_CARD_UNITS,row,InvKeys.INV_CARD_UNIT_ID,cardUnit.getId());
				cardBag.put(InvKeys.INV_CARD_UNITS,row,InvKeys.INV_CARD_UNIT_FACTOR,cardUnit.getCardUnitsFactor());
				
				HashMap unitMap=new HashMap();
				unitMap.put(InvKeys.INV_UNIT_ID,cardUnit.getTurqInventoryUnit().getId());
				unitMap.put(InvKeys.INV_UNIT_NAME,cardUnit.getTurqInventoryUnit().getUnitsName());
			
				cardBag.put(InvKeys.INV_CARD_UNITS,row,InvKeys.INV_UNIT,unitMap);
			}			
			
			return cardBag;
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
			TurqInventoryCard invCard = (TurqInventoryCard) argMap.get(InvKeys.INV_CARD);
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

	public static HashBag getInventoryCard(HashMap argMap) throws Exception
	{
		try
		{
			String invCode = (String) argMap.get(InvKeys.INV_CARD_CODE);
			TurqInventoryCard invCard=InvDALCardSearch.getInventoryCard(invCode);
			HashBag cardBag=new HashBag();
			if (invCard != null)
			{
				HashMap cardMap=new HashMap();
				cardMap.put(InvKeys.INV_CARD_ID,invCard.getId());
				cardMap.put(InvKeys.INV_CARD_NAME,invCard.getCardName());
				cardMap.put(InvKeys.INV_CARD_CODE,invCard.getCardInventoryCode());
				cardMap.put(InvKeys.INV_CARD_DEFINITION,invCard.getCardDefinition());
				cardMap.put(InvKeys.INV_IS_SPEC_VAT_FOR_EACH,new Boolean(invCard.isSpecVatForEach()));
				cardBag.put(InvKeys.INV_CARD,cardMap);
			}
			
			return cardBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getInventoryCardFromName(HashMap argMap) throws Exception
	{
		try
		{
			String invCode = (String) argMap.get(InvKeys.INV_CARD_NAME);
			TurqInventoryCard invCard=InvDALCardSearch.getInventoryCardFromName(invCode);
			
			HashBag cardBag=new HashBag();
			HashMap cardMap=new HashMap();
			
			cardMap.put(InvKeys.INV_CARD_ID,invCard.getId());
			cardMap.put(InvKeys.INV_CARD_NAME,invCard.getCardName());
			cardMap.put(InvKeys.INV_CARD_CODE,invCard.getCardInventoryCode());
			cardMap.put(InvKeys.INV_CARD_DEFINITION,invCard.getCardDefinition());
			cardMap.put(InvKeys.INV_IS_SPEC_VAT_FOR_EACH,new Boolean(invCard.isSpecVatForEach()));
			
			cardBag.put(InvKeys.INV_CARD,cardMap);
			return cardBag;
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}