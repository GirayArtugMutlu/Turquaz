/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.dal;

import java.util.List;


import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;


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
