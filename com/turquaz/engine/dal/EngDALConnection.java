
package com.turquaz.engine.dal;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.sql.*;

/**
* @author  Onsel Armagan
* @version  $Id$
* 
* Class for initial database configuration. It creates the necessary
* bindings according to hibernate.cfg.xml
* 
*/

public class EngDALConnection {
  private String driver, loginUrl, loginUser, loginPass;
  private Connection con;
  private Statement stmt;

  public EngDALConnection() {
	loginUrl =  System.getProperty("Url");
	loginUser = System.getProperty("dbLogin");
	loginPass = System.getProperty("dbPass");
	driver = "org.postgresql.Driver";
  }
  
  public EngDALConnection(String dbType, String userName, String pass, String Url) {

  	if (dbType.startsWith("Turquaz"))
  	{ 
  	
  	driver = "org.hsqldb.jdbcDriver";
  	 loginUrl = "jdbc:hsqldb:hsql://" +Url ;
     //loginUrl = "jdbc:postgresql://" + Url + "/";
     // loginUrl = "jdbc:mysql://10.90.19.52/turquaz";
	 loginUser = userName;
	 loginPass = pass;
	 
  	}
  else if (dbType.startsWith("Postgresql")) {
  		
  	driver = "org.postgresql.Driver";
  	String dbName = "template1";
  	 loginUrl = "jdbc:postgresql://" +Url + "/"+dbName;
     //loginUrl = "jdbc:postgresql://" + Url + "/";
     // loginUrl = "jdbc:mysql://10.90.19.52/turquaz";
	 loginUser = userName;
	 loginPass = pass;
 
	 
  }   
    

  }

  public void connect() throws Exception {
	try {
	   
	  Class.forName(driver);
	  con = DriverManager.getConnection(loginUrl, loginUser, loginPass);
	  stmt = con.createStatement();
	}
	catch (SQLException ec) {
	  throw ec;
	}
	catch (ClassNotFoundException ex) {
	  System.err.println("Cannot find driver.");
	  throw ex;
	}
  }

 
  public ResultSet execute_stored_procedure(CallableStatement cs) throws
	  Exception {
	try {
	  boolean result = cs.execute();
	  if (result) {
		return cs.getResultSet();
	  }
	  return null;
	}
	catch (SQLException ec) {
	  throw ec;
	}
  }

  public ResultSet getResultSet(String query) throws Exception {
	try {

	  ResultSet rs = stmt.executeQuery(query);
	  return rs;
	}

	catch (SQLException ec) {
	  throw ec;
	}
  }

  public void execQuery(String query) throws Exception {

	try {
	  stmt.execute(query);
	}

	catch (SQLException ec) {
	  throw ec;
	}

  }

  public void closeConnection() throws Exception {
	try {
	  con.close();
	}
	catch (SQLException ec) {
	  throw ec;
	}
  }
  
  public void createTables()throws Exception{
  try{
  	stmt.execute(getGetCreateScript());
  	String sql="";
    // Open the file that is the first
    // command line parameter
   FileInputStream fstream = new FileInputStream("sql/seq.sql");
                              // Convert our input stream to a
                              // DataInputStream
   DataInputStream in = new DataInputStream(fstream);

    // Continue to read lines while
    // there are still some left to read
    while (in.available() !=0){
   
    	sql = in.readLine();
    	if(sql.trim().startsWith("SELECT"));{
    	    stmt.execute(sql);
    	}
     
    }
    in.close();
    
   
     

  	
  	
  }
  catch(Exception ex){
  	throw ex;
  }
  
  }

  public Connection getCon() {
	return this.con;
  }
  
  
  private String getGetCreateScript()throws Exception{

    try
    {
      String sql="";
      // Open the file that is the first
      // command line parameter
     FileInputStream fstream = new FileInputStream("sql/turquaz.sql");
                                // Convert our input stream to a
                                // DataInputStream
     DataInputStream in = new DataInputStream(fstream);

      // Continue to read lines while
      // there are still some left to read
      while (in.available() !=0){
     
      	sql = sql + in.readLine()+ "\n";
       
      }
      in.close();
      
      return sql;
      
        }
           catch (Exception ex)
              {
                  throw ex;
              }
  }


}
