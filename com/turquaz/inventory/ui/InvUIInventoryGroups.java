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
import com.turquaz.engine.dal.TurqInventoryGroup;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.Messages;
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
					tableColumnParentGroups.setText(Messages.getString("InvUIInventoryGroups.0")); //$NON-NLS-1$
					tableColumnParentGroups.setWidth(147);
				}
			}
			{
				label1 = new Label(this, SWT.SEPARATOR);
				label1.setText("label1"); //$NON-NLS-1$
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
					tableColumnSubGroups.setText(Messages.getString("InvUIInventoryGroups.2")); //$NON-NLS-1$
					tableColumnSubGroups.setWidth(189);
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

	public void fillMainGroups() throws Exception
	{
		try
		{
			registeredGroups = new HashMap();
			TableItem item;
			TurqInventoryGroup group;
			java.util.List ls = InvBLCardAdd.getParentInventoryGroups();
			for (int i = 0; i < ls.size(); i++)
			{
				group = (TurqInventoryGroup) ls.get(i);
				item = new TableItem(tableParentGroups, SWT.NULL);
				item.setText(group.getGroupsName());
				item.setData(group);
				registeredGroups.put(group.getId(), null);
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
			ex.printStackTrace();
		}
	}

	private void tableParentGroupsWidgetSelected(SelectionEvent evt)
	{
		TableItem[] selection = tableParentGroups.getSelection();
		TurqInventoryGroup mainGroup;
		TurqInventoryGroup subGroup;
		if (selection.length > 0)
		{
			TableItem item;
			tableSubGroups.removeAll();
			mainGroup = (TurqInventoryGroup) selection[0].getData();
			Iterator it = mainGroup.getTurqInventoryGroups().iterator();
			while (it.hasNext())
			{
				subGroup = (TurqInventoryGroup) it.next();
				item = new TableItem(tableSubGroups, SWT.NULL);
				item.setText(subGroup.getGroupsName());
				item.setData(subGroup);
				if (registeredGroups.get(mainGroup.getId()) != null)
				{
					if (registeredGroups.get(mainGroup.getId()).equals(subGroup))
					{
						item.setChecked(true);
					}
				}
			}
		}
	}

	public void itemChecked(TableItem item)
	{
		TurqInventoryGroup group = (TurqInventoryGroup) item.getData();
		if (item.getChecked())
		{
			tableSubGroups.removeListener(SWT.Selection, subTablelistener);
			TableItem items[] = tableSubGroups.getItems();
			for (int i = 0; i < items.length; i++)
			{
				items[i].setChecked(false);
			}
			item.setChecked(true);
			registeredGroups.put(group.getTurqInventoryGroup().getId(), group);
			tableSubGroups.addListener(SWT.Selection, subTablelistener);
		}
		else
		{
			registeredGroups.put(group.getTurqInventoryGroup().getId(), null);
		}
	}

	public Map getRegisteredGroups()
	{
		return registeredGroups;
	}

	public void setRegisteredGroups(Map registeredGroups)
	{
		this.registeredGroups = registeredGroups;
	}
}