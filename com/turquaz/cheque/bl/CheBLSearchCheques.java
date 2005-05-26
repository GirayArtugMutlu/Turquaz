package com.turquaz.cheque.bl;

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
import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSearchCheques
{
	public static List searchCheque(HashMap argMap) throws Exception
	{
		String portfoliNo = (String) argMap.get(EngKeys.DOCUMENT_NO);
		TurqCurrentCard curCard = (TurqCurrentCard) argMap.get(EngKeys.CURRENT_CARD);
		Integer status = (Integer) argMap.get(CheKeys.CHE_STATUS);
		Date startEnterDate = (Date) argMap.get(CheKeys.CHE_START_ENTER_DATE);
		Date endEnterDate = (Date) argMap.get(CheKeys.CHE_END_ENTER_DATE);
		Date startDueDate = (Date) argMap.get(CheKeys.CHE_START_DUE_DATE);
		Date endDueDate = (Date) argMap.get(CheKeys.CHE_END_DUE_DATE);
		Integer sorting=(Integer)argMap.get(CheKeys.CHE_SORT);		
		
		return CheDALSearch.searchCheque(portfoliNo, curCard, status, startEnterDate, endEnterDate,
				startDueDate, endDueDate,sorting);
	}

	public static List searchOwnCheques(HashMap argMap) throws Exception
	{
		TurqCurrentCard curCard = (TurqCurrentCard) argMap.get(EngKeys.CURRENT_CARD);
		Date startEnterDate = (Date) argMap.get(CheKeys.CHE_START_ENTER_DATE);
		Date endEnterDate = (Date) argMap.get(CheKeys.CHE_END_ENTER_DATE);
		Date startDueDate = (Date) argMap.get(CheKeys.CHE_START_DUE_DATE);
		Date endDueDate = (Date) argMap.get(CheKeys.CHE_END_DUE_DATE);
		Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
		
		TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
		
		Boolean sortByDate=(Boolean)argMap.get(BankKeys.BANK_SORT_BY_DATE);
		
		return CheDALSearch.searchOwnCheques(curCard, bankCard, startEnterDate, endEnterDate, startDueDate,
				endDueDate, sortByDate.booleanValue());
	}

	public static TurqAccountingAccount getChequeRollAccountingAccount(TurqChequeCheque cheque, int rollType) throws Exception
	{
		return CheDALSearch.getChequeRollAccountingAccount(cheque, rollType);
	}

	
	public static List getChequeHistory(HashMap argMap) throws Exception
	{
		
		
		  TurqChequeCheque cheque = (TurqChequeCheque)argMap.get(CheKeys.CHE_CHEQUE);
		
			return CheDALSearch.getChequeHistory(cheque);
		
	}
}