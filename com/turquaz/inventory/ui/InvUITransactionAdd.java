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
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import com.turquaz.engine.ui.component.SecureComposite;

/**
 * 
 * @author onsel
 * @version $Id$
 */
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/

public class InvUITransactionAdd extends SecureComposite {

	private CCombo comboInvTransWhSelect;
	private Label lblInvTransWhSelect;
	private CCombo comboInvTransUnit;
	private Text txtNumInvTransAmount;
	private Label lblInvTransAmount;
	private CCombo combpInvTransType;
	private Label lblInvTransType;
	private CCombo comboInvTransCard;
	private CLabel lblInvTransCard;
	private Composite compInvTransAdd;
	public InvUITransactionAdd(Composite parent, int style) {
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
	
			compInvTransAdd = new Composite(this,SWT.NULL);
			lblInvTransCard = new CLabel(compInvTransAdd,SWT.NULL);
			comboInvTransCard = new CCombo(compInvTransAdd,SWT.NULL);
			lblInvTransType = new Label(compInvTransAdd,SWT.NULL);
			combpInvTransType = new CCombo(compInvTransAdd,SWT.NULL);
			lblInvTransAmount = new Label(compInvTransAdd,SWT.NULL);
			txtNumInvTransAmount = new Text(compInvTransAdd,SWT.NULL);
			comboInvTransUnit = new CCombo(compInvTransAdd,SWT.NULL);
			lblInvTransWhSelect = new Label(compInvTransAdd,SWT.NULL);
			comboInvTransWhSelect = new CCombo(compInvTransAdd,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(329,223));
	
			compInvTransAdd.setSize(new org.eclipse.swt.graphics.Point(329,223));
	
			GridData lblInvTransCardLData = new GridData();
			lblInvTransCardLData.verticalAlignment = GridData.CENTER;
			lblInvTransCardLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransCardLData.widthHint = -1;
			lblInvTransCardLData.heightHint = -1;
			lblInvTransCardLData.horizontalIndent = 0;
			lblInvTransCardLData.horizontalSpan = 1;
			lblInvTransCardLData.verticalSpan = 1;
			lblInvTransCardLData.grabExcessHorizontalSpace = false;
			lblInvTransCardLData.grabExcessVerticalSpace = false;
			lblInvTransCard.setLayoutData(lblInvTransCardLData);
			lblInvTransCard.setText("Inventory Card");
			GridLayout lblInvTransCardLayout = new GridLayout(1, true);
			lblInvTransCard.setLayout(lblInvTransCardLayout);
			lblInvTransCardLayout.marginWidth = 5;
			lblInvTransCardLayout.marginHeight = 5;
			lblInvTransCardLayout.numColumns = 1;
			lblInvTransCardLayout.makeColumnsEqualWidth = true;
			lblInvTransCardLayout.horizontalSpacing = 5;
			lblInvTransCardLayout.verticalSpacing = 5;
			lblInvTransCard.layout();
	
			GridData comboInvTransCardLData = new GridData();
			comboInvTransCardLData.verticalAlignment = GridData.CENTER;
			comboInvTransCardLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransCardLData.widthHint = -1;
			comboInvTransCardLData.heightHint = -1;
			comboInvTransCardLData.horizontalIndent = 0;
			comboInvTransCardLData.horizontalSpan = 3;
			comboInvTransCardLData.verticalSpan = 1;
			comboInvTransCardLData.grabExcessHorizontalSpace = false;
			comboInvTransCardLData.grabExcessVerticalSpace = false;
			comboInvTransCard.setLayoutData(comboInvTransCardLData);
	
			GridData lblInvTransTypeLData = new GridData();
			lblInvTransTypeLData.verticalAlignment = GridData.CENTER;
			lblInvTransTypeLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransTypeLData.widthHint = -1;
			lblInvTransTypeLData.heightHint = -1;
			lblInvTransTypeLData.horizontalIndent = 0;
			lblInvTransTypeLData.horizontalSpan = 1;
			lblInvTransTypeLData.verticalSpan = 1;
			lblInvTransTypeLData.grabExcessHorizontalSpace = false;
			lblInvTransTypeLData.grabExcessVerticalSpace = false;
			lblInvTransType.setLayoutData(lblInvTransTypeLData);
			lblInvTransType.setText("Transaction Type");
	
			GridData combpInvTransTypeLData = new GridData();
			combpInvTransTypeLData.verticalAlignment = GridData.CENTER;
			combpInvTransTypeLData.horizontalAlignment = GridData.BEGINNING;
			combpInvTransTypeLData.widthHint = -1;
			combpInvTransTypeLData.heightHint = -1;
			combpInvTransTypeLData.horizontalIndent = 0;
			combpInvTransTypeLData.horizontalSpan = 3;
			combpInvTransTypeLData.verticalSpan = 1;
			combpInvTransTypeLData.grabExcessHorizontalSpace = false;
			combpInvTransTypeLData.grabExcessVerticalSpace = false;
			combpInvTransType.setLayoutData(combpInvTransTypeLData);
	
			GridData lblInvTransAmountLData = new GridData();
			lblInvTransAmountLData.verticalAlignment = GridData.CENTER;
			lblInvTransAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransAmountLData.widthHint = -1;
			lblInvTransAmountLData.heightHint = -1;
			lblInvTransAmountLData.horizontalIndent = 0;
			lblInvTransAmountLData.horizontalSpan = 1;
			lblInvTransAmountLData.verticalSpan = 1;
			lblInvTransAmountLData.grabExcessHorizontalSpace = false;
			lblInvTransAmountLData.grabExcessVerticalSpace = false;
			lblInvTransAmount.setLayoutData(lblInvTransAmountLData);
			lblInvTransAmount.setText("Amount");
	
			GridData txtNumInvTransAmountLData = new GridData();
			txtNumInvTransAmountLData.verticalAlignment = GridData.CENTER;
			txtNumInvTransAmountLData.horizontalAlignment = GridData.BEGINNING;
			txtNumInvTransAmountLData.widthHint = -1;
			txtNumInvTransAmountLData.heightHint = -1;
			txtNumInvTransAmountLData.horizontalIndent = 0;
			txtNumInvTransAmountLData.horizontalSpan = 1;
			txtNumInvTransAmountLData.verticalSpan = 1;
			txtNumInvTransAmountLData.grabExcessHorizontalSpace = false;
			txtNumInvTransAmountLData.grabExcessVerticalSpace = false;
			txtNumInvTransAmount.setLayoutData(txtNumInvTransAmountLData);
	
			GridData comboInvTransUnitLData = new GridData();
			comboInvTransUnitLData.verticalAlignment = GridData.CENTER;
			comboInvTransUnitLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransUnitLData.widthHint = -1;
			comboInvTransUnitLData.heightHint = -1;
			comboInvTransUnitLData.horizontalIndent = 0;
			comboInvTransUnitLData.horizontalSpan = 2;
			comboInvTransUnitLData.verticalSpan = 1;
			comboInvTransUnitLData.grabExcessHorizontalSpace = false;
			comboInvTransUnitLData.grabExcessVerticalSpace = false;
			comboInvTransUnit.setLayoutData(comboInvTransUnitLData);
	
			GridData lblInvTransWhSelectLData = new GridData();
			lblInvTransWhSelectLData.verticalAlignment = GridData.CENTER;
			lblInvTransWhSelectLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWhSelectLData.widthHint = -1;
			lblInvTransWhSelectLData.heightHint = -1;
			lblInvTransWhSelectLData.horizontalIndent = 0;
			lblInvTransWhSelectLData.horizontalSpan = 1;
			lblInvTransWhSelectLData.verticalSpan = 1;
			lblInvTransWhSelectLData.grabExcessHorizontalSpace = false;
			lblInvTransWhSelectLData.grabExcessVerticalSpace = false;
			lblInvTransWhSelect.setLayoutData(lblInvTransWhSelectLData);
			lblInvTransWhSelect.setText("Warehouse");
	
			GridData comboInvTransWhSelectLData = new GridData();
			comboInvTransWhSelectLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhSelectLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhSelectLData.widthHint = -1;
			comboInvTransWhSelectLData.heightHint = -1;
			comboInvTransWhSelectLData.horizontalIndent = 0;
			comboInvTransWhSelectLData.horizontalSpan = 3;
			comboInvTransWhSelectLData.verticalSpan = 1;
			comboInvTransWhSelectLData.grabExcessHorizontalSpace = false;
			comboInvTransWhSelectLData.grabExcessVerticalSpace = false;
			comboInvTransWhSelect.setLayoutData(comboInvTransWhSelectLData);
			GridLayout compInvTransAddLayout = new GridLayout(4, true);
			compInvTransAdd.setLayout(compInvTransAddLayout);
			compInvTransAddLayout.marginWidth = 5;
			compInvTransAddLayout.marginHeight = 5;
			compInvTransAddLayout.numColumns = 4;
			compInvTransAddLayout.makeColumnsEqualWidth = true;
			compInvTransAddLayout.horizontalSpacing = 5;
			compInvTransAddLayout.verticalSpacing = 5;
			compInvTransAdd.layout();
			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			thisLayout.type = SWT.HORIZONTAL;
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.spacing = 0;
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
			InvUITransactionAdd inst = new InvUITransactionAdd(shell, SWT.NULL);
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
