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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.widgets.Composite;

public class AccUIAccountingJournal extends org.eclipse.swt.widgets.Composite
{
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblDummy;
	private Button btnReports;
	private Calendar cal = Calendar.getInstance();
	private ViewerComposite viewer;
	private Button checkApproved;
	private Composite compViewer;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AccUIAccountingJournal inst = new AccUIAccountingJournal(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AccUIAccountingJournal(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			this.setSize(513, 331);
			lblDateRange = new CLabel(this, SWT.NONE);
			lblDateRange.setText(AccLangKeys.STR_SELECT_DATE_RANGE); 
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
				GridData datePickerBeginDateLData = new GridData();
				datePickerBeginDateLData.widthHint = 157;
				datePickerBeginDateLData.heightHint = 22;
				datePickerBeginDate.setLayoutData(datePickerBeginDateLData);
				//datePickerBeginDate.setDate(new Date(cal.getTime().getYear(),0,1));
				cal.set(cal.get(Calendar.YEAR), 0, 1);
				datePickerBeginDate.setDate(cal.getTime());
			}
			datePickerEndDate = new DatePicker(this, SWT.NONE);
			GridData datePickerEndDateLData = new GridData();
			datePickerEndDateLData.widthHint = 157;
			datePickerEndDateLData.heightHint = 22;
			datePickerEndDate.setLayoutData(datePickerEndDateLData);
			{
				lblDummy = new CLabel(this, SWT.NONE);
			}
			{
				checkApproved = new Button(this, SWT.CHECK | SWT.LEFT);
				checkApproved.setText(AccLangKeys.STR_SHOW_ONLY_APPROVED); 
			}
			{
				btnReports = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnReportsLData = new GridData();
				btnReportsLData.widthHint = 157;
				btnReportsLData.heightHint = 23;
				btnReportsLData.verticalAlignment = GridData.BEGINNING;
				btnReports.setText(AccLangKeys.STR_SHOW_REPORT); 
				btnReports.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						btnReportsSingleClick();
					}
				});
				btnReports.setLayoutData(btnReportsLData);
			}
			{
				compViewer = new Composite(this, SWT.NONE);
				GridLayout compViewerLayout = new GridLayout();
				GridData compViewerLData = new GridData();
				compViewerLData.grabExcessHorizontalSpace = true;
				compViewerLData.grabExcessVerticalSpace = true;
				compViewerLData.horizontalAlignment = GridData.FILL;
				compViewerLData.verticalAlignment = GridData.FILL;
				compViewerLData.horizontalSpan = 3;
				compViewer.setLayoutData(compViewerLData);
				compViewerLayout.makeColumnsEqualWidth = true;
				compViewer.setLayout(compViewerLayout);
				{
					viewer = new ViewerComposite(compViewer, SWT.NONE);
					GridData viewerLData = new GridData();
					viewerLData.horizontalAlignment = GridData.FILL;
					viewerLData.verticalAlignment = GridData.FILL;
					viewerLData.grabExcessVerticalSpace = true;
					viewerLData.grabExcessHorizontalSpace = true;
					viewerLData.horizontalSpan = 3;
					viewer.setLayoutData(viewerLData);
				}
			}
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	private void btnReportsSingleClick()
	{
		try
		{
 
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.DATE_START,datePickerBeginDate.getDate());
			argMap.put(EngKeys.DATE_END,datePickerEndDate.getDate());
			argMap.put(AccKeys.ACC_APPROVED,new Boolean(checkApproved.getSelection()));
			

			HashBag bag=(HashBag)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getAccountingJournal",argMap);
			List list=(List)bag.get(AccKeys.ACC_TRANSACTIONS);
			
			
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy"); 
			
			Map parameters = new HashMap();
			
			parameters.put("ReportTitle",AccLangKeys.STR_JOURNAL);
			parameters.put("beginDate", dformat2.format(datePickerBeginDate.getDate()));
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); 
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); 
			parameters.put("column1header", AccLangKeys.STR_DEBIT); 
			parameters.put("column2header", AccLangKeys.STR_CREDIT); 
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", new TurkishCurrencyFormat()); 
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
			String[] fields = new String[]{"accounting_transactions_id",
					"accounting_transaction_columns_id",
					"accounting_journal_id",
					"transactions_date",
					"transaction_document_no",
					"rows_dept_in_base_currency",
					"rows_credit_in_base_currency",
					"account_name",
					"account_code",
					"transaction_definition"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/accounting/AccountingJournal.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}