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

/**
 * @author onsel
 * @version $Id$
 */

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import java.io.*;
import java.util.regex.Matcher;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalText;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.engine.ui.component.TTable;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import java.util.regex.Pattern;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUICardAdd extends SecureComposite {

	private Composite composite5;
	private CTabItem cTabItem2;
	private TableColumn tableColumn6;
	private Table table4;
	private Button button3;
	private Button button2;
	private Button button1;
	private Composite composite4;
	private TableColumn tableColumn4;
	private Table table3;
	private Composite composite3;
	private CLabel cLabel9;
	private TableColumn tableColumn2;
	private TableColumn tableColumn1;
	private Table table1;
	private Button btnNewUnit;
	private Button btnUnitRemove;
	private Button btnUnitAdd;
	private Composite composite2;
	private TableColumn tableColumn3;
	private Table table2;
	private Composite composite1;
	private CLabel cLabel8;
	private Text text5;
	private CLabel cLabel7;
	private Text cCombo2;
	private CLabel cLabel6;
	private Text cCombo1;
	private CLabel cLabel5;
	private NumericText text4;
	private CLabel cLabel4;
	private NumericText text3;
	private CLabel cLabel3;
	private Text text2;
	private CLabel cLabel2;
	private Text text1;
	private CLabel cLabel1;
	private Composite comp_general_info;
	private CTabItem cTabItem1;
	private CTabFolder cTabFolder1;
	public InvUICardAdd(Composite parent, int style) {
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
	
			cTabFolder1 = new CTabFolder(this,SWT.H_SCROLL| SWT.V_SCROLL);
			cTabItem1 = new CTabItem(cTabFolder1,SWT.NULL);
			comp_general_info = new Composite(cTabFolder1,SWT.NULL);
			cLabel1 = new CLabel(comp_general_info,SWT.RIGHT);
			text1 = new Text(comp_general_info,SWT.NULL);
			cLabel2 = new CLabel(comp_general_info,SWT.RIGHT);
			text2 = new Text(comp_general_info,SWT.NULL);
			cLabel3 = new CLabel(comp_general_info,SWT.RIGHT);
			text3 = new NumericText(comp_general_info,SWT.NULL);
			cLabel4 = new CLabel(comp_general_info,SWT.RIGHT);
			text4 = new NumericText(comp_general_info,SWT.NULL);
			cLabel5 = new CLabel(comp_general_info,SWT.RIGHT);
			cCombo1 = new Text(comp_general_info,SWT.NULL);
			cLabel6 = new CLabel(comp_general_info,SWT.RIGHT);
			cCombo2 = new Text(comp_general_info,SWT.NULL);
			cLabel7 = new CLabel(comp_general_info,SWT.RIGHT);
			text5 = new Text(comp_general_info,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL| SWT.V_SCROLL);
			cLabel8 = new CLabel(comp_general_info,SWT.RIGHT);
			composite1 = new Composite(comp_general_info,SWT.BORDER);
			table2 = new Table(composite1,SWT.BORDER);
			tableColumn3 = new TableColumn(table2,SWT.NULL);
			composite2 = new Composite(composite1,SWT.NULL);
			btnUnitAdd = new Button(composite2,SWT.PUSH| SWT.CENTER);
			btnUnitRemove = new Button(composite2,SWT.PUSH| SWT.CENTER);
			btnNewUnit = new Button(composite2,SWT.PUSH| SWT.CENTER);
			table1 = new Table(composite1,SWT.SINGLE| SWT.FULL_SELECTION| SWT.BORDER);
			tableColumn1 = new TableColumn(table1,SWT.CENTER);
			tableColumn2 = new TableColumn(table1,SWT.CENTER);
			cLabel9 = new CLabel(comp_general_info,SWT.RIGHT);
			composite3 = new Composite(comp_general_info,SWT.BORDER);
			table3 = new Table(composite3,SWT.BORDER);
			tableColumn4 = new TableColumn(table3,SWT.NULL);
			composite4 = new Composite(composite3,SWT.NULL);
			button1 = new Button(composite4,SWT.PUSH| SWT.CENTER);
			button2 = new Button(composite4,SWT.PUSH| SWT.CENTER);
			button3 = new Button(composite4,SWT.PUSH| SWT.CENTER);
			table4 = new Table(composite3,SWT.SINGLE| SWT.FULL_SELECTION| SWT.BORDER);
			tableColumn6 = new TableColumn(table4,SWT.CENTER);
			cTabItem2 = new CTabItem(cTabFolder1,SWT.NULL);
			composite5 = new Composite(cTabFolder1,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(585,434));
			final Color InvUICardAddbackground = new Color(Display.getDefault(),128,128,255);
			this.setBackground(InvUICardAddbackground);
	
			GridData cTabFolder1LData = new GridData();
			cTabFolder1LData.verticalAlignment = GridData.FILL;
			cTabFolder1LData.horizontalAlignment = GridData.FILL;
			cTabFolder1LData.widthHint = -1;
			cTabFolder1LData.heightHint = -1;
			cTabFolder1LData.horizontalIndent = 0;
			cTabFolder1LData.horizontalSpan = 1;
			cTabFolder1LData.verticalSpan = 1;
			cTabFolder1LData.grabExcessHorizontalSpace = true;
			cTabFolder1LData.grabExcessVerticalSpace = true;
			cTabFolder1.setLayoutData(cTabFolder1LData);
			cTabFolder1.setSize(new org.eclipse.swt.graphics.Point(571,408));
	
			cTabItem1.setControl(comp_general_info);
			cTabItem1.setText("Genel Bilgiler");
	
			comp_general_info.setSize(new org.eclipse.swt.graphics.Point(571,408));
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.FILL;
			cLabel1LData.widthHint = -1;
			cLabel1LData.heightHint = 19;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Stok Kodu");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(102,19));
	
			GridData text1LData = new GridData();
			text1LData.verticalAlignment = GridData.CENTER;
			text1LData.horizontalAlignment = GridData.BEGINNING;
			text1LData.widthHint = 98;
			text1LData.heightHint = 20;
			text1LData.horizontalIndent = 0;
			text1LData.horizontalSpan = 1;
			text1LData.verticalSpan = 1;
			text1LData.grabExcessHorizontalSpace = false;
			text1LData.grabExcessVerticalSpace = false;
			text1.setLayoutData(text1LData);
			text1.setTextLimit(2147483646);
			text1.setSize(new org.eclipse.swt.graphics.Point(98,20));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.END;
			cLabel2LData.widthHint = 65;
			cLabel2LData.heightHint = 19;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Stok Adý");
			cLabel2.setSize(new org.eclipse.swt.graphics.Point(65,19));
	
			GridData text2LData = new GridData();
			text2LData.verticalAlignment = GridData.CENTER;
			text2LData.horizontalAlignment = GridData.BEGINNING;
			text2LData.widthHint = 124;
			text2LData.heightHint = 20;
			text2LData.horizontalIndent = 0;
			text2LData.horizontalSpan = 1;
			text2LData.verticalSpan = 1;
			text2LData.grabExcessHorizontalSpace = true;
			text2LData.grabExcessVerticalSpace = false;
			text2.setLayoutData(text2LData);
			text2.setSize(new org.eclipse.swt.graphics.Point(124,20));
	
			GridData cLabel3LData = new GridData();
			cLabel3LData.verticalAlignment = GridData.CENTER;
			cLabel3LData.horizontalAlignment = GridData.FILL;
			cLabel3LData.widthHint = -1;
			cLabel3LData.heightHint = 19;
			cLabel3LData.horizontalIndent = 0;
			cLabel3LData.horizontalSpan = 1;
			cLabel3LData.verticalSpan = 1;
			cLabel3LData.grabExcessHorizontalSpace = false;
			cLabel3LData.grabExcessVerticalSpace = false;
			cLabel3.setLayoutData(cLabel3LData);
			cLabel3.setText("Stok Minimum Miktar");
			cLabel3.setSize(new org.eclipse.swt.graphics.Point(102,19));
	
			GridData text3LData = new GridData();
			text3LData.verticalAlignment = GridData.CENTER;
			text3LData.horizontalAlignment = GridData.BEGINNING;
			text3LData.widthHint = 98;
			text3LData.heightHint = 20;
			text3LData.horizontalIndent = 0;
			text3LData.horizontalSpan = 1;
			text3LData.verticalSpan = 1;
			text3LData.grabExcessHorizontalSpace = false;
			text3LData.grabExcessVerticalSpace = false;
			text3.setLayoutData(text3LData);
			text3.setSize(new org.eclipse.swt.graphics.Point(98,20));
	
			GridData cLabel4LData = new GridData();
			cLabel4LData.verticalAlignment = GridData.CENTER;
			cLabel4LData.horizontalAlignment = GridData.END;
			cLabel4LData.widthHint = 106;
			cLabel4LData.heightHint = 19;
			cLabel4LData.horizontalIndent = 0;
			cLabel4LData.horizontalSpan = 1;
			cLabel4LData.verticalSpan = 1;
			cLabel4LData.grabExcessHorizontalSpace = false;
			cLabel4LData.grabExcessVerticalSpace = false;
			cLabel4.setLayoutData(cLabel4LData);
			cLabel4.setText("Stok Maximum Miktar");
			cLabel4.setSize(new org.eclipse.swt.graphics.Point(106,19));
	
			GridData text4LData = new GridData();
			text4LData.verticalAlignment = GridData.CENTER;
			text4LData.horizontalAlignment = GridData.BEGINNING;
			text4LData.widthHint = 126;
			text4LData.heightHint = 19;
			text4LData.horizontalIndent = 0;
			text4LData.horizontalSpan = 1;
			text4LData.verticalSpan = 1;
			text4LData.grabExcessHorizontalSpace = false;
			text4LData.grabExcessVerticalSpace = false;
			text4.setLayoutData(text4LData);
			text4.setSize(new org.eclipse.swt.graphics.Point(126,19));
	
			GridData cLabel5LData = new GridData();
			cLabel5LData.verticalAlignment = GridData.CENTER;
			cLabel5LData.horizontalAlignment = GridData.FILL;
			cLabel5LData.widthHint = -1;
			cLabel5LData.heightHint = 19;
			cLabel5LData.horizontalIndent = 0;
			cLabel5LData.horizontalSpan = 1;
			cLabel5LData.verticalSpan = 1;
			cLabel5LData.grabExcessHorizontalSpace = false;
			cLabel5LData.grabExcessVerticalSpace = false;
			cLabel5.setLayoutData(cLabel5LData);
			cLabel5.setText("KDV yüzdesi");
			cLabel5.setSize(new org.eclipse.swt.graphics.Point(102,19));
	
			GridData cCombo1LData = new GridData();
			cCombo1LData.verticalAlignment = GridData.CENTER;
			cCombo1LData.horizontalAlignment = GridData.BEGINNING;
			cCombo1LData.widthHint = 98;
			cCombo1LData.heightHint = 20;
			cCombo1LData.horizontalIndent = 0;
			cCombo1LData.horizontalSpan = 1;
			cCombo1LData.verticalSpan = 1;
			cCombo1LData.grabExcessHorizontalSpace = false;
			cCombo1LData.grabExcessVerticalSpace = false;
			cCombo1.setLayoutData(cCombo1LData);
			cCombo1.setSize(new org.eclipse.swt.graphics.Point(98,20));
	
			GridData cLabel6LData = new GridData();
			cLabel6LData.verticalAlignment = GridData.CENTER;
			cLabel6LData.horizontalAlignment = GridData.END;
			cLabel6LData.widthHint = 77;
			cLabel6LData.heightHint = 19;
			cLabel6LData.horizontalIndent = 0;
			cLabel6LData.horizontalSpan = 1;
			cLabel6LData.verticalSpan = 1;
			cLabel6LData.grabExcessHorizontalSpace = false;
			cLabel6LData.grabExcessVerticalSpace = false;
			cLabel6.setLayoutData(cLabel6LData);
			cLabel6.setText("Ýndirim Yüzdesi");
			cLabel6.setSize(new org.eclipse.swt.graphics.Point(77,19));
	
			GridData cCombo2LData = new GridData();
			cCombo2LData.verticalAlignment = GridData.CENTER;
			cCombo2LData.horizontalAlignment = GridData.BEGINNING;
			cCombo2LData.widthHint = 129;
			cCombo2LData.heightHint = 18;
			cCombo2LData.horizontalIndent = 0;
			cCombo2LData.horizontalSpan = 1;
			cCombo2LData.verticalSpan = 1;
			cCombo2LData.grabExcessHorizontalSpace = false;
			cCombo2LData.grabExcessVerticalSpace = false;
			cCombo2.setLayoutData(cCombo2LData);
			cCombo2.setSize(new org.eclipse.swt.graphics.Point(129,18));
	
			GridData cLabel7LData = new GridData();
			cLabel7LData.verticalAlignment = GridData.BEGINNING;
			cLabel7LData.horizontalAlignment = GridData.FILL;
			cLabel7LData.widthHint = -1;
			cLabel7LData.heightHint = 19;
			cLabel7LData.horizontalIndent = 0;
			cLabel7LData.horizontalSpan = 1;
			cLabel7LData.verticalSpan = 1;
			cLabel7LData.grabExcessHorizontalSpace = false;
			cLabel7LData.grabExcessVerticalSpace = false;
			cLabel7.setLayoutData(cLabel7LData);
			cLabel7.setText("Açýklama");
			cLabel7.setSize(new org.eclipse.swt.graphics.Point(102,19));
	
			GridData text5LData = new GridData();
			text5LData.verticalAlignment = GridData.BEGINNING;
			text5LData.horizontalAlignment = GridData.FILL;
			text5LData.widthHint = -1;
			text5LData.heightHint = 60;
			text5LData.horizontalIndent = 0;
			text5LData.horizontalSpan = 3;
			text5LData.verticalSpan = 1;
			text5LData.grabExcessHorizontalSpace = false;
			text5LData.grabExcessVerticalSpace = false;
			text5.setLayoutData(text5LData);
			text5.setTextLimit(250);
			text5.setSize(new org.eclipse.swt.graphics.Point(431,60));
	
			GridData cLabel8LData = new GridData();
			cLabel8LData.verticalAlignment = GridData.BEGINNING;
			cLabel8LData.horizontalAlignment = GridData.FILL;
			cLabel8LData.widthHint = -1;
			cLabel8LData.heightHint = 19;
			cLabel8LData.horizontalIndent = 0;
			cLabel8LData.horizontalSpan = 1;
			cLabel8LData.verticalSpan = 1;
			cLabel8LData.grabExcessHorizontalSpace = false;
			cLabel8LData.grabExcessVerticalSpace = false;
			cLabel8.setLayoutData(cLabel8LData);
			cLabel8.setText("Stok Birimleri");
			cLabel8.setSize(new org.eclipse.swt.graphics.Point(102,19));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.BEGINNING;
			composite1LData.widthHint = 391;
			composite1LData.heightHint = 97;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 3;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(391,97));
	
			GridData table2LData = new GridData();
			table2LData.verticalAlignment = GridData.FILL;
			table2LData.horizontalAlignment = GridData.BEGINNING;
			table2LData.widthHint = 113;
			table2LData.heightHint = -1;
			table2LData.horizontalIndent = 0;
			table2LData.horizontalSpan = 1;
			table2LData.verticalSpan = 1;
			table2LData.grabExcessHorizontalSpace = false;
			table2LData.grabExcessVerticalSpace = false;
			table2.setLayoutData(table2LData);
			table2.setHeaderVisible(true);
			table2.setLinesVisible(true);
			table2.setSize(new org.eclipse.swt.graphics.Point(113,67));
	
			tableColumn3.setText("Birimler");
			tableColumn3.setWidth(125);
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.FILL;
			composite2LData.horizontalAlignment = GridData.BEGINNING;
			composite2LData.widthHint = 65;
			composite2LData.heightHint = -1;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = true;
			composite2.setLayoutData(composite2LData);
			composite2.setSize(new org.eclipse.swt.graphics.Point(65,87));
	
			GridData btnUnitAddLData = new GridData();
			btnUnitAddLData.verticalAlignment = GridData.CENTER;
			btnUnitAddLData.horizontalAlignment = GridData.FILL;
			btnUnitAddLData.widthHint = -1;
			btnUnitAddLData.heightHint = 23;
			btnUnitAddLData.horizontalIndent = 0;
			btnUnitAddLData.horizontalSpan = 1;
			btnUnitAddLData.verticalSpan = 1;
			btnUnitAddLData.grabExcessHorizontalSpace = false;
			btnUnitAddLData.grabExcessVerticalSpace = false;
			btnUnitAdd.setLayoutData(btnUnitAddLData);
			btnUnitAdd.setText("Ekle >>");
			btnUnitAdd.setSize(new org.eclipse.swt.graphics.Point(55,23));
	
			GridData btnUnitRemoveLData = new GridData();
			btnUnitRemoveLData.verticalAlignment = GridData.CENTER;
			btnUnitRemoveLData.horizontalAlignment = GridData.FILL;
			btnUnitRemoveLData.widthHint = -1;
			btnUnitRemoveLData.heightHint = 23;
			btnUnitRemoveLData.horizontalIndent = 0;
			btnUnitRemoveLData.horizontalSpan = 1;
			btnUnitRemoveLData.verticalSpan = 1;
			btnUnitRemoveLData.grabExcessHorizontalSpace = false;
			btnUnitRemoveLData.grabExcessVerticalSpace = false;
			btnUnitRemove.setLayoutData(btnUnitRemoveLData);
			btnUnitRemove.setText("<< Çýkar");
			btnUnitRemove.setSize(new org.eclipse.swt.graphics.Point(55,23));
	
			GridData btnNewUnitLData = new GridData();
			btnNewUnitLData.verticalAlignment = GridData.CENTER;
			btnNewUnitLData.horizontalAlignment = GridData.BEGINNING;
			btnNewUnitLData.widthHint = 57;
			btnNewUnitLData.heightHint = 23;
			btnNewUnitLData.horizontalIndent = 0;
			btnNewUnitLData.horizontalSpan = 1;
			btnNewUnitLData.verticalSpan = 1;
			btnNewUnitLData.grabExcessHorizontalSpace = false;
			btnNewUnitLData.grabExcessVerticalSpace = false;
			btnNewUnit.setLayoutData(btnNewUnitLData);
			btnNewUnit.setText("Yeni Birim");
			btnNewUnit.setSize(new org.eclipse.swt.graphics.Point(57,23));
			GridLayout composite2Layout = new GridLayout(1, true);
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 5;
			composite2Layout.marginHeight = 5;
			composite2Layout.numColumns = 1;
			composite2Layout.makeColumnsEqualWidth = true;
			composite2Layout.horizontalSpacing = 5;
			composite2Layout.verticalSpacing = 5;
			composite2.layout();
	
			GridData table1LData = new GridData();
			table1LData.verticalAlignment = GridData.FILL;
			table1LData.horizontalAlignment = GridData.FILL;
			table1LData.widthHint = -1;
			table1LData.heightHint = -1;
			table1LData.horizontalIndent = 0;
			table1LData.horizontalSpan = 1;
			table1LData.verticalSpan = 1;
			table1LData.grabExcessHorizontalSpace = false;
			table1LData.grabExcessVerticalSpace = true;
			table1.setLayoutData(table1LData);
			table1.setHeaderVisible(true);
			table1.setLinesVisible(true);
			table1.setSize(new org.eclipse.swt.graphics.Point(152,67));
	
			tableColumn1.setText("Birim");
			tableColumn1.setWidth(79);
	
			tableColumn2.setText("Katsayý");
			tableColumn2.setWidth(73);
			GridLayout composite1Layout = new GridLayout(3, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 3;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData cLabel9LData = new GridData();
			cLabel9LData.verticalAlignment = GridData.BEGINNING;
			cLabel9LData.horizontalAlignment = GridData.FILL;
			cLabel9LData.widthHint = -1;
			cLabel9LData.heightHint = -1;
			cLabel9LData.horizontalIndent = 0;
			cLabel9LData.horizontalSpan = 1;
			cLabel9LData.verticalSpan = 1;
			cLabel9LData.grabExcessHorizontalSpace = false;
			cLabel9LData.grabExcessVerticalSpace = false;
			cLabel9.setLayoutData(cLabel9LData);
			cLabel9.setText("Stok Grubu");
	
			GridData composite3LData = new GridData();
			composite3LData.verticalAlignment = GridData.CENTER;
			composite3LData.horizontalAlignment = GridData.BEGINNING;
			composite3LData.widthHint = 391;
			composite3LData.heightHint = 97;
			composite3LData.horizontalIndent = 0;
			composite3LData.horizontalSpan = 3;
			composite3LData.verticalSpan = 1;
			composite3LData.grabExcessHorizontalSpace = false;
			composite3LData.grabExcessVerticalSpace = false;
			composite3.setLayoutData(composite3LData);
			composite3.setSize(new org.eclipse.swt.graphics.Point(391,97));
	
			GridData table3LData = new GridData();
			table3LData.verticalAlignment = GridData.FILL;
			table3LData.horizontalAlignment = GridData.BEGINNING;
			table3LData.widthHint = 113;
			table3LData.heightHint = -1;
			table3LData.horizontalIndent = 0;
			table3LData.horizontalSpan = 1;
			table3LData.verticalSpan = 1;
			table3LData.grabExcessHorizontalSpace = false;
			table3LData.grabExcessVerticalSpace = false;
			table3.setLayoutData(table3LData);
			table3.setHeaderVisible(true);
			table3.setLinesVisible(true);
			table3.setSize(new org.eclipse.swt.graphics.Point(113,67));
	
			tableColumn4.setText("Stok Guruplarý");
			tableColumn4.setWidth(125);
	
			GridData composite4LData = new GridData();
			composite4LData.verticalAlignment = GridData.FILL;
			composite4LData.horizontalAlignment = GridData.BEGINNING;
			composite4LData.widthHint = 65;
			composite4LData.heightHint = -1;
			composite4LData.horizontalIndent = 0;
			composite4LData.horizontalSpan = 1;
			composite4LData.verticalSpan = 1;
			composite4LData.grabExcessHorizontalSpace = false;
			composite4LData.grabExcessVerticalSpace = true;
			composite4.setLayoutData(composite4LData);
			composite4.setSize(new org.eclipse.swt.graphics.Point(65,87));
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.CENTER;
			button1LData.horizontalAlignment = GridData.FILL;
			button1LData.widthHint = -1;
			button1LData.heightHint = 23;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("Ekle >>");
			button1.setSize(new org.eclipse.swt.graphics.Point(55,23));
	
			GridData button2LData = new GridData();
			button2LData.verticalAlignment = GridData.CENTER;
			button2LData.horizontalAlignment = GridData.FILL;
			button2LData.widthHint = -1;
			button2LData.heightHint = 23;
			button2LData.horizontalIndent = 0;
			button2LData.horizontalSpan = 1;
			button2LData.verticalSpan = 1;
			button2LData.grabExcessHorizontalSpace = false;
			button2LData.grabExcessVerticalSpace = false;
			button2.setLayoutData(button2LData);
			button2.setText("<< Çýkar");
			button2.setSize(new org.eclipse.swt.graphics.Point(55,23));
	
			GridData button3LData = new GridData();
			button3LData.verticalAlignment = GridData.CENTER;
			button3LData.horizontalAlignment = GridData.BEGINNING;
			button3LData.widthHint = 57;
			button3LData.heightHint = 23;
			button3LData.horizontalIndent = 0;
			button3LData.horizontalSpan = 1;
			button3LData.verticalSpan = 1;
			button3LData.grabExcessHorizontalSpace = false;
			button3LData.grabExcessVerticalSpace = false;
			button3.setLayoutData(button3LData);
			button3.setText("Yeni Grup");
			button3.setSize(new org.eclipse.swt.graphics.Point(57,23));
			GridLayout composite4Layout = new GridLayout(1, true);
			composite4.setLayout(composite4Layout);
			composite4Layout.marginWidth = 5;
			composite4Layout.marginHeight = 5;
			composite4Layout.numColumns = 1;
			composite4Layout.makeColumnsEqualWidth = true;
			composite4Layout.horizontalSpacing = 5;
			composite4Layout.verticalSpacing = 5;
			composite4.layout();
	
			GridData table4LData = new GridData();
			table4LData.verticalAlignment = GridData.FILL;
			table4LData.horizontalAlignment = GridData.FILL;
			table4LData.widthHint = -1;
			table4LData.heightHint = -1;
			table4LData.horizontalIndent = 0;
			table4LData.horizontalSpan = 1;
			table4LData.verticalSpan = 1;
			table4LData.grabExcessHorizontalSpace = false;
			table4LData.grabExcessVerticalSpace = true;
			table4.setLayoutData(table4LData);
			table4.setHeaderVisible(true);
			table4.setLinesVisible(true);
			table4.setSize(new org.eclipse.swt.graphics.Point(115,67));
	
			tableColumn6.setText("Dahil Olunan Gruplar");
			tableColumn6.setWidth(115);
			GridLayout composite3Layout = new GridLayout(3, true);
			composite3.setLayout(composite3Layout);
			composite3Layout.marginWidth = 5;
			composite3Layout.marginHeight = 5;
			composite3Layout.numColumns = 3;
			composite3Layout.makeColumnsEqualWidth = false;
			composite3Layout.horizontalSpacing = 5;
			composite3Layout.verticalSpacing = 5;
			composite3.layout();
			GridLayout comp_general_infoLayout = new GridLayout(4, true);
			comp_general_info.setLayout(comp_general_infoLayout);
			comp_general_infoLayout.marginWidth = 5;
			comp_general_infoLayout.marginHeight = 10;
			comp_general_infoLayout.numColumns = 4;
			comp_general_infoLayout.makeColumnsEqualWidth = false;
			comp_general_infoLayout.horizontalSpacing = 5;
			comp_general_infoLayout.verticalSpacing = 10;
			comp_general_info.layout();
	
			cTabItem2.setControl(composite5);
			cTabItem2.setText("cTabItem2");
	
			GridLayout composite5Layout = new GridLayout(4, true);
			composite5.setLayout(composite5Layout);
			composite5Layout.marginWidth = 5;
			composite5Layout.marginHeight = 5;
			composite5Layout.numColumns = 4;
			composite5Layout.makeColumnsEqualWidth = true;
			composite5Layout.horizontalSpacing = 5;
			composite5Layout.verticalSpacing = 5;
			composite5.layout();
			cTabFolder1.setSelection(0);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 2;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 10;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					InvUICardAddbackground.dispose();
				}
			});
	
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
		System.out.println("Delete Button Pushed!");
	}
	public void newForm(){
		System.out.println("New Button Pushed!");
	}
	public void search(){
		System.out.println("Search Button Pushed!");
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
			InvUICardAdd inst = new InvUICardAdd(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,601,434);
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
	/**
	* This is an auto-generated method which you can alter,
	* e.g. to point to a different property file, to modify the key by
	* by prefixing the name of this class, etc.
	*
	* By default, it expects a file called "messages.properties" to exist in the
	* current package, and returns the value of the property defined
	* in that file for the given key
	*/
	public String getExternalizedString(String key){
		try {
			return java.util.ResourceBundle.getBundle("com.turquaz.inventory.ui.InvUICardAddMessages").getString(key);
		} catch (java.util.MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
