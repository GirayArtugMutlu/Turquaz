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
import java.util.List;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.current.dal.CurDALTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

public class CurBLSearchTransaction
{
	CurDALTransactionUpdate dalUpdate = new CurDALTransactionUpdate();
	AccBLTransactionSearch blAccSearch = new AccBLTransactionSearch();
	CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();

	public CurBLSearchTransaction()
	{
	}

	public static List searchCurrentTransaction(Object curCard, Object type, String docNo, String definition, Date startDate, Date endDate)
			throws Exception
	{
		try
		{
			return CurDALSearchTransaction.searchTransaction((TurqCurrentCard) curCard, (TurqCurrentTransactionType) type, docNo,
					definition, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentTransaction getCurTransByTransId(Integer transId) throws Exception
	{
		try
		{
			return CurDALSearchTransaction.getCurTransByTransId(transId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentTransactions(TurqCurrentCard card, Date startDate, Date endDate) throws Exception
	{
		try
		{
			return CurDALSearchTransaction.getCurrentTransactions(card, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateCurrentTransaction(TurqCurrentCard curCard, Date transDate, String documentNo, boolean isCredit,
			BigDecimal amount, TurqAccountingAccount account, TurqCurrentTransaction curTrans) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqCurrency currency = EngBLCommon.getBaseCurrency();
			curTrans.setTurqCurrentCard(curCard);
			curTrans.setTransactionsDate(transDate);
			curTrans.setTransactionsDocumentNo(documentNo);
			curTrans.setUpdatedBy(System.getProperty("user"));
			curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			int accTransType;
			if (isCredit)
			{
				accTransType = 1;
				curTrans.setTransactionsTotalCredit(amount);
				//      TODO current trans exRate
				curTrans.setTotalCreditInForeignCurrency(amount.multiply(EngBLCommon.getBaseCurrencyExchangeRate().getExchangeRatio())
						.setScale(2, BigDecimal.ROUND_HALF_DOWN));
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
						.setScale(2, BigDecimal.ROUND_HALF_DOWN));
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
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteCurrentTransaction(TurqCurrentTransaction curTrans) throws Exception
	{
		try
		{
			/*
			 * //remove accounting transaction rows blAccSearch.removeTransactionRows(bankTrans.getTurqAccountingTransaction()); //remove
			 * accounting transaction dalUpdate.deleteObject(bankTrans);
			 * dalUpdate.deleteObject(bankTrans.getTurqAccountingTransaction()); //remove currren transaction
			 */
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentBalances(TurqCurrentCard curCard, TurqCurrentCard curCard2, Date startDate) throws Exception
	{
		try
		{
			return CurDALSearchTransaction.getCurrentBalances(curCard, curCard2, startDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
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

	public static void deleteInitialTransactions(TurqCurrentCard curCard) throws Exception
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
}