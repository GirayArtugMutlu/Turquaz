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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardUpdate;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class InvUIGroupingPlan extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private TableTree tableTreeGroups;
	private TableColumn tableColumnGroupName;
	private TableColumn tableColumnGrupDefinition;
	Menu popup;

	
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
					tableColumnGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME);
					tableColumnGroupName.setWidth(150);
				}
				{
					tableColumnGrupDefinition = new TableColumn(tableTreeGroups.getTable(), SWT.NONE);
					tableColumnGrupDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
					tableColumnGrupDefinition.setWidth(150);
				}
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
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
		item.setText(InvLangKeys.STR_NEW_SUB_GROUP);
		item.addListener(SWT.Selection, new Listener()
		{
			public void handleEvent(Event e)
			{
				TableTreeItem items[] = tableTreeGroups.getSelection();
				if (items.length > 0)
				{
					HashMap groupMap=(HashMap)items[0].getData();
					Integer groupId=(Integer)groupMap.get(InvKeys.INV_GROUP_ID);
					boolean isupdated = new InvUIGroupAddDialog(getShell(), SWT.NULL,groupId).open();
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
					HashMap groupMap=(HashMap)items[0].getData();
					Integer parentId=(Integer)groupMap.get(InvKeys.INV_PARENT_GROUP_ID);
					if (parentId.intValue() == -1)
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
			HashBag groupBag = (HashBag)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			HashMap groups=(HashMap)groupBag.get(InvKeys.INV_GROUPS);
			TableTreeItem item;
			TableTreeItem subItem;
			//TurqInventoryGroup invGroup;
			for (int i = 0; i < groups.size(); i++)
			{
				HashMap invGroup = (HashMap) groups.get(new Integer(i));
				item = new TableTreeItem(tableTreeGroups, SWT.NULL);
				item.setData(invGroup);
				item.setText(0,(String) invGroup.get(InvKeys.INV_GROUP_NAME));
				item.setText(1,(String) invGroup.get(InvKeys.INV_GROUP_DESCRIPTION));
				
				HashBag subGroupBag=(HashBag)invGroup.get(InvKeys.INV_SUB_GROUPS);
				HashMap subGroups=(HashMap)subGroupBag.get(InvKeys.INV_SUB_GROUPS);
				for(int k=0; k<subGroups.size(); k++)
				{
					HashMap subGroup = (HashMap) subGroups.get(new Integer(k));
					subItem = new TableTreeItem(item, SWT.NULL);
					subItem.setData(subGroup);
					subItem.setText(0,(String) subGroup.get(InvKeys.INV_GROUP_NAME));
					subItem.setText(1,(String) subGroup.get(InvKeys.INV_GROUP_DESCRIPTION));
					item.setExpanded(true);
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	private void tableTreeGroups_tableMouseDoubleClick(MouseEvent evt)
	{
		TableTreeItem items[] = tableTreeGroups.getSelection();
		if (items.length > 0)
		{
			boolean isupdated = new InvUIGroupUpdateDialog(getShell(), SWT.NULL, (HashMap) items[0].getData()).open();
			if (isupdated)
			{
				fillTable();
			}
		}
	}
	
	public void delete()
	{
		try
		{
			TableTreeItem items[] = tableTreeGroups.getSelection();
			if (items.length > 0)
			{
				boolean okToDelte = EngUICommon.okToDelete(getShell());
				if (okToDelte)
				{
					HashMap group = (HashMap) items[0].getData();
					
					HashMap argMap = new HashMap();
					argMap.put(InvKeys.INV_GROUP_ID, group.get(InvKeys.INV_GROUP_ID));
					EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(), "deleteInvGroup", argMap);
					EngUICommon.showDeletedSuccesfullyMessage(getShell());
					search();
				}
			}
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getShell());
		}
	}
	public void printTable ()
	{
		EngBLUtils.printTable(tableTreeGroups.getTable(), InvLangKeys.STR_INV_GROUPS); 

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