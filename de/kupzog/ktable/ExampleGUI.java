/* (c) 2004 by Friederich Kupzog Elektronik & Software
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
*/

package de.kupzog.ktable;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

/**
 * KTable example GUI
 * 
 *
 */

public class ExampleGUI {
	public static void main(String[] args) {
		// create a shell...
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("KTable examples");
		
		// put a tab folder in it...
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		
		// Item 1: a Text Table
		TabItem item1 = new TabItem(tabFolder, SWT.NONE);
		item1.setText("Text Table");
		Composite comp1 = new Composite(tabFolder, SWT.NONE);
		item1.setControl(comp1);
		comp1.setLayout(new FillLayout());
		
		
		// put a table in tabItem1...
		KTable table = new KTable(comp1, SWT.V_SCROLL | SWT.H_SCROLL);
		table.setRowSelectionMode(true);
		table.setMultiSelectionMode(true);
		table.setModel(new KTableModelExample());
		table.addCellSelectionListener(
			new KTableCellSelectionListener()
			{
				public void cellSelected(int col, int row, int statemask) {
					System.out.println("Cell ["+col+";"+row+"] selected.");
				}
				public void fixedCellSelected(int col, int row, int statemask) {
					System.out.println("Header ["+col+";"+row+"] selected.");
				}

			}
		);
	
		table.addCellResizeListener(
			new KTableCellResizeListener()
			{
				public void columnResized(int col, int newWidth) {
					System.out.println("Column "+col+" resized to "+newWidth);
				}
				public void rowResized(int newHeight) {
					System.out.println("Rows resized to "+newHeight);
				}

			}
		);
	
		// Item 2: a Color Palette
		TabItem item2 = new TabItem(tabFolder, SWT.NONE);
		item2.setText("Color Palette");
		Composite comp2 = new Composite(tabFolder, SWT.NONE);
		item2.setControl(comp2);
		comp2.setLayout(new FillLayout());
		
		// put a table in tabItem2...
		final KTable table2 = new KTable(comp2, SWT.NONE);
		table2.setModel(new PaletteExampleModel());
		table2.setRowSelectionMode(false);
		table2.setMultiSelectionMode(false);
		final Label label = new Label(comp2, SWT.NONE);
		label.setText("Click a cell...");
		table2.addCellSelectionListener(
			new KTableCellSelectionAdapter()
			{
				public void cellSelected(int col, int row, int statemask) {
					RGB rgb = (RGB)table2.getModel().getContentAt(col, row);
					label.setText("R: "+rgb.red+"\nG: "+rgb.green+"\nB: "+rgb.blue);
				}
			}
		);
		
		// Item 3: Town table
		TabItem item3 = new TabItem(tabFolder, SWT.NONE);
		item3.setText("Towns");
		Composite comp3 = new Composite(tabFolder, SWT.NONE);
		item3.setControl(comp3);
		comp3.setLayout(new FillLayout());
		
		// put a table in tabItem3...
		final KTable table3 = new KTable(comp3, SWT.H_SCROLL);
		table3.setModel(new TownExampleModel());
		table3.setRowSelectionMode(true);
		table3.setMultiSelectionMode(false);
		
	
	
		// display the shell...
		shell.setSize(600,600);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
