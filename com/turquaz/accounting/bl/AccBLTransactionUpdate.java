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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class AccBLTransactionUpdate
{	

	public static void updateTransaction(HashMap argMap) throws Exception
	{
		try
		{
			TurqAccountingTransaction transaction = (TurqAccountingTransaction) argMap
					.get(AccKeys.ACC_TRANSACTION);
			String docNo = (String) argMap.get(AccKeys.ACC_DOCUMENT_NO);
			Date transDate =(Date) argMap.get(AccKeys.ACC_TRANS_DATE);
			String definition = (String) argMap.get(AccKeys.ACC_DEFINITION);
			TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate) argMap
					.get(EngKeys.EXCHANGE_RATE);
			List transColumns = (List) argMap.get(AccKeys.ACC_TRANSACTIONS);
			transaction.setTransactionsDate(transDate);
			transaction.setTransactionDocumentNo(docNo);
			transaction.setTransactionDescription(definition);
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

	public static TurqAccountingTransaction getInitialTransaction() throws Exception
	{
		try
		{
			return AccDALTransactionUpdate.getInitialTransaction();
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