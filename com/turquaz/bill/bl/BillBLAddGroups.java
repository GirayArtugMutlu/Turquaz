
package com.turquaz.bill.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.bill.dal.BillDALAddGroups;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqCompany;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillBLAddGroups {
	Calendar cal = Calendar.getInstance();
	BillDALAddGroups dalAddGroups = new BillDALAddGroups();
	public BillBLAddGroups(){
		
	}
	
	public List getBillGroups()throws Exception {
		try{
			return dalAddGroups.getBillGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	public void saveGroup(String name, String description)throws Exception{
		try{
		TurqBillGroup group = new TurqBillGroup();
		group.setGroupDescription(description);
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
	
	public void updateGroup(String name, String description,TurqBillGroup group)throws Exception{
		try{

		group.setGroupDescription(description);
		group.setGroupsName(name);
	
		group.setUpdatedBy(System.getProperty("user"));
		group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	
		dalAddGroups.update(group);	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void deleteGroup(TurqBillGroup group)throws Exception{
		try{

	
		dalAddGroups.delete(group);	

		
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
