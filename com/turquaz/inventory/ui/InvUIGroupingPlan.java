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
 * @author Huseyin Ergun
 * @version $Id$
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;


public class InvUIGroupingPlan extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private TableTree tableTreeGroups;
	private TableColumn tableColumnGroupName;
	private TableColumn tableColumnGrupDefinition;
	Menu popup;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		InvUIGroupingPlan inst = new InvUIGroupingPlan(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public InvUIGroupingPlan(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(580, 362);
			{
				tableTreeGroups = new TableTree(this, SWT.NONE);
				GridData tableTreeGroupsLData = new GridData();
				tableTreeGroupsLData.grabExcessHorizontalSpace = true;
				tableTreeGroupsLData.horizontalAlignment = GridData.FILL;
				tableTreeGroupsLData.grabExcessVerticalSpace = true;
				tableTreeGroupsLData.verticalAlignment = GridData.FILL;
				tableTreeGroups.setLayoutData(tableTreeGroupsLData);
				tableTreeGroups.getTable().setHeaderVisible(true);
				tableTreeGroups.getTable().setLinesVisible(true);
				tableTreeGroups.getTable().addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableTreeGroups_tableMouseDoubleClick(evt);
					}
				});
				{
					tableColumnGroupName = new TableColumn(tableTreeGroups.getTable(), SWT.NONE);
					tableColumnGroupName.setText(Messages.getString("InvUIGroupingPlan.0")); //$NON-NLS-1$
					tableColumnGroupName.setWidth(150);
				}
				{
					tableColumnGrupDefinition = new TableColumn(tableTreeGroups.getTable(), SWT.NONE);
					tableColumnGrupDefinition.setText(Messages.getString("InvUIGroupingPlan.1")); //$NON-NLS-1$
					tableColumnGrupDefinition.setWidth(150);
				}
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void postInitGUI()
	{
		fillTable();
		initializePopUp();
	}

	public void initializePopUp()
	{
		//Add popup menu to delete account
		popup = new Menu(getShell(), SWT.POP_UP);
		MenuItem item = new MenuItem(popup, SWT.PUSH);
		item.setText(Messages.getString("InvUIGroupingPlan.2")); //$NON-NLS-1$
		item.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event e)
			{
				TableTreeItem items[] = tableTreeGroups.getSelection();
				if (items.length > 0)
				{
					boolean isupdated = new InvUIGroupAddDialog(getShell(), SWT.NULL, (TurqInventoryGroup) items[0].getData()).open();
					if (isupdated)
					{
						fillTable();
					}
				}
			}
		});
		popup.addListener(SWT.Show, new Listener()
		{
			public void handleEvent(Event event)
			{
				TableTreeItem items[] = tableTreeGroups.getSelection();
				if (items.length > 0)
				{
					TurqInventoryGroup group = (TurqInventoryGroup) items[0].getData();
					if (group.getTurqInventoryGroup().getId().intValue() == -1)
					{
						event.doit = true;
					}
					else
					{
						event.doit = false;
						popup.setVisible(false);
					}
				}
				event.doit = false;
			}
		});
		tableTreeGroups.setMenu(popup);
	}

	public void fillTable()
	{
		try
		{
			tableTreeGroups.removeAll();
			List ls = (List)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			TableTreeItem item;
			TableTreeItem subItem;
			TurqInventoryGroup invGroup;
			for (int i = 0; i < ls.size(); i++)
			{
				invGroup = (TurqInventoryGroup) ls.get(i);
				item = new TableTreeItem(tableTreeGroups, SWT.NULL);
				item.setData(invGroup);
				item.setText(0, invGroup.getGroupsName());
				item.setText(1, invGroup.getGroupsDescription());
				Iterator it = invGroup.getTurqInventoryGroups().iterator();
				while (it.hasNext())
				{
					invGroup = (TurqInventoryGroup) it.next();
					subItem = new TableTreeItem(item, SWT.NULL);
					subItem.setData(invGroup);
					subItem.setText(0, invGroup.getGroupsName());
					subItem.setText(1, invGroup.getGroupsDescription());
					item.setExpanded(true);
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	private void tableTreeGroups_tableMouseDoubleClick(MouseEvent evt)
	{
		TableTreeItem items[] = tableTreeGroups.getSelection();
		if (items.length > 0)
		{
			boolean isupdated = new InvUIGroupUpdateDialog(getShell(), SWT.NULL, (TurqInventoryGroup) items[0].getData()).open();
			if (isupdated)
			{
				fillTable();
			}
		}
	}
	
	public void delete ()
	{
		TableTreeItem items[] = tableTreeGroups.getSelection();
		if (items.length > 0)
		{
		try
		{			
			TurqInventoryGroup mainGroup = (TurqInventoryGroup) items[0].getData();
			
			if(EngUICommon.okToDelete(getShell(),Messages.getString("InvUIGroupUpdateDialog.1"))) //$NON-NLS-1$
			{ 
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_MAIN_GROUP,mainGroup);
				EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"delete",argMap); //$NON-NLS-1$
				EngUICommon.showMessageBox(getShell(),Messages.getString("InvUIGroupUpdateDialog.6"),SWT.ICON_INFORMATION); 
				search();

			}
			
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), Messages.getString("InvUIGroupUpdateDialog.7"), SWT.ICON_ERROR); //$NON-NLS-1$
		}
		}
	}
	public void printTable ()
	{
		EngBLUtils.printTable(tableTreeGroups.getTable(), "Stok Gruplarý"); 

	}
	public void exportToExcel ()
	{
		EngBLUtils.Export2Excel(tableTreeGroups.getTable());

	}
	public void search ()
	{
		fillTable();
	}
}