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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Session;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingJournal;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;

public class AccBLTransactionSearch
{
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
	
	public static HashBag getAccTransactionById(HashMap argMap)throws Exception
	{	
		Integer transId=(Integer)argMap.get(AccKeys.ACC_TRANS_ID);
		
		HashBag transBag=new HashBag();
		Session session=EngDALSessionFactory.getSession();
		TurqAccountingTransaction accTrans=(TurqAccountingTransaction)session.load(TurqAccountingTransaction.class,transId);
		
		transBag.put(AccKeys.ACC_TRANS_ID,accTrans.getId());
		transBag.put(AccKeys.ACC_TRANSACTION_DEFINITION,accTrans.getTransactionDescription());
		transBag.put(AccKeys.ACC_TRANSACTION_DOC_NO,accTrans.getTransactionDocumentNo());
		transBag.put(AccKeys.ACC_TRANS_DATE,accTrans.getTransactionsDate());
		transBag.put(AccKeys.ACC_TRANS_JOURNAL_ID,accTrans.getTurqAccountingJournal().getId());
		transBag.put(AccKeys.ACC_TRANS_MODULE_ID,accTrans.getTurqModule().getId());
		transBag.put(EngKeys.CURRENCY_ID,accTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getId());
		transBag.put(EngKeys.CURRENCY_ABBR,accTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		
		transBag.put(AccKeys.ACC_TRANSACTION_ROWS, new HashMap());
		
		List rowList=new ArrayList(accTrans.getTurqAccountingTransactionColumns());
		Collections.sort(rowList,new EngBLHibernateComparer());
		
		for(int row=0; row<rowList.size(); row++)
		{
			TurqAccountingTransactionColumn transRow=(TurqAccountingTransactionColumn)rowList.get(row);
			transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_TRANS_ROW_ID,transRow.getId());
			transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_TRANS_ROW_DEFINITION,transRow.getTransactionDefinition());
			transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,EngKeys.CREDIT_AMOUNT,transRow.getCreditAmount());
			transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,EngKeys.DEPT_AMOUNT,transRow.getDeptAmount());		
			
			HashMap accountMap=new HashMap();
			TurqAccountingAccount rowAcc=transRow.getTurqAccountingAccount();
			accountMap.put(AccKeys.ACC_ACCOUNT_ID,rowAcc.getId());
			accountMap.put(AccKeys.ACC_ACCOUNT_NAME,rowAcc.getAccountName());
			accountMap.put(AccKeys.ACC_ACCOUNT_CODE,rowAcc.getAccountCode());
			
			transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_ACCOUNT,accountMap);
		}
				
		return transBag;
	}
	
	//-Muhasebele?tirilmemi? fi?leri getirir...
	public static HashBag getUnsavedTransactions() throws Exception
	{
		try
		{
			HashBag transBag = new HashBag();
			List transList = AccDALTransactionSearch.getUnsavedTransactions();
			transBag.put(AccKeys.ACC_TRANSACTIONS,new HashMap());
			for (int k = 0; k <transList.size(); k++)
			{
				TurqAccountingTransaction trans=(TurqAccountingTransaction)transList.get(k);
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,AccKeys.ACC_TRANS_ID, trans.getId() );
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,AccKeys.ACC_TRANSACTION_DEFINITION, trans.getTransactionDescription());
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,AccKeys.ACC_TRANSACTION_DOC_NO, trans.getTransactionDocumentNo());
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,AccKeys.ACC_TRANS_DATE, trans.getTransactionsDate());
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,AccKeys.ACC_TRANS_TYPE_NAME,trans.getTurqAccountingTransactionType().getTypesName());
				
				BigDecimal total=new BigDecimal(0);
				Iterator it=trans.getTurqAccountingTransactionColumns().iterator();
				while(it.hasNext())
				{
					TurqAccountingTransactionColumn transRow=(TurqAccountingTransactionColumn)it.next();
					total = total.add(transRow.getRowsCreditInBaseCurrency());
				}				
				transBag.put(AccKeys.ACC_TRANSACTIONS,k,EngKeys.TOTAL_AMOUNT,total);
			}
			return transBag; 
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void addToJournal(HashMap argMap) throws Exception
	{
		Integer transId = (Integer) argMap.get(AccKeys.ACC_TRANS_ID);
		Date journalDate = (Date) argMap.get(AccKeys.ACC_TRANS_DATE);
		
		TurqAccountingTransaction trans=(TurqAccountingTransaction)EngDALSessionFactory.getSession().load(TurqAccountingTransaction.class,transId);
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

	/*AccUIAccountingAdvancedBalance*/
	public static List getTransactions(HashMap argMap )
			throws Exception
	{
		TurqAccountingAccount firstAccount =(TurqAccountingAccount) argMap.get(AccKeys.ACC_ACCOUNT_START);
		TurqAccountingAccount secondAccount = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT_END);
		Boolean initialAccounts = (Boolean)argMap.get(AccKeys.ACC_INITIAL_TRANS);
		Date startDate = (Date)argMap.get(AccKeys.ACC_START_DATE);
		Date endDate = (Date)argMap.get(AccKeys.ACC_END_DATE);
		
		
		return AccDALTransactionSearch.getTransactions(firstAccount, secondAccount, initialAccounts.booleanValue(), startDate, endDate);
		
	}

	public static void removeAccountingTransaction(HashMap argMap) throws Exception
	{
		Integer transId=(Integer)argMap.get(AccKeys.ACC_TRANS_ID);
		Session session=EngDALSessionFactory.getSession();
		
		TurqAccountingTransaction accTrans =(TurqAccountingTransaction)session.load(TurqAccountingTransaction.class,transId);
		AccDALTransactionSearch.deleteTransaction(accTrans);
	}
}