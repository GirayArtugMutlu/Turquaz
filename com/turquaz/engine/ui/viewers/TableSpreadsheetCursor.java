package com.turquaz.engine.ui.viewers;


import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;

import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * TableCursor that supports TableEditors of TableViewer
 * and allows a spreadsheet-like navigation through the table
 * Created on 15.07.2004
 * @author <a href='tobias.weih@inmeco.de'>Tobias Weih</a> inmeco - Institut für Computer- und Mediensysteme
 * @version XinityBase 2.2 M5
 */
public class TableSpreadsheetCursor extends TableCursor implements ICellEditorListener{
	TableViewer viewer;
    
	public TableSpreadsheetCursor(Table table, int style, TableViewer viewer) {
		super(table, style);
		this.viewer = viewer;
	

	}
	public void applyEditorValue() {
		TableSpreadsheetCursor.this.setVisible(true);
		TableSpreadsheetCursor.this.redraw();
		TableSpreadsheetCursor.this.viewer.setSelection(new StructuredSelection(TableSpreadsheetCursor.this.getRow()), true);
		// set selection of table separatly; viewer does incorrectly.
		TableSpreadsheetCursor.this.viewer.getTable().setSelection(new TableItem[] { TableSpreadsheetCursor.this.getRow() });

		setFocus();
		System.out.println("apply");
	}
	/**
	 * makes the TableCursor visible again.
	 *
	 * @see org.eclipse.jface.viewers.ICellEditorListener#cancelEditor()
	 */	
	public void cancelEditor() {
		TableSpreadsheetCursor.this.setVisible(true);
		
	}
	/**
	 * does nothing
	 * @see org.eclipse.jface.viewers.ICellEditorListener#editorValueChanged(boolean, boolean)
	 */
	public void editorValueChanged(boolean oldValidState, boolean newValidState) {}
	
	
}