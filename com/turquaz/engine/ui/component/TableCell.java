
package com.turquaz.engine.ui.component;

import org.eclipse.swt.widgets.TableItem;

/**
 * @author onsel
 *
 */
public class TableCell {
	public String cellText="";
	public TableItem item =null;

	public void setItem(TableItem item){
		this.item = item;
	}
	public void setCellText(String cellText){
        this.cellText = cellText;		
	}
	public String toString(){
		return cellText;
	}
	public TableItem getTableItem(){
		return item;
	}
	
}
