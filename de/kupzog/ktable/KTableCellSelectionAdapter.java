/*
 * Created on 02.03.2004
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



/**
 * @author Friederich Kupzog
 */
public class KTableCellSelectionAdapter 
implements KTableCellSelectionListener 
{
	/**
	 * Is called if a non-fixed cell is selected (gets the focus). 
	 * @see KTable for an explanation of the term "fixed cells".
	 * @param col
	 * the column of the cell
	 * @param row
	 * the row of the cell
	 * @param statemask
	 * the modifier keys that where pressed when the selection happened.
	 */
	public void cellSelected(int col, int row, int statemask) {
	}

	/**
	 * Is called if a fixed cell is selected (is clicked). 
	 * @see KTable for an explanation of the term "fixed cells".
	 * @param col
	 * the column of the cell
	 * @param row
	 * the row of the cell
	 * @param statemask
	 * the modifier keys that where pressed when the selection happened.
	 */
	public void fixedCellSelected(int col, int row, int statemask) {
	}


}
