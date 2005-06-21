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
import java.util.Date;
import java.util.HashMap;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.lang.ConsLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.InvKeys;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


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
	Integer consignmentId;
	ConBLUpdateConsignment blCons = new ConBLUpdateConsignment();
	private boolean updated = false;

	public ConUIConsignmentUpdateDialog(Shell parent, int style, Integer consId)
	{
		super(parent, style);
		this.consignmentId = consId;
	}

	public boolean open()
	{
		try
		{
			preInitGUI();
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
			dialogShell.setSize(663, 593);
			dialogShell.setText(ConsLangKeys.TITLE_CONS_UPDATE);
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
						{
							toolPrint = new ToolItem(toolBar1, SWT.NONE);
							toolPrint.setText(EngLangCommonKeys.STR_PRINT);
							toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
							toolPrint.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									try
									{
										dialogShell.close();
										HashMap argMap=new HashMap();
										argMap.put(ConsKeys.CONS_ID,consignmentId);
										EngTXCommon.doSelectTX(EngBLUtils.class.getName(),"PrintConsignment",argMap);
										
									}
									catch(Exception ex)
									{
                                        EngBLLogger.log(this.getClass(),ex,getParent());
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
            EngBLLogger.log(this.getClass(),e,getParent());
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
			argMap.put(ConsKeys.CONS_ID,consignmentId);
			
            HashBag consBag = (HashBag)EngTXCommon.doSelectTX(ConBLUpdateConsignment.class.getName(),"getConsignmentInfo",argMap);
			
			
			compAddConsignment.getTxtCurrentCard().setText((String)consBag.get(CurKeys.CUR_CURRENT_NAME) + " {" + (String)consBag.get(CurKeys.CUR_CURRENT_CODE) + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			compAddConsignment.getDateConsignmentDate().setDate((Date)consBag.get(EngKeys.DATE));
			compAddConsignment.getTxtDocumentNo().setText((String)consBag.get(EngKeys.DOCUMENT_NO));
			compAddConsignment.getTxtBillDocumentNo().setText((String)consBag.get(ConsKeys.CONS_BILL_DOC_NO));
			if (((Integer)consBag.get(EngKeys.TYPE)).intValue() == 0)
			{
				compAddConsignment.getComboConsignmentType().setText(EngLangCommonKeys.COMMON_BUY_STRING);
			}
			else
			{
				compAddConsignment.getComboConsignmentType().setText(EngLangCommonKeys.COMMON_SELL_STRING);
			}
			compAddConsignment.getTxtDefinition().setText((String)consBag.get(EngKeys.DESCRIPTION));
			
			
			if(((Boolean)consBag.get(ConsKeys.CONS_HAS_BILL)).booleanValue())
			{
				compAddConsignment.getTxtBillDocumentNo().setText((String)consBag.get(BillKeys.BILL_DOC_NO));
                compAddConsignment.getDatePickerBillDate().setText(DatePicker.formatter.format(BillKeys.BILL_DATE));
			}
			
			
			fillInvTransactionColumns();
			fillRegisteredGroup((HashMap)consBag.get(consBag.get(ConsKeys.CONS_GROUPS)));
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}

	}

	public void fillRegisteredGroup(HashMap groups)
	{
		
	     for (int i=0;i<groups.size();i++)
		{
            HashMap groupInfo =(HashMap)groups.get(new Integer(i));
			Integer groupId =(Integer)groupInfo.get(AdmKeys.ADM_GROUP_ID);
			compAddConsignment.getCompRegisterGroup().RegisterGroup(groupId);
		}
	}

	public void fillInvTransactionColumns()
	{
//		compAddConsignment.tableViewer.removeAll();
//		TableItem item;
//		TurqInventoryTransaction invTrans;
//		Iterator it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
//		while (it.hasNext())
//		{
//			invTrans = (TurqInventoryTransaction) it.next();
//			InvUITransactionTableRow row = new InvUITransactionTableRow(consignment.getConsignmentsType(),
//					compAddConsignment.tableViewer);
//			row.setDBObject(invTrans);
//			compAddConsignment.tableViewer.addRow(row);
//		}
//		InvUITransactionTableRow row2 = new InvUITransactionTableRow(consignment.getConsignmentsType(), compAddConsignment.tableViewer);
//		compAddConsignment.tableViewer.addRow(row2);
//		compAddConsignment.calculateTotals();
	}

	public void delete()
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				updated = true;
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS_ID,consignmentId);
				Integer result =(Integer)EngTXCommon.doTransactionTX(ConBLUpdateConsignment.class.getName(),"deleteConsignmentById",argMap);
				if(result.intValue()==1)
				{
					EngUICommon.showDeletedSuccesfullyMessage(getParent());
					dialogShell.close();
					//delete consignment
				}
				else if(result.intValue() ==-1)
				{
					EngUICommon.showMessageBox(getParent(),ConsLangKeys.MSG_HAS_BILL_CAN_NOT_DELETE,SWT.ICON_WARNING);
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
		try
		{
			updated = true;
			int type = EngBLCommon.COMMON_BUY_INT;
			if (compAddConsignment.getComboConsignmentType().getText().equals(EngLangCommonKeys.COMMON_SELL_STRING)) //$NON-NLS-1$
			{	
				type = EngBLCommon.COMMON_SELL_INT;
			}
			boolean willUpdateBill = EngUICommon.showQuestion(getParent(),ConsLangKeys.MSG_WILL_UPDATE_BILL);
			
			HashMap argMap=new HashMap();
			
			argMap.put(ConsKeys.CONS_ID,consignmentId);
			argMap.put(EngKeys.DOCUMENT_NO,compAddConsignment.getTxtDocumentNo().getText().trim());
			argMap.put(EngKeys.DEFINITION,compAddConsignment.getTxtDefinition().getText().trim());
			argMap.put(ConsKeys.CONS_DATE,compAddConsignment.getDateConsignmentDate().getDate());
			argMap.put(EngKeys.TYPE,new Integer(type));
			argMap.put(CurKeys.CUR_CARD_ID,compAddConsignment.getTxtCurrentCard().getCardId());
			argMap.put(EngKeys.CURRENCY_ID,EngBLClient.getBaseCurrencyId());
			argMap.put(ConsKeys.CONS_GROUPS,compAddConsignment.getConsignmentGroups());
			argMap.put(InvKeys.INV_TRANSACTIONS,compAddConsignment.getInventoryTransactions(type));
			argMap.put(ConsKeys.CONS_UPDATE_BILLS,new Boolean(willUpdateBill));
			
			EngTXCommon.doTransactionTX(ConBLUpdateConsignment.class.getName(),"updateConsignment",argMap);
			EngUICommon.showUpdatedSuccesfullyMessage(getParent());
			dialogShell.close();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}