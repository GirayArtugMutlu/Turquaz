package com.turquaz.inventory.bl;

import java.util.Calendar;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqInventoryWarehous;

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
 * @author Onsel Armagan
 * @version $Id$
 */
public class InvBLWarehouseAdd
{
	public static void saveWarehouse(String whName, String whCode, String whDescription, String whAddress, String whTelephone,
			String whCity) throws Exception
	{
		try
		{
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