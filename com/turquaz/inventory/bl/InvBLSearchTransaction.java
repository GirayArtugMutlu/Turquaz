
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
* @author  Huseyin Ergun
* @version  $Id$
*/

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.inventory.dal.InvDALSearchTransaction;

public class InvBLSearchTransaction {
	Calendar cal = Calendar.getInstance();
	InvDALSearchTransaction dalSearch = new InvDALSearchTransaction();
   
	public InvBLSearchTransaction(){
   	
	}
	public List searchTransactions(TurqCurrentCard card, TurqInventoryCard invCard, Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return dalSearch.searchTransactions(card,invCard,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
}
