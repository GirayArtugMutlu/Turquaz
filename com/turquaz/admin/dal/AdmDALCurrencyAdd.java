/*
 * Created on Feb 28, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author Cem
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmDALCurrencyAdd {
	
	public static void saveObject(Object obj) throws Exception {
		Transaction tx=null;
		try {

			Session session = EngDALSessionFactory.openSession();
			tx = session.beginTransaction();

			session.save(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {
			if (tx !=null)
				tx.rollback();
			throw ex;

		}
	}

}
