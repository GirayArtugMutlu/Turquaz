
package com.turquaz.engine.ui.component;

import java.util.List;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;



public class lastTableColumn extends TableColumn {

    public lastTableColumn(Table table, int style){
        super(table,style);
        postInitGui();
    }
    public void postInitGui(){
       this.addSelectionListener(new SelectionListener(){
           public void widgetDefaultSelected(SelectionEvent event){
               
           }
           
           public void widgetSelected(SelectionEvent event){
               TableColumn columns[]= getParent().getColumns();
               List selection = null;
               for(int i = 0;i<columns.length;)
               {
               
               }
           }
           
       }
               );
        
        
    }
}
