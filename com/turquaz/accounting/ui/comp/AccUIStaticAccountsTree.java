/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.ui.comp;
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccUIStaticAccountsTree {
	public AccUIStaticAccountsTree(){
		
			
	}
	public Tree fillTree(Tree tree)throws Exception{
		try{
		
		Map treeItems = new HashMap();
		List accountsList = EngBLAccountingAccounts.getAccounts();
		
		TurqAccountingAccount account;
		Integer parentId;
		
	    TreeItem item;
		
		for(int i=0;i<accountsList.size();i++){
		account = (TurqAccountingAccount)accountsList.get(i);
		parentId = account.getTurqAccountingAccount().getAccountingAccountsId();
		
		if(parentId.intValue()==-1){
		item = new TreeItem(tree,SWT.NULL);
		item.setText(account.getAccountCode()+" - "+account.getAccountName());
		item.setData(account);
		treeItems.put(account.getAccountingAccountsId(),item);
		}
		
		else{
			
		TreeItem parentItem = (TreeItem)treeItems.get(parentId);
		if(parentItem == null){
		   System.out.println(account.getAccountCode()+" "+parentId.intValue());
		}
		else{
		item = new TreeItem(parentItem,SWT.NULL);	
		treeItems.put(account.getAccountingAccountsId(),item);
		item.setText(account.getAccountCode()+" - "+account.getAccountName());
		item.setData(account);
		}
		
		}
			
		
		}
		
		
		
		return tree;	
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
		
	}
	
	

}
