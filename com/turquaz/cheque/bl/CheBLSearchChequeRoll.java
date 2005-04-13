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
import java.util.Iterator;
import java.util.List;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSearchChequeRoll
{
	
	public static List searchChequeRoll(HashMap argMap) throws Exception
	{
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);	
		 TurqChequeTransactionType type = (TurqChequeTransactionType)argMap.get(CheKeys.CHE_TRANS_TYPE); 
		
			return CheDALSearch.searchChequeRoll(rollNo, startDate, endDate, type);
		
	}

	public static List getTransactionTypes() throws Exception
	{
		
			return CheDALSearch.getTransactionTypes();
		
	}

	public static List getChequesInPortfolio() throws Exception
	{
		
			return CheDALSearch.getChequesInPortfolio();
		
	}

	public static List getChequesGivenToCurrent() throws Exception
	{
		
			return CheDALSearch.getChequesGivenToCurrent();
		
	}
	public static List getOwnChequesGivenToCurrent() throws Exception
	{
		
			return CheDALSearch.getOwnChequesGivenToCurrent();
		
	}

	public static TurqCurrentCard getCurrentCardOfCustomerCheque(HashMap argMap) throws Exception
	{
		TurqChequeCheque cheque =(TurqChequeCheque)argMap.get(CheKeys.CHE_CHEQUE);
			return CheDALSearch.getCurrentCardOfCustomerCheque(cheque);
		
	}
	public static TurqCurrentCard getCurrentCardOfGivenCheque(HashMap argMap) throws Exception
	{
		TurqChequeCheque cheque =(TurqChequeCheque)argMap.get(CheKeys.CHE_CHEQUE);
			return CheDALSearch.getCurrentCardOfGivenCheque(cheque);
		
	}

	public static List getChequesInBank() throws Exception
	{
		try
		{
			return CheDALSearch.getChequesInBank();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqChequeRoll getChequeRoll(HashMap argMap) throws Exception
	{
		 TurqChequeCheque cheque = (TurqChequeCheque)argMap.get(CheKeys.CHE_CHEQUE);
		 Integer rollType = (Integer)argMap.get(EngKeys.TYPE);
		
		CheDALUpdate.initChequeRolls(cheque);
		Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
		while (it.hasNext())
		{
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
			if (chequeInRoll.getTurqChequeRoll().getTurqChequeTransactionType().getId().intValue() == rollType.intValue())
			{
				return chequeInRoll.getTurqChequeRoll();
			}
		}
		return null;
	}
}