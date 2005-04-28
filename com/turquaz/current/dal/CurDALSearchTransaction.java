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
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
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

	public static List getCurrentBalances(TurqCurrentCard curCardStart, TurqCurrentCard curCardEnd, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction.turqCurrentCard.cardsCurrentCode,sum(transaction.transactionsTotalDept), " +
					" sum(transaction.transactionsTotalCredit) from TurqCurrentTransaction as transaction " +
					" where transaction.transactionsDate < :endDate ";
			
			if (curCardStart != null && curCardEnd != null)
			{
				query += " and transaction.turqCurrentCard.cardsCurrentCode >= '"+curCardStart.getCardsCurrentCode()+"'";
				query += " and transaction.turqCurrentCard.cardsCurrentCode <= '"+curCardEnd.getCardsCurrentCode()+"'";
			}
			else if (curCardStart != null)
			{
				query += " and transaction.turqCurrentCard.id="+curCardStart.getId();
			}
			query +=" group by transaction.turqCurrentCard.cardsCurrentCode"+
					" order by transaction.turqCurrentCard.cardsCurrentCode";

			Query q = session.createQuery(query);
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
			session.clear();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getCurrentCardAbstract(TurqCurrentCard curCardStart,TurqCurrentCard curCardEnd, 
			Date startDate, Date endDate, String definition,
			BigDecimal minAmount, TurqCurrentGroup curGroup ) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			Statement statement=session.connection().createStatement();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
			String query="Select curCard.cards_current_code, curCard.cards_name," +
			" curTransTable.transaction_type_name,curTransTable.transactions_date," +
			" curTransTable.transactions_document_no,curTransTable.transactions_total_credit," +
			" curTransTable.transactions_total_dept,curTransTable.id,curTransTable.transactions_definition" +
			" from turq_view_current_amount_total curView,";
			if (curGroup != null)
			{
				query += " turq_current_cards_groups curCardGr,";
			}
			query += " turq_current_cards curCard left join" +
			" (Select curTransType.transaction_type_name, curTrans.transactions_date," +
			" curTrans.transactions_document_no,curTrans.transactions_total_credit," +
			" curTrans.transactions_total_dept, curTrans.id, curTrans.transactions_definition," +
			" curTrans.current_cards_id " +
			" from turq_current_transactions curTrans," +
			" turq_current_transaction_types curTransType " +
			" where curTrans.current_transaction_types_id=curTransType.id";

			
			if (!definition.trim().equals(""))
			{
				query += " and curTrans.transactions_definition like '"+definition.toUpperCase(Locale.getDefault()) +"%'";
			}
			query += " and curTrans.transactions_date >= '"+df.format(startDate)+"'"+
			" and curTrans.transactions_date <= '"+df.format(endDate)+ "')" +
			" curTransTable ON curTransTable.current_cards_id=curCard.id" +
			" where curCard.id=curView.current_cards_id";
			
			if (curGroup != null)
			{
				query += " and curCardGr.current_cards_id=curCard.id and curCardGr.current_groups_id="+curGroup.getId().intValue();
			}
			
			if (curCardStart != null && curCardEnd != null)
			{
				query += " and curCard.cards_current_code >= '"+curCardStart.getCardsCurrentCode()+"'";
				query += " and curCard.cards_current_code <= '"+curCardEnd.getCardsCurrentCode()+"'";
			}
			else if (curCardStart != null)
			{
				query += " and curCard.id="+curCardStart.getId();
			}
			
			if (minAmount.doubleValue() > 0)
			{
				query += " and (Select sum(trans.transactions_total_dept)+sum(trans.transactions_total_credit)" +
						" from turq_current_transactions trans" +
						" where trans.current_cards_id=curCard.id" +
						" and trans.transactions_date >= '"+df.format(startDate)+"'"+
						" and trans.transactions_date <= '"+df.format(endDate)+ "') >"+minAmount;
			}
			query += " order by curCard.cards_current_code, curTransTable.transactions_date";
			
			ResultSet rs=statement.executeQuery(query);
			List list=new ArrayList();
			while (rs.next())
			{
				Object[] result=new Object[9];
				result[0]=rs.getObject(1);
				result[1]=rs.getObject(2);
				result[2]=rs.getObject(3);
				result[3]=rs.getObject(4);
				result[4]=rs.getObject(5);
				result[5]=rs.getObject(6);
				result[6]=rs.getObject(7);
				result[7]=rs.getObject(8);
				result[8]=rs.getObject(9);
				list.add(result);
			}			
			return list;
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
}