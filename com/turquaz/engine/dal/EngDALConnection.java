
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
import java.sql.*;

/**
* @author  Onsel Armagan
* @version  $Id$
*/

public class EngDALConnection {
  private String driver, loginUrl, loginUser, loginPass;
  private Connection con;
  private Statement stmt;

  public EngDALConnection() {
	loginUrl = "jdbc:mysql://" + System.getProperty("Url") + "/"+System.getProperty("dbName");
	loginUser = System.getProperty("dbLogin");
	loginPass = System.getProperty("dbPass");
  }

  public EngDALConnection(String userName, String pass, String Url, String dbName) {
	loginUrl = "jdbc:mysql://" +Url + "/"+dbName;
   // loginUrl = "jdbc:postgresql://" + Url + "/turquaz";
   // loginUrl = "jdbc:mysql://10.90.19.52/turquaz";
	loginUser = userName;
	loginPass = pass;


  }

  public void connect() throws Exception {
	try {
	   driver = "com.mysql.jdbc.Driver";
	 // loginUrl = "jdbc:mysql://10.90.19.52/turquaz";
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

  public Connection getCon() {
	return this.con;
  }

}
