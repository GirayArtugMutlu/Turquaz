
package com.turquaz.engine.ui.component;



import java.text.Collator;

import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TableSorter {
	
public static void sortTable(Table table, TableColumn column){
//	 sort column 2
    TableItem[] items = table.getItems();
    Collator collator = Collator.getInstance(Locale.getDefault());
    int col_index = getColumnIndex(table,column);
    for (int i = 1; i < items.length; i++) {
        String value1 = items[i].getText(col_index);
        for (int j = 0; j < i; j++){
            String value2 = items[j].getText(col_index);
            if (collator.compare(value1, value2) < 0) {
                String[] values = {items[i].getText(0), items[i].getText(1)};
                items[i].dispose();
                TableItem item = new TableItem(table, SWT.NONE, j);
                item.setText(values);
                items = table.getItems();
                break;
            }
        }
    }
	
}
 
 protected static int getColumnIndex(Table table, TableColumn tableColumn){
 	TableColumn columns[]= table.getColumns();
 	int index = -1;
 	for(int i=0;i<columns.length;i++){
 		if(columns[i].equals(tableColumn)){
 			index = i;
 			break;
 		}
 		
 	}
 	return index;
 	
 }

}
