
package com.turquaz.cash.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.cash.dal.CashDALCashCard;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCashTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;

public class CashBLCashTransactionAdd {
    CashDALCashCard dalCash = new CashDALCashCard();
    
    AccBLTransactionAdd blAccTran = new AccBLTransactionAdd();
    CurBLCurrentTransactionAdd blCurTrans = new CurBLCurrentTransactionAdd();
	
    private Calendar cal=Calendar.getInstance();
    
    public CashBLCashTransactionAdd(){
        
    }
    
 
  /**
     * TODO Update according to cash design changes
     * @param cashCard
     * @param current
     * @param type
     * @param seq
     * @param totalAmount
     * @param transDate
     * @param definition
     * @param document_no
     * @throws Exception
  */
 public void saveCurrentTransaction(TurqCashCard cashCard, TurqCurrentCard current, 
         							int type, TurqEngineSequence seq, 
         							BigDecimal totalAmount, Date transDate,
         							String definition, String document_no)throws Exception{
 try{
     
      if(seq ==null){
          try{
          TurqModule module = new TurqModule();
          module.setModulesId(new Integer(EngBLCommon.MODULE_CASH));
          seq = new TurqEngineSequence();
          seq.setTurqModule(module);
          dalCash.save(seq);
          }
          catch(Exception ex){
              throw ex;
          }
      }
     
     TurqCashTransactionType transType = new TurqCashTransactionType();
     transType.setCashTransactionTypesId(new Integer(type));
    
     TurqCashTransaction cashTrans = new TurqCashTransaction();
     cashTrans.setTurqCashCard(cashCard);
     cashTrans.setTurqCashTransactionType(transType);
     cashTrans.setTurqEngineSequence(seq);
     cashTrans.setTransactionDate(transDate);
     cashTrans.setTransactionDefinition(definition);
     cashTrans.setDocumentNo(document_no);
     cashTrans.setCreatedBy(System.getProperty("user"));
	 cashTrans.setUpdatedBy(System.getProperty("user"));
	 cashTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	 cashTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
     
 /*
  * Create cash Transaction Rows
  */
	 TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
	 cashTransRow.setCreatedBy(System.getProperty("user"));
	 cashTransRow.setUpdatedBy(System.getProperty("user"));
	 cashTransRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	 cashTransRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
	 cashTransRow.setTransactionDefinition(definition);
	 cashTransRow.setTurqAccountingAccount(current.getTurqAccountingAccount());
	 
	 
	/*
      * Create Accounting transaction
      */
     TurqAccountingTransactionColumn accTransRowCash = new TurqAccountingTransactionColumn();
	 TurqAccountingTransactionColumn accTransRowCurrent = new TurqAccountingTransactionColumn();  
	   
	 accTransRowCash.setTransactionDefinition(definition);
	 accTransRowCash.setTurqAccountingAccount(cashCard.getTurqAccountingAccount());
	 
	 accTransRowCurrent.setTransactionDefinition(definition);
	 accTransRowCurrent.setTurqAccountingAccount(current.getTurqAccountingAccount());
	 
	 
     
	 int accTransType = 0;
     
	 boolean currentTransType = false; // Credit or Debit
     
	 if(type==EngBLCommon.CASH_CURRENT_COLLECT)
     {
        accTransRowCash.setDeptAmount(totalAmount);
        accTransRowCash.setCreditAmount(new BigDecimal(0));
        
        accTransRowCurrent.setDeptAmount(new BigDecimal(0));
        accTransRowCurrent.setCreditAmount(totalAmount);
        
        cashTransRow.setDeptAmount(new BigDecimal(0));
        cashTransRow.setCreditAmount(totalAmount);
        
        accTransType = EngBLCommon.ACCOUNTING_TRANS_COLLECT;
        currentTransType = EngBLCommon.CURRENT_TRANS_CREDIT;
        
     }
     
     else if(type==EngBLCommon.CASH_CURRENT_PAYMENT)
     {
         
         
         accTransRowCash.setDeptAmount(new BigDecimal(0));
         accTransRowCash.setCreditAmount(totalAmount);
         
         accTransRowCurrent.setDeptAmount(totalAmount);
         accTransRowCurrent.setCreditAmount(new BigDecimal(0));
         
         cashTransRow.setDeptAmount(totalAmount);
         cashTransRow.setCreditAmount(new BigDecimal(0));
                  
         accTransType = EngBLCommon.ACCOUNTING_TRANS_PAYMENT;
         currentTransType = EngBLCommon.CURRENT_TRANS_DEBIT;
         
     } 

     /**
      * Save Cash Transaction
      */
	    dalCash.save(cashTrans);
	    
	
	    
	    
	    /**
		 * Save Cash Transaction Row
		 * 
		 */  
	
	    cashTransRow.setTurqCashTransaction(cashTrans);
	    dalCash.save(cashTransRow);
	    
	    
	    
	  /**
	   * Save Current transaction
	  */
	    
	    blCurTrans.saveCurrentTransaction(current, transDate,document_no,currentTransType,
	            						  totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CASH,
	            						  seq.getEngineSequencesId());
	
		    
	    
	    
	    
	    
	    /**
	     * Save Accounting Transaction 
	     * 
	    */
	   
	   Integer transId = blAccTran.saveAccTransaction(transDate,document_no,accTransType,seq.getTurqModule().getModulesId().intValue(),seq.getEngineSequencesId(),definition);
	   blAccTran.saveAccTransactionRow(accTransRowCash,transId);
	   blAccTran.saveAccTransactionRow(accTransRowCurrent,transId);
   
    
   }
    
    catch(Exception ex){
       
        throw ex;
    
    }
        
        
    }


}
