/*
 * Created on Nov 3, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.List;


import com.turquaz.engine.dal.EngDALCommon;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLUserAdd {
	
	private EngDALCommon dalCommon = new EngDALCommon();
	public AdmBLUserAdd(){
		
	}
	
	
	public void saveUser()throws Exception{
		try{
			
			
			
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
