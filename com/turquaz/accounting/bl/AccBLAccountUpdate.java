/*
 * Created on Oct 15, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.bl;

import java.util.Calendar;


import com.turquaz.accounting.dal.AccDALAccountUpdate;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccBLAccountUpdate {
	private AccDALAccountUpdate dalAccountUpdate = new AccDALAccountUpdate();
	Calendar cal = Calendar.getInstance();
     /**
	 * 
	 */
	public AccBLAccountUpdate() {
	}
	public void updateAccount(TurqAccountingAccount account, String accountName, String accountCode, int parent)throws Exception{
	try{
		
		TurqAccountingAccount parentAccount = new TurqAccountingAccount();
	
		parentAccount.setAccountingAccountsId(new Integer(parent));
		account.setAccountName(accountName);
		account.setAccountCode(accountCode);
	
		account.setUpdatedBy(System.getProperty("user"));
		account.setUpdateDate(new java.sql.Date( cal.getTime().getTime()));
	
		account.setTurqAccountingAccount(parentAccount);

	
		dalAccountUpdate.updateObject(account);
			
			
			
			
	
	}
	catch(Exception ex){
			throw ex;
	}
		
		
		
	}
	public void deleteAccount(Object obj)throws Exception{
		try{
			
			dalAccountUpdate.deleteObject(obj);
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	
	

}
