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

import com.turquaz.engine.dal.EngDALUserPerms;

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

		fillCompMap();
	}

	public static synchronized int getPermission(String classname) {
		if (_instance == null) {

			_instance = new EngBLPermissions("admin");

		}

		return _instance.getPerm(classname);

	}

	public static synchronized void init() {
		if (_instance == null) {

			_instance = new EngBLPermissions("admin");

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
			ResultSet rs = dbaccess.getModuleComponents();
			while (rs.next()) {
				compMap.put(rs.getString(1), 0 + "");
			}
			rs.close();

			//	System.out.println("Finished filling "+compMap.size());
			rs = dbaccess.getGroupPermissions("admin");
			calculateModulePerms(rs);
			rs = dbaccess.getUserPermissions("admin");
			calculateModulePerms(rs);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void calculateModulePerms(ResultSet rs) {
		try {

			int module_id = -1;
			int module_component_id = -1;
			int perm_level = 0;
			String component_name = "";
			while (rs.next()) {

				module_id = rs.getInt(1);
				module_component_id = rs.getInt(2);
				perm_level = rs.getInt(3);

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
							ArrayList list = dbaccess2
									.getModuleComponents(module_id);
							for (int i = 0; i < list.size(); i++) {
								compMap.put(list.get(i).toString(), perm_level
										+ "");

							}

						} else {
							component_name = dbaccess2.getModuleCompName(
									module_id, module_component_id);
							compMap.put(component_name, perm_level + "");
						}

					}

				} else {
					System.err
							.println("Permission hatası: level 1-3 arası olmalı!");
				}

			}
			rs.close();
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public int getPerm(String classname) {

		String level = compMap.get(classname).toString();
		return Integer.parseInt(level);

	}

}