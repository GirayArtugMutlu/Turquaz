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
import java.util.Iterator;
import java.util.List;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBankAccountingAccount;
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
	public static List searchBankCardsWithCode(HashMap argMap)
	throws Exception
{
try
{
	String bankName=(String)argMap.get(BankKeys.BANK_NAME);
	String bankCode=(String)argMap.get(BankKeys.BANK_CODE);
	return BankDALBankCardSearch.searchBankCardsWithCode(bankName, bankCode);
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

	public static HashBag initializeBankCardById(HashMap argMap) throws Exception
	{
		try
		{
			Integer bankId=(Integer)argMap.get(BankKeys.BANK_ID);
			TurqBanksCard bankCard=BankDALBankCardSearch.initializeBankCardById(bankId);
			HashBag bankBag = new HashBag();
			bankBag.put(BankKeys.BANK_NAME,bankCard.getBankName());
			bankBag.put(BankKeys.BANK_BRANCH_NAME,bankCard.getBankBranchName());
			bankBag.put(BankKeys.BANK_ACCOUNT_NO,bankCard.getBankAccountNo());
			bankBag.put(BankKeys.BANK_DEFINITION,bankCard.getBankDefinition());
			bankBag.put(BankKeys.BANK_CODE,bankCard.getBankCode());
			bankBag.put(AdmKeys.ADM_CURRENCY_ABBR,bankCard.getTurqCurrency().getCurrenciesAbbreviation());
			Iterator it = bankCard.getTurqBankAccountingAccounts().iterator();
			while(it.hasNext())
			{
				TurqBankAccountingAccount bankAccount =(TurqBankAccountingAccount)it.next();
				bankBag.put(BankKeys.BANK_ACCOUNTING_ACCOUNTS,bankAccount.getTurqBankAccountingType().getId().intValue(),bankAccount.getTurqAccountingAccount().getId());				
				
				
			}
			
			
			
			
			return bankBag;
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