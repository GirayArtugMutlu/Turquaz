package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
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
public class CurUIVoucherUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private CurUICurrentCardVoucher compVoucher;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	TurqCurrentTransaction curTrans;
	private boolean updated = false;

	public CurUIVoucherUpdate(Shell parent, int style, TurqCurrentTransaction curTrans)
	{
		super(parent, style);
		this.curTrans = curTrans;
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
			dialogShell.setText(Messages.getString("CurUIVoucherUpdate.5")); //$NON-NLS-1$
			dialogShell.setSize(672, 316);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(Messages.getString("CurUIVoucherUpdate.0")); //$NON-NLS-1$
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							update();
							dialogShell.close();
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar1, SWT.NONE);
					toolDelete.setText(Messages.getString("CurUIVoucherUpdate.2")); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							delete();
							dialogShell.close();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("CurUIVoucherUpdate.4")); //$NON-NLS-1$
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
					toolPrint.setText(Messages.getString("CurUIVoucherUpdate.3")); //$NON-NLS-1$
					toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif")); //$NON-NLS-1$
					toolPrint.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							dialogShell.close();
							EngBLUtils.printCurrentTrans(curTrans);
						}
					});
				}
			}
			{
				compVoucher = new CurUICurrentCardVoucher(dialogShell, SWT.NONE);
				GridData compVoucherLData = new GridData();
				compVoucherLData.horizontalAlignment = GridData.FILL;
				compVoucherLData.grabExcessHorizontalSpace = true;
				compVoucherLData.verticalAlignment = GridData.FILL;
				compVoucherLData.grabExcessVerticalSpace = true;
				compVoucher.setLayoutData(compVoucherLData);
			}
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

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		if (curTrans.getTransactionsTotalDept().doubleValue() > 0)
		{
			compVoucher.getComboType().setText(EngBLCommon.COMMON_DEPT_STRING);
			compVoucher.getTxtCredit().setText(curTrans.getTotalDeptInForeignCurrency());
		}
		else
		{
			compVoucher.getComboType().setText(EngBLCommon.COMMON_CREDIT_STRING);
			compVoucher.getTxtCredit().setText(curTrans.getTotalCreditInForeignCurrency());
		}
		compVoucher.getDateTransDate().setDate(curTrans.getTransactionsDate());
		compVoucher.getTxtCurrentCard().setText(
				curTrans.getTurqCurrentCard().getCardsName() + " {" + curTrans.getTurqCurrentCard().getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
		compVoucher.getTxtDefinition().setText(curTrans.getTransactionsDefinition());
		compVoucher.getComboCurrencyType().setText(
				curTrans.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		try
		{
			CurBLTransactionUpdate.initCurTrans(curTrans);
			Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			if (it.hasNext())
			{
				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doSingleTX(AccBLTransactionUpdate.class.getName(),"initializeTransactionRows",argMap);
				
				Iterator accIt = accTrans.getTurqAccountingTransactionColumns().iterator();
				while (accIt.hasNext())
				{
					TurqAccountingTransactionColumn accRow = (TurqAccountingTransactionColumn) accIt.next();
					if (!accRow.getTurqAccountingAccount().equals(
							CurBLCurrentCardSearch.getCurrentAccountingAccount(curTrans.getTurqCurrentCard(),
									EngBLCommon.CURRENT_ACC_TYPE_GENERAL)))
					{
						compVoucher.getAccountPicker().setText(accRow.getTurqAccountingAccount().getAccountCode());
					}
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

	public void update()
	{
		if (compVoucher.verifyFields())
		{
			updated = true;
			CurBLTransactionUpdate blUpdate = new CurBLTransactionUpdate();
			try
			{
				
				CurBLTransactionUpdate.deleteCurTrans(curTrans);
				BigDecimal credit = compVoucher.getTxtCredit().getBigDecimalValue();
				boolean isCredit = false;
				if (compVoucher.getComboType().getText().equals(EngBLCommon.COMMON_CREDIT_STRING))
				{
					isCredit = true;
				}
				TurqCurrentTransaction curtrans = CurBLCurrentTransactionAdd.saveOtherCurrentTransaction((TurqCurrentCard) compVoucher
						.getTxtCurrentCard().getData(), compVoucher.getAccountPicker().getTurqAccountingAccount(), compVoucher
						.getDateTransDate().getDate(), "", isCredit, credit, //$NON-NLS-1$
						new BigDecimal(0), EngBLCommon.CURRENT_TRANS_OTHERS, null, compVoucher.getTxtDefinition().getText(),
						compVoucher.getExchangeRate());
				EngUICommon.showMessageBox(getParent(), Messages.getString("CurUIVoucherUpdate.1")); //$NON-NLS-1$
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
			}
		}
	}

	public void delete()
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				
				updated = true;
				CurBLTransactionUpdate.deleteCurTrans(curTrans);
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