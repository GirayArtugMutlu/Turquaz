
package com.turquaz.engine.ui.viewers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;

public class TurquazContentProvider implements IStructuredContentProvider, ITableRowListViewer {
    
   private TableViewer tableViewer;
   
public TableViewer getTableViewer() {
    return tableViewer;
}
public void setTableViewer(TableViewer tableViewer) {
    this.tableViewer = tableViewer;
}
public TableRowList getTaskList() {
    return taskList;
}
public void setTaskList(TableRowList taskList) {
    this.taskList = taskList;
}
   private TableRowList taskList = new TableRowList(); 
   
    public TurquazContentProvider(TableViewer tableViewer){
        super();
        this.tableViewer = tableViewer;
        
    }
    public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		if (newInput != null)
			((TableRowList) newInput).addChangeListener(this);
		if (oldInput != null)
			((TableRowList) oldInput).removeChangeListener(this);
	}

	public void dispose() {
		taskList.removeChangeListener(this);
	}

	// Return the tasks as an array of Objects
	public Object[] getElements(Object parent) {
		return taskList.getTasks().toArray();
	}

	/* (non-Javadoc)
	 * @see ITaskListViewer#addTask(ExampleTask)
	 */
	public void addRow(ITableRow task) {
		tableViewer.add(task);
	}

	/* (non-Javadoc)
	 * @see ITaskListViewer#removeTask(ExampleTask)
	 */
	public void removeRow(ITableRow task) {
		tableViewer.remove(task);			
	}

	/* (non-Javadoc)
	 * @see ITaskListViewer#updateTask(ExampleTask)
	 */
	public void updateRow(ITableRow task) {
		tableViewer.update(task, null);	
	} 
    

}
