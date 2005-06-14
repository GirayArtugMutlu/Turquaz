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
 * @author onsel
 * @version $Id$
 */
package com.turquaz.cash.bl;

import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;

public class CashBLCashCardSearch
{
	

	public static HashBag searchCashCard(HashMap argMap) throws Exception
	{
		Integer account_id = (Integer)argMap.get(AccKeys.ACC_ACCOUNT_ID);
		TurqAccountingAccount account=null;
	
		if(account_id != null)
		{
			account= new TurqAccountingAccount();
			account.setId(account_id);	
		}
		String cardName = (String)argMap.get(CashKeys.CASH_CARD_NAME);
		
		
		
		HashBag returnBag = new HashBag();
		
        returnBag.put(CashKeys.CASH_CARDS,new HashMap());
		
		List list = CashDALCashCard.searchCashCard(account, cardName);
		
		for(int i=0;i<list.size();i++)
		{
			TurqCashCard cashCard = (TurqCashCard)list.get(i);
			returnBag.put(CashKeys.CASH_CARDS,i,CashKeys.CASH_CARD_NAME,cashCard.getCashCardName());
			returnBag.put(CashKeys.CASH_CARDS,i,EngKeys.DEFINITION,cashCard.getCashCardDefinition());
			returnBag.put(CashKeys.CASH_CARDS,i,CashKeys.CASH_CARD_ID,cashCard.getId());
			returnBag.put(CashKeys.CASH_CARDS,i,AccKeys.ACC_ACCOUNT_CODE_ID,cashCard.getTurqAccountingAccount().getId());
            returnBag.put(CashKeys.CASH_CARDS,i,AccKeys.ACC_ACCOUNT_CODE,cashCard.getTurqAccountingAccount().getAccountCode());
            
			
		}
		
		return returnBag;

	}
}