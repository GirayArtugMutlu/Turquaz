
package com.turquaz.consignment.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.engine.dal.EngDALSessionFactory;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConDALAddGroups {
	public ConDALAddGroups(){
		
	}
	public void save(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void update(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void delete(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getConsignmentGroups()throws Exception{
		try{
			
			
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqConsignmentGroup as gr " + //$NON-NLS-1$
					"where gr.turqCompany.companiesId ="+System.getProperty("company");	 //$NON-NLS-1$ //$NON-NLS-2$
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
