package com.turquaz.admin.ui;

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


import javax.swing.table.TableColumn;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTreeEditor;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqModule;

/**
 * 
 * @author onsel
 *
 *@version $Id$
 */
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/


public class AdmUIPermPanel extends org.eclipse.swt.widgets.Composite {

	private TableTreeItem tableTreeItem6;
	private TableTreeItem tableTreeItem5;
	private TableTreeItem tableTreeItem4;
	private TableTreeItem tableTreeItem3;
	private TableTreeItem tableTreeItem2;
	private TableTreeItem tableTreeItem1;
	private TableTree tableTree1;
	private CCombo cCombo1;
	private Composite composite2;
	private Composite composite1;
	public AdmUIPermPanel(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			composite1 = new Composite(this,SWT.NULL);
			cCombo1 = new CCombo(composite1,SWT.NULL);
			composite2 = new Composite(this,SWT.NULL);
			tableTree1 = new TableTree(composite2,SWT.CHECK| SWT.FULL_SELECTION);
			tableTreeItem1 = new TableTreeItem(tableTree1,SWT.NULL);
			tableTreeItem2 = new TableTreeItem(tableTree1,SWT.NULL);
			tableTreeItem3 = new TableTreeItem(tableTreeItem2,SWT.NULL);
			tableTreeItem4 = new TableTreeItem(tableTreeItem3,SWT.NULL);
			tableTreeItem5 = new TableTreeItem(tableTreeItem3,SWT.NULL);
			tableTreeItem6 = new TableTreeItem(tableTreeItem3,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(448,368));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = -1;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
	
			RowData cCombo1LData = new RowData(127, 20);
			cCombo1.setLayoutData(cCombo1LData);
			cCombo1.setText("cCombo1");
			cCombo1.setSize(new org.eclipse.swt.graphics.Point(127,20));
			RowLayout composite1Layout = new RowLayout(256);
			composite1.setLayout(composite1Layout);
			composite1Layout.type = SWT.HORIZONTAL;
			composite1Layout.marginWidth = 0;
			composite1Layout.marginHeight = 0;
			composite1Layout.spacing = 3;
			composite1Layout.wrap = true;
			composite1Layout.pack = true;
			composite1Layout.fill = false;
			composite1Layout.justify = false;
			composite1Layout.marginLeft = 3;
			composite1Layout.marginTop = 3;
			composite1Layout.marginRight = 3;
			composite1Layout.marginBottom = 3;
			composite1.layout();
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.FILL;
			composite2LData.horizontalAlignment = GridData.FILL;
			composite2LData.widthHint = -1;
			composite2LData.heightHint = -1;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = true;
			composite2.setLayoutData(composite2LData);
	
			tableTree1.setSize(new org.eclipse.swt.graphics.Point(422,311));
	
			tableTreeItem1.setText("Yönetici");
			tableTreeItem1.setChecked(false);
	
			tableTreeItem2.setText("Stok");
	
			tableTreeItem3.setText("Stok Kart? ");
	
			tableTreeItem4.setText("Okuma");
	
			tableTreeItem5.setText("Yazma");
	
			tableTreeItem6.setText("Silme");
			FillLayout composite2Layout = new FillLayout(256);
			composite2.setLayout(composite2Layout);
			composite2Layout.type = SWT.HORIZONTAL;
			composite2Layout.marginWidth = 0;
			composite2Layout.marginHeight = 0;
			composite2Layout.spacing = 0;
			composite2.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		try{
		Configuration cfg =new Configuration().setProperty("connection_url","jdbc:postgresql://kulup.sabanciuniv.edu/turquaz");
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		net.sf.hibernate.Transaction tx = session.beginTransaction();
		
		TurqModule module = new TurqModule();
	/*	company.setGroupsName("deneme2");
		company.setCreatedBy("adadf");
		company.setUpdateDate(new java.sql.Date(2002,12,2));
		company.setCreationDate(new java.sql.Date(2002,12,2));
	    company.setGroupsDescription("vwvdwv");
	    company.setUpdatedBy("wvrvwrv");
		session.save(company);
		session.flush();*/
		tx.commit();
		tx = session.beginTransaction();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
			
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			AdmUIPermPanel inst = new AdmUIPermPanel(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,448,368);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	* This is an auto-generated method which you can alter,
	* e.g. to point to a different property file, to modify the key by
	* by prefixing the name of this class, etc.
	*
	* By default, it expects a file called "messages.properties" to exist in the
	* current package, and returns the value of the property defined
	* in that file for the given key
	*/
	public String getExternalizedString(String key){
		try {
			return java.util.ResourceBundle.getBundle("com.turquaz.admin.ui.AdmUIPermPanelMessages").getString(key);
		} catch (java.util.MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
