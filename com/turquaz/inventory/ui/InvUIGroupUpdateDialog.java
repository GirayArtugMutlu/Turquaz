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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.SWT;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.Messages;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.bl.InvBLCardAdd;
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
	private InvBLCardAdd blCardAdd = new InvBLCardAdd();
	Calendar cal = Calendar.getInstance();
	private ToolItem toolDelete;
	private ToolItem toolSave;
	private ToolItem toolCancel;
	private InvUIInventoryGroupAdd compGroupAdd;
	private ToolBar toolBar;
	TurqInventoryGroup mainGroup;
	boolean isUpdated = false;

	public InvUIGroupUpdateDialog(Shell parent, int style, TurqInventoryGroup mainGroup)
	{
		super(parent, style);
		this.mainGroup = mainGroup;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
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
			dialogShell.setText(Messages.getString("InvUIGroupAddDialog.7")); //$NON-NLS-1$
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
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
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
					toolSave.setText(Messages.getString("InvUIGroupUpdateDialog.0")); //$NON-NLS-1$
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
					toolDelete.setText(Messages.getString("InvUIGroupUpdateDialog.2")); //$NON-NLS-1$
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
					toolCancel.setText(Messages.getString("InvUIGroupUpdateDialog.4")); //$NON-NLS-1$
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
			e.printStackTrace();
			return false;
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
		compGroupAdd.getTxtDefinition().setText(mainGroup.getGroupsDescription());
		compGroupAdd.getTxtGroupName().setText(mainGroup.getGroupsName());
	}

	private void toolSaveWidgetSelected(SelectionEvent evt)
	{
		compGroupAdd.update(mainGroup);
		isUpdated = true;
		dialogShell.close();
	}

	private void toolCancelWidgetSelected(SelectionEvent evt)
	{
		dialogShell.close();
	}

	private void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			/*
			 * if(EngUICommon.okToDelete(getParent())){ new InvBLCardUpdate().deleteObject(mainGroup) ;
			 * EngUICommon.showMessageBox(getParent(),Messages.getString("InvUIGroupUpdateDialog.6"),SWT.ICON_INFORMATION); //$NON-NLS-1$
			 * isUpdated = true; dialogShell.close(); }
			 */
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			EngUICommon.showMessageBox(getParent(), Messages.getString("InvUIGroupUpdateDialog.7"), SWT.ICON_ERROR); //$NON-NLS-1$
		}
	}
}