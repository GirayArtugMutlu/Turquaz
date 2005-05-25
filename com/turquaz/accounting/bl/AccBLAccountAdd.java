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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;

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

	public static List getAccountsForAccountPickers() throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAccountsForAccountPickers();
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
			return AccDALAccountAdd.getAllAccounts();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllAccountsForAccountPickerAll() throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAllAccountsForAccountPickerAll();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

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

	public static List getAllAccountsWithSum() throws Exception
	{
		return AccDALAccountAdd.getAllAccountsWithSum();
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

	public static TurqAccountingAccount saveAccount(HashMap argMap) throws Exception
	{
		try
		{
			String accountName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
			String accountCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
			Integer parentId = (Integer) argMap.get(AccKeys.ACC_PARENT_ID);
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
			return account;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}