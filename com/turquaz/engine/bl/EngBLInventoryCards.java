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
import java.util.List;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.inventory.bl.InvBLCardSearch;

public class EngBLInventoryCards
{
	public List cardList;
	static EngBLInventoryCards _instance;
	private InvBLCardSearch blAccount = new InvBLCardSearch();

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

	public static TurqInventoryCard getInvCard(String accountCode) throws Exception
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

	public TurqInventoryCard getCard(String invCode) throws Exception
	{
		try
		{
			return InvBLCardSearch.getInventoryCard(invCode);
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
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}