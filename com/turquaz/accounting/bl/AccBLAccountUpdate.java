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
import java.util.HashMap;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALAccountUpdate;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.exceptions.TurquazException;
import com.turquaz.engine.lang.AccLangKeys;

public class AccBLAccountUpdate
{
	public static void updateAccount(HashMap argMap) throws Exception
	{
		try
		{
			
			Integer accId = (Integer) argMap.get(AccKeys.ACC_ACCOUNT_ID);
			String accountName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
			String accountCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
			Integer parentId = (Integer) argMap.get(AccKeys.ACC_PARENT_ID);
			
			verifyAccountForUpdate(accId,accountCode);
			
			TurqAccountingAccount account = (TurqAccountingAccount) EngDALSessionFactory.getSession().load(
					TurqAccountingAccount.class, accId);
			TurqAccountingAccount parentAccount = (TurqAccountingAccount) EngDALSessionFactory.getSession()
					.load(TurqAccountingAccount.class, parentId);
			boolean isSub = isSubAccountOf(account, parentAccount);
			if (isSub)
			{
				throw new TurquazException(TurquazException.EX_ACC_SUB_ACC);
			}
			String accCode = account.getAccountCode();
			account.setAccountName(accountName);
			account.setAccountCode(accountCode);
			account.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			account.setUpdateDate(cal.getTime());
			account.setTurqAccountingAccountByParentAccount(parentAccount);
			if (parentAccount.getId().intValue() == -1)
			{
				account.setTurqAccountingAccountByTopAccount(parentAccount);
			}
			else
			{
				account.setTurqAccountingAccountByTopAccount(parentAccount
						.getTurqAccountingAccountByTopAccount());
			}
			EngDALCommon.updateObject(account);
			AccDALAccountUpdate.updateAccountCodeOfSubAccs(account, accCode);
			EngBLAccountingAccounts.RefreshContentAsistantMap();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	private static void verifyAccountForUpdate(Integer accountId, String accountCode) throws Exception
	{
		Integer existingAcc=AccBLAccountSearch.getAccountIdByAccountCode(accountCode);
		if (existingAcc != null)
		{
			if (accountId != null && existingAcc.intValue()!=accountId.intValue())
			{
				throw new TurquazException(AccLangKeys.MSG_NOT_ENTER_EXISTING_ACCOUNT_CODE);
			}
		}
	}

	private static boolean isSubAccountOf(TurqAccountingAccount parent, TurqAccountingAccount account)
	{
		int parentId = parent.getId().intValue();
		TurqAccountingAccount parentAcc = account.getTurqAccountingAccountByParentAccount();
		Integer parentAccId = parentAcc.getId();
		while (parentAccId.intValue() != -1)
		{
			if (parentAccId.intValue() == parentId)
				return true;
			parentAcc = parentAcc.getTurqAccountingAccountByParentAccount();
			parentAccId = parentAcc.getId();
			System.out.println("here");
		}
		return false;
	}

	public static List getSubAccounts(HashMap argMap) throws Exception
	{
		Integer parentId = (Integer) argMap.get(AccKeys.ACC_PARENT_ID);
		return AccDALAccountUpdate.getSubAccounts(parentId);
	}

	public static List getAccountTransColumns(HashMap argMap) throws Exception
	{
		Integer accId = (Integer) argMap.get(AccKeys.ACC_ACCOUNT_ID);
		return AccDALAccountUpdate.getAccountTransColumns(accId);
	}
	
	public static List getAccountTransColumns(Integer accountId) throws Exception
	{
		return AccDALAccountUpdate.getAccountTransColumns(accountId);
	}

	public static void deleteAccount(HashMap argMap) throws Exception
	{
		Integer accId = (Integer) argMap.get(AccKeys.ACC_ACCOUNT_ID);
		//XXX hsqldb bug is fixed..no need to change id while deleting..
		TurqAccountingAccount account = (TurqAccountingAccount) EngDALSessionFactory.getSession().load(
				TurqAccountingAccount.class, accId);
		if (account.getId().equals(account.getTurqAccountingAccountByTopAccount().getId()))
		{
			TurqAccountingAccount dummy = new TurqAccountingAccount();
			dummy.setId(new Integer(-1));
			account.setTurqAccountingAccountByTopAccount(dummy);
			EngDALCommon.updateObject(account);
		}
		EngDALCommon.deleteObject(account);
		EngBLAccountingAccounts.RefreshContentAsistantMap();
	}
}