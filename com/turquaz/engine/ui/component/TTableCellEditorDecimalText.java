/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;


import de.kupzog.ktable.KTable;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TTableCellEditorDecimalText extends TTableCellEditor {

	private DecimalText m_Text;
	

	public void open(KTable table, int col, int row, Rectangle rect) {
		super.open(table, col, row, rect);
		m_Text.setText(m_Model.getContentAt(m_Col, m_Row).toString());
		m_Text.selectAll();
		m_Text.setVisible(true);
		m_Text.setEditable(true);
		
	}


	public void close(boolean save) {
		m_Text.setVisible(false);
		if (save)
			m_Model.setContentAt(m_Col, m_Row, m_Text.getText());
		super.close(save);
	}


	protected Control createControl() {
		m_Text = new DecimalText(m_Table, SWT.NONE);
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
