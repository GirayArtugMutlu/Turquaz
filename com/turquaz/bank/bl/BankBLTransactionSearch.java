
package com.turquaz.bank.bl;

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
