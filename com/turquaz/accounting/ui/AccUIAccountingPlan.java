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



import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.dal.TurqAccountingAccount;




/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAccountingPlan extends org.eclipse.swt.widgets.Composite {

	private TableTree tableTreeAccountingPlan;
	private AccBLAccountAdd blAccount = new AccBLAccountAdd();
	public AccUIAccountingPlan(Composite parent, int style) {
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
	
			tableTreeAccountingPlan = new TableTree(this,SWT.FULL_SELECTION);
	
			this.setSize(new org.eclipse.swt.graphics.Point(468,276));
			final Color AccUIAccountingPlanbackground = new Color(Display.getDefault(),128,128,255);
			this.setBackground(AccUIAccountingPlanbackground);
	
			GridData tableTreeAccountingPlanLData = new GridData();
			tableTreeAccountingPlanLData.verticalAlignment = GridData.FILL;
			tableTreeAccountingPlanLData.horizontalAlignment = GridData.FILL;
			tableTreeAccountingPlanLData.widthHint = -1;
			tableTreeAccountingPlanLData.heightHint = -1;
			tableTreeAccountingPlanLData.horizontalIndent = 0;
			tableTreeAccountingPlanLData.horizontalSpan = 1;
			tableTreeAccountingPlanLData.verticalSpan = 1;
			tableTreeAccountingPlanLData.grabExcessHorizontalSpace = true;
			tableTreeAccountingPlanLData.grabExcessVerticalSpace = true;
			tableTreeAccountingPlan.setLayoutData(tableTreeAccountingPlanLData);
			tableTreeAccountingPlan.setSize(new org.eclipse.swt.graphics.Point(442,250));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					AccUIAccountingPlanbackground.dispose();
				}
			});
	
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
	tableTreeAccountingPlan.getTable().addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableTreeAccountingPlanMouseDoubleClick(evt);
				}
			});
	
	
	tableTreeAccountingPlan.getTable().setLinesVisible(true);
	tableTreeAccountingPlan.getTable().setHeaderVisible(true);

   TableColumn col = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col.setText("Account Code");
   col.setWidth(200);
   col = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col.setText("Account Name");
   col.setWidth(200);
   
   fillTree(-1,"");
	
	}
	
			
/**
 * 
 * @param parent Parent Account
 * @param codeCrit 
 */	
public void fillTree(int parent, String codeCrit){
	try{
		
	Map treeItems = new HashMap();	
	tableTreeAccountingPlan.removeAll();	
	TableTreeItem item;
	List mainBranches = blAccount.getAllAccounts();
	TurqAccountingAccount account;

	Integer parentId;
	
	
	
	for(int i =0; i< mainBranches.size();i++){
	account = (TurqAccountingAccount)mainBranches.get(i);
	
	parentId = account.getTurqAccountingAccount().getAccountingAccountsId();
	if(parentId.intValue()==-1){
		item = new TableTreeItem(tableTreeAccountingPlan,SWT.NULL);
		item.setText(0,account.getAccountCode());
		item.setText(1,account.getAccountName());
		item.setData(account);	
		treeItems.put(account.getAccountingAccountsId(),item);
		}
		
		else{
			
		TableTreeItem parentItem = (TableTreeItem)treeItems.get(parentId);
		if(parentItem == null){
		   System.out.println(account.getAccountCode()+" "+parentId.intValue());
		}
		else{
		item = new TableTreeItem(parentItem,SWT.NULL);	
		treeItems.put(account.getAccountingAccountsId(),item);
		item.setText(0,account.getAccountCode());
		item.setText(1,account.getAccountName());
		item.setData(account);	
		}
		
		}
	
	}
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
		
	
	
	}
	
	/**
	 * 
	 * @param parentItem
	 * @param parent_id
	 * @param codeCriteria Account code criteria for branches
	 */
	public void fillBranch(TableTreeItem parentItem, int parent_id, String codeCriteria){
		try{
			
		
			TableTreeItem item;
			List mainBranches = blAccount.getAccount(parent_id, codeCriteria);
			TurqAccountingAccount account;
			for(int i =0; i< mainBranches.size();i++){
			
			account = (TurqAccountingAccount)mainBranches.get(i);
			item = new TableTreeItem(parentItem,SWT.NULL);
			item.setText(0,account.getAccountCode());
			item.setText(1,account.getAccountName());
			item.setData(account);
			fillBranch(item,account.getAccountingAccountsId().intValue(),"");
		
			
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	/** Auto-generated event handler method */
	protected void tableTreeAccountingPlanMouseDoubleClick(MouseEvent evt){
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		
		if(items.length>0){
		TurqAccountingAccount account =(TurqAccountingAccount)items[0].getData();
		// it's not an main account
		// main accounts cannot be edited
		new AccUIAccountUpdate(this.getShell(),SWT.NULL,account).open();
		
		items[0].setText(0,account.getAccountCode());
		items[0].setText(1,account.getAccountName());
		items[0].setData(account); 
	    
	    
		}
		
		
		
	}
}
