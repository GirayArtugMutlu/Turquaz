
package com.turquaz.cheque.bl;
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
* @author  Onsel
* @version  $Id$
*/

import java.util.Date;
import java.util.List;

import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSearchCheques {
	public static List searchCheque(String portfoliNo, TurqCurrentCard curCard, Integer status, Date startEnterDate, Date endEnterDate, Date startDueDate, Date endDueDate)throws Exception {
		try{
			
		return	CheDALSearch.searchCheques(portfoliNo,curCard,status,startEnterDate,endEnterDate,startDueDate,endDueDate);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static List searchOwnCheques(TurqCurrentCard curCard, TurqBanksCard bankCard,
			 Date startEnterDate, Date endEnterDate,
			Date startDueDate, Date endDueDate) throws Exception {
		try {
			
		 return CheDALSearch.searchOwnCheques(curCard,bankCard,startEnterDate,endEnterDate,startDueDate,endDueDate);
		
		}
		catch (Exception ex){
			throw ex;
		}
	}

}
