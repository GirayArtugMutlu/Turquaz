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
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionType;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class AccBLTransactionUpdate
{
	public AccBLTransactionUpdate()
	{
	}

	//TODO DONE
	public static void updateTransaction(TurqAccountingTransaction transaction, String docNo, Object transDate, String definition,
			TurqCurrencyExchangeRate exchangeRate, Map creditAccounts, Map deptAccounts, boolean isSumRows) throws Exception
	{
		Date date = new Date(((java.util.Date) transDate).getTime());
		transaction.setTransactionsDate(date);
		transaction.setTransactionDocumentNo(docNo);
		transaction.setTransactionDescription(definition);
		transaction.setTurqCurrencyExchangeRate(exchangeRate);
		transaction.setUpdatedBy(System.getProperty("user"));
		Calendar cal = Calendar.getInstance();
		transaction.setLastModified(cal.getTime());
		try
		{
			EngDALCommon.updateObject(transaction);
			deleteTransactionRows(transaction);
			AccBLTransactionAdd.saveAccTransactionRows(deptAccounts, creditAccounts, transaction.getId(), isSumRows, definition,
					exchangeRate);
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

	public static void updateTransaction(TurqAccountingTransaction transaction, String docNo, java.util.Date transDate, int transType,
			String definition, TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		TurqAccountingTransactionType accTransType = new TurqAccountingTransactionType();
		accTransType.setId(new Integer(transType));
		transaction.setTurqAccountingTransactionType(accTransType);
		transaction.setTransactionsDate(transDate);
		transaction.setTransactionDocumentNo(docNo);
		transaction.setTransactionDescription(definition);
		transaction.setTurqCurrencyExchangeRate(exchangeRate);
		transaction.setUpdatedBy(System.getProperty("user"));
		Calendar cal = Calendar.getInstance();
		transaction.setLastModified(cal.getTime());
		try
		{
			EngDALCommon.updateObject(transaction);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void delete(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initiliazeTransactionRows(TurqAccountingTransaction trans) throws Exception
	{
		try
		{
			AccDALTransactionUpdate.initializeTransactionRows(trans);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}