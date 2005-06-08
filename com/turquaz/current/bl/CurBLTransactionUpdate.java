package com.turquaz.current.bl;

import java.util.HashMap;
import java.util.Iterator;

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrentTransaction;

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
 * @author Onsel Armagan
 * @version $Id$
 */
public class CurBLTransactionUpdate
{


	public static void deleteCurTrans(HashMap argMap) throws Exception
	{
		
		
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
		
		Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		while (it.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
			AccDALTransactionSearch.deleteTransaction(accTrans);
		}
		EngDALCommon.deleteObject(curTrans);
		
	}
	public static void deleteTransfer(HashMap argMap)throws Exception
	 {
		
	  Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
	  
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		
	  
	  Iterator it = curTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
	  while(it.hasNext())
	  {
	   EngDALCommon.deleteObject(it.next());
	  }	  
	  
	 }
	
	
	public static HashBag getVoucherInfo(HashMap argMap)throws Exception
	{
	
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
		HashBag transBag = new HashBag();
		transBag.put(EngKeys.DEFINITION,curTrans.getTransactionsDefinition());
		transBag.put(EngKeys.DOCUMENT_NO,curTrans.getTransactionsDocumentNo());
		transBag.put(EngKeys.DATE,curTrans.getTransactionsDate());
		
		transBag.put(CurKeys.CUR_CURRENT_CODE,curTrans.getTurqCurrentCard().getCardsCurrentCode());
		transBag.put(CurKeys.CUR_CURRENT_NAME,curTrans.getTurqCurrentCard().getCardsName());
		transBag.put(AdmKeys.ADM_CURRENCY_ABBR,curTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		transBag.put(EngKeys.CREDIT_AMOUNT,curTrans.getTotalCreditInForeignCurrency());
		transBag.put(EngKeys.DEPT_AMOUNT,curTrans.getTotalDeptInForeignCurrency());
		
		
		Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		if (it.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
			
			Iterator accIt = accTrans.getTurqAccountingTransactionColumns().iterator();
			while (accIt.hasNext())
			{

				
				Object curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curTrans.getTurqCurrentCard(),EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			    
				TurqAccountingTransactionColumn accRow = (TurqAccountingTransactionColumn) accIt.next();
				
				if (!accRow.getTurqAccountingAccount().equals(curAccount))
				{
					transBag.put(AccKeys.ACC_ACCOUNT_CODE,accRow.getTurqAccountingAccount().getAccountCode());
				}
			}
		}
		return transBag;
		
		
		
		
	}
	public static HashBag getMultipleVoucherInfo(HashMap argMap)throws Exception
	{
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
	    HashBag transBag = new HashBag();
		
		transBag.put(CurKeys.CUR_CURRENT_CODE,curTrans.getTurqCurrentCard().getCardsCurrentCode());
		transBag.put(CurKeys.CUR_CURRENT_NAME,curTrans.getTurqCurrentCard().getCardsName());
		transBag.put(EngKeys.DOCUMENT_NO,curTrans.getTransactionsDocumentNo());
		transBag.put(EngKeys.DEFINITION,curTrans.getTransactionsDefinition());
		transBag.put(EngKeys.DATE,curTrans.getTransactionsDate());		
		
		transBag.put(AccKeys.ACC_TRANSACTION_ROWS,new HashMap());
		
		Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
        if (it.hasNext())
        {         
            TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
          
            Iterator accIt = accTrans.getTurqAccountingTransactionColumns().iterator();
			int i=0;
			while (accIt.hasNext())
            {
                TurqAccountingTransactionColumn transRow = (TurqAccountingTransactionColumn)accIt.next();
                if((curTrans.getTurqCurrentTransactionType().getId().intValue()==EngBLCommon.CURRENT_TRANS_MULTIPLE_CREDIT)&&transRow.getDeptAmount().doubleValue()>0)
                {
                  
					HashMap accountMap = new HashMap();
					accountMap.put(AccKeys.ACC_ACCOUNT_CODE,transRow.getTurqAccountingAccount().getAccountCode());
					accountMap.put(AccKeys.ACC_ACCOUNT_NAME,transRow.getTurqAccountingAccount().getAccountName());
					accountMap.put(AccKeys.ACC_ACCOUNT_ID,transRow.getTurqAccountingAccount().getId());
					
					
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,AccKeys.ACC_ACCOUNT);
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,AccKeys.ACC_TRANS_ROW_DEFINITION,transRow.getTransactionDefinition());
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,EngKeys.DEPT_AMOUNT,transRow.getDeptAmount());
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,EngKeys.CREDIT_AMOUNT,transRow.getCreditAmount());
					
					
					i++;              
                    
                }  
                else if((curTrans.getTurqCurrentTransactionType().getId().intValue()==EngBLCommon.CURRENT_TRANS_MULTIPLE_DEPT)&&transRow.getCreditAmount().doubleValue()>0)
				{
					HashMap accountMap = new HashMap();
					accountMap.put(AccKeys.ACC_ACCOUNT_CODE,transRow.getTurqAccountingAccount().getAccountCode());
					accountMap.put(AccKeys.ACC_ACCOUNT_NAME,transRow.getTurqAccountingAccount().getAccountName());
					accountMap.put(AccKeys.ACC_ACCOUNT_ID,transRow.getTurqAccountingAccount().getId());
					
					
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,AccKeys.ACC_ACCOUNT,accountMap);
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,AccKeys.ACC_TRANS_ROW_DEFINITION,transRow.getTransactionDefinition());
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,EngKeys.DEPT_AMOUNT,transRow.getDeptAmount());
					transBag.put(AccKeys.ACC_TRANSACTION_ROWS,i,EngKeys.CREDIT_AMOUNT,transRow.getCreditAmount());
					
					
					i++;
				}
                
            }
            
            
        }
		
		return transBag;
		
		
		
	}

	public static HashBag getTransferBetweenAccountsInfo(HashMap argMap)throws Exception
	{
		Integer curTransId = (Integer)argMap.get(CurKeys.CUR_TRANSACTION_ID);
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)EngDALSessionFactory.getSession().load(TurqCurrentTransaction.class,curTransId);
	    HashBag transBag = new HashBag();
		transBag.put(EngKeys.DEFINITION,curTrans.getTransactionsDefinition());
		transBag.put(EngKeys.DOCUMENT_NO,curTrans.getTransactionsDocumentNo());
		transBag.put(EngKeys.DATE,curTrans.getTransactionsDate());
		Iterator it = curTrans.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
		 while(it.hasNext())
		 {
		 	TurqCurrentTransaction currentTrans = (TurqCurrentTransaction)it.next();
		 	
        
           if( currentTrans.getTransactionsTotalCredit().doubleValue()>0)
           {           	
            transBag.put(CurKeys.CUR_CARD_CREDIT,currentTrans.getTurqCurrentCard().getCardsName()+" {"+currentTrans.getTurqCurrentCard().getCardsCurrentCode()+"}");
           	transBag.put(EngKeys.TOTAL_AMOUNT,currentTrans.getTransactionsTotalCredit());
           }
           else
           {
			   transBag.put(CurKeys.CUR_CARD_DEPT,currentTrans.getTurqCurrentCard().getCardsName()+" {"+currentTrans.getTurqCurrentCard().getCardsCurrentCode()+"}");
	           transBag.put(EngKeys.TOTAL_AMOUNT,currentTrans.getTransactionsTotalDept());
	          
           } 	
		 }	 
	
		return transBag;
		
		
		
		
		
		
	}
	
}