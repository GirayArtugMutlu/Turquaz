
package com.turquaz.engine.ui.viewers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class TableRowList {
    private final int COUNT = 10;
	private Vector tasks = new Vector(COUNT);
	private Set changeListeners = new HashSet();
	int counter=0;
	/**
	 * Constructor
	 */
	public TableRowList() {
		super();
		this.initData();
	}
	
	/*
	 * Initialize the table data.
	 * Create COUNT tasks and add them them to the 
	 * collection of tasks
	 */
	private void initData() {
	
	};

	
	/**
	 * Return the collection of tasks
	 */
	public Vector getTasks() {
		return tasks;
	}
	
	/**
	 * Add a new task to the collection of tasks
	 */
	public void addTask(ITableRow row) {
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
	public void removeTask(ITableRow task) {
		tasks.remove(task);
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((ITableRowListViewer) iterator.next()).removeRow(task);
	}

	/**
	 * @param task
	 */
	public void taskChanged(ITableRow task) {
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext())
			((ITableRowListViewer) iterator.next()).updateRow(task);
	}

	/**
	 * @param viewer
	 */
	public void removeChangeListener(ITableRowListViewer viewer) {
		changeListeners.remove(viewer);
	}

	/**
	 * @param viewer
	 */
	public void addChangeListener(ITableRowListViewer viewer) {
		changeListeners.add(viewer);
	}

    
    
}
