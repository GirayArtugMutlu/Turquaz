package com.turquaz.consignment.bl;

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
/** ********************************************************************* */
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.dal.ConDALAddGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqConsignmentGroup;

public class ConBLAddGroups
{
	public static List getConsignmentGroups() throws Exception
	{
		try
		{
			return ConDALAddGroups.getConsignmentGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveGroup(HashMap argMap ) throws Exception
	{
		try
		{
			String name=(String)argMap.get(ConsKeys.CONS_GROUP_NAME);
			String description=(String)argMap.get(ConsKeys.CONS_GROUP_DESCRIPTION);
			Calendar cal = Calendar.getInstance();
			TurqConsignmentGroup group = new TurqConsignmentGroup();
			group.setGroupsDescription(description);
			group.setGroupsName(name);
			group.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(group);
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
			String name=(String)argMap.get(ConsKeys.CONS_GROUP_NAME);
			String description=(String)argMap.get(ConsKeys.CONS_GROUP_DESCRIPTION);
			TurqConsignmentGroup group=(TurqConsignmentGroup)argMap.get(ConsKeys.CONS_GROUP);
			Calendar cal = Calendar.getInstance();
			group.setGroupsDescription(description);
			group.setGroupsName(name);
			group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.updateObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}