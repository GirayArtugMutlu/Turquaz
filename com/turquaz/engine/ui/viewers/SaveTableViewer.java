/*
 * Created on Mar 22, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.viewers;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
*/
public class SaveTableViewer
{
	TableRowList rowList = new TableRowList();
	TableViewer viewer = null;
	int columnTypes[] = null;	
	
	public SaveTableViewer(Table table, CellEditor[] editors){
		
		viewer = new TableViewer(table);
		viewer.setUseHashlookup(true);		
		TableColumn columns[] = table.getColumns();
		List columnList = new ArrayList();
		String columnNames[] = new String[columns.length];
	
		for (int i = 0; i < columns.length; i++)
		{			
			columnNames[i] = columns[i].getText();
			columnList.add(columns[i].getText());
		
		}
		viewer.setCellEditors(editors);
		viewer.setColumnProperties(columnNames);
		TurquazContentProvider contentProvider = new TurquazContentProvider(viewer, rowList);
		viewer.setCellModifier(new TurquazCellModifier(columnList, contentProvider));
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new TurquazLabelProvider());
		viewer.setInput(rowList);
		
	}
	public void addRow(ITableRow row)
	{
		rowList.addTask(row);
	}

	public void removeAll()
	{
		rowList.removeAll();
	}
	
	public void addChangeListener(ITableRowListViewer listener){
		rowList.addChangeListener(listener);	
	}
	
	
}
