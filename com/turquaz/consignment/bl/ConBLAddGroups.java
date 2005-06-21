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
import java.util.Iterator;
import java.util.List;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.dal.ConDALAddGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignmentGroup;

public class ConBLAddGroups
{
	public static HashBag getConsignmentGroups() throws Exception
	{
		
			HashBag result = new HashBag();
			result.put(ConsKeys.CONS_GROUPS,new HashMap());
		    
			List list = ConDALAddGroups.getConsignmentGroups();
			Iterator it = list.iterator();
			int i=0;
			
			while(it.hasNext())
			{
				
				TurqConsignmentGroup conGroup =(TurqConsignmentGroup)it.next();
				result.put(ConsKeys.CONS_GROUPS,i,AdmKeys.ADM_GROUP_NAME,conGroup.getGroupsName());
				result.put(ConsKeys.CONS_GROUPS,i,AdmKeys.ADM_GROUP_ID,conGroup.getId());
				result.put(ConsKeys.CONS_GROUPS,i,AdmKeys.ADM_GROUP_DESCRIPTION,conGroup.getGroupsDescription());
				
				i++;
				
			}
			
			
			return result;
		
	}

	public static void saveGroup(HashMap argMap ) throws Exception
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
	public static void deleteGroup(HashMap argMap)throws Exception
	{
		
		Integer groupId =(Integer)argMap.get(ConsKeys.CONS_GROUP_ID);
		TurqConsignmentGroup group = new TurqConsignmentGroup();
		group.setId(groupId);
		EngDALCommon.deleteObject(group);
	
	}
	
	public static void updateGroup(HashMap argMap) throws Exception
	{
		
			String name=(String)argMap.get(ConsKeys.CONS_GROUP_NAME);
			String description=(String)argMap.get(ConsKeys.CONS_GROUP_DESCRIPTION);
			Integer groupId=(Integer)argMap.get(ConsKeys.CONS_GROUP_ID);
			TurqConsignmentGroup group = (TurqConsignmentGroup)EngDALSessionFactory.getSession().load(TurqConsignmentGroup.class,groupId);			
			
			
			Calendar cal = Calendar.getInstance();
			group.setGroupsDescription(description);
			group.setGroupsName(name);
			group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.updateObject(group);
	
	}
}