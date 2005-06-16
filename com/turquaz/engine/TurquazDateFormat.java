package com.turquaz.engine;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TurquazDateFormat {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String format(Date date)
	{
		return formatter.format(date);
	}
}
