package com.turquaz.engine.ui.component;

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
 * @author Huseyin Ergun
 * @version $Id$
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.Messages;
import com.turquaz.engine.ui.EngUIHelpDialog;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.engine.ui.EngUIPreferences;

public class MenuManager
{
	public static Menu createMainMenu(final Menu menuMain)
	{
		createFileMenu(menuMain);
		createEditMenu(menuMain);
		MenuItem mitAccounting = new MenuItem(menuMain, SWT.CASCADE);
		mitAccounting.setText(Messages.getString("MenuManager.2")); //$NON-NLS-1$
		mitAccounting = MenuFactory.createAccountingMenu(mitAccounting);
		MenuItem mitFinance = new MenuItem(menuMain, SWT.CASCADE);
		mitFinance.setText(Messages.getString("MenuManager.0")); //$NON-NLS-1$
		mitFinance = MenuFactory.createFinanceMenu(mitFinance);
		MenuItem mitSales = new MenuItem(menuMain, SWT.CASCADE);
		mitSales.setText(Messages.getString("MenuManager.4")); //$NON-NLS-1$
		mitSales = MenuFactory.createSalesMenu(mitSales);
		MenuItem mitInventory = new MenuItem(menuMain, SWT.CASCADE);
		mitInventory.setText(Messages.getString("MenuManager.5")); //$NON-NLS-1$
		mitInventory = MenuFactory.createInventoryMenu(mitInventory);
		MenuItem mitSettings = new MenuItem(menuMain, SWT.CASCADE);
		mitSettings.setText(Messages.getString("MenuManager.6")); //$NON-NLS-1$
		mitSettings = MenuFactory.createSettingsMenu(mitSettings);
		MenuItem mitHelp = new MenuItem(menuMain, SWT.CASCADE);
		mitHelp.setEnabled(true);
		mitHelp.setText(Messages.getString("EngUIMainFrame.22")); //$NON-NLS-1$
		Menu menuHelp = new Menu(mitHelp);
		mitHelp.setMenu(menuHelp);
		{
			MenuItem mitHelpContents = new MenuItem(menuHelp, SWT.PUSH);
			mitHelpContents.setText(Messages.getString("EngUIMainFrame.50")); //$NON-NLS-1$
			mitHelpContents.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					new EngUIHelpDialog(menuMain.getShell(), SWT.NULL).open();
				}
			});
		}
		return menuMain;
	}

	static void createFileMenu(final Menu menuMain)
	{
		MenuItem mitFile = new MenuItem(menuMain, SWT.CASCADE);
		mitFile.setText(Messages.getString("EngUIMainFrame.20")); //$NON-NLS-1$
		Menu menuFile = new Menu(mitFile);
		mitFile.setMenu(menuFile);
		{
			MenuItem mitExit = new MenuItem(menuFile, SWT.PUSH);
			mitExit.setText(Messages.getString("EngUIMainFrame.36")); //$NON-NLS-1$
			mitExit.setImage(SWTResourceManager.getImage("icons/Exit16.gif")); //$NON-NLS-1$
			mitExit.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					menuMain.getShell().close();
				}
			});
		}
	}

	static void createEditMenu(final Menu menuMain)
	{
		MenuItem mitEdit = new MenuItem(menuMain, SWT.CASCADE);
		mitEdit.setText(Messages.getString("EngUIMainFrame.21")); //$NON-NLS-1$
		Menu menuEdit = new Menu(mitEdit);
		mitEdit.setMenu(menuEdit);
		{
			MenuItem menuItemPreferences = new MenuItem(menuEdit, SWT.PUSH);
			menuItemPreferences.setText(Messages.getString("EngUIMainFrame.55")); //$NON-NLS-1$
			menuItemPreferences.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					new EngUIPreferences(menuMain.getShell(), SWT.NULL).open();
				}
			});
		}
		MenuItem mitView = new MenuItem(menuEdit, SWT.CASCADE);
		mitView.setText(Messages.getString("MenuManager.7"));  //$NON-NLS-1$
		{
			Menu menuView = new Menu(mitView);
			mitView.setMenu(menuView);
			{
				MenuItem mitModules = new MenuItem(menuView, SWT.PUSH);
				mitModules.setText(Messages.getString("EngUIMainFrame.2"));//$NON-NLS-1$
				mitModules.setImage(SWTResourceManager.getImage("icons/Process16.gif"));//$NON-NLS-1$
				mitModules.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compModulesTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compModulesTab);
							item.setText(Messages.getString("EngUIMainFrame.2"));//$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/Process16.gif")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				MenuItem mitFavorites = new MenuItem(menuView, SWT.PUSH);
				mitFavorites.setText(Messages.getString("EngUIMainFrame.5"));//$NON-NLS-1$
				mitFavorites.setImage(SWTResourceManager.getImage("icons/favorites.gif"));//$NON-NLS-1$
				mitFavorites.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compFavoritesTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compFavoritesTab);
							item.setText(Messages.getString("EngUIMainFrame.5"));//$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/favorites.gif")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				MenuItem mitHistory = new MenuItem(menuView, SWT.PUSH);
				mitHistory.setText(Messages.getString("EngUIMainFrame.16")); //$NON-NLS-1$
				mitHistory.setImage(SWTResourceManager.getImage("icons/history.png"));//$NON-NLS-1$
				mitHistory.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compHistoryTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compHistoryTab);
							item.setText(Messages.getString("EngUIMainFrame.16")); //$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/history.png")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				final MenuItem menuItemModulBar = new MenuItem(menuView, SWT.CHECK);
				menuItemModulBar.setText(Messages.getString("EngUIMainFrame.30")); //$NON-NLS-1$
				menuItemModulBar.setSelection(false);
				menuItemModulBar.setEnabled(false);
				menuItemModulBar.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (!menuItemModulBar.getSelection())
						{
							EngUIMainFrame.sashMainVertical.setMaximizedControl(EngUIMainFrame.sashMainHorizontal);
						}
						else
						{
							EngUIMainFrame.sashMainVertical.setMaximizedControl(null);
						}
					}
				});
			}
		}
		new MenuItem(menuEdit, SWT.SEPARATOR);
		MenuItem mitGoToRightTab = new MenuItem(menuEdit, SWT.PUSH);
		mitGoToRightTab.setText(Messages.getString("MenuManager.1")); //$NON-NLS-1$
		mitGoToRightTab.setAccelerator(SWT.CTRL | SWT.ARROW_RIGHT);
		SWTResourceManager.registerResourceUser(mitGoToRightTab);
		mitGoToRightTab.setImage(SWTResourceManager.getImage("/icons/forward.gif")); //$NON-NLS-1$
		mitGoToRightTab.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent evt)
			{
				if (EngUIMainFrame.tabfldMain.getItemCount() == 0)
				{
					return;
				}
				else if (EngUIMainFrame.tabfldMain.getItemCount() == EngUIMainFrame.tabfldMain.getSelectionIndex() + 1)
				{
					return;
				}
				else
				{
					EngUIMainFrame.tabfldMain.setSelection(EngUIMainFrame.tabfldMain.getSelectionIndex() + 1);
					EngUIMainFrame.arrangeIcons();
				}
			}
		});
		MenuItem mitGoToLeftTab = new MenuItem(menuEdit, SWT.PUSH);
		mitGoToLeftTab.setText(Messages.getString("MenuManager.3")); //$NON-NLS-1$
		mitGoToLeftTab.setAccelerator(SWT.CTRL | SWT.ARROW_LEFT);
		SWTResourceManager.registerResourceUser(mitGoToLeftTab);
		mitGoToLeftTab.setImage(SWTResourceManager.getImage("/icons/backward.gif")); //$NON-NLS-1$
		mitGoToLeftTab.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent evt)
			{
				if (EngUIMainFrame.tabfldMain.getItemCount() == 0)
				{
					return;
				}
				else if (EngUIMainFrame.tabfldMain.getSelectionIndex() == 0)
				{
					return;
				}
				else
				{
					EngUIMainFrame.tabfldMain.setSelection(EngUIMainFrame.tabfldMain.getSelectionIndex() - 1);
					EngUIMainFrame.arrangeIcons();
				}
			}
		});
	}
}