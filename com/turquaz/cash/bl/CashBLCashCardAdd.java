package com.turquaz.cash.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCashTransactionType;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

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
 * @author onsel
 * @version $Id$
 */
public class CashBLCashCardAdd
{
	CashDALCashCard dalCash = new CashDALCashCard();


	public static void saveCashCard(HashMap argMap ) throws Exception
	{
		
		
		 String name = (String) argMap.get(CashKeys.CASH_CARD_NAME);
		 String definition = (String) argMap.get(EngKeys.DEFINITION);
		 Integer cashAccountId =(Integer)argMap.get(AccKeys.ACC_ACCOUNT_ID);
		 
         TurqAccountingAccount acc = new TurqAccountingAccount();
         acc.setId(cashAccountId);
         
			Calendar cal = Calendar.getInstance();
			TurqCashCard cashCard = new TurqCashCard();
			cashCard.setCashCardName(name);
			cashCard.setCashCardDefinition(definition);
			cashCard.setTurqAccountingAccount(acc);
			cashCard.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cashCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cashCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cashCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(cashCard);
			
			saveInitialTransaction(cashCard);
			EngBLCashCards.RefreshContentAsistantMap();
			
	
	}
	public static void saveInitialTransaction(TurqCashCard cashCard)throws Exception
	{
		TurqEngineSequence seq;
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_BANKS));
		seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqCashTransactionType transType = new TurqCashTransactionType();
		transType.setId(new Integer(EngBLCommon.CASH_INITIAL_TRANSACTION));
		
		TurqCashTransaction cashTrans = new TurqCashTransaction();
		
		cashTrans.setTurqEngineSequence(seq);
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		
		cashTrans.setTransactionDate(cal.getTime());
		cashTrans.setTransactionDefinition("Aç?l?? Hareketi");
		cashTrans.setDocumentNo(""); //$NON-NLS-1$
		cashTrans.setTurqCashTransactionType(transType);
		cashTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		cashTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		cashTrans.setLastModified(Calendar.getInstance().getTime());
		cashTrans.setCreationDate(Calendar.getInstance().getTime());
		/*
		 * Transaction Rows
		 */
		TurqCashTransactionRow transRow = new TurqCashTransactionRow();
		transRow.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		transRow.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		transRow.setLastModified(Calendar.getInstance().getTime());
		transRow.setCreationDate(Calendar.getInstance().getTime());
		transRow.setTurqCashCard(cashCard);
		transRow.setTurqCurrencyExchangeRate(EngBLClient.getBaseCurrencyExchangeRate());
		transRow.setDeptAmount(new BigDecimal(0));
		transRow.setCreditAmount(new BigDecimal(0));
		transRow.setDeptAmountInForeignCurrency(new BigDecimal(0));
		transRow.setCreditAmountInForeignCurrency(new BigDecimal(0));
		transRow.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
		/**
		 * Save transaction bill
		 */
		EngDALCommon.saveObject(cashTrans);
		/**
		 * Save transaction row
		 */
		transRow.setTurqCashTransaction(cashTrans);
		EngDALCommon.saveObject(transRow);
		
		
	}
}