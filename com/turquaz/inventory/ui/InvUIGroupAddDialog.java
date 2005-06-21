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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.ui.EngUICommon;
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
public class InvUIGroupAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolSave;
	private ToolItem toolCancel;
	private InvUIInventoryGroupAdd compGroupAdd;
	private ToolBar toolBar;
	private Integer mainGroupId;
	private boolean isUpdated = false;

	public InvUIGroupAddDialog(Shell parent, int style, Integer mainGroupId)
	{
		super(parent, style);
		this.mainGroupId = mainGroupId;
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
			dialogShell.setText(InvLangKeys.TITLE_INV_SUB_GROUP_ADD);
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
			dialogShell.setSize(467, 230);
			{
				toolBar = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarLData = new GridData();
				toolBarLData.grabExcessHorizontalSpace = true;
				toolBarLData.horizontalAlignment = GridData.FILL;
				toolBar.setLayoutData(toolBarLData);
				{
					toolSave = new ToolItem(toolBar, SWT.NONE);
					toolSave.setText(EngLangCommonKeys.STR_SAVE);
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
					toolCancel = new ToolItem(toolBar, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolCancelWidgetSelected(evt);
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
	}

	private void toolSaveWidgetSelected(SelectionEvent evt)
	{
		compGroupAdd.save(mainGroupId);
		isUpdated = true;
		dialogShell.close();
	}

	private void toolCancelWidgetSelected(SelectionEvent evt)
	{
		dialogShell.close();
	}
}