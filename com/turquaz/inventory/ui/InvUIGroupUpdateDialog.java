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
import java.util.Calendar;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardUpdate;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUIGroupUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	Calendar cal = Calendar.getInstance();
	private ToolItem toolDelete;
	private ToolItem toolSave;
	private ToolItem toolCancel;
	private InvUIInventoryGroupAdd compGroupAdd;
	private ToolBar toolBar;
	private HashMap groupMap;
	boolean isUpdated = false;

	public InvUIGroupUpdateDialog(Shell parent, int style, HashMap group)
	{
		super(parent, style);
		this.groupMap = group;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
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
			dialogShell.setText(InvLangKeys.TITLE_INV_GROUPS);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433, 229));
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 433, 229);
			dialogShell.setSize(475, 331);
			{
				toolBar = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarLData = new GridData();
				toolBarLData.grabExcessHorizontalSpace = true;
				toolBarLData.horizontalAlignment = GridData.FILL;
				toolBar.setLayoutData(toolBarLData);
				{
					toolSave = new ToolItem(toolBar, SWT.NONE);
					toolSave.setText(EngLangCommonKeys.STR_UPDATE);
					toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolSaveWidgetSelected(evt);
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar, SWT.NONE);
					toolDelete.setText(EngLangCommonKeys.STR_DELETE);
					toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolDeleteWidgetSelected(evt);
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar, SWT.NONE);
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
				compGroupAdd = new InvUIInventoryGroupAdd(dialogShell, SWT.NONE);
				GridData compGroupAddLData = new GridData();
				compGroupAddLData.grabExcessHorizontalSpace = true;
				compGroupAddLData.horizontalAlignment = GridData.FILL;
				compGroupAddLData.grabExcessVerticalSpace = true;
				compGroupAddLData.verticalAlignment = GridData.FILL;
				compGroupAdd.setLayoutData(compGroupAddLData);
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

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		compGroupAdd.getTxtDefinition().setText((String)groupMap.get(InvKeys.INV_GROUP_DESCRIPTION));
		compGroupAdd.getTxtGroupName().setText((String)groupMap.get(InvKeys.INV_GROUP_NAME));
	}

	private void toolSaveWidgetSelected(SelectionEvent evt)
	{
		compGroupAdd.update((Integer)groupMap.get(InvKeys.INV_GROUP_ID));
		isUpdated = true;
		dialogShell.close();
	}

	private void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{			
			boolean okToDelete = EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{			
				isUpdated = true; 
				HashMap argMap = new HashMap();
				argMap.put(InvKeys.INV_GROUP_ID, groupMap.get(InvKeys.INV_GROUP_ID));
				EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(), "deleteInvGroup", argMap);
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