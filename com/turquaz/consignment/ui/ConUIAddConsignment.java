package com.turquaz.consignment.ui;

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
import java.util.List;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
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
import org.eclipse.swt.events.VerifyEvent;

import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLAddConsignment;
import com.turquaz.consignment.bl.ConBLAddGroups;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.ui.InvUITransactionAddDialog;

import org.eclipse.swt.widgets.Button;

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
public class ConUIAddConsignment extends org.eclipse.swt.widgets.Composite
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
	 * @return Returns the dateConsignmentDate.
	 */
	public DatePicker getDateConsignmentDate() {
		return dateConsignmentDate;
	}
	/**
	 * @param dateConsignmentDate The dateConsignmentDate to set.
	 */
	public void setDateConsignmentDate(DatePicker dateConsignmentDate) {
		this.dateConsignmentDate = dateConsignmentDate;
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
	 * @return Returns the txtBillDocumentNo.
	 */
	public Text getTxtBillDocumentNo() {
		return txtBillDocumentNo;
	}
	/**
	 * @param txtBillDocumentNo The txtBillDocumentNo to set.
	 */
	public void setTxtBillDocumentNo(Text txtBillDocumentNo) {
		this.txtBillDocumentNo = txtBillDocumentNo;
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
	private Composite compbuttons;
	private Button btnAddConsignmentRow;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnVat;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnUnitPrice;
	private TableColumn tableColumnAmount;
	private Composite compTotalsPanel;
	private NumericText txtDiscountRate;
	private Text txtBillDocumentNo;
	private CLabel lblInventoryPrice;
	private CLabel lblBillDocumentNo;
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
	private DatePicker dateConsignmentDate;
	private CLabel lblDate;
	private Text txtCurrentCard;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnInventoryCode;
	private TableColumn TableColumnVATSpecial;
	private TableColumn tableColumnUnit;
	private Button buttonConsignmentRemove;
	private Table tableConsignmentRows;
	ConBLAddGroups blAddGroup = new ConBLAddGroups();
	ConBLAddConsignment blAddCondignmetn = new ConBLAddConsignment();

	
	public ConUIAddConsignment(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(645, 526);
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
					tabItemGeneral = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGeneral.setText(Messages.getString("ConUIAddConsignment.10")); //$NON-NLS-1$
					tabItemGeneral.setImage(SWTResourceManager.getImage("icons/Home16.gif")); //$NON-NLS-1$
					tabItemGeneral.setText(Messages.getString("ConUIAddConsignment.0")); //$NON-NLS-1$

					{
						compGeneral = new Composite(cTabFolder1, SWT.NONE);
						GridLayout compGeneralLayout = new GridLayout();
						compGeneralLayout.numColumns = 2;
						compGeneral.setLayout(compGeneralLayout);
						tabItemGeneral.setControl(compGeneral);
						{
							compInfoPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout compInfoPanelLayout = new GridLayout();
							GridData compInfoPanelLData = new GridData();
							compInfoPanelLData.horizontalSpan = 2;
							compInfoPanelLData.horizontalAlignment = GridData.FILL;
							compInfoPanelLData.heightHint = 142;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
							{
								lblCurrentCard = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblCurrentCard.setText(Messages.getString("ConUIAddConsignment.1")); //$NON-NLS-1$
								GridData lblCurrentCardLData1 = new GridData();
								lblCurrentCard.setSize(88, 19);
								lblCurrentCardLData1.widthHint = 88;
								lblCurrentCardLData1.heightHint = 19;
								lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
								lblCurrentCard
									.setLayoutData(lblCurrentCardLData1);
							}
							{
								txtCurrentCard = new Text(
									compInfoPanel,
									SWT.MULTI);
								GridData txtCurrentCardLData = new GridData();
								txtCurrentCard
									.addModifyListener(new ModifyListener() {
									public void modifyText(ModifyEvent evt) {
										try {
											txtCurrentCard
												.setData(EngBLCurrentCards
													.getCards(txtCurrentCard
														.getText().trim()));
										} catch (Exception ex) {
											ex.printStackTrace();
										}

									}
									});
								txtCurrentCard.setSize(183, 16);
								txtCurrentCard.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtCurrentCardLData.widthHint = 183;
								txtCurrentCardLData.heightHint = 16;
								txtCurrentCardLData.horizontalSpan = 3;
								txtCurrentCard.setLayoutData(txtCurrentCardLData);
							}
							{
								lblDocumentNo = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblDocumentNo.setText(Messages.getString("ConUIAddConsignment.3")); //$NON-NLS-1$
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
								txtDocumentNoLData.widthHint = 106;
								txtDocumentNoLData.heightHint = 16;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lblBillDocumentNo = new CLabel(compInfoPanel, SWT.RIGHT);
								lblBillDocumentNo.setText(Messages.getString("ConUIAddConsignment.4")); //$NON-NLS-1$
								GridData lblBillDocumentNoLData = new GridData();
								lblBillDocumentNoLData.widthHint = 120;
								lblBillDocumentNoLData.heightHint = 17;
								lblBillDocumentNoLData.horizontalAlignment = GridData.END;
								lblBillDocumentNo.setLayoutData(lblBillDocumentNoLData);
							}
							{
								txtBillDocumentNo = new Text(
									compInfoPanel,
									SWT.NONE);
								GridData txtBillDocumentNoLData = new GridData();
								txtBillDocumentNoLData.widthHint = 133;
								txtBillDocumentNoLData.heightHint = 13;
								txtBillDocumentNo.setLayoutData(txtBillDocumentNoLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDate.setText(Messages.getString("ConUIAddConsignment.5")); //$NON-NLS-1$
								GridData lblDateLData = new GridData();
								lblDateLData.widthHint = 100;
								lblDateLData.heightHint = 22;
								lblDate.setLayoutData(lblDateLData);
							}
							{
								dateConsignmentDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDate.setBackground(SWTResourceManager.getColor(255, 255, 255));
								dateConsignmentDate.setFont(SWTResourceManager.getFont("Nimbus Sans L", 10, 1, false, false));
								dateConsignmentDateLData.widthHint = 143;
								dateConsignmentDateLData.heightHint = 30;
								dateConsignmentDate.setLayoutData(dateConsignmentDateLData);
							}
							{
								lblType = new CLabel(compInfoPanel, SWT.RIGHT);
								lblType.setText(Messages.getString("ConUIAddConsignment.6")); //$NON-NLS-1$
								GridData lblTypeLData = new GridData();
								lblTypeLData.widthHint = 68;
								lblTypeLData.heightHint = 15;
								lblTypeLData.horizontalAlignment = GridData.END;
								lblType.setLayoutData(lblTypeLData);
							}
							{
								comboConsignmentType = new CCombo(
									compInfoPanel,
									SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentType.setText(Messages.getString("ConUIAddConsignment.7")); //$NON-NLS-1$
								comboConsignmentTypeLData.widthHint = 85;
								comboConsignmentTypeLData.heightHint = 17;
								comboConsignmentType
									.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDiscountRate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDiscountRate.setText(Messages.getString("ConUIAddConsignment.8")); //$NON-NLS-1$
								GridData lblDiscountRateLData = new GridData();
								lblDiscountRateLData.widthHint = 99;
								lblDiscountRateLData.heightHint = 20;
								lblDiscountRate.setLayoutData(lblDiscountRateLData);
							}
							{
								txtDiscountRate = new NumericText(compInfoPanel, SWT.NONE);
								txtDiscountRate.addModifyListener(new ModifyListener(){
									public void modifyText(ModifyEvent evt){
										calculateTotals();
									}
								});
								GridData txtDiscountRateLData = new GridData();
								txtDiscountRate.setTextLimit(2);
								txtDiscountRateLData.widthHint = 105;
								txtDiscountRateLData.heightHint = 17;
								txtDiscountRate.setLayoutData(txtDiscountRateLData);
							}
							{
								lblDefinition = new CLabel(compInfoPanel, SWT.RIGHT);
								lblDefinition.setText(Messages.getString("ConUIAddConsignment.9")); //$NON-NLS-1$
								GridData lblDefinitionLData = new GridData();
								lblDefinitionLData.widthHint = 108;
								lblDefinitionLData.heightHint = 20;
								lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
								lblDefinitionLData.horizontalAlignment = GridData.END;
								lblDefinition.setLayoutData(lblDefinitionLData);
							}
							{
								txtDefinition = new Text(compInfoPanel, SWT.NONE);
								GridData txtDefinitionLData = new GridData();
								txtDefinitionLData.widthHint = 246;
								txtDefinitionLData.heightHint = 15;
								txtDefinition.setLayoutData(txtDefinitionLData);
							}
						}
						{
							compbuttons = new Composite(compGeneral, SWT.NONE);
							GridLayout composite1Layout = new GridLayout();
							GridData composite1LData = new GridData();
							composite1LData.widthHint = 43;
							composite1LData.heightHint = 81;
							composite1LData.verticalAlignment = GridData.BEGINNING;
							compbuttons.setLayoutData(composite1LData);
							composite1Layout.makeColumnsEqualWidth = true;
							compbuttons.setLayout(composite1Layout);
							{
								btnAddConsignmentRow = new Button(
									compbuttons,
									SWT.PUSH | SWT.CENTER);
								btnAddConsignmentRow
									.setImage(SWTResourceManager
										.getImage("icons/plus.gif")); //$NON-NLS-1$
								btnAddConsignmentRow
									.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										btnAddConsignmentRowMouseUp();
									}
									});
							}
							{
								buttonConsignmentRemove = new Button(
									compbuttons,
									SWT.PUSH | SWT.CENTER);
								buttonConsignmentRemove
									.setImage(SWTResourceManager
										.getImage("icons/minus.gif")); //$NON-NLS-1$
								buttonConsignmentRemove
									.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										TableItem selection[]=tableConsignmentRows.getSelection();
									    if(selection.length>0){
									       selection[0].dispose();
									    }
									}
									});
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
									.getString("ConUIAddConsignment.12")); //$NON-NLS-1$
								tableColumnInventoryCode.setWidth(98);
							}
							{
								tableColumnInventoryName = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnInventoryName.setText(Messages
									.getString("ConUIAddConsignment.13")); //$NON-NLS-1$
								tableColumnInventoryName.setWidth(106);
							}
							{
								tableColumnAmount = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnAmount.setText(Messages
									.getString("ConUIAddConsignment.14")); //$NON-NLS-1$
								tableColumnAmount.setWidth(99);
							}
							{
								tableColumnUnit = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnUnit.setText(Messages
									.getString("ConUIAddConsignment.15")); //$NON-NLS-1$
								tableColumnUnit.setWidth(54);
							}
							{
								tableColumnUnitPrice = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnUnitPrice.setText(Messages
									.getString("ConUIAddConsignment.16")); //$NON-NLS-1$
								tableColumnUnitPrice.setWidth(84);
							}
							{
								tableColumnTotalPrice = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnTotalPrice.setText(Messages
									.getString("ConUIAddConsignment.17")); //$NON-NLS-1$
								tableColumnTotalPrice.setWidth(94);
							}
							{
								tableColumnVat = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnVat.setText(Messages
									.getString("ConUIAddConsignment.18")); //$NON-NLS-1$
								tableColumnVat.setWidth(50);
							}
							{
								tableColumnVatAmount = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnVatAmount.setText(Messages
									.getString("ConUIAddConsignment.19")); //$NON-NLS-1$
								tableColumnVatAmount.setWidth(90);
							}
							{
								TableColumnVATSpecial = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								TableColumnVATSpecial.setText(Messages
									.getString("ConUIAddConsignment.20")); //$NON-NLS-1$
								TableColumnVATSpecial.setWidth(100);
							}
							{
								tableColumnCumulative = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnCumulative.setText(Messages
									.getString("ConUIAddConsignment.21")); //$NON-NLS-1$
								tableColumnCumulative.setWidth(100);
							}
						}
						{
							compTotalsPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout composite1Layout1 = new GridLayout();
							GridData composite1LData1 = new GridData();
							composite1LData1.grabExcessHorizontalSpace = true;
							composite1LData1.horizontalSpan = 2;
							composite1LData1.horizontalAlignment = GridData.FILL;
							composite1LData1.heightHint = 118;
							compTotalsPanel.setLayoutData(composite1LData1);
							composite1Layout1.numColumns = 4;
							compTotalsPanel.setLayout(composite1Layout1);
							{
								lblDiscountAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblDiscountAmount.setText(Messages.getString("ConUIAddConsignment.22")); //$NON-NLS-1$
								GridData lblDiscountAmountLData = new GridData();
								lblDiscountAmountLData.widthHint = 105;
								lblDiscountAmountLData.heightHint = 19;
								lblDiscountAmount.setLayoutData(lblDiscountAmountLData);
							}
							{
								txtDiscountAmount = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtDiscountAmountLData = new GridData();
								txtDiscountAmount.setBackground(SWTResourceManager.getColor(255,255,255));
								txtDiscountAmount.setEditable(false);
								txtDiscountAmountLData.widthHint = 191;
								txtDiscountAmountLData.heightHint = 18;
								txtDiscountAmount.setLayoutData(txtDiscountAmountLData);
							}
							{
								lblTotalAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalAmount.setText(Messages.getString("ConUIAddConsignment.23")); //$NON-NLS-1$
								GridData lblTotalAmountLData = new GridData();
								lblTotalAmountLData.widthHint = 90;
								lblTotalAmountLData.heightHint = 20;
								lblTotalAmount.setLayoutData(lblTotalAmountLData);
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
								txtTotalAmount.setLayoutData(txtTotalAmountLData);
							}
							{
								lblInventoryPrice = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblInventoryPrice.setText(Messages.getString("ConUIAddConsignment.24")); //$NON-NLS-1$
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
								lblTotalVat.setText(Messages.getString("ConUIAddConsignment.25")); //$NON-NLS-1$
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
								txtTotalVat.setBackground(SWTResourceManager.getColor(255,255,255));
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
								lblSpecialVAT.setText(Messages.getString("ConUIAddConsignment.26")); //$NON-NLS-1$
								GridData lblSpecialVATLData = new GridData();
								lblSpecialVATLData.widthHint = 94;
								lblSpecialVATLData.heightHint = 16;
								lblSpecialVAT.setLayoutData(lblSpecialVATLData);
							}
							{
								decSpecialVat = new CurrencyText(
									compTotalsPanel,
									SWT.NONE);
								GridData decSpecialVatLData = new GridData();
								decSpecialVatLData.widthHint = 191;
								decSpecialVatLData.heightHint = 19;
								decSpecialVatLData.horizontalSpan = 3;
								decSpecialVat.setLayoutData(decSpecialVatLData);
							}
						}
					}
				}
				{
					tabItemGroups = new CTabItem(cTabFolder1, SWT.NONE);

					tabItemGroups.setImage(SWTResourceManager.getImage("icons/Multi16.gif")); //$NON-NLS-1$
					tabItemGroups.setText(Messages.getString("ConUIAddConsignment.27")); //$NON-NLS-1$

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
							btnUpdateGroups.setText(Messages.getString("ConUIAddConsignment.28")); //$NON-NLS-1$
							GridData btnUpdateGroupsLData = new GridData();
							btnUpdateGroups
								.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
                                    btnUpdateGroupsClick();
								}
								});
							btnUpdateGroupsLData.widthHint = 147;
							btnUpdateGroupsLData.heightHint = 35;
							btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
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
		
		new ConUIConsignmentsGroupDialog(this.getShell(),SWT.NULL).open();
		
		fillGroupsTable();
		
		
		
		
		
	}
	public void fillGroupsTable(){
	
		try{
			
		//Fill Group Table	
		List list = blAddGroup.getConsignmentGroups();
		HashMap groupMap = new HashMap(); 
		
		
		TurqConsignmentGroup curGroup;
		
		for(int i=0; i<list.size();i++){
		curGroup = (TurqConsignmentGroup)list.get(i);
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
		
		comboConsignmentType.add(Messages.getString("ConUIAddConsignment.29")); //$NON-NLS-1$
		comboConsignmentType.add(Messages.getString("ConUIAddConsignment.30")); //$NON-NLS-1$
		
		//content assistant
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(txtCurrentCard);
		final TurquazContentAssistant assistant = new TurquazContentAssistant(adapter,3);
		adapter.appendVerifyKeyListener( new VerifyKeyListener() {
	                 public void verifyKey(VerifyEvent event) {

	                 // Check for Ctrl+Spacebar
	                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
	             
	                  assistant.showPossibleCompletions();    
	                   event.doit = false;

	                 }
	              }
		});
	}
	
	
	
	public void btnChooseMouseUp(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	    
	    System.out.println(data.getClass().getName());
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurrentCard.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName()); //$NON-NLS-1$
		txtCurrentCard.setData(curCard);
		txtDiscountRate.setText(curCard.getCardsDiscountRate().intValue());
	    }
	}
	public void btnAddConsignmentRowMouseUp(){
		
	TurqInventoryTransaction invTrans = new InvUITransactionAddDialog(this.getShell(),SWT.NULL).open();
	if(invTrans!=null){
	TableItem item = new TableItem(tableConsignmentRows,SWT.NULL);
	
	item.setData(invTrans);
	item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
							   invTrans.getTurqInventoryCard().getCardName(),
							   invTrans.getTransactionsAmountIn()+"", //$NON-NLS-1$
							   invTrans.getTurqInventoryUnit().getUnitsName(),
							   invTrans.getTransactionsUnitPrice().toString(),
							   invTrans.getTransactionsTotalPrice().toString(),
							   invTrans.getTransactionsVat()+"", //$NON-NLS-1$
							   invTrans.getTransactionsVatAmount().toString(),
							   invTrans.getTransactionsVatSpecialAmount().toString(),
							   invTrans.getTransactionsCumilativePrice().toString()});
	
		calculateTotals();
	}
	}
	
	
	public boolean verifyFields(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.ICON_WARNING);
	
		if(txtCurrentCard.getData()==null){
			msg.setMessage(Messages.getString("ConUIAddConsignment.11")); //$NON-NLS-1$
			msg.open();
			txtCurrentCard.setFocus();
			return false;
		}
		
		if(tableConsignmentRows.getItemCount()==0){
			msg.setMessage(Messages.getString("ConUIAddConsignment.31")); //$NON-NLS-1$
			msg.open();
			btnAddConsignmentRow.setFocus();
			return false;			
		}
		return true;
	}
	
	public void saveConsignmentRows(Integer consignmentID){
		try{
			TableItem items[] = tableConsignmentRows.getItems();
		     int type =0;
				if(comboConsignmentType.getText().equals(Messages.getString("ConUIAddConsignment.34"))){ //$NON-NLS-1$
					type =1;
				}
			for(int i=0;i<items.length;i++){
				blAddCondignmetn.saveConsignmentRow((TurqInventoryTransaction)items[i].getData(),consignmentID,type,txtDiscountRate.getIntValue());
				
						
			}
		
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
		
	}
	
	public void saveGroups(Integer consignmentId){
		try{
			TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
			for(int i=0;i<items.length;i++){
				if(items[i].getChecked()){
					blAddCondignmetn.registerGroup((TurqConsignmentGroup)items[i].getData(),consignmentId);
				}
				
			}
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void save(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	try{	
		if(verifyFields()){
		
		int type =0;
		if(comboConsignmentType.getText().equals(Messages.getString("ConUIAddConsignment.35"))){ //$NON-NLS-1$
			type =1;
		}
	
		TurqConsignment cons =blAddCondignmetn.saveConsignment(txtDocumentNo.getText(),
										txtDefinition.getText(),
										false,
										dateConsignmentDate.getDate(),
										(TurqCurrentCard)txtCurrentCard.getData(),
										txtDiscountRate.getIntValue(),
										txtDiscountAmount.getBigDecimalValue(),
										txtBillDocumentNo.getText(),
										txtTotalVat.getBigDecimalValue(),
										decSpecialVat.getBigDecimalValue(),
										txtTotalAmount.getBigDecimalValue(),type);
		saveConsignmentRows(cons.getConsignmentsId());
		saveGroups(cons.getConsignmentsId());
		msg.setMessage(Messages.getString("ConUIAddConsignment.36")); //$NON-NLS-1$
		msg.open();
		newForm();
		}
	}
	catch(Exception ex){
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
		 ConUIAddConsignment cardAdd = new ConUIAddConsignment(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(cardAdd);	 
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
    
    txtDiscountAmount.setText(discountTotal.toString());    
	txtSubTotal.setText(subTotal.toString());
	txtTotalVat.setText(totalVAT.toString());
	decSpecialVat.setText(totalSpecVAT.toString());
	txtTotalAmount.setText(generalTotal.subtract(discountTotal).toString());	
		
		
	}

}
