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
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
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
import com.turquaz.accounting.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
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
			lblDateRange.setText(Messages.getString("AccUIAccountingJournal.0")); //$NON-NLS-1$
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
				checkApproved.setText(Messages.getString("AccUIAccountingJournal.4")); //$NON-NLS-1$
			}
			{
				btnReports = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnReportsLData = new GridData();
				btnReportsLData.widthHint = 157;
				btnReportsLData.heightHint = 23;
				btnReportsLData.verticalAlignment = GridData.BEGINNING;
				btnReports.setText(Messages.getString("AccUIAccountingJournal.1")); //$NON-NLS-1$
				btnReports.addMouseListener(new MouseAdapter()
				{
					public void mouseDown(MouseEvent evt)
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
			e.printStackTrace();
		}
	}

	private void btnReportsSingleClick()
	{
		try
		{
			Map parameters = new HashMap();
			parameters.put(Messages.getString("AccUIAccountingJournal.2"), Messages.getString("AccUIAccountingJournal.3")); //$NON-NLS-1$ //$NON-NLS-2$
			//TODO should select all columns
			String sqlparam = "Select trans.id as accounting_transactions_id, transcolumns.id as accounting_transaction_columns_id,"
					+ " trans.*," + " transcolumns.*," + " accounts.*" + " from turq_accounting_transactions trans," + //$NON-NLS-1$
					"turq_accounting_transaction_columns transcolumns," + //$NON-NLS-1$
					"turq_accounting_accounts accounts where " + //$NON-NLS-1$
					"trans.id=transcolumns.accounting_transactions_id" + //$NON-NLS-1$
					" and transcolumns.accounting_accounts_id=accounts.id"; //$NON-NLS-1$
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			sqlparam += " and trans.transactions_date >= '" + dformat.format(datePickerBeginDate.getDate()) + "'" //$NON-NLS-1$ //$NON-NLS-2$
					+ " and trans.transactions_date <= '" + dformat.format(datePickerEndDate.getDate()) + "'"; //$NON-NLS-1$ //$NON-NLS-2$
			if (checkApproved.getSelection())
				sqlparam += " and trans.accounting_journal_id > 0"; //$NON-NLS-1$
			sqlparam += " ORDER BY trans.accounting_journal_id"; //$NON-NLS-1$
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			parameters.put("sqlparam", sqlparam); //$NON-NLS-1$
			parameters.put("beginDate", dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			parameters.put("column1header", Messages.getString("AccUIAccountingJournal.22")); //$NON-NLS-1$ //$NON-NLS-2$
			parameters.put("column2header", Messages.getString("AccUIAccountingJournal.24")); //$NON-NLS-1$ //$NON-NLS-2$
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", new TurkishCurrencyFormat()); //$NON-NLS-1$
			EngDALConnection db = new EngDALConnection();
			db.connect();
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/accounting/AccountingJournal.jasper"); //$NON-NLS-1$
			final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, db.getCon());
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}