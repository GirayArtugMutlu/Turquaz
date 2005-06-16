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
import java.util.Date;
import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;

public class AccDALAccountAdd
{
	public static List getAccounts(int parentid, String codeCriteria) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqAccountingAccount as accounts " + "where  accounts.turqAccountingAccountByParentAccount.id ="
					+ parentid + "" + " and accounts.accountCode like '" + codeCriteria + "%'" + " and accounts.id <> -1"
					+ " order by accounts.id";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
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
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account.id, account.accountName, account.accountCode," +
					" account.turqAccountingAccountByParentAccount.id from TurqAccountingAccount as account order by account.id";
			Query q = session.createQuery(query);
			List list = q.list();			
			return list;
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
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account.id, account.accountName, account.accountCode," +
					" account.turqAccountingAccountByParentAccount.id, accView.totalcreditamount," +
					" accView.totaldeptamount from TurqAccountingAccount account, TurqViewAccTotal accView"
					+ " where account.id=accView.accountingAccountsId order by account.id";
			//includes "accounting plan" id=-1
			Query q = session.createQuery(query);
			List list = q.list();		
			return list;
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
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account.id, account.accountName, account.accountCode," +
					" account.turqAccountingAccountByParentAccount.id from TurqAccountingAccount as account" +
					" where account.id <> -1 and account.turqAccountingAccountsByParentAccount.size=0"
					+ " order by account.accountCode";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
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
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account.id, account.accountName, account.accountCode," +
					" account.turqAccountingAccountByParentAccount.id from TurqAccountingAccount as account " + "where account.id<> -1" +
			//" and account.turqAccountingAccountsByParentAccount.accountingAccountsId=-1" +
					" order by account.accountCode";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getLeafAccount(String code) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqAccountingAccount as accounts " + "where accounts.accountCode ='" + code + "'"
					+ " and accounts.id <> -1" + " and accounts.turqAccountingAccountsByParentAccount.size=0";
			Query q = session.createQuery(query);
			List list = q.list();
		
			if (list.size() > 0)
			{
				return (TurqAccountingAccount) list.get(0);
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getAllAccounts(String code) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account from TurqAccountingAccount as account " + "where account.accountCode ='" + code + "'"
					+ " and account.id <> -1";
			Query q = session.createQuery(query);
			List list = q.list();
	
			if (list.size() > 0)
			{
				return (TurqAccountingAccount) list.get(0);
			}
			return null;
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
			Session session = EngDALSessionFactory.getSession();
			String query = "Select accounts.accountCode, accounts.accountName from TurqAccountingAccount as accounts "
					+ "where accounts.id <> -1" + " and accounts.turqAccountingAccountsByParentAccount.size=0"
					+ " and accounts.accountCode like '100%'" + " order by accounts.accountCode";
			Query q = session.createQuery(query);
			List list = q.list();
			
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactionColumns(int type, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transColumn from TurqAccountingTransactionColumn as transColumn"
					+ " where transColumn.turqAccountingTransaction.transactionsDate >= :startDate"
					+ " and transColumn.turqAccountingTransaction.transactionsDate <= :endDate";
			if (type != -1)
				query += " and transColumn.turqAccountingTransaction.turqAccountingTransactionType.id =" + type;
			Query q = session.createQuery(query);
			q.setParameter("endDate", endDate);
			q.setParameter("startDate", startDate);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}