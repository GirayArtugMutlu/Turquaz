/*
 * Created on Oct 15, 2004
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
