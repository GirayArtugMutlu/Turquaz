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

import java.util.List;


import com.turquaz.accounting.bl.AccBLAccountAdd;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLAccountingAccounts {
	public List accountList;

	
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
		_instance.fillAccountList();
		 
		return _instance.accountList;
		}
		catch(Exception ex){
			throw ex;
		}

	}
	


}
