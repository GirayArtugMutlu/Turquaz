/*
 * Created on Oct 4, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.ui.comp;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccUIAccountsTree{
	private AccBLAccountAdd blAccount = new AccBLAccountAdd();
	public AccUIAccountsTree(){
	
		
	}
	public Tree fillTree(int parent, String codeCrit,Tree tree){
	try{	
	TreeItem item;
	List mainBranches = blAccount.getAccount(parent, codeCrit);
	TurqAccountingAccount account;
	for(int i =0; i< mainBranches.size();i++){
	
	account = (TurqAccountingAccount)mainBranches.get(i);
	item = new TreeItem(tree,SWT.NULL);
	item.setText(account.getAccountCode()+" - "+account.getAccountName() );	
	item.setData(account);	
	fillBranch(item,account.getAccountingAccountsId().intValue(),"");
	
	}
	return tree;
	}
	catch(Exception ex){
		ex.printStackTrace();
		return tree;
	}
		
	
	
	}
	public void fillBranch(TreeItem parentItem, int parent_id, String codeCriteria){
		try{
			
		
			TreeItem item;
			List mainBranches = blAccount.getAccount(parent_id, codeCriteria);
			TurqAccountingAccount account;
			for(int i =0; i< mainBranches.size();i++){
			
			account = (TurqAccountingAccount)mainBranches.get(i);
			item = new TreeItem(parentItem,SWT.NULL);
			item.setText(account.getAccountCode()+" - "+account.getAccountName() );	
			item.setData(account);
			fillBranch(item,account.getAccountingAccountsId().intValue(),"");
		
			
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	

}
