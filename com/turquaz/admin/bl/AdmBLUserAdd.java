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
import java.util.List;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;


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
public class AdmBLUserAdd
{
	public static void saveUser(String username, String password, String realname, String description, List userGroups) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqUser user = new TurqUser();
			user.setUsername(username);
			user.setUsersPassword(password);
			user.setUsersRealName(realname);
			user.setUsersDescription(description);
			user.setCreatedBy(System.getProperty("user")); 
			user.setUpdatedBy(System.getProperty("user")); 
			user.setUpdateDate(cal.getTime());
			user.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(user);
			AdmBLUserAdd.saveUserGroups(user.getId(),userGroups);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void saveUserGroups(Integer userId, List userGroups)throws Exception
	{
		for(int k=0; k<userGroups.size(); k++)
		{
			registerUserGroup(userId,(TurqGroup)userGroups.get(k));
		}		
	}

	private static void registerUserGroup(Integer userId, TurqGroup group) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqUser user = new TurqUser();
			user.setId(userId);
			TurqUserGroup usergroup = new TurqUserGroup();
			usergroup.setTurqUser(user);
			usergroup.setTurqGroup((TurqGroup) group);
			usergroup.setCreatedBy(System.getProperty("user"));
			usergroup.setUpdatedBy(System.getProperty("user")); 
			usergroup.setUpdateDate(cal.getTime());
			usergroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(usergroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getGroups() throws Exception
	{
		try
		{
			return EngDALCommon.getGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}