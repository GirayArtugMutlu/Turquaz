
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
		Transaction tx=null;
		try{
		Session session = EngDALSessionFactory.openSession();
		tx = session.beginTransaction();
		session.saveOrUpdate(account);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			if (tx != null)
				tx.rollback();
			throw ex;
		}
	}
	public List getAccounts(int parentid, String codeCriteria)throws Exception{
		
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqAccountingAccount as accounts " +
					"where  accounts.turqAccountingAccountByParentAccount.id ="+parentid+"" +
							" and accounts.accountCode like '"+codeCriteria+"%'" +
							" and accounts.id <> -1" +
							" order by accounts.id";   

			Query q = session.createQuery(query); 
			
			List list = q.list();
		
			session.close();
			return list;
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public static TurqAccountingAccount getAccount(String code)throws Exception{
		try{
			Session session =  EngDALSessionFactory.openSession();
	
			String query = "from TurqAccountingAccount as accounts " +
					"where accounts.accountCode ='"+code+"'" +
							" and accounts.id <> -1";
						

			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			
			if(list.size()>0){
				return (TurqAccountingAccount)list.get(0); 
			}
			else
				return null;
			
			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public List getAllAccounts()throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
	
			String query = "from TurqAccountingAccount as accounts " +
					
					// was removing accounting plan	
					//	" and accounts.accountingAccountsId <> -1" +
							" order by accounts.id";   

			Query q = session.createQuery(query); 
			List list = q.list();

			session.close();
			return list;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public static List getAllAccountsWithSum()throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
	
			String query = "Select account, accView from" +
					" TurqAccountingAccount account, TurqViewAccTotal accView" +
					" where account.id=accView.accountingAccountsId" + 
					" order by account.id";
			//includes "accounting plan" id=-1

			Query q = session.createQuery(query); 
			List list = q.list();

			session.close();
			return list;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	
	public static List getAccountsForAccountPickers()throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqAccountingAccount as accounts " +
					"where accounts.id <> -1" +
					" and accounts.turqAccountingAccountsByParentAccount.size=0" +
					
					" order by accounts.accountCode";   

			Query q = session.createQuery(query); 
			List list = q.list();
	
			session.close();
			return list;
			 
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	
	public static List getAllAccountsForAccountPickerAll()throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
		
			String query = "Select account from TurqAccountingAccount as account " +
					"where account.id<> -1" +
					//" and account.turqAccountingAccountsByParentAccount.accountingAccountsId=-1" +
					
					" order by account.accountCode";   

			Query q = session.createQuery(query); 
			List list = q.list();
	
			session.close();
			return list;
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	public TurqAccountingAccount getLeafAccount(String code)throws Exception{
		try{
			Session session =  EngDALSessionFactory.openSession();
	
			String query = "from TurqAccountingAccount as accounts " +
					"where accounts.accountCode ='"+code+"'" +
							" and accounts.id <> -1" +
							" and accounts.turqAccountingAccountsByParentAccount.size=0";
						

			Query q = session.createQuery(query); 
			List list = q.list();
	
			session.close();
			if(list.size()>0){
				return (TurqAccountingAccount)list.get(0); 
			}
			else
				return null;			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public static TurqAccountingAccount getAllAccounts(String code)throws Exception{
		try{
			Session session =  EngDALSessionFactory.openSession();
	
			String query = "Select account from TurqAccountingAccount as account " +
					"where account.accountCode ='"+code+"'" +
							" and account.id <> -1";
						

			Query q = session.createQuery(query); 
			List list = q.list();
	
			session.close();
			if(list.size()>0){
				return (TurqAccountingAccount)list.get(0); 
			}
			else
				return null;			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public List getCashAccounts()throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
		
			String query = "Select accounts.accountCode, accounts.accountName from TurqAccountingAccount as accounts " +
					"where accounts.id <> -1" +
					" and accounts.turqAccountingAccountsByParentAccount.size=0" +
					" and accounts.accountCode like '100%'" +
					" order by accounts.accountCode";   

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
