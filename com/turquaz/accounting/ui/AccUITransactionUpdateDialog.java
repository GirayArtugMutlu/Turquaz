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

import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

public class AccUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private AccUITransactionAdd compTransactionAdd;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private Shell dialogShell;
	private boolean updated = false;
	private Integer transId;
	private HashBag transBag=null;

	public AccUITransactionUpdateDialog(Shell parent, int style, Integer transId)
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
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(AccLangKeys.STR_UPDATE_ACCOUNT_VOUCHER); 
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
				toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
				toolDelete.setText(EngLangCommonKeys.STR_DELETE);
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
				toolCancel.setText(EngLangCommonKeys.STR_CANCEL); //$NON-NLS-1$
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
				toolPrint.setText(EngLangCommonKeys.STR_PRINT); //$NON-NLS-1$
				toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
				toolPrint.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						try
						{
							dialogShell.close();
							HashMap argMap=new HashMap();
							argMap.put(AccKeys.ACC_TRANS_ID,transId);
							EngTXCommon.doSelectTX(EngBLUtils.class.getName(),"PrintTransaction",argMap);
							
						}
						catch(Exception ex)
						{
                            EngBLLogger.log(this.getClass(),ex,getParent());
						}
						
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
            EngBLLogger.log(this.getClass(),e,getParent());
			return true;
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
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
			compTransactionAdd.getTxtDocumentNo().setText(transDocNo);
			compTransactionAdd.getTxtTransDefinition().setText(transDefinition);
			compTransactionAdd.getComboCurrencyType().setText(currencyAbbr);
			
			Date date = new Date(transDate.getTime());
			compTransactionAdd.getDateTransactionDate().setDate(date);
			fillTable();
			compTransactionAdd.calculateTotalDeptAndCredit();
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getParent());
		}
	}

	public void fillTable()
	{
		compTransactionAdd.tableViewer.removeAll();

		HashMap rowList=(HashMap)transBag.get(AccKeys.ACC_TRANSACTION_ROWS);
		
		TableItem item;
		for (int k = 0; k < rowList.size(); k++)
		{
			HashMap transRow = (HashMap)rowList.get(new Integer(k));
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
		try
		{
			if (compTransactionAdd.verifyFields())
			{
				updated = true;
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANS_ID,transId);
				argMap.put(AccKeys.ACC_DOCUMENT_NO,compTransactionAdd.getTxtDocumentNo().getText().trim());
				argMap.put(AccKeys.ACC_TRANS_DATE, compTransactionAdd.getDateTransactionDate().getDate());
				argMap.put(AccKeys.ACC_DEFINITION,compTransactionAdd.getTxtTransDefinition().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(AccKeys.ACC_TRANSACTIONS,compTransactionAdd.getTransactionColumns());
				
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