/*
 * Created on 15.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.dal;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankDALBankCardSearch {
	
	public BankDALBankCardSearch(){
	
	}
	
	public List searchBankCards(String bankName, String bankBranchName, String bankAccountNo)
	throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		
		String query = "Select bankCard from TurqBanksCard as bankCard where" +
				" bankCard.turqCompany.companiesId ="+System.getProperty("company")+
		" and bankCard.bankName like '"+bankName+"%' and bankCard.bankBranchName like '"+bankBranchName+"%' "+
		" and bankCard.bankAccountNo like '"+bankAccountNo+"%'";
		
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