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
import java.util.List;



import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;


import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;


import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLSearchTransaction;
import com.turquaz.inventory.dal.InvDALCardAdd;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Text;
import com.turquaz.current.ui.comp.CurrentCodePicker;
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

public class InvUIInventoryTransactionReport extends org.eclipse.swt.widgets.Composite
		implements SearchComposite {
	private Composite compInvTransactionSearch;

	private Table tableTransactions;

	private TableColumn tableColumnTotalAmountOut;
	private Text txtInvNameEnd;
	private CLabel lblInvNameEnd;
	private InventoryPicker inventoryPicker1;
	private CLabel txtInvCardEnd;
	private TableColumn tableColumnInventoryName;
	private Text txtInvNameStart;
	private CLabel lblInvName;
	private CCombo comboInvGroup;
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
	private Calendar cal=Calendar.getInstance();
	private InvDALCardAdd invCardAdd=new InvDALCardAdd();

	public InvUIInventoryTransactionReport(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(612, 357);
			{
				compInvTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 155;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				compInvTransactionSearch.setLayoutData(composite1LData);
				compInvTransactionSearch.setLayout(composite1Layout);
				{
					lblInvCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvCard.setText("Stok Kart? - Ba?lang?ç");
				}
				{
					txtInvCardStart = new InventoryPicker(compInvTransactionSearch, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 150;
					txtInvCardLData.heightHint = 17;
					txtInvCardStart.setLayoutData(txtInvCardLData);
				}
				//START >>  txtInvCardEnd
				txtInvCardEnd = new CLabel(compInvTransactionSearch, SWT.NONE);
				txtInvCardEnd.setText("Stok Kart\u0131 -  Biti\u015f");
				//END <<  txtInvCardEnd
				//START >>  inventoryPicker1
				inventoryPicker1 = new InventoryPicker(
					compInvTransactionSearch,
					SWT.NONE);
				GridData inventoryPicker1LData = new GridData();
				inventoryPicker1LData.widthHint = 150;
				inventoryPicker1LData.heightHint = 17;
				inventoryPicker1.setLayoutData(inventoryPicker1LData);
				//END <<  inventoryPicker1
				{
					lblInvName = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvName.setText("Stok Cinsi - Ba?lang?ç");
				}
				{
					txtInvNameStart = new Text(compInvTransactionSearch, SWT.NONE);
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 144;
					txtInvNameLData.heightHint = 17;
					txtInvNameStart.setLayoutData(txtInvNameLData);
				}
				//START >>  lblInvNameEnd
				lblInvNameEnd = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvNameEnd.setText("Stok Cinsi - Biti\u015f");
				//END <<  lblInvNameEnd
				//START >>  txtInvNameEnd
				txtInvNameEnd = new Text(compInvTransactionSearch, SWT.NONE);
				GridData txtInvNameEndLData = new GridData();
				txtInvNameEndLData.widthHint = 144;
				txtInvNameEndLData.heightHint = 17;
				txtInvNameEnd.setLayoutData(txtInvNameEndLData);
				//END <<  txtInvNameEnd
				{
					lblCurrentCard = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
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
					lblCurCarEnd = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
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
					lblStartDate = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
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
					dateEndDate = new DatePicker(
						compInvTransactionSearch,
						SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 150;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblType.setText(Messages.getString("InvUIInventoryTransactionReport.6")); //$NON-NLS-1$
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
					comboTransactionsType.setText(Messages.getString("InvUIInventoryTransactionReport.7")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 127;
					comboConsignmentTypeLData.heightHint = 18;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
				{
					lblInvGroup = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvGroup.setText(Messages.getString("InvUIInventoryTransactionReport.8")); //$NON-NLS-1$
				}
				{
					comboInvGroup = new CCombo(
						compInvTransactionSearch,
						SWT.NONE);
					comboInvGroup.setText(Messages.getString("InvUIInventoryTransactionReport.9")); //$NON-NLS-1$
					GridData comboInvGroupLData = new GridData();
					comboInvGroupLData.widthHint = 127;
					comboInvGroupLData.heightHint = 18;
					comboInvGroup.setLayoutData(comboInvGroupLData);
				}
			}
			{
				tableTransactions = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
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
							tableTransactions, SWT.NONE);
					tableColumnTransactionDate.setText(Messages.getString("InvUIInventoryTransactionReport.10")); //$NON-NLS-1$
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryCode.setText("Stok Kodu");
					tableColumnInventoryCode.setWidth(109);
				}
				{
					tableColumnInventoryName = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryName.setText("Stok Cinsi");
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalAmountIn.setText(Messages.getString("InvUIInventoryTransactionReport.12")); //$NON-NLS-1$
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalPriceIn.setText(Messages
						.getString("InvUIInventoryTransactionReport.14")); //$NON-NLS-1$
					tableColumnTotalPriceIn.setWidth(100);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIInventoryTransactionReport.13")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(Messages.getString("InvUIInventoryTransactionReport.16")); //$NON-NLS-1$
					tableColumnTotalPriceOut.setWidth(100);
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
			if (invTrans != null)
			{
				TurqEngineSequence seq = invTrans.getTurqEngineSequence();
			
				TurqConsignment cons = blSearch.getConsignment(seq);
				boolean updated=new ConUIConsignmentUpdateDialog(this.getShell(),SWT.NULL,cons).open();
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
	public void postInitGui() {
		try
		{
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.17")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.18")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.19")); //$NON-NLS-1$
			comboTransactionsType.setText(Messages.getString("InvUIInventoryTransactionReport.20")); //$NON-NLS-1$
			cal.set(cal.get(Calendar.YEAR),0,1);
			dateStartDate.setDate(cal.getTime());
		
			List groupList=InvBLCardAdd.getInventoryGroups();
			for(int k=0; k<groupList.size(); k++)
			{
				TurqInventoryGroup gr=(TurqInventoryGroup)groupList.get(k);
				comboInvGroup.add(gr.getGroupsName());
				comboInvGroup.setData(gr.getGroupsName(),gr);
			}
			comboInvGroup.setText(Messages.getString("InvUIInventoryTransactionReport.15")); //$NON-NLS-1$
		}
		catch (Exception ex)
		{
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
	}
/*
	public void currentCardChoose() {
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			TurqCurrentCard curCard = (TurqCurrentCard) data;
			txtCurrentCard.setText(curCard.getCardsCurrentCode() + " - " //$NON-NLS-1$
					+ curCard.getCardsName());
			txtCurrentCard.setData(curCard);

		}

	} */
	/*
	public void inventoryCardChoose() {
		Object data = new InvUICardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			TurqInventoryCard invCard = (TurqInventoryCard) data;
			txtInvCardStart.setText(invCard.getCardInventoryCode() + " - " //$NON-NLS-1$
					+ invCard.getCardName());
			txtInvCardStart.setData(invCard);

		}
	}
   */
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


			List list = blSearch.searchTransactionsAdvanced(txtInvCardStart.getText().trim(),
					txtInvCardEnd.getText().trim(),txtInvNameStart.getText().trim(),
					txtInvNameEnd.getText().trim(),(TurqCurrentCard)txtCurCardStart.getData(),
					(TurqCurrentCard)txtCurCardEnd.getData(),dateStartDate.getDate(),
					dateEndDate.getDate(),type,
					(TurqInventoryGroup)comboInvGroup.getData(comboInvGroup.getText()));
			TurqInventoryTransaction transactions;
			TableItem item;
			
			BigDecimal totalAmountIn=new BigDecimal(0);
			BigDecimal totalAmountOut=new BigDecimal(0);
			BigDecimal totalPriceIn=new BigDecimal(0);
			BigDecimal totalPriceOut=new BigDecimal(0);
			
			for (int i = 0; i < list.size(); i++) {

				Object result[] = (Object[])list.get(i);
				transactions = (TurqInventoryTransaction) result[0];
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(transactions);
	
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				
				
				if(transactions.getTransactionsAmountIn().doubleValue()==0){
					priceOut = transactions.getTransactionsTotalPrice();	
					totalPriceOut=totalPriceOut.add(transactions.getTransactionsTotalPrice());
					
				}
				else
				{
					priceIn = transactions.getTransactionsTotalPrice();
					totalPriceIn=totalPriceIn.add(transactions.getTransactionsTotalPrice());
				}
				totalAmountIn=totalAmountIn.add(transactions.getTransactionsAmountIn());
				totalAmountOut=totalAmountOut.add(transactions.getTransactionsTotalAmountOut());
				
				
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
			
			item=new TableItem(tableTransactions,SWT.NULL);
			item=new TableItem(tableTransactions,SWT.NULL);
			item.setText(new String[]{"","",Messages.getString("InvUIInventoryTransactionReport.24"),cf.format(totalAmountIn), //$NON-NLS-1$ //$NON-NLS-2$
					cf.format(totalPriceIn),cf.format(totalAmountOut),
					cf.format(totalPriceOut)});

		} catch (Exception ex) {
			ex.printStackTrace();
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
	    EngBLUtils.printTable(tableTransactions,""); //$NON-NLS-1$
	    
	}

}

