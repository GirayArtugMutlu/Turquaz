/*
 * Created on 15.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.bl;
import java.util.List;

import com.turquaz.bank.dal.BankDALBankCardSearch;
import com.turquaz.engine.dal.TurqCurrency;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankBLBankCardSearch {
	public BankBLBankCardSearch(){
	}
	private BankDALBankCardSearch bankDALBankCardSearch=new BankDALBankCardSearch();
	
	public List searchBankCards(String bankName, String bankBranchName, String bankAccountNo, TurqCurrency currency)
	throws Exception{
		try{
		return bankDALBankCardSearch.searchBankCards(bankName,bankBranchName,bankAccountNo,currency);
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
