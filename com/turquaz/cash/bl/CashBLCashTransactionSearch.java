
package com.turquaz.cash.bl;

import java.util.Date;
import java.util.List;

import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.TurqCashCard;

public class CashBLCashTransactionSearch {
    CashDALCashCard dalCash = new CashDALCashCard();

    public CashBLCashTransactionSearch(){
        
    }
    
   public List searchCashTransactions(TurqCashCard cashCard, Date startDate, Date endDate)throws Exception{
       try{
           
           
           return dalCash.searchCashTransaction(cashCard,startDate,endDate);
           
           
       }
       catch(Exception ex){
           throw ex;
       }
       
   }

}
