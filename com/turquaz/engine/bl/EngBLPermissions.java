
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



import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqGroupPermission;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUserPermission;

/**
 * @author onsel
 * 
 * @version $Id$
 * 
 * Here is the permissions layer. Other classes uses static functions in this
 * class.
 */
public class EngBLPermissions {

	private String username = "";

	public Map compMap;

	
	static EngBLPermissions _instance;

	/**
	 * Constructor
	 * @param username Current User of the system
	 */
	public EngBLPermissions(String username) {
		
		this.username = username;
		fillCompMap();
	}

	/**
	 * 
	 * @param classname
	 * @return permission level 
	 */
	public static synchronized int getPermission(String classname) {
		if (_instance == null) {

			_instance = new EngBLPermissions(System.getProperty("user"));

		}

		return _instance.getPerm(classname);

	}
/**
 * initiliaze the static EngBLPermission object
 *
 */
	public static synchronized void init() {
		if (_instance == null) {

			_instance = new EngBLPermissions(System.getProperty("user"));

		}

	}
/**
 * 
 * @return the Map of classname and permission levels
 */
	protected Map getPermissionMap() {
		return compMap;
	}

/**
 * 
 * Fill the Permissions Map
 *
 */	
	
	private void fillCompMap() {
		try {
			compMap = new HashMap();
					
			
			List list =EngDALUserPerms.getModuleComponents();
			TurqModuleComponent comp = null;
			for(int i= 0;i<list.size();i++){
		     comp = (TurqModuleComponent)list.get(i);
		     compMap.put(comp.getComponentsName(),0+"");
		    }
		
		List ls = EngDALUserPerms.getGroupPermissions(username);
		calculateGroupPerms(ls);
		
		
		ls = EngDALUserPerms.getUserPermissions(username);
		calculateUserPerms(ls);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

/**
 * 
 * @param list List of the TurqGroupPermission objects for user
 * 
 * Calculates the group permissions according to the list 
 */	
	private void calculateGroupPerms(List list) {
		try {

			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for(int i= 0;i<list.size();i++){
				
				TurqGroupPermission perms = (TurqGroupPermission)list.get(i);

				module_id = perms.getTurqModule().getId().intValue();
				module_component_id = perms.getTurqModuleComponent().getId().intValue();
				
				perm_level = perms.getGroupPermissionsLevel();

				if (perm_level > -1 && perm_level < 4) {

					if (module_id == -1) {
						// Iterate over the values in the map
						Iterator it = compMap.keySet().iterator();
						while (it.hasNext()) {
							// Get value
							compMap.put(it.next(), perm_level + "");
						}

					} else {
						if (module_component_id == -1) {
							List lst = EngDALUserPerms.getModuleComponents(module_id);
							TurqModuleComponent modComp =null;
							for (int j = 0; j < list.size(); i++) {
								
								modComp =(TurqModuleComponent)list.get(j);
								compMap.put(modComp.getComponentsName(), perm_level
										+ "");

							}

						} else {
							component_name = EngDALUserPerms.getModuleCompName(module_id, module_component_id);
							compMap.put(component_name, perm_level + "");
						}

					}

				} else {
					System.err.println("Permission hatasi: level 1-3 arasý olmalý!");
				}

			}
		
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param list list of the TurqUserPermission objects of user
	 * Adds the user permission to the permission map (compMap)
	 * 
	 * 
	 */
	private void calculateUserPerms(List list) {
		try {

			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for(int i= 0;i<list.size();i++){
				
				TurqUserPermission perms = (TurqUserPermission)list.get(i);

				module_id = perms.getTurqModule().getId().intValue();
				module_component_id = perms.getTurqModuleComponent().getId().intValue();
				
				perm_level = perms.getUserPermissionsLevel();

				if (perm_level > -1 && perm_level < 4) {

					if (module_id == -1) {
						// Iterate over the values in the map
						Iterator it = compMap.keySet().iterator();
						while (it.hasNext()) {
							// Get value
							compMap.put(it.next(), perm_level + "");
						}

					} else {
						if (module_component_id == -1) {
							List lst = EngDALUserPerms.getModuleComponents(module_id);
							TurqModuleComponent modComp =null;
							for (int j = 0; j < list.size(); i++) {
								
								modComp =(TurqModuleComponent)list.get(j);
								compMap.put(modComp.getComponentsName(), perm_level
										+ "");

							}

						} else {
							component_name = EngDALUserPerms.getModuleCompName(module_id, module_component_id);
							compMap.put(component_name, perm_level + "");
						}

					}

				} else {
					System.err.println("Permission hatasi: level 1-3 arasý olmalý!");
				}

			}
		
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param classname Name of the class to check permission level
	 * @return the permission level for the classname
	 */
	
	public int getPerm(String classname) {

		String level = compMap.get(classname).toString();
		return Integer.parseInt(level);

	}

}