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
 * @author  Huseyin Ergun
 * @version  $Id$
 */

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;

import com.cloudgarden.resource.SWTResourceManager;
import com.jasperassistant.designer.viewer.ViewerApp;


import org.eclipse.swt.custom.CLabel;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;

import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;


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
	private CLabel lblAccountCode2;
	private AccountPicker txtAccount2;
	private TableColumn tableColumnCreditBalance;
	private TableColumn tableColumnDeptBalance;

	private CLabel lblAccNo;

	private Table tableTransactions;

	private Composite compAccTransactionSearch;

	private AccBLTransactionSearch blTransSearch = new AccBLTransactionSearch();

	private TurqAccountingAccount account;
	private TurqAccountingAccount account2;
	public AccUISubsidiaryLedger(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will
	 * disappear.
	 */
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
	
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
					lblDocumentNoLData.widthHint = 121;
					lblDocumentNoLData.heightHint = 21;
					lblAccNo.setLayoutData(lblDocumentNoLData);
					lblAccNo.setText(Messages.getString("AccUISubsidiaryLedger.0")); //$NON-NLS-1$
				}
				{
					txtAccount = new AccountPicker(compAccTransactionSearch,
							SWT.NONE);
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 173;
					txtDocumentNoLData.heightHint = 15;
					txtAccount.setLayoutData(txtDocumentNoLData);
				}
				{
					lblAccountCode2 = new CLabel(
						compAccTransactionSearch,
						SWT.NONE);
					lblAccountCode2.setText(Messages.getString("AccUISubsidiaryLedger.12")); //$NON-NLS-1$
				}
				{
					txtAccount2 = new AccountPicker(
						compAccTransactionSearch,
						SWT.NONE);
					GridData txtAccount2LData = new GridData();
					txtAccount2LData.widthHint = 173;
					txtAccount2LData.heightHint = 15;
					txtAccount2.setLayoutData(txtAccount2LData);
				}

				{
					lblStartDate = new CLabel(compAccTransactionSearch,
							SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(Messages.getString("AccUISubsidiaryLedger.1"));  //$NON-NLS-1$
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
					
					
					dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(Messages.getString("AccUISubsidiaryLedger.2"));  //$NON-NLS-1$
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
			{
				tableTransactions = new Table(this, SWT.MULTI | SWT.FULL_SELECTION);
				GridData tableTransactionsLData = new GridData();
				tableTransactionsLData.verticalAlignment = GridData.FILL;
				tableTransactionsLData.horizontalAlignment = GridData.FILL;
				tableTransactionsLData.grabExcessHorizontalSpace = true;
				tableTransactionsLData.grabExcessVerticalSpace = true;
				tableTransactions.setLayoutData(tableTransactionsLData);
				tableTransactions.setHeaderVisible(true);
				tableTransactions.setLinesVisible(true);
				{
					tableColumnDate = new TableColumn(tableTransactions, SWT.LEFT);
					tableColumnDate.setText(Messages
						.getString("AccUISubsidiaryLedger.3")); //$NON-NLS-1$
					tableColumnDate.setWidth(76);
				}
				{
					tableColumnDocumentNo = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnDocumentNo.setText(Messages
						.getString("AccUISubsidiaryLedger.4")); //$NON-NLS-1$
					tableColumnDocumentNo.setWidth(87);
				}
				{
					tableColumnDefinition = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnDefinition.setText(Messages
						.getString("AccUISubsidiaryLedger.5")); //$NON-NLS-1$
					tableColumnDefinition.setWidth(120);
				}
				{
					tableColumnDept = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnDept.setText(Messages
						.getString("AccUISubsidiaryLedger.6")); //$NON-NLS-1$
					tableColumnDept.setWidth(88);

				}
				{
					tableColumnCredit = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnCredit.setText(Messages
						.getString("AccUISubsidiaryLedger.7")); //$NON-NLS-1$
					tableColumnCredit.setWidth(83);
				}
				{
					tableColumnDeptBalance = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnDeptBalance.setText(Messages.getString("AccUISubsidiaryLedger.10")); //$NON-NLS-1$
					tableColumnDeptBalance.setWidth(80);
				}
				{
					tableColumnCreditBalance = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnCreditBalance.setText(Messages.getString("AccUISubsidiaryLedger.11")); //$NON-NLS-1$
					tableColumnCreditBalance.setWidth(80);
				}
				tableTransactions.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableTransactionsMouseDoubleClick(evt);
					}
				});
			}

			this.setSize(669, 511);

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

	}

	public void search() {
		
		try{
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			account=null;
			account2=null;
			if (txtAccount.getData()== null && txtAccount2.getData()== null)
			{
		    	msg.setMessage("?lk önce en az bir tane hesap kodu seçmelisiniz!"); 
		    	msg.open();
		    	txtAccount.setFocus();
		    	return ; 
			}
			else if (txtAccount.getData()==null)
			{
				account=(TurqAccountingAccount)txtAccount2.getData();
				account2=null;
			}
			else if (txtAccount2.getData()==null)
			{
				account=(TurqAccountingAccount)txtAccount.getData();
				account2=null;
			}
			else
			{
				account=(TurqAccountingAccount)txtAccount.getData();
				account2=(TurqAccountingAccount)txtAccount2.getData();
			}
			
			Map parameters = new HashMap();		
			String sqlparam;
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
			if (account2==null)
			{
				sqlparam="Select transColumns.accounting_transaction_columns_id as columnId, " +
						"transColumns.dept_amount,transColumns.credit_amount," +
						"transColumns.transaction_definition, accounts.account_name as accName," +
						"accounts.account_code as accCode, topacc.account_name as topAccName, topacc.account_code as topAccCode," +
						" trans.transactions_date, trans.transaction_document_no" +
						" from turq_accounting_transaction_columns transColumns," +
						" turq_accounting_accounts accounts," +
						" turq_accounting_accounts topacc," +
						" turq_accounting_transactions trans" +
				" where transColumns.accounting_accounts_id=accounts.accounting_accounts_id"+
				" and accounts.top_account=topacc.accounting_accounts_id" +
				" and accounts.accounting_accounts_id="+account.getAccountingAccountsId().intValue()+
				" and transColumns.accounting_transactions_id=trans.accounting_transactions_id"+
				" and trans.transactions_date >="+"'"+dformat.format(dateStartDate.getDate())+"'"+
				" and trans.transactions_date <="+"'"+dformat.format(dateEndDate.getDate())+"'";
			}
			else
			{
				sqlparam="Select transColumns.accounting_transaction_columns_id as columnId," +
				"transColumns.dept_amount,transColumns.credit_amount," +
				"transColumns.transaction_definition, accounts.account_name as accName," +
				"accounts.account_code as accCode, topacc.account_name as topAccName, topacc.account_code as topAccCode," +
				" trans.transactions_date, trans.transaction_document_no" +
				" from turq_accounting_transaction_columns transColumns," +
				" turq_accounting_accounts accounts, " +
				"turq_accounting_accounts topacc," +
				" turq_accounting_transactions trans" +
					" where transColumns.accounting_accounts_id=accounts.accounting_accounts_id" +
					" and accounts.top_account=topacc.accounting_accounts_id"+
					" and transColumns.accounting_transactions_id=trans.accounting_transactions_id"+
					" and accounts.account_code >="+"'"+account.getAccountCode()+"'"+
					" and accounts.account_code <="+"'"+account2.getAccountCode()+"'"+
					" and trans.transactions_date >="+"'"+dformat.format(dateStartDate.getDate())+"'"+
					" and trans.transactions_date <="+"'"+dformat.format(dateEndDate.getDate())+"'"+
					" order by accounts.accounting_accounts_id";
			}	
			System.out.println(sqlparam);
			SimpleDateFormat dformat2=new SimpleDateFormat("dd/MM/yyyy");
			parameters.put("sqlparam",sqlparam);
			parameters.put("beginDate",dformat2.format(dateStartDate.getDate()));
			parameters.put("endDate",dformat2.format(dateEndDate.getDate())); 			
			parameters.put("dformat",dformat2);
			parameters.put("account1",account.getAccountCode());
			parameters.put("account2",(account2==null)? "" : account2.getAccountCode());
			NumberFormat formatter=NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", new TurkishCurrencyFormat());
			EngDALConnection db=new EngDALConnection();
			db.connect();
			
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/accounting/AccountingSubsidiaryLedger.jasper"); 
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			ViewerApp viewerApp = new ViewerApp();
			
			viewerApp.getReportViewer().setDocument(jasperPrint);
			viewerApp.open();

			
					
			}
			catch(Exception ex){
				ex.printStackTrace();
				MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
				msg.setMessage(ex.getMessage());
				msg.open();
			}
		
		
		
		
		
		
		
		
		
		/*
		try {
			tableTransactions.removeAll();
			
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
			
			if (txtAccount.getData()== null && txtAccount2.getData()== null)
			{
		    	msg.setMessage(Messages.getString("AccUISubsidiaryLedger.9"));  //$NON-NLS-1$
		    	msg.open();
		    	txtAccount.setFocus();
		    	return ; 
			}
			else if (txtAccount.getData()==null)
			{
				account=(TurqAccountingAccount)txtAccount2.getData();
				account2=null;
			}
			else if (txtAccount2.getData()==null)
			{
				account=(TurqAccountingAccount)txtAccount.getData();
				account2=null;
			}
			else
			{
				account=(TurqAccountingAccount)txtAccount.getData();
				account2=(TurqAccountingAccount)txtAccount2.getData();
			}
			List result = blTransSearch.searchAccTransactionsColumns(
					account, dateStartDate
							.getData(), dateEndDate.getData());
			
			TurkishCurrencyFormat df = new TurkishCurrencyFormat();
			
			BigDecimal balance = new BigDecimal(0); //balance shown in table
			BigDecimal totalDept = new BigDecimal(0); //total dept
			BigDecimal totalCredit = new BigDecimal(0); //total credit
			
			TableItem item;
			// if start date is after beginning of the year
			// get the sum of previous transactions
			if (dateStartDate.getDate().after(new Date(cal.getTime().getYear(),0,1)) )
			{
				// get previous date (any better suggestions :) )
				Date date = dateStartDate.getDate();
				long time = date.getTime();
				time -= 86400000;
				date.setTime(time);
				
				// decimal formatter
				
				
				Object sums[] = blTransSearch.getAccTransactionBalance((TurqAccountingAccount) txtAccount.getData(),
						new Date(cal.getTime().getYear(),0,1),date);
				if (sums[0]!= null)
				{
					balance = balance.subtract((BigDecimal)sums[0]);
					totalDept = totalDept.add((BigDecimal)sums[0]);
					}
				if (sums[1] != null)
				{
					balance = balance.add((BigDecimal)sums[1]);
					totalCredit = totalCredit.add((BigDecimal)sums[1]);
				}
				
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setText(new String[]{"","",Messages.getString(Messages.getString("AccUISubsidiaryLedger.14")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
				        (balance.compareTo(new BigDecimal(0))<0) ? df.format(balance.multiply(new BigDecimal(-1))): "", //$NON-NLS-1$
				        (balance.compareTo(new BigDecimal(0))>0) ? df.format(balance): "", //$NON-NLS-1$
				        (balance.compareTo(new BigDecimal(0))<0) ? df.format(balance.multiply(new BigDecimal(-1))): "", //$NON-NLS-1$
						(balance.compareTo(new BigDecimal(0))>0) ? df.format(balance): "" }); //$NON-NLS-1$
				
				// one empty row
				item = new TableItem(tableTransactions, SWT.NULL);
			
			}
			
			
			int listSize = result.size();
			
			
			
			
			for (int i = 0; i < listSize; i++) {

				TurqAccountingTransactionColumn accTransColumn = (TurqAccountingTransactionColumn) result
						.get(i);
				
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(accTransColumn.getTurqAccountingTransaction());
				
				BigDecimal total = new BigDecimal(0);
				
				balance = balance.add(accTransColumn.getCreditAmount());
				totalCredit = totalCredit.add(accTransColumn.getCreditAmount());
				
				balance = balance.subtract(accTransColumn.getDeptAmount());
				totalDept = totalDept.add(accTransColumn.getDeptAmount());
				
				String transDate = formatter.format(accTransColumn
						.getTurqAccountingTransaction().getTransactionsDate());
				
				
				
				item.setText(new String[] { transDate,
						accTransColumn.getTurqAccountingTransaction().getTransactionDocumentNo(),
						accTransColumn.getTransactionDefinition(),
						
						// if it is zero does not print to the table
						(accTransColumn.getDeptAmount().equals(new BigDecimal(0))) ? "": df.format(accTransColumn.getDeptAmount()), //$NON-NLS-1$
						(accTransColumn.getCreditAmount().equals(new BigDecimal(0))) ? "": df.format(accTransColumn.getCreditAmount()), //$NON-NLS-1$
						(balance.compareTo(new BigDecimal(0))<0) ? df.format(balance.multiply(new BigDecimal(-1))): "", //$NON-NLS-1$
						(balance.compareTo(new BigDecimal(0))>0) ? df.format(balance): "" });  //$NON-NLS-1$
			}
			
			// grand total last row
			item = new TableItem(tableTransactions, SWT.NULL);
			item = new TableItem(tableTransactions, SWT.NULL);
			item.setText(new String[]{"","",Messages.getString("AccUISubsidiaryLedger.25"),df.format(totalDept),df.format(totalCredit), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			        (balance.compareTo(new BigDecimal(0))<0) ? df.format(balance.multiply(new BigDecimal(-1))): "", //$NON-NLS-1$
					(balance.compareTo(new BigDecimal(0))>0) ? df.format(balance): "" }); //$NON-NLS-1$
			
			
			
		} catch (Exception ex) {

			ex.printStackTrace();

		}*/

	}

	public void newForm() {

	}

	public void printTable() {
	    
	    Properties prop = new Properties();
	    prop.put("account_code",account.getAccountCode()); //$NON-NLS-1$
	    prop.put("account_name",account.getAccountName()); //$NON-NLS-1$
	    prop.put("top_account",account.getTurqAccountingAccountByTopAccount().getAccountName()); //$NON-NLS-1$
		prop.put("start_date",formatter.format(dateStartDate.getDate())); //$NON-NLS-1$
		prop.put("end_date",formatter.format(dateEndDate.getDate())); //$NON-NLS-1$
	    EngBLUtils.printSubsidiaryLedgerTable(tableTransactions, Messages.getString("AccUISubsidiaryLedger.8"),prop);  //$NON-NLS-1$

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