package com.turquaz.inventory.bl;

import java.util.HashMap;
import java.util.List;

import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALWarehouseSearch;

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
public class InvBLWarehouseSearch
{
	public static HashBag searchWarehouse(HashMap argMap) throws Exception
	{
        HashBag returnBag = new HashBag();
		returnBag.put(InvKeys.INV_WAREHOUSES,new HashMap());
        TurqInventoryWarehous warehouse;
        List result;
        
		
			String name=(String)argMap.get(InvKeys.INV_WAREHOUSE_NAME);
			String city=(String)argMap.get(InvKeys.INV_WAREHOUSE_CITY);
			result = InvDALWarehouseSearch.searchWarehouse(name, city);            
     
        for (int i = 0; i < result.size(); i++)
        {
            warehouse = (TurqInventoryWarehous) result.get(i);
            
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_CODE , warehouse.getWarehousesCode());
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_NAME , warehouse.getWarehousesName());
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_CITY , warehouse.getWarehousesCity());
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_TEL , warehouse.getWarehousesTelephone());
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_ID , warehouse.getId());
            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_DESC , warehouse.getWarehousesDescription());
            
        }
        
        
       
        return returnBag;
	}
    public static HashBag getWarehouseInfo(HashMap argMap) throws Exception
    {
        HashBag returnBag = new HashBag();
       
        try
        {
            Integer warehouseId =(Integer)argMap.get(InvKeys.INV_WAREHOUSE_ID);
            TurqInventoryWarehous warehouse = (TurqInventoryWarehous)EngDALSessionFactory.getSession().load(TurqInventoryWarehous.class,warehouseId);            
        
            returnBag.put(InvKeys.INV_WAREHOUSE_CODE , warehouse.getWarehousesCode());
            returnBag.put(InvKeys.INV_WAREHOUSE_NAME , warehouse.getWarehousesName());
            returnBag.put(InvKeys.INV_WAREHOUSE_CITY , warehouse.getWarehousesCity());
            returnBag.put(InvKeys.INV_WAREHOUSE_TEL , warehouse.getWarehousesTelephone());
            returnBag.put(InvKeys.INV_WAREHOUSE_ADDRESS, warehouse.getWarehousesAddress());
            returnBag.put(InvKeys.INV_WAREHOUSE_ID , warehouse.getId());
            returnBag.put(InvKeys.INV_WAREHOUSE_DESC , warehouse.getWarehousesDescription());
            
        
        }
        catch (Exception ex)
        {
            throw ex;
        }
        return returnBag;
    }

	public static HashBag getInventoryWarehouses() throws Exception
	{
		 HashBag returnBag = new HashBag();
		
		 returnBag.put(InvKeys.INV_WAREHOUSES,new HashMap());
	     
		 TurqInventoryWarehous warehouse;
	     
		 List result=InvDALWarehouseSearch.getInventoryWarehouses();
	        
		 for (int i = 0; i < result.size(); i++)
	        {
	            warehouse = (TurqInventoryWarehous) result.get(i);
	            
	            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_NAME , warehouse.getWarehousesName());
	            returnBag.put(InvKeys.INV_WAREHOUSES,i,InvKeys.INV_WAREHOUSE_ID , warehouse.getId());
	            
	        }
		
		
		 return returnBag;
		
	}
}