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
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardUpdate;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class InvUIUnitAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Text txtUnitName;
	private Table tableInvUnits;
	private Button btnUnitAdd;
	private CLabel cLabel1;
	private TableColumn tableColumnName;
	private Button btnUpdate;
	private Button btnDelete;
	private CLabel lblUnitName;
	private Composite composite1;
	private Shell dialogShell;
	Calendar cal = Calendar.getInstance();

	public InvUIUnitAddDialog(Shell parent, int style)
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
			dialogShell.setText(InvLangKeys.TITLE_INV_UNITS);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(252, 229));
			GridData tableInvUnitsLData = new GridData();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout(3, true);
				composite1Layout.marginWidth = 5;
				composite1Layout.marginHeight = 5;
				composite1Layout.numColumns = 3;
				composite1Layout.makeColumnsEqualWidth = false;
				composite1Layout.horizontalSpacing = 5;
				composite1Layout.verticalSpacing = 5;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 92;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				composite1.setSize(new org.eclipse.swt.graphics.Point(252, 92));
				composite1.setBackground(SWTResourceManager.getColor(255, 255, 255));
				composite1.setLayout(composite1Layout);
				{
					cLabel1 = new CLabel(composite1, SWT.NONE);
					GridData cLabel1LData = new GridData();
					cLabel1LData.horizontalAlignment = GridData.END;
					cLabel1LData.widthHint = 56;
					cLabel1LData.heightHint = 20;
					cLabel1.setLayoutData(cLabel1LData);
					cLabel1.setText(EngLangCommonKeys.STR_UNIT_NAME);
					cLabel1.setSize(new org.eclipse.swt.graphics.Point(56, 20));
				}
				{
					txtUnitName = new Text(composite1, SWT.BORDER);
					GridData txtUnitNameLData = new GridData();
					txtUnitName.addKeyListener(new KeyAdapter()
					{
						public void keyReleased(KeyEvent evt)
						{
							if (evt.keyCode == SWT.CR)
							{
								btnUnitAddMouseUp();
							}
						}
					});
					txtUnitNameLData.widthHint = 110;
					txtUnitNameLData.heightHint = 16;
					txtUnitNameLData.horizontalSpan = 2;
					txtUnitName.setLayoutData(txtUnitNameLData);
				}
				{
					btnDelete = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnDeleteLData = new GridData();
					btnDelete.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnDeleteMouseUp(evt);
						}
					});
					btnDeleteLData.horizontalAlignment = GridData.END;
					btnDeleteLData.widthHint = 50;
					btnDeleteLData.heightHint = 30;
					btnDelete.setLayoutData(btnDeleteLData);
					btnDelete.setText(EngLangCommonKeys.STR_DELETE);
					btnDelete.setSize(new org.eclipse.swt.graphics.Point(50, 30));
					btnDelete.setEnabled(false);
				}
				{
					btnUpdate = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnUpdateLData = new GridData();
					btnUpdate.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnUpdateMouseUp(evt);
						}
					});
					btnUpdateLData.horizontalAlignment = GridData.END;
					btnUpdateLData.widthHint = 50;
					btnUpdateLData.heightHint = 30;
					btnUpdate.setLayoutData(btnUpdateLData);
					btnUpdate.setText(EngLangCommonKeys.STR_UPDATE);
					btnUpdate.setSize(new org.eclipse.swt.graphics.Point(50, 30));
					btnUpdate.setEnabled(false);
				}
				{
					btnUnitAdd = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnUnitAddLData = new GridData();
					btnUnitAdd.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnUnitAddMouseUp();
						}
					});
					btnUnitAddLData.widthHint = 42;
					btnUnitAddLData.heightHint = 27;
					btnUnitAdd.setLayoutData(btnUnitAddLData);
					btnUnitAdd.setText(EngLangCommonKeys.STR_ADD);
					btnUnitAdd.setSize(new org.eclipse.swt.graphics.Point(42, 27));
				}
				composite1.layout();
			}
			tableInvUnits = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			tableColumnName = new TableColumn(tableInvUnits, SWT.NULL);
			tableColumnName.setText(EngLangCommonKeys.STR_UNIT_NAME);
			tableColumnName.setWidth(200);
			tableInvUnitsLData = new GridData();
			tableInvUnitsLData.verticalAlignment = GridData.FILL;
			tableInvUnitsLData.horizontalAlignment = GridData.FILL;
			tableInvUnitsLData.widthHint = -1;
			tableInvUnitsLData.heightHint = -1;
			tableInvUnitsLData.horizontalIndent = 0;
			tableInvUnitsLData.horizontalSpan = 1;
			tableInvUnitsLData.verticalSpan = 1;
			tableInvUnitsLData.grabExcessHorizontalSpace = true;
			tableInvUnitsLData.grabExcessVerticalSpace = true;
			tableInvUnits.setLayoutData(tableInvUnitsLData);
			tableInvUnits.setHeaderVisible(true);
			tableInvUnits.setLinesVisible(true);
			tableInvUnits.setSize(new org.eclipse.swt.graphics.Point(232, 117));
			tableInvUnits.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableInvUnitsMouseDoubleClick(evt);
				}
			});
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 252, 229);
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
			tableInvUnits.removeAll();
			List list = (List) EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getInventoryUnits",null);
			TurqInventoryUnit invUnit;
			TableItem item;
			for (int i = 0; i < list.size(); i++)
			{
				invUnit = (TurqInventoryUnit) list.get(i);
				item = new TableItem(tableInvUnits, SWT.NULL);
				item.setText(new String[]{invUnit.getUnitsName()});
				item.setData(invUnit);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
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
				argMap.put(InvKeys.INV_UNIT,txtUnitName.getData());
				//XXX check if there exist a transaction with this unit!!
				EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"delete",argMap);
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnUnitAdd.setEnabled(true);
				txtUnitName.setText(""); //$NON-NLS-1$
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				fillTable();
			}
		}
		catch (Exception ex)
		{
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnUnitAdd.setEnabled(true);
			txtUnitName.setText(""); //$NON-NLS-1$
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt)
	{
		try
		{
			if (txtUnitName.getText().trim().equals("")) 
			{ 
				EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_ENTER_UNIT_NAME,SWT.ICON_WARNING);
				txtUnitName.setFocus();
				return;
			}
			else
			{
				List list = (List)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getInventoryUnits",null);
				String unit = txtUnitName.getText().trim();
				boolean exist = false;
				for (int k = 0; k < list.size(); k++)
				{
					TurqInventoryUnit InvUnit = (TurqInventoryUnit) list.get(k);
					if (InvUnit.getUnitsName().equals(unit))
					{
						exist = true;
						break;
					}
				}
				if (exist)
				{
					EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_NOT_ENTER_UNIT_NAME_ALREADY_EXIST);
					return;
				}
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_UNIT,txtUnitName.getData());
				argMap.put(InvKeys.INV_UNIT_NAME,txtUnitName.getText().trim());
				EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"updateInvUnit",argMap);
				btnDelete.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnUnitAdd.setEnabled(true);
				txtUnitName.setText(""); //$NON-NLS-1$
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				fillTable();
			}
		}
		catch (Exception ex)
		{
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnUnitAdd.setEnabled(true);
			txtUnitName.setText(""); //$NON-NLS-1$
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void btnUnitAddMouseUp()
	{
		try
		{
			if (txtUnitName.getText().trim().equals("")) { //$NON-NLS-1$
				EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_ENTER_UNIT_NAME,SWT.ICON_WARNING);
				txtUnitName.setFocus();
				return;
			}
			List list = (List) EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getInventoryUnits",null);
			String unit = txtUnitName.getText().trim();
			boolean exist = false;
			for (int k = 0; k < list.size(); k++)
			{
				TurqInventoryUnit InvUnit = (TurqInventoryUnit) list.get(k);
				if (InvUnit.getUnitsName().equals(unit))
				{
					exist = true;
					break;
				}
			}
			if (exist)
			{
				EngUICommon.showMessageBox(getParent(),InvLangKeys.MSG_NOT_ENTER_UNIT_NAME_ALREADY_EXIST,SWT.ICON_WARNING);
				return;
			}
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_UNIT_NAME,txtUnitName.getText().trim());
			EngTXCommon.doTransactionTX(InvBLCardAdd.class.getName(),"saveUnit",argMap);
			txtUnitName.setText(""); //$NON-NLS-1$
			EngUICommon.showSavedSuccesfullyMessage(getParent());
			fillTable();
			txtUnitName.setFocus();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void tableInvUnitsMouseDoubleClick(MouseEvent evt)
	{
		TableItem item;
		if (tableInvUnits.getSelection().length > 0)
		{
			item = tableInvUnits.getSelection()[0];
			txtUnitName.setText(item.getText(0));
			txtUnitName.setData(item.getData());
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
			btnUnitAdd.setEnabled(false);
		}
	}
}