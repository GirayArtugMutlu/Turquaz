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
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;

import com.turquaz.accounting.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;
import com.jasperassistant.designer.viewer.ViewerComposite;
public class AccUIAccountingGeneralLedger extends org.eclipse.swt.widgets.Composite {
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblDummy;
	private Button btnShow;
	private Calendar cal=Calendar.getInstance();
	private ViewerComposite reportViewer;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	

	public AccUIAccountingGeneralLedger(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(491, 251);
			{
				lblDateRange = new CLabel(this, SWT.NONE);
				lblDateRange.setText(Messages.getString("AccUIAccountingGeneralLedger.0")); //$NON-NLS-1$
			}
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
				//datePickerBeginDate.setDate(new Date(cal.getTime().getYear(),0,1));
				cal.set(cal.get(Calendar.YEAR),0,1);
				datePickerBeginDate.setDate(cal.getTime());
			}
			{
				datePickerEndDate = new DatePicker(this, SWT.NONE);
			}
			{
				lblDummy = new CLabel(this, SWT.NONE);
				GridData lblDummyLData = new GridData();
				lblDummyLData.horizontalSpan = 2;
				lblDummy.setLayoutData(lblDummyLData);
			}
			{
				btnShow = new Button(this, SWT.PUSH | SWT.CENTER);
				btnShow.setText(Messages.getString("AccUIAccountingGeneralLedger.1")); //$NON-NLS-1$
				GridData btnShowLData = new GridData();
				btnShow.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnShowSingleClick();
					}
				});
				btnShowLData.widthHint = 120;
				btnShowLData.heightHint = 29;
				btnShow.setLayoutData(btnShowLData);
			}
			{
				reportViewer = new ViewerComposite(this, SWT.NONE);
				GridData reportViewerLData = new GridData();
				reportViewerLData.horizontalSpan = 3;
				reportViewerLData.grabExcessHorizontalSpace = true;
				reportViewerLData.horizontalAlignment = GridData.FILL;
				reportViewerLData.grabExcessVerticalSpace = true;
				reportViewerLData.verticalAlignment = GridData.FILL;
				reportViewer.setLayoutData(reportViewerLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnShowSingleClick(){
		try{
			
			Map parameters = new HashMap();
			String sqlparam="Select accounts.top_account,accounts.account_name," + //$NON-NLS-1$
					" accounts.account_code," +
					" trans.transactions_date,trans.transaction_document_no," + //$NON-NLS-1$
					" transcolumns.dept_amount, transcolumns.credit_amount, transcolumns.transaction_definition," + //$NON-NLS-1$
					" trans.accounting_journal_id, accounts.accounting_accounts_id" + //$NON-NLS-1$
					" from turq_accounting_accounts accounts, turq_accounting_transactions trans," + //$NON-NLS-1$
					" turq_accounting_transaction_columns transcolumns where" + //$NON-NLS-1$
					" accounts.accounting_accounts_id=transcolumns.accounting_accounts_id" + //$NON-NLS-1$
					" and transcolumns.accounting_transactions_id=trans.accounting_transactions_id" ; //$NON-NLS-1$
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			sqlparam +=" and trans.transactions_date >= '"+ dformat.format(datePickerBeginDate.getDate())+"'" //$NON-NLS-1$ //$NON-NLS-2$
					+" and trans.transactions_date <= '"+dformat.format(datePickerEndDate.getDate())+"'"//$NON-NLS-1$ //$NON-NLS-2$
					+" and trans.accounting_journal_id > 0"; 	

			sqlparam +=" ORDER BY accounts.top_account,trans.transactions_date"; //$NON-NLS-1$
			SimpleDateFormat dformat2=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			
			parameters.put("sqlparam",sqlparam);	 //$NON-NLS-1$
			parameters.put("beginDate",dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			NumberFormat formatter =NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            parameters.put("formatter",formatter); //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/accounting/AccountingGeneralLedger.jasper"); 
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			
			
			reportViewer.getReportViewer().setDocument(jasperPrint);
			
					
			}
			catch(Exception ex){
				ex.printStackTrace();
				MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
				//msg.setMessage(ex.getMessage());
				msg.open();
			}
		}
		
	}

