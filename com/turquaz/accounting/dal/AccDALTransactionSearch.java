package com.turquaz.accounting.dal;

/** ********************************************************************* */
/* TURQUAZ: Higly Modular Accounting/ERP Program */
/* ============================================ */
/* Copyright (c) 2004 by Turquaz Software Development Group */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or */
/* (at your option) any later version. */
/* 																		*/
/* This program is distributed in the hope that it will be useful, */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the */
/* GNU General Public License for more details. */
/** ********************************************************************* */
/**
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class AccDALTransactionSearch
{
	public static List getTransactionTypes() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select distinct transType from TurqAccountingTransactionType as transType";
			Query q = session.createQuery(query);
			List list = q.list();
	
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrency getBaseCurrency() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select currency from TurqCurrency as currency" + " where currency.defaultCurrency=true";
			Query q = session.createQuery(query);
			List list = q.list();

			return (TurqCurrency) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select exRate from TurqCurrencyExchangeRate as exRate" + " where exRate.id=-1";
			Query q = session.createQuery(query);
			List list = q.list();
			
			return (TurqCurrencyExchangeRate) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrencies() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select currency from TurqCurrency as currency where currency.id=1";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentBalances(TurqAccountingAccount accountStart, TurqAccountingAccount accountEnd, Date startDate)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select acc.accountCode," + "sum(transcolumn.rowsDeptInBaseCurrency),"
					+ "sum(transcolumn.rowsCreditInBaseCurrency)" + " from TurqAccountingAccount acc,"
					+ " TurqAccountingTransactionColumn transcolumn," + " TurqAccountingTransaction trans"
					+ " where transcolumn.turqAccountingTransaction=trans" + " and trans.transactionsDate < :startDate"
					+ " and acc=transcolumn.turqAccountingAccount";
			if (accountEnd == null)
			{
				query += " and acc.id=" + accountStart.getId();
			}
			else
			{
				query += " and acc.accountCode >= '" + accountStart.getAccountCode() + "'";
				query += " and acc.accountCode <= '" + accountEnd.getAccountCode() + "'";
			}
			query += " group by acc.accountCode";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchTransaction(String docNo, Object startDate, Object endDate, boolean isGeneralTrans, boolean isCollect,
			boolean isPayment) throws Exception
	{
		try
		{
			
			Session session = EngDALSessionFactory.getSession();
			String query = "select accTrans.id," + " accTrans.transactionsDate," + "accTrans.transactionDocumentNo,"
					+ "accTrans.turqAccountingTransactionType.typesName," + "accTrans.transactionDescription, "
					+ "accView.totalcreditamount," + "accTrans.turqModule.moduleDescription "
					+ "from TurqAccountingTransaction as accTrans, TurqViewAccTransTotalAmount as accView "
					+ " where accTrans.id = accView.accountingTransactionsId" ;
			if(!docNo.trim().equals(""))
			{
				query += " and accTrans.transactionDocumentNo like '"+ docNo + "%' ";
			}
					
			if (startDate != null)
			{
				query += " and accTrans.transactionsDate >= :startDate";
			}
			if (endDate != null)
			{
				query += " and accTrans.transactionsDate <= :endDate";
			}
			query += " and ( accTrans.turqAccountingTransactionType.id = -1 ";
			if (isGeneralTrans)
			{
				query += " or accTrans.turqAccountingTransactionType.id =" + EngBLCommon.ACCOUNTING_TRANS_GENERAL;
			}
			if (isCollect)
			{
				query += " or accTrans.turqAccountingTransactionType.id =" + EngBLCommon.ACCOUNTING_TRANS_COLLECT;
			}
			if (isPayment)
			{
				query += " or accTrans.turqAccountingTransactionType.id =" + EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
			}
			query += " )";
			query += " order by accTrans.transactionsDate";
			Query q = session.createQuery(query);
			if (startDate != null)
			{
				q.setParameter("startDate", startDate);
			}
			if (endDate != null)
			{
				q.setParameter("endDate", endDate);
			}
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteTransaction(TurqAccountingTransaction trans) throws Exception
	{
		try
		{
			
			Session session = EngDALSessionFactory.getSession();
			session.refresh(trans);
			Iterator it = trans.getTurqAccountingTransactionColumns().iterator();
			while(it.hasNext())
			{
				session.delete(it.next());
			}		
			
			session.delete(trans);
			session.flush();
	
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	

	public static List searchTransactionRows(TurqAccountingTransaction trans, boolean isCredit) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select transRow from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingTransaction = :trans";
			//Tahsil Fisi
			if (isCredit)
			{
				query += " and transRow.creditAmount > 0";
			}
			//Tediye Fisi
			else
			{
				query += " and transRow.deptAmount > 0";
			}
			Query q = session.createQuery(query);
			q.setParameter("trans", trans);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Object[] getAccTransactionBalance(TurqAccountingAccount acc, Object startDate, Object endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select sum(transRow.deptAmount),sum(transRow.creditAmount) from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingAccount = :acc ";
			if (startDate != null)
			{
				query += " and transRow.turqAccountingTransaction.transactionsDate >= :startDate";
			}
			if (endDate != null)
			{
				query += " and transRow.turqAccountingTransaction.transactionsDate <= :endDate";
			}
			Query q = session.createQuery(query);
			q.setParameter("acc", acc);
			if (startDate != null)
			{
				Date date = (Date) startDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("startDate", sqlDate);
			}
			if (endDate != null)
			{
				Date date = (Date) endDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("endDate", sqlDate);
			}
			List list = q.list();
			Object sums[] = (Object[]) list.get(0);
		
			return sums;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchAccTransactionsColumns(TurqAccountingAccount acc, Object startDate, Object endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select transRow from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingAccount = :acc ";
			if (startDate != null)
			{
				query += " and transRow.turqAccountingTransaction.transactionsDate >= :startDate";
			}
			if (endDate != null)
			{
				query += " and transRow.turqAccountingTransaction.transactionsDate <= :endDate";
			}
			query += " order by transRow.turqAccountingTransaction.transactionsDate ";
			Query q = session.createQuery(query);
			q.setParameter("acc", acc);
			if (startDate != null)
			{
				Date date = (Date) startDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("startDate", sqlDate);
			}
			if (endDate != null)
			{
				Date date = (Date) endDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("endDate", sqlDate);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getUnsavedTransactions() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select accTrans from TurqAccountingTransaction as accTrans"
					+ " where accTrans.turqAccountingJournal.id = -1";
			Query q = session.createQuery(query);
			List list = q.list();
			for (int i = 0; i < list.size(); i++)
			{
				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) list.get(i);
				Hibernate.initialize(accTrans.getTurqAccountingTransactionColumns());
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getAccTransInfo(Integer transId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select account.accountName, account.accountCode," + 
					" topacc.accountName, topacc.accountCode," + 
					" transColumn.deptAmount,transColumn.creditAmount, " + 
					" transColumn.transactionDefinition, transColumn.id" + 
					" from TurqAccountingTransactionColumn transColumn," +
					" transColumn.turqAccountingAccount as account," +
					" account.turqAccountingAccountByTopAccount as topacc" +  
					" where transColumn.turqAccountingTransaction.id=" + transId.intValue() +
					" order by topacc.accountCode";
			Query q = session.createQuery(query);
			
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactions(TurqAccountingAccount firstAccount, TurqAccountingAccount secondAccount, boolean initialAccounts, Date startDate, Date endDate)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select accounts, sum(transColumns.rowsDeptInBaseCurrency),"
					+ " sum(transColumns.rowsCreditInBaseCurrency) from TurqAccountingAccount accounts,"
					+ " TurqAccountingTransaction as accTrans," + " TurqAccountingTransactionColumn as transColumns"
					+ " where transColumns.turqAccountingTransaction=accTrans" + " and accounts=transColumns.turqAccountingAccount"
					+ " and accTrans.transactionsDate >= :startDate and accTrans.transactionsDate <= :endDate";
			if (firstAccount != null && secondAccount != null)
			{
				query += " and accounts.accountCode >='" + firstAccount.getAccountCode() + "'" + "and accounts.accountCode <='"
						+ secondAccount.getAccountCode() + "'";
			}
			else if (firstAccount != null)
			{
				query += " and accounts.accountCode ='" + firstAccount.getAccountCode() + "'";
			}
			if (!initialAccounts)
			{
				query += " and accTrans.turqAccountingTransactionType <>" + new Integer(3);
			}
			query += " group by accounts.id,accounts.accountName," + " accounts.accountCode, accounts.createdBy, accounts.creationDate,"
					+ " accounts.updatedBy, accounts.updateDate," + " accounts.turqAccountingAccountByParentAccount,"
					+ " accounts.turqAccountingAccountByTopAccount," + " accounts.turqAccountingAccountClass,"
					+ " accounts.turqAccountingAccountType" + " order by accounts.turqAccountingAccountByTopAccount.id";
			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate);
			q.setParameter("endDate",endDate);

			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}