
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

import com.turquaz.bank.dal.BankDALBankCardUpdate;
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
	
	public void updateBankCard(String bankName, String bankBranchName, String bankAccountNo,TurqCurrency currency, String definition, TurqBanksCard aCard)
	throws Exception{
		try{
			aCard.setBankName(bankName);
			aCard.setBankBranchName(bankBranchName);
			aCard.setBankAccountNo(bankAccountNo);	
			aCard.setTurqCurrency(currency);
			aCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			aCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			aCard.setBankDefinition(definition);
			bankDALBankCardUpdate.updateObject(aCard);
			
		}
		catch(Exception ex){
			throw ex;
		}
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

}
