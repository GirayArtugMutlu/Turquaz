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


import java.util.Iterator;


/**
* @author  Onsel Armagan
* @version  $Id$
*/

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
import com.turquaz.admin.bl.AdmBLUserUpdate;
import com.turquaz.admin.ui.AdmUIUserAdd;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
public class AdmUIUserUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this.getParent());
	}

	private TurqUser user;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private AdmUIUserAdd compUserAdd;
	private org.eclipse.swt.widgets.Shell dialogShell;
	private AdmBLUserUpdate blUserUpdate = new AdmBLUserUpdate();

	public AdmUIUserUpdateDialog(Shell parent, int style,TurqUser user) {
		super(parent, style);
		
		this.user = user;
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShell.setSize(472, 376);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 49));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 49));
					coolItem1.setSize(45, 49);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText("Update");
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
							toolUpdate
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									update();
								}
								});
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText("Delete");
							toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
						}
					}
				}
			}
			{
				compUserAdd = new AdmUIUserAdd(dialogShell, SWT.NONE);
				GridData compUserAddLData = new GridData();
				compUserAddLData.grabExcessHorizontalSpace = true;
				compUserAddLData.grabExcessVerticalSpace = true;
				compUserAddLData.horizontalAlignment = GridData.FILL;
				compUserAddLData.verticalAlignment = GridData.FILL;
				compUserAdd.setLayoutData(compUserAddLData);
			}

			postInitGui();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void postInitGui(){
		
		compUserAdd.getTxtUsername().setText(user.getUsername());
		compUserAdd.getTxtPassword().setText(user.getUsersPassword());
		compUserAdd.getTxtRePassword().setText(user.getUsersPassword());
		compUserAdd.getTxtRealName().setText(user.getUsersRealName());
		compUserAdd.getTxtDescription().setText(user.getUsersDescription());
		
		compUserAdd.getTxtUsername().setEditable(false);
		Iterator it = user.getTurqUserGroups().iterator();
		while(it.hasNext()){
			TurqUserGroup userGroup = (TurqUserGroup)it.next();
		   compUserAdd.getRegisteredGroups().RegisterGroup(userGroup.getTurqGroup());
			
		}
	
	}
	public void update(){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		try{
		if(compUserAdd.verifyFields()){
		
			blUserUpdate.updateUser(compUserAdd.getTxtPassword().getText(),compUserAdd.getTxtRealName().getText(),
									compUserAdd.getTxtDescription().getText(),user);	
			
			
			Iterator it = user.getTurqUserGroups().iterator();
			while(it.hasNext()){
			blUserUpdate.deleteObject(it.next());
		    }
			compUserAdd.saveUserGroups(user.getUsersId());
			msg.setMessage("Succesfully Updated!..");
			msg.open();
			dialogShell.close();
		}
				
		}
		catch(Exception ex){
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
		
	}
	public void delete(){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.OK|SWT.CANCEL);
		msg2.setMessage("Really Delete?");
		try{
			if(msg2.open()==SWT.OK){
			Iterator it = user.getTurqUserGroups().iterator();
			while(it.hasNext()){
			blUserUpdate.deleteObject(it.next());
		    }
			 it = user.getTurqUserPermissions().iterator();
			while(it.hasNext()){
			blUserUpdate.deleteObject(it.next());
		    }
			blUserUpdate.deleteObject(user);
			msg.setMessage("Deleted Succesfully?");
			msg.open();
			
			this.dialogShell.close();
			}
			
		}
		catch(Exception ex){
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	
	
	public void open(){
		try{
			
		Shell parent = getParent();
		dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
         initGUI();
		
		
		dialogShell.layout();
		dialogShell.pack();
		
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
