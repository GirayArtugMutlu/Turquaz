package com.turquaz.consignment.ui;

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
import java.util.HashMap;
import net.sf.hibernate.HibernateException;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLAddGroups;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.ConsLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class ConUIConsignmentsGroupDialog extends org.eclipse.swt.widgets.Dialog
{
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnName;
	private Label lblSeperator;
	private Table tableCurGroups;
	private Button btnGroupAdd;
	private Button btnUpdate;
	private Button btnDelete;
	private Text txtDescription;
	private CLabel lblDescription;
	private Text txtGroupName;
	private CLabel lblGroupName;
	private Composite compGroupAddDialog;
	private Shell dialogShell;
	Calendar cal = Calendar.getInstance();

	public ConUIConsignmentsGroupDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public void open()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(ConsLangKeys.TITLE_CONS_GROUPS); 
			compGroupAddDialog = new Composite(dialogShell, SWT.NULL);
			lblGroupName = new CLabel(compGroupAddDialog, SWT.NULL);
			txtGroupName = new Text(compGroupAddDialog, SWT.BORDER);
			lblDescription = new CLabel(compGroupAddDialog, SWT.NULL);
			txtDescription = new Text(compGroupAddDialog, SWT.SINGLE | SWT.BORDER);
			btnDelete = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
			btnUpdate = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
			btnGroupAdd = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
			tableCurGroups = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			tableColumnName = new TableColumn(tableCurGroups, SWT.NULL);
			tableColumnDescription = new TableColumn(tableCurGroups, SWT.NULL);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433, 229));
			GridData compGroupAddDialogLData = new GridData();
			compGroupAddDialogLData.horizontalAlignment = GridData.FILL;
			compGroupAddDialogLData.heightHint = 106;
			compGroupAddDialogLData.grabExcessHorizontalSpace = true;
			compGroupAddDialog.setLayoutData(compGroupAddDialogLData);
			compGroupAddDialog.setBackground(SWTResourceManager.getColor(255, 255, 255));
			GridData lblGroupNameLData = new GridData();
			lblGroupNameLData.widthHint = 59;
			lblGroupNameLData.heightHint = 20;
			lblGroupName.setLayoutData(lblGroupNameLData);
			lblGroupName.setText(EngLangCommonKeys.STR_NAME);
			GridData txtGroupNameLData = new GridData();
			txtGroupNameLData.widthHint = 111;
			txtGroupNameLData.heightHint = 19;
			txtGroupNameLData.horizontalSpan = 2;
			txtGroupName.setLayoutData(txtGroupNameLData);
			GridData lblDescriptionLData = new GridData();
			lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
			lblDescriptionLData.widthHint = 71;
			lblDescriptionLData.heightHint = 19;
			lblDescription.setLayoutData(lblDescriptionLData);
			lblDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);
			GridData txtDescriptionLData = new GridData();
			txtDescriptionLData.widthHint = 296;
			txtDescriptionLData.heightHint = 16;
			txtDescriptionLData.horizontalSpan = 2;
			txtDescription.setLayoutData(txtDescriptionLData);
			{
				lblSeperator = new Label(compGroupAddDialog, SWT.SEPARATOR | SWT.HORIZONTAL);
				GridData label1LData = new GridData();
				label1LData.heightHint = 2;
				label1LData.horizontalSpan = 3;
				label1LData.horizontalAlignment = GridData.FILL;
				lblSeperator.setLayoutData(label1LData);
			}
			GridData btnDeleteLData = new GridData();
			btnDeleteLData.horizontalAlignment = GridData.END;
			btnDeleteLData.widthHint = 50;
			btnDeleteLData.heightHint = 25;
			btnDelete.setLayoutData(btnDeleteLData);
			btnDelete.setText(EngLangCommonKeys.STR_DELETE);
			btnDelete.setEnabled(false);
			btnDelete.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnDeleteMouseUp(evt);
				}
			});
			GridData btnUpdateLData = new GridData();
			btnUpdateLData.horizontalAlignment = GridData.END;
			btnUpdateLData.widthHint = 71;
			btnUpdateLData.heightHint = 27;
			btnUpdate.setLayoutData(btnUpdateLData);
			btnUpdate.setText(EngLangCommonKeys.STR_UPDATE);
			btnUpdate.setEnabled(false);
			btnUpdate.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnUpdateMouseUp(evt);
				}
			});
			GridData btnGroupAddLData = new GridData();
			btnGroupAddLData.widthHint = 54;
			btnGroupAddLData.heightHint = 26;
			btnGroupAdd.setLayoutData(btnGroupAddLData);
			btnGroupAdd.setText(EngLangCommonKeys.STR_ADD);
			btnGroupAdd.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					btnGroupAddMouseDoubleClick(evt);
				}

				public void mouseUp(MouseEvent evt)
				{
					btnGroupAddMouseUp(evt);
				}
			});
			GridLayout compGroupAddDialogLayout = new GridLayout(3, true);
			compGroupAddDialog.setLayout(compGroupAddDialogLayout);
			compGroupAddDialogLayout.marginWidth = 5;
			compGroupAddDialogLayout.marginHeight = 5;
			compGroupAddDialogLayout.numColumns = 3;
			compGroupAddDialogLayout.makeColumnsEqualWidth = false;
			compGroupAddDialogLayout.horizontalSpacing = 5;
			compGroupAddDialogLayout.verticalSpacing = 5;
			compGroupAddDialog.layout();
			GridData tableCurGroupsLData = new GridData();
			tableCurGroupsLData.verticalAlignment = GridData.FILL;
			tableCurGroupsLData.horizontalAlignment = GridData.FILL;
			tableCurGroupsLData.grabExcessHorizontalSpace = true;
			tableCurGroupsLData.grabExcessVerticalSpace = true;
			tableCurGroups.setLayoutData(tableCurGroupsLData);
			tableCurGroups.setHeaderVisible(true);
			tableCurGroups.setLinesVisible(true);
			tableCurGroups.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableCurGroupsMouseDoubleClick(evt);
				}
			});
			tableColumnName.setText(EngLangCommonKeys.STR_NAME);
			tableColumnName.setWidth(150);
			tableColumnDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);
			tableColumnDescription.setWidth(269);
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 433, 229);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
		fillTable();
	}

	public void fillTable()
	{
		try
		{
			tableCurGroups.removeAll();
//			 Fill Group Table
			HashBag groupBag = (HashBag) EngTXCommon.doSelectTX(ConBLAddGroups.class.getName(), "getConsignmentGroups", null);
			
			HashMap groupList =(HashMap)groupBag.get(ConsKeys.CONS_GROUPS);
					
			
			HashMap groupInfo;
			TableItem item;
			for (int i = 0; i < groupList.size(); i++)
			{
				groupInfo = (HashMap) groupList.get(new Integer(i));
				
				item = new TableItem(tableCurGroups, SWT.NULL);
				
				item.setText(new String[]{groupInfo.get(AdmKeys.ADM_GROUP_NAME).toString(), groupInfo.get(AdmKeys.ADM_GROUP_DESCRIPTION).toString()});
				item.setData(groupInfo.get(AdmKeys.ADM_GROUP_ID));
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void btnDeleteMouseUp(MouseEvent evt)
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS_GROUP_ID, txtGroupName.getData());
				
				EngTXCommon.doTransactionTX(ConBLAddGroups.class.getName(),"deleteGroup",argMap);
				
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnGroupAdd.setEnabled(true);
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				fillTable();
			}
		}
		catch (Exception ex)
		{
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnGroupAdd.setEnabled(true);
			txtGroupName.setText(""); //$NON-NLS-1$
			txtDescription.setText(""); //$NON-NLS-1$
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt)
	{
		try
		{
			if (txtGroupName.getText().trim().equals("")) 
			{
				EngUICommon.showMessageBox(getParent(),CurLangKeys.MSG_ENTER_GROUP_NAME,SWT.ICON_WARNING);
			}
			else
			{
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS_GROUP_ID,txtGroupName.getData());
				argMap.put(ConsKeys.CONS_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(ConsKeys.CONS_GROUP_DESCRIPTION,txtDescription.getText().trim());
				EngTXCommon.doTransactionTX(ConBLAddGroups.class.getName(),"updateGroup",argMap);
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnGroupAdd.setEnabled(true);
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				fillTable();
			}
		}
		catch (Exception ex)
		{
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnGroupAdd.setEnabled(true);
			txtGroupName.setText(""); //$NON-NLS-1$
			txtDescription.setText(""); //$NON-NLS-1$
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseDoubleClick(MouseEvent evt)
	{
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseUp(MouseEvent evt)
	{
		try
		{
			if (txtGroupName.getText().trim().equals("")) 
			{
				EngUICommon.showMessageBox(getParent(),CurLangKeys.MSG_ENTER_GROUP_NAME,SWT.ICON_WARNING);
			}
			else
			{
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(ConsKeys.CONS_GROUP_DESCRIPTION,txtDescription.getText().trim());
				EngTXCommon.doTransactionTX(ConBLAddGroups.class.getName(),"saveGroup",argMap);
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				EngUICommon.showSavedSuccesfullyMessage(getParent());
				fillTable();
				
			}
		}
		catch (HibernateException ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void tableCurGroupsMouseDoubleClick(MouseEvent evt)
	{
		TableItem item;
		if (tableCurGroups.getSelection().length > 0)
		{
			item = tableCurGroups.getSelection()[0];
			txtGroupName.setText(item.getText(0));
			txtDescription.setText(item.getText(1));
			txtGroupName.setData(item.getData());
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
			btnGroupAdd.setEnabled(false);
		}
	}
}