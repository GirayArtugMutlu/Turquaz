package com.turquaz.inventory.bl;

import java.util.Calendar;
import java.util.HashMap;

import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.exceptions.TurquazException;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.inventory.InvKeys;
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
	public static void updateWarehouse(HashMap argMap) throws Exception
	{
		try
		{
            Integer warehouseId = (Integer)argMap.get(InvKeys.INV_WAREHOUSE_ID);
            TurqInventoryWarehous wh= (TurqInventoryWarehous)EngDALSessionFactory.getSession().load(TurqInventoryWarehous.class,warehouseId);
    
			String whName=(String)argMap.get(InvKeys.INV_WAREHOUSE_NAME);
			String whCode=(String)argMap.get(InvKeys.INV_WAREHOUSE_CODE);
			String whDescription=(String)argMap.get(InvKeys.INV_WAREHOUSE_DESC);
			String whAddress=(String)argMap.get(InvKeys.INV_WAREHOUSE_ADDRESS);
			String whTelephone=(String)argMap.get(InvKeys.INV_WAREHOUSE_TEL);
			String whCity=(String)argMap.get(InvKeys.INV_WAREHOUSE_CITY);
			
			wh.setWarehousesAddress(whAddress);
			wh.setWarehousesCity(whCity);
			wh.setWarehousesDescription(whDescription);
			wh.setWarehousesName(whName);
			wh.setWarehousesTelephone(whTelephone);
			wh.setWarehousesCode(whCode);
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
    
    public static void deleteWarehouse(HashMap argMap) throws Exception
    {
        try
        {
            Integer warehouseId = (Integer)argMap.get(InvKeys.INV_WAREHOUSE_ID);
            boolean hasTransaction=InvDALWarehouseUpdate.hasTransaction(warehouseId);
            if (hasTransaction)
            {
            	throw new TurquazException(InvLangKeys.MSG_WAREHOUSE_HAS_TRANSACTION);
            }            
            TurqInventoryWarehous warehouse= (TurqInventoryWarehous)EngDALSessionFactory.getSession().load(TurqInventoryWarehous.class,warehouseId);
        
            HashMap deleteMap = new HashMap ();
            deleteMap.put(InvKeys.INV_WAREHOUSE,warehouse);
            EngBLServer.delete(deleteMap);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}