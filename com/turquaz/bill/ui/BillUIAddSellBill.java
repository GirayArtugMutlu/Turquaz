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
 * @author  Huseyin Ergun
 * @version  $Id$
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.consignment.bl.ConBLAddConsignment;

import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.editors.InventoryCellEditor;
import com.turquaz.engine.ui.editors.NumericCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.ui.InvUITransactionAddDialog;
import com.turquaz.inventory.ui.InvUITransactionTableRow;

import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.SWT;


import com.turquaz.accounting.ui.comp.AccountPicker;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class BillUIAddSellBill extends Composite
		implements SecureComposite {

	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup() {
		return compRegisterGroup;
	}

	/**
	 * @param compRegisterGroup
	 *            The compRegisterGroup to set.
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
	 * @param dateConsignmentDate
	 *            The dateConsignmentDate to set.
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
	 * @param decSpecialVat
	 *            The decSpecialVat to set.
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
	 * @param tableConsignmentRows
	 *            The tableConsignmentRows to set.
	 */
	public void setTableConsignmentRows(Table tableConsignmentRows) {
		this.tableConsignmentRows = tableConsignmentRows;
	}

	/**
	 * @return Returns the txtConsignmentDocumentNo.
	 */
	public Text getTxtConsignmentDocumentNo() {
		return txtConsignmentDocumentNo;
	}

	/**
	 * @param txtConsignmentDocumentNo
	 *            The txtConsignmentDocumentNo to set.
	 */
	public void setTxtConsignmentDocumentNo(Text txtBillDocumentNo) {
		this.txtConsignmentDocumentNo = txtBillDocumentNo;
	}

	/**
	 * @return Returns the txtCurrentCard.
	 */
	public CurrentPicker getTxtCurrentCard() {
		return txtCurrentCard;
	}

	/**
	 * @param txtCurrentCard
	 *            The txtCurrentCard to set.
	 */
	public void setTxtCurrentCard(CurrentPicker txtCurrentCard) {
		this.txtCurrentCard = txtCurrentCard;
	}

	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition() {
		return txtDefinition;
	}

	/**
	 * @param txtDefinition
	 *            The txtDefinition to set.
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
	 * @param txtDiscountAmount
	 *            The txtDiscountAmount to set.
	 */
	public void setTxtDiscountAmount(CurrencyText txtDiscountAmount) {
		this.txtDiscountAmount = txtDiscountAmount;
	}


	

	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}

	/**
	 * @param txtDocumentNo
	 *            The txtDocumentNo to set.
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
	 * @param txtSubTotal
	 *            The txtSubTotal to set.
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
	 * @param txtTotalAmount
	 *            The txtTotalAmount to set.
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
	 * @param txtTotalVat
	 *            The txtTotalVat to set.
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

	private Composite compTotalsPanel;

	private CCombo comboPaymentType;

	private Label lblPaymentType;

	private Text txtConsignmentDocumentNo;

	private CLabel lblInventoryPrice;
	private DatePicker dateDueDate;
	private CLabel lblDueDate;
	private AccountPicker accountPickerCurAcc;
	private CLabel lblCashAccount;
	private CCombo comboWareHouse;
	private CLabel lblWareHouse;
	public TableViewer tableViewer;
	private TableColumn tableColumn12;
	private TableColumn tableColumn11;
	private TableColumn tableColumn10;
	private TableColumn tableColumn9;
	private TableColumn tableColumn8;
	private TableColumn tableColumn7;
	private TableColumn tableColumnDiscountRate;
	private TableColumn tableColumn6;
	private TableColumn tableColumn3;
	private TableColumn tableColumn4;
	private TableColumn tableColumn5;
	private TableColumn tableColumn;
	private TableColumn tableColumn2;
	private TableColumn tableColumn1;
	private Table tableConsignmentRows;

	private CLabel lblBillDocumentNo;

	private Text txtDefinition;

	private CLabel lblDefinition;

	private CurrencyText decSpecialVat;

	private Label lblSpecialVAT;

	private Button btnUpdateGroups;

	private RegisterGroupComposite compRegisterGroup;

	private Composite composite1;

	private CTabItem tabItemGroups;

	private Composite compGeneral;

	private CTabItem tabItemGeneral;

	private CTabFolder cTabFolder1;

	private CurrencyText txtDiscountAmount;

	private CLabel lblDiscountAmount;

	private CurrencyText txtTotalAmount;

	private CLabel lblTotalAmount;

	private CurrencyText txtSubTotal;

	private CurrencyText txtTotalVat;

	private CLabel lblTotalVat;

	private Text txtDocumentNo;

	private CLabel lblDocumentNo;

	private DatePicker dateConsignmentDate;

	private CLabel lblDate;

	private CurrentPicker txtCurrentCard;

	private CLabel lblCurrentCard;

	BillBLAddGroups blAddGroup = new BillBLAddGroups();

	BillBLAddBill blAddBill = new BillBLAddBill();

	ConBLAddConsignment blAddConsignment = new ConBLAddConsignment();
	
	private final int BILL_TYPE = 1;
	
//	 Set the table column property names
	private final String INVENTORY_CODE             = Messages.getString("BillUIAddSellBill.0"); //$NON-NLS-1$
	private final String INVENTORY_NAME   	        = Messages.getString("BillUIAddSellBill.1"); //$NON-NLS-1$
	private final String TRANS_AMOUNT               = Messages.getString("BillUIAddSellBill.2"); //$NON-NLS-1$
	private final String UNIT						= Messages.getString("BillUIAddSellBill.3"); //$NON-NLS-1$
	private final String TRANS_AMOUNT_IN_BASE_UNIT 	= Messages.getString("BillUIAddSellBill.4"); //$NON-NLS-1$
	private final String BASE_UNIT 		            = Messages.getString("BillUIAddSellBill.5"); //$NON-NLS-1$
	private final String UNIT_PRICE					= Messages.getString("BillUIAddSellBill.6"); //$NON-NLS-1$
	private final String TOTAL_PRICE				= Messages.getString("BillUIAddSellBill.7"); //$NON-NLS-1$
	private final String DISCOUNT_PERCENT           = Messages.getString("BillUIAddSellBill.14"); //$NON-NLS-1$
	private final String VAT_PERCENT				= Messages.getString("BillUIAddSellBill.8"); //$NON-NLS-1$
	private final String VAT_TOTAL					= Messages.getString("BillUIAddSellBill.9"); //$NON-NLS-1$
	private final String SPECIAL_VAT_PERCENT		= Messages.getString("BillUIAddSellBill.10"); //$NON-NLS-1$
	private final String SPECIAL_VAT_TOTAL			= Messages.getString("BillUIAddSellBill.11"); //$NON-NLS-1$
	private final String ROW_TOTAL 					= Messages.getString("BillUIAddSellBill.12");	 //$NON-NLS-1$
	   int last_row_index=0;
    TableSpreadsheetCursor cursor;
	
	// Set column names
	private String[] columnNames = new String[] { 
			INVENTORY_CODE, 
			INVENTORY_NAME,
			TRANS_AMOUNT,
			UNIT,
			TRANS_AMOUNT_IN_BASE_UNIT,
			BASE_UNIT,
			UNIT_PRICE,
			TOTAL_PRICE,
			DISCOUNT_PERCENT,
			VAT_PERCENT,
			VAT_TOTAL,
			SPECIAL_VAT_PERCENT,
			SPECIAL_VAT_TOTAL,
			ROW_TOTAL
			
			};
   private List columnList = new ArrayList();
   public TableRowList rowList = new TableRowList();
	
	

	public BillUIAddSellBill(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(1403, 536);
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
                    tabItemGeneral.setText(Messages
                        .getString("BillUIAddBill.0")); //$NON-NLS-1$
                    tabItemGeneral.setImage(SWTResourceManager
                        .getImage("icons/Home16.gif")); //$NON-NLS-1$
                    tabItemGeneral.setText(Messages
                        .getString("BillUIAddBill.2")); //$NON-NLS-1$

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
                            compInfoPanelLData.heightHint = 143;
                            compInfoPanelLData.grabExcessHorizontalSpace = true;
                            compInfoPanel.setLayoutData(compInfoPanelLData);
                            compInfoPanelLayout.numColumns = 4;
                            compInfoPanel.setLayout(compInfoPanelLayout);
                            {
                                lblCurrentCard = new CLabel(compInfoPanel, SWT.LEFT);
                                lblCurrentCard.setText(Messages.getString("BillUIAddBill.3")); //$NON-NLS-1$
                                GridData lblCurrentCardLData1 = new GridData();
                                lblCurrentCardLData1.widthHint = 85;
                                lblCurrentCardLData1.heightHint = 19;
                                lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
                                lblCurrentCard.setLayoutData(lblCurrentCardLData1);
                            }
                            {
                                txtCurrentCard = new CurrentPicker(compInfoPanel, SWT.NONE);
                                GridData txtCurrentCardLData = new GridData();
                               
                                txtCurrentCard.setBackground(SWTResourceManager.getColor(255,255,255));
                                txtCurrentCardLData.widthHint = 216;
                                txtCurrentCardLData.heightHint = 14;
                                txtCurrentCard.setLayoutData(txtCurrentCardLData);
                            }
                            {
                                lblDocumentNo = new CLabel(
                                    compInfoPanel,
                                    SWT.NONE);
                                lblDocumentNo.setText(Messages.getString("BillUIAddBill.5")); //$NON-NLS-1$
                                GridData lblDocumentNoLData = new GridData();
                                lblDocumentNoLData.widthHint = 88;
                                lblDocumentNoLData.heightHint = 17;
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
                                lblBillDocumentNo = new CLabel(compInfoPanel, SWT.LEFT);
                                lblBillDocumentNo.setText(Messages.getString("BillUIAddBill.6")); //$NON-NLS-1$
                                GridData lblBillDocumentNoLData = new GridData();
                                lblBillDocumentNoLData.widthHint = 99;
                                lblBillDocumentNoLData.heightHint = 16;
                                lblBillDocumentNo.setLayoutData(lblBillDocumentNoLData);
                            }
                            {
                                txtConsignmentDocumentNo = new Text(
                                    compInfoPanel,
                                    SWT.NONE);
                                GridData txtBillDocumentNoLData = new GridData();
                                txtBillDocumentNoLData.widthHint = 133;
                                txtBillDocumentNoLData.heightHint = 15;
                                txtConsignmentDocumentNo
                                    .setLayoutData(txtBillDocumentNoLData);
                            }
                            {
                                lblDate = new CLabel(compInfoPanel, SWT.LEFT);
                                lblDate.setText(Messages
                                    .getString("BillUIAddBill.7")); //$NON-NLS-1$
                                GridData lblDateLData = new GridData();
                                lblDateLData.widthHint = 100;
                                lblDateLData.heightHint = 22;
                                lblDate.setLayoutData(lblDateLData);
                            }
                            {
                                dateConsignmentDate = new DatePicker(
                                    compInfoPanel,
                                    SWT.EMBEDDED);
                                GridData dateConsignmentDateLData = new GridData();
                                dateConsignmentDateLData.widthHint = 113;
                                dateConsignmentDateLData.heightHint = 20;
                                dateConsignmentDate
                                    .setLayoutData(dateConsignmentDateLData);
                            }
                            {
                                lblDefinition = new CLabel(compInfoPanel, SWT.LEFT);
                                lblDefinition.setText(Messages
                                    .getString("BillUIAddBill.11")); //$NON-NLS-1$
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
                                txtDefinitionLData.widthHint = 211;
                                txtDefinitionLData.heightHint = 17;
                                txtDefinition.setLayoutData(txtDefinitionLData);
                            }
                            {
                                lblPaymentType = new Label(compInfoPanel, SWT.LEFT);
                                lblPaymentType.setText(Messages
                                    .getString("BillUIAddBill.12")); //$NON-NLS-1$
                                GridData lblPaymentTypeLData = new GridData();
                                lblPaymentTypeLData.horizontalAlignment = GridData.END;
                            }
                            {
                                comboPaymentType = new CCombo(
                                    compInfoPanel,
                                    SWT.NONE);
                                comboPaymentType.setEditable(false);
                                comboPaymentType
                                    .setBackground(SWTResourceManager.getColor(
                                        255,
                                        255,
                                        255));
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
                                comboPaymentTypeLData.widthHint = 90;
                                comboPaymentTypeLData.heightHint = 16;
                                comboPaymentType
                                    .setLayoutData(comboPaymentTypeLData);
                            }
                            {
                                lblWareHouse = new CLabel(
                                    compInfoPanel,
                                    SWT.NONE);
                                lblWareHouse.setText(Messages.getString("BillUIAddSellBill.13")); //$NON-NLS-1$
                                GridData lblWareHouseLData = new GridData();
                                lblWareHouseLData.widthHint = 52;
                                lblWareHouseLData.heightHint = 19;
                                lblWareHouse.setLayoutData(lblWareHouseLData);
                            }
                            {
                                comboWareHouse = new CCombo(
                                    compInfoPanel,
                                    SWT.NONE);
                                GridData comboWareHouseLData = new GridData();
                                comboWareHouseLData.widthHint = 89;
                                comboWareHouseLData.heightHint = 14;
                                comboWareHouse.setLayoutData(comboWareHouseLData);
                            }
							{
								lblCashAccount = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblCashAccount.setText(Messages.getString("BillUIAddSellBill.15")); //$NON-NLS-1$
							}
							{
								accountPickerCurAcc = new AccountPicker(
									compInfoPanel,
									SWT.NONE);
								GridData accountPickerCurAccLData = new GridData();
								accountPickerCurAccLData.widthHint = 110;
								accountPickerCurAccLData.heightHint = 14;
								accountPickerCurAcc.setLayoutData(accountPickerCurAccLData);
							}
                            {
                                lblDueDate = new CLabel(compInfoPanel, SWT.NONE);
                                lblDueDate.setText(Messages.getString("BillUIAddSellBill.18")); //$NON-NLS-1$
                            }
                            {
                                dateDueDate = new DatePicker(
                                    compInfoPanel,
                                    SWT.NONE);
                                GridData dateDueDateLData = new GridData();
                                dateDueDateLData.widthHint = 119;
                                dateDueDateLData.heightHint = 20;
                                dateDueDate.setLayoutData(dateDueDateLData);
                            }

                        }
                        {
                            tableConsignmentRows = new Table(
                                compGeneral,
                                SWT.FULL_SELECTION
                                    | SWT.HIDE_SELECTION
                                    | SWT.BORDER);
                            tableConsignmentRows.setHeaderVisible(true);
                            tableConsignmentRows.setLinesVisible(true);
                            GridData tableLData = new GridData();
                            tableLData.verticalAlignment = GridData.FILL;
                            tableLData.horizontalAlignment = GridData.FILL;
                            tableLData.horizontalSpan = 2;
                            tableLData.grabExcessHorizontalSpace = true;
                            tableLData.grabExcessVerticalSpace = true;
                            tableConsignmentRows.setLayoutData(tableLData);
                            {
                                tableColumn1 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn1.setText(INVENTORY_CODE);
                                tableColumn1.setWidth(100);
                                tableColumn1
                                    .addSelectionListener(new SelectionAdapter() {
                                        public void widgetSelected(
                                            SelectionEvent evt) {
                                            //      tableViewer.setSorter(new TurquazTableSorter(0));    
                                        }
                                    });
                            }
                            {
                                tableColumn2 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn2.setText(INVENTORY_NAME);
                                tableColumn2.setWidth(103);
                            }
                            {
                                tableColumn = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn.setText(TRANS_AMOUNT);
                                tableColumn.setWidth(106);
                            }
                            {
                                tableColumn5 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn5.setText(UNIT);
                                tableColumn5.setWidth(100);
                            }
                            {
                                tableColumn4 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn4.setText(TRANS_AMOUNT_IN_BASE_UNIT);
                                tableColumn4.setWidth(121);
                            }
							{
								tableColumn3 = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumn3.setText(BASE_UNIT);
								tableColumn3.setWidth(126);
							}
                            {
                                tableColumn6 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn6.setText(UNIT_PRICE);
                                tableColumn6.setWidth(100);
                            }
                            {
                                tableColumn7 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.RIGHT);
                                tableColumn7.setText(TOTAL_PRICE);
                                tableColumn7.setWidth(100);
                            }
                            {
                                tableColumnDiscountRate = new TableColumn(tableConsignmentRows, SWT.RIGHT);
                                tableColumnDiscountRate.setText(DISCOUNT_PERCENT);
                                tableColumnDiscountRate.setWidth(100);
                            }
                            {
                                tableColumn8 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.NONE);
                                tableColumn8.setText(VAT_PERCENT);
                                tableColumn8.setWidth(60);
                            }
                            {
                                tableColumn9 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
                                tableColumn9.setText(VAT_TOTAL);
                                tableColumn9.setWidth(100);
                            }
                            {
                                tableColumn10 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
                                tableColumn10.setText(SPECIAL_VAT_PERCENT);
                                tableColumn10.setWidth(84);
                            }
                            {
                                tableColumn11 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.RIGHT);
                                tableColumn11.setText(SPECIAL_VAT_TOTAL);
                                tableColumn11.setWidth(101);
                            }
                            {
                                tableColumn12 = new TableColumn(
                                    tableConsignmentRows,
                                    SWT.RIGHT);
                                tableColumn12.setText(ROW_TOTAL);
                                tableColumn12.setWidth(114);
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
                            composite1LData1.heightHint = 111;
                            compTotalsPanel.setLayoutData(composite1LData1);
                            composite1Layout1.numColumns = 4;
                            compTotalsPanel.setLayout(composite1Layout1);
                            {
                                lblDiscountAmount = new CLabel(
                                    compTotalsPanel,
                                    SWT.NONE);
                                lblDiscountAmount.setText(Messages
                                    .getString("BillUIAddBill.1")); //$NON-NLS-1$
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
                                txtDiscountAmount.setBackground(SWTResourceManager.getColor(255,255,255));
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
                                    .getString("BillUIAddBill.26")); //$NON-NLS-1$
                                GridData lblTotalAmountLData = new GridData();
                                lblTotalAmountLData.widthHint = 90;
                                lblTotalAmountLData.heightHint = 20;
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
                                txtTotalAmountLData.widthHint = 158;
                                txtTotalAmountLData.heightHint = 19;
                                txtTotalAmount.setLayoutData(txtTotalAmountLData);
                            }
                            {
                                lblInventoryPrice = new CLabel(
                                    compTotalsPanel,
                                    SWT.NONE);
                                lblInventoryPrice.setText(Messages
                                    .getString("BillUIAddBill.27")); //$NON-NLS-1$
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
                                    .getString("BillUIAddBill.28")); //$NON-NLS-1$
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
                                    .getString("BillUIAddBill.29")); //$NON-NLS-1$
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

					tabItemGroups.setImage(SWTResourceManager
							.getImage("icons/Multi16.gif")); //$NON-NLS-1$
					tabItemGroups.setText(Messages
							.getString("BillUIAddBill.31")); //$NON-NLS-1$

					{
						composite1 = new Composite(cTabFolder1, SWT.NONE);
						tabItemGroups.setControl(composite1);
						GridLayout composite1Layout2 = new GridLayout();
						composite1Layout2.makeColumnsEqualWidth = true;
						composite1.setLayout(composite1Layout2);
						{
							compRegisterGroup = new RegisterGroupComposite(
									composite1, SWT.NONE);
							GridData compRegisterGroupLData = new GridData();
							compRegisterGroupLData.widthHint = 182;
							compRegisterGroupLData.heightHint = 171;
							compRegisterGroup
									.setLayoutData(compRegisterGroupLData);
						}
						{
							btnUpdateGroups = new Button(composite1, SWT.PUSH
									| SWT.CENTER);
							btnUpdateGroups.setText(Messages
									.getString("BillUIAddBill.32")); //$NON-NLS-1$
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
			}
			this.layout();
			postInitGui();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean okToDelete(){
	    
	    MessageBox msg = new MessageBox(this.getShell(),SWT.ICON_WARNING|SWT.OK|SWT.CANCEL);
	       msg.setMessage(Messages.getString("BillUIAddBill.34"));  //$NON-NLS-1$
	       if(msg.open()==SWT.OK){
	           return true;
	       }
	       else
	       {
	           return false;
	       }
	       
	       
	}
	
	public void updateComboBoxEditor(){
	    try{
	       
	       InvUITransactionTableRow table_row =(InvUITransactionTableRow) cursor.getRow().getData(); 
	       ComboBoxCellEditor editor =(ComboBoxCellEditor) tableViewer.getCellEditors()[3];
	       
	       if(table_row.getUnits()!=null){ 
	       editor.setItems(table_row.getUnits());
	       }
	       
	       else {
	       editor.setItems(new String[]{});
	           
	       }
	       
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	

	public void btnUpdateGroupsClick() {

		new BillUIBillsGroupDialog(this.getShell(), SWT.NULL).open();

		fillGroupsTable();

	}
	
	private EngBLCommon blCommon = new EngBLCommon();
	public void fillComboWarehouses(){
		try{
			comboWareHouse.removeAll();
			List list = blCommon.getInventoryWarehouses();
			
			TurqInventoryWarehous warehouse;	
			for(int i=0;i<list.size();i++){
			
			warehouse = (TurqInventoryWarehous)list.get(i);
			comboWareHouse.add(warehouse.getWarehousesName());
			comboWareHouse.setData(warehouse.getWarehousesName(),warehouse);
			
			
			}
			if(comboWareHouse.getItemCount()>0){
				comboWareHouse.setText(comboWareHouse.getItem(0));
			}
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void fillGroupsTable() {

		try {

			//Fill Group Table
			List list = blAddGroup.getBillGroups();
			HashMap groupMap = new HashMap();

			TurqBillGroup curGroup;

			for (int i = 0; i < list.size(); i++) {
				curGroup = (TurqBillGroup) list.get(i);
				groupMap.put(curGroup.getGroupsName(), curGroup);
			}

			compRegisterGroup.fillTableAllGroups(groupMap);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

	}

	public void postInitGui() {
	    
		cTabFolder1.setSelection(tabItemGeneral);

		fillGroupsTable();

		//fill combo type

		comboPaymentType.add(Messages.getString("BillUIAddBill.13")); //$NON-NLS-1$
		comboPaymentType.setData(
				Messages.getString("BillUIAddBill.14"), new Boolean(false)); //$NON-NLS-1$
		comboPaymentType.add(Messages.getString("BillUIAddBill.25")); //$NON-NLS-1$
		comboPaymentType.setData(
				Messages.getString("BillUIAddBill.30"), new Boolean(true)); //$NON-NLS-1$
		comboPaymentType.setText(Messages.getString("BillUIAddBill.35")); //$NON-NLS-1$
		accountPickerCurAcc.setEnabled(false);
		

	    createTableViewer();

	    for(int i=0;i<10;i++){
//			enter empty table rows.
	      InvUITransactionTableRow row = new InvUITransactionTableRow(rowList,1,tableViewer);
	      rowList.addTask(row);
		}
	    
	    //fill combo ware houses
	    fillComboWarehouses();
	}

	 public void createTableViewer(){
	       columnList.add(INVENTORY_CODE);
	       columnList.add(INVENTORY_NAME);
	       columnList.add(TRANS_AMOUNT);
	       columnList.add(UNIT);
	       columnList.add(TRANS_AMOUNT_IN_BASE_UNIT);
	       columnList.add(BASE_UNIT);
	       columnList.add(UNIT_PRICE);
	       columnList.add(TOTAL_PRICE);
	       columnList.add(DISCOUNT_PERCENT);
	       columnList.add(VAT_PERCENT);
	       columnList.add(VAT_TOTAL);
	       columnList.add(SPECIAL_VAT_PERCENT);
	       columnList.add(SPECIAL_VAT_TOTAL);
	       columnList.add(ROW_TOTAL);
	         
	    
	       tableViewer = new TableViewer(tableConsignmentRows);
	       tableViewer.setUseHashlookup(true);
	       tableViewer.setColumnProperties(columnNames);
	       //     Create the cell editors
		   CellEditor[] editors = new CellEditor[columnNames.length];
	       editors[0] = new InventoryCellEditor(tableConsignmentRows); //Stok Kodu
	       editors[1] = new TextCellEditor(tableConsignmentRows);      //Stok Adi
	       editors[2] = new NumericCellEditor(tableConsignmentRows);   // mikatri     
	       editors[3] = new ComboBoxCellEditor(tableConsignmentRows,new String[]{},SWT.READ_ONLY);
	     
	       editors[4] = new NumericCellEditor(tableConsignmentRows);
	       editors[5] = new TextCellEditor(tableConsignmentRows);
	       editors[6] = new CurrencyCellEditor(tableConsignmentRows);
	       editors[7] = new CurrencyCellEditor(tableConsignmentRows);
	       editors[8] = new NumericCellEditor(tableConsignmentRows);
	       editors[9] = new NumericCellEditor(tableConsignmentRows);
	       editors[10] = new CurrencyCellEditor(tableConsignmentRows);
	       editors[11] = new CurrencyCellEditor(tableConsignmentRows);
	       editors[12] = new CurrencyCellEditor(tableConsignmentRows);
	       editors[13] = new CurrencyCellEditor(tableConsignmentRows);
	    
	       // Assign the cell editors to the viewer 
			tableViewer.setCellEditors(editors);
	       
			TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer,rowList);
			
			tableViewer.setCellModifier(new TurquazCellModifier(columnList,contentProvider));    
			tableViewer.setContentProvider(contentProvider);
			tableViewer.setLabelProvider(new TurquazLabelProvider());
			
			tableViewer.setInput(rowList);
			 
	             cursor = new TableSpreadsheetCursor(tableConsignmentRows, SWT.NONE,tableViewer,rowList);
	             cursor.setEnabled(true);
	        	 
	             cursor.addSelectionListener(new SelectionAdapter() {
	                     public void widgetDefaultSelected(
	                      SelectionEvent evt) {
	                        tableViewer.getCellEditors()[cursor.getColumn()].deactivate();
	                        TableItem item = cursor.getRow();
	                        int column_number = cursor.getColumn();
	                         tableViewer.editElement(cursor
	                             .getRow().getData(), cursor
	                             .getColumn());
	                                         

	                     }
	                     public void widgetSelected(
	                       SelectionEvent evt) {
	                         
	                         tableConsignmentRows.setSelection(new TableItem[] {cursor.getRow() });
	                    	 
	                         
	                         int current_row_index = ((InvUITransactionTableRow) cursor
	                             .getRow().getData())
	                             .getRowIndex();
	                         if (current_row_index != last_row_index) {
	                             last_row_index = current_row_index;
	                             updateComboBoxEditor();
	                         }
	                         cursor.redraw();                     
	                         
	 
	                     }
	                 });
	          
	         
	    //   To refresh the cell combo cell editor
	             for(int i=0;i<editors.length;i++){
	             editors[i].addListener(this.cursor);
	             }
	    	
		//	tableViewer.setSorter(new TurquazTableSorter(0));
	       
	    // Listener for rowList
	    rowList.addChangeListener(new ITableRowListViewer(){
	       public void updateRow(ITableRow row){
	           
	           calculateTotals();
	       
				
	           Vector vec = rowList.getTasks();
	           int index = vec.indexOf(row);
	           if(index==vec.size()-1){
	           		if(row.okToSave()){
	           			
	                    InvUITransactionTableRow row2 = new InvUITransactionTableRow(rowList,1,tableViewer);
	                    rowList.addTask(row2);
	                   
	           			

	           		}
	           	
	           }
	           
	      }
	       public void removeRow(ITableRow row){
	           calculateTotals();
	                 
	       }
	       public void addRow(ITableRow row){
	           calculateTotals();
	       }
	    });
	             
	             
	   }
	   
	public void btnChooseMouseUp() {
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			System.out.println(data.getClass().getName());
			TurqCurrentCard curCard = (TurqCurrentCard) data;
			txtCurrentCard.setText(curCard.getCardsCurrentCode()
					+ " - " + curCard.getCardsName()); //$NON-NLS-1$
			txtCurrentCard.setData(curCard);
			}
	}

	public void btnAddConsignmentRowMouseUp() {

		TurqInventoryTransaction invTrans = new InvUITransactionAddDialog(this
				.getShell(), SWT.NULL, true).open();
		if (invTrans != null) {
			TableItem item = new TableItem(tableConsignmentRows, SWT.NULL);

			item.setData(invTrans);
			item.setText(new String[] {
					invTrans.getTurqInventoryCard().getCardInventoryCode(),
					invTrans.getTurqInventoryCard().getCardName(),
					invTrans.getTransactionsAmountIn() + "", //$NON-NLS-1$
					invTrans.getTurqInventoryUnit().getUnitsName(),
					invTrans.getTransactionsUnitPrice().toString(),
					invTrans.getTransactionsTotalPrice().toString(),
					invTrans.getTransactionsVat() + "", //$NON-NLS-1$
					invTrans.getTransactionsVatAmount().toString(),
					invTrans.getTransactionsVatSpecialAmount().toString(),
					invTrans.getTransactionsCumilativePrice().toString() });

			calculateTotals();
		}
	}

	public boolean verifyFields() {
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING);

		if (txtCurrentCard.getData() == null) {
			msg.setMessage(Messages.getString("BillUIAddBill.38")); //$NON-NLS-1$
			msg.open();
			txtCurrentCard.setFocus();
			return false;
		}

		if (tableConsignmentRows.getItemCount() == 0) {
			msg.setMessage(Messages.getString("BillUIAddBill.39")); //$NON-NLS-1$
			msg.open();
			cursor.setFocus();
			return false;
		}
		
		boolean isExistEntry=false;
		TableItem items[] = tableConsignmentRows.getItems();
		for(int k=0; k<items.length ; k++)
		{
			InvUITransactionTableRow row = (InvUITransactionTableRow)items[k].getData();
			if (row.okToSave())
			{
				isExistEntry=true;
				break;
			}
		}
		if (!isExistEntry)
		{
			msg.setMessage(Messages.getString("BillUIAddBill.39")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		
		
		Boolean isCurrent=(Boolean)comboPaymentType.getData(comboPaymentType.getText());
		if (isCurrent.booleanValue())
		{
			if (accountPickerCurAcc.getData()==null)
			{
				msg.setMessage(Messages.getString("BillUIAddSellBill.17")); //$NON-NLS-1$
				msg.open();
				accountPickerCurAcc.setFocus();
				return false;
			}
		}
		return true;
	}

	public void saveConsignmentRows(Integer consignmentID) {
		try {
			TableItem items[] = tableConsignmentRows.getItems();

			// sell bill
			int type = BILL_TYPE;

			for (int i = 0; i < items.length; i++) {
			    

			    InvUITransactionTableRow row = (InvUITransactionTableRow)items[i].getData();
			   
			    TurqInventoryTransaction invTrans = (TurqInventoryTransaction)row.getDBObject();
			    invTrans.setTurqInventoryWarehous((TurqInventoryWarehous)comboWareHouse.getData(comboWareHouse.getText()));
				
			    if(row.okToSave()){
			      blAddConsignment.saveConsignmentRow(invTrans,consignmentID, type);
			      checkInventoryLevel(invTrans.getTurqInventoryCard());  
			    }
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void checkInventoryLevel(TurqInventoryCard invCard ){
	    try{
	     
	    InvBLCardSearch blCardSearch = new InvBLCardSearch();    
		TurqViewInventoryAmountTotal invView=blCardSearch.getView(invCard);
		int Now=(invView.getTransactionsTotalAmountNow()==null) ? 0 : invView.getTransactionsTotalAmountNow().intValue();
		int Max=invCard.getCardMaximumAmount();
		int Min=invCard.getCardMinimumAmount();
	
		
			
				if (Now< Min)
				{
					MessageBox msg=new MessageBox(this.getShell(), SWT.ICON_WARNING);
					msg.setMessage(Messages.getString("BillUIAddSellBill.19")); //$NON-NLS-1$
					msg.open();
				}
			
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
		
	}

	public void saveGroups(Integer consignmentId) {
		try {
			TableItem items[] = compRegisterGroup.getTableAllGroups()
					.getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].getChecked()) {
					blAddBill.registerGroup((TurqBillGroup) items[i].getData(),
							consignmentId);
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public TurqConsignment saveConsignment() throws Exception {
		try {
			// sell bill
			int type = BILL_TYPE;

			TurqConsignment cons = blAddConsignment.saveConsignment(
					txtConsignmentDocumentNo.getText(),
					txtDefinition.getText(), false, dateConsignmentDate
							.getDate(), (TurqCurrentCard) txtCurrentCard
							.getData(),
					txtDiscountAmount.getBigDecimalValue(), txtDocumentNo
							.getText(), txtTotalVat.getBigDecimalValue(),
					decSpecialVat.getBigDecimalValue(), txtTotalAmount
							.getBigDecimalValue(), type);
			saveConsignmentRows(cons.getConsignmentsId());

			return cons;
		} catch (Exception ex) {
			throw ex;
		}

	}

	public void save() {
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getShell(),SWT.YES|SWT.NO);
		try {
			if (verifyFields()) {

				// buy bill
				int type = BILL_TYPE;

				//First save its consignment..

				TurqConsignment cons = saveConsignment();

				Boolean paymentType = (Boolean) comboPaymentType
						.getData(comboPaymentType.getText());

				TurqBill bill = blAddBill.saveBill(txtDocumentNo.getText(),
						txtDefinition.getText(), false, dateConsignmentDate
								.getDate(), cons, type, !paymentType
								.booleanValue(),
								paymentType.booleanValue() ? accountPickerCurAcc.getData():null,
								 dateDueDate.getDate());
				saveGroups(bill.getBillsId());
				msg.setMessage(Messages.getString("BillUIAddBill.43")); //$NON-NLS-1$
				msg.open();
				msg2.setMessage(Messages.getString("BillUIAddSellBill.16")); //$NON-NLS-1$
				int answer = msg2.open();
				
				if(answer == SWT.YES)
				{
				    EngBLUtils.printBill(bill);
				    
				}
				
				
				
				newForm();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}

	}

	public void delete() {

	}

	public void search() {

	}

	public void newForm() {
	    BillUIAddSellBill  curCard = new BillUIAddSellBill(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();

	}

	public void calculateTotals() {

		TableItem items[] = tableConsignmentRows.getItems();
		BigDecimal subTotal = new BigDecimal(0);
		BigDecimal totalVAT = new BigDecimal(0);
		BigDecimal totalSpecVAT = new BigDecimal(0);
		BigDecimal generalTotal = new BigDecimal(0);
		BigDecimal discountTotal = new BigDecimal(0);

		for(int i =0;i<items.length;i++){
		    TurqInventoryTransaction invTrans = (TurqInventoryTransaction)((InvUITransactionTableRow)(items[i].getData())).getDBObject();
			subTotal = subTotal.add(invTrans.getTransactionsTotalPrice());
			totalVAT = totalVAT.add(invTrans.getTransactionsVatAmount());
			totalSpecVAT = totalSpecVAT.add(invTrans.getTransactionsVatSpecialAmount());
			discountTotal = discountTotal.add(invTrans.getTransactionsDiscountAmount());
			
		}

		 generalTotal = subTotal.add(totalVAT).add(totalSpecVAT);
		 
		txtDiscountAmount.setText(discountTotal.toString());
		txtSubTotal.setText(subTotal.toString());
		txtTotalVat.setText(totalVAT.toString());
		decSpecialVat.setText(totalSpecVAT.toString());
		txtTotalAmount.setText(generalTotal.subtract(discountTotal).toString());
	
		
	}

	/**
	 * @return Returns the comboPaymentType.
	 */
	public CCombo getComboPaymentType() {
		return comboPaymentType;
	}

	/**
	 * @param comboPaymentType
	 *            The comboPaymentType to set.
	 */
	public void setComboPaymentType(CCombo comboPaymentType) {
		this.comboPaymentType = comboPaymentType;
	}
}