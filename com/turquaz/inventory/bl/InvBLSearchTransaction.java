
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
* @author  Huseyin Ergun
* @version  $Id$
*/
import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.dal.InvDALSearchTransaction;

public class InvBLSearchTransaction {
   
	public static List searchTransactions(TurqCurrentCard card, TurqInventoryCard invCard, Date startDate,Date endDate, int type)throws Exception{
		try{			
			return InvDALSearchTransaction.searchTransactions(card,invCard,startDate,endDate,type);	
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	public static List searchTransactionsRange(TurqInventoryCard invCardStart,
			TurqInventoryCard invCardEnd, TurqCurrentCard curCard,
			Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return InvDALSearchTransaction.searchTransactionsRange(invCardStart,invCardEnd,curCard,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public static TurqInventoryTransaction getInvTransByTransId(Integer transId) throws Exception
	{
		try
		{
			return InvDALSearchTransaction.getInvTransByTransId(transId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public static List searchTransactionsAdvanced(String invCardCodeStart,String invCardCodeEnd,
			String invCardNameStart, String invCardNameEnd, 
			TurqCurrentCard curCardStart, TurqCurrentCard curCardEnd, 
			Date startDate,Date endDate, int type, TurqInventoryGroup invMainGroup,
			TurqInventoryGroup invSubGroup)throws Exception{
		try{
			
			return InvDALSearchTransaction.searchTransactionsAdvanced(invCardCodeStart,invCardCodeEnd,
					invCardNameStart,invCardNameEnd,curCardStart,curCardEnd,
					startDate,endDate,type,invMainGroup, invSubGroup);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public static TurqConsignment getConsignment(TurqEngineSequence seq) throws Exception
	{
		try {
			
			return InvDALSearchTransaction.getConsignment(seq);
		}
		
		catch (Exception ex) {
			throw ex;
		}
	}
	public static TurqBill getBill(TurqEngineSequence seq) throws Exception
	{
		try {
			
			return InvDALSearchTransaction.getBill(seq);
		}
		
		catch (Exception ex) {
			throw ex;
		}
	}
		
	
}
