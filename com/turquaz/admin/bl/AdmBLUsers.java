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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

public class AdmBLUsers
{
	public static HashBag getUsers() throws Exception
	{
		try
		{
            HashBag bag = new HashBag();
            List userList = EngDALCommon.getUsers();
            
            for(int i =0;i<userList.size();i++)
            {
                HashMap userMap=new HashMap();
                TurqUser user = (TurqUser)userList.get(i);
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_ID,user.getId());
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_NAME,user.getUsername());
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_REAL_NAME,user.getUsersRealName());
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_DESCRIPTION,user.getUsersDescription());
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_PASSWORD,user.getUsersPassword());
                
                Iterator it = user.getTurqUserGroups().iterator();
                
                List groupList=null;
                while (it.hasNext())
                {
                    TurqUserGroup userGroup = (TurqUserGroup)it.next();
                    groupList = new ArrayList();                    
                    groupList.add(userGroup.getTurqGroup().getId());
                }
                bag.put(AdmKeys.ADM_USERS,i,AdmKeys.ADM_USER_GROUPS,groupList);
                
            }   
            
            
            
            return bag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static void deleteGroup(HashMap argMap)throws Exception
	{
		try
		{	
			Integer groupId=(Integer)argMap.get(AdmKeys.ADM_GROUP_ID);
            TurqGroup group = new TurqGroup ();
            group.setId(groupId);
			deleteGroupPermissions(group);
			EngDALCommon.deleteObject(group);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public static void deleteUser(HashMap argMap)throws Exception
	{
		try
		{	
			Integer userId=(Integer)argMap.get(AdmKeys.ADM_USER_ID);
            
            TurqUser user = new TurqUser();
            user.setId(userId);
            EngDALSessionFactory.getSession().refresh(user);            
			deleteUserGroups(user);
			deleteUserPermissions(user);
			EngDALCommon.deleteObject(user);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	private static void deleteGroupPermissions(TurqGroup user)throws Exception
	{
		EngDALSessionFactory.getSession().refresh(user);
		
		Iterator it=user.getTurqGroupPermissions().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}
	private static void deleteUserPermissions(TurqUser user)throws Exception
	{
		Iterator it=user.getTurqUserPermissions().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}
	
	public static void deleteUserGroups(TurqUser user)throws Exception
	{
		Iterator it=user.getTurqUserGroups().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}
}