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
import java.util.Set;
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
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionCollect;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

public class AccUITransactionCollectUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private TurqAccountingTransaction accTrans;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	private AccUITransactionCollect compTransactionCollect;
	private boolean updated = false;

	public AccUITransactionCollectUpdateDialog(Shell parent, int style, TurqAccountingTransaction trans)
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
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(getText());
			dialogShell.setSize(636, 433);
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass()
					.getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setText(EngLangCommonKeys.STR_UPDATE); 
			dialogShell.setLayout(dialogShellLayout);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setSize(142, 49);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(142, 49));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(142, 49));
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setEnabled(false);
							toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); 
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
							toolDelete.setEnabled(false);
							toolDelete.setText(EngLangCommonKeys.STR_DELETE); 
							toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
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
							toolCancel.setText(EngLangCommonKeys.STR_CANCEL); 
							toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
							toolCancel.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									dialogShell.close();
								}
							});
						}
					}
				}
			}
			{
				compTransactionCollect = new AccUITransactionCollect(dialogShell, SWT.NONE);
				GridData compTransactionCollectLData = new GridData();
				compTransactionCollectLData.verticalAlignment = GridData.FILL;
				compTransactionCollectLData.horizontalAlignment = GridData.FILL;
				compTransactionCollectLData.grabExcessHorizontalSpace = true;
				compTransactionCollectLData.grabExcessVerticalSpace = true;
				compTransactionCollect.setLayoutData(compTransactionCollectLData);
				compTransactionCollect.getTxtTransDefinition().setBounds(353, 33, 260, 17);
				compTransactionCollect.getDatePickerTransactionDate().setBounds(353, 5, 150, 22);
				compTransactionCollect.getComboDeptor().setBounds(115, 35, 150, 17);
				compTransactionCollect.getTxtDocumentNo().setBounds(115, 5, 150, 17);
				compTransactionCollect.layout();
			}
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 574, 434);
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
            EngBLLogger.log(this.getClass(),e,getParent());
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
		if (EngBLPermissions.getPermission(compTransactionCollect.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compTransactionCollect.getClass().getName()) == 3)
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
		compTransactionCollect.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
		compTransactionCollect.getComboCurrencyType().setText(
				accTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		Date date = new Date(accTrans.getTransactionsDate().getTime());
		compTransactionCollect.getDatePickerTransactionDate().setDate(date);
		;
		fillTableAndCombo();
		Integer trModule = accTrans.getTurqModule().getId();
		if (trModule.intValue() != 1)
		{ //1=Transaction, only view is allowed for other modules..
		}
	}

	public void fillTableAndCombo()
	{
		compTransactionCollect.tableViewer.removeAll();
		Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
		List transRows = new ArrayList();
		transRows.addAll(transactionRows);
		Collections.sort(transRows, new EngBLHibernateComparer());
		TurqAccountingTransactionColumn transRow;
		TableItem item;
		for (int k = 0; k < transRows.size(); k++)
		{
			transRow = (TurqAccountingTransactionColumn) transRows.get(k);
			if (transRow.getCreditAmount().doubleValue()>0) { //$NON-NLS-1$
				ITableRow row = new AccUITransactionCollectTableRow(compTransactionCollect.tableViewer.getRowList());
				row.setDBObject(transRow);
				compTransactionCollect.tableViewer.addRow(row);
			}
			else
			{
				compTransactionCollect.getComboDeptor().setText(transRow.getTurqAccountingAccount().getAccountCode()); //$NON-NLS-1$
				compTransactionCollect.getComboDeptor().setData(transRow.getTurqAccountingAccount());
			}
		}
		//	 add last empty row
		AccUITransactionCollectTableRow row2 = new AccUITransactionCollectTableRow(compTransactionCollect.tableViewer.getRowList());
		compTransactionCollect.tableViewer.addRow(row2);
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		try
		{
			if (compTransactionCollect.verifyFields())
			{
				updated = true;			
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				argMap.put(AccKeys.ACC_DOCUMENT_NO,compTransactionCollect.getTxtDocumentNo().getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, compTransactionCollect.getDatePickerTransactionDate().getDate());
				argMap.put(AccKeys.ACC_DEFINITION,compTransactionCollect.getTxtTransDefinition().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(AccKeys.ACC_TRANSACTIONS,compTransactionCollect.getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionUpdate.class.getName(),"updateTransaction",argMap);			
				
				msg.setMessage(EngLangCommonKeys.MSG_UPDATED_SUCCESS); 
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.YES | SWT.NO);
		msg2.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); 
		int answer = msg2.open();
		if (answer == SWT.YES)
		{
			try
			{
				updated = true;
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doTransactionTX(AccBLTransactionSearch.class.getName(),"removeAccountingTransaction",argMap);
				
				
				msg.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); 
				msg.open();
				this.dialogShell.dispose();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getParent());
			}
		}
	}
}