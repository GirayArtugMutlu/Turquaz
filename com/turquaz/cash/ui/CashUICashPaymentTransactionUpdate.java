package com.turquaz.cash.ui;

/* This program is free software. You can redistribute it and/or modify */
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
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class CashUICashPaymentTransactionUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem tooldelete;
	private CashUICashPaymentTransactionAdd compTransAdd;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private TurqCashTransaction cashTrans;
	private boolean updated = false;

	public CashUICashPaymentTransactionUpdate(Shell parent, int style, TurqCashTransaction cashTrans)
	{
		super(parent, style);
		this.cashTrans = cashTrans;
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
			dialogShell.setText(Messages.getString("CashUICashPaymentTransactionUpdate.0")); //$NON-NLS-1$
			dialogShell.setLayout(new GridLayout());
			dialogShell.setImage(SWTResourceManager.getImage("icons/Editor16.gif")); //$NON-NLS-1$
			dialogShell.layout();
			dialogShell.setSize(636, 591);
			{
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(Messages.getString("CashUICashPaymentTransactionUpdate.1")); //$NON-NLS-1$
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							update();
						}
					});
				}
				{
					tooldelete = new ToolItem(toolBar1, SWT.NONE);
					tooldelete.setText(Messages.getString("CashUICashPaymentTransactionUpdate.3")); //$NON-NLS-1$
					tooldelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					tooldelete.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("CashUICashPaymentTransactionUpdate.5")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							dialogShell.close();
						}
					});
				}
			}
			{
				compTransAdd = new CashUICashPaymentTransactionAdd(dialogShell, SWT.NONE);
				GridData compCahsTransLData = new GridData();
				compCahsTransLData.horizontalAlignment = GridData.FILL;
				compCahsTransLData.verticalAlignment = GridData.FILL;
				compCahsTransLData.grabExcessVerticalSpace = true;
				compTransAdd.setLayoutData(compCahsTransLData);
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
		try
		{
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.ENG_SEQ,cashTrans.getTurqEngineSequence());
			
			TurqCurrentCard curCard =(TurqCurrentCard)EngTXCommon.doSelectTX(CashBLCashTransactionUpdate.class.getName(),"getCurrentCard",argMap);
			if (curCard != null)
			{
				compTransAdd.getTxtCurrentAccount().setText(curCard.getCardsName() + " {" + curCard.getCardsCurrentCode() + "}");
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
		Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
		if (it.hasNext())
		{
			TurqCashTransactionRow row = (TurqCashTransactionRow) it.next();
			compTransAdd.getTxtCashCard().setText(row.getTurqCashCard().getCashCardName());
			if (row.getDeptAmount().compareTo(new BigDecimal(0)) == 1)
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
			MessageBox msg = new MessageBox(this.getParent(), SWT.ICON_QUESTION | SWT.YES | SWT.NO);
			msg.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.7")); //$NON-NLS-1$
			int answer = msg.open();
			if (answer == SWT.YES)
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_TRANSACTION,cashTrans);
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionUpdate.class.getName(),"deleteCashTrans",argMap);
				
				MessageBox msg2 = new MessageBox(this.getParent(), SWT.ICON_INFORMATION);
				msg2.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.8")); //$NON-NLS-1$
				msg2.open();
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
			MessageBox msg = new MessageBox(this.getParent(), SWT.ICON_INFORMATION);
			if (compTransAdd.verifyFields())
			{
				updated = true;
				

				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD,compTransAdd.getTxtCashCard().getData());
				argMap.put(EngKeys.CURRENT_CARD,compTransAdd.getTxtCurrentAccount().getData());
				argMap.put(CashKeys.CASH_TOTAL_AMOUNT, compTransAdd.getCurTextTotalAmount().getBigDecimalValue());
				argMap.put(EngKeys.DATE,compTransAdd.getDatePicker().getDate());
				argMap.put(EngKeys.DEFINITION,compTransAdd.getTxtDefinition().getText());
				argMap.put(EngKeys.DOCUMENT_NO,compTransAdd.getTxtDocumentNo().getText());
				argMap.put(EngKeys.EXCHANGE_RATE, compTransAdd.getExchangeRate());
				argMap.put(CashKeys.CASH_TRANSACTION,cashTrans);
				
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionUpdate.class.getName(),"updateCashTrans",argMap );
			
				msg.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.9")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}