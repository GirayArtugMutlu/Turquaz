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
import java.util.HashMap;
import java.util.List;
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
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
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
					lblDocumentNo.setText(AccLangKeys.STR_VOUCHER_NO); 
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
				groupTransTypes.setText(AccLangKeys.STR_VOUCHER_TYPE); 
				//START >> btnAccTrans
				btnAccTrans = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnAccTrans.setText(AccLangKeys.STR_JOURNAL_VOUCHER); 
				btnAccTrans.setSelection(true);
				//END << btnAccTrans
				//START >> btnCollect
				btnCollect = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnCollect.setText(AccLangKeys.STR_COLLECT_VOUCHER); 
				btnCollect.setSelection(true);
				//END << btnCollect
				//START >> btnPayment
				btnPayment = new Button(groupTransTypes, SWT.CHECK | SWT.LEFT);
				btnPayment.setText(AccLangKeys.STR_PAYMENT_VOUCHER); 
				btnPayment.setSelection(true);
				//END << btnPayment
				//END << groupTransTypes
				{
					lblStartDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(AccLangKeys.STR_START_DATE); 
				}
				{
					dateStartDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 157;
					dateStartDateLData.heightHint = 23;
					dateStartDateLData.horizontalSpan = 2;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.layout();
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(AccLangKeys.STR_END_DATE); 
				}
				{
					dateEndDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 157;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
					dateEndDate.layout();
				}
				compAccTransactionSearch.layout();
			}
			tableTransactions = new Table(this, SWT.MULTI | SWT.FULL_SELECTION);
			{
				tableColumnDate = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDate.setText(EngLangCommonKeys.STR_DATE);
				tableColumnDate.setWidth(118);
			}
			tableColumnDocumentNo = new TableColumn(tableTransactions, SWT.NULL);
			tableColumnTransType = new TableColumn(tableTransactions, SWT.NULL);
			//START >> tableColumnModuleName
			tableColumnModuleName = new TableColumn(tableTransactions, SWT.NONE);
			tableColumnModuleName.setText(AccLangKeys.STR_TRANSACTION_MODULE); 
			tableColumnModuleName.setWidth(80);
			//END << tableColumnModuleName
			{
				tableColumnDefinition = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); 
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
			tableColumnTransType.setText(AccLangKeys.STR_VOUCHER_TYPE); 
			tableColumnTransType.setWidth(130);
			tableColumnDocumentNo.setText(AccLangKeys.STR_DOCUMENT_NO);
			tableColumnDocumentNo.setWidth(126);
			tableColumnTotalAmount.setText(AccLangKeys.STR_TOTAL_PRICE); 
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
            EngBLLogger.log(this.getClass(),e,getShell());
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
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			TableItem items[] = tableTransactions.getSelection();
			if (items.length > 0)
			{
				ITableRow row = (ITableRow) items[0].getData();
				Integer transId = (Integer) row.getDBObject();
				TurqAccountingTransaction accTrans = new TurqAccountingTransaction();
				accTrans.setId(transId);
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION, accTrans);
				EngTXCommon.doSelectTX(AccBLTransactionUpdate.class.getName(), "initiliazeTransactionRows",
						argMap);
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
					msg.setMessage(AccLangKeys.MSG_NOT_DELETE_VOUCHER_FROM_HERE); 
					msg.open();
					return;
				}
				if (status == 1)
				{
					msg.setMessage(AccLangKeys.MSG_HAS_JOURNAL_ID_CANNOT_DELETE); 
					msg.open();
					return;
				}
				AccBLTransactionUpdate blUpdate = new AccBLTransactionUpdate();
				MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
				msg2.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY);
				int result = msg2.open();
				if (result == SWT.OK)
				{
					argMap = new HashMap();
					argMap.put(AccKeys.ACC_TRANSACTION, accTrans);
					EngTXCommon.doTransactionTX(AccBLTransactionSearch.class.getName(),
							"removeAccountingTransaction", argMap);
					msg.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS);
					msg.open();
					search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_DOCUMENT_NO,txtDocumentNo.getText().trim());
			argMap.put(AccKeys.ACC_START_DATE,dateStartDate.getDate());
			argMap.put(AccKeys.ACC_END_DATE,dateEndDate.getDate());
			argMap.put(AccKeys.ACC_IS_GENERAL,new Boolean( btnAccTrans.getSelection()));
			argMap.put(AccKeys.ACC_IS_COLLECT,new Boolean(btnCollect.getSelection()));
			argMap.put(AccKeys.ACC_IS_PAYMENT,new Boolean(btnPayment.getSelection()));
			
			
			List result = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"searchAccTransaction",argMap);
		
			
			int listSize = result.size();
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < listSize; i++)
			{
				Object[] accTransValues = (Object[]) result.get(i);
				Integer transId=(Integer) accTransValues[0];
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
						cf.format(total)}, transId); //$NON-NLS-1$ 
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableTransactions, AccLangKeys.STR_ACCOUNT_VOUCHERS); 
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
				TurqAccountingTransaction accTrans =new TurqAccountingTransaction();
				accTrans.setId((Integer) row.getDBObject());
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doSelectTX(AccBLTransactionUpdate.class.getName(),"initiliazeTransactionRows",argMap);
				
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
					updated = new AccUITransactionCollectUpdateDialog(this.getShell(), SWT.NULL, accTrans.getId()).open();
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}
}