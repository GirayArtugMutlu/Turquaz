package com.turquaz.accounting.ui.reports;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;

import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.custom.CLabel;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;

import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.ui.AccUITransactionCollectUpdateDialog;
import com.turquaz.accounting.ui.AccUITransactionPaymentUpdateDialog;
import com.turquaz.accounting.ui.AccUITransactionUpdateDialog;
import com.turquaz.accounting.ui.comp.AccountPicker;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class AccUISubsidiaryLedger extends Composite implements SearchComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private TableColumn tableColumnDept;

	private TableColumn tableColumnDate;

	private DatePicker dateEndDate;

	private CLabel lblEndDate;

	private DatePicker dateStartDate;

	private TableColumn tableColumnDocumentNo;

	private TableColumn tableColumnCredit;

	private CLabel lblStartDate;

	private TableColumn tableColumnDefinition;

	private AccountPicker txtAccount;

	private CLabel lblAccNo;

	private Table tableTransactions;

	private Composite compAccTransactionSearch;

	private AccBLTransactionSearch blTransSearch = new AccBLTransactionSearch();

	public AccUISubsidiaryLedger(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will
	 * disappear.
	 */
	public void initGUI() {
		try {
			preInitGUI();

			{
				compAccTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 81;
				composite1LData.grabExcessHorizontalSpace = true;
				compAccTransactionSearch.setLayoutData(composite1LData);
				compAccTransactionSearch.setLayout(composite1Layout);
				{
					lblAccNo = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblDocumentNoLData = new GridData();
					lblDocumentNoLData.widthHint = 99;
					lblDocumentNoLData.heightHint = 24;
					lblAccNo.setLayoutData(lblDocumentNoLData);
					lblAccNo.setText("Hesap Kodu"); //$NON-NLS-1$
					lblAccNo
							.setSize(new org.eclipse.swt.graphics.Point(99, 24));
				}
				{
					txtAccount = new AccountPicker(compAccTransactionSearch,
							SWT.NONE);
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 135;
					txtDocumentNoLData.heightHint = 17;
					txtDocumentNoLData.horizontalSpan = 3;
					txtAccount.setLayoutData(txtDocumentNoLData);
					txtAccount.setSize(new org.eclipse.swt.graphics.Point(141,
							17));
				}

				{
					lblStartDate = new CLabel(compAccTransactionSearch,
							SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(Messages
							.getString("AccUITransactionSearch.3")); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(compAccTransactionSearch,
							SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 174;
					dateStartDateLData.heightHint = 24;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.setSize(new org.eclipse.swt.graphics.Point(
							174, 24));
					dateStartDate.layout();
					Calendar cal = Calendar.getInstance();
					
					dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(Messages
							.getString("AccUITransactionSearch.4")); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(compAccTransactionSearch,
							SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 173;
					dateEndDateLData.heightHint = 25;
					dateEndDate.setLayoutData(dateEndDateLData);
					dateEndDate.setSize(new org.eclipse.swt.graphics.Point(173,
							25));
					dateEndDate.layout();
				}
				compAccTransactionSearch.layout();
			}
			tableTransactions = new Table(this, SWT.MULTI | SWT.FULL_SELECTION);
			tableColumnDate = new TableColumn(tableTransactions, SWT.NULL);

			this.setSize(new org.eclipse.swt.graphics.Point(646, 513));

			GridData tableTransactionsLData = new GridData();
			tableTransactionsLData.verticalAlignment = GridData.FILL;
			tableTransactionsLData.horizontalAlignment = GridData.FILL;
			tableTransactionsLData.grabExcessHorizontalSpace = true;
			tableTransactionsLData.grabExcessVerticalSpace = true;
			tableTransactions.setLayoutData(tableTransactionsLData);
			tableTransactions.setHeaderVisible(true);
			tableTransactions.setLinesVisible(true);
			tableTransactions.addMouseListener(new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableTransactionsMouseDoubleClick(evt);
				}
			});

			tableColumnDate.setText(Messages
					.getString("AccUITransactionSearch.7")); //$NON-NLS-1$
			tableColumnDate.setWidth(118);
			{
				tableColumnDocumentNo = new TableColumn(tableTransactions,
						SWT.NONE);
				tableColumnDocumentNo.setText(Messages
						.getString("AccUITransactionSearch.0"));
				tableColumnDocumentNo.setWidth(126);
			}
			{
				tableColumnDefinition = new TableColumn(tableTransactions,
						SWT.NONE);
				tableColumnDefinition.setText(Messages
						.getString("AccUITransactionSearch.5")); //$NON-NLS-1$
				tableColumnDefinition.setWidth(150);
			}
			{
				tableColumnDept = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDept.setText("Borç"); //$NON-NLS-1$
				tableColumnDept.setWidth(118);

			}
			{
				tableColumnCredit = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnCredit.setText("Alacak");
				tableColumnCredit.setWidth(118);
			}
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
				}
			});

			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI() {
	}

	/** Add your post-init code in here */
	public void postInitGUI() {

	}

	public void save() {

	}

	public void delete() {

		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);

		TableItem items[] = tableTransactions.getSelection();
		if (items.length > 0) {
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) items[0]
					.getData();

			int status = 0;

			/* Check if it has a journal entry */
			if (accTrans.getTurqAccountingJournal().getAccountingJournalId()
					.intValue() != -1) {
				status = 1;

			}
			/*
			 * Check if it is entered from accountingmodule
			 *  
			 */
			//1- Muhasebe Modulu
			else if (accTrans.getTurqModule().getModulesId().intValue() != 1) {
				status = 2;

			}

			if (status == 2) {
				msg.setMessage(Messages.getString("AccUITransactionSearch.6")); //$NON-NLS-1$
				msg.open();
				return;
			}
			if (status == 1) {
				msg.setMessage(Messages.getString("AccUITransactionSearch.9")); //$NON-NLS-1$
				msg.open();
				return;
			}

			AccBLTransactionUpdate blUpdate = new AccBLTransactionUpdate();
			MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK
					| SWT.CANCEL);
			try {
				msg2
						.setMessage(Messages
								.getString("AccUITransactionSearch.10")); //$NON-NLS-1$
				int result = msg2.open();

				if (result == SWT.OK) {

					blUpdate.initiliazeTransactionRows(accTrans);

					Iterator it = accTrans
							.getTurqAccountingTransactionColumns().iterator();
					while (it.hasNext()) {
						EngBLCommon.delete(it.next());
					}
					EngBLCommon.delete(accTrans);

					msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
					msg.open();
					search();

				}

			} catch (Exception ex) {
				MessageBox msg3 = new MessageBox(this.getShell(),
						SWT.ICON_WARNING);
				msg3.setMessage(Messages.getString("AccUIAccountingPlan.5")); //$NON-NLS-1$
				msg3.open();

				ex.printStackTrace();

			}
		}

	}

	public void search() {
		try {
			tableTransactions.removeAll();
			
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
			
			if (txtAccount.getData()== null)
			{
		    	msg.setMessage("Lütfen Bir Muhasebe Hesab? Seçiniz!.."); //$NON-NLS-1$
		    	msg.open();
		    	txtAccount.setFocus();
		    	return ; 
			}
			List result = blTransSearch.searchAccTransactionsColumns(
					(TurqAccountingAccount) txtAccount.getData(), dateStartDate
							.getData(), dateEndDate.getData());

			TableItem item;

			int listSize = result.size();
			for (int i = 0; i < listSize; i++) {

				TurqAccountingTransactionColumn accTransColumn = (TurqAccountingTransactionColumn) result
						.get(i);

				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(accTransColumn.getTurqAccountingTransaction());
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
				BigDecimal total = new BigDecimal(0);

				String transDate = formatter.format(accTransColumn
						.getTurqAccountingTransaction().getTransactionsDate());
				item.setText(new String[] { transDate,
						accTransColumn.getTurqAccountingTransaction().getTransactionDocumentNo(),
						accTransColumn.getTransactionDefinition(),accTransColumn.getDeptAmount().toString(),accTransColumn.getCreditAmount().toString() });
			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	public void newForm() {

	}

	public void printTable() {
		EngBLUtils.printTable(tableTransactions, Messages
				.getString("AccUITransactionSearch.11")); //$NON-NLS-1$

	}

	/** Auto-generated event handler method */
	protected void tableTransactionsMouseDoubleClick(MouseEvent evt) {

		TableItem selection[] = tableTransactions.getSelection();

		if (selection.length > 0) {

			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) selection[0]
					.getData();

			int type = accTrans.getTurqAccountingTransactionType()
					.getAccountingTransactionTypesId().intValue();
		    if(type==2){
			    new AccUITransactionUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
			    search();
			    
			    }
			    else if(type==1){
			    new AccUITransactionPaymentUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
			    search();
			    }
			    else if(type==0) {
			    	new AccUITransactionCollectUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
			        search();
			    
			    }
		}

	}

	public void exportToExcel() {

		EngBLUtils.Export2Excel(tableTransactions);

	}

}