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

import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.dal.EngDALSessionFactory;

import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
public class InvDALSearchTransaction {
	public InvDALSearchTransaction() {

	}

	public List searchTransactions(TurqCurrentCard curCard,
			TurqInventoryCard invCard, Date startDate, Date endDate, int type)
			throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
  
                 			
			String query = "Select distinct transaction, consignment.consignmentsDate from TurqInventoryTransaction as transaction," +
					 " TurqConsignment as consignment where" +
					 " consignment.turqEngineSequence = transaction.turqEngineSequence "
					+ " and consignment.consignmentsDate >= :startDate"
					+ " and consignment.consignmentsDate <= :endDate"
					+ " and consignment.consignmentsType ="
					+ type + "";

			if (curCard != null) {
				query += " and consignment.turqBillConsignmentCommon.turqCurrentCard = :curCard";
			}
			if (invCard != null) {
				query += " and transaction.turqInventoryCard = :invCard";
			}
			

			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			
			if (curCard != null) {
				q.setParameter("curCard", curCard);
			}
			if (invCard != null) {
				q.setParameter("invCard", invCard);
			}

			
              List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}
	
	
	public TurqConsignment getConsignment(TurqEngineSequence seq) throws Exception
	{
		try {
			Session session = EngDALSessionFactory.openSession();
			session.refresh(seq);
			
			Hibernate.initialize(seq.getTurqConsignments());
			Iterator it = seq.getTurqConsignments().iterator();
			
			TurqConsignment cons = null;
			if (it.hasNext())
			{
				 cons = (TurqConsignment)it.next();
				ConDALUpdateConsignment dalSearchCons = new ConDALUpdateConsignment();
				dalSearchCons.initiliazeConsignment(cons);
			}
			session.close();
			return cons;

		} catch (Exception ex) {
			throw ex;
		}
	}

}

