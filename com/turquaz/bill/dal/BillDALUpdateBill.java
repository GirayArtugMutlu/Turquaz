package com.turquaz.bill.dal;

import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;

/**
 * @author onsel Window - Preferences - Java - Code Style - Code Templates
 */
public class BillDALUpdateBill
{
	public static void deleteAccountingTransactions(int billId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
		
			Iterator iter = session
					.iterate("select trans from TurqAccountingTransaction as trans"
							+ ", TurqBill as bill where bill.id="
							+ billId
							+ " and trans.turqEngineSequence = bill.turqEngineSequence");
			while (iter.hasNext())
			{
				TurqAccountingTransaction trans = (TurqAccountingTransaction) iter.next();
				Iterator it = trans.getTurqAccountingTransactionColumns().iterator();
				while (it.hasNext())
				{
					session.delete(it.next());
				}
				session.delete(trans);
			}
			session.flush();
		
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteCurrentTransactions(int billId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			Iterator iter = session
					.iterate("select trans from TurqCurrentTransaction as trans,"
							+ " TurqBill as bill where"
							+ " bill.id="
							+ billId
							+ " and trans.turqEngineSequence = bill.turqEngineSequence");
			while (iter.hasNext())
			{
				session.delete(iter.next());
			}
			session.flush();
		
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	

	public static Boolean canUpdateBill(Integer billId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select accTrans.id from TurqAccountingTransaction as accTrans,"
					+ " TurqBill as bill where "
					+ " accTrans.turqAccountingJournal.id <>-1"
					+ " and bill.id ="
					+ billId
					+ " and accTrans.turqEngineSequence.id=bill.turqEngineSequence.id";
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size() == 0)
			{
				return new Boolean(true);
			}
			else
				return new Boolean(false);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}