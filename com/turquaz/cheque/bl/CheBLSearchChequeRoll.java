
package com.turquaz.cheque.bl;

import java.util.List;

import com.turquaz.cheque.dal.CheDALSearch;
import com.turquaz.engine.dal.TurqChequeTransactionType;

public class CheBLSearchChequeRoll {
    
    public List searchChequeRoll(String rollNo, String startDate, String endDate, TurqChequeTransactionType type)throws Exception {
        try{
            
            return CheDALSearch.searchChequeRoll(rollNo,startDate,endDate,type);
        }
        catch(Exception ex){
            throw ex;
        }
    }

}
