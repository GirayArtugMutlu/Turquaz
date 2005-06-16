package com.turquaz.cash.bl;

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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CashBLCashTransactionSearch
{
	

	public static List searchCashTransactions(HashMap argMap) throws Exception
	{
		
		Integer cashCardId = (Integer)argMap.get(CashKeys.CASH_CARD_ID);
		TurqCashCard cashCard=null;
		if(cashCardId!=null)
		{
			cashCard = (TurqCashCard)EngDALSessionFactory.getSession().load(TurqCashCard.class,cashCardId);
		}
		Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		String definition = (String)argMap.get(EngKeys.DEFINITION);
		
		return CashDALCashCard.searchCashTransaction(cashCard, startDate, endDate, definition);
		
	}

	public static TurqCashTransaction initializeCashTransaction(HashMap argMap) throws Exception
	{
		
		Integer id = (Integer) argMap.get(EngKeys.TRANS_ID);
			return CashDALCashCard.initiliazeCashTrans(id);
		
	}

    public static HashBag getTransactionInfo(HashMap argMap) throws Exception
    {
     
           
            Integer id = (Integer) argMap.get(EngKeys.TRANS_ID);
            TurqCashTransaction cashTrans =  CashDALCashCard.initiliazeCashTrans(id);
            
            HashBag returnBag = new HashBag();
            
            returnBag.put(EngKeys.TRANS_ID,cashTrans.getId());
            returnBag.put(CashKeys.CASH_TRANS_MODULE_ID,cashTrans.getTurqEngineSequence().getTurqModule().getId());
            returnBag.put(CashKeys.CASH_TRANS_TYPE_ID,cashTrans.getTurqCashTransactionType().getId());
            returnBag.put(EngKeys.DOCUMENT_NO,cashTrans.getDocumentNo());
            returnBag.put(EngKeys.DATE,cashTrans.getTransactionDate());
            returnBag.put(EngKeys.DEFINITION,cashTrans.getTransactionDefinition());
            returnBag.put(EngKeys.ENG_SEQ_ID,cashTrans.getTurqEngineSequence().getId());
            
            TurqCurrentCard curCard = CashDALCashCard.getCurrentCard(cashTrans.getTurqEngineSequence());
            
            
            if (curCard != null)
            {
                returnBag.put(CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());   
                returnBag.put(CurKeys.CUR_CURRENT_CODE,curCard.getCardsCurrentCode());  
            }
            
            returnBag.put(CashKeys.CASH_TRANSACTION_ROWS, new HashMap());
            Iterator it = cashTrans.getTurqCashTransactionRows().iterator();            
            
            // if there is another line 
            int i = 0 ;
            while (it.hasNext())
            {

                TurqCashTransactionRow row =   (TurqCashTransactionRow) it.next();
/*                returnBag.put(CashKeys.CASH_TRANSACTION_ROWS,i,CashKeys.CASH_TRANS_ROW_CASH_CARD_NAME,row.getTurqCashCard().getCashCardName());
                returnBag.put(CashKeys.CASH_TRANSACTION_ROWS,i,CashKeys.CASH_TRANS_ROW_FOREIGN_DEPT_AMOUNT,row.getDeptAmountInForeignCurrency());
                returnBag.put(CashKeys.CASH_TRANSACTION_ROWS,i,CashKeys.CASH_TRANS_ROW_FOREIGN_CREDIT_AMOUNT,row.getCreditAmountInForeignCurrency());
                returnBag.put(CashKeys.CASH_TRANSACTION_ROWS,i,CashKeys.CASH_TRANS_ROW_ABBREVATION,row.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
                returnBag.put(CashKeys.CASH_TRANSACTION_ROWS,i,AccKeys.ACC_ACCOUNT_CODE,row.getTurqAccountingAccount().getAccountCode());
               */ 
                returnBag.put(CashKeys.CASH_TRANS_ROW_CASH_CARD_NAME,row.getTurqCashCard().getCashCardName());
                returnBag.put(CashKeys.CASH_TRANS_ROW_FOREIGN_DEPT_AMOUNT,row.getDeptAmountInForeignCurrency());
                returnBag.put(CashKeys.CASH_TRANS_ROW_FOREIGN_CREDIT_AMOUNT,row.getCreditAmountInForeignCurrency());
                returnBag.put(CashKeys.CASH_TRANS_ROW_ABBREVATION,row.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
                returnBag.put(AccKeys.ACC_ACCOUNT_CODE,row.getTurqAccountingAccount().getAccountCode());
            
                i++;
            }
            
            return returnBag;
                    
    }
    
    public static HashBag getTransactionBetweenAccounts(HashMap argMap) throws Exception
    {
     
           
            Integer id = (Integer) argMap.get(EngKeys.TRANS_ID);
            TurqCashTransaction cashTrans =  CashDALCashCard.initiliazeCashTrans(id);
            
            HashBag returnBag = new HashBag();
            
            returnBag.put(EngKeys.TRANS_ID,cashTrans.getId());
            returnBag.put(CashKeys.CASH_TRANS_MODULE_ID,cashTrans.getTurqEngineSequence().getTurqModule().getId());
            returnBag.put(CashKeys.CASH_TRANS_TYPE_ID,cashTrans.getTurqCashTransactionType().getId());
            returnBag.put(EngKeys.DOCUMENT_NO,cashTrans.getDocumentNo());
            returnBag.put(EngKeys.DATE,cashTrans.getTransactionDate());
            returnBag.put(EngKeys.DEFINITION,cashTrans.getTransactionDefinition());
            returnBag.put(EngKeys.ENG_SEQ_ID,cashTrans.getTurqEngineSequence().getId());
            
            TurqCurrentCard curCard = CashDALCashCard.getCurrentCard(cashTrans.getTurqEngineSequence());
            
            
            if (curCard != null)
            {
                returnBag.put(CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());   
                returnBag.put(CurKeys.CUR_CURRENT_CODE,curCard.getCardsCurrentCode());  
            }
            
            Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
            
            while (it.hasNext())
            {
                TurqCashTransactionRow row = (TurqCashTransactionRow) it.next();
                
                if (((BigDecimal)row.getDeptAmountInForeignCurrency()).compareTo(new BigDecimal(0)) == 1)
                {
                    returnBag.put(CashKeys.CASH_CARD_WITH_DEPT,row.getTurqCashCard().getCashCardName());
                    returnBag.put(CashKeys.CASH_TRANS_ROW_FOREIGN_DEPT_AMOUNT,row.getDeptAmountInForeignCurrency());
                }
                else
                {
                    returnBag.put(CashKeys.CASH_CARD_WITH_CREDIT,row.getTurqCashCard().getCashCardName());
                    returnBag.put(CashKeys.CASH_TRANS_ROW_FOREIGN_CREDIT_AMOUNT,row.getDeptAmountInForeignCurrency());
                    
                }
                
                returnBag.put(CashKeys.CASH_TRANS_ROW_ABBREVATION,row.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
               
             }
            
            return returnBag;
                    
    }
    
	public static void initializeTransaction(HashMap argMap) throws Exception
	{
        
		TurqCashTransaction cashTrans = (TurqCashTransaction)argMap.get(CashKeys.CASH_TRANSACTION);
			CashDALCashCard.initiliazeCashTrans(cashTrans);
	
	}

	public static List getTransactions(HashMap argMap) throws Exception
	{
		
		TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);
		
			return CashDALCashCard.getTransactions(cashCard, startDate, endDate);
	
	}
	public static HashBag getInitialTransactions() throws Exception 
	{
        HashBag bag = new HashBag();
        
        

		List cashTransList =  CashDALCashCard.getInitialTransactions();
        
        for(int i =0;i<cashTransList.size();i++)
        {
            TurqCashTransactionRow curTrans = (TurqCashTransactionRow)cashTransList.get(i);
            bag.put(CashKeys.CASH_TRANS_ROW,i,EngKeys.DEPT_AMOUNT,curTrans.getDeptAmount());
            bag.put(CashKeys.CASH_TRANS_ROW,i,EngKeys.CREDIT_AMOUNT,curTrans.getCreditAmount());
            bag.put(CashKeys.CASH_TRANS_ROW,i,CashKeys.CASH_CARD_NAME,curTrans.getTurqCashCard().getCashCardName());
            bag.put(CashKeys.CASH_TRANS_ROW,i,CashKeys.CASH_CARD_ID,curTrans.getTurqCashCard().getId());
            bag.put(CashKeys.CASH_TRANS_ROW,i,EngKeys.DEFINITION,curTrans.getTurqCashCard().getCashCardDefinition());
            bag.put(CashKeys.CASH_TRANS_ROW,i,CashKeys.CASH_TRANSACTION_ID,curTrans.getTurqCashTransaction().getId());
            
            
        }   
        
        return bag;
	}

	// Devreden
	public static List getDeferredTotal(HashMap argMap) throws Exception
	{
		TurqCashCard cashCard =(TurqCashCard)argMap.get(CashKeys.CASH_CARD);
	    Date endDate = (Date)argMap.get(EngKeys.DATE_END);
			
			return CashDALCashCard.getDeferredTotal(cashCard, endDate);
		
	}
}