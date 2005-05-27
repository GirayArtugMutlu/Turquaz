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
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
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
			Integer userId=(Integer)argMap.get(AdmKeys.ADM_USER_ID);
			Integer moduleId=(Integer)argMap.get(AdmKeys.ADM_MODULE_ID);
			Integer moduleCompId=(Integer)argMap.get(AdmKeys.ADM_MODULE_COMP_ID);
			Integer levelId=(Integer)argMap.get(AdmKeys.ADM_LEVEL_ID);
			
            TurqUser user = new TurqUser();
            user.setId(userId);
            
            TurqModule module = new TurqModule ();
            module.setId(moduleId);
            
            TurqModuleComponent moduleComp = new TurqModuleComponent ();
            moduleComp.setId(moduleCompId);
            
            TurqUserPermissionLevel level = new TurqUserPermissionLevel ();
            level.setId(levelId);
            
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

	public static HashBag getUserPermissions() throws Exception
	{
		try
		{
			HashBag bag = new HashBag();
            List userPermList = EngDALUserPerms.getUserPermissions();
            for(int i =0;i<userPermList.size();i++)
            {
                TurqUserPermission userPerm = (TurqUserPermission)userPermList.get(i);
                
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_USER_PERMISSION_ID,userPerm.getId());
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_USER_NAME,userPerm.getTurqUser().getUsername());
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_MODULE_DESCRIPTION,userPerm.getTurqModule().getModuleDescription());
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_MODULE_COMP_DESCRIPTION,userPerm.getTurqModuleComponent().getComponentsDescription());
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_USER_PERMISSION_DESCRIPTION,userPerm.getTurqUserPermissionLevel().getPermissionDescription());
                
            }            
            return bag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static HashBag getUserPermissonLevels() throws Exception
	{
		try
		{
            HashBag bag = new HashBag();
            List permList = EngDALUserPerms.getUserPermissonLevels();
            
            for(int i =0;i<permList.size();i++)
            {
                TurqUserPermissionLevel perm = (TurqUserPermissionLevel)permList.get(i);
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_USER_PERMISSION_ID,perm.getId());
                bag.put(AdmKeys.ADM_USER_PERMISSION,i,AdmKeys.ADM_USER_PERMISSION_DESCRIPTION,perm.getPermissionDescription());
                
            }            
            return bag;
            
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
    
    public static void deleteUserPermission (HashMap argMap ) throws Exception
    {
        try
        {
            Integer permissionId=(Integer)argMap.get(AdmKeys.ADM_USER_PERMISSION_ID);
           
            TurqUserPermission perm = new TurqUserPermission ();
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