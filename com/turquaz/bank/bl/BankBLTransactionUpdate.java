
package com.turquaz.bank.bl;

import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.dal.TurqBanksTransactionBill;

public class BankBLTransactionUpdate {

    public static TurqBanksTransactionBill initializeTransaction(Integer transId)throws Exception {
        try{
            
            return BankDALCommon.initializeTransaction(transId);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
}
