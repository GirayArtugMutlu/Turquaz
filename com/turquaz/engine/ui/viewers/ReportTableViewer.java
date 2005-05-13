package com.turquaz.engine.ui.viewers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.ui.EngUITableColumns;
import com.turquaz.engine.ui.EngUITableProperties;

public class ReportTableViewer
{
    int defaultWidths[] = null;
    Table table = null;
    
    public ReportTableViewer(Table tbl)
    {
        this.table = tbl;
        TableColumn columns[] = table.getColumns();
        defaultWidths = new int[columns.length];
        for (int i = 0; i < columns.length; i++)
        {
            defaultWidths[i] = columns[i].getWidth();
            columns[i].addControlListener(new ControlAdapter()
                    {
                        public void controlResized(ControlEvent e)
                        {
                            saveColumnWidths();
                        }
                    });
            
        }  
        setColumnWidths();
        setPopupMenu();
    }
    private void setPopupMenu()
    {
        Menu menu = table.getMenu();
        if (menu == null)
        {
            menu = new Menu(table.getShell(), SWT.POP_UP);
            table.setMenu(menu);
        }
        MenuItem item = new MenuItem(menu, SWT.SEPARATOR);
        item = new MenuItem(menu, SWT.PUSH);
        item.setText("Tablo Görünümü");
        item.addListener(SWT.Selection, new Listener()
        {
            public void handleEvent(Event e)
            {
                new EngUITableColumns(table.getShell(), SWT.NONE).open(table, defaultWidths);
            }
        });
    }
    public void setColumnWidths()
    {
        try
        {
          
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
            if (columnWidths == null)
            {
                return;
            }
            TableColumn columns[] = table.getColumns();
            for (int i = 0; i < columns.length; i++)
            {
                if (columnWidths.get(i + "") != null)
                {
                    try
                    {
                        int width = Integer.parseInt(columnWidths.get(i + "").toString());
                        columns[i].setWidth(width);
                    }
                    catch (Exception ex)
                    {
                        EngBLLogger.log(this.getClass(),ex);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex);
        }
    }
    public void saveColumnWidths()
    {
      
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
        for (int i = 0; i < columns.length; i++)
        {
            columnWidths.put(i + "", columns[i].getWidth() + "");
        }
        try
        {
            EngUITableProperties.setTableWidthMap(name, columnWidths);
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex);
        }
    }

}
