
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
* @author  Onsel
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;


import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;

public class CashBLCashTransactionUpdate {

    CashDALCashCard dalCash = new CashDALCashCard();
    
    AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
    CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();
	
    private Calendar cal=Calendar.getInstance();
    
    public CashBLCashTransactionUpdate(){
        
    }
    
    public TurqCurrentCard getCurrentCard(TurqEngineSequence seq) throws Exception{
        try{
            
            return dalCash.getCurrentCard(seq);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    public void deleteOnlyCashTransaction(TurqCashTransaction cashTrans) throws Exception{
        try
        {
            dalCash.initiliazeCashTrans(cashTrans);
            Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
            while(it.hasNext()){
                
                dalCash.delete(it.next());
                
            }
            
                
            
            dalCash.delete(cashTrans);
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
        
        
    }
    
    public void deleteCashTrans(TurqCashTransaction cashTrans)throws Exception{
        try{
            
            // if it is a current transaction the delete Current Transactions
            if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
            
                
           //delete current Transactions..      
           Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
                while(it.hasNext()){
                    
                    dalCash.delete(it.next());
                    
                }
                
                
            }
            
            //delete cash Transaction rows...
            Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
            while(it.hasNext()){
                
                dalCash.delete(it.next());
                
            }
            
            
            
            //delete accounting transactions 
            dalCash.deleteAccountingTransaction(cashTrans);
           
            
            dalCash.delete(cashTrans);
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    
    public void updateCashTrans(TurqCashTransaction cashTrans, TurqCashCard cashCard, TurqCurrentCard current, 
					BigDecimal totalAmount, Date transDate,
					String definition, String document_no)throws Exception {
        try{
            
            // if it is a current transaction the delete Current Transactions
            if(cashTrans.getTurqEngineSequence().getTurqModule().getModulesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqEngineSequence().getTurqModule().getModulesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
            
                
           //delete current Transactions..      
         
                Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
                while(it.hasNext()){
                    
                    dalCash.delete(it.next());
                    
                }
                
                
            }
             
             
             //delete cash Transaction rows...
             Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
             while(it.hasNext()){
                 
                 dalCash.delete(it.next());
                 
             }
             
             //delete accounting transactions 
             
             dalCash.deleteAccountingTransaction(cashTrans);
             
             
             
             
             cashTrans.setTurqCashCard(cashCard);
             cashTrans.setTransactionDate(transDate);
             cashTrans.setTransactionDefinition(definition);
             cashTrans.setDocumentNo(document_no);
        	 cashTrans.setUpdatedBy(System.getProperty("user"));
        	 cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));             
             
             
             /*
              * Create cash Transaction Rows
              */
            	 TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
            	 cashTransRow.setCreatedBy(System.getProperty("user"));
            	 cashTransRow.setUpdatedBy(System.getProperty("user"));
            	 cashTransRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
            	 cashTransRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
            	 cashTransRow.setTransactionDefinition(definition);
            	 cashTransRow.setTurqAccountingAccount(current.getTurqAccountingAccount());
            	 
            	 
            	/*
                  * Create Accounting transaction
                  */
                 TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
            	 TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
            	   
            	 accTransRowCash.setTransactionDefinition(definition);
            	 accTransRowCash.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
            	 
            	 accTransRowCurrent.setTransactionDefinition(definition);
            	 accTransRowCurrent.setTurqAccountingAccount(current.getTurqAccountingAccount());
            	 
            	 String currentTransDefinition="";
                 
            	 int accTransType = 0;
                 
            	 boolean currentTransType = false; // Credit or Debit
                 
            	 if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT)
                 {
                    accTransRowCash.setDeptAmount(totalAmount);
                    accTransRowCash.setCreditAmount(new BigDecimal(0));
                    
                    accTransRowCurrent.setDeptAmount(new BigDecimal(0));
                    accTransRowCurrent.setCreditAmount(totalAmount);
                    
                    cashTransRow.setDeptAmount(new BigDecimal(0));
                    cashTransRow.setCreditAmount(totalAmount);
                    
                    accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
                    currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
                    

                    currentTransDefinition = current.getCardsName()+" 'den Nakit";
                    
                 }
                 
                 else if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT)
                 {
                     
                     
                     accTransRowCash.setDeptAmount(new BigDecimal(0));
                     accTransRowCash.setCreditAmount(totalAmount);
                     
                     accTransRowCurrent.setDeptAmount(totalAmount);
                     accTransRowCurrent.setCreditAmount(new BigDecimal(0));
                     
                     cashTransRow.setDeptAmount(totalAmount);
                     cashTransRow.setCreditAmount(new BigDecimal(0));
                              
                     accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
                     currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
                     

                     currentTransDefinition = current.getCardsName()+" 'e Nakit";
                     
                 } 

                 	/**
                 	 * Save Cash Transaction
                 	*/
            	    dalCash.update(cashTrans);
            	    
            	
            	    
            	    
            	    /**
            		 * Save Cash Transaction Row
            		 * 
            		 */  
            	
            	    cashTransRow.setTurqCashTransaction(cashTrans);
            	    
            	    dalCash.save(cashTransRow);
            	    
            	    
            	    
            	  /**
            	   * Save Current transaction
            	  */
            	    
            	    blCurTrans.saveCurrentTransaction(current, transDate,document_no,currentTransType,
            	            						  totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CASH,
            	            						 cashTrans.getTurqEngineSequence().getEngineSequencesId(),currentTransDefinition);
            	
            		    
            	    
            	    
            	    
            	    
            	    /**
            	     * Save Accounting Transaction 
            	     * 
            	    */
            	   
            	   Integer transId = blAccTran.saveAccTransaction(transDate,document_no,accTransType, cashTrans.getTurqEngineSequence().getTurqModule().getModulesId().intValue(),
            	           										   cashTrans.getTurqEngineSequence().getEngineSequencesId(),definition);
            	   blAccTran.saveAccTransactionRow(accTransRowCash,transId);
            	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId);         
            
            
        }
        
        catch(Exception ex){
            
            throw ex;
        }
        
        
        
    }
    
    
    
    
    
}
