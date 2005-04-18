package com.turquaz.current.bl;

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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

public class CurBLSearchTransaction
{
	
	public static List searchCurrentTransaction(HashMap argMap )
			throws Exception
	{
		
		 Object curCard = argMap.get(EngKeys.CURRENT_CARD);
		 Object type = argMap.get(EngKeys.TYPE);
		 String docNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);
	
		return CurDALSearchTransaction.searchTransaction((TurqCurrentCard) curCard, (TurqCurrentTransactionType) type, docNo,
					definition, startDate, endDate);
		
	}

	public static TurqCurrentTransaction getCurTransByTransId(HashMap argMap) throws Exception
	{
		
		Integer transId = (Integer)argMap.get(EngKeys.TRANS_ID);
		
			return CurDALSearchTransaction.getCurTransByTransId(transId);
		
	}

	public static List getCurrentTransactions(HashMap argMap) throws Exception
	{
		
		TurqCurrentCard card = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
		Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		return CurDALSearchTransaction.getCurrentTransactions(card, startDate, endDate);
		
	}

	public static void updateCurrentTransaction(HashMap argMap) throws Exception
	{
		
		
		TurqCurrentCard curCard = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
		Date transDate = (Date)argMap.get(EngKeys.DATE);
		String documentNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Boolean isCredit =  (Boolean)argMap.get(CurKeys.CUR_IS_CREDIT);
		BigDecimal amount = (BigDecimal)argMap.get(CurKeys.CUR_TRANS_AMOUNT);
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)argMap.get(CurKeys.CUR_TRANSACTION); 
		
			Calendar cal = Calendar.getInstance();
			TurqCurrency currency = EngBLCommon.getBaseCurrency();
			curTrans.setTurqCurrentCard(curCard);
			curTrans.setTransactionsDate(transDate);
			curTrans.setTransactionsDocumentNo(documentNo);
			curTrans.setUpdatedBy(System.getProperty("user"));
			curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			int accTransType;
			if (isCredit.booleanValue())
			{
				accTransType = 1;
				curTrans.setTransactionsTotalCredit(amount);
				//      TODO current trans exRate
				curTrans.setTotalCreditInForeignCurrency(amount.multiply(EngBLCommon.getBaseCurrencyExchangeRate().getExchangeRatio())
						.setScale(2, EngBLCommon.ROUNDING_METHOD));
				curTrans.setTransactionsTotalDept(new BigDecimal(0));
				curTrans.setTotalDeptInForeignCurrency(new BigDecimal(0));
			}
			else
			{
				accTransType = 0;
				curTrans.setTransactionsTotalCredit(new BigDecimal(0));
				curTrans.setTotalCreditInForeignCurrency(new BigDecimal(0));
				//      TODO current trans exRate
				curTrans.setTotalDeptInForeignCurrency(amount.multiply(EngBLCommon.getBaseCurrencyExchangeRate().getExchangeRatio())
						.setScale(2, EngBLCommon.ROUNDING_METHOD));
				curTrans.setTransactionsTotalDept(amount);
			}
			EngDALCommon.updateObject(curTrans);
			/*
			 * accDalUpdate.updateTransaction(bankTrans.getTurqAccountingTransaction(),documentNo,transDate,accTransType); // Remove
			 * transaction rows blAccSearch.removeTransactionRows(bankTrans.getTurqAccountingTransaction()); // Save new Transaction Rows
			 * blTransAdd.saveAccountingCashTransactionRows(curCard,isCredit,amount,account,
			 * bankTrans.getTurqAccountingTransaction().getAccountingTransactionsId());
			 */
		
	}



	public static List getCurrentBalances(HashMap argMap) throws Exception
	{
		
		TurqCurrentCard curCardStart = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_START);
		TurqCurrentCard curCardEnd = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_END);
		Date startDate = (Date)argMap.get(EngKeys.DATE_START);
			return CurDALSearchTransaction.getCurrentBalances(curCardStart, curCardEnd, startDate);
		
	}

	public static List getInitialTransactions() throws Exception
	{
		try
		{
			return CurDALSearchTransaction.getInitialTransactions();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteInitialTransactions(TurqCurrentCard curCard) throws Exception
	{
		try
		{
			CurDALSearchTransaction.deleteInitialTransactions(curCard);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getCurrentCardAbstract(HashMap argMap) throws Exception
	{
		try
		{
			TurqCurrentCard curCardStart=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_START);
			TurqCurrentCard curCardEnd=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_END);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			BigDecimal minAmount=(BigDecimal)argMap.get(EngKeys.MIN_VALUE);	
			return CurDALSearchTransaction.getCurrentCardAbstract(curCardStart,curCardEnd, startDate, endDate, definition,minAmount);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}