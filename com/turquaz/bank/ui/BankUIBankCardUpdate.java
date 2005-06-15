package com.turquaz.bank.ui;

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
 * @author  Ceday
 * @version  $Id$
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import com.turquaz.admin.AdmKeys;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.bank.bl.BankBLBankCardUpdate;
import com.turquaz.bank.ui.BankUIBankCardAdd;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.lang.BankLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.CoolItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.CoolBar;
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
public class BankUIBankCardUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Integer bankCardId;
	private ToolItem toolCancel;
	private BankUIBankCardAdd compBankCard;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private boolean updated = false;

	public BankUIBankCardUpdate(Shell parent, int style, Integer bankId)
	{
		super(parent, style);
		bankCardId = bankId;
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
			dialogShell.setSize(487, 229);
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass()
					.getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setText(BankLangKeys.TITLE_BANK_CARD_UPDATE);
			dialogShell.setLayout(dialogShellLayout);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(100, 48));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(100, 48));
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setEnabled(true);
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
				compBankCard = new BankUIBankCardAdd(dialogShell, SWT.NONE);
				compBankCard.setSize(new org.eclipse.swt.graphics.Point(476, 155));
				GridData compBankCardLData = new GridData();
				compBankCardLData.verticalAlignment = GridData.FILL;
				compBankCardLData.horizontalAlignment = GridData.FILL;
				compBankCardLData.grabExcessHorizontalSpace = true;
				compBankCardLData.grabExcessVerticalSpace = true;
				compBankCard.setLayoutData(compBankCardLData);
				compBankCard.getComboCurrency().setSize(232, 21);
				compBankCard.getTxtBankAccountNo().setSize(248, 21);
				compBankCard.getTxtBankBranchName().setSize(248, 21);
				compBankCard.getComboCurrency().setLocation(new org.eclipse.swt.graphics.Point(105, 8));
				compBankCard.getTxtBankAccountNo().setLocation(new org.eclipse.swt.graphics.Point(105, 8));
				compBankCard.getTxtBankBranchName().setLocation(new org.eclipse.swt.graphics.Point(105, 8));
				compBankCard.getTxtBankName().setBounds(105, 5, 254, 21);
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 486, 208);
			dialogShell.setSize(523, 338);
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
			EngUICommon.centreWindow(dialogShell);
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			if (EngBLPermissions.getPermission(compBankCard.getClass().getName()) == 2)
			{
				toolUpdate.setEnabled(true);
			}
			else if (EngBLPermissions.getPermission(compBankCard.getClass().getName()) == 3)
			{
				toolDelete.setEnabled(true);
				toolUpdate.setEnabled(true);
			}
			
			HashMap argMap = new HashMap();
			argMap.put(BankKeys.BANK_ID,bankCardId);
			HashBag bankBag = (HashBag)EngTXCommon.doSelectTX(BankBLBankCardSearch.class.getName(),"initializeBankCardById",argMap);
			
			
			compBankCard.getTxtBankName().setText(bankBag.get(BankKeys.BANK_NAME).toString());
			compBankCard.getTxtBankBranchName().setText(bankBag.get(BankKeys.BANK_BRANCH_NAME).toString());
			compBankCard.getTxtBankAccountNo().setText(bankBag.get(BankKeys.BANK_ACCOUNT_NO).toString());
			compBankCard.getTxtDefinition().setText(bankBag.get(BankKeys.BANK_DEFINITION).toString());
			compBankCard.getTxtBankCode().setText(bankBag.get(BankKeys.BANK_CODE).toString());
			FillCurrencyCombo(bankBag.get(AdmKeys.ADM_CURRENCY_ABBR).toString());
			
			HashMap accountMap = (HashMap)bankBag.get(BankKeys.BANK_ACCOUNTING_ACCOUNTS);
			Iterator it = accountMap.keySet().iterator();
			Map fieldMap = compBankCard.getAccountingFields();
			while (it.hasNext())
			{
				Integer type = (Integer) it.next();				
				AccountPickerLeaf picker = (AccountPickerLeaf) fieldMap.get(type);
				picker.setData(accountMap.get(type));
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	private void FillCurrencyCombo(String currenyAbbr) throws Exception
	{
		try
		{
			CCombo comboCurrency = compBankCard.getComboCurrency();
			comboCurrency.removeAll();
			List currencies = (List)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getCurrencies",null);
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(), currency);
			}
			comboCurrency.setText(currenyAbbr);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/** Auto-generated event handler method */
	private void update()
	{
		try
		{
			updated = true;
			
			HashMap argMap=new HashMap();
			
			argMap.put(BankKeys.BANK_ID,bankCardId);
			argMap.put(BankKeys.BANK_NAME,compBankCard.getTxtBankName().getText().trim());
			argMap.put(BankKeys.BANK_BRANCH_NAME,compBankCard.getTxtBankBranchName().getText().trim());
			argMap.put(BankKeys.BANK_ACCOUNT_NO,compBankCard.getTxtBankAccountNo().getText().trim());
			argMap.put(BankKeys.BANK_CURRENCY,compBankCard.getComboCurrency().getData(compBankCard.getComboCurrency().getText()));
			argMap.put(BankKeys.BANK_DEFINITION,compBankCard.getTxtDefinition().getText().trim());
			argMap.put(BankKeys.BANK_CODE,compBankCard.getTxtBankCode().getText().trim());
			argMap.put(BankKeys.BANK_ACCOUNTING_ACCOUNTS,compBankCard.createAccountingMap());
			
			EngTXCommon.doTransactionTX(BankBLBankCardUpdate.class.getName(),"updateBankCard",argMap);
			EngUICommon.showUpdatedSuccesfullyMessage(getParent());
			this.dialogShell.close();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		update();
	}

	private void delete()
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				HashMap argMap=new HashMap();
				argMap.put(BankKeys.BANK_ID,bankCardId);
				
				HashBag returnValue=(HashBag)EngTXCommon.doSelectTX(BankBLBankCardUpdate.class.getName(),"hasTransaction",argMap);
				Boolean hasTx = (Boolean)returnValue.get(BankKeys.BANK_HAS_TRANSACTIONS);
			
				if (!hasTx.booleanValue())
				{
					updated = true;
					EngTXCommon.doTransactionTX(BankBLBankCardUpdate.class.getName(),"deleteBankCard",argMap);
					this.dialogShell.close();
				}
				else
				{
					EngUICommon.showMessageBox(getParent(),BankLangKeys.MSG_HAS_TRANS_CAN_NOT_DELETE,SWT.ICON_INFORMATION);
				}
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
		delete();
	}
}