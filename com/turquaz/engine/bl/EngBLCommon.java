
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
    
    public final static int CASH_CURRENT_COLLECT = 0; //Kasa Cari Tahsilat
    
    public final static int CASH_CURRENT_PAYMENT = 1; // Kasa Cari Ödeme
    
    
    
    public final static int ACCOUNTING_TRANS_COLLECT = 0; //Tahsil Fisi
    
    public final static int ACCOUNTING_TRANS_PAYMENT = 1; //Tediye F?S?
    
    public final static int ACCOUNTING_TRANS_GENERAL = 2; //MAhsup Fisi
   
    public final static int ACCOUNTING_TRANS_OPENING = 3; // Acilis Fisi
    
    
    
    public final static int CURRENT_TRANS_BILL = 1; //Cari Fatura Hareketi
    
    public final static int CURRENT_TRANS_CHEQUE = 2; // CAri Cek hareketi
    
    public final static int CURRENT_TRANS_TRADEBILL = 3; //Cari senet hareketi
    
    public final static int CURRENT_TRANS_CASH = 4; //Cari Nakit Hareketi
    
    public final static int CURRENT_TRANS_BANK = 5; //Cari Banka Hareketi
    
    public final static boolean CURRENT_TRANS_CREDIT = true; // cari alacak hareketi
    
    public final static boolean CURRENT_TRANS_DEBIT = false; // cari borc hareketi
    
    
    public final static int MODULE_INVENTORY = 0;  //Stok Modulu
    
    public final static int MODULE_ACCOUNTING = 1; // muhasebe module
    
    public final static int MODULE_BANKS = 3;   // Banka Modulu
    
    public final static int MODULE_CURRENT = 4;  // Cari Modulu
    
    public final static int MODULE_ADMIN = 5; //ayarlar modulu
    
    public final static int MODULE_CONSIGNMENT = 6; //irsaliye Modulu
    
    public final static int MODULE_BILL = 7; //fatura modulu
    
    public final static int MODULE_CASH = 8; //kasa modulu
    
    
    
    public final static boolean INVENTORY_SPEC_VAT_FOR_EACH = true; //OTV birimle hesaplanir
    public final static boolean INVENTORY_SPEC_VAT_PERCENT = false; //OTV yuzde ile hesaplanir.
    
    
    public final static int CONTENT_ASSIST_ACCOUNTING = 0;
    public final static int CONTENT_ASSIST_INVENTORY = 1;
    public final static int CONTENT_ASSIST_ACCOUNT_LEAVES =2;
    public final static int CONTENT_ASSIST_CURRENT =3;
    public final static int CONTENT_ASSIST_CASH = 4;
    
    
    public final static int BILL_TRANS_TYPE_BUY=0;
    public final static int BILL_TRANS_TYPE_SELL=1;
    
    
    
    
    
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
