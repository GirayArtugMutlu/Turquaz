
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

import java.sql.Statement;
import java.util.Calendar;
import java.util.List;


import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.current.dal.CurDALCurrentCardSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;


public class EngBLCommon {
	
	public final static int COMMON_BUY_INT=0;
	
	public final static int COMMON_SELL_INT=1;
	
	public final static int COMMON_ALL_INT=2;
	
	
	public final static String COMMON_BUY_STRING=Messages.getString("EngBLCommon.0"); //$NON-NLS-1$
	
	public final static String COMMON_SELL_STRING=Messages.getString("EngBLCommon.1"); //$NON-NLS-1$
	
	public final static String COMMON_ALL_STRING=Messages.getString("EngBLCommon.2"); //$NON-NLS-1$
	
	
	public final static int COMMON_DEPT = 0;
	
	public final static int COMMON_CREDIT = 1;
	
	
	public final static String COMMON_DEPT_STRING = Messages.getString("EngBLCommon.3"); //$NON-NLS-1$
    
	public final static String COMMON_CREDIT_STRING = Messages.getString("EngBLCommon.4"); //$NON-NLS-1$
	
	
    public final static int CASH_CURRENT_COLLECT = 0; //Kasa Cari Tahsilat
    
    public final static int CASH_CURRENT_PAYMENT = 1; // Kasa Cari Ödeme
    
    public final static int CASH_OTHER_COLLECT = 2; //Kasa Diger Tahsilat
    
    public final static int CASH_OTHER_PAYMENT = 3; // Kasa Diger Ödeme
    
    public final static int CASH_TRANSFER_BETWEEN_CARDS = 4; // Virman
    
    public final static int CASH_CHEQUE_COLLECT = 5; // Çek Tahsilat?
    
    
    
    
    
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
    
    
    public final static Integer CURRENT_ACC_TYPE_GENERAL =new Integer(0); // Cari alt hesabi
    
    public final static Integer CURRENT_ACC_TYPE_CHEQUES_TAKEN = new Integer(1); //alinan cekler
    
    public final static Integer CURRENT_ACC_TYPE_CHEQUES_GIVEN = new Integer(2); //verilen cekler..
    
    
    
    public final static boolean CURRENT_TRANS_CREDIT = true; // cari alacak hareketi
    
    public final static boolean CURRENT_TRANS_DEBIT = false; // cari borc hareketi
    
    
    public final static int BANK_TRANS_INITIAL = 0; //Acilis
    
    public final static int BANK_TRANS_RECIEVE_MONEY = 1; // Gelen Havale
    
    public final static int BANK_TRANS_SEND_MONEY =2;    // Giden havale
    
    public final static int BANK_TRANS_CASH_DRAW =4; // Para Çekme
    
    public final static int BANK_TRANS_CASH_DEPOSIT =3; //Para yatirma 
    
    public final static int BANK_TRANS_OTHER_DRAW =5; // Diger Alacak Hareketi
    
    public final static int BANK_TRANS_OTHER_DEPOSIT =6; // Diger Borc Hareketi
    
    public final static int BANK_TRANS_BETWEEN_BANKS = 7; //Virman
    
    public final static int BANK_TRANS_CHEQUE_COLLECT = 8; //Banka Cek Tahsili
    
    
    public final static Integer BANK_ACC_TYPE_GENERAL = new Integer(0); //banka muhasebe hesabi
    
    public final static Integer BANK_ACC_TYPE_CHEQUES_COLLECT = new Integer(1); //tahsildeki cekler
    
    public final static Integer BANK_ACC_TYPE_CHEQUES_GIVEN = new Integer(2); //verilen cekler
    
    
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
    
    public final static int CHEQUE_TYPE_CUSTOMER = 0; //mü?teri Ceki
    public final static int CHEQUE_TYPE_OWN = 1; //Firma Ceki
    
    public final static Integer CHEQUE_STATUS_PORTFOY = new Integer(0); //portfoyde
    public final static Integer CHEQUE_STATUS_CURRENT = new Integer(1); //ciro edili
    public final static Integer CHEQUE_STATUS_BANK = new Integer(2); // bankada tahsilde
    
    public final static String CHEQUE_STATUS_PORTFOY_STRING = Messages.getString("EngBLCommon.5"); //$NON-NLS-1$
    public final static String CHEQUE_STATUS_CURRENT_STRING = Messages.getString("EngBLCommon.6"); //$NON-NLS-1$
    public final static String CHEQUE_STATUS_BANK_STRING = Messages.getString("EngBLCommon.7"); //$NON-NLS-1$
    
    
    
    
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
    public final static int CONTENT_ASSIST_MAIN_ACCOUNTS=9;
    
    
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
    private static TurqCurrencyExchangeRate baseCurrencyExchangeRate=null;
    
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
    
    public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate()
    {
    	try
		{
    		if (baseCurrencyExchangeRate==null)
    			baseCurrencyExchangeRate=AccBLTransactionSearch.getBaseCurrencyExchangeRate();
    		return baseCurrencyExchangeRate;
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
	
	public static void updateAllBillAccountingTransactions(){
		try{
			Calendar calStart = Calendar.getInstance();
			calStart.set(calStart.get(Calendar.YEAR),0,1);
			
			Calendar calEnd = Calendar.getInstance();
			calEnd.set(calEnd.get(Calendar.YEAR),11,31);
		
			BillDALSearchBill dalBill =  new BillDALSearchBill();
			BillBLUpdateBill updateBill = new BillBLUpdateBill();
			BillBLAddBill addBill = new BillBLAddBill();
			
			List bills =dalBill.searchBill(null,"",calStart.getTime(),calEnd.getTime(),EngBLCommon.COMMON_ALL_INT); //$NON-NLS-1$
			
			for(int i=0;i<bills.size();i++){
			
				Object[]result = (Object[])bills.get(i);
				
				TurqBill bill = BillDALSearchBill.getBillByBillId((Integer)result[0]);
				
				dalBill.initializeBill(bill);
				updateBill.deleteAccountingTransactions(bill);
				addBill.saveAccountingTransaction(bill,bill.getTurqBillConsignmentCommon().getTurqCurrentCard());
					
				
				
				
				
			
			}	
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
	}
	public static void exportCurrentCardAccs() throws Exception{
		
		Transaction tx = null;
		try{
		
			
		List ls = new CurDALCurrentCardSearch().getCurrentCardsAndAccountingAccounts();
		
		Session session = EngDALSessionFactory.openSession();
		tx = session.beginTransaction();
		
		 Statement stmt = session.connection().createStatement();
		 String query =""; //$NON-NLS-1$
		 
		 for(int i=0;i<ls.size();i++){
		 	Object result[] = (Object[])ls.get(i);
		 	query = "insert into turq_current_accounting_accounts values("+result[0]+","+result[0]+","+result[1] //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
																		  +","+0+","+"'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		 	
		 	stmt.execute(query);
		 }
		
		tx.commit();
		session.flush();
		session.close();
		
		
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			if(tx!=null)
			tx.rollback();
		}
		
		
		
	}
	
	public static void exportBankCardAccs() throws Exception{
		
		Transaction tx = null;
		try{
		
			
		List ls = BankDALBankCardSearch.getBankCardsAndAccounts();
		
		Session session = EngDALSessionFactory.openSession();
		tx = session.beginTransaction();
		
		 Statement stmt = session.connection().createStatement();
		 String query =""; //$NON-NLS-1$
		 
		 for(int i=0;i<ls.size();i++){
		 	Object result[] = (Object[])ls.get(i);
		 	query = "insert into turq_bank_accounting_accounts values("+result[0]+","+result[0]+","+result[1] //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
														  +","+0+","+"'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		 	stmt.execute(query);
		 }
		
		tx.commit();
		session.flush();
		session.close();
		
		
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		
		
		
	}

}
