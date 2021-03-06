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
 * @author  Cem Dayanik
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.ui.BillUIBillUpdateDialog;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLSearchTransaction;
import com.turquaz.inventory.dal.InvDALCardAdd;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import com.turquaz.current.CurKeys;
import com.turquaz.current.ui.comp.CurrentCodePicker;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for anycorporate or commercial purpose. *************************************
 */
public class InvUIInventoryTransactionReport extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compInvTransactionSearch;
	private Table tableInvTransactions;
	private TableColumn tableColumnTotalAmountOut;
	private TableColumn tableColumnUnitPriceOut;
	private TableColumn tableColumnUnitPriceIn;
	private Button radioInvName;
	private Composite compRadio;
	private Button radioInvCode;
	private CCombo comboInvSubGroup;
	private CLabel lblInvSubGroup;
	private ViewerComposite viewer;
	private CTabItem tabItemReport;
	private CTabItem tabItemSearch;
	private CTabFolder tabFolder;
	private Text txtInvNameEnd;
	private CLabel lblInvNameEnd;
	private InventoryPicker txtInvCardEnd;
	private CLabel lblInvCardEnd;
	private TableColumn tableColumnInventoryName;
	private Text txtInvNameStart;
	private CLabel lblInvName;
	private CCombo comboInvMainGroup;
	private CLabel lblInvGroup;
	private CurrentCodePicker txtCurCardEnd;
	private CLabel lblCurCarEnd;
	private CLabel lblInvCard;
	private InventoryPicker txtInvCardStart;
	private TableColumn tableColumnTotalPriceIn;
	private TableColumn tableColumnInventoryCode;
	private CCombo comboTransactionsType;
	private CurrentCodePicker txtCurCardStart;
	private CLabel lblType;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnTotalAmountIn;
	private TableColumn tableColumnTotalPriceOut;
	private TableColumn tableColumnTransactionDate;
	private InvBLSearchTransaction blSearch = new InvBLSearchTransaction();
	private Calendar cal = Calendar.getInstance();
	private InvDALCardAdd invCardAdd = new InvDALCardAdd();
	private SearchTableViewer tableViewer = null;

	public InvUIInventoryTransactionReport(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(612, 357);
			{
				compInvTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 159;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				compInvTransactionSearch.setLayoutData(composite1LData);
				compInvTransactionSearch.setLayout(composite1Layout);
				//START >> compRadio
				compRadio = new Composite(compInvTransactionSearch, SWT.NONE);
				GridLayout compRadioLayout = new GridLayout();
				GridData compRadioLData = new GridData();
				compRadioLData.grabExcessHorizontalSpace = true;
				compRadioLData.horizontalAlignment = GridData.FILL;
				compRadioLData.horizontalSpan = 4;
				compRadio.setLayoutData(compRadioLData);
				compRadioLayout.numColumns = 5;
				compRadioLayout.marginWidth = 0;
				compRadioLayout.marginHeight = 0;
				compRadio.setLayout(compRadioLayout);
				{
					lblInvCard = new CLabel(compRadio, SWT.NONE);
					lblInvCard.setText(InvLangKeys.STR_INV_CODE_START);
				}
				{
					txtInvCardStart = new InventoryPicker(compRadio, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 157;
					txtInvCardLData.heightHint = 17;
					txtInvCardStart.setLayoutData(txtInvCardLData);
				}
				//START >> lblInvCardEnd
				lblInvCardEnd = new CLabel(compRadio, SWT.NONE);
				lblInvCardEnd.setText(InvLangKeys.STR_INV_CODE_END);
				GridData lblInvCardEndLData = new GridData();
				lblInvCardEndLData.widthHint = 106;
				lblInvCardEndLData.heightHint = 18;
				lblInvCardEnd.setLayoutData(lblInvCardEndLData);
				//END << lblInvCardEnd
				//START >> txtInvCardEnd
				txtInvCardEnd = new InventoryPicker(compRadio, SWT.NONE);
				GridData inventoryPicker1LData = new GridData();
				inventoryPicker1LData.widthHint = 157;
				inventoryPicker1LData.heightHint = 17;
				txtInvCardEnd.setLayoutData(inventoryPicker1LData);
				//END << txtInvCardEnd
				//START >> radioInvCode
				radioInvCode = new Button(compRadio, SWT.RADIO | SWT.LEFT);
				radioInvCode.setText(InvLangKeys.STR_SEARCH_BY_CODE);
				radioInvCode.setSelection(true);
				//END << radioInvCode
				{
					lblInvName = new CLabel(compRadio, SWT.NONE);
					lblInvName.setText(InvLangKeys.STR_INV_NAME_START);
				}
				{
					txtInvNameStart = new Text(compRadio, SWT.NONE);
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 150;
					txtInvNameLData.heightHint = 17;
					txtInvNameStart.setLayoutData(txtInvNameLData);
				}
				//START >> lblInvNameEnd
				lblInvNameEnd = new CLabel(compRadio, SWT.NONE);
				lblInvNameEnd.setText(InvLangKeys.STR_INV_NAME_END);
				//END << lblInvNameEnd
				//START >> txtInvNameEnd
				txtInvNameEnd = new Text(compRadio, SWT.NONE);
				GridData txtInvNameEndLData = new GridData();
				txtInvNameEndLData.widthHint = 150;
				txtInvNameEndLData.heightHint = 17;
				txtInvNameEnd.setLayoutData(txtInvNameEndLData);
				//END << txtInvNameEnd
				//START >> radioInvName
				radioInvName = new Button(compRadio, SWT.RADIO | SWT.LEFT);
				radioInvName.setText(InvLangKeys.STR_SEARCH_BY_NAME);
				//END << radioInvName
				//END << compRadio
				{
					lblCurrentCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD_START);
				}
				{
					txtCurCardStart = new CurrentCodePicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 157;
					txtCurCardLData.heightHint = 17;
					txtCurCardStart.setLayoutData(txtCurCardLData);
				}
				{
					lblCurCarEnd = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblCurCarEnd.setText(CurLangKeys.STR_CUR_CARD_END);
				}
				{
					txtCurCardEnd = new CurrentCodePicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardEndLData = new GridData();
					txtCurCardEndLData.widthHint = 157;
					txtCurCardEndLData.heightHint = 17;
					txtCurCardEnd.setLayoutData(txtCurCardEndLData);
				}
				{
					lblStartDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(compInvTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 157;
					dateStartDateLData.heightHint = 23;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(compInvTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 157;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblInvGroup = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvGroup.setText(InvLangKeys.STR_INV_MAIN_GROUP);
					GridData lblInvGroupLData = new GridData();
					lblInvGroupLData.widthHint = 85;
					lblInvGroupLData.heightHint = 19;
					lblInvGroup.setLayoutData(lblInvGroupLData);
				}
				{
					comboInvMainGroup = new CCombo(compInvTransactionSearch, SWT.NONE);
					GridData comboInvGroupLData = new GridData();
					comboInvMainGroup.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							comboInvMainGroupWidgetSelected(evt);
						}
					});
					comboInvGroupLData.widthHint = 134;
					comboInvGroupLData.heightHint = 17;
					comboInvMainGroup.setLayoutData(comboInvGroupLData);
				}
				//START >> lblInvSubGroup
				lblInvSubGroup = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvSubGroup.setText(InvLangKeys.STR_INV_SUB_GROUP);
				//END << lblInvSubGroup
				//START >> comboInvSubGroup
				comboInvSubGroup = new CCombo(compInvTransactionSearch, SWT.NONE);
				GridData comboInvSubGroupLData = new GridData();
				comboInvSubGroupLData.widthHint = 134;
				comboInvSubGroupLData.heightHint = 17;
				comboInvSubGroup.setLayoutData(comboInvSubGroupLData);
				//END << comboInvSubGroup
				{
					lblType = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblType.setText(EngLangCommonKeys.STR_TYPE);
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboTransactionsType = new CCombo(compInvTransactionSearch, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboTransactionsType.setText(EngLangCommonKeys.COMMON_ALL_STRING);
					comboConsignmentTypeLData.widthHint = 134;
					comboConsignmentTypeLData.heightHint = 17;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> tabItemSearch
			tabItemSearch = new CTabItem(tabFolder, SWT.NONE);
			tabItemSearch.setText(EngLangCommonKeys.STR_SEARCH_RESULT);
			{
				tableInvTransactions = new Table(tabFolder, SWT.FULL_SELECTION);
				tabItemSearch.setControl(tableInvTransactions);
				GridData tableConsignmentsLData = new GridData();
				tableInvTransactions.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						showConsignment();
					}
				});
				tableInvTransactions.setHeaderVisible(true);
				tableInvTransactions.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableInvTransactions.setLayoutData(tableConsignmentsLData);
				{
					tableColumnTransactionDate = new TableColumn(tableInvTransactions, SWT.NONE);
					tableColumnTransactionDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(tableInvTransactions, SWT.NONE);
					tableColumnInventoryCode.setText(InvLangKeys.STR_INV_CODE);
					tableColumnInventoryCode.setWidth(109);
				}
				{
					tableColumnInventoryName = new TableColumn(tableInvTransactions, SWT.NONE);
					tableColumnInventoryName.setText(InvLangKeys.STR_INV_NAME);
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalAmountIn.setText(InvLangKeys.STR_AMOUNT_IN);
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalPriceIn.setText(InvLangKeys.STR_PRICE_IN);
					tableColumnTotalPriceIn.setWidth(100);
				}
				//START >> tableColumnUnitPriceIn
				tableColumnUnitPriceIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
				tableColumnUnitPriceIn.setText(InvLangKeys.STR_UNIT_PRICE_IN);
				tableColumnUnitPriceIn.setWidth(100);
				//END << tableColumnUnitPriceIn
				{
					tableColumnTotalAmountOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalAmountOut.setText(InvLangKeys.STR_AMOUNT_OUT);
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(InvLangKeys.STR_PRICE_OUT);
					tableColumnTotalPriceOut.setWidth(100);
				}
				//START >> tableColumnUnitPriceOut
				tableColumnUnitPriceOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
				tableColumnUnitPriceOut.setText(InvLangKeys.STR_UNIT_PRICE_OUT);
				tableColumnUnitPriceOut.setWidth(100);
				//END << tableColumnUnitPriceOut
			}
			GridData tabFolderLData = new GridData();
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.grabExcessVerticalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolder.setLayoutData(tabFolderLData);
			//END << tabItemSearch
			//START >> tabItemReport
			tabItemReport = new CTabItem(tabFolder, SWT.NONE);
			tabItemReport.setText(EngLangCommonKeys.STR_REPORT);
			//START >> viewer
			viewer = new ViewerComposite(tabFolder, SWT.NONE);
			tabItemReport.setControl(viewer);
			//END << viewer
			tabFolder.setSelection(0);
			//END << tabItemReport
			//END << tabFolder
			postInitGui();
			this.layout();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/*public void GenerateJasper(List list, Map parameters, boolean useGroup)
	{
		try
		{
			String[] fields;
			if (useGroup)
			{
				fields = new String[]{"inventory_transactions_id", "transactions_date", "transactions_amount_in", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						"transactions_total_amount_out", "transactions_total_price", "card_inventory_code", "card_name", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						"cards_name", "inventory_cards_id", "bill_document_no", "groups_name", "inventory_groups_id"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
			}
			else
			{
				fields = new String[]{"inventory_transactions_id", "transactions_date", "transactions_amount_in", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						"transactions_total_amount_out", "transactions_total_price", "card_inventory_code", "card_name", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						"cards_name", "inventory_cards_id", "bill_document_no",}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport;
			if (useGroup)
			{
				jasperReport = JasperCompileManager.compileReport("reports/inventory/InventoryTransactionReportByGroup.jrxml");
			}
			else
			{
				jasperReport = JasperCompileManager.compileReport("reports/inventory/InventoryTransactionReport.jrxml");
			}
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	private void GenerateJasper(List list, int type)
	{
		try
		{
			Map parameters = new HashMap();
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$			
			if (type != EngBLCommon.COMMON_ALL_INT)
			{
				if (type == EngBLCommon.COMMON_BUY_INT)
					parameters.put("type", EngLangCommonKeys.COMMON_BUY_STRING); //$NON-NLS-1$
				else
					parameters.put("type", EngLangCommonKeys.COMMON_SELL_STRING); //$NON-NLS-1$
			}
			else
			{
				parameters.put("type", EngLangCommonKeys.COMMON_ALL_STRING);
			}
			TurqInventoryGroup invMainGroup = (TurqInventoryGroup) comboInvMainGroup.getData(comboInvMainGroup.getText());
			TurqInventoryGroup invSubGroup = (TurqInventoryGroup) comboInvSubGroup.getData(comboInvSubGroup.getText());
			if (invMainGroup != null)
			{
				parameters.put("invMainGroup", invMainGroup.getGroupsName()); //$NON-NLS-1$
				if (invSubGroup != null)
				{
					parameters.put("invSubGroup", invSubGroup.getGroupsName()); //$NON-NLS-1$
				}
				else
				{
					parameters.put("invSubGroup", EngLangCommonKeys.COMMON_ALL_STRING); //$NON-NLS-1$
				}
			}
			else
			{
				parameters.put("invMainGroup", EngLangCommonKeys.COMMON_ALL_STRING); //$NON-NLS-1$ 
				parameters.put("invSubGroup", EngLangCommonKeys.COMMON_ALL_STRING); //$NON-NLS-1$ 
			}
			TurqCurrentCard curCardStart = (TurqCurrentCard) txtCurCardStart.getData();
			TurqCurrentCard curCardEnd = (TurqCurrentCard) txtCurCardEnd.getData();
			if (curCardStart != null && curCardEnd != null)
			{
				parameters.put("curCardStart", curCardStart.getCardsCurrentCode()); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("curCardEnd", curCardEnd.getCardsCurrentCode()); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (curCardStart != null)
			{
				parameters.put("curCardStart", curCardStart.getCardsCurrentCode()); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("curCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (curCardEnd != null)
			{
				parameters.put("curCardStart", curCardEnd.getCardsCurrentCode()); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("curCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else
			{
				parameters.put("curCardStart", ""); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("curCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			TurqInventoryCard invCardStart = (TurqInventoryCard) txtInvCardStart.getData();
			TurqInventoryCard invCardEnd = (TurqInventoryCard) lblInvCardEnd.getData();
			if (invCardStart != null && invCardEnd != null)
			{
				parameters.put("invCardStart", invCardStart.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd", invCardEnd.getCardInventoryCode()); //$NON-NLS-1$
			}
			else if (invCardStart != null)
			{
				parameters.put("invCardStart", invCardStart.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (invCardEnd != null)
			{
				parameters.put("invCardStart", invCardEnd.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else
			{
				parameters.put("invCardStart", ""); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("invCardEnd", ""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			parameters.put("startDate", dformat2.format(dateStartDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", dformat2.format(dateEndDate.getDate())); //$NON-NLS-1$
			parameters.put("dateformat", dformat2); //$NON-NLS-1$
			parameters.put("formatter", new TurkishCurrencyFormat(2)); //$NON-NLS-1$
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			parameters.put("roundingMethod",new Integer(EngBLCommon.ROUNDING_METHOD));
			GenerateJasper(list, parameters, (invMainGroup != null));
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}*/

	public void showConsignment()
	{
		try
		{
			TableItem items[] = tableInvTransactions.getSelection();
			if (items.length > 0)
			{
				Integer transId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (transId != null)
				{
					boolean updated = false;
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_TRANS_ID,transId);
					
					HashBag idBag=(HashBag)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getAllIds",argMap);
					Integer billId=(Integer)idBag.get(BillKeys.BILL_ID);
					Integer consId=(Integer)idBag.get(ConsKeys.CONS_ID);
					
					if (billId != null)
					{
						updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, billId).open();
					}
					else if (consId != null)
					{
						updated = new ConUIConsignmentUpdateDialog(this.getShell(), SWT.NULL, consId).open();
					}
					else
					{
						//TODO Uretimten gelen stok hareketi. Uretim fisini acmali..
					}
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void postInitGui()
	{
		try
		{
			txtInvCardStart.setTextInvName(txtInvNameStart);
			txtInvCardEnd.setTextInvName(txtInvNameEnd);
			comboTransactionsType.add(EngLangCommonKeys.COMMON_ALL_STRING);
			comboTransactionsType.add(EngLangCommonKeys.COMMON_BUY_STRING);
			comboTransactionsType.add(EngLangCommonKeys.COMMON_SELL_STRING);
			comboTransactionsType.setText(EngLangCommonKeys.COMMON_ALL_STRING);
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			dateStartDate.setDate(cal.getTime());
			
			fillComboGroup();
			tableInvTransactions.setData("table_name", "tableInvTransactions");
			createTableViewer();
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public void fillComboGroup()
	{
		try
		{
			HashBag groupBag =(HashBag)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			HashMap groupList=(HashMap)groupBag.get(InvKeys.INV_GROUPS);
			comboInvMainGroup.add("");
			for (int k = 0; k < groupList.size(); k++)
			{
				HashMap gr = (HashMap) groupList.get(new Integer(k));
				String grName=(String)gr.get(InvKeys.INV_GROUP_NAME);
				comboInvMainGroup.add(grName);
				comboInvMainGroup.setData(grName, gr);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}


	public void save()
	{
	}

	public void search()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableViewer.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboTransactionsType.getText().equals(EngLangCommonKeys.COMMON_BUY_STRING))
				type = EngBLCommon.COMMON_BUY_INT;
			else if (comboTransactionsType.getText().equals(EngLangCommonKeys.COMMON_SELL_STRING))
				type = EngBLCommon.COMMON_SELL_INT;
			boolean searchByInvCode = radioInvCode.getSelection();
			
			HashMap argMap=new HashMap();			

			argMap.put(CurKeys.CUR_CARD_START_ID, txtCurCardStart.getCardId());
			argMap.put(CurKeys.CUR_CARD_END_ID,txtCurCardEnd.getCardId());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.TYPE, new Integer(type));
			
			HashMap subGroupMap=(HashMap)comboInvSubGroup.getData(comboInvSubGroup.getText());
			Integer subGroupId=null;
			if (subGroupMap != null)
			{
				subGroupId=(Integer)subGroupMap.get(InvKeys.INV_GROUP_ID);
			}
			
			HashMap mainGroupMap=(HashMap)comboInvMainGroup.getData(comboInvMainGroup.getText());
			Integer mainGroupId=null;
			if (mainGroupMap != null)
			{
				mainGroupId=(Integer)mainGroupMap.get(InvKeys.INV_GROUP_ID);
			}				
			argMap.put(InvKeys.INV_MAIN_GROUP_ID,mainGroupId);
			argMap.put(InvKeys.INV_SUB_GROUP_ID,subGroupId);
			
			if (searchByInvCode)
			{
				argMap.put(InvKeys.INV_CARD_CODE_START,txtInvCardStart.getText().trim());
				argMap.put(InvKeys.INV_CARD_CODE_END,txtInvCardEnd.getText().trim());
				argMap.put(InvKeys.INV_CARD_NAME_START,"");
				argMap.put(InvKeys.INV_CARD_NAME_END,"");				
			}
			else
			{
				argMap.put(InvKeys.INV_CARD_CODE_START,"");
				argMap.put(InvKeys.INV_CARD_CODE_END,"");
				argMap.put(InvKeys.INV_CARD_NAME_START,txtInvNameStart.getText().trim());
				argMap.put(InvKeys.INV_CARD_NAME_END,txtInvNameEnd.getText().trim());
			}
			HashBag transBag =(HashBag)EngTXCommon.doTransactionTX(InvBLSearchTransaction.class.getName(),"getInventoryTransactionReport",argMap);

			BigDecimal totalAmountIn = new BigDecimal(0);
			BigDecimal totalAmountOut = new BigDecimal(0);
			BigDecimal totalPriceIn = new BigDecimal(0);
			BigDecimal totalPriceOut = new BigDecimal(0);
			
			HashMap transList=(HashMap)transBag.get(InvKeys.INV_TRANSACTIONS);
			for (int i = 0; i < transList.size(); i++)
			{
				HashMap transMap=(HashMap)transList.get(new Integer(i));
				Integer transId = (Integer) transMap.get(InvKeys.INV_TRANS_ID);
				Date transDate = (Date)transMap.get(InvKeys.INV_TRANS_DATE);
				BigDecimal inAmount = (BigDecimal) transMap.get(InvKeys.INV_AMOUNT_IN);
				BigDecimal outAmount = (BigDecimal) transMap.get(InvKeys.INV_AMOUNT_OUT);
				BigDecimal totalPrice = (BigDecimal) transMap.get(InvKeys.INV_TOTAL_PRICE);
				String invCode = (String)transMap.get(InvKeys.INV_CARD_CODE);
				String invName = (String) transMap.get(InvKeys.INV_CARD_NAME);
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				BigDecimal unitPriceIn = new BigDecimal(0);
				BigDecimal unitPriceOut = new BigDecimal(0);
				if (inAmount.doubleValue() == 0)
				{
					priceOut = totalPrice;
					totalPriceOut = totalPriceOut.add(totalPrice);
					if (outAmount.doubleValue() != 0)
						unitPriceOut = totalPrice.divide(outAmount, 2, EngBLCommon.ROUNDING_METHOD);
				}
				else
				{
					priceIn = totalPrice;
					totalPriceIn = totalPriceIn.add(totalPrice);
					if (inAmount.doubleValue() != 0)
						unitPriceIn = totalPrice.divide(inAmount, 2, EngBLCommon.ROUNDING_METHOD);
				}
				totalAmountIn = totalAmountIn.add(inAmount);
				totalAmountOut = totalAmountOut.add(outAmount);
				tableViewer.addRow(new String[]{DatePicker.formatter.format(transDate), invCode, invName, cf.format(inAmount) + "", //$NON-NLS-1$								
						cf.format(priceIn), cf.format(unitPriceIn), cf.format(outAmount) + "", //$NON-NLS-1$
						cf.format(priceOut), cf.format(unitPriceOut)}, transId);
			}
			
			tableViewer.addRow(new String[]{"", "", "", "", "", "", "", "", ""}, null);

			BigDecimal unitPriceIn=(totalAmountIn.doubleValue()== 0) ? new BigDecimal(0) : totalPriceIn.divide(totalAmountIn,2,EngBLCommon.ROUNDING_METHOD);
			BigDecimal unitPriceOut=(totalAmountOut.doubleValue()== 0) ? new BigDecimal(0) : totalPriceOut.divide(totalAmountOut,2,EngBLCommon.ROUNDING_METHOD);
			tableViewer.addRow(new String[]{"", "", EngLangCommonKeys.STR_TOTAL_CAPITAL, cf.format(totalAmountIn), cf.format(totalPriceIn), cf.format(unitPriceIn), cf.format(totalAmountOut), cf.format(totalPriceOut), cf.format(unitPriceOut)}, null);
			
			
			//if (list.size() > 0)
				//GenerateJasper(list, type);
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[9];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[8] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableInvTransactions, columnTypes, true);
	}

	public void delete()
	{
		//should be implemented..
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInvTransactions, ""); //$NON-NLS-1$
	}

	private void comboInvMainGroupWidgetSelected(SelectionEvent evt)
	{
		comboInvSubGroup.removeAll();
		if (comboInvMainGroup.getSelectionIndex() == -1)
			return;
		HashMap invMainGr = (HashMap) comboInvMainGroup.getData(comboInvMainGroup.getText());
		if (invMainGr != null)
		{
			HashBag subGroupBag=(HashBag)invMainGr.get(InvKeys.INV_SUB_GROUPS);
			HashMap subGroups=(HashMap)subGroupBag.get(InvKeys.INV_SUB_GROUPS);
			for(int k=0; k<subGroups.size(); k++)
			{
				HashMap invGr = (HashMap)subGroups.get(new Integer(k));
				String invGrName=(String)invGr.get(InvKeys.INV_GROUP_NAME);
				comboInvSubGroup.add(invGrName);
				comboInvSubGroup.setData(invGrName, invGr);
			}
			if (comboInvSubGroup.getItemCount() > 0)
				comboInvSubGroup.setText(comboInvSubGroup.getItem(0));
		}
	}
}