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
 * @version $Id: AccDALTransactionSearch.java,v 1.16 2004/12/16 15:29:16
 *          cemdayanik Exp $
 */

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;

public class AccDALTransactionSearch {

	public AccDALTransactionSearch() {

	}

	public List getTransactionTypes() throws Exception {

		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "select distinct transType from TurqAccountingTransactionType as transType";
			Query q = session.createQuery(query);
			List list = q.list();
			session.close();

			return list;

		} catch (Exception ex) {
			throw ex;

		}

	}

	public List searchTransaction(String docNo, Object type, Object startDate,
			Object endDate) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();

			String query = "select accTrans.accountingTransactionsId, accTrans.transactionsDate,accTrans.transactionDocumentNo,accTrans.turqAccountingTransactionType.typesName,accTrans.transactionDescription, sum(transRow.creditAmount) from TurqAccountingTransaction as accTrans"
					+ " left join accTrans.turqAccountingTransactionColumns as transRow where accTrans.transactionDocumentNo like '"
					+ docNo
					+ "%' ";

			if (startDate != null) {

				query += " and accTrans.transactionsDate >= :startDate";
			}

			if (endDate != null) {
				query += " and accTrans.transactionsDate <= :endDate";
			}

			if (type != null) {
				query += " and accTrans.turqAccountingTransactionType= :transType";
			}
			
			
			query +=" group by  accTrans.accountingTransactionsId, accTrans.transactionsDate,accTrans.transactionDocumentNo,accTrans.turqAccountingTransactionType.typesName,accTrans.transactionDescription";
            query +=" order by accTrans.transactionsDate";   
			
			Query q = session.createQuery(query);

			if (startDate != null) {
				
				q.setParameter("startDate", startDate);
			}

			if (endDate != null) {
				
				q.setParameter("endDate",endDate);
			}

			if (type != null) {
				
				q.setParameter("transType", type);

			}

			List list = q.list();
			
			session.close();

			return list;

		} catch (Exception ex) {
			throw ex;
		}

	}
	public void deleteTransaction(TurqAccountingTransaction trans)throws Exception
	{
	    try {
	        removeTransactionRows(trans);
			Session session = EngDALSessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.delete(trans);

			session.flush();
			tr.commit();

			session.close();

		} catch (Exception ex) {
			throw ex;

		}
	    
	}

	public void removeTransactionRows(TurqAccountingTransaction transaction)
			throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session
					.delete("select row from TurqAccountingTransactionColumn as row where"
							+ " row.turqAccountingTransaction.accountingTransactionsId ="
							+ transaction.getAccountingTransactionsId()
									.intValue());

			session.flush();
			tr.commit();

			session.close();

		} catch (Exception ex) {
			throw ex;

		}

	}

	
	public List searchTransactionRows(TurqAccountingTransaction trans,
			boolean isCredit) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();

			String query = "select transRow from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingTransaction = :trans";

			//Tahsil Fisi
			if (isCredit) {
				query += " and transRow.creditAmount > 0";
			}
			//Tediye Fisi
			else {
				query += " and transRow.deptAmount > 0";
			}

			Query q = session.createQuery(query);
			q.setParameter("trans", trans);
			List list = q.list();
			session.close();

			return list;
		} catch (Exception ex) {
			throw ex;
		}
	}
	public Object[] getAccTransactionBalance(TurqAccountingAccount acc,
			Object startDate, Object endDate) throws Exception {
		try {
			
			Session session = EngDALSessionFactory.openSession();

			String query = "select sum(transRow.deptAmount),sum(transRow.creditAmount) from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingAccount = :acc ";

			if (startDate != null) {
				query += " and transRow.turqAccountingTransaction.transactionsDate >= :startDate";
			}

			if (endDate != null) {
				query += " and transRow.turqAccountingTransaction.transactionsDate <= :endDate";
			}
			
			Query q = session.createQuery(query);
			q.setParameter("acc", acc);

			if (startDate != null) {
				Date date = (Date) startDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("startDate", sqlDate);
			}

			if (endDate != null) {
				Date date = (Date) endDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("endDate", sqlDate);
			}
			List list = q.list();
			Object sums[] = (Object[])list.get(0);
			
			session.close();


			return sums;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public List searchAccTransactionsColumns(TurqAccountingAccount acc,
			Object startDate, Object endDate) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();

			String query = "select transRow from TurqAccountingTransactionColumn as transRow"
					+ " where transRow.turqAccountingAccount = :acc ";

			if (startDate != null) {
				query += " and transRow.turqAccountingTransaction.transactionsDate >= :startDate";
			}

			if (endDate != null) {
				query += " and transRow.turqAccountingTransaction.transactionsDate <= :endDate";
			}

			query += " order by transRow.turqAccountingTransaction.transactionsDate "; 
			Query q = session.createQuery(query);
			q.setParameter("acc", acc);

			if (startDate != null) {
				Date date = (Date) startDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("startDate", sqlDate);
			}

			if (endDate != null) {
				Date date = (Date) endDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("endDate", sqlDate);
			}
			
			List list = q.list();

			session.close();

			return list;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public List getUnsavedTransactions() throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			String query = "select accTrans from TurqAccountingTransaction as accTrans"
					+

					" where accTrans.turqAccountingJournal.accountingJournalId = -1";

			Query q = session.createQuery(query);

			List list = q.list();

			for (int i = 0; i < list.size(); i++) {

				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) list
						.get(i);
				Hibernate.initialize(accTrans
						.getTurqAccountingTransactionColumns());

			}

			session.close();

			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public List getTransactions(Object firstAccount, Object secondAccount,boolean initialAccounts, boolean finalAccounts,
			Date startDate, Date endDate) throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "select accounts, sum(transColumns.deptAmount),"
					+ " sum(transColumns.creditAmount) from TurqAccountingAccount accounts,"
					+ " TurqAccountingTransaction as accTrans,"
					+ " TurqAccountingTransactionColumn as transColumns"
					+ " where transColumns.turqAccountingTransaction.accountingTransactionsId=accTrans.accountingTransactionsId"
					+ " and accounts.accountingAccountsId=transColumns.turqAccountingAccount.accountingAccountsId";
			
			if (firstAccount !=null && secondAccount !=null)
			{
				TurqAccountingAccount first=(TurqAccountingAccount)firstAccount;
				TurqAccountingAccount second=(TurqAccountingAccount)secondAccount;
				query+=" and accounts.accountCode >='"+first.getAccountCode()+"'"+
					"and accounts.accountCode <='"+second.getAccountCode()+"'";				
			}
			else if (firstAccount !=null)
			{
				TurqAccountingAccount first=(TurqAccountingAccount)firstAccount;
				query+=" and accounts.accountCode ='"+first.getAccountCode()+"'";
			}
			else if (secondAccount !=null)
			{
				TurqAccountingAccount second=(TurqAccountingAccount)secondAccount;
				query+=" and accounts.accountCode ='"+second.getAccountCode()+"'";
			}
			if (startDate != null) {

				query += " and accTrans.transactionsDate >= :startDate";
			}

			if (endDate != null) {
				query += " and accTrans.transactionsDate <= :endDate";
			}

			if (!initialAccounts) {
				query += " and accTrans.turqAccountingTransactionType <>"
						+ new Integer(3);
			}
			query += " group by accounts.accountingAccountsId,accounts.accountName,"
					+ " accounts.accountCode, accounts.createdBy, accounts.creationDate,"
					+ " accounts.updatedBy, accounts.updateDate,"
					+ " accounts.turqAccountingAccountByParentAccount,"
					+ " accounts.turqAccountingAccountByTopAccount"
					+ " order by accounts.turqAccountingAccountByTopAccount.accountingAccountsId";
			Query q = session.createQuery(query);

			if (startDate != null) {
				java.sql.Date sqlDate = new java.sql.Date(startDate.getTime());
				q.setParameter("startDate", sqlDate);
			}

			if (endDate != null) {
				java.sql.Date sqlDate = new java.sql.Date(endDate.getTime());
				q.setParameter("endDate", sqlDate);
			}

			List list = q.list();
			session.close();

			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}
}