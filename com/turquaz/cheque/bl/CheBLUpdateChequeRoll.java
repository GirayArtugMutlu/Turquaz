
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

import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
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
            
            account.setAccountingAccountsId(new Integer(-1));
            new CashBLCashTransactionAdd().saveCashTransaction(cashCard,chequeRoll.getTurqEngineSequence(),EngBLCommon.CASH_CHEQUE_COLLECT,rollDate,Messages.getString("CheBLSaveChequeTransaction.5"),rollNo,totals,account); //$NON-NLS-1$
            
    		
    		
    		
    	}
    	catch(Exception ex){
    		throw ex;
    	}
    }
    
    public static void updateChequeRollIn(TurqChequeRoll chequeRoll, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType,boolean sumTransTotal)throws Exception{
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
            bankCardEmpty.setBanksCardsId(new Integer(-1));
            chequeRoll.setTurqBanksCard(bankCardEmpty);
               
           }
           else if(bankCard!=null)
           {
               chequeRoll.setTurqBanksCard(bankCard);
               
               TurqCurrentCard curCardEmpty = new TurqCurrentCard();
               curCardEmpty.setCurrentCardsId(new Integer(-1));
               chequeRoll.setTurqCurrentCard(curCardEmpty);
               
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
                  
                   if(rollType == EngBLCommon.CHEQUE_TRANS_IN){
                    blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getEngineSequencesId(),"Çek Portföy No:"+cheque.getChequesPortfolioNo() );
                }
                else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT){
                	 blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getEngineSequencesId(),"Çek Portföy No:"+cheque.getChequesPortfolioNo() );
                }
               
               
               }
            /*   if(bankCard!=null&&!sumTransTotal)
               {
                
               BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),cheque.getChequesAmount(),rollDate,"Çek Portfoy No:"+cheque.getChequesPortfolioNo(),rollNo);
               
               }
            */
               totalAmount = totalAmount.add(cheque.getChequesAmount());
               
               
           
           } 
           if(curCard!=null&&sumTransTotal)
           {
              
               if(rollType == EngBLCommon.CHEQUE_TRANS_IN){
                blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getEngineSequencesId(),"Çek Bordro No:"+chequeRoll.getChequeRollNo());
              }
              else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT){
              	blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getEngineSequencesId(),"Çek Bordro No:"+chequeRoll.getChequeRollNo());
              }
           }
      
           /*   if(bankCard!=null&&sumTransTotal)
           {
            
           BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),totalAmount,rollDate,"Çek Bordro No:"+rollNo,rollNo);
           
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
	            
	           new CashBLCashTransactionUpdate().deleteCashTrans(cashTrans);
	            
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
