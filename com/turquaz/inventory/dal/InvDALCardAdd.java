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
 * @author onsel
 * @version $Id$
 */

package com.turquaz.inventory.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;




public class InvDALCardAdd {
	
	
	public InvDALCardAdd()
	{
			
	}

	public void saveOrUpdateInvCard(TurqInventoryCard invCard)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(invCard);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void saveOrUpdateCardGroup(TurqInventoryCardGroup cardGroup)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(cardGroup);
			session.flush();
			tx.commit();
			session.close();
			
			}
			catch(Exception ex){
				throw ex;
			}	
	}
	public void saveOrUpdateCardUnit(TurqInventoryCardUnit cardUnit)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(cardUnit);
			session.flush();
			tx.commit();
			session.close();
			
			}
			catch(Exception ex){
				throw ex;
			}	
	}
	
	public void saveInvPrice(TurqInventoryPrice price)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
						
			session.saveOrUpdate(price);
			session.flush();
			tx.commit();
			session.close();
			
			}
			catch(Exception ex){
				throw ex;
			}	
	}
	
	public void registerGroup()throws Exception{
		try{
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
			
		}
	
	public TurqCurrency getCurrency(String abbrev)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqCurrency as currency " +
			"where currency.currenciesAbbreviation ='"+abbrev+"'";		   
	   

	Query q = session.createQuery(query); 
	List list = q.list();
	tx.commit();
	session.close();
	if(list.size()==0){
		throw new Exception("No such abbreviation");
	}
	else {
		return ((TurqCurrency)list.get(0));
		
		
	}
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public List getInventoryGroups()throws Exception{
	try{
		
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String query = "from TurqInventoryGroup as invGroup " +
				"where invGroup.turqCompany.companiesId ="+System.getProperty("company");		   
		   

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
	
	public List getInventoryUnits()throws Exception{
		try{
			
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqInventoryUnit as invUnit " +
					"where invUnit.turqCompany.companiesId ="+System.getProperty("company");		   
			   

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
