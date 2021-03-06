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
import com.turquaz.admin.AdmKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;

public class AdmBLGroupAdd
{
	public static Integer saveGroup(HashMap argMap) throws Exception
	{
		try
		{
			String groupname=(String)argMap.get(AdmKeys.ADM_GROUP_NAME);
			String description=(String)argMap.get(AdmKeys.ADM_GROUP_DESCRIPTION);
			Calendar cal = Calendar.getInstance();
			TurqGroup group = new TurqGroup();
			group.setGroupsName(groupname);
			group.setGroupsDescription(description);
			group.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(group);
			return group.getId();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}