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

import org.eclipse.swt.layout.FillLayout;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.inventory.Messages;

/**
 * 
 * @author onsel
 * @version $Id$
 */
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/

public class InvUITransactionAdd extends  Composite implements SecureComposite {

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

			this.setSize(new org.eclipse.swt.graphics.Point(329,223));

			GridLayout thisLayout = new GridLayout();
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			{
				compInvTransAdd = new Composite(this, SWT.NONE);
				GridLayout compInvTransAddLayout = new GridLayout();
				GridData compInvTransAddLData = new GridData();
				compInvTransAddLData.grabExcessHorizontalSpace = true;
				compInvTransAddLData.grabExcessVerticalSpace = true;
				compInvTransAddLData.horizontalAlignment = GridData.FILL;
				compInvTransAddLData.verticalAlignment = GridData.FILL;
				compInvTransAdd.setLayoutData(compInvTransAddLData);
				compInvTransAddLayout.numColumns = 4;
				compInvTransAddLayout.makeColumnsEqualWidth = true;
				compInvTransAdd.setLayout(compInvTransAddLayout);
				{
					lblInvTransCard = new CLabel(compInvTransAdd, SWT.NONE);
					GridLayout lblInvTransCardLayout = new GridLayout(1, true);
					lblInvTransCardLayout.marginWidth = 5;
					lblInvTransCardLayout.marginHeight = 5;
					lblInvTransCardLayout.numColumns = 1;
					lblInvTransCardLayout.makeColumnsEqualWidth = true;
					lblInvTransCardLayout.horizontalSpacing = 5;
					lblInvTransCardLayout.verticalSpacing = 5;
					GridData lblInvTransCardLData = new GridData();
					lblInvTransCardLData.widthHint = 52;
					lblInvTransCardLData.heightHint = 19;
					lblInvTransCard.setLayoutData(lblInvTransCardLData);
					lblInvTransCard.setText(Messages
						.getString("InvUITransactionAdd.0")); //$NON-NLS-1$
					lblInvTransCard.setLayout(lblInvTransCardLayout);
					lblInvTransCard.layout();
				}
				{
					comboInvTransCard = new CCombo(compInvTransAdd, SWT.NONE);
					GridData comboInvTransCardLData = new GridData();
					comboInvTransCardLData.widthHint = 64;
					comboInvTransCardLData.heightHint = 16;
					comboInvTransCardLData.horizontalSpan = 3;
					comboInvTransCard.setLayoutData(comboInvTransCardLData);
				}
				{
					lblInvTransType = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransTypeLData = new GridData();
					lblInvTransTypeLData.widthHint = 57;
					lblInvTransTypeLData.heightHint = 13;
					lblInvTransType.setLayoutData(lblInvTransTypeLData);
					lblInvTransType.setText(Messages
						.getString("InvUITransactionAdd.1")); //$NON-NLS-1$
				}
				{
					combpInvTransType = new CCombo(compInvTransAdd, SWT.NONE);
					GridData combpInvTransTypeLData = new GridData();
					combpInvTransTypeLData.widthHint = 64;
					combpInvTransTypeLData.heightHint = 16;
					combpInvTransTypeLData.horizontalSpan = 3;
					combpInvTransType.setLayoutData(combpInvTransTypeLData);
				}
				{
					lblInvTransAmount = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransAmountLData = new GridData();
					lblInvTransAmountLData.widthHint = 29;
					lblInvTransAmountLData.heightHint = 13;
					lblInvTransAmount.setLayoutData(lblInvTransAmountLData);
					lblInvTransAmount.setText(Messages
						.getString("InvUITransactionAdd.2")); //$NON-NLS-1$
				}
				{
					txtNumInvTransAmount = new Text(compInvTransAdd, SWT.NONE);
					GridData txtNumInvTransAmountLData = new GridData();
					txtNumInvTransAmountLData.widthHint = 64;
					txtNumInvTransAmountLData.heightHint = 13;
					txtNumInvTransAmount
						.setLayoutData(txtNumInvTransAmountLData);
				}
				{
					comboInvTransUnit = new CCombo(compInvTransAdd, SWT.NONE);
					GridData comboInvTransUnitLData = new GridData();
					comboInvTransUnitLData.widthHint = 64;
					comboInvTransUnitLData.heightHint = 16;
					comboInvTransUnitLData.horizontalSpan = 2;
					comboInvTransUnit.setLayoutData(comboInvTransUnitLData);
				}
				{
					lblInvTransWhSelect = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransWhSelectLData = new GridData();
					lblInvTransWhSelectLData.widthHint = 25;
					lblInvTransWhSelectLData.heightHint = 13;
					lblInvTransWhSelect.setLayoutData(lblInvTransWhSelectLData);
					lblInvTransWhSelect.setText(Messages
						.getString("InvUITransactionAdd.3")); //$NON-NLS-1$
				}
				{
					comboInvTransWhSelect = new CCombo(
						compInvTransAdd,
						SWT.NONE);
					GridData comboInvTransWhSelectLData = new GridData();
					comboInvTransWhSelectLData.widthHint = 64;
					comboInvTransWhSelectLData.heightHint = 16;
					comboInvTransWhSelectLData.horizontalSpan = 3;
					comboInvTransWhSelect
						.setLayoutData(comboInvTransWhSelectLData);
				}
				compInvTransAdd.layout();
			}
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
