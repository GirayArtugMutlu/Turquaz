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

import org.eclipse.jface.contentassist.ComboContentAssistSubjectAdapter;
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
	private CLabel lblInvTransWareUnit;
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
			lblInvTransWareUnit = new CLabel(compInvTransWare,SWT.NULL);
			comboInvTransWhUnit = new CCombo(compInvTransWare,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(329,223));
	
	
			GridData lblInvTransWhCardLData = new GridData();
			lblInvTransWhCardLData.verticalAlignment = GridData.CENTER;
			lblInvTransWhCardLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWhCardLData.widthHint = -1;
			lblInvTransWhCardLData.heightHint = -1;
			lblInvTransWhCardLData.horizontalIndent = 0;
			lblInvTransWhCardLData.horizontalSpan = 1;
			lblInvTransWhCardLData.verticalSpan = 1;
			lblInvTransWhCardLData.grabExcessHorizontalSpace = false;
			lblInvTransWhCardLData.grabExcessVerticalSpace = false;
			lblInvTransWhCard.setLayoutData(lblInvTransWhCardLData);
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
	
			GridData lblInvTransWhFromLData = new GridData();
			lblInvTransWhFromLData.verticalAlignment = GridData.CENTER;
			lblInvTransWhFromLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWhFromLData.widthHint = -1;
			lblInvTransWhFromLData.heightHint = -1;
			lblInvTransWhFromLData.horizontalIndent = 0;
			lblInvTransWhFromLData.horizontalSpan = 1;
			lblInvTransWhFromLData.verticalSpan = 1;
			lblInvTransWhFromLData.grabExcessHorizontalSpace = false;
			lblInvTransWhFromLData.grabExcessVerticalSpace = false;
			lblInvTransWhFrom.setLayoutData(lblInvTransWhFromLData);
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
	
			GridData lblInvTransWhToLData = new GridData();
			lblInvTransWhToLData.verticalAlignment = GridData.CENTER;
			lblInvTransWhToLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWhToLData.widthHint = -1;
			lblInvTransWhToLData.heightHint = -1;
			lblInvTransWhToLData.horizontalIndent = 0;
			lblInvTransWhToLData.horizontalSpan = 1;
			lblInvTransWhToLData.verticalSpan = 1;
			lblInvTransWhToLData.grabExcessHorizontalSpace = false;
			lblInvTransWhToLData.grabExcessVerticalSpace = false;
			lblInvTransWhTo.setLayoutData(lblInvTransWhToLData);
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
	
			GridData lblInvTransWhAmountLData = new GridData();
			lblInvTransWhAmountLData.verticalAlignment = GridData.CENTER;
			lblInvTransWhAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWhAmountLData.widthHint = -1;
			lblInvTransWhAmountLData.heightHint = -1;
			lblInvTransWhAmountLData.horizontalIndent = 0;
			lblInvTransWhAmountLData.horizontalSpan = 1;
			lblInvTransWhAmountLData.verticalSpan = 1;
			lblInvTransWhAmountLData.grabExcessHorizontalSpace = false;
			lblInvTransWhAmountLData.grabExcessVerticalSpace = false;
			lblInvTransWhAmount.setLayoutData(lblInvTransWhAmountLData);
			lblInvTransWhAmount.setText("Amount");
	
			GridData txtNumInvTransWhAmountLData = new GridData();
			txtNumInvTransWhAmountLData.verticalAlignment = GridData.CENTER;
			txtNumInvTransWhAmountLData.horizontalAlignment = GridData.BEGINNING;
			txtNumInvTransWhAmountLData.widthHint = -1;
			txtNumInvTransWhAmountLData.heightHint = -1;
			txtNumInvTransWhAmountLData.horizontalIndent = 0;
			txtNumInvTransWhAmountLData.horizontalSpan = 1;
			txtNumInvTransWhAmountLData.verticalSpan = 1;
			txtNumInvTransWhAmountLData.grabExcessHorizontalSpace = false;
			txtNumInvTransWhAmountLData.grabExcessVerticalSpace = false;
			txtNumInvTransWhAmount.setLayoutData(txtNumInvTransWhAmountLData);
	
			GridData lblInvTransWareUnitLData = new GridData();
			lblInvTransWareUnitLData.verticalAlignment = GridData.CENTER;
			lblInvTransWareUnitLData.horizontalAlignment = GridData.BEGINNING;
			lblInvTransWareUnitLData.widthHint = -1;
			lblInvTransWareUnitLData.heightHint = -1;
			lblInvTransWareUnitLData.horizontalIndent = 0;
			lblInvTransWareUnitLData.horizontalSpan = 1;
			lblInvTransWareUnitLData.verticalSpan = 1;
			lblInvTransWareUnitLData.grabExcessHorizontalSpace = false;
			lblInvTransWareUnitLData.grabExcessVerticalSpace = false;
			lblInvTransWareUnit.setLayoutData(lblInvTransWareUnitLData);
			lblInvTransWareUnit.setText("Unit");
	
			GridData comboInvTransWhUnitLData = new GridData();
			comboInvTransWhUnitLData.verticalAlignment = GridData.CENTER;
			comboInvTransWhUnitLData.horizontalAlignment = GridData.BEGINNING;
			comboInvTransWhUnitLData.widthHint = -1;
			comboInvTransWhUnitLData.heightHint = -1;
			comboInvTransWhUnitLData.horizontalIndent = 0;
			comboInvTransWhUnitLData.horizontalSpan = 1;
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
