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
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	public static List getSubsidiaryLedger(Integer accountIdStart, Integer accountIdEnd, Date startDate, Date endDate)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		TurqAccountingAccount accountStart=null;
		TurqAccountingAccount accountEnd=null;
		
		if (accountIdStart != null)
		{
			accountStart=(TurqAccountingAccount)session.load(TurqAccountingAccount.class,accountIdStart);
		}
		
		if (accountIdEnd != null)
		{
			accountEnd=(TurqAccountingAccount)session.load(TurqAccountingAccount.class,accountIdEnd);
		}
		
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		String 	query = "Select transColumns.id as columnId, transColumns.rows_dept_in_base_currency," +
					"transColumns.rows_credit_in_base_currency,transColumns.transaction_definition," +
					" accounts.account_name as accName, accounts.account_code as accCode," +
					" topacc.account_name as topAccName, topacc.account_code as topAccCode," + 
					" trans.transactions_date, trans.transaction_document_no" +
					" from turq_accounting_transaction_columns transColumns," + 
					" turq_accounting_accounts accounts, turq_accounting_accounts topacc," + 
					" turq_accounting_transactions trans" + 
					" where transColumns.accounting_accounts_id=accounts.id" + 
					" and accounts.top_account=topacc.id" + 
					" and transColumns.accounting_transactions_id=trans.id" + 
					" and trans.transactions_date >=" + "'" + dformat.format(startDate) + "'" + 
					" and trans.transactions_date <=" + "'" + dformat.format(endDate) + "'";
					
		if (accountEnd != null)
		{
			query +=" and accounts.account_code >=" + "'" + accountStart.getAccountCode() + "'" + 
					" and accounts.account_code <=" + "'" + accountEnd.getAccountCode() + "'" ;
		}
		else
		{
			query +=" and accounts.id=" + accountIdStart.intValue();
		}
		
		query +=" order by accounts.account_code,trans.transactions_date,trans.transaction_document_no";		
		Statement statement=session.connection().createStatement();
		ResultSet rs=statement.executeQuery(query);
		List result=new ArrayList();
		while(rs.next())
		{
			Object[] obj=new Object[10];
			for(int k=0; k<10; k++)
			{
				obj[k]=rs.getObject(k+1);
			}
			result.add(obj);
		}		
		return result;
	}
	
	public static List getGeneralLedger(Integer accountStartId, Integer accountEndId,Date startDate, Date endDate, boolean approved) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); 
			
			
			String query = "Select accounts.top_account,accounts.account_name," + 
			" accounts.account_code, trans.transactions_date,trans.transaction_document_no," + 
			" transcolumns.rows_dept_in_base_currency,transcolumns.rows_credit_in_base_currency,"+
			" transcolumns.transaction_definition, trans.accounting_journal_id," +
			" accounts.id as accounting_accounts_id" + 
			" from turq_accounting_accounts accounts,turq_accounting_transactions trans," +
			" turq_accounting_transaction_columns transcolumns " +
			" where accounts.id=transcolumns.accounting_accounts_id" + 
			" and transcolumns.accounting_transactions_id=trans.id" +
			" and trans.transactions_date >= '" + dformat.format(startDate) + "'" +
			" and trans.transactions_date <= '" + dformat.format(endDate) + "'";
			if (approved)
			{
				query += " and trans.accounting_journal_id > 0"; 
			}
			
			TurqAccountingAccount accountStart=null;
			if (accountStartId != null)
			{
				accountStart=(TurqAccountingAccount)session.load(TurqAccountingAccount.class,accountStartId);
			}
			TurqAccountingAccount accountEnd = null;
			if (accountEndId != null)
			{
				accountEnd=(TurqAccountingAccount)session.load(TurqAccountingAccount.class,accountEnd);
			}
			
			if (accountStart != null && accountEnd != null)
			{
				query += " and accounts.account_code >='" + accountStart.getAccountCode() + "'" +
					" and accounts.account_code <='" + accountEnd.getAccountCode() + "'";
			}
			else if (accountStart != null)
			{
				query += " and accounts.id=" + accountStart.getId();
			}
			else if (accountEnd != null)
			{
				query += " and accounts.id=" + accountEnd.getId();
			}
			query += " ORDER BY accounts.top_account,trans.transactions_date";
			
			Statement statement=session.connection().createStatement();
			ResultSet rs=statement.executeQuery(query);
			List list=new ArrayList();
			while(rs.next())
			{
				Object[] obj=new Object[10];
				for(int k=0; k<10; k++)
				{
					obj[k]=rs.getObject(k+1);
				}
				list.add(obj);
			}
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getAccountingJournal(Date startDate, Date endDate, boolean approved) throws Exception
	{
		try
		{
			
			Session session = EngDALSessionFactory.getSession();
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); 
			
			String query = "Select trans.id as accounting_transactions_id," +
			" transcolumns.id as accounting_transaction_columns_id,"+
			" trans.accounting_journal_id, trans.transactions_date," +
			" trans.transaction_document_no, transcolumns.rows_dept_in_base_currency," +
			" transcolumns.rows_credit_in_base_currency, accounts.account_name," +
			" accounts.account_code, trans.transaction_description" +
			" from turq_accounting_transactions trans," +
			" turq_accounting_transaction_columns transcolumns," + 
			" turq_accounting_accounts accounts" +
			" where trans.id=transcolumns.accounting_transactions_id" + 
			" and transcolumns.accounting_accounts_id=accounts.id" +
			" and trans.transactions_date >= '" + dformat.format(startDate) + "'" +
			" and trans.transactions_date <= '" + dformat.format(endDate) + "'"; 
			if (approved)
			{
				query += " and trans.accounting_journal_id > 0"; 
			}
			query += " ORDER BY trans.accounting_journal_id"; 
			
			Statement statement=session.connection().createStatement();
			ResultSet rs=statement.executeQuery(query);
			List list=new ArrayList();
			while(rs.next())
			{
				Object[] obj=new Object[10];
				for(int k=0; k<10; k++)
				{
					obj[k]=rs.getObject(k+1);
				}
				list.add(obj);
			}
		
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

	public static List searchTransaction(String docNo, Date startDate, Date endDate, boolean isGeneralTrans, boolean isCollect,
			boolean isPayment) throws Exception
	{
		try
		{
			
			Session session = EngDALSessionFactory.getSession();
			String query = "select accTrans.id, accTrans.transactionsDate, accTrans.transactionDocumentNo,"
					+ " accTrans.turqAccountingTransactionType.typesName, accTrans.transactionDescription, "
					+ " accView.totalcreditamount, accTrans.turqModule.moduleDescription, accTrans.turqAccountingJournal.id,"
					+ " accTrans.turqModule.id, accTrans.turqAccountingTransactionType.id"
					+ " from TurqAccountingTransaction as accTrans, TurqViewAccTransTotalAmount as accView "
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


	public static List getTransactions(TurqAccountingAccount firstAccount,
			TurqAccountingAccount secondAccount, boolean initialAccounts, Date startDate, Date endDate)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			Statement statement = session.connection().createStatement();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String query = "select accounts.id , accounts.account_code, accounts.account_name, " +
					" accounts.parent_account, accounts.top_account,"
					+ " accountSums.dept, accountSums.credit from turq_accounting_accounts accounts"
					+ " left join (Select transColumns.accounting_accounts_id, "
					+ " sum(transColumns.rows_dept_in_base_currency) as dept," 
					+ " sum(transColumns.rows_credit_in_base_currency) as credit"
					+ " from turq_accounting_transactions as accTrans,"
					+ " turq_accounting_transaction_columns as transColumns"
					+ " where transColumns.accounting_transactions_id=accTrans.id "
					+ " and accTrans.transactions_date >= '"
					+ df.format(startDate)+ "'"
					+ " and accTrans.transactions_date <= '"+ df.format(endDate)+ "'";
			if (!initialAccounts)
			{
				query += " and accTrans.accounting_transaction_types_id <>" + new Integer(3);
			}
			query +=" group by transColumns.accounting_accounts_id) " +
					" accountSums ON accountSums.accounting_accounts_id=accounts.id";
			if (firstAccount != null && secondAccount != null)
			{
				query += " and accounts.account_code >='" + firstAccount.getAccountCode() + "'"
						+ " and accounts.account_code <='" + secondAccount.getAccountCode() + "'";
			}
			else if (firstAccount != null)
			{
				query += " and accounts.account_code ='" + firstAccount.getAccountCode() + "'";
			}
			//query += " order by accounts.top_account";
			ResultSet rs = statement.executeQuery(query);
			List result = new ArrayList();
			while (rs.next())
			{
				Object[] obj = new Object[7];
				obj[0] = rs.getObject(1);
				obj[1] = rs.getObject(2);
				obj[2] = rs.getObject(3);
				obj[3] = rs.getObject(4);
				obj[4] = rs.getObject(5);
				obj[5] = rs.getObject(6);
				obj[6] = rs.getObject(7);
				result.add(obj);
			}
			return result;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}