package com.turquaz.admin.ui;

import java.awt.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.admin.bl.AdmBLUserPermissions;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.dal.TurqModule;
import com.turquaz.engine.dal.TurqModuleComponent;
import com.turquaz.engine.dal.TurqUser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class AdmUIUserPermissions extends org.eclipse.swt.widgets.Composite {
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
	private AdmBLUsers blUsers = new AdmBLUsers();
	private AdmBLUserPermissions blUserPerms = new AdmBLUserPermissions();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUIUserPermissions inst = new AdmUIUserPermissions(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
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

	public AdmUIUserPermissions(org.eclipse.swt.widgets.Composite parent, int style) {
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
					lblUsers = new CLabel(composite1, SWT.NONE);
					lblUsers.setText("Users");
					GridData lblUsersLData = new GridData();
					lblUsersLData.widthHint = 74;
					lblUsersLData.heightHint = 17;
					lblUsers.setLayoutData(lblUsersLData);
				}
				{
					comboUsers = new CCombo(composite1, SWT.NONE);
					GridData comboUsersLData = new GridData();
					comboUsersLData.widthHint = 118;
					comboUsersLData.heightHint = 16;
					comboUsers.setLayoutData(comboUsersLData);
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
					comboModules.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							moduleSelected(evt);
						}
					});
					comboModulesLData.widthHint = 118;
					comboModulesLData.heightHint = 14;
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
					comboModuleComponents.setSize(118, 16);
					comboModuleComponentsLData.widthHint = 118;
					comboModuleComponentsLData.heightHint = 16;
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
					comboPermissionLevelLData.widthHint = 25;
					comboPermissionLevelLData.heightHint = 17;
					comboPermissionLevel
						.setLayoutData(comboPermissionLevelLData);
				}
			}
			{
				tableUserPermissions = new Table(this, SWT.NONE);
				GridData table1LData = new GridData();
				tableUserPermissions.setLinesVisible(true);
				tableUserPermissions.setHeaderVisible(true);
				table1LData.verticalAlignment = GridData.FILL;
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalAlignment = GridData.FILL;
				tableUserPermissions.setLayoutData(table1LData);
				{
					tableColumnUser = new TableColumn(
						tableUserPermissions,
						SWT.NONE);
					tableColumnUser.setText("User");
					tableColumnUser.setWidth(100);
				}
				{
					tableColumnModule = new TableColumn(
						tableUserPermissions,
						SWT.NONE);
					tableColumnModule.setText("Module");
					tableColumnModule.setWidth(109);
				}
				{
					tableColumnModuleComponent = new TableColumn(
						tableUserPermissions,
						SWT.NONE);
					tableColumnModuleComponent.setText("Module Component");
					tableColumnModuleComponent.setWidth(120);
				}
				{
					tableColumnPermissionLevel = new TableColumn(
						tableUserPermissions,
						SWT.NONE);
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
	public void postInitGUI(){
		try{
		java.util.List userList = blUsers.getUsers();
		for(int i=0;i<userList.size();i++){
			TurqUser user = (TurqUser)userList.get(i);
			comboUsers.setData(user.getUsername(),user);
			comboUsers.add(user.getUsername());
			
		}
		java.util.List moduleList = blUserPerms.getModules();
		for(int i=0;i<userList.size();i++){
			TurqModule user = (TurqModule)moduleList.get(i);
			comboModules.setData(user.getModulesName(),user);
			comboModules.add(user.getModulesName());
		
		}
		comboPermissionLevel.add("0");
		comboPermissionLevel.add("1");
		comboPermissionLevel.add("2");
		comboPermissionLevel.add("3");
		
		
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void moduleSelected(SelectionEvent evt){
	try{
		if(comboModules.getText().equals("*")){
		comboModuleComponents.removeAll();	
		}
		else{
		
		comboModuleComponents.removeAll();
		TurqModule module = (TurqModule)comboModules.getData(comboModules.getText());
		fillComboModuleComponents(module.getModulesId().intValue());
			
		}
		
		
	}
	catch(Exception ex){
		
	}
	}
	public void fillComboModuleComponents(int module_id){
		try{
			java.util.List compList = blUserPerms.getModuleComponents(module_id);
			for(int i=0;i<compList.size();i++){
				TurqModuleComponent user = (TurqModuleComponent)compList.get(i);
				comboModuleComponents.setData(user.getComponentsName(),user);
				comboModuleComponents.add(user.getComponentsName());
			
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
