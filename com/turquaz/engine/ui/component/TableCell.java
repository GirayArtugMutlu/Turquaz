
package com.turquaz.engine.ui.component;

import org.eclipse.swt.widgets.TableItem;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
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
