/*
 * Created on Feb 28, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.admin.dal.AdmDALCurrencyExchangeRateAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

/**
 * @author Cem 
 */
public class AdmBLCurrencyExchangeRateAdd
{
	public static void saveExchangeRate(HashMap argMap) throws Exception
	{
		
		TurqCurrency exchangeCurrency=(TurqCurrency)argMap.get(EngKeys.EXCHANGE_CURRENCY);
		BigDecimal exchangeRatio=(BigDecimal)argMap.get(EngKeys.EXCHANGE_RATIO);
		Date exchangeDate=(Date)argMap.get(EngKeys.EXCHANGE_DATE);
		
		TurqCurrencyExchangeRate newExchangeRate = new TurqCurrencyExchangeRate();
		newExchangeRate.setExchangeRatio(exchangeRatio);
		newExchangeRate.setTurqCurrencyByExchangeCurrencyId(exchangeCurrency);
		newExchangeRate.setTurqCurrencyByBaseCurrencyId(EngBLCommon.getBaseCurrency());
		newExchangeRate.setExhangeRatesDate(exchangeDate);
		EngDALCommon.saveObject(newExchangeRate);
	}

	public static List getCurrencyExchangeRates() throws Exception
	{
		try
		{
			return AdmDALCurrencyExchangeRateAdd.getCurrencyExchangeRates();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}