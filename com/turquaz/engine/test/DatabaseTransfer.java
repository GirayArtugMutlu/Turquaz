
package com.turquaz.engine.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;

import com.turquaz.engine.dal.EngDALConnection;

public class DatabaseTransfer {
	
	public static void  main(String [] args)
	{
	//	EngDALConnection conn1 = new EngDALConnection("Postgresql","turquaz","","kulup.sabanciuniv.edu","turquaz_turkish_20041206");
		EngDALConnection conn2 = new EngDALConnection("Postgresql","turquaz","","kulup.sabanciuniv.edu","turquaz");
		
		ResultSet first ;
		try{
		    
		    conn2.connect();
		    FileInputStream fstream = new FileInputStream("insert.sql");
            // Convert our input stream to a
            // DataInputStream
		    DataInputStream in = new DataInputStream(fstream);

		    BufferedReader d = new BufferedReader(new InputStreamReader(in));
String sql ="";
// Continue to read lines while
// there are still some left to read
while (in.available() !=0){

sql = d.readLine();
sql +=";";
try{
    conn2.execQuery(sql);
    
}
catch(Exception ex){
    
}

}
		    
		    
		    
/*
		
		String query1 = "select * from turq_accounting_accounts order by accounting_accounts_id";
		first = conn1.getResultSet(query1);
		first.next();
		while(first.next())
		{
			String query2 = "insert into turq_accounting_accounts values ("+first.getString(1)+", '"+ first.getString(3) +" ','"+   first.getString(4) +"',"+ first.getString(5)+
			" ,"+first.getString(10)  +", 'admin','2004-12-05'	,'admin',	'2004-12-05'	" +  ")";
			System.out.println(query2);
			
			conn2.execQuery(query2);
		}
		
		*/
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
