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
import java.util.List;
import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeRoll;

public class CheBLSearchCheques
{
	public static HashBag searchCheque(HashMap argMap) throws Exception
	{
		String portfoliNo = (String) argMap.get(EngKeys.DOCUMENT_NO);
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		
		Integer status = (Integer) argMap.get(CheKeys.CHE_STATUS);
		Date startEnterDate = (Date) argMap.get(CheKeys.CHE_START_ENTER_DATE);
		Date endEnterDate = (Date) argMap.get(CheKeys.CHE_END_ENTER_DATE);
		Date startDueDate = (Date) argMap.get(CheKeys.CHE_START_DUE_DATE);
		Date endDueDate = (Date) argMap.get(CheKeys.CHE_END_DUE_DATE);
		Integer sorting=(Integer)argMap.get(CheKeys.CHE_SORT);	
	 	
		
		
		List list = CheDALSearch.searchCheque(portfoliNo, curCardId, status, startEnterDate, endEnterDate,
				startDueDate, endDueDate,sorting);
		HashBag chequeBag = new HashBag();
		chequeBag.put(CheKeys.CHE_CHEQUES,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
		  
			Object[] data = (Object[])list.get(i);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_CHEQUE_ID,data[0]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_PORTFOLIO_NO,data[1]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.DATE,data[2]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CurKeys.CUR_CURRENT_NAME,data[3]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_DUE_DATE,data[4]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.TYPE_ID,data[5]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.TOTAL_AMOUNT,data[6]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.TYPE_NAME,data[7]);
			
			
		}
		
		
		return chequeBag;		
		
	}

	public static HashBag searchOwnCheques(HashMap argMap) throws Exception
	{
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		
		Date startEnterDate = (Date) argMap.get(CheKeys.CHE_START_ENTER_DATE);
		Date endEnterDate = (Date) argMap.get(CheKeys.CHE_END_ENTER_DATE);
		Date startDueDate = (Date) argMap.get(CheKeys.CHE_START_DUE_DATE);
		Date endDueDate = (Date) argMap.get(CheKeys.CHE_END_DUE_DATE);
		Integer bankCardId=(Integer)argMap.get(BankKeys.BANK_ID);
		
		Boolean sortByDate=(Boolean)argMap.get(BankKeys.BANK_SORT_BY_DATE);
		
		List list =CheDALSearch.searchOwnCheques(curCardId, bankCardId, startEnterDate, endEnterDate, startDueDate,
				endDueDate, sortByDate.booleanValue());
		HashBag chequeBag = new HashBag();
		chequeBag.put(CheKeys.CHE_CHEQUES,new HashMap());
		
		for(int i=0;i<list.size();i++)
		{
		  
			Object[] data = (Object[])list.get(i);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_CHEQUE_ID,data[0]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.DATE,data[1]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CurKeys.CUR_CURRENT_NAME,data[2]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_DUE_DATE,data[3]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.TYPE_NAME,data[4]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,EngKeys.TOTAL_AMOUNT,data[5]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,BankKeys.BANK_CODE,data[6]);
			chequeBag.put(CheKeys.CHE_CHEQUES,i,CheKeys.CHE_CHEQUE_NO,data[7]);
			
			
			
		}
		return chequeBag;
		
		
	}

	public static TurqAccountingAccount getChequeRollAccountingAccount(TurqChequeCheque cheque, int rollType) throws Exception
	{
		return CheDALSearch.getChequeRollAccountingAccount(cheque, rollType);
	}

	
	public static HashBag getChequeHistory(HashMap argMap) throws Exception
	{
		
		
		  Integer chequeId = (Integer)argMap.get(CheKeys.CHE_CHEQUE_ID);
		  HashBag chequeBag=new HashBag();
		  chequeBag.put(CheKeys.CHE_CHEQUE_ROLLS,new HashMap());
		  
		  List list= CheDALSearch.getChequeHistory(chequeId);
		  
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
}