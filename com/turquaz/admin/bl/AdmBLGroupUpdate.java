
package com.turquaz.admin.bl;

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
* @author  Huseyin Ergun
* @version  $Id$
*/

import java.util.Calendar;

import com.turquaz.admin.dal.AdmDALGroupUpdate;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;

public class AdmBLGroupUpdate {
	AdmDALGroupUpdate dalAdmin = new AdmDALGroupUpdate();
	Calendar cal = Calendar.getInstance();
	public AdmBLGroupUpdate(){
		
	}
	public void updateGroup( String name, String description,TurqGroup group)throws Exception{
		try{
			
			group.setGroupsName(name);
			group.setGroupsDescription(description);;
			
			group.setUpdateDate(cal.getTime());
			group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			
			EngDALCommon.updateObject(group);
				
		}
		catch(Exception ex){
				throw ex;
		}
		
		}
	public void deleteObject(Object obj)throws Exception{
		try{
		 
			EngDALCommon.deleteObject(obj);
				
		}
		catch(Exception ex){
				throw ex;
		}
		
		}

}
