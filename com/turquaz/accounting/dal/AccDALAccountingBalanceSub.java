/*
 * Created on 25.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

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
/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccDALAccountingBalanceSub {
	public AccDALAccountingBalanceSub()
	{
	
	}
	
	public List getTransactionColumns(int type, Object startDate, Object endDate)throws Exception{
		
		try{
			Session session = EngDALSessionFactory.openSession();			
			/*String query = "Select transcolumns.dept_amount, " +
			"transcolumns.credit_amount, transcolumns.accounting_accounts_id," +
			" transcolumns.accounting_transactions_id, trans.accounting_transactions_id," +
			"accounts.accounting_accounts_id, accounts.parent_account, " +
			"accounts.account_code, accounts.account_name, accounts.companies_id," +
			" trans.transactions_date from turq_accounting_accounts accounts," +
			" turq_accounting_transactions trans, turq_accounting_transaction_columns" +
			" transcolumns where transcolumns.accounting_accounts_id=accounts.accounting_accounts_id" +
			" and transcolumns.accounting_transactions_id=trans.accounting_transactions_id" +
			" ORDER BY accounts.accounting_accounts_id";*/
			
			String query="Select transColumn from TurqAccountingTransactionColumn as transColumn" +
					" where transColumn.turqAccountingTransaction.transactionsDate >= :startDate" +
					" and transColumn.turqAccountingTransaction.transactionsDate <= :endDate";
			if (type!=-1)
				query+=" and transColumn.turqAccountingTransaction.turqAccountingTransactionType.accountingTransactionTypesId ="+type;
			Query q = session.createQuery(query); 
			q.setParameter("endDate",endDate);
			q.setParameter("startDate",startDate);
			
			List list = q.list();
			session.close();			
			return list;			
		}
		
		catch(Exception ex){
			throw ex;
			
		}
	}
	public List getAccounts()throws Exception{
		
		try{
			Session session = EngDALSessionFactory.openSession();			
			String query = "Select * from turq_accounting_accounts ORDER BY accounting_accounts_id";
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
