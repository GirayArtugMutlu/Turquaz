
package com.turquaz.engine.ui.viewers;

import org.eclipse.swt.graphics.Color;

public interface ITableRow {
    
    //Get column Text
    public String getColumnText(int column_index);
    
    //Get column Value
    public Object getValue(int column_index);
    
    public void modify(int column_index, Object value);
    
    // Get Row Color
    public Color getColor();
    
    //is column editable
    public boolean canModify(int column_index);
    
    //rows unique number !!important in equals function
    public void setRowIndex(int index);
    
    //get rows unique number
    public int getRowIndex();
    
    //if all required fields are filled properly
    public boolean okToSave();
    
    //To save the row We need the db object
    public Object getDBObject();
    
    //After fetching from db we need to fill this part
    public void setDBObject(Object obj);
    
    public boolean equals(Object obj);
    
 }
