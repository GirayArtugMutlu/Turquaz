/*  Copyright (C) 2004 by Friederich Kupzog Elektronik & Software
 
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
    
    Author: Friederich Kupzog  
    fkmk@kupzog.de
    www.kupzog.de/fkmk
*/
 
 
package de.kupzog.ktools.kprint.boxes;

import de.kupzog.ktable.KTableModel;
import de.kupzog.ktools.kprint.gui.MsgBox;

/**
 * Allows to print KTable objects.
 * 
 * You have to specify a KTableModel and a PTableBoxProvider.
 * @author Friederich Kupzog
 */
public class PTable {
	
	protected KTableModel model;
	protected PTableBoxProvider boxProvider;
	protected PContainer parent;

	public PTable(PContainer parent) {
		this.parent = parent;
	}
	
	protected void fillDocument()
	{
		boolean abgeschnitten = false;
		// Zeilen
		for (int i = 0; i < model.getRowCount(); i++) {
			//System.out.println("Spalte "+i);
			int height = model.getRowHeight();
			if (i==0) height = model.getFirstRowHeight();
			
			double width = parent.getPossibleWidth();
			
			
			// Spalten
			for (int j = 0; j < model.getColumnCount(); j++) {
				//System.out.println("  Zeile "+j);
				int style = PBox.POS_RIGHT | PBox.ROW_ALIGN;
				if (j == 0) style = PBox.POS_BELOW | PBox.ROW_ALIGN;
				
				PBox box = boxProvider.createBox(
					parent,
					style,
					j,
					i,
					model.getColumnWidth(j),
					height,
					(model.getFixedColumnCount() > j || model.getFixedRowCount() > i),
					model.getContentAt(j, i)
				);
				double boxWidth = Math.max(box.minCm, parent.getPossibleWidth()*box.hWeight);
				width -= boxWidth;
				if (width < 0)
				{
					box.dispose();
					abgeschnitten = true;
					break;
				}
			}
		}
		if (abgeschnitten) MsgBox.show("Tabelle ist zu breit für die Seite\n" +
		"und wird deshalb abgeschnitten.");

	}

	/**
	 * @return PTableBoxProvider
	 */
	public PTableBoxProvider getBoxProvider() {
		return boxProvider;
	}

	/**
	 * @return KTableModel
	 */
	public KTableModel getModel() {
		return model;
	}

	/**
	 * Sets the boxProvider.
	 * @param boxProvider The boxProvider to set
	 */
	public void setBoxProvider(PTableBoxProvider boxProvider) {
		this.boxProvider = boxProvider;
		if (this.boxProvider != null && this.model != null)
		{
			fillDocument();
		}
	}

	/**
	 * Sets the table.
	 * @param table The table to set
	 */
	public void setModel(KTableModel model) {
		this.model = model;
		if (this.boxProvider != null && this.model != null)
		{
			fillDocument();
		}
	}

}
