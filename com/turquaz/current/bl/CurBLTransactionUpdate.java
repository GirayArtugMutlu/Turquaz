package com.turquaz.current.bl;

import java.util.HashMap;
import java.util.Iterator;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;
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