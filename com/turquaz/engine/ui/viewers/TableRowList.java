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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class TableRowList
{
	private final int COUNT = 10;
	private Vector tasks = new Vector(COUNT);
	private Set changeListeners = new HashSet();
	int counter = 0;

	/**
	 * Constructor
	 */
	public TableRowList()
	{
		super();
		this.initData();
	}

	/*
	 * Initialize the table data. Create COUNT tasks and add them them to the collection of tasks
	 */
	private void initData()
	{
	};

	/**
	 * Return the collection of tasks
	 */
	public Vector getTasks()
	{
		return tasks;
	}

	/**
	 * Add a new task to the collection of tasks
	 */
	public void addTask(ITableRow row)
	{
		counter++;
		row.setRowIndex(counter);
		tasks.add(tasks.size(), row);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((ITableRowListViewer) iterator.next()).addRow(row);
	}

	/**
	 * @param task
	 */
	public void removeTask(ITableRow task)
	{
		tasks.remove(task);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((ITableRowListViewer) iterator.next()).removeRow(task);
	}

	public void removeAll()
	{		
		for (int k=0; k<tasks.size(); k++)
		{
			ITableRow task=(ITableRow)tasks.get(k);
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext())
				((ITableRowListViewer) iterator.next()).removeRow(task);
			
		}
		tasks=new Vector(COUNT);	
		counter=0;
	}
	
	public void removeAll(SearchTableViewer tableViewer)
	{		
		tasks=new Vector(COUNT);	
		tableViewer.viewer.refresh();
		counter=0;
	}

	/**
	 * @param task
	 */
	public void taskChanged(ITableRow task)
	{
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((ITableRowListViewer) iterator.next()).updateRow(task);
	}

	/**
	 * @param viewer
	 */
	public void removeChangeListener(ITableRowListViewer viewer)
	{
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(ITableRowListViewer viewer)
	{
		changeListeners.add(viewer);
	}
}