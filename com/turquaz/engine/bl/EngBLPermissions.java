/*
 * Created on 28.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.turquaz.engine.bl;

import java.util.*;


/**
 * @author onsel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
