/*
 * Created on Sep 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
							" accounts.turqAccountingAccount.accountingAccountsId ="+parentid+"" +
							" and accounts.accountCode like '"+codeCriteria+"%'";		   
			   

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
