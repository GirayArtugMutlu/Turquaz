package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.cash.CashKeys;
import com.turquaz.common.HashBag;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
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
public class BankUICashFromBankUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUICashFromBank compCashTrans;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private Integer transBillId;
	boolean isUpdated = false;

	public BankUICashFromBankUpdate(Shell parent, int style,Integer transBillId)
	{
		super(parent, style);
		this.transBillId = transBillId;
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
			dialogShell.setSize(555, 300);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
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
					toolDelete.setText(EngLangCommonKeys.STR_DELETE);
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
            EngBLLogger.log(this.getClass(),e,getParent());
			return false;
		}
	}

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);		
		
		try{
		HashMap argMap = new HashMap();
		argMap.put(BankKeys.BANK_TRANS_BILL_ID,transBillId);
		HashBag result = (HashBag)EngTXCommon.doSelectTX(BankBLTransactionSearch.class.getName(),"getTransactionInfo",argMap);
		
		
		
		compCashTrans.getTxtDocNo().setText(result.get(EngKeys.DOCUMENT_NO).toString());
		compCashTrans.getTxtDefinition().setText(result.get(EngKeys.DEFINITION).toString());
		compCashTrans.getDatePick().setDate((Date)result.get(EngKeys.DATE));
		
		HashMap rowMap = (HashMap)result.get(BankKeys.BANK_TRANSACTION_ROWS);
		
		for(int i=0;i<rowMap.size();i++)
		{
			HashMap rowInfo = (HashMap)rowMap.get(new Integer(i));
			compCashTrans.getTxtBankCard().setText(rowInfo.get(BankKeys.BANK_CODE).toString());
			
			BigDecimal creditAmount = (BigDecimal)rowInfo.get(EngKeys.CREDIT_AMOUNT);
			BigDecimal deptAmount = (BigDecimal)rowInfo.get(EngKeys.DEPT_AMOUNT);
				
			compCashTrans.getCurAmount().setText(creditAmount);
			
			if (creditAmount.compareTo(deptAmount) < 1)
			{
				compCashTrans.getCurAmount().setText(deptAmount);
			}
			
			
			
			
			
		}
		compCashTrans.getTxtCashCard().setText(result.get(CashKeys.CASH_CARD_NAME).toString());
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	
	}

	public void update()
	{
		try
		{
			if (compCashTrans.verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(BankKeys.BANK_TRANS_BILL_ID,transBillId);
				argMap.put(BankKeys.BANK_ID,compCashTrans.getTxtBankCard().getBankId());
				argMap.put(CashKeys.CASH_CARD_ID,compCashTrans.getTxtCashCard().getCashCardId());
				argMap.put(EngKeys.TOTAL_AMOUNT,compCashTrans.getCurAmount().getBigDecimalValue());
				argMap.put(EngKeys.TRANS_DATE,compCashTrans.getDatePick().getDate());
				argMap.put(EngKeys.DEFINITION,compCashTrans.getTxtDefinition().getText().trim());
				argMap.put(EngKeys.DOCUMENT_NO,compCashTrans.getTxtDocNo().getText().trim());
				argMap.put(EngKeys.EXCHANGE_RATE,compCashTrans.getExchangeRate());				
				
				
				EngTXCommon.doTransactionTX(BankBLTransactionUpdate.class.getName(),"updateCashTransactionBill",argMap);
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
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
				argMap.put(BankKeys.BANK_TRANS_BILL_ID,transBillId);
				EngTXCommon.doTransactionTX(BankBLTransactionUpdate.class.getName(),"deleteTransaction",argMap);
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
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