
package com.turquaz.cheque.bl;

import java.util.Date;
import java.util.List;

import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.engine.dal.TurqChequeTransactionType;

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

}
