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

import com.turquaz.accounting.AccKeys;
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

	public static HashBag getBankCards() throws Exception
	{
		try
		{
			HashBag returnBag = new HashBag();
			List list =  BankDALBankCardSearch.getBankCards();
			for(int i=0;i<list.size();i++)
			{
				TurqBanksCard bankCard = (TurqBanksCard)list.get(i);
				returnBag.put(BankKeys.BANK_CARDS,i,BankKeys.BANK_ID,bankCard.getId());
				returnBag.put(BankKeys.BANK_CARDS,i,BankKeys.BANK_CODE,bankCard.getBankCode());
				returnBag.put(BankKeys.BANK_CARDS,i,BankKeys.BANK_NAME,bankCard.getBankName());
				returnBag.put(BankKeys.BANK_CARDS,i,BankKeys.BANK_BRANCH_NAME,bankCard.getBankBranchName());
				
			}
			
			return returnBag;
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
	
	public static HashBag getAccountingAccount(HashMap argMap) throws Exception
	{
		Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
		TurqBanksCard bankCard = new TurqBanksCard();
		bankCard.setId(bankCardId);
		Integer type=(Integer)argMap.get(EngKeys.TYPE);
		HashBag bag = new HashBag();
		bag.put(AccKeys.ACC_ACCOUNT,BankDALBankCardSearch.getBankAccountingAccount(bankCard, type).getId());
		return bag;
	}
}