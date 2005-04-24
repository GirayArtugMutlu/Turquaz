package com.turquaz.admin.ui;

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
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AdmUIUsers extends org.eclipse.swt.widgets.Composite implements SecureComposite, SearchComposite
{
	private Table tableUsers;
	private TableColumn tableColumnUsername;
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnRealName;
	private SearchTableViewer tableViewer=null;

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
		AdmUIUsers inst = new AdmUIUsers(shell, SWT.NULL);
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

	public AdmUIUsers(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	public void save()
	{
	}

	public void delete()
	{
		try
		{
		TableItem[] selection=tableUsers.getSelection();
		if (selection.length > 0)
		{
			boolean delete=EngUICommon.okToDelete(this.getShell(),Messages.getString("AdmUIUsers.3")); //$NON-NLS-1$
			if (delete)
			{
				TurqUser user=(TurqUser)((ITableRow) selection[0].getData()).getDBObject();
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_USER,user);
				EngTXCommon.doTransactionTX(AdmBLUsers.class.getName(),"deleteUser",argMap);
				fillTable();
			}
		}
		}
		catch(Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();			
		}
	}

	public void newForm()
	{
		AdmUIUsers curCard = new AdmUIUsers(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void search()
	{
		fillTable();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(518, 319);
			{
				tableUsers = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
				GridData tableUsersLData = new GridData();
				tableUsers.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableUsersMouseDoubleClick(evt);
					}
				});
				tableUsers.setHeaderVisible(true);
				tableUsers.setLinesVisible(true);
				tableUsersLData.grabExcessHorizontalSpace = true;
				tableUsersLData.grabExcessVerticalSpace = true;
				tableUsersLData.horizontalAlignment = GridData.FILL;
				tableUsersLData.verticalAlignment = GridData.FILL;
				tableUsers.setLayoutData(tableUsersLData);
				{
					tableColumnUsername = new TableColumn(tableUsers, SWT.NONE);
					tableColumnUsername.setText(Messages.getString("AdmUIUsers.0")); //$NON-NLS-1$
					tableColumnUsername.setWidth(112);
				}
				{
					tableColumnRealName = new TableColumn(tableUsers, SWT.NONE);
					tableColumnRealName.setText(Messages.getString("AdmUIUsers.1")); //$NON-NLS-1$
					tableColumnRealName.setWidth(150);
				}
				{
					tableColumnDescription = new TableColumn(tableUsers, SWT.NONE);
					tableColumnDescription.setText(Messages.getString("AdmUIUsers.2")); //$NON-NLS-1$
					tableColumnDescription.setWidth(200);
				}
			}
			this.layout();
			PostInitGui();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}
	
	public void PostInitGui()
	{
		createTableViewer();
		fillTable();		
	}

	public void fillTable()
	{
		try
		{
			tableViewer.removeAll();
			List list = (List)EngTXCommon.doSelectTX(AdmBLUsers.class.getName(),"getUsers",null);
			TurqUser user;
			for (int i = 0; i < list.size(); i++)
			{
				user = (TurqUser) list.get(i);
				tableViewer.addRow(new String[]{user.getUsername(), user.getUsersRealName(), user.getUsersDescription()},user);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}
	
	public void createTableViewer()
	{
		int columnTypes[] = new int[3];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		tableViewer = new SearchTableViewer(tableUsers, columnTypes, true);
	}

	public void tableUsersMouseDoubleClick(MouseEvent evt)
	{
		TableItem items[] = tableUsers.getSelection();
		if (items.length > 0)
		{
			boolean updated=new AdmUIUserUpdateDialog(this.getShell(), SWT.NULL, (TurqUser)((ITableRow) items[0].getData()).getDBObject()).open();
			if (updated)
				fillTable();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableUsers);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableUsers, Messages.getString("AdmUIUsers.7")); //$NON-NLS-1$
	}
}