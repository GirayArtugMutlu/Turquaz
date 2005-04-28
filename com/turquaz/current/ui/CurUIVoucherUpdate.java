package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.current.CurKeys;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
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
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
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
            EngBLLogger.log(this.getClass(),e,getParent());
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
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
			
			EngTXCommon.doSelectTX(CurBLTransactionUpdate.class.getName(),"initCurTrans",argMap);
			Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
			if (it.hasNext())
			{
				TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
				 argMap = new HashMap();
				argMap.put(AccKeys.ACC_TRANSACTION,accTrans);
				EngTXCommon.doSelectTX(AccBLTransactionUpdate.class.getName(),"initiliazeTransactionRows",argMap);
				
				Iterator accIt = accTrans.getTurqAccountingTransactionColumns().iterator();
				while (accIt.hasNext())
				{

					argMap = new HashMap();
					argMap.put(EngKeys.CURRENT_CARD, curTrans.getTurqCurrentCard());
					argMap.put(EngKeys.TYPE,EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
					
					Object curAccount = EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getCurrentAccountingAccount",argMap);
				    
					TurqAccountingTransactionColumn accRow = (TurqAccountingTransactionColumn) accIt.next();
					if (!accRow.getTurqAccountingAccount().equals(curAccount))
					{
						compVoucher.getAccountPicker().setText(accRow.getTurqAccountingAccount().getAccountCode());
					}
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
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
				
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
				EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteCurTrans",argMap);
				
				BigDecimal credit = compVoucher.getTxtCredit().getBigDecimalValue();
				boolean isCredit = false;
				if (compVoucher.getComboType().getText().equals(EngBLCommon.COMMON_CREDIT_STRING))
				{
					isCredit = true;
				}
				
				 
				 argMap = new HashMap();
				argMap.put(EngKeys.CURRENT_CARD,(TurqCurrentCard)compVoucher.getTxtCurrentCard().getData());
				argMap.put(AccKeys.ACC_ACCOUNT, compVoucher.getAccountPicker().getTurqAccountingAccount());
				argMap.put(EngKeys.DATE,compVoucher.getDateTransDate().getDate());
				argMap.put(EngKeys.DOCUMENT_NO,"");
				argMap.put(CurKeys.CUR_IS_CREDIT,new Boolean(isCredit));
				argMap.put(CurKeys.CUR_TRANS_AMOUNT,credit);
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,new BigDecimal(0));
				argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CURRENT_TRANS_OTHERS));
				argMap.put(EngKeys.ENG_SEQ_ID,null);
				argMap.put(EngKeys.DEFINITION, compVoucher.getTxtDefinition().getText());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
								
				TurqCurrentTransaction curtrans = (TurqCurrentTransaction)EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveOtherCurrentTransaction",argMap);
					EngUICommon.showMessageBox(getParent(), Messages.getString("CurUIVoucherUpdate.1")); //$NON-NLS-1$
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getParent());
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
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_TRANSACTION,curTrans);
				EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteCurTrans",argMap);
				
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}