
package com.turquaz.consignment.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.consignment.dal.ConDALAddGroups;
import com.turquaz.engine.dal.TurqConsignmentGroup;


public class ConBLAddGroups {
	Calendar cal = Calendar.getInstance();
	ConDALAddGroups dalAddGroups = new ConDALAddGroups();
	public ConBLAddGroups(){
		
	}
	
	public List getConsignmentGroups()throws Exception {
		try{
			return dalAddGroups.getConsignmentGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	public void saveGroup(String name, String description)throws Exception{
		try{
		TurqConsignmentGroup group = new TurqConsignmentGroup();
		group.setGroupsDescription(description);
		group.setGroupsName(name);
		
		group.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		
		dalAddGroups.save(group);	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void updateGroup(String name, String description,TurqConsignmentGroup group)throws Exception{
		try{

		group.setGroupsDescription(description);
		group.setGroupsName(name);
	
		group.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	
		dalAddGroups.update(group);	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void deleteGroup(TurqConsignmentGroup group)throws Exception{
		try{

	
		dalAddGroups.delete(group);	

		
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
