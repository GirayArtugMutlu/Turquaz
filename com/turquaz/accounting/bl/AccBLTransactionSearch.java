package com.turquaz.accounting.bl;

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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingJournal;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class AccBLTransactionSearch
{
	public AccBLTransactionSearch()
	{
	}

	public static List searchAccTransaction(HashMap argMap) throws Exception
	{
		try
		{
			String docNo = (String)argMap.get(AccKeys.ACC_DOCUMENT_NO);
			Object startDate = argMap.get(AccKeys.ACC_START_DATE);
			Object endDate = argMap.get(AccKeys.ACC_END_DATE); 
			Boolean isGeneralTrans = (Boolean)argMap.get(AccKeys.ACC_IS_GENERAL);
			Boolean isCollect = (Boolean)argMap.get(AccKeys.ACC_IS_COLLECT);
			Boolean isPayment = (Boolean)argMap.get(AccKeys.ACC_IS_PAYMENT);
					
			List ls = AccDALTransactionSearch.searchTransaction(docNo, startDate, endDate, isGeneralTrans.booleanValue(), isCollect.booleanValue(), isPayment.booleanValue());
		    System.out.println(ls.size());
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentBalances(HashMap argMap)
			throws Exception
	{
		TurqAccountingAccount accountStart =(TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT_START);
		TurqAccountingAccount accountEnd =(TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT_END);
		Date startDate = (Date)argMap.get(AccKeys.ACC_START_DATE);  
				
			return AccDALTransactionSearch.getCurrentBalances(accountStart, accountEnd, startDate);
		
	}

	public static TurqCurrency getBaseCurrency() throws Exception
	{
		try
		{
			return AccDALTransactionSearch.getBaseCurrency();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate() throws Exception
	{
		try
		{
			return AccDALTransactionSearch.getBaseCurrencyExchangeRate();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrencies() throws Exception
	{
		
			return AccDALTransactionSearch.getCurrencies();	
		
	}
	
	public static List getAccTransInfo(Integer transId) throws Exception
	{
		try
		{
			return AccDALTransactionSearch.getAccTransInfo(transId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	//-Muhasebele?tirilmemi? fi?leri getirir...
	public static List getUnsavedTransactions() throws Exception
	{
		try
		{
			return AccDALTransactionSearch.getUnsavedTransactions();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void addToJournal(HashMap argMap) throws Exception
	{
		
		TurqAccountingTransaction trans = (TurqAccountingTransaction)argMap.get(AccKeys.ACC_TRANSACTION);
		Date journalDate = (Date)argMap.get(AccKeys.ACC_TRANS_DATE);
		
			TurqAccountingJournal journal = new TurqAccountingJournal();
			journal.setCreatedBy(System.getProperty("user"));
			journal.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			journal.setLastModified(cal.getTime());
			journal.setCreationDate(cal.getTime());
			journal.setJournalDate(journalDate);
			EngDALCommon.saveObject(journal);
			trans.setTurqAccountingJournal(journal);
			trans.setLastModified(cal.getTime());
			trans.setUpdatedBy(System.getProperty("user"));
			EngDALCommon.updateObject(trans);
		
	}

	public static List getTransactions(HashMap argMap )
			throws Exception
	{
		Object firstAccount = argMap.get(AccKeys.ACC_ACCOUNT_START);
		Object secondAccount = argMap.get(AccKeys.ACC_ACCOUNT_END);
		Boolean initialAccounts = (Boolean)argMap.get(AccKeys.ACC_INITIAL_TRANS);
		Date startDate = (Date)argMap.get(AccKeys.ACC_START_DATE);
		Date endDate = (Date)argMap.get(AccKeys.ACC_END_DATE);
		
		
			return AccDALTransactionSearch.getTransactions(firstAccount, secondAccount, initialAccounts.booleanValue(), startDate, endDate);
		
	}

	public static void removeAccountingTransaction(HashMap argMap) throws Exception
	{
		TurqAccountingTransaction accTrans =(TurqAccountingTransaction) argMap.get(AccKeys.ACC_TRANSACTION);
		AccDALTransactionSearch.deleteTransaction(accTrans);
	}
}