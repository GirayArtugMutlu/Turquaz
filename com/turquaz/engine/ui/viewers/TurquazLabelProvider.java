
package com.turquaz.engine.ui.viewers;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class TurquazLabelProvider extends LabelProvider
implements ITableLabelProvider,IColorProvider{
    
    public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
    public String getColumnText(Object element, int columnIndex) {
	    ITableRow row = (ITableRow)element;
	    return row.getColumnText(columnIndex);
	}
    

    public Color getBackground(Object element) {
        ITableRow row = (ITableRow)element;
	    return row.getColor();
        
    }
    public Color getForeground(Object arg0) {
        
        return null;
    }
}
