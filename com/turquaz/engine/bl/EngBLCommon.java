
package com.turquaz.engine.bl;

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
* @author  Onsel Armagan
* @version  $Id$
*/
import java.util.List;

import com.turquaz.engine.dal.EngDALCommon;


public class EngBLCommon {
    
    final static int CASH_CURRENT_COLLECT = 0; //Kasa Cari Tahsilat
    
    final static int CASH_CURRENT_PAYMENT = 1; // Kasa Cari Ödeme
    
    
    
    final static int MODULE_INVENTORY = 0;  //Stok Modulu
    
    final static int MODULE_ACCOUNTING = 1; // muhasebe module
    
    final static int MODULE_BANKS = 3;   // Banka Modulu
    
    final static int MODULE_CURRENT = 4;  // Cari Modulu
    
    final static int MODULE_ADMIN = 5; //ayarlar modulu
    
    final static int MODULE_CONSIGNMENT = 6; //irsaliye Modulu
    
    final static int MODULE_BILL = 7; //fatura modulu
    
    final static int MODULE_CASH = 8; //kasa modulu
    
    
    
	public EngBLCommon()
	{
		
	}
	private EngDALCommon engDALCom=new EngDALCommon();
	
	public List getCurrencies() throws Exception {
		try {

			return engDALCom.getCurrencies();

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public List getTurqCurrentGroups() throws Exception {
		try{
			return engDALCom.getTurqCurrentGroups();			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public boolean checkUserPass(String user, String pass)throws Exception{
		try{
			
			return engDALCom.checkUserPass(user,pass);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getInventoryWarehouses()throws Exception{
		try{
			
			return engDALCom.getInventoryWarehouses();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static void delete(Object obj)throws Exception{
	    try{
	        
	        EngDALCommon common =new EngDALCommon();
	        common.delete(obj);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}

}
