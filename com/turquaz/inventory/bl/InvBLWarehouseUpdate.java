package com.turquaz.inventory.bl;

import java.util.Calendar;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.inventory.dal.InvDALWarehouseUpdate;

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
public class InvBLWarehouseUpdate
{
	public static void updateWarehouse(TurqInventoryWarehous wh, String whAddres, String whTelephone, String whCity, String whDescription,
			String whName) throws Exception
	{
		try
		{
			wh.setWarehousesAddress(whAddres);
			wh.setWarehousesCity(whCity);
			wh.setWarehousesDescription(whDescription);
			wh.setWarehousesName(whName);
			wh.setWarehousesTelephone(whTelephone);
			wh.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			wh.setLastModified(cal.getTime());
			EngDALCommon.updateObject(wh);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteObject(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static boolean hasTransactions(TurqInventoryWarehous warehouse) throws Exception
	{
		try
		{
			return InvDALWarehouseUpdate.hasTransaction(warehouse);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}