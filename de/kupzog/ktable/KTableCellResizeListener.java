/*
 * Created on 19.02.2004
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
public interface KTableCellResizeListener {
	
	/**
	 * Is called when a row is resized.
	 */
	public void rowResized(int newHeight);

	/**
	 * Is called when a column is resized.
	 */
	public void columnResized(int col, int newWidth);

}
