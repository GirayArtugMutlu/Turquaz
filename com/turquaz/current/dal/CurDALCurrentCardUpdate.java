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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

public class CurDALCurrentCardUpdate
{
	public CurDALCurrentCardUpdate()
	{
	}

	public static List getCurrentGroups() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqCurrentGroup as curGroup ";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getCurrentTransactionBalances(TurqCurrentTransactionType type, TurqCurrentCard card) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select sum(trans.transactionsTotalDept),sum(trans.transactionsTotalCredit)"
					+ " from TurqCurrentTransaction as trans "
					+ "where trans.turqCurrentCard = :curCard and trans.turqCurrentTransactionType = :transType ";
			Query q = session.createQuery(query);
			q.setParameter("transType", type);
			q.setParameter("curCard", card);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initCurrentTrans(TurqCurrentTransaction curTrans) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(curTrans);
			Hibernate.initialize(curTrans.getTurqEngineSequence().getTurqAccountingTransactions());
			session.flush();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}