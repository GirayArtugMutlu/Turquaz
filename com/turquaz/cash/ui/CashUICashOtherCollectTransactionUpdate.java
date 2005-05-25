package com.turquaz.cash.ui;

/*																		*/
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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.layout.GridLayout;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashUICashOtherCollectTransactionUpdate extends Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem tooldelete;
	private CashUICashOtherCollectTransaction compTransAdd;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private TurqCashTransaction cashTrans;
	private boolean updated = false;

	public CashUICashOtherCollectTransactionUpdate(Shell parent, int style, TurqCashTransaction cashTrans)
	{
		super(parent, style);
		this.cashTrans = cashTrans;
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
				SWTResourceManager.registerResourceUser(this.dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.setSize(633, 353);
			dialogShell.setText(CashLangKeys.TITLE_OTHER_COLLECT_UPDATE);
			{
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							update();
						}
					});
				}
				{
					tooldelete = new ToolItem(toolBar1, SWT.NONE);
					tooldelete.setText(EngLangCommonKeys.STR_DELETE);
					tooldelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					tooldelete.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							dialogShell.close();
						}
					});
				}
			}
			{
				compTransAdd = new CashUICashOtherCollectTransaction(dialogShell, SWT.NONE);
				GridData compTransAddLData = new GridData();
				compTransAddLData.grabExcessHorizontalSpace = true;
				compTransAddLData.horizontalAlignment = GridData.FILL;
				compTransAddLData.grabExcessVerticalSpace = true;
				compTransAddLData.verticalAlignment = GridData.FILL;
				compTransAdd.setLayoutData(compTransAddLData);
			}
			postInitGUI();
			dialogShell.layout();
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

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		if (cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue() != EngBLCommon.MODULE_CASH)
		{
			toolUpdate.setEnabled(false);
			tooldelete.setEnabled(false);
		}
		compTransAdd.getTxtDocumentNo().setText(cashTrans.getDocumentNo());
		compTransAdd.getDatePicker().setDate(cashTrans.getTransactionDate());
		compTransAdd.getTxtDefinition().setText(cashTrans.getTransactionDefinition());
		Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
		if (it.hasNext())
		{
			TurqCashTransactionRow row = (TurqCashTransactionRow) it.next();
			compTransAdd.getTxtAccountingAccount().setText(row.getTurqAccountingAccount().getAccountCode());
			compTransAdd.getTxtCashCard().setText(row.getTurqCashCard().getCashCardName());
			if (row.getDeptAmountInForeignCurrency().compareTo(new BigDecimal(0)) == 1)
			{
				compTransAdd.getCurTextTotalAmount().setText(row.getDeptAmountInForeignCurrency());
			}
			else
			{
				compTransAdd.getCurTextTotalAmount().setText(row.getCreditAmountInForeignCurrency());
			}
			compTransAdd.getComboCurrencyType().setText(
					row.getTurqCurrencyExchangeRate().getTurqCurrencyByExchangeCurrencyId().getCurrenciesAbbreviation());
		}
	}

	public void delete()
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_TRANSACTION,cashTrans);
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionUpdate.class.getName(),"deleteCashTrans",argMap);
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void update()
	{
		try
		{
			if (compTransAdd.verifyFields())
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_TRANSACTION,cashTrans);
				argMap.put(CashKeys.CASH_CARD, compTransAdd.getTxtCashCard().getData());
				argMap.put(CashKeys.CASH_TOTAL_AMOUNT,compTransAdd.getCurTextTotalAmount().getBigDecimalValue());
				argMap.put(EngKeys.DATE, compTransAdd.getDatePicker().getDate());
				argMap.put(EngKeys.DEFINITION, compTransAdd.getTxtDefinition().getText());
				argMap.put(EngKeys.DOCUMENT_NO, compTransAdd.getTxtDocumentNo().getText());
				argMap.put(EngKeys.EXCHANGE_RATE, compTransAdd.getExchangeRate());
				argMap.put(AccKeys.ACC_ACCOUNT_ID,compTransAdd.getTxtAccountingAccount().getDBData());
							
				EngTXCommon.doTransactionTX(CashBLCashTransactionUpdate.class.getName(),"updateOtherTrans",argMap);
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				dialogShell.close();
			}
			
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}