/*
 * Created on Oct 18, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.bl;

import java.util.Calendar;
import java.util.Date;

import com.turquaz.accounting.dal.AccDALTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingJournal;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqAccountingTransactionType;

import com.turquaz.engine.dal.TurqModule;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccBLTransactionAdd {
	private AccDALTransactionAdd dalTransAdd = new AccDALTransactionAdd();
	Calendar cal = Calendar.getInstance();
	
	public AccBLTransactionAdd(){
		
	}
	
	
	//Muhasebe fisi kalemlerini kaydet
	public void saveAccTransactionRow(TurqAccountingTransactionColumn transRow, Integer transID)
	throws Exception{
	try
	{
		TurqAccountingTransaction trans = new TurqAccountingTransaction();
		trans.setAccountingTransactionsId(transID);
		
		transRow.setTurqAccountingTransaction(trans);
		
		transRow.setCreatedBy(System.getProperty("user"));
		transRow.setUpdatedBy(System.getProperty("user"));
		
		transRow.setLastModified(new java.sql.Date( cal.getTime().getTime()));
		transRow.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		
		dalTransAdd.save(transRow);
	}
	catch(Exception ex){
		throw ex;
	}
	}
	
	public Integer saveAccTransaction(Date date, String documentNo,int type,int moduleId) throws Exception
	{
		try{
		
		TurqAccountingTransaction trans = new TurqAccountingTransaction();
		trans.setTransactionDocumentNo(documentNo);
		trans.setTransactionsDate(new java.sql.Date(date.getTime()));
		
		
		//Hangi modulde kaydedildigi
		TurqModule module = new TurqModule();
		module.setModulesId(new Integer(moduleId));
		trans.setTurqModule(module);
		
		//Muhasebelestirilmemis.. o zaman yevmiye kaydi -1
		TurqAccountingJournal journal = new TurqAccountingJournal();
		journal.setAccountingJournalId(new Integer(-1))	;
		trans.setTurqAccountingJournal(journal);
		
		//Fis tip
		TurqAccountingTransactionType transType =new TurqAccountingTransactionType();
		transType.setAccountingTransactionTypesId(new Integer(type));	
		trans.setTurqAccountingTransactionType(transType);
		
		trans.setCreatedBy(System.getProperty("user"));
		trans.setUpdatedBy(System.getProperty("user"));
		
		trans.setLastModified(new java.sql.Date( cal.getTime().getTime()));
		trans.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		
		dalTransAdd.save(trans);
			
		
			
		return trans.getAccountingTransactionsId();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	
	
	}
	

}
