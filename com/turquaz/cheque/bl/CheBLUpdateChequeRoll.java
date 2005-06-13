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

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.CheServerLangKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeRollAccountingAccount;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLUpdateChequeRoll
{
	
	public static HashBag getChequeRollInfo(HashMap argMap)throws Exception
	{
		
		Integer chequeRollId = (Integer)argMap.get(CheKeys.CHE_CHEQUE_ROLL_ID);
		
		TurqChequeRoll chequeRoll = (TurqChequeRoll)EngDALSessionFactory.getSession().load(TurqChequeRoll.class,chequeRollId);
		
		HashBag rollInfo = new HashBag();
		
		rollInfo.put(EngKeys.DATE,chequeRoll.getChequeRollsDate());
		rollInfo.put(EngKeys.DOCUMENT_NO,chequeRoll.getChequeRollNo());
			
		rollInfo.put(CheKeys.CHE_CHEQUE_LIST,new HashMap());
		
		Iterator it = chequeRoll.getTurqChequeChequeInRolls().iterator();
		int i=0;
		while (it.hasNext())
		{
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
			TurqChequeCheque cheque = chequeInRoll.getTurqChequeCheque();
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_CHEQUE_ID,cheque.getId());
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.DATE,cheque.getChequesDueDate());
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
			rollInfo.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TOTAL_AMOUNT,cheque.getChequesAmountInForeignCurrency());
				
		
		 i++;
		}
		it = chequeRoll.getTurqEngineSequence().getTurqCashTransactions().iterator();
		if (it.hasNext())
		{
			TurqCashTransaction cashTrans = (TurqCashTransaction) it.next();
			
			
			
			Iterator it2 = cashTrans.getTurqCashTransactionRows().iterator();
			while (it2.hasNext())
			{
				TurqCashTransactionRow transRow = (TurqCashTransactionRow) it2.next();
				rollInfo.put(CashKeys.CASH_CARD_NAME,transRow.getTurqCashCard().getCashCardName());
			}
		}
		
		
		
	
	
		
		return rollInfo;
	
	}
	
	
	public static void initializeChequeRoll(HashMap argMap) throws Exception
	{
		TurqChequeRoll chequeRoll = (TurqChequeRoll)argMap.get(CheKeys.CHE_CHEQUE_ROLL);
		CheDALUpdate.initializeChequeRoll(chequeRoll);
		
	}

	public static TurqChequeRoll initializeChequeRollById(HashMap argMap) throws Exception
	{
		Integer chequeRollId = (Integer)argMap.get(EngKeys.TRANS_ID);
			return CheDALUpdate.initializeChequeRoll(chequeRollId);
		
	}

	public static void updateChequeCollectRoll(HashMap argMap) throws Exception
	{
		
		TurqChequeRoll chequeRoll = (TurqChequeRoll)argMap.get(CheKeys.CHE_CHEQUE_ROLL);
		
		Integer cashCardId = (Integer)argMap.get(CashKeys.CASH_CARD_ID);
		TurqCashCard cashCard=(TurqCashCard)EngDALSessionFactory.getSession().load(TurqCashCard.class,cashCardId);
				
		
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date rollDate = (Date)argMap.get(EngKeys.DATE);
		 List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		 
		
			emptyCheckRollIn(chequeRoll);
			chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeRoll.setLastModified(Calendar.getInstance().getTime());
			chequeRoll.setChequeRollNo(rollNo);
			chequeRoll.setChequeRollsDate(rollDate);
			EngDALCommon.updateObject(chequeRoll);
			if (cashCard.getTurqAccountingAccount() != null)
			{
				TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
				rollAccountingAccount.setId(chequeRoll.getId());
				rollAccountingAccount.setTurqChequeRoll(chequeRoll);
				rollAccountingAccount.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
				EngDALCommon.saveObject(rollAccountingAccount);
			}
			BigDecimal chequeTotals = new BigDecimal(0);
			for (int i = 0; i < chequeList.size(); i++)
			{
				TurqChequeCheque cheque = (TurqChequeCheque) chequeList.get(i);
				chequeTotals = chequeTotals.add(cheque.getChequesAmount());
			}
			List totals = new ArrayList();
			totals.add(chequeTotals);
			/**
			 * TODO accounting entegration da duzeltilecek
			 */
			TurqAccountingAccount account = new TurqAccountingAccount();
			account.setId(new Integer(-1));
			//          TODO cheq exRate
			CashBLCashTransactionAdd.saveCashTransaction(cashCard, chequeRoll.getTurqEngineSequence(), EngBLCommon.CASH_CHEQUE_COLLECT,
					rollDate,CheServerLangKeys.ENTRY_ROLL, rollNo, //$NON-NLS-1$
					totals, account, EngBLCommon.getBaseCurrencyExchangeRate()); //$NON-NLS-1$
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(cashCard.getTurqAccountingAccount(), null, chequeRoll,
					chequeTotals, EngBLCommon.getBaseCurrencyExchangeRate(),
                    CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		
	}
	
	public static void updateOwnChequeCollect(HashMap argMap)throws Exception
	{
		TurqChequeRoll chequeRoll = (TurqChequeRoll)argMap.get(CheKeys.CHE_CHEQUE_ROLL);
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
	    Date rollDate = (Date)argMap.get(EngKeys.DATE);
		List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
		emptyCheckRollIn(chequeRoll);
		
		TurqChequeCheque cheque;
		for (int i = 0; i < chequeList.size(); i++)
		{
			cheque = (TurqChequeCheque) chequeList.get(i);
			BankBLTransactionAdd.saveOwnChequeCollect(cheque.getTurqBanksCard(), chequeRoll.getTurqEngineSequence(), cheque.getChequesAmount(),
					rollDate,
                    CheServerLangKeys.ROLL_NO+ rollNo, rollNo, cheque.getTurqCurrencyExchangeRate());  //$NON-NLS-1$

		}
		CheBLSaveChequeTransaction.saveRollAccountingTransactions(null,null,chequeRoll,null,EngBLCommon.getBaseCurrencyExchangeRate(),CheServerLangKeys.ROLL_NO+chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		 
		 
		
		
	}

	public static void updateChequeRollIn(HashMap argMap) throws Exception
	{
		
			
		    Integer cheqRollId =(Integer)argMap.get(CheKeys.CHE_CHEQUE_ROLL_ID);
		    
			TurqChequeRoll chequeRoll = (TurqChequeRoll)EngDALSessionFactory.getSession().load(TurqChequeRoll.class,cheqRollId); 
						
			TurqAccountingAccount rollAccount =(TurqAccountingAccount)argMap.get(AccKeys.ACC_ACCOUNT);
			
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			}; 
			
			Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
				
			TurqBanksCard bankCard = (TurqBanksCard)EngDALSessionFactory.getSession().load(TurqBanksCard.class,bankCardId);

			
			 String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
			 Date rollDate = (Date)argMap.get(EngKeys.DATE);
			 List chequeList = (List)argMap.get(CheKeys.CHE_CHEQUE_LIST);
			 int rollType = ((Integer)argMap.get(EngKeys.TYPE)).intValue();
			 boolean sumTransTotal = ((Boolean)argMap.get(CheKeys.CHE_SUM_TRANS)).booleanValue();
			 TurqCurrencyExchangeRate exchangeRate = (TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
				
			emptyCheckRollIn(chequeRoll);
			chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			chequeRoll.setLastModified(Calendar.getInstance().getTime());
			chequeRoll.setChequeRollNo(rollNo);
			chequeRoll.setChequeRollsDate(rollDate);
			chequeRoll.setSumChequeAmounts(sumTransTotal);
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
			if (rollAccount != null)
			{
				TurqChequeRollAccountingAccount rollAccountingAccount = new TurqChequeRollAccountingAccount();
				rollAccountingAccount.setId(chequeRoll.getId());
				rollAccountingAccount.setTurqChequeRoll(chequeRoll);
				rollAccountingAccount.setTurqAccountingAccount(rollAccount);
				EngDALCommon.saveObject(rollAccountingAccount);
			}
			EngDALCommon.updateObject(chequeRoll);
		
			TurqChequeChequeInRoll chequeInRoll;
			BigDecimal totalAmount = new BigDecimal(0);
			HashMap chequeInfo ;
			for (int i = 0; i < chequeList.size(); i++)
			{
				chequeInfo = (HashMap) chequeList.get(i);
				//save current transaction...
				if (curCard != null && !sumTransTotal)
				{
					if (rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue())
					{
						CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, true,(BigDecimal) chequeInfo.get(EngKeys.TOTAL_AMOUNT),
								new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                                CheServerLangKeys.PORTFOLIO_NO + chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(), exchangeRate); //$NON-NLS-1$
					}
					else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
					{
						CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, false,
								(BigDecimal) chequeInfo.get(EngKeys.TOTAL_AMOUNT), new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll
										.getTurqEngineSequence().getId(),
                                        CheServerLangKeys.PORTFOLIO_NO+ chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(), exchangeRate); //$NON-NLS-1$
					}
				}
				if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
				{
					TurqCurrentCard currentCard = CheDALSearch.getCurrentCardOfCustomerCheque((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
					CurBLCurrentTransactionAdd.saveCurrentTransaction(currentCard, rollDate, rollNo, false, (BigDecimal) chequeInfo.get(EngKeys.TOTAL_AMOUNT),
							new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(), exchangeRate); //$NON-NLS-1$
				}
				else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT.intValue())
				{
					TurqCurrentCard currentCard = CheDALSearch.getCurrentCardOfGivenCheque((Integer)chequeInfo.get(CheKeys.CHE_CHEQUE_ID));
					CurBLCurrentTransactionAdd.saveCurrentTransaction(currentCard, rollDate, rollNo, true, (BigDecimal) chequeInfo.get(EngKeys.TOTAL_AMOUNT),
							new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(), exchangeRate); //$NON-NLS-1$
				}
				/*
				 * if(bankCard!=null&&!sumTransTotal) {
				 * BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),cheque.getChequesAmount(),rollDate,"Çek
				 * Portfoy No:"+cheque.getChequesPortfolioNo(),rollNo); }
				 */
				totalAmount = totalAmount.add((BigDecimal) chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			}
			if (curCard != null && sumTransTotal)
			{
				if (rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, true, totalAmount, new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(), CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo(), exchangeRate); //$NON-NLS-1$
				}
				else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, rollDate, rollNo, false, totalAmount,
							new BigDecimal(0), EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo(), exchangeRate); //$NON-NLS-1$
				}
			}
			if (rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue())
			{
				TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
						EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				//          TODO acc trans exRate
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, curAccount, chequeRoll, totalAmount, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
			{
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
			{
				TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(curCard,
						EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(curAccount, null, chequeRoll, totalAmount, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
			{
				CheBLUpdateCheque.updateBankTransactions(chequeRoll);
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(null, null, chequeRoll, null, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY.intValue())
			{
				CheBLSaveChequeTransaction
						.saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngBLCommon
								.getBaseCurrencyExchangeRate(),
                                CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
			{
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO  + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT.intValue())
			{
				CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngBLCommon
						.getBaseCurrencyExchangeRate(),  CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
			}
			/*
			 * if(bankCard!=null&&sumTransTotal) {
			 * BankBLTransactionAdd.saveChequeTransaction(bankCard,chequeRoll.getTurqEngineSequence(),totalAmount,rollDate,"Çek Bordro
			 * No:"+rollNo,rollNo); }
			 */
		
	}

	private static void emptyCheckRollIn(TurqChequeRoll chequeRoll) throws Exception
	{
		try
		{
			//Delete Current Transaction
			Iterator it = chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//Delete Cash Transactions..
			it = chequeRoll.getTurqEngineSequence().getTurqCashTransactions().iterator();
			while (it.hasNext())
			{
				TurqCashTransaction cashTrans = (TurqCashTransaction) it.next();
				CashDALCashCard.initiliazeCashTrans(cashTrans);
				CashBLCashTransactionUpdate.deleteChequeCashTrans(cashTrans);
			}
			//Delete Accounting Transactions..
			it = chequeRoll.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			while (it.hasNext())
			{
				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
				AccDALTransactionSearch.deleteTransaction(accTrans);
			}
			//Delete Bank Transactions
			
			it =   chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills().iterator();
			
			while(it.hasNext())
			{
				TurqBanksTransactionBill bankTrans = (TurqBanksTransactionBill) it.next();
				BankBLTransactionUpdate.deleteOnlyBankTransaction(bankTrans);				
				
			}
			
			
			//Delete roll Account
			//
			if (chequeRoll.getTurqChequeRollAccountingAccount() != null)
			{
				EngDALCommon.deleteObject(chequeRoll.getTurqChequeRollAccountingAccount());
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteChequeRollIn(HashMap argMap) throws Exception
	{
		Integer cheqRollId =(Integer)argMap.get(CheKeys.CHE_CHEQUE_ROLL_ID);
	    
		TurqChequeRoll chequeRoll = (TurqChequeRoll)EngDALSessionFactory.getSession().load(TurqChequeRoll.class,cheqRollId); 
			
		
		emptyCheckRollIn(chequeRoll);
			//Delete Roll Now
			EngDALCommon.deleteObject(chequeRoll);
		
	}
}