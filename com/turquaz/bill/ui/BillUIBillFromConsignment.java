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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.consignment.ui.ConUIConsignmentSearchDialog;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.interfaces.SecureComposite;

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
					tabItemGeneral.setText(Messages.getString("BillUIBillFromConsignment.0")); //$NON-NLS-1$
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
						toolItem1.setText("\u0130rsaliye Seç");
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
								lblCurrentCard.setText(Messages.getString("BillUIBillFromConsignment.5")); //$NON-NLS-1$
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
								lblConsignmentDate.setText(Messages.getString("BillUIBillFromConsignment.4")); //$NON-NLS-1$
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
								lblDocumentNo.setText("\u0130rsaliye No"); //$NON-NLS-1$
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
								lblDate.setText("Fatura Tarihi"); //$NON-NLS-1$
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
							lblBillDocNo.setText("Fatura No");
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
								lblDueDate.setText("Vade Tarihi");
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
								lblType.setText(Messages.getString("BillUIBillFromConsignment.8")); //$NON-NLS-1$
							}
							{
								comboConsignmentType = new CCombo(compInfoPanel, SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentType.setEnabled(false);
								comboConsignmentType.setBackground(SWTResourceManager.getColor(255, 255, 255));
								comboConsignmentType.setEditable(false);
								comboConsignmentType.setText(Messages.getString("BillUIBillFromConsignment.9")); //$NON-NLS-1$
								comboConsignmentTypeLData.widthHint = 85;
								comboConsignmentTypeLData.heightHint = 18;
								comboConsignmentTypeLData.horizontalSpan = 3;
								comboConsignmentType.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDefinition = new CLabel(compInfoPanel, SWT.LEFT);
								lblDefinition.setText(Messages.getString("BillUIBillFromConsignment.11")); //$NON-NLS-1$
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
								tableColumnInventoryCode.setText(Messages.getString("BillUIBillFromConsignment.13")); //$NON-NLS-1$
								tableColumnInventoryCode.setWidth(98);
							}
							{
								tableColumnInventoryName = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnInventoryName.setText(Messages.getString("BillUIBillFromConsignment.14")); //$NON-NLS-1$
								tableColumnInventoryName.setWidth(106);
							}
							{
								tableColumnAmount = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnAmount.setText(Messages.getString("BillUIBillFromConsignment.15")); //$NON-NLS-1$
								tableColumnAmount.setWidth(99);
							}
							{
								tableColumnUnit = new TableColumn(tableConsignmentRows, SWT.NONE);
								tableColumnUnit.setText(Messages.getString("BillUIBillFromConsignment.16")); //$NON-NLS-1$
								tableColumnUnit.setWidth(54);
							}
							{
								tableColumnUnitPrice = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnUnitPrice.setText(Messages.getString("BillUIBillFromConsignment.17")); //$NON-NLS-1$
								tableColumnUnitPrice.setWidth(70);
							}
							{
								tableColumnTotalPrice = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnTotalPrice.setText(Messages.getString("BillUIBillFromConsignment.18")); //$NON-NLS-1$
								tableColumnTotalPrice.setWidth(77);
							}
							{
								tableColumnVat = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnVat.setText(Messages.getString("BillUIBillFromConsignment.19")); //$NON-NLS-1$
								tableColumnVat.setWidth(50);
							}
							{
								tableColumnVatAmount = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnVatAmount.setText(Messages.getString("BillUIBillFromConsignment.20")); //$NON-NLS-1$
								tableColumnVatAmount.setWidth(90);
							}
							{
								TableColumnVATSpecial = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								TableColumnVATSpecial.setText(Messages.getString("BillUIBillFromConsignment.21")); //$NON-NLS-1$
								TableColumnVATSpecial.setWidth(100);
							}
							{
								tableColumnCumulative = new TableColumn(tableConsignmentRows, SWT.RIGHT);
								tableColumnCumulative.setText(Messages.getString("BillUIBillFromConsignment.22")); //$NON-NLS-1$
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
								lblDiscountAmount.setText(Messages.getString("BillUIBillFromConsignment.23")); //$NON-NLS-1$
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
								lblTotalAmount.setText(Messages.getString("BillUIBillFromConsignment.24")); //$NON-NLS-1$
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
								lblInventoryPrice.setText(Messages.getString("BillUIBillFromConsignment.25")); //$NON-NLS-1$
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
								lblTotalVat.setText(Messages.getString("BillUIBillFromConsignment.26")); //$NON-NLS-1$
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
								lblSpecialVAT = new Label(compTotalsPanel, SWT.NONE);
								lblSpecialVAT.setText(Messages.getString("BillUIBillFromConsignment.27")); //$NON-NLS-1$
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
					tabItemGroups.setText(Messages.getString("BillUIBillFromConsignment.28")); //$NON-NLS-1$
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
							btnUpdateGroups.setText(Messages.getString("BillUIBillFromConsignment.30")); //$NON-NLS-1$
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
			//Fill Group Table
			List list = (List)EngTXCommon.doSelectTX(BillBLAddGroups.class.getName(),"getBillGroups",null);
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
			TurqInventoryTransaction invTrans = (TurqInventoryTransaction)  (items[i].getData());
				
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
	public void postInitGui()
	{
		cTabFolder1.setSelection(0);
		fillGroupsTable();
		//fill combo type
		comboConsignmentType.add(Messages.getString("BillUIBillFromConsignment.31")); //$NON-NLS-1$
		comboConsignmentType.add(Messages.getString("BillUIBillFromConsignment.32")); //$NON-NLS-1$
		}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (consList.size()==0)
		{
			msg.setMessage(Messages.getString("BillUIBillFromConsignment.12")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		
		return true;
	}

	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				int type = EngBLCommon.COMMON_BUY_INT;
				if (comboConsignmentType.getText().equals(EngBLCommon.COMMON_SELL_STRING)) { //$NON-NLS-1$
					type = EngBLCommon.COMMON_SELL_INT;
				}
				
				HashMap argMap=new HashMap();
				
				argMap.put(BillKeys.BILL_DOC_NO,txtBillDocumentNo.getText().trim());
				argMap.put(BillKeys.BILL_DEFINITION,txtDefinition.getText().trim());
				argMap.put(BillKeys.BILL_IS_PRINTED,new Boolean(false));
				argMap.put(BillKeys.BILL_DATE,dateBillDate.getDate());
				argMap.put(BillKeys.BILL_CONS_LIST,consList);
				argMap.put(EngKeys.TYPE,new Integer(type));
				argMap.put(EngKeys.CURRENT_CARD,txtCurrentCard.getData());
				argMap.put(BillKeys.BILL_DUE_DATE,dateDueDate.getDate());
				argMap.put(BillKeys.BILL_DISCOUNT_AMOUNT,txtDiscountAmount.getBigDecimalValue());
				argMap.put(BillKeys.BILL_TOTAL_AMOUNT,txtTotalAmount.getBigDecimalValue());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(BillKeys.BILL_GROUPS,getBillGroups());
				argMap.put(BillKeys.BILL_CHECK,EngBLCommon.getBillCheckStatus());
				
				TurqBill bill = (TurqBill)EngTXCommon.doTransactionTX(BillBLAddBill.class.getName(),"saveBillFromCons",argMap);
				msg.setMessage(Messages.getString("BillUIBillFromConsignment.34")); //$NON-NLS-1$
				msg.open();
				
				MessageBox msg2 = new MessageBox(this.getShell(), SWT.YES | SWT.NO);
				msg2.setMessage(Messages.getString("BillUIAddSellBill.16")); //$NON-NLS-1$
				int answer = msg2.open();
				if (answer == SWT.YES)
				{
					boolean ans = EngUICommon.showQuestion(getShell(), Messages.getString("BillUIAddSellBill.20")); //$NON-NLS-1$
					argMap = new HashMap();
					argMap.put(BillKeys.BILL, bill);
					argMap.put(BillKeys.BILL_BALANCE, new Boolean(ans));
					EngTXCommon.doSelectTX(EngBLUtils.class.getName(), "printBill", argMap);
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
		txtCurrentCard.setData(result[0]);
		TurqCurrentCard curCard = (TurqCurrentCard)result[0];
		txtCurrentCard.setText(curCard.getCardsCurrentCode()+" "+curCard.getCardsName());
		consList = (List)result[1];
		
		tableConsignmentRows.removeAll();
		for(int i=0;i<consList.size();i++)
		{
			if(i!=0)
			{
				txtDocumentNo.setText(txtDocumentNo.getText()+",");
			}
			TurqConsignment cons = null;
		  try
			{
		  		Integer consId=(Integer)consList.get(i);
		  	    HashMap argMap=new HashMap();
		  	    argMap.put(ConsKeys.CONS_ID,consId);
		  		cons = (TurqConsignment)EngTXCommon.doSelectTX(ConBLUpdateConsignment.class.getName(),"initiliazeConsignmentById",argMap);
				dateConsDate.setDate(cons.getConsignmentsDate());
				
				Set invTransactions = cons.getTurqEngineSequence().getTurqInventoryTransactions();
				
				List list = new ArrayList(invTransactions);
				
				Collections.sort(list,new EngBLHibernateComparer());
				
				Iterator it = list.iterator();
				TableItem item;
				TurqInventoryTransaction invTrans;
				
				while (it.hasNext())
				{
					/**
					 * TODO Amount In is wrong....
					 */
					invTrans = (TurqInventoryTransaction) it.next();
					BigDecimal amount = invTrans.getAmountIn();
					if (amount.doubleValue()==0)
					{
						amount = invTrans.getAmountOut();
					}
					item = new TableItem(tableConsignmentRows, SWT.NULL);
					item.setData(invTrans);
					item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
							invTrans.getTurqInventoryCard().getCardName(), amount + "", //$NON-NLS-1$
							invTrans.getTurqInventoryUnit().getUnitsName(), invTrans.getUnitPriceInForeignCurrency().toString(),
							invTrans.getTotalPriceInForeignCurrency().toString(), invTrans.getVatRate() + "", //$NON-NLS-1$
							invTrans.getVatAmountInForeignCurrency().toString(),
							invTrans.getVatSpecialAmountInForeignCurrency().toString(),
							invTrans.getCumilativePriceInForeignCurrency().toString()});
				
				}
				String type = Messages.getString("BillUIBillFromConsignment.29"); //$NON-NLS-1$
				if (cons.getConsignmentsType() == 1)
				{
					type = Messages.getString("BillUIBillFromConsignment.43"); //$NON-NLS-1$
				}
				comboConsignmentType.setText(type);
				dateConsDate.setDate(cons.getConsignmentsDate());
				txtDocumentNo.setText(txtDocumentNo.getText()+cons.getConsignmentDocumentNo());
			    calculateTotals();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
		
	}
}