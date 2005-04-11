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

import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;

public class CashBLCashCardUpdate
{
	CashDALCashCard dalCash = new CashDALCashCard();


	public static void updateCashCard(HashMap argMap )
			throws Exception
	{
		
		TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		String name = (String)argMap.get(CashKeys.CASH_CARD_NAME);
		String definition = (String)argMap.get(EngKeys.DEFINITION);
		TurqAccountingAccount cashAccount = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		
		
			Calendar cal = Calendar.getInstance();
			cashCard.setCashCardName(name);
			cashCard.setCashCardDefinition(definition);
			cashCard.setTurqAccountingAccount(cashAccount);
			cashCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cashCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.updateObject(cashCard);
			
			if(!CashDALCashCard.checkInitialTransaction(cashCard))
			{
				CashBLCashCardAdd.saveInitialTransaction(cashCard);
				
			}
	
	}

	public static void deleteCashCard(HashMap argMap) throws Exception
	{
	
		
			EngDALCommon.deleteObject(argMap.get(CashKeys.CASH_CARD));
		
	}
}