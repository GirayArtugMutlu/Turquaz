
package com.turquaz.cheque.bl;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
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
    
    public static void saveChequeRoll(TurqAccountingAccount rollAccount, TurqCurrentCard curCard,TurqBanksCard bankCard, String rollNo,Date rollDate,List chequeList, int rollType, boolean sumTransTotal)throws Exception {
     
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
          
          chequeRoll.setTurqEngineSequence(seq);
             
          CheDALSave.save(chequeRoll);
          TurqChequeCheque cheque;
          TurqChequeChequeInRoll chequeInRoll;
          CurBLCurrentTransactionAdd blCurrent = new CurBLCurrentTransactionAdd();
          BigDecimal totalAmount = new BigDecimal(0);
          
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
              totalAmount = totalAmount.add(cheque.getChequesAmount());
              //save current transaction...
              if(curCard!=null&&!sumTransTotal)
              {
              
                  blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,cheque.getChequesAmount(),new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getEngineSequencesId(),"�ek Portf�y No:"+cheque.getChequesPortfolioNo() );
             
              }
              if(bankCard!=null&&!sumTransTotal)
              {
               
              BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,cheque.getChequesAmount(),rollDate,"�ek No:"+cheque.getChequesNo(),rollNo);
              
              }
              
              
              
          
          }   
          
          if(curCard!=null&&sumTransTotal)
          {
              blCurrent.saveCurrentTransaction(curCard,rollDate,rollNo,true,totalAmount,new BigDecimal(0),EngBLCommon.CURRENT_TRANS_CHEQUE,seq.getEngineSequencesId(),"�ek Bordro No:"+chequeRoll.getChequeRollNo());
              
          }
          if(bankCard!=null&&sumTransTotal)
          {
           
          BankBLTransactionAdd.saveChequeTransaction(bankCard,seq,totalAmount,rollDate,"�ek Bordro No:"+rollNo,rollNo);
          
          }
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    
    

}
