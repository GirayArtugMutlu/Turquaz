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

/**
* @author  Onsel Armagan
* @version  $Id$
*/
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.admin.bl.AdmBLUserAdd;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.ui.component.SecureComposite;
public class AdmUIGroups extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private Table tableGroups;
	private TableColumn tableColumnGroupname;
	private TableColumn tableColumnDescription;
	AdmBLGroups blGroups = new AdmBLGroups();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUIUsers inst = new AdmUIUsers(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AdmUIGroups(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	public void save(){
		
	}
	public void delete(){
		
	}
	public void newForm(){
		
	}
	public void search(){
		
	}
	

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(377, 322);
			{
				tableGroups = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
				GridData tableUsersLData = new GridData();
				tableGroups.setHeaderVisible(true);
				tableGroups.setLinesVisible(true);
				tableUsersLData.grabExcessHorizontalSpace = true;
				tableUsersLData.grabExcessVerticalSpace = true;
				tableUsersLData.horizontalAlignment = GridData.FILL;
				tableUsersLData.verticalAlignment = GridData.FILL;
				tableGroups.setLayoutData(tableUsersLData);
				{
					tableColumnGroupname = new TableColumn(tableGroups, SWT.NONE);
					tableColumnGroupname.setText("Group Name");
					tableColumnGroupname.setWidth(112);
				}
				{
					tableColumnDescription = new TableColumn(
						tableGroups,
						SWT.NONE);
					tableColumnDescription.setText("Description");
					tableColumnDescription.setWidth(200);
				}
			}
			this.layout();
			fillTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fillTable(){
		try{
			tableGroups.removeAll();
			List list = blGroups.getGroups();
			TurqGroup group;
			TableItem item;
			for(int i=0;i<list.size();i++){
				group = (TurqGroup)list.get(i);
			   item = new TableItem(tableGroups,SWT.NULL);
			   item.setData(group);
			   item.setText(new String[]{group.getGroupsName(),group.getGroupsDescription()});
				
			}
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}
