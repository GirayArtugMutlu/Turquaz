package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
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
public class BankUITransferBetweenAccountsUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUITransferBetweenAccounts compTransfer;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar;
	Integer transBillId;
	boolean isUpdated = false;

	public BankUITransferBetweenAccountsUpdate(Shell parent, int style, Integer transBill)
	{
		super(parent, style);
		this.transBillId = transBill;
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
			dialogShell.setSize(550, 309);
			{
				toolBar = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarLData = new GridData();
				toolBarLData.grabExcessHorizontalSpace = true;
				toolBarLData.horizontalAlignment = GridData.FILL;
				toolBar.setLayoutData(toolBarLData);
				{
					toolUpdate = new ToolItem(toolBar, SWT.NONE);
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							update();
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar, SWT.NONE);
					toolDelete.setText(EngLangCommonKeys.STR_DELETE);
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
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
				compTransfer = new BankUITransferBetweenAccounts(dialogShell, SWT.NONE);
				GridData bankUITransferLData = new GridData();
				bankUITransferLData.grabExcessHorizontalSpace = true;
				bankUITransferLData.horizontalAlignment = GridData.FILL;
				bankUITransferLData.grabExcessVerticalSpace = true;
				bankUITransferLData.verticalAlignment = GridData.FILL;
				compTransfer.setLayoutData(bankUITransferLData);
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

	public void postInitGUI()throws Exception
	{
		EngUICommon.centreWindow(dialogShell);
		EngUICommon.centreWindow(dialogShell);
		
			HashMap argMap = new HashMap();
			argMap.put(BankKeys.BANK_TRANS_BILL_ID,transBillId);
			HashBag result = (HashBag)EngTXCommon.doSelectTX(BankBLTransactionSearch.class.getName(),"getTransactionInfo",argMap);
			
		
		compTransfer.getTxtDocNo().setText(result.get(EngKeys.DOCUMENT_NO).toString());
		compTransfer.getTxtDefinition().setText(result.get(EngKeys.DEFINITION).toString());
		compTransfer.getDatePick().setDate((Date)result.get(EngKeys.DATE));
		
		HashMap rowMap = (HashMap)result.get(BankKeys.BANK_TRANSACTION_ROWS);
		for(int i=0;i<rowMap.size();i++)
		{
			
			HashMap rowInfo = (HashMap)rowMap.get(new Integer(i));
			compTransfer.getComboCurrencyType().setText(rowInfo.get(AdmKeys.ADM_CURRENCY_ABBR).toString());
			
			BigDecimal deptAmount = (BigDecimal)rowInfo.get(EngKeys.DEPT_AMOUNT);
			BigDecimal creditAmount = (BigDecimal)rowInfo.get(EngKeys.CREDIT_AMOUNT);
			
			if (creditAmount.doubleValue()>0)
			{
				compTransfer.getBankCardPickerWithCredit().setText(rowInfo.get(BankKeys.BANK_CODE).toString());
				compTransfer.getCurAmount().setText(creditAmount);
			}
			else
			{
				compTransfer.getCurAmount().setText(deptAmount);
				compTransfer.getBankCardPickerWithDept().setText(rowInfo.get(BankKeys.BANK_CODE).toString());
			
			}		
			
		}
			
	}

	public void update()
	{
		try
		{
			if (compTransfer.verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(BankKeys.BANK_TRANS_BILL_ID,transBillId);
				argMap.put(BankKeys.BANK_CARD_WITH_DEPT,compTransfer.getBankCardPickerWithDept().getBankId());
				argMap.put(BankKeys.BANK_CARD_WITH_CREDIT,compTransfer.getBankCardPickerWithCredit().getBankId());
				argMap.put(EngKeys.ENG_SEQ,null);
				argMap.put(EngKeys.TOTAL_AMOUNT,compTransfer.getCurAmount().getBigDecimalValue());
				argMap.put(EngKeys.TRANS_DATE,compTransfer.getDatePick().getDate());
				argMap.put(EngKeys.DEFINITION,compTransfer.getTxtDefinition().getText().trim());
				argMap.put(EngKeys.DOCUMENT_NO,compTransfer.getTxtDocNo().getText().trim());
				argMap.put(EngKeys.CURRENCY_ID,compTransfer.getComboCurrencyType().getData(compTransfer.getComboCurrencyType().getText().trim()));				
				
				EngTXCommon.doTransactionTX(BankBLTransactionUpdate.class.getName(),"updateTransferBetweenBanks",argMap);
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