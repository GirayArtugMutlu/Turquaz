
package com.turquaz.cash.bl;

import java.util.Iterator;

import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;

public class CashBLCashTransactionUpdate {

    CashDALCashCard dalCash = new CashDALCashCard();
    
    public CashBLCashTransactionUpdate(){
        
    }
    
    public TurqCurrentCard getCurrentCard(TurqEngineSequence seq) throws Exception{
        try{
            
            return dalCash.getCurrentCard(seq);
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    public void deleteCashTrans(TurqCashTransaction cashTrans)throws Exception{
        try{
            
            Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
            while(it.hasNext()){
                
                dalCash.delete(it.next());
                
            }
            
            dalCash.delete(cashTrans);
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    
    
    
}
