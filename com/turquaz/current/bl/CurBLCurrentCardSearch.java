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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALCurrentCardSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;

public class CurBLCurrentCardSearch
{

	/*CurUICurrentCardSearch, CurUICurCardBalanceReport*/
	public static HashBag searchCurrentCard(HashMap argMap) throws Exception
	{
		
		String currentCode = (String)argMap.get(CurKeys.CUR_CURRENT_CODE);
		String currentName = (String)argMap.get(CurKeys.CUR_CURRENT_NAME);
		Integer currentGroupId = (Integer)argMap.get(CurKeys.CUR_GROUP_ID);
		
		
		HashBag resultBag = new HashBag();
		resultBag.put(CurKeys.CUR_CARDS,new HashMap());
		List list = CurDALCurrentCardSearch.searchCurrentCards(currentCode, currentName, currentGroupId);
		Iterator it = list.iterator();
		int i=0;
		while(it.hasNext())
		{
			Object[] cardInfo = (Object[])it.next();
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CARD_ID,cardInfo[0]);
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_CODE,cardInfo[1]);
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_NAME,cardInfo[2]);
			
			resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
			resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.DEPT_AMOUNT,new BigDecimal(0));
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_BALANCE,new BigDecimal(0));
			
			if(cardInfo[3]!=null)
			{
				resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.CREDIT_AMOUNT,cardInfo[3]);
			}
			if(cardInfo[4]!=null)
			{
				resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.DEPT_AMOUNT,cardInfo[4]);
			}
			if(cardInfo[5]!=null)
			{
				resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_BALANCE,cardInfo[5]);
			}
			i++;
		}
			
		return resultBag;		
		
	}
	
	public static HashBag searchCurrentCardBalanceList(HashMap argMap) throws Exception
	{
		
		String currentCode = (String)argMap.get(CurKeys.CUR_CURRENT_CODE);
		String currentName = (String)argMap.get(CurKeys.CUR_CURRENT_NAME);
		
		
		Integer groupId = (Integer)argMap.get(CurKeys.CUR_GROUP_ID);
		TurqCurrentGroup currentGroup = null;
		if(groupId!=null)
		{
			currentGroup = new TurqCurrentGroup();
			currentGroup.setId(groupId);
		}
		
		Date startDate=(Date)argMap.get(EngKeys.DATE_START);
		Date endDate=(Date)argMap.get(EngKeys.DATE_END);
		String definition=(String)argMap.get(EngKeys.DEFINITION);		
		
		HashBag resultBag = new HashBag();
		resultBag.put(CurKeys.CUR_CARDS,new HashMap());
		List list = CurDALCurrentCardSearch.searchCurrentCardsBalanceList(currentCode, currentName, currentGroup,startDate,endDate,definition);
		Iterator it = list.iterator();
		int i=0;
		while(it.hasNext())
		{
			Object[] cardInfo = (Object[])it.next();
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CARD_ID,cardInfo[0]);
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_CODE,cardInfo[1]);
			resultBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_NAME,cardInfo[2]);
			
			resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
			resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.DEPT_AMOUNT,new BigDecimal(0));
			
			if(cardInfo[3]!=null)
			{
				resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.DEPT_AMOUNT,cardInfo[3]);
			}
			if(cardInfo[4]!=null)
			{
				resultBag.put(CurKeys.CUR_CARDS,i,EngKeys.CREDIT_AMOUNT,cardInfo[4]);
			}
			
			i++;
		}
			
		return resultBag;
	}

	public static TurqViewCurrentAmountTotal getCurrentCardView(HashMap argMap) throws Exception
	{
		
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		
		return CurDALCurrentCardSearch.getCurrentCardView(curCard);
		
	}
	public static HashBag getCurrentCards() throws Exception
	{
		try
		{
			HashBag returnBag = new HashBag();
			returnBag.put(CurKeys.CUR_CARDS,new HashMap());
			
			List list = CurDALCurrentCardSearch.getCurrentCards();
			for(int i=0;i<list.size();i++)
			{
				Object []cardInfo = (Object[])list.get(i);
				returnBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_CODE,cardInfo[0]);
				returnBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CURRENT_NAME,cardInfo[1]);
				returnBag.put(CurKeys.CUR_CARDS,i,CurKeys.CUR_CARD_ID,cardInfo[2]);
				
				
			}
			
			
			return returnBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static HashBag hasTransactions(HashMap argMap)throws Exception
	{
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		HashBag resultMap = new HashBag();
		resultMap.put(CurKeys.CUR_HAS_TRANSACTIONS,CurDALCurrentCardSearch.hasTransactions(curCard));
		return resultMap;
	}
	public static List getTransactions(HashMap argMap) throws Exception
	{
		
		
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		TurqCurrentCard curCard=null;
		if(curCardId!=null)
		{
			curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
		};
		
		return CurDALCurrentCardSearch.getTransactions(curCard);
		
	}


	public static TurqCurrentCard getCurrentCard(HashMap argMap) throws Exception
	{
		try
		{
			String cardCode=(String)argMap.get(CurKeys.CUR_CURRENT_CODE);
			return CurDALCurrentCardSearch.getCurrentCard(cardCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentCard initializeCurrentCard(HashMap argMap) throws Exception
	{
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		
		return CurDALCurrentCardSearch.initializeCurrentCard(curCardId);
	
	}

	
	
	public static String getCurrentAccountingAccount(HashMap argMap) throws Exception
	{
	
		Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
		
		TurqCurrentCard curCard = new TurqCurrentCard();
		
		curCard.setId(curCardId);
		
		Integer type = (Integer)argMap.get(EngKeys.TYPE);	   	
		
		return CurDALCurrentCardSearch.getCurrentAccountingAccount(curCard, type).getAccountCode();
		
	}
	
	public static TurqAccountingAccount getCurrentAccountingAccount(TurqCurrentCard curCard, Integer type) throws Exception
	{	
	
		return CurDALCurrentCardSearch.getCurrentAccountingAccount(curCard, type);
		
	}

	public static List getTurqCurrentGroups() throws Exception
	{
		return CurDALCurrentCardSearch.getTurqCurrentGroups();
	}
}