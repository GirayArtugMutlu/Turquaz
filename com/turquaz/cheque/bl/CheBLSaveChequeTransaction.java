
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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
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
    
    public static void saveChequeRoll(TurqAccountingAccount rollAccount, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType, boolean sumTransTotal)throws Exception {
     
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
                 if(rollType == EngBLCommon.CHEQUE_TRANS_IN){
                     blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.0")+cheque.getChequesPortfolioNo() ); //$NON-NLS-1$
                 }
                 else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT){
                 	 blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.1")+cheque.getChequesPortfolioNo() ); //$NON-NLS-1$
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
            if(rollType == EngBLCommon.CHEQUE_TRANS_IN){
              blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.2")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
            }
            else if(rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT){
            	blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,false,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getId(),Messages.getString("CheBLSaveChequeTransaction.3")+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
            }
            
          }
          
         if(rollType==EngBLCommon.CHEQUE_TRANS_IN)
         {
         	TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
//         	TODO acc trans exRate
         	saveRollAccountingTransactions(rollAccount,curAccount,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate());
         	
         }
         else if(rollType==EngBLCommon.CHEQUE_TRANS_OUT_BANK)
         {
         
         	saveRollAccountingTransactions(rollAccount,null,chequeRoll,totalAmount,EngBLCommon.getBaseCurrencyExchangeRate());
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
          type.setId(new Integer(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK));
          
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
            
            BankBLTransactionAdd.saveChequeTransaction(CheDALSearch.getBankOfCustomerCheque(cheque),seq,cheque.getChequesAmount(),rollDate,Messages.getString("CheBLSaveChequeTransaction.4")+rollNo,rollNo); //$NON-NLS-1$
                   
          }
          
          
    	
    	
    }
    public static void saveChequeCollect(TurqCashCard cashCard, String rollNo,Date rollDate,List chequeList)throws Exception {
    	
    	 
    	  TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setId(new Integer(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT));
          
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
            
          }
          
          List totals =new ArrayList();
          
          totals.add(chequeTotals);
          
          /**
           * TODO accounting entegration da duzeltilecek
           */
          TurqAccountingAccount account = new TurqAccountingAccount();
          
          account.setId(new Integer(-1));
          new CashBLCashTransactionAdd().saveCashTransaction(cashCard,chequeRoll.getTurqEngineSequence(),EngBLCommon.CASH_CHEQUE_COLLECT,rollDate,Messages.getString("CheBLSaveChequeTransaction.5"),rollNo,totals,account); //$NON-NLS-1$
          
    	
    	
    }
    
    
    public  static void saveRollAccountingTransactions(TurqAccountingAccount rollAccount,TurqAccountingAccount counterAccount,TurqChequeRoll roll, BigDecimal amount, TurqCurrencyExchangeRate exchangeRate)
    throws Exception
    {
    	
    	AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
    	
    	int type = roll.getTurqChequeTransactionType().getId().intValue();
    	int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
    	
    	if(rollAccount == null )
    	{
    	
    		return ;
    	
    	}
    	  	
    	
    	if(type==EngBLCommon.CHEQUE_TRANS_IN )
    		
    	{
    		if(counterAccount==null)
    		{
    			return;
    		}
    		TurqAccountingTransactionColumn transRollRow = new TurqAccountingTransactionColumn();
        	TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
        	
        	transRollRow.setTurqAccountingAccount(rollAccount);
        	transCounterRow.setTurqAccountingAccount(counterAccount);
        	
        	
    		transRollRow.setTransactionDefinition("Cek Bordrosu "+roll.getChequeRollNo());
    		transCounterRow.setTransactionDefinition("Cek Bordrosu "+roll.getChequeRollNo());
    	    // transRollRow.set
            transRollRow.setDeptAmount(amount);
            transRollRow.setCreditAmount(new BigDecimal(0));
    		 
    		transCounterRow.setDeptAmount(new BigDecimal(0));
    		transCounterRow.setCreditAmount(amount);    	
    		
    		Integer transId = blAccTran.saveAccTransaction(roll.getChequeRollsDate(),
    				roll.getChequeRollNo(), accTransType, roll.getTurqEngineSequence().getTurqModule()
    						.getId().intValue(), roll.getTurqEngineSequence()
    						.getId(), "Cek Bordrosu "+roll.getChequeRollNo());
    		
//    		TODO acc trans column exRate
    		blAccTran.saveAccTransactionRow(transRollRow,transId,exchangeRate);
    		blAccTran.saveAccTransactionRow(transCounterRow,transId,exchangeRate);
    	
    	}
    	
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_OUT_BANK){
    	{
    		Map accountMap = new Hashtable();
    		
    		CheBLUpdateChequeRoll.initializeChequeRoll(roll);
    		TurqChequeCheque cheque = null;
    		TurqAccountingAccount chequeAccount =null;
    		Iterator it = roll.getTurqChequeChequeInRolls().iterator();
    		while(it.hasNext())
    		{
    			cheque = ((TurqChequeChequeInRoll)it.next()).getTurqChequeCheque();
    			
    			chequeAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque,EngBLCommon.CHEQUE_TRANS_IN);
    			
    			if(chequeAccount == null)
    			{
    				return ;
    			}
    			if(accountMap.containsKey(chequeAccount.getId()))
    			{
    				BigDecimal total = (BigDecimal)accountMap.get(chequeAccount.getId());
    				total = total.add(cheque.getChequesAmount());
    				accountMap.put(chequeAccount.getId(),total);    				
    			}
    			else{
    				
    				accountMap.put(chequeAccount.getId(),cheque.getChequesAmount());
    			
    			}  		
    		
    		}
    		
    		// if we came here than we can save accounting transactons..
    		
    		TurqAccountingTransactionColumn transRollRow = new TurqAccountingTransactionColumn();
    		transRollRow.setTurqAccountingAccount(rollAccount);
    		
    		transRollRow.setDeptAmount(amount);
            transRollRow.setCreditAmount(new BigDecimal(0));
           
            transRollRow.setTransactionDefinition("Cek Bordrosu "+roll.getChequeRollNo());
            
            Integer transId = blAccTran.saveAccTransaction(roll.getChequeRollsDate(),
    				roll.getChequeRollNo(), accTransType, roll.getTurqEngineSequence().getTurqModule()
    						.getId().intValue(), roll.getTurqEngineSequence()
    						.getId(), "Cek Bordrosu "+roll.getChequeRollNo());
        	
            blAccTran.saveAccTransactionRow(transRollRow,transId,exchangeRate);
        
           
            it = accountMap.keySet().iterator();
    		
    		while(it.hasNext())
    		{
    		Integer accountId = (Integer)it.next();
    		TurqAccountingAccount account = new TurqAccountingAccount();
    		account.setId(accountId);
    		
    		TurqAccountingTransactionColumn transCounterRow = new TurqAccountingTransactionColumn();
    		
    		transCounterRow.setTurqAccountingAccount(account);
    		transCounterRow.setTransactionDefinition("Cek Bordrosu "+roll.getChequeRollNo());
     	   	
    		transCounterRow.setDeptAmount(new BigDecimal(0));
    		transCounterRow.setCreditAmount((BigDecimal)accountMap.get(accountId));    
    		 
    		blAccTran.saveAccTransactionRow(transCounterRow,transId,exchangeRate); 	        
    			
    			
    		}	
    	
    	}
    		
    		
    		
    		
    	
    	
    	
    	
    	
    	
    	
    	
    	}
    	
    	
    
    	else if(type == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT){
    		
    		
    		
    		
    	}
    	
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK)
    	{
    		
    	}
    	
    	
    	else if(type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT)
    	{
    	
    		
    	}
    	
    	
    	    	
    }
    
    
    

}
