
package com.turquaz.engine.dal;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;


public class EngDALCommon {
	
	public EngDALCommon()
	{
	
	}
	
	public List getCurrencies()throws Exception{
		try{
			
			Session session = EngDALSessionFactory.openSession();
	
			String query = "from TurqCurrency as currency ";		   
			   

			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;	
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public List getTurqCurrentGroups() throws Exception {
		try{
			
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqCurrentGroup as gr ";	
			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public boolean checkUserPass(String username, String pass)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqUser as user " +
					"where user.username ='"+username+"' and" +
					" user.usersPassword ='"+pass+"'";
			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			
			if(list.size()==1){
				return true;
			}
			else{
				return false;
			}
	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getGroups()throws Exception {
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqGroup as group";
			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getInventoryWarehouses()throws Exception {
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqInventoryWarehous as wh" ;	
			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getUsers()throws Exception {
		try{
			
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqUser as group";
			Query q = session.createQuery(query); 
			List list = q.list();
			
			for (int i =0;i<list.size();i++){
				
			TurqUser invCard = (TurqUser)list.get(i);
			Hibernate.initialize(invCard.getTurqUserGroups());
		    Hibernate.initialize(invCard.getTurqUserPermissions());
			
			}
			session.close();
			return list;
			
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


}
