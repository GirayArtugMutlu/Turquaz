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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private AccUITransactionAdd compTransactionAdd;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private Shell dialogShell;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();
	private boolean updated = false;
	private TurqAccountingTransaction accTrans;

	public AccUITransactionUpdateDialog(Shell parent, int style, TurqAccountingTransaction trans)
	{
		super(parent, style);
		this.accTrans = trans;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public boolean open()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(Messages.getString("AccUITransactionUpdateDialog.9")); //$NON-NLS-1$
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1.setLayoutData(toolBar1LData);
			}
			{
				compTransactionAdd = new AccUITransactionAdd(dialogShell, SWT.NONE);
				GridData compTransactionAddLData = new GridData();
				compTransactionAddLData.grabExcessHorizontalSpace = true;
				compTransactionAddLData.horizontalAlignment = GridData.FILL;
				compTransactionAddLData.grabExcessVerticalSpace = true;
				compTransactionAddLData.verticalAlignment = GridData.FILL;
				compTransactionAdd.setLayoutData(compTransactionAddLData);
				compTransactionAdd.getTxtDocumentNo().setBounds(80, 5, 150, 17);
				compTransactionAdd.layout();
			}
			dialogShell.setSize(667, 479);
			{
				toolUpdate = new ToolItem(toolBar1, SWT.NONE);
				toolUpdate.setText(Messages.getString("AccUITransactionUpdateDialog.0")); //$NON-NLS-1$
				toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
				toolUpdate.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						toolUpdateWidgetSelected(evt);
					}
				});
			}
			{
				toolDelete = new ToolItem(toolBar1, SWT.NONE);
				toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
				toolDelete.setText("&Fi\u015fi Sil");
				toolDelete.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						toolDeleteWidgetSelected(evt);
					}
				});
			}
			{
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(Messages.getString("AccUITransactionUpdateDialog.8")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						dialogShell.close();
					}
				});
			}
			{
				toolPrint = new ToolItem(toolBar1, SWT.NONE);
				toolPrint.setText(Messages.getString("AccUITransactionUpdateDialog.6")); //$NON-NLS-1$
				toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
				toolPrint.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						dialogShell.close();
						EngBLUtils.PrintTransaction(accTrans);
					}
				});
			}
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}

	public void showDialog(TurqAccountingTransaction accTrans)
	{
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		if (EngBLPermissions.getPermission(compTransactionAdd.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compTransactionAdd.getClass().getName()) == 3)
		{
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}
		/* Check if it has a journal entry */
		if (accTrans.getTurqAccountingJournal().getId().intValue() != -1)
		{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
		}
		try
		{
			/*
			 * Check if it is entered from accountingmodule
			 */
			//1- Muhasebe Modulu
			if (accTrans.getTurqModule().getId().intValue() != 1)
			{
				toolUpdate.setEnabled(false);
				toolDelete.setEnabled(false);
			}
			compTransactionAdd.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
			compTransactionAdd.getTxtTransDefinition().setText(accTrans.getTransactionDescription());
			compTransactionAdd.getComboCurrencyType().setText(
					accTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			Date date = new Date(accTrans.getTransactionsDate().getTime());
			compTransactionAdd.getDateTransactionDate().setDate(date);
			fillTable();
			compTransactionAdd.calculateTotalDeptAndCredit();
			Integer trModule = accTrans.getTurqModule().getId();
			if (trModule.intValue() != 1)
			{ //1=Transaction, only view is allowed for other modules..
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void fillTable()
	{
		compTransactionAdd.tableViewer.removeAll();
		Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
		List transRows = new ArrayList();
		transRows.addAll(transactionRows);
		Collections.sort(transRows, new EngBLHibernateComparer());
		TurqAccountingTransactionColumn transRow;
		TableItem item;
		for (int k = 0; k < transRows.size(); k++)
		{
			transRow = (TurqAccountingTransactionColumn) transRows.get(k);
			ITableRow row = new AccUITransactionAddTableRow(compTransactionAdd.tableViewer.getRowList());
			row.setDBObject(transRow);
			compTransactionAdd.tableViewer.addRow(row);
		}
		// add last empty row
		AccUITransactionAddTableRow row2 = new AccUITransactionAddTableRow(compTransactionAdd.tableViewer.getRowList());
		compTransactionAdd.tableViewer.addRow(row2);
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		try
		{
			if (compTransactionAdd.verifyFields())
			{
				updated = true;
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				compTransactionAdd.prepareAccountingMaps(creditAccounts, deptAccounts);
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				argMap.put(AccKeys.ACC_DOCUMENT_NO,compTransactionAdd.getTxtDocumentNo().getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, compTransactionAdd.getDateTransactionDate().getDate());
				argMap.put(AccKeys.ACC_DEFINITION,compTransactionAdd.getTxtTransDefinition().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(AccKeys.ACC_DEPT_ACCOUNT_MAP,deptAccounts);
				argMap.put(AccKeys.ACC_CREDIT_ACCOUNT_MAP,creditAccounts);
				argMap.put(AccKeys.ACC_SUM_ROWS,new Boolean(false));
				
				EngTXCommon.doTransactionTX(AccBLTransactionUpdate.class.getName(),"updateTransaction",argMap);
				
				
				msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.2")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.3")); //$NON-NLS-1$
			msg.open();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.YES | SWT.NO);
		msg2.setMessage(Messages.getString("AccUITransactionUpdateDialog.4")); //$NON-NLS-1$
		int answer = msg2.open();
		if (answer == SWT.YES)
		{
			try
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doTransactionTX(AccBLTransactionSearch.class.getName(),"removeAccountingTransaction",argMap);
				
				msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.5")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.dispose();
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
				msg.setMessage(Messages.getString("AccUITransactionUpdateDialog.3")); //$NON-NLS-1$
				msg.open();
			}
		}
	}
}