
package com.turquaz.current.bl;
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
* @author  Onsel Armagan
* @version  $Id$
*/
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.turquaz.accounting.bl.AccBLTransactionAdd;

import com.turquaz.current.dal.CurDALCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.ui.component.DatePicker;

public class CurBLCurrentTransactionAdd {

	private CurDALCurrentTransactionAdd dalCurrentTrans=new CurDALCurrentTransactionAdd();	
	private Calendar cal=Calendar.getInstance();
	public CurBLCurrentTransactionAdd(){
		
	}
	
	
	public TurqCurrentTransaction saveCurrentTransaction(TurqCurrentCard curCard,java.util.Date transDate, String documentNo,
			boolean isCredit,BigDecimal amount, BigDecimal totalDiscount, int type,Integer seqDocNo,String definition)throws Exception{
	  
	    try{
			
	    	TurqCurrency currency = EngBLCommon.getBaseCurrency();
	    	
			TurqEngineSequence docSeq =new TurqEngineSequence();;	
			
			if(seqDocNo==null){
				TurqModule module = new TurqModule();
				module.setModulesId(new Integer(4));
				docSeq.setTurqModule(module);
				dalCurrentTrans.saveObject(docSeq);
				
			}
			else
			{
				docSeq.setEngineSequencesId(seqDocNo);
			}
			
			TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
			curTrans.setTurqCurrentCard(curCard);
			curTrans.setTransactionsDate(transDate);
			curTrans.setTransactionsDocumentNo(documentNo);
			curTrans.setTransactionsTotalDiscount(totalDiscount);
			curTrans.setTotalDiscountInForeignCurrency(totalDiscount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			curTrans.setTransactionsDefinition(definition.toUpperCase(Locale.getDefault()));
			curTrans.setTurqEngineSequence(docSeq);
		
			
		
			if(isCredit){
			
			curTrans.setTransactionsTotalCredit(amount);
			curTrans.setTotalCreditInForeignCurrency(amount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			
			curTrans.setTransactionsTotalDept(new BigDecimal(0));			
            curTrans.setTotalDeptInForeignCurrency(new BigDecimal(0));
			
			
			}		
			else{
				curTrans.setTransactionsTotalCredit(new BigDecimal(0));
			    curTrans.setTotalCreditInForeignCurrency(new BigDecimal(0));
				
				curTrans.setTotalDeptInForeignCurrency(amount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));				
				curTrans.setTransactionsTotalDept(amount);	
				
			}
			
		
	        curTrans.setTurqCurrency(currency);
			
	        TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
	        
	        transType.setCurrentTransactionTypesId(new Integer(type));
	     
	        
	        curTrans.setTurqCurrentTransactionType(transType);	
	        
	        curTrans.setCreatedBy(System.getProperty("user"));
	 		curTrans.setUpdatedBy(System.getProperty("user"));
	 		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	 		curTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
	        dalCurrentTrans.saveObject(curTrans);
			return curTrans;
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public TurqCurrentTransaction saveOtherCurrentTransaction(TurqCurrentCard curCard,TurqAccountingAccount account,java.util.Date transDate, String documentNo,
			boolean isCredit,BigDecimal amount, BigDecimal totalDiscount,int type,Integer seqDocNo,String definition)throws Exception{
		try{
	
			TurqCurrentTransaction curTrans=saveCurrentTransaction(curCard,transDate,documentNo,isCredit,amount,totalDiscount,type,seqDocNo,definition);
			if(account==null)
			{
				return curTrans;
			}			
			else{
				  AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
				  //muhasebe fisi kalemlerini de ekleyelim.. 
			         // add accounting bill rows
				  String transDefinition="Cari Borc/Alacak "+DatePicker.formatter.format(transDate) +" " + documentNo;
			         Integer transId = blAcc.saveAccTransaction(transDate,documentNo,
			         		EngBLCommon.ACCOUNTING_TRANS_GENERAL,EngBLCommon.MODULE_CURRENT,curTrans.getTurqEngineSequence().getEngineSequencesId(),transDefinition);
			         
			         saveAccountingCashTransactionRows(curCard,isCredit,amount,account,transId,definition);           
			         
				return curTrans;
			}
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	/**
	 * 
	 * @param curCard
	 * @param transDate
	 * @param documentNo
	 * @param isCredit  Kasa Hareketi Tipini belirler
	 * @param amount 
	 * @param totalDiscount
	 * @param type    Hareketin tipi (nakit, fatura v.s.)
	 * @param account  Kasa muhasebe hesabi 
	 * @throws Exception
	 */
	
	public void saveCurrentCashTransaction(TurqCurrentCard curCard,java.util.Date transDate, String documentNo,
									boolean isCredit,BigDecimal amount, BigDecimal totalDiscount,
									int type, TurqAccountingAccount account) throws Exception{
		try{
			
		//Accounting Integration 
        //Eger bir Nakit hareketi ise Muhasebe kaydini yap
		//Daha sonra cari hareketi ekle
		//Nakit hareketi degilse hic birsey yapma.
			
			TurqCurrency currency = EngBLCommon.getBaseCurrency();
        if(type == 4){
          
          int accTransactionType = 1; //0-Tahsil, 1-Tediye, 2-Mahsup
          // 0 = collect
          // 1 = payment
          // 2 = general transaction
    	  //Cari Karta para verildiginde
		  //Kasaya alacak hareketi (Tediye fisi) 
	
    		if(isCredit){
    			
    			accTransactionType = 1;	    			
    			
    	   			
    		}
    	   //Cari Karttan para tahsil edildiginde
  		   //Kasaya borc hareketi(Tahsil fisi) 
    		else 
    		{
    			accTransactionType = 0;
    		}
        
        
         AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
        
         //4-Cari modulu id si.. 
         // current module id
         TurqEngineSequence seq= new TurqEngineSequence();
         TurqModule module = new TurqModule();
         module.setModulesId(new Integer(4));
         seq.setTurqModule(module);
         
         dalCurrentTrans.saveObject(seq);
         String transDefinition="Cari "+DatePicker.formatter.format(transDate) +" " + documentNo;
         Integer transId = blAcc.saveAccTransaction(transDate,documentNo,
         		accTransactionType,4,seq.getEngineSequencesId(),transDefinition);
         
         //muhasebe fisi kalemlerini de ekleyelim.. 
         // add accounting bill rows
         saveAccountingCashTransactionRows(curCard,isCredit,amount,account,transId,transDefinition);           
         
         
        //Simdi Cari Hareketi Kaydedebiliriz. 
         // insert current transactions
       	TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
 		
 		curTrans.setTransactionsDate(transDate);
 		curTrans.setTransactionsDocumentNo(documentNo);
 		curTrans.setTurqCurrentCard(curCard);
 	    curTrans.setTurqEngineSequence(seq);
 	    curTrans.setTurqCurrency(currency);
		
 		TurqAccountingTransaction accTrans = new TurqAccountingTransaction();
 		accTrans.setAccountingTransactionsId(transId);
 		
 		 		
		
 		if(isCredit){		
 			curTrans.setTransactionsTotalCredit(amount);
			curTrans.setTotalCreditInForeignCurrency(amount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
			
			curTrans.setTransactionsTotalDept(new BigDecimal(0));			
            curTrans.setTotalDeptInForeignCurrency(new BigDecimal(0));
 			
 		}
 		else 
 		{
 			curTrans.setTransactionsTotalCredit(new BigDecimal(0));
		    curTrans.setTotalCreditInForeignCurrency(new BigDecimal(0));
			
			curTrans.setTotalDeptInForeignCurrency(amount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));				
			curTrans.setTransactionsTotalDept(amount);	
 		
 		}
 		
 		
         
        TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
        transType.setCurrentTransactionTypesId(new Integer(type));
 		
 		curTrans.setTransactionsTotalDiscount(totalDiscount);
		curTrans.setTotalDiscountInForeignCurrency(totalDiscount.multiply(currency.getExchangeRate()).setScale(2,BigDecimal.ROUND_HALF_DOWN));
 		curTrans.setTurqCurrency(currency);
 		curTrans.setTurqCurrentTransactionType(transType);		
 		
 		curTrans.setCreatedBy(System.getProperty("user"));
 		curTrans.setUpdatedBy(System.getProperty("user"));
 		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
 		curTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
         
 		
 		
 		
 		
 		dalCurrentTrans.saveObject(curTrans);
                 
        }
             
        
        
		}
		catch(Exception ex){
			throw ex;
		}
	}
	/**
	 * Nakit Muhasebe fisi kalemlerini kaydet
	 * 
	 * @param curCard
	 * @param transDate
	 * @param isCredit
	 * @param amount
	 * @param account "cari karttaki muhasebe hesabina karsilik gelecek muhasebe kodu" 
	 * @param AccTransId Accounting transaction id
	 */
	public void saveAccountingCashTransactionRows(TurqCurrentCard curCard, 
			boolean isCredit,BigDecimal amount,TurqAccountingAccount account,
			Integer AccTransId, String definition) throws Exception{
	  try{
			   
        	
          TurqAccountingTransactionColumn transRowCash = new TurqAccountingTransactionColumn();
          TurqAccountingTransactionColumn transRowCurrent = new TurqAccountingTransactionColumn();

          //Kasa muhasebe kodunu girelim
          transRowCash.setTurqAccountingAccount(account);
    	
          //Cari Karta para verildiginde
		  //Kasaya alacak hareketi 
		  //Cari kartin satici muhasebe hesabina borc hareketi 
    		if(isCredit){
    		   			
    			transRowCash.setCreditAmount(amount);
    			transRowCash.setDeptAmount(new BigDecimal(0));
    			transRowCurrent.setCreditAmount(new BigDecimal(0));
    			transRowCurrent.setDeptAmount(amount);
    			
    			//cari sat?c? muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));
    	   			
    		}
    	   //Cari Karttan para tahsil edildiginde
  		   //Kasaya borc hareketi 
  		   //Cari kartin alici muhasebe hesabina alacak hareketi 
    		else 
    		{
    			transRowCash.setCreditAmount(new BigDecimal(0));
    			transRowCash.setDeptAmount(amount);
    			transRowCurrent.setCreditAmount(amount);
    			transRowCurrent.setDeptAmount(new BigDecimal(0));
    			
    			
    			//cari alici muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL));
    			
    		
    		}
        
        
         AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
           
         
         //fis kalemlerini de ekleyelim.. 
         transRowCash.setTransactionDefinition(definition);
         transRowCurrent.setTransactionDefinition(definition);
         blAcc.saveAccTransactionRow(transRowCash,AccTransId,EngBLCommon.getBaseCurrency(),new BigDecimal(1));
         blAcc.saveAccTransactionRow(transRowCurrent,AccTransId,EngBLCommon.getBaseCurrency(),new BigDecimal(1));
       
		}
		
	    catch(Exception ex){
			throw ex;
		}
		
	}

	
	
	/**
	 * 
	 * @return butun cari kartlar listesi
	 * @throws Exception
	 */
	public List getCurrentCards() throws Exception {
		try{
			
			return dalCurrentTrans.getCurrentCards();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getCurrentTransactionTypes() throws Exception {
		try{
			
			return dalCurrentTrans.getTransactionTypes();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	
	
	
	
}
