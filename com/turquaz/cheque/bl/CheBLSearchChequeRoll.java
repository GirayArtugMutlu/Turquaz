
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
import java.util.Iterator;
import java.util.List;

import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSearchChequeRoll {
    
    public static List searchChequeRoll(String rollNo,Date startDate, Date endDate, TurqChequeTransactionType type)throws Exception {
        try{
            
            return CheDALSearch.searchChequeRoll(rollNo,startDate,endDate,type);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static List getTransactionTypes()throws Exception{
        try{
            
            return CheDALSearch.getTransactionTypes();
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    public static List getChequesInPortfolio()throws Exception {
        try{
        
            return CheDALSearch.getChequesInPortfolio();
        
        }        
        catch(Exception ex){
            throw ex;
        }
    }
   
    public static List getChequesGivenToCurrent()throws Exception {
        try{
        
            return CheDALSearch.getChequesGivenToCurrent();
        
        }        
        catch(Exception ex){
            throw ex;
        }
    }
    
    public static TurqCurrentCard getCurrentCardOfCustomerCheque(TurqChequeCheque cheque)throws Exception{
		try{
			
			return CheDALSearch.getCurrentCardOfCustomerCheque(cheque);
		}
		catch(Exception ex)
		{
			throw ex;
		}
    }
    public static List getChequesInBank()throws Exception {
        try{
        
            return CheDALSearch.getChequesInBank();
        
        }        
        catch(Exception ex){
            throw ex;
        }
    }
    public static TurqChequeRoll getChequeRoll(TurqChequeCheque cheque, int rollType)throws Exception {

		CheDALUpdate.initChequeRolls(cheque);
		
		Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
		
		while(it.hasNext())
		{
			
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
			if(chequeInRoll.getTurqChequeRoll().getTurqChequeTransactionType().getId().intValue()==rollType)
			{
				
				return chequeInRoll.getTurqChequeRoll();
				
			}
			
			
		}

		return null;

    }

}
