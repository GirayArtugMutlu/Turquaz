
package com.turquaz.consignment.dal;
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


import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;


public class ConDALUpdateConsignment {

	public ConDALUpdateConsignment(){
		
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
		Transaction tx = null;
		try{
		Session session = EngDALSessionFactory.openSession();
		 tx = session.beginTransaction();
		session.update(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			if(tx!=null)
			{
				tx.rollback();
			}
			throw ex;
		}
	}
	public void updateConsignment(TurqConsignment obj)throws Exception{
		Transaction tx = null;
		try{
			
			Session session = EngDALSessionFactory.openSession();
			 tx = session.beginTransaction();
			session.update(obj);
			session.flush();
			tx.commit();
			session.close();
			
			}
			catch(Exception ex){
				if(tx!=null)
				{
					tx.rollback();
				}
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
	public void initiliazeConsignment(TurqConsignment cons)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
		
			
			session.refresh(cons);
			Hibernate.initialize(cons.getTurqEngineSequence()
					.getTurqInventoryTransactions());
			Hibernate.initialize(cons.getTurqBillConsignmentCommon()
					.getTurqBills());
			Hibernate.initialize(cons.getTurqConsignmentsInGroups());
			
			
			session.close();
			
			}
			catch(Exception ex){
				throw ex;
			}
	    
	    
	}
	
}
