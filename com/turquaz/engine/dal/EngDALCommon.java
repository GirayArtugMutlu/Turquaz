/*
 * Created on 16.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.dal;

import java.util.List;

import net.sf.hibernate.Hibernate;
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
	
	public List getTurqCurrentGroups() throws Exception {
		try{
			
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqCurrentGroup as gr " +
					"where gr.turqCompany.companiesId ="+System.getProperty("company");	
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
	public boolean checkUserPass(String username, String pass)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqUser as user " +
					"where user.username ='"+username+"' and" +
					" user.usersPassword ='"+pass+"'";
			Query q = session.createQuery(query); 
			List list = q.list();
			tx.commit();
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
			Transaction tx = session.beginTransaction();
			String query = "from TurqGroup as group";
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
	public List getUsers()throws Exception {
		try{
			
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqUser as group";
			Query q = session.createQuery(query); 
			List list = q.list();
			
			for (int i =0;i<list.size();i++){
				
			TurqUser invCard = (TurqUser)list.get(i);
			Hibernate.initialize(invCard.getTurqUserGroups());
		
			
			}
			tx.commit();
			session.close();
			return list;
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
