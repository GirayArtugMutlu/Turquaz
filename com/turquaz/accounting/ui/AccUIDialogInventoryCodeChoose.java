package com.turquaz.accounting.ui;

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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.ui.comp.AccUIAccountsTree;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Tree;
import com.turquaz.accounting.bl.AccBLAccountAdd;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a for-profit company or business) then you should purchase a license - please visit www.cloudgarden.com for details.
 */
public class AccUIDialogInventoryCodeChoose extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Tree accountTree;
	private AccBLAccountAdd blAccount;
	Object returnObj[] = new Object[2];

	public AccUIDialogInventoryCodeChoose(Shell parent, int style)
	{
		super(parent, style);
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public Object[] showDialog()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			accountTree = new Tree(dialogShell, SWT.NULL);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(304, 208));
			accountTree.setSize(new org.eclipse.swt.graphics.Point(298, 192));
			accountTree.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					accountTreeMouseDoubleClick(evt);
				}
			});
			FillLayout dialogShellLayout = new FillLayout(256);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.type = SWT.HORIZONTAL;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.spacing = 0;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 304, 208);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return returnObj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	/** Add your pre-init code in here */
	public void preInitGUI()
	{
		blAccount = new AccBLAccountAdd();
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
		AccUIAccountsTree treeFactory = new AccUIAccountsTree();
		accountTree = treeFactory.fillTree(-1, "", accountTree);
	}

	/**
	 * This static method creates a new instance of this class and shows it inside a new Shell. It is a convenience method for showing the
	 * GUI, but it can be copied and used as a basis for your own code. * It is auto-generated code - the body of this method will be
	 * re-generated after any changes are made to the GUI. However, if you delete this method it will not be re-created.
	 */
	public static void showGUI()
	{
		try
		{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			AccUIDialogInventoryCodeChoose inst = new AccUIDialogInventoryCodeChoose(shell, SWT.NULL);
			inst.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void accountTreeMouseDoubleClick(MouseEvent evt)
	{
		returnObj[0] = accountTree.getSelection()[0].getText();
		returnObj[1] = accountTree.getSelection()[0].getData();
		dialogShell.close();
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
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			accountTree = new Tree(dialogShell, SWT.NULL);
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(304, 208));
			accountTree.setSize(new org.eclipse.swt.graphics.Point(298, 192));
			accountTree.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					accountTreeMouseDoubleClick(evt);
				}
			});
			FillLayout dialogShellLayout = new FillLayout(256);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.type = SWT.HORIZONTAL;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.spacing = 0;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 304, 208);
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
			e.printStackTrace();
		}
	}
}