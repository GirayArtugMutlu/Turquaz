
package com.turquaz.bank.bl;
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

import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.dal.TurqBanksCard;

public class BankBLTransactionSearch {
    public static List searchtransaction(TurqBanksCard bankCard, String docNo, Date startDate, Date endDate)throws Exception{
        try{
            return BankDALCommon.searchBankTransactions(bankCard,docNo,startDate, endDate);
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    public static List getTransactions(TurqBanksCard bankCard, Date startDate, Date endDate)throws Exception {
        try{
            
            return BankDALCommon.getTransactions(bankCard, startDate, endDate);
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    //Devreden Toplam
    public static List getDeferredTotal(TurqBanksCard cashCard, Date endDate) throws Exception
    {
        try{
        
            return BankDALCommon.getDeferredTotal(cashCard,endDate);
        }
        catch(Exception ex){
            throw ex;
        }
    }
    

}
