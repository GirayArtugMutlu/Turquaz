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
import com.turquaz.bank.BankKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqCurrentTransaction;

public class CurBLSearchTransaction
{
	
	public static HashBag searchCurrentTransaction(HashMap argMap )
			throws Exception
	{

		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		 Integer typeId = (Integer)argMap.get(EngKeys.TYPE_ID);
		 String docNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);
	
		 List list = CurDALSearchTransaction.searchTransaction((TurqCurrentCard) curCard,  typeId, docNo,
					definition, startDate, endDate);
		 HashBag returnBag = new HashBag();
		 returnBag.put(CurKeys.CUR_TRANSACTIONS,new HashMap());
		 for(int i=0;i<list.size();i++)
		 {
			 Object[]transInfo = (Object[])list.get(i);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,CurKeys.CUR_TRANSACTION_ID,transInfo[0]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DATE,transInfo[1]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DOCUMENT_NO,transInfo[2]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,CurKeys.CUR_CURRENT_CODE,transInfo[3]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,CurKeys.CUR_CURRENT_NAME,transInfo[4]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.TYPE_NAME,transInfo[5]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.TYPE_ID,transInfo[6]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DEFINITION,transInfo[7]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DEPT_AMOUNT,transInfo[8]);
			 returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.CREDIT_AMOUNT,transInfo[9]);	 
			 
		 } 
		 
		 
		 
		return returnBag;
		
	}

	public static TurqCurrentTransaction getCurTransByTransId(HashMap argMap) throws Exception
	{
		
		Integer transId = (Integer)argMap.get(EngKeys.TRANS_ID);
		
			return CurDALSearchTransaction.getCurTransByTransId(transId);
		
	}

	public static HashBag getCurrentTransactions(HashMap argMap) throws Exception
	{
		
        HashBag returnBag = new HashBag();
		
		
		
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard card=null;
		if(curCardId!=null)
		{
			card=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		
		returnBag.put(CurKeys.CUR_CURRENT_CODE,card.getCardsCurrentCode());
		
		Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		
		
		List list = CurDALSearchTransaction.getCurrentTransactions(card, startDate, endDate);
		returnBag.put(CurKeys.CUR_TRANSACTIONS,new HashMap());
		for(int i=0;i<list.size();i++)
		{
			TurqCurrentTransaction trans = (TurqCurrentTransaction)list.get(i);
			
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DATE,trans.getTransactionsDate());
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,CurKeys.CUR_TRANSACTION_ID,trans.getId());
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.TYPE_NAME,trans.getTurqCurrentTransactionType().getTransactionTypeName());
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DOCUMENT_NO,trans.getTransactionsDocumentNo());
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.CREDIT_AMOUNT,trans.getTransactionsTotalCredit());
			returnBag.put(CurKeys.CUR_TRANSACTIONS,i,EngKeys.DEPT_AMOUNT,trans.getTransactionsTotalDept());
						
		}
		
		return returnBag;
		
	}

	public static void updateCurrentTransaction(HashMap argMap) throws Exception
	{
		
		

		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		Date transDate = (Date)argMap.get(EngKeys.DATE);
		String documentNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Boolean isCredit =  (Boolean)argMap.get(CurKeys.CUR_IS_CREDIT);
		BigDecimal amount = (BigDecimal)argMap.get(CurKeys.CUR_TRANS_AMOUNT);
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		
		Integer curTransId =(Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		
		
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		
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
			
			Integer curGroupId = (Integer)argMap.get(CurKeys.CUR_GROUP_ID);
			TurqCurrentGroup curGroup=new TurqCurrentGroup();
			curGroup.setId(curGroupId);
			
			return CurDALSearchTransaction.getCurrentCardAbstract(curCardStart,curCardEnd, startDate, endDate, definition,minAmount,curGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getBankTransaction(HashMap argMap) throws Exception
	{
		
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction trans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		
		Object[] bankTrans = EngDALCommon.getBankTransaction(trans.getTurqEngineSequence());
		HashBag result = new HashBag();
		result.put(BankKeys.BANK_TRANS_BILL_ID,bankTrans[0]);
		result.put(EngKeys.TYPE_ID,bankTrans[1]);
		return result;
	}

	public static HashBag getCheqeuTransaction(HashMap argMap) throws Exception
	{
		HashBag result = new HashBag();
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction trans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		result.put(CheKeys.CHE_CHEQUE_ROLL_ID,EngDALCommon.getCheqeuTransaction(trans.getTurqEngineSequence()));
		return result;
	}

	public static HashBag getBillofCurrentTrans(HashMap argMap) throws Exception
	{
		HashBag result = new HashBag();
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction trans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		result.put(BillKeys.BILL_ID,EngDALCommon.getBillOfCurrentTrans(trans.getTurqEngineSequence()));
		return result;
	}

	public static HashBag getCashTransaction(HashMap argMap) throws Exception
	{
		HashBag result = new HashBag();
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction trans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		result.put(CashKeys.CASH_TRANSACTION_ID,EngDALCommon.getCashTransaction(trans.getTurqEngineSequence()));
		return result;
	}
}