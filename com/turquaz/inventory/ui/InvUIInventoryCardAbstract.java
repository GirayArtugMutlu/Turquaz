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
import java.util.List;
import java.util.Map;



import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import com.turquaz.current.ui.comp.CurrentPicker;



import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLSearchTransaction;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import com.jasperassistant.designer.viewer.ViewerComposite;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for anycorporate or commercial purpose.
 * *************************************
 */

public class InvUIInventoryCardAbstract extends org.eclipse.swt.widgets.Composite
		implements SearchComposite {
	private Composite compInvTransactionSearch;

	private Table tableTransactions;

	private TableColumn tableColumnTotalAmountOut;
	private TableColumn tableColumnInventoryName;
	private ViewerComposite viewer;
	private CTabItem tabItemTable;
	private CTabItem tabItemReport;
	private CTabFolder tabFolderReport;
	private InventoryPicker txtInvCardEnd;
	private CLabel lblInvCardEnd;
	private TableColumn tableColumnTotalPriceIn;

	private TableColumn tableColumnInventoryCode;
	private InventoryPicker txtInvCardStart;
	private Label lblInvCard;

	private CCombo comboTransactionsType;
	private CurrentPicker txtCurCard;

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
	private Calendar cal=Calendar.getInstance();

	public InvUIInventoryCardAbstract(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(591, 344);
            {
                compInvTransactionSearch = new Composite(this, SWT.NONE);
                GridLayout composite1Layout = new GridLayout();
                composite1Layout.numColumns = 4;
                GridData composite1LData = new GridData();
                composite1LData.heightHint = 94;
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                compInvTransactionSearch.setLayoutData(composite1LData);
                compInvTransactionSearch.setLayout(composite1Layout);
                {
                    lblInvCard = new Label(compInvTransactionSearch, SWT.NONE);
                    lblInvCard.setText(Messages.getString("InvUIInventoryCardAbstract.0")); //$NON-NLS-1$
                        GridData lblInvCardLData = new GridData();
                        lblInvCardLData.widthHint = 126;
                        lblInvCardLData.heightHint = 15;
                        lblInvCard.setLayoutData(lblInvCardLData);
                }
                {
                    txtInvCardStart = new InventoryPicker(compInvTransactionSearch, SWT.NONE);

                    GridData textWithButton1LData = new GridData();

                    textWithButton1LData.widthHint = 140;
                    textWithButton1LData.heightHint = 17;
                    txtInvCardStart.setLayoutData(textWithButton1LData);
                }
				{
					lblInvCardEnd = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
					lblInvCardEnd.setText(Messages.getString("InvUIInventoryCardAbstract.1")); //$NON-NLS-1$
				}
				{
					txtInvCardEnd = new InventoryPicker(
						compInvTransactionSearch,
						SWT.NONE);
					GridData txtInvCardEndLData = new GridData();
					txtInvCardEndLData.widthHint = 140;
					txtInvCardEndLData.heightHint = 17;
					txtInvCardEnd.setLayoutData(txtInvCardEndLData);
				}
                {
                    lblCurrentCard = new CLabel(
                        compInvTransactionSearch,
                        SWT.NONE);
                    lblCurrentCard.setText(Messages
                        .getString("InvUITransactionSearch.1")); //$NON-NLS-1$

                }
				{
					txtCurCard = new CurrentPicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardLData = new GridData();
				
					txtCurCardLData.widthHint = 140;
					txtCurCardLData.heightHint = 17;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblType = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblType.setText(Messages
						.getString("InvUITransactionSearch.4")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboTransactionsType = new CCombo(
						compInvTransactionSearch,
						SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentTypeLData.widthHint = 116;
					comboConsignmentTypeLData.heightHint = 17;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
                {
                    lblStartDate = new CLabel(
                        compInvTransactionSearch,
                        SWT.NONE);
                    lblStartDate.setText(Messages
                        .getString("InvUITransactionSearch.2")); //$NON-NLS-1$
                    GridData lblStartDateLData = new GridData();
                    lblStartDateLData.widthHint = 109;
                    lblStartDateLData.heightHint = 17;
                    lblStartDate.setLayoutData(lblStartDateLData);
                }
                {
                    dateStartDate = new DatePicker(
                        compInvTransactionSearch,
                        SWT.NONE);
                    GridData dateStartDateLData = new GridData();
                    dateStartDateLData.widthHint = 141;
                    dateStartDateLData.heightHint = 22;
                    dateStartDate.setLayoutData(dateStartDateLData);
                }
                {
                    lblEndDate = new CLabel(compInvTransactionSearch, SWT.NONE);
                    lblEndDate.setText(Messages
                        .getString("InvUITransactionSearch.3")); //$NON-NLS-1$
                    GridData lblEndDateLData = new GridData();
                    lblEndDateLData.widthHint = 105;
                    lblEndDateLData.heightHint = 19;
                    lblEndDate.setLayoutData(lblEndDateLData);
                }
                {
                    dateEndDate = new DatePicker(
                        compInvTransactionSearch,
                        SWT.NONE);
                    GridData dateEndDateLData = new GridData();
                    dateEndDateLData.widthHint = 140;
                    dateEndDateLData.heightHint = 22;
                    dateEndDate.setLayoutData(dateEndDateLData);
                }
            }
			{
				tabFolderReport = new CTabFolder(this, SWT.NONE);
				
				tabFolderReport.setSize(56, 25);
				GridData tabFolderReportLData = new GridData();
				tabFolderReportLData.grabExcessVerticalSpace = true;
				tabFolderReportLData.grabExcessHorizontalSpace = true;
				tabFolderReportLData.horizontalAlignment = GridData.FILL;
				tabFolderReportLData.verticalAlignment = GridData.FILL;
				tabFolderReport.setLayoutData(tabFolderReportLData);
				{
					tabItemTable = new CTabItem(tabFolderReport, SWT.NONE);
					tabItemTable.setText(Messages.getString("InvUIInventoryCardAbstract.2")); //$NON-NLS-1$
					{
						tableTransactions = new Table(
							tabFolderReport,
							SWT.FULL_SELECTION);
						tabItemTable.setControl(tableTransactions);
						GridData tableConsignmentsLData = new GridData();
						tabFolderReport.setSelection(tabItemTable);
						tableTransactions.addMouseListener(new MouseAdapter() {
							public void mouseDoubleClick(MouseEvent evt) {
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
							tableColumnTransactionDate = new TableColumn(
								tableTransactions,
								SWT.NONE);
							tableColumnTransactionDate.setText(Messages
								.getString("InvUITransactionSearch.6")); //$NON-NLS-1$
							tableColumnTransactionDate.setWidth(88);
						}
						{
							tableColumnInventoryCode = new TableColumn(
								tableTransactions,
								SWT.NONE);
							tableColumnInventoryCode.setText(Messages
								.getString("InvUITransactionSearch.8")); //$NON-NLS-1$
							tableColumnInventoryCode.setWidth(108);
						}
						//START >>  tableColumnInventoryName
						tableColumnInventoryName = new TableColumn(
							tableTransactions,
							SWT.NONE);
						tableColumnInventoryName.setText(Messages.getString("InvUIInventoryCardAbstract.3")); //$NON-NLS-1$
						tableColumnInventoryName.setWidth(100);
						//END <<  tableColumnInventoryName
						{
							tableColumnTotalAmountIn = new TableColumn(
								tableTransactions,
								SWT.RIGHT);
							tableColumnTotalAmountIn.setText(Messages
								.getString("InvUITransactionSearch.7")); //$NON-NLS-1$
							tableColumnTotalAmountIn.setWidth(100);
						}
						{
							tableColumnTotalPriceIn = new TableColumn(
								tableTransactions,
								SWT.RIGHT);
							tableColumnTotalPriceIn.setText(Messages
								.getString("InvUITransactionSearch.9")); //$NON-NLS-1$
							tableColumnTotalPriceIn.setWidth(100);
						}
						{
							tableColumnTotalAmountOut = new TableColumn(
								tableTransactions,
								SWT.RIGHT);
							tableColumnTotalAmountOut.setText(Messages
								.getString("InvUITransactionSearch.10")); //$NON-NLS-1$
							tableColumnTotalAmountOut.setWidth(100);
						}
						{
							tableColumnTotalPriceOut = new TableColumn(
								tableTransactions,
								SWT.RIGHT);
							tableColumnTotalPriceOut.setText(Messages
								.getString("InvUITransactionSearch.11")); //$NON-NLS-1$
							tableColumnTotalPriceOut.setWidth(100);
						}
					}
				}
				{
					tabItemReport = new CTabItem(tabFolderReport, SWT.NONE);
					tabItemReport.setText(Messages.getString("InvUIInventoryCardAbstract.4")); //$NON-NLS-1$
					{
						viewer = new ViewerComposite(tabFolderReport, SWT.NONE);
						tabItemReport.setControl(viewer);
					}
				}
			}
			postInitGui();
			this.layout();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showConsignment()
	{
		try{
			
		
		TableItem items[] = tableTransactions.getSelection();
		if (items.length > 0)
		{
			TurqInventoryTransaction invTrans = (TurqInventoryTransaction)items[0].getData();
			TurqEngineSequence seq = invTrans.getTurqEngineSequence();
			
			TurqConsignment cons = blSearch.getConsignment(seq);
			boolean updated=new ConUIConsignmentUpdateDialog(this.getShell(),SWT.NULL,cons).open();
			if (updated)
				search();
		}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	public void postInitGui() {
		comboTransactionsType.add(EngBLCommon.COMMON_ALL_STRING);
		comboTransactionsType.add(EngBLCommon.COMMON_BUY_STRING);
		comboTransactionsType.add(EngBLCommon.COMMON_SELL_STRING);
		
		comboTransactionsType.setText(EngBLCommon.COMMON_ALL_STRING);

		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());
		
	}

	public void save() {

	}

	public void search() {

		try {

			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableTransactions.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
				type=EngBLCommon.COMMON_BUY_INT;
			else if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
				type = EngBLCommon.COMMON_SELL_INT;

			List list = blSearch.searchTransactionsRange((TurqInventoryCard) txtInvCardStart.getData(),
					(TurqInventoryCard) txtInvCardEnd.getData(),
					(TurqCurrentCard) txtCurCard.getData(),dateStartDate.getDate(), dateEndDate.getDate(),
					type);
			TurqInventoryTransaction transactions;
			TableItem item;
			for (int i = 0; i < list.size(); i++) {

				Object result[] = (Object[])list.get(i);
				transactions = (TurqInventoryTransaction) result[0];
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(transactions);
		
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				
				if(transactions.getTransactionsAmountIn().doubleValue()==0){
					priceOut = transactions.getTransactionsTotalPrice();					
					
				}
				else
				{
					priceIn = transactions.getTransactionsTotalPrice();
				}
				
				
				
				Date transDate = (Date)result[1];
				item.setText(new String[] {
								DatePicker.formatter.format(transDate),
								transactions.getTurqInventoryCard().getCardInventoryCode(),
								transactions.getTurqInventoryCard().getCardName(),
								cf.format(transactions.getTransactionsAmountIn())+"", //$NON-NLS-1$
								cf.format(priceIn),
								cf.format(transactions.getTransactionsTotalAmountOut())+"", //$NON-NLS-1$								
								cf.format(priceOut)});
			}
			GenerateJasper(type);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
}
	private void GenerateJasper(int type)
	{
		try
		{
			Map parameters = new HashMap();		
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");  //$NON-NLS-1$
			String sqlparam="Select trans.inventory_transactions_id,trans.transactions_amount_in," + //$NON-NLS-1$
					"trans.transactions_total_amount_out, trans.transactions_total_price," + //$NON-NLS-1$
					"invCard.card_inventory_code, invCard.card_name,curCard.cards_name," + //$NON-NLS-1$
					"trans.inventory_cards_id, trans.transactions_date,billcons.bill_document_no" + //$NON-NLS-1$
					" from turq_inventory_transactions trans," + //$NON-NLS-1$
					"turq_consignments cons, turq_bill_consignment_commons billcons," + //$NON-NLS-1$
					"turq_current_cards curCard, turq_inventory_cards invCard" + //$NON-NLS-1$
					" where trans.engine_sequences_id=cons.engine_sequences_id" + //$NON-NLS-1$
					" and cons.bill_consignment_common_id=billcons.bill_consignment_common_id" + //$NON-NLS-1$
					" and billcons.current_cards_id=curCard.current_cards_id" + //$NON-NLS-1$
					" and trans.inventory_cards_id=invCard.inventory_cards_id" + //$NON-NLS-1$
					" and trans.transactions_date >= '"+dformat.format(dateStartDate.getDate())+"'" + //$NON-NLS-1$ //$NON-NLS-2$
					" and trans.transactions_date <= '"+dformat.format(dateEndDate.getDate())+"'"; //$NON-NLS-1$ //$NON-NLS-2$
			
			
			if (type != EngBLCommon.COMMON_ALL_INT)
				sqlparam+=" and cons.consignments_type ="+ type; //$NON-NLS-1$
		
			TurqCurrentCard curCard=(TurqCurrentCard)txtCurCard.getData();
			if (curCard != null) {
				sqlparam += " and curCard.current_cards_id="+curCard.getCurrentCardsId(); //$NON-NLS-1$
			}
		
			TurqInventoryCard invCardStart=(TurqInventoryCard) txtInvCardStart.getData();
			TurqInventoryCard invCardEnd=(TurqInventoryCard)txtInvCardEnd.getData();
			if (invCardStart != null && invCardEnd != null) {
				sqlparam += " and invCard.card_inventory_code >= '"+invCardStart.getCardInventoryCode()+"'"; //$NON-NLS-1$ //$NON-NLS-2$
				sqlparam += " and invCard.card_inventory_code <= '"+invCardEnd.getCardInventoryCode()+"'"; //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("invCardStart",invCardStart.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd",invCardEnd.getCardInventoryCode()); //$NON-NLS-1$
			}
			else if (invCardStart != null)
			{
				sqlparam += " and invCard.inventory_cards_id ="+invCardStart.getInventoryCardsId(); //$NON-NLS-1$
				parameters.put("invCardStart",invCardStart.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd",""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (invCardEnd !=null)
			{
				sqlparam += " and invCard.inventory_cards_id ="+invCardEnd.getInventoryCardsId(); //$NON-NLS-1$
				parameters.put("invCardStart",invCardEnd.getCardInventoryCode()); //$NON-NLS-1$
				parameters.put("invCardEnd",""); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else
			{
				parameters.put("invCardStart",""); //$NON-NLS-1$ //$NON-NLS-2$
				parameters.put("invCardEnd",""); //$NON-NLS-1$ //$NON-NLS-2$
			}

			sqlparam +=" order by invCard.inventory_cards_id,trans.transactions_date"; //$NON-NLS-1$
			SimpleDateFormat dformat2=new SimpleDateFormat("dd/MM/yyyy");  //$NON-NLS-1$
			parameters.put("sqlparam",sqlparam);  //$NON-NLS-1$
			parameters.put("startDate",dformat2.format(dateStartDate.getDate()));  //$NON-NLS-1$
			parameters.put("endDate",dformat2.format(dateEndDate.getDate())); 			  //$NON-NLS-1$
			parameters.put("dateformat",dformat2);  //$NON-NLS-1$
			parameters.put("curCard",(curCard!=null)?curCard.getCardsCurrentCode():""); //$NON-NLS-1$ //$NON-NLS-2$
			parameters.put("formatter", new TurkishCurrencyFormat(2)); //$NON-NLS-1$
			parameters.put("currentDate",dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			List balances = blSearch.searchTransactionsRange(invCardStart,invCardEnd,					
					curCard,dateStartDate.getDate(), dateEndDate.getDate(),
				type);

			EngDALConnection db=new EngDALConnection();
			db.connect();
	
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/inventory/InventoryCardAbstract.jasper");   //$NON-NLS-1$
			final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());	
		
			viewer.getReportViewer().setDocument(jasperPrint);	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
	}

	

	public void newForm() {

	}

	public void delete() {

	}

	public void exportToExcel() {

		EngBLUtils.Export2Excel(tableTransactions);

	}
	public void printTable(){
	    EngBLUtils.printTable(tableTransactions,Messages.getString("InvUITransactionSearch.15")); //$NON-NLS-1$
	    
	}
}
