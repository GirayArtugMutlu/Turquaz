package com.turquaz.inventory.ui;

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

import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.HibernateException;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;


import com.cloudgarden.resource.SWTResourceManager;


import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
public class InvUIGroupAddDialog extends org.eclipse.swt.widgets.Dialog {
	private Button btnGroupAdd;
	private Button btnUpdate;
	private Button btnDelete;
	private Text txtDescription;
	private CLabel lblDescription;
	private Text txtGroupName;
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnName;
	private Table tableInvGroups;
	private CLabel lblGroupName;
	private Composite compGroupAddDialog;
	private Shell dialogShell;
    private InvBLCardAdd blCardAdd = new InvBLCardAdd();
    Calendar cal = Calendar.getInstance();
	public InvUIGroupAddDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}

			dialogShell.setText(Messages.getString("InvUIGroupAddDialog.7")); //$NON-NLS-1$
			compGroupAddDialog = new Composite(dialogShell,SWT.NULL);
			lblGroupName = new CLabel(compGroupAddDialog,SWT.NULL);
			txtGroupName = new Text(compGroupAddDialog,SWT.BORDER);
			lblDescription = new CLabel(compGroupAddDialog,SWT.NULL);
			txtDescription = new Text(compGroupAddDialog,SWT.SINGLE| SWT.BORDER);
			btnDelete = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			btnUpdate = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			btnGroupAdd = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			tableInvGroups = new Table(dialogShell,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnName = new TableColumn(tableInvGroups,SWT.NULL);
			tableColumnDescription = new TableColumn(tableInvGroups,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433,229));
	
			GridData compGroupAddDialogLData = new GridData();
			compGroupAddDialogLData.horizontalAlignment = GridData.FILL;
			compGroupAddDialogLData.heightHint = 98;
			compGroupAddDialogLData.grabExcessHorizontalSpace = true;
			compGroupAddDialog.setLayoutData(compGroupAddDialogLData);
			compGroupAddDialog.setBackground(SWTResourceManager.getColor(255, 255, 255));
	
			GridData lblGroupNameLData = new GridData();
			lblGroupNameLData.verticalAlignment = GridData.CENTER;
			lblGroupNameLData.horizontalAlignment = GridData.END;
			lblGroupNameLData.widthHint = 56;
			lblGroupNameLData.heightHint = 20;
			lblGroupNameLData.horizontalIndent = 0;
			lblGroupNameLData.horizontalSpan = 1;
			lblGroupNameLData.verticalSpan = 1;
			lblGroupNameLData.grabExcessHorizontalSpace = false;
			lblGroupNameLData.grabExcessVerticalSpace = false;
			lblGroupName.setLayoutData(lblGroupNameLData);
			lblGroupName.setText(Messages.getString("InvUIGroupAddDialog.0")); //$NON-NLS-1$
			lblGroupName.setSize(new org.eclipse.swt.graphics.Point(56,20));
	
			GridData txtGroupNameLData = new GridData();
			txtGroupName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode==SWT.CR)
						btnGroupAddMouseUp();
				}
			});
			txtGroupNameLData.widthHint = 112;
			txtGroupNameLData.heightHint = 15;
			txtGroupNameLData.horizontalSpan = 2;
			txtGroupName.setLayoutData(txtGroupNameLData);

			GridData lblDescriptionLData = new GridData();
			lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
			lblDescriptionLData.horizontalAlignment = GridData.END;
			lblDescriptionLData.widthHint = 96;
			lblDescriptionLData.heightHint = 21;
			lblDescription.setLayoutData(lblDescriptionLData);
			lblDescription.setText(Messages.getString("InvUIGroupAddDialog.1")); //$NON-NLS-1$
	
			GridData txtDescriptionLData = new GridData();
			txtDescriptionLData.widthHint = 302;
			txtDescriptionLData.heightHint = 13;
			txtDescriptionLData.horizontalSpan = 2;
			txtDescription.setLayoutData(txtDescriptionLData);

			GridData btnDeleteLData = new GridData();
			btnDeleteLData.horizontalAlignment = GridData.END;
			btnDeleteLData.widthHint = 56;
			btnDeleteLData.heightHint = 31;
			btnDelete.setLayoutData(btnDeleteLData);
			btnDelete.setText(Messages.getString("InvUIGroupAddDialog.2")); //$NON-NLS-1$
			btnDelete.setEnabled(false);
			btnDelete.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnDeleteMouseUp(evt);
				}
			});
	
			GridData btnUpdateLData = new GridData();
			btnUpdateLData.horizontalAlignment = GridData.END;
			btnUpdateLData.widthHint = 82;
			btnUpdateLData.heightHint = 30;
			btnUpdate.setLayoutData(btnUpdateLData);
			btnUpdate.setText(Messages.getString("InvUIGroupAddDialog.3")); //$NON-NLS-1$
			btnUpdate.setEnabled(false);
			btnUpdate.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnUpdateMouseUp(evt);
				}
			});
	
			GridData btnGroupAddLData = new GridData();
			btnGroupAdd.addMouseListener(new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnGroupAddMouseUp();
				}
			});
			btnGroupAddLData.verticalAlignment = GridData.CENTER;
			btnGroupAddLData.horizontalAlignment = GridData.BEGINNING;
			btnGroupAddLData.widthHint = -1;
			btnGroupAddLData.heightHint = -1;
			btnGroupAddLData.horizontalIndent = 0;
			btnGroupAddLData.horizontalSpan = 1;
			btnGroupAddLData.verticalSpan = 1;
			btnGroupAddLData.grabExcessHorizontalSpace = false;
			btnGroupAddLData.grabExcessVerticalSpace = false;
			btnGroupAdd.setLayoutData(btnGroupAddLData);
			btnGroupAdd.setText(Messages.getString("InvUIGroupAddDialog.4")); //$NON-NLS-1$
			GridLayout compGroupAddDialogLayout = new GridLayout(3, true);
			compGroupAddDialog.setLayout(compGroupAddDialogLayout);
			compGroupAddDialogLayout.marginWidth = 5;
			compGroupAddDialogLayout.marginHeight = 5;
			compGroupAddDialogLayout.numColumns = 3;
			compGroupAddDialogLayout.makeColumnsEqualWidth = false;
			compGroupAddDialogLayout.horizontalSpacing = 5;
			compGroupAddDialogLayout.verticalSpacing = 5;
			compGroupAddDialog.layout();
	
			GridData tableInvGroupsLData = new GridData();
			tableInvGroupsLData.verticalAlignment = GridData.FILL;
			tableInvGroupsLData.horizontalAlignment = GridData.FILL;
			tableInvGroupsLData.widthHint = -1;
			tableInvGroupsLData.heightHint = -1;
			tableInvGroupsLData.horizontalIndent = 0;
			tableInvGroupsLData.horizontalSpan = 1;
			tableInvGroupsLData.verticalSpan = 1;
			tableInvGroupsLData.grabExcessHorizontalSpace = true;
			tableInvGroupsLData.grabExcessVerticalSpace = true;
			tableInvGroups.setLayoutData(tableInvGroupsLData);
			tableInvGroups.setHeaderVisible(true);
			tableInvGroups.setLinesVisible(true);
			tableInvGroups.setSize(new org.eclipse.swt.graphics.Point(413,124));
			tableInvGroups.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableInvGroupsMouseDoubleClick(evt);
				}
			});
	
			tableColumnName.setText(Messages.getString("InvUIGroupAddDialog.5")); //$NON-NLS-1$
			tableColumnName.setWidth(150);
	
			tableColumnDescription.setText(Messages.getString("InvUIGroupAddDialog.6")); //$NON-NLS-1$
			tableColumnDescription.setWidth(270);
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 433,229);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
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
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	 Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
	fillTable();
	}

    public void fillTable(){
    try{
    tableInvGroups.removeAll();
    List list = blCardAdd.getInventoryGroups();
    
    TurqInventoryGroup invGroup;
    TableItem item;
    for(int i=0;i<list.size();i++){
    invGroup = (TurqInventoryGroup)list.get(i);
    item = new TableItem(tableInvGroups,SWT.NULL);
    item.setText(new String[]{invGroup.getGroupsName(),invGroup.getGroupsDescription()});
    item.setData(invGroup);     
    }
    
    
    }
    catch(Exception ex){
    ex.printStackTrace();
    
    }
    
    
    
    }
	/** Auto-generated event handler method */
	protected void tableInvGroupsMouseUp(MouseEvent evt){
	
	
		
	}
	

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseUp(){
		MessageBox msg = new MessageBox(this.getParent());
		try{
		
		
	    if(txtGroupName.getText().trim().equals("")){ //$NON-NLS-1$
	    
	    msg.setMessage(Messages.getString("InvUIGroupAddDialog.8")); //$NON-NLS-1$
	    msg.open();
	    }
	    else{
	    
	    blCardAdd.saveInvGroup(txtGroupName.getText().trim(),txtDescription.getText().trim());
	    msg.setMessage(Messages.getString("InvUIGroupAddDialog.9")); //$NON-NLS-1$
	    txtGroupName.setText(""); //$NON-NLS-1$
	    txtDescription.setText(""); //$NON-NLS-1$
	    fillTable();
	    msg.open();	    
	    }		
		
		}
		catch(HibernateException ex){
		ex.printStackTrace();
		msg.setText(Messages.getString("InvUIGroupAddDialog.12")); //$NON-NLS-1$
	    msg.open();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

	/** Auto-generated event handler method */
	protected void tableInvGroupsMouseDoubleClick(MouseEvent evt){
		TableItem item;
		if(tableInvGroups.getSelection().length>0){
		item = tableInvGroups.getSelection()[0];
		txtGroupName.setText(item.getText(0));
		txtDescription.setText(item.getText(1));
		txtGroupName.setData(item.getData());
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnGroupAdd.setEnabled(false);
		}
		
		
	}


	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt){
	MessageBox msg = new MessageBox(this.getParent());
	try{
		 if(txtGroupName.getText().trim().equals("")){ //$NON-NLS-1$
		    
		    msg.setMessage(Messages.getString("InvUIGroupAddDialog.14")); //$NON-NLS-1$
		    msg.open();
		    txtGroupName.setFocus();
		    return;
		    }
	else{
		
	TurqInventoryGroup invGroup = (TurqInventoryGroup)txtGroupName.getData();
	invGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
	invGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	invGroup.setGroupsName(txtGroupName.getText().trim());
	invGroup.setGroupsDescription(txtDescription.getText().trim());
	blCardAdd.saveOrUpdateObject(invGroup);
	
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnGroupAdd.setEnabled(true);
	txtGroupName.setText(""); //$NON-NLS-1$
	txtDescription.setText("");	 //$NON-NLS-1$
	msg.setMessage(Messages.getString("InvUIGroupAddDialog.18")); //$NON-NLS-1$
	msg.open();
	fillTable();
		    }
	
	
	}
	catch(Exception ex){
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnGroupAdd.setEnabled(true);
	txtGroupName.setText(""); //$NON-NLS-1$
	txtDescription.setText("");	 //$NON-NLS-1$
	msg.setMessage(Messages.getString("InvUIGroupAddDialog.21")); //$NON-NLS-1$
	msg.open();
	ex.printStackTrace();
	}
	
	
	}

	/** Auto-generated event handler method */
	protected void btnDeleteMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.OK|SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getParent());
	    try{
	    msg.setMessage(Messages.getString("InvUIGroupAddDialog.22")); //$NON-NLS-1$
	    int result = msg.open();
	    if(result==SWT.OK){
	   
	    blCardAdd.deleteObject(txtGroupName.getData());
	   
	   
	    btnDelete.setEnabled(false);
	    btnUpdate.setEnabled(false);
	    btnGroupAdd.setEnabled(true);
	    txtGroupName.setText(""); //$NON-NLS-1$
	    txtDescription.setText("");	 //$NON-NLS-1$
	    msg2.setMessage(Messages.getString("InvUIGroupAddDialog.25")); //$NON-NLS-1$
		msg2.open();
		fillTable();
	    
	    }
	    
		}
		catch(Exception ex){
			 btnDelete.setEnabled(false);
			    btnUpdate.setEnabled(false);
			    btnGroupAdd.setEnabled(true);
			    txtGroupName.setText(""); //$NON-NLS-1$
			    txtDescription.setText("");	 //$NON-NLS-1$
		msg2.setMessage(Messages.getString("InvUIGroupAddDialog.28"));	 //$NON-NLS-1$
		msg2.open();
		ex.printStackTrace();
		}
		
		
	}
}
