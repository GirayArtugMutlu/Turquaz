/*
 * Created on 20.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurDALCurrentCardAdd {
	
	public CurDALCurrentCardAdd(){
	}
	
	public void saveObject(Object obj)throws Exception {
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
	public void deleteObject(Object obj)throws Exception{
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
	public List getCurrentGroups() throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String query = "from TurqCurrentGroup as curGroup " +
				"where curGroup.turqCompany.companiesId ="+System.getProperty("company");		   
		Query q = session.createQuery(query); 
		List list = q.list();
		tx.commit();
		session.close();
		return list;
				
	}
	catch (Exception ex){
		throw ex;
	}
	
	}
	public boolean isCurrentCodePresent(String code)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqCurrentCard as curCard " +
					"where curCard.turqCompany.companiesId ="+System.getProperty("company")+
					" and curCard.cardsCurrentCode ='"+code+"'" ;		   
			Query q = session.createQuery(query); 
			List list = q.list();
			tx.commit();
			session.close();
			if(list.size()>0){
				return true;
			}
			return false;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public boolean isCurrentNamePresent(String code)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqCurrentCard as curCard " +
					"where curCard.turqCompany.companiesId ="+System.getProperty("company")+
					" and curCard.cardsName ='"+code+"'" ;		   
			Query q = session.createQuery(query); 
			List list = q.list();
			tx.commit();
			session.close();
			if(list.size()>0){
				return true;
			}
			return false;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
