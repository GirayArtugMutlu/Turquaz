/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;

import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqInventoryWarehous;

import com.turquaz.inventory.dal.InvDALWarehouseAdd;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLWarehouseAdd {
	
	private InvDALWarehouseAdd whDALAdd = new InvDALWarehouseAdd();
	
	Calendar cal = Calendar.getInstance();
	
	
	public void saveWarehouse(String whName, String whDescription,
							String whAddress, String whTelephone,
							String whCity          )throws Exception {
	  try{
		TurqInventoryWarehous warehouse = new TurqInventoryWarehous();
		warehouse.setWarehousesAddress(whAddress);
		warehouse.setWarehousesName(whName);
		warehouse.setWarehousesCity(whCity);
		warehouse.setWarehousesTelephone(whTelephone);
		warehouse.setWarehousesDescription(whDescription);
		
		TurqCompany company = new TurqCompany();
		company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
		
		warehouse.setCreatedBy(System.getProperty("user"));
		warehouse.setUpdatedBy(System.getProperty("user"));
		warehouse.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		warehouse.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		
		warehouse.setTurqCompany(company);
		whDALAdd.saveObject(warehouse);	
		//sfbk?msfb?ksmf?b
			
	
	  }
	  
		catch(Exception ex){
			throw ex;
		}
		
		
		
	}
	

}
