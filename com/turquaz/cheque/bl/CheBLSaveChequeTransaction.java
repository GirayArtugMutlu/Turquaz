
package com.turquaz.cheque.bl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class CheBLSaveChequeTransaction {
    
    public CheBLSaveChequeTransaction(){
        
    }
    
    public static void saveChequeRoll(TurqCurrentCard curCard, String rollNo,Date rollDate,List chequeList, int rollType)throws Exception {
     
      try{
          TurqChequeTransactionType type = new TurqChequeTransactionType();
          type.setChequeTransactionTypesId(new Integer(rollType));
         
         
          TurqModule module = new TurqModule();
          module.setModulesId(new Integer(EngBLCommon.MODULE_CHEQUE));
          
          TurqEngineSequence seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          CheDALSave.save(seq);
          
          
          TurqChequeRoll chequeRoll = new TurqChequeRoll();
          chequeRoll.setChequeRollsDate(rollDate);
          chequeRoll.setChequeRollNo(rollNo);
          chequeRoll.setTurqChequeTransactionType(type);
          
          chequeRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
          chequeRoll.setLastModified(Calendar.getInstance().getTime());
          chequeRoll.setCreationDate(Calendar.getInstance().getTime());
          
          
          
          chequeRoll.setTurqEngineSequence(seq);
          
          CheDALSave.save(chequeRoll);
          
      
          CheDALSave.save(chequeRoll);
          TurqChequeCheque cheque;
          TurqChequeChequeInRoll chequeInRoll;
          
          for(int i = 0; i<chequeList.size();i++){
              
              chequeInRoll = new TurqChequeChequeInRoll();
              
              cheque = (TurqChequeCheque)chequeList.get(i);
              
              CheDALSave.saveOrUpdate(cheque);
              
              chequeInRoll.setTurqChequeCheque(cheque);
              chequeInRoll.setTurqChequeRoll(chequeRoll);
              
              chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
              chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
              chequeInRoll.setLastModified(Calendar.getInstance().getTime());
              chequeInRoll.setCreationDate(Calendar.getInstance().getTime());                         
              
              CheDALSave.save(chequeInRoll);
          }          
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    

}
