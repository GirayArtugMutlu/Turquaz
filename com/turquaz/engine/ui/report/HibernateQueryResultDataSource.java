package com.turquaz.engine.ui.report;

import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

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
public class HibernateQueryResultDataSource implements JRDataSource
{
	private String[] fields;
	private Iterator iterator;
	private Object currentValue;

	public HibernateQueryResultDataSource(List list, String[] fields)
	{
		this.fields = fields;
		this.iterator = list.iterator();
	}

	public Object getFieldValue(JRField field) throws JRException
	{
		Object value = null;
		int index = getFieldIndex(field.getName());
		if (index > -1)
		{
			Object[] values = (Object[]) currentValue;
			value = values[index];
		}
		return value;
	}

	public boolean next() throws JRException
	{
		currentValue = iterator.hasNext() ? iterator.next() : null;
		return (currentValue != null);
	}

	private int getFieldIndex(String field)
	{
		int index = -1;
		for (int i = 0; i < fields.length; i++)
		{
			if (fields[i].equals(field))
			{
				index = i;
				break;
			}
		}
		return index;
	}
}