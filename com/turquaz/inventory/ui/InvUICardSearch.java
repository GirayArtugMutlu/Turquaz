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

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.SecureComposite;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;

import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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


public class InvUICardSearch extends  Composite implements SecureComposite,SearchComposite {

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private Table tableSearcResults;
	private Text txtInvCode;
	private CLabel lblInvCode;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
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

			this.setSize(new org.eclipse.swt.graphics.Point(573,437));

			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			{
				compInvCardSearch = new Composite(this, SWT.NONE);
				GridLayout compInvCardSearchLayout = new GridLayout();
				compInvCardSearchLayout.makeColumnsEqualWidth = true;
				compInvCardSearch.setLayout(compInvCardSearchLayout);
				compInvCardSearch.setSize(new org.eclipse.swt.graphics.Point(
					573,
					437));
				{
					compInvCardSearchPanel = new Composite(compInvCardSearch, SWT.NONE);
					GridLayout compInvCardSearchPanelLayout = new GridLayout();
					compInvCardSearchPanelLayout.numColumns = 4;
					compInvCardSearchPanel
						.setSize(new org.eclipse.swt.graphics.Point(563, 84));
					GridData compInvCardSearchPanelLData = new GridData();
					compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
					compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
					compInvCardSearchPanelLData.heightHint = 84;
					compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
					compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
					{
						lblInvCode = new CLabel(
							compInvCardSearchPanel,
							SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2LData.widthHint = 97;
						cLabel2LData.heightHint = 17;
						lblInvCode.setLayoutData(cLabel2LData);
						lblInvCode.setText(Messages
							.getString("InvUICardSearch.1")); //$NON-NLS-1$
						lblInvCode.setSize(new org.eclipse.swt.graphics.Point(
							97,
							17));
					}
					{
						txtInvCode = new Text(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeLData = new GridData();
						txtInvCodeLData.widthHint = 141;
						txtInvCodeLData.heightHint = 17;
						txtInvCode.setLayoutData(txtInvCodeLData);
						txtInvCode.setSize(new org.eclipse.swt.graphics.Point(
							147,
							17));
					}
					{
						lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvName.setText(Messages
							.getString("InvUICardSearch.0"));
						lblInvName.setSize(100, 18);
						GridData lblInvNameLData = new GridData();
						lblInvNameLData.widthHint = 100;
						lblInvNameLData.heightHint = 18;
						lblInvName.setLayoutData(lblInvNameLData);
					}
					{
						txtInvName = new Text(compInvCardSearchPanel, SWT.NONE);
						txtInvName.setSize(new org.eclipse.swt.graphics.Point(
							168,
							16));
						GridData txtInvNameLData = new GridData();
						txtInvNameLData.widthHint = 162;
						txtInvNameLData.heightHint = 16;
						txtInvName.setLayoutData(txtInvNameLData);
					}
					{
						lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvGroup.setText(Messages
							.getString("InvUICardSearch.2"));
						lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(
							110,
							17));
						GridData lblInvGroupLData = new GridData();
						lblInvGroupLData.widthHint = 110;
						lblInvGroupLData.heightHint = 17;
						lblInvGroup.setLayoutData(lblInvGroupLData);
					}
					{
						comboInvGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
						comboInvGroup
							.setSize(new org.eclipse.swt.graphics.Point(119, 16));
						GridData comboInvGroupLData = new GridData();
						comboInvGroupLData.widthHint = 97;
						comboInvGroupLData.heightHint = 16;
						comboInvGroup.setLayoutData(comboInvGroupLData);
					}
				}
				{
					tableSearcResults = new Table(compInvCardSearch, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
					tableSearcResults.setHeaderVisible(true);
					tableSearcResults.setLinesVisible(true);
					tableSearcResults
						.setSize(new org.eclipse.swt.graphics.Point(543, 318));
					GridData tableSearcResultsLData = new GridData();
					tableSearcResults.addMouseListener(new MouseAdapter() {
						public void mouseDoubleClick(MouseEvent evt) {
							tableSearcResultsMouseDoubleClick(evt);
						}
					});
					tableSearcResultsLData.verticalAlignment = GridData.FILL;
					tableSearcResultsLData.horizontalAlignment = GridData.FILL;
					tableSearcResultsLData.grabExcessHorizontalSpace = true;
					tableSearcResultsLData.grabExcessVerticalSpace = true;
					tableSearcResults.setLayoutData(tableSearcResultsLData);
					{
						tableColumnInvName = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnInvName.setText("Stok Kodu");
						tableColumnInvName.setWidth(115);
					}
					{
						tableColumnInventoryCode = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnInventoryCode.setText("Stok Adý");
						tableColumnInventoryCode.setWidth(107);
					}
					{
						tableColumnAmount = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnAmount.setText(Messages
							.getString("InvUICardSearch.5"));
						tableColumnAmount.setWidth(118);
					}
				}
			}
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
	this.txtInvName.setFocus();
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
	item.setText(new String[]{card.getCardInventoryCode(),card.getCardName()});
	
	
	}
	
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
	search();
	
	}
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableSearcResults);
		
	}
}
