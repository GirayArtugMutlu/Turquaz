
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

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class InvDALCardUpdate {
	public InvDALCardUpdate() {

	}

	public static void updateObject(Session session, Object obj) throws Exception {
		try
		{
			session.update(obj);

		}
		catch (Exception ex)
		{
			throw ex;
		}

	}

	public static void deleteObject(Session session, Object obj) throws Exception {
		try 
		{
			session.delete(obj);
		} 
		catch (Exception ex)
		{
			throw ex;
		}

	}

	public boolean hasTransactions(TurqInventoryCard card) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();

			String query = "Select transactions from TurqInventoryTransaction as transactions "
					+ "where transactions.turqInventoryCard = :invCard ";

			Query q = session.createQuery(query);
			q.setParameter("invCard", card);

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