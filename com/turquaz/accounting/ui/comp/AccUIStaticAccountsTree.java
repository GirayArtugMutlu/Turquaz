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
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUIStaticAccountsTree
{
	public AccUIStaticAccountsTree()
	{
	}

	public Tree fillTree(Tree tree) throws Exception
	{
		try
		{
			Map treeItems = new HashMap();
			List accountsList = EngBLAccountingAccounts.getAccounts();
			TurqAccountingAccount account;
			Integer parentId;
			TreeItem item;
			for (int i = 0; i < accountsList.size(); i++)
			{
				account = (TurqAccountingAccount) accountsList.get(i);
				parentId = account.getTurqAccountingAccountByParentAccount().getId();
				if (parentId.intValue() == -1)
				{
					item = new TreeItem(tree, SWT.NULL);
					item.setText(account.getAccountCode() + " - " + account.getAccountName());
					item.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false));
					item.setData(account);
					{
						//Register as a resource user - SWTResourceManager will
						//handle the obtaining and disposing of resources
						SWTResourceManager.registerResourceUser(item);
					}
					treeItems.put(account.getId(), item);
				}
				else
				{
					TreeItem parentItem = (TreeItem) treeItems.get(parentId);
					if (parentItem == null)
					{
						System.out.println(account.getAccountCode() + " " + parentId.intValue());
					}
					else
					{
						item = new TreeItem(parentItem, SWT.NULL);
						treeItems.put(account.getId(), item);
						item.setText(account.getAccountCode() + " - " + account.getAccountName());
						item.setData(account);
					}
				}
			}
			return tree;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}