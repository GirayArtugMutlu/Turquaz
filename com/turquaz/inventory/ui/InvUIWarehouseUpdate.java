package com.turquaz.inventory.ui;

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
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.HashMap;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import com.turquaz.inventory.bl.InvBLWarehouseUpdate;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;

public class InvUIWarehouseUpdate extends org.eclipse.swt.widgets.Dialog
{
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolWarehouseUpdate;
	private CoolItem coolWarehouseUpdate;
	private CoolBar coolBarInvUIWarehouse;
	private InvUIWarehouseAdd compInvUIWarehouse;
	private Shell dialogShell;
	private Integer warehouseId;
	private ToolItem toolCancel;

	public InvUIWarehouseUpdate(Shell parent, int style, Integer whId)
	{
		super(parent, style);
		warehouseId = whId;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public void open()
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
			dialogShell.setText(InvLangKeys.TITLE_WAREHOUSE_UPDATE);
			coolBarInvUIWarehouse = new CoolBar(dialogShell, SWT.NULL);
			coolWarehouseUpdate = new CoolItem(coolBarInvUIWarehouse, SWT.NULL);
			toolWarehouseUpdate = new ToolBar(coolBarInvUIWarehouse, SWT.NULL);
			toolUpdate = new ToolItem(toolWarehouseUpdate, SWT.NULL);
			toolDelete = new ToolItem(toolWarehouseUpdate, SWT.NULL);
			compInvUIWarehouse = new InvUIWarehouseAdd(dialogShell, SWT.BORDER);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(518, 428));
			GridData coolBarInvUIWarehouseLData = new GridData();
			coolBarInvUIWarehouseLData.verticalAlignment = GridData.CENTER;
			coolBarInvUIWarehouseLData.horizontalAlignment = GridData.FILL;
			coolBarInvUIWarehouseLData.widthHint = -1;
			coolBarInvUIWarehouseLData.heightHint = -1;
			coolBarInvUIWarehouseLData.horizontalIndent = 0;
			coolBarInvUIWarehouseLData.horizontalSpan = 1;
			coolBarInvUIWarehouseLData.verticalSpan = 1;
			coolBarInvUIWarehouseLData.grabExcessHorizontalSpace = false;
			coolBarInvUIWarehouseLData.grabExcessVerticalSpace = false;
			coolBarInvUIWarehouse.setLayoutData(coolBarInvUIWarehouseLData);
			coolWarehouseUpdate.setControl(toolWarehouseUpdate);
			coolWarehouseUpdate.setSize(new org.eclipse.swt.graphics.Point(87, 38));
			coolWarehouseUpdate.setPreferredSize(new org.eclipse.swt.graphics.Point(87, 38));
			coolWarehouseUpdate.setMinimumSize(new org.eclipse.swt.graphics.Point(87, 38));
			toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
			final org.eclipse.swt.graphics.Image toolUpdateýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass()
					.getClassLoader().getResourceAsStream("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.setImage(toolUpdateýmage);
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolUpdateWidgetSelected(evt);
				}
			});
			toolDelete.setText(EngLangCommonKeys.STR_DELETE);
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass()
					.getClassLoader().getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolWarehouseUpdate, SWT.NONE);
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
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolDeleteWidgetSelected(evt);
				}
			});
			GridData compInvUIWarehouseLData = new GridData();
			compInvUIWarehouseLData.verticalAlignment = GridData.FILL;
			compInvUIWarehouseLData.horizontalAlignment = GridData.FILL;
			compInvUIWarehouseLData.widthHint = -1;
			compInvUIWarehouseLData.heightHint = -1;
			compInvUIWarehouseLData.horizontalIndent = 0;
			compInvUIWarehouseLData.horizontalSpan = 1;
			compInvUIWarehouseLData.verticalSpan = 1;
			compInvUIWarehouseLData.grabExcessHorizontalSpace = true;
			compInvUIWarehouseLData.grabExcessVerticalSpace = true;
			compInvUIWarehouse.setLayoutData(compInvUIWarehouseLData);
			compInvUIWarehouse.setSize(new org.eclipse.swt.graphics.Point(504, 371));
			compInvUIWarehouse.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
					toolUpdateýmage.dispose();
					toolDeleteýmage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 518, 428);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		if (EngBLPermissions.getPermission(compInvUIWarehouse.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compInvUIWarehouse.getClass().getName()) == 3)
		{
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}
        
        try{
        
        HashMap argMap = new HashMap();
        argMap.put(InvKeys.INV_WAREHOUSE_ID,warehouseId);
        
        
        HashBag resultBag = (HashBag)EngTXCommon.doSelectTX(InvBLWarehouseSearch.class.getName(),"getWarehouseInfo",argMap);
        
		compInvUIWarehouse.getTxtTelephone().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_TEL));
		compInvUIWarehouse.getTxtWarehouseAdres().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_ADDRESS));
		compInvUIWarehouse.getTxtWarehouseCity().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_CITY));
		compInvUIWarehouse.getTxtWarehouseName().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_NAME));
		compInvUIWarehouse.getTxtWarehouseDescription().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_DESC));
		compInvUIWarehouse.getTxtWarehouseCode().setText((String)resultBag.get(InvKeys.INV_WAREHOUSE_CODE));
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getParent());
        }
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		try
		{
			if (!compInvUIWarehouse.verifyFields())
				return;
			
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_WAREHOUSE_ID,warehouseId);
			argMap.put(InvKeys.INV_WAREHOUSE_NAME,compInvUIWarehouse.getTxtWarehouseName().getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_CODE,compInvUIWarehouse.getTxtWarehouseCode().getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_DESC,compInvUIWarehouse.getTxtWarehouseDescription().getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_ADDRESS,compInvUIWarehouse.getTxtWarehouseAdres().getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_TEL,compInvUIWarehouse.getTxtTelephone().getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_CITY,compInvUIWarehouse.getTxtWarehouseCity().getText().trim());
			
			EngTXCommon.doTransactionTX(InvBLWarehouseUpdate.class.getName(),"updateWarehouse",argMap);
			EngUICommon.showUpdatedSuccesfullyMessage(getParent());
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				// if the warehouse card contains transactions
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_WAREHOUSE_ID,warehouseId);
				
				Boolean hasTX=(Boolean)EngTXCommon.doSelectTX(InvBLWarehouseUpdate.class.getName(),"hasTransactions",argMap);
				if (hasTX.booleanValue())
				{
					EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_WAREHOUSE_HAS_TRANSACTION,SWT.ICON_WARNING);
					return;
				}
				EngTXCommon.doTransactionTX(InvBLWarehouseUpdate.class.getName(),"deleteWarehouse",argMap);
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				this.dialogShell.dispose();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}