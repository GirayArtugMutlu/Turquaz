
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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryWarehous;

public class InvDALWarehouseUpdate {

	public void updateObject(Object obj) throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.update(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public void deleteObject(Object obj) throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.delete(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public boolean hasTransaction(TurqInventoryWarehous warehouse)
			throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "Select transactions from TurqInventoryTransaction as transactions "
					+ "where transactions.turqInventoryWarehous = :warehouse ";

			Query q = session.createQuery(query);
			q.setParameter("warehouse", warehouse);

			List list = q.list();
			session.close();

			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			throw ex;
		}
	}

}