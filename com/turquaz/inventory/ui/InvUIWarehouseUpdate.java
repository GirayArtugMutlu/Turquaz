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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqInventoryWarehous;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLWarehouseUpdate;
import com.turquaz.inventory.ui.InvUIWarehouseAdd;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class InvUIWarehouseUpdate extends org.eclipse.swt.widgets.Dialog {
	private ToolItem toolDelete;

	private ToolItem toolUpdate;

	private ToolBar toolWarehouseUpdate;

	private CoolItem coolWarehouseUpdate;

	private CoolBar coolBarInvUIWarehouse;

	private InvUIWarehouseAdd compInvUIWarehouse;

	private Shell dialogShell;

	private TurqInventoryWarehous warehouse;

	private InvBLWarehouseUpdate whUpdate = new InvBLWarehouseUpdate();

	public InvUIWarehouseUpdate(Shell parent, int style,
			TurqInventoryWarehous wh) {
		super(parent, style);
		warehouse = wh;

	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will
	 * disappear.
	 */
	public void open() {
		try {
			preInitGUI();

			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM
					| SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			coolBarInvUIWarehouse = new CoolBar(dialogShell, SWT.NULL);
			coolWarehouseUpdate = new CoolItem(coolBarInvUIWarehouse, SWT.NULL);
			toolWarehouseUpdate = new ToolBar(coolBarInvUIWarehouse, SWT.NULL);
			toolUpdate = new ToolItem(toolWarehouseUpdate, SWT.NULL);
			toolDelete = new ToolItem(toolWarehouseUpdate, SWT.NULL);
			compInvUIWarehouse = new InvUIWarehouseAdd(dialogShell, SWT.BORDER);

			dialogShell.setSize(new org.eclipse.swt.graphics.Point(518, 428));

			GridData coolBarInvUIWarehouseLData = new GridData();
			coolBarInvUIWarehouseLData.verticalAlignment = GridData.CENTER;
			coolBarInvUIWarehouseLData.horizontalAlignment = GridData.FILL;
			coolBarInvUIWarehouseLData.widthHint = -1;
			coolBarInvUIWarehouseLData.heightHint = -1;
			coolBarInvUIWarehouseLData.horizontalIndent = 0;
			coolBarInvUIWarehouseLData.horizontalSpan = 1;
			coolBarInvUIWarehouseLData.verticalSpan = 1;
			coolBarInvUIWarehouseLData.grabExcessHorizontalSpace = false;
			coolBarInvUIWarehouseLData.grabExcessVerticalSpace = false;
			coolBarInvUIWarehouse.setLayoutData(coolBarInvUIWarehouseLData);

			coolWarehouseUpdate.setControl(toolWarehouseUpdate);
			coolWarehouseUpdate.setSize(new org.eclipse.swt.graphics.Point(87,
					38));
			coolWarehouseUpdate
					.setPreferredSize(new org.eclipse.swt.graphics.Point(87, 38));
			coolWarehouseUpdate
					.setMinimumSize(new org.eclipse.swt.graphics.Point(87, 38));

			toolUpdate.setText(Messages.getString("InvUIWarehouseUpdate.0")); //$NON-NLS-1$
			final org.eclipse.swt.graphics.Image toolUpdate�mage = new org.eclipse.swt.graphics.Image(
					Display.getDefault(), getClass().getClassLoader()
							.getResourceAsStream("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.setImage(toolUpdate�mage);
			toolUpdate.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});

			toolDelete.setText(Messages.getString("InvUIWarehouseUpdate.2")); //$NON-NLS-1$
			final org.eclipse.swt.graphics.Image toolDelete�mage = new org.eclipse.swt.graphics.Image(
					Display.getDefault(), getClass().getClassLoader()
							.getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.setImage(toolDelete�mage);
			toolDelete.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});

			GridData compInvUIWarehouseLData = new GridData();
			compInvUIWarehouseLData.verticalAlignment = GridData.FILL;
			compInvUIWarehouseLData.horizontalAlignment = GridData.FILL;
			compInvUIWarehouseLData.widthHint = -1;
			compInvUIWarehouseLData.heightHint = -1;
			compInvUIWarehouseLData.horizontalIndent = 0;
			compInvUIWarehouseLData.horizontalSpan = 1;
			compInvUIWarehouseLData.verticalSpan = 1;
			compInvUIWarehouseLData.grabExcessHorizontalSpace = true;
			compInvUIWarehouseLData.grabExcessVerticalSpace = true;
			compInvUIWarehouse.setLayoutData(compInvUIWarehouseLData);
			compInvUIWarehouse.setSize(new org.eclipse.swt.graphics.Point(504,
					371));
			compInvUIWarehouse.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolUpdate�mage.dispose();
					toolDelete�mage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 518, 428);
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

	/** Add your pre-init code in here */
	public void preInitGUI() {
	}

	/** Add your post-init code in here */
	public void postInitGUI() {

		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);

		if (EngBLPermissions.getPermission(compInvUIWarehouse.getClass()
				.getName()) == 2) {
			toolUpdate.setEnabled(true);
		} else if (EngBLPermissions.getPermission(compInvUIWarehouse.getClass()
				.getName()) == 3) {
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}

		compInvUIWarehouse.getTxtTelephone().setText(
				warehouse.getWarehousesTelephone());
		compInvUIWarehouse.getTxtWarehouseAdres().setText(
				warehouse.getWarehousesAddress());
		compInvUIWarehouse.getTxtWarehouseCity().setText(
				warehouse.getWarehousesCity());
		compInvUIWarehouse.getTxtWarehouseName().setText(
				warehouse.getWarehousesName());
		compInvUIWarehouse.getTxtWarehouseDescription().setText(
				warehouse.getWarehousesDescription());

		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();

		int location_X = (parentLocation.x + parentSize.x) / 2
				- (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2
				- (dialogSize.y / 2);

		dialogShell.setLocation(location_X, location_Y);

	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt) {
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);

		try {
			if (!compInvUIWarehouse.verifyFields())
				return;

			whUpdate.updateWarehouse(warehouse, compInvUIWarehouse
					.getTxtWarehouseAdres().getText().trim(),
					compInvUIWarehouse.getTxtTelephone().getText().trim(),
					compInvUIWarehouse.getTxtWarehouseCity().getText().trim(),
					compInvUIWarehouse.getTxtWarehouseDescription().getText()
							.trim(), compInvUIWarehouse.getTxtWarehouseName()
							.getText().trim());
			msg.setMessage(Messages.getString("InvUIWarehouseUpdate.3")); //$NON-NLS-1$
		} catch (Exception ex) {

			ex.printStackTrace();
			msg.setMessage(Messages.getString("InvUIWarehouseUpdate.4")); //$NON-NLS-1$

		}
		msg.open();

	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt) {
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.OK | SWT.CANCEL);
		MessageBox msg = new MessageBox(this.getParent());
		try {
			msg2.setMessage(Messages.getString("InvUIWarehouseUpdate.5")); //$NON-NLS-1$
			int result = msg2.open();
			if (result == SWT.OK) {
				// if the warehouse card contains transactions
				if (whUpdate.hasTransactions(warehouse)) {
					msg
							.setMessage("Warehouse card contains transactions and \ncan not be deleted. Delete transactions first. "); //$NON-NLS-1$
					msg.open();
					return;
				}

				whUpdate.deleteObject(warehouse);
				msg.setMessage(Messages.getString("InvUIWarehouseUpdate.6")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			msg.setMessage(Messages.getString("InvUIWarehouseUpdate.7")); //$NON-NLS-1$
			msg.open();
		}

	}
}