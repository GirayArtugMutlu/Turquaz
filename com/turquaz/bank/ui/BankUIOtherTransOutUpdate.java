package com.turquaz.bank.ui;

import java.util.HashMap;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
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
public class BankUIOtherTransOutUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUIOtherTransIn compCashTrans;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private TurqBanksTransactionBill transBill;
	boolean isUpdated = false;

	public BankUIOtherTransOutUpdate(Shell parent, int style, TurqBanksTransactionBill transBill)
	{
		super(parent, style);
		this.transBill = transBill;
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
			dialogShell.setSize(555, 300);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(Messages.getString("BankUICashFromBankUpdate.0")); //$NON-NLS-1$
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
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
					toolDelete.setText(Messages.getString("BankUICashFromBankUpdate.2")); //$NON-NLS-1$
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
					toolCancel.setText(Messages.getString("BankUICashFromBankUpdate.4")); //$NON-NLS-1$
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
				compCashTrans = new BankUIOtherTransIn(dialogShell, SWT.NONE);
				GridData compCashTransLData = new GridData();
				compCashTransLData.grabExcessHorizontalSpace = true;
				compCashTransLData.horizontalAlignment = GridData.FILL;
				compCashTransLData.verticalAlignment = GridData.FILL;
				compCashTransLData.grabExcessVerticalSpace = true;
				compCashTrans.setLayoutData(compCashTransLData);
			}
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
		EngUICommon.centreWindow(dialogShell);
		compCashTrans.getTxtDocNo().setText(transBill.getTransactionBillNo());
		compCashTrans.getTxtDefinition().setText(transBill.getTransactionBillDefinition());
		compCashTrans.getDatePick().setDate(transBill.getTransactionBillDate());
		Iterator it = transBill.getTurqBanksTransactions().iterator();
		if (it.hasNext())
		{
			TurqBanksTransaction bankTrans = (TurqBanksTransaction) it.next();
			compCashTrans.getComboCurrencyType().setText(
					bankTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			compCashTrans.getTxtBankCard().setText(bankTrans.getTurqBanksCard().getBankCode());
			compCashTrans.getCurAmount().setText(bankTrans.getCreditAmountInForeignCurrency());
			if (bankTrans.getCreditAmountInForeignCurrency().compareTo(bankTrans.getDeptAmountInForeignCurrency()) < 1)
			{
				compCashTrans.getCurAmount().setText(bankTrans.getDeptAmountInForeignCurrency());
			}
		}
		it = transBill.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		if (it.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
			try
			{
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doSingleTX(AccBLTransactionUpdate.class.getName(),"initializeTransactionRows",argMap);
				
				Iterator it2 = accTrans.getTurqAccountingTransactionColumns().iterator();
				while (it2.hasNext())
				{
					TurqAccountingTransactionColumn transColumn = (TurqAccountingTransactionColumn) it2.next();
					if (transColumn.getDeptAmount().doubleValue() > 0)
					{
						compCashTrans.getCurrentPicker().setText(transColumn.getTurqAccountingAccount().getAccountCode());
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
	}

	public void update()
	{
		try
		{
			if (compCashTrans.verifyFields())
			{
				BankBLTransactionUpdate.updateOtherTransactionBill(transBill, compCashTrans.getTxtBankCard().getTurqBank(),
						compCashTrans.getCurrentPicker().getTurqAccountingAccount(), compCashTrans.getCurAmount()
								.getBigDecimalValue(), compCashTrans.getDatePick().getDate(), compCashTrans.getTxtDefinition()
								.getText().trim(), compCashTrans.getTxtDocNo().getText().trim(), compCashTrans.getExchangeRate());
				EngUICommon.showMessageBox(getParent(), Messages.getString("BankUIOtherTransInUpdate.0")); //$NON-NLS-1$
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

	public void delete()
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				BankBLTransactionUpdate.deleteTransaction(transBill);
				EngUICommon.showMessageBox(getParent(), Messages.getString("BankUIMoneyTransferInUpdate.5"), SWT.ICON_INFORMATION); //$NON-NLS-1$
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