
package com.turquaz.inventory.ui.comp;

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
import java.util.Arrays;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.inventory.Messages;


public class InvUIPriceCellModifier implements ICellModifier{
	InvUIPriceList priceList;
	public InvUIPriceCellModifier(InvUIPriceList list) {
		super();
		priceList = list;
	}
	
	private String[] columnNames=new String[]{Messages.getString("InvUIPriceCellModifier.0"), Messages.getString("InvUIPriceCellModifier.1"), Messages.getString("InvUIPriceCellModifier.2")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	public boolean canModify(Object element, String property) {
		return true;
	}
	public void modify(Object element, String property, Object value){	
//		 Find the index of the column 
		int columnIndex = Arrays.asList(columnNames).indexOf(property);
			
		TableItem item = (TableItem) element;
		InvUIPrice price = (InvUIPrice) item.getData();
		String valueString;

		switch (columnIndex) {
			case 0 : // COMPLETED_COLUMN 
				valueString = priceList.getPriceTypes()[((Integer) value).intValue()].trim();
				if (!price.getPriceType().equals(valueString)) {
					price.setPriceType(valueString);
				}
				break;
			case 1 : // DESCRIPTION_COLUMN 
				valueString = ((String) value).trim();
				price.setAmount(valueString);
				break;
			case 2 : // OWNER_COLUMN 
				valueString = priceList.getCurrencies()[((Integer) value).intValue()].trim();
				if (!price.getAbrev().equals(valueString)) {
					price.setAbrev(valueString);
				}
				break;
			
			default :
			}
		
		priceList.priceChanged(price);
	}
	public Object getValue(Object element, String property) {

//		 Find the index of the column
		int columnIndex = Arrays.asList(columnNames).indexOf(property);

		Object result = null;
		InvUIPrice price = (InvUIPrice) element;

		switch (columnIndex) {
			case 0 : // COMPLETED_COLUMN 
				String stringValue = price.getPriceType();
				String[] choices = priceList.getPriceTypes();
				int i = choices.length - 1;
				while (!stringValue.equals(choices[i]) && i > 0)
					--i;
				result = new Integer(i);
				break;
			case 1 : // DESCRIPTION_COLUMN 
				result = price.getAmount();
				break;
			case 2 : // OWNER_COLUMN 
				stringValue = price.getAbrev();
				String[] choices2 = priceList.getCurrencies();
				int j = choices2.length - 1;
				while (!stringValue.equals(choices2[j]) && j > 0)
					--j;
				result = new Integer(j);					
				break;
			default :
				result = ""; //$NON-NLS-1$
		}
		return result;
	}
	
	
}
