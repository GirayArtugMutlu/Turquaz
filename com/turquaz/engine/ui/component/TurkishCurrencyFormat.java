
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
	
	public TurkishCurrencyFormat(){
	super();
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setCurrencySymbol("YTL");
	dfs.setGroupingSeparator('.');
	dfs.setDecimalSeparator(',');
	dfs.setInternationalCurrencySymbol("YTL");
	this.setDecimalFormatSymbols(dfs);
	this.setGroupingSize(3);
	this.setMinimumFractionDigits(2);
	this.setMaximumFractionDigits(2);
	this.setGroupingUsed(true);
	
	}
	public TurkishCurrencyFormat(int minFraction){
		super();
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setCurrencySymbol("YTL");
		dfs.setGroupingSeparator('.');
		dfs.setDecimalSeparator(',');
		dfs.setInternationalCurrencySymbol("YTL");
		this.setDecimalFormatSymbols(dfs);
		this.setGroupingSize(3);
		this.setMinimumFractionDigits(minFraction);
		this.setMaximumFractionDigits(minFraction);
		this.setGroupingUsed(true);
		
		}
		
	
	
	
	public BigDecimal getBigDecimal(String str)
	{
		str=str.replaceAll("\\.","");
		str=str.replace(',','.');
		return new BigDecimal(str);
	}

}
