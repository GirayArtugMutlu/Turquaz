package com.turquaz.bill.dal;

import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;



public class BillDALAddBill
{
	public static boolean existBillNo(String billNo, Integer curCardId, int type, Integer billId) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		String query = "Select bill.billDocumentNo from TurqBill bill where" +
				" bill.billDocumentNo= '"+billNo+"' and bill.turqCurrentCard.id="+curCardId.intValue()+
				" and bill.billsType="+type;
		if (billId != null)
		{
			query += " and bill.id <> "+billId.intValue();
		}
		Query q = session.createQuery(query);
		List list = q.list();
		if (list.size() == 0)
		{
			return false;
		}
		else
			return true;
	}
	
	public static boolean existBillNo(String billNo, int type, Integer billId) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		String query = "Select bill.billDocumentNo from TurqBill bill where" +
				" bill.billDocumentNo= '"+billNo+"' and bill.billsType="+type;
		if (billId != null)
		{
			query += " and bill.id <> "+billId.intValue();
		}
		Query q = session.createQuery(query);
		List list = q.list();
		if (list.size() == 0)
		{
			return false;
		}
		else
			return true;
	}
	
	
}