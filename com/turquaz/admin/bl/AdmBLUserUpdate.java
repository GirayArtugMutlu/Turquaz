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
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqUser;

public class AdmBLUserUpdate
{
	public AdmBLUserUpdate()
	{
	}

	public static void updateUser(String password, String realname, String description, TurqUser user) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			user.setUsersPassword(password);
			user.setUsersRealName(realname);
			user.setUsersDescription(description);
			user.setUpdateDate(cal.getTime());
			user.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			EngDALCommon.updateObject(user);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteObject(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}