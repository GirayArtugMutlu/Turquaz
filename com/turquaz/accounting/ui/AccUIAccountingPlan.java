package com.turquaz.accounting.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free so ftware. You can redistribute it and/or modify */
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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.common.HashBag;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.lang.*;
import com.cloudgarden.resource.SWTResourceManager;


/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUIAccountingPlan extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	Menu popup;
	private TableTree tableTreeAccountingPlan;
	private HashMap accountTotals;

	public AccUIAccountingPlan(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			tableTreeAccountingPlan = new TableTree(this, SWT.FULL_SELECTION);
			this.setSize(new org.eclipse.swt.graphics.Point(468, 276));
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
			tableTreeAccountingPlan.setSize(new org.eclipse.swt.graphics.Point(442, 250));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
			EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
		try
		{
			//Add popup menu to delete account
			popup = new Menu(getShell(), SWT.POP_UP);
			MenuItem item = new MenuItem(popup, SWT.PUSH);
			item.setText(EngLangCommonKeys.STR_DELETE);
			item.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					delete();
				}
			});
			item = new MenuItem(popup, SWT.PUSH);
			item.setText(AccLangKeys.STR_NEW_ACCOUNT); 
			item.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					try
					{
						TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
						if (items.length > 0)
						{
							Integer accountId=(Integer) items[0].getData();
							boolean updated=new AccUIAddAccountDialog(getShell(), SWT.NULL).open((HashMap)allAccounts.get(accountId));
							if (updated)
							{
								fillTree(-1, ""); //$NON-NLS-1$
							}
						}
					}
					catch (Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			tableTreeAccountingPlan.getTable().addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					try
					{
						tableTreeAccountingPlanMouseDoubleClick(evt);
					}
					catch(Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			tableTreeAccountingPlan.getTable().setLinesVisible(true);
			tableTreeAccountingPlan.getTable().setHeaderVisible(true);
			tableTreeAccountingPlan.setMenu(popup);
			final TableColumn col = new TableColumn(tableTreeAccountingPlan.getTable(), SWT.LEFT);
			col.setText(AccLangKeys.STR_ACCOUNT_CODE); 
			col.setWidth(200);
			final TableColumn col2 = new TableColumn(tableTreeAccountingPlan.getTable(), SWT.LEFT);
			col2.setText(AccLangKeys.STR_ACCOUNT_NAME); 
			col2.setWidth(200);
			fillTree(-1, ""); //$NON-NLS-1$
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	/**
	 * @param parent
	 *            Parent Account
	 * @param codeCrit
	 */
	Map treeItems;
	Map allAccounts;
	Map locatedAccounts;
	
	public void fillTree(int parent, String codeCrit)
	{
		try
		{
			treeItems = new HashMap();
			tableTreeAccountingPlan.removeAll();
			
			
			HashBag mainBranches =(HashBag)EngTXCommon.doSelectTX(AccBLAccountAdd.class.getName(),"getAllAccountsWithSum",null) ;
			
			HashMap accountList=(HashMap)mainBranches.get(AccKeys.ACC_ACCOUNTS);
			accountTotals = new HashMap();
			allAccounts=new HashMap();
			locatedAccounts=new HashMap();
			
			for (int i = 0; i < accountList.size(); i++)
			{
				HashMap accountMap=(HashMap)accountList.get(new Integer(i));
				Integer accountId=(Integer)accountMap.get(AccKeys.ACC_ACCOUNT_ID);
				allAccounts.put(accountId,accountMap);
				locatedAccounts.put(accountId,new Boolean(false));
			}
			
			
			for (int i = 0; i < accountList.size(); i++)
			{
				HashMap accountMap=(HashMap)accountList.get(new Integer(i));
				Integer accountId=(Integer)accountMap.get(AccKeys.ACC_ACCOUNT_ID);
				Boolean located=(Boolean)locatedAccounts.get(accountId);
				if (!located.booleanValue())
				{
					LocateAccount(accountMap);
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public void LocateAccount(HashMap accountMap)throws Exception
	{
		TableTreeItem item;
		Integer accountId= (Integer)accountMap.get(AccKeys.ACC_ACCOUNT_ID);
		Integer parentId =(Integer) accountMap.get(AccKeys.ACC_PARENT_ID);
		BigDecimal totalDept =(BigDecimal)accountMap.get(AccKeys.ACC_TOTAL_DEPT_AMOUNT);
		if (totalDept==null)
			totalDept=new BigDecimal(0);
		
		BigDecimal totalCredit = (BigDecimal)accountMap.get(AccKeys.ACC_TOTAL_CREDIT_AMOUNT);
		if (totalCredit==null)
			totalCredit=new BigDecimal(0);
		
		BigDecimal[] totals = {totalCredit, totalDept};
		accountTotals.put(accountId, totals);
		if (parentId.intValue() == -1)
		{
			TableTreeItem[] parentItems = tableTreeAccountingPlan.getItems();
			String accCode =(String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE); 
			String accName=(String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME);
			int k;
			for (k = 0; k < parentItems.length; k++)
			{
				TableTreeItem pItem = parentItems[k];
				if (pItem.getText(0).equals(AccLangKeys.STR_ACCOUNT_PLAN_CAPITAL))
					continue;
				if (accCode.compareTo(pItem.getText(0)) < 0)
					break;
			}
			item = new TableTreeItem(tableTreeAccountingPlan, SWT.NULL, k);
			item.setText(0, accCode);
			item.setText(1, accName);
			item.setData(accountId);
			treeItems.put(accountId, item);
			locatedAccounts.put(accountId,new Boolean(true));
		}
		else
		{
			Boolean parentLocated=(Boolean)locatedAccounts.get(parentId);
			if (!parentLocated.booleanValue())
			{
				HashMap parentMap=(HashMap) allAccounts.get(parentId);
				LocateAccount(parentMap);
			}
			TableTreeItem parentItem = (TableTreeItem) treeItems.get(parentId);
			parentItem.setFont(SWTResourceManager.getFont("Tahoma", 9, 1, false, false)); //$NON-NLS-1$
			{
				//Register as a resource user - SWTResourceManager
				// will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(parentItem);
			}
			TableTreeItem[] parentItems = parentItem.getItems();
			String accCode =(String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE); 
			String accName=(String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME);
			int k;
			for (k = 0; k < parentItems.length; k++)
			{
				TableTreeItem pItem = parentItems[k];
				if (accCode.compareTo(pItem.getText(0)) < 0)
					break;
			}
			item = new TableTreeItem(parentItem, SWT.NULL, k);
			treeItems.put(accountId, item);
			locatedAccounts.put(accountId,new Boolean(true));
			item.setText(0, accCode);
			item.setText(1, accName);
			item.setData(accountId);
			while (parentId.intValue() != -1)
			{
				BigDecimal[] parentTotals = (BigDecimal[]) accountTotals.get(parentId);
				parentTotals[0] = parentTotals[0].add(totalCredit);
				parentTotals[1] = parentTotals[1].add(totalDept);
				HashMap parentMap=(HashMap)allAccounts.get(parentId);
				parentId =(Integer) parentMap.get(AccKeys.ACC_PARENT_ID);
			}
		}		
	}

	/** Auto-generated event handler method */
	protected void tableTreeAccountingPlanMouseDoubleClick(MouseEvent evt)throws Exception
	{
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		if (items.length > 0)
		{
			Integer accountId = (Integer) items[0].getData();
			// it's not an main account
			// main accounts cannot be edited
			// was, now can be edited
			//	if(account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId().intValue()!=-1)
			//	{
			HashMap accountMap=(HashMap) allAccounts.get(accountId);
			Integer parentId=(Integer)accountMap.get(AccKeys.ACC_PARENT_ID);
			boolean result = new AccUIAccountUpdate(this.getShell(), SWT.NULL,accountMap,(HashMap)allAccounts.get(parentId), (BigDecimal[]) accountTotals.get(accountId))
					.open();
			if (result)
			{
				fillTree(-1, ""); //$NON-NLS-1$
			}
			//	}
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableTreeAccountingPlan.getTable());
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableTreeAccountingPlan.getTable(), AccLangKeys.STR_ACCOUNTING_PLAN);
	}

	public void delete()
	{
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		if (items.length > 0)
		{
			Integer accountId = (Integer) items[0].getData();
		
			
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
			try
			{
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_ACCOUNT_ID,accountId);				
				List accTrans = (List) EngTXCommon.doSelectTX(AccBLAccountUpdate.class.getName(),"getAccountTransColumns",argMap);
				
				if (accTrans.size() > 0)
				{
					msg.setMessage(AccLangKeys.MSG_NOT_DELETE_ACCOUNT_WITH_TRANSACTION); 
					msg.open();
					return;
				}
								
				argMap = new HashMap();
		        argMap.put(AccKeys.ACC_PARENT_ID,accountId);	        
				List subAccs =(List)EngTXCommon.doSelectTX(AccBLAccountUpdate.class.getName(),"getSubAccounts",argMap);
				
				
				if (subAccs.size() > 0)
				{
					msg.setMessage(AccLangKeys.MSG_NOT_DELETE_ACCOUNT_WITH_SUBSIDIARY); 
					msg.open();
					return;
				}
				msg2.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); 
				int result = msg2.open();
				if (result == SWT.OK)
				{
					argMap = new HashMap();
					argMap.put(AccKeys.ACC_ACCOUNT_ID,accountId);
					EngTXCommon.doTransactionTX(AccBLAccountUpdate.class.getName(),"deleteAccount",argMap);
					EngBLAccountingAccounts.RefreshContentAsistantMap();
					msg.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); 
					msg.open();

					fillTree(-1, ""); //$NON-NLS-1$
				}
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}

	public void update()
	{
	}

	public void search()
	{
		fillTree(-1, ""); //$NON-NLS-1$
	}

	public void save()
	{
	}

	public void newForm()
	{
	}
}