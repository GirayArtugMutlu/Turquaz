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
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class TurquazContentProvider implements IStructuredContentProvider, ITableRowListViewer
{
	private TableViewer tableViewer;

	public TableViewer getTableViewer()
	{
		return tableViewer;
	}

	public void setTableViewer(TableViewer tableViewer)
	{
		this.tableViewer = tableViewer;
	}

	public TableRowList getTaskList()
	{
		return taskList;
	}

	public void setTaskList(TableRowList taskList)
	{
		this.taskList = taskList;
	}
	private TableRowList taskList;

	public TurquazContentProvider(TableViewer tableViewer, TableRowList taskList)
	{
		super();
		this.tableViewer = tableViewer;
		this.taskList = taskList;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput)
	{
		if (newInput != null)
			((TableRowList) newInput).addChangeListener(this);
		if (oldInput != null)
			((TableRowList) oldInput).removeChangeListener(this);
	}

	public void dispose()
	{
		taskList.removeChangeListener(this);
	}

	// Return the tasks as an array of Objects
	public Object[] getElements(Object parent)
	{
		return taskList.getTasks().toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ITaskListViewer#addTask(ExampleTask)
	 */
	public void addRow(ITableRow task)
	{
		tableViewer.add(task);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ITaskListViewer#removeTask(ExampleTask)
	 */
	public void removeRow(ITableRow task)
	{
		tableViewer.remove(task);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ITaskListViewer#updateTask(ExampleTask)
	 */
	public void updateRow(ITableRow task)
	{
		tableViewer.update(task, null);
	}
}