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
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

public class InvDALSearchTransaction {
	public InvDALSearchTransaction() {

	}

	public List searchTransactions(TurqCurrentCard curCard,
			TurqInventoryCard invCard, Date startDate, Date endDate, int type)
			throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "Select transaction from TurqInventoryTransaction as transaction where"
					+ " transaction.turqConsignment.consignmentsDate >= :startDate"
					+ " and transaction.turqConsignment.consignmentsDate <= :endDate"
					+ " and transaction.turqConsignment.consignmentsType ="
					+ type + "";

			if (curCard != null) {
				query += " and transaction.turqConsignment.turqCurrentCard = :curCard";
			}
			if (invCard != null) {
				query += " and transaction.turqInventoryCard = :invCard";
			}
			query += " order by transaction.turqConsignment.consignmentsDate";

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
			
			for (int i =0;i<list.size();i++){
				
			TurqInventoryTransaction invTrans = (TurqInventoryTransaction)list.get(i);
			Hibernate.initialize(invTrans.getTurqEngineSequence().getTurqConsignments());
			
			
			}
			

			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}

}

