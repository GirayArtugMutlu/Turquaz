package com.turquaz.engine.ui.report;
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



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class HibernateQueryResultDataSource implements JRDataSource {

	private Iterator iterator;

	private Object currentValue;

	public HibernateQueryResultDataSource(List list) {
		this.iterator = list.iterator();
	}

	public Object getFieldValue(JRField field) throws JRException {
		Object value = null;
		try {
			
			Method fld = currentValue.getClass().getMethod(
					"get" + field.getName(), null);
			
			
			value = fld.invoke(currentValue, null);
			
		
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		}
		return value;
	}

	
	public boolean next() throws JRException {
		currentValue = iterator.hasNext() ? iterator.next() : null;
		return (currentValue != null);
	}
}