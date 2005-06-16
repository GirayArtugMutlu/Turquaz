package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqSetting;

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

	public static TurqEngineSequence saveEngineSequence(int moduleId) throws Exception
	{
		TurqEngineSequence seq = new TurqEngineSequence();
		TurqModule module = new TurqModule();
		module.setId(new Integer(moduleId));
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		return seq;
	}

	public static Boolean checkUserPass(HashMap argMap) throws Exception
	{
		
		String user = (String)argMap.get(EngKeys.USER);
		String pass = (String)argMap.get(EngKeys.PASSWORD);
		
		return new Boolean(EngDALCommon.checkUserPass(user, pass));
		
	}

	public static TurqSetting getTurqSetting()throws Exception
	{
		return EngDALCommon.getTurqSetting();
	}

	public static void delete(HashMap argMap) throws Exception
	{
		try
		{
			Iterator it=argMap.values().iterator();
			while(it.hasNext())
				EngDALCommon.deleteObject(it.next());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void update(HashMap argMap) throws Exception
	{
		try
		{
			Iterator it=argMap.values().iterator();
			while(it.hasNext())
				EngDALCommon.updateObject(it.next());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

}
