package com.turquaz.current.ui;

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
import org.eclipse.swt.widgets.MessageBox;
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
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUIGroupAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	Calendar cal = Calendar.getInstance();
	private Text txtDescription;
	private Button btnDelete;
	private TableColumn tableColumnName;
	private TableColumn tableColumnDescription;
	private Table tableCurGroups;
	private Button btnGroupAdd;
	private Button btnUpdate;
	private CLabel lblDescription;
	private Text txtGroupName;
	private CLabel lblGroupName;
	private Composite compGroupAddDialog;

	public CurUIGroupAddDialog(Shell parent, int style)
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
			dialogShell.setText(CurLangKeys.TITLE_CUR_GROUPS_UPDATE); //$NON-NLS-1$
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433, 229));
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			{
				compGroupAddDialog = new Composite(dialogShell, SWT.NONE);
				GridLayout compGroupAddDialogLayout = new GridLayout();
				compGroupAddDialogLayout.numColumns = 3;
				GridData compGroupAddDialogLData = new GridData();
				compGroupAddDialog.setLayout(compGroupAddDialogLayout);
				compGroupAddDialog.setBackground(SWTResourceManager.getColor(255, 255, 255));
				compGroupAddDialogLData.horizontalAlignment = GridData.FILL;
				compGroupAddDialogLData.heightHint = 98;
				compGroupAddDialogLData.grabExcessHorizontalSpace = true;
				compGroupAddDialog.setLayoutData(compGroupAddDialogLData);
				{
					lblGroupName = new CLabel(compGroupAddDialog, SWT.NONE);
					lblGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME);//$NON-NLS-1$
					lblGroupName.setSize(new org.eclipse.swt.graphics.Point(56, 20));
					GridData lblGroupNameLData = new GridData();
					lblGroupNameLData.horizontalAlignment = GridData.END;
					lblGroupNameLData.widthHint = 56;
					lblGroupNameLData.heightHint = 20;
					lblGroupName.setLayoutData(lblGroupNameLData);
				}
				{
					txtGroupName = new Text(compGroupAddDialog, SWT.BORDER);
					GridData txtGroupNameLData = new GridData();
					txtGroupName.addKeyListener(new KeyAdapter()
					{
						public void keyReleased(KeyEvent evt)
						{
							if (evt.keyCode == SWT.CR)
								btnGroupAddMouseUp();
						}
					});
					txtGroupNameLData.widthHint = 118;
					txtGroupNameLData.heightHint = 8;
					txtGroupNameLData.horizontalSpan = 2;
					txtGroupName.setLayoutData(txtGroupNameLData);
				}
				{
					lblDescription = new CLabel(compGroupAddDialog, SWT.NONE);
					GridData lblDescriptionLData = new GridData();
					lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
					lblDescriptionLData.horizontalAlignment = GridData.END;
					lblDescriptionLData.widthHint = 72;
					lblDescriptionLData.heightHint = 23;
					lblDescription.setLayoutData(lblDescriptionLData);
					lblDescription.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
				}
				{
					txtDescription = new Text(compGroupAddDialog, SWT.SINGLE | SWT.BORDER);
					GridData txtDescriptionLData = new GridData();
					txtDescriptionLData.widthHint = 303;
					txtDescriptionLData.heightHint = 10;
					txtDescriptionLData.horizontalSpan = 2;
					txtDescription.setLayoutData(txtDescriptionLData);
				}
				{
					btnDelete = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
					btnDelete.setText(EngLangCommonKeys.STR_DELETE);//$NON-NLS-1$
					GridData btnDeleteLData = new GridData();
					btnDelete.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnDeleteMouseUp(evt);
						}
					});
					btnDelete.setEnabled(false);
					btnDeleteLData.horizontalAlignment = GridData.END;
					btnDeleteLData.widthHint = 54;
					btnDeleteLData.heightHint = 31;
					btnDelete.setLayoutData(btnDeleteLData);
				}
				{
					btnUpdate = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
					btnUpdate.setText(EngLangCommonKeys.STR_UPDATE);//$NON-NLS-1$
					GridData btnUpdateLData = new GridData();
					btnUpdate.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnUpdateMouseUp(evt);
						}
					});
					btnUpdate.setEnabled(false);
					btnUpdateLData.horizontalAlignment = GridData.END;
					btnUpdateLData.widthHint = 84;
					btnUpdateLData.heightHint = 32;
					btnUpdate.setLayoutData(btnUpdateLData);
				}
				{
					btnGroupAdd = new Button(compGroupAddDialog, SWT.PUSH | SWT.CENTER);
					btnGroupAdd.setText(EngLangCommonKeys.STR_ADD);//$NON-NLS-1$
					GridData btnGroupAddLData = new GridData();
					btnGroupAdd.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnGroupAddMouseUp();
						}
					});
					btnGroupAdd.setLayoutData(btnGroupAddLData);
				}
			}
			{
				tableCurGroups = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				tableCurGroups.setHeaderVisible(true);
				tableCurGroups.setLinesVisible(true);
				tableCurGroups.setSize(new org.eclipse.swt.graphics.Point(413, 124));
				GridData tableCurGroupsLData = new GridData();
				tableCurGroups.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableCurGroupsMouseDoubleClick(evt);
					}
				});
				tableCurGroupsLData.verticalAlignment = GridData.FILL;
				tableCurGroupsLData.horizontalAlignment = GridData.FILL;
				tableCurGroupsLData.grabExcessHorizontalSpace = true;
				tableCurGroupsLData.grabExcessVerticalSpace = true;
				tableCurGroups.setLayoutData(tableCurGroupsLData);
				{
					tableColumnName = new TableColumn(tableCurGroups, SWT.NONE);
					tableColumnName.setText(EngLangCommonKeys.STR_GROUP_NAME);//$NON-NLS-1$
					tableColumnName.setWidth(150);
				}
				{
					tableColumnDescription = new TableColumn(tableCurGroups, SWT.NONE);
					tableColumnDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);//$NON-NLS-1$
					tableColumnDescription.setWidth(270);
				}
			}
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
			HashBag groupBag = (HashBag)EngTXCommon.doSelectTX(CurBLCurrentCardAdd.class.getName(),"getCurrentGroups",null);
		
			HashMap groupList = (HashMap)groupBag.get(AdmKeys.ADM_GROUPS);
			TableItem item;
			for (int i = 0; i < groupList.size(); i++)
			{
				HashMap groupInfo = (HashMap) groupList.get(new Integer(i));
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
		MessageBox msg = new MessageBox(this.getParent(), SWT.OK | SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getParent());
		try
		{
			msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); //$NON-NLS-1$
			int result = msg.open();
			if (result == SWT.OK)
			{
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_GROUP_ID,txtGroupName.getData());
				EngTXCommon.doTransactionTX(CurBLCurrentCardAdd.class.getName(),"deleteGroup",argMap);
			
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnGroupAdd.setEnabled(true);
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				msg2.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
				msg2.open();
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
		MessageBox msg = new MessageBox(this.getParent());
		try
		{
			if (txtGroupName.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(CurLangKeys.MSG_ENTER_GROUP_NAME); //$NON-NLS-1$
				msg.open();
			}
			else
			{
				
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_GROUP_ID,txtGroupName.getData());
				argMap.put(CurKeys.CUR_GROUP_NAME,txtGroupName.getText().trim());
			    argMap.put(EngKeys.DEFINITION,txtDescription.getText().trim());
				
			    EngTXCommon.doTransactionTX(CurBLCurrentCardAdd.class.getName(),"updateGroup",argMap);
			    
			    
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnGroupAdd.setEnabled(true);
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); //$NON-NLS-1$
				msg.open();
				txtGroupName.setFocus();
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
	protected void btnGroupAddMouseUp()
	{
		MessageBox msg = new MessageBox(this.getParent());
		try
		{
			if (txtGroupName.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(CurLangKeys.MSG_ENTER_GROUP_NAME); //$NON-NLS-1$
				msg.open();
				txtGroupName.setFocus();
			}
			else
			{
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(EngKeys.DEFINITION,txtDescription.getText().trim());
				
				EngTXCommon.doTransactionTX(CurBLCurrentCardAdd.class.getName(),"saveCurrentGroup",argMap);
				
				
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); //$NON-NLS-1$
				txtGroupName.setText(""); //$NON-NLS-1$
				txtDescription.setText(""); //$NON-NLS-1$
				fillTable();
				msg.open();
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