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
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqGroupPermission;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUserPermissionLevel;

public class AdmBLGroupPermissions
{
	public static HashBag getGroupPermissions() throws Exception
	{
		try
		{
            HashBag bag = new HashBag();
            List permList = EngDALUserPerms.getGroupPermissions();
            
            for(int i =0;i<permList.size();i++)
            {
                TurqGroupPermission perm = (TurqGroupPermission)permList.get(i);
                bag.put(AdmKeys.ADM_GROUP_PERMISSION,i,AdmKeys.ADM_GROUP_PERMISSION_ID,perm.getId());
                bag.put(AdmKeys.ADM_GROUP_PERMISSION,i,AdmKeys.ADM_GROUP_NAME,perm.getTurqGroup().getGroupsName());
                bag.put(AdmKeys.ADM_GROUP_PERMISSION,i,AdmKeys.ADM_MODULE_DESCRIPTION,perm.getTurqModule().getModuleDescription());
                bag.put(AdmKeys.ADM_GROUP_PERMISSION,i,AdmKeys.ADM_MODULE_COMP_DESCRIPTION,perm.getTurqModuleComponent().getComponentsDescription());
                bag.put(AdmKeys.ADM_GROUP_PERMISSION,i,AdmKeys.ADM_GROUP_PERMISSION_LEVEL,new Integer(perm.getGroupPermissionsLevel()));
                
            }            
            return bag;
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getModuleComponents(HashMap argMap) throws Exception
	{
		try
		{
            Integer moduleId=(Integer)argMap.get(AdmKeys.ADM_MODULE_ID);
            
            HashBag bag = new HashBag();
            List moduleComponentList = EngDALUserPerms.getModuleComponents(moduleId.intValue());
            
            for(int i =0;i<moduleComponentList.size();i++)
            {
                TurqModuleComponent moduleComonent = (TurqModuleComponent)moduleComponentList.get(i);
                bag.put(AdmKeys.ADM_MODULE_COMP,i,AdmKeys.ADM_MODULE_COMP_ID,moduleComonent.getId());
                bag.put(AdmKeys.ADM_MODULE_COMP,i,AdmKeys.ADM_MODULE_COMP_DESCRIPTION,moduleComonent.getComponentsDescription());
                
            }    
            
			return bag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashBag getModules() throws Exception
	{
		try
		{
            HashBag bag = new HashBag();
            List moduleList = EngDALUserPerms.getModules();
            
            for(int i =0;i<moduleList.size();i++)
            {
                TurqModule module = (TurqModule)moduleList.get(i);
                bag.put(AdmKeys.ADM_MODULE,i,AdmKeys.ADM_MODULE_ID,module.getId());
                bag.put(AdmKeys.ADM_MODULE,i,AdmKeys.ADM_MODULE_DESCRIPTION,module.getModuleDescription());
                
            }            
            return bag;
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveGroupPermission(HashMap argMap) throws Exception
	{
		try
		{
			Integer groupId=(Integer)argMap.get(AdmKeys.ADM_GROUP_ID);
            
            TurqGroup group = new TurqGroup();
            group.setId(groupId);
            
			TurqModule module=(TurqModule)argMap.get(AdmKeys.ADM_MODULE);
			TurqModuleComponent moduleComp=(TurqModuleComponent)argMap.get(AdmKeys.ADM_MODULE_COMP);
			TurqUserPermissionLevel permissionLevel=(TurqUserPermissionLevel)argMap.get(AdmKeys.ADM_LEVEL);
			
			Calendar cal = Calendar.getInstance();
			TurqGroupPermission groupPerm = new TurqGroupPermission();
			groupPerm.setTurqGroup(group);
			groupPerm.setTurqModule(module);
			groupPerm.setTurqModuleComponent(moduleComp);
			groupPerm.setGroupPermissionsLevel(permissionLevel.getPermissionLevel());
			groupPerm.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			groupPerm.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			groupPerm.setUpdateDate(cal.getTime());
			groupPerm.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(groupPerm);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
    public static void deleteGroupPermission (HashMap argMap ) throws Exception
    {
        try
        {
            Integer permissionId=(Integer)argMap.get(AdmKeys.ADM_GROUP_PERMISSION_ID);
           
            TurqGroupPermission perm = new TurqGroupPermission ();
            perm.setId(permissionId);
            
            EngDALSessionFactory.getSession().refresh(perm);
                        
            EngBLCommon.delete(perm);            
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}