
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
 * @author onsel
 * @version $Id$
 */
package com.turquaz.cash.bl;

import java.util.Calendar;

import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;

public class CashBLCashCardUpdate {
    Calendar cal=Calendar.getInstance();
    CashDALCashCard dalCash = new CashDALCashCard();
    
    public CashBLCashCardUpdate(){
        
    }
    
    
    public void updateCashCard(TurqCashCard cashCard, String name, String definition, TurqAccountingAccount cashAccount)throws Exception {
        try{
            
          
          cashCard.setCashCardName(name);
          cashCard.setCashCardDefinition(definition);
          cashCard.setTurqAccountingAccount(cashAccount);
         
          cashCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          cashCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
          
		  dalCash.update(cashCard);   
          
          
        }
        catch(Exception ex){
            
            throw ex;
            
        }
        
        
        
    }
    public void delete(TurqCashCard card)throws Exception{
        
        try{
            dalCash.delete(card);
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }

}
