package com.turquaz.engine.bl;

import java.util.HashMap;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

public class EngBLCashCards
{
	public HashMap cashCardList;
	public HashMap cardMap = new HashMap();
	static EngBLCashCards _instance;

	public EngBLCashCards() throws Exception
	{
		try
		{
			fillCashCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillCashCards() throws Exception
	{
		try
		{
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_ID, null);
			argMap.put(CashKeys.CASH_CARD_NAME,"");
			
			HashBag result  =(HashBag)EngTXCommon.doSelectTX(CashBLCashCardSearch.class.getName(),"searchCashCard",argMap);			
			
			cashCardList =(HashMap)result.get(CashKeys.CASH_CARDS);
			cardMap.clear();
			
			
			for (int i = 0; i < cashCardList.size(); i++)
			{
				HashMap cardInfo = (HashMap)cashCardList.get(new Integer(i));
				
				cardMap.put(cardInfo.get(CashKeys.CASH_CARD_NAME), cardInfo);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static synchronized HashMap getCashCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCashCards();
			}
			return _instance.cashCardList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getCard(String cardName) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCashCards();
			}
			return (HashMap) _instance.cardMap.get(cardName);
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
				_instance = new EngBLCashCards();
				return;
			}
			_instance.fillCashCards();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_CASH);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}