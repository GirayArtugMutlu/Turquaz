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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TableSorter;





import com.cloudgarden.resource.SWTResourceManager;
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
public class AccUIAccountingPlan extends org.eclipse.swt.widgets.Composite implements 
SearchComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}


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
			this.setBackground(SWTResourceManager.getColor(128, 128, 255));
	
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

  final TableColumn col = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col.setText(Messages.getString("AccUIAccountingPlan.0")); //$NON-NLS-1$
   col.setWidth(200);

  final TableColumn col2 = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col2.setText(Messages.getString("AccUIAccountingPlan.1")); //$NON-NLS-1$
   col2.setWidth(200);

   
   fillTree(-1,""); //$NON-NLS-1$
	
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
	
	parentId = account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId();
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
		   System.out.println(account.getAccountCode()+" "+parentId.intValue()); //$NON-NLS-1$
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
			fillBranch(item,account.getAccountingAccountsId().intValue(),""); //$NON-NLS-1$
		
			
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
		//if(account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId().intValue()!=-1)
		new AccUIAccountUpdate(this.getShell(),SWT.NULL,account).open();
		
		fillTree(-1,"");
	    
	    
		}
		
		
		
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableTreeAccountingPlan.getTable());
		
	}
}
