/*
 * Created on 15.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqCurrency;

import java.util.Calendar;


public class BankBLBankCardAdd {
	public BankBLBankCardAdd()
	{
	}
	
	private BankDALBankCardAdd bankCardDALAdd=new BankDALBankCardAdd();
	
	Calendar cal=Calendar.getInstance();
	
	public void saveBankCard(String bankName, String bankBranchName, String bankAccountNo, TurqCurrency currency )
	throws Exception
	{
		try
		{
			TurqBanksCard bankCard=new TurqBanksCard();
			bankCard.setBankName(bankName);
			bankCard.setBankBranchName(bankBranchName);
			bankCard.setBankAccountNo(bankAccountNo);
			bankCard.setTurqCurrency(currency);
			
			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			
			bankCard.setCreatedBy(System.getProperty("user"));
			bankCard.setUpdatedBy(System.getProperty("user"));
			bankCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bankCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			bankCard.setTurqCompany(company);
			bankCardDALAdd.saveObject(bankCard);	
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}

}
