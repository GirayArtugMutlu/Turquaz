package com.turquaz.bill.ui;

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
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.common.HashBag;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.BillLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillUIBillsGroupDialog extends org.eclipse.swt.widgets.Dialog
{
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnName;
	private Label seperator;
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

	public BillUIBillsGroupDialog(Shell parent, int style)
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
			dialogShell.setText(BillLangKeys.TITLE_BILL_GROUPS);
			dialogShell.setSize(434, 245);
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			{
				compGroupAddDialog = new Composite(dialogShell, SWT.NONE);
				GridLayout compGroupAddDialogLayout = new GridLayout(3, true);
				compGroupAddDialogLayout.marginWidth = 5;
				compGroupAddDialogLayout.marginHeight = 5;
				compGroupAddDialogLayout.numColumns = 3;
				compGroupAddDialogLayout.makeColumnsEqualWidth = false;
				compGroupAddDialogLayout.horizontalSpacing = 5;
				compGroupAddDialogLayout.verticalSpacing = 5;
				GridData compGroupAddDialogLData = new GridData();
				compGroupAddDialogLData.horizontalAlignment = GridData.FILL;
				compGroupAddDialogLData.heightHint = 106;
				compGroupAddDialogLData.grabExcessHorizontalSpace = true;
				compGroupAddDialog.setLayoutData(compGroupAddDialogLData);
				compGroupAddDialog.setBackground(SWTResourceManager.getColor(255, 255, 255));
				compGroupAddDialog.setLayout(compGroupAddDialogLayout);
				{
					lblGroupName = new CLabel(compGroupAddDialog, SWT.NONE);
					GridData lblGroupNameLData = new GridData();
					lblGroupNameLData.widthHint = 59;
					lblGroupNameLData.heightHint = 20;
					lblGroupName.setLayoutData(lblGroupNameLData);
					lblGroupName.setText(EngLangCommonKeys.STR_NAME);
				}
				{
					txtGroupName = new Text(compGroupAddDialog, SWT.BORDER);
					GridData txtGroupNameLData = new GridData();
					txtGroupNameLData.widthHint = 111;
					txtGroupNameLData.heightHint = 19;
					txtGroupNameLData.horizontalSpan = 2;
					txtGroupName.setLayoutData(txtGroupNameLData);
				}
				{
					lblDescription = new CLabel(compGroupAddDialog, SWT.NONE);
					GridData lblDescriptionLData = new GridData();
					lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
					lblDescriptionLData.widthHint = 71;
					lblDescriptionLData.heightHint = 19;
					lblDescription.setLayoutData(lblDescriptionLData);
					lblDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);
				}
				{
					txtDescription = new Text(compGroupAddDialog, SWT.SINGLE | SWT.BORDER);
					GridData txtDescriptionLData = new GridData();
					txtDescriptionLData.widthHint = 296;
					txtDescriptionLData.heightHint = 16;
					txtDescriptionLData.horizontalSpan = 2;
					txtDescription.setLayoutData(txtDescriptionLData);
				}
				{
					btnDelete = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
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
				}
				{
					btnUpdate = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
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
				}
				{
					btnGroupAdd = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
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
				}
				{
					seperator = new Label(compGroupAddDialog, SWT.SEPARATOR | SWT.HORIZONTAL);
					seperator.setText("label1"); //$NON-NLS-1$
					GridData label1LData = new GridData();
					label1LData.heightHint = 2;
					label1LData.horizontalSpan = 3;
					label1LData.horizontalAlignment = GridData.FILL;
					seperator.setLayoutData(label1LData);
				}
				compGroupAddDialog.layout();
			}
			tableCurGroups = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			tableColumnName = new TableColumn(tableCurGroups, SWT.NULL);
			tableColumnDescription = new TableColumn(tableCurGroups, SWT.NULL);
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
			HashBag groupBag = (HashBag)EngTXCommon.doSelectTX(BillBLAddGroups.class.getName(),"getBillGroups",null);
		
			HashMap groupList =(HashMap)groupBag.get(BillKeys.BILL_GROUPS);
			
	
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
				argMap.put(BillKeys.BILL_GROUP,txtGroupName.getData());
				EngTXCommon.doTransactionTX(BillBLAddGroups.class.getName(),"deleteGroup",argMap);
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
			if (txtGroupName.getText().trim().equals("")) { //$NON-NLS-1$
				EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_ENTER_GROUP_NAME,SWT.ICON_WARNING);
			}
			else
			{
				HashMap argMap=new HashMap();
				argMap.put(BillKeys.BILL_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(BillKeys.BILL_GROUP_DESCRIPTION,txtDescription.getText().trim());
				argMap.put(BillKeys.BILL_GROUP,txtGroupName.getData());
		
				EngTXCommon.doTransactionTX(BillBLAddGroups.class.getName(),"updateGroup",argMap);
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
			if (txtGroupName.getText().trim().equals("")) { //$NON-NLS-1$
				EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_ENTER_GROUP_NAME,SWT.ICON_WARNING);
			}
			else
			{
				HashMap argMap=new HashMap();
				argMap.put(BillKeys.BILL_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(BillKeys.BILL_GROUP_DESCRIPTION,txtDescription.getText().trim());
				EngTXCommon.doTransactionTX(BillBLAddGroups.class.getName(),"saveGroup",argMap);
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