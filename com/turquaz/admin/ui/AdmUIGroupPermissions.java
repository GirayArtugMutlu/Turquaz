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
import org.eclipse.swt.widgets.MessageBox;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLGroupPermissions;
import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqGroupPermission;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;

public class AdmUIGroupPermissions extends org.eclipse.swt.widgets.Composite implements SecureComposite, SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite composite1;
	private Table tableGroupPermissions;
	private CLabel lblModules;
	private CCombo comboModules;
	private CLabel lblModuleComponents;
	private TableColumn tableColumnPermissionLevel;
	private CCombo comboPermissionLevel;
	private TableColumn tableColumnModuleComponent;
	private TableColumn tableColumnModule;
	private TableColumn tableColumnGroup;
	private CLabel lblPermissionLevel;
	private CCombo comboModuleComponents;
	private CCombo comboGroups;
	private CLabel lblGroups;

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
		AdmUIUserPermissions inst = new AdmUIUserPermissions(shell, SWT.NULL);
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

	public AdmUIGroupPermissions(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(492, 342);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.BEGINNING;
				composite1LData.heightHint = 104;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 2;
				composite1Layout.verticalSpacing = 3;
				composite1.setLayout(composite1Layout);
				{
					lblGroups = new CLabel(composite1, SWT.NONE);
					lblGroups.setText(Messages.getString("AdmUIGroupPermissions.0")); //$NON-NLS-1$
					GridData lblUsersLData = new GridData();
					lblUsersLData.widthHint = 74;
					lblUsersLData.heightHint = 17;
					lblGroups.setLayoutData(lblUsersLData);
				}
				{
					comboGroups = new CCombo(composite1, SWT.NONE);
					GridData comboUsersLData = new GridData();
					comboGroups.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboGroups.setEditable(false);
					comboUsersLData.widthHint = 134;
					comboUsersLData.heightHint = 17;
					comboGroups.setLayoutData(comboUsersLData);
				}
				{
					lblModules = new CLabel(composite1, SWT.NONE);
					lblModules.setText(Messages.getString("AdmUIGroupPermissions.1")); //$NON-NLS-1$
					GridData lblModulesLData = new GridData();
					lblModulesLData.widthHint = 67;
					lblModulesLData.heightHint = 17;
					lblModules.setLayoutData(lblModulesLData);
				}
				{
					comboModules = new CCombo(composite1, SWT.NONE);
					GridData comboModulesLData = new GridData();
					comboModules.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboModules.setEditable(false);
					comboModules.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							moduleSelected(evt);
						}
					});
					comboModulesLData.widthHint = 134;
					comboModulesLData.heightHint = 17;
					comboModules.setLayoutData(comboModulesLData);
				}
				{
					lblModuleComponents = new CLabel(composite1, SWT.NONE);
					lblModuleComponents.setText(Messages.getString("AdmUIGroupPermissions.2")); //$NON-NLS-1$
					GridData lblModuleComponentsLData = new GridData();
					lblModuleComponentsLData.widthHint = 128;
					lblModuleComponentsLData.heightHint = 18;
					lblModuleComponents.setLayoutData(lblModuleComponentsLData);
				}
				{
					comboModuleComponents = new CCombo(composite1, SWT.NONE);
					GridData comboModuleComponentsLData = new GridData();
					comboModuleComponents.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboModuleComponents.setEditable(false);
					comboModuleComponentsLData.widthHint = 134;
					comboModuleComponentsLData.heightHint = 17;
					comboModuleComponents.setLayoutData(comboModuleComponentsLData);
				}
				{
					lblPermissionLevel = new CLabel(composite1, SWT.NONE);
					lblPermissionLevel.setText(Messages.getString("AdmUIGroupPermissions.3")); //$NON-NLS-1$
				}
				{
					comboPermissionLevel = new CCombo(composite1, SWT.NONE);
					GridData comboPermissionLevelLData = new GridData();
					comboPermissionLevel.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboPermissionLevel.setEditable(false);
					comboPermissionLevelLData.widthHint = 134;
					comboPermissionLevelLData.heightHint = 17;
					comboPermissionLevel.setLayoutData(comboPermissionLevelLData);
				}
			}
			{
				tableGroupPermissions = new Table(this, SWT.NONE);
				GridData table1LData = new GridData();
				tableGroupPermissions.setLinesVisible(true);
				tableGroupPermissions.setHeaderVisible(true);
				table1LData.verticalAlignment = GridData.FILL;
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalAlignment = GridData.FILL;
				tableGroupPermissions.setLayoutData(table1LData);
				{
					tableColumnGroup = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnGroup.setText(Messages.getString("AdmUIGroupPermissions.4")); //$NON-NLS-1$
					tableColumnGroup.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnModule.setText(Messages.getString("AdmUIGroupPermissions.5")); //$NON-NLS-1$
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnModuleComponent.setText(Messages.getString("AdmUIGroupPermissions.6")); //$NON-NLS-1$
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnPermissionLevel.setText(Messages.getString("AdmUIGroupPermissions.7")); //$NON-NLS-1$
					tableColumnPermissionLevel.setWidth(120);
				}
			}
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void postInitGUI()
	{
		try
		{
			List groupList =(List)EngTXCommon.doSingleTX(AdmBLGroups.class.getName(),"getGroups",null);
			for (int i = 0; i < groupList.size(); i++)
			{
				TurqGroup group = (TurqGroup) groupList.get(i);
				comboGroups.setData(group.getGroupsDescription(), group);
				comboGroups.add(group.getGroupsDescription());
			}
			List moduleList =(List)EngTXCommon.doSingleTX(AdmBLGroupPermissions.class.getName(),"getModules",null);
			for (int i = 0; i < moduleList.size(); i++)
			{
				TurqModule module = (TurqModule) moduleList.get(i);
				comboModules.setData(module.getModuleDescription(), module);
				comboModules.add(module.getModuleDescription());
			}
			comboPermissionLevel.add("None"); //$NON-NLS-1$
			comboPermissionLevel.setData("None", new Integer(0)); //$NON-NLS-1$
			comboPermissionLevel.add("Read"); //$NON-NLS-1$
			comboPermissionLevel.setData("Read", new Integer(1)); //$NON-NLS-1$
			comboPermissionLevel.add("Read/Write"); //$NON-NLS-1$
			comboPermissionLevel.setData("Read/Write", new Integer(2)); //$NON-NLS-1$
			comboPermissionLevel.add("Read/Write/Delete"); //$NON-NLS-1$
			comboPermissionLevel.setData("Read/Write/Delete", new Integer(3)); //$NON-NLS-1$
			comboPermissionLevel.setText("None"); //$NON-NLS-1$
			fillTableUserPermissions();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void moduleSelected(SelectionEvent evt)
	{
		try
		{
			if (comboModules.getText().equals("*")) { //$NON-NLS-1$
				comboModuleComponents.removeAll();
				TurqModuleComponent modComp = new TurqModuleComponent();
				modComp.setId(new Integer(-1));
				comboModuleComponents.setText("*"); //$NON-NLS-1$
				comboModuleComponents.add("*"); //$NON-NLS-1$
				comboModuleComponents.setData("*", modComp); //$NON-NLS-1$
			}
			else
			{
				comboModuleComponents.removeAll();
				TurqModule module = (TurqModule) comboModules.getData(comboModules.getText());
				fillComboModuleComponents(module.getId().intValue());
			}
		}
		catch (Exception ex)
		{
		}
	}

	public void fillComboModuleComponents(int module_id)
	{
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(AdmKeys.ADM_MODULE_ID,new Integer(module_id));
			List compList =(List)EngTXCommon.doSingleTX(AdmBLGroupPermissions.class.getName(),"getModuleComponents",argMap);
			for (int i = 0; i < compList.size(); i++)
			{
				TurqModuleComponent group = (TurqModuleComponent) compList.get(i);
				comboModuleComponents.setData(group.getComponentsDescription(), group);
				comboModuleComponents.add(group.getComponentsDescription());
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void fillTableUserPermissions()
	{
		try
		{
			tableGroupPermissions.removeAll();
			List groupPermList =(List)EngTXCommon.doSingleTX(AdmBLGroupPermissions.class.getName(),"getGroupPermissions",null);
			TableItem item;
			String groupname;
			String module;
			String moduleComp;
			String permLevel;
			for (int i = 0; i < groupPermList.size(); i++)
			{
				TurqGroupPermission groupPerm = (TurqGroupPermission) groupPermList.get(i);
				groupname = groupPerm.getTurqGroup().getGroupsName();
				module = groupPerm.getTurqModule().getModuleDescription();
				if (module.trim().equals("*")) { //$NON-NLS-1$
					moduleComp = "*"; //$NON-NLS-1$
				}
				else
				{
					moduleComp = groupPerm.getTurqModuleComponent().getComponentsDescription();
				}
				// print error if it does not take the permissons
				permLevel = Messages.getString("AdmUIGroupPermissions.13"); //$NON-NLS-1$
				if (groupPerm.getGroupPermissionsLevel() == 0)
				{
					permLevel = Messages.getString("AdmUIGroupPermissions.14"); //$NON-NLS-1$
				}
				else if (groupPerm.getGroupPermissionsLevel() == 1)
				{
					permLevel = Messages.getString("AdmUIGroupPermissions.15"); //$NON-NLS-1$
				}
				else if (groupPerm.getGroupPermissionsLevel() == 2)
				{
					permLevel = Messages.getString("AdmUIGroupPermissions.16"); //$NON-NLS-1$
				}
				else if (groupPerm.getGroupPermissionsLevel() == 3)
				{
					permLevel = Messages.getString("AdmUIGroupPermissions.17"); //$NON-NLS-1$
				}
				item = new TableItem(tableGroupPermissions, SWT.NULL);
				item.setData(groupPerm);
				item.setText(new String[]{groupname, module, moduleComp, permLevel});
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (comboGroups.getSelectionIndex() == -1)
		{
			msg.setMessage(Messages.getString("AdmUIGroupPermissions.19")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModules.getSelectionIndex() == -1)
		{
			msg.setMessage(Messages.getString("AdmUIGroupPermissions.20")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModuleComponents.getData(comboModuleComponents.getText()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIGroupPermissions.21")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboPermissionLevel.getData(comboPermissionLevel.getText().trim()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIGroupPermissions.22")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		return true;
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(AdmKeys.ADM_GROUP,comboGroups.getData(comboGroups.getText().trim()));
				argMap.put(AdmKeys.ADM_MODULE,comboModules.getData(comboModules.getText().trim()));
				argMap.put(AdmKeys.ADM_MODULE_COMP,comboModuleComponents.getData(comboModuleComponents.getText().trim()));
				argMap.put(AdmKeys.ADM_LEVEL,comboPermissionLevel.getData(comboPermissionLevel.getText().trim()));
				
				EngTXCommon.doTransactionTX(AdmBLGroupPermissions.class.getName(),"saveGroupPermission",argMap);
				newForm();
				fillTableUserPermissions();
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("AdmUIGroupPermissions.23")); //$NON-NLS-1$
				msg.open();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getShell(), SWT.NULL);
		msg.setMessage(Messages.getString("AdmUIGroupPermissions.24")); //$NON-NLS-1$
		try
		{
			if (msg.open() == SWT.OK)
			{
				TableItem items[] = tableGroupPermissions.getSelection();
				if (items.length > 0)
				{
					HashMap argMap=new HashMap();
					argMap.put(EngKeys.OBJECT,items[0].getData());
					EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"delete",argMap);
					fillTableUserPermissions();
					msg2.setMessage(Messages.getString("AdmUIGroupPermissions.25")); //$NON-NLS-1$
					msg2.open();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg2.setMessage(ex.getMessage());
			msg2.open();
		}
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableGroupPermissions, "Grup ?zinleri");
	}

	public void search()
	{
	}

	public void newForm()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableGroupPermissions);
	}
}