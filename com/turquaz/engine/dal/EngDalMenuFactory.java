
package com.turquaz.engine.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;


public class EngDalMenuFactory {

	public static List getAllMenu() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			String query = "select menu from TurqEngineMenu as menu order by parent_id, order by menu_type where id > -1" ;
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
	
		catch (Exception e)
		{
			throw e;
		}
	}
}
