package com.turquaz.engine;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author Onsel Armagan
 * @version $Id$
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.log4j.Logger;

public class EngConfiguration
{
	private static final String filename = "config/turquaz.properties"; //$NON-NLS-1$
	private Properties props;
	public static String logoURL = "";
	public Date currentDate;
	private static EngConfiguration _instance;

	private EngConfiguration()
	{
		try
		{
			currentDate = Calendar.getInstance().getTime();
			FileInputStream fis = new FileInputStream(filename);
			props = new Properties();
			props.load(fis);
			logoURL = props.getProperty("logoURL");
			if (logoURL == null)
			{
				logoURL = "";
			}
			
			
			
			if (props.getProperty("invoice_template") != null) { //$NON-NLS-1$
				
				String invoice_template = props.getProperty("invoice_template");
				if(invoice_template.endsWith(".jasper"))
				{
					invoice_template = invoice_template.substring(0,invoice_template.length()-7)+".jrxml";
					props.setProperty("invoice_template",invoice_template);		
					FileOutputStream fileout = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
					props.store(fileout, "Turquaz Properties File"); //$NON-NLS-1$
					fileout.flush();
					fileout.close();
				}
			}
			
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public static void setString(String key, String value)
	{
		
		_instance.props.setProperty(key, value);
		try
		{
			FileOutputStream fileout = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
			_instance.props.store(fileout, "Turquaz Properties File"); //$NON-NLS-1$
			fileout.flush();
			fileout.close();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(EngConfiguration.class);
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
	public static boolean automaticDispatcNote(){
		
		if (_instance == null)
		{
			_instance = new EngConfiguration();
		}
		
		String ADN = _instance.findString("automatic.dispatch.note");
		
		if(ADN == null)
		{
			return true;
		}
		
		if(ADN.trim().equals("true"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public static String getString(String key)
	{
		if (_instance == null)
		{
			_instance = new EngConfiguration();
		}
		return _instance.findString(key);
	}

	private String findString(String Key)
	{
		if (props == null)
		{
			return "";
		}
		return props.getProperty(Key);
	}

	public static Date getCurrentDate()
	{
		if (_instance == null)
		{
			_instance = new EngConfiguration();
		}
		return _instance.currentDate;
	}

	public static void setCurrentDate(Date d)
	{
		if (_instance == null)
		{
			_instance = new EngConfiguration();
		}
		_instance.currentDate = d;
	}

	public static void refreshConfig()
	{
		_instance = new EngConfiguration();
	}
}