/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.bl;


import java.util.Calendar;

import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccBLAccountAdd {
	private AccDALAccountAdd dalAccountAdd;
	Calendar cal = Calendar.getInstance();
	public AccBLAccountAdd(){
	
		dalAccountAdd = new AccDALAccountAdd();
		
	}
	
	public void saveAccount(String accountName, String accountCode, int parent)throws Exception{
		try{
		
		TurqAccountingAccount account = new TurqAccountingAccount();
		TurqAccountingAccount parentAccount = new TurqAccountingAccount();
		TurqCompany company = new TurqCompany();
		company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
		parentAccount.setAccountingAccountsId(new Integer(parent));
		account.setAccountName(accountName);
		account.setAccountCode(accountCode);
		account.setCreatedBy(System.getProperty("user"));
		account.setUpdatedBy(System.getProperty("user"));
		account.setUpdateDate(new java.sql.Date( cal.getTime().getTime()));
		account.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		account.setTurqAccountingAccount(parentAccount);
		account.setTurqCompany(company);
	
		dalAccountAdd.saveOrUpdateAccount(account);
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	
	

}
