/*
 * Created on Oct 15, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;

import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.inventory.dal.InvDALWarehouseSearch;
import com.turquaz.inventory.dal.InvDALWarehouseUpdate;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLWarehouseUpdate {
	
	private InvDALWarehouseUpdate whDALUpdate = new InvDALWarehouseUpdate();

	Calendar cal = Calendar.getInstance();
	
	public void updateWarehouse(TurqInventoryWarehous wh, String whAddres,
			String whTelephone, String whCity, String whDescription,String whName
			)throws Exception{

		


	}

	

}
