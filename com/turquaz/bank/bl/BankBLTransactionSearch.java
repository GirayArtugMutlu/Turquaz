package com.turquaz.bank.bl;

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
 * @author Onsel
 * @version $Id$
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.admin.AdmKeys;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;

public class BankBLTransactionSearch
{
	
	public static HashBag getTransactionInfo(HashMap argMap)throws Exception
	{
		Integer transId = (Integer)argMap.get(BankKeys.BANK_TRANS_BILL_ID);
		TurqBanksTransactionBill transBill = BankDALCommon.initializeTransaction(transId);
		
		HashBag transBag = new HashBag();
        transBag.put(EngKeys.DOCUMENT_NO,transBill.getTransactionBillNo());
		transBag.put(EngKeys.DEFINITION,transBill.getTransactionBillDefinition());
		transBag.put(EngKeys.DATE,transBill.getTransactionBillDate());

		
		Iterator it = transBill.getTurqBanksTransactions().iterator();
		int i=0;
		while(it.hasNext())
		{
			
			TurqBanksTransaction transRow = (TurqBanksTransaction)it.next();
			transBag.put(BankKeys.BANK_TRANSACTION_ROWS,i,BankKeys.BANK_CODE,transRow.getTurqBanksCard().getBankCode());
			transBag.put(BankKeys.BANK_TRANSACTION_ROWS,i,EngKeys.CREDIT_AMOUNT,transRow.getCreditAmountInForeignCurrency());
			transBag.put(BankKeys.BANK_TRANSACTION_ROWS,i,EngKeys.DEPT_AMOUNT,transRow.getDeptAmountInForeignCurrency());
			transBag.put(BankKeys.BANK_TRANSACTION_ROWS,i,AdmKeys.ADM_CURRENCY_ABBR,transRow.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());			
			transBag.put(AdmKeys.ADM_CURRENCY_ABBR,transRow.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			i++;
		}
		
		Iterator it2 = transBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
		if (it2.hasNext())
		{
			
				TurqCashTransaction cashTrans = (TurqCashTransaction)it2.next();
				
				CashDALCashCard.initiliazeCashTrans(cashTrans);
				Iterator it3 = cashTrans.getTurqCashTransactionRows().iterator();
				TurqCashCard curCard = null;
				
				if (it3.hasNext())
				{
					TurqCashTransactionRow cashTransRow = (TurqCashTransactionRow) it3.next();
					curCard = cashTransRow.getTurqCashCard();
				}
				transBag.put(CashKeys.CASH_CARD_NAME,curCard.getCashCardName());
		
		}
		Iterator it3 = transBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
		if(it3.hasNext())
		{
			TurqCurrentTransaction curTrans = (TurqCurrentTransaction) it3.next();
			TurqCurrentCard curCard = curTrans.getTurqCurrentCard();
			transBag.put(CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());
			transBag.put(CurKeys.CUR_CURRENT_CODE,curCard.getCardsCurrentCode());
		
		}
	
		Iterator it4 =transBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		if(it4.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction)it4.next();
			
			AccDALTransactionUpdate.initializeTransactionRows(accTrans);
			Iterator it5 = accTrans.getTurqAccountingTransactionColumns().iterator();
			while(it5.hasNext())
			{
				TurqAccountingTransactionColumn transColumn = (TurqAccountingTransactionColumn) it5.next();
				
				if(transBill.getTurqBanksTransactionType().getId().intValue()==EngBLCommon.BANK_TRANS_OTHER_DRAW)
				{
					
					if(transColumn.getDeptAmount().doubleValue()>0)
					{
					
						transBag.put(AccKeys.ACC_ACCOUNT_CODE,transColumn.getTurqAccountingAccount().getAccountCode());
						
					}
					
				}
				else if(transBill.getTurqBanksTransactionType().getId().intValue()==EngBLCommon.BANK_TRANS_OTHER_DEPOSIT)
					
				{
					
					if(transColumn.getCreditAmount().doubleValue()>0)
					{
					
						transBag.put(AccKeys.ACC_ACCOUNT_CODE,transColumn.getTurqAccountingAccount().getAccountCode());
						
					}
					
				}
			}
			
			
			
		}
		
		return transBag;
	}
		
		
	
	
	public static HashBag searchtransaction(HashMap argMap) throws Exception
	{
		try
		{
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			HashBag transBag = new HashBag();
			List list = BankDALCommon.searchBankTransactions(docNo, startDate, endDate);
			
			transBag.put(BankKeys.BANK_TRANSACTIONS,new HashMap());
			
			for(int i=0;i<list.size();i++)
			{
				Object results[] = (Object[])list.get(i);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,BankKeys.BANK_TRANS_BILL_ID,results[0]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.DATE,results[1]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.TYPE_NAME,results[2]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.DEFINITION,results[3]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.DOCUMENT_NO,results[4]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.DEPT_AMOUNT,results[5]);
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.CREDIT_AMOUNT,results[6]);				
				transBag.put(BankKeys.BANK_TRANSACTIONS,i,EngKeys.TYPE_ID,results[7]);
			}
			return transBag;
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactions(HashMap argMap) throws Exception
	{
		try
		{
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
			
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
			
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			return BankDALCommon.getTransactions(bankCard, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//Devreden Toplam
	public static List getDeferredTotal(HashMap argMap) throws Exception
	{
		try
		{
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
			
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
			
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			return BankDALCommon.getDeferredTotal(bankCard, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//aC?L?S Degerleri
	public static List getBankInitialTransactions() throws Exception
	{
		try
		{
			return BankDALCommon.getBankInitialTransactions();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}