/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.dal;
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
* @author  Onsel Armagan
* @version  $Id$
*/
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmDALUserPermissions {
	public AdmDALUserPermissions(){
		
	}
	
	public void saveObject(Object obj)throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(obj);
		session.flush();
		tx.commit();
		session.close();
	}
	catch(Exception ex){
	throw ex;
	}
	}
	public void deleteObject(Object obj)throws Exception {
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.delete(obj);
			session.flush();
			tx.commit();
			session.close();
		}
		catch(Exception ex){
		throw ex;
		}
		}

}
