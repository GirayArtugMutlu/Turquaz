
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
import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.inventory.dal.InvDALProfitAnalysis;

public class InvBLProfitAnalysis {
    Calendar cal = Calendar.getInstance();
    InvDALProfitAnalysis dalProfit = new InvDALProfitAnalysis();
    public InvBLProfitAnalysis(){
       	
    }
    
    /**
     * 
     * @param type 
     * 0 - Ortalama deger
     * 
     * @return
     */
    public List getTransactionTotals(int type, Date startDate, Date endDate)throws Exception{
     try{
      
     
     if(type == 0){
         
         return dalProfit.getInventoryTotalsAccordingToAvarage(startDate, endDate);
         
     }
     
     else{ 
        return null;
       }
     }
     catch(Exception ex){
         throw ex;
     }
    }

}
