
package com.turquaz.consignment.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.consignment.dal.ConDALAddGroups;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignmentGroup;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
		
		TurqCompany company = new TurqCompany();	
		company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
		group.setTurqCompany(company);
		group.setCreatedBy(System.getProperty("user"));
		group.setUpdatedBy(System.getProperty("user"));
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
	
		group.setUpdatedBy(System.getProperty("user"));
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
