/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.List;

import com.turquaz.engine.dal.EngDALUserPerms;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUserPermissions {
	private EngDALUserPerms dalUserPerm = new EngDALUserPerms();
	public AdmBLUserPermissions(){
		
	}
	public List getUserPermissions()throws Exception{
	try{
		
		return dalUserPerm.getUserPermissions();
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	public List getModuleComponents(int moduleId)throws Exception{
		try{
			
			return dalUserPerm.getModuleComponents(moduleId);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getModules()throws Exception {
		try{
			
			return dalUserPerm.getModules();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}


}
