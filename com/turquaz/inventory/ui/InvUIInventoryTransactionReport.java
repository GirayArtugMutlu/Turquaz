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


import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurquazDecimalFormat;


import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.inventory.Messages;
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
	private Text txtInvName;
	private CLabel lblInvName;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
	private CurrentCodePicker txtCurCardEnd;
	private CLabel lblCurCarEnd;
	private CLabel lblInvCard;
	private Text txtInvCard;
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
				composite1LData.heightHint = 126;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				compInvTransactionSearch.setLayoutData(composite1LData);
				compInvTransactionSearch.setLayout(composite1Layout);
				{
					lblInvCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvCard.setText(Messages.getString("InvUIInventoryTransactionReport.0")); //$NON-NLS-1$
				}
				{
					txtInvCard = new Text(compInvTransactionSearch, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 156;
					txtInvCardLData.heightHint = 17;
					txtInvCard.setLayoutData(txtInvCardLData);
				}
				{
					lblInvName = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblInvName.setText(Messages.getString("InvUIInventoryTransactionReport.1")); //$NON-NLS-1$
				}
				{
					txtInvName = new Text(compInvTransactionSearch, SWT.NONE);
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 164;
					txtInvNameLData.heightHint = 15;
					txtInvName.setLayoutData(txtInvNameLData);
				}
				{
					lblCurrentCard = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
					lblCurrentCard.setText(Messages.getString("InvUIInventoryTransactionReport.2")); //$NON-NLS-1$
				}
				{
					txtCurCardStart = new CurrentCodePicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardLData = new GridData();

					txtCurCardLData.widthHint = 162;
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
					txtCurCardEndLData.widthHint = 171;
					txtCurCardEndLData.heightHint = 16;
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
					dateEndDateLData.widthHint = 140;
					dateEndDateLData.heightHint = 22;
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
					comboConsignmentTypeLData.widthHint = 82;
					comboConsignmentTypeLData.heightHint = 14;
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
					comboInvGroupLData.widthHint = 82;
					comboInvGroupLData.heightHint = 16;
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
					tableColumnInventoryCode.setText(Messages.getString("InvUIInventoryTransactionReport.11")); //$NON-NLS-1$
					tableColumnInventoryCode.setWidth(108);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalAmountIn.setText(Messages.getString("InvUIInventoryTransactionReport.12")); //$NON-NLS-1$
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(
						tableTransactions,
						SWT.RIGHT);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIInventoryTransactionReport.13")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceIn.setText(Messages.getString("InvUIInventoryTransactionReport.14")); //$NON-NLS-1$
					tableColumnTotalPriceIn.setWidth(100);
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
		try
		{
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.17")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.18")); //$NON-NLS-1$
			comboTransactionsType.add(Messages.getString("InvUIInventoryTransactionReport.19")); //$NON-NLS-1$
			comboTransactionsType.setText(Messages.getString("InvUIInventoryTransactionReport.20")); //$NON-NLS-1$
			cal.set(cal.get(Calendar.YEAR),0,1);
			dateStartDate.setDate(cal.getTime());
		
			List groupList=invCardAdd.getInventoryGroups();
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
			txtInvCard.setText(invCard.getCardInventoryCode() + " - " //$NON-NLS-1$
					+ invCard.getCardName());
			txtInvCard.setData(invCard);

		}
	}
   */
	public void save() {

	}

	public void search() {

		try {

			TurquazDecimalFormat df = new TurquazDecimalFormat();
			tableTransactions.removeAll();
			int type = 0;
			if (comboTransactionsType.getText().equals(Messages.getString("InvUIInventoryTransactionReport.21"))) //$NON-NLS-1$
				type=2;
			else if (comboTransactionsType.getText().equals(Messages.getString("InvUIInventoryTransactionReport.22"))) //$NON-NLS-1$
				type = 1;


			List list = blSearch.searchTransactionsAdvanced(txtInvCard.getText(),
					txtInvName.getText(),(TurqCurrentCard)txtCurCardStart.getData(),
					(TurqCurrentCard)txtCurCardEnd.getData(),dateStartDate.getDate(),
					dateEndDate.getDate(),type,
					(TurqInventoryGroup)comboInvGroup.getData(comboInvGroup.getText()));
			TurqInventoryTransaction transactions;
			TableItem item;
			for (int i = 0; i < list.size(); i++) {

				Object result[] = (Object[])list.get(i);
				transactions = (TurqInventoryTransaction) result[0];
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(transactions);
			/*
				Iterator it = transactions.getTurqEngineSequence().getTurqConsignments().iterator();
			
				TurqConsignment cons = null;
				
				if(it.hasNext()){
					cons = (TurqConsignment)it.next();
					
				}
				else{
					throw new Exception(Messages.getString("InvUIInventoryTransactionReport.17")); //$NON-NLS-1$
				}
				
		    */		
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				
				if(transactions.getTransactionsAmountIn()==0){
					priceOut = transactions.getTransactionsTotalPrice();
					
					
				}
				else
				{
					priceIn = transactions.getTransactionsTotalPrice();
				}
				
				
				
				Date transDate = (Date)result[1];
				item.setText(new String[] {
								DatePicker.formatter.format(transDate),
								transactions.getTurqInventoryCard().getCardName(),
								transactions.getTransactionsAmountIn()+"", //$NON-NLS-1$
								transactions.getTransactionsTotalAmountOut()+"", //$NON-NLS-1$
								df.format(priceIn),
								df.format(priceOut)});

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
	    EngBLUtils.printTable(tableTransactions,""); //$NON-NLS-1$
	    
	}

}
