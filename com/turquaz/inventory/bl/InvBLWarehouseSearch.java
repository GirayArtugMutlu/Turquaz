/*
 * Created on Oct 13, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.inventory.dal.InvDALWarehouseSearch;





/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLWarehouseSearch {
	private InvDALWarehouseSearch whDALSearch = new InvDALWarehouseSearch();

	Calendar cal = Calendar.getInstance();
	
	public List searchWarehouse(String name, String city)throws Exception{
		try{
			
	    return whDALSearch.searchWarehouse(name, city);
		
		}
		catch(Exception ex){
			
			throw ex;
			
		}
		
		
		
	}
	

}
