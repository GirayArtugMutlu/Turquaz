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
 * @author Ehad Karacam
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingJournal;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqAccountingTransactionType;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class AccBLTransactionAdd
{
	public AccBLTransactionAdd()
	{
	}

	//Muhasebe fisi kalemlerini kaydet
	//TODO DONE
	public static void saveAccTransactionRows(Map deptAccounts, Map creditAccounts, Integer transId, boolean isSumRows, String definition,
			TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		Iterator it = deptAccounts.keySet().iterator();
		while (it.hasNext())
		{
			Integer accountId = (Integer) it.next();
			TurqAccountingAccount account = new TurqAccountingAccount();
			account.setId(accountId);
			List deptRows = (List) deptAccounts.get(accountId);
			if (isSumRows)
			{
				BigDecimal totalRow = new BigDecimal(0);
				for (int k = 0; k < deptRows.size(); k++)
				{
					totalRow = totalRow.add((BigDecimal) deptRows.get(k));
				}
				deptRows.clear();
				deptRows.add(totalRow);
			}
			for (int k = 0; k < deptRows.size(); k++)
			{
				TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
				transCounterRow.setTurqAccountingAccount(account);
				transCounterRow.setTransactionDefinition(definition);
				transCounterRow.setDeptAmount((BigDecimal) deptRows.get(k));
				transCounterRow.setCreditAmount(new BigDecimal(0));
				if (transCounterRow.getDeptAmount().doubleValue() > 0)
				{
					registerAccTransactionRow(transCounterRow, transId, exchangeRate);
				}
			}
		}
		it = creditAccounts.keySet().iterator();
		while (it.hasNext())
		{
			Integer accountId = (Integer) it.next();
			TurqAccountingAccount account = new TurqAccountingAccount();
			account.setId(accountId);
			List creditRows = (List) creditAccounts.get(accountId);
			if (isSumRows)
			{
				BigDecimal totalRow = new BigDecimal(0);
				for (int k = 0; k < creditRows.size(); k++)
				{
					totalRow = totalRow.add((BigDecimal) creditRows.get(k));
				}
				creditRows.clear();
				creditRows.add(totalRow);
			}
			for (int k = 0; k < creditRows.size(); k++)
			{
				TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
				transCounterRow.setTurqAccountingAccount(account);
				transCounterRow.setTransactionDefinition(definition);
				transCounterRow.setDeptAmount(new BigDecimal(0));
				transCounterRow.setCreditAmount((BigDecimal) creditRows.get(k));
				if (transCounterRow.getCreditAmount().doubleValue() > 0)
				{
					registerAccTransactionRow(transCounterRow, transId, exchangeRate);
				}
			}
		}
	}
	
	
	public static void saveAccountingTransactionRow(HashMap argMap)throws Exception
	{
		TurqAccountingTransactionColumn transRow = (TurqAccountingTransactionColumn)argMap.get(AccKeys.ACC_TRANS_ROW);
		Integer transID =(Integer)argMap.get(AccKeys.ACC_TRANS_ID);
		TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
		registerAccTransactionRow(transRow,transID,exchangeRate);
		
		
	}

	private static void registerAccTransactionRow(TurqAccountingTransactionColumn transRow, Integer transID,
			TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		try
		{
			if (transRow.getCreditAmount().compareTo(new BigDecimal(0)) < 1 && transRow.getDeptAmount().compareTo(new BigDecimal(0)) < 1)
			{
				return;
			}
			TurqAccountingTransaction trans = new TurqAccountingTransaction();
			trans.setId(transID);
			transRow.setTurqAccountingTransaction(trans);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			transRow.setRowsCreditInBaseCurrency(transRow.getCreditAmount().multiply(exchangeRate.getExchangeRatio()).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			transRow.setRowsDeptInBaseCurrency(transRow.getDeptAmount().multiply(exchangeRate.getExchangeRatio()).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			transRow.setLastModified(cal.getTime());
			transRow.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(transRow);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}	
	
	public static void saveAccTransactionFromUI(HashMap argMap)throws Exception{
		
		Date date = (Date) argMap.get(AccKeys.ACC_TRANS_DATE);
		String documentNo = (String)argMap.get(AccKeys.ACC_DOCUMENT_NO);
		Integer type = (Integer)argMap.get(AccKeys.ACC_TYPE);
		Integer moduleId = (Integer)argMap.get(AccKeys.ACC_MODULE_ID);
		Integer seqId = (Integer)argMap.get(AccKeys.ACC_SEQUENCE_ID);
		String definition = (String)argMap.get(AccKeys.ACC_DEFINITION);
		TurqCurrencyExchangeRate exRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		Map creditAccount = (Map)argMap.get(AccKeys.ACC_CREDIT_ACCOUNT_MAP);
		Map deptAccount = (Map)argMap.get(AccKeys.ACC_DEPT_ACCOUNT_MAP);
		Boolean sumRows = (Boolean)argMap.get(AccKeys.ACC_SUM_ROWS);
		
		saveAccTransaction(date, documentNo,type.intValue(),moduleId.intValue(),seqId,definition,exRate,creditAccount,deptAccount,sumRows.booleanValue());
		
	}

	public static boolean saveAccTransaction(Date date, String documentNo, int type, int moduleId, Integer docSeqId, String definition,
			TurqCurrencyExchangeRate exchangeRate, Map creditAccounts, Map deptAccounts, boolean isSumRows) throws Exception
	{
		try
		{
			TurqEngineSequence docSeq = new TurqEngineSequence();
			if (docSeqId == null)
			{
				TurqModule module = new TurqModule();
				module.setId(new Integer(EngBLCommon.MODULE_ACCOUNTING));
				docSeq.setTurqModule(module);
				EngDALCommon.saveObject(docSeq);
			}
			else
			{
				docSeq.setId(docSeqId);
			}
			TurqAccountingTransaction trans = new TurqAccountingTransaction();
			trans.setTurqEngineSequence(docSeq);
			trans.setTransactionDocumentNo(documentNo);
			trans.setTransactionDescription(definition);
			trans.setTransactionsDate(new java.sql.Date(date.getTime()));
			/**
			 * TODO Will Change in next version
			 */
			trans.setTurqCurrencyExchangeRate(exchangeRate);
			//Hangi modulde kaydedildigi
			TurqModule module = new TurqModule();
			module.setId(new Integer(moduleId));
			trans.setTurqModule(module);
			//Muhasebelestirilmemis.. o zaman yevmiye kaydi -1
			TurqAccountingJournal journal = new TurqAccountingJournal();
			journal.setId(new Integer(-1));
			trans.setTurqAccountingJournal(journal);
			//Fis tip
			TurqAccountingTransactionType transType = new TurqAccountingTransactionType();
			transType.setId(new Integer(type));
			trans.setTurqAccountingTransactionType(transType);
			trans.setCreatedBy(System.getProperty("user"));
			trans.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			trans.setLastModified(cal.getTime());
			trans.setCreationDate(cal.getTime());
			trans.setTransactionDescription(definition);
			EngDALCommon.saveObject(trans);
			//TODO Should return boolean
			saveAccTransactionRows(deptAccounts, creditAccounts, trans.getId(), isSumRows, definition, exchangeRate);
			return true;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}