
package com.turquaz.engine.ui.component;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.turquaz.current.ui.CurUICurrentCardAdd;
import com.turquaz.engine.ui.EngUIMainFrame;

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
* @author   Huseyin Ergun
* @version  $Id$
*/

public class MenuFactory {

	public static MenuItem createFinanceMenu (MenuItem menuItem)
	{
		
		Menu menuFinance = new Menu(menuItem);
		menuItem.setMenu(menuFinance);
		
		MenuItem currentMit = new MenuItem(menuFinance,SWT.CASCADE);
		currentMit.setText("Cari");
		
		Menu currentMenu = new Menu(currentMit);
		currentMit.setMenu(currentMenu);
		
		// current menu items 
		
		MenuItem currentAccAdd = new MenuItem (currentMenu,SWT.PUSH);
		currentAccAdd.setText("Cari Kart Ekleme");
		currentAccAdd.setData(CurUICurrentCardAdd.class.getName());
		currentAccAdd.addSelectionListener(new MenuSelectionAdapter());
		currentAccAdd.setAccelerator(SWT.CTRL | 'g');
		MenuItem sps =new MenuItem(currentMenu,SWT.SEPARATOR);
		
		return menuItem;
	}
	
}

class MenuSelectionAdapter extends SelectionAdapter {
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub
		super.widgetDefaultSelected(arg0);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent arg0) {
		
		
	EngUIMainFrame.openNewTab(((MenuItem)arg0.widget).getText(),arg0.widget.getData().toString());
		
	}
}
