package com.turquaz.cash.dal;

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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqEngineSequence;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

/**
 * @author onsel
 * @version $Id$
 */
public class CashDALCashCard
{
	public CashDALCashCard()
	{
	}

	public static void deleteAccountingTransaction(TurqCashTransaction cashTrans) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
		
			session.refresh(cashTrans);
			Iterator it = cashTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				TurqAccountingTransaction accTran = (TurqAccountingTransaction) it.next();
				Iterator it2 = accTran.getTurqAccountingTransactionColumns().iterator();
				while (it2.hasNext())
				{
					session.delete(it2.next());
				}
				session.delete(accTran);
			}
		
			session.flush();
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchCashCard(TurqAccountingAccount account, String name) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select cashCard from TurqCashCard as cashCard " + " where cashCard.cashCardName like '" + name + "%' ";
			if (account != null)
			{
				query += " cashCard.turqAccountingAccount = :account";
			}
			Query q = session.createQuery(query);
			if (account != null)
			{
				q.setParameter("account", account);
			}
			List lst = q.list();
		
			return lst;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchCashTransaction(TurqCashCard cashCard, Date startdate, Date endDate, String definition) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select distinct cashTrans.id,"
					+ " cashTrans.turqCashTransactionType.cashTransationTypeName, sum(transRow.deptAmount),sum(transRow.creditAmount),cashTrans.transactionDate, cashTrans.transactionDefinition from TurqCashTransaction as cashTrans"
					+ " left join cashTrans.turqCashTransactionRows as transRow "
					+ " where cashTrans.transactionDate >= :startDate and cashTrans.transactionDate <= :endDate ";
			if (cashCard != null)
			{
				query += " and transRow.turqCashCard = :cashCard ";
			}
			if (!definition.equals(""))
			{
				query += " and cashTrans.transactionDefinition like '" + definition + "%'";
			}
			query += " group by cashTrans.id, cashTrans.turqCashTransactionType.cashTransationTypeName, cashTrans.transactionDate,cashTrans.transactionDefinition";
			query += " order by cashTrans.transactionDate";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startdate);
			q.setParameter("endDate", endDate);
			if (cashCard != null)
			{
				q.setParameter("cashCard", cashCard);
			}
			List lst = q.list();
			return lst;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCashTransaction initiliazeCashTrans(Integer id) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			TurqCashTransaction cashTrans = (TurqCashTransaction) session.load(TurqCashTransaction.class, id);
			Hibernate.initialize(cashTrans.getTurqEngineSequence().getTurqCurrentTransactions());
			Hibernate.initialize(cashTrans.getTurqCashTransactionRows());
			Hibernate.initialize(cashTrans.getTurqEngineSequence().getTurqAccountingTransactions());
			
			return cashTrans;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initiliazeCashTrans(TurqCashTransaction cashTrans) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(cashTrans);
			Hibernate.initialize(cashTrans.getTurqCashTransactionRows());
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentCard getCurrentCard(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqCurrentTransactions());
			Iterator it = seq.getTurqCurrentTransactions().iterator();
			if (it.hasNext())
			{
				TurqCurrentTransaction curTrans = (TurqCurrentTransaction) it.next();
			
				return curTrans.getTurqCurrentCard();
			}
			
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactions(TurqCashCard cashCard, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select trans.id, trans.transactionDate, trans.transactionDefinition,"
					+ " transRow.deptAmount,transRow.creditAmount, trans.turqCashTransactionType.cashTransationTypeName"
					+ " from TurqCashTransaction as trans left join trans.turqCashTransactionRows as transRow "
					+ " where transRow.turqCashCard = :cashCard"
					+ " and trans.transactionDate >= :startDate and trans.transactionDate<= :endDate"
					+ " order by trans.id,trans.transactionDate";
			Query q = session.createQuery(query);
			q.setParameter("cashCard", cashCard);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			List ls = q.list();
			
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//Devreden Toplam
	public static List getDeferredTotal(TurqCashCard cashCard, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select sum(row.deptAmount),sum(row.creditAmount)"
					+ " from TurqCashTransactionRow as row where row.turqCashTransaction.transactionDate < :endDate"
					+ " and row.turqCashCard = :cashCard" + " group by row.turqCashCard";
			Query q = session.createQuery(query);
			q.setParameter("endDate", endDate);
			q.setParameter("cashCard", cashCard);
			List ls = q.list();
			
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}