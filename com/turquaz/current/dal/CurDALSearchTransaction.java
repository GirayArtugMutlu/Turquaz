package com.turquaz.current.dal;

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
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurDALSearchTransaction
{
	public CurDALSearchTransaction()
	{
	}

	public static List searchTransaction(TurqCurrentCard curCard, TurqCurrentTransactionType type, String docNo, String definition,
			Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction.id," + " transaction.transactionsDate," + " transaction.transactionsDocumentNo,"
					+ " curCard.cardsCurrentCode, curCard.cardsName, transType.transactionTypeName,"
					+ " transaction.transactionsDefinition, transaction.transactionsTotalDept,"
					+ " transaction.transactionsTotalCredit from TurqCurrentTransaction as transaction,"
					+ " transaction.turqCurrentCard as curCard,transaction.turqCurrentTransactionType as transType where"
					+ " transaction.transactionsDocumentNo like '" + docNo + "%'" + " and transaction.transactionsDefinition like '"
					+ definition.toUpperCase(Locale.getDefault()) + "%'" + " and transaction.transactionsDate >= :startDate "
					+ " and transaction.transactionsDate <= :endDate";
			if (curCard != null)
			{
				query += " and transaction.turqCurrentCard = :curCard";
			}
			if (type != null)
			{
				query += " and transaction.turqCurrentTransactionType = :type";
			}
			query += " order by transaction.transactionsDate";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			if (curCard != null)
			{
				q.setParameter("curCard", curCard);
			}
			if (type != null)
			{
				q.setParameter("type", type);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentTransaction getCurTransByTransId(Integer transId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction from TurqCurrentTransaction as transaction" + " where transaction.id=" + transId;
			Query q = session.createQuery(query);
			List list = q.list();
			return (TurqCurrentTransaction) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentTransactions(TurqCurrentCard curCard, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction from TurqCurrentTransaction as transaction where"
					+ " transaction.turqCurrentCard= :curCard";
			if (startDate != null && endDate != null)
			{
				query += " and transaction.transactionsDate >= :startDate " + " and transaction.transactionsDate <= :endDate";
			}
			Query q = session.createQuery(query);
			if (startDate != null && endDate != null)
			{
				q.setParameter("startDate", startDate);
				q.setParameter("endDate", endDate);
			}
			q.setParameter("curCard", curCard);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentBalances(TurqCurrentCard curCard, TurqCurrentCard curCard2, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "";
			if (curCard == null)
			{
				query = "Select transaction.turqCurrentCard.cardsCurrentCode,sum(transaction.transactionsTotalDept),"
						+ "sum(transaction.transactionsTotalCredit)" + " from TurqCurrentTransaction as transaction where"
						+ " transaction.transactionsDate < :endDate" + " group by transaction.turqCurrentCard.cardsCurrentCode";
			}
			else if (curCard2 == null)
			{
				query = "Select transaction.turqCurrentCard.cardsCurrentCode,sum(transaction.transactionsTotalDept),"
						+ "sum(transaction.transactionsTotalCredit) from TurqCurrentTransaction as transaction where"
						+ " transaction.turqCurrentCard= :curCard and" + " transaction.transactionsDate < :endDate"
						+ " group by transaction.turqCurrentCard.cardsCurrentCode";
			}
			else
			{
				query = "Select transaction.turqCurrentCard.cardsCurrentCode,sum(transaction.transactionsTotalDept),"
						+ "sum(transaction.transactionsTotalCredit) from TurqCurrentTransaction as transaction where"
						+ " transaction.turqCurrentCard.cardsCurrentCode >=" + "'" + curCard.getCardsCurrentCode() + "'"
						+ " and transaction.turqCurrentCard.cardsCurrentCode <=" + "'" + curCard2.getCardsCurrentCode() + "'"
						+ " and transaction.transactionsDate < :endDate" + " group by transaction.turqCurrentCard.cardsCurrentCode"
						+ " order by transaction.turqCurrentCard.cardsCurrentCode";
			}
			Query q = session.createQuery(query);
			if (curCard == null)
			{
			}
			else if (curCard2 == null)
				q.setParameter("curCard", curCard);
			q.setParameter("endDate", endDate);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInitialTransactions() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankTrans from TurqCurrentTransaction as bankTrans "
					+ " where bankTrans.turqCurrentTransactionType.id = " + EngBLCommon.CURRENT_TRANS_INITIAL
					+ " order by bankTrans.turqCurrentCard.cardsCurrentCode";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInitialTransactions(TurqCurrentCard curCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankTrans from TurqCurrentTransaction as bankTrans "
					+ " where bankTrans.turqCurrentTransactionType.id = " + EngBLCommon.CURRENT_TRANS_INITIAL
					+ " and bankTrans.turqCurrentCard = :curCard " + " order by bankTrans.turqCurrentCard.cardsCurrentCode";
			Query q = session.createQuery(query);
			q.setParameter("curCard", curCard);
			List list = q.list();
			for (int i = 0; i < list.size(); i++)
			{
				session.delete(list.get(i));
			}
			session.flush();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}