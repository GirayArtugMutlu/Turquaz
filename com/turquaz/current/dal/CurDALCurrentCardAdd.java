
package com.turquaz.current.dal;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel Armagan
* @version  $Id$
*/
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
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
		String query = "from TurqCurrentGroup as curGroup " ;		   
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
					"where curCard.cardsCurrentCode =:code" ;		   
			Query q = session.createQuery(query); 
			q.setParameter("code",code);
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
					"where curCard.cardsName ='"+code+"'" ;		   
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
