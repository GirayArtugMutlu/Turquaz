
package com.turquaz.cheque.bl;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeRollAccountingAccount;
import com.turquaz.engine.dal.TurqChequeTransactionType;

import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class CheBLSaveChequeTransaction {
    
    public CheBLSaveChequeTransaction(){
        
    }
    
    public static void saveChequeRoll(TurqAccountingAccount rollAccount, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType, boolean sumTransTotal, TurqCurrencyExchangeRate exchangeRate)throws Exception {
     
      try{
      	
 
      	
          TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(new Integer(rollType));
         
         
          TurqModule module = new TurqModule();
          module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          
          
          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          chequeRoll.setSumChequeAmounts(sumTransTotal);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          
          if(curCard!=null)
          {
           chequeRoll.setTurqCurrentCard(curCard);
           
           TurqBanksCard bankCardEmpty = new TurqBanksCard();
           bankCardEmpty.setId(new Integer(-1));
           chequeRoll.setTurqBanksCard(bankCardEmpty);
              
          }
          else if(bankCard!=null)
          {
              chequeRoll.setTurqBanksCard(bankCard);
              
              TurqCurrentCard curCardEmpty = new TurqCurrentCard();
              curCardEmpty.setId(new Integer(-1));
              chequeRoll.setTurqCurrentCard(curCardEmpty);              
              
          }
          
          chequeRoll.setTurqEngineSequence(seq);
             
          CheDALSave.save(chequeRoll);
          
          if(rollAccount!=null){
          
          	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
          	rollAccountingAccount.setId(chequeRoll.getId());
          	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
          	rollAccountingAccount.setTurqAccountingAccount(rollAccount);
          	CheDALSave.save(rollAccountingAccount);          
          
          }
          
          TurqChequeCheque cheque;
          TurqChequeChequeInRoll chequeInRoll;
          CurBLCurrentTransactionAdd blCurrent = new CurBLCurrentTransactionAdd();
          BigDecimal totalAmount = new BigDecimal(0);
          
          for(int i = 0; i<chequeList.size();i++){
              
              chequeInRoll = new TurqChequeChequeInRoll();
              
              cheque = (TurqChequeCheque)chequeList.get(i);
               
              CheDALSave.saveOrUpdate(cheque);
              
              chequeInRoll.setTurqChequeCheque(cheque);
              chequeInRoll.setTurqChequeRoll(chequeRoll);
              
              chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
              chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
              chequeInRoll.setLastModified(Calendar.getInstance().getTime());
              chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
              
              
              CheDALSave.save(chequeInRoll);
              
              totalAmount = totalAmount.add(cheque.getChequesAmount());
              //save current transaction...
              if(curCard!=null&&!sumTransTotal)
              {
                 if(rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue()){
                     blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.0")+cheque.getChequesPortfolioNo(),exchangeRate ); //$NON-NLS-1$
                 }
                 else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue()){
                 	 blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.1")+cheque.getChequesPortfolioNo(),exchangeRate ); //$NON-NLS-1$
                 }
              }
      
              /*if(bankCard!=null&&!sumTransTotal)
              {
               
              BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,cheque.getChequesAmount(),rollDate,"Çek Portfoy No:"+cheque.getChequesPortfolioNo(),rollNo);
              
              }
              */
              
              
          
          }   
          
          if(curCard!=null&&sumTransTotal)
          {
            if(rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue()){
              blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.2")+chequeRoll.getChequeRollNo(),exchangeRate); //$NON-NLS-1$
            }
            else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue()){
            	blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.3")+chequeRoll.getChequeRollNo(),exchangeRate); //$NON-NLS-1$
            }
            
          }
          
         if(rollType==EngBLCommon.CHEQUE_TRANS_IN.intValue())
         {
         	TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
//         	TODO acc trans exRate
         	saveRollAccountingTransactions(rollAccount,curAccount,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.5")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
         	
         }
         else if(rollType==EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
         {
         
         	saveRollAccountingTransactions(rollAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.6")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
         }
         
         else if(rollType==EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
         {
         
         	TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
         	
         	saveRollAccountingTransactions(curAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.7")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
         
         }
        
         
        
          
       /*   if(bankCard!=null&&sumTransTotal)
          {
           
          BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,totalAmount,rollDate,"Çek Bordro No:"+rollNo,rollNo);
          
          }
          */
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    
    public static void saveCollectFromBank( String rollNo,Date rollDate,List chequeList)throws Exception {
    	
    	 
    	  TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK);
          
          TurqModule module = new TurqModule();
          module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          

          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          chequeRoll.setSumChequeAmounts(false);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          TurqCurrentCard curCardEmpty = new TurqCurrentCard();
          curCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqCurrentCard(curCardEmpty);   
          
          TurqBanksCard bankCardEmpty = new TurqBanksCard();
          bankCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqBanksCard(bankCardEmpty);
          
          chequeRoll.setTurqEngineSequence(seq);
          CheDALSave.save(chequeRoll);
          
          TurqChequeChequeInRoll chequeInRoll;
          TurqChequeCheque cheque;
          
          
          for(int i = 0; i<chequeList.size();i++){
            
            chequeInRoll = new TurqChequeChequeInRoll();
            
            cheque = (TurqChequeCheque)chequeList.get(i);     
            
            
            chequeInRoll.setTurqChequeCheque(cheque);
            chequeInRoll.setTurqChequeRoll(chequeRoll);
            
            chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setLastModified(Calendar.getInstance().getTime());
            chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
            
            
            CheDALSave.save(chequeInRoll);
            
            BankBLTransactionAdd.saveChequeTransaction(CheDALSearch.getBankOfCustomerCheque(cheque),seq,cheque.getChequesAmount(),rollDate,Messages.getString("CheBLSaveChequeTransaction.4")+rollNo,rollNo,cheque.getTurqCurrencyExchangeRate()); //$NON-NLS-1$
            
            
          }
         
          saveRollAccountingTransactions(null,null,chequeRoll,null,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.8") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
          
         
          
          
    	
    	
    }
    public static void saveReturnFromBank(TurqAccountingAccount rollAccount, String rollNo,Date rollDate,List chequeList)throws Exception {
    	
    	 
    	  TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY);
          
          TurqModule module = new TurqModule();
          module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          

          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          chequeRoll.setSumChequeAmounts(false);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          TurqCurrentCard curCardEmpty = new TurqCurrentCard();
          curCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqCurrentCard(curCardEmpty);   
          
          TurqBanksCard bankCardEmpty = new TurqBanksCard();
          bankCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqBanksCard(bankCardEmpty);
          
          chequeRoll.setTurqEngineSequence(seq);
          CheDALSave.save(chequeRoll);
          
          if(rollAccount!=null){
            
            	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
            	rollAccountingAccount.setId(chequeRoll.getId());
            	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
            	rollAccountingAccount.setTurqAccountingAccount(rollAccount);
            	CheDALSave.save(rollAccountingAccount);          
            
            }
          
          
          TurqChequeChequeInRoll chequeInRoll;
          TurqChequeCheque cheque;
          
          BigDecimal amount = new BigDecimal(0);
          
          for(int i = 0; i<chequeList.size();i++){
            
            chequeInRoll = new TurqChequeChequeInRoll();
            
            cheque = (TurqChequeCheque)chequeList.get(i);
       
            
            
            chequeInRoll.setTurqChequeCheque(cheque);
            chequeInRoll.setTurqChequeRoll(chequeRoll);
            
            chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setLastModified(Calendar.getInstance().getTime());
            chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
            
            amount = amount.add(cheque.getChequesAmount());
            
            
            CheDALSave.save(chequeInRoll);
           
            
          }
          saveRollAccountingTransactions(rollAccount,null,chequeRoll,amount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.9") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
          
         
         
    
    }
    public static void saveReturnFromCurrent(TurqAccountingAccount rollAccount, String rollNo,Date rollDate,List chequeList)throws Exception {
    	
    	 
    	  TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT);
          
          TurqModule module = new TurqModule();
          module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          

          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          chequeRoll.setSumChequeAmounts(false);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          TurqCurrentCard curCardEmpty = new TurqCurrentCard();
          curCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqCurrentCard(curCardEmpty);   
          
          TurqBanksCard bankCardEmpty = new TurqBanksCard();
          bankCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqBanksCard(bankCardEmpty);
          
          chequeRoll.setTurqEngineSequence(seq);
          CheDALSave.save(chequeRoll);
          
          if(rollAccount!=null){
            
            	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
            	rollAccountingAccount.setId(chequeRoll.getId());
            	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
            	rollAccountingAccount.setTurqAccountingAccount(rollAccount);
            	CheDALSave.save(rollAccountingAccount);          
            
            }
          
          
          TurqChequeChequeInRoll chequeInRoll;
          TurqChequeCheque cheque;
          
          BigDecimal amount = new BigDecimal(0);
          
          for(int i = 0; i<chequeList.size();i++){
            
            chequeInRoll = new TurqChequeChequeInRoll();
            
            cheque = (TurqChequeCheque)chequeList.get(i);
       
            
            
            chequeInRoll.setTurqChequeCheque(cheque);
            chequeInRoll.setTurqChequeRoll(chequeRoll);
            
            chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setLastModified(Calendar.getInstance().getTime());
            chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
            
            amount = amount.add(cheque.getChequesAmount());
            CheDALSave.save(chequeInRoll);
           
            
          }
          
          saveRollAccountingTransactions(rollAccount,null,chequeRoll,amount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.10") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
          
         
    
    }
    
    
    
    public static void saveChequeCollect(TurqCashCard cashCard, String rollNo,Date rollDate,List chequeList)throws Exception {
    	
    	 
    	
    	  TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT);
          
          TurqModule module = new TurqModule();
          module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          

          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          chequeRoll.setSumChequeAmounts(false);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          TurqCurrentCard curCardEmpty = new TurqCurrentCard();
          curCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqCurrentCard(curCardEmpty);   
          
          TurqBanksCard bankCardEmpty = new TurqBanksCard();
          bankCardEmpty.setId(new Integer(-1));
          chequeRoll.setTurqBanksCard(bankCardEmpty);
          
          chequeRoll.setTurqEngineSequence(seq);
          
          CheDALSave.save(chequeRoll);
          
          if(cashCard.getTurqAccountingAccount()!=null){
            
            	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
            	rollAccountingAccount.setId(chequeRoll.getId());
            	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
            	rollAccountingAccount.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
            	CheDALSave.save(rollAccountingAccount);          
            
           }
          
          
          
          TurqChequeChequeInRoll chequeInRoll;
          TurqChequeCheque cheque;
          
          BigDecimal chequeTotals = new BigDecimal(0);
          
          for(int i = 0; i<chequeList.size();i++){
            
            chequeInRoll = new TurqChequeChequeInRoll();
            
            cheque = (TurqChequeCheque)chequeList.get(i);
                
            
            chequeInRoll.setTurqChequeCheque(cheque);
            chequeInRoll.setTurqChequeRoll(chequeRoll);
            
            chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeInRoll.setLastModified(Calendar.getInstance().getTime());
            chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
            
            chequeTotals = chequeTotals.add(cheque.getChequesAmount()); 
            
            CheDALSave.save(chequeInRoll);
            
            TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque);
            /**
             * TODO save current Transaction Here
             */
            
            
          }
          
          List totals =new ArrayList();
          
          totals.add(chequeTotals);
          
          /**
           * TODO accounting entegration da duzeltilecek
           */
          TurqAccountingAccount account = new TurqAccountingAccount();
          
          account.setId(new Integer(-1));
//        TODO bill exRate
          new CashBLCashTransactionAdd().saveCashTransaction(cashCard,chequeRoll.getTurqEngineSequence(),
          		EngBLCommon.CASH_CHEQUE_COLLECT,rollDate,
				Messages.getString("CheBLSaveChequeTransaction.5"),rollNo,totals, //$NON-NLS-1$
				account,EngBLCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
          
          saveRollAccountingTransactions(cashCard.getTurqAccountingAccount(),null,chequeRoll,chequeTotals,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLSaveChequeTransaction.11")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
          
    	
    	
    }
    
    
    public  static void saveRollAccountingTransactions(TurqAccountingAccount rollAccount,TurqAccountingAccount counterAccount,TurqChequeRoll roll, BigDecimal amount, TurqCurrencyExchangeRate exchangeRate,String definition)
    throws Exception
    {
    	
    	Map creditAccountsMap = new HashMap();
    	Map deptAccountsMap = new HashMap();
    	
        boolean okToSave = prepareAccountingRows(creditAccountsMap,deptAccountsMap,rollAccount,counterAccount,roll,amount,exchangeRate);
    	
        if(!okToSave)
    	{
    		
    		return ;
    		
    	}       
    	
    	AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
    	
    	
    	int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
    	
    	
    	//  Save Accounting Transaction
    	//    		TODO cheq exRate
    		Integer transId = blAccTran.saveAccTransaction(roll.getChequeRollsDate(),
    				roll.getChequeRollNo(), accTransType, roll.getTurqEngineSequence().getTurqModule()
    						.getId().intValue(), roll.getTurqEngineSequence()
    						.getId(), definition,exchangeRate);
    	
    	
    		
    		
    		
    		//    		save credit columns...
      		
      		Iterator it = creditAccountsMap.keySet().iterator();
    		
    		while(it.hasNext())
    		{
    		Integer accountId = (Integer)it.next();
    		TurqAccountingAccount account = new TurqAccountingAccount();
    		account.setId(accountId);
    		
    		TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
    		
    		transCounterRow.setTurqAccountingAccount(account);
    		transCounterRow.setTransactionDefinition(definition);
     	   	
    		transCounterRow.setDeptAmount(new BigDecimal(0));
    		transCounterRow.setCreditAmount((BigDecimal)creditAccountsMap.get(accountId));    
    		 
    		blAccTran.saveAccTransactionRow(transCounterRow,transId,exchangeRate);       
    			
    			
    		}	
    		
    		
    		//  save debit columns
    		it = deptAccountsMap.keySet().iterator();
    		
    		while(it.hasNext())
    		{
    		
    		Integer accountId = (Integer)it.next();
    		TurqAccountingAccount account = new TurqAccountingAccount();
    		account.setId(accountId);
    		
    		TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
    		
    		transCounterRow.setTurqAccountingAccount(account);
    		transCounterRow.setTransactionDefinition(definition);
     	   	
    		transCounterRow.setDeptAmount((BigDecimal)deptAccountsMap.get(accountId));
    		transCounterRow.setCreditAmount(new BigDecimal(0));    
    		 
    		blAccTran.saveAccTransactionRow(transCounterRow,transId,exchangeRate);       
    			
    			
    		}	
    		
    		
    	
    	
    	
    	    	
    }
    
    
    private static boolean prepareAccountingRows(Map creditAccountsMap, Map deptAccountsMap,TurqAccountingAccount rollAccount,TurqAccountingAccount counterAccount,TurqChequeRoll roll, BigDecimal amount, TurqCurrencyExchangeRate exchangeRate)throws Exception
	{
    	
    	creditAccountsMap.clear();
    	deptAccountsMap.clear();
    	
    	
    	int type = roll.getTurqChequeTransactionType().getId().intValue();
    	
    	if(type==EngBLCommon.CHEQUE_TRANS_IN.intValue() )
       	{
    		if(rollAccount == null )
        	{
        	
        		return false;
        	
        	}
        	  	
    		if(counterAccount==null)
    		{
    			return false;
    		}
        	
        	deptAccountsMap.put(rollAccount.getId(),amount);
        	
        	creditAccountsMap.put(counterAccount.getId(),amount);
        	
    	
    	}
    	else if(type == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
    	{
       	
        		if(rollAccount == null )
            	{
            	
            		return false;
            	
            	}

        		CheBLUpdateChequeRoll.initializeChequeRoll(roll);  	
        	
        		
        		TurqChequeCheque cheque = null;
        		TurqAccountingAccount chequeAccount =null;
        		
        		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
        		
        		while(it.hasNext())
        		{
        			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
        			
        			chequeAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_IN.intValue());
        			
        			if(chequeAccount == null)
        			{
        				return false ;
        			}
        			if(creditAccountsMap.containsKey(chequeAccount.getId()))
        			{
        				BigDecimal total = (BigDecimal)creditAccountsMap.get(chequeAccount.getId());
        				total = total.add(cheque.getChequesAmount());
        				creditAccountsMap.put(chequeAccount.getId(),total);    				
        			}
        			else{
        				
        				creditAccountsMap.put(chequeAccount.getId(),cheque.getChequesAmount());
        			
        			}  		
        		
        		}
        		
        		
        		deptAccountsMap.put(rollAccount.getId(),amount);
               	
        }

    	else if(type == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue()){
    		
    		if(rollAccount == null )
        	{
        	
        		return false;
        	
        	}
        	  	
    		
    		
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount chequeAccount =null;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
    		
    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			if(cheque.getChequesType()==EngBLCommon.CHEQUE_TYPE_CUSTOMER)
    			{
    			
    				chequeAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_IN.intValue());
    			
    			}
    			else
    			{
    				
    				TurqBanksCard bankCard = cheque.getTurqBanksCard();
    				chequeAccount = BankBLBankCardSearch.getAccountingAccount(bankCard,EngBLCommon.BANK_ACC_TYPE_CHEQUES_GIVEN);
    				
    			   				
    			}
    			
    			
    			if(chequeAccount == null)
    			{
    				return false ;
    			}
    			if(creditAccountsMap.containsKey(chequeAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)creditAccountsMap.get(chequeAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				creditAccountsMap.put(chequeAccount.getId(),total);    				
    			}
    			else{
    				
    				creditAccountsMap.put(chequeAccount.getId(),cheque.getChequesAmount());
    			
    			}  		
    		
    		}
    		
    		deptAccountsMap.put(rollAccount.getId(),amount);
             	
    	}
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
    	{
    	
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount deptAccount =null;
    		TurqAccountingAccount creditAccount = null;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
    		
    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			
    			TurqBanksCard bankCard = CheDALSearch.getBankOfCustomerCheque(cheque);
    			   			
    			deptAccount = BankBLBankCardSearch.getAccountingAccount(bankCard,EngBLCommon.BANK_ACC_TYPE_GENERAL);
    			
    			creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue());
    			
    			
    			if(deptAccount==null||creditAccount==null)
    			{
    					return false ;
    				
    			}
    			
    			if(deptAccountsMap.containsKey(deptAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)deptAccountsMap.get(deptAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				deptAccountsMap.put(deptAccount.getId(),total);    				
    			}
    			else{
    				
    				deptAccountsMap.put(deptAccount.getId(),cheque.getChequesAmount());
    			
    			}  
    			
    			if(creditAccountsMap.containsKey(creditAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)creditAccountsMap.get(creditAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				creditAccountsMap.put(creditAccount.getId(),total);    				
    			}
    			else{
    				
    				creditAccountsMap.put(creditAccount.getId(),cheque.getChequesAmount());
    			
    			}  			
    		}    		
    	}  
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT.intValue())
    	{
    	
    		if(rollAccount==null){
    			return false ;
    		}
  
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount deptAccount = rollAccount;
    		TurqAccountingAccount creditAccount = null;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();

    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_IN.intValue());
    			

    			if(deptAccount==null||creditAccount==null)
    			{
    				return false ;
    				
    			}
    			
    			if(creditAccountsMap.containsKey(creditAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)creditAccountsMap.get(creditAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				creditAccountsMap.put(creditAccount.getId(),total);    				
    			}
    			else{
    				
    				creditAccountsMap.put(creditAccount.getId(),cheque.getChequesAmount());
    			
    			}  	
    			
    			
    		}
    		deptAccountsMap.put(deptAccount.getId(),amount);
      		
    	}
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY.intValue())
    	{
    		if(rollAccount==null){
    			return false ;
    		}
    	
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount creditAccount = null;
    		TurqAccountingAccount deptAccount = rollAccount;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
    	
    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			TurqBanksCard bankCard = CheDALSearch.getBankOfCustomerCheque(cheque);
	   			   			
    			creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue());
    			
	
    			if(creditAccount==null)
    			{
    				return false;
		
    			}
    			
    			if(creditAccountsMap.containsKey(creditAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)creditAccountsMap.get(creditAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				creditAccountsMap.put(creditAccount.getId(),total);    				
    			}
    			
    			else{
    				
    				creditAccountsMap.put(creditAccount.getId(),cheque.getChequesAmount());
    			
    			}     			
    		}
    		
    		
    		deptAccountsMap.put(deptAccount.getId(),amount);
    	}
    	
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
    	{
    		if(rollAccount==null){
    			return false ;
    		}
    	
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount creditAccount = null;
    		TurqAccountingAccount deptAccount = rollAccount;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
    	
    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			TurqBanksCard bankCard = CheDALSearch.getBankOfCustomerCheque(cheque);
	   			   			
    			creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_IN.intValue());
    			
	
    			if(creditAccount==null)
    			{
    				return false;
		
    			}
    			
    			if(creditAccountsMap.containsKey(creditAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)creditAccountsMap.get(creditAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				creditAccountsMap.put(creditAccount.getId(),total);    				
    			}
    			
    			else{
    				
    				creditAccountsMap.put(creditAccount.getId(),cheque.getChequesAmount());
    			
    			}     			
    		}
    		
    		
    		deptAccountsMap.put(deptAccount.getId(),amount);
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return true;
	}
    
    
    

}
