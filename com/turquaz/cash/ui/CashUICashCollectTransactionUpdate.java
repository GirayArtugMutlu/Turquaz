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
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
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


public class CashUICashCollectTransactionUpdate extends Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem tooldelete;
	private CashUICashCollectTransactionAdd compTransAdd;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private Integer cashTransId;
	private boolean updated = false;

	public CashUICashCollectTransactionUpdate(Shell parent, int style, Integer cashTransId)
	{
		super(parent, style);
		this.cashTransId = cashTransId;
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
			dialogShell.setText(CashLangKeys.TITLE_COLLECT_VOUCHER_UPDATE);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
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
				compTransAdd = new CashUICashCollectTransactionAdd(dialogShell, SWT.NONE);
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
        
        HashMap argMapSearch = new HashMap();
        argMapSearch.put(EngKeys.TRANS_ID,cashTransId);
        
        try
        {
        HashBag cashBag = (HashBag)EngTXCommon.doSelectTX(CashBLCashTransactionSearch.class.getName(),"getTransactionInfo",argMapSearch); //$NON-NLS-1$

        
		if (((Integer)cashBag.get(CashKeys.CASH_TRANS_MODULE_ID)).intValue() != EngBLCommon.MODULE_CASH)
		{
			toolUpdate.setEnabled(false);
			tooldelete.setEnabled(false);
		}
        
        
        
		compTransAdd.getTxtDocumentNo().setText(cashBag.get(EngKeys.DOCUMENT_NO).toString());
		compTransAdd.getDatePicker().setDate((Date)cashBag.get(EngKeys.DATE));
		compTransAdd.getTxtDefinition().setText(cashBag.get(EngKeys.DEFINITION).toString());
        compTransAdd.getTxtCurrentAccount().setText(cashBag.get(CurKeys.CUR_CURRENT_NAME) + " {" + cashBag.get(CurKeys.CUR_CURRENT_CODE) + "}");
		compTransAdd.getTxtCashCard().setText(cashBag.get(CashKeys.CASH_TRANS_ROW_CASH_CARD_NAME).toString());
		
            if (((BigDecimal)cashBag.get(CashKeys.CASH_TRANS_ROW_FOREIGN_DEPT_AMOUNT)).compareTo(new BigDecimal(0)) == 1)
			{
				compTransAdd.getCurTextTotalAmount().setText((BigDecimal)cashBag.get(CashKeys.CASH_TRANS_ROW_FOREIGN_DEPT_AMOUNT));
			}
			else
			{
				compTransAdd.getCurTextTotalAmount().setText((BigDecimal)cashBag.get(CashKeys.CASH_TRANS_ROW_FOREIGN_CREDIT_AMOUNT));
			}
			compTransAdd.getComboCurrencyType().setText(cashBag.get(CashKeys.CASH_TRANS_ROW_ABBREVATION).toString());
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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
				argMap.put(CashKeys.CASH_TRANSACTION_ID,cashTransId);
				
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

				argMap.put(CashKeys.CASH_CARD,compTransAdd.getTxtCashCard().getData());
				argMap.put(CurKeys.CUR_CARD_ID,compTransAdd.getTxtCurrentAccount().getCardId());
				argMap.put(CashKeys.CASH_TOTAL_AMOUNT, compTransAdd.getCurTextTotalAmount().getBigDecimalValue());
				argMap.put(EngKeys.DATE,compTransAdd.getDatePicker().getDate());
				argMap.put(EngKeys.DEFINITION,compTransAdd.getTxtDefinition().getText());
				argMap.put(EngKeys.DOCUMENT_NO,compTransAdd.getTxtDocumentNo().getText());
				argMap.put(EngKeys.CURRENCY_ID, compTransAdd.getComboCurrencyType().getData(compTransAdd.getComboCurrencyType().getText().trim()));
				argMap.put(CashKeys.CASH_TRANSACTION_ID,cashTransId);
				
				
				EngTXCommon.doTransactionTX(CashBLCashTransactionUpdate.class.getName(),"updateCashTrans",argMap );
			
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