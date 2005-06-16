package com.turquaz.engine.bl;

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
import java.util.HashMap;
import java.util.List;
import com.turquaz.common.HashBag;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardSearch;

public class EngBLInventoryCards
{
	public List cardList;
	static EngBLInventoryCards _instance;

	public EngBLInventoryCards() throws Exception
	{
		try
		{
			fillInventoryList();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillInventoryList() throws Exception
	{
		try
		{
			cardList = InvBLCardSearch.getInventoryCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public static synchronized List getInventoryCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryCards();
			}
			return _instance.cardList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getInvCard(String accountCode) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryCards();
			}
			return _instance.getCard(accountCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static HashMap getInvFromCardName(String cardName) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryCards();
			}
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD_NAME,cardName);
			HashBag cardBag=(HashBag)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"getInventoryCardFromName",argMap);
			
			return  (HashMap)cardBag.get(InvKeys.INV_CARD);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public HashMap getCard(String invCode) throws Exception
	{
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD_CODE,invCode);
			HashBag cardBag=(HashBag)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"getInventoryCard",argMap);
			return (HashMap)cardBag.get(InvKeys.INV_CARD);
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
				_instance = new EngBLInventoryCards();
				return;
			}
			_instance.fillInventoryList();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_INVENTORY);
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}