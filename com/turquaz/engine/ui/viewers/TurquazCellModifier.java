package com.turquaz.engine.ui.viewers;

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
 * @author Onsel
 * @version $Id$
 */
import java.util.List;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

public class TurquazCellModifier implements ICellModifier
{
	private List columnNames;
	private TurquazContentProvider contentProvider;

	public TurquazCellModifier(List columnNames, TurquazContentProvider provider)
	{
		super();
		this.columnNames = columnNames;
		this.contentProvider = provider;
	}

	public boolean canModify(Object element, String property)
	{
		int columnIndex = columnNames.indexOf(property);
		ITableRow task = (ITableRow) element;
		return task.canModify(columnIndex);
	}

	public Object getValue(Object element, String property)
	{
		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);
		Object result = "";
		ITableRow task = (ITableRow) element;
		result = task.getValue(columnIndex);
		return result;
	}

	public void modify(Object element, String property, Object value)
	{
		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);
		TableItem item = (TableItem) element;
		ITableRow task = (ITableRow) item.getData();
		task.modify(columnIndex, value);
		contentProvider.getTaskList().taskChanged(task);
	}
}