package com.turquaz.bill.ui;

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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;



import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.ui.component.TextWithButton;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearchDialog;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.SWT;


import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class BillUIBillFromConsignment extends org.eclipse.swt.widgets.Composite
implements SecureComposite{

	/**
	 * @return Returns the comboConsignmentType.
	 */
	public CCombo getComboConsignmentType() {
		return comboConsignmentType;
	}
	/**
	 * @param comboConsignmentType The comboConsignmentType to set.
	 */
	public void setComboConsignmentType(CCombo comboConsignmentType) {
		this.comboConsignmentType = comboConsignmentType;
	}
	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup() {
		return compRegisterGroup;
	}
	/**
	 * @param compRegisterGroup The compRegisterGroup to set.
	 */
	public void setCompRegisterGroup(RegisterGroupComposite compRegisterGroup) {
		this.compRegisterGroup = compRegisterGroup;
	}
	/**
	 * @return Returns the dateBillDate.
	 */
	public DatePicker getDateBillDate() {
		return dateBillDate;
	}
	/**
	 * @param dateBillDate The dateBillDate to set.
	 */
	public void setDateBillDate(DatePicker dateConsignmentDate) {
		this.dateBillDate = dateConsignmentDate;
	}
	/**
	 * @return Returns the decSpecialVat.
	 */
	public CurrencyText getDecSpecialVat() {
		return decSpecialVat;
	}
	/**
	 * @param decSpecialVat The decSpecialVat to set.
	 */
	public void setDecSpecialVat(CurrencyText decSpecialVat) {
		this.decSpecialVat = decSpecialVat;
	}
	/**
	 * @return Returns the tableConsignmentRows.
	 */
	public Table getTableConsignmentRows() {
		return tableConsignmentRows;
	}
	/**
	 * @param tableConsignmentRows The tableConsignmentRows to set.
	 */
	public void setTableConsignmentRows(Table tableConsignmentRows) {
		this.tableConsignmentRows = tableConsignmentRows;
	}
	/**
	 * @return Returns the txtCurrentCard.
	 */
	public Text getTxtCurrentCard() {
		return txtCurrentCard;
	}
	/**
	 * @param txtCurrentCard The txtCurrentCard to set.
	 */
	public void setTxtCurrentCard(Text txtCurrentCard) {
		this.txtCurrentCard = txtCurrentCard;
	}
	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition() {
		return txtDefinition;
	}
	/**
	 * @param txtDefinition The txtDefinition to set.
	 */
	public void setTxtDefinition(Text txtDefinition) {
		this.txtDefinition = txtDefinition;
	}
	/**
	 * @return Returns the txtDiscountAmount.
	 */
	public CurrencyText getTxtDiscountAmount() {
		return txtDiscountAmount;
	}
	/**
	 * @param txtDiscountAmount The txtDiscountAmount to set.
	 */
	public void setTxtDiscountAmount(CurrencyText txtDiscountAmount) {
		this.txtDiscountAmount = txtDiscountAmount;
	}
	/**
	 * @return Returns the txtDiscountRate.
	 */
	public NumericText getTxtDiscountRate() {
		return txtDiscountRate;
	}
	/**
	 * @param txtDiscountRate The txtDiscountRate to set.
	 */
	public void setTxtDiscountRate(NumericText txtDiscountRate) {
		this.txtDiscountRate = txtDiscountRate;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	/**
	 * @param txtDocumentNo The txtDocumentNo to set.
	 */
	public void setTxtDocumentNo(Text txtDocumentNo) {
		this.txtDocumentNo = txtDocumentNo;
	}
	/**
	 * @return Returns the txtSubTotal.
	 */
	public CurrencyText getTxtSubTotal() {
		return txtSubTotal;
	}
	/**
	 * @param txtSubTotal The txtSubTotal to set.
	 */
	public void setTxtSubTotal(CurrencyText txtSubTotal) {
		this.txtSubTotal = txtSubTotal;
	}
	/**
	 * @return Returns the txtTotalAmount.
	 */
	public CurrencyText getTxtTotalAmount() {
		return txtTotalAmount;
	}
	/**
	 * @param txtTotalAmount The txtTotalAmount to set.
	 */
	public void setTxtTotalAmount(CurrencyText txtTotalAmount) {
		this.txtTotalAmount = txtTotalAmount;
	}
	/**
	 * @return Returns the txtTotalVat.
	 */
	public CurrencyText getTxtTotalVat() {
		return txtTotalVat;
	}
	/**
	 * @param txtTotalVat The txtTotalVat to set.
	 */
	public void setTxtTotalVat(CurrencyText txtTotalVat) {
		this.txtTotalVat = txtTotalVat;
	}
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Composite compInfoPanel;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnVat;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnUnitPrice;
	private TableColumn tableColumnAmount;
	private Composite compTotalsPanel;
	private CLabel lblInventoryPrice;
	private DatePicker dateDueDate;
	private CLabel lblDueDate;
	private AccountPicker accountPickerCurAcc;
	private CLabel lblCashAccount;
	private CCombo comboPaymentType;
	private CLabel lblPaymentType;
	private NumericText txtDiscountRate;
	private DatePicker dateConsDate;
	private CLabel lblConsignmentDate;
	private TextWithButton txtConsignment;
	private CLabel lblConsignmet;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CurrencyText decSpecialVat;
	private Label lblSpecialVAT;
	private TableColumn tableColumnCumulative;
	private Button btnUpdateGroups;
	private RegisterGroupComposite compRegisterGroup;
	private Composite composite1;
	private CTabItem tabItemGroups;
	private Composite compGeneral;
	private CTabItem tabItemGeneral;
	private CTabFolder cTabFolder1;
	private CCombo comboConsignmentType;
	private CLabel lblType;
	private CurrencyText txtDiscountAmount;
	private CLabel lblDiscountAmount;
	private CurrencyText txtTotalAmount;
	private CLabel lblTotalAmount;
	private CurrencyText txtSubTotal;
	private CurrencyText txtTotalVat;
	private CLabel lblTotalVat;
	private CLabel lblDiscountRate;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateBillDate;
	private CLabel lblDate;
	private Text txtCurrentCard;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnInventoryCode;
	private TableColumn TableColumnVATSpecial;
	private TableColumn tableColumnUnit;
	private Table tableConsignmentRows;
	BillBLAddGroups blAddGroup = new BillBLAddGroups();
	BillBLAddBill blAddBill = new BillBLAddBill();

	
	public BillUIBillFromConsignment(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
	try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(633, 527);
			{
				cTabFolder1 = new CTabFolder(this, SWT.NONE);
				cTabFolder1.setSize(56, 25);
				GridData cTabFolder1LData = new GridData();
				cTabFolder1LData.grabExcessHorizontalSpace = true;
				cTabFolder1LData.grabExcessVerticalSpace = true;
				cTabFolder1LData.horizontalAlignment = GridData.FILL;
				cTabFolder1LData.verticalAlignment = GridData.FILL;
				cTabFolder1.setLayoutData(cTabFolder1LData);
				{
					tabItemGroups = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGroups.setText(Messages.getString("BillUIBillFromConsignment.28")); //$NON-NLS-1$
					tabItemGroups.setImage(SWTResourceManager.getImage("icons/Multi16.gif")); //$NON-NLS-1$
					{
						composite1 = new Composite(cTabFolder1, SWT.NONE);
						tabItemGroups.setControl(composite1);
						GridLayout composite1Layout2 = new GridLayout();
						composite1Layout2.makeColumnsEqualWidth = true;
						composite1.setLayout(composite1Layout2);
						{
							compRegisterGroup = new RegisterGroupComposite(
								composite1,
								SWT.NONE);
							GridData compRegisterGroupLData = new GridData();
							compRegisterGroupLData.widthHint = 182;
							compRegisterGroupLData.heightHint = 171;
							compRegisterGroup.setLayoutData(compRegisterGroupLData);
						}
						{
							btnUpdateGroups = new Button(composite1, SWT.PUSH
								| SWT.CENTER);
							btnUpdateGroups.setText(Messages.getString("BillUIBillFromConsignment.30")); //$NON-NLS-1$
							GridData btnUpdateGroupsLData = new GridData();
							btnUpdateGroups
								.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
                                    btnUpdateGroupsClick();
								}
								});
							btnUpdateGroupsLData.widthHint = 112;
							btnUpdateGroupsLData.heightHint = 22;
							btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
						}
					}
				}
				{
					tabItemGeneral = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGeneral.setText(Messages
						.getString("BillUIBillFromConsignment.0")); //$NON-NLS-1$
					tabItemGeneral.setImage(SWTResourceManager
						.getImage("icons/Home16.gif")); //$NON-NLS-1$
					{
						compGeneral = new Composite(cTabFolder1, SWT.NONE);
						GridLayout compGeneralLayout = new GridLayout();
						compGeneral.setLayout(compGeneralLayout);
						tabItemGeneral.setControl(compGeneral);
						{
							compInfoPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout compInfoPanelLayout = new GridLayout();
							GridData compInfoPanelLData = new GridData();
							compInfoPanelLData.horizontalSpan = 2;
							compInfoPanelLData.horizontalAlignment = GridData.FILL;
							compInfoPanelLData.heightHint = 188;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
							{
								lblConsignmet = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblConsignmet.setText(Messages
									.getString("BillUIBillFromConsignment.2")); //$NON-NLS-1$
								GridData lblConsignmetLData = new GridData();
								lblConsignmetLData.widthHint = 118;
								lblConsignmetLData.heightHint = 23;
								lblConsignmet.setLayoutData(lblConsignmetLData);
							}
							{
								txtConsignment = new TextWithButton(
									compInfoPanel,
									SWT.NONE);
								GridData txtConsignmentLData = new GridData();
								txtConsignment
									.addMouseListener(new MouseAdapter() {
										public void mouseUp(MouseEvent evt) {
											chooseConsignmentMouseUp();
										}
									});
								txtConsignment.setText(Messages
									.getString("BillUIBillFromConsignment.3")); //$NON-NLS-1$
								txtConsignmentLData.widthHint = 200;
								txtConsignmentLData.heightHint = 21;
								txtConsignment
									.setLayoutData(txtConsignmentLData);
							}
							{
								lblConsignmentDate = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblConsignmentDate.setText(Messages
									.getString("BillUIBillFromConsignment.4")); //$NON-NLS-1$
								GridData lblConsignmentDateLData = new GridData();
								lblConsignmentDateLData.widthHint = 94;
								lblConsignmentDateLData.heightHint = 18;
								lblConsignmentDate.setLayoutData(lblConsignmentDateLData);
							}
							{
								dateConsDate = new DatePicker(
									compInfoPanel,
									SWT.NONE);
								GridData dateConsDateLData = new GridData();
								dateConsDate.setEnabled(false);
								dateConsDateLData.widthHint = 118;
								dateConsDateLData.heightHint = 25;
								dateConsDate.setLayoutData(dateConsDateLData);
							}
							{
								lblCurrentCard = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblCurrentCard.setText(Messages
									.getString("BillUIBillFromConsignment.5")); //$NON-NLS-1$
								GridData lblCurrentCardLData1 = new GridData();
								lblCurrentCardLData1.widthHint = 86;
								lblCurrentCardLData1.heightHint = 19;
								lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
								lblCurrentCard.setLayoutData(lblCurrentCardLData1);
							}
							{
								txtCurrentCard = new Text(
									compInfoPanel,
									SWT.MULTI);
								GridData txtCurrentCardLData = new GridData();
								txtCurrentCard.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtCurrentCard.setEditable(false);
								txtCurrentCardLData.widthHint = 179;
								txtCurrentCardLData.heightHint = 19;
								txtCurrentCard.setLayoutData(txtCurrentCardLData);
							}
							{
								lblDocumentNo = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblDocumentNo.setText(Messages
									.getString("BillUIBillFromConsignment.6")); //$NON-NLS-1$
								GridData lblDocumentNoLData = new GridData();
								lblDocumentNoLData.widthHint = 107;
								lblDocumentNoLData.heightHint = 15;
								lblDocumentNo.setLayoutData(lblDocumentNoLData);
							}
							{
								txtDocumentNo = new Text(
									compInfoPanel,
									SWT.NONE);
								GridData txtDocumentNoLData = new GridData();
								txtDocumentNo.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtDocumentNo.setEditable(false);
								txtDocumentNoLData.widthHint = 114;
								txtDocumentNoLData.heightHint = 16;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDate.setText(Messages
									.getString("BillUIBillFromConsignment.7")); //$NON-NLS-1$
								GridData lblDateLData = new GridData();
								lblDateLData.widthHint = 70;
								lblDateLData.heightHint = 21;
								lblDate.setLayoutData(lblDateLData);
							}
							{
								dateBillDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDateLData.widthHint = 109;
								dateConsignmentDateLData.heightHint = 21;
								dateBillDate.setLayoutData(dateConsignmentDateLData);
							}
							{
								lblType = new CLabel(compInfoPanel, SWT.LEFT);
								lblType.setText(Messages
									.getString("BillUIBillFromConsignment.8")); //$NON-NLS-1$
								GridData lblTypeLData = new GridData();
								lblTypeLData.widthHint = 62;
								lblTypeLData.heightHint = 14;
								lblTypeLData.verticalAlignment = GridData.BEGINNING;
								lblType.setLayoutData(lblTypeLData);
							}
							{
								comboConsignmentType = new CCombo(
									compInfoPanel,
									SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentType.setEnabled(false);
								comboConsignmentType
									.setBackground(SWTResourceManager.getColor(
										255,
										255,
										255));
								comboConsignmentType.setEditable(false);
								comboConsignmentType.setText(Messages
									.getString("BillUIBillFromConsignment.9")); //$NON-NLS-1$
								comboConsignmentTypeLData.widthHint = 81;
								comboConsignmentTypeLData.heightHint = 21;
								comboConsignmentType.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDiscountRate = new CLabel(
									compInfoPanel,
									SWT.LEFT);
								lblDiscountRate.setText(Messages
									.getString("BillUIBillFromConsignment.10")); //$NON-NLS-1$
								GridData lblDiscountRateLData = new GridData();
								lblDiscountRateLData.widthHint = 96;
								lblDiscountRateLData.heightHint = 15;
								lblDiscountRate
									.setLayoutData(lblDiscountRateLData);
							}
							{
								txtDiscountRate = new NumericText(
									compInfoPanel,
									SWT.NONE);
								txtDiscountRate.setTextLimit(2);
								GridData txtDiscountRateLData = new GridData();
								txtDiscountRate.setSize(107, 20);
								txtDiscountRate
									.addModifyListener(new ModifyListener() {
										public void modifyText(ModifyEvent evt) {
											calculateTotals();
										}
									});
								txtDiscountRateLData.widthHint = 107;
								txtDiscountRateLData.heightHint = 20;
								txtDiscountRate
									.setLayoutData(txtDiscountRateLData);
							}
							{
								lblDefinition = new CLabel(
									compInfoPanel,
									SWT.LEFT);
								lblDefinition.setText(Messages
									.getString("BillUIBillFromConsignment.11")); //$NON-NLS-1$
								GridData lblDefinitionLData = new GridData();
								lblDefinitionLData.widthHint = 108;
								lblDefinitionLData.heightHint = 20;
								lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
								lblDefinition.setLayoutData(lblDefinitionLData);
							}
							{
								txtDefinition = new Text(
									compInfoPanel,
									SWT.NONE);
								GridData txtDefinitionLData = new GridData();
								txtDefinitionLData.widthHint = 160;
								txtDefinitionLData.heightHint = 35;
								txtDefinition.setLayoutData(txtDefinitionLData);
							}
							{
								lblPaymentType = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblPaymentType.setText(Messages.getString("BillUIBillFromConsignment.1")); //$NON-NLS-1$
							}
							{
								comboPaymentType = new CCombo(
									compInfoPanel,
									SWT.NONE);
								GridData comboPaymentTypeLData = new GridData();
								comboPaymentType
									.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(
										SelectionEvent evt) {
										Boolean isCurrent=(Boolean)comboPaymentType.getData(comboPaymentType.getText());
										if (isCurrent.booleanValue())
											accountPickerCurAcc.setEnabled(true);
										else
											accountPickerCurAcc.setEnabled(false);
									}
									});
								comboPaymentTypeLData.widthHint = 58;
								comboPaymentTypeLData.heightHint = 10;
								comboPaymentType.setLayoutData(comboPaymentTypeLData);
							}
                            {
                                lblDueDate = new CLabel(compInfoPanel, SWT.NONE);
                                lblDueDate.setText("Vade Tarihi");
                            }
                            {
                                dateDueDate = new DatePicker(
                                    compInfoPanel,
                                    SWT.NONE);
                                GridData dateDueDateLData = new GridData();
                                dateDueDateLData.widthHint = 110;
                                dateDueDateLData.heightHint = 22;
                                dateDueDate.setLayoutData(dateDueDateLData);
                            }
							{
								lblCashAccount = new CLabel(compInfoPanel, SWT.NONE);
								lblCashAccount.setText(Messages.getString("BillUIBillFromConsignment.35"));  //$NON-NLS-1$
								GridData lblKasaLData = new GridData();
								lblKasaLData.widthHint = 93;
								lblKasaLData.heightHint = 16;
								lblCashAccount.setLayoutData(lblKasaLData);
							}
							{
								accountPickerCurAcc = new AccountPicker(
									compInfoPanel,
									SWT.NONE);
								accountPickerCurAcc.setEnabled(false);
								
								GridData accountPickerCurAccLData = new GridData();
								accountPickerCurAccLData.widthHint = 134;
								accountPickerCurAccLData.heightHint = 17;
								accountPickerCurAcc.setLayoutData(accountPickerCurAccLData);
							}
						}
						{
							tableConsignmentRows = new Table(
								compGeneral,
								SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
							GridData tableConsignmentRowsLData = new GridData();
							tableConsignmentRows.setLinesVisible(true);
							tableConsignmentRows.setHeaderVisible(true);
							tableConsignmentRowsLData.grabExcessHorizontalSpace = true;
							tableConsignmentRowsLData.grabExcessVerticalSpace = true;
							tableConsignmentRowsLData.horizontalAlignment = GridData.FILL;
							tableConsignmentRowsLData.verticalAlignment = GridData.FILL;
							tableConsignmentRows
								.setLayoutData(tableConsignmentRowsLData);
							{
								tableColumnInventoryCode = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnInventoryCode.setText(Messages
									.getString("BillUIBillFromConsignment.13")); //$NON-NLS-1$
								tableColumnInventoryCode.setWidth(98);
							}
							{
								tableColumnInventoryName = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnInventoryName.setText(Messages
									.getString("BillUIBillFromConsignment.14")); //$NON-NLS-1$
								tableColumnInventoryName.setWidth(106);
							}
							{
								tableColumnAmount = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnAmount.setText(Messages
									.getString("BillUIBillFromConsignment.15")); //$NON-NLS-1$
								tableColumnAmount.setWidth(99);
							}
							{
								tableColumnUnit = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnUnit.setText(Messages
									.getString("BillUIBillFromConsignment.16")); //$NON-NLS-1$
								tableColumnUnit.setWidth(54);
							}
							{
								tableColumnUnitPrice = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								tableColumnUnitPrice.setText(Messages
									.getString("BillUIBillFromConsignment.17")); //$NON-NLS-1$
								tableColumnUnitPrice.setWidth(70);
							}
							{
								tableColumnTotalPrice = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								tableColumnTotalPrice.setText(Messages
									.getString("BillUIBillFromConsignment.18")); //$NON-NLS-1$
								tableColumnTotalPrice.setWidth(77);
							}
							{
								tableColumnVat = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								tableColumnVat.setText(Messages
									.getString("BillUIBillFromConsignment.19")); //$NON-NLS-1$
								tableColumnVat.setWidth(50);
							}
							{
								tableColumnVatAmount = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								tableColumnVatAmount.setText(Messages
									.getString("BillUIBillFromConsignment.20")); //$NON-NLS-1$
								tableColumnVatAmount.setWidth(90);
							}
							{
								TableColumnVATSpecial = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								TableColumnVATSpecial.setText(Messages
									.getString("BillUIBillFromConsignment.21")); //$NON-NLS-1$
								TableColumnVATSpecial.setWidth(100);
							}
							{
								tableColumnCumulative = new TableColumn(
									tableConsignmentRows,
									SWT.RIGHT);
								tableColumnCumulative.setText(Messages
									.getString("BillUIBillFromConsignment.22")); //$NON-NLS-1$
								tableColumnCumulative.setWidth(100);
							}
						}
						{
							compTotalsPanel = new Composite(
								compGeneral,
								SWT.NONE);
							GridLayout composite1Layout1 = new GridLayout();
							GridData composite1LData1 = new GridData();
							composite1LData1.grabExcessHorizontalSpace = true;
							composite1LData1.horizontalSpan = 2;
							composite1LData1.horizontalAlignment = GridData.FILL;
							composite1LData1.heightHint = 126;
							compTotalsPanel.setLayoutData(composite1LData1);
							composite1Layout1.numColumns = 4;
							compTotalsPanel.setLayout(composite1Layout1);
							{
								lblDiscountAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblDiscountAmount.setText(Messages
									.getString("BillUIBillFromConsignment.23")); //$NON-NLS-1$
								GridData lblDiscountAmountLData = new GridData();
								lblDiscountAmountLData.widthHint = 105;
								lblDiscountAmountLData.heightHint = 19;
								lblDiscountAmount
									.setLayoutData(lblDiscountAmountLData);
							}
							{
								txtDiscountAmount = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtDiscountAmountLData = new GridData();
								txtDiscountAmount
									.setBackground(SWTResourceManager.getColor(
										255,
										255,
										255));
								txtDiscountAmount.setEditable(false);
								txtDiscountAmountLData.widthHint = 191;
								txtDiscountAmountLData.heightHint = 18;
								txtDiscountAmount
									.setLayoutData(txtDiscountAmountLData);
							}
							{
								lblTotalAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalAmount.setText(Messages
									.getString("BillUIBillFromConsignment.24")); //$NON-NLS-1$
								GridData lblTotalAmountLData = new GridData();
								lblTotalAmount.setSize(87, 19);
								lblTotalAmountLData.widthHint = 87;
								lblTotalAmountLData.heightHint = 19;
								lblTotalAmount
									.setLayoutData(lblTotalAmountLData);
							}
							{
								txtTotalAmount = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtTotalAmountLData = new GridData();
								txtTotalAmount.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtTotalAmount.setEditable(false);
								txtTotalAmountLData.widthHint = 197;
								txtTotalAmountLData.heightHint = 17;
								txtTotalAmount
									.setLayoutData(txtTotalAmountLData);
							}
							{
								lblInventoryPrice = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblInventoryPrice.setText(Messages
									.getString("BillUIBillFromConsignment.25")); //$NON-NLS-1$
								GridData lblInventoryPriceLData = new GridData();
								lblInventoryPrice.setSize(87, 19);
								lblInventoryPriceLData.widthHint = 87;
								lblInventoryPriceLData.heightHint = 19;
								lblInventoryPrice
									.setLayoutData(lblInventoryPriceLData);
							}
							{
								txtSubTotal = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData text1LData = new GridData();
								txtSubTotal.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtSubTotal.setEditable(false);
								text1LData.widthHint = 190;
								text1LData.heightHint = 19;
								text1LData.horizontalSpan = 3;
								txtSubTotal.setLayoutData(text1LData);
							}
							{
								lblTotalVat = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalVat.setText(Messages
									.getString("BillUIBillFromConsignment.26")); //$NON-NLS-1$
								GridData lblTotalVatLData = new GridData();
								lblTotalVat.setSize(87, 19);
								lblTotalVatLData.widthHint = 87;
								lblTotalVatLData.heightHint = 19;
								lblTotalVat.setLayoutData(lblTotalVatLData);
							}
							{
								txtTotalVat = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtTotalVatLData = new GridData();
								txtTotalVat.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtTotalVat.setEditable(false);
								txtTotalVatLData.widthHint = 190;
								txtTotalVatLData.heightHint = 19;
								txtTotalVatLData.horizontalSpan = 3;
								txtTotalVat.setLayoutData(txtTotalVatLData);
							}
							{
								lblSpecialVAT = new Label(
									compTotalsPanel,
									SWT.NONE);
								lblSpecialVAT.setText(Messages
									.getString("BillUIBillFromConsignment.27")); //$NON-NLS-1$
								GridData lblSpecialVATLData = new GridData();
								lblSpecialVATLData.widthHint = 104;
								lblSpecialVATLData.heightHint = 16;
								lblSpecialVAT.setLayoutData(lblSpecialVATLData);
							}
							{
								decSpecialVat = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData decSpecialVatLData = new GridData();
								decSpecialVat.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								decSpecialVat.setEditable(false);
								decSpecialVatLData.widthHint = 191;
								decSpecialVatLData.heightHint = 19;
								decSpecialVatLData.horizontalSpan = 3;
								decSpecialVat.setLayoutData(decSpecialVatLData);
							}
						}
					}
				}
			}
			this.layout();
			postInitGui();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void btnUpdateGroupsClick(){
		
		new BillUIBillsGroupDialog(this.getShell(),SWT.NULL).open();
		
		fillGroupsTable();
		
		
		
		
		
	}
	public void fillGroupsTable(){
	
		try{
			
		//Fill Group Table	
		List list = blAddGroup.getBillGroups();
		HashMap groupMap = new HashMap(); 
		
		
		TurqBillGroup curGroup;
		
		for(int i=0; i<list.size();i++){
		curGroup = (TurqBillGroup)list.get(i);
		groupMap.put(curGroup.getGroupsName(),curGroup);
		}
		
		compRegisterGroup.fillTableAllGroups(groupMap);	
		
		
		
		
		}
		catch(Exception ex){
		
			ex.printStackTrace();
		}
		
	}
	public void postInitGui(){
		cTabFolder1.setSelection(tabItemGeneral);
		
		fillGroupsTable();
		
		//fill combo type
		
		comboConsignmentType.add(Messages.getString("BillUIBillFromConsignment.31")); //$NON-NLS-1$
		comboConsignmentType.add(Messages.getString("BillUIBillFromConsignment.32")); //$NON-NLS-1$
		
		comboPaymentType.add("Cari"); //$NON-NLS-1$
		comboPaymentType.setData("Cari",new Boolean(false)); //$NON-NLS-1$
		comboPaymentType.add("Nakit"); //$NON-NLS-1$
		comboPaymentType.setData("Nakit",new Boolean(true)); //$NON-NLS-1$
		comboPaymentType.setText("Cari"); //$NON-NLS-1$
	}
	
	
	
	
	
	public boolean verifyFields(){
		MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
		if (txtConsignment.getData()==null)
		{
			msg.setMessage(Messages.getString("BillUIBillFromConsignment.12")); //$NON-NLS-1$
			msg.open();
			txtConsignment.setFocus();
			return false;
		}
		
		
		Boolean isCurrent=(Boolean)comboPaymentType.getData(comboPaymentType.getText());
		if (isCurrent.booleanValue())
		{
			if (accountPickerCurAcc.getData()==null)
			{
				msg.setMessage(Messages.getString("BillUIBillFromConsignment.36")); //$NON-NLS-1$
				msg.open();
				accountPickerCurAcc.setFocus();
				return false;
			}
		}
		return true;
	}
	
	
	public void saveGroups(Integer consignmentId){
		try{
			TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
			for(int i=0;i<items.length;i++){
				if(items[i].getChecked()){
					blAddBill.registerGroup((TurqBillGroup)items[i].getData(),consignmentId);
				}
				
			}
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		try
		{	
			if(verifyFields())
			{
			
				int type =0;
				if(comboConsignmentType.getText().equals(Messages.getString("BillUIBillFromConsignment.33"))){ //$NON-NLS-1$
					type =1;
				}
				TurqConsignment consignment = (TurqConsignment)txtConsignment.getData();
	     
				Boolean paymentType = (Boolean)comboPaymentType.getData(comboPaymentType.getText());
	     
				TurqBill bill =blAddBill.saveBill(txtDocumentNo.getText(),
										txtDefinition.getText(),
										false,
										dateBillDate.getDate(),
										consignment,
										type,
										!paymentType.booleanValue(),
										paymentType.booleanValue() ? accountPickerCurAcc.getData() : null,
										 dateDueDate.getDate());
		
				saveGroups(bill.getBillsId());
				msg.setMessage(Messages.getString("BillUIBillFromConsignment.34")); //$NON-NLS-1$
				msg.open();
				newForm();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
	}
	public void delete(){
		
	}
	public void search(){
		
	}
	public void newForm(){
	    BillUIBillFromConsignment  curCard = new BillUIBillFromConsignment(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();
		
		
	}
	
	public void calculateTotals(){
		
	TableItem items[] = tableConsignmentRows.getItems();
	BigDecimal subTotal = new BigDecimal(0);
	BigDecimal totalVAT = new BigDecimal(0);
	BigDecimal totalSpecVAT = new BigDecimal(0);
	BigDecimal generalTotal = new BigDecimal(0);
	BigDecimal discountTotal = new BigDecimal(0);
	
	
	for(int i =0;i<items.length;i++){
		subTotal = subTotal.add(new BigDecimal(items[i].getText(5)));
		totalVAT = totalVAT.add(new BigDecimal(items[i].getText(7)));
		totalSpecVAT = totalSpecVAT.add(new BigDecimal(items[i].getText(8)));
		
	}
	
	generalTotal = subTotal.add(totalVAT).add(totalSpecVAT);
    double discountRate = (double)txtDiscountRate.getIntValue()/100;
  
   
 
    discountTotal = generalTotal.multiply(new BigDecimal(discountRate+"")).setScale(2, BigDecimal.ROUND_DOWN);; //$NON-NLS-1$
       
    totalSpecVAT = totalSpecVAT.subtract(totalSpecVAT.multiply(new BigDecimal(discountRate+""))).setScale(2,BigDecimal.ROUND_DOWN); //$NON-NLS-1$
    
    subTotal = subTotal.subtract(subTotal.multiply(new BigDecimal(discountRate+""))).setScale(2, BigDecimal.ROUND_DOWN); //$NON-NLS-1$
    
    totalVAT = totalVAT.subtract(totalVAT.multiply(new BigDecimal(discountRate+""))).setScale(2, BigDecimal.ROUND_DOWN); //$NON-NLS-1$
    
    txtDiscountAmount.setText(discountTotal);    
	txtSubTotal.setText(subTotal);
	txtTotalVat.setText(totalVAT);
	decSpecialVat.setText(totalSpecVAT);
	txtTotalAmount.setText(generalTotal.subtract(discountTotal));	
		
		
	}
	
	public void chooseConsignmentMouseUp(){
	TurqConsignment cons = new ConUIConsignmentSearchDialog(this.getShell(),SWT.NULL).open();
	
	if(cons!=null){
	try{   
    ConBLUpdateConsignment.initiliazeConsignment(cons);
	txtConsignment.setData(cons);	
	
	TurqBillConsignmentCommon common = cons.getTurqBillConsignmentCommon();
		
	txtCurrentCard.setText(common.getTurqCurrentCard().getCardsCurrentCode()+" - "+common.getTurqCurrentCard().getCardsName()); //$NON-NLS-1$
	txtCurrentCard.setData(common.getTurqCurrentCard());
	txtDocumentNo.setText(common.getBillDocumentNo());
	dateConsDate.setDate(cons.getConsignmentsDate());
    txtConsignment.setText(cons.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
	
	Iterator it = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
	
	TableItem item;
	TurqInventoryTransaction invTrans;
	
    tableConsignmentRows.removeAll(); 
    	
	while(it.hasNext()){
		/**
		 * TODO Amount In is wrong....
		 */
		
		
    	invTrans = (TurqInventoryTransaction)it.next();
    	
    	BigDecimal amount = invTrans.getTransactionsAmountIn();
    	if(amount.compareTo(new BigDecimal(0))<1)
    	{
    		amount = invTrans.getTransactionsTotalAmountOut();
    	}
    	
    	
    	item = new TableItem(tableConsignmentRows,SWT.NULL);
    	item.setData(invTrans);
    	item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
				   invTrans.getTurqInventoryCard().getCardName(),
				    amount+"", //$NON-NLS-1$
				   invTrans.getTurqInventoryUnit().getUnitsName(),
				   invTrans.getTransactionsUnitPrice().toString(),
				   invTrans.getTransactionsTotalPrice().toString(),
				   invTrans.getTransactionsVat()+"", //$NON-NLS-1$
				   invTrans.getTransactionsVatAmount().toString(),
				   invTrans.getTransactionsVatSpecialAmount().toString(),
				   invTrans.getTransactionsCumilativePrice().toString()});

    	
    	
    }	
	String type = Messages.getString("BillUIBillFromConsignment.29"); //$NON-NLS-1$
	
	if(cons.getConsignmentsType()==1){
		type=Messages.getString("BillUIBillFromConsignment.43"); //$NON-NLS-1$
	}
	comboConsignmentType.setText(type);
	
	txtDiscountRate.setText(common.getDiscountRate());
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	    EngUICommon.showMessageBox(getShell(),ex.getMessage(),SWT.ICON_ERROR);
	}
	
	}		
	}

}
