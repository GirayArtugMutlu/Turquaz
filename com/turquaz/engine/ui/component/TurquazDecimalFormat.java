/*
 * Created on 26.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TurquazDecimalFormat extends DecimalFormat{
	
	public TurquazDecimalFormat ()
	{
		super();
		this.setGroupingSize(3);
		this.setMaximumFractionDigits(2);
		this.setMaximumIntegerDigits(18);
		DecimalFormatSymbols df=new DecimalFormatSymbols();
		df.setDecimalSeparator(',');
		df.setGroupingSeparator('.');
		this.setDecimalFormatSymbols(df);
		this.setGroupingUsed(true);
	}
	

}
