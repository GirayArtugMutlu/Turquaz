
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

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;


public class BankBLBankCardSearch {
	
	private BankDALBankCardSearch bankDALBankCardSearch=new BankDALBankCardSearch();
	
	public BankBLBankCardSearch()
	{
	}
	
	
	
	
	public List searchBankCards(String bankName, String bankBranchName, String bankAccountNo, TurqCurrency currency)
	throws Exception
	{
		try
		{
			return bankDALBankCardSearch.searchBankCards(bankName,bankBranchName,bankAccountNo,currency);
		}
		catch(Exception ex)
		{
			throw ex;
		}		
	}
	
	
	public static TurqBanksCard getBankCardByBankCardId(Integer bankId)
	throws Exception
	{
		try 
		{
			return BankDALBankCardSearch.getBankCardByBankCardId(bankId);
		} 
		catch (Exception ex) 
		{
			throw ex;
		}
	}

}
