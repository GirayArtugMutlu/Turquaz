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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLGroupPermissions;
import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.admin.bl.AdmBLUserPermissions;
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
					lblGroups.setText(EngLangCommonKeys.STR_GROUPS); //$NON-NLS-1$
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
					comboModulesLData.widthHint = 134;
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
					comboModuleComponentsLData.widthHint = 134;
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
					tableColumnGroup.setText(EngLangCommonKeys.STR_GROUP_NAME); //$NON-NLS-1$
					tableColumnGroup.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnModule.setText(AdmLangKeys.STR_MODULE); //$NON-NLS-1$
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(tableGroupPermissions, SWT.NONE);
					tableColumnModuleComponent.setText(AdmLangKeys.STR_MODULE_COMPONENT); //$NON-NLS-1$
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(tableGroupPermissions, SWT.NONE);
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
			HashBag groupBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroups.class.getName(),"getGroups",null);
			
            HashMap groupMap = (HashMap)groupBag.get(AdmKeys.ADM_GROUP);
            
            
            for (int i = 0; i < groupMap.size(); i++)
			{
				HashMap rowMap = (HashMap)groupMap.get(new Integer(i));
                
				comboGroups.setData(rowMap.get(AdmKeys.ADM_GROUP_NAME).toString(), rowMap.get(AdmKeys.ADM_GROUP_ID));
				comboGroups.add(rowMap.get(AdmKeys.ADM_GROUP_NAME).toString());
			}
			HashBag moduleBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModules",null);
            
            HashMap moduleMap = (HashMap)moduleBag.get(AdmKeys.ADM_MODULE);
            
			for (int i = 0; i < moduleMap.size(); i++)
			{
                HashMap rowMap = (HashMap)moduleMap.get(new Integer(i));
                
				comboModules.setData(rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString(), rowMap.get(AdmKeys.ADM_MODULE_ID ));
				comboModules.add(rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString());
			}
			
            HashBag userPermBag = (HashBag)EngTXCommon.doSelectTX(AdmBLUserPermissions.class.getName(),"getUserPermissonLevels",null);
			
            HashMap userPermMap = (HashMap)userPermBag.get(AdmKeys.ADM_USER_PERMISSION);
            
            for (int i=0; i<userPermBag.size(); i++)
			{
                HashMap rowMap = (HashMap)userPermMap.get(new Integer(i));
                			
                comboPermissionLevel.setData(rowMap.get(AdmKeys.ADM_USER_PERMISSION_DESCRIPTION).toString(),AdmKeys.ADM_USER_PERMISSION_ID);
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
			if (comboModules.getText().equals("*")) { //$NON-NLS-1$
				comboModuleComponents.removeAll();
				comboModuleComponents.setText("*"); //$NON-NLS-1$
				comboModuleComponents.add("*"); //$NON-NLS-1$
				comboModuleComponents.setData("*", new Integer (-1)); //$NON-NLS-1$
			}
			else
			{
				comboModuleComponents.removeAll();
				Integer moduleId = (Integer) comboModules.getData(comboModules.getText());
				fillComboModuleComponents(moduleId.intValue());
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
			HashBag compListBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getModuleComponents",argMap);
            
            HashMap compListMap = (HashMap)compListBag.get(AdmKeys.ADM_MODULE_COMP);
            
			for (int i = 0; i < compListMap.size(); i++)
			{
				//TurqModuleComponent group = (TurqModuleComponent) compList.get(i);
                
                HashMap rowMap = (HashMap)compListMap.get(new Integer(i));
				comboModuleComponents.setData(rowMap.get(AdmKeys.ADM_MODULE_COMP_DESCRIPTION).toString(), AdmKeys.ADM_MODULE_COMP_ID);
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
			tableGroupPermissions.removeAll();
			HashBag groupPermBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroupPermissions.class.getName(),"getGroupPermissions",null);
			TableItem item;
			String groupname;
			String module;
			String moduleComp;
			String permLevel;
            
            HashMap groupPermMap = (HashMap)groupPermBag.get(AdmKeys.ADM_GROUP_PERMISSION);
            
            
			for (int i = 0; i < groupPermMap.size(); i++)
			{
                HashMap rowMap = (HashMap)groupPermMap.get(new Integer(i));
			//	TurqGroupPermission groupPerm = (TurqGroupPermission) groupPermList.get(i);
				groupname = rowMap.get(AdmKeys.ADM_GROUP_NAME).toString();
				module = rowMap.get(AdmKeys.ADM_MODULE_DESCRIPTION).toString();
				if (module.trim().equals("*")) { //$NON-NLS-1$
					moduleComp = "*"; //$NON-NLS-1$
				}
				else
				{
					moduleComp = rowMap.get(AdmKeys.ADM_MODULE_COMP_DESCRIPTION).toString();
				}
				// print error if it does not take the permissons
		
                permLevel ="";
				if (((Integer)rowMap.get(AdmKeys.ADM_GROUP_PERMISSION_LEVEL)).intValue() == 0)
				{
					permLevel = AdmLangKeys.STR_NONE; //$NON-NLS-1$
				}
				else if (((Integer)rowMap.get(AdmKeys.ADM_GROUP_PERMISSION_LEVEL)).intValue() == 1)
				{
					permLevel = AdmLangKeys.STR_READ;
				}
				else if (((Integer)rowMap.get(AdmKeys.ADM_GROUP_PERMISSION_LEVEL)).intValue() == 2)
				{
					permLevel = AdmLangKeys.STR_READ_WRITE;
                }
				else if (((Integer)rowMap.get(AdmKeys.ADM_GROUP_PERMISSION_LEVEL)).intValue() == 3)
				{
					permLevel = AdmLangKeys.STR_READ_WRITE_DELETE;
				}
				item = new TableItem(tableGroupPermissions, SWT.NULL);
				item.setData(rowMap.get(AdmKeys.ADM_GROUP_PERMISSION_ID));
				item.setText(new String[]{groupname, module, moduleComp, permLevel});
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
		if (comboGroups.getData(comboGroups.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_GROUP); //$NON-NLS-1$
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
				
				argMap.put(AdmKeys.ADM_GROUP_ID,comboGroups.getData(comboGroups.getText().trim()));
				argMap.put(AdmKeys.ADM_MODULE,comboModules.getData(comboModules.getText().trim()));
				argMap.put(AdmKeys.ADM_MODULE_COMP,comboModuleComponents.getData(comboModuleComponents.getText().trim()));
				argMap.put(AdmKeys.ADM_LEVEL,comboPermissionLevel.getData(comboPermissionLevel.getText().trim()));
				
				EngTXCommon.doTransactionTX(AdmBLGroupPermissions.class.getName(),"saveGroupPermission",argMap);
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

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getShell(), SWT.NULL);
		msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); 
		try
		{
			if (msg.open() == SWT.OK)
			{
				TableItem items[] = tableGroupPermissions.getSelection();
				if (items.length > 0)
				{
					HashMap argMap=new HashMap();
					argMap.put(AdmKeys.ADM_GROUP_PERMISSION_ID,items[0].getData());
					EngTXCommon.doTransactionTX(AdmBLGroupPermissions.class.getName(),"deleteGroupPermission",argMap);
					fillTableUserPermissions();
					msg2.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); 
					msg2.open();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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