
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

import java.util.Properties;


public class EngConfiguration {
	private static final String filename = "config/turquaz.properties";//$NON-NLS-1$
    private Properties props ;
    public static String logoURL ="";
	

	private static EngConfiguration _instance;
	private EngConfiguration() {
	    try{
	        
      FileInputStream fis = new FileInputStream(filename);
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
	
}