/*
 * Created on 15.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.bl;

import com.turquaz.bank.dal.BankDALBankCardAdd;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqCurrency;

import java.util.Calendar;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
