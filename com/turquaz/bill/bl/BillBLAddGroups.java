
package com.turquaz.bill.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.bill.dal.BillDALAddGroups;
import com.turquaz.engine.dal.TurqBillGroup;

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
