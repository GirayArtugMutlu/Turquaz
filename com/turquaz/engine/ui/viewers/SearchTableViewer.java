package com.turquaz.engine.ui.viewers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.ui.EngUITableProperties;
import com.turquaz.engine.ui.component.SearchComposite;

/**
 * @author onsel Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchTableViewer
{
	TableRowList rowList = new TableRowList();
	TableViewer viewer = null;
	int columnTypes[] = null;

	public SearchTableViewer(Table table, int columnTypes[],boolean isSortable)
	{
		this.columnTypes = columnTypes;
		viewer = new TableViewer(table);
		viewer.setUseHashlookup(true);
		TableColumn columns[] = table.getColumns();
		List columnList = new ArrayList();
		String columnNames[] = new String[columns.length];
		for (int i = 0; i < columns.length; i++)
		{
			columnNames[i] = columns[i].getText();
			columnList.add(columns[i].getText());
			if(isSortable)
			{
				columns[i].addListener(SWT.Selection, new SearchTableColumnListener(viewer, i, columnTypes[i]));
			}
			columns[i].addControlListener(new ControlAdapter(){
				public void controlResized(ControlEvent e)
				{
					saveColumnWidths();
				}
			});
		}
		viewer.setColumnProperties(columnNames);
		TurquazContentProvider contentProvider = new TurquazContentProvider(viewer, rowList);
		viewer.setCellModifier(new TurquazCellModifier(columnList, contentProvider));
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new TurquazLabelProvider());
		viewer.setInput(rowList);
		
		/**
		 * Set Column Widths
		 */		
		setColumnWidths();
		
		/**
		 * Save Column Widths
		 */
		saveColumnWidths();
	}

	public void addRow(String[] txt, Object data)
	{
		rowList.addTask(new SearchTableRow(txt, data));
	}

	public void addRow(ITableRow row)
	{
		rowList.addTask(row);
	}

	public void removeAll()
	{
		rowList.removeAll();
	}
	
	
	public void setColumnWidths()
	{
		try
		{
			Table table = viewer.getTable();
			Composite cmp = table.getParent();
			while (!(cmp instanceof SearchComposite))
			{
				cmp = cmp.getParent();
				if (cmp == null)
				{
					return;
				}
			}
			Map columnWidths = EngUITableProperties.getTableWidthMap(cmp.getClass().getName());
			if(columnWidths==null)
			{
				return;
			}
			
			TableColumn columns[] = table.getColumns();
			for(int i=0;i<columns.length;i++)
			{
				if(columnWidths.get(i+"")!=null)
				{
					try{
						int width = Integer.parseInt(columnWidths.get(i+"").toString());
						columns[i].setWidth(width);
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				
			}
			
			
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void saveColumnWidths()
	{
		
		Table table = viewer.getTable();
		Composite cmp = table.getParent();
		while (!(cmp instanceof SearchComposite))
		{
			cmp = cmp.getParent();
			if (cmp == null)
			{
				return;
			}
		}
		String name = cmp.getClass().getName();
		Map columnWidths = new HashMap();
		TableColumn columns[] = table.getColumns();
		for(int i=0;i<columns.length;i++)
		{
		   columnWidths.put(i+"",columns[i].getWidth()+"");			
		}
		try{
		EngUITableProperties.setTableWidthMap(name, columnWidths);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}

class SearchTableColumnListener implements Listener
{
	int columnIndex;
	int columnType;
	TableViewer viewer;
	private TurquazTableSorter tableSorter = null;
	public static Image ascendingImage = SWTResourceManager.getImage("gfx/up_arrow.gif");
	public static Image descendingImage = SWTResourceManager.getImage("gfx/down_arrow.gif");

	public SearchTableColumnListener(TableViewer viewer, int columnIndex, int columnType)
	{
		this.columnIndex = columnIndex;
		this.columnType = columnType;
		this.viewer = viewer;
		tableSorter = new TurquazTableSorter(columnIndex, columnType);
	}

	public void handleEvent(Event e)
	{
		boolean sortStyle = !tableSorter.getAscending();
		tableSorter.setAscending(sortStyle);
		TableColumn[] columns = viewer.getTable().getColumns();
		for (int k = 0; k < columns.length; k++)
		{
			columns[k].setImage(null);
		}
		columns[columnIndex].setImage(sortStyle ? ascendingImage : descendingImage);
		viewer.setSorter(tableSorter);
		viewer.refresh();
	}
}