
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

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;


public class EngBLCommon {
	
	public final static int COMMON_BUY_INT=0;
	
	public final static int COMMON_SELL_INT=1;
	
	public final static int COMMON_ALL_INT=2;
	
	
	public final static String COMMON_BUY_STRING=Messages.getString("EngBLCommon.0"); //$NON-NLS-1$
	
	public final static String COMMON_SELL_STRING=Messages.getString("EngBLCommon.1"); //$NON-NLS-1$
	
	public final static String COMMON_ALL_STRING=Messages.getString("EngBLCommon.2"); //$NON-NLS-1$
	
	
	
    
    public final static int CASH_CURRENT_COLLECT = 0; //Kasa Cari Tahsilat
    
    public final static int CASH_CURRENT_PAYMENT = 1; // Kasa Cari �deme
    
    
    
    public final static int ACCOUNTING_TRANS_COLLECT = 0; //Tahsil Fisi
    
    public final static int ACCOUNTING_TRANS_PAYMENT = 1; //Tediye F?S?
    
    public final static int ACCOUNTING_TRANS_GENERAL = 2; //MAhsup Fisi
   
    public final static int ACCOUNTING_TRANS_OPENING = 3; // Acilis Fisi
    
    
    
    public final static int CURRENT_TRANS_BILL = 1; //Cari Fatura Hareketi
    
    public final static int CURRENT_TRANS_CHEQUE = 2; // CAri Cek hareketi
    
    public final static int CURRENT_TRANS_TRADEBILL = 3; //Cari senet hareketi
    
    public final static int CURRENT_TRANS_CASH = 4; //Cari Nakit Hareketi
    
    public final static int CURRENT_TRANS_BANK = 5; //Cari Banka Hareketi
    
    public final static int CURRENT_TRANS_INITIAL = 6; //Cari Acilis
    
    public final static int CURRENT_TRANS_OTHERS = 7; //Diger Borc Alacaklar
    
    
    
    public final static boolean CURRENT_TRANS_CREDIT = true; // cari alacak hareketi
    
    public final static boolean CURRENT_TRANS_DEBIT = false; // cari borc hareketi
    
    
    public final static int BANK_TRANS_INITIAL = 0; //Acilis
    
    public final static int BANK_TRANS_RECIEVE_MONEY = 1; // Gelen Havale
    
    public final static int BANK_TRANS_SEND_MONEY =2;    // Giden havale
    
    public final static int BANK_TRANS_CASH_DRAW =4; // Para �ekme
    
    public final static int BANK_TRANS_CASH_DEPOSIT =3; //Para yatirma 
    
    public final static int BANK_TRANS_OTHER_DRAW =5; // Diger Alacak Hareketi
    
    public final static int BANK_TRANS_OTHER_DEPOSIT =6; // Diger Borc Hareketi
    
    public final static int BANK_TRANS_BETWEEN_BANKS = 7; //Virman
    
    public final static int BANK_TRANS_CHEQUE_COLLECT = 8; //Banka Cek Tahsili
    
    
    
    public final static int MODULE_INVENTORY = 0;  //Stok Modulu
    
    public final static int MODULE_ACCOUNTING = 1; // muhasebe module
    
    public final static int MODULE_BANKS = 3;   // Banka Modulu
    
    public final static int MODULE_CURRENT = 4;  // Cari Modulu
    
    public final static int MODULE_ADMIN = 5; //ayarlar modulu
    
    public final static int MODULE_CONSIGNMENT = 6; //irsaliye Modulu
    
    public final static int MODULE_BILL = 7; //fatura modulu
    
    public final static int MODULE_CASH = 8; //kasa modulu
    
    public final static int MODULE_CHEQUE = 9; //cek modulu
    
    
    public final static int CHEQUE_TRANS_IN = 0; //Cek Giris Bordrosu
    public final static int CHEQUE_TRANS_OUT_CURRENT = 1; //Cek Cari Cikis Bordrosu
    public final static int CHEQUE_TRANS_OUT_BANK = 2; //Cek bank Cikis bordrosu
    public final static int CHEQUE_TRANS_COLLECT_FROM_BANK = 3; //Bankadan Cek Tahsilati
    public final static int CHEQUE_TRANS_COLLECT_FROM_CURRENT = 4; //Elden cek tahsilati
    
    public final static int CHEQUE_TYPE_CUSTOMER = 0; //m�?teri Ceki
    public final static int CHEQUE_TYPE_OWN = 1; //Firma Ceki
    
    public final static Integer CHEQUE_STATUS_PORTFOY = new Integer(0); //portfoyde
    public final static Integer CHEQUE_STATUS_CURRENT = new Integer(1); //ciro edili
    public final static Integer CHEQUE_STATUS_BANK = new Integer(2); // bankada tahsilde
    
    public final static String CHEQUE_STATUS_PORTFOY_STRING = "Portf�yde";
    public final static String CHEQUE_STATUS_CURRENT_STRING = "Ciro Edildi";
    public final static String CHEQUE_STATUS_BANK_STRING = "Bankada Tahsilde";
    
    
    
    
    public final static boolean INVENTORY_SPEC_VAT_FOR_EACH = true; //OTV birimle hesaplanir
    public final static boolean INVENTORY_SPEC_VAT_PERCENT = false; //OTV yuzde ile hesaplanir.
    
    
    public final static int CONTENT_ASSIST_ACCOUNTING = 0;
    public final static int CONTENT_ASSIST_INVENTORY = 1;
    public final static int CONTENT_ASSIST_ACCOUNT_LEAVES =2;
    public final static int CONTENT_ASSIST_CURRENT =3;
    public final static int CONTENT_ASSIST_CASH = 4;
    public final static int CONTENT_ASSIST_ACCOUNTING_CASH =5;
    public final static int CONTENT_ASSIST_CURRENT_CODE =6;
    public final static int CONTENT_ASSIST_BANK =7;
    public final static int CONTENT_ASSIST_INVENTORY_GROUPS =8;
    
    
    public final static int BILL_TRANS_TYPE_BUY=0;
    public final static int BILL_TRANS_TYPE_SELL=1;
    public final static int BILL_TRANS_TYPE_ALL=2;
    
    public final static int CONSIGNMENT_TRANS_TYPE_BUY=0;
    public final static int CONSIGNMENT_TRANS_TYPE_SELL=1;
    public final static int CONSIGNMENT_TRANS_TYPE_ALL=2;
    
    
    public final static int INVENTORY_TRANS_INITIAL = 0;    
    public final static int INVENTORY_TRANS_CONSIGNMENT =1;
    
    
    public final static int TABLE_ROW_COUNT = 10;
    
    private static TurqCurrency baseCurrency=null;
    
    public static TurqCurrency getBaseCurrency()
    {
    	try
		{
    		if (baseCurrency==null)
    			baseCurrency=AccBLTransactionSearch.getBaseCurrency();
    		return baseCurrency;
		}
    	catch(Exception ex)
		{
    		ex.printStackTrace();
    		return null;
		}
    }
    
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
