
package com.turquaz.engine.ui.viewers;

public interface ITableRow {
    public String getColumnText(int column_index);
    public Object getValue(int column_index);
    public void modify(int column_index, Object value);
}
