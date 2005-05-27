package com.turquaz.cash.bl;

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
 * @author Onsel
 * @version $Id$
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;

public class CashBLCashTransactionSearch
{
	

	public static List searchCashTransactions(HashMap argMap) throws Exception
	{
		
		Integer cashCardId = (Integer)argMap.get(CashKeys.CASH_CARD_ID);
		TurqCashCard cashCard=(TurqCashCard)EngDALSessionFactory.getSession().load(TurqCashCard.class,cashCardId);
		
		Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		String definition = (String)argMap.get(EngKeys.DEFINITION);
		
		return CashDALCashCard.searchCashTransaction(cashCard, startDate, endDate, definition);
		
	}

	public static TurqCashTransaction initializeCashTransaction(HashMap argMap) throws Exception
	{
		
		Integer id = (Integer) argMap.get(EngKeys.TRANS_ID);
			return CashDALCashCard.initiliazeCashTrans(id);
		
	}

	public static void initializeTransaction(HashMap argMap) throws Exception
	{
		TurqCashTransaction cashTrans = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
			CashDALCashCard.initiliazeCashTrans(cashTrans);
	
	}

	public static List getTransactions(HashMap argMap) throws Exception
	{
		
		TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		
			return CashDALCashCard.getTransactions(cashCard, startDate, endDate);
	
	}
	public static List getInitialTransactions()throws Exception 
	{
		return CashDALCashCard.getInitialTransactions();
		
	}

	// Devreden
	public static List getDeferredTotal(HashMap argMap) throws Exception
	{
		TurqCashCard cashCard =(TurqCashCard)argMap.get(CashKeys.CASH_CARD);
	    Date endDate = (Date)argMap.get(EngKeys.DATE_END);
			
			return CashDALCashCard.getDeferredTotal(cashCard, endDate);
		
	}
}