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
import com.turquaz.accounting.AccKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingType;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALCardSearch;

public class InvBLCardSearch
{
	public static HashBag searchCards(HashMap argMap) throws Exception
	{
		try
		{
			String cardName = (String) argMap.get(InvKeys.INV_CARD_NAME);
			String cardCode = (String) argMap.get(InvKeys.INV_CARD_CODE);
			Integer groupId = (Integer) argMap.get(InvKeys.INV_GROUP_ID);
			List cards=InvDALCardSearch.searchInventoryCards(cardName, cardCode, groupId);
			
			HashBag cardBag=new HashBag();
			cardBag.put(InvKeys.INV_CARDS, new HashMap());
			
			for(int k=0; k<cards.size(); k++)
			{
				Object[] invInfo=(Object[])cards.get(k);
				TurqInventoryCard invCard=(TurqInventoryCard)invInfo[0];
				TurqViewInventoryTotal invView=(TurqViewInventoryTotal)invInfo[1];
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_ID,invCard.getId());
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_CODE,invCard.getCardInventoryCode());
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_NAME,invCard.getCardName());
				
				BigDecimal amountIn=invView.getTotalAmountIn();
				if (amountIn == null)
				{
					amountIn=new BigDecimal(0);
				}
				BigDecimal amountOut=invView.getTotalAmountOut();
				if (amountOut == null)
				{
					amountOut=new BigDecimal(0);
				}
				BigDecimal priceIn=invView.getTotalPriceIn();
				if (priceIn == null)
				{
					priceIn = new BigDecimal(0);
				}
				BigDecimal priceOut=invView.getTotalPriceOut();
				if (priceOut == null)
				{
					priceOut = new BigDecimal(0);
				}
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_IN,amountIn);
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_OUT,amountOut);
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_PRICE_IN,priceIn);
				cardBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_PRICE_OUT,priceOut);
			}
			
			return cardBag;
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

	public static HashBag getInvAccountingAccs(HashMap argMap) throws Exception
	{
		try
		{
			Integer invCardId = (Integer) argMap.get(InvKeys.INV_CARD_ID);
			List invAccounts= InvDALCardSearch.getInvAccountingAccs(invCardId);
			HashBag accountBag=new HashBag();
			accountBag.put(InvKeys.INV_ACCOUNTS, new HashMap());
			
			for(int k=0; k<invAccounts.size(); k++)
			{
				TurqInventoryAccountingAccount invAcc=(TurqInventoryAccountingAccount)invAccounts.get(k);
				
				accountBag.put(InvKeys.INV_ACCOUNTS,k,InvKeys.INV_ACCOUNT_ID,invAcc.getId());
				
				HashMap accMap=new HashMap();
				TurqAccountingAccount acc=invAcc.getTurqAccountingAccount();
				accMap.put(AccKeys.ACC_ACCOUNT_ID, acc.getId());
				accMap.put(AccKeys.ACC_ACCOUNT_CODE, acc.getAccountCode());
				accMap.put(AccKeys.ACC_ACCOUNT_NAME, acc.getAccountName());
				
				accountBag.put(InvKeys.INV_ACCOUNTS,k,AccKeys.ACC_ACCOUNT,accMap);
				
				HashMap invAccType=new HashMap();
				TurqInventoryAccountingType type=invAcc.getTurqInventoryAccountingType();
				invAccType.put(InvKeys.INV_ACC_TYPE_ID,type.getId());
				invAccType.put(InvKeys.INV_ACC_TYPE_NAME,type.getTypeName());
				invAccType.put(InvKeys.INV_ACC_TYPE_DEFINITION,type.getDefinition());
				
				accountBag.put(InvKeys.INV_ACCOUNTS,k,InvKeys.INV_ACC_TYPE,invAccType);
			}
			
			return accountBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static HashBag getInvCardPrices(HashMap argMap) throws Exception
	{
		Integer invCardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
		List invPrices=InvDALCardSearch.getInvCardPrices(invCardId);	
		
		HashBag priceBag=new HashBag();
		priceBag.put(InvKeys.INV_CARD_PRICES, new HashMap());
		
		for(int k=0; k<invPrices.size(); k++)
		{
			TurqInventoryPrice invPrice=(TurqInventoryPrice)invPrices.get(k);
			
			priceBag.put(InvKeys.INV_CARD_PRICES,k,InvKeys.INV_PRICE_ID,invPrice.getId());
			priceBag.put(InvKeys.INV_CARD_PRICES,k,InvKeys.INV_PRICE_AMOUNT,invPrice.getPricesAmount());
			priceBag.put(InvKeys.INV_CARD_PRICES,k,InvKeys.INV_IS_BUY,new Boolean(invPrice.isPricesType()));
			priceBag.put(InvKeys.INV_CARD_PRICES,k,EngKeys.CURRENCY_ID,invPrice.getTurqCurrency().getId());
			priceBag.put(InvKeys.INV_CARD_PRICES,k,EngKeys.CURRENCY_ABBR,invPrice.getTurqCurrency().getCurrenciesAbbreviation());
		}		
		return priceBag;
		
	}
	
	public static HashBag getInvCardGroups(HashMap argMap) throws Exception
	{
		Integer invCardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
		List invGroups=InvDALCardSearch.getInvCardGroups(invCardId);	
		
		HashBag groupBag=new HashBag();
		groupBag.put(InvKeys.INV_CARD_GROUPS, new HashMap());
		
		for(int k=0; k<invGroups.size(); k++)
		{
			TurqInventoryCardGroup invCardGroup=(TurqInventoryCardGroup)invGroups.get(k);
			TurqInventoryGroup invGroup=invCardGroup.getTurqInventoryGroup();
			
			HashMap invGroupMap=new HashMap();
			invGroupMap.put(InvKeys.INV_GROUP_ID,invGroup.getId());
			invGroupMap.put(InvKeys.INV_GROUP_NAME,invGroup.getGroupsName());
			invGroupMap.put(InvKeys.INV_GROUP_DESCRIPTION,invGroup.getGroupsDescription());
			invGroupMap.put(InvKeys.INV_PARENT_GROUP_ID,invGroup.getTurqInventoryGroup().getId());
			
			groupBag.put(InvKeys.INV_CARD_GROUPS,k,InvKeys.INV_CARD_GROUP_ID,invCardGroup.getId());

			groupBag.put(InvKeys.INV_CARD_GROUPS,k,InvKeys.INV_GROUP,invGroupMap);
			
		}		
		return groupBag;
		
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
		String curCardStart=(String)argMap.get(CurKeys.CUR_CARD_START);
		String curCardEnd=(String)argMap.get(CurKeys.CUR_CARD_END);
		TurqInventoryGroup invMainGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_MAIN_GROUP);
		TurqInventoryGroup invSubGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_SUB_GROUP);
		
		return InvDALCardSearch.getTransactionTotalReport(cardCodeStart, cardCodeEnd, cardNameStart, cardNameEnd,
				startDate, endDate, curCardStart, curCardEnd, invMainGroup, invSubGroup);
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
			cardBag.put(InvKeys.INV_DISCOUNT_RATE, new BigDecimal(invCard.getCardDiscount()));
			cardBag.put(InvKeys.INV_MAX_AMOUNT, new Integer(invCard.getCardMaximumAmount()));
			cardBag.put(InvKeys.INV_MIN_AMOUNT, new Integer(invCard.getCardMinimumAmount()));
			
			
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
				row++;
			}			
			
			return cardBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getView(HashMap argMap) throws Exception
	{
		try
		{
			Integer invCardId = (Integer) argMap.get(InvKeys.INV_CARD_ID);
			
			TurqInventoryCard invCard = (TurqInventoryCard)EngDALSessionFactory.getSession().load(TurqInventoryCard.class,invCardId);
						
			TurqViewInventoryAmountTotal view = InvDALCardSearch.getView(invCardId);
			
			HashBag result = new HashBag();
			result.put(InvKeys.INV_AMOUNT_NOW,view.getTransactionsTotalAmountNow());
			result.put(InvKeys.INV_AMOUNT_MAX,new Integer(invCard.getCardMaximumAmount()));
			result.put(InvKeys.INV_AMOUNT_MIN,new Integer(invCard.getCardMinimumAmount()));
			
			return result;
			
			
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