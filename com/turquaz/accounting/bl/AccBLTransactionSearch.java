/*
 * Created on Oct 19, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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


import java.util.Calendar;
import java.util.List;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.engine.dal.TurqAccountingTransaction;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccBLTransactionSearch {
	
	private AccDALTransactionSearch dalTransSearch = new AccDALTransactionSearch();
	Calendar cal = Calendar.getInstance();
	
	public AccBLTransactionSearch(){
		
	}
	public List searchAccTransaction(String docNo, Object type, Object startDate, Object endDate)throws Exception{
	try{
		
		return dalTransSearch.searchTransaction(docNo,type,startDate,endDate);
				
	}
	catch(Exception ex){
		throw ex;
	}
	
	
	
	}
	
	public List getTransactionTypes()throws Exception{
		try{
			
			return dalTransSearch.getTransactionTypes();
					
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List searchTransactionRows(TurqAccountingTransaction trans, boolean isCredit)throws Exception{
		try{
			
			
			return dalTransSearch.searchTransactionRows(trans,isCredit);
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	public void removeTransactionRows(TurqAccountingTransaction transaction)throws Exception{
		try{

           dalTransSearch.removeTransactionRows(transaction);
			
			
		}
		catch(Exception ex){
			throw ex;
			
		}
		
	}
	
	//-Muhasebele?tirilmemi? fi?leri getirir...
	public List getUnsavedTransactions()throws Exception{
	    try{
	        
	      return dalTransSearch.getUnsavedTransactions();   
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    
	    
	}
	
	

}
