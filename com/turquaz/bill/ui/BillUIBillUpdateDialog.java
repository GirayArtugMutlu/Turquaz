package com.turquaz.bill.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.cash.CashKeys;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.lang.BillLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableItem;
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
public class BillUIBillUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private BillUIAddBill compAddBill;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private TurqBill bill;
	ConBLUpdateConsignment blUpdateCons = new ConBLUpdateConsignment();
	private boolean updated = false;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */
	public BillUIBillUpdateDialog(Shell parent, int style, TurqBill bill)
	{
		super(parent, style);
		this.bill = bill;
	}

	public BillUIBillUpdateDialog(Shell parent, int style)
	{
		super(parent, style);
		this.bill = null;
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
			dialogShell.setText(BillLangKeys.TITLE_BILL_UPDATE);
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.horizontalSpacing = 4;
			dialogShellLayout.marginHeight = 4;

			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
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
					toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							delete();
						}
					});
				}
				{
					toolPrint = new ToolItem(toolBar1, SWT.NONE);
					toolPrint.setText(EngLangCommonKeys.STR_PRINT);
					toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif")); //$NON-NLS-1$
					toolPrint.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							try
							{
								boolean answer = EngUICommon.showQuestion(getParent(), BillLangKeys.MSG_WILL_BALANCE_BE_PRINTED);
								dialogShell.close();
								HashMap argMap=new HashMap();
								argMap.put(BillKeys.BILL,bill);
								argMap.put(BillKeys.BILL_BALANCE,new Boolean(answer));
								EngTXCommon.doSelectTX(EngBLUtils.class.getName(),"printBill",argMap);
							}
							catch(Exception ex)
							{
                                EngBLLogger.log(this.getClass(),ex,getParent());
							}
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
				compAddBill = new BillUIAddBill(dialogShell, SWT.NONE, bill.getBillsType());
				GridData compBillUIAddDialogLData = new GridData();
				compBillUIAddDialogLData.grabExcessHorizontalSpace = true;
				compBillUIAddDialogLData.horizontalAlignment = GridData.FILL;
				compBillUIAddDialogLData.verticalAlignment = GridData.FILL;
				compBillUIAddDialogLData.grabExcessVerticalSpace = true;
				compAddBill.setLayoutData(compBillUIAddDialogLData);
			}
			dialogShell.layout();
			dialogShell.setSize(690, 562);
			postInitGui();
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
	
	public void postInitGui()
	{
		try
		{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			if (bill == null)
				return;
			HashMap argMap=new HashMap();
			argMap.put(BillKeys.BILL_ID,bill.getId());
			Boolean canUpdateBill=(Boolean)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"canUpdateBill",argMap);
			if (!canUpdateBill.booleanValue())
			{
				toolDelete.setEnabled(false);
				toolUpdate.setEnabled(false);
			}
			else
			{
				if (EngBLPermissions.getPermission(compAddBill.getClass().getName()) == 2)
				{
					toolUpdate.setEnabled(true);
				}
				else if (EngBLPermissions.getPermission(compAddBill.getClass().getName()) == 3)
				{
					toolDelete.setEnabled(true);
					toolUpdate.setEnabled(true);
				}
			}
			compAddBill.getTxtCurrentCard().setData(bill.getTurqCurrentCard());
			compAddBill.getTxtCurrentCard().setText(
					bill.getTurqCurrentCard().getCardsName() + " {" + bill.getTurqCurrentCard().getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			;
			compAddBill.getTxtDocumentNo().setText(bill.getBillDocumentNo());
			compAddBill.getDateConsignmentDate().setDate(bill.getBillsDate());
			
			compAddBill.getDateDueDate().setDate(bill.getDueDate());
			compAddBill.getTxtDefinition().setText(bill.getBillsDefinition());
            if(!bill.isIsOpen())
            {
                compAddBill.getBtnClosedBill().setSelection(true);
                compAddBill.getCashPicker().setVisible(true);
                Iterator it = bill.getTurqEngineSequence().getTurqCashTransactions().iterator();
                if(it.hasNext())
                {
                    TurqCashTransaction cashTrans = (TurqCashTransaction)it.next();
                    Iterator it2 = cashTrans.getTurqCashTransactionRows().iterator();
                    while(it2.hasNext())
                    {
                        TurqCashTransactionRow transRow = (TurqCashTransactionRow)it2.next();
                        compAddBill.getCashPicker().setData(transRow.getTurqCashCard());
                        
                        
                    }
                    
                }
                
            }
			fillInvTransactionColumns();
			fillRegisteredGroup();
			EngUICommon.centreWindow(dialogShell);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void fillInvTransactionColumns()
	{
		compAddBill.tableViewer.removeAll();
		TableItem item;
		
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		List transColumns= new ArrayList();
		while (it.hasNext())
		{
			TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
			Iterator it2 = billInEng.getTurqEngineSequence().getTurqConsignments().iterator();
			if (it2.hasNext())
			{
				TurqConsignment cons = (TurqConsignment) it2.next();
				compAddBill.getTxtConsignmentDate().setText(DatePicker.formatter.format(cons.getConsignmentsDate()));
				if (!cons.getConsignmentDocumentNo().equals("")) //$NON-NLS-1$
					compAddBill.getTxtConsignmentDocumentNo().append("[" + cons.getConsignmentDocumentNo() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			Iterator it3 = billInEng.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it3.hasNext())
			{
				transColumns.add(it3.next());
			}
		}
		Collections.sort(transColumns,new EngBLHibernateComparer());
		TurqInventoryTransaction invTrans;
		for(int k=0; k<transColumns.size(); k++)
		{
			invTrans=(TurqInventoryTransaction)transColumns.get(k);
			InvUITransactionTableRow row = new InvUITransactionTableRow(compAddBill.BILL_TYPE, compAddBill.tableViewer);
			row.setDBObject(invTrans);
			compAddBill.tableViewer.addRow(row);
		}
		compAddBill.calculateTotals();
	}

	public void fillRegisteredGroup()
	{
		TurqBillInGroup group;
		Iterator it = bill.getTurqBillInGroups().iterator();
		while (it.hasNext())
		{
			group = (TurqBillInGroup) it.next();
			compAddBill.getCompRegisterGroup().RegisterGroup(group.getTurqBillGroup());
		}
	}

	public void update()
	{
		try
		{
			if (bill == null)
				return;
			if (compAddBill.verifyFields())
			{
				updated = true;
				//update the consignment
				int type = compAddBill.BILL_TYPE;
				//TODO exchange rate
				
				HashMap argMap=new HashMap();
				
				argMap.put(BillKeys.BILL,bill);
				argMap.put(BillKeys.BILL_DOC_NO,compAddBill.getTxtDocumentNo().getText().trim());
				argMap.put(BillKeys.BILL_DEFINITION,compAddBill.getTxtDefinition().getText().trim());
				argMap.put(BillKeys.BILL_IS_PRINTED,new Boolean(false));
				argMap.put(BillKeys.BILL_DATE,compAddBill.getDateConsignmentDate().getDate());
				argMap.put(EngKeys.TYPE,new Integer(type));
				argMap.put(CurKeys.CUR_CARD_ID,compAddBill.getTxtCurrentCard().getCardId());
				argMap.put(BillKeys.BILL_DUE_DATE,compAddBill.getDateDueDate().getDate());
				argMap.put(BillKeys.BILL_DISCOUNT_AMOUNT,compAddBill.getTxtDiscountAmount().getBigDecimalValue());			
				argMap.put(BillKeys.BILL_TOTAL_AMOUNT,compAddBill.getTxtTotalAmount().getBigDecimalValue());
				argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				argMap.put(BillKeys.BILL_GROUPS,compAddBill.getBillGroups());
				argMap.put(InvKeys.INV_TRANSACTIONS,compAddBill.getInventoryTransactions());	
				argMap.put(BillKeys.BILL_CHECK,EngBLCommon.getBillCheckStatus());
				argMap.put(BillKeys.BILL_IS_OPEN,new Boolean(!compAddBill.getBtnClosedBill().getSelection()));
                argMap.put(CashKeys.CASH_CARD,compAddBill.getCashPicker().getData());
                
				int[] result=(int[])EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"updateBill",argMap);
				
				if(result[0]==EngBLCommon.BILL_ERR_TOO_MANY_CONS)
				{
					EngUICommon.showMessageBox(getParent(),BillLangKeys.MSG_COULDNT_UPDATE_CONS_DUE_TO_MANY_CONS,SWT.ICON_WARNING);
				}
				if(result[1]==-1)
				{			   	
					EngUICommon.showMessageBox(getParent(),EngLangCommonKeys.MSG_ACCOUNTING_ENTEGRATION_COULDNT_BE_MADE,SWT.ICON_WARNING);
				}
				
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
			this.dialogShell.close();
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
				boolean deleteCons = false;
				//TODO send boolean to delete cons
				if (EngUICommon.showQuestion(getParent(), BillLangKeys.MSG_WILL_DELETE_CONS))
				{
					deleteCons = true;
				}
				HashMap argMap=new HashMap();
				argMap.put(BillKeys.BILL,bill);
				argMap.put(BillKeys.BILL_DELETE_CONS,new Boolean(deleteCons));
				EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"deleteBill",argMap);
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}