package com.turquaz.inventory.dal;

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
 * @author Huseyin Ergun
 * @version $Id$
 */
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;

public class InvDALSearchTransaction
{
	public static List searchTransactions(TurqCurrentCard curCard, TurqInventoryCard invCard, Date startDate, Date endDate, int type)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction.id,transaction.transactionsDate,transaction.amountIn,"
					+ "transaction.amountOut, transaction.totalPrice," + " transaction.turqInventoryCard.cardInventoryCode, "
					+ " transaction.turqInventoryCard.cardName from TurqInventoryTransaction as transaction"
					+ " where transaction.transactionsDate >= :startDate" + " and transaction.transactionsDate <= :endDate";
			if (type == EngBLCommon.COMMON_BUY_INT)
				query += " and transaction.amountIn > 0";
			else if (type == EngBLCommon.COMMON_SELL_INT)
				query += " and transaction.amountOut > 0";
			if (curCard != null)
			{
				query += " and transaction.turqCurrentCard = :curCard";
			}
			if (invCard != null)
			{
				query += " and transaction.turqInventoryCard = :invCard";
			}
			query += " order by transaction.transactionsDate";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			if (curCard != null)
			{
				q.setParameter("curCard", curCard);
			}
			if (invCard != null)
			{
				q.setParameter("invCard", invCard);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchTransactionsRange(TurqInventoryCard invCardStart, TurqInventoryCard invCardEnd, TurqCurrentCard curCard,
			Date startDate, Date endDate, int type) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction.id," + "transaction.transactionsDate," + "transaction.amountIn,"
					+ "transaction.amountOut, transaction.totalPrice," + " transaction.turqInventoryCard.cardInventoryCode, "
					+ " transaction.turqInventoryCard.cardName," + " transaction.turqCurrentCard.cardsName,"
					+ " transaction.turqInventoryCard.id," + " transaction.documentNo "
					+ "  from TurqInventoryTransaction as transaction" + " where transaction.transactionsDate >= :startDate"
					+ " and transaction.transactionsDate <= :endDate";
			if (type == EngBLCommon.COMMON_BUY_INT)
				query += " and transaction.amountIn > 0";
			else if (type == EngBLCommon.COMMON_SELL_INT)
				query += " and transaction.amountOut > 0";
			if (curCard != null)
			{
				query += " and transaction.turqCurrentCard = :curCard";
			}
			if (invCardStart != null && invCardEnd != null)
			{
				query += " and transaction.turqInventoryCard.cardInventoryCode >= '" + invCardStart.getCardInventoryCode() + "'";
				query += " and transaction.turqInventoryCard.cardInventoryCode <= '" + invCardEnd.getCardInventoryCode() + "'";
			}
			else if (invCardStart != null)
			{
				query += " and transaction.turqInventoryCard = :invCardStart";
			}
			else if (invCardEnd != null)
			{
				query += " and transaction.turqInventoryCard = :invCardEnd";
			}
			query += " order by transaction.turqInventoryCard";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			if (curCard != null)
			{
				q.setParameter("curCard", curCard);
			}
			if (invCardStart != null && invCardEnd != null)
			{
			}
			else if (invCardStart != null)
			{
				q.setParameter("invCardStart", invCardStart);
			}
			else if (invCardEnd != null)
			{
				q.setParameter("invCardEnd", invCardEnd);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchTransactionsAdvanced(String invCardCodeStart, String invCardCodeEnd, String invCardNameStart,
			String invCardNameEnd, TurqCurrentCard curCardStart, TurqCurrentCard curCardEnd, Date startDate, Date endDate, int type,
			TurqInventoryGroup invMainGroup, TurqInventoryGroup invSubGroup) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction.id," + "transaction.transactionsDate," + "transaction.amountIn,"
					+ "transaction.amountOut," + " transaction.totalPrice," + " transaction.turqInventoryCard.cardInventoryCode, "
					+ " transaction.turqInventoryCard.cardName," + " transaction.turqCurrentCard.cardsName,"
					+ " transaction.turqInventoryCard.id," + " transaction.documentNo";
			if (invMainGroup != null)
			{
				query += ", cardGroup.turqInventoryGroup.groupsName," + " cardGroup.turqInventoryGroup.id";
			}
			query += " from TurqInventoryTransaction as transaction";
			if (invMainGroup != null)
			{
				query += " left join transaction.turqInventoryCard.turqInventoryCardGroups as cardGroup";
			}
			query += " where transaction.transactionsDate >= :startDate" + " and transaction.transactionsDate <= :endDate";
			if (invMainGroup != null)
			{
				query += " and cardGroup.turqInventoryGroup.turqInventoryGroup.id=" + invMainGroup.getId();
			}
			if (type == EngBLCommon.COMMON_BUY_INT)
				query += " and transaction.amountIn > 0";
			else if (type == EngBLCommon.COMMON_SELL_INT)
				query += " and transaction.amountOut > 0";
			if (!invCardCodeStart.equals("") && !invCardCodeEnd.equals(""))
			{
				query += "  and transaction.turqInventoryCard.cardInventoryCode >= '" + invCardCodeStart + "'";
				query += "  and transaction.turqInventoryCard.cardInventoryCode <= '" + invCardCodeEnd + "'";
			}
			else if (!invCardCodeStart.equals(""))
			{
				query += " and transaction.turqInventoryCard.cardInventoryCode like '" + invCardCodeStart + "%'";
			}
			else if (!invCardCodeEnd.equals(""))
			{
				query += " and transaction.turqInventoryCard.cardInventoryCode like '" + invCardCodeEnd + "%'";
			}
			if (!invCardNameStart.equals("") && !invCardNameEnd.equals(""))
			{
				query += " and transaction.turqInventoryCard.cardName >= '" + invCardNameStart + "'";
				query += " and transaction.turqInventoryCard.cardName <= '" + invCardNameEnd + "'";
			}
			else if (!invCardNameStart.equals(""))
			{
				query += " and transaction.turqInventoryCard.cardName like '" + invCardNameStart + "%'";
			}
			else if (!invCardNameEnd.equals(""))
			{
				query += " and transaction.turqInventoryCard.cardName like '" + invCardNameEnd + "%'";
			}
			if (curCardStart != null && curCardEnd != null)
			{
				query += " and transaction.turqCurrentCard.cardsCurrentCode >= '" + curCardStart.getCardsCurrentCode() + "'";
				query += " and transaction.turqCurrentCard.cardsCurrentCode <= '" + curCardEnd.getCardsCurrentCode() + "'";
			}
			else if (curCardStart != null)
			{
				query += " and transaction.turqCurrentCard = :curCardStart";
			}
			else if (curCardEnd != null)
			{
				query += " and transaction.turqCurrentCard = :curCardEnd";
			}
			if (invMainGroup != null)
			{
				if (invSubGroup != null)
				{
					query += " and "
							+ invSubGroup.getId()
							+ " in (Select gr.turqInventoryGroup.id from transaction.turqInventoryCard.turqInventoryCardGroups as gr)";
				}
				else
				{
					query += " and exists (((Select tgr.turqInventoryGroup.id"
							+ " from transaction.turqInventoryCard.turqInventoryCardGroups as tgr) " + " intersect "
							+ " (Select invGr.id from TurqInventoryGroup as invGr " + " where invGr.turqInventoryGroup.id="
							+ invMainGroup.getId() + ")))";
				}
			}
			if (invMainGroup != null)
			{
				query += " order by cardGroup.turqInventoryGroup.id, transaction.transactionsDate";
			}
			else
			{
				query += " order by transaction.turqInventoryCard.id,transaction.transactionsDate";
			}
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			if (curCardStart != null && curCardEnd != null)
			{
			}
			else if (curCardStart != null)
				q.setParameter("curCardStart", curCardStart);
			else if (curCardEnd != null)
				q.setParameter("curCardEnd", curCardEnd);
			if (invMainGroup != null)
			{
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryTransaction getInvTransByTransId(Integer transId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transaction from TurqInventoryTransaction as transaction" + " where transaction.id=" + transId;
			Query q = session.createQuery(query);
			List list = q.list();
			return (TurqInventoryTransaction) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqConsignment getConsignment(TurqEngineSequence seq) throws Exception
	{
		Session session = null;
		try
		{
			session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqConsignments());
			Iterator it = seq.getTurqConsignments().iterator();
			TurqConsignment cons = null;
			if (it.hasNext())
			{
				cons = (TurqConsignment) it.next();
				ConDALUpdateConsignment.initiliazeConsignment(cons);
			}
			return cons;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}

	public static List getInitialTransactions() throws Exception
	{
		Session session = null;
		try
		{
			session = EngDALSessionFactory.getSession();
			String query = "Select invTrans from TurqInventoryTransaction as invTrans "
					+ " where invTrans.turqInventoryTransactionType.id = " + EngBLCommon.INV_TRANS_INITIAL;
			Query q = session.createQuery(query);
			return q.list();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBill getBill(TurqEngineSequence seq) throws Exception
	{
		Session session = null;
		try
		{
			session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqConsignments());
			Iterator it = seq.getTurqBillInEngineSequences().iterator();
			TurqBill bill = null;
			if (it.hasNext())
			{
				bill = ((TurqBillInEngineSequence) it.next()).getTurqBill();
				BillDALSearchBill.initializeBill(bill);
			}
			return bill;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}
}