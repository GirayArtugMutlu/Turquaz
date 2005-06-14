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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSearchChequeRoll
{
	
	public static HashBag searchChequeRoll(HashMap argMap) throws Exception
	{
		String rollNo = (String)argMap.get(EngKeys.DOCUMENT_NO);
		 Date startDate = (Date)argMap.get(EngKeys.DATE_START);
		 Date endDate = (Date)argMap.get(EngKeys.DATE_END);	
		Integer typeId = (Integer)argMap.get(CheKeys.CHE_TRANS_TYPE); 
		
		HashBag rollsBag = new HashBag();
		rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,new HashMap());
		
		List list = CheDALSearch.searchChequeRoll(rollNo, startDate, endDate, typeId);
		
		for(int i =0;i<list.size();i++)
		{
			
			Object info[] =(Object[])list.get(i);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CheKeys.CHE_CHEQUE_ROLL_ID,info[0]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.DATE,info[1]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.DOCUMENT_NO,info[2]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.TYPE_NAME,info[3]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CurKeys.CUR_CURRENT_NAME,info[4]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,BankKeys.BANK_CODE,info[5]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,CurKeys.CUR_CARD_ID,info[6]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,BankKeys.BANK_ID,info[7]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.TOTAL_AMOUNT,info[8]);
			rollsBag.put(CheKeys.CHE_CHEQUE_ROLLS,i,EngKeys.TYPE_ID,info[9]);
			
		}
		
		
		
		
		
		
		return rollsBag;
		
	}

	public static HashBag getTransactionTypes() throws Exception
	{
		
			
		List list = CheDALSearch.getTransactionTypes();
		HashBag returnBag = new HashBag();
		returnBag.put(EngKeys.TYPES,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
			TurqChequeTransactionType type = (TurqChequeTransactionType)list.get(i);
			
			returnBag.put(EngKeys.TYPE,i,EngKeys.TYPE_NAME,type.getTransactionTypsName());
			returnBag.put(EngKeys.TYPE,i,EngKeys.TYPE_ID,type.getId());
						
		}
		return returnBag;
		
		
		
		
		
		
		
	}

	public static HashBag getChequesInPortfolio() throws Exception
	{
		
		List list = CheDALSearch.getChequesInPortfolio();
		HashBag chequesBag = new HashBag();
		chequesBag.put(CheKeys.CHE_CHEQUE_LIST,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
			TurqChequeCheque cheque = (TurqChequeCheque)list.get(i);
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_CHEQUE_ID,cheque.getId());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.DATE,cheque.getChequesDueDate());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TYPE_ID,new Integer(cheque.getChequesType()));
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque.getId());
			
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TOTAL_AMOUNT,cheque.getChequesAmount());
				
		}
		
		
			return chequesBag; 
		
	}

	public static HashBag getChequesGivenToCurrent() throws Exception
	{
		List list = CheDALSearch.getChequesGivenToCurrent();
		HashBag chequesBag = new HashBag();
		chequesBag.put(CheKeys.CHE_CHEQUE_LIST,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
			TurqChequeCheque cheque = (TurqChequeCheque)list.get(i);
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_CHEQUE_ID,cheque.getId());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.DATE,cheque.getChequesDueDate());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TYPE_ID,new Integer(cheque.getChequesType()));
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque.getId());
			
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TOTAL_AMOUNT,cheque.getChequesAmount());
				
		}	
		
			return chequesBag; 
		
	}
	public static HashBag getOwnChequesGivenToCurrent() throws Exception
	{
		
		List list = CheDALSearch.getOwnChequesGivenToCurrent();
		HashBag chequesBag = new HashBag();
		chequesBag.put(CheKeys.CHE_CHEQUE_LIST,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
			TurqChequeCheque cheque = (TurqChequeCheque)list.get(i);
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_CHEQUE_ID,cheque.getId());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.DATE,cheque.getChequesDueDate());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TYPE_ID,new Integer(cheque.getChequesType()));
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfGivenCheque(cheque.getId());
			
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TOTAL_AMOUNT,cheque.getChequesAmount());
				
		}	
		
			return chequesBag; 
		
	}

	public static TurqCurrentCard getCurrentCardOfCustomerCheque(HashMap argMap) throws Exception
	{
		Integer cheque =(Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
			return CheDALSearch.getCurrentCardOfCustomerCheque(cheque);
		
	}
	public static TurqCurrentCard getCurrentCardOfGivenCheque(HashMap argMap) throws Exception
	{
		Integer cheque =(Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
			return CheDALSearch.getCurrentCardOfGivenCheque(cheque);
		
	}

	public static HashBag getChequesInBank() throws Exception
	{
		List list = CheDALSearch.getChequesInBank();
		HashBag chequesBag = new HashBag();
		chequesBag.put(CheKeys.CHE_CHEQUE_LIST,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
			TurqChequeCheque cheque = (TurqChequeCheque)list.get(i);
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_CHEQUE_ID,cheque.getId());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PORTFOLIO_NO,cheque.getChequesPortfolioNo());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.DATE,cheque.getChequesDueDate());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_DEBTOR,cheque.getChequesDebtor());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CheKeys.CHE_PAYMENT_PLACE,cheque.getChequesPaymentPlace());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TYPE_ID,new Integer(cheque.getChequesType()));
			
			TurqCurrentCard curCard = CheDALSearch.getCurrentCardOfCustomerCheque(cheque.getId());
			
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,CurKeys.CUR_CURRENT_NAME,curCard.getCardsName());
			chequesBag.put(CheKeys.CHE_CHEQUE_LIST,i,EngKeys.TOTAL_AMOUNT,cheque.getChequesAmount());
				
		}	
		
			return chequesBag; 
	}

	public static TurqChequeRoll getChequeRoll(HashMap argMap) throws Exception
	{
		 TurqChequeCheque cheque = (TurqChequeCheque)argMap.get(CheKeys.CHE_CHEQUE);
		 Integer rollType = (Integer)argMap.get(EngKeys.TYPE);
		
		CheDALUpdate.initChequeRolls(cheque);
		Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
		while (it.hasNext())
		{
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
			if (chequeInRoll.getTurqChequeRoll().getTurqChequeTransactionType().getId().intValue() == rollType.intValue())
			{
				return chequeInRoll.getTurqChequeRoll();
			}
		}
		return null;
	}
}