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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLKeyEvents;
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
	
	public static MenuItem mitNew;
	public static MenuItem mitSave;
	public static MenuItem mitDelete;
	public static MenuItem mitSearch;
	public static MenuItem mitExcel;
	public static MenuItem mitPrint;

	public static void createFileMenu(final Menu menuMain)
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
			
			mitNew = new MenuItem(menuFile, SWT.PUSH);
			TurqKeyEvent newEvent=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.NEW);
			mitNew.setText(Messages.getString("MenuManager.1")+((newEvent.isActive) ? EngBLKeyEvents.getStringValue(newEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
			mitSave.setText(Messages.getString("MenuManager.9")+((saveEvent.isActive) ? EngBLKeyEvents.getStringValue(saveEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
			mitDelete.setText(Messages.getString("MenuManager.11")+((deleteEvent.isActive) ? EngBLKeyEvents.getStringValue(deleteEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
			mitSearch.setText(Messages.getString("MenuManager.13")+((searchEvent.isActive) ? EngBLKeyEvents.getStringValue(searchEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
			mitExcel.setText(Messages.getString("MenuManager.15")+((excelEvent.isActive) ? EngBLKeyEvents.getStringValue(excelEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
			mitPrint.setText(Messages.getString("MenuManager.17")+ ((printEvent.isActive) ? EngBLKeyEvents.getStringValue(printEvent):""));  //$NON-NLS-1$ //$NON-NLS-2$
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
		mitView.setText(Messages.getString("MenuManager.7")); //$NON-NLS-1$
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
		MenuItem shortcuts = new MenuItem(menuEdit, SWT.PUSH);
		shortcuts.setText(Messages.getString("MenuManager.8")); //$NON-NLS-1$
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
		mitGoToRightTab.setText(Messages.getString("MenuManager.19")+((nextTabEvent.isActive) ? EngBLKeyEvents.getStringValue(nextTabEvent):"")); //$NON-NLS-1$ //$NON-NLS-2$
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
		mitGoToLeftTab.setText(Messages.getString("MenuManager.21")+((previousTabEvent.isActive) ? EngBLKeyEvents.getStringValue(previousTabEvent):"")); //$NON-NLS-1$ //$NON-NLS-2$
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