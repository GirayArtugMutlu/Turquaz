/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
import java.util.Date;
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;

import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.current.dal.CurDALTransactionUpdate;
import com.turquaz.engine.dal.TurqAccountingAccount;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLSearchTransaction {
	private CurDALSearchTransaction dalSearch = new CurDALSearchTransaction();
	private AccBLTransactionUpdate accDalUpdate = new AccBLTransactionUpdate();
	CurDALTransactionUpdate dalUpdate = new CurDALTransactionUpdate();
	AccBLTransactionSearch blAccSearch = new AccBLTransactionSearch();
	CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	Calendar cal = Calendar.getInstance();
	public CurBLSearchTransaction(){
		
	}
	public List searchCurrentTransaction(Object curCard,
										Object type, String docNo, Date startDate,
										Date endDate)throws Exception {
		try{
		
		return 	dalSearch.searchTransaction((TurqCurrentCard)curCard,
											(TurqCurrentTransactionType)type,
											docNo,startDate, endDate);
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public void updateCurrentTransaction(TurqCurrentCard curCard,Date transDate,
			String documentNo,boolean isCredit,BigDecimal amount,
			TurqAccountingAccount account,TurqCurrentTransaction curTrans)throws Exception{
	try{
		
		curTrans.setTurqCurrentCard(curCard);
		curTrans.setTransactionsDate(transDate);
		curTrans.setTransactionsDocumentNo(documentNo);
		curTrans.setUpdatedBy(System.getProperty("user"));
 		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		
 		
		int accTransType;
		
		if(isCredit){
		
		accTransType =1;
		curTrans.setTransactionsTotalCredit(amount);	
		curTrans.setTransactionsTotalDept(new BigDecimal(0));
		
		}
		else{
		
		accTransType =0;	
		curTrans.setTransactionsTotalCredit(new BigDecimal(0));
		curTrans.setTransactionsTotalDept(amount);
		
		}

 		dalUpdate.updateObject(curTrans);
 		
    	accDalUpdate.updateTransaction(curTrans.getTurqAccountingTransaction(),documentNo,transDate,accTransType);		
		
//    	Remove transaction rows
		blAccSearch.removeTransactionRows(curTrans.getTurqAccountingTransaction());

//		Save new Transaction Rows		
		blTransAdd.saveAccountingCashTransactionRows(curCard,isCredit,amount,account,
				curTrans.getTurqAccountingTransaction().getAccountingTransactionsId());
				
			
	}
	catch(Exception ex){
		throw ex;
	}

	}
	public void deleteCurrentTransaction(TurqCurrentTransaction curTrans)throws Exception{
		try{
			
			//remove accounting transaction rows
			blAccSearch.removeTransactionRows(curTrans.getTurqAccountingTransaction());
			//remove accounting transaction
			dalUpdate.deleteObject(curTrans);
			
			dalUpdate.deleteObject(curTrans.getTurqAccountingTransaction());
			
			//remove currren transaction
			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	

}
