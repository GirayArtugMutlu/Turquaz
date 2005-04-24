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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
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
import com.turquaz.admin.bl.AdmBLUserPermissions;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserPermission;
import com.turquaz.engine.dal.TurqUserPermissionLevel;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;

public class AdmUIUserPermissions extends org.eclipse.swt.widgets.Composite implements SecureComposite, SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite composite1;
	private Table tableUserPermissions;
	private CLabel lblModules;
	private CCombo comboModules;
	private CLabel lblModuleComponents;
	private TableColumn tableColumnPermissionLevel;
	private CCombo comboPermissionLevel;
	private TableColumn tableColumnModuleComponent;
	private TableColumn tableColumnModule;
	private TableColumn tableColumnUser;
	private CLabel lblPermissionLevel;
	private CCombo comboModuleComponents;
	private CCombo comboUsers;
	private CLabel lblUsers;

	public AdmUIUserPermissions(org.eclipse.swt.widgets.Composite parent, int style)
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
				composite1LData.heightHint = 102;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 2;
				composite1Layout.verticalSpacing = 3;
				composite1.setLayout(composite1Layout);
				{
					lblUsers = new CLabel(composite1, SWT.NONE);
					lblUsers.setText(Messages.getString("AdmUIUserPermissions.0")); //$NON-NLS-1$
					GridData lblUsersLData = new GridData();
					lblUsersLData.widthHint = 74;
					lblUsersLData.heightHint = 17;
					lblUsers.setLayoutData(lblUsersLData);
				}
				{
					comboUsers = new CCombo(composite1, SWT.NONE);
					GridData comboUsersLData = new GridData();
					comboUsers.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboUsers.setEditable(false);
					comboUsersLData.widthHint = 135;
					comboUsersLData.heightHint = 17;
					comboUsers.setLayoutData(comboUsersLData);
				}
				{
					lblModules = new CLabel(composite1, SWT.NONE);
					lblModules.setText(Messages.getString("AdmUIUserPermissions.1")); //$NON-NLS-1$
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
					comboModulesLData.widthHint = 135;
					comboModulesLData.heightHint = 17;
					comboModules.setLayoutData(comboModulesLData);
				}
				{
					lblModuleComponents = new CLabel(composite1, SWT.NONE);
					lblModuleComponents.setText(Messages.getString("AdmUIUserPermissions.2")); //$NON-NLS-1$
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
					comboModuleComponentsLData.widthHint = 135;
					comboModuleComponentsLData.heightHint = 17;
					comboModuleComponents.setLayoutData(comboModuleComponentsLData);
				}
				{
					lblPermissionLevel = new CLabel(composite1, SWT.NONE);
					lblPermissionLevel.setText(Messages.getString("AdmUIUserPermissions.3")); //$NON-NLS-1$
				}
				{
					comboPermissionLevel = new CCombo(composite1, SWT.NONE);
					GridData comboPermissionLevelLData = new GridData();
					comboPermissionLevel.setBackground(SWTResourceManager.getColor(255, 255, 255));
					comboPermissionLevel.setEditable(false);
					comboPermissionLevelLData.widthHint = 135;
					comboPermissionLevelLData.heightHint = 17;
					comboPermissionLevel.setLayoutData(comboPermissionLevelLData);
				}
			}
			{
				tableUserPermissions = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
				GridData table1LData = new GridData();
				tableUserPermissions.setLinesVisible(true);
				tableUserPermissions.setHeaderVisible(true);
				table1LData.verticalAlignment = GridData.FILL;
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalAlignment = GridData.FILL;
				tableUserPermissions.setLayoutData(table1LData);
				{
					tableColumnUser = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnUser.setText(Messages.getString("AdmUIUserPermissions.4")); //$NON-NLS-1$
					tableColumnUser.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnModule.setText(Messages.getString("AdmUIUserPermissions.5")); //$NON-NLS-1$
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnModuleComponent.setText(Messages.getString("AdmUIUserPermissions.6")); //$NON-NLS-1$
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnPermissionLevel.setText(Messages.getString("AdmUIUserPermissions.7")); //$NON-NLS-1$
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
			List userList =(List)EngTXCommon.doSelectTX(AdmBLUsers.class.getName(),"getUsers",null);
			for (int i = 0; i < userList.size(); i++)
			{
				TurqUser user = (TurqUser) userList.get(i);
				comboUsers.setData(user.getUsername(), user);
				comboUsers.add(user.getUsername());
			}
			List moduleList =(List)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModules",null);
			for (int i = 0; i < moduleList.size(); i++)
			{
				TurqModule module = (TurqModule) moduleList.get(i);
				comboModules.setData(module.getModuleDescription(), module);
				comboModules.add(module.getModuleDescription());
			}
			List permissionLevels=(List)EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"getUserPermissonLevels",null);
			for (int i=0; i<permissionLevels.size(); i++)
			{
				TurqUserPermissionLevel perLevel=(TurqUserPermissionLevel)permissionLevels.get(i);
				comboPermissionLevel.setData(perLevel.getPermissionDescription(),perLevel);
				comboPermissionLevel.add(perLevel.getPermissionDescription());
			}
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
			TurqModule module=(TurqModule)comboModules.getData(comboModules.getText());
			if (module != null)
			{
				comboModuleComponents.removeAll();
				TurqModuleComponent modComp = new TurqModuleComponent();
				modComp.setId(new Integer(-1));
				comboModuleComponents.setText("*");
				comboModuleComponents.add("*");
				comboModuleComponents.setData("*",modComp);
				if (module.getId().intValue()!=-1)
				{
					fillComboModuleComponents(module.getId().intValue());
				}
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
			List compList =(List)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModuleComponents",argMap);
			for (int i = 0; i < compList.size(); i++)
			{
				TurqModuleComponent modComp = (TurqModuleComponent) compList.get(i);
				comboModuleComponents.setData(modComp.getComponentsDescription(), modComp);
				comboModuleComponents.add(modComp.getComponentsDescription());
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
			tableUserPermissions.removeAll();
			List userPermList =(List)EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"getUserPermissions",null);
			TableItem item;
			String username;
			String module;
			String moduleComp;
			String permLevel;
			for (int i = 0; i < userPermList.size(); i++)
			{
				TurqUserPermission userPerm = (TurqUserPermission) userPermList.get(i);
				username = userPerm.getTurqUser().getUsername();
				module = userPerm.getTurqModule().getModuleDescription();
				if (module.trim().equals("*")) { //$NON-NLS-1$
					moduleComp = "*"; //$NON-NLS-1$
				}
				else
				{
					moduleComp = userPerm.getTurqModuleComponent().getComponentsDescription();
				}
				permLevel = userPerm.getTurqUserPermissionLevel().getPermissionDescription();
				item = new TableItem(tableUserPermissions, SWT.NULL);
				item.setData(userPerm);
				item.setText(new String[]{username, module, moduleComp, permLevel});
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
		if (comboUsers.getData(comboUsers.getText()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIUserPermissions.20")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModules.getData(comboModules.getText()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIUserPermissions.21")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModuleComponents.getData(comboModuleComponents.getText()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIUserPermissions.22")); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboPermissionLevel.getData(comboPermissionLevel.getText()) == null)
		{
			msg.setMessage(Messages.getString("AdmUIUserPermissions.23")); //$NON-NLS-1$
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
				
				argMap.put(AdmKeys.ADM_USER,comboUsers.getData(comboUsers.getText()));
				argMap.put(AdmKeys.ADM_MODULE,comboModules.getData(comboModules.getText()));
				argMap.put(AdmKeys.ADM_MODULE_COMP,comboModuleComponents.getData(comboModuleComponents.getText()));
				argMap.put(AdmKeys.ADM_LEVEL,comboPermissionLevel.getData(comboPermissionLevel.getText()));
				
				EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"saveUserPermission",argMap);
				newForm();
				fillTableUserPermissions();
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("AdmUIUserPermissions.24")); //$NON-NLS-1$
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

	public void search()
	{
		comboUsers.setText(""); //$NON-NLS-1$
		comboModules.setText(""); //$NON-NLS-1$
		comboModuleComponents.setText(""); //$NON-NLS-1$
		comboPermissionLevel.setText(""); //$NON-NLS-1$
	}

	public void newForm()
	{
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getShell(), SWT.NULL);
		msg.setMessage(Messages.getString("AdmUIUserPermissions.29")); //$NON-NLS-1$
		try
		{
			if (msg.open() == SWT.OK)
			{
				TableItem items[] = tableUserPermissions.getSelection();
				if (items.length > 0)
				{
					HashMap argMap=new HashMap();
					argMap.put(AdmKeys.ADM_PERMISSION,items[0].getData());
					EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"delete",argMap);
					fillTableUserPermissions();
					msg2.setMessage(Messages.getString("AdmUIUserPermissions.30")); //$NON-NLS-1$
					msg2.open();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg2.setMessage("Hata Olustu!");
			msg2.open();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableUserPermissions);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableUserPermissions, "Kullan?c? ?zinleri");
	}
}