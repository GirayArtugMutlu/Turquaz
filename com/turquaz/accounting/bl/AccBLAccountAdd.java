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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.exceptions.TurquazException;
import com.turquaz.engine.lang.AccLangKeys;

public class AccBLAccountAdd
{
	public static List getAccount(HashMap argMap) throws Exception
	{
		try
		{
			Integer parentid = (Integer) argMap.get(AccKeys.ACC_PARENT_ID);
			String codeCrit = (String) argMap.get(AccKeys.ACC_CODE_CRITERIA);
			return AccDALAccountAdd.getAccounts(parentid.intValue(), codeCrit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getLeafAccounts() throws Exception
	{
		try
		{
			List accounts=AccDALAccountAdd.getLeafAccounts();
			List accountMaps=new ArrayList();
			for(int k=0; k<accounts.size(); k++)
			{
				HashMap accountMap=new HashMap();
				Object[] accountInfo=(Object[])accounts.get(k);
				accountMap.put(AccKeys.ACC_ACCOUNT_ID,accountInfo[0]);
				accountMap.put(AccKeys.ACC_ACCOUNT_NAME,accountInfo[1]);
				accountMap.put(AccKeys.ACC_ACCOUNT_CODE,accountInfo[2]);
				accountMap.put(AccKeys.ACC_PARENT_ID,accountInfo[3]);
				accountMaps.add(accountMap);
			}
			return accountMaps;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllAccounts() throws Exception
	{
		try
		{
			List accounts=AccDALAccountAdd.getAllAccounts();
			List accountMaps=new ArrayList();
			for(int k=0; k<accounts.size(); k++)
			{
				HashMap accountMap=new HashMap();
				Object[] accountInfo=(Object[])accounts.get(k);
				accountMap.put(AccKeys.ACC_ACCOUNT_ID,accountInfo[0]);
				accountMap.put(AccKeys.ACC_ACCOUNT_NAME,accountInfo[1]);
				accountMap.put(AccKeys.ACC_ACCOUNT_CODE,accountInfo[2]);
				accountMap.put(AccKeys.ACC_PARENT_ID,accountInfo[3]);
				accountMaps.add(accountMap);
			}
			return accountMaps;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllAccountsExceptRoot() throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAllAccountsExceptRoot();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//probably no need anymore
	public static TurqAccountingAccount getAllAccountsWithCodeCrit(HashMap argMap) throws Exception
	{
		try
		{
			String codeCrit = (String) argMap.get(AccKeys.ACC_CODE_CRITERIA);
			return AccDALAccountAdd.getAllAccounts(codeCrit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getAllAccountsWithSum() throws Exception
	{
		List list= AccDALAccountAdd.getAllAccountsWithSum();
		String[] columnNames=new String[]{
				AccKeys.ACC_ACCOUNT_ID,
				AccKeys.ACC_ACCOUNT_NAME,
				AccKeys.ACC_ACCOUNT_CODE,
				AccKeys.ACC_PARENT_ID,
				AccKeys.ACC_TOTAL_CREDIT_AMOUNT,
				AccKeys.ACC_TOTAL_DEPT_AMOUNT};
		HashBag accountBag=new HashBag();
		accountBag.put(AccKeys.ACC_ACCOUNTS,list,columnNames);
		return accountBag;
	}

	public static List getCashAccounts() throws Exception
	{
		try
		{
			return AccDALAccountAdd.getCashAccounts();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getLeafAccount(HashMap argMap) throws Exception
	{
		try
		{
			String codeCrit = (String) argMap.get(AccKeys.ACC_CODE_CRITERIA);
			return AccDALAccountAdd.getLeafAccount(codeCrit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactionColumns(HashMap argMap) throws Exception
	{
		Integer type = (Integer) argMap.get(AccKeys.ACC_TYPE);
		Date startDate =(Date) argMap.get(AccKeys.ACC_START_DATE);
		Date endDate = (Date)argMap.get(AccKeys.ACC_END_DATE);
		return AccDALAccountAdd.getTransactionColumns(type.intValue(), startDate, endDate);
	}

	public static Integer saveAccount(HashMap argMap) throws Exception
	{
		try
		{
			String accountName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
			String accountCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
			Integer parentId = (Integer) argMap.get(AccKeys.ACC_PARENT_ID);

			verifyAccountForSave(accountCode,parentId);
			
			TurqAccountingAccount account = new TurqAccountingAccount();
			TurqAccountingAccount parentAccount = new TurqAccountingAccount();
			if (parentId != null)
			{
				parentAccount.setId(parentId);
			}
			else
			{
				
				parentAccount.setId(new Integer(-1));
			}
			EngDALSessionFactory.getSession().refresh(parentAccount);
			account.setAccountName(accountName);
			account.setAccountCode(accountCode);
			account.setCreatedBy(System.getProperty("user"));
			account.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			account.setUpdateDate(cal.getTime());
			account.setCreationDate(cal.getTime());
			account.setTurqAccountingAccountByParentAccount(parentAccount);
			if (parentAccount.getId().intValue() == -1)
			{
				account.setTurqAccountingAccountByTopAccount(parentAccount);
				EngDALCommon.saveObject(account);
				account.setTurqAccountingAccountByTopAccount(account);
				EngDALCommon.updateObject(account);
			}
			else
			{
				account.setTurqAccountingAccountByTopAccount(parentAccount
						.getTurqAccountingAccountByTopAccount());
				EngDALCommon.saveObject(account);
			}
			EngBLAccountingAccounts.RefreshContentAsistantMap();
			return account.getId();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	private static void verifyAccountForSave(String accountCode,Integer parentId) throws Exception
	{
		Integer accountId=AccBLAccountSearch.getAccountIdByAccountCode(accountCode);
		if (accountId != null)
		{
			throw new TurquazException(AccLangKeys.MSG_NOT_ENTER_EXISTING_ACCOUNT_CODE);
		}
		List accTrans = AccBLAccountUpdate.getAccountTransColumns(parentId);
		if (accTrans.size() > 0)
		{
			throw new TurquazException(AccLangKeys.MSG_NOT_ENTER_SUBSIDIARY_ACCOUNT_PARENT_HAS_TRANSACTION); 
		}
	}
}