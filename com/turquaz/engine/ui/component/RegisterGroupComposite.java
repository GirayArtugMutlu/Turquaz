package com.turquaz.engine.ui.component;

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
import java.util.Iterator;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a for-profit company or business) then you should purchase a license - please visit www.cloudgarden.com for details.
 */
public class RegisterGroupComposite extends org.eclipse.swt.widgets.Composite
{
	private TableColumn tableColumn3;
	private Table tableAllGroups;
	private Composite composite1;

	public RegisterGroupComposite(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			composite1 = new Composite(this, SWT.NULL);
			tableAllGroups = new Table(composite1, SWT.SINGLE | SWT.CHECK | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL
					| SWT.BORDER);
			tableColumn3 = new TableColumn(tableAllGroups, SWT.NULL);
			this.setSize(new org.eclipse.swt.graphics.Point(174, 188));
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.FILL;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = -1;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = true;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(174, 188));
			GridData tableAllGroupsLData = new GridData();
			tableAllGroupsLData.verticalAlignment = GridData.FILL;
			tableAllGroupsLData.horizontalAlignment = GridData.FILL;
			tableAllGroupsLData.widthHint = -1;
			tableAllGroupsLData.heightHint = -1;
			tableAllGroupsLData.horizontalIndent = 0;
			tableAllGroupsLData.horizontalSpan = 1;
			tableAllGroupsLData.verticalSpan = 1;
			tableAllGroupsLData.grabExcessHorizontalSpace = true;
			tableAllGroupsLData.grabExcessVerticalSpace = true;
			tableAllGroups.setLayoutData(tableAllGroupsLData);
			tableAllGroups.setHeaderVisible(true);
			tableAllGroups.setLinesVisible(true);
			tableAllGroups.setSize(new org.eclipse.swt.graphics.Point(134, 158));
			tableColumn3.setText(EngLangCommonKeys.STR_GROUPS); //$NON-NLS-1$
			tableColumn3.setWidth(141);
			GridLayout composite1Layout = new GridLayout(3, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 3;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
	}

	/** Auto-generated event handler method */
	public void fillTableAllGroups(HashMap elementMap)
	{
		tableAllGroups.removeAll();
		Iterator it = elementMap.keySet().iterator();
		TableItem item;
		while (it.hasNext())
		{
			item = new TableItem(tableAllGroups, SWT.NULL);
			String key = it.next().toString();
			item.setText(key);
			item.setData(elementMap.get(key));
		}
	}

	public void RegisterGroup(Object data)
	{
		TableItem items[] = tableAllGroups.getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getData().equals(data))
			{
				items[i].setChecked(true);
			}
		}
	}

	/**
	 * @return Returns the tableAllGroups.
	 */
	public Table getTableAllGroups()
	{
		return tableAllGroups;
	}
}