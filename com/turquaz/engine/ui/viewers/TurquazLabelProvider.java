
package com.turquaz.engine.ui.viewers;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TurquazLabelProvider extends LabelProvider
implements ITableLabelProvider{
    
    public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
    public String getColumnText(Object element, int columnIndex) {
	    ITableRow row = (ITableRow)element;
	    return row.getColumnText(columnIndex);
	}

}
