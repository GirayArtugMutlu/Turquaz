
package com.turquaz.engine.ui.component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author onsel
 *
  */
public class TurkishCurrencyFormat extends DecimalFormat {
	
	static TurkishCurrencyFormat _instance;
	
	public TurkishCurrencyFormat(int minFractionDigits){
	super();
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setCurrencySymbol("YTL");
	dfs.setGroupingSeparator('.');
	dfs.setDecimalSeparator(',');
	dfs.setInternationalCurrencySymbol("YTL");
	this.setDecimalFormatSymbols(dfs);
	this.setGroupingSize(3);
	this.setMinimumFractionDigits(2);
	this.setMaximumFractionDigits(minFractionDigits);
	this.setGroupingUsed(true);
	
	}
	
	
	
	
	public BigDecimal getBigDecimal(String str)
	{
		str=str.replaceAll("\\.","");
		str=str.replace(',','.');
		return new BigDecimal(str);
	}

}
