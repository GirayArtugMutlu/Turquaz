/*
 * Created on Oct 19, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.bl;

import java.sql.Date;
import java.util.Calendar;


import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.engine.dal.TurqAccountingTransaction;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccBLTransactionUpdate {
	
	private AccDALTransactionUpdate dalTransUpdate = new AccDALTransactionUpdate();
	Calendar cal = Calendar.getInstance();
	public AccBLTransactionUpdate(){
		
	}
	
	public void updateTransaction(TurqAccountingTransaction transaction,String docNo, Object transDate)
	throws Exception{
	
		Date date = new Date(((java.util.Date)transDate).getTime());
		transaction.setTransactionsDate(date);
		transaction.setTransactionDocumentNo(docNo);
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

}