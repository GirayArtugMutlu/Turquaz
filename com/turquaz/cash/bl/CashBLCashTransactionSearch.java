
package com.turquaz.cash.bl;
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

import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;

public class CashBLCashTransactionSearch {
    CashDALCashCard dalCash = new CashDALCashCard();

    public CashBLCashTransactionSearch(){
        
    }
    
   public List searchCashTransactions(TurqCashCard cashCard, Date startDate, Date endDate, String definition)throws Exception{
       try{
           
           
           return dalCash.searchCashTransaction(cashCard,startDate,endDate, definition);
           
           
       }
       catch(Exception ex){
           throw ex;
       }
       
   }
   public TurqCashTransaction initializeCashTransaction(Integer id)throws Exception
   {
       try{
                    
           return dalCash.initiliazeCashTrans(id);
           
           
       }
       catch(Exception ex){
           throw ex;
       }
   }
   
   public void initializeCashTransaction(TurqCashTransaction cashTrans)throws Exception
   {
       try{
                    
       dalCash.initiliazeCashTrans(cashTrans);
           
           
       }
       catch(Exception ex){
           throw ex;
       }
   }
   public static List getTransactions(TurqCashCard cashCard, Date startDate, Date endDate)throws Exception{
       try{
           
           return CashDALCashCard.getTransactions(cashCard,startDate,endDate);
           
       }
       catch(Exception ex){
           throw ex;
       }
   }
 
   // Devreden
   public static List getDeferredTotal(TurqCashCard cashCard,Date endDate)throws Exception 
   {
       try
       {
           return CashDALCashCard.getDeferredTotal(cashCard,endDate);
       }
       catch(Exception ex)
       {
           throw ex;
       }
       
   }

}
