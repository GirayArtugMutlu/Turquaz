
package com.turquaz.cheque.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqCurrentCard;

public class CheBLUpdateChequeRoll {

    public static void initializeChequeRoll(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
           CheDALUpdate.initializeChequeRoll(chequeRoll); 
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static void updateChequeRollIn(TurqChequeRoll chequeRoll, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType)throws Exception{
        try{
           
            emptyCheckRollIn(chequeRoll);
           
        
           chequeRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
           chequeRoll.setLastModified(Calendar.getInstance().getTime());
           
          
           if(curCard!=null)
           {
            chequeRoll.setTurqCurrentCard(curCard);
            
            TurqBanksCard bankCardEmpty = new TurqBanksCard();
            bankCardEmpty.setBanksCardsId(new Integer(-1));
            chequeRoll.setTurqBanksCard(bankCardEmpty);
               
           }
           else if(bankCard!=null)
           {
               chequeRoll.setTurqBanksCard(bankCard);
               
               TurqCurrentCard curCardEmpty = new TurqCurrentCard();
               curCardEmpty.setCurrentCardsId(new Integer(-1));
               chequeRoll.setTurqCurrentCard(curCardEmpty);
               
           }
           
          
                
           TurqChequeCheque cheque;
         
           TurqChequeChequeInRoll chequeInRoll;
           CurBLCurrentTransactionAdd blCurrent = new CurBLCurrentTransactionAdd();
           
           for(int i = 0; i<chequeList.size();i++){
               
               chequeInRoll = new TurqChequeChequeInRoll();
               
               cheque = (TurqChequeCheque)chequeList.get(i);
           
               
             
               
               CheDALSave.save(cheque);
               
               chequeInRoll.setTurqChequeCheque(cheque);
               chequeInRoll.setTurqChequeRoll(chequeRoll);
               
               chequeInRoll.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
               chequeInRoll.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
               chequeInRoll.setLastModified(Calendar.getInstance().getTime());
               chequeInRoll.setCreationDate(Calendar.getInstance().getTime()); 
               
               CheDALSave.save(chequeInRoll);
               
               //save current transaction...
               if(curCard!=null)
               {
                   blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,chequeRoll.getTurqEngineSequence().getEngineSequencesId(),"Çek Portföy No:"+cheque.getChequesPortfolioNo() );
               }
               
               
               
           
           }         
            
            
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
    public static void emptyCheckRollIn(TurqChequeRoll chequeRoll)throws Exception
    {
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
	        
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static void deleteChequeRollIn(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
          emptyCheckRollIn(chequeRoll);
            
	        //Delete Roll Now
	        
	        CheDALSave.delete(chequeRoll);
	        
	        
            
        }
        catch(Exception ex)
        {
           throw ex;
        }
    }
}
