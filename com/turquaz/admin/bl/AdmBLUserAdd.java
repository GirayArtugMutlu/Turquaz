
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

import com.turquaz.admin.dal.AdmDALUserAdd;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

public class AdmBLUserAdd {
	
	private EngDALCommon dalCommon = new EngDALCommon();
	private AdmDALUserAdd dalAdmin = new AdmDALUserAdd();
	Calendar cal = Calendar.getInstance();
	public AdmBLUserAdd(){
		
	}
	
	
	public Integer saveUser(String username, String password, String realname, String description)throws Exception{
		try{
		
			TurqUser user = new TurqUser();
			user.setUsername(username);
			user.setUsersPassword(password);
			user.setUsersRealName(realname);
			user.setUsersDescription(description);
			

			user.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			user.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		    user.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			user.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalAdmin.saveObject(user);
			
			return user.getId();
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public void saveUserGroups(Integer userId, Object group)throws Exception {
		try{
		
			TurqUser user = new TurqUser();
			user.setId(userId);
			TurqUserGroup usergroup = new TurqUserGroup();
			usergroup.setTurqUser(user);
			usergroup.setTurqGroup((TurqGroup)group);
			
			usergroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			usergroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		    usergroup.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			usergroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalAdmin.saveObject(usergroup);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getGroups()throws Exception{
		try{
			
			return dalCommon.getGroups();
			
			
			
		}
		catch (Exception ex){
			throw ex;
		}
		
	}

}
