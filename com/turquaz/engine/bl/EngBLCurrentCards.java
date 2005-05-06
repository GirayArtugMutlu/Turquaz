package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.dal.TurqCurrentCard;
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
	public List currentList;
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
			currentList = CurBLCurrentCardSearch.getCurrentCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static synchronized List getCurrentCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCurrentCards();
			}
			return _instance.currentList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentCard getCards(String currentCode) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCurrentCards();
			}
			return (TurqCurrentCard) _instance.getCurrentCard(currentCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrentCard getCurrentCardForContentAssist(String cardNameCode) throws Exception
	{
		try
		{
			String pattern = ".*[{](.*)[}].*";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(cardNameCode);
			if (m.find())
			{
				return getCards(m.group(1));
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public TurqCurrentCard getCurrentCard(String currentCode) throws Exception
	{
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(CurKeys.CUR_CURRENT_CODE,currentCode);
			return (TurqCurrentCard)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getCurrentCard",argMap);
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