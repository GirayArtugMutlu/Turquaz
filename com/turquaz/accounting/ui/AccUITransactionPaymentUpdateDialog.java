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
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
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
import com.turquaz.accounting.ui.AccUITransactionPayment;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

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
	private boolean updated = false;
	private HashBag transBag=null;
	private Integer transId;

	public AccUITransactionPaymentUpdateDialog(Shell parent, int style, Integer transId)
	{
		super(parent, style);
		this.transId=transId;
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
			dialogShell.setText(AccLangKeys.STR_UPDATE_PAYMENT_VOUCHER);
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
			toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); 
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
			toolDelete.setText(EngLangCommonKeys.STR_DELETE); 
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
		try
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
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_TRANS_ID, transId);
			transBag = (HashBag) EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),
					"getAccTransactionById", argMap);
			
			Integer journalId = (Integer) transBag.get(AccKeys.ACC_TRANS_JOURNAL_ID);
			Integer moduleId = (Integer) transBag.get(AccKeys.ACC_TRANS_MODULE_ID);
			String transDefinition = (String) transBag.get(AccKeys.ACC_TRANSACTION_DEFINITION);
			String transDocNo = (String) transBag.get(AccKeys.ACC_TRANSACTION_DOC_NO);
			String currencyAbbr = (String) transBag.get(EngKeys.CURRENCY_ABBR);
			Integer currencyId = (Integer) transBag.get(EngKeys.CURRENCY_ID);
			Date transDate = (Date) transBag.get(AccKeys.ACC_TRANS_DATE);
		
			
			/* Check if it has a journal entry */
			if (journalId.intValue() != -1)
			{
				toolUpdate.setEnabled(false);
				toolDelete.setEnabled(false);
			}
			/*
			 * Check if it is entered from accountingmodule
			 */
			//1- Muhasebe Modulu
			if (moduleId.intValue() != 1)
			{
				toolUpdate.setEnabled(false);
				toolDelete.setEnabled(false);
			}
			compTransactionPayment.getTxtDocumentNo().setText(transDocNo);
			compTransactionPayment.getTxtDefinition().setText(transDefinition);
			compTransactionPayment.getComboCurrencyType().setText(currencyAbbr);
			Date date = new Date(transDate.getTime());
			compTransactionPayment.getDatePickerTransactionDate().setDate(date);
			fillTableAndCombo();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void fillTableAndCombo()
	{
		compTransactionPayment.tableViewer.removeAll();

		HashMap rowList=(HashMap)transBag.get(AccKeys.ACC_TRANSACTION_ROWS);
		
		TableItem item;
		for (int k = 0; k < rowList.size(); k++)
		{
			HashMap transRow = (HashMap)rowList.get(new Integer(k));
			
			if (((BigDecimal)transRow.get(EngKeys.DEPT_AMOUNT)).doubleValue()>0)
			{ 
				ITableRow row = new AccUITransactionPaymentTableRow(compTransactionPayment.tableViewer.getRowList());
				row.setDBObject(transRow);
				compTransactionPayment.tableViewer.addRow(row);
			}
			else
			{
				HashMap accountMap=(HashMap)transRow.get(AccKeys.ACC_ACCOUNT);
				
				compTransactionPayment.getComboCreditor().setText((String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE));
				compTransactionPayment.getComboCreditor().setDataMap(accountMap);
			}
		
		}

		//	 add last empty row
		AccUITransactionPaymentTableRow row2 = new AccUITransactionPaymentTableRow(compTransactionPayment.tableViewer.getRowList());
		compTransactionPayment.tableViewer.addRow(row2);
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		try
		{
			if (compTransactionPayment.verifyFields())
			{
				updated = true;
			
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_ID,transId);
				argMap.put(AccKeys.ACC_DOCUMENT_NO,compTransactionPayment.getTxtDocumentNo().getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, compTransactionPayment.getDatePickerTransactionDate().getDate());
				argMap.put(AccKeys.ACC_DEFINITION,compTransactionPayment.getTxtDefinition().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(AccKeys.ACC_TRANSACTIONS,compTransactionPayment.getTransactionColumns());
				
				EngTXCommon.doTransactionTX(AccBLTransactionUpdate.class.getName(),"updateTransaction",argMap);			
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
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
		boolean okToDelete=EngUICommon.okToDelete(getParent());
		if (okToDelete)
		{
			try
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_ID,transId);
				EngTXCommon.doTransactionTX(AccBLTransactionSearch.class.getName(),"removeAccountingTransaction",argMap);
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				this.dialogShell.dispose();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getParent());
			}
		}
	}
}