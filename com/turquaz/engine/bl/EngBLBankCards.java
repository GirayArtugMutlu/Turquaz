package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.dal.TurqBanksCard;

public class EngBLBankCards
{
	public List currentList;
	public HashMap cardMap = new HashMap();
	static EngBLBankCards _instance;
	BankBLBankCardSearch blCardSearch = new BankBLBankCardSearch();

	public EngBLBankCards() throws Exception
	{
		try
		{
			fillBankCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillBankCards() throws Exception
	{
		try
		{
			currentList = BankBLBankCardSearch.getBankCards();
			cardMap.clear();
			TurqBanksCard cashCard;
			for (int i = 0; i < currentList.size(); i++)
			{
				cashCard = (TurqBanksCard) (currentList.get(i));
				cardMap.put(cashCard.getBankCode(), cashCard);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static synchronized List getBankCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLBankCards();
			}
			return _instance.currentList;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBanksCard getCard(String cardName) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLBankCards();
			}
			return (TurqBanksCard) _instance.cardMap.get(cardName);
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
				_instance = new EngBLBankCards();
				return;
			}
			_instance.fillBankCards();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}