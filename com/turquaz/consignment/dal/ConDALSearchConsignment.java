package com.turquaz.consignment.dal;

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
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;


public class ConDALSearchConsignment {
	public ConDALSearchConsignment() {

	}

	public List searchConsignments(TurqCurrentCard curCard, Date startDate,
			Date endDate, int type) throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "Select consignment from TurqConsignment as consignment"+					
					" where consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
					" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$
					" and consignment.consignmentsType =" + type + //$NON-NLS-1$
					" and consignment.consignmentsId <> -1 "; //$NON-NLS-1$		

			if (curCard != null) {
				query += " and consignment.turqBillConsignmentCommon.turqCurrentCard = :curCard"; //$NON-NLS-1$
			}
			query += " order by consignment.consignmentsDate"; //$NON-NLS-1$

			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$

			if (curCard != null) {
				q.setParameter("curCard", curCard); //$NON-NLS-1$
			}

			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}

	//?rsaliyeden faturalstirma da kullaniliyo..
	public List chooseConsignments(TurqCurrentCard curCard, Date startDate,
			Date endDate, int type) throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "Select consignment from TurqConsignment as consignment where" + //$NON-NLS-1$
					" consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
					" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$
					" and consignment.consignmentsType =" + type + //$NON-NLS-1$
					" and consignment.consignmentsId <> -1 "; //$NON-NLS-1$

			if (curCard != null) {
				query += " and consignment.turqBillConsignmentCommon.turqCurrentCard = :curCard"; //$NON-NLS-1$
			}
			query += " and consignment.turqBillConsignmentCommon.turqBills.size=0"; //$NON-NLS-1$
			query += " order by consignment.consignmentsDate"; //$NON-NLS-1$

			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$

			if (curCard != null) {
				q.setParameter("curCard", curCard); //$NON-NLS-1$
			}

			List list = q.list();

			TurqConsignment cons;
			for (int i = 0; i < list.size(); i++) {

				cons = (TurqConsignment) list.get(i);
				Hibernate.initialize(cons.getTurqConsignmentsInGroups());
				Hibernate.initialize(cons.getTurqEngineSequence()
						.getTurqInventoryTransactions());

			}

			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}

}