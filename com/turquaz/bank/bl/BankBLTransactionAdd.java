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
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqBanksTransactionType;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.lang.BankLangKeys;

public class BankBLTransactionAdd
{
	public static void saveTransferBetweenBanks(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer bankCardWithDeptId=(Integer)argMap.get(BankKeys.BANK_CARD_WITH_DEPT);
			Integer bankCardWithCreditId = (Integer)argMap.get(BankKeys.BANK_CARD_WITH_CREDIT);
			
			
					
			
			TurqBanksCard bankCardWithDept=(TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardWithDeptId);
			TurqBanksCard bankCardWithCredit=(TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardWithCreditId);
			
			
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(new Integer(EngBLCommon.BANK_TRANS_BETWEEN_BANKS));
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRowCredit.setTurqBanksTransactionBill(bankTransBill);
			transRowCredit.setTurqCurrencyExchangeRate(exchangeRate);
			transRowDebit.setTurqBanksTransactionBill(bankTransBill);
			transRowDebit.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRowCredit);
			EngDALCommon.saveObject(transRowDebit);
			/**
			 * Save accounting transactions...
			 */
			/*
			 * Create Accounting transaction
			 */
			TurqAccountingTransactionColumn accTransRowDept = new TurqAccountingTransactionColumn();
			TurqAccountingTransactionColumn accTransRowCredit = new TurqAccountingTransactionColumn();
			TurqAccountingAccount creditAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithCredit,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			TurqAccountingAccount deptAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithDept,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
		
			accTransRowDept.setTransactionDefinition(definition);
			accTransRowDept.setTurqAccountingAccount(deptAccount);
			accTransRowCredit.setTransactionDefinition(definition);
			accTransRowCredit.setTurqAccountingAccount(creditAccount);
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			accTransRowCredit.setDeptAmount(new BigDecimal(0));
			accTransRowCredit.setCreditAmount(totalAmount);
			accTransRowDept.setDeptAmount(totalAmount);
			accTransRowDept.setCreditAmount(new BigDecimal(0));
			String accounting_definition = BankLangKeys.STR_TRANFER + definition;
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			BankBLTransactionUpdate.prepareAccountingMaps(deptAccount, creditAccount, totalAmount, creditAccounts,
					deptAccounts);
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, seq.getTurqModule().getId().intValue(), seq.getId(),
					accounting_definition, exchangeRate, creditAccounts, deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveInitialBankTransaction(TurqBanksCard bankCard) throws Exception
	{
		
			TurqEngineSequence seq;
			TurqModule module = new TurqModule();
			module.setId(new Integer(EngBLCommon.MODULE_BANKS));
			seq = new TurqEngineSequence();
			seq.setTurqModule(module);
			EngDALCommon.saveObject(seq);
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(new Integer(EngBLCommon.BANK_TRANS_INITIAL));
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
			Calendar cal = Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			bankTransBill.setTransactionBillDate(cal.getTime());
			bankTransBill.setTransactionBillDefinition(BankLangKeys.STR_INITIAL_TRANSACTION); 
			bankTransBill.setTransactionBillNo(""); //$NON-NLS-1$
			bankTransBill.setTurqBanksTransactionType(transType);
			bankTransBill.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankTransBill.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankTransBill.setLastModified(Calendar.getInstance().getTime());
			bankTransBill.setCreationDate(Calendar.getInstance().getTime());
			/*
			 * Transaction Rows
			 */
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			transRow.setTurqCurrencyExchangeRate(EngBLCommon.getBaseCurrencyExchangeRate());
			transRow.setDeptAmount(new BigDecimal(0));
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
			transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
			/**
			 * Save transaction bill
			 */
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			EngDALCommon.saveObject(transRow);
		
	}

	public static void saveCashTransaction(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
		
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
				
			TurqCashCard cashCard=(TurqCashCard)argMap.get(CashKeys.CASH_CARD);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(type);
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			TurqAccountingAccount currentAccount = cashCard.getTurqAccountingAccount();
			String currentTransDefinition = ""; //$NON-NLS-1$
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			boolean currentTransType = false; // Credit or Debit
			int cashTransType = 0;
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			//Para yatirma
			if (type.intValue() == EngBLCommon.BANK_TRANS_CASH_DEPOSIT)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(currentAccount, bankAccount, totalAmount, creditAccounts,
						deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
				cashTransType = EngBLCommon.CASH_CURRENT_PAYMENT;
			}
			//Para cekme
			else if (type.intValue() == EngBLCommon.BANK_TRANS_CASH_DRAW)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(bankAccount, currentAccount, totalAmount, creditAccounts,
						deptAccounts);
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
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRow);
			/**
			 * 
			 * 
			 *  
			 */
			CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();
			/**
			 * Save Cash Transaction
			 */
			List totals = new ArrayList();
			totals.add(totalAmount);
			CashBLCashTransactionAdd.saveCashTransaction(cashCard, seq, cashTransType, transDate, definition, docNo, totals,
					bankAccount, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, seq.getTurqModule().getId().intValue(), seq.getId(),
					definition, exchangeRate, creditAccounts, deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}


	public static void saveTransaction(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
					
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(type);
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			TurqAccountingAccount currentAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			String currentTransDefinition = ""; //$NON-NLS-1$
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			boolean currentTransType = false; // Credit or Debit
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			if (type.intValue() == EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(currentAccount, bankAccount, totalAmount, creditAccounts,
						deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
				currentTransDefinition = bankCard.getBankCode() + " " + definition; //$NON-NLS-1$
			}
			else if (type.intValue() == EngBLCommon.BANK_TRANS_SEND_MONEY)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(bankAccount, currentAccount, totalAmount, creditAccounts,
						deptAccounts);
				transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				transRow.setDeptAmount(new BigDecimal(0));
				transRow.setCreditAmountInForeignCurrency(totalAmount);
				transRow
						.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
								EngBLCommon.ROUNDING_METHOD));
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
				currentTransDefinition = bankCard.getBankCode() + " " + definition; //$NON-NLS-1$
			}
			/**
			 * Save transaction bill
			 */
			EngDALCommon.saveObject(bankTransBill);
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
					new BigDecimal(0), EngBLCommon.CURRENT_TRANS_BANK, seq.getId(), currentTransDefinition, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			if(currentAccount!=null)
			{
				AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, seq.getTurqModule().getId().intValue(), seq.getId(),
					definition, exchangeRate, creditAccounts, deptAccounts, true);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static void saveOtherTransaction(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
			
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
					
			TurqAccountingAccount account=(TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqEngineSequence seq=(TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
			BigDecimal totalAmount=(BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			
			
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(type);
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,
					EngBLCommon.BANK_ACC_TYPE_GENERAL);
			Integer bankAccId = null;
			if(bankAccount != null)
			{
				bankAccId = bankAccount.getId();
			}
			
			String currentTransDefinition = ""; //$NON-NLS-1$
			int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			Map creditAccounts = new HashMap();
			Map deptAccounts = new HashMap();
			//Para yatirma
			if (type.intValue() == EngBLCommon.BANK_TRANS_OTHER_DEPOSIT)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(account, bankAccount, totalAmount, creditAccounts,
						deptAccounts);
				transRow.setDeptAmountInForeignCurrency(totalAmount);
				transRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
				transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(0));
			}
			//Para cekme
			else if (type.intValue() == EngBLCommon.BANK_TRANS_OTHER_DRAW)
			{
				BankBLTransactionUpdate.prepareAccountingMaps(bankAccount, account, totalAmount, creditAccounts,
						deptAccounts);
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
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			EngDALCommon.saveObject(transRow);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, docNo, accTransType, seq.getTurqModule().getId().intValue(), seq.getId(),
					definition, exchangeRate, creditAccounts, deptAccounts, true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveChequeTransaction(TurqBanksCard bankCard, TurqEngineSequence seq, BigDecimal totalAmount, Date transDate,
			String definition, String docNo, TurqCurrencyExchangeRate exRate) throws Exception
	{
		try
		{
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(new Integer(EngBLCommon.BANK_TRANS_CHEQUE_COLLECT));
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			transRow.setTurqCurrencyExchangeRate(exRate);
			transRow.setDeptAmount(totalAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			transRow.setDeptAmountInForeignCurrency(totalAmount);
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
			/**
			 * Save transaction bill
			 */
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			EngDALCommon.saveObject(transRow);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static void saveOwnChequeCollect(TurqBanksCard bankCard, TurqEngineSequence seq, BigDecimal totalAmount, Date transDate,
			String definition, String docNo, TurqCurrencyExchangeRate exRate) throws Exception
	{
		try
		{
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_BANKS));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqBanksTransactionType transType = new TurqBanksTransactionType();
			transType.setId(new Integer(EngBLCommon.BANK_TRANS_OWN_CHEQUE_COLLECT));
			TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
			bankTransBill.setTurqEngineSequence(seq);
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
			TurqBanksTransaction transRow = new TurqBanksTransaction();
			transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			transRow.setLastModified(Calendar.getInstance().getTime());
			transRow.setCreationDate(Calendar.getInstance().getTime());
			transRow.setTurqBanksCard(bankCard);
			transRow.setTurqCurrencyExchangeRate(exRate);
			transRow.setCreditAmount(totalAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			transRow.setCreditAmountInForeignCurrency(totalAmount);
			transRow.setDeptAmount(new BigDecimal(0));
			transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
			/**
			 * Save transaction bill
			 */
			EngDALCommon.saveObject(bankTransBill);
			/**
			 * Save transaction row
			 */
			transRow.setTurqBanksTransactionBill(bankTransBill);
			EngDALCommon.saveObject(transRow);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}