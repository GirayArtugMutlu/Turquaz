
package com.turquaz.current.bl;
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
import java.util.List;

import com.turquaz.current.dal.CurDALCurrentCardSearch;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;

public class CurBLCurrentCardSearch {
	
	public CurBLCurrentCardSearch(){
	
	}
	
	private CurDALCurrentCardSearch curDALCurrentCardSearch=new CurDALCurrentCardSearch();
	
	public List searchCurrentCard(String currentCode, String currentName,
									TurqCurrentGroup currentGroup)
	throws Exception{
		try{
			return curDALCurrentCardSearch.searchCurrentCards(currentCode,currentName,currentGroup);

		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getTransactions(TurqCurrentCard curCard) throws Exception
	{
		try
		{
			return curDALCurrentCardSearch.getTransactions(curCard);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}	
	
	public List getCurrentCards()throws Exception {
	    try{
	        
	        return curDALCurrentCardSearch.getCurrentCards();
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    
	}
	public TurqCurrentCard getCurrentCard(String cardCode)throws Exception{
	    try{
	        return curDALCurrentCardSearch.getCurrentCard(cardCode);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    
	}
	

}
