package com.turquaz.engine.ui.viewers;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author  Onsel
 * @version  $Id$
 */


import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.editors.NumericCellEditor;

/**
 * TableCursor that supports TableEditors of TableViewer and allows a spreadsheet-like navigation through the table Created on 15.07.2004
 * 
 * @author <a href='tobias.weih@inmeco.de'>Tobias Weih </a> inmeco - Institut f�r Computer- und Mediensysteme
 * @version XinityBase 2.2 M5
 */
public class TableSpreadsheetCursor extends TableCursor implements ICellEditorListener
{
	TableViewer tableViewer;
	TableRowList rowList;
	Table table;
	boolean activeDelete = true;
	int previousColumn = -1;

	public TableSpreadsheetCursor(Table table, int style, SaveTableViewer viewer, boolean activateDelete)
	{
		super(table, style);
		this.tableViewer = viewer.getViewer();
		rowList = viewer.getRowList();
		this.table = table;
		this.activeDelete = activateDelete;
		this.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				keyReleasedEventMethod(e);
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			public void mouseDoubleClick(MouseEvent arg0)
			{
				tableViewer.editElement(getRow().getData(), getColumn());
			}
		});
		this.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e)
			{
				
				TableColumn column = TableSpreadsheetCursor.this.table.getColumn(getColumn());
				if(column.getWidth()<5)
				{
					if(getColumn()>previousColumn)
					{
						if(getColumn()<TableSpreadsheetCursor.this.table.getColumnCount()-1)
						{
							TableSpreadsheetCursor.this.setSelection(getRow(),getColumn()+1);
						}
						else
						{
							TableSpreadsheetCursor.this.setSelection(getRow(),getColumn()-1);
						}
					}
					else
					{
						if(getColumn()>0)
						{
							TableSpreadsheetCursor.this.setSelection(getRow(),getColumn()-1);
						}
						else
						{
							TableSpreadsheetCursor.this.setSelection(getRow(),getColumn()+1);
						}
					}
					previousColumn = getColumn();
					
				}
				
				
				
				
				
			}
			
			
		});
	}

	public TableSpreadsheetCursor(Table table, int style, TableViewer viewer, TableRowList roeList, boolean activateDelete)
	{
		super(table, style);
		this.tableViewer = viewer;
		this.rowList = roeList;
		this.table = table;
		this.activeDelete = activateDelete;
		this.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
				keyReleasedEventMethod(e);
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			public void mouseDoubleClick(MouseEvent arg0)
			{
				tableViewer.editElement(getRow().getData(), getColumn());
			}
		});
	}

	public void keyReleasedEventMethod(KeyEvent e)
	{
		if (e.keyCode == SWT.DEL)
		{
			if (getRow() != null)
			{
				if (okToDelete())
				{
					ITableRow row = (ITableRow) getRow().getData();
					TableSpreadsheetCursor.this.rowList.removeTask(row);
					int itemCount = TableSpreadsheetCursor.this.table.getItemCount();
					if (itemCount > 0)
					{
						setSelection(itemCount - 1, 0);
					}
				}
			}
		}
		// F2 edit
		else if (e.keyCode == 16777227 && e.stateMask == 0)
		{
			tableViewer.editElement(getRow().getData(), getColumn());
			// any character
		}
		else if (e.stateMask == SWT.CTRL)
		{
			tableViewer.editElement(getRow().getData(), getColumn());
		}
		//any character
		else if ((e.keyCode < 0x10000 || e.character != '\0') && e.keyCode > 0x1f && e.keyCode != 127 || e.keyCode == 0x00
				&& (e.stateMask == 0 || e.stateMask == SWT.SHIFT))
		{
			if (getRow() != null)
			{
				tableViewer.editElement(getRow().getData(), getColumn());
				if (tableViewer.getCellEditors()[getColumn()] instanceof TextCellEditor)
				{
					TextCellEditor editor = ((TextCellEditor) tableViewer.getCellEditors()[getColumn()]);
					((Text) editor.getControl()).setText("" + e.character); //$NON-NLS-1$
					if (tableViewer.getCellEditors()[getColumn()] instanceof CurrencyCellEditor
							|| tableViewer.getCellEditors()[getColumn()] instanceof NumericCellEditor)
					{
						((Text) editor.getControl()).setSelection(1);
					}
					else
					{
						((Text) editor.getControl()).setSelection(1);
					}
				}
			}
		}
	}

	public void applyEditorValue()
	{
		TableSpreadsheetCursor.this.setVisible(true);
		TableSpreadsheetCursor.this.redraw();
		tableViewer.setSelection(new StructuredSelection(TableSpreadsheetCursor.this.getRow()), true);
		// set selection of table separatly; viewer does incorrectly.
		tableViewer.getTable().setSelection(new TableItem[]{TableSpreadsheetCursor.this.getRow()});
		setFocus();
	}

	/**
	 * makes the TableCursor visible again.
	 * 
	 * @see org.eclipse.jface.viewers.ICellEditorListener#cancelEditor()
	 */
	public void cancelEditor()
	{
		TableSpreadsheetCursor.this.setVisible(true);
	}

	/**
	 * does nothing
	 * 
	 * @see org.eclipse.jface.viewers.ICellEditorListener#editorValueChanged(boolean, boolean)
	 */
	public void editorValueChanged(boolean oldValidState, boolean newValidState)
	{
	}

	public boolean okToDelete()
	{
		if (!activeDelete)
			return false;
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY);
		if (msg.open() == SWT.OK)
		{
			return true;
		}
		return false;
	}
}