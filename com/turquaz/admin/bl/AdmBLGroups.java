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
 * @author Huseyin Ergun
 * @version $Id$
 */
import java.util.List;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;

public class AdmBLGroups
{
	public static HashBag getGroups() throws Exception
	{
		try
		{            
            HashBag bag = new HashBag();
            List groupList = EngDALCommon.getGroups();
            for(int i =0;i<groupList.size();i++)
            {
                TurqGroup group = (TurqGroup)groupList.get(i);
                bag.put(AdmKeys.ADM_GROUP,i,AdmKeys.ADM_GROUP_ID,group.getId());
                bag.put(AdmKeys.ADM_GROUP,i,AdmKeys.ADM_GROUP_NAME,group.getGroupsName());
                bag.put(AdmKeys.ADM_GROUP,i,AdmKeys.ADM_GROUP_DESCRIPTION,group.getGroupsName());
                
            }            
            return bag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}