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
import java.util.List;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;

public class AccBLAccountAdd
{
	public AccBLAccountAdd()
	{
	}

	public static List getAccount(Integer parentid, String codeCrit) throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAccounts(parentid.intValue(), codeCrit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getLeafAccount(String codeCrit) throws Exception
	{
		try
		{
			return AccDALAccountAdd.getLeafAccount(codeCrit);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getAllAccounts(String codeCrit) throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAllAccounts(codeCrit);
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

	public static List getAllAccountsWithSum() throws Exception
	{
		try
		{
			return AccDALAccountAdd.getAllAccountsWithSum();
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

	public static TurqAccountingAccount saveAccount(String accountName, String accountCode, TurqAccountingAccount parent) throws Exception
	{
		try
		{
			TurqAccountingAccount account = new TurqAccountingAccount();
			TurqAccountingAccount parentAccount;
			if (parent != null)
			{
				parentAccount = (TurqAccountingAccount) parent;
			}
			else
			{
				parentAccount = new TurqAccountingAccount();
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
			}
			else
			{
				account.setTurqAccountingAccountByTopAccount(parentAccount.getTurqAccountingAccountByTopAccount());
			}
			EngDALCommon.saveObject(account);
			return account;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactionColumns(int type, Object startDate, Object endDate) throws Exception
	{
		try
		{
			return AccDALAccountAdd.getTransactionColumns(type, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}