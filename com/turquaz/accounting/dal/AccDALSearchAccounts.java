package com.turquaz.accounting.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqViewAccTotal;

public class AccDALSearchAccounts {

	/**
	 * @param args
	 */
	public static List searchAccounts(String accCode, String accName) throws Exception{
		
		TurqViewAccTotal accView=null;
		
		Session session = EngDALSessionFactory.getSession();
		String query ="select account.accountCode,account.accountName,accView from TurqAccountingAccount as account,TurqViewAccTotal as accView where account.accountCode like '"+accCode+"%'" +
				" and account.accountName like '"+accName+"%' and accView.accountingAccountsId = account.id and account.id <>-1";
		Query q = session.createQuery(query);
 
    
		List list = q.list();
	
		return list;
	}
	
	public static Integer getAccountIdByAccountCode(String accountCode) throws Exception
	{		
		Session session = EngDALSessionFactory.getSession();
		String query ="select account.id from TurqAccountingAccount as account where account.accountCode="+accountCode;
		Query q = session.createQuery(query);    
		List list = q.list();
		if (list.size() > 0)
			return (Integer)list.get(0);
		else 
			return null;
	}
	
	public static String getAccountCodeById(Integer accId) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		String query ="select account.accountCode from TurqAccountingAccount as account where account.id="+accId.intValue();
		Query q = session.createQuery(query);    
		List list = q.list();
		if (list.size() > 0)
			return (String)list.get(0);
		else
			return "";
		
	}
	
	

}
