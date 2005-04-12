package com.turquaz.consignment.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
import java.util.HashMap;
import java.util.Iterator;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import org.apache.log4j.Logger;
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
public class ConUIConsignmentUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ConUIAddConsignment compAddConsignment;
	private ToolItem toolPrint;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	TurqConsignment consignment;
	ConBLUpdateConsignment blCons = new ConBLUpdateConsignment();
	private boolean updated = false;

	public ConUIConsignmentUpdateDialog(Shell parent, int style, TurqConsignment cons)
	{
		super(parent, style);
		consignment = cons;
	}

	public boolean open()
	{
		try
		{
			preInitGUI();
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
			dialogShell.setSize(663, 593);
			dialogShell.setText(Messages.getString("ConUIConsignmentUpdateDialog.7")); //$NON-NLS-1$
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 44));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 44));
					coolItem1.setSize(45, 44);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText(Messages.getString("ConUIConsignmentUpdateDialog.0")); //$NON-NLS-1$
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
							toolDelete.setText(Messages.getString("ConUIConsignmentUpdateDialog.2")); //$NON-NLS-1$
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
							toolCancel.setText(Messages.getString("ConUIConsignmentUpdateDialog.1")); //$NON-NLS-1$
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
							toolPrint.setText(Messages.getString("ConUIConsignmentUpdateDialog.3")); //$NON-NLS-1$
							toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
							toolPrint.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									try
									{
										dialogShell.close();
										HashMap argMap=new HashMap();
										argMap.put(ConsKeys.CONS,consignment);
										EngTXCommon.doSingleTX(EngBLUtils.class.getName(),"PrintConsignment",argMap);
										
									}
									catch(Exception ex)
									{
										ex.printStackTrace();
									}
								}
							});
						}
					}
				}
			}
			{
				compAddConsignment = new ConUIAddConsignment(dialogShell, SWT.NONE);
				GridData compAddConsignmentLData = new GridData();
				compAddConsignmentLData.grabExcessHorizontalSpace = true;
				compAddConsignmentLData.horizontalAlignment = GridData.FILL;
				compAddConsignmentLData.verticalAlignment = GridData.FILL;
				compAddConsignmentLData.grabExcessVerticalSpace = true;
				compAddConsignment.setLayoutData(compAddConsignmentLData);
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

	public void preInitGUI()
	{
	}

	public void postInitGui()
	{
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		if (EngBLPermissions.getPermission(compAddConsignment.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compAddConsignment.getClass().getName()) == 3)
		{
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(ConsKeys.CONS,consignment);
			EngTXCommon.doSingleTX(ConBLUpdateConsignment.class.getName(),"initiliazeConsignment",argMap);
			
			TurqCurrentCard curCard = consignment.getTurqCurrentCard();
			compAddConsignment.getTxtCurrentCard().setText(curCard.getCardsName() + " {" + curCard.getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			compAddConsignment.getDateConsignmentDate().setDate(consignment.getConsignmentsDate());
			compAddConsignment.getTxtDocumentNo().setText(consignment.getConsignmentDocumentNo());
			compAddConsignment.getTxtBillDocumentNo().setText(consignment.getBillDocumentNo());
			if (consignment.getConsignmentsType() == 0)
			{
				compAddConsignment.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.5")); //$NON-NLS-1$
			}
			else
			{
				compAddConsignment.getComboConsignmentType().setText(Messages.getString("ConUIConsignmentUpdateDialog.6")); //$NON-NLS-1$
			}
			compAddConsignment.getTxtDefinition().setText(consignment.getConsignmentsDefinition());
			
			Iterator it = consignment.getTurqEngineSequence().getTurqBillInEngineSequences().iterator();
			if(it.hasNext())
			{
				TurqBillInEngineSequence billEng = (TurqBillInEngineSequence)it.next();
				compAddConsignment.getTxtBillDocumentNo().setText(billEng.getTurqBill().getBillDocumentNo());
			}
			
			
			fillInvTransactionColumns();
			fillRegisteredGroup();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}

	}

	public void fillRegisteredGroup()
	{
		TurqConsignmentsInGroup group;
		Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
		while (it.hasNext())
		{
			group = (TurqConsignmentsInGroup) it.next();
			compAddConsignment.getCompRegisterGroup().RegisterGroup(group.getTurqConsignmentGroup());
		}
	}

	public void fillInvTransactionColumns()
	{
		compAddConsignment.tableViewer.removeAll();
		TableItem item;
		TurqInventoryTransaction invTrans;
		Iterator it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
		while (it.hasNext())
		{
			invTrans = (TurqInventoryTransaction) it.next();
			InvUITransactionTableRow row = new InvUITransactionTableRow(consignment.getConsignmentsType(),
					compAddConsignment.tableViewer);
			row.setDBObject(invTrans);
			compAddConsignment.tableViewer.addRow(row);
		}
		InvUITransactionTableRow row2 = new InvUITransactionTableRow(consignment.getConsignmentsType(), compAddConsignment.tableViewer);
		compAddConsignment.tableViewer.addRow(row2);
		compAddConsignment.calculateTotals();
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.CANCEL | SWT.OK);
		msg2.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.9")); //$NON-NLS-1$
		try
		{
			if (msg2.open() == SWT.OK)
			{
				updated = true;
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS,consignment);
				Integer result =(Integer)EngTXCommon.doTransactionTX(ConBLUpdateConsignment.class.getName(),"deleteConsignment",argMap);
				if(result.intValue()==1)
				{
				msg.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.10")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
				//delete consignment
				}
				else if(result.intValue() ==-1)
				{
					EngUICommon.showMessageBox(getParent(),Messages.getString("ConUIConsignmentUpdateDialog.13"),SWT.ICON_WARNING); //$NON-NLS-1$
				}
					
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error(Messages.getString("ConUIConsignmentUpdateDialog.14"), ex); //$NON-NLS-1$
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void update()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		try
		{
			updated = true;
			int type = EngBLCommon.COMMON_BUY_INT;
			if (compAddConsignment.getComboConsignmentType().getText().equals(EngBLCommon.COMMON_SELL_STRING)) //$NON-NLS-1$
			{	
				type = EngBLCommon.COMMON_SELL_INT;
			}
			boolean willUpdateBill = EngUICommon.okToDelete(getParent(),Messages.getString("ConUIConsignmentUpdateDialog.15")); //$NON-NLS-1$
			
			HashMap argMap=new HashMap();
			
			argMap.put(ConsKeys.CONS,consignment);
			argMap.put(EngKeys.DOCUMENT_NO,compAddConsignment.getTxtDocumentNo().getText().trim());
			argMap.put(EngKeys.DEFINITION,compAddConsignment.getTxtDefinition().getText().trim());
			argMap.put(ConsKeys.CONS_DATE,compAddConsignment.getDateConsignmentDate().getDate());
			argMap.put(EngKeys.TYPE,new Integer(type));
			argMap.put(EngKeys.CURRENT_CARD,compAddConsignment.getTxtCurrentCard().getData());
			argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
			argMap.put(ConsKeys.CONS_GROUPS,compAddConsignment.getConsignmentGroups());
			argMap.put(InvKeys.INV_TRANSACTIONS,compAddConsignment.getInventoryTransactions(type));
			argMap.put(ConsKeys.CONS_UPDATE_BILLS,new Boolean(willUpdateBill));
			
			EngTXCommon.doTransactionTX(ConBLUpdateConsignment.class.getName(),"updateConsignment",argMap);
						
			msg.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.12")); //$NON-NLS-1$
			msg.open();
			dialogShell.close();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error(Messages.getString("ConUIConsignmentUpdateDialog.16"), ex); //$NON-NLS-1$
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}