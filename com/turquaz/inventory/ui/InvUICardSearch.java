package com.turquaz.inventory.ui;

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


import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.component.TTable;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import java.sql.*;


/**
 * 
 * @author onsel
 * @version $Id$
 */
public class InvUICardSearch extends SecureComposite {

	private TTable tTable1;
	public InvUICardSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			tTable1 = new TTable(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(329,223));
	
			GridData tTable1LData = new GridData();
			tTable1LData.verticalAlignment = GridData.FILL;
			tTable1LData.horizontalAlignment = GridData.FILL;
			tTable1LData.widthHint = -1;
			tTable1LData.heightHint = -1;
			tTable1LData.horizontalIndent = 0;
			tTable1LData.horizontalSpan = 1;
			tTable1LData.verticalSpan = 1;
			tTable1LData.grabExcessHorizontalSpace = false;
			tTable1LData.grabExcessVerticalSpace = true;
			tTable1.setLayoutData(tTable1LData);
			tTable1.setSize(new org.eclipse.swt.graphics.Point(319,193));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		tTable1.fillRandom();
		
	}
	public void save(){
		
	}
	public void delete(){
		
	}
	public void newForm(){
		
	}
	public void search(){
		
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUICardSearch inst = new InvUICardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,329,223);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
