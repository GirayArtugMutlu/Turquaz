
package com.turquaz.cheque.bl;

import com.turquaz.cheque.dal.CheDALSave;

public class CheBLSaveChequeTransaction {
    
    public CheBLSaveChequeTransaction(){
        
    }
    
    public void saveTransaction(Object obj)throws Exception {
        try{
            
            CheDALSave.save(obj);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    

}
