
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
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
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
    
    public void deleteChequeCashTrans(TurqCashTransaction cashTrans)throws Exception{
        try{
            
            // if it is a current transaction the delete Current Transactions
            if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
            
                
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
            
            
            dalCash.delete(cashTrans);
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    
    public void deleteCashTrans(TurqCashTransaction cashTrans)throws Exception{
        try{
            
            // if it is a current transaction the delete Current Transactions
            if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
            
                
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
    
    //TODO DONE
    public void updateCashTrans(TurqCashTransaction cashTrans, TurqCashCard cashCard, TurqCurrentCard current, 
					BigDecimal totalAmount, Date transDate,
					String definition, String document_no,TurqCurrencyExchangeRate exchangeRate)throws Exception {
        try{
            
        
            
                
           //delete current Transactions..      
         
                Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
                while(it.hasNext()){
                    
                    dalCash.delete(it.next());
                    
                }
                

             
             
             //delete cash Transaction rows...
             it = cashTrans.getTurqCashTransactionRows().iterator();
             while(it.hasNext()){
                 
                 dalCash.delete(it.next());
                 
             }
             
             //delete accounting transactions 
             
             dalCash.deleteAccountingTransaction(cashTrans);
             
             
             
             
            
             cashTrans.setTransactionDate(transDate);
             cashTrans.setTransactionDefinition(definition);
             cashTrans.setDocumentNo(document_no);
        	 cashTrans.setUpdatedBy(System.getProperty("user"));
        	 cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));             
             
             
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
            	 cashTransRow.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(current,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));
            	 
            	 
            	/*
                  * Create Accounting transaction
                  */
                 TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
            	 TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
            	   
            	 accTransRowCash.setTransactionDefinition(definition);
            	 accTransRowCash.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
            	 
            	 accTransRowCurrent.setTransactionDefinition(definition);
            	 accTransRowCurrent.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(current,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));
            	 
            	 String currentTransDefinition="";
                 
            	 int accTransType = 0;
                 
            	 boolean currentTransType = false; // Credit or Debit
                 
            	 if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT)
                 {
                    accTransRowCash.setDeptAmount(totalAmount);
                    accTransRowCash.setCreditAmount(new BigDecimal(0));
                    
                    accTransRowCurrent.setDeptAmount(new BigDecimal(0));
                    accTransRowCurrent.setCreditAmount(totalAmount);
                    
                    cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
                    cashTransRow.setDeptAmount(new BigDecimal(0));
                    cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
                    cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
                    
                    accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
                    currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
                    

                    currentTransDefinition = current.getCardsName()+" 'den Nakit";
                    
                 }
                 
                 else if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT)
                 {
                     
                     
                     accTransRowCash.setDeptAmount(new BigDecimal(0));
                     accTransRowCash.setCreditAmount(totalAmount);
                     
                     accTransRowCurrent.setDeptAmount(totalAmount);
                     accTransRowCurrent.setCreditAmount(new BigDecimal(0));
                     
                     cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
                     cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
                     cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
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
            	    cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
            	    cashTransRow.setTurqCashTransaction(cashTrans);
            	    
            	    dalCash.save(cashTransRow);
            	    
            	    
            	    
            	  /**
            	   * Save Current transaction
            	  */
            	    
            	    blCurTrans.saveCurrentTransaction(current, transDate,document_no,currentTransType,
            	            						  totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CASH,
            	            						 cashTrans.getTurqEngineSequence().getId(),currentTransDefinition,
													 exchangeRate);
            	
            		    
            	    
            	    
            	    
            	    
            	    /**
            	     * Save Accounting Transaction 
            	     * 
            	    */
            	   
            	   Integer transId = blAccTran.saveAccTransaction(transDate,document_no,accTransType, cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue(),
            	           										   cashTrans.getTurqEngineSequence().getId(),
																   definition,exchangeRate);

            	   blAccTran.saveAccTransactionRow(accTransRowCash,transId,exchangeRate);
            	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId,exchangeRate);         
            
            
        }
        
        catch(Exception ex){
            
            throw ex;
        }
        
        
        
    }
    
    //TODO DONE
    public void updateOtherTrans(TurqCashTransaction cashTrans, TurqCashCard cashCard, TurqAccountingAccount account, 
			BigDecimal totalAmount, Date transDate,
			String definition, String document_no, TurqCurrencyExchangeRate exchangeRate)throws Exception {
try{
    

    
        
   //delete current Transactions..      
 
        Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
        while(it.hasNext()){
            
            dalCash.delete(it.next());
            
        }

     
     
     //delete cash Transaction rows...
     it = cashTrans.getTurqCashTransactionRows().iterator();
     while(it.hasNext()){
         
         dalCash.delete(it.next());
         
     }
     
     //delete accounting transactions 
     
     dalCash.deleteAccountingTransaction(cashTrans);
     
     
     
     
     cashTrans.setTransactionDate(transDate);
     cashTrans.setTransactionDefinition(definition);
     cashTrans.setDocumentNo(document_no);
	 cashTrans.setUpdatedBy(System.getProperty("user"));
	 cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));             
     
     
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
    	 
    	 
    	/*
          * Create Accounting transaction
          */
         TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
    	 TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
    	   
    	 accTransRowCash.setTransactionDefinition(definition);
    	 accTransRowCash.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
    	 
    	 accTransRowCurrent.setTransactionDefinition(definition);
    	 accTransRowCurrent.setTurqAccountingAccount(account);
    	 
    	 String currentTransDefinition="";
         
    	 int accTransType = 0;
         
    	 boolean currentTransType = false; // Credit or Debit
         
    	 if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_OTHER_COLLECT)
         {
            accTransRowCash.setDeptAmount(totalAmount);
            accTransRowCash.setCreditAmount(new BigDecimal(0));
            
            accTransRowCurrent.setDeptAmount(new BigDecimal(0));
            accTransRowCurrent.setCreditAmount(totalAmount);
            
            cashTransRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
            cashTransRow.setDeptAmount(new BigDecimal(0));
            cashTransRow.setCreditAmountInForeignCurrency(totalAmount);
            cashTransRow.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
            
            accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
            currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
            

            
         }
         
         else if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_OTHER_PAYMENT)
         {
             
             
             accTransRowCash.setDeptAmount(new BigDecimal(0));
             accTransRowCash.setCreditAmount(totalAmount);
             
             accTransRowCurrent.setDeptAmount(totalAmount);
             accTransRowCurrent.setCreditAmount(new BigDecimal(0));
             
             cashTransRow.setDeptAmountInForeignCurrency(totalAmount);
             cashTransRow.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
             cashTransRow.setCreditAmount(new BigDecimal(0));
             cashTransRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
                      
             accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
             currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
             
             
         } 

         	/**
         	 * Save Cash Transaction
         	*/
    	    dalCash.update(cashTrans);
    	    
    	
    	    
    	    
    	    /**
    		 * Save Cash Transaction Row
    		 * 
    		 */  
    	    cashTransRow.setTurqCurrencyExchangeRate(exchangeRate);
    	    cashTransRow.setTurqCashTransaction(cashTrans);
    	    
    	    dalCash.save(cashTransRow);
    	    
    	    
    	    
    	
    	    
    	    /**
    	     * Save Accounting Transaction 
    	     * 
    	    */
    	   
    	   Integer transId = blAccTran.saveAccTransaction(transDate,document_no,accTransType, cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue(),
    	           										   cashTrans.getTurqEngineSequence().getId(),
														   definition,exchangeRate);

    	   blAccTran.saveAccTransactionRow(accTransRowCash,transId,exchangeRate);
    	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId,exchangeRate);         
    
    
}

catch(Exception ex){
    
    throw ex;
}



}
    
    //TODO DONE
    public void updateTransBetweenCards(TurqCashTransaction cashTrans, TurqCashCard cashCardWithDebt, TurqCashCard cashCardWithCredit, 
			BigDecimal totalAmount, Date transDate,
			String definition, String document_no, TurqCurrencyExchangeRate exchangeRate)throws Exception {
try{
    
    
        
   //delete current Transactions..      
 
        Iterator it = cashTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
        while(it.hasNext()){
            
            dalCash.delete(it.next());
            
        }
        
        
     
     
     //delete cash Transaction rows...
     it = cashTrans.getTurqCashTransactionRows().iterator();
     while(it.hasNext()){
         
         dalCash.delete(it.next());
         
     }
     
     //delete accounting transactions 
     
     dalCash.deleteAccountingTransaction(cashTrans);
     
     
     
     
     cashTrans.setTransactionDate(transDate);
     cashTrans.setTransactionDefinition(definition);
     cashTrans.setDocumentNo(document_no);
	 cashTrans.setUpdatedBy(System.getProperty("user"));
	 cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));             
     
     
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

			cashTransRowWithDept.setCreditAmountInForeignCurrency(totalAmount);
			cashTransRowWithDept.setCreditAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
			cashTransRowWithDept.setDeptAmount(new BigDecimal(0));
			cashTransRowWithDept.setDeptAmountInForeignCurrency(new BigDecimal(0));
			
			cashTransRowWithCredit.setDeptAmountInForeignCurrency(totalAmount);
			cashTransRowWithCredit.setDeptAmount(totalAmount.multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
			cashTransRowWithCredit.setCreditAmountInForeignCurrency(new BigDecimal(0));
			cashTransRowWithCredit.setCreditAmount(new BigDecimal(0));

			accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
	

	
		/**
		 * Save Cash Transaction
		 */
		dalCash.update(cashTrans);

		/**
		 * Save Cash Transaction Row
		 *  
		 */

		cashTransRowWithDept.setTurqCashTransaction(cashTrans);
		cashTransRowWithCredit.setTurqCashTransaction(cashTrans);
		
		cashTransRowWithDept.setTurqCurrencyExchangeRate(exchangeRate);
		cashTransRowWithCredit.setTurqCurrencyExchangeRate(exchangeRate);
		

		dalCash.save(cashTransRowWithDept);
     dalCash.save(cashTransRowWithCredit);
	
		/**
		 * Save Accounting Transaction
		 *  
		 */

		Integer transId = blAccTran.saveAccTransaction(transDate,
				document_no, accTransType, cashTrans.getTurqEngineSequence().getTurqModule()
						.getId().intValue(), cashTrans.getTurqEngineSequence()
						.getId(), definition,exchangeRate);

		blAccTran.saveAccTransactionRow(accTransCashWithDept, transId,
				exchangeRate);
		blAccTran.saveAccTransactionRow(accTransCashWithCredit, transId,
				exchangeRate);
    
}

catch(Exception ex){
    
    throw ex;
}



}
    
    
    
    
}
