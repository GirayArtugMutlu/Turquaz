/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.List;


import com.turquaz.admin.dal.AdmDALUserAdd;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUserAdd {
	
	private EngDALCommon dalCommon = new EngDALCommon();
	private AdmDALUserAdd dalAdmin = new AdmDALUserAdd();
	Calendar cal = Calendar.getInstance();
	public AdmBLUserAdd(){
		
	}
	
	
	public Integer saveUser(String username, String password, String realname, String description)throws Exception{
		try{
		
			TurqUser user = new TurqUser();
			user.setUsername(username);
			user.setUsersPassword(password);
			user.setUsersRealName(realname);
			user.setUsersDescription(description);
			

			user.setCreatedBy(System.getProperty("user"));
			user.setUpdatedBy(System.getProperty("user"));
		    user.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			user.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalAdmin.saveObject(user);
			
			return user.getUsersId();
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public void saveUserGroups(Integer userId, Object group)throws Exception {
		try{
		
			TurqUser user = new TurqUser();
			user.setUsersId(userId);
			TurqUserGroup usergroup = new TurqUserGroup();
			usergroup.setTurqUser(user);
			usergroup.setTurqGroup((TurqGroup)group);
			
			usergroup.setCreatedBy(System.getProperty("user"));
			usergroup.setUpdatedBy(System.getProperty("user"));
		    usergroup.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			usergroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalAdmin.saveObject(usergroup);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getGroups()throws Exception{
		try{
			
			return dalCommon.getGroups();
			
			
			
		}
		catch (Exception ex){
			throw ex;
		}
		
	}

}
