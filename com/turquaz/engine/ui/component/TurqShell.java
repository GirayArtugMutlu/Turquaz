package com.turquaz.engine.ui.component;

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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.engine.ui.EngUIMainFrame;

public class TurqShell extends Shell
{
	public TurqShell()
	{
		super();
	}

	public TurqShell(Display d)
	{
		super(d);
	}

	public void dispose()
	{
		EngUIMainFrame.saveFavoritesTree();
		super.dispose();
	}
}