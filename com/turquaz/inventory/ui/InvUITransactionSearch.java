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

import java.util.Iterator;
import java.util.List;


import org.eclipse.jface.contentassist.SubjectControlContentAssistant;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TextWithButton;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLSearchTransaction;

import org.eclipse.swt.widgets.Label;
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
		implements SecureComposite, SearchComposite {
	private Composite compInvTransactionSearch;

	private Table tableTransactions;

	private TableColumn tableColumnCurrentName;

	private TableColumn tableColumnVatAmount;

	private TextWithButton txtCurCard;
	private TableColumn tableColumnInventoryCode;
	private Text txtInvCard;
	private Label lblInvCard;

	private CCombo comboTransactionsType;

	private CLabel lblType;

	private CLabel lblEndDate;

	private DatePicker dateEndDate;

	private DatePicker dateStartDate;

	private CLabel lblStartDate;

	private CLabel lblCurrentCard;

	private TableColumn tableColumnSpecialVatAmount;

	private TableColumn tableColumnCumulativePrice;

	private TableColumn tableColumnTransactionDate;

	private InvBLSearchTransaction blSearch = new InvBLSearchTransaction();

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
                composite1Layout.numColumns = 2;
                GridData composite1LData = new GridData();
                composite1LData.heightHint = 147;
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                compInvTransactionSearch.setLayoutData(composite1LData);
                compInvTransactionSearch.setLayout(composite1Layout);
                {
                    lblInvCard = new Label(compInvTransactionSearch, SWT.NONE);
                    lblInvCard.setText(Messages
                        .getString("InvUITransactionSearch.0")); //$NON-NLS-1$
                        GridData lblInvCardLData = new GridData();
                        lblInvCardLData.widthHint = 89;
                        lblInvCardLData.heightHint = 17;
                        lblInvCard.setLayoutData(lblInvCardLData);
                }
                {
                    txtInvCard = new Text(compInvTransactionSearch, SWT.NONE);

                    GridData textWithButton1LData = new GridData();
                    txtInvCard.addModifyListener(new ModifyListener() {
                       public void modifyText(ModifyEvent ev){
                           try{
                             txtInvCard.setData( EngBLInventoryCards.getAccount(txtInvCard.getText().trim()));
                                                 
                           }
                           catch(Exception ex){
                               ex.printStackTrace();
                           }
                           
                           
                       }
                    });
                    txtInvCard.setDoubleClickEnabled(false);
                    textWithButton1LData.widthHint = 203;
                    textWithButton1LData.heightHint = 20;
                    txtInvCard.setLayoutData(textWithButton1LData);
                }
                {
                    lblCurrentCard = new CLabel(
                        compInvTransactionSearch,
                        SWT.NONE);
                    lblCurrentCard.setText(Messages
                        .getString("InvUITransactionSearch.1")); //$NON-NLS-1$
                    GridData lblCurrentCardLData = new GridData();
                    lblCurrentCardLData.widthHint = 109;
                    lblCurrentCardLData.heightHint = 18;
                    lblCurrentCard.setLayoutData(lblCurrentCardLData);
                }
                {
                    txtCurCard = new TextWithButton(
                        compInvTransactionSearch,
                        SWT.NONE);
                    GridData txtCurCardLData = new GridData();
                    txtCurCard.addMouseListener(new MouseAdapter() {
                        public void mouseUp(MouseEvent evt) {
                            currentCardChoose();
                        }
                    });
                    txtCurCardLData.widthHint = 208;
                    txtCurCardLData.heightHint = 20;
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
                    comboConsignmentTypeLData.widthHint = 72;
                    comboConsignmentTypeLData.heightHint = 14;
                    comboTransactionsType
                        .setLayoutData(comboConsignmentTypeLData);
                }
            }
			{
				tableTransactions = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				
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
					tableColumnTransactionDate.setWidth(104);
				}
				{
					tableColumnCurrentName = new TableColumn(tableTransactions,
							SWT.NONE);
					tableColumnCurrentName.setText(Messages.getString("InvUITransactionSearch.7")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
				}
				{
					tableColumnInventoryCode = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryCode.setText(Messages.getString("InvUITransactionSearch.8")); //$NON-NLS-1$
					tableColumnInventoryCode.setWidth(140);
				}
				{
					tableColumnCumulativePrice = new TableColumn(
							tableTransactions, SWT.NONE);
					tableColumnCumulativePrice.setText(Messages.getString("InvUITransactionSearch.9")); //$NON-NLS-1$
					tableColumnCumulativePrice.setWidth(100);
				}
				{
					tableColumnVatAmount = new TableColumn(tableTransactions,
							SWT.NONE);
					tableColumnVatAmount.setText(Messages.getString("InvUITransactionSearch.10")); //$NON-NLS-1$
					tableColumnVatAmount.setWidth(100);
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
							tableTransactions, SWT.NONE);
					tableColumnSpecialVatAmount.setText(Messages.getString("InvUITransactionSearch.11")); //$NON-NLS-1$
					tableColumnSpecialVatAmount.setWidth(100);
				}
			}
			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void postInitGui() {
		comboTransactionsType.add(Messages.getString("InvUITransactionSearch.12")); //$NON-NLS-1$
		comboTransactionsType.add(Messages.getString("InvUITransactionSearch.13")); //$NON-NLS-1$
	
//		Content Assistant for Inventory Code
		/****************************************************/
		  TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(txtInvCard);
		
		 final SubjectControlContentAssistant asistant= new TurquazContentAssistant(adapter,1);
		   
		     adapter.appendVerifyKeyListener(
		             new VerifyKeyListener() {
		                 public void verifyKey(VerifyEvent event) {

		                 // Check for Ctrl+Spacebar
		                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
		             
		                  asistant.showPossibleCompletions();              
		                   event.doit = false;

		                 }
		              }
		           });
		 	
		  /************************************************************/  
		
		
		
		
	}

	public void currentCardChoose() {
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			System.out.println(data.getClass().getName());
			TurqCurrentCard curCard = (TurqCurrentCard) data;
			txtCurCard.setText(curCard.getCardsCurrentCode() + " - " //$NON-NLS-1$
					+ curCard.getCardsName());
			txtCurCard.setData(curCard);

		}

	}
	/*
	public void inventoryCardChoose() {
		Object data = new InvUICardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			System.out.println(data.getClass().getName());
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

			tableTransactions.removeAll();
			int type = 0;
			if (comboTransactionsType.getText().equals(Messages.getString("InvUITransactionSearch.16"))) { //$NON-NLS-1$
				type = 1;
			}

			List list = blSearch.searchTransactions((TurqCurrentCard) txtCurCard
					.getData(),(TurqInventoryCard) txtInvCard.getData(), dateStartDate.getDate(), dateEndDate.getDate(),
					type);
			TurqInventoryTransaction transactions;
			TableItem item;
			for (int i = 0; i < list.size(); i++) {

				transactions = (TurqInventoryTransaction) list.get(i);
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(transactions);
			
				Iterator it = transactions.getTurqEngineSequence().getTurqConsignments().iterator();
			
				TurqConsignment cons = null;
				
				if(it.hasNext()){
					cons = (TurqConsignment)it.next();
					
				}
				else{
					throw new Exception(Messages.getString("InvUITransactionSearch.17")); //$NON-NLS-1$
				}
				
				
				item.setText(new String[] {
								DatePicker.formatter.format(cons.getConsignmentsDate()),
							    cons.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName(),
								transactions.getTurqInventoryCard().getCardName(),
								cons.getTurqBillConsignmentCommon().getTotalAmount().toString(),
								cons.getTurqBillConsignmentCommon().getVatAmount().toString(),
								cons.getTurqBillConsignmentCommon().getSpecialVatAmount()
										.toString() });

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

}