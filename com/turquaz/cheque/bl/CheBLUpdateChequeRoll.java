
package com.turquaz.cheque.bl;

import java.util.Iterator;

import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
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
    public static void deleteChequeRollIn(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
           //Delete cheques In the Roll
            Iterator it = chequeRoll.getTurqChequeChequeInRolls().iterator();
	        
	        while(it.hasNext()){
	            
	            TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
	            TurqChequeCheque cheque = chequeInRoll.getTurqChequeCheque();
	            CheDALSave.delete(chequeInRoll);
	            CheDALSave.delete(cheque);
	            
	            
	        }
	        
	        //Delete Current Transaction 
	        
	        it = chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
	        while(it.hasNext()){
	            
	           CheDALSave.delete(it.next());
	            
	        }
	        //Delete Bank Transaction 
	        
	        it = chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills().iterator();
	        while(it.hasNext()){
	            
	           TurqBanksTransactionBill transBill = (TurqBanksTransactionBill) it.next();
	           BankBLTransactionUpdate.initializeTransaction(transBill);
	           BankBLTransactionUpdate.deleteTransaction(transBill);
	            
	        }
	        
	        //Delete Roll Now
	        
	        CheDALSave.delete(chequeRoll);
	        
	        
            
        }
        catch(Exception ex)
        {
           throw ex;
        }
    }
}
