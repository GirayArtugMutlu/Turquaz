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
* @author  Onsel Armagan
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
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import com.turquaz.current.ui.comp.CurrentPicker;


import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLSearchTransaction;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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

public class InvUITransactionSearch extends org.eclipse.swt.widgets.Composite
		implements SearchComposite {
	private Composite compInvTransactionSearch;

	private Table tableTransactions;

	private TableColumn tableColumnTotalAmountOut;
	private CLabel lblInvCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnTotalPriceIn;

	private TableColumn tableColumnInventoryCode;
	private InventoryPicker txtInvCard;

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

	public InvUITransactionSearch(org.eclipse.swt.widgets.Composite parent,
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
                composite1LData.heightHint = 98;
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                compInvTransactionSearch.setLayoutData(composite1LData);
                compInvTransactionSearch.setLayout(composite1Layout);
				//START >>  lblInvCard
				lblInvCard = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvCard.setText("Stok Kodu");
				//END <<  lblInvCard
                {
                    txtInvCard = new InventoryPicker(compInvTransactionSearch, SWT.NONE);

                    GridData textWithButton1LData = new GridData();

                    textWithButton1LData.widthHint = 150;
                    textWithButton1LData.heightHint = 17;
                    txtInvCard.setLayoutData(textWithButton1LData);
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
				
					txtCurCardLData.widthHint = 150;
					txtCurCardLData.heightHint = 17;
					txtCurCard.setLayoutData(txtCurCardLData);
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
                    dateStartDateLData.widthHint = 150;
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
                    dateEndDateLData.widthHint = 150;
                    dateEndDateLData.heightHint = 22;
                    dateEndDate.setLayoutData(dateEndDateLData);
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
                    comboTransactionsType.setText(Messages
                        .getString("InvUITransactionSearch.5")); //$NON-NLS-1$
                    comboConsignmentTypeLData.widthHint = 127;
                    comboConsignmentTypeLData.heightHint = 18;
                    comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
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
					tableColumnTransactionDate.setText(Messages.getString("InvUITransactionSearch.6")); //$NON-NLS-1$
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryCode.setText(Messages.getString("InvUITransactionSearch.8")); //$NON-NLS-1$
					tableColumnInventoryCode.setWidth(108);
				}
				{
					tableColumnInventoryName = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryName.setText(Messages.getString("InvUITransactionSearch.19")); //$NON-NLS-1$
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalAmountIn.setText(Messages.getString("InvUITransactionSearch.7"));  //$NON-NLS-1$
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
					tableColumnTotalAmountOut.setText(Messages.getString("InvUITransactionSearch.10"));  //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(Messages.getString("InvUITransactionSearch.11")); //$NON-NLS-1$
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
		try
		{
			
		
			TableItem items[] = tableTransactions.getSelection();
			if (items.length > 0)
			{

				Integer transId = (Integer)items[0].getData();
				if (transId != null)
				{
					TurqInventoryTransaction invTrans=InvBLSearchTransaction.getInvTransByTransId(transId);
			
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
		comboTransactionsType.add(Messages.getString("InvUITransactionSearch.14")); //$NON-NLS-1$
		comboTransactionsType.add(Messages.getString("InvUITransactionSearch.12")); //$NON-NLS-1$
		comboTransactionsType.add(Messages.getString("InvUITransactionSearch.13")); //$NON-NLS-1$
		comboTransactionsType.setText(Messages.getString("InvUITransactionSearch.18")); //$NON-NLS-1$

		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());
		
	}

	public void save() {

	}

	public void search() {

		try {

			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			tableTransactions.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
			{
				type=EngBLCommon.COMMON_BUY_INT;
			}
			else if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
			{
				type = EngBLCommon.COMMON_SELL_INT;
			}

			List list = blSearch.searchTransactions((TurqCurrentCard) txtCurCard
					.getData(),(TurqInventoryCard) txtInvCard.getData(), dateStartDate.getDate(), dateEndDate.getDate(),
					type);
			TurqInventoryTransaction transactions;
			TableItem item;
			for (int i = 0; i < list.size(); i++) {

				Object result[] = (Object[])list.get(i);
				item = new TableItem(tableTransactions, SWT.NULL);


				Integer transId=(Integer)result[0];
				Date transDate = (Date)result[1];
				BigDecimal inAmount=(BigDecimal)result[2];
				BigDecimal outAmount=(BigDecimal)result[3];
				BigDecimal totalPrice=(BigDecimal)result[4];
				String invCode=(String)result[5];
				String invName=(String)result[6];
				
				item.setData(transId);
		
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				
				if(inAmount.doubleValue()==0){
					priceOut = totalPrice;					
					
				}
				else
				{
					priceIn = totalPrice;
				}
				

				item.setText(new String[] {
						DatePicker.formatter.format(transDate),
						invCode,
						invName,
						cf.format(inAmount)+"", //$NON-NLS-1$								
						cf.format(priceIn),
						cf.format(outAmount)+"", //$NON-NLS-1$
						cf.format(priceOut)});

			}

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
	    EngBLUtils.printTable(tableTransactions,Messages.getString("InvUITransactionSearch.15")); //$NON-NLS-1$
	    
	}
}
