/*
 * Copyright (C) 2004 by Friederich Kupzog Elektronik & Software This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version. This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA Author: Friederich Kupzog fkmk@kupzog.de
 * www.kupzog.de/fkmk
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import com.turquaz.engine.Messages;
import de.kupzog.ktools.kprint.boxes.PBox;
import de.kupzog.ktools.kprint.boxes.PContainer;
import de.kupzog.ktools.kprint.boxes.PDocument;
import de.kupzog.ktools.kprint.boxes.PLittleTextBox;
import de.kupzog.ktools.kprint.boxes.PTableBoxProvider;
import de.kupzog.ktools.kprint.boxes.PTextStyle;
import de.kupzog.ktools.kprint.gui.MsgBox;
import de.kupzog.ktools.kprint.gui.PageSetup;

public class SWTPTable
{
	protected Table table;
	protected PTableBoxProvider boxProvider;
	protected PContainer parent;

	public SWTPTable(PContainer parent)
	{
		this.parent = parent;
	}

	protected void fillDocument()
	{
		boolean abgeschnitten = false;
		calculatePageLengths();
		// Zeilen
		/**
		 * if (j == 0) style = PBox.POS_BELOW | PBox.ROW_ALIGN;
		 */
		double width = parent.getPossibleWidth();
		for (int j = 0; j < table.getColumnCount(); j++)
		{
			int height = table.getHeaderHeight();
			int column_width = table.getColumn(j).getWidth();
			if(column_width <20)
			{
				continue;
				
			}
			int style = PBox.POS_RIGHT | PBox.ROW_ALIGN;
			if (j == 0)
				style = PBox.POS_BELOW | PBox.ROW_ALIGN;
			PBox box = boxProvider.createBox(parent, style, j, 0, column_width, height,true, table.getColumn(j).getText());
			
			((PLittleTextBox) box).getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
			
			double boxWidth = Math.max(box.minCm, parent.getPossibleWidth() * box.hWeight);
			width -= boxWidth;
			if (width < 0)
			{
				box.dispose();
				abgeschnitten = true;
				break;
			}
		}
		for (int i = 0; i < table.getItemCount(); i++)
		{
			width = parent.getPossibleWidth();
			// Spalten
			for (int j = 0; j < table.getColumnCount(); j++)
			{
				//System.out.println(" Zeile "+j);
				int height = table.getHeaderHeight();
				int column_width = table.getColumn(j).getWidth();
				if(column_width <20)
				{
					continue;
					
				}
				int style = PBox.POS_RIGHT | PBox.ROW_ALIGN;
				if (j == 0)
					style = PBox.POS_BELOW | PBox.ROW_ALIGN;
				
				PBox box = boxProvider
						.createBox(parent, style, j, i,column_width,height, false, table.getItem(i).getText(j));
				if (table.getColumn(j).getStyle() == SWT.RIGHT)
				{
					((PLittleTextBox) box).getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
				}
				double boxWidth = Math.max(box.minCm, parent.getPossibleWidth() * box.hWeight);
				width -= boxWidth;
				if (width < 0)
				{
					box.dispose();
					abgeschnitten = true;
					break;
				}
			}
		}
		if (abgeschnitten)
			MsgBox.show(Messages.getString("SWTPTable.0") + //$NON-NLS-1$
					Messages.getString("SWTPTable.1")); //$NON-NLS-1$
	}

	public void calculatePageLengths()
	{
		if (table != null)
		{
			PDocument doc = (PDocument) parent;
			double width = parent.getPossibleWidth();
			for (int j = 0; j < table.getColumnCount(); j++)
			{
				double boxWidth = Math.max(0, table.getColumn(j).getWidth() * 0.03);
				width -= boxWidth;
				if (width < 0)
				{
					break;
				}
			}
			if (width < 0)
			{
				doc.setPageHeight(PageSetup.paperWidth);
				doc.setPageWidth(PageSetup.paperHeight);
			}
		}
	}

	/**
	 * @return PTableBoxProvider
	 */
	public PTableBoxProvider getBoxProvider()
	{
		return boxProvider;
	}

	/**
	 * @return KTableModel
	 */
	public Table getTable()
	{
		return table;
	}

	/**
	 * Sets the boxProvider.
	 * 
	 * @param boxProvider
	 *             The boxProvider to set
	 */
	public void setBoxProvider(PTableBoxProvider boxProvider)
	{
		this.boxProvider = boxProvider;
		if (this.boxProvider != null && this.table != null)
		{
			fillDocument();
		}
	}

	/**
	 * Sets the table.
	 * 
	 * @param table
	 *             The table to set
	 */
	public void setTable(Table table)
	{
		this.table = table;
		if (this.boxProvider != null && this.table != null)
		{
			fillDocument();
		}
	}
}