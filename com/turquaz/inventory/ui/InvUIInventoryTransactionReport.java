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
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.bill.ui.BillUIBillUpdateDialog;
import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
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
	private Table tableTransactions;
	private TableColumn tableColumnTotalAmountOut;
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
				{
					lblInvCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvCard.setText(Messages.getString("InvUIInventoryTransactionReport.0")); //$NON-NLS-1$
				}
				{
					txtInvCardStart = new InventoryPicker(compInvTransactionSearch, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 150;
					txtInvCardLData.heightHint = 17;
					txtInvCardStart.setLayoutData(txtInvCardLData);
				}
				//START >> lblInvCardEnd
				lblInvCardEnd = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvCardEnd.setText(Messages.getString("InvUIInventoryTransactionReport.1")); //$NON-NLS-1$
				//END << lblInvCardEnd
				//START >> txtInvCardEnd
				txtInvCardEnd = new InventoryPicker(compInvTransactionSearch, SWT.NONE);
				GridData inventoryPicker1LData = new GridData();
				inventoryPicker1LData.widthHint = 150;
				inventoryPicker1LData.heightHint = 17;
				txtInvCardEnd.setLayoutData(inventoryPicker1LData);
				//END << txtInvCardEnd
				{
					lblInvName = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvName.setText(Messages.getString("InvUIInventoryTransactionReport.11")); //$NON-NLS-1$
				}
				{
					txtInvNameStart = new Text(compInvTransactionSearch, SWT.NONE);
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 144;
					txtInvNameLData.heightHint = 17;
					txtInvNameStart.setLayoutData(txtInvNameLData);
				}
				//START >> lblInvNameEnd
				lblInvNameEnd = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvNameEnd.setText(Messages.getString("InvUIInventoryTransactionReport.21")); //$NON-NLS-1$
				//END << lblInvNameEnd
				//START >> txtInvNameEnd
				txtInvNameEnd = new Text(compInvTransactionSearch, SWT.NONE);
				GridData txtInvNameEndLData = new GridData();
				txtInvNameEndLData.widthHint = 144;
				txtInvNameEndLData.heightHint = 17;
				txtInvNameEnd.setLayoutData(txtInvNameEndLData);
				//END << txtInvNameEnd
				{
					lblCurrentCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("InvUIInventoryTransactionReport.2")); //$NON-NLS-1$
				}
				{
					txtCurCardStart = new CurrentCodePicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 150;
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
					txtCurCardEndLData.widthHint = 150;
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
					dateStartDateLData.widthHint = 150;
					dateStartDateLData.heightHint = 22;
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
					dateEndDateLData.widthHint = 150;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblInvGroup = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvGroup.setText("Stok Ana Grup");
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
					comboInvGroupLData.widthHint = 127;
					comboInvGroupLData.heightHint = 18;
					comboInvMainGroup.setLayoutData(comboInvGroupLData);
				}
				//START >> lblInvSubGroup
				lblInvSubGroup = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvSubGroup.setText("Stok Alt Grup");
				//END << lblInvSubGroup
				//START >> comboInvSubGroup
				comboInvSubGroup = new CCombo(compInvTransactionSearch, SWT.NONE);
				GridData comboInvSubGroupLData = new GridData();
				comboInvSubGroupLData.widthHint = 125;
				comboInvSubGroupLData.heightHint = 13;
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
					comboConsignmentTypeLData.widthHint = 127;
					comboConsignmentTypeLData.heightHint = 18;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> tabItemSearch
			tabItemSearch = new CTabItem(tabFolder, SWT.NONE);
			tabItemSearch.setText(Messages.getString("InvUIInventoryTransactionReport.22")); //$NON-NLS-1$
			{
				tableTransactions = new Table(tabFolder, SWT.FULL_SELECTION);
				tabItemSearch.setControl(tableTransactions);
				GridData tableConsignmentsLData = new GridData();
				tableTransactions.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						showConsignment();
					}
				});
				tableTransactions.setHeaderVisible(true);
				tableTransactions.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableTransactions.setLayoutData(tableConsignmentsLData);
				{
					tableColumnTransactionDate = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnTransactionDate.setText(Messages.getString("InvUIInventoryTransactionReport.10")); //$NON-NLS-1$
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnInventoryCode.setText(Messages.getString("InvUIInventoryTransactionReport.23")); //$NON-NLS-1$
					tableColumnInventoryCode.setWidth(109);
				}
				{
					tableColumnInventoryName = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnInventoryName.setText(Messages.getString("InvUIInventoryTransactionReport.24")); //$NON-NLS-1$
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalAmountIn.setText(Messages.getString("InvUIInventoryTransactionReport.12")); //$NON-NLS-1$
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceIn.setText(Messages.getString("InvUIInventoryTransactionReport.14")); //$NON-NLS-1$
					tableColumnTotalPriceIn.setWidth(100);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIInventoryTransactionReport.13")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(Messages.getString("InvUIInventoryTransactionReport.16")); //$NON-NLS-1$
					tableColumnTotalPriceOut.setWidth(100);
				}
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
			e.printStackTrace();
		}
	}

	public void GenerateJasper(List list, Map parameters, boolean useGroup)
	{
		try
		{
			String[] fields;
			if (useGroup)
			{
				fields = new String[]{"inventory_transactions_id", "transactions_date", "transactions_amount_in",
						"transactions_total_amount_out", "transactions_total_price", "card_inventory_code", "card_name",
						"cards_name", "inventory_cards_id", "bill_document_no", "groups_name", "inventory_groups_id"};
			}
			else
			{
				fields = new String[]{"inventory_transactions_id", "transactions_date", "transactions_amount_in",
						"transactions_total_amount_out", "transactions_total_price", "card_inventory_code", "card_name",
						"cards_name", "inventory_cards_id", "bill_document_no",};
			}
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport;
			if (useGroup)
				jasperReport = (JasperReport) JRLoader.loadObject("reports/inventory/InventoryTransactionReportByGroup.jasper"); //$NON-NLS-1$
			else
				jasperReport = (JasperReport) JRLoader.loadObject("reports/inventory/InventoryTransactionReport.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
					parameters.put("invSubGroup", " Hepsi");
				}
			}
			else
			{
				parameters.put("invMainGroup", " Hepsi");
				parameters.put("invSubGroup", " Hepsi");
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
			GenerateJasper(list, parameters, (invMainGroup != null));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void showConsignment()
	{
		try
		{
			TableItem items[] = tableTransactions.getSelection();
			if (items.length > 0)
			{
				Integer transId = (Integer) items[0].getData();
				if (transId != null)
				{
					boolean updated = false;
					TurqInventoryTransaction invTrans = InvBLSearchTransaction.getInvTransByTransId(transId);
					TurqEngineSequence seq = invTrans.getTurqEngineSequence();
					TurqBill bill = InvBLSearchTransaction.getBill(seq);
					if (bill != null)
					{
						updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, bill).open();
					}
					else
					{
						TurqConsignment cons = InvBLSearchTransaction.getConsignment(seq);
						updated = new ConUIConsignmentUpdateDialog(this.getShell(), SWT.NULL, cons).open();
					}
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void postInitGui()
	{
		try
		{
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.17")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.18")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.19")); //$NON-NLS-1$
			comboTransactionsType.setText(Messages.getString("InvUIInventoryTransactionReport.20")); //$NON-NLS-1$
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			dateStartDate.setDate(cal.getTime());
			List groupList = InvBLCardAdd.getParentInventoryGroups();
			comboInvMainGroup.add("");
			for (int k = 0; k < groupList.size(); k++)
			{
				TurqInventoryGroup gr = (TurqInventoryGroup) groupList.get(k);
				comboInvMainGroup.add(gr.getGroupsName());
				comboInvMainGroup.setData(gr.getGroupsName(), gr);
			}
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	/*
	 * public void currentCardChoose() { Object data = new CurUICurrentCardSearchDialog(this.getShell(), SWT.NULL).open(); if (data !=
	 * null) { TurqCurrentCard curCard = (TurqCurrentCard) data; txtCurrentCard.setText(curCard.getCardsCurrentCode() + " - " //$NON-NLS-1$ +
	 * curCard.getCardsName()); txtCurrentCard.setData(curCard); } }
	 */
	/*
	 * public void inventoryCardChoose() { Object data = new InvUICardSearchDialog(this.getShell(), SWT.NULL).open(); if (data != null) {
	 * TurqInventoryCard invCard = (TurqInventoryCard) data; txtInvCardStart.setText(invCard.getCardInventoryCode() + " - " //$NON-NLS-1$ +
	 * invCard.getCardName()); txtInvCardStart.setData(invCard); } }
	 */
	public void save()
	{
	}

	public void search()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableTransactions.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
				type = EngBLCommon.COMMON_BUY_INT;
			else if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
				type = EngBLCommon.COMMON_SELL_INT;
			List list = InvBLSearchTransaction.searchTransactionsAdvanced(txtInvCardStart.getText().trim(), txtInvCardEnd.getText()
					.trim(), txtInvNameStart.getText().trim(), txtInvNameEnd.getText().trim(), (TurqCurrentCard) txtCurCardStart
					.getData(), (TurqCurrentCard) txtCurCardEnd.getData(), dateStartDate.getDate(), dateEndDate.getDate(), type,
					(TurqInventoryGroup) comboInvMainGroup.getData(comboInvMainGroup.getText()), (TurqInventoryGroup) comboInvSubGroup
							.getData(comboInvSubGroup.getText()));
			TurqInventoryTransaction transactions;
			TableItem item;
			BigDecimal totalAmountIn = new BigDecimal(0);
			BigDecimal totalAmountOut = new BigDecimal(0);
			BigDecimal totalPriceIn = new BigDecimal(0);
			BigDecimal totalPriceOut = new BigDecimal(0);
			for (int i = 0; i < list.size(); i++)
			{
				Object result[] = (Object[]) list.get(i);
				item = new TableItem(tableTransactions, SWT.NULL);
				Integer transId = (Integer) result[0];
				Date transDate = (Date) result[1];
				BigDecimal inAmount = (BigDecimal) result[2];
				BigDecimal outAmount = (BigDecimal) result[3];
				BigDecimal totalPrice = (BigDecimal) result[4];
				String invCode = (String) result[5];
				String invName = (String) result[6];
				item.setData(transId);
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				if (inAmount.doubleValue() == 0)
				{
					priceOut = totalPrice;
					totalPriceOut = totalPriceOut.add(totalPrice);
				}
				else
				{
					priceIn = totalPrice;
					totalPriceIn = totalPriceIn.add(totalPrice);
				}
				totalAmountIn = totalAmountIn.add(inAmount);
				totalAmountOut = totalAmountOut.add(outAmount);
				item.setText(new String[]{DatePicker.formatter.format(transDate), invCode, invName, cf.format(inAmount) + "", //$NON-NLS-1$								
						cf.format(priceIn), cf.format(outAmount) + "", //$NON-NLS-1$
						cf.format(priceOut)});
			}
			item = new TableItem(tableTransactions, SWT.NULL);
			item = new TableItem(tableTransactions, SWT.NULL);
			item.setText(new String[]{"", "", "TOPLAM", cf.format(totalAmountIn), cf.format(totalPriceIn), cf.format(totalAmountOut),
					cf.format(totalPriceOut)});
			if (list.size() > 0)
				GenerateJasper(list, type);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void newForm()
	{
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableTransactions);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableTransactions, ""); //$NON-NLS-1$
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
			comboInvSubGroup.add("");
			while (it.hasNext())
			{
				TurqInventoryGroup invGr = (TurqInventoryGroup) it.next();
				comboInvSubGroup.add(invGr.getGroupsName());
				comboInvSubGroup.setData(invGr.getGroupsName(), invGr);
			}
		}
	}
}