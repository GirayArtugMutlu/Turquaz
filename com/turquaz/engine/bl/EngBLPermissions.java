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

package com.turquaz.engine.bl;

import java.sql.ResultSet;
import java.util.*;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
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

	EngDALUserPerms dbaccess;

	EngDALUserPerms dbaccess2;

	static EngBLPermissions _instance;

	public EngBLPermissions(String username) {
		
		this.username = username;
		fillCompMap();
	}

	public static synchronized int getPermission(String classname) {
		if (_instance == null) {

			_instance = new EngBLPermissions(System.getProperty("user"));

		}

		return _instance.getPerm(classname);

	}

	public static synchronized void init() {
		if (_instance == null) {

			_instance = new EngBLPermissions(System.getProperty("user"));

		}

	}

	protected Map getMap() {
		return compMap;
	}

	private void fillCompMap() {
		try {
			compMap = new HashMap();
					
			
			
			
			dbaccess = new EngDALUserPerms();
			dbaccess2 = new EngDALUserPerms();
			List list = dbaccess.getModuleComponents();
			TurqModuleComponent comp = null;
			for(int i= 0;i<list.size();i++){
		     comp = (TurqModuleComponent)list.get(i);
		     compMap.put(comp.getComponentsName(),0+"");
		    }
		
		//	System.out.println("Finished filling "+compMap.size());
		List ls = dbaccess.getGroupPermissions(username);
		calculateGroupPerms(ls);
		
		
		ls = dbaccess.getUserPermissions(username);
		calculateUserPerms(ls);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void calculateGroupPerms(List list) {
		try {

			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for(int i= 0;i<list.size();i++){
				
				TurqGroupPermission perms = (TurqGroupPermission)list.get(i);

				module_id = perms.getTurqModule().getModulesId().intValue();
				module_component_id = perms.getTurqModuleComponent().getModuleComponentsId().intValue();
				
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
							List lst = dbaccess2.getModuleComponents(module_id);
							TurqModuleComponent modComp =null;
							for (int j = 0; j < list.size(); i++) {
								
								modComp =(TurqModuleComponent)list.get(j);
								compMap.put(modComp.getComponentsName(), perm_level
										+ "");

							}

						} else {
							component_name = dbaccess2.getModuleCompName(module_id, module_component_id);
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
	private void calculateUserPerms(List list) {
		try {

			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			for(int i= 0;i<list.size();i++){
				
				TurqUserPermission perms = (TurqUserPermission)list.get(i);

				module_id = perms.getTurqModule().getModulesId().intValue();
				module_component_id = perms.getTurqModuleComponent().getModuleComponentsId().intValue();
				
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
							List lst = dbaccess2.getModuleComponents(module_id);
							TurqModuleComponent modComp =null;
							for (int j = 0; j < list.size(); i++) {
								
								modComp =(TurqModuleComponent)list.get(j);
								compMap.put(modComp.getComponentsName(), perm_level
										+ "");

							}

						} else {
							component_name = dbaccess2.getModuleCompName(module_id, module_component_id);
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
	public int getPerm(String classname) {

		String level = compMap.get(classname).toString();
		return Integer.parseInt(level);

	}

}