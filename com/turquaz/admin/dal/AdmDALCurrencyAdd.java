/*
 * Created on Feb 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmDALCurrencyAdd {
	
	public static void saveObject(Object obj) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {

			throw ex;

		}
	}

}
