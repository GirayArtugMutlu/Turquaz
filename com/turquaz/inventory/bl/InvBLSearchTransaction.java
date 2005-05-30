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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALSearchTransaction;

public class InvBLSearchTransaction
{
	public static List searchTransactions(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(CurKeys.CUR_CARD);
			TurqInventoryCard invCard=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			return InvDALSearchTransaction.searchTransactions(curCard, invCard, startDate, endDate, type.intValue());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchTransactionsRange(HashMap argMap) throws Exception
	{
		try
		{
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(CurKeys.CUR_CARD);
			TurqInventoryCard invCardStart=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD_START);
			TurqInventoryCard invCardEnd=(TurqInventoryCard)argMap.get(InvKeys.INV_CARD_END);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			return InvDALSearchTransaction.searchTransactionsRange(invCardStart, invCardEnd, curCard, startDate, endDate, type.intValue());
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

	public static TurqConsignment getConsignment(HashMap argMap) throws Exception
	{
		try
		{
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			return InvDALSearchTransaction.getConsignment(seq);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBill getBill(HashMap argMap) throws Exception
	{
		try
		{
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			return InvDALSearchTransaction.getBill(seq);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInitialTransactions() throws Exception
	{
		return InvDALSearchTransaction.getInitialTransactions();
	}
}