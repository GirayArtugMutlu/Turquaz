
package com.turquaz.consignment.bl;
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
import java.util.Calendar;
import java.util.List;

import com.turquaz.consignment.dal.ConDALAddGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqConsignmentGroup;


public class ConBLAddGroups {
	Calendar cal = Calendar.getInstance();
	ConDALAddGroups dalAddGroups = new ConDALAddGroups();
	public ConBLAddGroups(){
		
	}
	
	public List getConsignmentGroups()throws Exception {
		try{
			return dalAddGroups.getConsignmentGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	public void saveGroup(String name, String description)throws Exception{
		try{
		TurqConsignmentGroup group = new TurqConsignmentGroup();
		group.setGroupsDescription(description);
		group.setGroupsName(name);
		
		group.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		
		EngDALCommon.saveObject(group);	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void updateGroup(String name, String description,TurqConsignmentGroup group)throws Exception{
		try{

		group.setGroupsDescription(description);
		group.setGroupsName(name);
	
		group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	
		EngDALCommon.updateObject(group);	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void deleteGroup(TurqConsignmentGroup group)throws Exception{
		try{

	
			EngDALCommon.deleteObject(group);	

		
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
