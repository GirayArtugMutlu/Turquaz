package com.turquaz.inventory.bl;

import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.inventory.InvKeys;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
/**
 * @author Onsel Armagan
 * @version $Id$
 */
public class InvBLWarehouseAdd
{
	public static void saveWarehouse(HashMap argMap) throws Exception
	{
		try
		{
			String whName=(String)argMap.get(InvKeys.INV_WAREHOUSE_NAME);
			String whCode=(String)argMap.get(InvKeys.INV_WAREHOUSE_CODE);
			String whDescription=(String)argMap.get(InvKeys.INV_WAREHOUSE_DESC);
			String whAddress=(String)argMap.get(InvKeys.INV_WAREHOUSE_ADDRESS);
			String whTelephone=(String)argMap.get(InvKeys.INV_WAREHOUSE_TEL);
			String whCity=(String)argMap.get(InvKeys.INV_WAREHOUSE_CITY);
			TurqInventoryWarehous warehouse = new TurqInventoryWarehous();
			warehouse.setWarehousesAddress(whAddress);
			warehouse.setWarehousesName(whName);
			warehouse.setWarehousesCity(whCity);
			warehouse.setWarehousesTelephone(whTelephone);
			warehouse.setWarehousesDescription(whDescription);
			warehouse.setWarehousesCode(whCode);
			warehouse.setCreatedBy(System.getProperty("user"));
			warehouse.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			warehouse.setLastModified(cal.getTime());
			warehouse.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(warehouse);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}