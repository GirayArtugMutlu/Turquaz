package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;

import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;

public class EngBLServer {

	public static HashBag getCurrencies() throws Exception
	{
		try
		{
			HashBag currencyBag=new HashBag();
			List list= EngDALCommon.getCurrencies();
			currencyBag.put(EngKeys.CURRENCIES,new HashMap());
			
			for(int k=0; k<list.size(); k++)
			{
				TurqCurrency currency=(TurqCurrency)list.get(k);
				
				currencyBag.put(EngKeys.CURRENCIES,k,EngKeys.CURRENCY_ID,currency.getId());
				currencyBag.put(EngKeys.CURRENCIES,k,EngKeys.CURRENCY_ABBR,currency.getCurrenciesAbbreviation());
				currencyBag.put(EngKeys.CURRENCIES,k,EngKeys.DEFAULT, new Boolean(currency.isDefaultCurrency()));
				currencyBag.put(EngKeys.CURRENCIES,k,EngKeys.CONSTANT, new Boolean(currency.isConstant()));
			}
			
			return currencyBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

}
