
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
* @author  Onsel Armagan
* @version  $Id$
*/

import com.turquaz.bank.dal.BankDALBankCardAdd;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

import java.util.Calendar;


public class BankBLBankCardAdd {
	public BankBLBankCardAdd()
	{
	}
	
	private BankDALBankCardAdd bankCardDALAdd=new BankDALBankCardAdd();
	
	Calendar cal=Calendar.getInstance();
	
	public void saveBankCard(String bankName, String bankBranchName, String bankAccountNo, TurqCurrency currency, String definition )
	throws Exception
	{
		try
		{
			TurqBanksCard bankCard=new TurqBanksCard();
			bankCard.setBankName(bankName);
			bankCard.setBankBranchName(bankBranchName);
			bankCard.setBankAccountNo(bankAccountNo);
			bankCard.setTurqCurrency(currency);
			bankCard.setBankDefinition(definition);
			bankCard.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			bankCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bankCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			bankCardDALAdd.saveObject(bankCard);	
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

}
