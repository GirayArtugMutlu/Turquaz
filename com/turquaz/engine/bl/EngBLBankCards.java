package com.turquaz.engine.bl;

import java.util.HashMap;

import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

public class EngBLBankCards
{
	public HashMap bankCardList;
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
			HashBag bankBag =(HashBag)EngTXCommon.doSelectTX(BankBLBankCardSearch.class.getName(),"getBankCards",null);
			bankCardList =(HashMap)bankBag.get(BankKeys.BANK_CARDS);
			cardMap.clear();
			TurqBanksCard cashCard;
			for (int i = 0; i < bankCardList.size(); i++)
			{

				HashMap infoMap =(HashMap)bankCardList.get(new Integer(i));
				cardMap.put(infoMap.get(BankKeys.BANK_CODE), infoMap);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getBankCards() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLBankCards();
			}
			return _instance.bankCardList;
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
				_instance = new EngBLBankCards();
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
				_instance = new EngBLBankCards();
				return;
			}
			_instance.fillBankCards();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_BANK);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}