/*
 * Created on 03.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.List;

import com.turquaz.engine.dal.EngDALCommon;

/**
 * @author huseyin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLGroups {
	private EngDALCommon dalCommon = new EngDALCommon();
	public AdmBLGroups(){
		
	}
	
	public List getGroups()throws Exception{
		try{
			
			return dalCommon.getGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
