package com.turquaz.cash.bl;

import java.util.Calendar;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;

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
public class CashBLCashCardAdd
{
	CashDALCashCard dalCash = new CashDALCashCard();

	public CashBLCashCardAdd()
	{
	}

	public static void saveCashCard(String name, String definition, TurqAccountingAccount cashAccount) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqCashCard cashCard = new TurqCashCard();
			cashCard.setCashCardName(name);
			cashCard.setCashCardDefinition(definition);
			cashCard.setTurqAccountingAccount(cashAccount);
			cashCard.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cashCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cashCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(cashCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}