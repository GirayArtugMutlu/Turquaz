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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearchDialog;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.BillLangKeys;
import com.turquaz.engine.lang.ConsLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.inventory.InvKeys;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillUIBillFromConsignment extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	/**
	 * @return Returns the comboConsignmentType.
	 */
	public CCombo getComboConsignmentType()
	{
		return comboConsignmentType;
	}

	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup()
	{
		return compRegisterGroup;
	}

	/**
	 * @return Returns the dateBillDate.
	 */
	public DatePicker getDateBillDate()
	{
		return dateBillDate;
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
	 * @return Returns the txtCurrentCard.
	 */
	public Text getTxtCurrentCard()
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
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnVat;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnUnitPrice;
	private TableColumn tableColumnAmount;
	private Composite compTotalsPanel;
	private CLabel lblInventoryPrice;
	private ToolItem toolItem1;
	private ToolBar toolBar;
	private Text txtBillDocumentNo;
	private CLabel lblBillDocNo;
	private DatePicker dateDueDate;
	private CLabel lblDueDate;
	private DatePicker dateConsDate;
	private CLabel lblConsignmentDate;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CurrencyText decSpecialVat;
	private CLabel lblSpecialVAT;
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
	List consList = new ArrayList();

	public BillUIBillFromConsignment(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(698, 529);
			{
				cTabFolder1 = new CTabFolder(this, SWT.NONE);
				GridData cTabFolder1LData = new GridData();
				cTabFolder1LData.grabExcessHorizontalSpace = true;
				cTabFolder1LData.grabExcessVerticalSpace = true;
				cTabFolder1LData.horizontalAlignment = GridData.FILL;
				cTabFolder1LData.verticalAlignment = GridData.FILL;
				cTabFolder1.setLayoutData(cTabFolder1LData);
				{
					tabItemGeneral = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGeneral.setText(EngLangCommonKeys.STR_GENERAL_INFO);
					tabItemGeneral.setImage(SWTResourceManager.getImage("icons/Home16.gif")); //$NON-NLS-1$
					{
						compGeneral = new Composite(cTabFolder1, SWT.NONE);
						GridLayout compGeneralLayout = new GridLayout();
						compGeneral.setLayout(compGeneralLayout);
						tabItemGeneral.setControl(compGeneral);
						//START >>  toolBar
						toolBar = new ToolBar(compGeneral, SWT.RIGHT);
						//START >>  toolItem1
						toolItem1 = new ToolItem(toolBar, SWT.NONE);
						toolItem1.setText(ConsLangKeys.STR_SELECT_CONSIGNMENT);
						toolItem1.setImage(SWTResourceManager.getImage("icons/search.gif"));
						toolItem1.addSelectionListener(new SelectionAdapter() {
							public void widgetSelected(SelectionEvent evt) {
							chooseConsignmentMouseUp();	
							}
						});
						//END <<  toolItem1
						//END <<  toolBar
						{
							compInfoPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout compInfoPanelLayout = new GridLayout();
							GridData compInfoPanelLData = new GridData();
							compInfoPanelLData.horizontalSpan = 2;
							compInfoPanelLData.horizontalAlignment = GridData.FILL;
							compInfoPanelLData.heightHint = 148;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
							{
								lblCurrentCard = new CLabel(compInfoPanel, SWT.NONE);
								lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD);
								GridData lblCurrentCardLData1 = new GridData();
								lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
								lblCurrentCard.setLayoutData(lblCurrentCardLData1);
							}
							{
								txtCurrentCard = new Text(compInfoPanel, SWT.MULTI);
								GridData txtCurrentCardLData = new GridData();
								txtCurrentCard.setBackground(SWTResourceManager.getColor(255,255,255));
								txtCurrentCard.setEditable(false);
								txtCurrentCardLData.widthHint = 232;
								txtCurrentCardLData.heightHint = 18;
								txtCurrentCard.setLayoutData(txtCurrentCardLData);
							}
							{
								lblConsignmentDate = new CLabel(compInfoPanel, SWT.NONE);
								lblConsignmentDate.setText(ConsLangKeys.STR_CONS_DATE);
							}
							{
								dateConsDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateConsDateLData = new GridData();
								dateConsDate.setEnabled(false);
								dateConsDateLData.widthHint = 109;
								dateConsDateLData.heightHint = 21;
								dateConsDate.setLayoutData(dateConsDateLData);
							}
							{
								lblDocumentNo = new CLabel(compInfoPanel, SWT.NONE);
								lblDocumentNo.setText(ConsLangKeys.STR_CONS_DOC_NO);
							}
							{
								txtDocumentNo = new Text(compInfoPanel, SWT.NONE);
								GridData txtDocumentNoLData = new GridData();
								txtDocumentNo.setBackground(SWTResourceManager.getColor(255,255,255));
								txtDocumentNo.setEditable(false);
								txtDocumentNoLData.widthHint = 232;
								txtDocumentNoLData.heightHint = 18;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDate.setText(BillLangKeys.STR_BILL_DATE);
							}
							{
								dateBillDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDateLData.widthHint = 109;
								dateConsignmentDateLData.heightHint = 21;
								dateBillDate.setLayoutData(dateConsignmentDateLData);
							}
							//START >>  lblBillDocNo
							lblBillDocNo = new CLabel(compInfoPanel, SWT.NONE);
							lblBillDocNo.setText(BillLangKeys.STR_BILL_DOC_NO);
							//END <<  lblBillDocNo
							//START >>  txtBillDocumentNo
							txtBillDocumentNo = new Text(compInfoPanel, SWT.NONE);
							GridData txtBillDocumentNoLData = new GridData();
							txtBillDocumentNoLData.widthHint = 232;
							txtBillDocumentNoLData.heightHint = 18;
							txtBillDocumentNo.setLayoutData(txtBillDocumentNoLData);
							//END <<  txtBillDocumentNo
							{
								lblDueDate = new CLabel(compInfoPanel, SWT.NONE);
								lblDueDate.setText(EngLangCommonKeys.STR_DUE_DATE);
							}
							{
								dateDueDate = new DatePicker(compInfoPanel, SWT.NONE);
								GridData dateDueDateLData = new GridData();
								dateDueDateLData.widthHint = 109;
								dateDueDateLData.heightHint = 21;
								dateDueDate.setLayoutData(dateDueDateLData);
							}
							{
								lblType = new CLabel(compInfoPanel, SWT.LEFT);
								lblType.setText(EngLangCommonKeys.STR_TYPE);
							}
							{
								comboConsignmentType = new CCombo(compInfoPanel, SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentType.setEnabled(false);
								comboConsignmentType.setBackground(SWTResourceManager.getColor(255, 255, 255));
								comboConsignmentType.setEditable(false);
								comboConsignmentType.setText(EngLangCommonKeys.COMMON_BUY_STRING);
								comboConsignmentTypeLData.widthHint = 85;
								comboConsignmentTypeLData.heightHint = 18;
								comboConsignmentTypeLData.horizontalSpan = 3;
								comboConsignmentType.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDefinition = new CLabel(compInfoPanel, SWT.LEFT);
								lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
								GridData lblDefinitionLData = new GridData();
								lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
								lblDefinition.setLayoutData(lblDefinitionLData);
							}
							{
								txtDefinition = new Text(compInfoPanel, SWT.V_SCROLL);
								GridData txtDefinitionLData = new GridData();
								txtDefinitionLData.widthHint = 425;
								txtDefinitionLData.heightHint = 32;
								txtDefinitionLData.horizontalSpan = 3;
								txtDefinition.setLayoutData(txtDefinitionLData);
							}
						}
						{
							tableConsignmentRows = new Table(compGeneral, SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
							GridData tableConsignmentRowsLData = new GridData();
							tableConsignmentRows.setLinesVisible(true);
							tableConsignmentRows.setHeaderVisible(true);
							tableConsignmentRowsLData.grabExcessHorizontalSpace = true;
							tableConsignmentRowsLData.grabExcessVerticalSpace = true;
							tableConsignmentRowsLData.horizontalAlignment = GridData.FILL;
							tableConsignmentRowsLData.verticalAlignment = GridData.FILL;
							tableConsignmentRows.setLayoutData(tableConsignmentRowsLData);
							{
								tableColumnInventoryCode = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnInventoryCode.setText(InvLangKeys.STR_INV_CODE);
								tableColumnInventoryCode.setWidth(98);
							}
							{
								tableColumnInventoryName = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnInventoryName.setText(InvLangKeys.STR_INV_NAME);
								tableColumnInventoryName.setWidth(106);
							}
							{
								tableColumnAmount = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnAmount.setText(EngLangCommonKeys.STR_AMOUNT);
								tableColumnAmount.setWidth(99);
							}
							{
								tableColumnUnit = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnUnit.setText(EngLangCommonKeys.STR_UNIT);
								tableColumnUnit.setWidth(54);
							}
							{
								tableColumnUnitPrice = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnUnitPrice.setText(EngLangCommonKeys.STR_UNIT_PRICE);
								tableColumnUnitPrice.setWidth(70);
							}
							{
								tableColumnTotalPrice = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnTotalPrice.setText(EngLangCommonKeys.STR_TOTAL_PRICE);
								tableColumnTotalPrice.setWidth(90);
							}
							{
								tableColumnVat = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnVat.setText(InvLangKeys.STR_VAT_PERCENTAGE);
								tableColumnVat.setWidth(50);
							}
							{
								tableColumnVatAmount = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnVatAmount.setText(InvLangKeys.STR_VAT_TOTAL);
								tableColumnVatAmount.setWidth(90);
							}
							{
								TableColumnVATSpecial = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								TableColumnVATSpecial.setText(InvLangKeys.STR_SPEC_VAT);
								TableColumnVATSpecial.setWidth(100);
							}
							{
								tableColumnCumulative = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnCumulative.setText(EngLangCommonKeys.STR_GENERAL_TOTAL);
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
							composite1LData1.heightHint = 126;
							compTotalsPanel.setLayoutData(composite1LData1);
							composite1Layout1.numColumns = 4;
							compTotalsPanel.setLayout(composite1Layout1);
							{
								lblDiscountAmount = new CLabel(compTotalsPanel, SWT.NONE);
								lblDiscountAmount.setText(EngLangCommonKeys.STR_DISCOUNT_AMOUNT);
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
								txtDiscountAmountLData.widthHint = 191;
								txtDiscountAmountLData.heightHint = 18;
								txtDiscountAmount.setLayoutData(txtDiscountAmountLData);
							}
							{
								lblTotalAmount = new CLabel(compTotalsPanel, SWT.NONE);
								lblTotalAmount.setText(EngLangCommonKeys.STR_GENERAL_TOTAL);
								GridData lblTotalAmountLData = new GridData();
								lblTotalAmount.setSize(87, 19);
								lblTotalAmountLData.widthHint = 87;
								lblTotalAmountLData.heightHint = 19;
								lblTotalAmount.setLayoutData(lblTotalAmountLData);
							}
							{
								txtTotalAmount = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData txtTotalAmountLData = new GridData();
								txtTotalAmount.setBackground(SWTResourceManager.getColor(255, 255, 255));
								txtTotalAmount.setEditable(false);
								txtTotalAmountLData.widthHint = 197;
								txtTotalAmountLData.heightHint = 17;
								txtTotalAmount.setLayoutData(txtTotalAmountLData);
							}
							{
								lblInventoryPrice = new CLabel(compTotalsPanel, SWT.NONE);
								lblInventoryPrice.setText(EngLangCommonKeys.STR_MIDDLE_SUM);
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
								text1LData.widthHint = 190;
								text1LData.heightHint = 19;
								text1LData.horizontalSpan = 3;
								txtSubTotal.setLayoutData(text1LData);
							}
							{
								lblTotalVat = new CLabel(compTotalsPanel, SWT.NONE);
								lblTotalVat.setText(InvLangKeys.STR_TOTAL_VAT);
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
								txtTotalVatLData.widthHint = 190;
								txtTotalVatLData.heightHint = 19;
								txtTotalVatLData.horizontalSpan = 3;
								txtTotalVat.setLayoutData(txtTotalVatLData);
							}
							{
								lblSpecialVAT = new CLabel(compTotalsPanel, SWT.NONE);
								lblSpecialVAT.setText(InvLangKeys.STR_SPEC_VAT);
								GridData lblSpecialVATLData = new GridData();
								lblSpecialVATLData.widthHint = 104;
								lblSpecialVATLData.heightHint = 16;
								lblSpecialVAT.setLayoutData(lblSpecialVATLData);
							}
							{
								decSpecialVat = new CurrencyText(compTotalsPanel, SWT.NONE);
								GridData decSpecialVatLData = new GridData();
								decSpecialVat.setBackground(SWTResourceManager.getColor(255, 255, 255));
								decSpecialVat.setEditable(false);
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
					tabItemGroups.setText(EngLangCommonKeys.STR_GROUPS);
					tabItemGroups.setImage(SWTResourceManager.getImage("icons/Multi16.gif")); //$NON-NLS-1$
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
							btnUpdateGroups.setText(EngLangCommonKeys.STR_UPDATE_GROUPS);
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
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void btnUpdateGroupsClick()
	{
		new BillUIBillsGroupDialog(this.getShell(), SWT.NULL).open();
		fillGroupsTable();
	}

	public void fillGroupsTable()
	{
		try
		{
//			 Fill Group Table
			HashBag groupBag = (HashBag) EngTXCommon.doSelectTX(BillBLAddGroups.class.getName(), "getBillGroups", null);

			HashMap groupList = (HashMap) groupBag.get(BillKeys.BILL_GROUPS);

			compRegisterGroup.fillTableAllGroups(groupList);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
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
			
				
			HashMap invTrans = (HashMap)  (items[i].getData());

			subTotal = subTotal.add((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
			totalVAT = totalVAT.add((BigDecimal) invTrans.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY));
			totalSpecVAT = totalSpecVAT.add((BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY));
			discountTotal = discountTotal.add((BigDecimal) invTrans.get(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY));

		}
		generalTotal = subTotal.add(totalVAT).add(totalSpecVAT);
		txtDiscountAmount.setText(discountTotal);
		txtSubTotal.setText(subTotal);
		txtTotalVat.setText(totalVAT);
		decSpecialVat.setText(totalSpecVAT);
		txtTotalAmount.setText(generalTotal.subtract(discountTotal));
	}
	public void postInitGui()
	{
		cTabFolder1.setSelection(0);
		fillGroupsTable();
		//fill combo type
		comboConsignmentType.add(EngLangCommonKeys.COMMON_BUY_STRING);
		comboConsignmentType.add(EngLangCommonKeys.COMMON_SELL_STRING);
		}

	public boolean verifyFields()
	{
		if (consList.size()==0)
		{
			EngUICommon.showMessageBox(getShell(),ConsLangKeys.MSG_SELECT_CONS_NO,SWT.ICON_WARNING);
			return false;
		}
		
		return true;
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				int type = EngBLCommon.COMMON_BUY_INT;
				if (comboConsignmentType.getText().equals(EngLangCommonKeys.COMMON_SELL_STRING)) { //$NON-NLS-1$
					type = EngBLCommon.COMMON_SELL_INT;
				}
				
				HashMap argMap=new HashMap();
				
				argMap.put(BillKeys.BILL_DOC_NO,txtBillDocumentNo.getText().trim());
				argMap.put(BillKeys.BILL_DEFINITION,txtDefinition.getText().trim());
				argMap.put(BillKeys.BILL_IS_PRINTED,new Boolean(false));
				argMap.put(BillKeys.BILL_DATE,dateBillDate.getDate());
				argMap.put(BillKeys.BILL_CONS_LIST,consList);
				argMap.put(EngKeys.TYPE,new Integer(type));
				argMap.put(CurKeys.CUR_CARD_ID,txtCurrentCard.getData());
				argMap.put(BillKeys.BILL_DUE_DATE,dateDueDate.getDate());
				argMap.put(BillKeys.BILL_DISCOUNT_AMOUNT,txtDiscountAmount.getBigDecimalValue());
				argMap.put(BillKeys.BILL_TOTAL_AMOUNT,txtTotalAmount.getBigDecimalValue());
				argMap.put(EngKeys.CURRENCY_ID,EngBLClient.getBaseCurrencyId());
				argMap.put(BillKeys.BILL_GROUPS,getBillGroups());
				argMap.put(BillKeys.BILL_CHECK,EngBLClient.getBillCheckStatus());
				
				EngTXCommon.doTransactionTX(BillBLAddBill.class.getName(),"saveBillFromCons",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				
				boolean print=EngUICommon.showQuestion(getShell(),BillLangKeys.MSG_WANT_TO_PRINT_BILL);
				if (print)
				{
				//	boolean ans = EngUICommon.showQuestion(getShell(),BillLangKeys.MSG_WILL_BALANCE_BE_PRINTED);
				//	argMap = new HashMap();
				//	argMap.put(BillKeys.BILL, bill);
				//	argMap.put(BillKeys.BILL_BALANCE, new Boolean(ans));
				//	EngTXCommon.doSelectTX(EngBLUtils.class.getName(), "printBill", argMap);
				}	
				
				
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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

	public void delete()
	{
	}

	public void search()
	{
	}

	public void newForm()
	{
		BillUIBillFromConsignment curCard = new BillUIBillFromConsignment(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}
	

	public void chooseConsignmentMouseUp()
	{
		Object[] result = new ConUIConsignmentSearchDialog(this.getShell(), SWT.NULL).open(dateBillDate.getDate());
		if(result[0]==null||result[1]==null)
		{
			return;
		}
		txtDocumentNo.setText("");
		
		Integer curCardId = (Integer)result[0];
	
		txtCurrentCard.setData(curCardId);
	
		consList = (List)result[1];
		
		tableConsignmentRows.removeAll();
		for(int i=0;i<consList.size();i++)
		{
			if(i!=0)
			{
				txtDocumentNo.setText(txtDocumentNo.getText()+",");
			}
		
		  try
			{
		  		Integer consId=(Integer)consList.get(i);
		  	    HashMap argMap=new HashMap();
		  	    argMap.put(ConsKeys.CONS_ID,consId);
				
				HashBag consInfo = (HashBag)EngTXCommon.doSelectTX(ConBLUpdateConsignment.class.getName(),"getConsignmentInfo",argMap);
		  		
				
				dateConsDate.setDate((Date)consInfo.get(EngKeys.DATE));
				
				HashMap invTransMap = (HashMap)consInfo.get(InvKeys.INV_TRANSACTIONS);
				
				
				TableItem item;
			
				
				for(int k=0;i<invTransMap.size();k++)
				{
					/**
					 * TODO Amount In is wrong....
					 */
					HashMap invTransInfo = (HashMap) invTransMap.get(new Integer(k));
					
					BigDecimal amount =(BigDecimal) invTransInfo.get(InvKeys.INV_AMOUNT_IN);
					
					if (amount.doubleValue()==0)
					{
						amount = (BigDecimal) invTransInfo.get(InvKeys.INV_AMOUNT_OUT);
					}
					item = new TableItem(tableConsignmentRows, SWT.NULL);
					
					item.setData(invTransInfo.get(InvKeys.INV_TRANS_ID));
					
					HashMap invCardInfo =(HashMap)invTransInfo.get(InvKeys.INV_CARD);
					
					item.setText(new String[]{invCardInfo.get(InvKeys.INV_CARD_NAME).toString(),
							invCardInfo.get(InvKeys.INV_CARD_CODE).toString(), amount + "", //$NON-NLS-1$
							invTransInfo.get(InvKeys.INV_UNIT_NAME).toString(), invTransInfo.get(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY).toString(),
							invTransInfo.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY).toString(), invTransInfo.get(InvKeys.INV_VAT_RATE) + "", //$NON-NLS-1$
							invTransInfo.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY).toString(),
							invTransInfo.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY).toString(),
							invTransInfo.get(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY).toString()});
				
				}
				String type = EngLangCommonKeys.COMMON_BUY_STRING;
				if (((Integer)consInfo.get(EngKeys.TYPE)).intValue() == 1)
				{
					type = EngLangCommonKeys.COMMON_SELL_STRING;
				}
				comboConsignmentType.setText(type);
				
				txtDocumentNo.setText(txtDocumentNo.getText()+consInfo.get(EngKeys.DOCUMENT_NO).toString());
			    calculateTotals();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
		
	}
}