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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.apache.log4j.Logger;
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
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.consignment.bl.ConBLAddConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.editors.InventoryCellEditor;
import com.turquaz.engine.ui.editors.InventoryNameCellEditor;
import com.turquaz.engine.ui.editors.NumericCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import com.turquaz.inventory.ui.InvUITransactionAddDialog;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillUIAddBill extends Composite implements SecureComposite
{
	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup()
	{
		return compRegisterGroup;
	}

	/**
	 * @return Returns the dateConsignmentDate.
	 */
	public DatePicker getDateConsignmentDate()
	{
		return dateConsignmentDate;
	}

	/**
	 * @return Returns the decSpecialVat.
	 */
	public CurrencyText getDecSpecialVat()
	{
		return decSpecialVat;
	}

	/**
	 * @return Returns the tableConsignmentRows.
	 */
	public Table getTableConsignmentRows()
	{
		return tableConsignmentRows;
	}

	/**
	 * @return Returns the txtConsignmentDate.
	 */
	public Text getTxtConsignmentDate()
	{
		return txtConsignmentDate;
	}
	
	/**
	 * @return Returns the txtConsignmentDocumentNo.
	 */
	public Text getTxtConsignmentDocumentNo()
	{
		return txtConsignmentDocumentNo;
	}

	/**
	 * @return Returns the txtCurrentCard.
	 */
	public CurrentPicker getTxtCurrentCard()
	{
		return txtCurrentCard;
	}

	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	/**
	 * @return Returns the txtDiscountAmount.
	 */
	public CurrencyText getTxtDiscountAmount()
	{
		return txtDiscountAmount;
	}

	public DatePicker getDateDueDate()
	{
		return dateDueDate;
	}

	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo()
	{
		return txtDocumentNo;
	}

	/**
	 * @return Returns the txtSubTotal.
	 */
	public CurrencyText getTxtSubTotal()
	{
		return txtSubTotal;
	}

	/**
	 * @return Returns the txtTotalAmount.
	 */
	public CurrencyText getTxtTotalAmount()
	{
		return txtTotalAmount;
	}

	/**
	 * @return Returns the txtTotalVat.
	 */
	public CurrencyText getTxtTotalVat()
	{
		return txtTotalVat;
	}

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite compInfoPanel;
	private Composite compTotalsPanel;
	private Text txtConsignmentDocumentNo;
	private CLabel lblInventoryPrice;
	private Text txtConsignmentDate;
	private CLabel lblConsignmentDate;
	private TableColumn tableColumnAmountAfterDiscount;
	private DatePicker dateDueDate;
	private CLabel lbDueDate;
	private CCombo comboWareHouse;
	private CLabel lblWareHouse;
	public SaveTableViewer tableViewer;
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
	private CLabel lblConsDocumentNo;
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
	ConBLAddConsignment blAddConsignment = new ConBLAddConsignment();
	public int BILL_TYPE = 0;
	//	 Set the table column property names
	private final String INVENTORY_CODE = Messages.getString("BillUIAddBill.4"); //$NON-NLS-1$
	private final String INVENTORY_NAME = Messages.getString("BillUIAddBill.8"); //$NON-NLS-1$
	private final String TRANS_AMOUNT = Messages.getString("BillUIAddBill.9"); //$NON-NLS-1$
	private final String UNIT = Messages.getString("BillUIAddBill.15"); //$NON-NLS-1$
	private final String TRANS_AMOUNT_IN_BASE_UNIT = Messages.getString("BillUIAddBill.10"); //$NON-NLS-1$
	private final String BASE_UNIT = Messages.getString("BillUIAddBill.17"); //$NON-NLS-1$
	private final String UNIT_PRICE = Messages.getString("BillUIAddBill.18"); //$NON-NLS-1$
	private final String TOTAL_PRICE = Messages.getString("BillUIAddBill.19"); //$NON-NLS-1$
	private final String DISCOUNT_PERCENT = Messages.getString("BillUIAddBill.16"); //$NON-NLS-1$
	private final String TOTAL_PRICE_AFTER_DISCOUNT = Messages.getString("BillUIAddBill.44"); //$NON-NLS-1$
	private final String VAT_PERCENT = Messages.getString("BillUIAddBill.20"); //$NON-NLS-1$
	private final String VAT_TOTAL = Messages.getString("BillUIAddBill.21"); //$NON-NLS-1$
	private final String SPECIAL_VAT_PERCENT = Messages.getString("BillUIAddBill.22"); //$NON-NLS-1$
	private final String SPECIAL_VAT_TOTAL = Messages.getString("BillUIAddBill.23"); //$NON-NLS-1$
	private final String ROW_TOTAL = Messages.getString("BillUIAddBill.24"); //$NON-NLS-1$
	int last_row_index = 0;
	TableSpreadsheetCursor cursor;
	// Set column names
	private String[] columnNames = new String[]{INVENTORY_CODE, INVENTORY_NAME, TRANS_AMOUNT, UNIT, TRANS_AMOUNT_IN_BASE_UNIT, BASE_UNIT,
			UNIT_PRICE, TOTAL_PRICE, DISCOUNT_PERCENT, TOTAL_PRICE_AFTER_DISCOUNT, VAT_PERCENT, VAT_TOTAL, SPECIAL_VAT_PERCENT,
			SPECIAL_VAT_TOTAL, ROW_TOTAL};
	private List columnList = new ArrayList();

	public BillUIAddBill(org.eclipse.swt.widgets.Composite parent, int style, int type)
	{
		super(parent, style);
		BILL_TYPE = type;
		initGUI();
	}

	public BillUIAddBill(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		BILL_TYPE = 0;
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(981, 551);
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
					tabItemGeneral.setText(Messages.getString("BillUIAddBill.0")); //$NON-NLS-1$
					tabItemGeneral.setImage(SWTResourceManager.getImage("icons/Home16.gif")); //$NON-NLS-1$
					tabItemGeneral.setText(Messages.getString("BillUIAddBill.2")); //$NON-NLS-1$
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
							compInfoPanelLData.heightHint = 149;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
							{
								lblCurrentCard = new CLabel(compInfoPanel, SWT.LEFT);
								lblCurrentCard.setText(Messages.getString("BillUIAddBill.3")); //$NON-NLS-1$
								GridData lblCurrentCardLData1 = new GridData();
								lblCurrentCardLData1.widthHint = 90;
								lblCurrentCardLData1.heightHint = 19;
								lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
								lblCurrentCard.setLayoutData(lblCurrentCardLData1);
							}
							{
								txtCurrentCard = new CurrentPicker(compInfoPanel, SWT.NONE);
								GridData txtCurrentCardLData = new GridData();
								txtCurrentCard.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtCurrentCardLData.widthHint = 157;
								txtCurrentCardLData.heightHint = 17;
								txtCurrentCard.setLayoutData(txtCurrentCardLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDate.setText(Messages.getString("BillUIAddBill.7")); //$NON-NLS-1$
								GridData lblDateLData = new GridData();
								lblDateLData.widthHint = 90;
								lblDateLData.heightHint = 22;
								lblDate.setLayoutData(lblDateLData);
							}
							{
								dateConsignmentDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDateLData.widthHint = 157;
								dateConsignmentDateLData.heightHint = 23;
								dateConsignmentDate.setLayoutData(dateConsignmentDateLData);
							}
							{
								lblDocumentNo = new CLabel(compInfoPanel, SWT.NONE);
								lblDocumentNo.setText(Messages.getString("BillUIAddBill.5")); //$NON-NLS-1$
								GridData lblDocumentNoLData = new GridData();
								lblDocumentNoLData.widthHint = 88;
								lblDocumentNoLData.heightHint = 17;
								lblDocumentNo.setLayoutData(lblDocumentNoLData);
							}
							{
								txtDocumentNo = new Text(compInfoPanel, SWT.NONE);
								GridData txtDocumentNoLData = new GridData();
								txtDocumentNo.setTextLimit(50);
								txtDocumentNoLData.widthHint = 150;
								txtDocumentNoLData.heightHint = 17;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lbDueDate = new CLabel(compInfoPanel, SWT.NONE);
								lbDueDate.setText(Messages.getString("BillUIAddBill.40")); //$NON-NLS-1$
								GridData lbDueDateLData = new GridData();
								lbDueDateLData.widthHint = 90;
								lbDueDateLData.heightHint = 19;
								lbDueDate.setLayoutData(lbDueDateLData);
							}
							{
								dateDueDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateDueDateLData = new GridData();
								dateDueDateLData.widthHint = 157;
								dateDueDateLData.heightHint = 23;
								dateDueDate.setLayoutData(dateDueDateLData);
							}
							{
								lblConsDocumentNo = new CLabel(compInfoPanel, SWT.LEFT);
								lblConsDocumentNo.setText(Messages.getString("BillUIAddBill.6")); //$NON-NLS-1$
								GridData lblBillDocumentNoLData = new GridData();
								lblBillDocumentNoLData.widthHint = 90;
								lblBillDocumentNoLData.heightHint = 16;
								lblConsDocumentNo.setLayoutData(lblBillDocumentNoLData);
							}
							{
								txtConsignmentDocumentNo = new Text(compInfoPanel, SWT.NONE);
								GridData txtBillDocumentNoLData = new GridData();
								txtConsignmentDocumentNo.setForeground(SWTResourceManager.getColor(255, 255, 255));
								txtConsignmentDocumentNo.setEnabled(false);
								txtConsignmentDocumentNo.setTextLimit(50);
								txtBillDocumentNoLData.widthHint = 150;
								txtBillDocumentNoLData.heightHint = 17;
								txtConsignmentDocumentNo.setLayoutData(txtBillDocumentNoLData);
							}
							//START >>  lblConsignmentDate
							lblConsignmentDate = new CLabel(compInfoPanel, SWT.NONE);
							lblConsignmentDate.setText("\u0130rsaliye Tarihi");
							//END <<  lblConsignmentDate
							//START >>  txtConsignmentDate
							GridData txtConsignmentDateLData = new GridData();
							txtConsignmentDateLData.widthHint = 150;
							txtConsignmentDateLData.heightHint = 17;
							txtConsignmentDate = new Text(compInfoPanel, SWT.NONE);
							txtConsignmentDate.setLayoutData(txtConsignmentDateLData);
							txtConsignmentDate.setEditable(false);
							txtConsignmentDate.setBackground(SWTResourceManager.getColor(255,255,255));
							//END <<  txtConsignmentDate
							{
								lblWareHouse = new CLabel(compInfoPanel, SWT.NONE);
								lblWareHouse.setText(Messages.getString("BillUIAddBill.33")); //$NON-NLS-1$
								GridData lblWareHouseLData = new GridData();
								lblWareHouseLData.widthHint = 90;
								lblWareHouseLData.heightHint = 16;
								lblWareHouse.setLayoutData(lblWareHouseLData);
							}
							{
								comboWareHouse = new CCombo(compInfoPanel, SWT.NONE);
								GridData comboWareHouseLData = new GridData();
								comboWareHouseLData.widthHint = 135;
								comboWareHouseLData.heightHint = 17;
								comboWareHouseLData.horizontalSpan = 3;
								comboWareHouse.setLayoutData(comboWareHouseLData);
							}
							{
								lblDefinition = new CLabel(compInfoPanel, SWT.LEFT);
								lblDefinition.setText(Messages.getString("BillUIAddBill.11")); //$NON-NLS-1$
								GridData lblDefinitionLData = new GridData();
								lblDefinitionLData.widthHint = 90;
								lblDefinitionLData.heightHint = 20;
								lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
								lblDefinition.setLayoutData(lblDefinitionLData);
							}
							{
								txtDefinition = new Text(compInfoPanel, SWT.WRAP | SWT.V_SCROLL);
								GridData txtDefinitionLData = new GridData();
								txtDefinition.setTextLimit(250);
								txtDefinitionLData.widthHint = 392;
								txtDefinitionLData.heightHint = 22;
								txtDefinitionLData.horizontalSpan = 3;
								txtDefinition.setLayoutData(txtDefinitionLData);
							}
						}
						{
							tableConsignmentRows = new Table(compGeneral, SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.BORDER);
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
								tableColumn1 = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumn1.setText(INVENTORY_CODE);
								tableColumn1.setWidth(100);
								tableColumn1.addSelectionListener(new SelectionAdapter()
								{
									public void widgetSelected(SelectionEvent evt)
									{
										//      tableViewer.setSorter(new TurquazTableSorter(0));
									}
								});
							}
							{
								tableColumn2 = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumn2.setText(INVENTORY_NAME);
								tableColumn2.setWidth(103);
							}
							{
								tableColumn = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn.setText(TRANS_AMOUNT);
								tableColumn.setWidth(106);
							}
							{
								tableColumn5 = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumn5.setText(UNIT);
								tableColumn5.setWidth(100);
							}
							{
								tableColumn4 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn4.setText(TRANS_AMOUNT_IN_BASE_UNIT);
								tableColumn4.setWidth(121);
							}
							{
								tableColumn3 = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumn3.setText(BASE_UNIT);
								tableColumn3.setWidth(126);
							}
							{
								tableColumn6 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn6.setText(UNIT_PRICE);
								tableColumn6.setWidth(100);
							}
							{
								tableColumn7 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn7.setText(TOTAL_PRICE);
								tableColumn7.setWidth(100);
							}
							{
								tableColumnDiscountRate = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnDiscountRate.setText(DISCOUNT_PERCENT);
								tableColumnDiscountRate.setWidth(50);
							}
							{
								tableColumnAmountAfterDiscount = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnAmountAfterDiscount.setText(TOTAL_PRICE_AFTER_DISCOUNT);
								tableColumnAmountAfterDiscount.setWidth(100);
							}
							{
								tableColumn8 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn8.setText(VAT_PERCENT);
								tableColumn8.setWidth(56);
							}
							{
								tableColumn9 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn9.setText(VAT_TOTAL);
								tableColumn9.setWidth(100);
							}
							{
								tableColumn10 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn10.setText(SPECIAL_VAT_PERCENT);
								tableColumn10.setWidth(110);
							}
							{
								tableColumn11 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn11.setText(SPECIAL_VAT_TOTAL);
								tableColumn11.setWidth(101);
							}
							{
								tableColumn12 = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumn12.setText(ROW_TOTAL);
								tableColumn12.setWidth(114);
							}
						}
						{
							compTotalsPanel = new Composite(compGeneral, SWT.NONE);
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
								lblDiscountAmount = new CLabel(compTotalsPanel, SWT.NONE);
								lblDiscountAmount.setText(Messages.getString("BillUIAddBill.1")); //$NON-NLS-1$
								GridData lblDiscountAmountLData = new GridData();
								lblDiscountAmountLData.widthHint = 105;
								lblDiscountAmountLData.heightHint = 19;
								lblDiscountAmount.setLayoutData(lblDiscountAmountLData);
							}
							{
								txtDiscountAmount = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData txtDiscountAmountLData = new GridData();
								txtDiscountAmount.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtDiscountAmount.setEditable(false);
								txtDiscountAmountLData.widthHint = 150;
								txtDiscountAmountLData.heightHint = 17;
								txtDiscountAmount.setLayoutData(txtDiscountAmountLData);
							}
							{
								lblTotalAmount = new CLabel(compTotalsPanel, SWT.NONE);
								lblTotalAmount.setText(Messages.getString("BillUIAddBill.26")); //$NON-NLS-1$
								GridData lblTotalAmountLData = new GridData();
								lblTotalAmountLData.widthHint = 90;
								lblTotalAmountLData.heightHint = 20;
								lblTotalAmount.setLayoutData(lblTotalAmountLData);
							}
							{
								txtTotalAmount = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData txtTotalAmountLData = new GridData();
								txtTotalAmount.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtTotalAmount.setEditable(false);
								txtTotalAmountLData.widthHint = 150;
								txtTotalAmountLData.heightHint = 17;
								txtTotalAmount.setLayoutData(txtTotalAmountLData);
							}
							{
								lblInventoryPrice = new CLabel(compTotalsPanel, SWT.NONE);
								lblInventoryPrice.setText(Messages.getString("BillUIAddBill.27")); //$NON-NLS-1$
								GridData lblInventoryPriceLData = new GridData();
								lblInventoryPrice.setSize(87, 19);
								lblInventoryPriceLData.widthHint = 87;
								lblInventoryPriceLData.heightHint = 19;
								lblInventoryPrice.setLayoutData(lblInventoryPriceLData);
							}
							{
								txtSubTotal = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData text1LData = new GridData();
								txtSubTotal.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtSubTotal.setEditable(false);
								text1LData.widthHint = 150;
								text1LData.heightHint = 17;
								text1LData.horizontalSpan = 3;
								txtSubTotal.setLayoutData(text1LData);
							}
							{
								lblTotalVat = new CLabel(compTotalsPanel, SWT.NONE);
								lblTotalVat.setText(Messages.getString("BillUIAddBill.28")); //$NON-NLS-1$
								GridData lblTotalVatLData = new GridData();
								lblTotalVat.setSize(87, 19);
								lblTotalVatLData.widthHint = 87;
								lblTotalVatLData.heightHint = 19;
								lblTotalVat.setLayoutData(lblTotalVatLData);
							}
							{
								txtTotalVat = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData txtTotalVatLData = new GridData();
								txtTotalVat.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtTotalVat.setEditable(false);
								txtTotalVatLData.widthHint = 150;
								txtTotalVatLData.heightHint = 17;
								txtTotalVatLData.horizontalSpan = 3;
								txtTotalVat.setLayoutData(txtTotalVatLData);
							}
							{
								lblSpecialVAT = new Label(compTotalsPanel, SWT.NONE);
								lblSpecialVAT.setText(Messages.getString("BillUIAddBill.29")); //$NON-NLS-1$
								GridData lblSpecialVATLData = new GridData();
								lblSpecialVATLData.widthHint = 94;
								lblSpecialVATLData.heightHint = 16;
								lblSpecialVAT.setLayoutData(lblSpecialVATLData);
							}
							{
								decSpecialVat = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData decSpecialVatLData = new GridData();
								decSpecialVatLData.widthHint = 150;
								decSpecialVatLData.heightHint = 17;
								decSpecialVatLData.horizontalSpan = 3;
								decSpecialVat.setLayoutData(decSpecialVatLData);
							}
						}
					}
				}
				{
					tabItemGroups = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGroups.setImage(SWTResourceManager.getImage("icons/Multi16.gif")); //$NON-NLS-1$
					tabItemGroups.setText(Messages.getString("BillUIAddBill.31")); //$NON-NLS-1$
					{
						composite1 = new Composite(cTabFolder1, SWT.NONE);
						tabItemGroups.setControl(composite1);
						GridLayout composite1Layout2 = new GridLayout();
						composite1Layout2.makeColumnsEqualWidth = true;
						composite1.setLayout(composite1Layout2);
						{
							compRegisterGroup = new RegisterGroupComposite(composite1, SWT.NONE);
							GridData compRegisterGroupLData = new GridData();
							compRegisterGroupLData.widthHint = 182;
							compRegisterGroupLData.heightHint = 171;
							compRegisterGroup.setLayoutData(compRegisterGroupLData);
						}
						{
							btnUpdateGroups = new Button(composite1, SWT.PUSH | SWT.CENTER);
							btnUpdateGroups.setText(Messages.getString("BillUIAddBill.32")); //$NON-NLS-1$
							GridData btnUpdateGroupsLData = new GridData();
							btnUpdateGroups.addMouseListener(new MouseAdapter()
							{
								public void mouseUp(MouseEvent evt)
								{
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
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void updateComboBoxEditor()
	{
		try
		{
			InvUITransactionTableRow table_row = (InvUITransactionTableRow) cursor.getRow().getData();
			ComboBoxCellEditor editor = (ComboBoxCellEditor) tableViewer.getViewer().getCellEditors()[3];
			if (table_row.getUnits() != null)
			{
				editor.setItems(table_row.getUnits());
			}
			else
			{
				editor.setItems(new String[]{});
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	public boolean okToDelete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		msg.setMessage(Messages.getString("BillUIAddBill.34")); //$NON-NLS-1$
		if (msg.open() == SWT.OK)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void btnUpdateGroupsClick()
	{
		new BillUIBillsGroupDialog(this.getShell(), SWT.NULL).open();
		fillGroupsTable();
	}

	public void fillComboWarehouses()
	{
		try
		{
			comboWareHouse.removeAll();
			List list =(List)EngTXCommon.doSingleTX(InvBLWarehouseSearch.class.getName(),"getInventoryWarehouses",null);
			TurqInventoryWarehous warehouse;
			for (int i = 0; i < list.size(); i++)
			{
				warehouse = (TurqInventoryWarehous) list.get(i);
				comboWareHouse.add(warehouse.getWarehousesName());
				comboWareHouse.setData(warehouse.getWarehousesName(), warehouse);
			}
			if (comboWareHouse.getItemCount() > 0)
			{
				comboWareHouse.setText(comboWareHouse.getItem(0));
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	public void fillGroupsTable()
	{
		try
		{
			//Fill Group Table
			List list = (List)EngTXCommon.doSingleTX(BillBLAddGroups.class.getName(),"getBillGroups",null);
			HashMap groupMap = new HashMap();
			TurqBillGroup curGroup;
			for (int i = 0; i < list.size(); i++)
			{
				curGroup = (TurqBillGroup) list.get(i);
				groupMap.put(curGroup.getGroupsName(), curGroup);
			}
			compRegisterGroup.fillTableAllGroups(groupMap);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	public void postInitGui()
	{
		fillGroupsTable();
		createTableViewer();
		//fill combo ware houses
		fillComboWarehouses();
		cTabFolder1.setSelection(0);
	}

	public void createTableViewer()
	{
		//     Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new InventoryCellEditor(tableConsignmentRows); //Stok Kodu
		editors[1] = new InventoryNameCellEditor(tableConsignmentRows); //Stok Adi
		editors[2] = new CurrencyCellEditor(tableConsignmentRows, 2); // mikatri
		editors[3] = new ComboBoxCellEditor(tableConsignmentRows, new String[]{}, SWT.READ_ONLY);
		editors[4] = new CurrencyCellEditor(tableConsignmentRows, 2);
		editors[5] = new TextCellEditor(tableConsignmentRows);
		editors[6] = new CurrencyCellEditor(tableConsignmentRows, 4);
		editors[7] = new CurrencyCellEditor(tableConsignmentRows, 4);
		editors[8] = new CurrencyCellEditor(tableConsignmentRows, 4);
		editors[9] = new CurrencyCellEditor(tableConsignmentRows, 2);
		editors[10] = new NumericCellEditor(tableConsignmentRows);
		editors[11] = new CurrencyCellEditor(tableConsignmentRows, 4);
		editors[12] = new CurrencyCellEditor(tableConsignmentRows, 4);
		editors[13] = new CurrencyCellEditor(tableConsignmentRows, 2);
		editors[14] = new CurrencyCellEditor(tableConsignmentRows, 2);
		// Assign the cell editors to the viewer
		tableViewer = new SaveTableViewer(tableConsignmentRows, editors);
		cursor = new TableSpreadsheetCursor(tableConsignmentRows, SWT.NONE, tableViewer, true);
		cursor.setEnabled(true);
		cursor.addSelectionListener(new SelectionAdapter()
		{
			public void widgetDefaultSelected(SelectionEvent evt)
			{
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}

			public void widgetSelected(SelectionEvent evt)
			{
				int current_row_index = ((InvUITransactionTableRow) cursor.getRow().getData()).getRowIndex();
				if (current_row_index != last_row_index)
				{
					last_row_index = current_row_index;
					updateComboBoxEditor();
				}
			}
		});
		//   To refresh the cell combo cell editor
		for (int i = 0; i < editors.length; i++)
		{
			editors[i].addListener(this.cursor);
		}
		//	tableViewer.setSorter(new TurquazTableSorter(0));
		// Listener for rowList
		tableViewer.addChangeListener(new ITableRowListViewer()
		{
			public void updateRow(ITableRow row)
			{
				calculateTotals();
				Vector vec = tableViewer.getRowList().getTasks();
				int index = vec.indexOf(row);
				if (index == vec.size() - 1 && row.okToSave())
				{
					InvUITransactionTableRow row2 = new InvUITransactionTableRow(BILL_TYPE, tableViewer);
					tableViewer.getRowList().addTask(row2);
				}
			}

			public void removeRow(ITableRow row)
			{
				calculateTotals();
			}

			public void addRow(ITableRow row)
			{
				calculateTotals();
			}
		});
	}



	public void btnAddConsignmentRowMouseUp()
	{
		TurqInventoryTransaction invTrans = new InvUITransactionAddDialog(this.getShell(), SWT.NULL, true).open();
		if (invTrans != null)
		{
			TableItem item = new TableItem(tableConsignmentRows, SWT.NULL);
			item.setData(invTrans);
			item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
					invTrans.getTurqInventoryCard().getCardName(), invTrans.getAmountIn() + "", //$NON-NLS-1$
					invTrans.getTurqInventoryUnit().getUnitsName(), invTrans.getUnitPriceInForeignCurrency().toString(),
					invTrans.getTotalPriceInForeignCurrency().toString(), invTrans.getVatRate() + "", //$NON-NLS-1$
					invTrans.getVatAmountInForeignCurrency().toString(), invTrans.getVatSpecialAmountInForeignCurrency().toString(),
					invTrans.getCumilativePriceInForeignCurrency().toString()});
			calculateTotals();
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING);
		if (txtCurrentCard.getData() == null)
		{
			msg.setMessage(Messages.getString("BillUIAddBill.38")); //$NON-NLS-1$
			msg.open();
			txtCurrentCard.setFocus();
			return false;
		}
		if (tableConsignmentRows.getItemCount() == 0)
		{
			msg.setMessage(Messages.getString("BillUIAddBill.39")); //$NON-NLS-1$
			msg.open();
			cursor.setFocus();
			return false;
		}
		boolean isExistEntry = false;
		TableItem items[] = tableConsignmentRows.getItems();
		for (int k = 0; k < items.length; k++)
		{
			InvUITransactionTableRow row = (InvUITransactionTableRow) items[k].getData();
			if (row.okToSave())
			{
				isExistEntry = true;
				break;
			}
		}
		if (!isExistEntry)
		{
			msg.setMessage(Messages.getString("BillUIAddBill.39")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		
		return true;
	}

	public boolean checkStabilityInventoryLevel(TurqInventoryCard invCard)
	{
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD,invCard);
			TurqViewInventoryAmountTotal invView = (TurqViewInventoryAmountTotal)EngTXCommon.doSingleTX(InvBLCardSearch.class.getName(),"getView",argMap);
			int Now = (invView.getTransactionsTotalAmountNow() == null) ? 0 : invView.getTransactionsTotalAmountNow().intValue();
			int Max = invCard.getCardMaximumAmount();
			int Min = invCard.getCardMinimumAmount();
			if (BILL_TYPE == EngBLCommon.BILL_TRANS_TYPE_SELL && Now < Min)
				return false;
			else if (BILL_TYPE == EngBLCommon.BILL_TRANS_TYPE_BUY && Max != 0 && Now > Max)
				return false;
			return true;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			return false;
		}
	}

	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				// buy bill
				int type = BILL_TYPE;
				TurqBill bill = null;
				
				HashMap argMap=new HashMap();
				
				argMap.put(BillKeys.BILL,bill);
				argMap.put(BillKeys.BILL_DEFINITION,txtDefinition.getText().trim());
				argMap.put(BillKeys.BILL_IS_PRINTED,new Boolean(false));
				argMap.put(BillKeys.BILL_DATE,dateConsignmentDate.getDate());
				argMap.put(EngKeys.TYPE, new Integer(type));
				argMap.put(EngKeys.CURRENT_CARD,txtCurrentCard.getData());
				argMap.put(BillKeys.BILL_DUE_DATE,dateDueDate.getDate());
				argMap.put(BillKeys.BILL_DISCOUNT_AMOUNT,txtDiscountAmount.getBigDecimalValue());
				argMap.put(BillKeys.BILL_DOC_NO,txtDocumentNo.getText().trim());
				argMap.put(BillKeys.BILL_TOTAL_AMOUNT,txtTotalAmount.getBigDecimalValue());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(BillKeys.BILL_GROUPS,getBillGroups());
				argMap.put(InvKeys.INV_TRANSACTIONS,getInventoryTransactions());				
				
				Integer result = (Integer)EngTXCommon.doTransactionTX(BillBLAddBill.class.getName(),"saveBillFromBill",argMap);
				if(result.intValue()!=1)
				{
					EngUICommon.showMessageBox(getShell(),Messages.getString("BillUIAddBill.30"), SWT.ICON_WARNING); //$NON-NLS-1$
				}
				msg.setMessage(Messages.getString("BillUIAddBill.43")); //$NON-NLS-1$
				msg.open();
				newForm();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	public List getBillGroups()
	{
		List list = new ArrayList();
		TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getChecked())
			{
				list.add(items[i].getData());
			}
		}
		return list;
	}

	public List getInventoryTransactions()
	{
		List invTransactions = new ArrayList();
		TableItem items[] = tableConsignmentRows.getItems();
		for (int i = 0; i < items.length; i++)
		{
			InvUITransactionTableRow row = (InvUITransactionTableRow) items[i].getData();
			TurqInventoryTransaction invTrans = (TurqInventoryTransaction) row.getDBObject();
			invTrans.setTurqInventoryWarehous((TurqInventoryWarehous) comboWareHouse.getData(comboWareHouse.getText()));
			if (row.okToSave())
			{
				invTransactions.add(invTrans);
			}
		}
		return invTransactions;
	}

	public void delete()
	{
	}

	public void search()
	{
	}

	public void newForm()
	{
		BillUIAddBuyBill curCard = new BillUIAddBuyBill(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void calculateTotals()
	{
		TableItem items[] = tableConsignmentRows.getItems();
		BigDecimal subTotal = new BigDecimal(0);
		BigDecimal totalVAT = new BigDecimal(0);
		BigDecimal totalSpecVAT = new BigDecimal(0);
		BigDecimal generalTotal = new BigDecimal(0);
		BigDecimal discountTotal = new BigDecimal(0);
		for (int i = 0; i < items.length; i++)
		{
			TurqInventoryTransaction invTrans = (TurqInventoryTransaction) ((InvUITransactionTableRow) (items[i].getData()))
					.getDBObject();
			subTotal = subTotal.add(invTrans.getTotalPriceInForeignCurrency());
			totalVAT = totalVAT.add(invTrans.getVatAmountInForeignCurrency());
			totalSpecVAT = totalSpecVAT.add(invTrans.getVatSpecialAmountInForeignCurrency());
			discountTotal = discountTotal.add(invTrans.getDiscountAmountInForeignCurrency());
		}
		generalTotal = subTotal.add(totalVAT).add(totalSpecVAT);
		txtDiscountAmount.setText(discountTotal);
		txtSubTotal.setText(subTotal);
		txtTotalVat.setText(totalVAT);
		decSpecialVat.setText(totalSpecVAT);
		txtTotalAmount.setText(generalTotal.subtract(discountTotal));
	}

	
}