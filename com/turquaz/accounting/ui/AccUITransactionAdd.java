package com.turquaz.accounting.ui;
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
* @author  Onsel Armagan
* @version  $Id$
*/

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionAdd extends org.eclipse.swt.widgets.Composite {

	private DatePicker datePicker1;
	public AccUITransactionAdd(Composite parent, int style) {
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
	
			datePicker1 = new DatePicker(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(505,316));
	
			GridData datePicker1LData = new GridData();
			datePicker1LData.verticalAlignment = GridData.CENTER;
			datePicker1LData.horizontalAlignment = GridData.BEGINNING;
			datePicker1LData.widthHint = 98;
			datePicker1LData.heightHint = 26;
			datePicker1LData.horizontalIndent = 0;
			datePicker1LData.horizontalSpan = 1;
			datePicker1LData.verticalSpan = 1;
			datePicker1LData.grabExcessHorizontalSpace = false;
			datePicker1LData.grabExcessVerticalSpace = false;
			datePicker1.setLayoutData(datePicker1LData);
			datePicker1.setSize(new org.eclipse.swt.graphics.Point(98,26));
			datePicker1.layout();
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
	}
}
