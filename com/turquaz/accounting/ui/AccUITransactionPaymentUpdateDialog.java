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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
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
public class AccUITransactionPaymentUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private AccUITransactionPayment compTransactionPayment;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	private TurqAccountingTransaction accTrans;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();
	private boolean updated = false;

	public AccUITransactionPaymentUpdateDialog(Shell parent, int style, TurqAccountingTransaction trans)
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
			dialogShell.setText(Messages.getString("AccUITransactionPaymentUpdateDialog.1")); //$NON-NLS-1$
			coolBar1 = new CoolBar(dialogShell, SWT.NULL);
			coolItem1 = new CoolItem(coolBar1, SWT.NULL);
			toolBar1 = new ToolBar(coolBar1, SWT.NULL);
			toolUpdate = new ToolItem(toolBar1, SWT.NULL);
			toolDelete = new ToolItem(toolBar1, SWT.NULL);
			compTransactionPayment = new AccUITransactionPayment(dialogShell, SWT.NULL);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(611, 406));
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = true;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
			coolItem1.setControl(toolBar1);
			coolItem1.setSize(42, 52);
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(42, 52));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(42, 52));
			toolUpdate.setText(Messages.getString("AccUITransactionPaymentUpdateDialog.0")); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolUpdateWidgetSelected(evt);
				}
			});
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass()
					.getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			toolDelete.setText(Messages.getString("AccUITransactionPaymentUpdateDialog.2")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(Messages.getString("AccUITransactionPaymentUpdateDialog.3")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						dialogShell.close();
					}
				});
			}
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolDeleteWidgetSelected(evt);
				}
			});
			GridData compTransactionPaymentLData = new GridData();
			compTransactionPaymentLData.verticalAlignment = GridData.FILL;
			compTransactionPaymentLData.horizontalAlignment = GridData.FILL;
			compTransactionPaymentLData.widthHint = -1;
			compTransactionPaymentLData.heightHint = -1;
			compTransactionPaymentLData.horizontalIndent = 0;
			compTransactionPaymentLData.horizontalSpan = 1;
			compTransactionPaymentLData.verticalSpan = 1;
			compTransactionPaymentLData.grabExcessHorizontalSpace = true;
			compTransactionPaymentLData.grabExcessVerticalSpace = true;
			compTransactionPayment.setLayoutData(compTransactionPaymentLData);
			compTransactionPayment.setSize(new org.eclipse.swt.graphics.Point(601, 353));
			compTransactionPayment.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
					toolDeleteýmage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 611, 406);
			dialogShell.setSize(bounds.width, bounds.height);
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

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		if (EngBLPermissions.getPermission(compTransactionPayment.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compTransactionPayment.getClass().getName()) == 3)
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
		/*
		 * Check if it is entered from accountingmodule
		 */
		//1- Muhasebe Modulu
		if (accTrans.getTurqModule().getId().intValue() != 1)
		{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
		}
		compTransactionPayment.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
		compTransactionPayment.getTxtDefinition().setText(accTrans.getTransactionDescription());
		compTransactionPayment.getComboCurrencyType().setText(
				accTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		Date date = new Date(accTrans.getTransactionsDate().getTime());
		compTransactionPayment.getDatePickerTransactionDate().setDate(date);
		fillTableAndCombo();
		Integer trModule = accTrans.getTurqModule().getId();
		if (trModule.intValue() != 1)
		{ //1=Transaction, only view is allowed for other modules..
		}
	}

	public void fillTableAndCombo()
	{
		compTransactionPayment.tableViewer.removeAll();
		Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
		List transRows = new ArrayList();
		transRows.addAll(transactionRows);
		Collections.sort(transRows, new EngBLHibernateComparer());
		TurqAccountingTransactionColumn transRow;
		TableItem item;
		for (int k = 0; k < transRows.size(); k++)
		{
			transRow = (TurqAccountingTransactionColumn) transRows.get(k);
			if (!transRow.getDeptAmount().toString().equals("0")) { //$NON-NLS-1$
				ITableRow row = new AccUITransactionPaymentTableRow(compTransactionPayment.tableViewer.getRowList());
				row.setDBObject(transRow);
				compTransactionPayment.tableViewer.addRow(row);
			}
			else
			{
				compTransactionPayment.getComboCreditor().setText(transRow.getTurqAccountingAccount().getAccountCode()); //$NON-NLS-1$
				compTransactionPayment.getComboCreditor().setData(transRow.getTurqAccountingAccount()); //$NON-NLS-1$
			}
		}
		//	 add last empty row
		AccUITransactionPaymentTableRow row2 = new AccUITransactionPaymentTableRow(compTransactionPayment.tableViewer.getRowList());
		compTransactionPayment.tableViewer.addRow(row2);
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		try
		{
			if (compTransactionPayment.verifyFields())
			{
				updated = true;
				Map creditAccounts = new HashMap();
				Map deptAccounts = new HashMap();
				compTransactionPayment.prepareAccountingMaps(creditAccounts, deptAccounts);
				AccBLTransactionUpdate.updateTransaction(accTrans, compTransactionPayment.getTxtDocumentNo().getText().trim(),
						compTransactionPayment.getDatePickerTransactionDate().getData(), compTransactionPayment.getTxtDefinition()
								.getText().trim(), compTransactionPayment.getExchangeRate(), creditAccounts, deptAccounts, false);
				msg.setMessage(Messages.getString("AccUITransactionPaymentUpdateDialog.6")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg.setMessage(Messages.getString("AccUITransactionPaymentUpdateDialog.7")); //$NON-NLS-1$
			msg.open();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.YES | SWT.NO);
		msg2.setMessage(Messages.getString("AccUITransactionPaymentUpdateDialog.8")); //$NON-NLS-1$
		int answer = msg2.open();
		if (answer == SWT.YES)
		{
			try
			{
				updated = true;
				AccBLTransactionSearch.removeAccountingTransaction(accTrans);
				msg.setMessage(Messages.getString("AccUITransactionPaymentUpdateDialog.9")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.dispose();
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
				msg.setMessage(Messages.getString("AccUITransactionPaymentUpdateDialog.10")); //$NON-NLS-1$
				msg.open();
			}
		}
	}
}