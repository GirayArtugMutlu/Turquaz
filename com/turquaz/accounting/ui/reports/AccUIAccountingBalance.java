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
import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;

public class AccUIAccountingBalance extends org.eclipse.swt.widgets.Composite
{
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblLogoURL;
	private Button btnIcon;
	private Button btnShow;

	public AccUIAccountingBalance(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void btnShowSingleClick()
	{
		try
		{
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_TYPE,new Integer(3));
			argMap.put(AccKeys.ACC_START_DATE,datePickerBeginDate.getDate());
			argMap.put(AccKeys.ACC_END_DATE,datePickerEndDate.getDate());
		
			List transColumns = (List)EngTXCommon.doSelectTX(AccBLAccountAdd.class.getName(),"getTransactionColumns",argMap);
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			for (int k = 0; k < transColumns.size(); k++)
			{
				TurqAccountingTransactionColumn column = (TurqAccountingTransactionColumn) transColumns.get(k);
				totalCredit = totalCredit.add(column.getCreditAmount());
				totalDept = totalDept.add(column.getDeptAmount());
			}
			if (!totalDept.equals(totalCredit))
			{
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(AccLangKeys.MSG_OPENING_VOUCHER_NOT_SAME_CREDIT_DEBIT); 
				msg.open();
			}
			Map parameters = new HashMap();
			String sqlparam = "Select mytab.deptsum,mytab.creditsum,mytab.top_account,accs.account_name,accs.account_code," + //$NON-NLS-1$
					" accs.id as accounting_accounts_id from turq_accounting_accounts accs," + //$NON-NLS-1$
					"(Select SUM(transcolumns.dept_amount) as deptsum," + //$NON-NLS-1$
					"SUM(transcolumns.credit_amount) as creditsum," + //$NON-NLS-1$
					" accounts.top_account" + //$NON-NLS-1$
					" from turq_accounting_accounts accounts," + //$NON-NLS-1$
					" turq_accounting_transaction_columns transcolumns, " + //$NON-NLS-1$
					" turq_accounting_transactions trans" + //$NON-NLS-1$
					" where transcolumns.accounting_accounts_id=accounts.id" + //$NON-NLS-1$
					" and transcolumns.accounting_transactions_id=trans.id"; //$NON-NLS-1$
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			sqlparam += " and trans.transactions_date >= '" + dformat.format(datePickerBeginDate.getDate()) + "'" //$NON-NLS-1$ //$NON-NLS-2$
					+ " and trans.transactions_date <= '" + dformat.format(datePickerEndDate.getDate()) + "'" //$NON-NLS-1$ //$NON-NLS-2$
					+ " GROUP BY accounts.top_account)" + //$NON-NLS-1$
					" as mytab where mytab.top_account=accs.id ORDER BY mytab.top_account"; //$NON-NLS-1$
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			parameters.put("sqlparam", sqlparam); //$NON-NLS-1$
			parameters.put("beginDate", dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			parameters.put("formatter", formatter); //$NON-NLS-1$
			parameters.put("imageUrl", EngConfiguration.logoURL); //$NON-NLS-1$
			parameters.put("formatter", formatter); //$NON-NLS-1$
			EngDALConnection db = new EngDALConnection();
			db.connect();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/accounting/AccountingBalance.jasper"); //$NON-NLS-1$
			final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, db.getCon());
			JasperViewer.viewReport(jasperPrint, false);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	private void initGUI()
	{
		try
		{
			{
				this.setSize(400, 75);
			}
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(543, 194);
			{
				lblDateRange = new CLabel(this, SWT.NONE);
				lblDateRange.setText(AccLangKeys.STR_SELECT_DATE_RANGE); 
			}
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
			}
			{
				datePickerEndDate = new DatePicker(this, SWT.NONE);
			}
			{
				lblLogoURL = new CLabel(this, SWT.NONE);
				GridData lblLogoURLLData = new GridData();
				lblLogoURLLData.widthHint = 175;
				lblLogoURLLData.heightHint = 14;
				lblLogoURLLData.grabExcessHorizontalSpace = true;
				lblLogoURL.setLayoutData(lblLogoURLLData);
			}
			{
				btnIcon = new Button(this, SWT.PUSH | SWT.CENTER);
				btnIcon.setText(AccLangKeys.STR_CHOOSE_LOGO); 
				GridData btnIconLData = new GridData();
				btnIconLData.horizontalAlignment = GridData.END;
				btnIconLData.horizontalSpan = 2;
				btnIcon.setText(AccLangKeys.STR_CHOOSE_LOGO); 
				GridData btnIconLData1 = new GridData();
				btnIconLData1.widthHint = 102;
				btnIconLData1.heightHint = 30;
				btnIcon.setLayoutData(btnIconLData1);
				btnIcon.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						btnLogoSingleClick();
					}
				});
			}
			{
				btnShow = new Button(this, SWT.PUSH | SWT.CENTER);
				btnShow.setText(AccLangKeys.STR_SHOW_REPORT); 
				GridData btnShowLData = new GridData();
				btnShowLData.widthHint = 117;
				btnShowLData.heightHint = 30;
				btnShow.setLayoutData(btnShowLData);
				btnShow.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						btnShowSingleClick();
					}
				});
			}
			File file = new File(EngConfiguration.logoURL);
			if (file.exists())
				this.lblLogoURL.setText(AccLangKeys.STR_LOGO+ EngConfiguration.logoURL); //$NON-NLS-1$
			else
			{
				this.lblLogoURL.setText(AccLangKeys.STR_LOGO); //$NON-NLS-1$
				EngConfiguration.logoURL = ""; //$NON-NLS-1$
			}
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	private void btnLogoSingleClick()
	{
		FileDialog dialog = new FileDialog(this.getShell(), SWT.OK);
		dialog.setFilterNames(new String[]{"Image Files (*.jpg;*.jpeg;*.bmp;*.png)", "*.jpg;*.jpeg;*.bmp;*.png"}); //$NON-NLS-1$ //$NON-NLS-2$
		dialog.setFilterExtensions(new String[]{"*.jpg;*.jpeg;*.bmp;*.png"}); //Windows wild cards //$NON-NLS-1$
		dialog.setText(AccLangKeys.STR_LOGO); //$NON-NLS-1$
		String filepath = dialog.open();
		if (filepath != null)
		{
			EngConfiguration.logoURL = filepath;
			lblLogoURL.setText(AccLangKeys.STR_LOGO + filepath); //$NON-NLS-1$
		}
	}
}