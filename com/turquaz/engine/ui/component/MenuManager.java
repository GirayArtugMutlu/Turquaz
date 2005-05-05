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

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLKeyEvents;
import com.turquaz.engine.bl.EngBLMenu;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqEngineMenu;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUIHelpDialog;
import com.turquaz.engine.ui.EngUIKeyControls;
import com.turquaz.engine.ui.EngUIMainFrame;
import com.turquaz.engine.ui.EngUIPreferences;

public class MenuManager 
{
	
	
	public static Menu createMainMenu(final Menu menuMain)
	{
		createFileMenu(menuMain);
		createEditMenu(menuMain);
		
		MenuItem mitAccounting = new MenuItem(menuMain, SWT.CASCADE);
		mitAccounting.setText(EngLangCommonKeys.MENU_ACCOUNTING); //$NON-NLS-1$
		mitAccounting = MenuFactory.createAccountingMenu(mitAccounting);
		MenuItem mitFinance = new MenuItem(menuMain, SWT.CASCADE);
		mitFinance.setText(EngLangCommonKeys.MENU_FINANCE); //$NON-NLS-1$
		mitFinance = MenuFactory.createFinanceMenu(mitFinance);
		MenuItem mitSales = new MenuItem(menuMain, SWT.CASCADE);
		mitSales.setText(EngLangCommonKeys.MENU_SALES); //$NON-NLS-1$
		mitSales = MenuFactory.createSalesMenu(mitSales);
		MenuItem mitInventory = new MenuItem(menuMain, SWT.CASCADE);
		mitInventory.setText(EngLangCommonKeys.MENU_INVENTORY); //$NON-NLS-1$
		mitInventory = MenuFactory.createInventoryMenu(mitInventory);
		MenuItem mitSettings = new MenuItem(menuMain, SWT.CASCADE);
		mitSettings.setText(EngLangCommonKeys.MENU_SETTINGS); //$NON-NLS-1$
		mitSettings = MenuFactory.createSettingsMenu(mitSettings);
		MenuItem mitHelp = new MenuItem(menuMain, SWT.CASCADE);
		mitHelp.setEnabled(true);
		mitHelp.setText(EngLangCommonKeys.MENU_HELP); //$NON-NLS-1$
		Menu menuHelp = new Menu(mitHelp);
		mitHelp.setMenu(menuHelp);
		{
			MenuItem mitHelpContents = new MenuItem(menuHelp, SWT.PUSH);
			mitHelpContents.setText(EngLangCommonKeys.MENU_ABOUT); //$NON-NLS-1$
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
	
	public static MenuItem mitNew;
	public static MenuItem mitSave;
	public static MenuItem mitDelete;
	public static MenuItem mitSearch;
	public static MenuItem mitExcel;
	public static MenuItem mitPrint;

	public static void createFileMenu(final Menu menuMain)
	{
		MenuItem mitFile = new MenuItem(menuMain, SWT.CASCADE);
		mitFile.setText(EngLangCommonKeys.MENU_FILE); //$NON-NLS-1$
		Menu menuFile = new Menu(mitFile);
		mitFile.setMenu(menuFile);
		{
			MenuItem mitExit = new MenuItem(menuFile, SWT.PUSH);
			mitExit.setText(EngLangCommonKeys.MENU_EXIT); //$NON-NLS-1$
			mitExit.setImage(SWTResourceManager.getImage("icons/Exit16.gif")); //$NON-NLS-1$
			mitExit.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					menuMain.getShell().close();
				}
			});
			
			mitNew = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent newEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.NEW);
			mitNew.setText(EngLangCommonKeys.STR_NEW+((newEvent.isActive) ? EngBLKeyEvents.getStringValue(newEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitNew.setAccelerator(newEvent.stateMask | newEvent.keyCode);
			mitNew.setImage(SWTResourceManager.getImage("icons/new_wiz.gif")); //$NON-NLS-1$
			mitNew.setData(newEvent);
			if (newEvent.isAvailable)
			{
				mitNew.setEnabled(true);
			}
			else
			{
				mitNew.setEnabled(false);
			}
			mitNew.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					Composite c = (Composite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					if (c instanceof SecureComposite)
					{
						((SecureComposite) c).newForm();
					}
				}
			});
			
			mitSave = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent saveEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.SAVE);
			mitSave.setText(EngLangCommonKeys.STR_SAVE+((saveEvent.isActive) ? EngBLKeyEvents.getStringValue(saveEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitSave.setAccelerator(saveEvent.stateMask | saveEvent.keyCode);
			mitSave.setImage(SWTResourceManager.getImage("icons/save.jpg")); //$NON-NLS-1$
			mitSave.setData(saveEvent);
			if (saveEvent.isAvailable)
			{
				mitSave.setEnabled(true);
			}
			else
			{
				mitSave.setEnabled(false);
			}
			mitSave.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					Composite c = (Composite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					if (c instanceof SecureComposite)
					{
						((SecureComposite) c).save();
					}
				}
			});
			
			
			mitDelete = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent deleteEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.DELETE);
			mitDelete.setText(EngLangCommonKeys.STR_DELETE+((deleteEvent.isActive) ? EngBLKeyEvents.getStringValue(deleteEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitDelete.setAccelerator(deleteEvent.stateMask | deleteEvent.keyCode);
			mitDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
			mitDelete.setData(deleteEvent);
			if (deleteEvent.isAvailable)
			{
				mitDelete.setEnabled(true);
			}
			else
			{
				mitDelete.setEnabled(false);
			}
			mitDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					Composite c = (Composite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					if (c instanceof SearchComposite)
					{
						((SearchComposite) c).delete();
					}
				}
			});
			
			mitSearch = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent searchEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.SEARCH);
			mitSearch.setText(EngLangCommonKeys.STR_SEARCH+((searchEvent.isActive) ? EngBLKeyEvents.getStringValue(searchEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitSearch.setAccelerator(searchEvent.stateMask | searchEvent.keyCode);
			mitSearch.setImage(SWTResourceManager.getImage("icons/search.jpg")); //$NON-NLS-1$
			mitSearch.setData(searchEvent);
			if (searchEvent.isAvailable)
			{
				mitSearch.setEnabled(true);
			}
			else
			{
				mitSearch.setEnabled(false);
			}
			mitSearch.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					Composite c = (Composite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					if (c instanceof SearchComposite)
					{
						((SearchComposite) c).search();
					}
				}
			});
			
			
			mitExcel = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent excelEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.EXCEL);
			mitExcel.setText(EngLangCommonKeys.STR_EXPORT_TO_EXCEL+((excelEvent.isActive) ? EngBLKeyEvents.getStringValue(excelEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitExcel.setAccelerator(excelEvent.stateMask | excelEvent.keyCode);
			mitExcel.setImage(SWTResourceManager.getImage("icons/excel.jpeg")); //$NON-NLS-1$
			mitExcel.setData(excelEvent);
			if (excelEvent.isAvailable)
			{
				mitExcel.setEnabled(true);
			}
			else
			{
				mitExcel.setEnabled(false);
			}
			mitExcel.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					SearchComposite sc = (SearchComposite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					sc.exportToExcel();
				}
			});
			
			
			mitPrint = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent printEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.PRINT);
			mitPrint.setText(EngLangCommonKeys.STR_PRINT+ ((printEvent.isActive) ? EngBLKeyEvents.getStringValue(printEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
			mitPrint.setAccelerator(printEvent.stateMask | printEvent.keyCode);
			mitPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
			mitPrint.setData(printEvent);
			if (printEvent.isAvailable)
			{
				mitPrint.setEnabled(true);
			}
			else
			{
				mitPrint.setEnabled(false);
			}
			mitPrint.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					SearchComposite sc = (SearchComposite) EngUIMainFrame.tabfldMain.getSelection().getControl();
					sc.printTable();
				}
			});
		}		
	}
	
	static void createAllMenu (final Menu menuMain)
	{
		try{

		List list = (List)EngTXCommon.doTransactionTX(EngBLMenu.class.getName(),"getAllMenu",null);
		
		MenuItem mitData = new MenuItem(menuMain, SWT.CASCADE);
		
		Menu menuData = new Menu(mitData);
		mitData.setMenu(menuData);
		MenuItem mit ;
		MenuItem sps;
		// sps = new MenuItem(menuAcc, SWT.SEPARATOR);
		
		
		TurqEngineMenu engMenu = new TurqEngineMenu();
		
		for (int i = 0; i < list.size(); i ++)
		{
			engMenu = (TurqEngineMenu)list.get(i);
			if (engMenu.getMenuType() == 0)
			{
				mitData.setText(engMenu.getMenuName());
			}
			else if (engMenu.getMenuType() == 2)
			{
				sps = new MenuItem(menuData, SWT.SEPARATOR);
			}
			else if (engMenu.getMenuType() == 3 && EngBLPermissions.getPermission(engMenu.getTurqModuleComponent().getComponentsName())>0)
			{
				mit = new MenuItem(menuData, SWT.PUSH);
				mit.setText(engMenu.getMenuName()); 
				mit.setData(engMenu.getTurqModuleComponent().getComponentsName());
				mit.addSelectionListener(new MenuSelectionAdapter());
			}
			
			
		}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	static void createEditMenu(final Menu menuMain)
	{
		MenuItem mitEdit = new MenuItem(menuMain, SWT.CASCADE);
		mitEdit.setText(EngLangCommonKeys.MENU_EDIT); //$NON-NLS-1$
		Menu menuEdit = new Menu(mitEdit);
		mitEdit.setMenu(menuEdit);
		{
			MenuItem menuItemPreferences = new MenuItem(menuEdit, SWT.PUSH);
			menuItemPreferences.setText(EngLangCommonKeys.MENU_PREFERENCES); //$NON-NLS-1$
			menuItemPreferences.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					new EngUIPreferences(menuMain.getShell(), SWT.NULL).open();
				}
			});
		}
		MenuItem mitView = new MenuItem(menuEdit, SWT.CASCADE);
		mitView.setText(EngLangCommonKeys.MENU_VIEW); //$NON-NLS-1$
		{
			Menu menuView = new Menu(mitView);
			mitView.setMenu(menuView);
			{
				MenuItem mitModules = new MenuItem(menuView, SWT.PUSH);
				mitModules.setText(EngLangCommonKeys.MENU_MODULES);//$NON-NLS-1$
				mitModules.setImage(SWTResourceManager.getImage("icons/Process16.gif"));//$NON-NLS-1$
				mitModules.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compModulesTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compModulesTab);
							item.setText(EngLangCommonKeys.STR_MODULES);//$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/Process16.gif")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				MenuItem mitFavorites = new MenuItem(menuView, SWT.PUSH);
				mitFavorites.setText(EngLangCommonKeys.STR_FAVORITES);//$NON-NLS-1$
				mitFavorites.setImage(SWTResourceManager.getImage("icons/favorites.gif"));//$NON-NLS-1$
				mitFavorites.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compFavoritesTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compFavoritesTab);
							item.setText(EngLangCommonKeys.STR_FAVORITES);//$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/favorites.gif")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				MenuItem mitHistory = new MenuItem(menuView, SWT.PUSH);
				mitHistory.setText(EngLangCommonKeys.STR_HISTORY); //$NON-NLS-1$
				mitHistory.setImage(SWTResourceManager.getImage("icons/history.png"));//$NON-NLS-1$
				mitHistory.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (EngUIMainFrame.checkTabMenu(EngUIMainFrame.compHistoryTab) == -1)
						{
							CTabItem item = new CTabItem(EngUIMainFrame.tabfldMenu, SWT.NULL);
							item.setControl(EngUIMainFrame.compHistoryTab);
							item.setText(EngLangCommonKeys.STR_HISTORY); //$NON-NLS-1$
							item.setImage(SWTResourceManager.getImage("icons/history.png")); //$NON-NLS-1$
							EngUIMainFrame.tabfldMenu.setSelection(item);
							EngUIMainFrame.sashMainHorizontal.setMaximizedControl(null);
						}
					}
				});
			}
			{
				final MenuItem menuItemModulBar = new MenuItem(menuView, SWT.CHECK);
				menuItemModulBar.setText(EngLangCommonKeys.STR_MODULES); //$NON-NLS-1$
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
		MenuItem shortcuts = new MenuItem(menuEdit, SWT.PUSH);
		shortcuts.setText(EngLangCommonKeys.MENU_SHORTCUTS); //$NON-NLS-1$
		SWTResourceManager.registerResourceUser(shortcuts);
		shortcuts.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent evt)
			{
				new EngUIKeyControls(menuMain.getShell(),SWT.NULL).open();
			}
		});

		
		
		
		new MenuItem(menuEdit, SWT.SEPARATOR);
		MenuItem mitGoToRightTab = new MenuItem(menuEdit, SWT.PUSH);
		
		TurqKeyEvent nextTabEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.NEXT_TAB);
		mitGoToRightTab.setText(EngLangCommonKeys.STR_NEXT_TAB+((nextTabEvent.isActive) ? EngBLKeyEvents.getStringValue(nextTabEvent):"")); //$NON-NLS-1$ //$NON-NLS-2$
		mitGoToRightTab.setAccelerator(nextTabEvent.stateMask | nextTabEvent.keyCode);
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
		TurqKeyEvent previousTabEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.PREVIOUS_TAB);
		mitGoToLeftTab.setText(EngLangCommonKeys.STR_PREVIOUS_TAB+((previousTabEvent.isActive) ? EngBLKeyEvents.getStringValue(previousTabEvent):"")); //$NON-NLS-1$ //$NON-NLS-2$
		mitGoToLeftTab.setAccelerator(previousTabEvent.stateMask | previousTabEvent.keyCode);
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