
package com.turquaz.admin.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;


public class AdmDALGroupUpdate {
	public AdmDALGroupUpdate() {

	}
	public void updateObject(Object obj)throws Exception {
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
	public void deleteObject(Object obj)throws Exception {
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
}
