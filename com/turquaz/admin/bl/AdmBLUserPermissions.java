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
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserPermission;
import com.turquaz.engine.dal.TurqUserPermissionLevel;

public class AdmBLUserPermissions
{
	public static void saveUserPermission(HashMap argMap) throws Exception
	{
		try
		{
			TurqUser user=(TurqUser)argMap.get(AdmKeys.ADM_USER);
			TurqModule module=(TurqModule)argMap.get(AdmKeys.ADM_MODULE);
			TurqModuleComponent moduleComp=(TurqModuleComponent)argMap.get(AdmKeys.ADM_MODULE_COMP);
			TurqUserPermissionLevel level=(TurqUserPermissionLevel)argMap.get(AdmKeys.ADM_LEVEL);
			
			Calendar cal = Calendar.getInstance();
			TurqUserPermission userPerm = new TurqUserPermission();
			userPerm.setTurqUser(user);
			userPerm.setTurqModule(module);
			userPerm.setTurqModuleComponent(moduleComp);
			userPerm.setTurqUserPermissionLevel(level);
			userPerm.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			userPerm.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			userPerm.setUpdateDate(cal.getTime());
			userPerm.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(userPerm);
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
	
	public static List getUserPermissonLevels() throws Exception
	{
		try
		{
			return EngDALUserPerms.getUserPermissonLevels();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}