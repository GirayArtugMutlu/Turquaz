/*
 * Created on 03.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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

import java.util.List;

import com.turquaz.engine.dal.EngDALUserPerms;

/**
 * @author huseyin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLGroupPermissions {

		private EngDALUserPerms dalGroupPerms = new EngDALUserPerms();
		public AdmBLGroupPermissions(){
			
		}
		public List getGroupPermissions()throws Exception{
		try{
			
			return dalGroupPerms.getGroupPermissions();
			
		}
		catch(Exception ex){
			throw ex;
		}
		}
		public List getModuleComponents(int moduleId)throws Exception{
			try{
				
				return dalGroupPerms.getModuleComponents(moduleId);
				
			}
			catch(Exception ex){
				throw ex;
			}
		}
		public List getModules()throws Exception {
			try{
				
				return dalGroupPerms.getModules();
				
			}
			catch(Exception ex){
				throw ex;
			}
		}

	
}
