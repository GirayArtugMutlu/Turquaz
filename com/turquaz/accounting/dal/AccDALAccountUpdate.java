package com.turquaz.accounting.dal;

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
import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;

public class AccDALAccountUpdate
{
	public static List getSubAccounts(Integer parentId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqAccountingAccount as accounts " + "where accounts.turqAccountingAccountByParentAccount.id ="
					+ parentId;
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateAccountCodeOfSubAccs(TurqAccountingAccount parentAcc, String firstAccCode) throws Exception
	{
		try
		{
			List subAccounts = getSubAccounts(parentAcc.getId());
			Session session = EngDALSessionFactory.getSession();
			for (int k = 0; k < subAccounts.size(); k++)
			{
				
				TurqAccountingAccount subAcc = (TurqAccountingAccount) subAccounts.get(k);
				String remainingCode = subAcc.getAccountCode().substring(firstAccCode.length());
				String firstSubAccCode = subAcc.getAccountCode();
				subAcc.setAccountCode(parentAcc.getAccountCode().concat(remainingCode));
				session.update(subAcc);
				session.flush();
				updateAccountCodeOfSubAccs(subAcc, firstSubAccCode);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAccountTransColumns(Integer accId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transColumns from TurqAccountingTransactionColumn as transColumns "
					+ "where transColumns.turqAccountingAccount.id =" + accId;
			Query q = session.createQuery(query);
			List list = q.list();
			
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTotalDeptAndCredit(TurqAccountingAccount account) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select sum(transaction.rowsDeptInBaseCurrency), sum(transaction.rowsCreditInBaseCurrency) from TurqAccountingTransactionColumn as transaction "
					+ "where transaction.turqAccountingAccount= :account";
			Query q = session.createQuery(query);
			q.setParameter("account", account);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}