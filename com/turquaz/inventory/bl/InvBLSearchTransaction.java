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
 * @author Huseyin Ergun
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import net.sf.hibernate.Session;

import com.turquaz.bill.BillKeys;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALSearchTransaction;

public class InvBLSearchTransaction
{
	public static HashBag searchTransactions(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			Integer invCardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			List transList=InvDALSearchTransaction.searchTransactions(curCardId, invCardId, startDate, endDate, type.intValue());
		
			HashBag transBag= new HashBag();
			transBag.put(InvKeys.INV_TRANSACTIONS, new HashMap());
			
			for(int k=0; k<transList.size(); k++)
			{
				Object[] transInfo=(Object[])transList.get(k);
				Integer transId=(Integer)transInfo[0];
				Date transDate=(Date)transInfo[1];
				BigDecimal amountIn=(BigDecimal)transInfo[2];
				BigDecimal amountOut=(BigDecimal)transInfo[3];
				BigDecimal totalPrice=(BigDecimal)transInfo[4];
				String invCode=(String)transInfo[5];
				String invName=(String)transInfo[6];
				
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TRANS_ID,transId);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TRANS_DATE,transDate);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_AMOUNT_IN,amountIn);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_AMOUNT_OUT,amountOut);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TOTAL_PRICE,totalPrice);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_CARD_CODE,invCode);
				transBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_CARD_NAME,invName);
			}
			
			return transBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getAllIds(HashMap argMap) throws Exception
	{
		Integer transId=(Integer)argMap.get(InvKeys.INV_TRANS_ID);
		Session session=EngDALSessionFactory.getSession();
		
		TurqInventoryTransaction invTrans=(TurqInventoryTransaction)session.load(TurqInventoryTransaction.class,transId);
		
		Integer billId=InvDALSearchTransaction.getBillId(invTrans.getTurqEngineSequence());
		Integer consId=InvDALSearchTransaction.getConsignmentId(invTrans.getTurqEngineSequence());
				
		HashBag idBag=new HashBag();
		idBag.put(BillKeys.BILL_ID,billId);
		idBag.put(ConsKeys.CONS_ID,consId);
		
		return idBag;
	}
	
	
	public static HashBag getInventoryCardAbstract(HashMap argMap) throws Exception
	{
		try
		{
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);

			Integer invCardStartId=(Integer)argMap.get(InvKeys.INV_CARD_START_ID);
			Integer invCardEndId=(Integer)argMap.get(InvKeys.INV_CARD_END_ID);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			TurqInventoryCard invCardStart=null;
			TurqInventoryCard invCardEnd=null;
			Session session=EngDALSessionFactory.getSession();
			if (invCardStartId != null)
			{
				invCardStart=(TurqInventoryCard)session.load(TurqInventoryCard.class, invCardStartId);
			}
			if (invCardEndId != null)
			{
				invCardEnd=(TurqInventoryCard)session.load(TurqInventoryCard.class, invCardEndId);
			}
			List cards=InvDALSearchTransaction.searchTransactionsRange(invCardStart, invCardEnd, curCardId, startDate, endDate, type.intValue());
			
			HashBag abstractBag=new HashBag();
			abstractBag.put(InvKeys.INV_CARDS, new HashMap());
			
			for(int k=0; k<cards.size(); k++)
			{
				Object[] cardInfo=(Object[])cards.get(k);
				Integer transId=(Integer)cardInfo[0];
				Date transDate=(Date)cardInfo[1];
				BigDecimal amountIn=(BigDecimal)cardInfo[2];
				BigDecimal amountOut=(BigDecimal)cardInfo[3];
				BigDecimal totalPrice=(BigDecimal)cardInfo[4];
				String invCode=(String)cardInfo[5];
				String invName=(String)cardInfo[6];
				
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_TRANS_ID,transId);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_TRANS_DATE,transDate);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_IN,amountIn);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_OUT,amountOut);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_TOTAL_PRICE,totalPrice);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_CODE,invCode);
				abstractBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_NAME,invName);				
			}
			
			return abstractBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryTransaction getInvTransByTransId(HashMap argMap) throws Exception
	{
		try
		{
			Integer transId=(Integer)argMap.get(EngKeys.TRANS_ID);
			return InvDALSearchTransaction.getInvTransByTransId(transId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchTransactionsAdvanced(HashMap argMap) throws Exception
	{
		try
		{
			String invCardCodeStart=(String)argMap.get(InvKeys.INV_CARD_CODE_START);
			String invCardCodeEnd=(String)argMap.get(InvKeys.INV_CARD_CODE_END);
			String invCardNameStart=(String)argMap.get(InvKeys.INV_CARD_NAME_START);
			String invCardNameEnd=(String)argMap.get(InvKeys.INV_CARD_NAME_END);
			TurqCurrentCard curCardStart=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_START);
			TurqCurrentCard curCardEnd=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_END);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqInventoryGroup invMainGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_MAIN_GROUP);
			TurqInventoryGroup invSubGroup=(TurqInventoryGroup)argMap.get(InvKeys.INV_SUB_GROUP);
			return InvDALSearchTransaction.searchTransactionsAdvanced(invCardCodeStart, invCardCodeEnd, invCardNameStart,
					invCardNameEnd, curCardStart, curCardEnd, startDate, endDate, type.intValue(), invMainGroup, invSubGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getInitialTransactions() throws Exception
	{
		HashBag initialBag=new HashBag();
		List initials=InvDALSearchTransaction.getInitialTransactions();
		
		initialBag.put(InvKeys.INV_TRANSACTIONS, new HashMap());
		
		for(int k=0; k<initials.size(); k++)
		{
			TurqInventoryTransaction invTrans=(TurqInventoryTransaction)initials.get(k);
			
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TRANS_ID,invTrans.getId());
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TRANS_DATE,invTrans.getTransactionsDate());
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TRANS_DEFINITION,invTrans.getDefinition());
			
			HashMap invCardMap=new HashMap();
			TurqInventoryCard invCard=invTrans.getTurqInventoryCard();
			
			invCardMap.put(InvKeys.INV_CARD_ID, invCard.getId());
			invCardMap.put(InvKeys.INV_CARD_CODE, invCard.getCardInventoryCode());
			invCardMap.put(InvKeys.INV_CARD_NAME, invCard.getCardName());
			invCardMap.put(InvKeys.INV_CARD_DEFINITION, invCard.getCardDefinition());
			
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_CARD, invCardMap);
			
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_AMOUNT_IN, invTrans.getAmountIn());
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_AMOUNT_OUT, invTrans.getAmountOut());
			initialBag.put(InvKeys.INV_TRANSACTIONS,k,InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY, invTrans.getTotalPriceInForeignCurrency());
		}
		
		return initialBag;
	}
}