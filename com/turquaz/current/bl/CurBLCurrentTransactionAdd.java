package com.turquaz.current.bl;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.ui.component.DatePicker;

public class CurBLCurrentTransactionAdd
{
	
	public static TurqCurrentTransaction saveCurrentTransaction(TurqCurrentCard curCard, Date transDate, String documentNo,
			boolean isCredit, BigDecimal amount, BigDecimal totalDiscount, int type, Integer seqDocNo, String definition,
			TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		try
		{
			TurqEngineSequence docSeq = new TurqEngineSequence();
			
			if (seqDocNo == null)
			{
				TurqModule module = new TurqModule();
				module.setId(new Integer(4));
				docSeq.setTurqModule(module);
				EngDALCommon.saveObject(docSeq);
			}
			else
			{
				docSeq.setId(seqDocNo);
			}
			TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
			curTrans.setTurqCurrentCard(curCard);
			curTrans.setTransactionsDate(transDate);
			curTrans.setTransactionsDocumentNo(documentNo);
			curTrans.setTransactionsTotalDiscount(totalDiscount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			curTrans.setTotalDiscountInForeignCurrency(totalDiscount);
			curTrans.setTransactionsDefinition(definition.toUpperCase(Locale.getDefault()));
			curTrans.setTurqEngineSequence(docSeq);
			if (isCredit)
			{
				curTrans.setTransactionsTotalCredit(amount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				curTrans.setTotalCreditInForeignCurrency(amount);
				curTrans.setTransactionsTotalDept(new BigDecimal(0));
				curTrans.setTotalDeptInForeignCurrency(new BigDecimal(0));
			}
			else
			{
				curTrans.setTransactionsTotalCredit(new BigDecimal(0));
				curTrans.setTotalCreditInForeignCurrency(new BigDecimal(0));
				curTrans.setTotalDeptInForeignCurrency(amount);
				curTrans.setTransactionsTotalDept(amount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
			}
			curTrans.setTurqCurrencyExchangeRate(exchangeRate);
			TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
			transType.setId(new Integer(type));
			curTrans.setTurqCurrentTransactionType(transType);
			curTrans.setCreatedBy(System.getProperty("user"));
			curTrans.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			curTrans.setLastModified(cal.getTime());
			curTrans.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(curTrans);
			return curTrans;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static TurqCurrentTransaction saveOtherCurrentTransaction(HashMap argMap) throws Exception
	{
		
		
		TurqCurrentCard curCard = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		Date transDate = (Date)argMap.get(EngKeys.DATE);
		String documentNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Boolean isCredit = (Boolean)argMap.get(CurKeys.CUR_IS_CREDIT);
		BigDecimal amount = (BigDecimal)argMap.get(CurKeys.CUR_TRANS_AMOUNT);
		BigDecimal totalDiscount = (BigDecimal)argMap.get(CurKeys.CUR_DISCOUNT_PAYMENT);
		Integer type = (Integer)argMap.get(EngKeys.TYPE);
		Integer seqDocNo = (Integer)argMap.get(EngKeys.ENG_SEQ_ID);
		String definition = (String)argMap.get(EngKeys.DEFINITION);
		TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
		
			TurqCurrentTransaction curTrans = saveCurrentTransaction(curCard, transDate, documentNo, isCredit.booleanValue(), amount, totalDiscount,
					type.intValue(), seqDocNo, definition, exchangeRate);
			if (account == null)
			{
				return curTrans;
			}
			else
			{
				AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
				//muhasebe fisi kalemlerini de ekleyelim..
				// add accounting bill rows
				String transDefinition = "Cari Borc/Alacak " + DatePicker.formatter.format(transDate) + " " + documentNo;
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				prepareAccountingMaps(curCard, isCredit.booleanValue(), amount, account, deptAccounts, creditAccounts);
				AccBLTransactionAdd.saveAccTransaction(transDate, documentNo, EngBLCommon.ACCOUNTING_TRANS_GENERAL,
						EngBLCommon.MODULE_CURRENT, curTrans.getTurqEngineSequence().getId(), transDefinition, exchangeRate,
						creditAccounts, deptAccounts, true);
				return curTrans;
			}
		
	}

	/**
	 * @param curCard
	 * @param transDate
	 * @param documentNo
	 * @param isCredit
	 *             Kasa Hareketi Tipini belirler
	 * @param amount
	 * @param totalDiscount
	 * @param type
	 *             Hareketin tipi (nakit, fatura v.s.)
	 * @param account
	 *             Kasa muhasebe hesabi
	 * @throws Exception
	 */
	//DONE
	public static void saveCurrentCashTransaction(HashMap argMap)
			throws Exception
	{

		TurqCurrentCard curCard = (TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
		TurqAccountingAccount account = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		Date transDate = (Date)argMap.get(EngKeys.DATE);
		String documentNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Boolean isCredit = (Boolean)argMap.get(CurKeys.CUR_IS_CREDIT);
		BigDecimal amount = (BigDecimal)argMap.get(CurKeys.CUR_TRANS_AMOUNT);
		BigDecimal totalDiscount = (BigDecimal)argMap.get(CurKeys.CUR_DISCOUNT_PAYMENT);
		Integer type = (Integer)argMap.get(EngKeys.TYPE);
		Integer seqDocNo = (Integer)argMap.get(EngKeys.ENG_SEQ_ID);
		TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		
			//Accounting Integration
			//Eger bir Nakit hareketi ise Muhasebe kaydini yap
			//Daha sonra cari hareketi ekle
			//Nakit hareketi degilse hic birsey yapma.
			if (type.intValue() == 4)
			{
				int accTransactionType = 1; //0-Tahsil, 1-Tediye, 2-Mahsup
				// 0 = collect
				// 1 = payment
				// 2 = general transaction
				//Cari Karta para verildiginde
				//Kasaya alacak hareketi (Tediye fisi)
				if (isCredit.booleanValue())
				{
					accTransactionType = 1;
				}
				//Cari Karttan para tahsil edildiginde
				//Kasaya borc hareketi(Tahsil fisi)
				else
				{
					accTransactionType = 0;
				}
				AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
				//4-Cari modulu id si..
				// current module id
				TurqEngineSequence seq = new TurqEngineSequence();
				TurqModule module = new TurqModule();
				module.setId(new Integer(4));
				seq.setTurqModule(module);
				EngDALCommon.saveObject(seq);
				String transDefinition = "Cari " + DatePicker.formatter.format(transDate) + " " + documentNo;
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				prepareAccountingMaps(curCard, isCredit.booleanValue(), amount, account, deptAccounts, creditAccounts);
				AccBLTransactionAdd.saveAccTransaction(transDate, documentNo, accTransactionType, 4, seq.getId(), transDefinition,
						exchangeRate, creditAccounts, deptAccounts, true);
				//Simdi Cari Hareketi Kaydedebiliriz.
				// insert current transactions
				TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
				curTrans.setTransactionsDate(transDate);
				curTrans.setTransactionsDocumentNo(documentNo);
				curTrans.setTurqCurrentCard(curCard);
				curTrans.setTurqEngineSequence(seq);
				curTrans.setTurqCurrencyExchangeRate(exchangeRate);
				TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
				transType.setId(type);
				curTrans.setTransactionsTotalDiscount(totalDiscount.multiply(exchangeRate.getExchangeRatio()).setScale(2,
						EngBLCommon.ROUNDING_METHOD));
				curTrans.setTotalDiscountInForeignCurrency(totalDiscount);
				curTrans.setTurqCurrencyExchangeRate(exchangeRate);
				curTrans.setTurqCurrentTransactionType(transType);
				curTrans.setCreatedBy(System.getProperty("user"));
				curTrans.setUpdatedBy(System.getProperty("user"));
				Calendar cal = Calendar.getInstance();
				curTrans.setLastModified(cal.getTime());
				curTrans.setCreationDate(cal.getTime());
				EngDALCommon.saveObject(curTrans);
			}
		
	}

	/**
	 * Nakit Muhasebe fisi kalemlerini kaydet
	 * 
	 * @param curCard
	 * @param transDate
	 * @param isCredit
	 * @param amount
	 * @param account
	 *             "cari karttaki muhasebe hesabina karsilik gelecek muhasebe kodu"
	 * @param AccTransId
	 *             Accounting transaction id
	 */
	//TODO DONE
	private static void prepareAccountingMaps(TurqCurrentCard curCard, boolean isCredit, BigDecimal amount, TurqAccountingAccount account,
			Map deptAccounts, Map creditAccounts) throws Exception
	{
		try
		{
			Integer accountId = account.getId();
			Integer currentAccountId = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard, EngBLCommon.CURRENT_ACC_TYPE_GENERAL)
					.getId();
			//Cari Karta para verildiginde
			//Kasaya alacak hareketi
			//Cari kartin satici muhasebe hesabina borc hareketi
			if (!isCredit)
			{
				List creditRows = (List) creditAccounts.get(accountId);
				if (creditRows == null)
				{
					creditRows = new ArrayList();
					creditAccounts.put(accountId, creditRows);
				}
				creditRows.add(amount);
				List deptRows = (List) deptAccounts.get(currentAccountId);
				if (deptRows == null)
				{
					deptRows = new ArrayList();
					deptAccounts.put(currentAccountId, deptRows);
				}
				deptRows.add(amount);
			}
			//Cari Karttan para tahsil edildiginde
			//Kasaya borc hareketi
			//Cari kartin alici muhasebe hesabina alacak hareketi
			else
			{
				List deptRows = (List) deptAccounts.get(accountId);
				if (deptRows == null)
				{
					deptRows = new ArrayList();
					deptAccounts.put(accountId, deptRows);
				}
				deptRows.add(amount);
				List creditRows = (List) creditAccounts.get(currentAccountId);
				if (creditRows == null)
				{
					creditRows = new ArrayList();
					creditAccounts.put(currentAccountId, creditRows);
				}
				creditRows.add(amount);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @return butun cari kartlar listesi
	 * @throws Exception
	 */
	public static List getCurrentCards() throws Exception
	{
		try
		{
			return CurDALCurrentTransactionAdd.getCurrentCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	
	public static List getCurrentTransactionTypes() throws Exception
	{
		try
		{
			return CurDALCurrentTransactionAdd.getTransactionTypes();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}