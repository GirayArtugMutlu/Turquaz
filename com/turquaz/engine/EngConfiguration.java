
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
* @author  Onsel Armagan
* @version  $Id$
*/
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.dal.TurqCurrency;


public class EngConfiguration {
	private static final String filename = "config/turquaz.properties";//$NON-NLS-1$
    private Properties props ;
    public static String logoURL ="";
    public Date currentDate;
    public TurqCurrency baseCurrency = null;
	

	private static EngConfiguration _instance;
	private EngConfiguration() {
	    try{
	    
	   currentDate  = Calendar.getInstance().getTime();    
       FileInputStream fis = new FileInputStream(filename);
       baseCurrency = AccBLTransactionSearch.getBaseCurrency();
	   props = new Properties();
	   props.load(fis);
	   logoURL=props.getProperty("logoURL");
	   if(logoURL ==null){
	       logoURL ="";
	   }
	    
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	}

	public static void setString(String key, String value){
	
	    _instance.props.setProperty(key,value);  
	    try{
	    FileOutputStream fileout = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
	    _instance.props.store(fileout,"Turquaz Properties File"); //$NON-NLS-1$
		fileout.flush();
		fileout.close();
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	
	}
	
	public static String getString(String key) {
		if(_instance==null){
		    _instance = new EngConfiguration();
		}
	    
	    return _instance.findString(key);
	    
	}
	
	private String findString(String Key){
	
		if(props ==null){
			return "";
		}
	    return props.getProperty(Key);
	    
	}
	public static Date getCurrentDate()
	{
	    if(_instance==null){
		    _instance = new EngConfiguration();
		}
	    
	    return _instance.currentDate;
	    
	}
	public static void setCurrentDate(Date d)
	{
	   
	    if(_instance==null){
		    _instance = new EngConfiguration();
		}
	    
	  _instance.currentDate = d;
	}
	
	public static TurqCurrency getBaseCurrency(){
		if(_instance==null){
		    _instance = new EngConfiguration();
		}
	    
	  return _instance.baseCurrency;
	}
	public static void refreshConfig(){
	    _instance = new EngConfiguration();
	}
	
	
}