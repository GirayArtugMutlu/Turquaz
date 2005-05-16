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
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.exceptions.TurquazException;

public class AccBLAccountUpdate
{
	public static void updateAccount(HashMap argMap) throws Exception
	{
		try
		{
			TurqAccountingAccount account = (TurqAccountingAccount) argMap.get(AccKeys.ACC_ACCOUNT);
			String accountName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
			String accountCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
			TurqAccountingAccount parentAccount = (TurqAccountingAccount) argMap.get(AccKeys.ACC_PARENT_ACCOUNT);
			boolean isSub=isSubAccountOf(account,parentAccount);
			System.out.println(isSub);
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
	
	private static boolean isSubAccountOf(TurqAccountingAccount parent, TurqAccountingAccount account)
	{
		int parentId=parent.getId().intValue();
		TurqAccountingAccount parentAcc=account.getTurqAccountingAccountByParentAccount();
		Integer parentAccId=parentAcc.getId();
		while (parentAccId.intValue() != -1)
		{
			if (parentAccId.intValue()==parentId)
				return true;
			parentAcc=parentAcc.getTurqAccountingAccountByParentAccount();
			parentAccId=parentAcc.getId();
			System.out.println("here");
		}
		return false;
	}


	public static List getSubAccounts(HashMap argMap) throws Exception
	{
		
		TurqAccountingAccount parentAcc = (TurqAccountingAccount)argMap.get(AccKeys.ACC_PARENT_ACCOUNT);
		
			return AccDALAccountUpdate.getSubAccounts(parentAcc);
	
	}

	public static List getAccountTransColumns(HashMap argMap) throws Exception
	{
		
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		
		return AccDALAccountUpdate.getAccountTransColumns(account);
		
	}

	public static void deleteAccount(HashMap argMap) throws Exception
	{
        TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
       
        if(account.getId().equals(account.getTurqAccountingAccountByTopAccount().getId()))
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