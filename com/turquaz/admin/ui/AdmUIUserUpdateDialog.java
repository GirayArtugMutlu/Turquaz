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

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLUserUpdate;
import com.turquaz.admin.ui.AdmUIUserAdd;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
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
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
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
			dialogShell.setText(Messages.getString("AdmUIUserUpdateDialog.3")); //$NON-NLS-1$
			dialogShell.setLayout(dialogShellLayout);
			dialogShell.setSize(472, 376);
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
			compUserAdd.saveUserGroups(user.getId());
			msg.setMessage(Messages.getString("AdmUIUserUpdateDialog.4")); //$NON-NLS-1$
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
		msg2.setMessage(Messages.getString("AdmUIUserUpdateDialog.5")); //$NON-NLS-1$
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
			msg.setMessage(Messages.getString("AdmUIUserUpdateDialog.6")); //$NON-NLS-1$
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
        {
            toolBar1 = new ToolBar(dialogShell, SWT.NONE);
            GridData toolBar1LData = new GridData();
            toolBar1LData.grabExcessHorizontalSpace = true;
            toolBar1LData.horizontalAlignment = GridData.FILL;
            toolBar1.setLayoutData(toolBar1LData);
            {
                toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                toolUpdate.setText(Messages
                    .getString("AdmUIUserUpdateDialog.0")); //$NON-NLS-1$
                toolUpdate.setImage(SWTResourceManager
                    .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                toolUpdate.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        update();
                    }
                });
            }
            {
                toolDelete = new ToolItem(toolBar1, SWT.NONE);
                toolDelete.setText(Messages
                    .getString("AdmUIUserUpdateDialog.2")); //$NON-NLS-1$
                toolDelete.setImage(SWTResourceManager
                    .getImage("icons/Delete16.gif")); //$NON-NLS-1$
            }
            {
                toolCancel = new ToolItem(toolBar1, SWT.NONE);
                toolCancel.setText(Messages
                    .getString("AdmUIUserUpdateDialog.1")); //$NON-NLS-1$
                toolCancel.setImage(SWTResourceManager
                    .getImage("icons/cancel.jpg")); //$NON-NLS-1$
                toolCancel.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                        dialogShell.close();
                    }
                });
            }
        }
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
