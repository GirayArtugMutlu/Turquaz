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

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * @author onsel
 *
 * @version $Id$
 * 
 * Class for initial database configuration. It creates the necessary
 * bindings according to hibernate.cfg.xml
 * Initiliaze the static SessionFactory object
 * 
 */
public class EngDALSessionFactory {
	static EngDALSessionFactory _instance;
	public SessionFactory factory;
	
	/**
	 * Default Constructor
	 *
	 */
	public EngDALSessionFactory(){
		try{
		Configuration cfg =new Configuration();
		factory = cfg.configure().buildSessionFactory();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	/**
	 * 
	 * @return SessionFactory objects for opening Hibernate Sessions
	 */
	public static synchronized SessionFactory getSessionFactory(){
		if (_instance == null) {

			_instance = new EngDALSessionFactory();

		}

		return _instance.factory;
	}
	/**
	 * 
	 * @return Session object whisch is created by the static SessionFactory
	 * @throws Exception
	 */
	public static synchronized Session openSession() throws Exception{
		try{
		if (_instance == null) {

			_instance = new EngDALSessionFactory();

		}

		return _instance.factory.openSession();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	/**
	 * initialize the static EngDALSessionFactory
	 *
	 */
	public static synchronized void init() {
		if (_instance == null) {

			_instance = new EngDALSessionFactory();

		}
	}


}
