/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.admin.dal.AdmDALUserPermissions;
import com.turquaz.engine.dal.EngDALUserPerms;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserPermission;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUserPermissions {
	
	private AdmDALUserPermissions dalAdminUserPerms = new AdmDALUserPermissions();
	private EngDALUserPerms dalEngUserPerm = new EngDALUserPerms();
	Calendar cal = Calendar.getInstance();
	
	public AdmBLUserPermissions(){
		
	}
	
	public void saveUserPermission(Object user, Object module, Object moduleComp, int level)throws Exception{
		try{
			
			TurqUserPermission userPerm = new TurqUserPermission();
			userPerm.setTurqUser((TurqUser)user);
			userPerm.setTurqModule((TurqModule)module);
			userPerm.setTurqModuleComponent((TurqModuleComponent)moduleComp);
			userPerm.setUserPermissionsLevel(level);
			
			userPerm.setCreatedBy(System.getProperty("user"));
			userPerm.setUpdatedBy(System.getProperty("user"));
			userPerm.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			userPerm.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalAdminUserPerms.saveObject(userPerm);
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void deleteObject(Object obj)throws Exception {
		try{
			
			dalAdminUserPerms.deleteObject(obj);			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getUserPermissions()throws Exception{
	try{
		
		return dalEngUserPerm.getUserPermissions();
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	public List getModuleComponents(int moduleId)throws Exception{
		try{
			
			return dalEngUserPerm.getModuleComponents(moduleId);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getModules()throws Exception {
		try{
			
			return dalEngUserPerm.getModules();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	


}
