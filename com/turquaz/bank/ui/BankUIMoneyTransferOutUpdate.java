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
 * @author  Onsel
 * @version  $Id$
 */
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIMoneyTransferOutUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUIMoneyTransferOut compMoneyTransferIn;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private TurqBanksTransactionBill transBill;
	boolean isUpdated = false;

	public BankUIMoneyTransferOutUpdate(Shell parent, int style, TurqBanksTransactionBill transBill)
	{
		super(parent, style);
		this.transBill = transBill;
	}

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
			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setText(Messages.getString("BankUIMoneyTransferOutUpdate.0")); //$NON-NLS-1$
			dialogShell.setSize(526, 296);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.setText(Messages.getString("BankUIMoneyTransferOutUpdate.1")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							update();
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar1, SWT.NONE);
					toolDelete.setText(Messages.getString("BankUIMoneyTransferOutUpdate.2")); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("BankUIMoneyTransferOutUpdate.4")); //$NON-NLS-1$
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
			{
				compMoneyTransferIn = new BankUIMoneyTransferOut(dialogShell, SWT.NONE);
				GridData compMoneyTransferInLData = new GridData();
				compMoneyTransferInLData.grabExcessHorizontalSpace = true;
				compMoneyTransferInLData.horizontalAlignment = GridData.FILL;
				compMoneyTransferInLData.verticalAlignment = GridData.FILL;
				compMoneyTransferInLData.grabExcessVerticalSpace = true;
				compMoneyTransferIn.setLayoutData(compMoneyTransferInLData);
			}
			dialogShell.open();
			postInitGUI();
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
            EngBLLogger.log(this.getClass(),e,getParent());
			return false;
		}
	}

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		compMoneyTransferIn.getTxtDocNo().setText(transBill.getTransactionBillNo());
		compMoneyTransferIn.getTxtDefinition().setText(transBill.getTransactionBillDefinition());
		compMoneyTransferIn.getDatePick().setDate(transBill.getTransactionBillDate());
		Iterator it = transBill.getTurqBanksTransactions().iterator();
		if (it.hasNext())
		{
			TurqBanksTransaction bankTrans = (TurqBanksTransaction) it.next();
			compMoneyTransferIn.getComboCurrencyType().setText(
					bankTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			compMoneyTransferIn.getTxtBankCard().setText(bankTrans.getTurqBanksCard().getBankCode());
			compMoneyTransferIn.getCurAmount().setText(bankTrans.getCreditAmountInForeignCurrency());
			if (bankTrans.getCreditAmountInForeignCurrency().compareTo(bankTrans.getDeptAmountInForeignCurrency()) < 1)
			{
				compMoneyTransferIn.getCurAmount().setText(bankTrans.getDeptAmountInForeignCurrency());
			}
			Iterator it2 = transBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
			if (it2.hasNext())
			{
				TurqCurrentTransaction curTrans = (TurqCurrentTransaction) it2.next();
				TurqCurrentCard curCard = curTrans.getTurqCurrentCard();
				compMoneyTransferIn.getCurrentPicker().setText(curCard.getCardsName() + " {" + curCard.getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	public void update()
	{
		try
		{
			if (compMoneyTransferIn.verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(BankKeys.BANK_TRANS_BILL,transBill);
				argMap.put(BankKeys.BANK,compMoneyTransferIn.getTxtBankCard().getData());
				argMap.put(EngKeys.CURRENT_CARD,compMoneyTransferIn.getCurrentPicker().getData());
				argMap.put(EngKeys.TOTAL_AMOUNT,compMoneyTransferIn.getCurAmount().getBigDecimalValue());
				argMap.put(EngKeys.TRANS_DATE,compMoneyTransferIn.getDatePick().getDate());
				argMap.put(EngKeys.DEFINITION,compMoneyTransferIn.getTxtDefinition().getText().trim());
				argMap.put(EngKeys.DOCUMENT_NO,compMoneyTransferIn.getTxtDocNo().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,compMoneyTransferIn.getExchangeRate());
				
				
				EngTXCommon.doTransactionTX(BankBLTransactionUpdate.class.getName(),"updateTransactionBill",argMap);
				EngUICommon.showMessageBox(getParent(), Messages.getString("BankUIMoneyTransferOutUpdate.5")); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
         }
	}

	public void delete()
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				HashMap argMap=new HashMap();
				argMap.put(BankKeys.BANK_TRANS_BILL,transBill);
				EngTXCommon.doTransactionTX(BankBLTransactionUpdate.class.getName(),"deleteTransaction",argMap);
				EngUICommon.showMessageBox(getParent(), Messages.getString("BankUIMoneyTransferOutUpdate.6"), SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
        }
	}
}