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

/**
 * @author Onsel Armagan
 * @version $Id$
 */

import java.sql.Connection;
import java.sql.DriverManager;

import org.hsqldb.Server;

public class DatabaseThread extends Thread {

/*	public void run() {

		String[] args = { "-database", "database/turquaz", "-port",
				String.valueOf(8877), "-no_system_exit", "true" };

		Server.main(args);

		try {
			// creates a connection to the internal database
			String url = "jdbc:hsqldb:hsql://127.0.0.1:8877";
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection(url, "sa", "");
			if (con != null) {
				// needed to patch DatabaseManager so it could
				// be initialized and use the supplied connection

				org.hsqldb.util.DatabaseManager dm = new org.hsqldb.util.DatabaseManager();
				dm.main();
				dm.connect(con);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} 

	}*/

}