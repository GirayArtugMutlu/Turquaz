/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.dal;

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
import com.turquaz.engine.dal.TurqAccountingAccount;


public class AccDALAccountAdd {
	
	public void saveOrUpdateAccount(TurqAccountingAccount account)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(account);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getAccounts(int parentid, String codeCriteria)throws Exception{
		
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqAccountingAccount as accounts " +
					"where accounts.turqCompany.companiesId ="+System.getProperty("company")+" and" +
							" accounts.turqAccountingAccountByParentAccount.accountingAccountsId ="+parentid+"" +
							" and accounts.accountCode like '"+codeCriteria+"%'" +
							" and accounts.accountingAccountsId <> -1" +
							" order by accounts.accountCode";   

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
	public List getAllAccounts()throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String query = "from TurqAccountingAccount as accounts " +
					"where accounts.turqCompany.companiesId ="+System.getProperty("company")+
							" and accounts.accountingAccountsId <> -1" +
							" order by accounts.accountCode";   

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
