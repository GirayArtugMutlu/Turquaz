/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvDALWarehouseAdd {
	public InvDALWarehouseAdd()
	{
			
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
	
	
	
	
	

}
