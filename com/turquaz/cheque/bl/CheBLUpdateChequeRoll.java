
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
import java.util.Iterator;
import java.util.List;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeRollAccountingAccount;

import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLUpdateChequeRoll {

    public static void initializeChequeRoll(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
           CheDALUpdate.initializeChequeRoll(chequeRoll); 
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static TurqChequeRoll initializeChequeRoll(Integer chequeRollId)throws Exception {
        try{
            
            return CheDALUpdate.initializeChequeRoll(chequeRollId); 
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static void updateChequeCollectRoll(TurqChequeRoll chequeRoll,
    										TurqCashCard cashCard, String rollNo,Date rollDate,List chequeList
											)throws Exception{
    	try{
    		
    		emptyCheckRollIn(chequeRoll);
    		
    		
            chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
            chequeRoll.setLastModified(Calendar.getInstance().getTime());
            chequeRoll.setChequeRollNo(rollNo);
            chequeRoll.setChequeRollsDate(rollDate);
          
            CheDALSave.update(chequeRoll);
                      
          
            if(cashCard.getTurqAccountingAccount()!=null){
                
                	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
                	rollAccountingAccount.setId(chequeRoll.getId());
                	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
                	rollAccountingAccount.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
                	CheDALSave.save(rollAccountingAccount);
                	
              }
            
            
            BigDecimal chequeTotals = new BigDecimal(0);
            
            for(int i = 0; i<chequeList.size();i++){
            	TurqChequeCheque cheque=(TurqChequeCheque)chequeList.get(i);
              
              chequeTotals = chequeTotals.add(cheque.getChequesAmount()); 
              
             
              
            }
            
            List totals =new ArrayList();
            
            totals.add(chequeTotals);
            
            /**
             * TODO accounting entegration da duzeltilecek
             */
            
            TurqAccountingAccount account = new TurqAccountingAccount();
            
            account.setId(new Integer(-1));
//          TODO cheq exRate
            new CashBLCashTransactionAdd().saveCashTransaction(cashCard,
            		chequeRoll.getTurqEngineSequence(),EngBLCommon.CASH_CHEQUE_COLLECT,
					rollDate,Messages.getString("CheBLSaveChequeTransaction.5"),rollNo, //$NON-NLS-1$
					totals,account,EngBLCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
            
            CheBLSaveChequeTransaction.saveRollAccountingTransactions(cashCard.getTurqAccountingAccount(),null,chequeRoll,chequeTotals,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.1") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
            
    		
    		
    		
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    }
    
    public static void updateChequeRollIn(TurqChequeRoll chequeRoll,TurqAccountingAccount rollAccount, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType,boolean sumTransTotal, TurqCurrencyExchangeRate exchangeRate)throws Exception{
        try{
            
           
        	 emptyCheckRollIn(chequeRoll);
           
           chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
           chequeRoll.setLastModified(Calendar.getInstance().getTime());
           chequeRoll.setChequeRollNo(rollNo);
           chequeRoll.setChequeRollsDate(rollDate);
           chequeRoll.setSumChequeAmounts(sumTransTotal);
          
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
           
           if(rollAccount!=null){
            
            	TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
            	rollAccountingAccount.setId(chequeRoll.getId());
            	rollAccountingAccount.setTurqChequeRoll(chequeRoll);
            	rollAccountingAccount.setTurqAccountingAccount(rollAccount);
            	CheDALSave.save(rollAccountingAccount);          
            
            }
           
          CheDALSave.update(chequeRoll);
                
           TurqChequeCheque cheque;
         
           TurqChequeChequeInRoll chequeInRoll;
          
           CurBLCurrentTransactionAdd blCurrent = new CurBLCurrentTransactionAdd();
           BigDecimal totalAmount = new BigDecimal(0);
           
           for(int i = 0; i<chequeList.size();i++){
               
             
               cheque = (TurqChequeCheque)chequeList.get(i);     
              
               
               //save current transaction...
               if(curCard!=null&&!sumTransTotal)
               {
                  if(rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue()){
                    blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),Messages.getString("CheBLUpdateChequeRoll.2")+cheque.getChequesPortfolioNo(),exchangeRate ); //$NON-NLS-1$
                }
                else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue()){
                	 blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),Messages.getString("CheBLUpdateChequeRoll.3")+cheque.getChequesPortfolioNo(),exchangeRate ); //$NON-NLS-1$
                }
               
               
               }
             
               if(rollType==EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
               {
                         
               TurqCurrentCard currentCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque);
               blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),"Cari Cek ?adesi "+cheque.getChequesPortfolioNo(),exchangeRate);
                             	
               }
               else if(rollType==EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT.intValue())
               {
                         
               TurqCurrentCard currentCard = CheDALSearch.getCurrentCardOfGivenCheque(cheque);
               blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),"Cari Cek ?adesi "+cheque.getChequesPortfolioNo(),exchangeRate);
                             	
               }
               
            /*   if(bankCard!=null&&!sumTransTotal)
               {
                
               BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),cheque.getChequesAmount(),rollDate,"�ek Portfoy No:"+cheque.getChequesPortfolioNo(),rollNo);
               
               }
            */
               totalAmount = totalAmount.add(cheque.getChequesAmount());
               
               
           
           } 
           
           if(curCard!=null&&sumTransTotal)
           {
              
               if(rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue()){
                blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),Messages.getString("CheBLUpdateChequeRoll.4")+chequeRoll.getChequeRollNo(),exchangeRate); //$NON-NLS-1$
              }
              else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue()){
              	blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getId(),Messages.getString("CheBLUpdateChequeRoll.5")+chequeRoll.getChequeRollNo(),exchangeRate); //$NON-NLS-1$
              }
           }
           
           if(rollType==EngBLCommon.CHEQUE_TRANS_IN.intValue())
           {
           	TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
//          TODO acc trans exRate
           	CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount,curAccount,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.6")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
           	
           }
           else if(rollType==EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
           {
           
           	CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.7")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
           }
           
           else if(rollType==EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
           {
           
           	TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
           	
           	CheBLSaveChequeTransaction.saveRollAccountingTransactions(curAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.8")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
           
           }
           else if(rollType==EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
           {
                     
           	CheBLUpdateCheque.updateBankTransactions(chequeRoll); 
           	CheBLSaveChequeTransaction.saveRollAccountingTransactions(null,null,chequeRoll,null,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.9") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
                       	
           }
           else if(rollType==EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY.intValue())
           {
                     
           	CheBLSaveChequeTransaction. saveRollAccountingTransactions(rollAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.10") +chequeRoll.getChequeRollNo()); //$NON-NLS-1$
                      	
           }
           
           else if(rollType==EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
           {
                     
           	CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate(),Messages.getString("CheBLUpdateChequeRoll.0") +chequeRoll.getChequeRollNo());  //$NON-NLS-1$
             
           	
           }
          
           
      
           /*   if(bankCard!=null&&sumTransTotal)
           {
            
           BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),totalAmount,rollDate,"�ek Bordro No:"+rollNo,rollNo);
           
           }
           */    
            
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    
    
    public static void emptyCheckRollIn(TurqChequeRoll chequeRoll)throws Exception
    {
        try{
            
        
	        
	        //Delete Current Transaction 
	        
	       Iterator it = chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
	        while(it.hasNext()){
	            
	           CheDALSave.delete(it.next());
	            
	        }
	      
	        //Delete Cash Transactions..
	        it = chequeRoll.getTurqEngineSequence().getTurqCashTransactions().iterator();
	        while(it.hasNext()){
	        
	        	TurqCashTransaction cashTrans = (TurqCashTransaction)it.next();
	        	new CashBLCashTransactionSearch().initializeCashTransaction(cashTrans);
	            
	           new CashBLCashTransactionUpdate().deleteChequeCashTrans(cashTrans);
	            
	        }
	      
	        //Delete Accounting Transactions..
	        it = chequeRoll.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
	       
	        while(it.hasNext()){
	        
	        	TurqAccountingTransaction accTrans = (TurqAccountingTransaction)it.next();
	        	new AccBLTransactionSearch().removeAccountingTransaction(accTrans);
	            
	        }
	        //Delete roll Account 
	        //
	        
	        if(chequeRoll.getTurqChequeRollAccountingAccount()!=null)
	        {
	        	CheDALSave.delete(chequeRoll.getTurqChequeRollAccountingAccount());
	        }
	        
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static void deleteChequeRollIn(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
        	emptyCheckRollIn(chequeRoll);
            
	        //Delete Roll Now
	        
	        CheDALSave.delete(chequeRoll);
	        
	        
            
        }
        catch(Exception ex)
        {
           throw ex;
        }
    }
}
