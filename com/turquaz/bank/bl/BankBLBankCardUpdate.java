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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALBankCardUpdate;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.bl.EngBLBankCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

public class BankBLBankCardUpdate
{
	public static void updateBankCard(HashMap argMap) throws Exception
	{
		
		try
		{
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			String bankName=(String)argMap.get(BankKeys.BANK_NAME);
			String bankBranchName=(String)argMap.get(BankKeys.BANK_BRANCH_NAME);
			String bankAccountNo=(String)argMap.get(BankKeys.BANK_ACCOUNT_NO);
			TurqCurrency currency=(TurqCurrency)argMap.get(BankKeys.BANK_CURRENCY);
			String definition=(String)argMap.get(BankKeys.BANK_DEFINITION);
			String bankCode=(String)argMap.get(BankKeys.BANK_CODE);
			Map accountingAccounts=(Map)argMap.get(BankKeys.BANK_ACCOUNTING_ACCOUNTS);
			
			
			updateBankCardInfo( bankCard, bankName, bankBranchName, bankAccountNo, currency, definition, bankCode);
			if (!checkInitialTransaction( bankCard))
			{
				BankBLTransactionAdd.saveInitialBankTransaction(bankCard);
			}
			updateBankAccountingAccounts( bankCard, accountingAccounts);
			EngBLBankCards.RefreshContentAsistantMap();
			
		}
		catch (Exception ex)
		{
			
			throw ex;
		}
	}

	private static void updateBankCardInfo( TurqBanksCard bankCard, String bankName, String bankBranchName,
			String bankAccountNo, TurqCurrency currency, String definition, String bankCode) throws Exception
	{
		bankCard.setBankName(bankName);
		bankCard.setBankBranchName(bankBranchName);
		bankCard.setBankAccountNo(bankAccountNo);
		bankCard.setTurqCurrency(currency);
		bankCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		Calendar cal = Calendar.getInstance();
		bankCard.setLastModified(cal.getTime());
		bankCard.setBankDefinition(definition);
		bankCard.setBankCode(bankCode);
		EngDALCommon.updateObject( bankCard);
	}

	private static boolean checkInitialTransaction( TurqBanksCard bankCard) throws Exception
	{
		try
		{
			return BankDALCommon.checkInitialTransaction( bankCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateBankAccountingAccounts(TurqBanksCard curCard, Map accounts) throws Exception
	{
		Iterator it = curCard.getTurqBankAccountingAccounts().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
		BankBLBankCardAdd.saveBankAccountingAccounts( curCard, accounts);
	}

	public static Boolean hasTransaction(HashMap argMap) throws Exception
	{
		TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
		return BankDALBankCardUpdate.hasTransaction(bankCard);
	}

	public static void deleteBankCard(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			Iterator it = bankCard.getTurqBankAccountingAccounts().iterator();
			while (it.hasNext())
			{
				EngBLCommon.delete(it.next());
			}
			BankDALBankCardUpdate.deleteInitialTransaction(bankCard);
			EngDALCommon.deleteObject(bankCard);
			EngBLBankCards.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}