package com.turquaz.bill.ui;

import java.util.Iterator;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
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
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private BillUIAddBill compAddBill;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
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
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(Messages.getString("BillUIBillUpdateDialog.6")); //$NON-NLS-1$
			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(690, 562);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.heightHint = 46;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 42));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 42));
					coolItem1.setSize(45, 42);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText(Messages.getString("BillUIBillUpdateDialog.0")); //$NON-NLS-1$
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
							toolDelete.setText(Messages.getString("BillUIBillUpdateDialog.2")); //$NON-NLS-1$
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
							toolCancel = new ToolItem(toolBar1, SWT.NONE);
							toolCancel.setText(Messages.getString("BillUIBillUpdateDialog.4")); //$NON-NLS-1$
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
							toolPrint.setText(Messages.getString("BillUIBillUpdateDialog.5")); //$NON-NLS-1$
							toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif")); //$NON-NLS-1$
							toolPrint.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									boolean answer = EngUICommon.okToDelete(getParent(), Messages
											.getString("BillUIBillUpdateDialog.7")); //$NON-NLS-1$
									dialogShell.close();
									EngBLUtils.printBill(bill, answer);
								}
							});
						}
					}
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
			e.printStackTrace();
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
			if (!BillBLUpdateBill.canUpdateBill(bill))
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
			compAddBill.getTxtCurrentCard().setData(bill.getTurqBillConsignmentCommon().getTurqCurrentCard());
			compAddBill.getTxtCurrentCard().setText(
					bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName()
							+ " {" + bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			;
			compAddBill.getTxtDocumentNo().setText(bill.getTurqBillConsignmentCommon().getBillDocumentNo());
			compAddBill.getDateConsignmentDate().setDate(bill.getBillsDate());
			compAddBill.getTxtConsignmentDocumentNo().setText(bill.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
			if (bill.isIsOpen())
			{
				compAddBill.getComboPaymentType().setText(Messages.getString("BillUIBillUpdateDialog.8")); //$NON-NLS-1$
			}
			else
			{
				compAddBill.getComboPaymentType().setText(Messages.getString("BillUIBillUpdateDialog.11")); //$NON-NLS-1$
			}
			compAddBill.getDateDueDate().setDate(bill.getDueDate());
			compAddBill.getTxtDefinition().setText(bill.getBillsDefinition());
			fillInvTransactionColumns();
			fillRegisteredGroup();
			EngUICommon.centreWindow(dialogShell);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void fillInvTransactionColumns()
	{
		compAddBill.rowList.removeAll();
		TableItem item;
		TurqInventoryTransaction invTrans;
		Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
		if (it.hasNext())
		{
			TurqConsignment cons = (TurqConsignment) it.next();
			Iterator it2 = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it2.hasNext())
			{
				invTrans = (TurqInventoryTransaction) it2.next();
				InvUITransactionTableRow row = new InvUITransactionTableRow(compAddBill.rowList, compAddBill.BILL_TYPE,
						compAddBill.tableViewer);
				row.setDBObject(invTrans);
				compAddBill.rowList.addTask(row);
			}
		}
		InvUITransactionTableRow row2 = new InvUITransactionTableRow(compAddBill.rowList, compAddBill.BILL_TYPE, compAddBill.tableViewer);
		compAddBill.rowList.addTask(row2);
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
		MessageBox msg;
		try
		{
			if (bill == null)
				return;
			if (compAddBill.verifyFields())
			{
				updated = true;
				//update the consignment
				int type = compAddBill.BILL_TYPE;
				Boolean paymentType = (Boolean) compAddBill.getComboPaymentType().getData(compAddBill.getComboPaymentType().getText());
				BillBLUpdateBill
						.updateBill(bill, compAddBill.getTxtDocumentNo().getText().trim(), compAddBill.getTxtConsignmentDocumentNo()
								.getText().trim(), compAddBill.getTxtDefinition().getText(), false, !paymentType.booleanValue(),
								compAddBill.getDateConsignmentDate().getDate(), (TurqCurrentCard) compAddBill.getTxtCurrentCard()
										.getData(), compAddBill.getTxtDiscountAmount().getBigDecimalValue(), compAddBill
										.getTxtTotalVat().getBigDecimalValue(), compAddBill.getDecSpecialVat()
										.getBigDecimalValue(), compAddBill.getTxtTotalAmount().getBigDecimalValue(), type,
								compAddBill.getAccountPickerCurAcc().getTurqAccountingAccount(), compAddBill.getDateDueDate()
										.getDate(), compAddBill.getInventoryTransactions(), compAddBill.getBillGroups(),
								EngBLCommon.getBaseCurrencyExchangeRate());
				msg = new MessageBox(this.getParent(), SWT.ICON_INFORMATION);
				msg.setMessage(Messages.getString("BillUIBillUpdateDialog.10")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			msg = new MessageBox(this.getParent(), SWT.ICON_ERROR);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
			this.dialogShell.close();
		}
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.CANCEL | SWT.OK);
		msg2.setMessage(Messages.getString("BillUIBillUpdateDialog.3")); //$NON-NLS-1$
		try
		{
			if (msg2.open() == SWT.OK)
			{
				updated = true;
				BillBLUpdateBill.deleteBill(bill);
				//TODO send boolean to delete cons
				if (EngUICommon.okToDelete(getParent(), Messages.getString("BillUIBillUpdateDialog.9"))) { //$NON-NLS-1$
					BillBLUpdateBill.deleteBillConsignment(bill);
				}
				msg.setMessage(Messages.getString("BillUIBillUpdateDialog.1")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}