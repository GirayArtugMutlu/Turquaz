package com.turquaz.inventory.ui.comp;

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
 * @author Onsel Armagan
 * @version $Id$
 */
public interface IPriceListViewer
{
	/**
	 * Update the view to reflect the fact that a task was added to the task list
	 * 
	 * @param task
	 */
	public void addPrice(InvUIPrice price);

	/**
	 * Update the view to reflect the fact that a task was removed from the task list
	 * 
	 * @param task
	 */
	public void removePrice(InvUIPrice price);

	/**
	 * Update the view to reflect the fact that one of the tasks was modified
	 * 
	 * @param task
	 */
	public void updatePrice(InvUIPrice price);
}