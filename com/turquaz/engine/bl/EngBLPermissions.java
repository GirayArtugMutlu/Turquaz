package com.turquaz.engine.bl;

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
import java.util.*;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.tx.EngTXCommon;

/**
 * @author onsel
 * @version $Id$ Here is the permissions layer. Other classes uses static
 *          functions in this class.
 */
public class EngBLPermissions
{
	private String username = "";
	public Map compMap;
	static EngBLPermissions _instance;

	/**
	 * Constructor
	 * 
	 * @param username
	 *             Current User of the system
	 */
	public EngBLPermissions(String username)
	{
		this.username = username;
		fillCompMap();
	}

	/**
	 * @param classname
	 * @return permission level
	 */
	public static synchronized int getPermission(String classname)
	{
		if (_instance == null)
		{
			_instance = new EngBLPermissions(System.getProperty("user"));
		}
		return _instance.getPerm(classname);
	}

	/**
	 * initiliaze the static EngBLPermission object
	 */
	public static synchronized void init()
	{
		if (_instance == null)
		{
			_instance = new EngBLPermissions(System.getProperty("user"));
		}
	}

	/**
	 * @return the Map of classname and permission levels
	 */
	protected Map getPermissionMap()
	{
		return compMap;
	}

	/**
	 * Fill the Permissions Map
	 */
	private void fillCompMap()
	{
		try
		{
			compMap = new HashMap();
						
			
			HashBag result =(HashBag) EngTXCommon.doSelectTX(EngDALUserPerms.class.getName(),"getModuleComponents",null);
			HashMap moduleList =(HashMap)result.get(EngKeys.MODULE_COMPONENTS);
			
			Iterator it = moduleList.keySet().iterator();
			
			while(it.hasNext())
			{
				List list =(List)moduleList.get(it.next());
				
				Iterator listIt=list.iterator();
				
				while(listIt.hasNext())
				{
					HashMap compInfo = (HashMap)listIt.next();
					compMap.put(compInfo.get(AdmKeys.ADM_MODULE_COMP_NAME),"0");
				}
				
				
				
			}
		
			
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.USER,username);
			
			HashBag permBag =(HashBag) EngTXCommon.doSelectTX(EngDALUserPerms.class.getName(),"getGroupPermissions",argMap);
			
			HashMap permList = (HashMap)permBag.get(EngKeys.GROUP_PERMISSIONS);		
			
			calculateGroupPerms(permList,moduleList);
						
			HashBag userPermBag =(HashBag) EngTXCommon.doSelectTX(EngDALUserPerms.class.getName(),"getUserPermissions",argMap);
			
			HashMap userPermList = (HashMap)userPermBag.get(EngKeys.USER_PERMISSIONS);		
			
			calculateUserPerms(userPermList,moduleList);
		
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/**
	 * @param list
	 *             List of the TurqGroupPermission objects for user Calculates the group permissions according to the list
	 */
	private void calculateGroupPerms(HashMap permlist,HashMap moduleList)
	{
		try
		{
			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for (int i = 0; i < permlist.size(); i++)
			{
				
				HashMap permInfo =(HashMap)permlist.get(new Integer(i));
							
				module_id = ((Integer)permInfo.get(AdmKeys.ADM_MODULE_ID)).intValue();
				module_component_id = ((Integer)permInfo.get(AdmKeys.ADM_MODULE_COMP_ID)).intValue();
				perm_level = ((Integer)permInfo.get(AdmKeys.ADM_GROUP_PERMISSION_LEVEL)).intValue();
				component_name = (String)permInfo.get(AdmKeys.ADM_MODULE_COMP_NAME);
				
				if (perm_level > -1 && perm_level < 4)
				{
					if (module_id == -1)
					{
						// Iterate over the values in the map
						Iterator it = compMap.keySet().iterator();
						while (it.hasNext())
						{
							// Get value
							compMap.put(it.next(), perm_level + "");
						}
					}
					else
					{
						if (module_component_id == -1)
						{
							
							List list = (List)moduleList.get(new Integer(module_id));
														
							HashMap modComp = null;
							for (int j = 0; j < list.size(); i++)
							{
								modComp = (HashMap) list.get(j);
								compMap.put(modComp.get(AdmKeys.ADM_MODULE_COMP_NAME), perm_level + "");
							}
						}
						else
						{							
							compMap.put(component_name, perm_level + "");
						}
					}
				}
				else
				{
					System.err.println("Permission hatasi: level 1-3 arasý olmalý!");
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/**
	 * @param list
	 *             list of the TurqUserPermission objects of user Adds the user permission to the permission map (compMap)
	 */
	private void calculateUserPerms(HashMap permlist,HashMap moduleList)
	{
		try
		{
			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for (int i = 0; i < permlist.size(); i++)
			{
				HashMap permInfo =(HashMap)permlist.get(new Integer(i));
				
				module_id = ((Integer)permInfo.get(AdmKeys.ADM_MODULE_ID)).intValue();
				module_component_id = ((Integer)permInfo.get(AdmKeys.ADM_MODULE_COMP_ID)).intValue();
				perm_level = ((Integer)permInfo.get(AdmKeys.ADM_USER_PERMISSION_LEVEL)).intValue();
				component_name = (String)permInfo.get(AdmKeys.ADM_MODULE_COMP_NAME);
				
				if (perm_level > -1 && perm_level < 4)
				{
					if (module_id == -1)
					{
						// Iterate over the values in the map
						Iterator it = compMap.keySet().iterator();
						while (it.hasNext())
						{
							// Get value
							compMap.put(it.next(), perm_level + "");
						}
					}
					else
					{
						if (module_component_id == -1)
						{
							List list = (List)moduleList.get(new Integer(module_id));
							
							HashMap modComp = null;
							for (int j = 0; j < list.size(); i++)
							{
								modComp = (HashMap) list.get(j);
								compMap.put(modComp.get(AdmKeys.ADM_MODULE_COMP_NAME), perm_level + "");
							}
						}
						else
						{
							compMap.put(component_name, perm_level + "");
						}
					}
				}
				else
				{
					System.err.println("Permission levels should be between 1-3");
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/**
	 * @param classname
	 *             Name of the class to check permission level
	 * @return the permission level for the classname
	 */
	public int getPerm(String classname)
	{
		if (compMap.get(classname) != null)
		{
			String level = compMap.get(classname).toString();
			return Integer.parseInt(level);
		}
		else
		{
			System.err.println("You probably forgot to add a module component to database!");
			System.err.println("Class name: " + classname);
			return 0;
		}
	}
}