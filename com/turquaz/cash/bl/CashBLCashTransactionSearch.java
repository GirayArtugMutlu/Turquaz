
package com.turquaz.cash.bl;

import java.util.Date;
import java.util.List;

import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;

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
   public TurqCashTransaction initializeCashTransaction(Integer id)throws Exception
   {
       try{
                    
           return dalCash.initiliazeCashTrans(id);
           
           
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
