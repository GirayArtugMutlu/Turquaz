
package com.turquaz.accounting.bl;
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

import java.sql.Date;
import java.util.Calendar;



import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionType;

import com.turquaz.engine.dal.TurqCurrencyExchangeRate;


public class AccBLTransactionUpdate {
	
	private AccDALTransactionUpdate dalTransUpdate = new AccDALTransactionUpdate();
	Calendar cal = Calendar.getInstance();
	public AccBLTransactionUpdate(){
		
	}
	
	//TODO DONE
	public void updateTransaction(TurqAccountingTransaction transaction,String docNo, Object transDate, String definition, TurqCurrencyExchangeRate exchangeRate)
	throws Exception{
	
		Date date = new Date(((java.util.Date)transDate).getTime());
		transaction.setTransactionsDate(date);
		transaction.setTransactionDocumentNo(docNo);
		transaction.setTransactionDescription(definition);
		transaction.setTurqCurrencyExchangeRate(exchangeRate);
		transaction.setUpdatedBy(System.getProperty("user"));
		transaction.setLastModified(new java.sql.Date( cal.getTime().getTime()));
	   	try{
		dalTransUpdate.updateObject(transaction);
		
	   	}
	   	catch(Exception ex){
	   		throw ex;
	   	}
	
	}
	public TurqAccountingTransaction getInitialTransaction()throws Exception{
	    try{
	 
	      return dalTransUpdate.getInitialTransaction();
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	public void updateTransaction(TurqAccountingTransaction transaction,String docNo, java.util.Date transDate,
				int transType, String definition,TurqCurrencyExchangeRate exchangeRate)
	throws Exception{
	
		TurqAccountingTransactionType accTransType = new TurqAccountingTransactionType();
		accTransType.setId(new Integer(transType));
		transaction.setTurqAccountingTransactionType(accTransType);
		transaction.setTransactionsDate(transDate);
		transaction.setTransactionDocumentNo(docNo);
		transaction.setTransactionDescription(definition);
		transaction.setTurqCurrencyExchangeRate(exchangeRate);
		transaction.setUpdatedBy(System.getProperty("user"));
		transaction.setLastModified(new java.sql.Date( cal.getTime().getTime()));
	   	try{
		dalTransUpdate.updateObject(transaction);
		
	   	}
	   	catch(Exception ex){
	   		throw ex;
	   	}
	
	}
	
	
	public void delete(Object obj)throws Exception{
		try{
			
			dalTransUpdate.deleteObject(obj);
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public void initiliazeTransactionRows(TurqAccountingTransaction trans)throws Exception{
	    try{
	        dalTransUpdate.initializeTransactionRows(trans);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	

}
