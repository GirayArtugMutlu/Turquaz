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
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.accounting.ui.comp.AccountPicker;
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

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;


import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryUnit;

import com.turquaz.engine.ui.component.SecureComposite;

import java.awt.Color;
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
import org.eclipse.swt.widgets.Label;


import com.cloudgarden.resource.SWTResourceManager;
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
public class InvUICardAdd extends Composite implements SecureComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

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

	private AccountPicker txtInvCardOutAcc;

	private CLabel lblInvCardOutAcc;

	private AccountPicker txtInvCardInAcc;

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

	private CurrencyText decTextSpecialVatAmount;
	private Label lblSpecialVatAmount;
	private NumericText numTextSpecailVATPercent;
	private Label lblSpecialVATPercent;
	private Label label5;
	private Label label4;
	private Label label3;
	private Label label2;
	private Label label1;

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
			tabInvCardGeneral = new CTabItem(tabfldInvCardAdd, SWT.NONE);
			tabInvCardDetails = new CTabItem(tabfldInvCardAdd,SWT.NULL);
			tabInvCardUnits = new CTabItem(tabfldInvCardAdd,SWT.NULL);
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

			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 2;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 10;
			thisLayout.verticalSpacing = 0;
			
			this.setSize(641, 467);

			GridData tabfldInvCardAddLData = new GridData();
			tabfldInvCardAddLData.verticalAlignment = GridData.FILL;
			tabfldInvCardAddLData.horizontalAlignment = GridData.FILL;
			tabfldInvCardAddLData.grabExcessHorizontalSpace = true;
			tabfldInvCardAddLData.grabExcessVerticalSpace = true;
			tabfldInvCardAdd.setLayoutData(tabfldInvCardAddLData);

			tabInvCardDetails.setText(Messages.getString("InvUICardAdd.6")); //$NON-NLS-1$
			{
				compInvCardDetails = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardDetails.setControl(compInvCardDetails);
				GridLayout compInvCardDetailsLayout = new GridLayout(4, true);
				compInvCardDetailsLayout.marginWidth = 5;
				compInvCardDetailsLayout.marginHeight = 5;
				compInvCardDetailsLayout.numColumns = 4;
				compInvCardDetailsLayout.makeColumnsEqualWidth = false;
				compInvCardDetailsLayout.horizontalSpacing = 5;
				compInvCardDetailsLayout.verticalSpacing = 5;
				compInvCardDetails.setSize(new org.eclipse.swt.graphics.Point(641,404));
				compInvCardDetails.setLayout(compInvCardDetailsLayout);
				{
					lblInvCardMin = new Label(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardMinLData = new GridData();
					lblInvCardMinLData.widthHint = 115;
					lblInvCardMinLData.heightHint = 16;
					lblInvCardMin.setLayoutData(lblInvCardMinLData);
					lblInvCardMin.setText(Messages.getString("InvUICardAdd.7")); //$NON-NLS-1$
					lblInvCardMin.setSize(new org.eclipse.swt.graphics.Point(
						115,
						16));
				}
				{
					txtnumInvCardMin = new NumericText(
						compInvCardDetails,
						SWT.NONE);
					GridData txtnumInvCardMinLData = new GridData();
					txtnumInvCardMinLData.widthHint = 85;
					txtnumInvCardMinLData.heightHint = 18;
					txtnumInvCardMin.setLayoutData(txtnumInvCardMinLData);
					txtnumInvCardMin
						.setSize(new org.eclipse.swt.graphics.Point(91, 18));
				}
				{
					lblInvCardMax = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardMaxLData = new GridData();
					lblInvCardMaxLData.horizontalAlignment = GridData.END;
					lblInvCardMaxLData.widthHint = 114;
					lblInvCardMaxLData.heightHint = 20;
					lblInvCardMax.setLayoutData(lblInvCardMaxLData);
					lblInvCardMax.setText(Messages.getString("InvUICardAdd.8")); //$NON-NLS-1$
				}
				{
					txtnumInvCardMax = new NumericText(
						compInvCardDetails,
						SWT.NONE);
					GridData txtnumInvCardMaxLData = new GridData();
					txtnumInvCardMaxLData.widthHint = 98;
					txtnumInvCardMaxLData.heightHint = 18;
					txtnumInvCardMax.setLayoutData(txtnumInvCardMaxLData);
					txtnumInvCardMax
						.setSize(new org.eclipse.swt.graphics.Point(104, 18));
				}
				{
					lblInvCardInAcc = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardInAccLData = new GridData();
					lblInvCardInAccLData.widthHint = 142;
					lblInvCardInAccLData.heightHint = 17;
					lblInvCardInAcc.setLayoutData(lblInvCardInAccLData);
					lblInvCardInAcc.setText(Messages.getString("InvUICardAdd.9")); //$NON-NLS-1$
				}
				{
					txtInvCardInAcc = new AccountPicker(compInvCardDetails, SWT.NONE);
					GridData txtInvCardInAccLData = new GridData();
					txtInvCardInAccLData.widthHint = 144;
					txtInvCardInAccLData.heightHint = 19;
					txtInvCardInAcc.setLayoutData(txtInvCardInAccLData);
				}
				{
					lblInvCardOutAcc = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardOutAccLData = new GridData();
					lblInvCardOutAccLData.horizontalAlignment = GridData.END;
					lblInvCardOutAccLData.widthHint = 134;
					lblInvCardOutAccLData.heightHint = 16;
					lblInvCardOutAcc.setLayoutData(lblInvCardOutAccLData);
					lblInvCardOutAcc.setText(Messages.getString("InvUICardAdd.10")); //$NON-NLS-1$
				}
				{
					txtInvCardOutAcc = new AccountPicker(compInvCardDetails, SWT.NONE);
					GridData txtInvCardOutAccLData = new GridData();
					txtInvCardOutAccLData.widthHint = 161;
					txtInvCardOutAccLData.heightHint = 18;
					txtInvCardOutAcc.setLayoutData(txtInvCardOutAccLData);
					txtInvCardOutAcc.setEnabled(true);
				}
				{
					lblInvCardVat = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardVatLData = new GridData();
					lblInvCardVatLData.widthHint = 115;
					lblInvCardVatLData.heightHint = 16;
					lblInvCardVat.setLayoutData(lblInvCardVatLData);
					lblInvCardVat
						.setText(Messages.getString("InvUICardAdd.11")); //$NON-NLS-1$
					lblInvCardVat.setSize(new org.eclipse.swt.graphics.Point(
						115,
						16));
				}
				{
					txtInvCardVat = new NumericText(
						compInvCardDetails,
						SWT.NONE);
					GridData txtInvCardVatLData = new GridData();
					txtInvCardVatLData.widthHint = 55;
					txtInvCardVatLData.heightHint = 17;
					txtInvCardVat.setLayoutData(txtInvCardVatLData);
					txtInvCardVat.setSize(new org.eclipse.swt.graphics.Point(
						61,
						17));
				}
				{
					lblInvCardDiscount = new CLabel(
						compInvCardDetails,
						SWT.RIGHT);
					GridData lblInvCardDiscountLData = new GridData();
					lblInvCardDiscountLData.horizontalAlignment = GridData.END;
					lblInvCardDiscountLData.widthHint = 61;
					lblInvCardDiscountLData.heightHint = 19;
					lblInvCardDiscount.setLayoutData(lblInvCardDiscountLData);
					lblInvCardDiscount.setText(Messages.getString("InvUICardAdd.12")); //$NON-NLS-1$
				}
				{
					txtInvCardDiscount = new NumericText(
						compInvCardDetails,
						SWT.NONE);
					GridData txtInvCardDiscountLData = new GridData();
					txtInvCardDiscountLData.widthHint = 98;
					txtInvCardDiscountLData.heightHint = 18;
					txtInvCardDiscount.setLayoutData(txtInvCardDiscountLData);
					txtInvCardDiscount
						.setSize(new org.eclipse.swt.graphics.Point(104, 18));
				}
				{
					lblSpecialVATPercent = new Label(
						compInvCardDetails,
						SWT.RIGHT);
					lblSpecialVATPercent.setText(Messages.getString("InvUICardAdd.34")); //$NON-NLS-1$
					GridData lblSpecialVATPercentLData = new GridData();
					lblSpecialVATPercentLData.widthHint = 63;
					lblSpecialVATPercentLData.heightHint = 18;
					lblSpecialVATPercentLData.horizontalAlignment = GridData.END;
					lblSpecialVATPercent
						.setLayoutData(lblSpecialVATPercentLData);
				}
				{
					numTextSpecailVATPercent = new NumericText(
						compInvCardDetails,
						SWT.NONE);
					GridData numTextSpecailVATPercentLData = new GridData();
					numTextSpecailVATPercent.setSize(55, 17);
					numTextSpecailVATPercentLData.widthHint = 55;
					numTextSpecailVATPercentLData.heightHint = 17;
					numTextSpecailVATPercent.setLayoutData(numTextSpecailVATPercentLData);
				}
				{
					lblSpecialVatAmount = new Label(
						compInvCardDetails,
						SWT.RIGHT);
					lblSpecialVatAmount.setText(Messages.getString("InvUICardAdd.35")); //$NON-NLS-1$
					GridData lblSpecialVatAmountLData = new GridData();
					lblSpecialVatAmountLData.horizontalAlignment = GridData.END;
					lblSpecialVatAmountLData.widthHint = 107;
					lblSpecialVatAmountLData.heightHint = 13;
					lblSpecialVatAmount.setLayoutData(lblSpecialVatAmountLData);
				}
				{
					decTextSpecialVatAmount = new CurrencyText(
						compInvCardDetails,
						SWT.NONE);
					GridData decTextSpecialVatAmountLData = new GridData();
					decTextSpecialVatAmountLData.widthHint = 91;
					decTextSpecialVatAmountLData.heightHint = 16;
					decTextSpecialVatAmount.setLayoutData(decTextSpecialVatAmountLData);
				}
				{
					label3 = new Label(compInvCardDetails, SWT.SEPARATOR
						| SWT.HORIZONTAL);
					label3.setText("label1"); //$NON-NLS-1$
					GridData label3LData = new GridData();
					label3LData.horizontalAlignment = GridData.FILL;
					label3LData.horizontalSpan = 4;
					label3.setLayoutData(label3LData);
				}
				{
					btnInvCardDetPre = new Button(compInvCardDetails, SWT.PUSH
						| SWT.CENTER);
					GridData btnInvCardDetPreLData = new GridData();
					btnInvCardDetPreLData.widthHint = 85;
					btnInvCardDetPreLData.heightHint = 31;
					btnInvCardDetPreLData.horizontalSpan = 3;
					btnInvCardDetPreLData.verticalSpan = 10;
					btnInvCardDetPre.setLayoutData(btnInvCardDetPreLData);
					btnInvCardDetPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
					btnInvCardDetPre.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnInvCardDetPreMouseUp(evt);
						}
					});
				}
				{
					btnInvCardNext = new Button(compInvCardDetails, SWT.PUSH
						| SWT.CENTER);
					GridData btnInvCardNextLData = new GridData();
					btnInvCardNextLData.horizontalAlignment = GridData.END;
					btnInvCardNextLData.widthHint = 83;
					btnInvCardNextLData.heightHint = 28;
					btnInvCardNextLData.verticalSpan = 10;
					btnInvCardNextLData.grabExcessHorizontalSpace = true;
					btnInvCardNext.setLayoutData(btnInvCardNextLData);
					btnInvCardNext.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
					btnInvCardNext.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnInvCardNextMouseUp(evt);
						}
					});
				}
				compInvCardDetails.layout();

			}

			tabInvCardUnits.setText(Messages.getString("InvUICardAdd.15")); //$NON-NLS-1$
			{
				compInvCardUnit = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardUnits.setControl(compInvCardUnit);
				GridLayout compInvCardUnitLayout = new GridLayout();
				compInvCardUnitLayout.numColumns = 4;
				compInvCardUnit.setSize(new org.eclipse.swt.graphics.Point(641,404));
				compInvCardUnit.setLayout(compInvCardUnitLayout);
				{
					lblInvCardUnit = new CLabel(compInvCardUnit, SWT.NONE);
					GridData lblInvCardUnitLData = new GridData();
					lblInvCardUnitLData.widthHint = 97;
					lblInvCardUnitLData.heightHint = 19;
					lblInvCardUnit.setLayoutData(lblInvCardUnitLData);
					lblInvCardUnit.setText(Messages.getString("InvUICardAdd.16")); //$NON-NLS-1$
				}
				{
					comboInvCardUnits = new CCombo(compInvCardUnit, SWT.FLAT
						| SWT.READ_ONLY);
					GridData comboInvCardUnitsLData = new GridData();
					comboInvCardUnitsLData.widthHint = 104;
					comboInvCardUnitsLData.heightHint = 18;
					comboInvCardUnits.setLayoutData(comboInvCardUnitsLData);
					comboInvCardUnits.setText(Messages
						.getString("InvUICardAdd.17")); //$NON-NLS-1$
					comboInvCardUnits.setBackground(SWTResourceManager
						.getColor(255, 255, 255));
				}
				{
					btnUpdateUnits = new Button(compInvCardUnit, SWT.PUSH
						| SWT.CENTER);
					GridData btnUpdateUnitsLData = new GridData();
					btnUpdateUnitsLData.horizontalSpan = 2;
					btnUpdateUnitsLData.widthHint = 128;
					btnUpdateUnitsLData.heightHint = 29;
					btnUpdateUnits.setLayoutData(btnUpdateUnitsLData);
					btnUpdateUnits.setText(Messages.getString("InvUICardAdd.18")); //$NON-NLS-1$
					btnUpdateUnits.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnUpdateUnitsMouseUp(evt);
						}
					});
				}
				{
					lblInvCardSecondaryUnits = new CLabel(
						compInvCardUnit,
						SWT.NONE);
					GridData lblInvCardSecondaryUnitsLData = new GridData();
					lblInvCardSecondaryUnitsLData.verticalAlignment = GridData.BEGINNING;
					lblInvCardSecondaryUnitsLData.widthHint = 85;
					lblInvCardSecondaryUnitsLData.heightHint = 19;
					lblInvCardSecondaryUnits.setLayoutData(lblInvCardSecondaryUnitsLData);
					lblInvCardSecondaryUnits.setText(Messages.getString("InvUICardAdd.19")); //$NON-NLS-1$
				}
				{
					compInvCardAddSecondaryUnits = new Composite(
						compInvCardUnit,
						SWT.NONE);
					GridLayout compInvCardAddSecondaryUnitsLayout = new GridLayout(
						3,
						true);
					compInvCardAddSecondaryUnitsLayout.marginWidth = 0;
					compInvCardAddSecondaryUnitsLayout.marginHeight = 5;
					compInvCardAddSecondaryUnitsLayout.numColumns = 3;
					compInvCardAddSecondaryUnitsLayout.makeColumnsEqualWidth = false;
					compInvCardAddSecondaryUnitsLayout.horizontalSpacing = 5;
					compInvCardAddSecondaryUnitsLayout.verticalSpacing = 5;
					GridData compInvCardAddSecondaryUnitsLData = new GridData();
					compInvCardAddSecondaryUnitsLData.widthHint = 361;
					compInvCardAddSecondaryUnitsLData.heightHint = 124;
					compInvCardAddSecondaryUnitsLData.horizontalSpan = 2;
					compInvCardAddSecondaryUnits.setLayoutData(compInvCardAddSecondaryUnitsLData);
					compInvCardAddSecondaryUnits
						.setLayout(compInvCardAddSecondaryUnitsLayout);
					{
						tableInvCardAddAllUnits = new Table(
							compInvCardAddSecondaryUnits,
							SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
						GridData tableInvCardAddAllUnitsLData = new GridData();
						tableInvCardAddAllUnitsLData.widthHint = 96;
						tableInvCardAddAllUnitsLData.heightHint = 80;
						tableInvCardAddAllUnits
							.setLayoutData(tableInvCardAddAllUnitsLData);
						tableInvCardAddAllUnits.setHeaderVisible(true);
						tableInvCardAddAllUnits.setLinesVisible(true);
						tableInvCardAddAllUnits
							.setSize(new org.eclipse.swt.graphics.Point(
								116,
								100));
						{
							tableColumn1 = new TableColumn(
								tableInvCardAddAllUnits,
								SWT.NONE);
							tableColumn1.setText(Messages
								.getString("InvUICardAdd.15")); //$NON-NLS-1$
							tableColumn1.setWidth(112);
						}
					}
					{
						compInvCardAddUnitsButtons = new Composite(
							compInvCardAddSecondaryUnits,
							SWT.NONE);
						GridLayout compInvCardAddUnitsButtonsLayout = new GridLayout(
							1,
							true);
						compInvCardAddUnitsButtonsLayout.marginWidth = 5;
						compInvCardAddUnitsButtonsLayout.marginHeight = 5;
						compInvCardAddUnitsButtonsLayout.numColumns = 1;
						compInvCardAddUnitsButtonsLayout.makeColumnsEqualWidth = true;
						compInvCardAddUnitsButtonsLayout.horizontalSpacing = 5;
						compInvCardAddUnitsButtonsLayout.verticalSpacing = 5;
						GridData compInvCardAddUnitsButtonsLData = new GridData();
						compInvCardAddUnitsButtonsLData.widthHint = 63;
						compInvCardAddUnitsButtonsLData.heightHint = 73;
						compInvCardAddUnitsButtons.setLayoutData(compInvCardAddUnitsButtonsLData);
						compInvCardAddUnitsButtons
							.setLayout(compInvCardAddUnitsButtonsLayout);
						{
							btnRegisterInvUnit = new Button(
								compInvCardAddUnitsButtons,
								SWT.PUSH | SWT.CENTER);
							GridData btnRegisterInvUnitLData = new GridData();
							btnRegisterInvUnitLData.horizontalAlignment = GridData.CENTER;
							btnRegisterInvUnitLData.widthHint = 41;
							btnRegisterInvUnitLData.heightHint = 30;
							btnRegisterInvUnit.setLayoutData(btnRegisterInvUnitLData);
							btnRegisterInvUnit.setText(">>"); //$NON-NLS-1$
							btnRegisterInvUnit
								.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnRegisterInvUnitMouseUp(evt);
									}
								});
						}
						{
							btnRemoveRegisteredInvUnit = new Button(
								compInvCardAddUnitsButtons,
								SWT.PUSH | SWT.CENTER);
							GridData btnRemoveRegisteredInvUnitLData = new GridData();
							btnRemoveRegisteredInvUnitLData.horizontalAlignment = GridData.CENTER;
							btnRemoveRegisteredInvUnitLData.widthHint = 40;
							btnRemoveRegisteredInvUnitLData.heightHint = 30;
							btnRemoveRegisteredInvUnit.setLayoutData(btnRemoveRegisteredInvUnitLData);
							btnRemoveRegisteredInvUnit.setText("<<"); //$NON-NLS-1$
							btnRemoveRegisteredInvUnit
								.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnRemoveRegisteredInvUnitMouseUp(evt);
									}
								});
						}
						compInvCardAddUnitsButtons.layout();
					}
					{
						tableInvCardAddRegisteredUnits = new Table(
							compInvCardAddSecondaryUnits,
							SWT.V_SCROLL | SWT.BORDER);
						GridData tableInvCardAddRegisteredUnitsLData = new GridData();
						tableInvCardAddRegisteredUnitsLData.widthHint = 140;
						tableInvCardAddRegisteredUnitsLData.heightHint = 81;
						tableInvCardAddRegisteredUnits
							.setLayoutData(tableInvCardAddRegisteredUnitsLData);
						tableInvCardAddRegisteredUnits.setHeaderVisible(true);
						tableInvCardAddRegisteredUnits.setLinesVisible(true);
						tableInvCardAddRegisteredUnits
							.setSize(new org.eclipse.swt.graphics.Point(
								160,
								101));
						{
							tableColumn2 = new TableColumn(
								tableInvCardAddRegisteredUnits,
								SWT.NONE);
							tableColumn2.setText(Messages
								.getString("InvUICardAdd.23")); //$NON-NLS-1$
							tableColumn2.setWidth(110);
						}
						{
							tableColumnUnitCoefficient = new TableColumn(
								tableInvCardAddRegisteredUnits,
								SWT.NONE);
							tableColumnUnitCoefficient.setText(Messages
								.getString("InvUICardAdd.24")); //$NON-NLS-1$
							tableColumnUnitCoefficient.setWidth(50);
						}
					}
					compInvCardAddSecondaryUnits.layout();
				}
				{
					label1 = new Label(compInvCardUnit, SWT.SEPARATOR
						| SWT.HORIZONTAL);
					label1.setText("label1"); //$NON-NLS-1$
					GridData label1LData = new GridData();
					label1LData.horizontalSpan = 4;
					label1LData.horizontalAlignment = GridData.FILL;
					label1.setLayoutData(label1LData);
				}
				{
					btnInvCardUnitsPre = new Button(compInvCardUnit, SWT.PUSH
						| SWT.CENTER);
					GridData btnInvCardUnitsPreLData = new GridData();
					btnInvCardUnitsPreLData.widthHint = 90;
					btnInvCardUnitsPreLData.heightHint = 32;
					btnInvCardUnitsPreLData.horizontalSpan = 3;
					btnInvCardUnitsPreLData.verticalSpan = 10;
					btnInvCardUnitsPre.setLayoutData(btnInvCardUnitsPreLData);
					btnInvCardUnitsPre.setText(Messages.getString("InvUICardAdd.25")); //$NON-NLS-1$
					btnInvCardUnitsPre.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnInvCardUnitsPreMouseUp(evt);
						}
					});
				}
				{
					btnInvCardUnitsNxt = new Button(compInvCardUnit, SWT.PUSH
						| SWT.CENTER);
					GridData btnInvCardUnitsNxtLData = new GridData();
					btnInvCardUnitsNxtLData.horizontalAlignment = GridData.END;
					btnInvCardUnitsNxtLData.widthHint = 85;
					btnInvCardUnitsNxtLData.heightHint = 29;
					btnInvCardUnitsNxtLData.verticalSpan = 10;
					btnInvCardUnitsNxt.setLayoutData(btnInvCardUnitsNxtLData);
					btnInvCardUnitsNxt.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
					btnInvCardUnitsNxt.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnInvCardUnitsNxtMouseUp(evt);
						}
					});
				}
				compInvCardUnit.layout();

			}

			tabInvCardPrices.setControl(compInvCardPrices);
			tabInvCardPrices.setText(Messages.getString("InvUICardAdd.27")); //$NON-NLS-1$
	
			compInvCardPrices.setSize(new org.eclipse.swt.graphics.Point(641,404));
	
			GridData compInvCardPricesTableLData = new GridData();
			compInvCardPricesTableLData.widthHint = 486;
			compInvCardPricesTableLData.heightHint = 198;
			compInvCardPricesTableLData.horizontalSpan = 2;
			compInvCardPricesTable.setLayoutData(compInvCardPricesTableLData);

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
			btnInvCardAddPricesAddPrice.setImage(SWTResourceManager.getImage("icons/plus.gif")); //$NON-NLS-1$
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
			btnInvCardAddPricesRemovePrice.setImage(SWTResourceManager.getImage("icons/minus.gif")); //$NON-NLS-1$
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

			tableColumnPriceType.setText(Messages.getString("InvUICardAdd.28")); //$NON-NLS-1$
			tableColumnPriceType.setWidth(120);
	
			tableColumnAmount.setText(Messages.getString("InvUICardAdd.29")); //$NON-NLS-1$
			tableColumnAmount.setWidth(150);
	
			tableColumnCurrency.setText(Messages.getString("InvUICardAdd.30")); //$NON-NLS-1$
			tableColumnCurrency.setWidth(162);
			GridLayout compInvCardPricesTableLayout = new GridLayout(2, true);
			compInvCardPricesTable.setLayout(compInvCardPricesTableLayout);
			{
				label4 = new Label(compInvCardPrices, SWT.SEPARATOR | SWT.HORIZONTAL);
				label4.setText("label1"); //$NON-NLS-1$
				GridData label4LData = new GridData();
				label4LData.horizontalAlignment = GridData.FILL;
				label4LData.horizontalSpan = 4;
				label4.setLayoutData(label4LData);
			}
			compInvCardPricesTableLayout.marginWidth = 5;
			compInvCardPricesTableLayout.marginHeight = 5;
			compInvCardPricesTableLayout.numColumns = 2;
			compInvCardPricesTableLayout.makeColumnsEqualWidth = false;
			compInvCardPricesTableLayout.horizontalSpacing = 5;
			compInvCardPricesTableLayout.verticalSpacing = 5;
			compInvCardPricesTable.layout();
	
			GridData btnInvCardPricesPreLData = new GridData();
			btnInvCardPricesPreLData.verticalAlignment = GridData.END;
			btnInvCardPricesPreLData.widthHint = 86;
			btnInvCardPricesPreLData.heightHint = 30;
			btnInvCardPricesPre.setLayoutData(btnInvCardPricesPreLData);
			btnInvCardPricesPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
			btnInvCardPricesPre.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnInvCardPricesPreMouseUp(evt);
				}
			});
	
			GridData btnInvCardPricesNextLData = new GridData();
			btnInvCardPricesNextLData.verticalAlignment = GridData.END;
			btnInvCardPricesNextLData.horizontalAlignment = GridData.END;
			btnInvCardPricesNextLData.widthHint = 81;
			btnInvCardPricesNextLData.heightHint = 30;
			btnInvCardPricesNext.setLayoutData(btnInvCardPricesNextLData);
			btnInvCardPricesNext.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
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

			tabInvCardGroups.setText(Messages.getString("InvUICardAdd.33")); //$NON-NLS-1$
			{
				compInvCardAddGroups = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardGroups.setControl(compInvCardAddGroups);
				GridLayout compInvCardAddGroupsLayout = new GridLayout(1, true);
				compInvCardAddGroupsLayout.marginWidth = 5;
				compInvCardAddGroupsLayout.marginHeight = 5;
				compInvCardAddGroupsLayout.numColumns = 1;
				compInvCardAddGroupsLayout.makeColumnsEqualWidth = true;
				compInvCardAddGroupsLayout.horizontalSpacing = 5;
				compInvCardAddGroupsLayout.verticalSpacing = 5;
				compInvCardAddGroups
					.setSize(new org.eclipse.swt.graphics.Point(641, 404));
				compInvCardAddGroups.setLayout(compInvCardAddGroupsLayout);
				{
					compInvCardAddGroupsSelection = new Composite(
						compInvCardAddGroups,
						SWT.NONE);
					GridLayout compInvCardAddGroupsSelectionLayout = new GridLayout(
						3,
						true);
					compInvCardAddGroupsSelectionLayout.marginWidth = 5;
					compInvCardAddGroupsSelectionLayout.marginHeight = 5;
					compInvCardAddGroupsSelectionLayout.numColumns = 3;
					compInvCardAddGroupsSelectionLayout.makeColumnsEqualWidth = false;
					compInvCardAddGroupsSelectionLayout.horizontalSpacing = 5;
					compInvCardAddGroupsSelectionLayout.verticalSpacing = 5;
					GridData compInvCardAddGroupsSelectionLData = new GridData();
					compInvCardAddGroupsSelectionLData.widthHint = 448;
					compInvCardAddGroupsSelectionLData.heightHint = 184;
					compInvCardAddGroupsSelection
						.setLayoutData(compInvCardAddGroupsSelectionLData);
					compInvCardAddGroupsSelection
						.setSize(new org.eclipse.swt.graphics.Point(448, 184));
					compInvCardAddGroupsSelection
						.setLayout(compInvCardAddGroupsSelectionLayout);
					{
						tableInvCardAddGroupsAllGroups = new Table(
							compInvCardAddGroupsSelection,
							SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
						GridData tableInvCardAddGroupsAllGroupsLData = new GridData();
						tableInvCardAddGroupsAllGroupsLData.widthHint = 119;
						tableInvCardAddGroupsAllGroupsLData.heightHint = 119;
						tableInvCardAddGroupsAllGroups
							.setLayoutData(tableInvCardAddGroupsAllGroupsLData);
						tableInvCardAddGroupsAllGroups.setHeaderVisible(true);
						tableInvCardAddGroupsAllGroups.setLinesVisible(true);
						tableInvCardAddGroupsAllGroups
							.setSize(new org.eclipse.swt.graphics.Point(
								141,
								141));
						{
							tableColumnInvCardAddGroupAllGroups = new TableColumn(
								tableInvCardAddGroupsAllGroups,
								SWT.NONE);
							tableColumnInvCardAddGroupAllGroups
								.setText(Messages.getString("InvUICardAdd.33")); //$NON-NLS-1$
							tableColumnInvCardAddGroupAllGroups.setWidth(141);
						}
					}
					{
						compInvCardAddGroupsButtons = new Composite(
							compInvCardAddGroupsSelection,
							SWT.NONE);
						GridLayout compInvCardAddGroupsButtonsLayout = new GridLayout(
							1,
							true);
						compInvCardAddGroupsButtonsLayout.marginWidth = 5;
						compInvCardAddGroupsButtonsLayout.marginHeight = 5;
						compInvCardAddGroupsButtonsLayout.numColumns = 1;
						compInvCardAddGroupsButtonsLayout.makeColumnsEqualWidth = true;
						compInvCardAddGroupsButtonsLayout.horizontalSpacing = 5;
						compInvCardAddGroupsButtonsLayout.verticalSpacing = 5;
						GridData compInvCardAddGroupsButtonsLData = new GridData();
						compInvCardAddGroupsButtonsLData.widthHint = 136;
						compInvCardAddGroupsButtonsLData.heightHint = 118;
						compInvCardAddGroupsButtons
							.setLayoutData(compInvCardAddGroupsButtonsLData);
						compInvCardAddGroupsButtons
							.setSize(new org.eclipse.swt.graphics.Point(
								136,
								118));
						compInvCardAddGroupsButtons
							.setLayout(compInvCardAddGroupsButtonsLayout);
						{
							btnInvCardAddGroupsRegister = new Button(
								compInvCardAddGroupsButtons,
								SWT.PUSH | SWT.CENTER);
							GridData btnInvCardAddGroupsRegisterLData = new GridData();
							btnInvCardAddGroupsRegisterLData.horizontalAlignment = GridData.CENTER;
							btnInvCardAddGroupsRegisterLData.widthHint = 44;
							btnInvCardAddGroupsRegisterLData.heightHint = 29;
							btnInvCardAddGroupsRegister
								.setLayoutData(btnInvCardAddGroupsRegisterLData);
							btnInvCardAddGroupsRegister.setText(">>"); //$NON-NLS-1$
							btnInvCardAddGroupsRegister
								.setSize(new org.eclipse.swt.graphics.Point(
									44,
									29));
							btnInvCardAddGroupsRegister
								.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnInvCardAddGroupsRegisterMouseUp(evt);
									}
								});
						}
						{
							btnInvCardAddGroupsRemove = new Button(
								compInvCardAddGroupsButtons,
								SWT.PUSH | SWT.CENTER);
							GridData btnInvCardAddGroupsRemoveLData = new GridData();
							btnInvCardAddGroupsRemoveLData.verticalAlignment = GridData.BEGINNING;
							btnInvCardAddGroupsRemoveLData.horizontalAlignment = GridData.CENTER;
							btnInvCardAddGroupsRemoveLData.widthHint = 48;
							btnInvCardAddGroupsRemoveLData.heightHint = 31;
							btnInvCardAddGroupsRemove
								.setLayoutData(btnInvCardAddGroupsRemoveLData);
							btnInvCardAddGroupsRemove.setText("<<"); //$NON-NLS-1$
							btnInvCardAddGroupsRemove
								.setSize(new org.eclipse.swt.graphics.Point(
									48,
									31));
							btnInvCardAddGroupsRemove
								.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnInvCardAddGroupsRemoveMouseUp(evt);
									}
								});
						}
						{
							btnInvCardAddNew = new Button(
								compInvCardAddGroupsButtons,
								SWT.PUSH | SWT.CENTER);
							GridData btnInvCardAddNewLData = new GridData();
							btnInvCardAddNewLData.widthHint = 129;
							btnInvCardAddNewLData.heightHint = 41;
							btnInvCardAddNewLData.horizontalSpan = 2;
							btnInvCardAddNew
								.setLayoutData(btnInvCardAddNewLData);
							btnInvCardAddNew.setText(Messages
								.getString("InvUICardAdd.37")); //$NON-NLS-1$
							btnInvCardAddNew
								.setSize(new org.eclipse.swt.graphics.Point(
									129,
									41));
							btnInvCardAddNew
								.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnInvCardAddNewMouseUp(evt);
									}
								});
						}
						compInvCardAddGroupsButtons.layout();
					}
					{
						tableInvCardAddGroupsRegisteredGroups = new Table(
							compInvCardAddGroupsSelection,
							SWT.FULL_SELECTION | SWT.BORDER);
						GridData tableInvCardAddGroupsRegisteredGroupsLData = new GridData();
						tableInvCardAddGroupsRegisteredGroupsLData.widthHint = 128;
						tableInvCardAddGroupsRegisteredGroupsLData.heightHint = 119;
						tableInvCardAddGroupsRegisteredGroups
							.setLayoutData(tableInvCardAddGroupsRegisteredGroupsLData);
						tableInvCardAddGroupsRegisteredGroups
							.setHeaderVisible(true);
						tableInvCardAddGroupsRegisteredGroups
							.setLinesVisible(true);
						tableInvCardAddGroupsRegisteredGroups
							.setSize(new org.eclipse.swt.graphics.Point(
								150,
								141));
						{
							tableColumnRegisteredGroups = new TableColumn(
								tableInvCardAddGroupsRegisteredGroups,
								SWT.NONE);
							tableColumnRegisteredGroups.setText(Messages
								.getString("InvUICardAdd.38")); //$NON-NLS-1$
							tableColumnRegisteredGroups.setWidth(146);
						}
					}
					compInvCardAddGroupsSelection.layout();
				}
				{
					btnInvCardGroupsPre = new Button(
						compInvCardAddGroups,
						SWT.PUSH | SWT.CENTER);
					GridData btnInvCardGroupsPreLData = new GridData();
					btnInvCardGroupsPreLData.widthHint = 97;
					btnInvCardGroupsPreLData.heightHint = 31;
					btnInvCardGroupsPre.setLayoutData(btnInvCardGroupsPreLData);
					btnInvCardGroupsPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
					btnInvCardGroupsPre.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnInvCardGroupsPreMouseUp(evt);
						}
					});
				}
				{
					label5 = new Label(compInvCardAddGroups, SWT.SEPARATOR
						| SWT.HORIZONTAL);
					label5.setText("label1"); //$NON-NLS-1$
					GridData label5LData = new GridData();
					label5LData.horizontalAlignment = GridData.FILL;
					label5LData.horizontalSpan = 4;
					label5.setLayoutData(label5LData);
				}
				compInvCardAddGroups.layout();

			}

			tabfldInvCardAdd.setSelection(0);
			{
				
				tabInvCardGeneral.setText(Messages.getString("InvUICardAdd.0")); //$NON-NLS-1$
				{
					compInvCardGeneral = new Composite(tabfldInvCardAdd, SWT.NONE);
					tabInvCardGeneral.setControl(compInvCardGeneral);
					GridLayout compInvCardGeneralLayout = new GridLayout(
						4,
						true);
					compInvCardGeneralLayout.marginWidth = 5;
					compInvCardGeneralLayout.marginHeight = 5;
					compInvCardGeneralLayout.numColumns = 4;
					compInvCardGeneralLayout.makeColumnsEqualWidth = false;
					compInvCardGeneralLayout.horizontalSpacing = 5;
					compInvCardGeneralLayout.verticalSpacing = 5;
					compInvCardGeneral.setLayout(compInvCardGeneralLayout);
					{
						lblInvCardCode = new CLabel(
							compInvCardGeneral,
							SWT.NONE);
						GridData lblInvCardCodeLData = new GridData();
						lblInvCardCodeLData.widthHint = 100;
						lblInvCardCodeLData.heightHint = 23;
						lblInvCardCode.setLayoutData(lblInvCardCodeLData);
						lblInvCardCode.setText(Messages
							.getString("InvUICardAdd.3")); //$NON-NLS-1$
						lblInvCardCode
							.setSize(new org.eclipse.swt.graphics.Point(100, 23));
					}
					{
						txtInvCardCode = new Text(compInvCardGeneral, SWT.NONE);
						GridData txtInvCardCodeLData = new GridData();
						txtInvCardCodeLData.widthHint = 130;
						txtInvCardCodeLData.heightHint = 15;
						txtInvCardCodeLData.horizontalSpan = 3;
						txtInvCardCode.setLayoutData(txtInvCardCodeLData);
						txtInvCardCode.setTextLimit(25);
						txtInvCardCode
							.setSize(new org.eclipse.swt.graphics.Point(136, 15));
					}
					{
						lblInvCardName = new CLabel(
							compInvCardGeneral,
							SWT.NONE);
						GridData lblInvCardNameLData = new GridData();
						lblInvCardNameLData.widthHint = 96;
						lblInvCardNameLData.heightHint = 20;
						lblInvCardName.setLayoutData(lblInvCardNameLData);
						lblInvCardName.setText("Stok Cinsi"); //$NON-NLS-1$
						lblInvCardName
							.setSize(new org.eclipse.swt.graphics.Point(96, 20));
					}
					{
						txtInvCardName = new Text(compInvCardGeneral, SWT.NONE);
						GridData txtInvCardNameLData = new GridData();
						txtInvCardNameLData.widthHint = 132;
						txtInvCardNameLData.heightHint = 16;
						txtInvCardNameLData.horizontalSpan = 3;
						txtInvCardName.setLayoutData(txtInvCardNameLData);
						txtInvCardName.setTextLimit(50);
						txtInvCardName
							.setSize(new org.eclipse.swt.graphics.Point(138, 16));
					}
					{
						lblInvCardDefinition = new CLabel(
							compInvCardGeneral,
							SWT.NONE);
						GridData lblInvCardDefinitionLData = new GridData();
						lblInvCardDefinitionLData.widthHint = 76;
						lblInvCardDefinitionLData.heightHint = 17;
						lblInvCardDefinition
							.setLayoutData(lblInvCardDefinitionLData);
						lblInvCardDefinition.setText(Messages
							.getString("InvUICardAdd.4")); //$NON-NLS-1$
						lblInvCardDefinition
							.setSize(new org.eclipse.swt.graphics.Point(76, 17));
					}
					{
						txtInvCardDefinition = new Text(
							compInvCardGeneral,
							SWT.MULTI | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL);
						GridData txtInvCardDefinitionLData = new GridData();
						txtInvCardDefinitionLData.widthHint = 187;
						txtInvCardDefinitionLData.heightHint = 46;
						txtInvCardDefinitionLData.horizontalSpan = 3;
						txtInvCardDefinition.setLayoutData(txtInvCardDefinitionLData);
						txtInvCardDefinition.setTextLimit(250);
					}
					{
						label2 = new Label(compInvCardGeneral, SWT.SEPARATOR
							| SWT.HORIZONTAL);
						label2.setText("label1"); //$NON-NLS-1$
						GridData label2LData = new GridData();
						label2LData.horizontalAlignment = GridData.FILL;
						label2LData.horizontalSpan = 4;
						label2.setLayoutData(label2LData);
					}
					{
						btnInvCardGeneral = new Button(
							compInvCardGeneral,
							SWT.PUSH | SWT.CENTER);
						GridData btnInvCardGeneralLData = new GridData();
						btnInvCardGeneralLData.verticalAlignment = GridData.END;
						btnInvCardGeneralLData.horizontalAlignment = GridData.END;
						btnInvCardGeneralLData.widthHint = 84;
						btnInvCardGeneralLData.heightHint = 32;
						btnInvCardGeneralLData.horizontalSpan = 4;
						btnInvCardGeneralLData.verticalSpan = 2;
						btnInvCardGeneralLData.grabExcessHorizontalSpace = true;
						btnInvCardGeneral.setLayoutData(btnInvCardGeneralLData);
						btnInvCardGeneral.setText(Messages
							.getString("InvUICardAdd.5")); //$NON-NLS-1$
						btnInvCardGeneral.addMouseListener(new MouseAdapter() {
							public void mouseUp(MouseEvent evt) {
								btnInvCardGeneralMouseUp(evt);
							}
						});
					}
					compInvCardGeneral.layout();
				}
			}
			
			
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
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
	tableInvPricesViewer.setColumnProperties(new String[]{Messages.getString("InvUICardAdd.14"),Messages.getString("InvUICardAdd.20"),Messages.getString("InvUICardAdd.21")}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		// Create the cell editors
	CellEditor[] editors = new CellEditor[3];

	editors[0] = new ComboBoxCellEditor(tableInvCardAddPrices,new String[]{Messages.getString("InvUICardAdd.22"),Messages.getString("InvUICardAdd.26")}); //$NON-NLS-1$ //$NON-NLS-2$

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

				    String newText = text.substring(0, e.start) + e.text + text.substring(e.end);

				    if (newText.equals("")){ //$NON-NLS-1$
				     e.doit = true;
				     return;
				    }

				    Pattern realNumberPattern = Pattern.compile("-?[0-9]+[0-9]*(([" +decimalSymbol + "][0-9]?[0-9]?)|(["+decimalSymbol+"]))?"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				    Matcher matcher = realNumberPattern.matcher(newText);
				    boolean valid = matcher.matches();

				    e.doit = valid;
 	
					
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
				item.setGrayed(true);

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
		if (txtInvCardName.getText().trim().equals("")) { 		 //$NON-NLS-1$
			msg.setMessage(Messages.getString("InvUICardAdd.41"));  //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (txtInvCardCode.getText().trim().equals("")) { 		 //$NON-NLS-1$
			msg.setMessage(Messages.getString("InvUICardAdd.43"));  //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (txtInvCardInAcc.getData()==null) { 		
			msg.setMessage(Messages.getString("InvUICardAdd.44"));  //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (txtInvCardOutAcc.getData()==null) { 		
			msg.setMessage(Messages.getString("InvUICardAdd.45"));  //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboInvCardUnits.getData(comboInvCardUnits.getText())==null){
			msg.setMessage(Messages.getString("InvUICardAdd.46"));  //$NON-NLS-1$
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
						.trim(), 	txtInvCardName.getText().trim(), txtInvCardDefinition
								.getText().trim(), txtnumInvCardMin
								.getIntValue(), txtnumInvCardMax.getIntValue(),
								txtInvCardVat.getIntValue(), txtInvCardDiscount
								.getIntValue(), accountIdBuy, accountIdSell,numTextSpecailVATPercent.getIntValue()
								,decTextSpecialVatAmount.getBigDecimalValue());

				

				// Register its Groups
                saveInvGroups(cardId);

				//Register its Units
                saveInvUnits(cardId);  
				
				// Save the price list now.
		        saveInvPrices(cardId);
		        
		    	MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("InvUICardAdd.36")); //$NON-NLS-1$
				msg.open();
				
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
        		if(type.equals(Messages.getString("InvUICardAdd.31"))){	 //$NON-NLS-1$
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
			box.setMessage(Messages.getString("InvUICardAdd.32")); //$NON-NLS-1$
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
	 * @return Returns the txtInvCardName.
	 */
	public Text getTxtInvCardName() {
		return txtInvCardName;
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
	 * @return Returns the decTextSpecialVatAmount.
	 */
	public CurrencyText getDecTextSpecialVatAmount() {
		return decTextSpecialVatAmount;
	}
	/**
	 * @return Returns the numTextSpecailVATPercent.
	 */
	public NumericText getNumTextSpecailVATPercent() {
		return numTextSpecailVATPercent;
	}
	public AccountPicker getTxtInvCardInAcc() {
		return txtInvCardInAcc;
	}
	public void setTxtInvCardInAcc(AccountPicker txtInvCardInAcc) {
		this.txtInvCardInAcc = txtInvCardInAcc;
	}
	public AccountPicker getTxtInvCardOutAcc() {
		return txtInvCardOutAcc;
	}
	public void setTxtInvCardOutAcc(AccountPicker txtInvCardOutAcc) {
		this.txtInvCardOutAcc = txtInvCardOutAcc;
	}
}