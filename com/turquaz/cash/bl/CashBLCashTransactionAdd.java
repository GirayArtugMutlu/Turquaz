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
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCashTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class CashBLCashTransactionAdd {
	CashDALCashCard dalCash = new CashDALCashCard();

	AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();

	CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();

	private Calendar cal = Calendar.getInstance();

	public CashBLCashTransactionAdd() {

	}

	public void saveCashTransaction(TurqCashCard cashCard,
			TurqEngineSequence seq, int type, Date transDate,
			String definition, String documentNo, List totals,
			TurqAccountingAccount account) throws Exception {
		try {
			if (seq == null) {
				try {
					TurqModule module = new TurqModule();
					module.setModulesId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					dalCash.save(seq);
				} catch (Exception ex) {
					throw ex;
				}
			}

			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setCashTransactionTypesId(new Integer(type));

			TurqCashTransaction cashTrans = new TurqCashTransaction();
			
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(documentNo);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			/**
			 * Save Cash Transaction
			 */
			dalCash.save(cashTrans);

			BigDecimal totalAmount = new BigDecimal(0);

			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow;
			for (int i = 0; i < totals.size(); i++) {

				cashTransRow = new TurqCashTransactionRow();
				cashTransRow.setTurqCashCard(cashCard);
				cashTransRow.setCreatedBy(System.getProperty("user"));
				cashTransRow.setUpdatedBy(System.getProperty("user"));
				cashTransRow.setLastModified(new java.sql.Date(cal.getTime()
						.getTime()));
				cashTransRow.setCreationDate(new java.sql.Date(cal.getTime()
						.getTime()));
				cashTransRow.setTransactionDefinition(definition);
				cashTransRow.setTurqAccountingAccount(account);

				if (type == EngBLCommon.CASH_CURRENT_COLLECT||type==EngBLCommon.CASH_CHEQUE_COLLECT) {
					cashTransRow.setDeptAmount((BigDecimal) totals.get(i));
					cashTransRow.setCreditAmount(new BigDecimal(0));

				} else if (type == EngBLCommon.CASH_CURRENT_PAYMENT) {

					cashTransRow.setDeptAmount(new BigDecimal(0));
					cashTransRow.setCreditAmount((BigDecimal) totals.get(i));

				}
			

				totalAmount = totalAmount.add((BigDecimal) totals.get(i));
				/**
				 * Save Cash Transaction Row
				 *  
				 */

				cashTransRow.setTurqCashTransaction(cashTrans);

				dalCash.save(cashTransRow);
			}

		}

		catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * 
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
	public void saveCurrentTransaction(TurqCashCard cashCard,
			TurqCurrentCard current, int type, TurqEngineSequence seq,
			BigDecimal totalAmount, Date transDate, String definition,
			String document_no) throws Exception {
		try {

			if (seq == null) {
				try {
					TurqModule module = new TurqModule();
					module.setModulesId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					dalCash.save(seq);
				} catch (Exception ex) {
					throw ex;
				}
			}

			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setCashTransactionTypesId(new Integer(type));

			TurqCashTransaction cashTrans = new TurqCashTransaction();
			
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
			cashTransRow.setTurqCashCard(cashCard);
			cashTransRow.setCreatedBy(System.getProperty("user"));
			cashTransRow.setUpdatedBy(System.getProperty("user"));
			cashTransRow.setLastModified(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRow.setCreationDate(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRow.setTransactionDefinition(definition);
			cashTransRow.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(current,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));

			/*
			 * Create Accounting transaction
			 */
			TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
			TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();

			accTransRowCash.setTransactionDefinition(definition);
			accTransRowCash.setTurqAccountingAccount(cashCard
					.getTurqAccountingAccount());

			accTransRowCurrent.setTransactionDefinition(definition);
			accTransRowCurrent.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(current,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));

			String currentTransDefinition = "";

			int accTransType = 0;

			boolean currentTransType = false; // Credit or Debit

			if (type == EngBLCommon.CASH_CURRENT_COLLECT) {
				accTransRowCash.setDeptAmount(totalAmount);
				accTransRowCash.setCreditAmount(new BigDecimal(0));

				accTransRowCurrent.setDeptAmount(new BigDecimal(0));
				accTransRowCurrent.setCreditAmount(totalAmount);

				cashTransRow.setDeptAmount(totalAmount);
				cashTransRow.setCreditAmount(new BigDecimal(0));

				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
				currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
				currentTransDefinition = current.getCardsName() + " 'den Nakit";

			}

			else if (type == EngBLCommon.CASH_CURRENT_PAYMENT) {

				accTransRowCash.setDeptAmount(new BigDecimal(0));
				accTransRowCash.setCreditAmount(totalAmount);

				accTransRowCurrent.setDeptAmount(totalAmount);
				accTransRowCurrent.setCreditAmount(new BigDecimal(0));

				cashTransRow.setDeptAmount(new BigDecimal(0));
				cashTransRow.setCreditAmount(totalAmount);

				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
				currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
				currentTransDefinition = current.getCardsName() + " 'e Nakit";

			}

			/**
			 * Save Cash Transaction
			 */
			dalCash.save(cashTrans);

			/**
			 * Save Cash Transaction Row
			 *  
			 */

			cashTransRow.setTurqCashTransaction(cashTrans);

			dalCash.save(cashTransRow);

			/**
			 * Save Current transaction
			 */

			blCurTrans.saveCurrentTransaction(current, transDate, document_no,
					currentTransType, totalAmount, new BigDecimal(0),
					EngBLCommon.CURRENT_TRANS_CASH, seq.getEngineSequencesId(),
					currentTransDefinition);

			/**
			 * Save Accounting Transaction
			 *  
			 */

			Integer transId = blAccTran.saveAccTransaction(transDate,
					document_no, accTransType, seq.getTurqModule()
							.getModulesId().intValue(), seq
							.getEngineSequencesId(), definition);
			blAccTran.saveAccTransactionRow(accTransRowCash, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));
			blAccTran.saveAccTransactionRow(accTransRowCurrent, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));

		}

		catch (Exception ex) {

			throw ex;

		}

	}

	public void saveOtherTransaction(TurqCashCard cashCard,
			TurqAccountingAccount account, int type, TurqEngineSequence seq,
			BigDecimal totalAmount, Date transDate, String definition,
			String document_no) throws Exception {
		try {

			if (seq == null) {
				try {
					TurqModule module = new TurqModule();
					module.setModulesId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					dalCash.save(seq);
				} catch (Exception ex) {
					throw ex;
				}
			}

			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setCashTransactionTypesId(new Integer(type));

			TurqCashTransaction cashTrans = new TurqCashTransaction();
			
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
			cashTransRow.setTurqCashCard(cashCard);
			cashTransRow.setCreatedBy(System.getProperty("user"));
			cashTransRow.setUpdatedBy(System.getProperty("user"));
			cashTransRow.setLastModified(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRow.setCreationDate(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRow.setTransactionDefinition(definition);
			cashTransRow.setTurqAccountingAccount(account);

			/*
			 * Create Accounting transaction
			 */
			TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
			TurqAccountingTransactionColumn accTransRowOther = new TurqAccountingTransactionColumn();

			accTransRowCash.setTransactionDefinition(definition);
			accTransRowCash.setTurqAccountingAccount(cashCard
					.getTurqAccountingAccount());

			accTransRowOther.setTransactionDefinition(definition);
			accTransRowOther.setTurqAccountingAccount(account);

			String currentTransDefinition = "";

			int accTransType = 0;

			boolean currentTransType = false; // Credit or Debit

			if (type == EngBLCommon.CASH_OTHER_COLLECT) {
				accTransRowCash.setDeptAmount(totalAmount);
				accTransRowCash.setCreditAmount(new BigDecimal(0));

				accTransRowOther.setDeptAmount(new BigDecimal(0));
				accTransRowOther.setCreditAmount(totalAmount);

				cashTransRow.setDeptAmount(totalAmount);
				cashTransRow.setCreditAmount(new BigDecimal(0));

				accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;

			}

			else if (type == EngBLCommon.CASH_OTHER_PAYMENT) {

				accTransRowCash.setDeptAmount(new BigDecimal(0));
				accTransRowCash.setCreditAmount(totalAmount);

				accTransRowOther.setDeptAmount(totalAmount);
				accTransRowOther.setCreditAmount(new BigDecimal(0));

				cashTransRow.setDeptAmount(new BigDecimal(0));
				cashTransRow.setCreditAmount(totalAmount);

				accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;

			}

			/**
			 * Save Cash Transaction
			 */
			dalCash.save(cashTrans);

			/**
			 * Save Cash Transaction Row
			 *  
			 */

			cashTransRow.setTurqCashTransaction(cashTrans);

			dalCash.save(cashTransRow);

		
			/**
			 * Save Accounting Transaction
			 *  
			 */

			Integer transId = blAccTran.saveAccTransaction(transDate,
					document_no, accTransType, seq.getTurqModule()
							.getModulesId().intValue(), seq
							.getEngineSequencesId(), definition);
			blAccTran.saveAccTransactionRow(accTransRowCash, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));
			blAccTran.saveAccTransactionRow(accTransRowOther, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));

		}

		catch (Exception ex) {

			throw ex;

		}

	}
	public void saveTransferBetweenAccounts(TurqCashCard cashCardWithDebt,
			TurqCashCard cashCardWithCredit , int type, TurqEngineSequence seq,
			BigDecimal totalAmount, Date transDate, String definition,
			String document_no) throws Exception {
		try {

			if (seq == null) {
				try {
					TurqModule module = new TurqModule();
					module.setModulesId(new Integer(EngBLCommon.MODULE_CASH));
					seq = new TurqEngineSequence();
					seq.setTurqModule(module);
					dalCash.save(seq);
				} catch (Exception ex) {
					throw ex;
				}
			}

			TurqCashTransactionType transType = new TurqCashTransactionType();
			transType.setCashTransactionTypesId(new Integer(type));

			TurqCashTransaction cashTrans = new TurqCashTransaction();
		
			cashTrans.setTurqCashTransactionType(transType);
			cashTrans.setTurqEngineSequence(seq);
			cashTrans.setTransactionDate(transDate);
			cashTrans.setTransactionDefinition(definition);
			cashTrans.setDocumentNo(document_no);
			cashTrans.setCreatedBy(System.getProperty("user"));
			cashTrans.setUpdatedBy(System.getProperty("user"));
			cashTrans
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashTrans
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			/*
			 * Create cash Transaction Rows
			 */
			TurqCashTransactionRow cashTransRowWithDept = new TurqCashTransactionRow();
			cashTransRowWithDept.setTurqCashCard(cashCardWithDebt);
			cashTransRowWithDept.setCreatedBy(System.getProperty("user"));
			cashTransRowWithDept.setUpdatedBy(System.getProperty("user"));
			cashTransRowWithDept.setLastModified(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRowWithDept.setCreationDate(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRowWithDept.setTransactionDefinition(definition);
			cashTransRowWithDept.setTurqAccountingAccount(cashCardWithCredit.getTurqAccountingAccount());
		   
			/*************************************/
			TurqCashTransactionRow cashTransRowWithCredit = new TurqCashTransactionRow();
			cashTransRowWithCredit.setTurqCashCard(cashCardWithCredit);
			cashTransRowWithCredit.setCreatedBy(System.getProperty("user"));
			cashTransRowWithCredit.setUpdatedBy(System.getProperty("user"));
			cashTransRowWithCredit.setLastModified(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRowWithCredit.setCreationDate(new java.sql.Date(cal.getTime()
					.getTime()));
			cashTransRowWithCredit.setTransactionDefinition(definition);
			cashTransRowWithCredit.setTurqAccountingAccount(cashCardWithDebt.getTurqAccountingAccount());

			
			
			
			
			/*
			 * Create Accounting transaction
			 */
			TurqAccountingTransactionColumn accTransCashWithDept = new TurqAccountingTransactionColumn();
			TurqAccountingTransactionColumn accTransCashWithCredit = new TurqAccountingTransactionColumn();

			accTransCashWithDept.setTransactionDefinition(definition);
			accTransCashWithDept.setTurqAccountingAccount(cashCardWithDebt
					.getTurqAccountingAccount());

			accTransCashWithCredit.setTransactionDefinition(definition);
			accTransCashWithCredit.setTurqAccountingAccount(cashCardWithCredit.getTurqAccountingAccount());

		

			int accTransType = 0;

			boolean currentTransType = false; // Credit or Debit

			
				accTransCashWithDept.setCreditAmount(totalAmount);
				accTransCashWithDept.setDeptAmount(new BigDecimal(0));

				accTransCashWithCredit.setCreditAmount(new BigDecimal(0));
				accTransCashWithCredit.setDeptAmount(totalAmount);

				cashTransRowWithDept.setCreditAmount(totalAmount);
				cashTransRowWithDept.setDeptAmount(new BigDecimal(0));
				
				cashTransRowWithCredit.setDeptAmount(totalAmount);
				cashTransRowWithCredit.setCreditAmount(new BigDecimal(0));

				accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
		

		
			/**
			 * Save Cash Transaction
			 */
			dalCash.save(cashTrans);

			/**
			 * Save Cash Transaction Row
			 *  
			 */

			cashTransRowWithDept.setTurqCashTransaction(cashTrans);
			cashTransRowWithCredit.setTurqCashTransaction(cashTrans);
			

			dalCash.save(cashTransRowWithDept);
            dalCash.save(cashTransRowWithCredit);
		
			/**
			 * Save Accounting Transaction
			 *  
			 */

			Integer transId = blAccTran.saveAccTransaction(transDate,
					document_no, accTransType, seq.getTurqModule()
							.getModulesId().intValue(), seq
							.getEngineSequencesId(), definition);
			blAccTran.saveAccTransactionRow(accTransCashWithDept, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));
			blAccTran.saveAccTransactionRow(accTransCashWithCredit, transId,
					EngBLCommon.getBaseCurrency(), new BigDecimal(1));

		}

		catch (Exception ex) {

			throw ex;

		}

	}

}