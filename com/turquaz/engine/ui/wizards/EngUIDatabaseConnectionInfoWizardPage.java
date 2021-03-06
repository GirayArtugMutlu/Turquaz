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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.lang.EngLangCommonKeys;

public class EngUIDatabaseConnectionInfoWizardPage extends WizardPage
{
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

	/**
	 * @return Returns the txtPassword.
	 */
	public Text getTxtPassword()
	{
		return txtPassword;
	}

	/**
	 * @param txtPassword
	 *             The txtPassword to set.
	 */
	public void setTxtPassword(Text txtPassword)
	{
		this.txtPassword = txtPassword;
	}

	/**
	 * @return Returns the txtServerAddress.
	 */
	public Text getTxtServerAddress()
	{
		return txtServerAddress;
	}

	/**
	 * @param txtServerAddress
	 *             The txtServerAddress to set.
	 */
	public void setTxtServerAddress(Text txtServerAddress)
	{
		this.txtServerAddress = txtServerAddress;
	}

	/**
	 * @return Returns the txtServerPort.
	 */
	public Text getTxtServerPort()
	{
		return txtServerPort;
	}

	/**
	 * @param txtServerPort
	 *             The txtServerPort to set.
	 */
	public void setTxtServerPort(Text txtServerPort)
	{
		this.txtServerPort = txtServerPort;
	}

	/**
	 * @return Returns the txtUsername.
	 */
	public Text getTxtUsername()
	{
		return txtUsername;
	}

	/**
	 * @param txtUsername
	 *             The txtUsername to set.
	 */
	public void setTxtUsername(Text txtUsername)
	{
		this.txtUsername = txtUsername;
	}
	private ISelection selection;
	private Text txtServerAddress;
	private Text txtServerPort;
	private Text txtUsername;
	private Text txtPassword;

	public EngUIDatabaseConnectionInfoWizardPage(ISelection selection)
	{
		super("Database Connector"); //$NON-NLS-1$
		setTitle(EngLangCommonKeys.STR_DATABASE_WIZARD); //$NON-NLS-1$
		setDescription(EngLangCommonKeys.STR_DATABASE_WIZARD_DESCRIPTION); //$NON-NLS-1$
		this.selection = selection;
		setPageComplete(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite arg0)
	{
		Composite container = new Composite(arg0, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText(EngLangCommonKeys.STR_DATABASE_SERVER); //$NON-NLS-1$
		txtServerAddress = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		txtServerAddress.setLayoutData(gd);
		txtServerAddress.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				txtUsername.setText("");
				dialogChanged();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText("&Port:"); //$NON-NLS-1$
		txtServerPort = new Text(container, SWT.BORDER | SWT.SINGLE);
		EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard) getWizard()).getPage1();
		gd = new GridData(GridData.FILL_HORIZONTAL);
		txtServerPort.setLayoutData(gd);
		txtServerPort.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				dialogChanged();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText(EngLangCommonKeys.STR_USERNAME); //$NON-NLS-1$
		txtUsername = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		txtUsername.setLayoutData(gd);
		txtUsername.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				dialogChanged();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText(EngLangCommonKeys.STR_PASSWORD); //$NON-NLS-1$
		txtPassword = new Text(container, SWT.BORDER | SWT.SINGLE | SWT.PASSWORD);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		txtPassword.setLayoutData(gd);
		txtPassword.addModifyListener(new ModifyListener()
		{
			public void modifyText(ModifyEvent e)
			{
				dialogChanged();
			}
		});
		this.setControl(container);
	}

	private void updateStatus(String message)
	{
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public void updateFields(String type)
	{
		if (type.startsWith("Postgresql")) //$NON-NLS-1$
		{
			txtServerAddress.setText("localhost"); //$NON-NLS-1$
			txtServerPort.setText("5432"); //$NON-NLS-1$
			txtUsername.setText("postgres"); //$NON-NLS-1$
		}
		else if (type.startsWith("Turquaz")) //$NON-NLS-1$
		{
			txtServerAddress.setText("localhost"); //$NON-NLS-1$
			txtServerPort.setText("8877"); //$NON-NLS-1$
			txtUsername.setText("sa"); //$NON-NLS-1$
		}
	}

	private void dialogChanged()
	{
		if (txtServerAddress.getText().length() == 0)
		{
			updateStatus(EngLangCommonKeys.STR_ENTER_DATABASE_SERVER_LOCATION); //$NON-NLS-1$
			return;
		}
		else if (txtUsername.getText().length() == 0)
		{
			updateStatus(EngLangCommonKeys.STR_ENTER_USERNAME); //$NON-NLS-1$
			return;
		}
		updateStatus(null);
	}

	public IWizardPage getNextPage()
	{
		EngUIDatabaseSelectionWizardPage page = ((EngUIDatabaseConnectionWizard) getWizard()).getPage3();
		page.ShowPage();
		return page;
	}
}