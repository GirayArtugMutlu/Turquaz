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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.hibernate.Transaction;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

public class EngBLCommon
{
	public final static int COMMON_BUY_INT = 0;
	public final static int COMMON_SELL_INT = 1;
	public final static int COMMON_ALL_INT = 2;
	public final static String COMMON_BUY_STRING = Messages.getString("EngBLCommon.0"); //$NON-NLS-1$
	public final static String COMMON_SELL_STRING = Messages.getString("EngBLCommon.1"); //$NON-NLS-1$
	public final static String COMMON_ALL_STRING = Messages.getString("EngBLCommon.2"); //$NON-NLS-1$
	public final static int COMMON_DEPT = 0;
	public final static int COMMON_CREDIT = 1;
	public final static String COMMON_DEPT_STRING = Messages.getString("EngBLCommon.3"); //$NON-NLS-1$
	public final static String COMMON_CREDIT_STRING = Messages.getString("EngBLCommon.4"); //$NON-NLS-1$
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
	public final static Integer CHEQUE_TRANS_IN = new Integer(0); //Cek
	// Giris
	// Bordrosu
	public final static String CHEQUE_TRANS_IN_STRING = Messages.getString("EngBLCommon.5"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_OUT_CURRENT = new Integer(1); //Cek
	// Cari
	// Cikis
	// Bordrosu
	public final static String CHEQUE_TRANS_OUT_CURRENT_STRING = Messages.getString("EngBLCommon.6"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_OUT_BANK = new Integer(2); //Cek
	// bank
	// Cikis
	// bordrosu
	public final static String CHEQUE_TRANS_OUT_BANK_STRING = Messages.getString("EngBLCommon.7"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_COLLECT_FROM_BANK = new Integer(3); //Bankadan
	// Cek
	public final static String CHEQUE_TRANS_COLLECT_FROM_BANK_STRING = Messages.getString("EngBLCommon.8"); // Tahsilati
	// //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_COLLECT_FROM_CURRENT = new Integer(4); //Elden
	// cek
	// tahsilati
	public final static String CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING = Messages.getString("EngBLCommon.9"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY = new Integer(5); //Bankadan
	// Portfoye
	// iade...
	public final static String CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING = Messages.getString("EngBLCommon.10"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_RETURN_TO_CURRENT = new Integer(6); //Cariden
	// Portfoye
	// iade...
	public final static String CHEQUE_TRANS_RETURN_TO_CURRENT_STRING = Messages.getString("EngBLCommon.11"); //$NON-NLS-1$
	public final static Integer CHEQUE_TRANS_RETURN_FROM_CURRENT = new Integer(7);
	public final static String CHEQUE_TRANS_RETURN_FROM_CURRENT_STRING = Messages.getString("EngBLCommon.18"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_PORTFOY = new Integer(1);
	public final static String CHEQUE_STATUS_PORTFOY_STRING = Messages.getString("EngBLCommon.12"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_CURRENT = new Integer(2);
	public final static String CHEQUE_STATUS_CURRENT_STRING = Messages.getString("EngBLCommon.13"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_COLLECTED = new Integer(3);
	public final static String CHEQUE_STATUS_COLLECTED_STRING = Messages.getString("EngBLCommon.14"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_RETURN_TO_CURRENT = new Integer(4);
	public final static String CHEQUE_STATUS_RETURN_TO_CURRENT_STRING = Messages.getString("EngBLCommon.15"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_IN_BANK = new Integer(6);
	public final static String CHEQUE_STATUS_IN_BANK_STRING = Messages.getString("EngBLCommon.16"); //$NON-NLS-1$
	public final static Integer CHEQUE_STATUS_BOUNCED = new Integer(5);
	public final static String CHEQUE_STATUS_BOUNCED_STRING = Messages.getString("EngBLCommon.17"); //$NON-NLS-1$

	public static Map getChequeStatusMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(CHEQUE_STATUS_PORTFOY_STRING, CHEQUE_STATUS_PORTFOY);
		map.put(CHEQUE_STATUS_CURRENT_STRING, CHEQUE_STATUS_CURRENT);
		map.put(CHEQUE_STATUS_COLLECTED_STRING, CHEQUE_STATUS_COLLECTED);
		map.put(CHEQUE_STATUS_RETURN_TO_CURRENT_STRING, CHEQUE_STATUS_RETURN_TO_CURRENT);
		map.put(CHEQUE_STATUS_IN_BANK_STRING, CHEQUE_STATUS_IN_BANK);
		map.put(CHEQUE_STATUS_BOUNCED_STRING, CHEQUE_STATUS_BOUNCED);
		return map;
	}
	public final static int CHEQUE_TYPE_CUSTOMER = 0; //mü?teri Ceki
	public final static int CHEQUE_TYPE_OWN = 1; //Firma Ceki

	public static Map getChequeTransMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(CHEQUE_TRANS_IN_STRING, CHEQUE_TRANS_IN);
		map.put(CHEQUE_TRANS_OUT_CURRENT_STRING, CHEQUE_TRANS_OUT_CURRENT);
		map.put(CHEQUE_TRANS_OUT_BANK_STRING, CHEQUE_TRANS_OUT_BANK);
		map.put(CHEQUE_TRANS_COLLECT_FROM_BANK_STRING, CHEQUE_TRANS_COLLECT_FROM_BANK);
		map.put(CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING, CHEQUE_TRANS_COLLECT_FROM_CURRENT);
		map.put(CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING, CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY);
		map.put(CHEQUE_TRANS_RETURN_TO_CURRENT_STRING, CHEQUE_TRANS_RETURN_TO_CURRENT);
		return map;
	}

	public static Map getChequeTransMapWithIntegerKey()
	{
		Map map = new HashMap();
		map.put(CHEQUE_TRANS_IN, CHEQUE_TRANS_IN_STRING);
		map.put(CHEQUE_TRANS_OUT_CURRENT, CHEQUE_TRANS_OUT_CURRENT_STRING);
		map.put(CHEQUE_TRANS_OUT_BANK, CHEQUE_TRANS_OUT_BANK_STRING);
		map.put(CHEQUE_TRANS_COLLECT_FROM_BANK, CHEQUE_TRANS_COLLECT_FROM_BANK_STRING);
		map.put(CHEQUE_TRANS_COLLECT_FROM_CURRENT, CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING);
		map.put(CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY, CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING);
		map.put(CHEQUE_TRANS_RETURN_TO_CURRENT, CHEQUE_TRANS_RETURN_TO_CURRENT_STRING);
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
	public final static int BILL_TRANS_TYPE_BUY = 0;
	public final static int BILL_TRANS_TYPE_SELL = 1;
	public final static int BILL_TRANS_TYPE_ALL = 2;
	public final static int CONSIGNMENT_TRANS_TYPE_BUY = 0;
	public final static int CONSIGNMENT_TRANS_TYPE_SELL = 1;
	public final static int CONSIGNMENT_TRANS_TYPE_ALL = 2;
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
	public final static int TABLE_ROW_COUNT = 10;
	public final static int ROUNDING_METHOD = BigDecimal.ROUND_HALF_DOWN;
	private static TurqCurrency baseCurrency = null;
	private static TurqCurrencyExchangeRate baseCurrencyExchangeRate = null;

	public static TurqCurrency getBaseCurrency()
	{
		try
		{
			if (baseCurrency == null)
				baseCurrency = AccBLTransactionSearch.getBaseCurrency();
			return baseCurrency;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate()
	{
		try
		{
			if (baseCurrencyExchangeRate == null)
				baseCurrencyExchangeRate = AccBLTransactionSearch.getBaseCurrencyExchangeRate();
			return baseCurrencyExchangeRate;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	public EngBLCommon()
	{
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

	public static boolean checkUserPass(String user, String pass) throws Exception
	{
		try
		{
			return EngDALCommon.checkUserPass(user, pass);
		}
		catch (Exception ex)
		{
			throw ex;
		}
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
				TurqBill bill = BillDALSearchBill.getBillByBillId((Integer) result[0]);
				BillDALSearchBill.initializeBill(bill);
				BillBLUpdateBill.deleteAccountingTransactions(bill);
				BillBLAddBill.saveAccountingTransaction(bill, null);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
			ex.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public static void exportInventoryAccounts() throws Exception
	{
		Transaction tx = null;
		try
		{
			/*
			 * List ls = InvDALCardSearch.getInventoryCardsAndAccounts(); Session session = EngDALSessionFactory.openSession(); tx =
			 * session.beginTransaction(); Statement stmt = session.connection().createStatement(); String query = ""; //$NON-NLS-1$ int
			 * i=0; int key=0; for (i = 0; i < ls.size(); i++) { Object results[]=(Object[])ls.get(i); //ACCOUNT BUY query = "insert into
			 * turq_inventory_accounting_accounts values(" //$NON-NLS-1$ +key +","+results[0] //$NON-NLS-1$ +","+results[1]//$NON-NLS-1$
			 * +","+0+",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ stmt.execute(query); key++; //ACCOUNT
			 * SELL query = "insert into turq_inventory_accounting_accounts values(" //$NON-NLS-1$ +key +","+results[0] //$NON-NLS-1$
			 * +","+results[2] //$NON-NLS-1$ +","+1+",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$
			 * stmt.execute(query); key++; //BUY VAT query = "insert into turq_inventory_accounting_accounts values(" //$NON-NLS-1$ +key
			 * +","+results[0]//$NON-NLS-1$ +","+results[3] //$NON-NLS-1$ +","+2+",'admin','2005-01-01','admin','2005-01-01')";
			 * //$NON-NLS-1$ //$NON-NLS-2$ stmt.execute(query); key++; //SELL VAT query = "insert into turq_inventory_accounting_accounts
			 * values(" //$NON-NLS-1$ +key +","+results[0] //$NON-NLS-1$ +","+results[4]//$NON-NLS-1$
			 * +","+3+",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ stmt.execute(query); key++; //BUY
			 * SPECIAL VAT query = "insert into turq_inventory_accounting_accounts values(" //$NON-NLS-1$ +key +","+results[0]
			 * //$NON-NLS-1$ +","+results[5] //$NON-NLS-1$ +","+4+",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$
			 * //$NON-NLS-2$ stmt.execute(query); key++; //SELL SPECIAL VAT query = "insert into turq_inventory_accounting_accounts
			 * values(" //$NON-NLS-1$ +key +","+results[0] //$NON-NLS-1$ +","+results[6]//$NON-NLS-1$
			 * +","+5+",'admin','2005-01-01','admin','2005-01-01')"; //$NON-NLS-1$ //$NON-NLS-2$ stmt.execute(query); key++; }
			 * tx.commit(); session.flush(); session.close();
			 */
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
		 * stmt.execute(query); } tx.commit(); session.flush(); session.close(); } catch (Exception ex) { ex.printStackTrace();
		 * tx.rollback(); }
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
			ex.printStackTrace();
		}
	}
}