
package com.turquaz.engine.ui.component;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	
	public static void sortTable(Table sortableTable, TableColumn tableColumn, boolean isAscending ){
		if (tableColumn == null)
		      return;

		    String sColumnName = tableColumn.getText();
     	    List columnCellList = getColumnCells(sortableTable, tableColumn);
     	    
     	    TableItem items[] = sortableTable.getItems();
            TableItem itemsOriginal[] =(TableItem[])items.clone();
            
     	    TableCell[] cells = (TableCell[])columnCellList.toArray();
		     
		    if (isAscending)
		      Arrays.sort(cells);
		    else
		      Arrays.sort(cells, Collections.reverseOrder());

		/* Flicker
		    for (int i = 0; i < cells.length; i++)
		      cells[i].getTableRowCore().setIndex(i);
		*/

		    /**
		     * for (int i = 0; i < cells.length; i++) {
		      if (cells[i] != cellsOriginal[i]) {
		        TableRowCore row = cells[i].getTableRowCore();
		        ((BufferedTableRow)row).setTableItem(tableItems[i], false);
		        ((BufferedTableRow)row).setSelected(bWasSelected);
		        tableItems[i].setData("TableRow", row);
		        row.setValid(false);
		        row.refresh(true);
		      }
		    }
		
		     */
		    
	}
 protected static List getColumnCells(Table table, TableColumn tableColumn){
 	
    ArrayList l = new ArrayList();
    int columnIndex = getColumnIndex(table,tableColumn);
    TableCell cell = new TableCell();
    if (table != null && !table.isDisposed()&&columnIndex!=-1) {
      TableItem tis[]= table.getItems();
      for (int i = 0; i < tis.length; i++) {
         String cellText =tis[i].getText(columnIndex);
         
        if (cellText != null){
            cell = new TableCell();
            cell.setCellText(cellText);
            cell.setItem(tis[i]);
        	l.add(cell);
        }
      }
    }
    return l;
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
