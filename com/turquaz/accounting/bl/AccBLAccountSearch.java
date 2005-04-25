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

}
