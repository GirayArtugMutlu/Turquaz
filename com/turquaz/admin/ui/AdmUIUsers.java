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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
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
			boolean delete=EngUICommon.okToDelete(this.getShell()); //$NON-NLS-1$
			if (delete)
			{
				HashMap userMap=(HashMap)((ITableRow) selection[0].getData()).getDBObject();
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_USER_ID,userMap.get(AdmKeys.ADM_USER_ID));
				EngTXCommon.doTransactionTX(AdmBLUsers.class.getName(),"deleteUser",argMap);
				fillTable();
			}
		}
		}
		catch(Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());			
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
					tableColumnUsername.setText(AdmLangKeys.STR_USERNAME); //$NON-NLS-1$
					tableColumnUsername.setWidth(112);
				}
				{
					tableColumnRealName = new TableColumn(tableUsers, SWT.NONE);
					tableColumnRealName.setText(AdmLangKeys.STR_REAL_NAME); //$NON-NLS-1$
					tableColumnRealName.setWidth(150);
				}
				{
					tableColumnDescription = new TableColumn(tableUsers, SWT.NONE);
					tableColumnDescription.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
					tableColumnDescription.setWidth(200);
				}
			}
			this.layout();
			PostInitGui();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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
			HashBag usersBag = (HashBag)EngTXCommon.doSelectTX(AdmBLUsers.class.getName(),"getUsers",null);
            
            HashMap usersMap = (HashMap) usersBag.get(AdmKeys.ADM_USERS);
            
            
                        
			for (int i = 0; i < usersMap.size(); i++)
			{
                HashMap rowMap = (HashMap)usersMap.get(new Integer(i));
				tableViewer.addRow(new String[]{rowMap.get(AdmKeys.ADM_USER_NAME).toString(), rowMap.get(AdmKeys.ADM_USER_REAL_NAME).toString(), rowMap.get(AdmKeys.ADM_USER_DESCRIPTION).toString()},rowMap);
                
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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
            HashMap userMap=(HashMap)((ITableRow)items[0].getData()).getDBObject();
			boolean updated=new AdmUIUserUpdateDialog(this.getShell(), SWT.NULL, userMap).open();
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
		EngBLUtils.printTable(tableUsers, AdmLangKeys.STR_USERS); //$NON-NLS-1$
	}
}