
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
import java.util.Calendar;
import java.util.Date;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqBanksTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class BankBLTransactionAdd {
    
    public static void saveTransaction(TurqBanksCard bankCard, TurqCurrentCard curCard, 
                                       int type, TurqEngineSequence seq,
                                       BigDecimal totalAmount,
                                       Date transDate,
                                       String definition,
                                       String docNo)throws Exception {
        try
        {
            if(seq ==null){
                try{
                TurqModule module = new TurqModule();
                module.setModulesId(new Integer(EngBLCommon.MODULE_BANKS));
                seq = new TurqEngineSequence();
                seq.setTurqModule(module);
                BankDALCommon.saveObject(seq);
                }
                catch(Exception ex){
                    throw ex;
                }
            }
            TurqBanksTransactionType transType = new TurqBanksTransactionType();
            transType.setBankTransactionTypesId(new Integer(type));
            
            TurqBanksTransactionBill bankTransBill = new TurqBanksTransactionBill();
            System.out.println(Calendar.getInstance().getTime());
            
            bankTransBill.setTurqBanksCard(bankCard);           
            bankTransBill.setTurqEngineSequence(seq);
            bankTransBill.setTransactionBillDate(transDate);
            bankTransBill.setTransactionBillDefinition(definition);
            bankTransBill.setTransactionBillNo(docNo);
            bankTransBill.setTurqBanksTransactionType(transType);
            
            bankTransBill.setCreatedBy(System.getProperty("user"));
       	    bankTransBill.setUpdatedBy(System.getProperty("user"));
       	    bankTransBill.setLastModified(Calendar.getInstance().getTime());
         	bankTransBill.setCreationDate(Calendar.getInstance().getTime());
         
     
         	
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
         
    	 if(type==EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
         {
            accTransRowBank.setDeptAmount(totalAmount);
            accTransRowBank.setCreditAmount(new BigDecimal(0));
            
            accTransRowCurrent.setDeptAmount(new BigDecimal(0));
            accTransRowCurrent.setCreditAmount(totalAmount);
            
            transRow.setDeptAmount(new BigDecimal(0));
            transRow.setCreditAmount(totalAmount);
            
          
            currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
            currentTransDefinition = curCard.getCardsName()+" 'den Havale";
            
            
         }
         
         else if(type==EngBLCommon.BANK_TRANS_SEND_MONEY)
         {
             
             
             accTransRowBank.setDeptAmount(new BigDecimal(0));
             accTransRowBank.setCreditAmount(totalAmount);
             
             accTransRowCurrent.setDeptAmount(totalAmount);
             accTransRowCurrent.setCreditAmount(new BigDecimal(0));
             
             transRow.setDeptAmount(totalAmount);
             transRow.setCreditAmount(new BigDecimal(0));
                      
             currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
             currentTransDefinition = curCard.getCardsName()+" 'e Havale";
             
         } 
         
         /**
          * Save transaction bill
          */
         BankDALCommon.saveObject(bankTransBill);
         
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
   	            						  seq.getEngineSequencesId(),currentTransDefinition);
   	
   		    
   	    
   	    
   	    
   	    
   	    /**
   	     * Save Accounting Transaction 
   	     * 
   	    */
   	   
   	   Integer transId = blAccTran.saveAccTransaction(transDate,docNo,accTransType,seq.getTurqModule().getModulesId().intValue(),seq.getEngineSequencesId(),definition);
   	   blAccTran.saveAccTransactionRow(accTransRowBank,transId);
   	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId);
       	    
       	 
            
            
            
        
        
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    
    private static void saveTransactionRow() throws Exception {
        try
        {
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    

}
