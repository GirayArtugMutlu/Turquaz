/*
 * Created on Feb 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;

import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLCurrencyAdd {
	private static Calendar cal=Calendar.getInstance();
	
	public static void saveCurrency(String currencyName,String currencyAbbr,
			String currencyCountry) throws Exception
	{
		TurqCurrency newCurrency=new TurqCurrency();
		
		newCurrency.setCurrenciesName(currencyName);
		newCurrency.setCurrenciesAbbreviation(currencyAbbr);
		newCurrency.setCurrenciesCountry(currencyCountry);
		
		newCurrency.setCreatedBy(System.getProperty("user"));
		newCurrency.setUpdatedBy(System.getProperty("user"));
		newCurrency.setLastModified(new java.sql.Date( cal.getTime().getTime()));
		newCurrency.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		
		EngDALCommon.saveObject(newCurrency);
	}

}
