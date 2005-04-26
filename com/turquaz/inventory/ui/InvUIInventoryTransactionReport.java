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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.bill.ui.BillUIBillUpdateDialog;
import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
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
import com.turquaz.inventory.Messages;
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
					lblInvCard.setText(Messages.getString("InvUIInventoryTransactionReport.0")); //$NON-NLS-1$
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
				lblInvCardEnd.setText(Messages.getString("InvUIInventoryTransactionReport.1")); //$NON-NLS-1$
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
				radioInvCode.setText(Messages.getString("InvUIInventoryTransactionReport.8")); //$NON-NLS-1$
				radioInvCode.setSelection(true);
				//END << radioInvCode
				{
					lblInvName = new CLabel(compRadio, SWT.NONE);
					lblInvName.setText(Messages.getString("InvUIInventoryTransactionReport.9")); //$NON-NLS-1$
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
				lblInvNameEnd.setText(Messages.getString("InvUIInventoryTransactionReport.11")); //$NON-NLS-1$
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
				radioInvName.setText(Messages.getString("InvUIInventoryTransactionReport.15")); //$NON-NLS-1$
				//END << radioInvName
				//END << compRadio
				{
					lblCurrentCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("InvUIInventoryTransactionReport.2")); //$NON-NLS-1$
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
					lblCurCarEnd.setText(Messages.getString("InvUIInventoryTransactionReport.3")); //$NON-NLS-1$
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
					lblStartDate.setText(Messages.getString("InvUIInventoryTransactionReport.4")); //$NON-NLS-1$
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
					lblEndDate.setText(Messages.getString("InvUIInventoryTransactionReport.5")); //$NON-NLS-1$
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
					lblInvGroup.setText(Messages.getString("InvUIInventoryTransactionReport.17")); //$NON-NLS-1$
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
				lblInvSubGroup.setText(Messages.getString("InvUIInventoryTransactionReport.18")); //$NON-NLS-1$
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
					lblType.setText(Messages.getString("InvUIInventoryTransactionReport.6")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboTransactionsType = new CCombo(compInvTransactionSearch, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboTransactionsType.setText(Messages.getString("InvUIInventoryTransactionReport.7")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 134;
					comboConsignmentTypeLData.heightHint = 17;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> tabItemSearch
			tabItemSearch = new CTabItem(tabFolder, SWT.NONE);
			tabItemSearch.setText(Messages.getString("InvUIInventoryTransactionReport.22")); //$NON-NLS-1$
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
					tableColumnTransactionDate.setText(Messages.getString("InvUIInventoryTransactionReport.10")); //$NON-NLS-1$
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(tableInvTransactions, SWT.NONE);
					tableColumnInventoryCode.setText(Messages.getString("InvUIInventoryTransactionReport.23")); //$NON-NLS-1$
					tableColumnInventoryCode.setWidth(109);
				}
				{
					tableColumnInventoryName = new TableColumn(tableInvTransactions, SWT.NONE);
					tableColumnInventoryName.setText(Messages.getString("InvUIInventoryTransactionReport.24")); //$NON-NLS-1$
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalAmountIn.setText(Messages.getString("InvUIInventoryTransactionReport.12")); //$NON-NLS-1$
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalPriceIn.setText(Messages.getString("InvUIInventoryTransactionReport.14")); //$NON-NLS-1$
					tableColumnTotalPriceIn.setWidth(100);
				}
				//START >> tableColumnUnitPriceIn
				tableColumnUnitPriceIn = new TableColumn(tableInvTransactions, SWT.RIGHT);
				tableColumnUnitPriceIn.setText("Gir. Birim Fiyat");
				tableColumnUnitPriceIn.setWidth(100);
				//END << tableColumnUnitPriceIn
				{
					tableColumnTotalAmountOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIInventoryTransactionReport.13")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(Messages.getString("InvUIInventoryTransactionReport.16")); //$NON-NLS-1$
					tableColumnTotalPriceOut.setWidth(100);
				}
				//START >> tableColumnUnitPriceOut
				tableColumnUnitPriceOut = new TableColumn(tableInvTransactions, SWT.RIGHT);
				tableColumnUnitPriceOut.setText("Ç\u0131k. Birim Fiyat");
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
			tabItemReport.setText(Messages.getString("InvUIInventoryTransactionReport.25")); //$NON-NLS-1$
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

	public void GenerateJasper(List list, Map parameters, boolean useGroup)
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
				//jasperReport = (JasperReport) JRLoader.loadObject("reports/inventory/InventoryTransactionReportByGroup.jasper"); //$NON-NLS-1$
			}
			else
			{
				jasperReport = JasperCompileManager.compileReport("reports/inventory/InventoryTransactionReport.jrxml");
				//jasperReport = (JasperReport) JRLoader.loadObject("reports/inventory/InventoryTransactionReport.jasper"); //$NON-NLS-1$
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
					parameters.put("type", EngBLCommon.COMMON_BUY_STRING); //$NON-NLS-1$
				else
					parameters.put("type", EngBLCommon.COMMON_SELL_STRING); //$NON-NLS-1$
			}
			else
			{
				parameters.put("type", Messages.getString("InvUIInventoryTransactionReport.32")); //$NON-NLS-1$ //$NON-NLS-2$
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
					parameters.put("invSubGroup", Messages.getString("InvUIInventoryTransactionReport.26")); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			else
			{
				parameters.put("invMainGroup", Messages.getString("InvUIInventoryTransactionReport.21")); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("invSubGroup", Messages.getString("InvUIInventoryTransactionReport.20")); //$NON-NLS-1$ //$NON-NLS-2$
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
	}

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
					argMap.put(EngKeys.TRANS_ID,transId);
					TurqInventoryTransaction invTrans =(TurqInventoryTransaction)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getInvTransByTransId",argMap);
					TurqEngineSequence seq = invTrans.getTurqEngineSequence();
					argMap=new HashMap();
					argMap.put(EngKeys.ENG_SEQ,seq);
					TurqBill bill =(TurqBill)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getBill",argMap);
					if (bill != null)
					{
						updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, bill).open();
					}
					else
					{
						argMap=new HashMap();
						argMap.put(EngKeys.ENG_SEQ,seq);
						TurqConsignment cons = (TurqConsignment)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getConsignment",argMap);
						updated = new ConUIConsignmentUpdateDialog(this.getShell(), SWT.NULL, cons).open();
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
			comboTransactionsType.add(EngBLCommon.COMMON_ALL_STRING);
			comboTransactionsType.add(EngBLCommon.COMMON_BUY_STRING);
			comboTransactionsType.add(EngBLCommon.COMMON_SELL_STRING);
			comboTransactionsType.setText(EngBLCommon.COMMON_ALL_STRING);
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			dateStartDate.setDate(cal.getTime());
			List groupList = (List)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			comboInvMainGroup.add(""); //$NON-NLS-1$
			for (int k = 0; k < groupList.size(); k++)
			{
				TurqInventoryGroup gr = (TurqInventoryGroup) groupList.get(k);
				comboInvMainGroup.add(gr.getGroupsName());
				comboInvMainGroup.setData(gr.getGroupsName(), gr);
			}
			tableInvTransactions.setData("table_name", "tableInvTransactions");
			createTableViewer();
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
			if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
				type = EngBLCommon.COMMON_BUY_INT;
			else if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
				type = EngBLCommon.COMMON_SELL_INT;
			boolean searchByInvCode = radioInvCode.getSelection();
			
			HashMap argMap=new HashMap();			

			argMap.put(EngKeys.CURRENT_CARD_START, txtCurCardStart.getData());
			argMap.put(EngKeys.CURRENT_CARD_END,txtCurCardEnd.getData());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.TYPE, new Integer(type));
			argMap.put(InvKeys.INV_MAIN_GROUP,comboInvMainGroup.getData(comboInvMainGroup.getText()));
			argMap.put(InvKeys.INV_SUB_GROUP,comboInvSubGroup.getData(comboInvSubGroup.getText()));
			
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
			List list =(List)EngTXCommon.doTransactionTX(InvBLSearchTransaction.class.getName(),"searchTransactionsAdvanced",argMap);
			TurqInventoryTransaction transactions;
			BigDecimal totalAmountIn = new BigDecimal(0);
			BigDecimal totalAmountOut = new BigDecimal(0);
			BigDecimal totalPriceIn = new BigDecimal(0);
			BigDecimal totalPriceOut = new BigDecimal(0);
			for (int i = 0; i < list.size(); i++)
			{
				Object result[] = (Object[]) list.get(i);
				Integer transId = (Integer) result[0];
				Date transDate = (Date) result[1];
				BigDecimal inAmount = (BigDecimal) result[2];
				BigDecimal outAmount = (BigDecimal) result[3];
				BigDecimal totalPrice = (BigDecimal) result[4];
				String invCode = (String) result[5];
				String invName = (String) result[6];
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
			boolean writeAmounts=false;
			if (list.size()> 0)
			{
				Object[] result = (Object[]) list.get(0);
				String invCode1 = (String) result[5];
				result = (Object[]) list.get(list.size()-1);
				String invCode2 = (String) result[5];
				if ( invCode1.equals(invCode2))
				{
					writeAmounts=true;
				}
			}
			
			tableViewer.addRow(new String[]{"", "", "", "", "", "", "", "", ""}, null);
			if (writeAmounts)
			{
				BigDecimal unitPriceIn=(totalAmountIn.doubleValue()== 0) ? new BigDecimal(0) : totalPriceIn.divide(totalAmountIn,2,EngBLCommon.ROUNDING_METHOD);
				BigDecimal unitPriceOut=(totalAmountOut.doubleValue()== 0) ? new BigDecimal(0) : totalPriceOut.divide(totalAmountOut,2,EngBLCommon.ROUNDING_METHOD);
				tableViewer.addRow(new String[]{"", "", "TOPLAM", cf.format(totalAmountIn), cf.format(totalPriceIn), cf.format(unitPriceIn), cf.format(totalAmountOut), cf.format(totalPriceOut), cf.format(unitPriceOut)}, null);
			}
			else
			{
				tableViewer.addRow(new String[]{"", "", "TOPLAM", "", cf.format(totalPriceIn), "", "", cf.format(totalPriceOut), ""}, null);
			}			
			if (list.size() > 0)
				GenerateJasper(list, type);
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
		TurqInventoryGroup invMainGr = (TurqInventoryGroup) comboInvMainGroup.getData(comboInvMainGroup.getText());
		if (invMainGr != null)
		{
			Iterator it = invMainGr.getTurqInventoryGroups().iterator();
			comboInvSubGroup.add(""); //$NON-NLS-1$
			while (it.hasNext())
			{
				TurqInventoryGroup invGr = (TurqInventoryGroup) it.next();
				comboInvSubGroup.add(invGr.getGroupsName());
				comboInvSubGroup.setData(invGr.getGroupsName(), invGr);
			}
		}
	}
}