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
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.admin.bl.AdmBLGroupPermissions;
import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqGroupPermission;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserPermission;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;

public class AdmUIGroupPermissions extends org.eclipse.swt.widgets.Composite
implements SecureComposite{

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

	private AdmBLGroups blGroups = new AdmBLGroups();

	private AdmBLGroupPermissions blGroupPerms = new AdmBLGroupPermissions();

	/**
	 * Auto-generated main method to display this
	 * org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args) {
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite
	 * inside a new Shell.
	 */
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUIUserPermissions inst = new AdmUIUserPermissions(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AdmUIGroupPermissions(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(492, 342);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.BEGINNING;
				composite1LData.heightHint = 122;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 2;
				composite1.setLayout(composite1Layout);
				{
					lblGroups = new CLabel(composite1, SWT.NONE);
					lblGroups.setText("Groups");
					GridData lblUsersLData = new GridData();
					lblUsersLData.widthHint = 74;
					lblUsersLData.heightHint = 17;
					lblGroups.setLayoutData(lblUsersLData);
				}
				{
					comboGroups = new CCombo(composite1, SWT.NONE);
					GridData comboUsersLData = new GridData();
					comboGroups.setBackground(SWTResourceManager.getColor(255,
							255, 255));
					comboGroups.setEditable(false);
					comboUsersLData.widthHint = 118;
					comboUsersLData.heightHint = 16;
					comboGroups.setLayoutData(comboUsersLData);
				}
				{
					lblModules = new CLabel(composite1, SWT.NONE);
					lblModules.setText("Modules");
					GridData lblModulesLData = new GridData();
					lblModulesLData.widthHint = 67;
					lblModulesLData.heightHint = 17;
					lblModules.setLayoutData(lblModulesLData);
				}
				{
					comboModules = new CCombo(composite1, SWT.NONE);
					GridData comboModulesLData = new GridData();
					comboModules.setBackground(SWTResourceManager.getColor(255,
							255, 255));
					comboModules.setEditable(false);
					comboModules.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							moduleSelected(evt);
						}
					});
					comboModulesLData.widthHint = 174;
					comboModulesLData.heightHint = 16;
					comboModules.setLayoutData(comboModulesLData);
				}
				{
					lblModuleComponents = new CLabel(composite1, SWT.NONE);
					lblModuleComponents.setText("Module Components");
					GridData lblModuleComponentsLData = new GridData();
					lblModuleComponentsLData.widthHint = 128;
					lblModuleComponentsLData.heightHint = 18;
					lblModuleComponents.setLayoutData(lblModuleComponentsLData);
				}
				{
					comboModuleComponents = new CCombo(composite1, SWT.NONE);
					GridData comboModuleComponentsLData = new GridData();
					comboModuleComponents.setBackground(SWTResourceManager
							.getColor(255, 255, 255));
					comboModuleComponents.setEditable(false);
					comboModuleComponentsLData.widthHint = 176;
					comboModuleComponentsLData.heightHint = 14;
					comboModuleComponents
							.setLayoutData(comboModuleComponentsLData);
				}
				{
					lblPermissionLevel = new CLabel(composite1, SWT.NONE);
					lblPermissionLevel.setText("Permission Level");
				}
				{
					comboPermissionLevel = new CCombo(composite1, SWT.NONE);
					GridData comboPermissionLevelLData = new GridData();
					comboPermissionLevel.setBackground(SWTResourceManager
							.getColor(255, 255, 255));
					comboPermissionLevel.setEditable(false);
					comboPermissionLevelLData.widthHint = 25;
					comboPermissionLevelLData.heightHint = 17;
					comboPermissionLevel
							.setLayoutData(comboPermissionLevelLData);
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
					tableColumnGroup = new TableColumn(tableGroupPermissions,
							SWT.NONE);
					tableColumnGroup.setText("Group");
					tableColumnGroup.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(tableGroupPermissions,
							SWT.NONE);
					tableColumnModule.setText("Module");
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(
							tableGroupPermissions, SWT.NONE);
					tableColumnModuleComponent.setText("Module Component");
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(
							tableGroupPermissions, SWT.NONE);
					tableColumnPermissionLevel.setText("Permission Level");
					tableColumnPermissionLevel.setWidth(104);
				}
			}
			this.layout();
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void postInitGUI() {
		try {

			java.util.List groupList = blGroups.getGroups();
			for (int i = 0; i < groupList.size(); i++) {
				TurqGroup group = (TurqGroup) groupList.get(i);
				comboGroups.setData(group.getGroupsName(), group);
				comboGroups.add(group.getGroupsName());

			}

			java.util.List moduleList = blGroupPerms.getModules();
			System.out.println(moduleList.size());
			for (int i = 0; i < moduleList.size(); i++) {
				TurqModule module = (TurqModule) moduleList.get(i);
				comboModules.setData(module.getModulesName(), module);
				comboModules.add(module.getModulesName());

			}
			comboPermissionLevel.add("0");
			comboPermissionLevel.add("1");
			comboPermissionLevel.add("2");
			comboPermissionLevel.add("3");

			fillTableUserPermissions();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void moduleSelected(SelectionEvent evt) {
		try {
			if (comboModules.getText().equals("*")) {
				comboModuleComponents.removeAll();
				TurqModuleComponent modComp = new TurqModuleComponent();
				modComp.setModuleComponentsId(new Integer(-1));
				comboModuleComponents.setText("*");
				comboModuleComponents.add("*");
				comboModuleComponents.setData("*", modComp);

			} else {

				comboModuleComponents.removeAll();
				TurqModule module = (TurqModule) comboModules
						.getData(comboModules.getText());
				fillComboModuleComponents(module.getModulesId().intValue());

			}

		} catch (Exception ex) {

		}
	}

	public void fillComboModuleComponents(int module_id) {
		try {
			java.util.List compList = blGroupPerms
					.getModuleComponents(module_id);
			for (int i = 0; i < compList.size(); i++) {
				TurqModuleComponent group = (TurqModuleComponent) compList
						.get(i);
				comboModuleComponents.setData(group.getComponentsDescription(),
						group);
				comboModuleComponents.add(group.getComponentsDescription());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void fillTableUserPermissions() {
		try {
			tableGroupPermissions.removeAll();
			java.util.List groupPermList = blGroupPerms.getGroupPermissions();
			TableItem item;

			String groupname;
			String module;
			String moduleComp;
			String permLevel;

			for (int i = 0; i < groupPermList.size(); i++) {

				TurqGroupPermission groupPerm = (TurqGroupPermission) groupPermList
						.get(i);
				groupname = groupPerm.getTurqGroup().getGroupsName();
				module = groupPerm.getTurqModule().getModulesName();

				if (module.trim().equals("*")) {
					moduleComp = "*";

				} else {
					moduleComp = groupPerm.getTurqModuleComponent()
							.getComponentsDescription();
				}
				permLevel = groupPerm.getGroupPermissionsLevel() + "";

				item = new TableItem(tableGroupPermissions, SWT.NULL);
				item.setData(groupPerm);

				item.setText(new String[] { groupname, module, moduleComp,
						permLevel });

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public boolean verifyFields(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		
		
		if(comboGroups.getSelectionIndex()==-1){
	    	msg.setMessage("Please Choose a Group !");
			msg.open();
			return false;
		}
	    else if(comboModules.getSelectionIndex()==-1){
	    	msg.setMessage("Please Choose Module !");
			msg.open();
			return false;
		}
		else if(comboModuleComponents.getData(comboModuleComponents.getText())== null){
			msg.setMessage("Please Choose Module Component!");
			msg.open();
			return false;
		}
		
		else if(comboPermissionLevel.getText().trim().length()==0){
			msg.setMessage("Please Choose a Permission Level");
			msg.open();
			return false;
		}
		
		return true;
	}
	
	public void save(){
		try{
			if(verifyFields()){
			blGroupPerms.saveGroupPermission(comboGroups.getData(comboGroups.getText()),
										comboModules.getData(comboModules.getText()),
										comboModuleComponents.getData(comboModuleComponents.getText()),
										Integer.parseInt(comboPermissionLevel.getText()));	
			
			newForm();
			fillTableUserPermissions();
			
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage("Succesfully Saved!");
			msg.open();
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}
	public void delete(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.OK|SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getShell(),SWT.NULL);
		msg.setMessage("Really Delete?");
		
	try{
		if(msg.open()==SWT.OK){
			
		
		TableItem items[]=tableGroupPermissions.getSelection();
		if(items.length>0){
		blGroupPerms.deleteObject(items[0].getData());	
		fillTableUserPermissions();
		msg2.setMessage("Succesfully Deleted!..");
	    msg2.open();
		
		}
	}
		
		
		
		
	}
	catch(Exception ex){
		ex.printStackTrace();
		msg2.setMessage(ex.getMessage());
	    msg2.open();
	}
		
		
		
	}
	public void search(){
		
	}
	public void newForm(){
		
	}

}