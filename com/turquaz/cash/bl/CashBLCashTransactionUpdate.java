package com.turquaz.cash.bl;

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
 * @author Onsel
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;

public class CashBLCashTransactionUpdate
{
	public CashBLCashTransactionUpdate()
	{
	}

	public static TurqCurrentCard getCurrentCard(HashMap argMap) throws Exception
	{
		
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			return CashDALCashCard.getCurrentCard(seq);
		
	}

	public static void deleteOnlyCashTransaction(TurqCashTransaction cashTrans) throws Exception
	{
		
			CashDALCashCard.initiliazeCashTrans(cashTrans);
			Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			EngDALCommon.deleteObject(cashTrans);
	
	}

	public static void deleteChequeCashTrans(TurqCashTransaction cashTrans) throws Exception
	{
		try
		{
			// if it is a current transaction the delete Current Transactions
			if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_COLLECT
					|| cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
			{
				//delete current Transactions..
				Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
				while (it.hasNext())
				{
					EngDALCommon.deleteObject(it.next());
				}
			}
			//delete cash Transaction rows...
			Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			EngDALCommon.deleteObject(cashTrans);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteCashTrans(HashMap argMap) throws Exception
	{
		
		 TurqCashTransaction cashTrans = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
		
			// if it is a current transaction the delete Current Transactions
			if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_COLLECT
					|| cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
			{
				//delete current Transactions..
				Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
				while (it.hasNext())
				{
					EngDALCommon.deleteObject(it.next());
				}
			}
			//delete cash Transaction rows...
			Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			CashDALCashCard.deleteAccountingTransaction(cashTrans);
			EngDALCommon.deleteObject(cashTrans);
		
	}

	
	public static void updateCashTrans(HashMap argMap)throws Exception
	{
		
		TurqCashTransaction cashTrans  = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
		 TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		 Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 TurqCurrentCard current = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD); 
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
		
			Calendar cal = Calendar.getInstance();
			//delete current Transactions..
			Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash Transaction rows...
			it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			CashDALCashCard.deleteAccountingTransaction(cashTrans);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
			cashTransRow.setTurqCashCard(cashCard);
			cashTransRow.setCreatedBy(System.getProperty("user"));
			cashTransRow.setUpdatedBy(System.getProperty("user"));
			cashTransRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTransRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			cashTransRow.setTransactionDefinition(definition);
			cashTransRow.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(current,
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL));
			TurqAccountingAccount cashAccount = cashCard.getTurqAccountingAccount();
			TurqAccountingAccount currentAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(current,
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			String currentTransDefinition = "";
			int accTransType = 0;
			boolean currentTransType = false; // Credit or Debit
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_COLLECT)
			{
				prepareAccountingMaps(currentAccount, cashAccount, totalAmount, creditAccounts, deptAccounts);
				cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setCreditAmount(new BigDecimal(0));
				cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
				cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
				currentTransDefinition = current.getCardsName() + " 'den Nakit";
			}
			else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
			{
				prepareAccountingMaps(cashAccount, currentAccount, totalAmount, creditAccounts, deptAccounts);
				cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
				cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setDeptAmount(new BigDecimal(0));
				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
				currentTransDefinition = current.getCardsName() + " 'e Nakit";
			}
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.updateObject(cashTrans);
			/**
			 * Save Cash Transaction Row
			 */
			cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
			cashTransRow.setTurqCashTransaction(cashTrans);
			EngDALCommon.saveObject(cashTransRow);
			/**
			 * Save Current transaction
			 */
			CurBLCurrentTransactionAdd.saveCurrentTransaction(current, transDate, document_no, currentTransType, totalAmount,
					new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CASH, cashTrans.getTurqEngineSequence().getId(),
					currentTransDefinition, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, cashTrans.getTurqEngineSequence()
					.getTurqModule().getId().intValue(), cashTrans.getTurqEngineSequence().getId(), definition, exchangeRate,
					creditAccounts, deptAccounts, true);
	
	}

	public static void prepareAccountingMaps(TurqAccountingAccount creditAccount, TurqAccountingAccount deptAccount, BigDecimal amount, Map creditAccounts,
			Map deptAccounts) throws Exception
	{
		creditAccounts.clear();
		deptAccounts.clear();
		if(creditAccount ==null||deptAccount==null)
		{
			return;
		}
		
		List creditRows = (List) creditAccounts.get(creditAccount.getId());
		if (creditRows == null)
		{
			creditRows = new ArrayList();
			creditAccounts.put(creditAccount.getId(), creditRows);
		}
		creditRows.add(amount);
		List deptRows = (List) deptAccounts.get(deptAccount.getId());
		if (deptRows == null)
		{
			deptRows = new ArrayList();
			deptAccounts.put(deptAccount.getId(), deptRows);
		}
		deptRows.add(amount);
	}

	
	public static void updateOtherTrans(HashMap argMap)
			throws Exception
	{
		
			TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
			TurqCashTransaction cashTrans  = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
		
		 Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 
		 TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
		
		
			Calendar cal = Calendar.getInstance();
			//delete current Transactions..
			Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash Transaction rows...
			it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			CashDALCashCard.deleteAccountingTransaction(cashTrans);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
			cashTransRow.setTurqCashCard(cashCard);
			cashTransRow.setCreatedBy(System.getProperty("user"));
			cashTransRow.setUpdatedBy(System.getProperty("user"));
			cashTransRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTransRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			cashTransRow.setTransactionDefinition(definition);
			cashTransRow.setTurqAccountingAccount(account);
			TurqAccountingAccount cashAccount = cashCard.getTurqAccountingAccount();
			String currentTransDefinition = "";
			int accTransType = 0;
			boolean currentTransType = false; // Credit or Debit
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_COLLECT)
			{
				prepareAccountingMaps(account, cashAccount, totalAmount, creditAccounts, deptAccounts);
				cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setDeptAmount(new BigDecimal(0));
				cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
				cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
			}
			else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_PAYMENT)
			{
				prepareAccountingMaps(cashAccount, account, totalAmount, creditAccounts, deptAccounts);
				cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
				cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setCreditAmount(new BigDecimal(0));
				cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
			}
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.updateObject(cashTrans);
			/**
			 * Save Cash Transaction Row
			 */
			cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
			cashTransRow.setTurqCashTransaction(cashTrans);
			EngDALCommon.saveObject(cashTransRow);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, cashTrans.getTurqEngineSequence()
					.getTurqModule().getId().intValue(), cashTrans.getTurqEngineSequence().getId(), definition, exchangeRate,
					creditAccounts, deptAccounts, true);
		
	}

	
	public static void updateTransBetweenCards(HashMap argMap) throws Exception
	{
		
		TurqCashTransaction cashTrans  = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
		TurqCashCard cashCardWithDebt= (TurqCashCard)argMap.get(CashKeys.CASH_CARD_WITH_DEPT);
		TurqCashCard cashCardWithCredit =(TurqCashCard)argMap.get(CashKeys.CASH_CARD_WITH_CREDIT);
		Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 TurqCurrentCard current = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD); 
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
			Calendar cal = Calendar.getInstance();
			//delete current Transactions..
			Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash Transaction rows...
			it = cashTrans.getTurqCashTransactionRows().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			CashDALCashCard.deleteAccountingTransaction(cashTrans);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRowWithDept = new TurqCashTransactionRow();
			cashTransRowWithDept.setTurqCashCard(cashCardWithDebt);
			cashTransRowWithDept.setCreatedBy(System.getProperty("user"));
			cashTransRowWithDept.setUpdatedBy(System.getProperty("user"));
			cashTransRowWithDept.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTransRowWithDept.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			cashTransRowWithDept.setTransactionDefinition(definition);
			cashTransRowWithDept.setTurqAccountingAccount(cashCardWithCredit.getTurqAccountingAccount());
			/** ********************************** */
			TurqCashTransactionRow cashTransRowWithCredit = new TurqCashTransactionRow();
			cashTransRowWithCredit.setTurqCashCard(cashCardWithCredit);
			cashTransRowWithCredit.setCreatedBy(System.getProperty("user"));
			cashTransRowWithCredit.setUpdatedBy(System.getProperty("user"));
			cashTransRowWithCredit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTransRowWithCredit.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			cashTransRowWithCredit.setTransactionDefinition(definition);
			cashTransRowWithCredit.setTurqAccountingAccount(cashCardWithDebt.getTurqAccountingAccount());
			int accTransType = 0;
			boolean currentTransType = false; // Credit or Debit
			cashTransRowWithDept.setCreditAmountInForeignCurrency(totalAmount);
			cashTransRowWithDept.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			cashTransRowWithDept.setDeptAmount(new BigDecimal(0));
			cashTransRowWithDept.setDeptAmountInForeignCurrency(new BigDecimal(0));
			cashTransRowWithCredit.setDeptAmountInForeignCurrency(totalAmount);
			cashTransRowWithCredit.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			cashTransRowWithCredit.setCreditAmountInForeignCurrency(new BigDecimal(0));
			cashTransRowWithCredit.setCreditAmount(new BigDecimal(0));
			accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.updateObject(cashTrans);
			/**
			 * Save Cash Transaction Row
			 */
			cashTransRowWithDept.setTurqCashTransaction(cashTrans);
			cashTransRowWithCredit.setTurqCashTransaction(cashTrans);
			cashTransRowWithDept.setTurqCurrencyExchangeRate(exchangeRate);
			cashTransRowWithCredit.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(cashTransRowWithDept);
			EngDALCommon.saveObject(cashTransRowWithCredit);
			/**
			 * Save Accounting Transaction
			 */
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			prepareAccountingMaps(cashCardWithDebt.getTurqAccountingAccount(), cashCardWithCredit.getTurqAccountingAccount()
					, totalAmount, creditAccounts, deptAccounts);
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, cashTrans.getTurqEngineSequence()
					.getTurqModule().getId().intValue(), cashTrans.getTurqEngineSequence().getId(), definition, exchangeRate,
					creditAccounts, deptAccounts, true);
	
	}
}