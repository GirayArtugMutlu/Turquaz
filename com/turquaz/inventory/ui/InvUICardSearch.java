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



import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.component.TTable;
import com.turquaz.inventory.bl.InvBLCardAdd;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;


/**
 * 
 * @author onsel
 * @version $Id$
 */
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/

public class InvUICardSearch extends SecureComposite {

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private TableColumn tableColumnInvName;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
	private Text txtInvCode;
	private CLabel cLabel2;
	private Text txtInvName;
	private CLabel lblInvName;
	private Table table1;
	private Composite compInvCardSearchPanel;
	private Composite compInvCardSearch;
	public InvUICardSearch(Composite parent, int style) {
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
	
			compInvCardSearch = new Composite(this,SWT.NULL);
			compInvCardSearchPanel = new Composite(compInvCardSearch,SWT.NULL);
			lblInvName = new CLabel(compInvCardSearchPanel,SWT.NULL);
			txtInvName = new Text(compInvCardSearchPanel,SWT.NULL);
			cLabel2 = new CLabel(compInvCardSearchPanel,SWT.NULL);
			txtInvCode = new Text(compInvCardSearchPanel,SWT.NULL);
			lblInvGroup = new CLabel(compInvCardSearchPanel,SWT.NULL);
			comboInvGroup = new CCombo(compInvCardSearchPanel,SWT.NULL);
			table1 = new Table(compInvCardSearch,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnInvName = new TableColumn(table1,SWT.NULL);
			tableColumnInventoryCode = new TableColumn(table1,SWT.NULL);
			tableColumnAmount = new TableColumn(table1,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(553,434));
	
			compInvCardSearch.setSize(new org.eclipse.swt.graphics.Point(553,434));
	
			GridData compInvCardSearchPanelLData = new GridData();
			compInvCardSearchPanelLData.verticalAlignment = GridData.CENTER;
			compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
			compInvCardSearchPanelLData.widthHint = -1;
			compInvCardSearchPanelLData.heightHint = 124;
			compInvCardSearchPanelLData.horizontalIndent = 0;
			compInvCardSearchPanelLData.horizontalSpan = 1;
			compInvCardSearchPanelLData.verticalSpan = 1;
			compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
			compInvCardSearchPanelLData.grabExcessVerticalSpace = false;
			compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
			compInvCardSearchPanel.setSize(new org.eclipse.swt.graphics.Point(543,124));
	
			GridData lblInvNameLData = new GridData();
			lblInvNameLData.widthHint = 84;
			lblInvNameLData.heightHint = 19;
			lblInvName.setLayoutData(lblInvNameLData);
			lblInvName.setText("Inventory Name");
			lblInvName.setSize(new org.eclipse.swt.graphics.Point(84,19));
	
			GridData txtInvNameLData = new GridData();
			txtInvNameLData.widthHint = 149;
			txtInvNameLData.heightHint = 16;
			txtInvName.setLayoutData(txtInvNameLData);
			txtInvName.setSize(new org.eclipse.swt.graphics.Point(149,16));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.widthHint = 85;
			cLabel2LData.heightHint = 18;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Inventory Code");
			cLabel2.setSize(new org.eclipse.swt.graphics.Point(85,18));
	
			GridData txtInvCodeLData = new GridData();
			txtInvCodeLData.widthHint = 149;
			txtInvCodeLData.heightHint = 17;
			txtInvCode.setLayoutData(txtInvCodeLData);
			txtInvCode.setSize(new org.eclipse.swt.graphics.Point(149,17));
	
			GridData lblInvGroupLData = new GridData();
			lblInvGroupLData.widthHint = 86;
			lblInvGroupLData.heightHint = 19;
			lblInvGroup.setLayoutData(lblInvGroupLData);
			lblInvGroup.setText("Inventory Group");
			lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(86,19));
	
			GridData comboInvGroupLData = new GridData();
			comboInvGroupLData.widthHint = 136;
			comboInvGroupLData.heightHint = 17;
			comboInvGroup.setLayoutData(comboInvGroupLData);
			comboInvGroup.setSize(new org.eclipse.swt.graphics.Point(136,17));
			GridLayout compInvCardSearchPanelLayout = new GridLayout(4, true);
			compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
			compInvCardSearchPanelLayout.marginWidth = 5;
			compInvCardSearchPanelLayout.marginHeight = 5;
			compInvCardSearchPanelLayout.numColumns = 4;
			compInvCardSearchPanelLayout.makeColumnsEqualWidth = false;
			compInvCardSearchPanelLayout.horizontalSpacing = 5;
			compInvCardSearchPanelLayout.verticalSpacing = 5;
			compInvCardSearchPanel.layout();
	
			GridData table1LData = new GridData();
			table1LData.verticalAlignment = GridData.FILL;
			table1LData.horizontalAlignment = GridData.FILL;
			table1LData.widthHint = -1;
			table1LData.heightHint = -1;
			table1LData.horizontalIndent = 0;
			table1LData.horizontalSpan = 1;
			table1LData.verticalSpan = 1;
			table1LData.grabExcessHorizontalSpace = true;
			table1LData.grabExcessVerticalSpace = true;
			table1.setLayoutData(table1LData);
			table1.setHeaderVisible(true);
			table1.setLinesVisible(true);
			table1.setSize(new org.eclipse.swt.graphics.Point(527,279));
	
			tableColumnInvName.setText("Inventory Name");
			tableColumnInvName.setWidth(100);
	
			tableColumnInventoryCode.setText("Inventory Code");
			tableColumnInventoryCode.setWidth(107);
	
			tableColumnAmount.setText("Amount");
			tableColumnAmount.setWidth(100);
			GridLayout compInvCardSearchLayout = new GridLayout(1, true);
			compInvCardSearch.setLayout(compInvCardSearchLayout);
			compInvCardSearchLayout.marginWidth = 5;
			compInvCardSearchLayout.marginHeight = 5;
			compInvCardSearchLayout.numColumns = 1;
			compInvCardSearchLayout.makeColumnsEqualWidth = true;
			compInvCardSearchLayout.horizontalSpacing = 5;
			compInvCardSearchLayout.verticalSpacing = 5;
			compInvCardSearch.layout();
			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			thisLayout.type = SWT.HORIZONTAL;
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.spacing = 0;
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

		
		fillComboGroup();
		
				
	}
	public void fillComboGroup(){
	try {
			java.util.List groupLst = invBLCardAdd.getInventoryGroups();
			TableItem item = null;
			TurqInventoryGroup trqInvGroup;
			for (int i = 0; i < groupLst.size(); i++) {
				trqInvGroup = (TurqInventoryGroup) groupLst.get(i);
				comboInvGroup.add(trqInvGroup.getGroupsName());
				comboInvGroup.setData(trqInvGroup.getGroupsName(), trqInvGroup);
					

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	
	}
	
	public void save(){
		
	}
	public void delete(){
		
	}
	public void newForm(){
		
	}
	public void search(){
		
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
			InvUICardSearch inst = new InvUICardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,553,434);
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
}
