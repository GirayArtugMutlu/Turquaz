
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

import java.util.*;


/**
 * @author onsel
 *
 * @version $Id$
 */
public class EngBLPermissions {
	private String username ="";
	private Map permMap = new HashMap();
	
	public EngBLPermissions(String username){
		
	calculateModulePerms();	
		
	}
	private void calculateModulePerms(){
	
	permMap.put("Modul paket adý","Modul class adý");
		
	}
	
	private Map calculateComponentPerms(int ModuleID)
	{
		Map comp_perms = new HashMap();
		return comp_perms;	
		 
	}
	
	public int getPermission(String classname){
		return 3;
	}

}
