/*
 * Created on Oct 19, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.accounting.dal.AccDALTransactionAdd;
import com.turquaz.accounting.dal.AccDALTransactionSearch;

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
	
	
	

}
