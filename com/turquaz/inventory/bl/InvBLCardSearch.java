
package com.turquaz.inventory.bl;
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
* @author  Onsel Armagan
* @version  $Id$
*/

import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;

import com.turquaz.inventory.dal.InvDALCardSearch;


public class InvBLCardSearch {
	private InvDALCardSearch cardSearch;

	Calendar cal = Calendar.getInstance();

	public InvBLCardSearch() {

		cardSearch = new InvDALCardSearch();

	}
	public List searchCards(String cardName, String cardCode, TurqInventoryGroup group)throws Exception{
		try{
		
			return cardSearch.searchInventoryCards(cardName,cardCode,group);
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	public TurqInventoryCard initializeInventoryCard(Integer cardId)throws Exception{
	    try{
	        
	        return cardSearch.initializeInventoryCard(cardId);
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	public void initializeInventoryCard(TurqInventoryCard invCard)throws Exception{
	    try{
	        
	        cardSearch.initializeInventoryCard(invCard);
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	public TurqInventoryCard getTurqInvCardById(Integer cardId )throws Exception{
	    try{      
	        
	        return cardSearch.getTurqInvCardById(cardId);
			}
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	
	public TurqViewInventoryAmountTotal getView (TurqInventoryCard invCard)throws Exception
	{
		try{
		    
			return cardSearch.getView(invCard);
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	public List getInventoryCards()throws Exception {
	    try{
	        return cardSearch.getInventoryCards();
	        
	    }
	    catch(Exception ex){
	        
	        throw ex;
	    }
	    
	    
	}
	public TurqInventoryCard getInventoryCard(String invCode)throws Exception {
	    try{
	        return cardSearch.getInventoryCard(invCode);
	        
	    }
	    catch(Exception ex){
	        
	        throw ex;
	    }
	    
	    
	}
	
	
	
	

}
