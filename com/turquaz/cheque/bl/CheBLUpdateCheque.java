/*
 * Created on Feb 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.cheque.bl;

import java.math.BigDecimal;
import java.util.Iterator;

import com.turquaz.bank.bl.BankBLTransactionAdd;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cheque.dal.CheDALSave;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CheBLUpdateCheque {
	
	public static void updateCheque(TurqChequeCheque cheque)throws Exception{
	
	try{

			/**
			 * 
			 * 1-) update cheque
			 * 2-) get cheque Rolls
			 * 3-) update transactions
			 * 4-)  
			 */
		
		CheDALSave.update(cheque);
		
		CheDALUpdate.initChequeRolls(cheque);
		
		Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
		
		while(it.hasNext())
		{
			
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
			updateChequeRollTransactions(chequeInRoll.getTurqChequeRoll());
			
		}
		
		
		
		
		
	
	}
	catch(Exception ex)
	{
		throw ex;
	}
		
	}
	public static void deleteCheque(TurqChequeCheque cheque)throws Exception 
	{
		try{
			
			/**
			 * 
			 * 1-) 
			 * 2-) get cheque Rolls
			 * 3-) update transactions
			 * 4-)  
			 */
		
		
		CheDALUpdate.initChequeRolls(cheque);
		
		Iterator it = cheque.getTurqChequeChequeInRolls().iterator();
		
		while(it.hasNext())
		{
			
			TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
			
			TurqChequeRoll chequeRoll = chequeInRoll.getTurqChequeRoll();
			
			CheDALSave.delete(chequeInRoll);
			
			
			updateChequeRollTransactions(chequeRoll);
			
		}
		
		CheDALSave.delete(cheque);
		
		
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	
	private static void updateChequeRollTransactions(TurqChequeRoll chequeRoll)throws Exception{
		try{
			
			CheDALUpdate.initializeChequeRoll(chequeRoll);
			
			updateCurrentTransactions(chequeRoll);
			
			updateBankTransactions(chequeRoll);
			
			
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		
		
	}
	
	private static void updateCurrentTransactions(TurqChequeRoll chequeRoll)throws Exception{

		try{
			CurBLCurrentTransactionAdd blCurrent = new CurBLCurrentTransactionAdd();
			
			// Delete Current transactions first
			Iterator it = chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			
			while (it.hasNext())
			{
				CheDALSave.delete(it.next());		
			}
			
			
			if(chequeRoll.getTurqChequeTransactionType().getChequeTransactionTypesId().intValue()==EngBLCommon.CHEQUE_TRANS_IN)
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator(); 
				
				
				while(it.hasNext())
				{
					
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
					
					blCurrent.saveCurrentTransaction(chequeRoll.getTurqCurrentCard(),
													chequeRoll.getChequeRollsDate(),
													chequeRoll.getChequeRollNo(),
													true, //Credit
													chequeInRoll.getTurqChequeCheque().getChequesAmount(),
													new BigDecimal(0),
													EngBLCommon.CURRENT_TRANS_CHEQUE,
													chequeRoll.getTurqEngineSequence().getEngineSequencesId(),
													"Çek Portföy No:"+chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo() );
	             }
				
			    
			
			}
			else if(chequeRoll.getTurqChequeTransactionType().getChequeTransactionTypesId().intValue()==EngBLCommon.CHEQUE_TRANS_OUT_CURRENT)
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator(); 
				
				
				while(it.hasNext())
				{
					
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
					
					blCurrent.saveCurrentTransaction(chequeRoll.getTurqCurrentCard(),
													chequeRoll.getChequeRollsDate(),
													chequeRoll.getChequeRollNo(),
													false, //Dept
													chequeInRoll.getTurqChequeCheque().getChequesAmount(),
													new BigDecimal(0),
													EngBLCommon.CURRENT_TRANS_CHEQUE,
													chequeRoll.getTurqEngineSequence().getEngineSequencesId(),
													"Çek Portföy No:"+chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo() );
	             }
				
			    
			
			}
			
			
			
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	private static void updateBankTransactions(TurqChequeRoll chequeRoll)throws Exception{
		try{
			//Delete Bank Transactions First
			Iterator it = chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills().iterator();
			while(it.hasNext())
			{
			
				TurqBanksTransactionBill transBill = (TurqBanksTransactionBill)it.next();
				BankBLTransactionUpdate.initializeTransaction(transBill);
				BankBLTransactionUpdate.deleteTransaction(transBill);
				
			}
				
			if(chequeRoll.getTurqChequeTransactionType().getChequeTransactionTypesId().intValue()==EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK)
			{
				it = chequeRoll.getTurqChequeChequeInRolls().iterator(); 
				
				
				while(it.hasNext())
				{
					
					TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
					
					 BankBLTransactionAdd.saveChequeTransaction(chequeInRoll.getTurqChequeCheque().getTurqBanksCard(),
					 											chequeRoll.getTurqEngineSequence(),
					 											chequeInRoll.getTurqChequeCheque().getChequesAmount(),
																chequeRoll.getChequeRollsDate(),
																"Çek Portfoy No:"+chequeInRoll.getTurqChequeCheque().getChequesPortfolioNo(),
																chequeRoll.getChequeRollNo());
		              			
				}
				
			    
			
			}
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

}
