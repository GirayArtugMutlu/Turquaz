package com.turquaz.cheque.ui;

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
 * @author Onsel
 * @version $Id$
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLUpdateChequeRoll;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class CheUIChequeCollectFromBankUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private CheUIChequeCollectFromBank compChequeRoll;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar;
	boolean isUpdated = false;
	TurqChequeRoll chequeRoll = null;

	public CheUIChequeCollectFromBankUpdate(Shell parent, int style, TurqChequeRoll chequeRoll)
	{
		super(parent, style);
		this.chequeRoll = chequeRoll;
	}

	public boolean open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(654, 509);
			//START >> toolBar
			toolBar = new ToolBar(dialogShell, SWT.NONE);
			GridData toolBarLData = new GridData();
			toolBarLData.horizontalAlignment = GridData.FILL;
			toolBarLData.grabExcessHorizontalSpace = true;
			toolBar.setLayoutData(toolBarLData);
			//START >> toolUpdate
			toolUpdate = new ToolItem(toolBar, SWT.NONE);
			toolUpdate.setText("Güncelle");
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolUpdateWidgetSelected(evt);
				}
			});
			//END << toolUpdate
			//START >> toolDelete
			toolDelete = new ToolItem(toolBar, SWT.NONE);
			toolDelete.setText("Sil");
			toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolDeleteWidgetSelected(evt);
				}
			});
			//END << toolDelete
			//START >> toolCancel
			toolCancel = new ToolItem(toolBar, SWT.NONE);
			toolCancel.setText("Kapat");
			toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
			toolCancel.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					dialogShell.close();
				}
			});
			//END << toolCancel
			//END << toolBar
			//START >> compChequeRoll
			compChequeRoll = new CheUIChequeCollectFromBank(dialogShell, SWT.NONE);
			GridData compChequeRollLData = new GridData();
			compChequeRollLData.grabExcessHorizontalSpace = true;
			compChequeRollLData.horizontalAlignment = GridData.FILL;
			compChequeRollLData.verticalAlignment = GridData.FILL;
			compChequeRollLData.grabExcessVerticalSpace = true;
			compChequeRoll.setLayoutData(compChequeRollLData);
			//END << compChequeRoll
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public void postInitGUI()
	{
		try
		{
			compChequeRoll.getToolItemAdd().setEnabled(false);
			compChequeRoll.getToolItemDelete().setEnabled(false);
			EngUICommon.centreWindow(dialogShell);
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			
			HashMap argMap = new HashMap();
			argMap.put(CheKeys.CHE_CHEQUE_ROLL,chequeRoll);
			EngTXCommon.doSingleTX(CheBLUpdateChequeRoll.class.getName(),"initializeChequeRoll",argMap);
			
			
			compChequeRoll.getTxtRollNo().setText(chequeRoll.getChequeRollNo());
			compChequeRoll.getDatePicker1().setDate(chequeRoll.getChequeRollsDate());
			TableItem item;
			Iterator it = chequeRoll.getTurqChequeChequeInRolls().iterator();
			while (it.hasNext())
			{
				TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll) it.next();
				TurqChequeCheque cheque = chequeInRoll.getTurqChequeCheque();
				item = new TableItem(compChequeRoll.getTableCheques(), SWT.NULL);
				item.setData(cheque);
				item.setText(new String[]{cheque.getChequesPortfolioNo(), DatePicker.formatter.format(cheque.getChequesDueDate()),
						cheque.getChequesPaymentPlace(), cheque.getChequesDebtor(), cf.format(cheque.getChequesAmount())});
			}
			compChequeRoll.calculateTotal();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	private void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		try
		{
			if (compChequeRoll.verifyFields())
			{
				List chequeList = new ArrayList();
				int count = compChequeRoll.getTableCheques().getItemCount();
				for (int i = 0; i < count; i++)
				{
					chequeList.add(compChequeRoll.getTableCheques().getItem(i).getData());
				}
				//	          TODO cheq trans exRate
				
				
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ROLL,chequeRoll);
				argMap.put(EngKeys.DOCUMENT_NO,compChequeRoll.getTxtRollNo().getText().trim());
				argMap.put(EngKeys.DATE,compChequeRoll.getDatePicker1().getDate());
				argMap.put(CheKeys.CHE_CHEQUE_LIST,chequeList);
				argMap.put(EngKeys.TYPE,EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK);
				argMap.put(CheKeys.CHE_SUM_TRANS,new Boolean(false));
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				
				
				EngTXCommon.doTransactionTX(CheBLUpdateChequeRoll.class.getName(),"updateChequeRollIn",argMap);
				
						EngUICommon.showMessageBox(getParent(), Messages.getString("CheUIChequeInPayroll.13"), SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getParent(), ex.getMessage(), SWT.ICON_ERROR);
		}
	}

	private void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				if (compChequeRoll.getTableCheques().getItemCount() > 0)
				{
					EngUICommon.showMessageBox(getParent(), Messages.getString("CheUIChequeOutPayrollBankUpdate.0"), SWT.ICON_WARNING); //$NON-NLS-1$
					return;
				}
				
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ROLL,chequeRoll);
				EngTXCommon.doTransactionTX(CheBLUpdateChequeRoll.class.getName(),"deleteChequeRollIn",argMap);
				
				EngUICommon.showMessageBox(getParent(), Messages.getString("CheUIChequeInPayrollUpdate.8"), SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getParent(), ex.getMessage().toString(), SWT.ICON_ERROR);
		}
	}
}