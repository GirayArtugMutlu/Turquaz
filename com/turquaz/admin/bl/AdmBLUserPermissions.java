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
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserPermission;

public class AdmBLUserPermissions
{
	public AdmBLUserPermissions()
	{
	}

	public static void saveUserPermission(Object user, Object module, Object moduleComp, int level) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqUserPermission userPerm = new TurqUserPermission();
			userPerm.setTurqUser((TurqUser) user);
			userPerm.setTurqModule((TurqModule) module);
			userPerm.setTurqModuleComponent((TurqModuleComponent) moduleComp);
			userPerm.setUserPermissionsLevel(level);
			userPerm.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			userPerm.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			userPerm.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			userPerm.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(userPerm);
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

	public static List getUserPermissions() throws Exception
	{
		try
		{
			return EngDALUserPerms.getUserPermissions();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getModuleComponents(int moduleId) throws Exception
	{
		try
		{
			return EngDALUserPerms.getModuleComponents(moduleId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getModules() throws Exception
	{
		try
		{
			return EngDALUserPerms.getModules();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}