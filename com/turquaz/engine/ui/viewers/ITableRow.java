
package com.turquaz.engine.ui.viewers;

import org.eclipse.swt.graphics.Color;

public interface ITableRow {
    public String getColumnText(int column_index);
    public Object getValue(int column_index);
    public void modify(int column_index, Object value);
    public Color getColor();
    public boolean canModify(int column_index);
    public void setRowIndex(int index);
    public int getRowIndex();
 }
