/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccDALAccountAdd {
	
	public void saveOrUpdateAccount(TurqAccountingAccount account)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(account);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
