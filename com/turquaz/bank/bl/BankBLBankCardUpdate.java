
package com.turquaz.bank.bl;
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
* @author  Ceday
* @version  $Id$
*/


import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import com.turquaz.bank.dal.BankDALBankCardUpdate;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;


public class BankBLBankCardUpdate {
	public BankBLBankCardUpdate(){
		
	}
	
	private BankDALBankCardUpdate bankDALBankCardUpdate=new BankDALBankCardUpdate();
	private Calendar cal=Calendar.getInstance();
	
	
	/**
	 * 
	 * @param bankName String
	 * @param bankBranchName String
	 * @param bankAccountNo String
	 * @param aCard TurqBanksCard
	 */
	
	public void updateBankCard(String bankName, String bankBranchName, String bankAccountNo,TurqCurrency currency, String definition, String bankCode, Map accountingAccounts, TurqBanksCard aCard)
	throws Exception{
		try{
			aCard.setBankName(bankName);
			aCard.setBankBranchName(bankBranchName);
			aCard.setBankAccountNo(bankAccountNo);	
			aCard.setTurqCurrency(currency);
			aCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			aCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			aCard.setBankDefinition(definition);
			aCard.setBankCode(bankCode);
			
			bankDALBankCardUpdate.updateObject(aCard);
			
			if(!checkInitialTransaction(aCard))
			{
			
			   BankBLTransactionAdd.saveInitialBankTransaction(aCard);
			    
			}
			updateBankAccountingAccounts(aCard,accountingAccounts);
		
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	/**
	 * 
	 * @return
	 */
	public boolean checkInitialTransaction(TurqBanksCard bankCard) throws Exception{
	   try{
	       return BankDALCommon.checkInitialTransaction(bankCard);
	   }
	   catch(Exception ex)
	   {
	       throw ex;
	   }
	    
	    
	    
	    
	}
	
	public void updateBankAccountingAccounts(TurqBanksCard curCard, Map accounts)throws Exception{
		
		Iterator it = curCard.getTurqBankAccountingAccounts().iterator();
		while(it.hasNext()){
		BankDALCommon.deleteObject(it.next());
		}
		
		new BankBLBankCardAdd().saveBankAccountingAccounts(curCard,accounts);
		
		
		
		
	}
	public boolean hasTransaction(TurqBanksCard bankCard)throws Exception {
		
		return bankDALBankCardUpdate.hasTransaction(bankCard);
		
	}
	
	
	/**
	 * 
	 * @param obj Serializable object
	 */
	
	public void deleteObject(Object obj)throws Exception{
 		try{
 			
 			
 			
 			bankDALBankCardUpdate.deleteObject(obj);
 			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	/**
	 * 
	 * @param obj Serializable object
	 */
	
	public void deleteBankCard(TurqBanksCard bankCard)throws Exception{
 		try{
 			
 			Iterator it = bankCard.getTurqBankAccountingAccounts().iterator();
 			while(it.hasNext())
 			{
 				deleteObject(it.next());
 				
 			}
 			
 			bankDALBankCardUpdate.deleteInitialTransaction(bankCard);
 			
 			bankDALBankCardUpdate.deleteObject(bankCard);
 			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
