/*
 * Created on Sep 28, 2004
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
	
	public List getAccount(int parentid, String codeCrit)throws Exception{
		try{
			
			return dalAccountAdd.getAccounts(parentid,codeCrit);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public List getAllAccounts()throws Exception{
		try{
			
			return dalAccountAdd.getAllAccounts();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public List getAccountsForAccountPickers()throws Exception{
		try{
			
			return dalAccountAdd.getAccountsForAccountPickers();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public void saveAccount(String accountName, String accountCode, Object parent)throws Exception{
		try{
		
		
		TurqAccountingAccount account = new TurqAccountingAccount();
		TurqAccountingAccount parentAccount;
		if(parent!=null){
		parentAccount =(TurqAccountingAccount)parent;
		}
		else{
		parentAccount = new TurqAccountingAccount();
		parentAccount.setAccountingAccountsId(new Integer(-1));
		}
		
		TurqCompany company = new TurqCompany();
		company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
	
		account.setAccountName(accountName);
		account.setAccountCode(accountCode);
		account.setCreatedBy(System.getProperty("user"));
		account.setUpdatedBy(System.getProperty("user"));
		account.setUpdateDate(new java.sql.Date( cal.getTime().getTime()));
		account.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		
		account.setTurqAccountingAccountByParentAccount(parentAccount);
		if(parentAccount.getAccountingAccountsId().intValue()==-1){
		 account.setTurqAccountingAccountByTopAccount(parentAccount); 
		}
		else{
		account.setTurqAccountingAccountByTopAccount(parentAccount.getTurqAccountingAccountByTopAccount());
		}
		account.setTurqCompany(company);
	
		dalAccountAdd.saveOrUpdateAccount(account);
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	
	

}
