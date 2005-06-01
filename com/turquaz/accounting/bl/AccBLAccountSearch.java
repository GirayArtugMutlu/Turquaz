package com.turquaz.accounting.bl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.dal.AccDALSearchAccounts;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;

public class AccBLAccountSearch {

	
	public static HashBag searchAccounts(HashMap argMap)throws Exception
	{
		String accCode = (String) argMap.get(AccKeys.ACC_ACCOUNT_CODE);
		String accName = (String) argMap.get(AccKeys.ACC_ACCOUNT_NAME);
		
		HashBag accountsBag=new HashBag();
		accountsBag.put(AccKeys.ACC_ACCOUNTS,new HashMap());
		
		List accList= AccDALSearchAccounts.searchAccounts(accCode,accName);	
		
		for(int k=0; k<accList.size(); k++)
		{
			Object[] accInfo=(Object[])accList.get(k);
			Integer accountId=(Integer)accInfo[0];
			String accountCode=(String)accInfo[1];
			String accountName=(String)accInfo[2];
			
			BigDecimal deptAmount=(BigDecimal)accInfo[3];
			if (deptAmount==null)
			{
				deptAmount=new BigDecimal(0);
			}
			
			BigDecimal creditAmount=(BigDecimal)accInfo[4];
			if (creditAmount==null)
			{
				creditAmount=new BigDecimal(0);
			}
			
			accountsBag.put(AccKeys.ACC_ACCOUNTS,k,AccKeys.ACC_ACCOUNT_ID,accountId);
			accountsBag.put(AccKeys.ACC_ACCOUNTS,k,AccKeys.ACC_ACCOUNT_CODE,accountCode);
			accountsBag.put(AccKeys.ACC_ACCOUNTS,k,AccKeys.ACC_ACCOUNT_NAME,accountName);
			accountsBag.put(AccKeys.ACC_ACCOUNTS,k,EngKeys.DEPT_AMOUNT,deptAmount);
			accountsBag.put(AccKeys.ACC_ACCOUNTS,k,EngKeys.CREDIT_AMOUNT,creditAmount);			
			
		}
	
		return accountsBag;
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
