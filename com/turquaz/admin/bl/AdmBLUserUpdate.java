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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import com.turquaz.admin.AdmKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;

public class AdmBLUserUpdate
{
	public static void updateUser(HashMap argMap) throws Exception
	{
		try
		{
			String password=(String)argMap.get(AdmKeys.ADM_PASSWORD);
			String realname=(String)argMap.get(AdmKeys.ADM_REALNAME);
			String description=(String)argMap.get(EngKeys.DESCRIPTION);
			TurqUser user=(TurqUser)argMap.get(AdmKeys.ADM_USER);
			List userGroups=(List)argMap.get(AdmKeys.ADM_USER_GROUPS);
			
			Calendar cal = Calendar.getInstance();
			user.setUsersPassword(password);
			user.setUsersRealName(realname);
			user.setUsersDescription(description);
			user.setUpdateDate(cal.getTime());
			user.setUpdatedBy(System.getProperty("user"));
			EngDALCommon.updateObject(user);
			updateUserGroups(user,userGroups);
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static void updateGroup(HashMap argMap) throws Exception
	{
		try
		{
		
			String realname=(String)argMap.get(AdmKeys.ADM_GROUP_NAME);
			String description=(String)argMap.get(AdmKeys.ADM_GROUP_DESCRIPTION);
			TurqGroup group=(TurqGroup)argMap.get(AdmKeys.ADM_GROUP);
			List userGroups=(List)argMap.get(AdmKeys.ADM_USER_GROUPS);
			
			Calendar cal = Calendar.getInstance();
			
			group.setGroupsName(realname);
			group.setGroupsDescription(description);
			group.setUpdateDate(cal.getTime());
			group.setUpdatedBy(System.getProperty("user"));
			EngDALCommon.updateObject(group);
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	
	private static void updateUserGroups(TurqUser user, List userGroups)throws Exception
	{
		AdmBLUsers.deleteUserGroups(user);
		AdmBLUserAdd.saveUserGroups(user.getId(),userGroups);		
	}
}