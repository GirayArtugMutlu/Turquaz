
package com.turquaz.engine.dal;



import java.sql.Connection;
import java.sql.DriverManager;

import org.hsqldb.Server;

public class DatabaseThread extends Thread {
        
    public void run() {
        
        String[] args = { "-database", "database/turquaz",
            "-port", String.valueOf(8877),
            "-no_system_exit", "true" };
       
   //Server.main(args);
        
      /*
        try{
        // creates a connection to the internal database 
        String url = "jdbc:hsqldb:hsql://127.0.0.1:8877" ;
        Class.forName("org.hsqldb.jdbcDriver");
        Connection con = DriverManager.getConnection(url,"sa",
            "");
        if (con != null) {
            // needed to patch DatabaseManager so it could
            // be initialized and use the supplied connection 
         
        	org.hsqldb.util.DatabaseManager dm = new org.hsqldb.util.DatabaseManager();
            dm.main();
            dm.connect(con);
        }   
        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        */
        
    }

}
