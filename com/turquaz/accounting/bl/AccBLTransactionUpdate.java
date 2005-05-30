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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class AccBLTransactionUpdate
{	

	public static void updateTransaction(HashMap argMap) throws Exception
	{
		try
		{
			Integer transId = (Integer) argMap.get(AccKeys.ACC_TRANS_ID);
			String docNo = (String) argMap.get(AccKeys.ACC_DOCUMENT_NO);
			Date transDate =(Date) argMap.get(AccKeys.ACC_TRANS_DATE);
			String definition = (String) argMap.get(AccKeys.ACC_DEFINITION);
			Integer exchangeRateId = (Integer) argMap.get(EngKeys.EXCHANGE_RATE_ID);
			List transColumns = (List) argMap.get(AccKeys.ACC_TRANSACTIONS);
			
			TurqAccountingTransaction transaction=new TurqAccountingTransaction();
			transaction.setId(transId);
			EngDALSessionFactory.getSession().refresh(transaction);
			
			transaction.setTransactionsDate(transDate);
			transaction.setTransactionDocumentNo(docNo);
			transaction.setTransactionDescription(definition);
			
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)EngDALSessionFactory.getSession().load(TurqCurrencyExchangeRate.class,exchangeRateId);
			
			transaction.setTurqCurrencyExchangeRate(exchangeRate);
			transaction.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			transaction.setLastModified(cal.getTime());
			EngDALCommon.updateObject(transaction);
			deleteTransactionRows(transaction);
			AccBLTransactionAdd.saveAccTransactionRows(transColumns, transaction.getId(), exchangeRate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteTransactionRows(TurqAccountingTransaction transaction) throws Exception
	{
		Set transactionRows = transaction.getTurqAccountingTransactionColumns();
		Iterator it = transactionRows.iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}

	public static HashBag getInitialTransaction() throws Exception
	{
		try
		{
			HashBag transBag=new HashBag();
			TurqAccountingTransaction trans=AccDALTransactionUpdate.getInitialTransaction();
			
			transBag.put(AccKeys.ACC_TRANS_ID,trans.getId());
			transBag.put(AccKeys.ACC_TRANSACTION_DEFINITION,trans.getTransactionDescription());
			transBag.put(AccKeys.ACC_TRANSACTION_DOC_NO,trans.getTransactionDocumentNo());
			transBag.put(AccKeys.ACC_TRANSACTION_DATE,trans.getTransactionsDate());
			transBag.put(EngKeys.EXCHANGE_CURRENCY_ID,trans.getTurqCurrencyExchangeRate().getId());
			transBag.put(EngKeys.EXCHANGE_CURRENCY_ABBR,trans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			
			ArrayList transRows=new ArrayList(trans.getTurqAccountingTransactionColumns());
			Collections.sort(transRows,new EngBLHibernateComparer());

			for (int row=0; row<transRows.size(); row++ )
			{
				TurqAccountingTransactionColumn transRow=(TurqAccountingTransactionColumn)transRows.get(row);
				transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_TRANS_ROW_ID,transRow.getId());
				transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_TRANS_ROW_DEFINITION,transRow.getTransactionDefinition());
				transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,EngKeys.CREDIT_AMOUNT,transRow.getCreditAmount());
				transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,EngKeys.DEPT_AMOUNT,transRow.getDeptAmount());	
				
				HashMap accountMap=new HashMap();
				accountMap.put(AccKeys.ACC_ACCOUNT_ID,transRow.getTurqAccountingAccount().getId());
				accountMap.put(AccKeys.ACC_ACCOUNT_NAME,transRow.getTurqAccountingAccount().getAccountName());
				accountMap.put(AccKeys.ACC_ACCOUNT_CODE,transRow.getTurqAccountingAccount().getAccountCode());
				
				transBag.put(AccKeys.ACC_TRANSACTION_ROWS,row,AccKeys.ACC_ACCOUNT,accountMap);

			}		
			
			return transBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	

	public static void initiliazeTransactionRows(HashMap argMap) throws Exception
	{
		
		TurqAccountingTransaction trans = (TurqAccountingTransaction)argMap.get(AccKeys.ACC_TRANSACTION);
			AccDALTransactionUpdate.initializeTransactionRows(trans);
		
	}
}