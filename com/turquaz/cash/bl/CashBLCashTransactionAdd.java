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
 * @version $Id: CashBLCashTransactionAdd.java,v 1.13 2005/02/18 16:35:32
 *          cemdayanik Exp $
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.cash.CashKeys;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCashTransactionType;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashBLCashTransactionAdd
{
	

	
	public static void saveCashTransaction(TurqCashCard cashCard, TurqEngineSequence seq, int type, Date transDate, String definition,
			String documentNo, List totals, TurqAccountingAccount account, TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		
			Calendar cal = Calendar.getInstance();
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setId(new Integer(type));
			TurqCashTransaction cashTrans = new TurqCashTransaction();
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(documentNo);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.saveObject(cashTrans);
			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow;
			for (int i = 0; i < totals.size(); i++)
			{
				cashTransRow = new TurqCashTransactionRow();
				cashTransRow.setTurqCashCard(cashCard);
				cashTransRow.setCreatedBy(System.getProperty("user"));
				cashTransRow.setUpdatedBy(System.getProperty("user"));
				cashTransRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				cashTransRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
				cashTransRow.setTransactionDefinition(definition);
				cashTransRow.setTurqAccountingAccount(account);
				cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
				if (type == EngBLCommon.CASH_CURRENT_COLLECT || type == EngBLCommon.CASH_CHEQUE_COLLECT)
				{
					cashTransRow.setDeptAmountInForeignCurrency((BigDecimal) totals.get(i));
					cashTransRow.setDeptAmount(((BigDecimal) totals.get(i)).multiply(exchangeRate.getExchangeRatio()).setScale(2,
							EngBLCommon.ROUNDING_METHOD));
					cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
					cashTransRow.setCreditAmount(new BigDecimal(0));
				}
				else if (type == EngBLCommon.CASH_CURRENT_PAYMENT)
				{
					cashTransRow.setDeptAmount(new BigDecimal(0));
					cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
					cashTransRow.setCreditAmountInForeignCurrency((BigDecimal) totals.get(i));
					cashTransRow.setCreditAmount(((BigDecimal) totals.get(i)).multiply(exchangeRate.getExchangeRatio()).setScale(2,
							EngBLCommon.ROUNDING_METHOD));
				}
				/**
				 * Save Cash Transaction Row
				 */
				cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
				cashTransRow.setTurqCashTransaction(cashTrans);
				EngDALCommon.saveObject(cashTransRow);
			}
		
	}

	/**
	 * @param cashCard
	 * @param current
	 * @param type
	 * @param seq
	 * @param totalAmount
	 * @param transDate
	 * @param definition
	 * @param document_no
	 * @throws Exception
	 */
	
	public static void saveCurrentTransaction(HashMap argMap )	throws Exception
	{
		 TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		 TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		 Integer type = (Integer)argMap.get(EngKeys.TYPE);
		 Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 TurqCurrentCard current = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD); 
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.ENG_SEQ);
		
			Calendar cal = Calendar.getInstance();
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setId(type);
			TurqCashTransaction cashTrans = new TurqCashTransaction();
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
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
			if (type.intValue() == EngBLCommon.CASH_CURRENT_COLLECT)
			{
				CashBLCashTransactionUpdate.prepareAccountingMaps(currentAccount.getId(), cashAccount.getId(), totalAmount,
						creditAccounts, deptAccounts);
				cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
				cashTransRow.setCreditAmount(new BigDecimal(0));
				cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
				if (definition.equals(""))
				{
					currentTransDefinition = current.getCardsName() + " 'den Nakit";
				}
				else
				{
					currentTransDefinition = definition;
				}
			}
			else if (type.intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
			{
				CashBLCashTransactionUpdate.prepareAccountingMaps(cashAccount.getId(), currentAccount.getId(), totalAmount,
						creditAccounts, deptAccounts);
				cashTransRow.setDeptAmount(new BigDecimal(0));
				cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
				if (definition.equals(""))
				{
					currentTransDefinition = current.getCardsName() + " 'e Nakit";
				}
				else
				{
					currentTransDefinition = definition;
				}
			}
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.saveObject(cashTrans);
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
					new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CASH, seq.getId(), currentTransDefinition, exchangeRate);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, seq.getTurqModule().getId().intValue(), seq
					.getId(), definition, exchangeRate, creditAccounts, deptAccounts, true);
		
	
	}

	
	public static void saveOtherTransaction(HashMap argMap)
			throws Exception
	{
		 TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		 TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		 Integer type = (Integer)argMap.get(EngKeys.TYPE);
		 Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 
		 TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.ENG_SEQ);
		
		
			Calendar cal = Calendar.getInstance();
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setId(type);
			TurqCashTransaction cashTrans = new TurqCashTransaction();
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
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
			if (type.intValue() == EngBLCommon.CASH_OTHER_COLLECT)
			{
				CashBLCashTransactionUpdate.prepareAccountingMaps(account.getId(), cashAccount.getId(), totalAmount, creditAccounts,
						deptAccounts);
				cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
				cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setCreditAmount(new BigDecimal(0));
				cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
			}
			else if (type.intValue() == EngBLCommon.CASH_OTHER_PAYMENT)
			{
				CashBLCashTransactionUpdate.prepareAccountingMaps(cashAccount.getId(), account.getId(), totalAmount, creditAccounts,
						deptAccounts);
				cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
				cashTransRow.setDeptAmount(new BigDecimal(0));
				cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
				cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
			}
			/**
			 * Save Cash Transaction
			 */
			EngDALCommon.saveObject(cashTrans);
			/**
			 * Save Cash Transaction Row
			 */
			cashTransRow.setTurqCashTransaction(cashTrans);
			EngDALCommon.saveObject(cashTransRow);
			/**
			 * Save Accounting Transaction
			 */
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, seq.getTurqModule().getId().intValue(), seq
					.getId(), definition, exchangeRate, creditAccounts, deptAccounts, true);
		
		
	}

	public static void saveTransferBetweenAccounts(HashMap argMap) throws Exception
	{
		TurqCashCard cashCardWithDebt= (TurqCashCard)argMap.get(CashKeys.CASH_CARD_WITH_DEPT);
		TurqCashCard cashCardWithCredit =(TurqCashCard)argMap.get(CashKeys.CASH_CARD_WITH_CREDIT);
		 
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		 Integer type = (Integer)argMap.get(EngKeys.TYPE);
		 Date transDate = (Date)argMap.get(EngKeys.DATE);
		 String definition = (String)argMap.get(EngKeys.DEFINITION);
		 String document_no = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 BigDecimal totalAmount = (BigDecimal)argMap.get(CashKeys.CASH_TOTAL_AMOUNT);
		 TurqCurrentCard current = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD); 
		 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.ENG_SEQ);
		
		
		
		
			Calendar cal = Calendar.getInstance();
			if (seq == null)
			{
				try
				{
					TurqModule module = new TurqModule();
					module.setId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					EngDALCommon.saveObject(seq);
				}
				catch (Exception ex)
				{
					throw ex;
				}
			}
			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setId(type);
			TurqCashTransaction cashTrans = new TurqCashTransaction();
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
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
			EngDALCommon.saveObject(cashTrans);
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
			CashBLCashTransactionUpdate.prepareAccountingMaps(cashCardWithDebt.getTurqAccountingAccount().getId(), cashCardWithCredit
					.getTurqAccountingAccount().getId(), totalAmount, creditAccounts, deptAccounts);
			AccBLTransactionAdd.saveAccTransaction(transDate, document_no, accTransType, seq.getTurqModule().getId().intValue(), seq
					.getId(), definition, exchangeRate, creditAccounts, deptAccounts, true);
		
	}
}