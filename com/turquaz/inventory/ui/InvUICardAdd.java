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
import com.turquaz.engine.ui.component.TTableComboModel;
import com.turquaz.engine.ui.component.TTableModel;

import org.eclipse.swt.widgets.List;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.engine.ui.component.TTable;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import java.util.regex.Pattern;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUICardAdd extends SecureComposite {

	private TableColumn tableColumnRegisteredGroups;
	private TableColumn tableColumnGroups;
	private Table tableInvCardAddGroupsAllGroups;
	private Table tableInvCardAddGroupsRegisteredGroups;
	private Button btnInvCardAddGroupsRemoveRegisteredGroup;
	private Button btnInvCardAddGroupsRegisterGroup;
	private Composite compInvCardAddGroupsButtonComp;
	private Composite compInvCardAddGroupsSelection;
	private Composite compInvCardAddGroups;
	private TTable tTable1;
	private Button button2;
	private Button button1;
	private Composite composite5;
	private Composite composite4;
	private Composite composite3;
	private Button btnInvCardRemoveUnit;
	private Button btnInvCardAddUnit;
	private Composite composite2;
	private TTable tableInvCardSecondaryUnits;
	private Composite composite1;
	private CLabel lblInvCardSecondaryUnits;
	private CTabItem tabInvCardGroups;
	private CTabItem tabInvCardPrices;
	private Button btnInvCardNext;
	private Button btnInvCardDetPre;
	private CCombo comboInvCardUnits;
	private CLabel lblInvCardUnit;
	private Composite compInvCardUnit;
	private Text txtInvCardDiscount;
	private CLabel lblInvCardDiscount;
	private Text txtInvCardVat;
	private CLabel lblInvCardVat;
	private Text txtInvCardOutAcc;
	private CLabel lblInvCardOutAcc;
	private Text txtInvCardInAcc;
	private CLabel lblInvCardInAcc;
	private Text txtnumInvCardMax;
	private CLabel lblInvCardMax;
	private NumericText txtnumInvCardMin;
	private Label lblInvCardMin;
	private Composite compInvCardDetails;
	private CTabItem tabInvCardDetails;
	private Button btnInvCardGeneral;
	private CTabItem tabInvCardUnits;
	private Text txtInvCardDefinition;
	private CLabel lblInvCardDefinition;
	private Text txtInvCardCode;
	private CLabel lblInvCardCode;
	private Text txtInvCardSpecialCode;
	private CLabel lblInvCardSpecialCode;
	private Text txtInvCardName;
	private CLabel lblInvCardName;
	private Composite compInvCardGeneral;
	private CTabItem tabInvCardGeneral;
	private CTabFolder tabfldInvCardAdd;
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
	
			tabfldInvCardAdd = new CTabFolder(this,SWT.NULL);
			tabInvCardGeneral = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardGeneral = new Composite(tabfldInvCardAdd,SWT.NULL);
			lblInvCardName = new CLabel(compInvCardGeneral,SWT.NULL);
			txtInvCardName = new Text(compInvCardGeneral,SWT.NULL);
			lblInvCardSpecialCode = new CLabel(compInvCardGeneral,SWT.NULL);
			txtInvCardSpecialCode = new Text(compInvCardGeneral,SWT.NULL);
			lblInvCardCode = new CLabel(compInvCardGeneral,SWT.NULL);
			txtInvCardCode = new Text(compInvCardGeneral,SWT.NULL);
			lblInvCardDefinition = new CLabel(compInvCardGeneral,SWT.NULL);
			txtInvCardDefinition = new Text(compInvCardGeneral,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL| SWT.V_SCROLL);
			btnInvCardGeneral = new Button(compInvCardGeneral,SWT.PUSH| SWT.CENTER);
			tabInvCardDetails = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardDetails = new Composite(tabfldInvCardAdd,SWT.NULL);
			lblInvCardMin = new Label(compInvCardDetails,SWT.NULL);
			txtnumInvCardMin = new NumericText(compInvCardDetails,SWT.NULL);
			lblInvCardMax = new CLabel(compInvCardDetails,SWT.NULL);
			txtnumInvCardMax = new Text(compInvCardDetails,SWT.NULL);
			lblInvCardInAcc = new CLabel(compInvCardDetails,SWT.NULL);
			txtInvCardInAcc = new Text(compInvCardDetails,SWT.NULL);
			lblInvCardOutAcc = new CLabel(compInvCardDetails,SWT.NULL);
			txtInvCardOutAcc = new Text(compInvCardDetails,SWT.NULL);
			lblInvCardVat = new CLabel(compInvCardDetails,SWT.NULL);
			txtInvCardVat = new Text(compInvCardDetails,SWT.NULL);
			lblInvCardDiscount = new CLabel(compInvCardDetails,SWT.NULL);
			txtInvCardDiscount = new Text(compInvCardDetails,SWT.NULL);
			btnInvCardDetPre = new Button(compInvCardDetails,SWT.PUSH| SWT.CENTER);
			btnInvCardNext = new Button(compInvCardDetails,SWT.PUSH| SWT.CENTER);
			tabInvCardUnits = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardUnit = new Composite(tabfldInvCardAdd,SWT.NULL);
			lblInvCardUnit = new CLabel(compInvCardUnit,SWT.NULL);
			comboInvCardUnits = new CCombo(compInvCardUnit,SWT.FLAT);
			lblInvCardSecondaryUnits = new CLabel(compInvCardUnit,SWT.NULL);
			composite1 = new Composite(compInvCardUnit,SWT.NULL);
			composite2 = new Composite(composite1,SWT.NULL);
			btnInvCardAddUnit = new Button(composite2,SWT.PUSH| SWT.CENTER);
			btnInvCardRemoveUnit = new Button(composite2,SWT.PUSH| SWT.CENTER);
			tableInvCardSecondaryUnits = new TTable(composite1,SWT.V_SCROLL| SWT.BORDER);
			tabInvCardPrices = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			composite3 = new Composite(tabfldInvCardAdd,SWT.NULL);
			composite4 = new Composite(composite3,SWT.NULL);
			composite5 = new Composite(composite4,SWT.NULL);
			button1 = new Button(composite5,SWT.PUSH| SWT.CENTER);
			button2 = new Button(composite5,SWT.PUSH| SWT.CENTER);
			tTable1 = new TTable(composite4,SWT.V_SCROLL| SWT.BORDER);
			tabInvCardGroups = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardAddGroups = new Composite(tabfldInvCardAdd,SWT.NULL);
			compInvCardAddGroupsSelection = new Composite(compInvCardAddGroups,SWT.NULL);
			tableInvCardAddGroupsAllGroups = new Table(compInvCardAddGroupsSelection,SWT.SINGLE| SWT.BORDER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(585,434));
			final Color InvUICardAddbackground = new Color(Display.getDefault(),128,128,255);
			this.setBackground(InvUICardAddbackground);
	
			GridData tabfldInvCardAddLData = new GridData();
			tabfldInvCardAddLData.verticalAlignment = GridData.FILL;
			tabfldInvCardAddLData.horizontalAlignment = GridData.FILL;
			tabfldInvCardAddLData.widthHint = -1;
			tabfldInvCardAddLData.heightHint = -1;
			tabfldInvCardAddLData.horizontalIndent = 0;
			tabfldInvCardAddLData.horizontalSpan = 1;
			tabfldInvCardAddLData.verticalSpan = 1;
			tabfldInvCardAddLData.grabExcessHorizontalSpace = true;
			tabfldInvCardAddLData.grabExcessVerticalSpace = true;
			tabfldInvCardAdd.setLayoutData(tabfldInvCardAddLData);
			tabfldInvCardAdd.setSize(new org.eclipse.swt.graphics.Point(587,425));
	
			tabInvCardGeneral.setControl(compInvCardGeneral);
			tabInvCardGeneral.setText("General Information");
	
			compInvCardGeneral.setSize(new org.eclipse.swt.graphics.Point(587,408));
	
			lblInvCardName.setText("Inventory Name");
			lblInvCardName.setSize(new org.eclipse.swt.graphics.Point(90,30));
			lblInvCardName.setBounds(new org.eclipse.swt.graphics.Rectangle(14,21,90,30));
	
			txtInvCardName.setTextLimit(50);
			txtInvCardName.setSize(new org.eclipse.swt.graphics.Point(89,21));
			txtInvCardName.setBounds(new org.eclipse.swt.graphics.Rectangle(103,24,95,21));
	
			lblInvCardSpecialCode.setText("Special Code");
			lblInvCardSpecialCode.setSize(new org.eclipse.swt.graphics.Point(81,30));
			lblInvCardSpecialCode.setBounds(new org.eclipse.swt.graphics.Rectangle(17,53,81,30));
	
			txtInvCardSpecialCode.setTextLimit(25);
			txtInvCardSpecialCode.setSize(new org.eclipse.swt.graphics.Point(89,18));
			txtInvCardSpecialCode.setBounds(new org.eclipse.swt.graphics.Rectangle(101,60,95,18));
	
			lblInvCardCode.setText("Inventory Code");
			lblInvCardCode.setSize(new org.eclipse.swt.graphics.Point(100,23));
			lblInvCardCode.setBounds(new org.eclipse.swt.graphics.Rectangle(211,21,100,23));
	
			txtInvCardCode.setTextLimit(25);
			txtInvCardCode.setSize(new org.eclipse.swt.graphics.Point(92,20));
			txtInvCardCode.setBounds(new org.eclipse.swt.graphics.Rectangle(308,23,98,20));
	
			lblInvCardDefinition.setText("Definition");
			lblInvCardDefinition.setSize(new org.eclipse.swt.graphics.Point(75,20));
			lblInvCardDefinition.setBounds(new org.eclipse.swt.graphics.Rectangle(18,90,75,20));
	
			txtInvCardDefinition.setTextLimit(250);
			txtInvCardDefinition.setSize(new org.eclipse.swt.graphics.Point(180,55));
			txtInvCardDefinition.setBounds(new org.eclipse.swt.graphics.Rectangle(102,95,203,71));
	
			btnInvCardGeneral.setText("Next");
			btnInvCardGeneral.setSize(new org.eclipse.swt.graphics.Point(60,30));
			btnInvCardGeneral.setBounds(new org.eclipse.swt.graphics.Rectangle(342,207,60,30));
			btnInvCardGeneral.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardGeneralMouseUp(evt);
				}
			});
			compInvCardGeneral.setLayout(null);
	
			tabInvCardDetails.setControl(compInvCardDetails);
			tabInvCardDetails.setText("Details");
	
			compInvCardDetails.setSize(new org.eclipse.swt.graphics.Point(587,408));
	
			GridData lblInvCardMinLData = new GridData();
			lblInvCardMinLData.verticalAlignment = GridData.CENTER;
			lblInvCardMinLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardMinLData.widthHint = 84;
			lblInvCardMinLData.heightHint = 15;
			lblInvCardMinLData.horizontalIndent = 0;
			lblInvCardMinLData.horizontalSpan = 1;
			lblInvCardMinLData.verticalSpan = 1;
			lblInvCardMinLData.grabExcessHorizontalSpace = false;
			lblInvCardMinLData.grabExcessVerticalSpace = false;
			lblInvCardMin.setLayoutData(lblInvCardMinLData);
			lblInvCardMin.setText("Minimum Amount");
			lblInvCardMin.setSize(new org.eclipse.swt.graphics.Point(84,15));
	
			GridData txtnumInvCardMinLData = new GridData();
			txtnumInvCardMinLData.verticalAlignment = GridData.CENTER;
			txtnumInvCardMinLData.horizontalAlignment = GridData.BEGINNING;
			txtnumInvCardMinLData.widthHint = 87;
			txtnumInvCardMinLData.heightHint = 14;
			txtnumInvCardMinLData.horizontalIndent = 0;
			txtnumInvCardMinLData.horizontalSpan = 1;
			txtnumInvCardMinLData.verticalSpan = 1;
			txtnumInvCardMinLData.grabExcessHorizontalSpace = false;
			txtnumInvCardMinLData.grabExcessVerticalSpace = false;
			txtnumInvCardMin.setLayoutData(txtnumInvCardMinLData);
			txtnumInvCardMin.setSize(new org.eclipse.swt.graphics.Point(87,14));
	
			GridData lblInvCardMaxLData = new GridData();
			lblInvCardMaxLData.verticalAlignment = GridData.CENTER;
			lblInvCardMaxLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardMaxLData.widthHint = 101;
			lblInvCardMaxLData.heightHint = 19;
			lblInvCardMaxLData.horizontalIndent = 0;
			lblInvCardMaxLData.horizontalSpan = 1;
			lblInvCardMaxLData.verticalSpan = 1;
			lblInvCardMaxLData.grabExcessHorizontalSpace = false;
			lblInvCardMaxLData.grabExcessVerticalSpace = false;
			lblInvCardMax.setLayoutData(lblInvCardMaxLData);
			lblInvCardMax.setText("Maximum Amount");
			lblInvCardMax.setSize(new org.eclipse.swt.graphics.Point(101,19));
	
			GridData txtnumInvCardMaxLData = new GridData();
			txtnumInvCardMaxLData.verticalAlignment = GridData.CENTER;
			txtnumInvCardMaxLData.horizontalAlignment = GridData.BEGINNING;
			txtnumInvCardMaxLData.widthHint = 28;
			txtnumInvCardMaxLData.heightHint = 16;
			txtnumInvCardMaxLData.horizontalIndent = 0;
			txtnumInvCardMaxLData.horizontalSpan = 1;
			txtnumInvCardMaxLData.verticalSpan = 1;
			txtnumInvCardMaxLData.grabExcessHorizontalSpace = false;
			txtnumInvCardMaxLData.grabExcessVerticalSpace = false;
			txtnumInvCardMax.setLayoutData(txtnumInvCardMaxLData);
			txtnumInvCardMax.setSize(new org.eclipse.swt.graphics.Point(28,16));
	
			GridData lblInvCardInAccLData = new GridData();
			lblInvCardInAccLData.verticalAlignment = GridData.CENTER;
			lblInvCardInAccLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardInAccLData.widthHint = -1;
			lblInvCardInAccLData.heightHint = -1;
			lblInvCardInAccLData.horizontalIndent = 0;
			lblInvCardInAccLData.horizontalSpan = 1;
			lblInvCardInAccLData.verticalSpan = 1;
			lblInvCardInAccLData.grabExcessHorizontalSpace = false;
			lblInvCardInAccLData.grabExcessVerticalSpace = false;
			lblInvCardInAcc.setLayoutData(lblInvCardInAccLData);
			lblInvCardInAcc.setText("In Accounting Code");
	
			GridData txtInvCardInAccLData = new GridData();
			txtInvCardInAccLData.verticalAlignment = GridData.CENTER;
			txtInvCardInAccLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardInAccLData.widthHint = -1;
			txtInvCardInAccLData.heightHint = -1;
			txtInvCardInAccLData.horizontalIndent = 0;
			txtInvCardInAccLData.horizontalSpan = 1;
			txtInvCardInAccLData.verticalSpan = 1;
			txtInvCardInAccLData.grabExcessHorizontalSpace = false;
			txtInvCardInAccLData.grabExcessVerticalSpace = false;
			txtInvCardInAcc.setLayoutData(txtInvCardInAccLData);
	
			GridData lblInvCardOutAccLData = new GridData();
			lblInvCardOutAccLData.verticalAlignment = GridData.CENTER;
			lblInvCardOutAccLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardOutAccLData.widthHint = -1;
			lblInvCardOutAccLData.heightHint = -1;
			lblInvCardOutAccLData.horizontalIndent = 0;
			lblInvCardOutAccLData.horizontalSpan = 1;
			lblInvCardOutAccLData.verticalSpan = 1;
			lblInvCardOutAccLData.grabExcessHorizontalSpace = false;
			lblInvCardOutAccLData.grabExcessVerticalSpace = false;
			lblInvCardOutAcc.setLayoutData(lblInvCardOutAccLData);
			lblInvCardOutAcc.setText("Out Accointing Code");
	
			GridData txtInvCardOutAccLData = new GridData();
			txtInvCardOutAccLData.verticalAlignment = GridData.CENTER;
			txtInvCardOutAccLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardOutAccLData.widthHint = -1;
			txtInvCardOutAccLData.heightHint = -1;
			txtInvCardOutAccLData.horizontalIndent = 0;
			txtInvCardOutAccLData.horizontalSpan = 1;
			txtInvCardOutAccLData.verticalSpan = 1;
			txtInvCardOutAccLData.grabExcessHorizontalSpace = false;
			txtInvCardOutAccLData.grabExcessVerticalSpace = false;
			txtInvCardOutAcc.setLayoutData(txtInvCardOutAccLData);
	
			GridData lblInvCardVatLData = new GridData();
			lblInvCardVatLData.verticalAlignment = GridData.CENTER;
			lblInvCardVatLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardVatLData.widthHint = -1;
			lblInvCardVatLData.heightHint = -1;
			lblInvCardVatLData.horizontalIndent = 0;
			lblInvCardVatLData.horizontalSpan = 1;
			lblInvCardVatLData.verticalSpan = 1;
			lblInvCardVatLData.grabExcessHorizontalSpace = false;
			lblInvCardVatLData.grabExcessVerticalSpace = false;
			lblInvCardVat.setLayoutData(lblInvCardVatLData);
			lblInvCardVat.setText("Vat");
	
			GridData txtInvCardVatLData = new GridData();
			txtInvCardVatLData.verticalAlignment = GridData.CENTER;
			txtInvCardVatLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardVatLData.widthHint = -1;
			txtInvCardVatLData.heightHint = -1;
			txtInvCardVatLData.horizontalIndent = 0;
			txtInvCardVatLData.horizontalSpan = 1;
			txtInvCardVatLData.verticalSpan = 1;
			txtInvCardVatLData.grabExcessHorizontalSpace = false;
			txtInvCardVatLData.grabExcessVerticalSpace = false;
			txtInvCardVat.setLayoutData(txtInvCardVatLData);
	
			GridData lblInvCardDiscountLData = new GridData();
			lblInvCardDiscountLData.verticalAlignment = GridData.CENTER;
			lblInvCardDiscountLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardDiscountLData.widthHint = -1;
			lblInvCardDiscountLData.heightHint = -1;
			lblInvCardDiscountLData.horizontalIndent = 0;
			lblInvCardDiscountLData.horizontalSpan = 1;
			lblInvCardDiscountLData.verticalSpan = 1;
			lblInvCardDiscountLData.grabExcessHorizontalSpace = false;
			lblInvCardDiscountLData.grabExcessVerticalSpace = false;
			lblInvCardDiscount.setLayoutData(lblInvCardDiscountLData);
			lblInvCardDiscount.setText("Discount");
	
			GridData txtInvCardDiscountLData = new GridData();
			txtInvCardDiscountLData.verticalAlignment = GridData.CENTER;
			txtInvCardDiscountLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardDiscountLData.widthHint = -1;
			txtInvCardDiscountLData.heightHint = -1;
			txtInvCardDiscountLData.horizontalIndent = 0;
			txtInvCardDiscountLData.horizontalSpan = 1;
			txtInvCardDiscountLData.verticalSpan = 1;
			txtInvCardDiscountLData.grabExcessHorizontalSpace = false;
			txtInvCardDiscountLData.grabExcessVerticalSpace = false;
			txtInvCardDiscount.setLayoutData(txtInvCardDiscountLData);
	
			GridData btnInvCardDetPreLData = new GridData();
			btnInvCardDetPreLData.verticalAlignment = GridData.CENTER;
			btnInvCardDetPreLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardDetPreLData.widthHint = -1;
			btnInvCardDetPreLData.heightHint = -1;
			btnInvCardDetPreLData.horizontalIndent = 0;
			btnInvCardDetPreLData.horizontalSpan = 3;
			btnInvCardDetPreLData.verticalSpan = 1;
			btnInvCardDetPreLData.grabExcessHorizontalSpace = false;
			btnInvCardDetPreLData.grabExcessVerticalSpace = false;
			btnInvCardDetPre.setLayoutData(btnInvCardDetPreLData);
			btnInvCardDetPre.setText("Previous");
	
			GridData btnInvCardNextLData = new GridData();
			btnInvCardNextLData.verticalAlignment = GridData.CENTER;
			btnInvCardNextLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardNextLData.widthHint = 35;
			btnInvCardNextLData.heightHint = 23;
			btnInvCardNextLData.horizontalIndent = 0;
			btnInvCardNextLData.horizontalSpan = 1;
			btnInvCardNextLData.verticalSpan = 1;
			btnInvCardNextLData.grabExcessHorizontalSpace = false;
			btnInvCardNextLData.grabExcessVerticalSpace = false;
			btnInvCardNext.setLayoutData(btnInvCardNextLData);
			btnInvCardNext.setText("Next");
			btnInvCardNext.setSize(new org.eclipse.swt.graphics.Point(35,23));
			btnInvCardNext.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardNextMouseUp(evt);
				}
			});
			GridLayout compInvCardDetailsLayout = new GridLayout(4, true);
			compInvCardDetails.setLayout(compInvCardDetailsLayout);
			compInvCardDetailsLayout.marginWidth = 5;
			compInvCardDetailsLayout.marginHeight = 5;
			compInvCardDetailsLayout.numColumns = 4;
			compInvCardDetailsLayout.makeColumnsEqualWidth = true;
			compInvCardDetailsLayout.horizontalSpacing = 5;
			compInvCardDetailsLayout.verticalSpacing = 5;
			compInvCardDetails.layout();
	
			tabInvCardUnits.setControl(compInvCardUnit);
			tabInvCardUnits.setText("Units");
	
			compInvCardUnit.setSize(new org.eclipse.swt.graphics.Point(587,408));
	
			GridData lblInvCardUnitLData = new GridData();
			lblInvCardUnitLData.verticalAlignment = GridData.CENTER;
			lblInvCardUnitLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardUnitLData.widthHint = -1;
			lblInvCardUnitLData.heightHint = -1;
			lblInvCardUnitLData.horizontalIndent = 0;
			lblInvCardUnitLData.horizontalSpan = 1;
			lblInvCardUnitLData.verticalSpan = 1;
			lblInvCardUnitLData.grabExcessHorizontalSpace = false;
			lblInvCardUnitLData.grabExcessVerticalSpace = false;
			lblInvCardUnit.setLayoutData(lblInvCardUnitLData);
			lblInvCardUnit.setText("Base Unit");
	
			GridData comboInvCardUnitsLData = new GridData();
			comboInvCardUnitsLData.verticalAlignment = GridData.CENTER;
			comboInvCardUnitsLData.horizontalAlignment = GridData.BEGINNING;
			comboInvCardUnitsLData.widthHint = 89;
			comboInvCardUnitsLData.heightHint = 16;
			comboInvCardUnitsLData.horizontalIndent = 0;
			comboInvCardUnitsLData.horizontalSpan = 3;
			comboInvCardUnitsLData.verticalSpan = 1;
			comboInvCardUnitsLData.grabExcessHorizontalSpace = false;
			comboInvCardUnitsLData.grabExcessVerticalSpace = false;
			comboInvCardUnits.setLayoutData(comboInvCardUnitsLData);
			comboInvCardUnits.setText("Choose Unit");
			comboInvCardUnits.setSize(new org.eclipse.swt.graphics.Point(89,16));
	
			GridData lblInvCardSecondaryUnitsLData = new GridData();
			lblInvCardSecondaryUnitsLData.verticalAlignment = GridData.BEGINNING;
			lblInvCardSecondaryUnitsLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardSecondaryUnitsLData.widthHint = -1;
			lblInvCardSecondaryUnitsLData.heightHint = -1;
			lblInvCardSecondaryUnitsLData.horizontalIndent = 0;
			lblInvCardSecondaryUnitsLData.horizontalSpan = 1;
			lblInvCardSecondaryUnitsLData.verticalSpan = 1;
			lblInvCardSecondaryUnitsLData.grabExcessHorizontalSpace = false;
			lblInvCardSecondaryUnitsLData.grabExcessVerticalSpace = false;
			lblInvCardSecondaryUnits.setLayoutData(lblInvCardSecondaryUnitsLData);
			lblInvCardSecondaryUnits.setText("Secondary Units");
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.BEGINNING;
			composite1LData.widthHint = 308;
			composite1LData.heightHint = 127;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(308,127));
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.CENTER;
			composite2LData.horizontalAlignment = GridData.BEGINNING;
			composite2LData.widthHint = 53;
			composite2LData.heightHint = 67;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = false;
			composite2.setLayoutData(composite2LData);
			composite2.setSize(new org.eclipse.swt.graphics.Point(53,67));
	
			GridData btnInvCardAddUnitLData = new GridData();
			btnInvCardAddUnitLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddUnitLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddUnitLData.widthHint = 30;
			btnInvCardAddUnitLData.heightHint = 24;
			btnInvCardAddUnitLData.horizontalIndent = 0;
			btnInvCardAddUnitLData.horizontalSpan = 1;
			btnInvCardAddUnitLData.verticalSpan = 1;
			btnInvCardAddUnitLData.grabExcessHorizontalSpace = false;
			btnInvCardAddUnitLData.grabExcessVerticalSpace = false;
			btnInvCardAddUnit.setLayoutData(btnInvCardAddUnitLData);
			final org.eclipse.swt.graphics.Image btnInvCardAddUnitimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/plus.gif"));
			btnInvCardAddUnitimage.setBackground(btnInvCardAddUnit.getBackground());
			btnInvCardAddUnit.setImage(btnInvCardAddUnitimage);
			btnInvCardAddUnit.setSize(new org.eclipse.swt.graphics.Point(30,24));
			btnInvCardAddUnit.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					btnInvCardAddUnitMouseDown(evt);
				}
			});
	
			GridData btnInvCardRemoveUnitLData = new GridData();
			btnInvCardRemoveUnitLData.verticalAlignment = GridData.CENTER;
			btnInvCardRemoveUnitLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardRemoveUnitLData.widthHint = 30;
			btnInvCardRemoveUnitLData.heightHint = 24;
			btnInvCardRemoveUnitLData.horizontalIndent = 0;
			btnInvCardRemoveUnitLData.horizontalSpan = 1;
			btnInvCardRemoveUnitLData.verticalSpan = 1;
			btnInvCardRemoveUnitLData.grabExcessHorizontalSpace = false;
			btnInvCardRemoveUnitLData.grabExcessVerticalSpace = false;
			btnInvCardRemoveUnit.setLayoutData(btnInvCardRemoveUnitLData);
			final org.eclipse.swt.graphics.Image btnInvCardRemoveUnitimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/minus.gif"));
			btnInvCardRemoveUnitimage.setBackground(btnInvCardRemoveUnit.getBackground());
			btnInvCardRemoveUnit.setImage(btnInvCardRemoveUnitimage);
			btnInvCardRemoveUnit.setSize(new org.eclipse.swt.graphics.Point(30,24));
			btnInvCardRemoveUnit.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					btnInvCardRemoveUnitMouseDown(evt);
				}
			});
			GridLayout composite2Layout = new GridLayout(1, true);
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 5;
			composite2Layout.marginHeight = 5;
			composite2Layout.numColumns = 1;
			composite2Layout.makeColumnsEqualWidth = true;
			composite2Layout.horizontalSpacing = 5;
			composite2Layout.verticalSpacing = 5;
			composite2.layout();
	
			GridData tableInvCardSecondaryUnitsLData = new GridData();
			tableInvCardSecondaryUnitsLData.verticalAlignment = GridData.CENTER;
			tableInvCardSecondaryUnitsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardSecondaryUnitsLData.widthHint = 227;
			tableInvCardSecondaryUnitsLData.heightHint = 84;
			tableInvCardSecondaryUnitsLData.horizontalIndent = 0;
			tableInvCardSecondaryUnitsLData.horizontalSpan = 1;
			tableInvCardSecondaryUnitsLData.verticalSpan = 1;
			tableInvCardSecondaryUnitsLData.grabExcessHorizontalSpace = false;
			tableInvCardSecondaryUnitsLData.grabExcessVerticalSpace = false;
			tableInvCardSecondaryUnits.setLayoutData(tableInvCardSecondaryUnitsLData);
			tableInvCardSecondaryUnits.setSize(new org.eclipse.swt.graphics.Point(227,84));
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
			GridLayout compInvCardUnitLayout = new GridLayout(4, true);
			compInvCardUnit.setLayout(compInvCardUnitLayout);
			compInvCardUnitLayout.marginWidth = 5;
			compInvCardUnitLayout.marginHeight = 5;
			compInvCardUnitLayout.numColumns = 4;
			compInvCardUnitLayout.makeColumnsEqualWidth = true;
			compInvCardUnitLayout.horizontalSpacing = 5;
			compInvCardUnitLayout.verticalSpacing = 5;
			compInvCardUnit.layout();
	
			tabInvCardPrices.setControl(composite3);
			tabInvCardPrices.setText("Prices");
	
	
			GridData composite4LData = new GridData();
			composite4LData.verticalAlignment = GridData.CENTER;
			composite4LData.horizontalAlignment = GridData.BEGINNING;
			composite4LData.widthHint = 308;
			composite4LData.heightHint = 127;
			composite4LData.horizontalIndent = 0;
			composite4LData.horizontalSpan = 1;
			composite4LData.verticalSpan = 1;
			composite4LData.grabExcessHorizontalSpace = false;
			composite4LData.grabExcessVerticalSpace = false;
			composite4.setLayoutData(composite4LData);
			composite4.setSize(new org.eclipse.swt.graphics.Point(308,127));
	
			GridData composite5LData = new GridData();
			composite5LData.verticalAlignment = GridData.CENTER;
			composite5LData.horizontalAlignment = GridData.BEGINNING;
			composite5LData.widthHint = 53;
			composite5LData.heightHint = 67;
			composite5LData.horizontalIndent = 0;
			composite5LData.horizontalSpan = 1;
			composite5LData.verticalSpan = 1;
			composite5LData.grabExcessHorizontalSpace = false;
			composite5LData.grabExcessVerticalSpace = false;
			composite5.setLayoutData(composite5LData);
			composite5.setSize(new org.eclipse.swt.graphics.Point(53,67));
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.CENTER;
			button1LData.horizontalAlignment = GridData.BEGINNING;
			button1LData.widthHint = 30;
			button1LData.heightHint = 24;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setImage(btnInvCardAddUnitimage);
			button1.setSize(new org.eclipse.swt.graphics.Point(30,24));
			button1.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					button1MouseDown(evt);
				}
			});
	
			GridData button2LData = new GridData();
			button2LData.verticalAlignment = GridData.CENTER;
			button2LData.horizontalAlignment = GridData.BEGINNING;
			button2LData.widthHint = 30;
			button2LData.heightHint = 24;
			button2LData.horizontalIndent = 0;
			button2LData.horizontalSpan = 1;
			button2LData.verticalSpan = 1;
			button2LData.grabExcessHorizontalSpace = false;
			button2LData.grabExcessVerticalSpace = false;
			button2.setLayoutData(button2LData);
			button2.setImage(btnInvCardRemoveUnitimage);
			button2.setSize(new org.eclipse.swt.graphics.Point(30,24));
			button2.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					button2MouseDown(evt);
				}
			});
			GridLayout composite5Layout = new GridLayout(1, true);
			composite5.setLayout(composite5Layout);
			composite5Layout.marginWidth = 5;
			composite5Layout.marginHeight = 5;
			composite5Layout.numColumns = 1;
			composite5Layout.makeColumnsEqualWidth = true;
			composite5Layout.horizontalSpacing = 5;
			composite5Layout.verticalSpacing = 5;
			composite5.layout();
	
			GridData tTable1LData = new GridData();
			tTable1LData.verticalAlignment = GridData.CENTER;
			tTable1LData.horizontalAlignment = GridData.BEGINNING;
			tTable1LData.widthHint = 227;
			tTable1LData.heightHint = 113;
			tTable1LData.horizontalIndent = 0;
			tTable1LData.horizontalSpan = 1;
			tTable1LData.verticalSpan = 1;
			tTable1LData.grabExcessHorizontalSpace = false;
			tTable1LData.grabExcessVerticalSpace = false;
			tTable1.setLayoutData(tTable1LData);
			tTable1.setSize(new org.eclipse.swt.graphics.Point(227,113));
			GridLayout composite4Layout = new GridLayout(2, true);
			composite4.setLayout(composite4Layout);
			composite4Layout.marginWidth = 5;
			composite4Layout.marginHeight = 5;
			composite4Layout.numColumns = 2;
			composite4Layout.makeColumnsEqualWidth = false;
			composite4Layout.horizontalSpacing = 5;
			composite4Layout.verticalSpacing = 5;
			composite4.layout();
			GridLayout composite3Layout = new GridLayout(1, true);
			composite3.setLayout(composite3Layout);
			composite3Layout.marginWidth = 5;
			composite3Layout.marginHeight = 5;
			composite3Layout.numColumns = 1;
			composite3Layout.makeColumnsEqualWidth = true;
			composite3Layout.horizontalSpacing = 5;
			composite3Layout.verticalSpacing = 5;
			composite3.layout();
	
			tabInvCardGroups.setControl(compInvCardAddGroups);
			tabInvCardGroups.setText("Groups");
	
	
			GridData compInvCardAddGroupsSelectionLData = new GridData();
			compInvCardAddGroupsSelectionLData.verticalAlignment = GridData.CENTER;
			compInvCardAddGroupsSelectionLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardAddGroupsSelectionLData.widthHint = 327;
			compInvCardAddGroupsSelectionLData.heightHint = 141;
			compInvCardAddGroupsSelectionLData.horizontalIndent = 0;
			compInvCardAddGroupsSelectionLData.horizontalSpan = 1;
			compInvCardAddGroupsSelectionLData.verticalSpan = 1;
			compInvCardAddGroupsSelectionLData.grabExcessHorizontalSpace = false;
			compInvCardAddGroupsSelectionLData.grabExcessVerticalSpace = false;
			compInvCardAddGroupsSelection.setLayoutData(compInvCardAddGroupsSelectionLData);
			compInvCardAddGroupsSelection.setSize(new org.eclipse.swt.graphics.Point(327,141));
	
			GridData tableInvCardAddGroupsAllGroupsLData = new GridData();
			tableInvCardAddGroupsAllGroupsLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddGroupsAllGroupsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddGroupsAllGroupsLData.widthHint = 104;
			tableInvCardAddGroupsAllGroupsLData.heightHint = 97;
			tableInvCardAddGroupsAllGroupsLData.horizontalIndent = 0;
			tableInvCardAddGroupsAllGroupsLData.horizontalSpan = 1;
			tableInvCardAddGroupsAllGroupsLData.verticalSpan = 1;
			tableInvCardAddGroupsAllGroupsLData.grabExcessHorizontalSpace = false;
			tableInvCardAddGroupsAllGroupsLData.grabExcessVerticalSpace = false;
			tableInvCardAddGroupsAllGroups.setLayoutData(tableInvCardAddGroupsAllGroupsLData);
			tableInvCardAddGroupsAllGroups.setHeaderVisible(true);
			tableInvCardAddGroupsAllGroups.setLinesVisible(true);
			tableInvCardAddGroupsAllGroups.setSize(new org.eclipse.swt.graphics.Point(104,97));
			GridLayout compInvCardAddGroupsSelectionLayout = new GridLayout(3, true);
			compInvCardAddGroupsSelection.setLayout(compInvCardAddGroupsSelectionLayout);
			compInvCardAddGroupsSelectionLayout.marginWidth = 5;
			compInvCardAddGroupsSelectionLayout.marginHeight = 5;
			compInvCardAddGroupsSelectionLayout.numColumns = 3;
			compInvCardAddGroupsSelectionLayout.makeColumnsEqualWidth = false;
			compInvCardAddGroupsSelectionLayout.horizontalSpacing = 5;
			compInvCardAddGroupsSelectionLayout.verticalSpacing = 5;
			compInvCardAddGroupsSelection.layout();
			GridLayout compInvCardAddGroupsLayout = new GridLayout(1, true);
			compInvCardAddGroups.setLayout(compInvCardAddGroupsLayout);
			compInvCardAddGroupsLayout.marginWidth = 5;
			compInvCardAddGroupsLayout.marginHeight = 5;
			compInvCardAddGroupsLayout.numColumns = 1;
			compInvCardAddGroupsLayout.makeColumnsEqualWidth = true;
			compInvCardAddGroupsLayout.horizontalSpacing = 5;
			compInvCardAddGroupsLayout.verticalSpacing = 5;
			compInvCardAddGroups.layout();
			tabfldInvCardAdd.setSelection(0);
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
					btnInvCardAddUnitimage.dispose();
					btnInvCardRemoveUnitimage.dispose();
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
		
	tableInvCardSecondaryUnits.setModel(new TTableComboModel());
	TTableModel model =(TTableModel)tableInvCardSecondaryUnits.getModel();	
   	tableInvCardSecondaryUnits.setHeaderColumn(new String[]{"Units","Units Factor"});
	model.setColumnWidth(0,100);
	model.setColumnWidth(1,100);
	model.setRowCount(1); 
    
    
	}
	
	
	public void save(){
	System.out.println("Save Button Pushed!");
		
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

	/** Auto-generated event handler method This is used to go to next tab. */
	protected void btnInvCardGeneralMouseUp(MouseEvent evt){
		int next =tabfldInvCardAdd.getSelectionIndex()+1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method This is used to go to next tab.*/
	protected void btnInvCardNextMouseUp(MouseEvent evt){
		int next =tabfldInvCardAdd.getSelectionIndex()+1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void button1MouseDown(MouseEvent evt){
		TTableModel model = (TTableModel)tableInvCardSecondaryUnits.getModel();
		model.setRowCount(model.getRowCount()+1);
		tableInvCardSecondaryUnits.redraw();
		
	}

	/** Auto-generated event handler method */
	protected void button2MouseDown(MouseEvent evt){
		
	if(tableInvCardSecondaryUnits.getRowSelection().length!=0){	
	 int selection =tableInvCardSecondaryUnits.getRowSelection()[0];
	 
	 TTableModel model = (TTableModel)tableInvCardSecondaryUnits.getModel();
	 	
		model.removeRow(selection);
		tableInvCardSecondaryUnits.redraw();
	}	
	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddGroupsRegisterGroupMouseDown(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddGroupsRemoveRegisteredGroupMouseDown(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddUnitMouseDown(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnInvCardRemoveUnitMouseDown(MouseEvent evt){
		//TODO add your handler code here
	}
}
