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
 * www.kupzog.de/fkmk
 * 
 */
package de.kupzog.ktable;
import org.eclipse.swt.graphics.*;
/**
 * @author Friederich Kupzog
 */
public class PaletteExampleModel 
implements KTableModel {

	/* 
	 * overridden from superclass
	 */
	public Object getContentAt(int col, int row) {
		return new RGB(col*16,row*16,(col+row)*8);
	}

	/* 
	 * overridden from superclass
	 */
	public KTableCellEditor getCellEditor(int col, int row) {
		return null;
	}

	/* 
	 * overridden from superclass
	 */
	public void setContentAt(int col, int row, Object value) {
	}

	/* 
	 * overridden from superclass
	 */
	public int getRowCount() {
		return 16;
	}

	/* 
	 * overridden from superclass
	 */
	public int getFixedRowCount() {
		return 0;
	}

	/* 
	 * overridden from superclass
	 */
	public int getColumnCount() {
		return 16;
	}

	/* 
	 * overridden from superclass
	 */
	public int getFixedColumnCount() {
		return 0;
	}

	/* 
	 * overridden from superclass
	 */
	public int getColumnWidth(int col) {
		return 10;
	}

	/* 
	 * overridden from superclass
	 */
	public boolean isColumnResizable(int col) {
		return false;
	}

	/* 
	 * overridden from superclass
	 */
	public void setColumnWidth(int col, int value) {
	}

	/* 
	 * overridden from superclass
	 */
	public int getRowHeight() {
		return 10;
	}

	/* 
	 * overridden from superclass
	 */
	public int getFirstRowHeight() {
		return 10;
	}

	/* 
	 * overridden from superclass
	 */
	public boolean isRowResizable() {
		return false;
	}

	/* 
	 * overridden from superclass
	 */
	public int getRowHeightMinimum() {
		return 10;
	}

	/* 
	 * overridden from superclass
	 */
	public void setRowHeight(int value) {
	}

	private static KTableCellRenderer myRenderer = new PaletteExampleRenderer();
	/* 
	 * overridden from superclass
	 */
	public KTableCellRenderer getCellRenderer(int col, int row) {
		return myRenderer;
	}

}
