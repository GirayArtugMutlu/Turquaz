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



import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.component.TTable;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;

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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;


/**
 * 
 * @author onsel
 * @version $Id$
 */
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
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/


public class InvUICardSearch extends SecureComposite {

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private Table tableSearcResults;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
	private Text txtInvCode;
	private CLabel cLabel2;
	private Text txtInvName;
	private Composite compInvCardSearchPanel;
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
			tableSearcResults = new Table(compInvCardSearch,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnInvName = new TableColumn(tableSearcResults,SWT.NULL);
			tableColumnInventoryCode = new TableColumn(tableSearcResults,SWT.NULL);
			tableColumnAmount = new TableColumn(tableSearcResults,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(573,437));
	
			compInvCardSearch.setSize(new org.eclipse.swt.graphics.Point(573,437));
	
			GridData compInvCardSearchPanelLData = new GridData();
			compInvCardSearchPanelLData.verticalAlignment = GridData.CENTER;
			compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
			compInvCardSearchPanelLData.widthHint = -1;
			compInvCardSearchPanelLData.heightHint = 84;
			compInvCardSearchPanelLData.horizontalIndent = 0;
			compInvCardSearchPanelLData.horizontalSpan = 1;
			compInvCardSearchPanelLData.verticalSpan = 1;
			compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
			compInvCardSearchPanelLData.grabExcessVerticalSpace = false;
			compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
			compInvCardSearchPanel.setSize(new org.eclipse.swt.graphics.Point(563,84));
	
			GridData lblInvNameLData = new GridData();
			lblInvNameLData.verticalAlignment = GridData.CENTER;
			lblInvNameLData.horizontalAlignment = GridData.BEGINNING;
			lblInvNameLData.widthHint = 114;
			lblInvNameLData.heightHint = 18;
			lblInvNameLData.horizontalIndent = 0;
			lblInvNameLData.horizontalSpan = 1;
			lblInvNameLData.verticalSpan = 1;
			lblInvNameLData.grabExcessHorizontalSpace = false;
			lblInvNameLData.grabExcessVerticalSpace = false;
			lblInvName.setLayoutData(lblInvNameLData);
			lblInvName.setText("Inventory Name");
			lblInvName.setSize(new org.eclipse.swt.graphics.Point(114,18));
	
			GridData txtInvNameLData = new GridData();
			txtInvNameLData.verticalAlignment = GridData.CENTER;
			txtInvNameLData.horizontalAlignment = GridData.BEGINNING;
			txtInvNameLData.widthHint = 168;
			txtInvNameLData.heightHint = 16;
			txtInvNameLData.horizontalIndent = 0;
			txtInvNameLData.horizontalSpan = 1;
			txtInvNameLData.verticalSpan = 1;
			txtInvNameLData.grabExcessHorizontalSpace = false;
			txtInvNameLData.grabExcessVerticalSpace = false;
			txtInvName.setLayoutData(txtInvNameLData);
			txtInvName.setSize(new org.eclipse.swt.graphics.Point(168,16));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.BEGINNING;
			cLabel2LData.widthHint = 97;
			cLabel2LData.heightHint = 17;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Inventory Code");
			cLabel2.setSize(new org.eclipse.swt.graphics.Point(97,17));
	
			GridData txtInvCodeLData = new GridData();
			txtInvCodeLData.verticalAlignment = GridData.CENTER;
			txtInvCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtInvCodeLData.widthHint = 147;
			txtInvCodeLData.heightHint = 17;
			txtInvCodeLData.horizontalIndent = 0;
			txtInvCodeLData.horizontalSpan = 1;
			txtInvCodeLData.verticalSpan = 1;
			txtInvCodeLData.grabExcessHorizontalSpace = false;
			txtInvCodeLData.grabExcessVerticalSpace = false;
			txtInvCode.setLayoutData(txtInvCodeLData);
			txtInvCode.setSize(new org.eclipse.swt.graphics.Point(147,17));
	
			GridData lblInvGroupLData = new GridData();
			lblInvGroupLData.verticalAlignment = GridData.CENTER;
			lblInvGroupLData.horizontalAlignment = GridData.BEGINNING;
			lblInvGroupLData.widthHint = 110;
			lblInvGroupLData.heightHint = 17;
			lblInvGroupLData.horizontalIndent = 0;
			lblInvGroupLData.horizontalSpan = 1;
			lblInvGroupLData.verticalSpan = 1;
			lblInvGroupLData.grabExcessHorizontalSpace = false;
			lblInvGroupLData.grabExcessVerticalSpace = false;
			lblInvGroup.setLayoutData(lblInvGroupLData);
			lblInvGroup.setText("Inventory Group");
			lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(110,17));
	
			GridData comboInvGroupLData = new GridData();
			comboInvGroupLData.verticalAlignment = GridData.CENTER;
			comboInvGroupLData.horizontalAlignment = GridData.BEGINNING;
			comboInvGroupLData.widthHint = 119;
			comboInvGroupLData.heightHint = 14;
			comboInvGroupLData.horizontalIndent = 0;
			comboInvGroupLData.horizontalSpan = 1;
			comboInvGroupLData.verticalSpan = 1;
			comboInvGroupLData.grabExcessHorizontalSpace = false;
			comboInvGroupLData.grabExcessVerticalSpace = false;
			comboInvGroup.setLayoutData(comboInvGroupLData);
			comboInvGroup.setSize(new org.eclipse.swt.graphics.Point(119,16));
			GridLayout compInvCardSearchPanelLayout = new GridLayout(4, true);
			compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
			compInvCardSearchPanelLayout.marginWidth = 5;
			compInvCardSearchPanelLayout.marginHeight = 5;
			compInvCardSearchPanelLayout.numColumns = 4;
			compInvCardSearchPanelLayout.makeColumnsEqualWidth = false;
			compInvCardSearchPanelLayout.horizontalSpacing = 5;
			compInvCardSearchPanelLayout.verticalSpacing = 5;
			compInvCardSearchPanel.layout();
	
			GridData tableSearcResultsLData = new GridData();
			tableSearcResultsLData.verticalAlignment = GridData.FILL;
			tableSearcResultsLData.horizontalAlignment = GridData.FILL;
			tableSearcResultsLData.widthHint = -1;
			tableSearcResultsLData.heightHint = -1;
			tableSearcResultsLData.horizontalIndent = 0;
			tableSearcResultsLData.horizontalSpan = 1;
			tableSearcResultsLData.verticalSpan = 1;
			tableSearcResultsLData.grabExcessHorizontalSpace = true;
			tableSearcResultsLData.grabExcessVerticalSpace = true;
			tableSearcResults.setLayoutData(tableSearcResultsLData);
			tableSearcResults.setHeaderVisible(true);
			tableSearcResults.setLinesVisible(true);
			tableSearcResults.setSize(new org.eclipse.swt.graphics.Point(543,318));
			tableSearcResults.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableSearcResultsMouseDoubleClick(evt);
				}
			});
	
			tableColumnInvName.setText("Inventory Name");
			tableColumnInvName.setWidth(115);
	
			tableColumnInventoryCode.setText("Inventory Code");
			tableColumnInventoryCode.setWidth(107);
	
			tableColumnAmount.setText("Amount");
			tableColumnAmount.setWidth(118);
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
	tableSearcResults.removeAll();
	InvBLCardSearch cardSearch = new InvBLCardSearch();
	List result;
	try{
	if(comboInvGroup.getSelectionIndex()==-1){
	result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),null);
	
	}
	else{
	result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),(TurqInventoryGroup)comboInvGroup.getData(comboInvGroup.getText()));
	
	}
	
	TableItem item;
	int listSize = result.size();
	for(int i =0; i<listSize;i++){
	TurqInventoryCard card = (TurqInventoryCard)result.get(i);
	item = new TableItem(tableSearcResults,SWT.NULL);
	item.setData(card);
	item.setText(new String[]{card.getCardName(),card.getCardInventoryCode()});
	
	
	}
	
	System.out.println(result.size());
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
			InvUICardSearch inst = new InvUICardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,573,437);
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
/** Auto-generated event handler method */
	protected void tableSearcResultsMouseDoubleClick(MouseEvent evt){
    TableItem [] selection= tableSearcResults.getSelection();	
	
	if(selection.length>0){
	
	TurqInventoryCard card = (TurqInventoryCard)selection[0].getData();
	new InvUICardUpdateDialog(this.getShell(),SWT.NULL,card).open();
	
	
	}
	}
}
