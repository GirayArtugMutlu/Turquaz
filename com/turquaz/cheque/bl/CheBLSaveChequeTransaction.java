
package com.turquaz.cheque.bl;

import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLSaveChequeTransaction {
    
    public CheBLSaveChequeTransaction(){
        
    }
    
    public void saveChequeRoll(TurqCurrentCard curCard, String rollNo,Date rollDate,List chequeList)throws Exception {
     
      try{
          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
      
          
            
           
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    

}
