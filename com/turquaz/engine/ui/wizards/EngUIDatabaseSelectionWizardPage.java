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
 * @version $Id: EngUIDatabaseSelectionWizardPage.java,v 1.13 2004/11/20
 *          20:43:39 huseyiner Exp $
 */
import java.sql.ResultSet;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALConnection;

public class EngUIDatabaseSelectionWizardPage extends WizardPage {
	private ISelection selection;

	private CCombo comboDatabases;

	private EngDALConnection connection;

	public EngUIDatabaseSelectionWizardPage(ISelection selection) {

		super(""); //$NON-NLS-1$
		setTitle(Messages.getString("EngUIDatabaseSelectionWizardPage.1")); //$NON-NLS-1$
		setDescription(Messages.getString("EngUIDatabaseSelectionWizardPage.2")); //$NON-NLS-1$
		this.selection = selection;
		setPageComplete(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite arg0) {
		Composite container = new Composite(arg0, SWT.NULL);

		this.setControl(container);

	}

	public void ShowPage() {
		final Composite container = (Composite) this.getControl();
		Control children[] = container.getChildren();
		for (int i = 0; i < children.length; i++) {
			children[i].dispose();

		}
		if (checkConnection()) {
			setErrorMessage(null);
			GridLayout layout = new GridLayout();
			container.setLayout(layout);
			layout.numColumns = 2;
			layout.verticalSpacing = 9;

			Label label = new Label(container, SWT.NULL);
			label.setText("&Database Name:"); //$NON-NLS-1$

			comboDatabases = new CCombo(container, SWT.FLAT);
			comboDatabases.setEditable(false);
			comboDatabases.setBackground(SWTResourceManager.getColor(255, 255,
					255));

			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			comboDatabases.setLayoutData(gd);
			comboDatabases.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					setPageComplete(true);
				}
			});

			

			container.layout();

			fillCombo();
		}

		else {
			setErrorMessage(Messages
					.getString("EngUIDatabaseSelectionWizardPage.10") + //$NON-NLS-1$
					Messages.getString("EngUIDatabaseSelectionWizardPage.11")); //$NON-NLS-1$

		}
	}

	public void fillCombo() {

		comboDatabases.removeAll();
		EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard) getWizard())
				.getPage1();
		if (connection != null) {
			if (page1.getComboDBServer().getText().startsWith("Turquaz")) {
				comboDatabases.add("turquaz");
				
			}
			//postgresql

			else if (page1.getComboDBServer().getText()
					.startsWith("Postgresql")) {
				try {
					ResultSet rs = connection
							.getResultSet("SELECT d.datname as name FROM pg_database d where d.datistemplate ='false'"); //$NON-NLS-1$
					while (rs.next()) {
						comboDatabases.add(rs.getString("name")); //$NON-NLS-1$
					}
					rs.close();

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}

	}

	public boolean checkConnection() {
		EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard) getWizard())
				.getPage1();
		EngUIDatabaseConnectionInfoWizardPage page2 = ((EngUIDatabaseConnectionWizard) getWizard())
				.getPage2();

		connection = new EngDALConnection(page1.getComboDBServer().getText()
				.trim(), page2.getTxtUsername().getText().trim(), page2
				.getTxtPassword().getText(), page2.getTxtServerAddress()
				.getText().trim()
				+ ":" + //$NON-NLS-1$
				page2.getTxtServerPort().getText().trim()); //$NON-NLS-1$

		try {
			connection.connect();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	private void dialogChanged() {
		if (comboDatabases.getText().length() == 0) {
			updateStatus(Messages
					.getString("EngUIDatabaseSelectionWizardPage.0")); //$NON-NLS-1$

			return;
		}

		updateStatus(null);
	}

	public IWizardPage getNextPage() {

		EngUICreateTablesWizardPage page = ((EngUIDatabaseConnectionWizard) getWizard())
				.getPage4();
		page.ShowPage(comboDatabases.getText());

		return page;

	}

	/**
	 * @return Returns the comboDatabases.
	 */
	public CCombo getComboDatabases() {
		return comboDatabases;
	}

	/**
	 * @param comboDatabases
	 *            The comboDatabases to set.
	 */
	public void setComboDatabases(CCombo comboDatabases) {
		this.comboDatabases = comboDatabases;
	}
}