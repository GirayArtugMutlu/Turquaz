
package com.turquaz.engine.ui.component;

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
* @author  Onsel Armagan
* @version  $Id$
*/

 

	import org.eclipse.swt.*;
	import org.eclipse.swt.custom.*;
	import org.eclipse.swt.events.*;
	import org.eclipse.swt.graphics.*;
	import org.eclipse.swt.widgets.*;


public class TTableCellEditorCombo 	extends TTableCellEditor 
	{
		private CCombo m_Combo;
		private String m_Items[];

		public void open(TTable table, int row, int col, Rectangle rect) {
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
			if(m_Items.length>0){
				m_Combo.setText(m_Items[0]);
			}
			m_Model.setContentAt(m_Col, m_Row,m_Combo.getText());
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
		public int getSelectionIndex(){
			if(m_Combo.equals(null)){
				return -1;
			}
			
			else {
				return m_Combo.getSelectionIndex();
			}
		}
		
		

}


