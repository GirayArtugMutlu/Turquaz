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
 * www.kupzog.de/fkmk
 * 
 */

package de.kupzog.ktable;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class KTableCellEditorText 
extends KTableCellEditor 
{
	private Text m_Text;
	

	public void open(KTable table, int col, int row, Rectangle rect) {
		super.open(table, col, row, rect);
		m_Text.setText(m_Model.getContentAt(m_Col, m_Row).toString());
		m_Text.selectAll();
		m_Text.setVisible(true);
		m_Text.setEditable(false);
		
	}


	public void close(boolean save) {
		m_Text.setVisible(false);
		if (save)
			m_Model.setContentAt(m_Col, m_Row, m_Text.getText());
		super.close(save);
	}


	protected Control createControl() {
		m_Text = new Text(m_Table, SWT.NONE);
		m_Text.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				try {
					onKeyPressed(e);
				} catch (Exception ex) {
				}
			}
		});
		m_Text.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent arg0) {
				onTraverse(arg0);
			}
		});
		return m_Text;
	}
	
	/* 
	 * overridden from superclass
	 */
	public void setBounds(Rectangle rect) 
	{
		super.setBounds(new Rectangle(rect.x, rect.y+(rect.height - 15)/2+1,
									  rect.width, 15));
	}

}