
package com.turquaz.cheque.bl;

import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.engine.dal.TurqChequeRoll;

public class CheBLUpdateChequeRoll {

    public static void initializeChequeRoll(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
           CheDALUpdate.initializeChequeRoll(chequeRoll); 
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
}
