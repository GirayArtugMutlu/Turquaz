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

import org.eclipse.jface.viewers.CellEditor;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

import com.turquaz.accounting.ui.AccUIDialogInventoryCodeChoose;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.engine.ui.component.SecureComposite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.turquaz.engine.ui.component.NumericText;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.ui.comp.IPriceListViewer;
import com.turquaz.inventory.ui.comp.InvUIPrice;
import com.turquaz.inventory.ui.comp.InvUIPriceCellModifier;
import com.turquaz.inventory.ui.comp.InvUIPriceLabelProvider;
import com.turquaz.inventory.ui.comp.InvUIPriceList;


import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.ui.component.TextWithButton;
import org.eclipse.swt.widgets.Label;


/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a for-profit company or business) then you should purchase a license -
 * please visit www.cloudgarden.com for details.
 */
public class InvUICardAdd extends SecureComposite {
	private TableViewer tableInvPricesViewer;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnPriceType;
	private Button btnUpdateUnits;
	private Button btnInvCardAddNew;
	private Button btnInvCardGroupsPre;

	private Button btnInvCardPricesNext;

	private Button btnInvCardPricesPre;

	private Button btnInvCardUnitsNxt;

	private Button btnInvCardUnitsPre;

	public HashMap mapEditorsTableInvCardAddRegisteredUnits;

	private TableColumn tableColumnUnitCoefficient;

	private TableColumn tableColumn2;

	private Table tableInvCardAddRegisteredUnits;

	private Button btnRemoveRegisteredInvUnit;

	private Button btnRegisterInvUnit;

	private Composite compInvCardAddUnitsButtons;

	private TableColumn tableColumn1;

	private Table tableInvCardAddAllUnits;

	private Composite compInvCardAddSecondaryUnits;

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();

	private Button btnInvCardAddGroupsRemove;

	private Button btnInvCardAddGroupsRegister;

	private TableColumn tableColumnInvCardAddGroupAllGroups;

	private Table tableInvCardAddGroupsRegisteredGroups;

	private Composite compInvCardAddGroupsButtons;

	private TableColumn tableColumnRegisteredGroups;

	private TableColumn tableColumnGroups;

	private Table tableInvCardAddGroupsAllGroups;

	private Composite compInvCardAddGroupsButtonComp;

	private Composite compInvCardAddGroupsSelection;

	private Composite compInvCardAddGroups;

	private Table tableInvCardAddPrices;

	private Button btnInvCardAddPricesRemovePrice;

	private Button btnInvCardAddPricesAddPrice;

	private Composite compInvCardPricesAdd;

	private Composite compInvCardPricesTable;

	private Composite compInvCardPrices;

	private CLabel lblInvCardSecondaryUnits;

	private CTabItem tabInvCardGroups;

	private CTabItem tabInvCardPrices;

	private Button btnInvCardNext;

	private Button btnInvCardDetPre;

	private CCombo comboInvCardUnits;

	private CLabel lblInvCardUnit;

	private Composite compInvCardUnit;

	private NumericText txtInvCardDiscount;

	private CLabel lblInvCardDiscount;

	private NumericText txtInvCardVat;

	private CLabel lblInvCardVat;

	private TextWithButton txtInvCardOutAcc;

	private CLabel lblInvCardOutAcc;

	private TextWithButton txtInvCardInAcc;

	private CLabel lblInvCardInAcc;

	private NumericText txtnumInvCardMax;

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
	private List currencyList;
	public InvUIPriceList priceList;
	
	
	InvBLCardAdd blCardAdd = new InvBLCardAdd();
	EngBLCommon engCardAdd=new EngBLCommon();

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
			lblInvCardMin = new Label(compInvCardDetails,SWT.RIGHT);
			txtnumInvCardMin = new NumericText(compInvCardDetails,SWT.NULL);
			lblInvCardMax = new CLabel(compInvCardDetails,SWT.RIGHT);
			txtnumInvCardMax = new NumericText(compInvCardDetails,SWT.NULL);
			lblInvCardInAcc = new CLabel(compInvCardDetails,SWT.RIGHT);
			txtInvCardInAcc = new TextWithButton(compInvCardDetails,SWT.NULL);
			lblInvCardOutAcc = new CLabel(compInvCardDetails,SWT.RIGHT);
			txtInvCardOutAcc = new TextWithButton(compInvCardDetails,SWT.NULL);
			lblInvCardVat = new CLabel(compInvCardDetails,SWT.RIGHT);
			txtInvCardVat = new NumericText(compInvCardDetails,SWT.NULL);
			lblInvCardDiscount = new CLabel(compInvCardDetails,SWT.RIGHT);
			txtInvCardDiscount = new NumericText(compInvCardDetails,SWT.NULL);
			btnInvCardDetPre = new Button(compInvCardDetails,SWT.PUSH| SWT.CENTER);
			btnInvCardNext = new Button(compInvCardDetails,SWT.PUSH| SWT.CENTER);
			tabInvCardUnits = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardUnit = new Composite(tabfldInvCardAdd,SWT.NULL);
			lblInvCardUnit = new CLabel(compInvCardUnit,SWT.NULL);
			comboInvCardUnits = new CCombo(compInvCardUnit,SWT.FLAT| SWT.READ_ONLY);
			btnUpdateUnits = new Button(compInvCardUnit,SWT.PUSH| SWT.CENTER);
			lblInvCardSecondaryUnits = new CLabel(compInvCardUnit,SWT.NULL);
			compInvCardAddSecondaryUnits = new Composite(compInvCardUnit,SWT.NULL);
			tableInvCardAddAllUnits = new Table(compInvCardAddSecondaryUnits,SWT.SINGLE| SWT.V_SCROLL| SWT.BORDER);
			tableColumn1 = new TableColumn(tableInvCardAddAllUnits,SWT.NULL);
			compInvCardAddUnitsButtons = new Composite(compInvCardAddSecondaryUnits,SWT.NULL);
			btnRegisterInvUnit = new Button(compInvCardAddUnitsButtons,SWT.PUSH| SWT.CENTER);
			btnRemoveRegisteredInvUnit = new Button(compInvCardAddUnitsButtons,SWT.PUSH| SWT.CENTER);
			tableInvCardAddRegisteredUnits = new Table(compInvCardAddSecondaryUnits,SWT.V_SCROLL| SWT.BORDER);
			tableColumn2 = new TableColumn(tableInvCardAddRegisteredUnits,SWT.NULL);
			tableColumnUnitCoefficient = new TableColumn(tableInvCardAddRegisteredUnits,SWT.NULL);
			btnInvCardUnitsPre = new Button(compInvCardUnit,SWT.PUSH| SWT.CENTER);
			btnInvCardUnitsNxt = new Button(compInvCardUnit,SWT.PUSH| SWT.CENTER);
			tabInvCardPrices = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardPrices = new Composite(tabfldInvCardAdd,SWT.NULL);
			compInvCardPricesTable = new Composite(compInvCardPrices,SWT.NULL);
			compInvCardPricesAdd = new Composite(compInvCardPricesTable,SWT.NULL);
			btnInvCardAddPricesAddPrice = new Button(compInvCardPricesAdd,SWT.PUSH| SWT.CENTER);
			btnInvCardAddPricesRemovePrice = new Button(compInvCardPricesAdd,SWT.PUSH| SWT.CENTER);
			tableInvCardAddPrices = new Table(compInvCardPricesTable,SWT.FULL_SELECTION| SWT.V_SCROLL| SWT.BORDER);
			tableColumnPriceType = new TableColumn(tableInvCardAddPrices,SWT.NULL);
			tableColumnAmount = new TableColumn(tableInvCardAddPrices,SWT.NULL);
			tableColumnCurrency = new TableColumn(tableInvCardAddPrices,SWT.NULL);
			btnInvCardPricesPre = new Button(compInvCardPrices,SWT.PUSH| SWT.CENTER);
			btnInvCardPricesNext = new Button(compInvCardPrices,SWT.PUSH| SWT.CENTER);
			tabInvCardGroups = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			compInvCardAddGroups = new Composite(tabfldInvCardAdd,SWT.NULL);
			compInvCardAddGroupsSelection = new Composite(compInvCardAddGroups,SWT.NULL);
			tableInvCardAddGroupsAllGroups = new Table(compInvCardAddGroupsSelection,SWT.SINGLE| SWT.FULL_SELECTION| SWT.BORDER);
			tableColumnInvCardAddGroupAllGroups = new TableColumn(tableInvCardAddGroupsAllGroups,SWT.NULL);
			compInvCardAddGroupsButtons = new Composite(compInvCardAddGroupsSelection,SWT.NULL);
			btnInvCardAddGroupsRegister = new Button(compInvCardAddGroupsButtons,SWT.PUSH| SWT.CENTER);
			btnInvCardAddGroupsRemove = new Button(compInvCardAddGroupsButtons,SWT.PUSH| SWT.CENTER);
			btnInvCardAddNew = new Button(compInvCardAddGroupsButtons,SWT.PUSH| SWT.CENTER);
			tableInvCardAddGroupsRegisteredGroups = new Table(compInvCardAddGroupsSelection,SWT.FULL_SELECTION| SWT.BORDER);
			tableColumnRegisteredGroups = new TableColumn(tableInvCardAddGroupsRegisteredGroups,SWT.NULL);
			btnInvCardGroupsPre = new Button(compInvCardAddGroups,SWT.PUSH| SWT.CENTER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(639,430));
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
			tabfldInvCardAdd.setSize(new org.eclipse.swt.graphics.Point(641,421));
	
			tabInvCardGeneral.setControl(compInvCardGeneral);
			tabInvCardGeneral.setText("General Information");
	
			compInvCardGeneral.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData lblInvCardNameLData = new GridData();
			lblInvCardNameLData.verticalAlignment = GridData.CENTER;
			lblInvCardNameLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardNameLData.widthHint = 96;
			lblInvCardNameLData.heightHint = 20;
			lblInvCardNameLData.horizontalIndent = 0;
			lblInvCardNameLData.horizontalSpan = 1;
			lblInvCardNameLData.verticalSpan = 1;
			lblInvCardNameLData.grabExcessHorizontalSpace = false;
			lblInvCardNameLData.grabExcessVerticalSpace = false;
			lblInvCardName.setLayoutData(lblInvCardNameLData);
			lblInvCardName.setText("Inventory Name");
			lblInvCardName.setSize(new org.eclipse.swt.graphics.Point(96,20));
	
			GridData txtInvCardNameLData = new GridData();
			txtInvCardNameLData.verticalAlignment = GridData.CENTER;
			txtInvCardNameLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardNameLData.widthHint = 138;
			txtInvCardNameLData.heightHint = 16;
			txtInvCardNameLData.horizontalIndent = 0;
			txtInvCardNameLData.horizontalSpan = 1;
			txtInvCardNameLData.verticalSpan = 1;
			txtInvCardNameLData.grabExcessHorizontalSpace = false;
			txtInvCardNameLData.grabExcessVerticalSpace = false;
			txtInvCardName.setLayoutData(txtInvCardNameLData);
			txtInvCardName.setTextLimit(50);
			txtInvCardName.setSize(new org.eclipse.swt.graphics.Point(138,16));
	
			GridData lblInvCardSpecialCodeLData = new GridData();
			lblInvCardSpecialCodeLData.verticalAlignment = GridData.CENTER;
			lblInvCardSpecialCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardSpecialCodeLData.widthHint = 73;
			lblInvCardSpecialCodeLData.heightHint = 18;
			lblInvCardSpecialCodeLData.horizontalIndent = 0;
			lblInvCardSpecialCodeLData.horizontalSpan = 1;
			lblInvCardSpecialCodeLData.verticalSpan = 1;
			lblInvCardSpecialCodeLData.grabExcessHorizontalSpace = false;
			lblInvCardSpecialCodeLData.grabExcessVerticalSpace = false;
			lblInvCardSpecialCode.setLayoutData(lblInvCardSpecialCodeLData);
			lblInvCardSpecialCode.setText("Special Code");
			lblInvCardSpecialCode.setSize(new org.eclipse.swt.graphics.Point(73,18));
	
			GridData txtInvCardSpecialCodeLData = new GridData();
			txtInvCardSpecialCodeLData.verticalAlignment = GridData.CENTER;
			txtInvCardSpecialCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardSpecialCodeLData.widthHint = 89;
			txtInvCardSpecialCodeLData.heightHint = 18;
			txtInvCardSpecialCodeLData.horizontalIndent = 0;
			txtInvCardSpecialCodeLData.horizontalSpan = 1;
			txtInvCardSpecialCodeLData.verticalSpan = 1;
			txtInvCardSpecialCodeLData.grabExcessHorizontalSpace = false;
			txtInvCardSpecialCodeLData.grabExcessVerticalSpace = false;
			txtInvCardSpecialCode.setLayoutData(txtInvCardSpecialCodeLData);
			txtInvCardSpecialCode.setTextLimit(25);
			txtInvCardSpecialCode.setSize(new org.eclipse.swt.graphics.Point(89,18));
	
			GridData lblInvCardCodeLData = new GridData();
			lblInvCardCodeLData.verticalAlignment = GridData.CENTER;
			lblInvCardCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardCodeLData.widthHint = 100;
			lblInvCardCodeLData.heightHint = 23;
			lblInvCardCodeLData.horizontalIndent = 0;
			lblInvCardCodeLData.horizontalSpan = 1;
			lblInvCardCodeLData.verticalSpan = 1;
			lblInvCardCodeLData.grabExcessHorizontalSpace = false;
			lblInvCardCodeLData.grabExcessVerticalSpace = false;
			lblInvCardCode.setLayoutData(lblInvCardCodeLData);
			lblInvCardCode.setText("Inventory Code");
			lblInvCardCode.setSize(new org.eclipse.swt.graphics.Point(100,23));
	
			GridData txtInvCardCodeLData = new GridData();
			txtInvCardCodeLData.verticalAlignment = GridData.CENTER;
			txtInvCardCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardCodeLData.widthHint = 136;
			txtInvCardCodeLData.heightHint = 15;
			txtInvCardCodeLData.horizontalIndent = 0;
			txtInvCardCodeLData.horizontalSpan = 3;
			txtInvCardCodeLData.verticalSpan = 1;
			txtInvCardCodeLData.grabExcessHorizontalSpace = false;
			txtInvCardCodeLData.grabExcessVerticalSpace = false;
			txtInvCardCode.setLayoutData(txtInvCardCodeLData);
			txtInvCardCode.setTextLimit(25);
			txtInvCardCode.setSize(new org.eclipse.swt.graphics.Point(136,15));
	
			GridData lblInvCardDefinitionLData = new GridData();
			lblInvCardDefinitionLData.verticalAlignment = GridData.CENTER;
			lblInvCardDefinitionLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardDefinitionLData.widthHint = 76;
			lblInvCardDefinitionLData.heightHint = 17;
			lblInvCardDefinitionLData.horizontalIndent = 0;
			lblInvCardDefinitionLData.horizontalSpan = 1;
			lblInvCardDefinitionLData.verticalSpan = 1;
			lblInvCardDefinitionLData.grabExcessHorizontalSpace = false;
			lblInvCardDefinitionLData.grabExcessVerticalSpace = false;
			lblInvCardDefinition.setLayoutData(lblInvCardDefinitionLData);
			lblInvCardDefinition.setText("Definition");
			lblInvCardDefinition.setSize(new org.eclipse.swt.graphics.Point(76,17));
	
			GridData txtInvCardDefinitionLData = new GridData();
			txtInvCardDefinitionLData.verticalAlignment = GridData.CENTER;
			txtInvCardDefinitionLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardDefinitionLData.widthHint = 180;
			txtInvCardDefinitionLData.heightHint = 55;
			txtInvCardDefinitionLData.horizontalIndent = 0;
			txtInvCardDefinitionLData.horizontalSpan = 3;
			txtInvCardDefinitionLData.verticalSpan = 1;
			txtInvCardDefinitionLData.grabExcessHorizontalSpace = false;
			txtInvCardDefinitionLData.grabExcessVerticalSpace = false;
			txtInvCardDefinition.setLayoutData(txtInvCardDefinitionLData);
			txtInvCardDefinition.setTextLimit(250);
			txtInvCardDefinition.setSize(new org.eclipse.swt.graphics.Point(180,55));
	
			GridData btnInvCardGeneralLData = new GridData();
			btnInvCardGeneralLData.verticalAlignment = GridData.END;
			btnInvCardGeneralLData.horizontalAlignment = GridData.END;
			btnInvCardGeneralLData.widthHint = 67;
			btnInvCardGeneralLData.heightHint = 23;
			btnInvCardGeneralLData.horizontalIndent = 0;
			btnInvCardGeneralLData.horizontalSpan = 4;
			btnInvCardGeneralLData.verticalSpan = 2;
			btnInvCardGeneralLData.grabExcessHorizontalSpace = false;
			btnInvCardGeneralLData.grabExcessVerticalSpace = false;
			btnInvCardGeneral.setLayoutData(btnInvCardGeneralLData);
			btnInvCardGeneral.setText("Next >>");
			btnInvCardGeneral.setSize(new org.eclipse.swt.graphics.Point(67,23));
			btnInvCardGeneral.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardGeneralMouseUp(evt);
				}
			});
			GridLayout compInvCardGeneralLayout = new GridLayout(4, true);
			compInvCardGeneral.setLayout(compInvCardGeneralLayout);
			compInvCardGeneralLayout.marginWidth = 5;
			compInvCardGeneralLayout.marginHeight = 5;
			compInvCardGeneralLayout.numColumns = 4;
			compInvCardGeneralLayout.makeColumnsEqualWidth = false;
			compInvCardGeneralLayout.horizontalSpacing = 5;
			compInvCardGeneralLayout.verticalSpacing = 5;
			compInvCardGeneral.layout();
	
			tabInvCardDetails.setControl(compInvCardDetails);
			tabInvCardDetails.setText("Details");
	
			compInvCardDetails.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData lblInvCardMinLData = new GridData();
			lblInvCardMinLData.verticalAlignment = GridData.CENTER;
			lblInvCardMinLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardMinLData.widthHint = 115;
			lblInvCardMinLData.heightHint = 16;
			lblInvCardMinLData.horizontalIndent = 0;
			lblInvCardMinLData.horizontalSpan = 1;
			lblInvCardMinLData.verticalSpan = 1;
			lblInvCardMinLData.grabExcessHorizontalSpace = false;
			lblInvCardMinLData.grabExcessVerticalSpace = false;
			lblInvCardMin.setLayoutData(lblInvCardMinLData);
			lblInvCardMin.setText("Minimum Amount");
			lblInvCardMin.setSize(new org.eclipse.swt.graphics.Point(115,16));
	
			GridData txtnumInvCardMinLData = new GridData();
			txtnumInvCardMinLData.verticalAlignment = GridData.CENTER;
			txtnumInvCardMinLData.horizontalAlignment = GridData.BEGINNING;
			txtnumInvCardMinLData.widthHint = 91;
			txtnumInvCardMinLData.heightHint = 18;
			txtnumInvCardMinLData.horizontalIndent = 0;
			txtnumInvCardMinLData.horizontalSpan = 1;
			txtnumInvCardMinLData.verticalSpan = 1;
			txtnumInvCardMinLData.grabExcessHorizontalSpace = false;
			txtnumInvCardMinLData.grabExcessVerticalSpace = false;
			txtnumInvCardMin.setLayoutData(txtnumInvCardMinLData);
			txtnumInvCardMin.setSize(new org.eclipse.swt.graphics.Point(91,18));
	
			GridData lblInvCardMaxLData = new GridData();
			lblInvCardMaxLData.verticalAlignment = GridData.CENTER;
			lblInvCardMaxLData.horizontalAlignment = GridData.END;
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
			txtnumInvCardMaxLData.widthHint = 104;
			txtnumInvCardMaxLData.heightHint = 18;
			txtnumInvCardMaxLData.horizontalIndent = 0;
			txtnumInvCardMaxLData.horizontalSpan = 1;
			txtnumInvCardMaxLData.verticalSpan = 1;
			txtnumInvCardMaxLData.grabExcessHorizontalSpace = false;
			txtnumInvCardMaxLData.grabExcessVerticalSpace = false;
			txtnumInvCardMax.setLayoutData(txtnumInvCardMaxLData);
			txtnumInvCardMax.setSize(new org.eclipse.swt.graphics.Point(104,18));
	
			GridData lblInvCardInAccLData = new GridData();
			lblInvCardInAccLData.verticalAlignment = GridData.CENTER;
			lblInvCardInAccLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardInAccLData.widthHint = 115;
			lblInvCardInAccLData.heightHint = 16;
			lblInvCardInAccLData.horizontalIndent = 0;
			lblInvCardInAccLData.horizontalSpan = 1;
			lblInvCardInAccLData.verticalSpan = 1;
			lblInvCardInAccLData.grabExcessHorizontalSpace = false;
			lblInvCardInAccLData.grabExcessVerticalSpace = false;
			lblInvCardInAcc.setLayoutData(lblInvCardInAccLData);
			lblInvCardInAcc.setText("In Accounting Code");
			lblInvCardInAcc.setSize(new org.eclipse.swt.graphics.Point(115,16));
	
			GridData txtInvCardInAccLData = new GridData();
			txtInvCardInAccLData.verticalAlignment = GridData.CENTER;
			txtInvCardInAccLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardInAccLData.widthHint = 139;
			txtInvCardInAccLData.heightHint = 16;
			txtInvCardInAccLData.horizontalIndent = 0;
			txtInvCardInAccLData.horizontalSpan = 1;
			txtInvCardInAccLData.verticalSpan = 1;
			txtInvCardInAccLData.grabExcessHorizontalSpace = false;
			txtInvCardInAccLData.grabExcessVerticalSpace = false;
			txtInvCardInAcc.setLayoutData(txtInvCardInAccLData);
			txtInvCardInAcc.setSize(new org.eclipse.swt.graphics.Point(139,16));
			txtInvCardInAcc.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					txtInvCardInAccMouseUp(evt);
				}
			});
			txtInvCardInAcc.layout();
	
			GridData lblInvCardOutAccLData = new GridData();
			lblInvCardOutAccLData.verticalAlignment = GridData.CENTER;
			lblInvCardOutAccLData.horizontalAlignment = GridData.END;
			lblInvCardOutAccLData.widthHint = 104;
			lblInvCardOutAccLData.heightHint = 19;
			lblInvCardOutAccLData.horizontalIndent = 0;
			lblInvCardOutAccLData.horizontalSpan = 1;
			lblInvCardOutAccLData.verticalSpan = 1;
			lblInvCardOutAccLData.grabExcessHorizontalSpace = false;
			lblInvCardOutAccLData.grabExcessVerticalSpace = false;
			lblInvCardOutAcc.setLayoutData(lblInvCardOutAccLData);
			lblInvCardOutAcc.setText("Out Accointing Code");
			lblInvCardOutAcc.setSize(new org.eclipse.swt.graphics.Point(104,19));
	
			GridData txtInvCardOutAccLData = new GridData();
			txtInvCardOutAccLData.verticalAlignment = GridData.CENTER;
			txtInvCardOutAccLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardOutAccLData.widthHint = 163;
			txtInvCardOutAccLData.heightHint = 17;
			txtInvCardOutAccLData.horizontalIndent = 0;
			txtInvCardOutAccLData.horizontalSpan = 1;
			txtInvCardOutAccLData.verticalSpan = 1;
			txtInvCardOutAccLData.grabExcessHorizontalSpace = false;
			txtInvCardOutAccLData.grabExcessVerticalSpace = false;
			txtInvCardOutAcc.setLayoutData(txtInvCardOutAccLData);
			txtInvCardOutAcc.setSize(new org.eclipse.swt.graphics.Point(163,17));
			txtInvCardOutAcc.setEnabled(true);
			txtInvCardOutAcc.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					txtInvCardOutAccMouseUp(evt);
				}
			});
			txtInvCardOutAcc.layout();
	
			GridData lblInvCardVatLData = new GridData();
			lblInvCardVatLData.verticalAlignment = GridData.CENTER;
			lblInvCardVatLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardVatLData.widthHint = 115;
			lblInvCardVatLData.heightHint = 16;
			lblInvCardVatLData.horizontalIndent = 0;
			lblInvCardVatLData.horizontalSpan = 1;
			lblInvCardVatLData.verticalSpan = 1;
			lblInvCardVatLData.grabExcessHorizontalSpace = false;
			lblInvCardVatLData.grabExcessVerticalSpace = false;
			lblInvCardVat.setLayoutData(lblInvCardVatLData);
			lblInvCardVat.setText("Vat");
			lblInvCardVat.setSize(new org.eclipse.swt.graphics.Point(115,16));
	
			GridData txtInvCardVatLData = new GridData();
			txtInvCardVatLData.verticalAlignment = GridData.CENTER;
			txtInvCardVatLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardVatLData.widthHint = 61;
			txtInvCardVatLData.heightHint = 17;
			txtInvCardVatLData.horizontalIndent = 0;
			txtInvCardVatLData.horizontalSpan = 1;
			txtInvCardVatLData.verticalSpan = 1;
			txtInvCardVatLData.grabExcessHorizontalSpace = false;
			txtInvCardVatLData.grabExcessVerticalSpace = false;
			txtInvCardVat.setLayoutData(txtInvCardVatLData);
			txtInvCardVat.setSize(new org.eclipse.swt.graphics.Point(61,17));
	
			GridData lblInvCardDiscountLData = new GridData();
			lblInvCardDiscountLData.verticalAlignment = GridData.CENTER;
			lblInvCardDiscountLData.horizontalAlignment = GridData.END;
			lblInvCardDiscountLData.widthHint = 47;
			lblInvCardDiscountLData.heightHint = 19;
			lblInvCardDiscountLData.horizontalIndent = 0;
			lblInvCardDiscountLData.horizontalSpan = 1;
			lblInvCardDiscountLData.verticalSpan = 1;
			lblInvCardDiscountLData.grabExcessHorizontalSpace = false;
			lblInvCardDiscountLData.grabExcessVerticalSpace = false;
			lblInvCardDiscount.setLayoutData(lblInvCardDiscountLData);
			lblInvCardDiscount.setText("Discount");
			lblInvCardDiscount.setSize(new org.eclipse.swt.graphics.Point(47,19));
	
			GridData txtInvCardDiscountLData = new GridData();
			txtInvCardDiscountLData.verticalAlignment = GridData.CENTER;
			txtInvCardDiscountLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCardDiscountLData.widthHint = 104;
			txtInvCardDiscountLData.heightHint = 18;
			txtInvCardDiscountLData.horizontalIndent = 0;
			txtInvCardDiscountLData.horizontalSpan = 1;
			txtInvCardDiscountLData.verticalSpan = 1;
			txtInvCardDiscountLData.grabExcessHorizontalSpace = false;
			txtInvCardDiscountLData.grabExcessVerticalSpace = false;
			txtInvCardDiscount.setLayoutData(txtInvCardDiscountLData);
			txtInvCardDiscount.setSize(new org.eclipse.swt.graphics.Point(104,18));
	
			GridData btnInvCardDetPreLData = new GridData();
			btnInvCardDetPreLData.verticalAlignment = GridData.CENTER;
			btnInvCardDetPreLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardDetPreLData.widthHint = 82;
			btnInvCardDetPreLData.heightHint = 25;
			btnInvCardDetPreLData.horizontalIndent = 0;
			btnInvCardDetPreLData.horizontalSpan = 3;
			btnInvCardDetPreLData.verticalSpan = 10;
			btnInvCardDetPreLData.grabExcessHorizontalSpace = false;
			btnInvCardDetPreLData.grabExcessVerticalSpace = false;
			btnInvCardDetPre.setLayoutData(btnInvCardDetPreLData);
			btnInvCardDetPre.setText("<< Previous");
			btnInvCardDetPre.setSize(new org.eclipse.swt.graphics.Point(82,25));
			btnInvCardDetPre.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardDetPreMouseUp(evt);
				}
			});
	
			GridData btnInvCardNextLData = new GridData();
			btnInvCardNextLData.verticalAlignment = GridData.CENTER;
			btnInvCardNextLData.horizontalAlignment = GridData.END;
			btnInvCardNextLData.widthHint = 61;
			btnInvCardNextLData.heightHint = 25;
			btnInvCardNextLData.horizontalIndent = 0;
			btnInvCardNextLData.horizontalSpan = 1;
			btnInvCardNextLData.verticalSpan = 10;
			btnInvCardNextLData.grabExcessHorizontalSpace = false;
			btnInvCardNextLData.grabExcessVerticalSpace = false;
			btnInvCardNext.setLayoutData(btnInvCardNextLData);
			btnInvCardNext.setText("Next >>");
			btnInvCardNext.setSize(new org.eclipse.swt.graphics.Point(61,25));
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
			compInvCardDetailsLayout.makeColumnsEqualWidth = false;
			compInvCardDetailsLayout.horizontalSpacing = 5;
			compInvCardDetailsLayout.verticalSpacing = 5;
			compInvCardDetails.layout();
	
			tabInvCardUnits.setControl(compInvCardUnit);
			tabInvCardUnits.setText("Units");
	
			compInvCardUnit.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData lblInvCardUnitLData = new GridData();
			lblInvCardUnitLData.verticalAlignment = GridData.CENTER;
			lblInvCardUnitLData.horizontalAlignment = GridData.BEGINNING;
			lblInvCardUnitLData.widthHint = 51;
			lblInvCardUnitLData.heightHint = 19;
			lblInvCardUnitLData.horizontalIndent = 0;
			lblInvCardUnitLData.horizontalSpan = 1;
			lblInvCardUnitLData.verticalSpan = 1;
			lblInvCardUnitLData.grabExcessHorizontalSpace = false;
			lblInvCardUnitLData.grabExcessVerticalSpace = false;
			lblInvCardUnit.setLayoutData(lblInvCardUnitLData);
			lblInvCardUnit.setText("Base Unit");
			lblInvCardUnit.setSize(new org.eclipse.swt.graphics.Point(51,19));
	
			GridData comboInvCardUnitsLData = new GridData();
			comboInvCardUnitsLData.verticalAlignment = GridData.CENTER;
			comboInvCardUnitsLData.horizontalAlignment = GridData.BEGINNING;
			comboInvCardUnitsLData.widthHint = 104;
			comboInvCardUnitsLData.heightHint = 29;
			comboInvCardUnitsLData.horizontalIndent = 0;
			comboInvCardUnitsLData.horizontalSpan = 1;
			comboInvCardUnitsLData.verticalSpan = 1;
			comboInvCardUnitsLData.grabExcessHorizontalSpace = false;
			comboInvCardUnitsLData.grabExcessVerticalSpace = false;
			comboInvCardUnits.setLayoutData(comboInvCardUnitsLData);
			comboInvCardUnits.setText("Choose Unit");
			final Color comboInvCardUnitsbackground = new Color(Display.getDefault(),255,255,255);
			comboInvCardUnits.setBackground(comboInvCardUnitsbackground);
			comboInvCardUnits.setSize(new org.eclipse.swt.graphics.Point(104,29));
	
			GridData btnUpdateUnitsLData = new GridData();
			btnUpdateUnitsLData.verticalAlignment = GridData.CENTER;
			btnUpdateUnitsLData.horizontalAlignment = GridData.BEGINNING;
			btnUpdateUnitsLData.widthHint = -1;
			btnUpdateUnitsLData.heightHint = -1;
			btnUpdateUnitsLData.horizontalIndent = 0;
			btnUpdateUnitsLData.horizontalSpan = 2;
			btnUpdateUnitsLData.verticalSpan = 1;
			btnUpdateUnitsLData.grabExcessHorizontalSpace = false;
			btnUpdateUnitsLData.grabExcessVerticalSpace = false;
			btnUpdateUnits.setLayoutData(btnUpdateUnitsLData);
			btnUpdateUnits.setText("Update Units");
			btnUpdateUnits.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnUpdateUnitsMouseUp(evt);
				}
			});
	
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
	
			GridData compInvCardAddSecondaryUnitsLData = new GridData();
			compInvCardAddSecondaryUnitsLData.verticalAlignment = GridData.CENTER;
			compInvCardAddSecondaryUnitsLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardAddSecondaryUnitsLData.widthHint = 422;
			compInvCardAddSecondaryUnitsLData.heightHint = 139;
			compInvCardAddSecondaryUnitsLData.horizontalIndent = 0;
			compInvCardAddSecondaryUnitsLData.horizontalSpan = 1;
			compInvCardAddSecondaryUnitsLData.verticalSpan = 1;
			compInvCardAddSecondaryUnitsLData.grabExcessHorizontalSpace = false;
			compInvCardAddSecondaryUnitsLData.grabExcessVerticalSpace = false;
			compInvCardAddSecondaryUnits.setLayoutData(compInvCardAddSecondaryUnitsLData);
			compInvCardAddSecondaryUnits.setSize(new org.eclipse.swt.graphics.Point(422,139));
	
			GridData tableInvCardAddAllUnitsLData = new GridData();
			tableInvCardAddAllUnitsLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddAllUnitsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddAllUnitsLData.widthHint = 116;
			tableInvCardAddAllUnitsLData.heightHint = 100;
			tableInvCardAddAllUnitsLData.horizontalIndent = 0;
			tableInvCardAddAllUnitsLData.horizontalSpan = 1;
			tableInvCardAddAllUnitsLData.verticalSpan = 1;
			tableInvCardAddAllUnitsLData.grabExcessHorizontalSpace = false;
			tableInvCardAddAllUnitsLData.grabExcessVerticalSpace = false;
			tableInvCardAddAllUnits.setLayoutData(tableInvCardAddAllUnitsLData);
			tableInvCardAddAllUnits.setHeaderVisible(true);
			tableInvCardAddAllUnits.setLinesVisible(true);
			tableInvCardAddAllUnits.setSize(new org.eclipse.swt.graphics.Point(116,100));
	
			tableColumn1.setText("Units");
			tableColumn1.setWidth(112);
	
			GridData compInvCardAddUnitsButtonsLData = new GridData();
			compInvCardAddUnitsButtonsLData.verticalAlignment = GridData.CENTER;
			compInvCardAddUnitsButtonsLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardAddUnitsButtonsLData.widthHint = 64;
			compInvCardAddUnitsButtonsLData.heightHint = 64;
			compInvCardAddUnitsButtonsLData.horizontalIndent = 0;
			compInvCardAddUnitsButtonsLData.horizontalSpan = 1;
			compInvCardAddUnitsButtonsLData.verticalSpan = 1;
			compInvCardAddUnitsButtonsLData.grabExcessHorizontalSpace = false;
			compInvCardAddUnitsButtonsLData.grabExcessVerticalSpace = false;
			compInvCardAddUnitsButtons.setLayoutData(compInvCardAddUnitsButtonsLData);
			compInvCardAddUnitsButtons.setSize(new org.eclipse.swt.graphics.Point(64,64));
	
			GridData btnRegisterInvUnitLData = new GridData();
			btnRegisterInvUnitLData.verticalAlignment = GridData.CENTER;
			btnRegisterInvUnitLData.horizontalAlignment = GridData.CENTER;
			btnRegisterInvUnitLData.widthHint = 39;
			btnRegisterInvUnitLData.heightHint = 19;
			btnRegisterInvUnitLData.horizontalIndent = 0;
			btnRegisterInvUnitLData.horizontalSpan = 1;
			btnRegisterInvUnitLData.verticalSpan = 1;
			btnRegisterInvUnitLData.grabExcessHorizontalSpace = false;
			btnRegisterInvUnitLData.grabExcessVerticalSpace = false;
			btnRegisterInvUnit.setLayoutData(btnRegisterInvUnitLData);
			btnRegisterInvUnit.setText(">>");
			btnRegisterInvUnit.setSize(new org.eclipse.swt.graphics.Point(39,19));
			btnRegisterInvUnit.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnRegisterInvUnitMouseUp(evt);
				}
			});
	
			GridData btnRemoveRegisteredInvUnitLData = new GridData();
			btnRemoveRegisteredInvUnitLData.verticalAlignment = GridData.CENTER;
			btnRemoveRegisteredInvUnitLData.horizontalAlignment = GridData.CENTER;
			btnRemoveRegisteredInvUnitLData.widthHint = 39;
			btnRemoveRegisteredInvUnitLData.heightHint = 19;
			btnRemoveRegisteredInvUnitLData.horizontalIndent = 0;
			btnRemoveRegisteredInvUnitLData.horizontalSpan = 1;
			btnRemoveRegisteredInvUnitLData.verticalSpan = 1;
			btnRemoveRegisteredInvUnitLData.grabExcessHorizontalSpace = false;
			btnRemoveRegisteredInvUnitLData.grabExcessVerticalSpace = false;
			btnRemoveRegisteredInvUnit.setLayoutData(btnRemoveRegisteredInvUnitLData);
			btnRemoveRegisteredInvUnit.setText("<<");
			btnRemoveRegisteredInvUnit.setSize(new org.eclipse.swt.graphics.Point(39,19));
			btnRemoveRegisteredInvUnit.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnRemoveRegisteredInvUnitMouseUp(evt);
				}
			});
			GridLayout compInvCardAddUnitsButtonsLayout = new GridLayout(1, true);
			compInvCardAddUnitsButtons.setLayout(compInvCardAddUnitsButtonsLayout);
			compInvCardAddUnitsButtonsLayout.marginWidth = 5;
			compInvCardAddUnitsButtonsLayout.marginHeight = 5;
			compInvCardAddUnitsButtonsLayout.numColumns = 1;
			compInvCardAddUnitsButtonsLayout.makeColumnsEqualWidth = true;
			compInvCardAddUnitsButtonsLayout.horizontalSpacing = 5;
			compInvCardAddUnitsButtonsLayout.verticalSpacing = 5;
			compInvCardAddUnitsButtons.layout();
	
			GridData tableInvCardAddRegisteredUnitsLData = new GridData();
			tableInvCardAddRegisteredUnitsLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddRegisteredUnitsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddRegisteredUnitsLData.widthHint = 160;
			tableInvCardAddRegisteredUnitsLData.heightHint = 101;
			tableInvCardAddRegisteredUnitsLData.horizontalIndent = 0;
			tableInvCardAddRegisteredUnitsLData.horizontalSpan = 1;
			tableInvCardAddRegisteredUnitsLData.verticalSpan = 1;
			tableInvCardAddRegisteredUnitsLData.grabExcessHorizontalSpace = false;
			tableInvCardAddRegisteredUnitsLData.grabExcessVerticalSpace = false;
			tableInvCardAddRegisteredUnits.setLayoutData(tableInvCardAddRegisteredUnitsLData);
			tableInvCardAddRegisteredUnits.setHeaderVisible(true);
			tableInvCardAddRegisteredUnits.setLinesVisible(true);
			tableInvCardAddRegisteredUnits.setSize(new org.eclipse.swt.graphics.Point(160,101));
	
			tableColumn2.setText("Registered Units");
			tableColumn2.setWidth(110);
	
			tableColumnUnitCoefficient.setText("Factor");
			tableColumnUnitCoefficient.setWidth(50);
			GridLayout compInvCardAddSecondaryUnitsLayout = new GridLayout(3, true);
			compInvCardAddSecondaryUnits.setLayout(compInvCardAddSecondaryUnitsLayout);
			compInvCardAddSecondaryUnitsLayout.marginWidth = 0;
			compInvCardAddSecondaryUnitsLayout.marginHeight = 5;
			compInvCardAddSecondaryUnitsLayout.numColumns = 3;
			compInvCardAddSecondaryUnitsLayout.makeColumnsEqualWidth = false;
			compInvCardAddSecondaryUnitsLayout.horizontalSpacing = 5;
			compInvCardAddSecondaryUnitsLayout.verticalSpacing = 5;
			compInvCardAddSecondaryUnits.layout();
	
			GridData btnInvCardUnitsPreLData = new GridData();
			btnInvCardUnitsPreLData.verticalAlignment = GridData.CENTER;
			btnInvCardUnitsPreLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardUnitsPreLData.widthHint = 82;
			btnInvCardUnitsPreLData.heightHint = 25;
			btnInvCardUnitsPreLData.horizontalIndent = 0;
			btnInvCardUnitsPreLData.horizontalSpan = 3;
			btnInvCardUnitsPreLData.verticalSpan = 10;
			btnInvCardUnitsPreLData.grabExcessHorizontalSpace = false;
			btnInvCardUnitsPreLData.grabExcessVerticalSpace = false;
			btnInvCardUnitsPre.setLayoutData(btnInvCardUnitsPreLData);
			btnInvCardUnitsPre.setText(" Previous");
			btnInvCardUnitsPre.setSize(new org.eclipse.swt.graphics.Point(82,25));
			btnInvCardUnitsPre.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardUnitsPreMouseUp(evt);
				}
			});
	
			GridData btnInvCardUnitsNxtLData = new GridData();
			btnInvCardUnitsNxtLData.verticalAlignment = GridData.CENTER;
			btnInvCardUnitsNxtLData.horizontalAlignment = GridData.END;
			btnInvCardUnitsNxtLData.widthHint = 61;
			btnInvCardUnitsNxtLData.heightHint = 25;
			btnInvCardUnitsNxtLData.horizontalIndent = 0;
			btnInvCardUnitsNxtLData.horizontalSpan = 1;
			btnInvCardUnitsNxtLData.verticalSpan = 10;
			btnInvCardUnitsNxtLData.grabExcessHorizontalSpace = false;
			btnInvCardUnitsNxtLData.grabExcessVerticalSpace = false;
			btnInvCardUnitsNxt.setLayoutData(btnInvCardUnitsNxtLData);
			btnInvCardUnitsNxt.setText("Next ");
			btnInvCardUnitsNxt.setSize(new org.eclipse.swt.graphics.Point(61,25));
			btnInvCardUnitsNxt.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardUnitsNxtMouseUp(evt);
				}
			});
			GridLayout compInvCardUnitLayout = new GridLayout(4, true);
			compInvCardUnit.setLayout(compInvCardUnitLayout);
			compInvCardUnitLayout.marginWidth = 5;
			compInvCardUnitLayout.marginHeight = 5;
			compInvCardUnitLayout.numColumns = 4;
			compInvCardUnitLayout.makeColumnsEqualWidth = true;
			compInvCardUnitLayout.horizontalSpacing = 5;
			compInvCardUnitLayout.verticalSpacing = 5;
			compInvCardUnit.layout();
	
			tabInvCardPrices.setControl(compInvCardPrices);
			tabInvCardPrices.setText("Prices");
	
			compInvCardPrices.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData compInvCardPricesTableLData = new GridData();
			compInvCardPricesTableLData.verticalAlignment = GridData.CENTER;
			compInvCardPricesTableLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardPricesTableLData.widthHint = 534;
			compInvCardPricesTableLData.heightHint = 207;
			compInvCardPricesTableLData.horizontalIndent = 0;
			compInvCardPricesTableLData.horizontalSpan = 2;
			compInvCardPricesTableLData.verticalSpan = 1;
			compInvCardPricesTableLData.grabExcessHorizontalSpace = false;
			compInvCardPricesTableLData.grabExcessVerticalSpace = false;
			compInvCardPricesTable.setLayoutData(compInvCardPricesTableLData);
			compInvCardPricesTable.setSize(new org.eclipse.swt.graphics.Point(534,207));
	
			GridData compInvCardPricesAddLData = new GridData();
			compInvCardPricesAddLData.verticalAlignment = GridData.CENTER;
			compInvCardPricesAddLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardPricesAddLData.widthHint = 45;
			compInvCardPricesAddLData.heightHint = 67;
			compInvCardPricesAddLData.horizontalIndent = 0;
			compInvCardPricesAddLData.horizontalSpan = 1;
			compInvCardPricesAddLData.verticalSpan = 1;
			compInvCardPricesAddLData.grabExcessHorizontalSpace = false;
			compInvCardPricesAddLData.grabExcessVerticalSpace = false;
			compInvCardPricesAdd.setLayoutData(compInvCardPricesAddLData);
			compInvCardPricesAdd.setSize(new org.eclipse.swt.graphics.Point(45,67));
	
			GridData btnInvCardAddPricesAddPriceLData = new GridData();
			btnInvCardAddPricesAddPriceLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddPricesAddPriceLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddPricesAddPriceLData.widthHint = 30;
			btnInvCardAddPricesAddPriceLData.heightHint = 24;
			btnInvCardAddPricesAddPriceLData.horizontalIndent = 0;
			btnInvCardAddPricesAddPriceLData.horizontalSpan = 1;
			btnInvCardAddPricesAddPriceLData.verticalSpan = 1;
			btnInvCardAddPricesAddPriceLData.grabExcessHorizontalSpace = false;
			btnInvCardAddPricesAddPriceLData.grabExcessVerticalSpace = false;
			btnInvCardAddPricesAddPrice.setLayoutData(btnInvCardAddPricesAddPriceLData);
			btnInvCardAddPricesAddPrice.setSize(new org.eclipse.swt.graphics.Point(30,24));
			btnInvCardAddPricesAddPrice.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					btnInvCardAddPricesAddPriceMouseDown(evt);
				}
			});
	
			GridData btnInvCardAddPricesRemovePriceLData = new GridData();
			btnInvCardAddPricesRemovePriceLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddPricesRemovePriceLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddPricesRemovePriceLData.widthHint = 30;
			btnInvCardAddPricesRemovePriceLData.heightHint = 24;
			btnInvCardAddPricesRemovePriceLData.horizontalIndent = 0;
			btnInvCardAddPricesRemovePriceLData.horizontalSpan = 1;
			btnInvCardAddPricesRemovePriceLData.verticalSpan = 1;
			btnInvCardAddPricesRemovePriceLData.grabExcessHorizontalSpace = false;
			btnInvCardAddPricesRemovePriceLData.grabExcessVerticalSpace = false;
			btnInvCardAddPricesRemovePrice.setLayoutData(btnInvCardAddPricesRemovePriceLData);
			btnInvCardAddPricesRemovePrice.setSize(new org.eclipse.swt.graphics.Point(30,24));
			btnInvCardAddPricesRemovePrice.addMouseListener( new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					btnInvCardAddPricesRemovePriceMouseDown(evt);
				}
			});
			GridLayout compInvCardPricesAddLayout = new GridLayout(1, true);
			compInvCardPricesAdd.setLayout(compInvCardPricesAddLayout);
			compInvCardPricesAddLayout.marginWidth = 5;
			compInvCardPricesAddLayout.marginHeight = 5;
			compInvCardPricesAddLayout.numColumns = 1;
			compInvCardPricesAddLayout.makeColumnsEqualWidth = true;
			compInvCardPricesAddLayout.horizontalSpacing = 5;
			compInvCardPricesAddLayout.verticalSpacing = 5;
			compInvCardPricesAdd.layout();
	
			GridData tableInvCardAddPricesLData = new GridData();
			tableInvCardAddPricesLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddPricesLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddPricesLData.widthHint = 421;
			tableInvCardAddPricesLData.heightHint = 178;
			tableInvCardAddPricesLData.horizontalIndent = 0;
			tableInvCardAddPricesLData.horizontalSpan = 1;
			tableInvCardAddPricesLData.verticalSpan = 1;
			tableInvCardAddPricesLData.grabExcessHorizontalSpace = false;
			tableInvCardAddPricesLData.grabExcessVerticalSpace = false;
			tableInvCardAddPrices.setLayoutData(tableInvCardAddPricesLData);
			tableInvCardAddPrices.setHeaderVisible(true);
			tableInvCardAddPrices.setLinesVisible(true);
			tableInvCardAddPrices.setSize(new org.eclipse.swt.graphics.Point(421,178));
	
			tableColumnPriceType.setText("Price Type");
			tableColumnPriceType.setWidth(120);
	
			tableColumnAmount.setText("Amount");
			tableColumnAmount.setWidth(150);
	
			tableColumnCurrency.setText("Currency");
			tableColumnCurrency.setWidth(162);
			GridLayout compInvCardPricesTableLayout = new GridLayout(2, true);
			compInvCardPricesTable.setLayout(compInvCardPricesTableLayout);
			compInvCardPricesTableLayout.marginWidth = 5;
			compInvCardPricesTableLayout.marginHeight = 5;
			compInvCardPricesTableLayout.numColumns = 2;
			compInvCardPricesTableLayout.makeColumnsEqualWidth = false;
			compInvCardPricesTableLayout.horizontalSpacing = 5;
			compInvCardPricesTableLayout.verticalSpacing = 5;
			compInvCardPricesTable.layout();
	
			GridData btnInvCardPricesPreLData = new GridData();
			btnInvCardPricesPreLData.verticalAlignment = GridData.END;
			btnInvCardPricesPreLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardPricesPreLData.widthHint = 82;
			btnInvCardPricesPreLData.heightHint = 25;
			btnInvCardPricesPreLData.horizontalIndent = 0;
			btnInvCardPricesPreLData.horizontalSpan = 1;
			btnInvCardPricesPreLData.verticalSpan = 1;
			btnInvCardPricesPreLData.grabExcessHorizontalSpace = false;
			btnInvCardPricesPreLData.grabExcessVerticalSpace = false;
			btnInvCardPricesPre.setLayoutData(btnInvCardPricesPreLData);
			btnInvCardPricesPre.setText("Previous");
			btnInvCardPricesPre.setSize(new org.eclipse.swt.graphics.Point(82,25));
			btnInvCardPricesPre.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardPricesPreMouseUp(evt);
				}
			});
	
			GridData btnInvCardPricesNextLData = new GridData();
			btnInvCardPricesNextLData.verticalAlignment = GridData.END;
			btnInvCardPricesNextLData.horizontalAlignment = GridData.END;
			btnInvCardPricesNextLData.widthHint = 61;
			btnInvCardPricesNextLData.heightHint = 25;
			btnInvCardPricesNextLData.horizontalIndent = 0;
			btnInvCardPricesNextLData.horizontalSpan = 1;
			btnInvCardPricesNextLData.verticalSpan = 1;
			btnInvCardPricesNextLData.grabExcessHorizontalSpace = false;
			btnInvCardPricesNextLData.grabExcessVerticalSpace = false;
			btnInvCardPricesNext.setLayoutData(btnInvCardPricesNextLData);
			btnInvCardPricesNext.setText("Next ");
			btnInvCardPricesNext.setSize(new org.eclipse.swt.graphics.Point(61,25));
			btnInvCardPricesNext.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardPricesNextMouseUp(evt);
				}
			});
			GridLayout compInvCardPricesLayout = new GridLayout(2, true);
			compInvCardPrices.setLayout(compInvCardPricesLayout);
			compInvCardPricesLayout.marginWidth = 5;
			compInvCardPricesLayout.marginHeight = 5;
			compInvCardPricesLayout.numColumns = 2;
			compInvCardPricesLayout.makeColumnsEqualWidth = true;
			compInvCardPricesLayout.horizontalSpacing = 5;
			compInvCardPricesLayout.verticalSpacing = 5;
			compInvCardPrices.layout();
	
			tabInvCardGroups.setControl(compInvCardAddGroups);
			tabInvCardGroups.setText("Groups");
	
			compInvCardAddGroups.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData compInvCardAddGroupsSelectionLData = new GridData();
			compInvCardAddGroupsSelectionLData.verticalAlignment = GridData.CENTER;
			compInvCardAddGroupsSelectionLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardAddGroupsSelectionLData.widthHint = 448;
			compInvCardAddGroupsSelectionLData.heightHint = 184;
			compInvCardAddGroupsSelectionLData.horizontalIndent = 0;
			compInvCardAddGroupsSelectionLData.horizontalSpan = 1;
			compInvCardAddGroupsSelectionLData.verticalSpan = 1;
			compInvCardAddGroupsSelectionLData.grabExcessHorizontalSpace = false;
			compInvCardAddGroupsSelectionLData.grabExcessVerticalSpace = false;
			compInvCardAddGroupsSelection.setLayoutData(compInvCardAddGroupsSelectionLData);
			compInvCardAddGroupsSelection.setSize(new org.eclipse.swt.graphics.Point(448,184));
	
			GridData tableInvCardAddGroupsAllGroupsLData = new GridData();
			tableInvCardAddGroupsAllGroupsLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddGroupsAllGroupsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddGroupsAllGroupsLData.widthHint = 141;
			tableInvCardAddGroupsAllGroupsLData.heightHint = 141;
			tableInvCardAddGroupsAllGroupsLData.horizontalIndent = 0;
			tableInvCardAddGroupsAllGroupsLData.horizontalSpan = 1;
			tableInvCardAddGroupsAllGroupsLData.verticalSpan = 1;
			tableInvCardAddGroupsAllGroupsLData.grabExcessHorizontalSpace = false;
			tableInvCardAddGroupsAllGroupsLData.grabExcessVerticalSpace = false;
			tableInvCardAddGroupsAllGroups.setLayoutData(tableInvCardAddGroupsAllGroupsLData);
			tableInvCardAddGroupsAllGroups.setHeaderVisible(true);
			tableInvCardAddGroupsAllGroups.setLinesVisible(true);
			tableInvCardAddGroupsAllGroups.setSize(new org.eclipse.swt.graphics.Point(141,141));
	
			tableColumnInvCardAddGroupAllGroups.setText("Groups");
			tableColumnInvCardAddGroupAllGroups.setWidth(141);
	
			GridData compInvCardAddGroupsButtonsLData = new GridData();
			compInvCardAddGroupsButtonsLData.verticalAlignment = GridData.CENTER;
			compInvCardAddGroupsButtonsLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardAddGroupsButtonsLData.widthHint = 136;
			compInvCardAddGroupsButtonsLData.heightHint = 118;
			compInvCardAddGroupsButtonsLData.horizontalIndent = 0;
			compInvCardAddGroupsButtonsLData.horizontalSpan = 1;
			compInvCardAddGroupsButtonsLData.verticalSpan = 1;
			compInvCardAddGroupsButtonsLData.grabExcessHorizontalSpace = false;
			compInvCardAddGroupsButtonsLData.grabExcessVerticalSpace = false;
			compInvCardAddGroupsButtons.setLayoutData(compInvCardAddGroupsButtonsLData);
			compInvCardAddGroupsButtons.setSize(new org.eclipse.swt.graphics.Point(136,118));
	
			GridData btnInvCardAddGroupsRegisterLData = new GridData();
			btnInvCardAddGroupsRegisterLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddGroupsRegisterLData.horizontalAlignment = GridData.CENTER;
			btnInvCardAddGroupsRegisterLData.widthHint = 44;
			btnInvCardAddGroupsRegisterLData.heightHint = 29;
			btnInvCardAddGroupsRegisterLData.horizontalIndent = 0;
			btnInvCardAddGroupsRegisterLData.horizontalSpan = 1;
			btnInvCardAddGroupsRegisterLData.verticalSpan = 1;
			btnInvCardAddGroupsRegisterLData.grabExcessHorizontalSpace = false;
			btnInvCardAddGroupsRegisterLData.grabExcessVerticalSpace = false;
			btnInvCardAddGroupsRegister.setLayoutData(btnInvCardAddGroupsRegisterLData);
			btnInvCardAddGroupsRegister.setText(">>");
			btnInvCardAddGroupsRegister.setSize(new org.eclipse.swt.graphics.Point(44,29));
			btnInvCardAddGroupsRegister.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardAddGroupsRegisterMouseUp(evt);
				}
			});
	
			GridData btnInvCardAddGroupsRemoveLData = new GridData();
			btnInvCardAddGroupsRemoveLData.verticalAlignment = GridData.BEGINNING;
			btnInvCardAddGroupsRemoveLData.horizontalAlignment = GridData.CENTER;
			btnInvCardAddGroupsRemoveLData.widthHint = 48;
			btnInvCardAddGroupsRemoveLData.heightHint = 31;
			btnInvCardAddGroupsRemoveLData.horizontalIndent = 0;
			btnInvCardAddGroupsRemoveLData.horizontalSpan = 1;
			btnInvCardAddGroupsRemoveLData.verticalSpan = 1;
			btnInvCardAddGroupsRemoveLData.grabExcessHorizontalSpace = false;
			btnInvCardAddGroupsRemoveLData.grabExcessVerticalSpace = false;
			btnInvCardAddGroupsRemove.setLayoutData(btnInvCardAddGroupsRemoveLData);
			btnInvCardAddGroupsRemove.setText("<<");
			btnInvCardAddGroupsRemove.setSize(new org.eclipse.swt.graphics.Point(48,31));
			btnInvCardAddGroupsRemove.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardAddGroupsRemoveMouseUp(evt);
				}
			});
	
			GridData btnInvCardAddNewLData = new GridData();
			btnInvCardAddNewLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddNewLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddNewLData.widthHint = 129;
			btnInvCardAddNewLData.heightHint = 41;
			btnInvCardAddNewLData.horizontalIndent = 0;
			btnInvCardAddNewLData.horizontalSpan = 2;
			btnInvCardAddNewLData.verticalSpan = 1;
			btnInvCardAddNewLData.grabExcessHorizontalSpace = false;
			btnInvCardAddNewLData.grabExcessVerticalSpace = false;
			btnInvCardAddNew.setLayoutData(btnInvCardAddNewLData);
			btnInvCardAddNew.setText("Update Groups");
			btnInvCardAddNew.setSize(new org.eclipse.swt.graphics.Point(129,41));
			btnInvCardAddNew.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardAddNewMouseUp(evt);
				}
			});
			GridLayout compInvCardAddGroupsButtonsLayout = new GridLayout(1, true);
			compInvCardAddGroupsButtons.setLayout(compInvCardAddGroupsButtonsLayout);
			compInvCardAddGroupsButtonsLayout.marginWidth = 5;
			compInvCardAddGroupsButtonsLayout.marginHeight = 5;
			compInvCardAddGroupsButtonsLayout.numColumns = 1;
			compInvCardAddGroupsButtonsLayout.makeColumnsEqualWidth = true;
			compInvCardAddGroupsButtonsLayout.horizontalSpacing = 5;
			compInvCardAddGroupsButtonsLayout.verticalSpacing = 5;
			compInvCardAddGroupsButtons.layout();
	
			GridData tableInvCardAddGroupsRegisteredGroupsLData = new GridData();
			tableInvCardAddGroupsRegisteredGroupsLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddGroupsRegisteredGroupsLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddGroupsRegisteredGroupsLData.widthHint = 150;
			tableInvCardAddGroupsRegisteredGroupsLData.heightHint = 141;
			tableInvCardAddGroupsRegisteredGroupsLData.horizontalIndent = 0;
			tableInvCardAddGroupsRegisteredGroupsLData.horizontalSpan = 1;
			tableInvCardAddGroupsRegisteredGroupsLData.verticalSpan = 1;
			tableInvCardAddGroupsRegisteredGroupsLData.grabExcessHorizontalSpace = false;
			tableInvCardAddGroupsRegisteredGroupsLData.grabExcessVerticalSpace = false;
			tableInvCardAddGroupsRegisteredGroups.setLayoutData(tableInvCardAddGroupsRegisteredGroupsLData);
			tableInvCardAddGroupsRegisteredGroups.setHeaderVisible(true);
			tableInvCardAddGroupsRegisteredGroups.setLinesVisible(true);
			tableInvCardAddGroupsRegisteredGroups.setSize(new org.eclipse.swt.graphics.Point(150,141));
	
			tableColumnRegisteredGroups.setText("Registered Groups");
			tableColumnRegisteredGroups.setWidth(146);
			GridLayout compInvCardAddGroupsSelectionLayout = new GridLayout(3, true);
			compInvCardAddGroupsSelection.setLayout(compInvCardAddGroupsSelectionLayout);
			compInvCardAddGroupsSelectionLayout.marginWidth = 5;
			compInvCardAddGroupsSelectionLayout.marginHeight = 5;
			compInvCardAddGroupsSelectionLayout.numColumns = 3;
			compInvCardAddGroupsSelectionLayout.makeColumnsEqualWidth = false;
			compInvCardAddGroupsSelectionLayout.horizontalSpacing = 5;
			compInvCardAddGroupsSelectionLayout.verticalSpacing = 5;
			compInvCardAddGroupsSelection.layout();
	
			GridData btnInvCardGroupsPreLData = new GridData();
			btnInvCardGroupsPreLData.verticalAlignment = GridData.CENTER;
			btnInvCardGroupsPreLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardGroupsPreLData.widthHint = -1;
			btnInvCardGroupsPreLData.heightHint = -1;
			btnInvCardGroupsPreLData.horizontalIndent = 0;
			btnInvCardGroupsPreLData.horizontalSpan = 1;
			btnInvCardGroupsPreLData.verticalSpan = 1;
			btnInvCardGroupsPreLData.grabExcessHorizontalSpace = false;
			btnInvCardGroupsPreLData.grabExcessVerticalSpace = false;
			btnInvCardGroupsPre.setLayoutData(btnInvCardGroupsPreLData);
			btnInvCardGroupsPre.setText("Previous");
			btnInvCardGroupsPre.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardGroupsPreMouseUp(evt);
				}
			});
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
					comboInvCardUnitsbackground.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here */
	public void preInitGUI() {
	try{
		mapEditorsTableInvCardAddRegisteredUnits = new HashMap();
		currencyList = engCardAdd.getCurrencies();
		}
	catch(Exception ex){
	ex.printStackTrace();
	}
		
	}

	/** Add your post-init code in here */
	public void postInitGUI() {

		fillInvCardUnits();
		fillTableInvAllGroups();
		initTableInvPrices();
	
		

	}

	public void initTableInvPrices() {
	tableInvPricesViewer = new TableViewer(tableInvCardAddPrices);
	tableInvPricesViewer.setUseHashlookup(true);
	tableInvPricesViewer.setColumnProperties(new String[]{Messages.getString("InvUICardAdd.40"),Messages.getString("InvUICardAdd.41"),Messages.getString("InvUICardAdd.42")}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		// Create the cell editors
	CellEditor[] editors = new CellEditor[3];

	editors[0] = new ComboBoxCellEditor(tableInvCardAddPrices,new String[]{Messages.getString("InvUICardAdd.43"),Messages.getString("InvUICardAdd.44")}); //$NON-NLS-1$ //$NON-NLS-2$

   TurqCurrency currency;
   String []currencies = new String[currencyList.size()];
					for(int i =0; i<currencyList.size();i++){					
					currency = (TurqCurrency)currencyList.get(i);
					currencies[i]=currency.getCurrenciesAbbreviation();
					
					}		
  //Initialize Price List				
  priceList=  new InvUIPriceList(currencies);				
         
  editors[2] = new ComboBoxCellEditor(tableInvCardAddPrices, currencies, SWT.READ_ONLY);

		// Column 4 : Percent complete (Text with digits only)
	TextCellEditor textEditor = new TextCellEditor(tableInvCardAddPrices);
		((Text) textEditor.getControl()).addVerifyListener(
		
			new VerifyListener() {
				public void verifyText(VerifyEvent e) {
					char decimalSymbol ='.';
 	int numberOfDecimals =2;
 	Text control = (Text)e.widget;
    String text = control.getText();
    e.doit = false;

    if (e.keyCode == SWT.BS || e.keyCode == SWT.DEL){
     e.doit = true;
     return;
    }

    String newText = text.substring(0, e.start) + e.text +
text.substring(e.end);

    if (newText.equals("")){ //$NON-NLS-1$
     e.doit = true;
     return;
    }

    Pattern realNumberPattern = Pattern.compile("-?[1-9]*[0-9]{1}([" + //$NON-NLS-1$
decimalSymbol + "][0-9]+)?"); //$NON-NLS-1$
    Matcher matcher = realNumberPattern.matcher(newText);
    boolean valid = matcher.matches();

    e.doit = valid;

    if (newText.length() > 2){
     int pos = newText.indexOf('-');
     if (pos != -1 && newText.indexOf('-', pos + 1) != -1){
      e.doit = false;
      return;
     }
     if (newText.charAt(0) == '-' && newText.charAt(1) == '0' &&
       newText.charAt(2) != decimalSymbol){
      e.doit = false;
      return;
     }
     pos = newText.indexOf(decimalSymbol);
     if (pos != -1) {
      e.doit = true;
      if (newText.indexOf(decimalSymbol, pos + 1) != -1){
       e.doit = false;
       return;
      }

      if (newText.substring(pos + 1).length() > numberOfDecimals){
       e.doit = false;
       return;
      }
     }
    }
    else {
     if (newText.length() == 1 && newText.charAt(0) == '-'){
      e.doit = true;
     }
    }
					
				}
			});
		editors[1] = textEditor;

		// Assign the cell editors to the viewer 
		tableInvPricesViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableInvPricesViewer.setCellModifier(new InvUIPriceCellModifier(priceList));
		// Set the default sorter for the viewer 
	  //tableViewer.setSorter(new ExampleTaskSorter(ExampleTaskSorter.DESCRIPTION));
	   tableInvPricesViewer.setLabelProvider(new InvUIPriceLabelProvider());
	   tableInvPricesViewer.setContentProvider(new InvUIContentProvider());
	   tableInvPricesViewer.setInput(priceList);
		

	}

	/**
	 * InnerClass that acts as a proxy for the InvUIPriceList 
	 * providing content for the Table. It implements the IPriceListViewer 
	 * interface since it must register changeListeners with the 
	 * InvUIPriceList 
	 */
	class InvUIContentProvider implements IStructuredContentProvider, IPriceListViewer {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if (newInput != null)
				((InvUIPriceList) newInput).addChangeListener(this);
			if (oldInput != null)
				((InvUIPriceList) oldInput).removeChangeListener(this);
		}

		public void dispose() {
			priceList.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		public Object[] getElements(Object parent) {
			return priceList.getPrices().toArray();
		}

		/* (non-Javadoc)
		 * @see ITaskListViewer#addTask(ExampleTask)
		 */
		public void addPrice(InvUIPrice price) {
			tableInvPricesViewer.add(price);
		}

		/* (non-Javadoc)
		 * @see ITaskListViewer#removeTask(ExampleTask)
		 */
		public void removePrice(InvUIPrice price) {
			tableInvPricesViewer.remove(price);			
		}

		/* (non-Javadoc)
		 * @see ITaskListViewer#updateTask(ExampleTask)
		 */
		public void updatePrice(InvUIPrice price) {
			tableInvPricesViewer.update(price,null);
		}
	}
	
	
	
	
	
	
	

	public void fillInvCardUnits() {

		tableInvCardAddAllUnits.removeAll();
		tableInvCardAddRegisteredUnits.removeAll();
		comboInvCardUnits.removeAll();
		
		//Remove All editors
		Iterator it = mapEditorsTableInvCardAddRegisteredUnits.keySet().iterator();
		while (it.hasNext()){
		TableEditor editor =(TableEditor) mapEditorsTableInvCardAddRegisteredUnits.get(it.next());
		editor.getEditor().dispose();
		editor.dispose();		
		}
		tableInvCardAddRegisteredUnits.getColumn(1).setWidth(50);		
		
		try {
			java.util.List unitLst = invBLCardAdd.getInventoryUnits();
			TableItem item = null;
			TurqInventoryUnit trqInvUnit;

			for (int i = 0; i < unitLst.size(); i++) {
				trqInvUnit = (TurqInventoryUnit) unitLst.get(i);
				comboInvCardUnits.add(trqInvUnit.getUnitsName());
				comboInvCardUnits
						.setData(trqInvUnit.getUnitsName(), trqInvUnit);
				item = new TableItem(tableInvCardAddAllUnits, SWT.NULL);
				item.setText(trqInvUnit.getUnitsName());
				item.setData(trqInvUnit);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void fillTableInvAllGroups() {

		tableInvCardAddGroupsAllGroups.removeAll();
		tableInvCardAddGroupsRegisteredGroups.removeAll();
		try {
			java.util.List groupLst = invBLCardAdd.getInventoryGroups();
			TableItem item = null;
			TurqInventoryGroup trqInvGroup;
			for (int i = 0; i < groupLst.size(); i++) {
				trqInvGroup = (TurqInventoryGroup) groupLst.get(i);
				item = new TableItem(tableInvCardAddGroupsAllGroups, SWT.NULL);
				item.setText(trqInvGroup.getGroupsName());
				item.setData(trqInvGroup);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void clearFields(){
	
	 InvUICardAdd cardAdd = new InvUICardAdd(this.getParent(),this.getStyle());
	 CTabFolder tabfld = (CTabFolder)this.getParent();
	 tabfld.getSelection().setControl(cardAdd);	 
	 this.dispose();
		
	
	}
	

	public boolean verifyFields() {
		
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		//If inventory name is not given
		if (txtInvCardName.getText().trim().equals("")) { 		
			msg.setMessage("Please Fill Inventory Name!"); 
			msg.open();
			return false;
		}
		else if (txtInvCardCode.getText().trim().equals("")) { 		
			msg.setMessage("Please Fill Inventory Code!"); 
			msg.open();
			return false;
		}
		else if (txtInvCardInAcc.getData()==null) { 		
			msg.setMessage("Please Select Buy Accounting Code in Details"); 
			msg.open();
			return false;
		}
		else if (txtInvCardOutAcc.getData()==null) { 		
			msg.setMessage("Please Select Sell Accounting Code in Details"); 
			msg.open();
			return false;
		}
		else if (comboInvCardUnits.getData(comboInvCardUnits.getText())==null){
			msg.setMessage("Please Select Base Unit in Units"); 
			msg.open();
			return false;
		}
		return true;
	}

	public void save() {
		if (verifyFields()) {

			
			TurqAccountingAccount accountIdSell = (TurqAccountingAccount) txtInvCardOutAcc.getData();
			TurqAccountingAccount accountIdBuy = (TurqAccountingAccount) txtInvCardInAcc.getData();
			try {

				// Save inventory card

				Integer cardId = blCardAdd.saveInvCard(txtInvCardCode.getText()
						.trim(), txtInvCardSpecialCode.getText().trim(),
						txtInvCardName.getText().trim(), txtInvCardDefinition
								.getText().trim(), txtnumInvCardMin
								.getIntValue(), txtnumInvCardMax.getIntValue(),
								txtInvCardVat.getIntValue(), txtInvCardDiscount
								.getIntValue(), accountIdBuy, accountIdSell );

				

				// Register its Groups
                saveInvGroups(cardId);

				//Register its Units
                saveInvUnits(cardId);  
				
				// Save the price list now.
		        saveInvPrices(cardId);
		        
		        clearFields();
		        	         
		         } catch (Exception ex) {
				ex.printStackTrace();
				MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(ex.getMessage());
				msg.open();
				
			}

		}

	}
	
	public void saveInvGroups(Integer cardId){

	try{	
		int itemCount = tableInvCardAddGroupsRegisteredGroups
				.getItemCount();
		TableItem item;
		for (int i = 0; i < itemCount; i++) {
			item = tableInvCardAddGroupsRegisteredGroups.getItem(i);
			blCardAdd.registerGroup(cardId, item.getData());
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	
	}
	public void saveInvUnits(Integer cardId){
      try
	  {
		Object invUnit = comboInvCardUnits.getData(comboInvCardUnits
				.getText());
		blCardAdd.registerUnits(cardId, invUnit, 1);
		TableItem item;
		//Register Secondary Units
		int itemCount = tableInvCardAddRegisteredUnits.getItemCount();
		TableEditor editor;
		for (int i = 0; i < itemCount; i++) {
			item = tableInvCardAddRegisteredUnits.getItem(i);
			editor = (TableEditor) mapEditorsTableInvCardAddRegisteredUnits
					.get(item.getText(0));
			int factor = ((NumericText) editor.getEditor())
					.getIntValue();
			blCardAdd.registerUnits(cardId, item.getData(), factor);

		}
	  }
      catch(Exception ex){
      	ex.printStackTrace();
      }
		
	}
	public void saveInvPrices(Integer cardId){
		try{
	   int itemCount =tableInvCardAddPrices.getItemCount();
	   TableItem item;
        for(int i=0;i<itemCount;i++){
        item = tableInvCardAddPrices.getItem(i);
        String type = item.getText(0); 
        String amount = item.getText(1); 
        String abbrev = item.getText(2);
        	
        	if(!type.equals("")&&!abbrev.equals("")&&!amount.equals("")){ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        	
        	boolean priceType =false;	
        		if(type.equals(Messages.getString("InvUICardAdd.53"))){	 //$NON-NLS-1$
        			priceType=true;		         		
        		}
        		
        		blCardAdd.saveInvPrices(cardId,priceType,abbrev,amount);
        
        	}
        }
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

	public void delete() {
		

	}

	public void newForm() {
		
		
	}

	public void search() {
		
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
			Rectangle shellBounds = shell.computeTrim(0,0,655,430);
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
	protected void btnInvCardGeneralMouseUp(MouseEvent evt) {
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	protected void btnInvCardUnitsNxtMouseUp(MouseEvent evt) {
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	protected void btnInvCardAddPricesAddPriceMouseDown(MouseEvent evt) {
	//	tableInvPricesViewer.add(new InvUIPrice());
		priceList.addPrice();
		
	}

	protected void btnInvCardAddPricesRemovePriceMouseDown(MouseEvent evt) {
		InvUIPrice price = (InvUIPrice) ((IStructuredSelection) 
				tableInvPricesViewer.getSelection()).getFirstElement();
		if (price != null) {
			priceList.removePrice(price);
		} 	
	
	/*	TTableModel model = (TTableModel) tableInvCardAddPrices.getModel();
		int s[] = tableInvCardAddPrices.getRowSelection();
		if (s.length > 0) {

			model.removeRow(s[0]);
			tableInvCardAddPrices.redraw();

		}
   */
	}

	protected void btnInvCardAddGroupsRegisterGroupMouseDown(MouseEvent evt) {

	}

	protected void btnInvCardAddGroupsRemoveRegisteredGroupMouseDown(
			MouseEvent evt) {

	}

	protected void btnInvCardAddUnitMouseDown(MouseEvent evt) {

	}

	protected void btnInvCardRemoveUnitMouseDown(MouseEvent evt) {

	}

	protected void btnRegisterInvUnitMouseUp(MouseEvent evt) {
		//if the base unit is selected
		if (comboInvCardUnits.getSelectionIndex() > -1) {
			int selectedIndex = tableInvCardAddAllUnits.getSelectionIndex();

			//if there is a selection
			if (selectedIndex >= 0) {
				
				String itemText = tableInvCardAddAllUnits
						.getItem(selectedIndex).getText();
				
				//if the selection is not the base unit
				if (!itemText.equals(comboInvCardUnits.getText())) {
					TableItem registeredItem = new TableItem(
							tableInvCardAddRegisteredUnits, SWT.NULL);
					registeredItem.setText(itemText);
					registeredItem.setData(tableInvCardAddAllUnits.getItem(
							selectedIndex).getData());
					tableInvCardAddAllUnits.remove(selectedIndex);

					TableEditor editor = new TableEditor(
							tableInvCardAddRegisteredUnits);
					editor.grabHorizontal = true;
					NumericText nText = new NumericText(
							tableInvCardAddRegisteredUnits, SWT.NONE);
					nText.setText(1);
					editor.setEditor(nText, registeredItem, 1);
					mapEditorsTableInvCardAddRegisteredUnits.put(itemText,
							editor);
				}

			}
		} else {
			MessageBox box = new MessageBox(this.getShell());
			box.setMessage(Messages.getString("InvUICardAdd.57")); //$NON-NLS-1$
			box.open();
		}

	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddGroupsRegisterMouseUp(MouseEvent evt) {
		int selectedIndex = tableInvCardAddGroupsAllGroups.getSelectionIndex();

		if (selectedIndex >= 0) {
			TableItem registeredItem = new TableItem(tableInvCardAddGroupsRegisteredGroups, SWT.NULL);
			registeredItem.setText(tableInvCardAddGroupsAllGroups.getItem(
					selectedIndex).getText());
			registeredItem.setData(tableInvCardAddGroupsAllGroups.getItem(
					selectedIndex).getData());
			tableInvCardAddGroupsAllGroups.remove(selectedIndex);
		}

	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddGroupsRemoveMouseUp(MouseEvent evt) {
		int selectedIndex = tableInvCardAddGroupsRegisteredGroups
				.getSelectionIndex();

		if (selectedIndex >= 0) {
			TableItem registeredItem = new TableItem(
					tableInvCardAddGroupsAllGroups, SWT.NULL);
			registeredItem.setText(tableInvCardAddGroupsRegisteredGroups
					.getItem(selectedIndex).getText());
			registeredItem.setData(tableInvCardAddGroupsRegisteredGroups
					.getItem(selectedIndex).getData());
			tableInvCardAddGroupsRegisteredGroups.remove(selectedIndex);
		}

	}

	/** Auto-generated event handler method */
	protected void btnRemoveRegisteredInvUnitMouseUp(MouseEvent evt) {

		int selectedIndex = tableInvCardAddRegisteredUnits.getSelectionIndex();

		if (selectedIndex >= 0) {
			TableItem registeredItem = new TableItem(tableInvCardAddAllUnits,
					SWT.NULL);
			String itemText = tableInvCardAddRegisteredUnits.getItem(
					selectedIndex).getText();
			registeredItem.setText(tableInvCardAddRegisteredUnits.getItem(
					selectedIndex).getText());
			registeredItem.setData(tableInvCardAddRegisteredUnits.getItem(
					selectedIndex).getData());
			tableInvCardAddRegisteredUnits.remove(selectedIndex);
			((TableEditor) mapEditorsTableInvCardAddRegisteredUnits
					.get(itemText)).getEditor().dispose();
			((TableEditor) mapEditorsTableInvCardAddRegisteredUnits
					.get(itemText)).dispose();
			mapEditorsTableInvCardAddRegisteredUnits.remove(itemText);
			tableInvCardAddRegisteredUnits.getColumn(1).setWidth(50);
		}

	}

	/** Auto-generated event handler method */
	protected void btnInvCardPricesNextMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
		
	}

	/** Auto-generated event handler method */
	protected void btnInvCardNextMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void txtInvCardInAccMouseUp(MouseEvent evt) {
		AccUIDialogInventoryCodeChoose dialogchoose = new AccUIDialogInventoryCodeChoose(
				getShell(), SWT.NULL);
		Object[] obj = dialogchoose.showDialog();
		if (obj[0] != null) {
			txtInvCardInAcc.setData(obj[1]);
			txtInvCardInAcc.setText(obj[0].toString());
		}

	}

	/** Auto-generated event handler method */
	protected void btnInvCardDetPreMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardUnitsPreMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);

	}

	/** Auto-generated event handler method */
	protected void btnInvCardPricesPreMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	

	/** Auto-generated event handler method */
	protected void btnInvCardGroupsPreMouseUp(MouseEvent evt) {
		//TODO add your handler code here
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void txtInvCardOutAccMouseUp(MouseEvent evt) {
		AccUIDialogInventoryCodeChoose dialogchoose = new AccUIDialogInventoryCodeChoose(
				getShell(), SWT.NULL);
		Object[] obj = dialogchoose.showDialog();
		if (obj[0] != null) {
			txtInvCardOutAcc.setData(obj[1]);
			txtInvCardOutAcc.setText(obj[0].toString());
		}

	}

	/** Auto-generated event handler method */
	protected void btnInvCardAddNewMouseUp(MouseEvent evt){
		new InvUIGroupAddDialog(this.getShell(),SWT.NULL).open();
		fillTableInvAllGroups();
	}

	/** Auto-generated event handler method */
	protected void btnUpdateUnitsMouseUp(MouseEvent evt){
	 new InvUIUnitAddDialog(this.getShell(),SWT.NULL).open();
	 fillInvCardUnits();
	}
	/**
	 * @return Returns the tableInvCardAddAllUnits.
	 */
	public Table getTableInvCardAddAllUnits() {
		return tableInvCardAddAllUnits;
	}
	/**
	 * @return Returns the tableInvCardAddGroupsAllGroups.
	 */
	public Table getTableInvCardAddGroupsAllGroups() {
		return tableInvCardAddGroupsAllGroups;
	}
	/**
	 * @return Returns the tableInvCardAddGroupsRegisteredGroups.
	 */
	public Table getTableInvCardAddGroupsRegisteredGroups() {
		return tableInvCardAddGroupsRegisteredGroups;
	}
	/**
	 * @return Returns the tableInvCardAddPrices.
	 */
	public Table getTableInvCardAddPrices() {
		return tableInvCardAddPrices;
	}
	/**
	 * @return Returns the tableInvCardAddRegisteredUnits.
	 */
	public Table getTableInvCardAddRegisteredUnits() {
		return tableInvCardAddRegisteredUnits;
	}
	/**
	 * @return Returns the txtInvCardCode.
	 */
	public Text getTxtInvCardCode() {
		return txtInvCardCode;
	}
	/**
	 * @return Returns the txtInvCardDefinition.
	 */
	public Text getTxtInvCardDefinition() {
		return txtInvCardDefinition;
	}
	/**
	 * @return Returns the txtInvCardDiscount.
	 */
	public NumericText getTxtInvCardDiscount() {
		return txtInvCardDiscount;
	}
	/**
	 * @return Returns the txtInvCardInAcc.
	 */
	public TextWithButton getTxtInvCardInAcc() {
		return txtInvCardInAcc;
	}
	/**
	 * @return Returns the txtInvCardName.
	 */
	public Text getTxtInvCardName() {
		return txtInvCardName;
	}
	/**
	 * @return Returns the txtInvCardOutAcc.
	 */
	public TextWithButton getTxtInvCardOutAcc() {
		return txtInvCardOutAcc;
	}
	/**
	 * @return Returns the txtInvCardSpecialCode.
	 */
	public Text getTxtInvCardSpecialCode() {
		return txtInvCardSpecialCode;
	}
	/**
	 * @return Returns the txtInvCardVat.
	 */
	public NumericText getTxtInvCardVat() {
		return txtInvCardVat;
	}
	/**
	 * @return Returns the txtnumInvCardMax.
	 */
	public NumericText getTxtnumInvCardMax() {
		return txtnumInvCardMax;
	}
	/**
	 * @return Returns the txtnumInvCardMin.
	 */
	public NumericText getTxtnumInvCardMin() {
		return txtnumInvCardMin;
	}
	/**
	 * @return Returns the comboInvCardUnits.
	 */
	public CCombo getComboInvCardUnits() {
		return comboInvCardUnits;
	}
	/**
	 * @return Returns the priceList.
	 */
	public InvUIPriceList getPriceList() {
		return priceList;
	}
	/**
	 * @param txtInvCardSpecialCode The txtInvCardSpecialCode to set.
	 */
	public void setTxtInvCardSpecialCode(Text txtInvCardSpecialCode) {
		this.txtInvCardSpecialCode = txtInvCardSpecialCode;
	}
}