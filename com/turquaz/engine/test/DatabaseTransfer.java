
package com.turquaz.engine.test;

import java.sql.ResultSet;

import com.turquaz.engine.dal.EngDALConnection;

public class DatabaseTransfer {
	
	public static void  main(String [] args)
	{
		EngDALConnection conn1 = new EngDALConnection("Postgresql","turquaz","","kulup.sabanciuniv.edu","turquaz_turkish_20041206");
		EngDALConnection conn2 = new EngDALConnection("Postgresql","turquaz","","kulup.sabanciuniv.edu","turquaz_turkish");
		
		ResultSet first ;
		try{
		conn1.connect();
		conn2.connect();
		String query1 = "select * from turq_accounting_accounts order by accounting_accounts_id";
		first = conn1.getResultSet(query1);
		first.next();
		while(first.next())
		{
			String query2 = "insert into turq_accounting_accounts values ("+first.getString(1)+", '"+ first.getString(3) +" ','"+   first.getString(4) +" ',"+ first.getString(5)+
			" ,"+first.getString(10)  +", 'admin','2004-12-05'	,'admin',	'2004-12-05'	" +  ")";
			System.out.println(query2);
			
			conn2.execQuery(query2);
		}
		
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
