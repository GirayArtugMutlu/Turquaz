/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;

import com.turquaz.admin.dal.AdmDALUserAdd;
import com.turquaz.admin.dal.AdmDALUserUpdate;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqUser;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUserUpdate {
	private AdmDALUserUpdate dalAdmin = new AdmDALUserUpdate();
	Calendar cal = Calendar.getInstance();
	public AdmBLUserUpdate(){
		
		
	}
	
	public void updateUser(String password, String realname, String description,TurqUser user)throws Exception{
	try{
		
		user.setUsersPassword(password);
		user.setUsersRealName(realname);
		user.setUsersDescription(description);
		
		user.setUpdateDate(cal.getTime());
		user.setUpdatedBy(System.getProperty("user"));
		
		dalAdmin.updateObject(user);
			
	}
	catch(Exception ex){
			throw ex;
	}
	
	}

}
