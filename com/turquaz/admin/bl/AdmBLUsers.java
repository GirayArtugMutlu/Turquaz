/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.List;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUsers {
	private EngDALCommon dalCommon = new EngDALCommon();
	public AdmBLUsers(){
		
	}
	
	public List getUsers()throws Exception{
		try{
			
			return dalCommon.getUsers();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

}