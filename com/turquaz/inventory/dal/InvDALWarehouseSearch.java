/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.dal;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvDALWarehouseSearch {
	public InvDALWarehouseSearch(){
		
	}
	public List searchWarehouse(String name, String city)throws Exception{
		try{
		
			Session session = EngDALSessionFactory.openSession();
			
			String query = "Select wh from TurqInventoryWarehous as wh " +
							
						   "where wh.turqCompany.companiesId ="+System.getProperty("company")+" " +
						   "and wh.warehousesName like '"+name+"%' and wh.warehousesCity like '"+city+"%' ";
			  	
			Query q = session.createQuery(query); 
					
			List list = q.list();
						
		    session.close();
		
			return list;		
			
					
		
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	
	

}