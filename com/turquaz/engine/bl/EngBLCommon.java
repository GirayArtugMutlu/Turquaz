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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.EngModulePrefs;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqSetting;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.inventory.dal.InvDALCardSearch;

public class EngBLCommon
{
	
	public static String VERSION = "0.7.6 Beta 6"; //$NON-NLS-1$
	public static String DATABASE_VERSION="0.7.6"; //$NON-NLS-1$
	
	public static int BILL_ERR_TOO_MANY_CONS = -1;
	public static int BILL_SAVED_SUCCESFULLY = 1;
	public static int BILL_ERR_OTHER = 0;
	
	public final static int COMMON_BUY_INT = 0;
	public final static int COMMON_SELL_INT = 1;
	public final static int COMMON_ALL_INT = 2;
	public final static int COMMON_RETURN_BUY_INT = 3;
    public final static int COMMON_RETURN_SELL_INT = 4;
    
    
    public final static int COMMON_DEPT = 0;
	public final static int COMMON_CREDIT = 1;
	public final static int CASH_CURRENT_COLLECT = 0; //Kasa Cari
	// Tahsilat
	public final static int CASH_CURRENT_PAYMENT = 1; // Kasa Cari
	// Ödeme
	public final static int CASH_OTHER_COLLECT = 2; //Kasa
	// Diger
	// Tahsilat
	public final static int CASH_OTHER_PAYMENT = 3; // Kasa
	// Diger
	// Ödeme
	public final static int CASH_TRANSFER_BETWEEN_CARDS = 4; // Virman
	public final static int CASH_CHEQUE_COLLECT = 5; // Çek
	// Tahsilat?
	public final static int CASH_INITIAL_TRANSACTION = 6; //Kasa Acilis..
	
    public final static int CASH_BILL_COLLECT =7; //Kapali Satis Faturasi
    
    public final static int CASH_BILL_PAYMENT =8; //Kapali Alis Faturasi
	
	
	public final static int ACCOUNTING_TRANS_COLLECT = 0; //Tahsil
	// Fisi
	public final static int ACCOUNTING_TRANS_PAYMENT = 1; //Tediye
	// F?S?
	public final static int ACCOUNTING_TRANS_GENERAL = 2; //MAhsup
	// Fisi
	public final static int ACCOUNTING_TRANS_OPENING = 3; // Acilis
	// Fisi
	public final static int CURRENT_TRANS_BILL = 1; //Cari
	// Fatura
	// Hareketi
	public final static int CURRENT_TRANS_CHEQUE = 2; // CAri Cek
	// hareketi
	public final static int CURRENT_TRANS_TRADEBILL = 3; //Cari
	// senet
	// hareketi
	public final static int CURRENT_TRANS_CASH = 4; //Cari
	// Nakit
	// Hareketi
	public final static int CURRENT_TRANS_BANK = 5; //Cari
	// Banka
	// Hareketi
	public final static int CURRENT_TRANS_INITIAL = 6; //Cari
	// Acilis
	public final static int CURRENT_TRANS_OTHERS = 7; //Diger Borc
	
	public final static int CURRENT_TRANS_BETWEEN_ACCOUNTS = 8; //Virman
    
    public final static int CURRENT_TRANS_MULTIPLE_DEPT = 9; //Coklu borc
    
    public final static int CURRENT_TRANS_MULTIPLE_CREDIT = 10; //Coklu Alacak
	
	// Alacaklar
	public final static Integer CURRENT_ACC_TYPE_GENERAL = new Integer(0); // Cari
	// alt
	// hesabi
	public final static Integer CURRENT_ACC_TYPE_CHEQUES_TAKEN = new Integer(1); //alinan
	// cekler
	public final static Integer CURRENT_ACC_TYPE_CHEQUES_GIVEN = new Integer(2); //verilen
	// cekler..
	public final static boolean CURRENT_TRANS_CREDIT = true; // cari
	// alacak
	// hareketi
	public final static boolean CURRENT_TRANS_DEBIT = false; // cari
	// borc
	// hareketi
	public final static int BANK_TRANS_INITIAL = 0; //Acilis
	public final static int BANK_TRANS_RECIEVE_MONEY = 1; // Gelen
	// Havale
	public final static int BANK_TRANS_SEND_MONEY = 2; // Giden
	// havale
	public final static int BANK_TRANS_CASH_DRAW = 4; // Para Çekme
	public final static int BANK_TRANS_CASH_DEPOSIT = 3; //Para
	// yatirma
	public final static int BANK_TRANS_OTHER_DRAW = 5; // Diger
	// Alacak
	// Hareketi
	public final static int BANK_TRANS_OTHER_DEPOSIT = 6; // Diger
	// Borc
	// Hareketi
	public final static int BANK_TRANS_BETWEEN_BANKS = 7; //Virman
	public final static int BANK_TRANS_CHEQUE_COLLECT = 8; //Banka Cek
	// Tahsili
	public final static int BANK_TRANS_OWN_CHEQUE_COLLECT = 9;
	
	
	
	public final static Integer BANK_ACC_TYPE_GENERAL = new Integer(0); //banka
	// muhasebe
	// hesabi
	public final static Integer BANK_ACC_TYPE_CHEQUES_COLLECT = new Integer(1); //tahsildeki
	// cekler
	public final static Integer BANK_ACC_TYPE_CHEQUES_GIVEN = new Integer(2); //verilen
	// cekler
	public final static int MODULE_INVENTORY = 0; //Stok
	// Modulu
	public final static int MODULE_ACCOUNTING = 1; // muhasebe
	// module
	public final static int MODULE_BANKS = 3; // Banka
	// Modulu
	public final static int MODULE_CURRENT = 4; // Cari
	// Modulu
	public final static int MODULE_ADMIN = 5; //ayarlar
	// modulu
	public final static int MODULE_CONSIGNMENT = 6; //irsaliye
	// Modulu
	public final static int MODULE_BILL = 7; //fatura
	// modulu
	public final static int MODULE_CASH = 8; //kasa
	// modulu
	public final static int MODULE_CHEQUE = 9; //cek
	// modulu
	public final static int INV_TRANS_INITIAL = 0;
	public final static int INV_TRANS_BUY_SELL = 1;
	public final static int INV_TRANS_OTHER = 2;
	public final static int INV_TRANS_MANUFACTURING = 3;
	public final static Integer CHEQUE_TRANS_IN = new Integer(0); //Cek
	public final static Integer CHEQUE_TRANS_OUT_CURRENT = new Integer(1); //Cek
	public final static Integer CHEQUE_TRANS_OUT_BANK = new Integer(2); //Cek
	public final static Integer CHEQUE_TRANS_COLLECT_FROM_BANK = new Integer(3); //Bankadan
	// //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_COLLECT_FROM_CURRENT = new Integer(4); //Elden
	public final static Integer CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY = new Integer(5); //Bankadan
	public final static Integer CHEQUE_TRANS_RETURN_TO_CURRENT = new Integer(6); //Cariden Portfoye iade...
	public final static Integer CHEQUE_TRANS_RETURN_FROM_CURRENT = new Integer(7);
	public final static Integer CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE =new Integer(8);	
	
	
	
	
	public final static Integer CHEQUE_STATUS_PORTFOY = new Integer(1);
	public final static Integer CHEQUE_STATUS_CURRENT = new Integer(2);
	public final static Integer CHEQUE_STATUS_COLLECTED = new Integer(3);
	public final static Integer CHEQUE_STATUS_RETURN_TO_CURRENT = new Integer(4);
	public final static Integer CHEQUE_STATUS_IN_BANK = new Integer(6);
	public final static Integer CHEQUE_STATUS_BOUNCED = new Integer(5);
    
    public final static String BILL_CONFIG ="bill"; //$NON-NLS-1$
	public final static String BILL_CONFIG_CHECK_BILL_NO="checkBillNo"; //$NON-NLS-1$
	public final static String BILL_CONFIG_CHECK_BUY_BILL="checkBuyBill"; //$NON-NLS-1$
	public final static String BILL_CONFIG_CHECK_SELL_BILL="checkSellBill"; //$NON-NLS-1$
    public final static String BILL_CONFIG_CHECK_USE_INVENTORY_NAME ="useInvName"; //$NON-NLS-1$
	public final static int CHECK_BUY_BILL=1;
	public final static int CHECK_SELL_BILL=2;
    
    
    
	
	public static Map getChequeStatusMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(EngLangCommonKeys.CHEQUE_STATUS_PORTFOY_STRING, CHEQUE_STATUS_PORTFOY);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_CURRENT_STRING, CHEQUE_STATUS_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_COLLECTED_STRING, CHEQUE_STATUS_COLLECTED);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_RETURN_TO_CURRENT_STRING, CHEQUE_STATUS_RETURN_TO_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_IN_BANK_STRING, CHEQUE_STATUS_IN_BANK);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_BOUNCED_STRING, CHEQUE_STATUS_BOUNCED);
		return map;
	}
	public final static int CHEQUE_TYPE_CUSTOMER = 0; //mü?teri Ceki
	public final static int CHEQUE_TYPE_OWN = 1; //Firma Ceki

	public static Map getChequeTransMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(EngLangCommonKeys.CHEQUE_TRANS_IN_STRING, CHEQUE_TRANS_IN);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_OUT_CURRENT_STRING, CHEQUE_TRANS_OUT_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_OUT_BANK_STRING, CHEQUE_TRANS_OUT_BANK);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_BANK_STRING, CHEQUE_TRANS_COLLECT_FROM_BANK);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING, CHEQUE_TRANS_COLLECT_FROM_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING, CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_RETURN_TO_CURRENT_STRING, CHEQUE_TRANS_RETURN_TO_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE_STRING,CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE);
		return map;
	}

	public static Map getChequeTransMapWithIntegerKey()
	{
		Map map = new HashMap();
		map.put(CHEQUE_TRANS_IN, EngLangCommonKeys.CHEQUE_TRANS_IN_STRING);
		map.put(CHEQUE_TRANS_OUT_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_OUT_CURRENT_STRING);
		map.put(CHEQUE_TRANS_OUT_BANK, EngLangCommonKeys.CHEQUE_TRANS_OUT_BANK_STRING);
		map.put(CHEQUE_TRANS_COLLECT_FROM_BANK, EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_BANK_STRING);
		map.put(CHEQUE_TRANS_COLLECT_FROM_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING);
		map.put(CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY, EngLangCommonKeys.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING);
		map.put(CHEQUE_TRANS_RETURN_TO_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_RETURN_TO_CURRENT_STRING);
		map.put(CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE,EngLangCommonKeys.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE_STRING);
		return map;
	}
	public final static boolean INVENTORY_SPEC_VAT_FOR_EACH = true; //OTV
	// birimle
	// hesaplanir
	public final static boolean INVENTORY_SPEC_VAT_PERCENT = false; //OTV yuzde
	// ile
	// hesaplanir.
	public final static int CONTENT_ASSIST_ACCOUNTING = 0;
	public final static int CONTENT_ASSIST_INVENTORY = 1;
	public final static int CONTENT_ASSIST_ACCOUNT_LEAVES = 2;
	public final static int CONTENT_ASSIST_CURRENT = 3;
	public final static int CONTENT_ASSIST_CASH = 4;
	public final static int CONTENT_ASSIST_ACCOUNTING_CASH = 5;
	public final static int CONTENT_ASSIST_CURRENT_CODE = 6;
	public final static int CONTENT_ASSIST_BANK = 7;
	public final static int CONTENT_ASSIST_INVENTORY_GROUPS = 8;
	public final static int CONTENT_ASSIST_MAIN_ACCOUNTS = 9;
	public final static int CONTENT_ASSIST_INVENTORY_NAME = 10;
	
	
    
	public final static int CONSIGNMENT_TRANS_TYPE_BUY = 0;
	public final static int CONSIGNMENT_TRANS_TYPE_SELL = 1;
	public final static int CONSIGNMENT_TRANS_TYPE_ALL = 2;
    public final static int CONSIGNMENT_TRANS_TYPE_RETURN_BUY =3;
    public final static int CONSIGNMENT_TRANS_TYPE_RETURN_SELL =4;
	
    public final static int INVENTORY_TRANS_INITIAL = 0;
	public final static int INVENTORY_TRANS_CONSIGNMENT = 1;
        
	public final static int INVENTORY_ACCOUNT_TYPE_BUY = 0;
	public final static int INVENTORY_ACCOUNT_TYPE_SELL = 1;
	public final static int INVENTORY_ACCOUNT_TYPE_VAT_BUY = 2;
	public final static int INVENTORY_ACCOUNT_TYPE_VAT_SELL = 3;
	public final static int INVENTORY_ACCOUNT_TYPE_SPEC_VAT_BUY = 4;
	public final static int INVENTORY_ACCOUNT_TYPE_SPEC_VAT_SELL = 5;
	public final static int INVENTORY_ACCOUNT_TYPE_DISCOUNT_BUY = 6;
	public final static int INVENTORY_ACCOUNT_TYPE_DISCOUNT_SELL = 7;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_BUY = 8;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_SELL = 9;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_VAT_BUY = 10;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_VAT_SELL = 11;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_SPEC_VAT_BUY = 12;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_SPEC_VAT_SELL = 13;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_DISCOUNT_BUY = 14;
    public final static int INVENTORY_ACCOUNT_TYPE_RETURN_DISCOUNT_SELL = 15;
    
    
	public final static int TABLE_ROW_COUNT = 10;
	public final static int ROUNDING_METHOD = BigDecimal.ROUND_HALF_UP;
	private static TurqCurrency baseCurrency = null;
	private static TurqCurrencyExchangeRate baseCurrencyExchangeRate = null;

	public static TurqCurrency getBaseCurrency()
	{
		try
		{
			if (baseCurrency == null)
			{
				baseCurrency = (TurqCurrency)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getBaseCurrency",null); //$NON-NLS-1$
			}
				return baseCurrency;
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLCommon.class,ex);
			return null;
		}
	}

	public static TurqCurrencyExchangeRate getCurrencyExchangeRate(TurqCurrency baseCurrency, TurqCurrency exchangeCurrency,
			Date exhangeDate) throws Exception
	{
		try
		{
			return EngDALCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, exhangeDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	
	
	public static Integer getBankTransaction(HashMap argMap) throws Exception
	{
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		return EngDALCommon.getBankTransaction(seq);
	}
	public static Integer getCheqeuTransaction(HashMap argMap) throws Exception
	{
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		return EngDALCommon.getCheqeuTransaction(seq);
	}
	
	public static Integer getBill(HashMap argMap) throws Exception
	{
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		return EngDALCommon.getBill(seq);
	}
	public static Integer getBillofCurrentTrans(HashMap argMap) throws Exception
	{
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		return EngDALCommon.getBillOfCurrentTrans(seq);
	}
	
	

	public static Integer getCashTransaction(HashMap argMap) throws Exception
	{
		TurqEngineSequence seq = (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
		return EngDALCommon.getCashTransaction(seq);
	}
		
	

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate() 
	{
		
			if (baseCurrencyExchangeRate == null){
				try
				{
					baseCurrencyExchangeRate = (TurqCurrencyExchangeRate)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getBaseCurrencyExchangeRate",null); //$NON-NLS-1$
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(EngBLCommon.class,ex);
				}
			}
					return baseCurrencyExchangeRate;
		
	}

	public static List getCurrencies() throws Exception
	{
		try
		{
			return EngDALCommon.getCurrencies();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqEngineSequence saveEngineSequence(int moduleId) throws Exception
	{
		TurqEngineSequence seq = new TurqEngineSequence();
		TurqModule module = new TurqModule();
		module.setId(new Integer(moduleId));
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		return seq;
	}

	public static void insertBillInEngineSeq() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Statement stmt = session.connection().createStatement();
			String query = "Select id,engine_sequences_id from turq_bills"; //$NON-NLS-1$
			ResultSet result = stmt.executeQuery(query);
			Statement stmt2 = session.connection().createStatement();
			int k = 0;
			while (result.next())
			{
				int id = result.getInt(1);
				int engineSeq = result.getInt(2);
				query = "Insert into turq_bill_in_engine_sequences values (" + k + "," + engineSeq + "," + id + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				stmt2.execute(query);
				k++;
			}
			session.flush();
			tx.commit();
			session.close();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqSetting getTurqSetting()throws Exception
	{
		return EngDALCommon.getTurqSetting();
	}

	public static Boolean checkUserPass(HashMap argMap) throws Exception
	{
		
		String user = (String)argMap.get(EngKeys.USER);
		String pass = (String)argMap.get(EngKeys.PASSWORD);
		
		return new Boolean(EngDALCommon.checkUserPass(user, pass));
		
	}
	
	public static Integer getBillCheckStatus()
	{
		String checkBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_BILL_NO);
		if (checkBill != null)
		{
			boolean check=new Boolean(checkBill).booleanValue();
			if (check)
			{
				boolean checkBuy=false;
				boolean checkSell=false;
				String checkBuyBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_BUY_BILL);
				if (checkBuyBill != null)
				{
					checkBuy=new Boolean(checkBuyBill).booleanValue();
				}		
				String checkSellBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_SELL_BILL);
				if (checkSellBill != null)
				{
					checkSell=new Boolean(checkSellBill).booleanValue();
				}
				int result=0;
				if (checkBuy)
				{
					result |= EngBLCommon.CHECK_BUY_BILL;
				}
				if (checkSell)
				{
					result |= EngBLCommon.CHECK_SELL_BILL;
				}
				return new Integer(result);
			}	
		}
		return new Integer(0);	
	}

	public static void delete(Object obj) throws Exception
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
	
	public static void delete(HashMap argMap) throws Exception
	{
		try
		{
			Iterator it=argMap.values().iterator();
			while(it.hasNext())
				EngBLCommon.delete(it.next());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void save(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.saveObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void update(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.updateObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void update(HashMap argMap) throws Exception
	{
		try
		{
			Iterator it=argMap.values().iterator();
			while(it.hasNext())
				update(it.next());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateAllBillAccountingTransactions()
	{
		try
		{
			Calendar calStart = Calendar.getInstance();
			calStart.set(calStart.get(Calendar.YEAR), 0, 1);
			Calendar calEnd = Calendar.getInstance();
			calEnd.set(calEnd.get(Calendar.YEAR), 11, 31);
			List bills = BillDALSearchBill.searchBill(null, "", calStart.getTime(), calEnd.getTime(), EngBLCommon.COMMON_ALL_INT); //$NON-NLS-1$
			for (int i = 0; i < bills.size(); i++)
			{
				Object[] result = (Object[]) bills.get(i);
				TurqBill bill = BillDALSearchBill.initializeBillById((Integer) result[0]);
				BillBLUpdateBill.deleteAccountingTransactions(bill);
				//XXX this method should be checked..
				//BillBLAddBill.saveAccountingTransaction(bill, null);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLCommon.class,ex);
		}
	}

	public static void exportCurrentCardAccs() throws Exception
	{
		Transaction tx = null;
		try
		{
			/*
			 * List ls = new CurDALCurrentCardSearch() .getCurrentCardsAndAccountingAccounts(); Session session =
			 * EngDALSessionFactory.openSession(); tx = session.beginTransaction(); Statement stmt =
			 * session.connection().createStatement(); String query = ""; //$NON-NLS-1$ for (int i = 0; i < ls.size(); i++) { Object
			 * result[] = (Object[]) ls.get(i); query = "insert into turq_current_accounting_accounts values(" + result[0] + "," +
			 * result[0] + "," + result[1] //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ + "," + 0 + "," +
			 * "'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ stmt.execute(query); }
			 * tx.commit(); session.flush(); session.close();
			 */
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLCommon.class,ex);
			if (tx != null)
				tx.rollback();
		}
	}

	public static void exportInventoryAccounts() throws Exception
	{
		Transaction tx = null;
		try
		{
			List ls = InvDALCardSearch.getInventoryCardsAndAccounts();
			Session session = EngDALSessionFactory.getSession();
			Statement stmt = session.connection().createStatement();
			String query = ""; //$NON-NLS-1$
			int i = 0;
			int key = 0;
			for (i = 0; i < ls.size(); i++)
			{
				Object results[] = (Object[]) ls.get(i);
				query = "insert into turq_inventory_accounting_accounts values(" + key + "," + results[0] + "," + results[1] + "," + 0 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
				query = "insert into turq_inventory_accounting_accounts values(" + key + "," + results[0] + "," + results[2] + "," + 1 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
				query = "insert into turq_inventory_accounting_accounts values(" + key + "," + results[0] + "," + results[3] + "," + 2 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
				query = "insert into turq_inventory_accounting_accounts values(" + key + "," + results[0] + "," + results[4] + "," + 3 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
				query = "insert into turq_inventory_accounting_accounts values(" + key + "," + results[0] + "," + results[5] + "," + 4 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
				query = "insert into turq_inventory_accounting_accounts  values(" + key + "," + results[0] + "," + results[6] + "," + 5 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ ",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
				stmt.execute(query);
				key++;
			}
			session.flush();

		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLCommon.class,ex);
			if (tx != null)
				tx.rollback();
		}
	}

	public static void exportBankCardAccs() throws Exception
	{
		/*
		 * Transaction tx = null; try { List ls = BankDALBankCardSearch.getBankCardsAndAccounts(); Session session =
		 * EngDALSessionFactory.openSession(); tx = session.beginTransaction(); Statement stmt = session.connection().createStatement();
		 * String query = ""; //$NON-NLS-1$ for (int i = 0; i < ls.size(); i++) { Object result[] = (Object[]) ls.get(i); query = "insert
		 * into turq_bank_accounting_accounts values(" + result[0] + "," + result[0] + "," + result[1] //$NON-NLS-1$ //$NON-NLS-2$
		 * //$NON-NLS-3$ + "," + 0 + "," + "'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		 * stmt.execute(query); } tx.commit(); session.flush(); session.close(); } catch (Exception ex) { Logger loger =
		 * Logger.getLogger(this.getClass()); loger.error("Exception Caught",ex);ex.printStacxkTrace(); tx.rollback(); }
		 */
	}

	public static void updateAllCashTransactions()
	{
		try
		{
			/*
			 * Date startDate = DatePicker.getFirstDayOfYear(); Date endDate = DatePicker.getLastDayOfYear(); List ls = new
			 * CashDALCashCard().searchCashTransaction(null, startDate, endDate, ""); //$NON-NLS-1$ CashBLCashTransactionSearch blSearch =
			 * new CashBLCashTransactionSearch(); CashBLCashTransactionUpdate blUpdate = new CashBLCashTransactionUpdate(); for (int i =
			 * 0; i < ls.size(); i++) { Object[] cashTranses = (Object[]) ls.get(i); TurqCashTransaction cashTrans = blSearch
			 * .initializeCashTransaction((Integer) cashTranses[0]); if (cashTrans.getTurqCashTransactionType().getId().intValue() ==
			 * EngBLCommon.CASH_CURRENT_COLLECT || cashTrans.getTurqCashTransactionType().getId() .intValue() ==
			 * EngBLCommon.CASH_CURRENT_PAYMENT) { BigDecimal totalAmount = new BigDecimal(0); Iterator it =
			 * cashTrans.getTurqCashTransactionRows() .iterator(); TurqCashCard cashCard = null; if (it.hasNext()) {
			 * TurqCashTransactionRow row = (TurqCashTransactionRow) it .next(); cashCard = row.getTurqCashCard(); if
			 * (row.getDeptAmount().compareTo(new BigDecimal(0)) == 1) { totalAmount= row.getDeptAmountInForeignCurrency(); } else {
			 * totalAmount = row.getCreditAmountInForeignCurrency(); } } TurqCurrentCard curCard =
			 * blUpdate.getCurrentCard(cashTrans.getTurqEngineSequence()); if(cashCard!=null&&curCard!=null) {
			 * blUpdate.updateCashTrans(cashTrans,cashCard,curCard,totalAmount,cashTrans.getTransactionDate(),cashTrans.getTransactionDefinition(),cashTrans.getDocumentNo(),EngBLCommon.getBaseCurrencyExchangeRate()); } } }
			 */
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLCommon.class,ex);
		}
	}
}