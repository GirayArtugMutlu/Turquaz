package com.turquaz.admin.ui;

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

import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;




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
/**
 * 
 * @author onsel
 *
 *@version $Id$
 */


public class AdmUIPermPanel extends Composite {

	private TableTreeItem tableTreeItem6;
	private TableTreeItem tableTreeItem5;
	private TableTreeItem tableTreeItem4;
	private TableTreeItem tableTreeItem3;
	private TableTreeItem tableTreeItem2;
	private TableTreeItem tableTreeItem1;
	private TableTree tableTree1;
	private CCombo cCombo1;
	private Composite composite2;
	private Composite composite1;
	public AdmUIPermPanel(Composite parent, int style) {
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
	
			composite1 = new Composite(this,SWT.NULL);
			cCombo1 = new CCombo(composite1,SWT.NULL);
			composite2 = new Composite(this,SWT.NULL);
			tableTree1 = new TableTree(composite2,SWT.CHECK| SWT.FULL_SELECTION);
			tableTreeItem1 = new TableTreeItem(tableTree1,SWT.NULL);
			tableTreeItem2 = new TableTreeItem(tableTree1,SWT.NULL);
			tableTreeItem3 = new TableTreeItem(tableTreeItem2,SWT.NULL);
			tableTreeItem4 = new TableTreeItem(tableTreeItem3,SWT.NULL);
			tableTreeItem5 = new TableTreeItem(tableTreeItem3,SWT.NULL);
			tableTreeItem6 = new TableTreeItem(tableTreeItem3,SWT.NULL);
	
			this.setSize(475, 297);
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = -1;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
	
			RowData cCombo1LData = new RowData(127, 20);
			cCombo1.setLayoutData(cCombo1LData);
			cCombo1.setText("cCombo1");
			cCombo1.setSize(new org.eclipse.swt.graphics.Point(127,20));
			RowLayout composite1Layout = new RowLayout(256);
			composite1.setLayout(composite1Layout);
			composite1Layout.type = SWT.HORIZONTAL;
			composite1Layout.marginWidth = 0;
			composite1Layout.marginHeight = 0;
			composite1Layout.spacing = 3;
			composite1Layout.wrap = true;
			composite1Layout.pack = true;
			composite1Layout.fill = false;
			composite1Layout.justify = false;
			composite1Layout.marginLeft = 3;
			composite1Layout.marginTop = 3;
			composite1Layout.marginRight = 3;
			composite1Layout.marginBottom = 3;
			composite1.layout();
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.FILL;
			composite2LData.horizontalAlignment = GridData.FILL;
			composite2LData.widthHint = -1;
			composite2LData.heightHint = -1;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = true;
			composite2.setLayoutData(composite2LData);
	
			tableTree1.setSize(new org.eclipse.swt.graphics.Point(422,311));
			tableTree1.getTable().setBounds(0, 0, 459, 231);

			tableTreeItem1.setText("Yönetici");
			tableTreeItem1.setChecked(false);
	
			tableTreeItem2.setText("Stok");
	
			tableTreeItem3.setText("Stok Kart? ");
	
			tableTreeItem4.setText("Okuma");
	
			tableTreeItem5.setText("Yazma");
	
			tableTreeItem6.setText("Silme");
			FillLayout composite2Layout = new FillLayout(256);
			composite2.setLayout(composite2Layout);
			composite2Layout.type = SWT.HORIZONTAL;
			composite2Layout.marginWidth = 0;
			composite2Layout.marginHeight = 0;
			composite2Layout.spacing = 0;
			composite2.layout();
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

	/** Add your post-init code in here  */
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
	

}
