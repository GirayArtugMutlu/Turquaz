
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
* @author  Onsel Armagan
* @version  $Id$
*/
import java.util.Calendar;
import java.util.List;

import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqGroupPermission;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/

public class AdmBLGroupPermissions {

		
		
		public AdmBLGroupPermissions(){
			
		}
		public static List getGroupPermissions()throws Exception{
		try{
			
			return EngDALUserPerms.getGroupPermissions();
			
		}
		catch(Exception ex){
			throw ex;
		}
		}
		public static List getModuleComponents(int moduleId)throws Exception{
			try{
				
				return EngDALUserPerms.getModuleComponents(moduleId);
				
			}
			catch(Exception ex){
				throw ex;
			}
		}
		public static List getModules()throws Exception {
			try{
				
				return EngDALUserPerms.getModules();
				
			}
			catch(Exception ex){
				throw ex;
			}
		}
		public static void saveGroupPermission(Object group, Object module, Object moduleComp, int level)throws Exception{
			try{
				Calendar cal = Calendar.getInstance();
				TurqGroupPermission groupPerm = new TurqGroupPermission();
				groupPerm.setTurqGroup((TurqGroup)group);
				groupPerm.setTurqModule((TurqModule)module);
				groupPerm.setTurqModuleComponent((TurqModuleComponent)moduleComp);
				groupPerm.setGroupPermissionsLevel(level);
				
				groupPerm.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
				groupPerm.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				groupPerm.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
				groupPerm.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
				
				EngDALCommon.saveObject(groupPerm);
				
				
			}
			catch(Exception ex){
				throw ex;
			}
		}
		
		public static void deleteObject(Object obj)throws Exception {
			try{
				
				EngDALCommon.deleteObject(obj);			
				
			}
			catch(Exception ex){
				throw ex;
			}
		}

	
}
