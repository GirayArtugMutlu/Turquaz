package com.turquaz.bank.bl;

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
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqBanksTransactionType;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.lang.BankLangKeys;

public class BankBLTransactionUpdate
{
	public static TurqBanksTransactionBill initializeTransaction(HashMap argMap) throws Exception
	{
		try
		{
			Integer transId=(Integer)argMap.get(EngKeys.TRANS_ID);
			return BankDALCommon.initializeTransaction(transId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initializeTransaction(TurqBanksTransactionBill transBill) throws Exception
	{
		try
		{
			BankDALCommon.initializeTransaction(transBill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static void updateTransferBetweenBanks(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksTransactionBill bankTransBill=(TurqBanksTransactionBill)argMap.get(BankKeys.BANK_TRANS_BILL);
			TurqBanksCard bankCardWithDept=(TurqBanksCard)argMap.get(BankKeys.BANK_CARD_WITH_DEPT);
			TurqBanksCard bankCardWithCredit=(TurqBanksCard)argMap.get(BankKeys.BANK_CARD_WITH_CREDIT);
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);			
			
			// delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
			it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				AccDALTransactionSearch.deleteTransaction((TurqAccountingTransaction) it.next());
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(new Integer(EngBLCommon.BANK_TRANS_BETWEEN_BANKS));
			bankTransBill.setTransactionBillDate(transDate);
			bankTransBill.setTransactionBillDefinition(definition);
			bankTransBill.setTransactionBillNo(docNo);
			bankTransBill.setTurqBanksTransactionType(transType);
			bankTransBill.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankTransBill.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankTransBill.setLastModified(Calendar.getInstance().getTime());
			bankTransBill.setCreationDate(Calendar.getInstance().getTime());
			/*
			 * Transaction Rows
			 */
			TurqBanksTransaction transRowCredit = new TurqBanksTransaction();
			transRowCredit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRowCredit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRowCredit.setLastModified(Calendar.getInstance().getTime());
			transRowCredit.setCreationDate(Calendar.getInstance().getTime());
			transRowCredit.setTurqBanksCard(bankCardWithCredit);
			transRowCredit.setCreditAmountInForeignCurrency(totalAmount);
			transRowCredit.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio())
					.setScale(2, EngBLCommon.ROUNDING_METHOD));
			transRowCredit.setDeptAmountInForeignCurrency(new BigDecimal(0));
			transRowCredit.setDeptAmount(new BigDecimal(0));
			TurqBanksTransaction transRowDebit = new TurqBanksTransaction();
			transRowDebit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRowDebit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRowDebit.setLastModified(Calendar.getInstance().getTime());
			transRowDebit.setCreationDate(Calendar.getInstance().getTime());
			transRowDebit.setTurqBanksCard(bankCardWithDept);
			transRowDebit.setCreditAmountInForeignCurrency(new BigDecimal(0));
			transRowDebit.setCreditAmount(new BigDecimal(0));
			transRowDebit.setDeptAmountInForeignCurrency(totalAmount);
			transRowDebit.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			/**
			 * Save transaction bill
			 */
			EngDALCommon.updateObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRowCredit.setTurqBanksTransactionBill(bankTransBill);
			transRowCredit.setTurqCurrencyExchangeRate(exchangeRate);
			transRowDebit.setTurqBanksTransactionBill(bankTransBill);
			transRowDebit.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRowCredit);
			EngDALCommon.saveObject(transRowDebit);
			TurqAccountingAccount creditAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithCredit,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			TurqAccountingAccount deptAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithDept,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			prepareAccountingMaps(deptAccount, creditAccount, totalAmount, creditAccounts, deptAccounts);
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			String accounting_definition = BankLangKeys.STR_INITIAL_TRANSACTION + definition;
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, bankTransBill.getTurqEngineSequence().getTurqModule()
					.getId().intValue(), bankTransBill.getTurqEngineSequence().getId(), accounting_definition, exchangeRate,
					creditAccounts, deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void prepareAccountingMaps(TurqAccountingAccount creditAccount,TurqAccountingAccount deptAccount, BigDecimal amount, Map creditAccounts,
			Map deptAccounts) throws Exception
	{
		deptAccounts.clear();
		creditAccounts.clear();
		if(deptAccount==null || creditAccount==null)
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

	
	public static void updateCashTransactionBill(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqBanksTransactionBill bankTransBill=(TurqBanksTransactionBill)argMap.get(BankKeys.BANK_TRANS_BILL);
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			TurqCashCard cashCard=(TurqCashCard)argMap.get(CashKeys.CASH_CARD);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);	
			
			//delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
			while (it.hasNext())
			{
				CashBLCashTransactionUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it.next());
			}
			//delete accounting transactions
			AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
			it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				AccDALTransactionSearch.deleteTransaction((TurqAccountingTransaction) it.next());
			}
			bankTransBill.setTransactionBillDate(transDate);
			bankTransBill.setTransactionBillDefinition(definition);
			bankTransBill.setTransactionBillNo(docNo);
			bankTransBill.setUpdatedBy(System.getProperty("user"));
			bankTransBill.setLastModified(Calendar.getInstance().getTime());
			/*
			 * Transaction Rows
			 */
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			String currentTransDefinition = "";
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			boolean currentTransType = false; // Credit or Debit
			int cashTransType = 0;
			int type = bankTransBill.getTurqBanksTransactionType().getId().intValue();
			//Para yatirma
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			if (type == EngBLCommon.BANK_TRANS_CASH_DEPOSIT)
			{
				prepareAccountingMaps(cashCard.getTurqAccountingAccount(), bankAccount, totalAmount, creditAccounts,
						deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
				cashTransType = EngBLCommon.CASH_CURRENT_PAYMENT;
			}
			//Para cekme
			else if (type == EngBLCommon.BANK_TRANS_CASH_DRAW)
			{
				prepareAccountingMaps(bankAccount, cashCard.getTurqAccountingAccount(), totalAmount, deptAccounts,
						creditAccounts);
				transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				transRow.setDeptAmount(new BigDecimal(0));
				transRow.setCreditAmountInForeignCurrency(totalAmount);
				transRow
						.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
								EngBLCommon.ROUNDING_METHOD));
				cashTransType = EngBLCommon.CASH_CURRENT_COLLECT;
			}
			/**
			 * Save transaction bill
			 */
			EngDALCommon.updateObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRow);
			CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();
			/**
			 * Save Cash Transaction
			 */
			List totals = new ArrayList();
			totals.add(totalAmount);
			CashBLCashTransactionAdd.saveCashTransaction(cashCard, bankTransBill.getTurqEngineSequence(), cashTransType, transDate,
					definition, docNo, totals, bankAccount, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, bankTransBill.getTurqEngineSequence().getTurqModule()
					.getId().intValue(), bankTransBill.getTurqEngineSequence().getId(), definition, exchangeRate, creditAccounts,
					deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static void updateOtherTransactionBill(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksTransactionBill bankTransBill=(TurqBanksTransactionBill)argMap.get(BankKeys.BANK_TRANS_BILL);
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			TurqAccountingAccount account=(TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);	
			
			
			//delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
			it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				AccDALTransactionSearch.deleteTransaction((TurqAccountingTransaction) it.next());
			}
			bankTransBill.setTransactionBillDate(transDate);
			bankTransBill.setTransactionBillDefinition(definition);
			bankTransBill.setTransactionBillNo(docNo);
			bankTransBill.setUpdatedBy(System.getProperty("user"));
			bankTransBill.setLastModified(Calendar.getInstance().getTime());
			/*
			 * Transaction Rows
			 */
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			String currentTransDefinition = "";
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			int type = bankTransBill.getTurqBanksTransactionType().getId().intValue();
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			//Para yatirma
			if (type == EngBLCommon.BANK_TRANS_OTHER_DEPOSIT)
			{
				prepareAccountingMaps(account, bankAccount, totalAmount, creditAccounts, deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
			}
			//Para cekme
			else if (type == EngBLCommon.BANK_TRANS_OTHER_DRAW)
			{
				prepareAccountingMaps(bankAccount, account, totalAmount, creditAccounts, deptAccounts);
				transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				transRow.setDeptAmount(new BigDecimal(0));
				transRow.setCreditAmountInForeignCurrency(totalAmount);
				transRow
						.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
								EngBLCommon.ROUNDING_METHOD));
			}
			/**
			 * Save transaction bill
			 */
			EngDALCommon.updateObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRow);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, bankTransBill.getTurqEngineSequence().getTurqModule()
					.getId().intValue(), bankTransBill.getTurqEngineSequence().getId(), definition, exchangeRate, creditAccounts,
					deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static void updateTransactionBill(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqBanksTransactionBill bankTransBill=(TurqBanksTransactionBill)argMap.get(BankKeys.BANK_TRANS_BILL);
			TurqBanksCard bankCard=(TurqBanksCard)argMap.get(BankKeys.BANK);
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);	
			
			//delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
			while (it.hasNext())
			{
				CashBLCashTransactionUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it.next());
			}
			//delete current transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete accounting transactions
			AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
			it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				AccDALTransactionSearch.deleteTransaction((TurqAccountingTransaction) it.next());
			}
			bankTransBill.setTransactionBillDate(transDate);
			bankTransBill.setTransactionBillDefinition(definition);
			bankTransBill.setTransactionBillNo(docNo);
			bankTransBill.setUpdatedBy(System.getProperty("user"));
			bankTransBill.setLastModified(Calendar.getInstance().getTime());
			/*
			 * Transaction Rows
			 */
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			TurqAccountingAccount currentAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			String currentTransDefinition = "";
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			boolean currentTransType = false; // Credit or Debit
			int type = bankTransBill.getTurqBanksTransactionType().getId().intValue();
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			if (type == EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
			{
				prepareAccountingMaps(currentAccount, bankAccount, totalAmount, creditAccounts, deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
				currentTransDefinition = curCard.getCardsName() + BankLangKeys.STR_TRANSFER_FROM;
			}
			else if (type == EngBLCommon.BANK_TRANS_SEND_MONEY)
			{
				prepareAccountingMaps(bankAccount, currentAccount, totalAmount, creditAccounts, deptAccounts);
				transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				transRow.setDeptAmount(new BigDecimal(0));
				transRow.setCreditAmountInForeignCurrency(totalAmount);
				transRow
						.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
								EngBLCommon.ROUNDING_METHOD));
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
				currentTransDefinition = curCard.getCardsName() + BankLangKeys.STR_TRANSFER_TO;
			}
			/**
			 * Save transaction bill
			 */
			EngDALCommon.updateObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRow);
			/**
			 * Save Current transaction
			 */
			CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, transDate, docNo, currentTransType, totalAmount,
					new BigDecimal(0), EngBLCommon.CURRENT_TRANS_BANK, bankTransBill.getTurqEngineSequence().getId(),
					currentTransDefinition, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, bankTransBill.getTurqEngineSequence().getTurqModule()
					.getId().intValue(), bankTransBill.getTurqEngineSequence().getId(), definition, exchangeRate, creditAccounts,
					deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteOnlyBankTransaction(TurqBanksTransactionBill bankTransBill)throws Exception
	{
		try
		{
			BankDALCommon.initializeTransaction(bankTransBill);
			//delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete current transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			
		
			
			//delete transaction..
			EngDALCommon.deleteObject(bankTransBill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static void deleteTransaction(TurqBanksTransactionBill bankTransBill) throws Exception
	{
		try
		{
			BankDALCommon.initializeTransaction(bankTransBill);
			//delete transactions
			Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete current transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//delete cash transactions
			it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
			while (it.hasNext())
			{
				CashBLCashTransactionUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it.next());
			}
		
			it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				AccDALTransactionSearch.deleteTransaction((TurqAccountingTransaction) it.next());
			}
			//delete transaction..
			EngDALCommon.deleteObject(bankTransBill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void deleteTransaction(HashMap argMap) throws Exception
	{
		try
		{
			TurqBanksTransactionBill bankTransBill=(TurqBanksTransactionBill)argMap.get(BankKeys.BANK_TRANS_BILL);
			deleteTransaction(bankTransBill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}