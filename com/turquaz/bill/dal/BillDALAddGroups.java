
package com.turquaz.bill.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;


public class BillDALAddGroups {
	public BillDALAddGroups(){
		
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
	public List getBillGroups()throws Exception{
		try{
			
			
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqBillGroup as gr ";
			Query q = session.createQuery(query); 
			List list = q.list();
	
			session.close();
			return list;	
	
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
