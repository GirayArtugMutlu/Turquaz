package com.turquaz.bank.ui;

import java.util.Iterator;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
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
public class BankUICashFromBankUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUICashFromBank compCashTrans;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private TurqBanksTransactionBill transBill;
	boolean isUpdated = false;

	public BankUICashFromBankUpdate(Shell parent, int style, TurqBanksTransactionBill transBill)
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
				compCashTrans = new BankUICashFromBank(dialogShell, SWT.NONE);
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
			compCashTrans.getTxtBankCard().setText(bankTrans.getTurqBanksCard().getBankCode());
			compCashTrans.getCurAmount().setText(bankTrans.getCreditAmountInForeignCurrency());
			if (bankTrans.getCreditAmountInForeignCurrency().compareTo(bankTrans.getDeptAmountInForeignCurrency()) < 1)
			{
				compCashTrans.getCurAmount().setText(bankTrans.getDeptAmountInForeignCurrency());
			}
			compCashTrans.getComboCurrencyType().setText(
					bankTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
			Iterator it2 = transBill.getTurqEngineSequence().getTurqCashTransactions().iterator();
			if (it2.hasNext())
			{
				try
				{
					TurqCashTransaction curTrans = (TurqCashTransaction) it2.next();
					CashBLCashTransactionSearch.initializeCashTransaction(curTrans);
					Iterator it3 = curTrans.getTurqCashTransactionRows().iterator();
					TurqCashCard curCard = null;
					;
					if (it3.hasNext())
					{
						TurqCashTransactionRow cashTransRow = (TurqCashTransactionRow) it3.next();
						curCard = cashTransRow.getTurqCashCard();
					}
					compCashTrans.getCurrentPicker().setText(curCard.getCashCardName());
				}
				catch (Exception ex)
				{
					ex.toString();
				}
			}
		}
	}

	public void update()
	{
		try
		{
			if (compCashTrans.verifyFields())
			{
				BankBLTransactionUpdate.updateCashTransactionBill(transBill, compCashTrans.getTxtBankCard().getTurqBank(),
						compCashTrans.getCurrentPicker().getTurqCashCard(), compCashTrans.getCurAmount().getBigDecimalValue(),
						compCashTrans.getDatePick().getDate(), compCashTrans.getTxtDefinition().getText().trim(), compCashTrans
								.getTxtDocNo().getText().trim(), compCashTrans.getExchangeRate());
				EngUICommon.showMessageBox(getParent(), Messages.getString("BankUIMoneyTransferInUpdate.6")); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
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
			ex.printStackTrace();
			EngUICommon.showMessageBox(getParent(), ex.getMessage().toString(), SWT.ICON_ERROR);
		}
	}
}