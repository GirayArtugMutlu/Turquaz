/*
 * Created on Feb 28, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.admin.AdmKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;

/**
 * @author Cem 
 */
public class AdmBLCurrencyAdd
{
	public static void saveCurrency(HashMap argMap) throws Exception
	{
		String currencyName=(String)argMap.get(AdmKeys.ADM_CURRENCY_NAME);
		String currencyAbbr=(String)argMap.get(AdmKeys.ADM_CURRENCY_ABBR);
		String currencyCountry=(String)argMap.get(AdmKeys.ADM_CURRENCY_COUNTRY);
		Calendar cal = Calendar.getInstance();
		TurqCurrency newCurrency = new TurqCurrency();
		newCurrency.setCurrenciesName(currencyName);
		newCurrency.setCurrenciesAbbreviation(currencyAbbr);
		newCurrency.setCurrenciesCountry(currencyCountry);
		newCurrency.setCreatedBy(System.getProperty("user"));
		newCurrency.setUpdatedBy(System.getProperty("user"));
		newCurrency.setLastModified(cal.getTime());
		newCurrency.setCreationDate(cal.getTime());
		EngDALCommon.saveObject(newCurrency);
	}
}