/*
 * Created on 28.02.2004
 *
 * (c) 2004 by Friederich Kupzog Elektronik & Software
 * 
 * This program is free software; you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for 
 * more details. 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the fkmk@kupzog.de
 * 
 */
package de.kupzog.ktable;
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public abstract class KTableCellEditor {
	
	protected KTableModel m_Model;
	protected KTable m_Table;
	protected Rectangle m_Rect;
	protected int m_Row;
	protected int m_Col;
	protected Control m_Control;
	
	/**
	 * disposes the editor and its components
	 */
	public void dispose() {
		if (m_Control != null) {
			m_Control.dispose();
			m_Control = null;
		}
	}
	
	
	/**
	 * Activates the editor at the given position.
	 * @param row
	 * @param col
	 * @param rect
	 */
	public void open(KTable table, int col, int row, Rectangle rect) {
		m_Table = table;
		m_Model = table.getModel();
		m_Rect = rect;
		m_Row = row;
		m_Col = col;
		if (m_Control == null) {
			m_Control = createControl();
		}
		setBounds(m_Rect);
		GC gc = new GC(m_Table);
		m_Table.drawCell(gc, m_Col, m_Row);
		gc.dispose();
	}
	
	/**
	 * Deactivates the editor.
	 * @param save
	 * If true, the content is saved to the underlying table.
	 */
	public void close(boolean save) {
		m_Table.m_CellEditor = null;
		m_Control.setVisible(false);
		GC gc = new GC(m_Table);
		m_Table.drawCell(gc, m_Col, m_Row);
		gc.dispose();
		this.dispose();
	}
	
	/**
	 * Returns true if the editor has the focus.
	 * @return boolean
	 */
	public boolean isFocused() {
		if (m_Control == null)
			return false;
		return m_Control.isFocusControl();
	}

	/**
	 * Sets the editor's position and size
	 * @param rect
	 */
	public void setBounds(Rectangle rect) {
		if (m_Control != null)
			m_Control.setBounds(rect);
	}


	/*
	 * Creates the editor's control. Has to be overwritten 
	 * by useful editor implementations. 
	 */
	protected abstract Control createControl();
	

	protected void onKeyPressed(KeyEvent e) {
		if ((e.character == '\r')  && ((e.stateMask & SWT.SHIFT) == 0)) 
		{
			close(true);
		}
		else if (e.character == SWT.ESC) {
			close(false);
		}
		else
		{
			m_Table.scrollToFocus();
		}
	}
	
	protected void onTraverse(TraverseEvent e)
	{
		close(true);
		//m_Table.tryToOpenEditorAt(m_Col+1, m_Row);
	}
}
