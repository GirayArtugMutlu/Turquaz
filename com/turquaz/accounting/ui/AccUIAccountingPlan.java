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
import org.apache.log4j.Logger;
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
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLAccountUpdate;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqViewAccTotal;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.SearchComposite;
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
			e.printStackTrace();
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
			item.setText(Messages.getString("AccUIAccountingPlan.2")); //$NON-NLS-1$
			item.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					delete();
				}
			});
			item = new MenuItem(popup, SWT.PUSH);
			item.setText(Messages.getString("AccUIAccountingPlan.3")); //$NON-NLS-1$
			item.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					try
					{
						TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
						if (items.length > 0)
						{
							new AccUIAddAccountDialog(getShell(), SWT.NULL).open((TurqAccountingAccount) items[0].getData());
							fillTree(-1, ""); //$NON-NLS-1$
						}
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			});
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
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
						ex.printStackTrace();
					}
				}
			});
			tableTreeAccountingPlan.getTable().setLinesVisible(true);
			tableTreeAccountingPlan.getTable().setHeaderVisible(true);
			tableTreeAccountingPlan.setMenu(popup);
			final TableColumn col = new TableColumn(tableTreeAccountingPlan.getTable(), SWT.LEFT);
			col.setText(Messages.getString("AccUIAccountingPlan.0")); //$NON-NLS-1$
			col.setWidth(200);
			final TableColumn col2 = new TableColumn(tableTreeAccountingPlan.getTable(), SWT.LEFT);
			col2.setText(Messages.getString("AccUIAccountingPlan.1")); //$NON-NLS-1$
			col2.setWidth(200);
			fillTree(-1, ""); //$NON-NLS-1$
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			ex.printStackTrace();
			loger.error(this, ex);
		}
	}

	/**
	 * @param parent
	 *            Parent Account
	 * @param codeCrit
	 */
	public void fillTree(int parent, String codeCrit)
	{
		try
		{
			Map treeItems = new HashMap();
			tableTreeAccountingPlan.removeAll();
			TableTreeItem item;
			
			List mainBranches =(List)EngTXCommon.doSingleTX(AccBLAccountAdd.class.getName(),"getAllAccountsWithSum",null) ;
			TurqAccountingAccount account;
			TurqViewAccTotal accView;
			Integer parentId;
			accountTotals = new HashMap();
			for (int i = 0; i < mainBranches.size(); i++)
			{
				account = (TurqAccountingAccount) ((Object[]) mainBranches.get(i))[0];
				accView = (TurqViewAccTotal) ((Object[]) mainBranches.get(i))[1];
				parentId = account.getTurqAccountingAccountByParentAccount().getId();
				BigDecimal totalDept = (accView.getTotaldeptamount() == null) ? new BigDecimal(0) : accView.getTotaldeptamount();
				BigDecimal totalCredit = (accView.getTotalcreditamount() == null) ? new BigDecimal(0) : accView.getTotalcreditamount();
				BigDecimal[] totals = {totalCredit, totalDept};
				accountTotals.put(new Integer(accView.getAccountingAccountsId()), totals);
				if (parentId.intValue() == -1)
				{
					TableTreeItem[] parentItems = tableTreeAccountingPlan.getItems();
					String accId = account.getAccountCode();
					int k;
					for (k = 0; k < parentItems.length; k++)
					{
						TableTreeItem pItem = parentItems[k];
						if (pItem.getText(0).equals("HESAP PLANI")) //$NON-NLS-1$
							continue;
						if (accId.compareTo(pItem.getText(0)) < 0)
							break;
					}
					item = new TableTreeItem(tableTreeAccountingPlan, SWT.NULL, k);
					item.setText(0, account.getAccountCode());
					item.setText(1, account.getAccountName());
					item.setData(account);
					treeItems.put(account.getId(), item);
				}
				else
				{
					TableTreeItem parentItem = (TableTreeItem) treeItems.get(parentId);
					parentItem.setFont(SWTResourceManager.getFont("Tahoma", 9, 1, false, false)); //$NON-NLS-1$
					{
						//Register as a resource user - SWTResourceManager
						// will
						//handle the obtaining and disposing of resources
						SWTResourceManager.registerResourceUser(parentItem);
					}
					TableTreeItem[] parentItems = parentItem.getItems();
					String accId = account.getAccountCode();
					int k;
					for (k = 0; k < parentItems.length; k++)
					{
						TableTreeItem pItem = parentItems[k];
						if (accId.compareTo(pItem.getText(0)) < 0)
							break;
					}
					item = new TableTreeItem(parentItem, SWT.NULL, k);
					treeItems.put(account.getId(), item);
					item.setText(0, account.getAccountCode());
					item.setText(1, account.getAccountName());
					item.setData(account);
					while (parentId.intValue() != -1)
					{
						BigDecimal[] parentTotals = (BigDecimal[]) accountTotals.get(parentId);
						parentTotals[0] = parentTotals[0].add(totalCredit);
						parentTotals[1] = parentTotals[1].add(totalDept);
						account = account.getTurqAccountingAccountByParentAccount();
						parentId = account.getTurqAccountingAccountByParentAccount().getId();
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * @param parentItem
	 * @param parent_id
	 * @param codeCriteria
	 *            Account code criteria for branches
	 */
	public void fillBranch(TableTreeItem parentItem, int parent_id, String codeCriteria)
	{
		try
		{
			TableTreeItem item;
			Object args[] = new Object[2];
			args[0]=new Integer(parent_id);
			args[1]=codeCriteria;
			List mainBranches = AccBLAccountAdd.getAccount((Integer)args[0],codeCriteria);
			
			TurqAccountingAccount account;
			for (int i = 0; i < mainBranches.size(); i++)
			{
				account = (TurqAccountingAccount) mainBranches.get(i);
				item = new TableTreeItem(parentItem, SWT.NULL);
				item.setText(0, account.getAccountCode());
				item.setText(1, account.getAccountName());
				item.setData(account);
				fillBranch(item, account.getId().intValue(), ""); //$NON-NLS-1$
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void tableTreeAccountingPlanMouseDoubleClick(MouseEvent evt)throws Exception
	{
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		if (items.length > 0)
		{
			TurqAccountingAccount account = (TurqAccountingAccount) items[0].getData();
			// it's not an main account
			// main accounts cannot be edited
			// was, now can be edited
			//	if(account.getTurqAccountingAccountByParentAccount().getAccountingAccountsId().intValue()!=-1)
			//	{
			boolean result = new AccUIAccountUpdate(this.getShell(), SWT.NULL, account, (BigDecimal[]) accountTotals.get(account.getId()))
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
		EngBLUtils.printTable(tableTreeAccountingPlan.getTable(), Messages.getString("AccUIAccountingPlan.4")); //$NON-NLS-1$
	}

	public void delete()
	{
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		if (items.length > 0)
		{
			TurqAccountingAccount account = (TurqAccountingAccount) items[0].getData();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
			try
			{
				List accTrans = AccBLAccountUpdate.getAccountTransColumns(account);
				if (accTrans.size() > 0)
				{
					msg.setMessage(Messages.getString("AccUIAccountingPlan.6")); //$NON-NLS-1$
					msg.open();
					return;
				}
				List subAccs = AccBLAccountUpdate.getSubAccounts(account);
				if (subAccs.size() > 0)
				{
					msg.setMessage(Messages.getString("AccUIAccountingPlan.5")); //$NON-NLS-1$
					msg.open();
					return;
				}
				msg2.setMessage(Messages.getString("AccUIAccountUpdate.15")); //$NON-NLS-1$
				int result = msg2.open();
				if (result == SWT.OK)
				{
					AccBLAccountUpdate.deleteAccount(account);
					msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
					msg.open();
					EngTXCommon.doSingleTX(EngBLAccountingAccounts.class.getName(),"RefreshContentAsistantMap",null);

					fillTree(-1, ""); //$NON-NLS-1$
				}
			}
			catch (Exception ex)
			{
				MessageBox msg3 = new MessageBox(this.getShell(), SWT.NULL);
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
				msg3.setMessage(ex.getMessage());
				msg3.open();
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