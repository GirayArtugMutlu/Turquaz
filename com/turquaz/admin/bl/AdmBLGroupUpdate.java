
package com.turquaz.admin.bl;

import java.util.Calendar;

import com.turquaz.admin.dal.AdmDALGroupUpdate;
import com.turquaz.engine.dal.TurqGroup;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLGroupUpdate {
	AdmDALGroupUpdate dalAdmin = new AdmDALGroupUpdate();
	Calendar cal = Calendar.getInstance();
	public AdmBLGroupUpdate(){
		
	}
	public void updateGroup( String name, String description,TurqGroup group)throws Exception{
		try{
			
			group.setGroupsName(name);
			group.setGroupsDescription(description);;
			
			group.setUpdateDate(cal.getTime());
			group.setUpdatedBy(System.getProperty("user"));
			
			dalAdmin.updateObject(group);
				
		}
		catch(Exception ex){
				throw ex;
		}
		
		}
	public void deleteObject(Object obj)throws Exception{
		try{
		 
			dalAdmin.deleteObject(obj);
				
		}
		catch(Exception ex){
				throw ex;
		}
		
		}

}
