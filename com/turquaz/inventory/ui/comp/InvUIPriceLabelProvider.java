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
 * @author Onsel Armagan
 * @version $Id$
 */
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class InvUIPriceLabelProvider extends LabelProvider implements ITableLabelProvider
{
	public Image getColumnImage(Object element, int columnIndex)
	{
		return null;
	}

	public String getColumnText(Object element, int columnIndex)
	{
		String result = ""; //$NON-NLS-1$
		InvUIPrice price = (InvUIPrice) element;
		switch (columnIndex)
		{
			case 0 :
				result = price.priceType;
				break;
			case 1 :
				result = price.amount;
				break;
			case 2 :
				result = price.abrev;
				break;
			default :
				break;
		}
		return result;
	}
}