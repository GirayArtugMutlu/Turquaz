
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


import com.turquaz.accounting.dal.AccDALAccountUpdate;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;


public class AccBLAccountUpdate {
	private AccDALAccountUpdate dalAccountUpdate = new AccDALAccountUpdate();
	Calendar cal = Calendar.getInstance();
     /**
	 * 
	 */
	public AccBLAccountUpdate() {
	}
	public void updateAccount(TurqAccountingAccount account, String accountName, String accountCode, Object parent)throws Exception
	{
		try
		{
			String accCode=account.getAccountCode();
			TurqAccountingAccount parentAccount =(TurqAccountingAccount)parent; 
			account.setAccountName(accountName);
			account.setAccountCode(accountCode);
	
			account.setUpdatedBy(System.getProperty("user"));
			account.setUpdateDate(new java.sql.Date( cal.getTime().getTime()));
	
			account.setTurqAccountingAccountByParentAccount(parentAccount);
			if(parentAccount.getAccountingAccountsId().intValue()==-1)
			{
				account.setTurqAccountingAccountByTopAccount(account);
				
			}
			else {
			account.setTurqAccountingAccountByTopAccount(parentAccount.getTurqAccountingAccountByTopAccount());			
			}
			dalAccountUpdate.updateObject(account);		
			
			dalAccountUpdate.updateAccountCodeOfSubAccs(account,accCode);
			EngBLAccountingAccounts.RefreshContentAsistantMap();
	
		}
		catch(Exception ex)
		{
			throw ex;
		}	
	}
	
	public void updateTopAccount(TurqAccountingAccount toUpdate, TurqAccountingAccount topAccount)
		throws Exception
	{
		try
		{
			System.out.println("updateTOoOp");
			toUpdate.setTurqAccountingAccountByTopAccount(topAccount);
			List subAccounts=dalAccountUpdate.getSubAccounts(toUpdate);
			for (int k=0; k<subAccounts.size(); k++)
			{
				TurqAccountingAccount subAcc=(TurqAccountingAccount)subAccounts.get(k);
				updateTopAccount(subAcc, topAccount);
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	public List getSubAccounts (TurqAccountingAccount parentAcc) throws Exception
	{
		try
		{
			return dalAccountUpdate.getSubAccounts(parentAcc);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public List getAccountTransColumns(TurqAccountingAccount account) throws Exception
	{
		try
		{
			return dalAccountUpdate.getAccountTransColumns(account);
		}
		catch(Exception ex)
		{
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
	
	public List getTotalDeptAndCredit(Object obj)throws Exception{
		
		try{
		return dalAccountUpdate.getTotalDeptAndCredit((TurqAccountingAccount)obj);
			
			
		}
		catch(Exception ex){
		 throw ex;
		}
	}
	
	
	
	
	

}
