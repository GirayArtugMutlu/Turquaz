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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLGroupPermissions;
import com.turquaz.admin.bl.AdmBLUserPermissions;
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
					lblUsers.setText(AdmLangKeys.STR_USERS); //$NON-NLS-1$
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
					lblModules.setText(AdmLangKeys.STR_MODULES); //$NON-NLS-1$
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
					lblModuleComponents.setText(AdmLangKeys.STR_MODULE_COMPONENTS); //$NON-NLS-1$
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
					lblPermissionLevel.setText(AdmLangKeys.STR_PERMISION_LEVEL); //$NON-NLS-1$
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
					tableColumnUser.setText(AdmLangKeys.STR_USERNAME); //$NON-NLS-1$
					tableColumnUser.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnModule.setText(AdmLangKeys.STR_MODULE); //$NON-NLS-1$
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnModuleComponent.setText(AdmLangKeys.STR_MODULE_COMPONENT); //$NON-NLS-1$
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(tableUserPermissions, SWT.NONE);
					tableColumnPermissionLevel.setText(AdmLangKeys.STR_PERMISION_LEVEL); //$NON-NLS-1$
					tableColumnPermissionLevel.setWidth(120);
				}
			}
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGUI()
	{
		try
		{
			HashBag userBag =(HashBag)EngTXCommon.doSelectTX(AdmBLUsers.class.getName(),"getUsers",null);
            
            HashMap userMap = (HashMap) userBag.get(AdmKeys.ADM_USERS);
            
			for (int i = 0; i < userMap.size(); i++)
			{
                HashMap rowMap = (HashMap)userMap.get(new Integer(i));
                
                
				comboUsers.setData(rowMap.get(AdmKeys.ADM_USER_NAME).toString(), rowMap.get(AdmKeys.ADM_USER_ID));
				comboUsers.add(rowMap.get(AdmKeys.ADM_USER_NAME).toString());
			}
			HashBag moduleBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModules",null);
           
            HashMap moduleMap = (HashMap)moduleBag.get(AdmKeys.ADM_MODULE);
            
            
            for (int i = 0; i < moduleMap.size(); i++)
			{
                HashMap rowMap = (HashMap)moduleMap.get(new Integer(i));
                
				comboModules.setData(rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString(), rowMap.get(AdmKeys.ADM_MODULE_ID));
				comboModules.add(rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString());
			}
			HashBag userPermBag =(HashBag)EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"getUserPermissonLevels",null);
            
            HashMap userPermMap = (HashMap)userPermBag.get(AdmKeys.ADM_USER_PERMISSION);
            
			for (int i=0; i<userPermMap.size(); i++)
			{
                HashMap rowMap = (HashMap)userPermMap.get(new Integer(i));
                
				comboPermissionLevel.setData(rowMap.get(AdmKeys.ADM_USER_PERMISSION_DESCRIPTION).toString(),rowMap.get(AdmKeys.ADM_USER_PERMISSION_ID));
				comboPermissionLevel.add(rowMap.get(AdmKeys.ADM_USER_PERMISSION_DESCRIPTION).toString());
			}
			fillTableUserPermissions();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void moduleSelected(SelectionEvent evt)
	{
		try
		{
			Integer moduleId = (Integer)comboModules.getData(comboModules.getText());
			
            if (moduleId != null)
			{
				comboModuleComponents.removeAll();
                
				comboModuleComponents.setText("*");
				comboModuleComponents.add("*");
				comboModuleComponents.setData("*",new Integer (-1));
                
				if (moduleId.intValue()!=-1)
				{
					fillComboModuleComponents(moduleId.intValue());
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
            
			HashBag moduleCompBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModuleComponents",argMap);
            
            HashMap moduleCompMap = (HashMap) moduleCompBag.get(AdmKeys.ADM_MODULE_COMP);
            
			for (int i = 0; i < moduleCompBag.size(); i++)
			{
                HashMap rowMap = (HashMap)moduleCompMap.get(new Integer(i));
                
				comboModuleComponents.setData(rowMap.get(AdmKeys.ADM_MODULE_COMP_DESCRIPTION).toString(), rowMap.get(AdmKeys.ADM_MODULE_COMP_ID));
				comboModuleComponents.add(rowMap.get(AdmKeys.ADM_MODULE_COMP_DESCRIPTION).toString());
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void fillTableUserPermissions()
	{
		try
		{
			tableUserPermissions.removeAll();
			HashBag userPermBag =(HashBag)EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"getUserPermissions",null);
            
            HashMap userPermMap = (HashMap) userPermBag.get(AdmKeys.ADM_USER_PERMISSION);
            
			TableItem item;
			String username;
			String module;
			String moduleComp;
			String permLevel;
            
            
			for (int i = 0; i < userPermMap.size(); i++)
			{
                HashMap rowMap = (HashMap)userPermMap.get(new Integer(i));
                
				username = rowMap.get(AdmKeys.ADM_USER_NAME).toString();
				module = rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString();
				if (module.trim().equals("*")) { //$NON-NLS-1$
					moduleComp = "*"; //$NON-NLS-1$
				}
				else
				{
					moduleComp = rowMap.get(AdmKeys.ADM_MODULE_COMP_DESCRIPTION).toString();
				}
				permLevel = rowMap.get(AdmKeys.ADM_USER_PERMISSION_DESCRIPTION).toString();
				item = new TableItem(tableUserPermissions, SWT.NULL);
				item.setData(rowMap.get(AdmKeys.ADM_USER_PERMISSION_ID));
				item.setText(new String[]{username, module, moduleComp, permLevel});
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (comboUsers.getData(comboUsers.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_USER); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModules.getData(comboModules.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_MODULE); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboModuleComponents.getData(comboModuleComponents.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_MODULE_COMPONENT); //$NON-NLS-1$
			msg.open();
			return false;
		}
		else if (comboPermissionLevel.getData(comboPermissionLevel.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_PERMISSION_LEVEL); //$NON-NLS-1$
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
				
				argMap.put(AdmKeys.ADM_USER_ID,comboUsers.getData(comboUsers.getText()));
				argMap.put(AdmKeys.ADM_MODULE_ID,comboModules.getData(comboModules.getText()));
				argMap.put(AdmKeys.ADM_MODULE_COMP_ID,comboModuleComponents.getData(comboModuleComponents.getText()));
				argMap.put(AdmKeys.ADM_LEVEL_ID,comboPermissionLevel.getData(comboPermissionLevel.getText()));
				
				EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"saveUserPermission",argMap);
				newForm();
				fillTableUserPermissions();
				EngUICommon.showSavedSuccesfullyMessage(getShell());
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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
		msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); //$NON-NLS-1$
		try
		{
			if (msg.open() == SWT.OK)
			{
				TableItem items[] = tableUserPermissions.getSelection();
				if (items.length > 0)
				{
					HashMap argMap=new HashMap();
					argMap.put(AdmKeys.ADM_USER_PERMISSION_ID,items[0].getData());
					EngTXCommon.doTransactionTX(AdmBLUserPermissions.class.getName(),"deleteUserPermission",argMap);
					fillTableUserPermissions();
					msg2.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
					msg2.open();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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