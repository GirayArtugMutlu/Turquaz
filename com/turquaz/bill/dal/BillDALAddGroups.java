package com.turquaz.bill.dal;

import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;

public class BillDALAddGroups
{
	public BillDALAddGroups()
	{
	}

	public static List getBillGroups() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
			String query = "from TurqBillGroup as gr ";
			Query q = session.createQuery(query);
			List list = q.list();
			session.close();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}