/*
 * Created on Feb 15, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.cheque.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
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
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel Window - Preferences - Java - Code Style - Code Templates
 */
public class CheBLUpdateCheque
{
	
	public static HashBag getChequeInfo(HashMap argMap)throws Exception
	{
		
		Integer chequeId = (Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
		TurqChequeCheque cheque = (TurqChequeCheque)EngDALSessionFactory.getSession().load(TurqChequeCheque.class,chequeId);
		
		HashBag chequeBag=new HashBag();
		chequeBag.put(CheKeys.CHE_CHEQUE_ID,cheque.getId());
		chequeBag.put(BankKeys.BANK_BRANCH_NAME,cheque.getBankBranchName());
		chequeBag.put(BankKeys.BANK_NAME,cheque.getBankName());
		chequeBag.put(CheKeys.CHE_CHEQUE_NO,cheque.getChequesNo());
		chequeBag.put(CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
		chequeBag.put(CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
		chequeBag.put(CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
		chequeBag.put(CheKeys.CHE_DUE_DATE,cheque.getChequesDueDate());
		chequeBag.put(EngKeys.TOTAL_AMOUNT,cheque.getChequesAmount());
		chequeBag.put(BankKeys.BANK_ACCOUNT_NO,cheque.getBankAccountNo());
		
		if(cheque.getTurqBanksCard().getId().intValue()!=-1)
		{
			chequeBag.put(BankKeys.BANK_CODE,cheque.getTurqBanksCard().getBankCode());
		}
		chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,new HashMap());
		
		
		List list = CheDALSearch.getChequeHistory(chequeId);
		for(int i=0;i<list.size();i++)
		{
			TurqChequeRoll cheqRoll =(TurqChequeRoll)list.get(i);
			chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.DATE,cheqRoll.getChequeRollsDate());
			chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CheKeys.CHE_CHEQUE_ROLL_ID,cheqRoll.getId());
			chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.TYPE_NAME,cheqRoll.getTurqChequeTransactionType().getTransactionTypsName());
			chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.TYPE_ID,cheqRoll.getTurqChequeTransactionType().getId());
			
			if(cheqRoll.getTurqBanksCard().getId().intValue()!=-1)
			{
				chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,BankKeys.BANK_CODE,cheqRoll.getTurqBanksCard().getBankCode());
			}
			else
			{
				chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,BankKeys.BANK_CODE,"");
			}
			
			if(cheqRoll.getTurqCurrentCard().getId().intValue()!=-1)
			{
				chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CurKeys.CUR_CURRENT_CODE,cheqRoll.getTurqCurrentCard().getCardsCurrentCode());
				
			}
			else
			{
				chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CurKeys.CUR_CURRENT_CODE,"");
				
			}
			
		}
		
		return chequeBag;
		
		
	}
	
	
	public static void updateCheque(HashMap argMap) throws Exception
	{
		
			/**
			 * 1-) update cheque 2-) get cheque Rolls 3-) update transactions 4-)
			 */
		
			Integer chequeId = (Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
			TurqChequeCheque cheque = (TurqChequeCheque)EngDALSessionFactory.getSession().load(TurqChequeCheque.class,chequeId);
			
			String bankBranchName =(String)argMap.get(BankKeys.BANK_BRANCH_NAME);
			String bankName =(String)argMap.get(BankKeys.BANK_NAME);
			String portfolioNo =(String)argMap.get(CheKeys.CHE_PORTFOLIO_NO);
			String chequeNo =(String)argMap.get(CheKeys.CHE_CHEQUE_NO);
			Date dueDate =(Date)argMap.get(CheKeys.CHE_DUE_DATE);
			String deptor =(String)argMap.get(CheKeys.CHE_DEBTOR);
			String paymentPlace =(String)argMap.get(CheKeys.CHE_PAYMENT_PLACE);
			BigDecimal amount = (BigDecimal)argMap.get(EngKeys.TOTAL_AMOUNT);
			String bankAccountNo = (String)argMap.get(BankKeys.BANK_ACCOUNT_NO);
			Integer currencyId =(Integer)argMap.get(EngKeys.CURRENCY_ID);			
			
			
			cheque.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cheque.setLastModified(Calendar.getInstance().getTime());
			
			Integer bankCardId = (Integer)argMap.get(BankKeys.BANK_ID);
			
			if(bankCardId!=null)
			{
				TurqBanksCard bankCard  = new TurqBanksCard();
				bankCard.setId(bankCardId);
				cheque.setTurqBanksCard(bankCard);
			}	
			
			
			
			
			
			cheque.setBankBranchName(bankBranchName);
			cheque.setBankName(bankName);
			cheque.setChequesPortfolioNo(portfolioNo);
			cheque.setChequesNo(chequeNo);
			cheque.setChequesDueDate(dueDate);
			cheque.setChequesValueDate(dueDate);
			cheque.setChequesDebtor(deptor);
			cheque.setChequesPaymentPlace(paymentPlace);
			cheque.setChequesAmount(amount);
			
			if(bankAccountNo!=null)
			cheque.setBankAccountNo(bankAccountNo);
			
			cheque.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cheque.setLastModified(Calendar.getInstance().getTime());
		
			
			
			EngDALCommon.updateObject(cheque);
		
			
			Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
				updateChequeRollTransactions(chequeInRoll.getTurqChequeRoll());
			}
		
	}

	public static void deleteCheque(HashMap argMap) throws Exception
	{

		Integer chequeId = (Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
		TurqChequeCheque cheque =(TurqChequeCheque)EngDALSessionFactory.getSession().load(TurqChequeCheque.class,chequeId);
		
			/**
			 * 1-) 2-) get cheque Rolls 3-) update transactions 4-)
			 */
			
			Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
				TurqChequeRoll chequeRoll = chequeInRoll.getTurqChequeRoll();
				EngDALCommon.deleteObject(chequeInRoll);
				updateChequeRollTransactions(chequeRoll);
			}
			EngDALCommon.deleteObject(cheque);
		
	}

	private static void updateChequeRollTransactions(TurqChequeRoll chequeRoll) throws Exception
	{
		try
		{
			CheDALUpdate.initializeChequeRoll(chequeRoll);
			updateCurrentTransactions(chequeRoll);
			updateBankTransactions(chequeRoll);
			updateAccountingTransactions(chequeRoll);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateCurrentTransactions(TurqChequeRoll chequeRoll) throws Exception
	{
		try
		{
			// Delete Current transactions first
			Iterator it = chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_IN.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
					//TODO cheq current exRate
					CurBLCurrentTransactionAdd
							.saveCurrentTransaction(
									chequeRoll.getTurqCurrentCard(),
									chequeRoll.getChequeRollsDate(),
									chequeRoll.getChequeRollNo(),
									true, //Credit
									chequeInRoll.getTurqChequeCheque().getChequesAmount(),
									new BigDecimal(0),
									EngBLCommon.CURRENT_TRANS_CHEQUE,
									chequeRoll.getTurqEngineSequence().getId(),
                                    CheServerLangKeys.PORTFOLIO_NO + chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(),chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate()); //$NON-NLS-1$
				}
			}
			else if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
					//		          TODO cheq trans exRate
					CurBLCurrentTransactionAdd.saveCurrentTransaction(chequeRoll.getTurqCurrentCard(),
							chequeRoll.getChequeRollsDate(), chequeRoll.getChequeRollNo(), false, //Dept
							chequeInRoll.getTurqChequeCheque().getChequesAmount(), new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO+ chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(), //$NON-NLS-1$
							chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate());
				}
			}
			else if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT
					.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
					//TODO cheq trans exRate
					TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(chequeInRoll.getTurqChequeCheque().getId());
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, chequeRoll.getChequeRollsDate(), chequeRoll
							.getChequeRollNo(), false, //Dept
							chequeInRoll.getTurqChequeCheque().getChequesAmount(), new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(), //$NON-NLS-1$
							chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate());
				}
			}
			else if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT
					.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
					//TODO cheq trans exRate
					TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfGivenCheque(chequeInRoll.getTurqChequeCheque().getId());
					CurBLCurrentTransactionAdd.saveCurrentTransaction(curCard, chequeRoll.getChequeRollsDate(), chequeRoll
							.getChequeRollNo(), false, //Dept
							chequeInRoll.getTurqChequeCheque().getChequesAmount(), new BigDecimal(0),
							EngBLCommon.CURRENT_TRANS_CHEQUE, chequeRoll.getTurqEngineSequence().getId(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(), //$NON-NLS-1$
							chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate());
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateBankTransactions(TurqChequeRoll chequeRoll) throws Exception
	{
		try
		{
			//Delete Bank Transactions First
			Iterator it = chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills().iterator();
			while (it.hasNext())
			{
				TurqBanksTransactionBill transBill = (TurqBanksTransactionBill) it.next();
				BankBLTransactionUpdate.initializeTransaction(transBill);
				BankBLTransactionUpdate.deleteOnlyBankTransaction(transBill);
			}
			if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
					BankBLTransactionAdd.saveChequeTransaction(chequeInRoll.getTurqChequeCheque().getTurqBanksCard(), chequeRoll
							.getTurqEngineSequence(), chequeInRoll.getTurqChequeCheque().getChequesAmount(), chequeRoll
							.getChequeRollsDate(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(), //$NON-NLS-1$
							chequeRoll.getChequeRollNo(), chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate());
				}
			}
			else if (chequeRoll.getTurqChequeTransactionType().getId().intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE.intValue())
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator();
				while (it.hasNext())
				{
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
				
					BankBLTransactionAdd.saveOwnChequeCollect(chequeInRoll.getTurqChequeCheque().getTurqBanksCard(), chequeRoll
							.getTurqEngineSequence(), chequeInRoll.getTurqChequeCheque().getChequesAmount(), chequeRoll
							.getChequeRollsDate(),
                            CheServerLangKeys.PORTFOLIO_NO + chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(), //$NON-NLS-1$
							chequeRoll.getChequeRollNo(), chequeInRoll.getTurqChequeCheque().getTurqCurrencyExchangeRate());
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateAccountingTransactions(TurqChequeRoll chequeRoll) throws Exception
	{
		//Delete Accounting Transactions..
		Iterator it = chequeRoll.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		while (it.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
			AccDALTransactionSearch.deleteTransaction(accTrans);
		}
		int rollType = chequeRoll.getTurqChequeTransactionType().getId().intValue();
		// 
		BigDecimal totalAmount = new BigDecimal(0);
		it = chequeRoll.getTurqChequeChequeInRolls().iterator();
		while (it.hasNext())
		{
			TurqChequeCheque cheque = ((TurqChequeChequeInRoll) it.next()).getTurqChequeCheque();
			totalAmount = totalAmount.add(cheque.getChequesAmount());
		}
		if (rollType == EngBLCommon.CHEQUE_TRANS_IN.intValue())
		{
			
			if(chequeRoll.getTurqChequeRollAccountingAccount()==null)
			{
				return;
			}
			TurqAccountingAccount rollAccount = chequeRoll.getTurqChequeRollAccountingAccount().getTurqAccountingAccount();
			TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(chequeRoll.getTurqCurrentCard(),
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			//       TODO acc trans exRate
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, curAccount, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
		{
			if(chequeRoll.getTurqChequeRollAccountingAccount()==null)
			{
				return;
			}
			TurqAccountingAccount rollAccount = chequeRoll.getTurqChequeRollAccountingAccount().getTurqAccountingAccount();
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(rollAccount, null, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
		{
			TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(chequeRoll.getTurqCurrentCard(),
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(curAccount, null, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK.intValue())
		{
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(null, null, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO+ chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT.intValue())
		{
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(chequeRoll.getTurqChequeRollAccountingAccount()
					.getTurqAccountingAccount(), null, chequeRoll, totalAmount, EngBLCommon.getBaseCurrencyExchangeRate(),CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY.intValue())
		{
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(chequeRoll.getTurqChequeRollAccountingAccount()
					.getTurqAccountingAccount(), null, chequeRoll, totalAmount, EngBLCommon.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT.intValue())
		{
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(null, null, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(),CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT.intValue())
		{
			CheBLSaveChequeTransaction.saveRollAccountingTransactions(null, null, chequeRoll, totalAmount, EngBLCommon
					.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo()); //$NON-NLS-1$
		}
		else if (rollType == EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE.intValue())
		{		

			CheBLSaveChequeTransaction.saveRollAccountingTransactions(null, null, chequeRoll, null, EngBLCommon.getBaseCurrencyExchangeRate(), CheServerLangKeys.ROLL_NO + chequeRoll.getChequeRollNo());  //$NON-NLS-1$
				
		}
	}
	
	
}