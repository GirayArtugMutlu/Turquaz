/*
 * Created on Feb 28, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;

/**
 * @author Cem 
 */
public class AdmBLCurrencyAdd
{
	public static void saveCurrency(String currencyName, String currencyAbbr, String currencyCountry) throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqCurrency newCurrency = new TurqCurrency();
		newCurrency.setCurrenciesName(currencyName);
		newCurrency.setCurrenciesAbbreviation(currencyAbbr);
		newCurrency.setCurrenciesCountry(currencyCountry);
		newCurrency.setCreatedBy(System.getProperty("user"));
		newCurrency.setUpdatedBy(System.getProperty("user"));
		newCurrency.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		newCurrency.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		EngDALCommon.saveObject(newCurrency);
	}
}