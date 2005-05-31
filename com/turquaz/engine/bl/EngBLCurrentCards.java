package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

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
 * @author Huseyin Ergun
 * @version $Id$
 */
public class EngBLCurrentCards
{
	public HashMap currentCards;
	public HashMap cardMap = new HashMap();
	static EngBLCurrentCards _instance;

	public EngBLCurrentCards() throws Exception
	{
		try
		{
			fillCurrentCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillCurrentCards() throws Exception
	{
		try
		{
			HashBag resultBag = (HashBag)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getCurrentCards",null);
			
			currentCards = (HashMap)resultBag.get(CurKeys.CUR_CARDS);
			
			for(int i=0;i<currentCards.size();i++)
			{
				HashMap cardInfo = (HashMap)currentCards.get(new Integer(i));
				cardMap.put(cardInfo.get(CurKeys.CUR_CURRENT_CODE),cardInfo);
							
			}
			
			
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static synchronized HashMap getCurrentCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCurrentCards();
			}
			return _instance.currentCards;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getCardsInfo(String currentCode) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCurrentCards();
			}
			return (HashMap) _instance.cardMap.get(currentCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getCurrentCardForContentAssist(String cardNameCode) throws Exception
	{
		try
		{
			String pattern = ".*[{](.*)[}].*";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(cardNameCode);
			if (m.find())
			{
				return getCardsInfo(m.group(1));
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	

	public static void RefreshContentAsistantMap() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCurrentCards();
				return;
			}
			_instance.fillCurrentCards();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_CURRENT);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}