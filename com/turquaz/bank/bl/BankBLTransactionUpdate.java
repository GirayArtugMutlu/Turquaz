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
 * @version $Id: BankBLTransactionUpdate.java,v 1.8 2005/02/03 16:41:46 onsel
 *          Exp $
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqBanksTransactionType;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;

public class BankBLTransactionUpdate {
    static CashBLCashTransactionUpdate blCashUpdate = new CashBLCashTransactionUpdate();

    public static TurqBanksTransactionBill initializeTransaction(Integer transId)
            throws Exception {
        try {

            return BankDALCommon.initializeTransaction(transId);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void initializeTransaction(TurqBanksTransactionBill transBill)
            throws Exception {
        try {

            BankDALCommon.initializeTransaction(transBill);

        } catch (Exception ex) {
            throw ex;
        }

    }
    public static void updateTransferBetweenBanks( TurqBanksTransactionBill bankTransBill,TurqBanksCard bankCardWithDept,
            TurqBanksCard bankCardWithCredit,
            BigDecimal totalAmount, Date transDate, String definition,
            String docNo) throws Exception {
        try {
            
            // delete transactions

            Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }
            
            //delete accounting transactions
            AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
            it = bankTransBill.getTurqEngineSequence()
                    .getTurqAccountingTransactions().iterator();

            while (it.hasNext()) {
                dalAcc.deleteTransaction((TurqAccountingTransaction) it.next());

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
             *  
             */
            TurqBanksTransaction transRowCredit = new TurqBanksTransaction();
            transRowCredit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            transRowCredit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            transRowCredit.setLastModified(Calendar.getInstance().getTime());
            transRowCredit.setCreationDate(Calendar.getInstance().getTime());
          
            transRowCredit.setTurqBanksCard(bankCardWithDept);
            transRowCredit.setCreditAmount(totalAmount);
            transRowCredit.setDeptAmount(new BigDecimal(0));

            TurqBanksTransaction transRowDebit = new TurqBanksTransaction();
            transRowDebit.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            transRowDebit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            transRowDebit.setLastModified(Calendar.getInstance().getTime());
            transRowDebit.setCreationDate(Calendar.getInstance().getTime());
         
            transRowDebit.setTurqBanksCard(bankCardWithCredit);
            transRowDebit.setCreditAmount(new BigDecimal(0));
            transRowDebit.setDeptAmount(totalAmount);
           

            /**
             * Save transaction bill
             */
            BankDALCommon.updateObject(bankTransBill);

            /**
             * Save transaction row
             */
            transRowCredit.setTurqBanksTransactionBill(bankTransBill);
            transRowDebit.setTurqBanksTransactionBill(bankTransBill);
            BankDALCommon.saveObject(transRowCredit);
            BankDALCommon.saveObject(transRowDebit);
            /**
             * 
             * Save accounting transactions...
             * 
             */
            /*
             * Create Accounting transaction
             */
            AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
            
            TurqAccountingTransactionColumn accTransRowDept = new TurqAccountingTransactionColumn();
            TurqAccountingTransactionColumn accTransRowCredit = new TurqAccountingTransactionColumn();

            
            TurqAccountingAccount creditAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithCredit,EngBLCommon.BANK_ACC_TYPE_GENERAL);
            TurqAccountingAccount deptAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCardWithDept,EngBLCommon.BANK_ACC_TYPE_GENERAL);
            
            
            
            accTransRowDept.setTransactionDefinition(definition);
            accTransRowDept.setTurqAccountingAccount(creditAccount);

            accTransRowCredit.setTransactionDefinition(definition);
            accTransRowCredit.setTurqAccountingAccount(deptAccount);

            int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
            
            accTransRowCredit.setDeptAmount(new BigDecimal(0));
            accTransRowCredit.setCreditAmount(totalAmount);

            accTransRowDept.setDeptAmount(totalAmount);
            accTransRowDept.setCreditAmount(new BigDecimal(0));
            
            
            String accounting_definition ="Banka Virman - "+definition;
            
            Integer transId = blAccTran.saveAccTransaction(transDate, docNo,
                    accTransType,
                    bankTransBill.getTurqEngineSequence().getTurqModule().getId().intValue(),bankTransBill.getTurqEngineSequence()
                            .getId(), accounting_definition);
//          TODO acc trans column exRate
            blAccTran.saveAccTransactionRow(accTransRowCredit, transId,EngBLCommon.getBaseCurrencyExchangeRate());
            blAccTran.saveAccTransactionRow(accTransRowDept, transId,EngBLCommon.getBaseCurrencyExchangeRate());


        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void updateCashTransactionBill(
            TurqBanksTransactionBill bankTransBill, TurqBanksCard bankCard,
            TurqCashCard cashCard, BigDecimal totalAmount, Date transDate,
            String definition, String docNo) throws Exception {
        try {

            //delete transactions

            Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }

            //delete cash transactions

            it = bankTransBill.getTurqEngineSequence()
                    .getTurqCashTransactions().iterator();

            while (it.hasNext()) {

                blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it
                        .next());

            }

            //delete accounting transactions
            AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
            it = bankTransBill.getTurqEngineSequence()
                    .getTurqAccountingTransactions().iterator();

            while (it.hasNext()) {
                dalAcc.deleteTransaction((TurqAccountingTransaction) it.next());

            }

          
            bankTransBill.setTransactionBillDate(transDate);
            bankTransBill.setTransactionBillDefinition(definition);
            bankTransBill.setTransactionBillNo(docNo);

            bankTransBill.setUpdatedBy(System.getProperty("user"));
            bankTransBill.setLastModified(Calendar.getInstance().getTime());

            /*
             * Transaction Rows
             *  
             */
            TurqBanksTransaction transRow = new TurqBanksTransaction();
            transRow.setCreatedBy(System.getProperty("user"));
            transRow.setUpdatedBy(System.getProperty("user"));
            transRow.setLastModified(Calendar.getInstance().getTime());
            transRow.setCreationDate(Calendar.getInstance().getTime());
         
            transRow.setTurqBanksCard(bankCard);

            /*
             * Create Accounting transaction
             */
            TurqAccountingTransactionColumn accTransRowBank = new TurqAccountingTransactionColumn();
            TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();


            TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,EngBLCommon.BANK_ACC_TYPE_GENERAL);
            
            
            accTransRowBank.setTransactionDefinition(definition);
            accTransRowBank.setTurqAccountingAccount(bankAccount);

            accTransRowCurrent.setTransactionDefinition(definition);
            accTransRowCurrent.setTurqAccountingAccount(cashCard
                    .getTurqAccountingAccount());

            String currentTransDefinition = "";

            int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;

            boolean currentTransType = false; // Credit or Debit
            int cashTransType = 0;

            int type = bankTransBill.getTurqBanksTransactionType()
                    .getId().intValue();
            //Para yatirma
            if (type == EngBLCommon.BANK_TRANS_CASH_DEPOSIT) {
                accTransRowBank.setDeptAmount(totalAmount);
                accTransRowBank.setCreditAmount(new BigDecimal(0));

                accTransRowCurrent.setDeptAmount(new BigDecimal(0));
                accTransRowCurrent.setCreditAmount(totalAmount);

                transRow.setDeptAmount(totalAmount);
                transRow.setCreditAmount(new BigDecimal(0));

                cashTransType = EngBLCommon.CASH_CURRENT_PAYMENT;

            }

            //Para cekme
            else if (type == EngBLCommon.BANK_TRANS_CASH_DRAW) {

                accTransRowBank.setDeptAmount(new BigDecimal(0));
                accTransRowBank.setCreditAmount(totalAmount);

                accTransRowCurrent.setDeptAmount(totalAmount);
                accTransRowCurrent.setCreditAmount(new BigDecimal(0));

                transRow.setDeptAmount(new BigDecimal(0));
                transRow.setCreditAmount(totalAmount);

                cashTransType = EngBLCommon.CASH_CURRENT_COLLECT;

            }

            /**
             * Save transaction bill
             */
            BankDALCommon.updateObject(bankTransBill);

            /**
             * Save transaction row
             */
            transRow.setTurqBanksTransactionBill(bankTransBill);
            BankDALCommon.saveObject(transRow);

            /**
             * 
             * 
             *  
             */
            AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
            CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();

            /**
             * Save Cash Transaction
             */

            List totals = new ArrayList();
            totals.add(totalAmount);
            CashBLCashTransactionAdd blCash = new CashBLCashTransactionAdd();
            blCash.saveCashTransaction(cashCard, bankTransBill
                    .getTurqEngineSequence(), cashTransType, transDate,
                    definition, docNo, totals, bankAccount);

            /**
             * Save Accounting Transaction
             *  
             */

            Integer transId = blAccTran.saveAccTransaction(transDate, docNo,
                    accTransType, bankTransBill.getTurqEngineSequence()
                            .getTurqModule().getId().intValue(),
                    bankTransBill.getTurqEngineSequence()
                            .getId(), definition);
//          TODO acc trans column exRate
            blAccTran.saveAccTransactionRow(accTransRowBank, transId,EngBLCommon.getBaseCurrencyExchangeRate());
            blAccTran.saveAccTransactionRow(accTransRowCurrent, transId,EngBLCommon.getBaseCurrencyExchangeRate());

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void updateOtherTransactionBill(
            TurqBanksTransactionBill bankTransBill, TurqBanksCard bankCard,
            TurqAccountingAccount account, BigDecimal totalAmount, Date transDate,
            String definition, String docNo) throws Exception {
        try {

            //delete transactions

            Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }          

            //delete accounting transactions
            AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
            it = bankTransBill.getTurqEngineSequence()
                    .getTurqAccountingTransactions().iterator();

            while (it.hasNext()) {
                dalAcc.deleteTransaction((TurqAccountingTransaction) it.next());

            }

          
            bankTransBill.setTransactionBillDate(transDate);
            bankTransBill.setTransactionBillDefinition(definition);
            bankTransBill.setTransactionBillNo(docNo);

            bankTransBill.setUpdatedBy(System.getProperty("user"));
            bankTransBill.setLastModified(Calendar.getInstance().getTime());

            /*
             * Transaction Rows
             *  
             */
            TurqBanksTransaction transRow = new TurqBanksTransaction();
            transRow.setCreatedBy(System.getProperty("user"));
            transRow.setUpdatedBy(System.getProperty("user"));
            transRow.setLastModified(Calendar.getInstance().getTime());
            transRow.setCreationDate(Calendar.getInstance().getTime());
          
            transRow.setTurqBanksCard(bankCard);

            /*
             * Create Accounting transaction
             */
            TurqAccountingTransactionColumn accTransRowBank = new TurqAccountingTransactionColumn();
            TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();


            TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,EngBLCommon.BANK_ACC_TYPE_GENERAL);
            
            accTransRowBank.setTransactionDefinition(definition);
            accTransRowBank.setTurqAccountingAccount(bankAccount);

            accTransRowCurrent.setTransactionDefinition(definition);
            accTransRowCurrent.setTurqAccountingAccount(account);

            String currentTransDefinition = "";

            int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;

         

            int type = bankTransBill.getTurqBanksTransactionType()
                    .getId().intValue();
            //Para yatirma
            if (type == EngBLCommon.BANK_TRANS_OTHER_DEPOSIT) {
                accTransRowBank.setDeptAmount(totalAmount);
                accTransRowBank.setCreditAmount(new BigDecimal(0));

                accTransRowCurrent.setDeptAmount(new BigDecimal(0));
                accTransRowCurrent.setCreditAmount(totalAmount);

                transRow.setDeptAmount(totalAmount);
                transRow.setCreditAmount(new BigDecimal(0));

            }

            //Para cekme
            else if (type == EngBLCommon.BANK_TRANS_OTHER_DRAW) {

                accTransRowBank.setDeptAmount(new BigDecimal(0));
                accTransRowBank.setCreditAmount(totalAmount);

                accTransRowCurrent.setDeptAmount(totalAmount);
                accTransRowCurrent.setCreditAmount(new BigDecimal(0));

                transRow.setDeptAmount(new BigDecimal(0));
                transRow.setCreditAmount(totalAmount);

           

            }

            /**
             * Save transaction bill
             */
            BankDALCommon.updateObject(bankTransBill);

            /**
             * Save transaction row
             */
            transRow.setTurqBanksTransactionBill(bankTransBill);
            BankDALCommon.saveObject(transRow);

            /**
             * 
             * 
             *  
             */
            AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();


            /**
             * Save Accounting Transaction
             *  
             */

            Integer transId = blAccTran.saveAccTransaction(transDate, docNo,
                    accTransType, bankTransBill.getTurqEngineSequence()
                            .getTurqModule().getId().intValue(),
                    bankTransBill.getTurqEngineSequence()
                            .getId(), definition);
//          TODO acc trans column exRate
            blAccTran.saveAccTransactionRow(accTransRowBank, transId,EngBLCommon.getBaseCurrencyExchangeRate());
            blAccTran.saveAccTransactionRow(accTransRowCurrent, transId,EngBLCommon.getBaseCurrencyExchangeRate());

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void updateTransactionBill(
            TurqBanksTransactionBill bankTransBill, TurqBanksCard bankCard,
            TurqCurrentCard curCard, BigDecimal totalAmount, Date transDate,
            String definition, String docNo) throws Exception {
        try {

            //delete transactions

            Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }

            //delete cash transactions

            it = bankTransBill.getTurqEngineSequence()
                    .getTurqCashTransactions().iterator();

            while (it.hasNext()) {

                blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it
                        .next());

            }

            //delete current transactions

            it = bankTransBill.getTurqEngineSequence()
                    .getTurqCurrentTransactions().iterator();

            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }

            //delete accounting transactions
            AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
            it = bankTransBill.getTurqEngineSequence()
                    .getTurqAccountingTransactions().iterator();

            while (it.hasNext()) {
                dalAcc.deleteTransaction((TurqAccountingTransaction) it.next());

            }

         
            bankTransBill.setTransactionBillDate(transDate);
            bankTransBill.setTransactionBillDefinition(definition);
            bankTransBill.setTransactionBillNo(docNo);

            bankTransBill.setUpdatedBy(System.getProperty("user"));
            bankTransBill.setLastModified(Calendar.getInstance().getTime());

            /*
             * Transaction Rows
             *  
             */
            TurqBanksTransaction transRow = new TurqBanksTransaction();
            transRow.setCreatedBy(System.getProperty("user"));
            transRow.setUpdatedBy(System.getProperty("user"));
            transRow.setLastModified(Calendar.getInstance().getTime());
            transRow.setCreationDate(Calendar.getInstance().getTime());
            
            transRow.setTurqBanksCard(bankCard);

            /*
             * Create Accounting transaction
             */
            TurqAccountingTransactionColumn accTransRowBank = new TurqAccountingTransactionColumn();
            TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();


            TurqAccountingAccount bankAccount = BankDALBankCardSearch.getBankAccountingAccount(bankCard,EngBLCommon.BANK_ACC_TYPE_GENERAL);
            
            accTransRowBank.setTransactionDefinition(definition);
            accTransRowBank.setTurqAccountingAccount(bankAccount);

            accTransRowCurrent.setTransactionDefinition(definition);
            accTransRowCurrent.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));

            String currentTransDefinition = "";

            int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;

            boolean currentTransType = false; // Credit or Debit

            int type = bankTransBill.getTurqBanksTransactionType()
                    .getId().intValue();

            if (type == EngBLCommon.BANK_TRANS_RECIEVE_MONEY) {
                accTransRowBank.setDeptAmount(totalAmount);
                accTransRowBank.setCreditAmount(new BigDecimal(0));

                accTransRowCurrent.setDeptAmount(new BigDecimal(0));
                accTransRowCurrent.setCreditAmount(totalAmount);

                transRow.setDeptAmount(totalAmount);
                transRow.setCreditAmount(new BigDecimal(0));

                currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
                currentTransDefinition = curCard.getCardsName()
                        + " 'den Havale";

            }

            else if (type == EngBLCommon.BANK_TRANS_SEND_MONEY) {

                accTransRowBank.setDeptAmount(new BigDecimal(0));
                accTransRowBank.setCreditAmount(totalAmount);

                accTransRowCurrent.setDeptAmount(totalAmount);
                accTransRowCurrent.setCreditAmount(new BigDecimal(0));

                transRow.setDeptAmount(new BigDecimal(0));
                transRow.setCreditAmount(totalAmount);

                currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
                currentTransDefinition = curCard.getCardsName() + " 'e Havale";

            }

            /**
             * Save transaction bill
             */
            BankDALCommon.updateObject(bankTransBill);

            /**
             * Save transaction row
             */
            transRow.setTurqBanksTransactionBill(bankTransBill);
            BankDALCommon.saveObject(transRow);

            /**
             * 
             * 
             *  
             */
            AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
            CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();

            /**
             * Save Current transaction
             */

            blCurTrans.saveCurrentTransaction(curCard, transDate, docNo,
                    currentTransType, totalAmount, new BigDecimal(0),
                    EngBLCommon.CURRENT_TRANS_BANK, bankTransBill
                            .getTurqEngineSequence().getId(),
                    currentTransDefinition);

            /**
             * Save Accounting Transaction
             *  
             */

            Integer transId = blAccTran.saveAccTransaction(transDate, docNo,
                    accTransType, bankTransBill.getTurqEngineSequence()
                            .getTurqModule().getId().intValue(),
                    bankTransBill.getTurqEngineSequence()
                            .getId(), definition);
//          TODO acc trans column exRate
            blAccTran.saveAccTransactionRow(accTransRowBank, transId,EngBLCommon.getBaseCurrencyExchangeRate());
            blAccTran.saveAccTransactionRow(accTransRowCurrent, transId,EngBLCommon.getBaseCurrencyExchangeRate());

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static void deleteTransaction(TurqBanksTransactionBill bankTransBill)
            throws Exception {
        try {
            //delete transactions

            Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }

            //delete current transactions

            it = bankTransBill.getTurqEngineSequence()
                    .getTurqCurrentTransactions().iterator();

            while (it.hasNext()) {
                BankDALCommon.deleteObject(it.next());

            }

            //delete cash transactions

            it = bankTransBill.getTurqEngineSequence()
                    .getTurqCashTransactions().iterator();

            while (it.hasNext()) {

                blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction) it
                        .next());

            }

            //delete accounting transactions
            AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
            it = bankTransBill.getTurqEngineSequence()
                    .getTurqAccountingTransactions().iterator();

            while (it.hasNext()) {
                dalAcc.deleteTransaction((TurqAccountingTransaction) it.next());

            }

            //delete transaction..
            BankDALCommon.deleteObject(bankTransBill);

        } catch (Exception ex) {
            throw ex;
        }
    }

}