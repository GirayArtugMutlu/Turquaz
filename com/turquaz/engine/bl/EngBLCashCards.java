
package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;

import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.engine.dal.TurqCashCard;

public class EngBLCashCards {
    public List currentList;

	public HashMap cardMap = new HashMap();

	static EngBLCashCards _instance;

	private CashBLCashCardSearch blCurrentCards = new CashBLCashCardSearch();

	public EngBLCashCards() throws Exception {
		try {
			fillCashCards();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void fillCashCards() throws Exception {
		try {
			currentList = blCurrentCards.searchCashCard(null,"");
			cardMap.clear();

			TurqCashCard cashCard;
			for (int i = 0; i < currentList.size(); i++) {
				cashCard = (TurqCashCard)(currentList.get(i));
				cardMap.put(cashCard.getCashCardName(), cashCard);

			}
		} catch (Exception ex) {
			throw ex;
		}

	}

	public static synchronized List getCashCards() throws Exception {
		try {
			if (_instance == null) {

				_instance = new EngBLCashCards();

			}

			return _instance.currentList;

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public static TurqCashCard getCard(String cardName)
	throws Exception {
		try 
		{

			if (_instance == null) {

				_instance = new EngBLCashCards();

			}

			return (TurqCashCard) _instance.cardMap.get(cardName);

		}
		catch (Exception ex) 
		{
			throw ex;
		}
	}
	public static void RefreshContentAsistantMap()throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLCashCards();
				return;
			}
			_instance.fillCashCards();
		}
		
		catch(Exception ex)
		{
			throw ex;
		}	
		
	}

}