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
import com.turquaz.engine.dal.TurqAccountingAccount;

public class CashBLCashCardSearch
{
	

	public static List searchCashCard(HashMap argMap) throws Exception
	{
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		String cardName = (String)argMap.get(CashKeys.CASH_CARD_NAME);
		
			return CashDALCashCard.searchCashCard(account, cardName);
		
	}
}