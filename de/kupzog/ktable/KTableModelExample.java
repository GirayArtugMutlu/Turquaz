/*
 * Created on 14.02.2004
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
import java.util.*;

/**
 * @author Friederich Kupzog
 */
public class KTableModelExample 
implements KTableModel {
	
	private int[] colWidths;
	private int rowHeight;
	private HashMap content;

	/**
	 * 
	 */
	public KTableModelExample() {
		colWidths = new int[getColumnCount()];
		for (int i = 0; i < colWidths.length; i++) {
			colWidths[i] = 70;
		}
		rowHeight = 18;
		content = new HashMap();
	}

	// Inhalte
	
	public Object getContentAt(int col, int row)
	{
		//System.out.println("col "+col+" row "+row);
		String erg = (String)content.get(col+"/"+row);
		if (erg != null) return erg;
		return col +"/"+ row;
	}
	
	
	/* 
	 * overridden from superclass
	 */
	public KTableCellEditor getCellEditor(int col, int row) {
		if (col % 2 == 0)
		{
			KTableCellEditorCombo e = new KTableCellEditorCombo();
			e.setItems(new String[] {"First text","Second text","third text"});
			return e;
		}
		else return new KTableCellEditorText();
	}

	/* 
	 * overridden from superclass
	 */
	public void setContentAt(int col, int row, Object value) {
		content.put(col+"/"+row, value);
		//
	}


	// Umfang
	
	public int getRowCount()
	{
		return 1000000;
	}
	
	public int getFixedRowCount()
	{
		return 2;
	}
	
	public int getColumnCount()
	{
		return 100;
	}
	
	public int getFixedColumnCount()
	{
		return 1;
	}
	

	// Größen
	
	public int getColumnWidth(int col)
	{
		return colWidths[col];
	}
	
	public int getRowHeight()
	{
		return rowHeight;
	}

	public boolean isColumnResizable(int col) {
		return true;
	}
	
	public int getFirstRowHeight()
	{
		return 22;
	}
	
	public boolean isRowResizable() {
		return true;
	}

	public int getRowHeightMinimum() {
		return 18;
	}


	public void setColumnWidth(int col, int value) {
		colWidths[col] = value;
	}

	public void setRowHeight(int value) {
		if (value < 2) value = 2;
		rowHeight = value;
	}


	// Rendering
	
	public KTableCellRenderer getCellRenderer(int col, int row)
	{
		return KTableCellRenderer.defaultRenderer;
	}

}



