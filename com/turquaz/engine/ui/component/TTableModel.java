/*
 * Created on 05.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.turquaz.engine.ui.component;
import de.kupzog.ktable.*;
import java.util.*;
import java.sql.*;

/**
 * @author onsel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TTableModel implements KTableModel {

	private int[] colWidths;
	private int rowHeight;
	private int columnCount =0;
	private int rowCount =1;
	private HashMap content;

	/**
	 * 
	 */
	public TTableModel() {
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
		return "";
	}
	
	
	/* 
	 * overridden from superclass
	 */
	public KTableCellEditor getCellEditor(int col, int row) {
		/*if (col % 2 == 0)
		{
			KTableCellEditorCombo e = new KTableCellEditorCombo();
			e.setItems(new String[] {"First text","Second text","third text"});
			return e;
		}
		else*/ 
		return new KTableCellEditorText();
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
		return rowCount;
	}
	
	public void setRowCount(int a){
		rowCount = a;
	}
	
	public int getFixedRowCount()
	{
		return 1;
	}
	
	public int getColumnCount()
	{
		return columnCount;
	}
	public void setColumnCount(int a)
	{
		columnCount = a;
		colWidths = new int[getColumnCount()];
				for (int i = 0; i < colWidths.length; i++) {
					colWidths[i] = 70;
				}
	}
	public void clearTable(){
		columnCount =0;
		rowCount =1;
		content.clear();
	}
	
	public int getFixedColumnCount()
	{
		return 0;
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


