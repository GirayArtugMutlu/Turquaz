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
 * @author Ceday
 * @version $Id$
 */
import java.util.HashMap;
import java.util.List;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

public class BankBLBankCardSearch
{
	public static List searchBankCards(HashMap argMap)
			throws Exception
	{
		try
		{
			String bankName=(String)argMap.get(BankKeys.BANK_NAME);
			String bankBranchName=(String)argMap.get(BankKeys.BANK_BRANCH_NAME);
			String bankAccountNo=(String)argMap.get(BankKeys.BANK_ACCOUNT_NO);
			TurqCurrency currency=(TurqCurrency)argMap.get(BankKeys.BANK_CURRENCY);
			return BankDALBankCardSearch.searchBankCards(bankName, bankBranchName, bankAccountNo, currency);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getBankCards() throws Exception
	{
		try
		{
			return BankDALBankCardSearch.getBankCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBanksCard initializeBankCardById(HashMap argMap) throws Exception
	{
		try
		{
			Integer bankId=(Integer)argMap.get(BankKeys.BANK_ID);
			TurqBanksCard bankCard=BankDALBankCardSearch.initializeBankCardById(bankId);
			return bankCard;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getAccountingAccount(TurqBanksCard bankCard, Integer type) throws Exception
	{
		return BankDALBankCardSearch.getBankAccountingAccount(bankCard, type);
	}
	
	public static TurqAccountingAccount getAccountingAccount(HashMap argMap) throws Exception
	{
		TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
		Integer type=(Integer)argMap.get(EngKeys.TYPE);
		return BankDALBankCardSearch.getBankAccountingAccount(bankCard, type);
	}
}