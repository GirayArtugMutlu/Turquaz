
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
* @author  Onsel
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;

public class BankBLTransactionUpdate {
   static CashBLCashTransactionUpdate blCashUpdate = new CashBLCashTransactionUpdate();
    public static TurqBanksTransactionBill initializeTransaction(Integer transId)throws Exception {
        try{
            
            return BankDALCommon.initializeTransaction(transId);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    public static void initializeTransaction(TurqBanksTransactionBill transBill)throws Exception {
        try{
            
         BankDALCommon.initializeTransaction(transBill);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    public static void updateCashTransactionBill(TurqBanksTransactionBill bankTransBill, TurqBanksCard bankCard,
			 									TurqCashCard cashCard,  BigDecimal totalAmount,
			 									Date transDate,
			 									String definition,
			 									String docNo)throws Exception
    {
    try{
        
      
        
          //delete transactions
           
          Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
          while(it.hasNext()){
              BankDALCommon.deleteObject(it.next());
              
          }
           
           //delete cash transactions
          
          it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
          
          while(it.hasNext()){
              
           blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction)it.next());
              
          }
           
           //delete accounting transactions
          AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
          it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
          
          while(it.hasNext()){
             dalAcc.deleteTransaction((TurqAccountingTransaction)it.next());
              
          }
          
          
           
          bankTransBill.setTurqBanksCard(bankCard);           
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
         	transRow.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
      
        
        	
       	
         	/*
            * Create Accounting transaction
            */
           TurqAccountingTransactionColumn accTransRowBank = new TurqAccountingTransactionColumn();
      	    TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
      	   
      	    accTransRowBank.setTransactionDefinition(definition);
      	    accTransRowBank.setTurqAccountingAccount(bankCard.getTurqAccountingAccount());
      	 
      	    accTransRowCurrent.setTransactionDefinition(definition);
      	    accTransRowCurrent.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
      	    
      	 
      	    
      	 String currentTransDefinition="";
        
   	 int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
        
   	 boolean currentTransType = false; // Credit or Debit
   	 int cashTransType =0;
        
   	 int type =bankTransBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue(); 
   	 //Para yatirma
   	 if(type==EngBLCommon.BANK_TRANS_CASH_DEPOSIT)
        {
           accTransRowBank.setDeptAmount(totalAmount);
           accTransRowBank.setCreditAmount(new BigDecimal(0));
           
           accTransRowCurrent.setDeptAmount(new BigDecimal(0));
           accTransRowCurrent.setCreditAmount(totalAmount);
           
           transRow.setDeptAmount(totalAmount);
           transRow.setCreditAmount(new BigDecimal(0));
           
           cashTransType = EngBLCommon.CASH_CURRENT_PAYMENT;
           
        }
   	 
   	 
        //Para cekme
        else if(type==EngBLCommon.BANK_TRANS_CASH_DRAW)
        {
            
            
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
  	    blCash.saveCashTransaction(cashCard,bankTransBill.getTurqEngineSequence(),cashTransType,transDate,definition,docNo,totals,bankCard.getTurqAccountingAccount());
  	
  	    
  	    
  	    
  	    
  	    /**
  	     * Save Accounting Transaction 
  	     * 
  	    */
  	   
  	   Integer transId = blAccTran.saveAccTransaction(transDate,docNo,accTransType,bankTransBill.getTurqEngineSequence().getTurqModule().getModulesId().intValue(),bankTransBill.getTurqEngineSequence().getEngineSequencesId(),definition);
  	   blAccTran.saveAccTransactionRow(accTransRowBank,transId);
  	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId);
      	    
      	 
           
           
           
           
           
       }
       catch(Exception ex){
           throw ex;
       }
    
       
        
        
    }
    public static void updateTransactionBill(TurqBanksTransactionBill bankTransBill, TurqBanksCard bankCard,
            								 TurqCurrentCard curCard,  BigDecimal totalAmount,
            								 Date transDate,
                                             String definition,
                                             String docNo)throws Exception {
        try{
         
           //delete transactions
            
           Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
           while(it.hasNext()){
               BankDALCommon.deleteObject(it.next());
               
           }
            
           //delete cash transactions
           
           it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
           
           while(it.hasNext()){
               
            blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction)it.next());
               
           }
           
           
            //delete current transactions 
           
           it = bankTransBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
           
           while(it.hasNext()){
               BankDALCommon.deleteObject(it.next());
               
           }
            
            //delete accounting transactions
           AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
           it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
           
           while(it.hasNext()){
              dalAcc.deleteTransaction((TurqAccountingTransaction)it.next());
               
           }
           
           
            
           bankTransBill.setTurqBanksCard(bankCard);           
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
         	transRow.setTurqAccountingAccount(curCard.getTurqAccountingAccount());
      
        
        	
       	
         	/*
            * Create Accounting transaction
            */
           TurqAccountingTransactionColumn accTransRowBank = new TurqAccountingTransactionColumn();
      	    TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
      	   
      	    accTransRowBank.setTransactionDefinition(definition);
      	    accTransRowBank.setTurqAccountingAccount(bankCard.getTurqAccountingAccount());
      	 
      	    accTransRowCurrent.setTransactionDefinition(definition);
      	    accTransRowCurrent.setTurqAccountingAccount(curCard.getTurqAccountingAccount());
      	    
      	 
      	    
      	 String currentTransDefinition="";
        
   	 int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
        
   	 boolean currentTransType = false; // Credit or Debit
   	 
   	 int type =bankTransBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue();
        
   	 if(type == EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
        {
           accTransRowBank.setDeptAmount(totalAmount);
           accTransRowBank.setCreditAmount(new BigDecimal(0));
           
           accTransRowCurrent.setDeptAmount(new BigDecimal(0));
           accTransRowCurrent.setCreditAmount(totalAmount);
           
           transRow.setDeptAmount(totalAmount);
           transRow.setCreditAmount(new BigDecimal(0));
           
         
           currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
           currentTransDefinition = curCard.getCardsName()+" 'den Havale";
           
           
        }
        
        else if(type==EngBLCommon.BANK_TRANS_SEND_MONEY)
        {
            
            
            accTransRowBank.setDeptAmount(new BigDecimal(0));
            accTransRowBank.setCreditAmount(totalAmount);
            
            accTransRowCurrent.setDeptAmount(totalAmount);
            accTransRowCurrent.setCreditAmount(new BigDecimal(0));
            
            transRow.setDeptAmount(new BigDecimal(0));
            transRow.setCreditAmount(totalAmount);
                     
            currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
            currentTransDefinition = curCard.getCardsName()+" 'e Havale";
            
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
  	 
  	
  	    blCurTrans.saveCurrentTransaction(curCard, transDate,docNo,currentTransType,
  	            						  totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_BANK,
  	            						  bankTransBill.getTurqEngineSequence().getEngineSequencesId(),currentTransDefinition);
  	
  		    
  	    
  	    
  	    
  	    
  	    /**
  	     * Save Accounting Transaction 
  	     * 
  	    */
  	   
  	   Integer transId = blAccTran.saveAccTransaction(transDate,docNo,accTransType, bankTransBill.getTurqEngineSequence().getTurqModule().getModulesId().intValue(), bankTransBill.getTurqEngineSequence().getEngineSequencesId(),definition);
  	   blAccTran.saveAccTransactionRow(accTransRowBank,transId);
  	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId);        
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static void deleteTransaction(TurqBanksTransactionBill bankTransBill)throws Exception {
        try{
            //delete transactions
            
           Iterator it = bankTransBill.getTurqBanksTransactions().iterator();
           while(it.hasNext()){
               BankDALCommon.deleteObject(it.next());
               
           }
            
            //delete current transactions 
           
           it = bankTransBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
           
           while(it.hasNext()){
               BankDALCommon.deleteObject(it.next());
               
           }
           
           //delete cash transactions
           
           it = bankTransBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
           
           while(it.hasNext()){
               
            blCashUpdate.deleteOnlyCashTransaction((TurqCashTransaction)it.next());
               
           }
           
            
            //delete accounting transactions
           AccDALTransactionSearch dalAcc = new AccDALTransactionSearch();
           it = bankTransBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
           
           while(it.hasNext()){
              dalAcc.deleteTransaction((TurqAccountingTransaction)it.next());
               
           }
           
           //delete transaction..
           BankDALCommon.deleteObject(bankTransBill);
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    
}
