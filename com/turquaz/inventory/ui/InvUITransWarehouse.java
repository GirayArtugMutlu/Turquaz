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
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUITransWarehouse extends org.eclipse.swt.widgets.Composite {

	private CCombo comboInvTransWhUnit;
	private Text txtNumInvTransWhAmount;
	private CLabel lblInvTransWhAmount;
	private CCombo comboInvTransWhTo;
	private CLabel lblInvTransWhTo;
	private CCombo comboInvTransWhFrom;
	private Label lblInvTransWhFrom;
	private CCombo comboInvTransWhCard;
	private CLabel lblInvTransWhCard;
	private Composite compInvTransWare;
	public InvUITransWarehouse(Composite parent, int style) {
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
	
			compInvTransWare = new Composite(this,SWT.NULL);
			lblInvTransWhCard = new CLabel(compInvTransWare,SWT.NULL);
			comboInvTransWhCard = new CCombo(compInvTransWare,SWT.NULL);
			lblInvTransWhFrom = new Label(compInvTransWare,SWT.NULL);
			comboInvTransWhFrom = new CCombo(compInvTransWare,SWT.NULL);
			lblInvTransWhTo = new CLabel(compInvTransWare,SWT.NULL);
			comboInvTransWhTo = new CCombo(compInvTransWare,SWT.NULL);
			lblInvTransWhAmount = new CLabel(compInvTransWare,SWT.NULL);
			txtNumInvTransWhAmount = new Text(compInvTransWare,SWT.NULL);
			comboInvTransWhUnit = new CCombo(compInvTransWare,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(329,223));
	
	
			lblInvTransWhCard.setText("Inventory Card");
	
			GridData comboInvTransWhCardLData = new GridData();
			comboInvTransWhCardLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhCardLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhCardLData.widthHint = -1;
			comboInvTransWhCardLData.heightHint = -1;
			comboInvTransWhCardLData.horizontalIndent = 0;
			comboInvTransWhCardLData.horizontalSpan = 3;
			comboInvTransWhCardLData.verticalSpan = 1;
			comboInvTransWhCardLData.grabExcessHorizontalSpace = false;
			comboInvTransWhCardLData.grabExcessVerticalSpace = false;
			comboInvTransWhCard.setLayoutData(comboInvTransWhCardLData);
	
			lblInvTransWhFrom.setText("From:");
	
			GridData comboInvTransWhFromLData = new GridData();
			comboInvTransWhFromLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhFromLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhFromLData.widthHint = -1;
			comboInvTransWhFromLData.heightHint = -1;
			comboInvTransWhFromLData.horizontalIndent = 0;
			comboInvTransWhFromLData.horizontalSpan = 3;
			comboInvTransWhFromLData.verticalSpan = 1;
			comboInvTransWhFromLData.grabExcessHorizontalSpace = false;
			comboInvTransWhFromLData.grabExcessVerticalSpace = false;
			comboInvTransWhFrom.setLayoutData(comboInvTransWhFromLData);
	
			lblInvTransWhTo.setText("To:");
	
			GridData comboInvTransWhToLData = new GridData();
			comboInvTransWhToLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhToLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhToLData.widthHint = -1;
			comboInvTransWhToLData.heightHint = -1;
			comboInvTransWhToLData.horizontalIndent = 0;
			comboInvTransWhToLData.horizontalSpan = 3;
			comboInvTransWhToLData.verticalSpan = 1;
			comboInvTransWhToLData.grabExcessHorizontalSpace = false;
			comboInvTransWhToLData.grabExcessVerticalSpace = false;
			comboInvTransWhTo.setLayoutData(comboInvTransWhToLData);
	
			lblInvTransWhAmount.setText("Amount");
	
	
			GridData comboInvTransWhUnitLData = new GridData();
			comboInvTransWhUnitLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhUnitLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhUnitLData.widthHint = -1;
			comboInvTransWhUnitLData.heightHint = -1;
			comboInvTransWhUnitLData.horizontalIndent = 0;
			comboInvTransWhUnitLData.horizontalSpan = 2;
			comboInvTransWhUnitLData.verticalSpan = 1;
			comboInvTransWhUnitLData.grabExcessHorizontalSpace = false;
			comboInvTransWhUnitLData.grabExcessVerticalSpace = false;
			comboInvTransWhUnit.setLayoutData(comboInvTransWhUnitLData);
			GridLayout compInvTransWareLayout = new GridLayout(4, true);
			compInvTransWare.setLayout(compInvTransWareLayout);
			compInvTransWareLayout.marginWidth = 5;
			compInvTransWareLayout.marginHeight = 5;
			compInvTransWareLayout.numColumns = 4;
			compInvTransWareLayout.makeColumnsEqualWidth = true;
			compInvTransWareLayout.horizontalSpacing = 5;
			compInvTransWareLayout.verticalSpacing = 5;
			compInvTransWare.layout();
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

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
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
			InvUITransWarehouse inst = new InvUITransWarehouse(shell, SWT.NULL);
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
