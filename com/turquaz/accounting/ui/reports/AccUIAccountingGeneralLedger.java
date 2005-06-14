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
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.common.HashBag;
import org.eclipse.swt.widgets.Button;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import org.eclipse.swt.layout.GridData;
import com.jasperassistant.designer.viewer.ViewerComposite;

public class AccUIAccountingGeneralLedger extends org.eclipse.swt.widgets.Composite
{
	private Calendar cal = Calendar.getInstance();
	private Composite compOptions;
	private CLabel lblAccountEnd;
	private Composite compViewever;
	private AccountPicker txtAccountStart;
	private CLabel lblAccountStart;
	private Button btnShow;
	private Button checkApproved;
	private DatePicker datePickerEndDate;
	private ViewerComposite viewer;
	private AccountPicker txtAccountEnd;
	private CLabel lblEndDate;
	private DatePicker datePickerBeginDate;
	private CLabel lblStartDate;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public AccUIAccountingGeneralLedger(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			this.setSize(613, 330);
			//START >> compOptions
			compOptions = new Composite(this, SWT.NONE);
			GridLayout compOptionsLayout = new GridLayout();
			GridData compOptionsLData = new GridData();
			compOptionsLData.horizontalAlignment = GridData.FILL;
			compOptionsLData.verticalAlignment = GridData.FILL;
			compOptions.setLayoutData(compOptionsLData);
			compOptionsLayout.makeColumnsEqualWidth = true;
			compOptionsLayout.numColumns = 4;
			compOptions.setLayout(compOptionsLayout);
			//START >> lblStartDate
			lblStartDate = new CLabel(compOptions, SWT.NONE);
			lblStartDate.setText(AccLangKeys.STR_START_DATE); 
			//END << lblStartDate
			//START >> datePickerBeginDate
			datePickerBeginDate = new DatePicker(compOptions, SWT.NONE);
			//datePickerBeginDate.setDate(new
			// Date(cal.getTime().getYear(),0,1));
			cal.set(cal.get(Calendar.YEAR), 0, 1);
			datePickerBeginDate.setDate(cal.getTime());
			GridData datePickerBeginDateLData = new GridData();
			datePickerBeginDateLData.widthHint = 135;
			datePickerBeginDateLData.heightHint = 22;
			datePickerBeginDate.setLayoutData(datePickerBeginDateLData);
			//END << datePickerBeginDate
			//START >> lblEndDate
			lblEndDate = new CLabel(compOptions, SWT.NONE);
			lblEndDate.setText(AccLangKeys.STR_END_DATE); //$NON-NLS-1$
			GridData lblEndDateLData = new GridData();
			lblEndDateLData.widthHint = 75;
			lblEndDateLData.heightHint = 16;
			lblEndDate.setLayoutData(lblEndDateLData);
			//END << lblEndDate
			//START >> datePickerEndDate
			datePickerEndDate = new DatePicker(compOptions, SWT.NONE);
			GridData datePickerEndDateLData = new GridData();
			datePickerEndDateLData.widthHint = 135;
			datePickerEndDateLData.heightHint = 22;
			datePickerEndDate.setLayoutData(datePickerEndDateLData);
			//END << datePickerEndDate
			//START >> lblAccountStart
			lblAccountStart = new CLabel(compOptions, SWT.NONE);
			lblAccountStart.setText(AccLangKeys.STR_ACC_CODE_START); 
			//END << lblAccountStart
			//START >> txtAccountStart
			txtAccountStart = new AccountPicker(compOptions, SWT.NONE);
			GridData txtAccountStartLData = new GridData();
			txtAccountStartLData.widthHint = 134;
			txtAccountStartLData.heightHint = 17;
			txtAccountStart.setLayoutData(txtAccountStartLData);
			//END << txtAccountStart
			//START >> lblAccountEnd
			lblAccountEnd = new CLabel(compOptions, SWT.NONE);
			lblAccountEnd.setText(AccLangKeys.STR_ACC_CODE_END); 
			//END << lblAccountEnd
			//START >> txtAccountEnd
			txtAccountEnd = new AccountPicker(compOptions, SWT.NONE);
			GridData txtAccountEndLData = new GridData();
			txtAccountEndLData.widthHint = 134;
			txtAccountEndLData.heightHint = 17;
			txtAccountEnd.setLayoutData(txtAccountEndLData);
			//END << txtAccountEnd
			//START >> checkApproved
			checkApproved = new Button(compOptions, SWT.CHECK | SWT.LEFT);
			checkApproved.setText(AccLangKeys.STR_SHOW_ONLY_APPROVED); 
			GridData checkApprovedLData = new GridData();
			checkApprovedLData.widthHint = 182;
			checkApprovedLData.heightHint = 12;
			checkApprovedLData.horizontalSpan = 3;
			checkApproved.setLayoutData(checkApprovedLData);
			//END << checkApproved
			//START >> btnShow
			btnShow = new Button(compOptions, SWT.PUSH | SWT.CENTER);
			btnShow.setText(AccLangKeys.STR_SHOW_REPORT); 
			GridData btnShowLData = new GridData();
			btnShow.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnShowSingleClick();
				}
			});
			btnShowLData.widthHint = 134;
			btnShowLData.heightHint = 22;
			btnShow.setLayoutData(btnShowLData);
			//END << btnShow
			//END << compOptions
			//START >> compViewever
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
			//START >> viewer
			viewer = new ViewerComposite(compViewever, SWT.NONE);
			GridData viewerLData = new GridData();
			viewerLData.grabExcessVerticalSpace = true;
			viewerLData.grabExcessHorizontalSpace = true;
			viewerLData.horizontalAlignment = GridData.FILL;
			viewerLData.verticalAlignment = GridData.FILL;
			viewer.setLayoutData(viewerLData);
			//END << viewer
			//END << compViewever
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	private void btnShowSingleClick()
	{
		try
		{
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_START_ID,txtAccountStart.getId());
			argMap.put(AccKeys.ACC_ACCOUNT_END_ID,txtAccountEnd.getId());
			argMap.put(EngKeys.DATE_START,datePickerBeginDate.getDate());
			argMap.put(EngKeys.DATE_END,datePickerEndDate.getDate());
			argMap.put(AccKeys.ACC_APPROVED,new Boolean(checkApproved.getSelection()));
			
			HashBag bag=(HashBag)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getGeneralLedger",argMap);
			List list=(List)bag.get(AccKeys.ACC_TRANSACTIONS);
			
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy"); 
			Map parameters = new HashMap();
			parameters.put("beginDate", dformat2.format(datePickerBeginDate.getDate())); 
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); 
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); 
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			parameters.put("formatter", formatter);
			
			GenerateJasper(list,parameters);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public void GenerateJasper(List list, Map parameters)
	{
		try
		{
			String[] fields = new String[]{"top_account",
					"account_name",
					"account_code",
					"transactions_date",
					"transaction_document_no",
					"rows_dept_in_base_currency",
					"rows_credit_in_base_currency",
					"transaction_definition",					
					"accounting_journal_id",
					"accounting_accounts_id"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/accounting/AccountingGeneralLedger.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

}