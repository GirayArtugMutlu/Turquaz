package com.turquaz.engine.ui.component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author Ceday
 */
public class TurquazDecimalFormat extends DecimalFormat
{
	public TurquazDecimalFormat()
	{
		super();
		this.setGroupingSize(3);
		this.setMaximumFractionDigits(2);
		//this.setMinimumFractionDigits(2);
		this.setMaximumIntegerDigits(18);
		DecimalFormatSymbols df = new DecimalFormatSymbols();
		df.setDecimalSeparator(',');
		df.setGroupingSeparator('.');
		this.setDecimalFormatSymbols(df);
		this.setGroupingUsed(true);
	}
}