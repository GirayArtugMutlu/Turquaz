
package com.turquaz.engine.ui.viewers;

import java.util.List;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

public class TurquazCellModifier implements ICellModifier{
   
    private List columnNames;
    private TurquazContentProvider contentProvider;
    public TurquazCellModifier(List columnNames, TurquazContentProvider provider) {
		super();
		this.columnNames = columnNames;
		this.contentProvider = provider;
	}
    
    public boolean canModify(Object element, String property) {
        int columnIndex = columnNames.indexOf(property);
    	ITableRow task = (ITableRow) element;
        return task.canModify(columnIndex);
	}
    public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);

		Object result = "";
		ITableRow task = (ITableRow) element;
        result = task.getValue(columnIndex); 	
		
		return result;	
	}
    public void modify(Object element, String property, Object value) {	

    	// Find the index of the column
		int columnIndex = columnNames.indexOf(property);
			
		TableItem item = (TableItem) element;	
		ITableRow task = (ITableRow) item.getData();
		task.modify(columnIndex,value);
		contentProvider.getTaskList().taskChanged(task);
		
	}

    
}
