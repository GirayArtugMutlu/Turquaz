/*
 * Created on Sep 25, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngDALSessionFactory {
	static EngDALSessionFactory _instance;
	public SessionFactory factory;
	
	public EngDALSessionFactory(){
		try{
		Configuration cfg =new Configuration();
		factory = cfg.configure().buildSessionFactory();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public static synchronized SessionFactory getSessionFactory(){
		if (_instance == null) {

			_instance = new EngDALSessionFactory();

		}

		return _instance.factory;
	}
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
	public static synchronized void init() {
		if (_instance == null) {

			_instance = new EngDALSessionFactory();

		}
	}


}
