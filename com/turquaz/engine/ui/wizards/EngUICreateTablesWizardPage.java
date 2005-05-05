package com.turquaz.engine.ui.wizards;

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
 * @author Onsel Armagan
 * @version $Id$
 */
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.turquaz.engine.lang.EngLangCommonKeys;
public class EngUICreateTablesWizardPage extends WizardPage
{
	private ISelection selection;
	private boolean isDisplaySet = false;

	public EngUICreateTablesWizardPage(ISelection selection)
	{
		super("Database Connector"); //$NON-NLS-1$
		setTitle(EngLangCommonKeys.STR_DATABASE_WIZARD); //$NON-NLS-1$
		setDescription(EngLangCommonKeys.STR_DATABASE_WIZARD_DESCRIPTION); //$NON-NLS-1$
		this.selection = selection;
		setPageComplete(true);
	}

	public void createControl(Composite arg0)
	{
		Composite container = new Composite(arg0, SWT.NULL);
		this.setControl(container);
	}

	public void ShowPage(String dbName)
	{
		EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard) getWizard()).getPage1();
		Composite container = (Composite) this.getControl();
		Control children[] = container.getChildren();
		for (int i = 0; i < children.length; i++)
		{
			children[i].dispose();
		}
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		if (page1.getComboDBServer().getText().startsWith("Turquaz")) //$NON-NLS-1$
		{
			label.setText(EngLangCommonKeys.STR_DATABASE_WIZARD_SUCCESS); //$NON-NLS-1$
		}
		else
		{
			label.setText(EngLangCommonKeys.STR_DATABASE_WIZARD_SUCCESS + EngLangCommonKeys.STR_CHECK_DATABASE_TABLES); //$NON-NLS-1$ //$NON-NLS-2$
		}
		container.layout();
	}

	public boolean checkTables()
	{
		EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard) getWizard()).getPage1();
		if (page1.getComboDBServer().getText().startsWith("Turquaz")) //$NON-NLS-1$
		{
			// no need to create tables
			return true;
		}
		else
		{
			// if postgresql
			return false;
		}
	}

	/**
	 * @return Returns the isDisplaySet.
	 */
	public boolean isDisplaySet()
	{
		return isDisplaySet;
	}

	/**
	 * @param isDisplaySet
	 *             The isDisplaySet to set.
	 */
	public void setDisplaySet(boolean isDisplaySet)
	{
		this.isDisplaySet = isDisplaySet;
	}

	/**
	 * @return Returns the selection.
	 */
	public ISelection getSelection()
	{
		return selection;
	}

	/**
	 * @param selection
	 *             The selection to set.
	 */
	public void setSelection(ISelection selection)
	{
		this.selection = selection;
	}
}