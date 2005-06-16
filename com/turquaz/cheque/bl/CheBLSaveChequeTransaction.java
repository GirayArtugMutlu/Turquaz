package com.turquaz.cheque.bl;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.CheServerLangKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeRollAccountingAccount;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class CheBLSaveChequeTransaction
{
	
	public static void saveChequeRoll(HashMap argMap) throws Exception
	{
		
		Integer rollAccountId = (Integer)argMap.get(AccKeys.ACC_ACCOUNT_ID);
		TurqAccountingAccount rollAccount =null;
		if(rollAccountId!=null)
		{
			rollAccount =(TurqAccountingAccount)EngDALSessionFactory.getSession().load(TurqAccountingAccount.class,rollAccountId);
		}
		
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		}
		
		Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
		TurqBanksCard bankCard = null;
		if(bankCardId!=null)
		{
			bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);
		}
		
		
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Date rollDate = (Date)argMap.get(EngKeys.DATE);
		List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		Integer rollType = (Integer)argMap.get(EngKeys.TYPE);
		Boolean sumTransTotal = (Boolean)argMap.get(CheKeys.CHE_SUM_TRANS);
		
		
		TurqCurrencyExchangeRate exchangeRate = EngDALCommon.getCurrencyExchangeRate(EngBLClient.getBaseCurrencyId(),rollDate);
		
			TurqChequeTransactionType type = new TurqChequeTransactionType();
			type.setId(rollType);
			TurqModule module = new TurqModule();
			module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
			TurqEngineSequence seq = new TurqEngineSequence();
			seq.setTurqModule(module);
			EngDALCommon.saveObject(seq);
			TurqChequeRoll chequeRoll = new TurqChequeRoll();
			chequeRoll.setChequeRollsDate(rollDate);
			chequeRoll.setChequeRollNo(rollNo);
			chequeRoll.setTurqChequeTransactionType(type);
			chequeRoll.setSumChequeAmounts(sumTransTotal.booleanValue());
			chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeRoll.setLastModified(Calendar.getInstance().getTime());
			chequeRoll.setCreationDate(Calendar.getInstance().getTime());
			if (curCard != null)
			{
				chequeRoll.setTurqCurrentCard(curCard);
				TurqBanksCard bankCardEmpty = new TurqBanksCard();
				bankCardEmpty.setId(new Integer(-1));
				chequeRoll.setTurqBanksCard(bankCardEmpty);
			}
			else if (bankCard != null)
			{
				chequeRoll.setTurqBanksCard(bankCard);
				TurqCurrentCard curCardEmpty = new TurqCurrentCard();
				curCardEmpty.setId(new Integer(-1));
				chequeRoll.setTurqCurrentCard(curCardEmpty);
			}
			chequeRoll.setTurqEngineSequence(seq);
			EngDALCommon.saveObject(chequeRoll);
			if (rollAccount != null)
			{
				TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
				rollAccountingAccount.setId(chequeRoll.getId());
				rollAccountingAccount.setTurqChequeRoll(chequeRoll);
				rollAccountingAccount.setTurqAccountingAccount(rollAccount);
				EngDALCommon.saveObject(rollAccountingAccount);
			}
			TurqChequeCheque cheque;
			
			BigDecimal totalAmount = new BigDecimal(0);
			for (int i = 0; i < chequeList.size(); i++)
			{
				TurqChequeChequeInRoll chequeInRoll = new TurqChequeChequeInRoll();
				
				
				cheque = saveCheque((HashMap)chequeList.get(i),rollDate);				            
				
				
				chequeInRoll.setTurqChequeCheque(cheque);
				chequeInRoll.setTurqChequeRoll(chequeRoll);
				chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
				chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				chequeInRoll.setLastModified(Calendar.getInstance().getTime());
				chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
				EngDALCommon.saveObject(chequeInRoll);
				totalAmount = totalAmount.add(cheque.getChequesAmount());
				//save current transaction...
				if (curCard != null && !sumTransTotal.booleanValue())
				{
					if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_IN.intValue())
					{
						CurBLCurrentTransactionAdd
								.saveCurrentTransaction(curCard, rollDate, rollNo, true, cheque.getChequesAmount(), new BigDecimal(
										0), EngBLCommon.CURRENT_TRANS_CHEQUE, seq.getId(), CheServerLangKeys.PORTFOLIO_NO+ cheque.getChequesPortfolioNo(), exchangeRate); //$NON-NLS-1$
					}
					else if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
					{
						CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, false,
								cheque.getChequesAmount(), new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, seq.getId(),
                                CheServerLangKeys.PORTFOLIO_NO + cheque.getChequesPortfolioNo(), exchangeRate); //$NON-NLS-1$
					}
				}
				/*
				 * if(bankCard!=null&&!sumTransTotal) {
				 * BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,cheque.getChequesAmount(),rollDate,"Çek Portfoy
				 * No:"+cheque.getChequesPortfolioNo(),rollNo); }
				 */
			}
			if (curCard != null && sumTransTotal.booleanValue())
			{
				if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_IN.intValue())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, true, totalAmount, new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE, seq.getId(),
                            CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo(), exchangeRate); //$NON-NLS-1$
				}
				else if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, false, totalAmount,
							new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, seq.getId(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo(), exchangeRate); //$NON-NLS-1$
				}
			}
			if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_IN.intValue())
			{
				TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
						EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				//         	TODO acc trans exRate
				saveRollAccountingTransactions(rollAccount, curAccount, chequeRoll, totalAmount, EngDALCommon
						.getBaseCurrencyExchangeRate(),
                        CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
			{
				saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngDALCommon.getBaseCurrencyExchangeRate(),
                        CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
			{
				TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
						EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				saveRollAccountingTransactions(curAccount, null, chequeRoll, totalAmount, EngDALCommon.getBaseCurrencyExchangeRate(),
                        CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			/*
			 * if(bankCard!=null&&sumTransTotal) { BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,totalAmount,rollDate,"Çek
			 * Bordro No:"+rollNo,rollNo); }
			 */
		
	}

	private static TurqChequeCheque saveCheque(HashMap chequeInfo,Date rollDate)throws Exception
	{
		TurqChequeCheque cheque = new TurqChequeCheque();
		cheque.setBankAccountNo((String)chequeInfo.get(BankKeys.BANK_ACCOUNT_NO));
		cheque.setBankBranchName((String)chequeInfo.get(BankKeys.BANK_BRANCH_NAME));
		cheque.setBankName((String)chequeInfo.get(BankKeys.BANK_NAME));
		cheque.setChequesAmount((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
		cheque.setChequesAmountInForeignCurrency((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
		cheque.setChequesDebtor((String)chequeInfo.get(CheKeys.CHE_DEBTOR));
		cheque.setChequesDueDate((Date)chequeInfo.get(EngKeys.DATE));
		cheque.setChequesNo((String)chequeInfo.get(CheKeys.CHE_CHEQUE_NO));
		cheque.setChequesPaymentPlace((String)chequeInfo.get(CheKeys.CHE_PAYMENT_PLACE));
		cheque.setChequesPortfolioNo((String)chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO));
		cheque.setChequesType(((Integer)chequeInfo.get(EngKeys.TYPE_ID)).intValue());
		cheque.setChequesValueDate((Date)chequeInfo.get(EngKeys.DATE));
		cheque.setCreatedBy(System.getProperty("user"));
		cheque.setCreationDate(Calendar.getInstance().getTime());
		cheque.setLastModified(Calendar.getInstance().getTime());
		cheque.setUpdatedBy(System.getProperty("user"));
		
		
		TurqBanksCard bankCard = new TurqBanksCard();
		bankCard.setId((Integer)chequeInfo.get(BankKeys.BANK_ID));		
		cheque.setTurqBanksCard(bankCard);
		
		Integer currencyId = (Integer)chequeInfo.get(EngKeys.CURRENCY_ID);
		TurqCurrency currency = new TurqCurrency();
		currency.setId(currencyId);		
		cheque.setTurqCurrency(currency);
		
		
		
		cheque.setTurqCurrencyExchangeRate(EngDALCommon.getCurrencyExchangeRate(currencyId,rollDate));
		
		if(chequeInfo.get(CheKeys.CHE_CHEQUE_ID)==null)
		{			
			EngDALCommon.saveObject(cheque);
		}
		else
		{
			cheque.setId((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			EngDALCommon.updateObject(cheque);
		}
		
	
		return cheque;
		
	}
	
	public static void saveCollectOfOwnCheques(HashMap argMap)throws Exception
	{
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Date rollDate = (Date)argMap.get(EngKeys.DATE);
		List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE);
		
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		TurqChequeChequeInRoll chequeInRoll;
		TurqChequeCheque cheque;
		for (int i = 0; i < chequeList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			cheque = (TurqChequeCheque) chequeList.get(i);
			chequeInRoll.setTurqChequeCheque(cheque);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			EngDALCommon.saveObject(chequeInRoll);
			BankBLTransactionAdd.saveOwnChequeCollect(cheque.getTurqBanksCard(), seq, cheque.getChequesAmount(),
					rollDate,
                    CheServerLangKeys.ROLL_NO + rollNo, rollNo, cheque.getTurqCurrencyExchangeRate());  //$NON-NLS-1$
		}
		
		saveRollAccountingTransactions(null, null, chequeRoll, null, EngDALCommon.getBaseCurrencyExchangeRate(), "Firma Çeki Tahsili" + chequeRoll.getChequeRollNo()); 
	
		
		
		
	}
	
	public static void saveCollectFromBank(HashMap argMap) throws Exception
	{
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Date rollDate = (Date)argMap.get(EngKeys.DATE);
		List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK);
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		TurqChequeChequeInRoll chequeInRoll;
		
		for (int i = 0; i < chequeList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			
			HashMap chequeInfo = (HashMap) chequeList.get(i);
			Integer chequeId = (Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID);
			TurqChequeCheque cheq =(TurqChequeCheque)EngDALSessionFactory.getSession().load(TurqChequeCheque.class,chequeId);
					
			chequeInRoll.setTurqChequeCheque(cheq);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			EngDALCommon.saveObject(chequeInRoll);
			BankBLTransactionAdd.saveChequeTransaction(CheDALSearch.getBankOfCustomerCheque(cheq), seq, cheq.getChequesAmount(),
					rollDate,
                    CheServerLangKeys.ROLL_NO + rollNo, rollNo, cheq.getTurqCurrencyExchangeRate()); //$NON-NLS-1$
		}
		saveRollAccountingTransactions(null, null, chequeRoll, null, EngDALCommon.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
	}

	public static void saveReturnFromBank(HashMap argMap)
			throws Exception
	{
		
		TurqAccountingAccount rollAccount = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date rollDate = (Date)argMap.get(EngKeys.DATE);
		 List chequeList = (List) argMap.get(CheKeys.CHE_CHEQUE_LIST);
		
		
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY);
		
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		if (rollAccount != null)
		{
			TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
			rollAccountingAccount.setId(chequeRoll.getId());
			rollAccountingAccount.setTurqChequeRoll(chequeRoll);
			rollAccountingAccount.setTurqAccountingAccount(rollAccount);
			EngDALCommon.saveObject(rollAccountingAccount);
		}
		TurqChequeChequeInRoll chequeInRoll;
		HashMap chequeInfo;
		BigDecimal amount = new BigDecimal(0);
		for (int i = 0; i < chequeList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			
			chequeInfo = (HashMap) chequeList.get(i);
			
			TurqChequeCheque cheque = new TurqChequeCheque();
			cheque.setId((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			
			chequeInRoll.setTurqChequeCheque(cheque);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			amount = amount.add((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			EngDALCommon.saveObject(chequeInRoll);
		}
		saveRollAccountingTransactions(rollAccount, null, chequeRoll, amount,EngDALCommon.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
	}

	public static void saveReturnToCurrent(HashMap argMap)
			throws Exception
	{
		
		TurqAccountingAccount rollAccount = (TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date rollDate = (Date)argMap.get(EngKeys.DATE);
		 List chequeList = (List) argMap.get(CheKeys.CHE_CHEQUE_LIST);
		
		
		
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT);
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		if (rollAccount != null)
		{
			TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
			rollAccountingAccount.setId(chequeRoll.getId());
			rollAccountingAccount.setTurqChequeRoll(chequeRoll);
			rollAccountingAccount.setTurqAccountingAccount(rollAccount);
			EngDALCommon.saveObject(rollAccountingAccount);
		}
		TurqChequeChequeInRoll chequeInRoll;
		HashMap chequeInfo;
		BigDecimal amount = new BigDecimal(0);
		for (int i = 0; i < chequeList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			
			chequeInfo = (HashMap) chequeList.get(i);
			
			
			TurqChequeCheque cheque =new TurqChequeCheque();
			
			cheque.setId((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			
			chequeInRoll.setTurqChequeCheque(cheque);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			amount = amount.add((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			EngDALCommon.saveObject(chequeInRoll);
			
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			CurBLCurrentTransactionAdd
					.saveCurrentTransaction(
							curCard,
							chequeRoll.getChequeRollsDate(),
							chequeRoll.getChequeRollNo(),
							false,
							(BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT),
							new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE,
							chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO+(String)chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO), EngDALCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
		}
		saveRollAccountingTransactions(rollAccount, null, chequeRoll, amount, EngDALCommon.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
	}

	public static void saveReturnFromCurrent(HashMap argMap) throws Exception
	{
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		Date rollDate = (Date)argMap.get(EngKeys.DATE);
		List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		
		
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT);
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		TurqChequeChequeInRoll chequeInRoll;
		HashMap chequeInfo;
		BigDecimal amount = new BigDecimal(0);
		for (int i = 0; i < chequeList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			chequeInfo = (HashMap) chequeList.get(i);
			
			TurqChequeCheque cheque = new TurqChequeCheque();
			cheque.setId((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			
			
			chequeInRoll.setTurqChequeCheque(cheque);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			amount = amount.add((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			EngDALCommon.saveObject(chequeInRoll);
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			CurBLCurrentTransactionAdd
					.saveCurrentTransaction(
							curCard,
							chequeRoll.getChequeRollsDate(),
							chequeRoll.getChequeRollNo(),
							false,
							(BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT),
							new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE,
							chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO+ (String)chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO), EngDALCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
		}
		saveRollAccountingTransactions(null, null, chequeRoll, amount, EngDALCommon.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo()); //$NON-NLS-1$
	}

	public static void saveChequeCollect(HashMap argMap ) throws Exception
	{
		Integer cashCardId = (Integer)argMap.get(CashKeys.CASH_CARD_ID);
		TurqCashCard cashCard=(TurqCashCard)EngDALSessionFactory.getSession().load(TurqCashCard.class,cashCardId);
		 
		 String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date rollDate = (Date)argMap.get(EngKeys.DATE);
		 List cheList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		
		
		TurqChequeTransactionType type = new TurqChequeTransactionType();
		type.setId(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT);
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_CHEQUE));
		TurqEngineSequence seq = new TurqEngineSequence();
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		TurqChequeRoll chequeRoll = new TurqChequeRoll();
		chequeRoll.setChequeRollsDate(rollDate);
		chequeRoll.setChequeRollNo(rollNo);
		chequeRoll.setTurqChequeTransactionType(type);
		chequeRoll.setSumChequeAmounts(false);
		chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		chequeRoll.setLastModified(Calendar.getInstance().getTime());
		chequeRoll.setCreationDate(Calendar.getInstance().getTime());
		TurqCurrentCard curCardEmpty = new TurqCurrentCard();
		curCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqCurrentCard(curCardEmpty);
		TurqBanksCard bankCardEmpty = new TurqBanksCard();
		bankCardEmpty.setId(new Integer(-1));
		chequeRoll.setTurqBanksCard(bankCardEmpty);
		chequeRoll.setTurqEngineSequence(seq);
		EngDALCommon.saveObject(chequeRoll);
		if (cashCard.getTurqAccountingAccount() != null)
		{
			TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
			rollAccountingAccount.setId(chequeRoll.getId());
			rollAccountingAccount.setTurqChequeRoll(chequeRoll);
			rollAccountingAccount.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
			EngDALCommon.saveObject(rollAccountingAccount);
		}
		TurqChequeChequeInRoll chequeInRoll;
	
		BigDecimal chequeTotals = new BigDecimal(0);
		for (int i = 0; i < cheList.size(); i++)
		{
			chequeInRoll = new TurqChequeChequeInRoll();
			HashMap chequeInfo = (HashMap) cheList.get(i);
			TurqChequeCheque cheq = new TurqChequeCheque();
			cheq.setId((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
			
			chequeInRoll.setTurqChequeCheque(cheq);
			chequeInRoll.setTurqChequeRoll(chequeRoll);
			chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeInRoll.setLastModified(Calendar.getInstance().getTime());
			chequeInRoll.setCreationDate(Calendar.getInstance().getTime());
			chequeTotals = chequeTotals.add((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			EngDALCommon.saveObject(chequeInRoll);
		}
		List totals = new ArrayList();
		totals.add(chequeTotals);
		/**
		 * TODO accounting entegration da duzeltilecek
		 */
		TurqAccountingAccount account = new TurqAccountingAccount();
		account.setId(new Integer(-1));
		//        TODO bill exRate
		CashBLCashTransactionAdd.saveCashTransaction(cashCard, chequeRoll.getTurqEngineSequence(), EngBLCommon.CASH_CHEQUE_COLLECT,
				rollDate, CheServerLangKeys.ENTRY_ROLL, rollNo, totals, //$NON-NLS-1$
				account, EngDALCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
		saveRollAccountingTransactions(cashCard.getTurqAccountingAccount(), null, chequeRoll, chequeTotals, EngDALCommon
				.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
	}

	public static void saveRollAccountingTransactions(TurqAccountingAccount rollAccount, TurqAccountingAccount counterAccount,
			TurqChequeRoll roll, BigDecimal amount, TurqCurrencyExchangeRate exchangeRate, String definition) throws Exception
	{
		Map creditAccountsMap = new HashMap();
		Map deptAccountsMap = new HashMap();
		boolean okToSave = prepareAccountingRows(creditAccountsMap, deptAccountsMap, rollAccount, counterAccount, roll, amount,
				exchangeRate);
		if (!okToSave)
		{
			return;
		}
		AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
		int accTransType = EngBLCommon.ACCOUNTING_TRANS_GENERAL;
		//  Save Accounting Transaction
		//    		TODO cheq exRate
		AccBLTransactionAdd.saveAccTransaction(roll.getChequeRollsDate(), roll.getChequeRollNo(), accTransType, roll
				.getTurqEngineSequence().getTurqModule().getId().intValue(), roll.getTurqEngineSequence().getId(), definition,
				exchangeRate, creditAccountsMap, deptAccountsMap, true);
	}

	private static boolean prepareAccountingRows(Map creditAccountsMap, Map deptAccountsMap, TurqAccountingAccount rollAccount,
			TurqAccountingAccount counterAccount, TurqChequeRoll roll, BigDecimal amount, TurqCurrencyExchangeRate exchangeRate)
			throws Exception
	{
		creditAccountsMap.clear();
		deptAccountsMap.clear();
		int type = roll.getTurqChequeTransactionType().getId().intValue();
		if (type == EngBLCommon.CHEQUE_TRANS_IN.intValue())
		{
			if (rollAccount == null)
			{
				return false;
			}
			if (counterAccount == null)
			{
				return false;
			}
			List deptList = new ArrayList();
			deptList.add(amount);
			deptAccountsMap.put(rollAccount.getId(), deptList);
			List creditList = new ArrayList();
			creditList.add(amount);
			creditAccountsMap.put(counterAccount.getId(), creditList);
		}
		else if(type == EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE.intValue())
		{
			
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount givenChequesAccount = null;
			TurqAccountingAccount bankGeneralAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				
				givenChequesAccount = BankBLBankCardSearch.getAccountingAccount(cheque.getTurqBanksCard(), EngBLCommon.BANK_ACC_TYPE_CHEQUES_GIVEN);
				
				bankGeneralAccount = BankBLBankCardSearch.getAccountingAccount(cheque.getTurqBanksCard(), EngBLCommon.BANK_ACC_TYPE_GENERAL);
				
				if (givenChequesAccount == null)
				{
					System.out.println("asdasd");
					return false;
				}
				if (bankGeneralAccount == null)
				{
					
					return false;
				}
				
				
				if (deptAccountsMap.containsKey(givenChequesAccount.getId()))
				{
					List ls = (List) deptAccountsMap.get(givenChequesAccount.getId());
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(givenChequesAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(givenChequesAccount.getId(), ls);
				}
				if (creditAccountsMap.containsKey(bankGeneralAccount.getId()))
				{
					List ls = (List)creditAccountsMap.get(bankGeneralAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(bankGeneralAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(bankGeneralAccount.getId(), ls);
				}
			}
						
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
		{
			if (rollAccount == null)
			{
				return false;
			}
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount chequeAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				chequeAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_IN.intValue());
				if (chequeAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(chequeAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(chequeAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(chequeAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(chequeAccount.getId(), ls);
				}
			}
			List deptList = new ArrayList();
			deptList.add(amount);
			deptAccountsMap.put(rollAccount.getId(), deptList);
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
		{
			if (rollAccount == null)
			{
				return false;
			}
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount chequeAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				if (cheque.getChequesType() == EngBLCommon.CHEQUE_TYPE_CUSTOMER)
				{
					chequeAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_IN.intValue());
			       
				}
				else
				{
					TurqBanksCard bankCard = cheque.getTurqBanksCard();
					chequeAccount = BankBLBankCardSearch.getAccountingAccount(bankCard, EngBLCommon.BANK_ACC_TYPE_CHEQUES_GIVEN);
				}
				if (chequeAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(chequeAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(chequeAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(chequeAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(chequeAccount.getId(), ls);
				}
			}
			List deptList = new ArrayList();
			deptList.add(amount);
			deptAccountsMap.put(rollAccount.getId(), deptList);
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
		{
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount deptAccount = null;
			TurqAccountingAccount creditAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				TurqBanksCard bankCard = CheDALSearch.getBankOfCustomerCheque(cheque);
				deptAccount = BankBLBankCardSearch.getAccountingAccount(bankCard, EngBLCommon.BANK_ACC_TYPE_GENERAL);
				creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue());
				if (deptAccount == null || creditAccount == null)
				{
					return false;
				}
				if (deptAccountsMap.containsKey(deptAccount.getId()))
				{
					List ls = (List) deptAccountsMap.get(deptAccount.getId());
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
				if (creditAccountsMap.containsKey(creditAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(creditAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
			}
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT.intValue())
		{
			if (rollAccount == null)
			{
				return false;
			}
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount deptAccount = null;
			TurqAccountingAccount creditAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_IN.intValue());
				if (deptAccount == null || creditAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(creditAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(creditAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
			}
			List deptList = new ArrayList();
			deptList.add(amount);
			deptAccountsMap.put(deptAccount, deptList);
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY.intValue())
		{
			if (rollAccount == null)
			{
				return false;
			}
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount creditAccount = null;
			TurqAccountingAccount deptAccount = rollAccount;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				TurqBanksCard bankCard = CheDALSearch.getBankOfCustomerCheque(cheque);
				creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue());
				if (creditAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(creditAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(creditAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
			}
			List deptList = new ArrayList();
			deptList.add(amount);
			deptAccountsMap.put(deptAccount.getId(), deptList);
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
		{
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount creditAccount = null;
			TurqAccountingAccount deptAccount = null;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque.getId());
				deptAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard, EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				creditAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_IN.intValue());
				if (creditAccount == null || deptAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(creditAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(creditAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				if (deptAccountsMap.containsKey(deptAccount.getId()))
				{
					List ls = (List) deptAccountsMap.get(deptAccount.getId());
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
			}
		}
		else if (type == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT.intValue())
		{
			CheDALUpdate.initializeChequeRoll(roll);
			TurqChequeCheque cheque = null;
			TurqAccountingAccount creditAccount = null;
			TurqAccountingAccount deptAccount = rollAccount;
			Iterator it = roll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
				TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfGivenCheque(cheque.getId());
				creditAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard, EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				deptAccount = CheBLSearchCheques.getChequeRollAccountingAccount(cheque, EngBLCommon.CHEQUE_TRANS_IN.intValue());
				if (creditAccount == null || deptAccount == null)
				{
					return false;
				}
				if (creditAccountsMap.containsKey(creditAccount.getId()))
				{
					List ls = (List) creditAccountsMap.get(creditAccount.getId());
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					creditAccountsMap.put(creditAccount.getId(), ls);
				}
				if (deptAccountsMap.containsKey(deptAccount.getId()))
				{
					List ls = (List) deptAccountsMap.get(deptAccount.getId());
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
				else
				{
					List ls = new ArrayList();
					ls.add(cheque.getChequesAmount());
					deptAccountsMap.put(deptAccount.getId(), ls);
				}
			}
		}
		return true;
	}
}