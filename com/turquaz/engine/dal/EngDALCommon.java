/*
 * Created on 16.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngDALCommon {
	
	public EngDALCommon()
	{
	
	}
	
	public List getCurrencies()throws Exception{
		try{
			
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqCurrency as currency " +
					"where currency.turqCompany.companiesId ="+System.getProperty("company");		   
			   

			Query q = session.createQuery(query); 
			List list = q.list();
			tx.commit();
			session.close();
			return list;	
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
