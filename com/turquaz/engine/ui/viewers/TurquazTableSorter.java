
package com.turquaz.engine.ui.viewers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

public class TurquazTableSorter extends ViewerSorter{
	int columnIndex;
    public TurquazTableSorter(int criteria) {
		super();
		this.columnIndex = criteria;
	}    

    public int compare(Viewer arg0, Object arg1, Object arg2) {
        // TODO Auto-generated method stub
        
        ITableRow row1 = (ITableRow)arg1;
        ITableRow row2 = (ITableRow)arg2;
        
       return collator.compare(row1.getColumnText(columnIndex),row2.getValue(columnIndex));
        
        
    }
}
