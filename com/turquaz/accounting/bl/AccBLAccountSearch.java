package com.turquaz.accounting.bl;

import java.util.HashMap;
import java.util.List;

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALSearchAccounts;

public class AccBLAccountSearch {

	
	public static List searchAccounts(HashMap argMap)throws Exception
	{
		String accCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
		String accName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
		
		return AccDALSearchAccounts.searchAccounts(accCode,accName);		
	}
	
	public static String getAccountCodeById(HashMap argMap) throws Exception
	{
		Integer accId=(Integer)argMap.get(AccKeys.ACC_ACCOUNT_ID);
		
		return AccDALSearchAccounts.getAccountCodeById(accId);
	}
	
	public static Integer getAccountIdByAccountCode(String accountCode) throws Exception
	{
		return AccDALSearchAccounts.getAccountIdByAccountCode(accountCode);
	}

}
