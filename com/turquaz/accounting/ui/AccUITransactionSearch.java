package com.turquaz.accounting.ui;

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
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUITransactionSearch extends Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private TableColumn tableColumnTotalAmount;
	private TableColumn tableColumnDate;
	private TableColumn tableColumnDocumentNo;
	private TableColumn tableColumnModuleName;
	private Button btnPayment;
	private Button btnCollect;
	private TableColumn tableColumnTransType;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private Button btnAccTrans;
	private Group groupTransTypes;
	private TableColumn tableColumnDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private Table tableTransactions;
	private Composite compAccTransactionSearch;
	private Calendar cal = Calendar.getInstance();
	SearchTableViewer tableViewer = null;

	public AccUITransactionSearch(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			{
				compAccTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 128;
				composite1LData.grabExcessHorizontalSpace = true;
				compAccTransactionSearch.setLayoutData(composite1LData);
				compAccTransactionSearch.setLayout(composite1Layout);
				{
					lblDocumentNo = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblDocumentNoLData = new GridData();
					lblDocumentNoLData.widthHint = 99;
					lblDocumentNoLData.heightHint = 24;
					lblDocumentNo.setLayoutData(lblDocumentNoLData);
					lblDocumentNo.setText(Messages.getString("AccUITransactionSearch.0")); //$NON-NLS-1$
					lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(99, 24));
				}
				{
					txtDocumentNo = new Text(compAccTransactionSearch, SWT.NONE);
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 150;
					txtDocumentNoLData.heightHint = 17;
					txtDocumentNoLData.horizontalSpan = 2;
					txtDocumentNo.setLayoutData(txtDocumentNoLData);
				}
				//START >> groupTransTypes
				groupTransTypes = new Group(compAccTransactionSearch, SWT.NONE);
				GridLayout groupTransTypesLayout = new GridLayout();
				GridData groupTransTypesLData = new GridData();
				groupTransTypesLData.verticalSpan = 3;
				groupTransTypesLData.widthHint = 193;
				groupTransTypesLData.heightHint = 81;
				groupTransTypesLData.grabExcessHorizontalSpace = true;
				groupTransTypesLData.horizontalAlignment = GridData.CENTER;
				groupTransTypes.setLayoutData(groupTransTypesLData);
				groupTransTypesLayout.makeColumnsEqualWidth = true;
				groupTransTypes.setLayout(groupTransTypesLayout);
				groupTransTypes.setText(Messages.getString("AccUITransactionSearch.2")); //$NON-NLS-1$
				//START >> btnAccTrans
				btnAccTrans = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnAccTrans.setText(Messages.getString("AccUITransactionSearch.12")); //$NON-NLS-1$
				btnAccTrans.setSelection(true);
				//END << btnAccTrans
				//START >> btnCollect
				btnCollect = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnCollect.setText(Messages.getString("AccUITransactionSearch.13")); //$NON-NLS-1$
				btnCollect.setSelection(true);
				//END << btnCollect
				//START >> btnPayment
				btnPayment = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnPayment.setText(Messages.getString("AccUITransactionSearch.14")); //$NON-NLS-1$
				btnPayment.setSelection(true);
				//END << btnPayment
				//END << groupTransTypes
				{
					lblStartDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(Messages.getString("AccUITransactionSearch.3")); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 156;
					dateStartDateLData.heightHint = 22;
					dateStartDateLData.horizontalSpan = 2;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.layout();
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(Messages.getString("AccUITransactionSearch.4")); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 154;
					dateEndDateLData.heightHint = 21;
					dateEndDate.setLayoutData(dateEndDateLData);
					dateEndDate.layout();
				}
				compAccTransactionSearch.layout();
			}
			tableTransactions = new Table(this, SWT.MULTI | SWT.FULL_SELECTION);
			{
				tableColumnDate = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDate.setText(Messages.getString("AccUITransactionSearch.7")); //$NON-NLS-1$
				tableColumnDate.setWidth(118);
			}
			tableColumnDocumentNo = new TableColumn(tableTransactions, SWT.NULL);
			tableColumnTransType = new TableColumn(tableTransactions, SWT.NULL);
			//START >> tableColumnModuleName
			tableColumnModuleName = new TableColumn(tableTransactions, SWT.NONE);
			tableColumnModuleName.setText(Messages.getString("AccUITransactionSearch.15")); //$NON-NLS-1$
			tableColumnModuleName.setWidth(80);
			//END << tableColumnModuleName
			{
				tableColumnDefinition = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDefinition.setText(Messages.getString("AccUITransactionSearch.5")); //$NON-NLS-1$
				tableColumnDefinition.setWidth(150);
			}
			tableColumnTotalAmount = new TableColumn(tableTransactions, SWT.RIGHT);
			this.setSize(new org.eclipse.swt.graphics.Point(646, 513));
			GridData tableTransactionsLData = new GridData();
			tableTransactionsLData.verticalAlignment = GridData.FILL;
			tableTransactionsLData.horizontalAlignment = GridData.FILL;
			tableTransactionsLData.grabExcessHorizontalSpace = true;
			tableTransactionsLData.grabExcessVerticalSpace = true;
			tableTransactions.setLayoutData(tableTransactionsLData);
			tableTransactions.setHeaderVisible(true);
			tableTransactions.setLinesVisible(true);
			tableTransactions.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableTransactionsMouseDoubleClick(evt);
				}
			});
			tableColumnTransType.setText(Messages.getString("AccUITransactionSearch.1")); //$NON-NLS-1$
			tableColumnTransType.setWidth(130);
			tableColumnDocumentNo.setText(Messages.getString("AccUITransactionSearch.0")); //$NON-NLS-1$
			tableColumnDocumentNo.setWidth(126);
			tableColumnTotalAmount.setText(Messages.getString("AccUITransactionSearch.8")); //$NON-NLS-1$
			tableColumnTotalAmount.setWidth(118);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[6];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableTransactions, columnTypes, true);
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		createTableViewer();
	}

	public void save()
	{
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		TableItem items[] = tableTransactions.getSelection();
		if (items.length > 0)
		{
			ITableRow row = (ITableRow) items[0].getData();
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) row.getDBObject();
			int status = 0;
			/* Check if it has a journal entry */
			if (accTrans.getTurqAccountingJournal().getId().intValue() != -1)
			{
				status = 1;
			}
			/*
			 * Check if it is entered from accountingmodule
			 */
			//1- Muhasebe Modulu
			else if (accTrans.getTurqModule().getId().intValue() != 1)
			{
				status = 2;
			}
			if (status == 2)
			{
				msg.setMessage(Messages.getString("AccUITransactionSearch.6")); //$NON-NLS-1$
				msg.open();
				return;
			}
			if (status == 1)
			{
				msg.setMessage(Messages.getString("AccUITransactionSearch.9")); //$NON-NLS-1$
				msg.open();
				return;
			}
			AccBLTransactionUpdate blUpdate = new AccBLTransactionUpdate();
			MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
			try
			{
				msg2.setMessage(Messages.getString("AccUITransactionSearch.10")); //$NON-NLS-1$
				int result = msg2.open();
				if (result == SWT.OK)
				{
					AccBLTransactionUpdate.initiliazeTransactionRows(accTrans);
					Iterator it = accTrans.getTurqAccountingTransactionColumns().iterator();
					while (it.hasNext())
					{
						EngBLCommon.delete(it.next());
					}
					EngBLCommon.delete(accTrans);
					msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
					msg.open();
					search();
				}
			}
			catch (Exception ex)
			{
				MessageBox msg3 = new MessageBox(this.getShell(), SWT.ICON_WARNING);
				msg3.setMessage(Messages.getString("AccUIAccountingPlan.5")); //$NON-NLS-1$
				msg3.open();
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
			}
		}
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			List result = AccBLTransactionSearch.searchAccTransaction(txtDocumentNo.getText().trim(), dateStartDate.getDate(),
					dateEndDate.getDate(), btnAccTrans.getSelection(), btnCollect.getSelection(), btnPayment.getSelection());
			int listSize = result.size();
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < listSize; i++)
			{
				TurqAccountingTransaction accTran = new TurqAccountingTransaction();
				Object[] accTransValues = (Object[]) result.get(i);
				accTran.setId((Integer) accTransValues[0]);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
				BigDecimal total = new BigDecimal(0);
				if (accTransValues[5] != null)
				{
					total = (BigDecimal) accTransValues[5];
				}
				String transDate = formatter.format(accTransValues[1]);
				tableViewer.addRow(new String[]{transDate, accTransValues[2].toString(), //doc no
						accTransValues[3].toString(), //type
						accTransValues[6].toString(),//modele name
						accTransValues[4].toString(), //definition
						cf.format(total)}, accTran); //$NON-NLS-1$ 
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void newForm()
	{
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableTransactions, Messages.getString("AccUITransactionSearch.11")); //$NON-NLS-1$
	}

	/** Auto-generated event handler method */
	protected void tableTransactionsMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem selection[] = tableTransactions.getSelection();
			if (selection.length > 0)
			{
				ITableRow row = (ITableRow) selection[0].getData();
				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) row.getDBObject();
				AccBLTransactionUpdate.initiliazeTransactionRows(accTrans);
				int type = accTrans.getTurqAccountingTransactionType().getId().intValue();
				boolean updated;
				if (type == 2)
				{
					updated = new AccUITransactionUpdateDialog(this.getShell(), SWT.NULL, accTrans).open();
					if (updated)
						search();
				}
				else if (type == 1)
				{
					updated = new AccUITransactionPaymentUpdateDialog(this.getShell(), SWT.NULL, accTrans).open();
					if (updated)
						search();
				}
				else if (type == 0)
				{
					updated = new AccUITransactionCollectUpdateDialog(this.getShell(), SWT.NULL, accTrans).open();
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableTransactions);
	}
}