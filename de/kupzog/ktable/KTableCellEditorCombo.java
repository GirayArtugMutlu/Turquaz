/*
 * Created on 01.03.2004
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
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

/**
 * @author Friederich Kupzog
 */
public class KTableCellEditorCombo 
extends KTableCellEditor 
{
	private CCombo m_Combo;
	private String m_Items[];

	public void open(KTable table, int row, int col, Rectangle rect) {
		super.open(table, row, col, rect);
		m_Combo.setText((String)m_Model.getContentAt(m_Col, m_Row));
	}

	public void close(boolean save) {
		m_Combo.setVisible(false);
		if (save)
			m_Model.setContentAt(m_Col, m_Row, m_Combo.getText());
		super.close(save);
	}

	protected Control createControl() {
		m_Combo = new CCombo(m_Table, SWT.READ_ONLY);
		m_Combo.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		if (m_Items != null)
			m_Combo.setItems(m_Items);
		m_Combo.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				try {
					onKeyPressed(e);
				} catch (Exception ex) {
				}
			}
		});
		m_Combo.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent arg0) {
				onTraverse(arg0);
			}
		});
		return m_Combo;
	}
	
	public void setBounds(Rectangle rect) 
	{
		super.setBounds(new Rectangle(rect.x, rect.y+1,
									  rect.width, rect.height-2));
	}

	public void setItems(String items[]) {
		m_Items = items;
	}
	

}
