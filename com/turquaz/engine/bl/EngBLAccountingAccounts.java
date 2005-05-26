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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

public class EngBLAccountingAccounts
{
	public List accountList; //all accounts including -1
	public List leafAccounts; //only leaf accounts
	public List normalAccounts; //all accounts except -1
	public List cashAccountList;
	
	
	public HashMap accountMap = new HashMap();
	public HashMap leafAccountMap=new HashMap();
	
	static EngBLAccountingAccounts _instance;

	public EngBLAccountingAccounts() throws Exception
	{
		try
		{
			fillAccountList();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillAccountList() throws Exception
	{
		try
		{
			
			accountList = AccBLAccountAdd.getAllAccounts();
			leafAccounts =AccBLAccountAdd.getLeafAccounts();
			normalAccounts = AccBLAccountAdd.getAllAccountsExceptRoot();
			
			cashAccountList =AccBLAccountAdd.getCashAccounts();
			accountMap.clear();
			
			for (int i = 0; i < accountList.size(); i++)
			{
				HashMap accountInfo = (HashMap) accountList.get(i);
				accountMap.put(accountInfo.get(AccKeys.ACC_ACCOUNT_CODE), accountInfo);
			}
			for(int k=0; k<leafAccounts.size(); k++)
			{
				HashMap accountInfo = (HashMap)leafAccounts.get(k);
				leafAccountMap.put(accountInfo.get(AccKeys.ACC_ACCOUNT_CODE), accountInfo);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public static List getAccounts() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return _instance.accountList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getNormalAccounts() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return _instance.normalAccounts;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public static List getLeafAccounts() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return _instance.leafAccounts;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCashAccounts() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return _instance.cashAccountList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getAccount(String accountCode) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return (HashMap) _instance.accountMap.get(accountCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static HashMap getLeafAccount(String accountCode) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
			}
			return (HashMap) _instance.leafAccountMap.get(accountCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void RefreshContentAsistantMap() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLAccountingAccounts();
				return;
			}
			_instance.fillAccountList();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_ACCOUNTING);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}