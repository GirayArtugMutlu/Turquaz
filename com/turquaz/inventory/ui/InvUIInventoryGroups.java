package com.turquaz.inventory.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardAdd;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUIInventoryGroups extends org.eclipse.swt.widgets.Composite
{
	private Table tableParentGroups;
	private TableColumn tableColumnParentGroups;
	private TableColumn tableColumnSubGroups;
	private Table tableSubGroups;
	private Label label1;
	private Map registeredGroups;
	Listener subTablelistener;

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
		InvUIInventoryGroups inst = new InvUIInventoryGroups(shell, SWT.NULL);
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

	public InvUIInventoryGroups(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			this.setSize(406, 240);
			{
				tableParentGroups = new Table(this, SWT.BORDER);
				GridData listParentGroupsLData = new GridData();
				tableParentGroups.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						tableParentGroupsWidgetSelected(evt);
					}
				});
				tableParentGroups.setLinesVisible(true);
				tableParentGroups.setHeaderVisible(true);
				listParentGroupsLData.widthHint = 136;
				;
				listParentGroupsLData.verticalAlignment = GridData.FILL;
				listParentGroupsLData.grabExcessVerticalSpace = true;
				tableParentGroups.setLayoutData(listParentGroupsLData);
				{
					tableColumnParentGroups = new TableColumn(tableParentGroups, SWT.NONE);
					tableColumnParentGroups.setText(InvLangKeys.STR_MAIN_GROUPS);
					tableColumnParentGroups.setWidth(147);
				}
			}
			{
				label1 = new Label(this, SWT.SEPARATOR);
				GridData label1LData = new GridData();
				label1LData.verticalAlignment = GridData.FILL;
				label1LData.widthHint = 28;
				label1LData.grabExcessVerticalSpace = true;
				label1.setLayoutData(label1LData);
			}
			{
				tableSubGroups = new Table(this, SWT.SINGLE | SWT.CHECK | SWT.BORDER);
				subTablelistener = new Listener()
				{
					public void handleEvent(Event event)
					{
						if (event.detail == SWT.CHECK)
						{
							itemChecked((TableItem) event.item);
						}
					}
				};
				tableSubGroups.addListener(SWT.Selection, subTablelistener);
				GridData tableSubGroupsLData = new GridData();
				tableSubGroups.setLinesVisible(true);
				tableSubGroups.setHeaderVisible(true);
				tableSubGroupsLData.grabExcessVerticalSpace = true;
				tableSubGroupsLData.verticalAlignment = GridData.FILL;
				tableSubGroupsLData.grabExcessHorizontalSpace = true;
				tableSubGroupsLData.horizontalAlignment = GridData.FILL;
				tableSubGroups.setLayoutData(tableSubGroupsLData);
				{
					tableColumnSubGroups = new TableColumn(tableSubGroups, SWT.NONE);
					tableColumnSubGroups.setText(InvLangKeys.STR_SUB_GROUPS);
					tableColumnSubGroups.setWidth(189);
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

	public void fillMainGroups() throws Exception
	{
		try
		{
			registeredGroups = new HashMap();
			TableItem item;
			HashBag groupBag =(HashBag)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			HashMap groupsMap=(HashMap)groupBag.get(InvKeys.INV_GROUPS);
			for (int i = 0; i < groupsMap.size(); i++)
			{
				HashMap invGroupMap = (HashMap)groupsMap.get(new Integer(i));
				item = new TableItem(tableParentGroups, SWT.NULL);
				item.setText((String)invGroupMap.get(InvKeys.INV_GROUP_NAME));
				item.setData(invGroupMap);
				registeredGroups.put(invGroupMap.get(InvKeys.INV_GROUP_ID), null);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void postInitGUI()
	{
		try
		{
			fillMainGroups();
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	private void tableParentGroupsWidgetSelected(SelectionEvent evt)
	{
		TableItem[] selection = tableParentGroups.getSelection();
		HashMap mainGroup;
		if (selection.length > 0)
		{
			TableItem item;
			tableSubGroups.removeAll();
			mainGroup = (HashMap) selection[0].getData();
			HashBag subGroupBag=(HashBag)mainGroup.get(InvKeys.INV_SUB_GROUPS);
			HashMap subGroups=(HashMap)subGroupBag.get(InvKeys.INV_SUB_GROUPS);
			
			for (int k=0; k<subGroups.size(); k++)
			{
				HashMap subGroup=(HashMap)subGroups.get(new Integer(k));
				item = new TableItem(tableSubGroups, SWT.NULL);
				item.setText((String)subGroup.get(InvKeys.INV_GROUP_NAME));
				item.setData(subGroup);
				if (registeredGroups.get(mainGroup.get(InvKeys.INV_GROUP_ID)) != null)
				{
					if (registeredGroups.get(mainGroup.get(InvKeys.INV_GROUP_ID)).equals(subGroup))
					{
						item.setChecked(true);
					}
				}
			}
		}
	}

	public void itemChecked(TableItem item)
	{
		HashMap group = (HashMap) item.getData();
		TableItem[] selectedMain=tableParentGroups.getSelection();
		HashMap mainGroup=(HashMap)selectedMain[0].getData();
		if (item.getChecked())
		{
			tableSubGroups.removeListener(SWT.Selection, subTablelistener);
			TableItem items[] = tableSubGroups.getItems();
			for (int i = 0; i < items.length; i++)
			{
				items[i].setChecked(false);
			}
			item.setChecked(true);
			registeredGroups.put(mainGroup.get(InvKeys.INV_GROUP_ID), group);
			tableSubGroups.addListener(SWT.Selection, subTablelistener);
		}
		else
		{
			registeredGroups.put(mainGroup.get(InvKeys.INV_GROUP_ID), null);
		}
	}

	public HashMap getRegisteredGroups()
	{
		HashMap regGroups=new HashMap();
		
		Iterator it=registeredGroups.keySet().iterator();
		while(it.hasNext())
		{
			Integer groupId=(Integer)it.next();
			HashMap groupMap=(HashMap)registeredGroups.get(groupId);
			if (groupMap != null)
			{
				regGroups.put(groupId,groupMap);
			}
		}
		return regGroups;
	}

}