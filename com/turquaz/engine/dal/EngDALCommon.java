
package com.turquaz.engine.dal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;


public class EngDALCommon {
	
	public EngDALCommon()
	{
	
	}
	
	public static List getCurrencies()throws Exception{
		try{
			
			Session session = EngDALSessionFactory.openSession();
	
			String query = "from TurqCurrency as currency where currency.id=1 ";		   
			   

			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;	
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public static TurqCurrencyExchangeRate getCurrencyExchangeRate(TurqCurrency baseCurrency, TurqCurrency exchangeCurrency, Date exchangeDate)
	throws Exception
	{

		try 
		{
			Session session = EngDALSessionFactory.openSession();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			String query = "select exchangeRate from TurqCurrencyExchangeRate as exchangeRate" +
					" where exchangeRate.turqCurrencyByBaseCurrencyId= :baseCurrency" +
					" and exchangeRate.turqCurrencyByExchangeCurrencyId= :exchangeCurrency" +
					" and exchangeRate.exhangeRatesDate ='"+df.format(exchangeDate)+"'";
			Query q = session.createQuery(query);
			
			q.setParameter("baseCurrency",baseCurrency);
			q.setParameter("exchangeCurrency",exchangeCurrency);
			List list = q.list();
			session.close();
			
			if (list.size()==0)
				return null;
			else
				return (TurqCurrencyExchangeRate)list.get(0);

		} catch (Exception ex) {
			throw ex;

		}
	}
	
	
	public static boolean checkUserPass(String username, String pass)throws Exception{
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
	public static List getGroups()throws Exception {
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
	public static List getUsers()throws Exception {
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
	
	public static void deleteObject(Object obj)throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(obj);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public static void deleteObject(Session session,Object obj)throws Exception
	{
		session.delete(obj);
	}
	
	public static void updateObject(Object obj)throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public static void updateObject(Session session,Object obj)throws Exception
	{
		session.update(obj);
	}
	
	public static void saveObject(Object obj)throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		session.flush();
		tx.commit();
		session.close();
	}
	
	public static void saveObject(Session session,Object obj)throws Exception
	{
		session.save(obj);
	}
}
