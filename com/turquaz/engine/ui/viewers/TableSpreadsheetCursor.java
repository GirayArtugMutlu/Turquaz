package com.turquaz.engine.ui.viewers;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.engine.test.NewComposite;


/**
 * TableCursor that supports TableEditors of TableViewer
 * and allows a spreadsheet-like navigation through the table
 * Created on 15.07.2004
 * @author <a href='tobias.weih@inmeco.de'>Tobias Weih</a> inmeco - Institut für Computer- und Mediensysteme
 * @version XinityBase 2.2 M5
 */
public class TableSpreadsheetCursor extends TableCursor{
	TableViewer tableViewer;
	public TableSpreadsheetCursor(Table table, int style, NewComposite comp) {
		super(table, style);
		this.tableViewer = comp.tableViewer;
		
		addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding rowtable
			public void widgetSelected(SelectionEvent e) {
              
				// set cursor-selection to mark whole row
				tableViewer.setSelection(new StructuredSelection(getRow()), true);
				// set selection of table separatly; viewer does incorrectly.
			     tableViewer.getTable().setSelection(new TableItem[] {getRow() });

			}
	
			// when the user hits "ENTER" in the TableCursor, pop up a text/combo editor 
			// so that they can change the text of the cell for controlType=="input" || "select1"<br>
			// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
			public void widgetDefaultSelected(SelectionEvent e) {
			activateEditor();
			}
		});
		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				// F2 to open editor
				if(e.keyCode == 16777227 && e.stateMask == 0){
					activateEditor();

				// any character
				} else if((e.keyCode<0x10000 || e.character!='\0') && e.keyCode>0x1f && e.keyCode!=127 
					|| e.keyCode==0x00 && (e.stateMask==0 || e.stateMask==SWT.SHIFT)){
					
					activateEditor();
					
				}
			}
			public void keyReleased(KeyEvent e) {
			}
		});	
		

	}
	private void activateEditor() {
	
	    Object o = (TableSpreadsheetCursor.this.getRow()).getData();
		TableSpreadsheetCursor.this.tableViewer.editElement((TableSpreadsheetCursor.this.getRow()).getData(), TableSpreadsheetCursor.this.getColumn());
		
	}
	
}