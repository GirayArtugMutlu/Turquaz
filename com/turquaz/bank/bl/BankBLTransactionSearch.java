package com.turquaz.bank.bl;

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
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqBanksCard;

public class BankBLTransactionSearch
{
	public static List searchtransaction(HashMap argMap) throws Exception
	{
		try
		{
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			return BankDALCommon.searchBankTransactions(docNo, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactions(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			return BankDALCommon.getTransactions(bankCard, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//Devreden Toplam
	public static List getDeferredTotal(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			return BankDALCommon.getDeferredTotal(bankCard, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//aC?L?S Degerleri
	public static List getBankInitialTransactions() throws Exception
	{
		try
		{
			return BankDALCommon.getBankInitialTransactions();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}