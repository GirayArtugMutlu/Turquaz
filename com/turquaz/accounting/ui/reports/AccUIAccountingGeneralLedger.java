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

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.SWT;

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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.accounting.ui.comp.AccountPickerAll;
import org.eclipse.swt.widgets.Button;

import com.turquaz.accounting.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;
import com.jasperassistant.designer.viewer.ViewerComposite;

public class AccUIAccountingGeneralLedger extends
		org.eclipse.swt.widgets.Composite {

	private Calendar cal = Calendar.getInstance();
	private Composite compOptions;
	private CLabel lblAccountEnd;
	private Composite compViewever;
	private AccountPickerAll txtAccountStart;
	private CLabel lblAccountStart;
	private Button btnShow;
	private Button checkApproved;
	private DatePicker datePickerEndDate;
	private ViewerComposite viewer;
	private AccountPickerAll txtAccountEnd;
	private CLabel lblEndDate;
	private DatePicker datePickerBeginDate;
	private CLabel lblStartDate;

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */

	public AccUIAccountingGeneralLedger(
			org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			this.setSize(613, 330);
			//START >>  compOptions
			compOptions = new Composite(this, SWT.NONE);
			GridLayout compOptionsLayout = new GridLayout();
			GridData compOptionsLData = new GridData();
			compOptionsLData.horizontalAlignment = GridData.FILL;
			compOptionsLData.verticalAlignment = GridData.FILL;
			compOptions.setLayoutData(compOptionsLData);
			compOptionsLayout.makeColumnsEqualWidth = true;
			compOptionsLayout.numColumns = 4;
			compOptions.setLayout(compOptionsLayout);
			//START >>  lblStartDate
			lblStartDate = new CLabel(compOptions, SWT.NONE);
			lblStartDate.setText(Messages.getString("AccUIAccountingGeneralLedger.0")); //$NON-NLS-1$
			//END <<  lblStartDate
			//START >>  datePickerBeginDate
			datePickerBeginDate = new DatePicker(compOptions, SWT.NONE);
			//datePickerBeginDate.setDate(new
			// Date(cal.getTime().getYear(),0,1));
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			datePickerBeginDate.setDate(cal.getTime());
			GridData datePickerBeginDateLData = new GridData();
			datePickerBeginDateLData.widthHint = 135;
			datePickerBeginDateLData.heightHint = 22;
			datePickerBeginDate.setLayoutData(datePickerBeginDateLData);
			//END <<  datePickerBeginDate
			//START >>  lblEndDate
			lblEndDate = new CLabel(compOptions, SWT.NONE);
			lblEndDate.setText(Messages.getString("AccUIAccountingGeneralLedger.3")); //$NON-NLS-1$
			GridData lblEndDateLData = new GridData();
			lblEndDateLData.widthHint = 75;
			lblEndDateLData.heightHint = 16;
			lblEndDate.setLayoutData(lblEndDateLData);
			//END <<  lblEndDate
			//START >>  datePickerEndDate
			datePickerEndDate = new DatePicker(compOptions, SWT.NONE);
			GridData datePickerEndDateLData = new GridData();
			datePickerEndDateLData.widthHint = 135;
			datePickerEndDateLData.heightHint = 22;
			datePickerEndDate.setLayoutData(datePickerEndDateLData);
			//END <<  datePickerEndDate
			//START >>  lblAccountStart
			lblAccountStart = new CLabel(compOptions, SWT.NONE);
			lblAccountStart.setText(Messages.getString("AccUIAccountingGeneralLedger.4")); //$NON-NLS-1$
			//END <<  lblAccountStart
			//START >>  txtAccountStart
			txtAccountStart = new AccountPickerAll(compOptions, SWT.NONE);
			GridData txtAccountStartLData = new GridData();
			txtAccountStartLData.widthHint = 134;
			txtAccountStartLData.heightHint = 17;
			txtAccountStart.setLayoutData(txtAccountStartLData);
			//END <<  txtAccountStart
			//START >>  lblAccountEnd
			lblAccountEnd = new CLabel(compOptions, SWT.NONE);
			lblAccountEnd.setText(Messages.getString("AccUIAccountingGeneralLedger.5")); //$NON-NLS-1$
			//END <<  lblAccountEnd
			//START >>  txtAccountEnd
			txtAccountEnd = new AccountPickerAll(compOptions, SWT.NONE);
			GridData txtAccountEndLData = new GridData();
			txtAccountEndLData.widthHint = 134;
			txtAccountEndLData.heightHint = 17;
			txtAccountEnd.setLayoutData(txtAccountEndLData);
			//END <<  txtAccountEnd
			//START >>  checkApproved
			checkApproved = new Button(compOptions, SWT.CHECK | SWT.LEFT);
			checkApproved.setText(Messages
				.getString("AccUIAccountingGeneralLedger.2")); //$NON-NLS-1$
			GridData checkApprovedLData = new GridData();
			checkApprovedLData.widthHint = 182;
			checkApprovedLData.heightHint = 12;
			checkApprovedLData.horizontalSpan = 3;
			checkApproved.setLayoutData(checkApprovedLData);
			//END <<  checkApproved
			//START >>  btnShow
			btnShow = new Button(compOptions, SWT.PUSH | SWT.CENTER);
			btnShow.setText(Messages
				.getString("AccUIAccountingGeneralLedger.1")); //$NON-NLS-1$
			GridData btnShowLData = new GridData();
			btnShow.addMouseListener(new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnShowSingleClick();
				}
			});
			btnShowLData.widthHint = 134;
			btnShowLData.heightHint = 22;
			btnShow.setLayoutData(btnShowLData);
			//END <<  btnShow
			//END <<  compOptions
			//START >>  compViewever
			compViewever = new Composite(this, SWT.NONE);
			GridLayout compVieweverLayout = new GridLayout();
			GridData compVieweverLData = new GridData();
			compVieweverLData.grabExcessHorizontalSpace = true;
			compVieweverLData.grabExcessVerticalSpace = true;
			compVieweverLData.horizontalAlignment = GridData.FILL;
			compVieweverLData.verticalAlignment = GridData.FILL;
			compViewever.setLayoutData(compVieweverLData);
			compVieweverLayout.makeColumnsEqualWidth = true;
			compViewever.setLayout(compVieweverLayout);
			//START >>  viewer
			viewer = new ViewerComposite(compViewever, SWT.NONE);
			GridData viewerLData = new GridData();
			viewerLData.grabExcessVerticalSpace = true;
			viewerLData.grabExcessHorizontalSpace = true;
			viewerLData.horizontalAlignment = GridData.FILL;
			viewerLData.verticalAlignment = GridData.FILL;
			viewer.setLayoutData(viewerLData);
			//END <<  viewer
			//END <<  compViewever
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnShowSingleClick() {
		try {

			Map parameters = new HashMap();
			String sqlparam = "Select accounts.top_account,accounts.account_name," + //$NON-NLS-1$
					" accounts.account_code,"+ //$NON-NLS-1$	
					" trans.transactions_date,trans.transaction_document_no,"+ //$NON-NLS-1$
					" transcolumns.rows_dept_in_base_currency," +
					" transcolumns.rows_credit_in_base_currency," +
					" transcolumns.transaction_definition," +//$NON-NLS-1$
					" trans.accounting_journal_id, accounts.id as accounting_accounts_id"+ //$NON-NLS-1$
					" from turq_accounting_accounts accounts," +
					" turq_accounting_transactions trans,"+ //$NON-NLS-1$
					" turq_accounting_transaction_columns transcolumns" +
					" where accounts.id=transcolumns.accounting_accounts_id"+ //$NON-NLS-1$
					" and transcolumns.accounting_transactions_id=trans.id"; //$NON-NLS-1$
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			sqlparam += " and trans.transactions_date >= '" + dformat.format(datePickerBeginDate.getDate()) + "'" //$NON-NLS-1$ //$NON-NLS-2$
					+ " and trans.transactions_date <= '" + dformat.format(datePickerEndDate.getDate()) + "'";//$NON-NLS-1$ //$NON-NLS-2$
			if (checkApproved.getSelection())
				sqlparam += " and trans.accounting_journal_id > 0"; //$NON-NLS-1$
			
			TurqAccountingAccount accountStart=(TurqAccountingAccount)txtAccountStart.getData();
			TurqAccountingAccount accountEnd=(TurqAccountingAccount)txtAccountEnd.getData();
			
			if (accountStart != null && accountEnd != null)
			{
				sqlparam +=" and accounts.account_code >='"+accountStart.getAccountCode()+"'" +
						" and accounts.account_code <='"+accountEnd.getAccountCode()+"'";
			}
			else if (accountStart !=null && accountEnd ==null)
			{
				sqlparam += " and accounts.id="+accountStart.getId();
			}
			else if (accountStart == null && accountEnd != null)
			{
				sqlparam += " and accounts.id="+accountEnd.getId();
			}

			sqlparam += " ORDER BY accounts.top_account,trans.transactions_date"; //$NON-NLS-1$
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$

			parameters.put("sqlparam", sqlparam); //$NON-NLS-1$
			parameters.put("beginDate", dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			parameters.put("formatter", formatter); //$NON-NLS-1$
			EngDALConnection db = new EngDALConnection();
			db.connect();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/accounting/AccountingGeneralLedger.jasper"); //$NON-NLS-1$
			final JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, db.getCon());
			
			viewer.getReportViewer().setDocument(jasperPrint);
			

		} catch (Exception ex) {
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			//msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

}

