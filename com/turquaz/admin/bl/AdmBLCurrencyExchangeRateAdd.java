/*
 * Created on Feb 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.turquaz.admin.dal.AdmDALCurrencyExchangeRateAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLCurrencyExchangeRateAdd {
	
	public static void saveExchangeRate(TurqCurrency exchangeCurrency,
			BigDecimal exchangeRatio, Date exchangeDate) throws Exception
	{
		TurqCurrencyExchangeRate newExchangeRate= new TurqCurrencyExchangeRate();
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
		catch(Exception ex )
		{
			throw ex;
		}
	}
}
