package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;

import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.dal.TurqCurrentCard;

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

public class EngBLCurrentCards {

	public List currentList;

	public HashMap cardMap = new HashMap();

	static EngBLCurrentCards _instance;

	private CurBLCurrentCardSearch blCurrentCards = new CurBLCurrentCardSearch();

	public EngBLCurrentCards() throws Exception {
		try {
			fillCurrentCards();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void fillCurrentCards() throws Exception {
		try {
			currentList = blCurrentCards.searchCurrentCard("", "", null);
			cardMap.clear();

			TurqCurrentCard currentCard;
			for (int i = 0; i < currentList.size(); i++) {
				currentCard = (TurqCurrentCard)((Object[]) currentList.get(i))[1];
				cardMap.put(currentCard.getCardsCurrentCode(), currentCard);

			}
		} catch (Exception ex) {
			throw ex;
		}

	}

	public static synchronized List getCurrentCards() throws Exception {
		try {
			if (_instance == null) {

				_instance = new EngBLCurrentCards();

			}

			return _instance.currentList;

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public static TurqCurrentCard getCards(String currentCode)
	throws Exception {
		try {

			if (_instance == null) {

				_instance = new EngBLCurrentCards();

			}

			return (TurqCurrentCard) _instance.cardMap.get(currentCode);

		} catch (Exception ex) {
			throw ex;
		}

}
	
	

}