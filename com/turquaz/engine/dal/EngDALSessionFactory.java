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
package com.turquaz.engine.dal;

import java.util.Properties;
import org.eclipse.core.internal.preferences.Base64;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.bl.EngBLLogger;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * @author onsel
 * @version $Id$ Class for initial database configuration. It creates the
 *          necessary bindings according to hibernate.cfg.xml Initiliaze the static SessionFactory object
 */
public class EngDALSessionFactory
{
	static EngDALSessionFactory _instance;
	public SessionFactory factory;
	Configuration cfg;
	static Session session = null;

	/**
	 * Default Constructor
	 */
	public EngDALSessionFactory()
	{
		Properties props = new Properties();
		try
		{
			String url = "notSet://";
			String driver = "noteSet";
			if (EngConfiguration.getString("dbType").startsWith("Turquaz"))
			{
				// url = "jdbc:hsqldb:hsql://"+EngConfiguration.getString("serverAddress")+":"+EngConfiguration.getString("serverPort");
				url = "jdbc:hsqldb:database/turquaz";
				driver = "org.hsqldb.jdbcDriver";
				props.put("hibernate.dialect", "net.sf.hibernate.dialect.HSQLDialect");
			}
			else if (EngConfiguration.getString("dbType").startsWith("Postgresql"))
			{
				url = "jdbc:postgresql://" + EngConfiguration.getString("serverAddress") + ":"
						+ EngConfiguration.getString("serverPort") + "/" + EngConfiguration.getString("dbName");
				driver = "org.postgresql.Driver";
				props.put("hibernate.dialect", "net.sf.hibernate.dialect.PostgreSQLDialect");
				props.put("hibernate.schema", "public");
			}
			String username = EngConfiguration.getString("dbUsername");
			String password = EngConfiguration.getString("dbPassword");
			password = new String(Base64.decode(password.getBytes()));
			System.setProperty("Url", url);
			System.setProperty("dbLogin", username);
			System.setProperty("dbPass", password);
			cfg = new Configuration();
			props.put("hibernate.connection.url", url);
			props.put("hibernate.connection.driver_class", driver);
			props.put("hibernate.connection.username", username);
			props.put("hibernate.connection.password", password);
			props.put("hibernate.show_sql", "false");
			cfg = cfg.configure();
			cfg.addProperties(props);
			factory = cfg.buildSessionFactory();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/**
	 * @return SessionFactory objects for opening Hibernate Sessions
	 */
	public static synchronized SessionFactory getSessionFactory()
	{
		if (_instance == null)
		{
			_instance = new EngDALSessionFactory();
		}
		return _instance.factory;
	}

	/**
	 * @return SessionFactory objects for opening Hibernate Sessions
	 */
	public static synchronized Configuration getConfiguration()
	{
		if (_instance == null)
		{
			_instance = new EngDALSessionFactory();
		}
		return _instance.cfg;
	}

	/**
	 * @return Session object whisch is created by the static SessionFactory
	 * @throws Exception
	 */
	public static synchronized Session openSession() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngDALSessionFactory();
			}
			
			session = _instance.factory.openSession();
			session.clear();
			return session;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static Session getSession() throws Exception
	{
		try{
			
			return session;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * initialize the static EngDALSessionFactory
	 */
	public static synchronized void init()
	{
		if (_instance == null)
		{
			_instance = new EngDALSessionFactory();
		}
	}
}