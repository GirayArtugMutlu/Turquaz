/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

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

import java.util.HashMap;
import java.util.List;


import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLAccountingAccounts {
	public List accountList;
	public HashMap accountMap = new HashMap();

	
	static EngBLAccountingAccounts _instance;
	
	private AccBLAccountAdd blAccount = new AccBLAccountAdd();
	
	public EngBLAccountingAccounts()throws Exception{
		try{
		fillAccountList();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void fillAccountList()throws Exception{
		try{
		 accountList = blAccount.getAllAccounts();
		 accountMap.clear();
		 
		 TurqAccountingAccount account;
		 for(int i=0;i<accountList.size();i++){
		  account = (TurqAccountingAccount)accountList.get(i);
		  accountMap.put(account.getAccountCode(),account);   
		     
		 }
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static synchronized List getAccounts() throws Exception{
		try{
		if (_instance == null) {
              
			_instance = new EngBLAccountingAccounts();

		}
		
        //Not really static 
		
		 
		return _instance.accountList;
		}
		catch(Exception ex){
			throw ex;
		}

	}
	public static TurqAccountingAccount getAccount(String accountCode)throws Exception{
	    try{
	        if (_instance == null) {
	              
				_instance = new EngBLAccountingAccounts();

			}
			
			 
			return (TurqAccountingAccount)_instance.accountMap.get(accountCode);
			}
			catch(Exception ex){
				throw ex;
			}
	}
	
	public static void RefreshContentAsistantMap()throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
				return;
			}
			_instance.fillAccountList();
		}
		
		catch(Exception ex)
		{
			throw ex;
		}	
		
	}
	
	


}
