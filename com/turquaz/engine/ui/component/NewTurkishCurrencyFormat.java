
package com.turquaz.engine.ui.component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author onsel
 *
  */
public class NewTurkishCurrencyFormat extends DecimalFormat {
	
	static NewTurkishCurrencyFormat _instance;
	
	public NewTurkishCurrencyFormat(){
	super();
	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
	dfs.setCurrencySymbol("YTL");
	dfs.setGroupingSeparator('.');
	dfs.setDecimalSeparator(',');
	dfs.setInternationalCurrencySymbol("YTL");
	this.setDecimalFormatSymbols(dfs);
	this.setGroupingSize(3);
	this.setMaximumFractionDigits(2);
	this.setGroupingUsed(true);
	
	}
	
	public String format(BigDecimal dc){
		
		String formatted = super.format(dc);
		formatted +=" "+this.getDecimalFormatSymbols().getCurrencySymbol();
		return formatted;
		
	}
	
	public static synchronized String formatBD(BigDecimal bdc){
		
		if(_instance == null){
			
			_instance = new NewTurkishCurrencyFormat();
		}
		return _instance.format(bdc);
		
	}
	

}
