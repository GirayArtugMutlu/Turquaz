package com.turquaz.engine.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the 
 * terms of the GNU General Public License as published by */
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder2Adapter;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import com.turquaz.admin.bl.AdmBLCompanyInfo;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.LiveSashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.FillLayout;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.EngModulePrefs;
import com.turquaz.engine.backup.EngBackUp;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLKeyEvents;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLXmlParser;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.ui.component.MenuFactory;
import com.turquaz.engine.ui.component.MenuManager;
import com.turquaz.engine.ui.component.TreeFactory;
import com.turquaz.engine.ui.component.TurqKeyEvent;
import com.turquaz.engine.ui.component.rssowl.BrowserPanel;
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class EngUIMainFrame extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Tree treeCurrent;
	private Label label1;
	private Composite compModulesHelp;
	private Tree treeBank;
	private Tree treeAccounting;
	public static CTabFolder tabfldMain;
	private static ToolItem toolSearch;
	private static ToolItem toolDelete;
	private static ToolItem toolSave;
	private static ToolItem toolNew;
	private ToolBar toolbarMainTop;
	private Composite compMainInRight;
	private static Tree treeFavorites;
	private CLabel lblFavoritesTab;
	private ToolItem toolBrowser;
	private CLabel lblActiveModul;
	private Label label2;
	private Button btnCheque;
	private Tree treeCheques;
	private Tree treeCash;
	private Button btnCash;
	private Composite compFavoritesSelection;
	public static Composite compFavoritesTab;
	private CTabItem tabFavorites;
	private Tree treeAdmin;
	private Tree treeInventory;
	private Composite compModulesTree;
	private Button btnAdmin;
	private Button btnAccounting;
	private Button btnBank;
	private Button btnBill;
	private Button btnConsignment;
	private Button btnCurrent;
	private Button btnInventory;
	private static ToolItem toolPrint;
	private static Tree treeHistory;
	private CLabel lblHistory;
	public static Composite compHistoryTab;
	private CTabItem tabHistory;
	private Tree treeBill;
	private static ToolItem toolExportToExcel;
	private Tree treeConsignment;
	public static Composite compModulesTab;
	private CTabItem tabModules;
	public static CTabFolder tabfldMenu;
	public static LiveSashForm sashMainHorizontal;
	public static SashForm sashMainVertical;
	private Composite compMainIn;
	private Composite compMain;
	public static Menu menuMain;
	Menu popupTreeAddFavorites;
	Menu popupTreeRemoveFavorites;
	static Map mapList = new HashMap();
	public static Display display;
	public static Shell shell;

	public EngUIMainFrame(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
		display = this.getDisplay();
		shell = this.getShell();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			{
				label2 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
				label2.setText("label2"); //$NON-NLS-1$
				GridData label2LData = new GridData();
				label2LData.grabExcessHorizontalSpace = true;
				label2LData.horizontalAlignment = GridData.FILL;
				label2.setLayoutData(label2LData);
			}
			compMain = new Composite(this, SWT.NULL);
			compMainIn = new Composite(compMain, SWT.NULL);
			sashMainVertical = new SashForm(compMainIn, SWT.NULL);
			sashMainHorizontal = new LiveSashForm(sashMainVertical, SWT.SMOOTH);
			tabfldMenu = new CTabFolder(sashMainHorizontal, SWT.TOP | SWT.BORDER | SWT.CLOSE);
			tabModules = new CTabItem(tabfldMenu, SWT.NULL);
			compModulesTab = new Composite(tabfldMenu, SWT.NULL);
			{
				lblActiveModul = new CLabel(compModulesTab, SWT.NONE);
				GridData lblActiveModulLData = new GridData();
				lblActiveModul.setFont(SWTResourceManager.getFont("Tahoma", 12, 1, false, false)); //$NON-NLS-1$
				lblActiveModul.setForeground(SWTResourceManager.getColor(255, 255, 255));
				lblActiveModul.setBackground(SWTResourceManager.getColor(128, 128, 128));
				lblActiveModulLData.grabExcessHorizontalSpace = true;
				lblActiveModulLData.horizontalAlignment = GridData.FILL;
				lblActiveModulLData.heightHint = 26;
				lblActiveModulLData.horizontalIndent = 10;
				lblActiveModul.setLayoutData(lblActiveModulLData);
			}
			compModulesTree = new Composite(compModulesTab, SWT.NULL);
			treeBank = new Tree(compModulesTree, SWT.NULL);
			treeInventory = new Tree(compModulesTree, SWT.NULL);
			treeAccounting = new Tree(compModulesTree, SWT.NULL);
			treeAdmin = new Tree(compModulesTree, SWT.NULL);
			treeCurrent = new Tree(compModulesTree, SWT.NULL);
			treeCurrent.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
			{
				treeConsignment = new Tree(compModulesTree, SWT.NONE);
				treeConsignment.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
				treeConsignment.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						treeConsignmentMouseDoubleClick();
					}
				});
			}
			{
				treeBill = new Tree(compModulesTree, SWT.NONE);
				treeBill.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
				treeBill.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						treeBillMouseDoubleClick();
					}
				});
			}
			{
				treeCash = new Tree(compModulesTree, SWT.NONE);
				treeCash.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
				treeCash.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						treeCashMouseDoubleClick();
					}
				});
			}
			{
				treeCheques = new Tree(compModulesTree, SWT.NONE);
				treeCheques.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
				treeCheques.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						treeChequeMouseDoubleClick();
					}
				});
			}
			label1 = new Label(compModulesTab, SWT.SEPARATOR | SWT.HORIZONTAL);
			compModulesHelp = new Composite(compModulesTab, SWT.NULL);
			tabFavorites = new CTabItem(tabfldMenu, SWT.NULL);
			compFavoritesTab = new Composite(tabfldMenu, SWT.NULL);
			compFavoritesSelection = new Composite(compFavoritesTab, SWT.NULL);
			lblFavoritesTab = new CLabel(compFavoritesSelection, SWT.NULL);
			treeFavorites = new Tree(compFavoritesTab, SWT.NULL);
			compMainInRight = new Composite(sashMainHorizontal, SWT.NULL);
			this.setSize(797, 582);
			GridData compMainLData = new GridData();
			compMainLData.verticalAlignment = GridData.FILL;
			compMainLData.horizontalAlignment = GridData.FILL;
			compMainLData.widthHint = -1;
			compMainLData.heightHint = -1;
			compMainLData.horizontalIndent = 0;
			compMainLData.horizontalSpan = 1;
			compMainLData.verticalSpan = 1;
			compMainLData.grabExcessHorizontalSpace = false;
			compMainLData.grabExcessVerticalSpace = true;
			compMain.setLayoutData(compMainLData);
			compMain.setSize(new org.eclipse.swt.graphics.Point(800, 578));
			GridData compMainInLData = new GridData();
			compMainInLData.verticalAlignment = GridData.FILL;
			compMainInLData.horizontalAlignment = GridData.FILL;
			compMainInLData.widthHint = -1;
			compMainInLData.heightHint = -1;
			compMainInLData.horizontalIndent = 0;
			compMainInLData.horizontalSpan = 1;
			compMainInLData.verticalSpan = 1;
			compMainInLData.grabExcessHorizontalSpace = true;
			compMainInLData.grabExcessVerticalSpace = true;
			compMainIn.setLayoutData(compMainInLData);
			GridData sashMainVerticalLData = new GridData();
			sashMainVerticalLData.verticalAlignment = GridData.FILL;
			sashMainVerticalLData.horizontalAlignment = GridData.FILL;
			sashMainVerticalLData.grabExcessHorizontalSpace = true;
			sashMainVerticalLData.grabExcessVerticalSpace = true;
			sashMainVertical.setLayoutData(sashMainVerticalLData);
			sashMainVertical.setOrientation(SWT.VERTICAL);
			sashMainHorizontal.setSize(new org.eclipse.swt.graphics.Point(792, 572));
			sashMainHorizontal.setBounds(new org.eclipse.swt.graphics.Rectangle(0, 0, 792, 572));
			tabfldMenu.setBounds(0, 0, 354, 564);
			tabModules.setControl(compModulesTab);
			tabModules.setText(EngLangCommonKeys.STR_MODULES); //$NON-NLS-1$
			tabModules.setImage(SWTResourceManager.getImage("icons/Process16.gif")); //$NON-NLS-1$
			GridData compModulesTreeLData = new GridData();
			compModulesTreeLData.verticalAlignment = GridData.FILL;
			compModulesTreeLData.horizontalAlignment = GridData.FILL;
			compModulesTreeLData.grabExcessVerticalSpace = true;
			compModulesTree.setLayoutData(compModulesTreeLData);
			treeBank.setSize(new org.eclipse.swt.graphics.Point(370, 251));
			treeBank.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
			treeBank.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeBankMouseDoubleClick();
				}
			});
			treeInventory.setSize(new org.eclipse.swt.graphics.Point(370, 251));
			treeInventory.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
			treeInventory.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeInventoryMouseDoubleClick();
				}
			});
			treeAccounting.setSize(new org.eclipse.swt.graphics.Point(370, 251));
			treeAccounting.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
			treeAccounting.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeAccountingMouseDoubleClick();
				}
			});
			treeAdmin.setSize(new org.eclipse.swt.graphics.Point(370, 251));
			treeAdmin.setFont(SWTResourceManager.getFont("Verdana", 9, 0, false, false)); //$NON-NLS-1$
			treeAdmin.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeAdminMouseDoubleClick();
				}
			});
			treeCurrent.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeCurrentMouseDoubleClick();
				}
			});
			final StackLayout compModulesTreeLayout = new StackLayout();
			compModulesTree.setBackground(SWTResourceManager.getColor(255, 255, 255));
			compModulesTree.setLayout(compModulesTreeLayout);
			compModulesTreeLayout.marginWidth = 0;
			compModulesTreeLayout.marginHeight = 0;
			compModulesTreeLayout.topControl = null;
			compModulesTree.layout();
			GridData label1LData = new GridData();
			label1LData.horizontalAlignment = GridData.FILL;
			label1LData.heightHint = 3;
			label1.setLayoutData(label1LData);
			label1.setText("label1"); //$NON-NLS-1$
			GridData compModulesHelpLData = new GridData();
			compModulesHelpLData.verticalAlignment = GridData.FILL;
			compModulesHelpLData.horizontalAlignment = GridData.FILL;
			compModulesHelpLData.widthHint = -1;
			compModulesHelpLData.heightHint = -1;
			compModulesHelpLData.horizontalIndent = 0;
			compModulesHelpLData.horizontalSpan = 1;
			compModulesHelpLData.verticalSpan = 1;
			compModulesHelpLData.grabExcessHorizontalSpace = false;
			compModulesHelpLData.grabExcessVerticalSpace = false;
			compModulesHelp.setLayoutData(compModulesHelpLData);
			compModulesHelp.setSize(new org.eclipse.swt.graphics.Point(386, 235));
			FillLayout compModulesHelpLayout = new FillLayout(org.eclipse.swt.SWT.VERTICAL);
			compModulesHelpLayout.type = SWT.VERTICAL;
			compModulesHelp.setLayout(compModulesHelpLayout);
			{
				btnInventory = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnInventory.setText(EngLangCommonKeys.STR_MODULE_INVENTORY); //$NON-NLS-1$
				btnInventory.setSize(379, 21);
				btnInventory.setBackground(SWTResourceManager.getColor(255, 255, 255));
				btnInventory.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeInventory;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_INVENTORY); //$NON-NLS-1$
					}
				});
				btnInventory.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnCurrent = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnCurrent.setText(EngLangCommonKeys.STR_MODULE_CURRENT); //$NON-NLS-1$
				btnCurrent.setSize(379, 21);
				btnCurrent.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeCurrent;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_CURRENT); //$NON-NLS-1$
					}
				});
				btnCurrent.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnConsignment = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnConsignment.setText(EngLangCommonKeys.STR_MODULE_CONSIGNMENT); //$NON-NLS-1$
				btnConsignment.setSize(379, 21);
				btnConsignment.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeConsignment;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_CONSIGNMENT); //$NON-NLS-1$
					}
				});
				btnConsignment.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnBill = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnBill.setText(EngLangCommonKeys.STR_MODULE_BILL); //$NON-NLS-1$
				btnBill.setSize(379, 21);
				btnBill.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeBill;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_BILL); //$NON-NLS-1$
					}
				});
				btnBill.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnCheque = new Button(compModulesHelp, SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnCheque.setText(EngLangCommonKeys.STR_MODULE_CHEQUE); //$NON-NLS-1$
				btnCheque.setSize(379, 21);
				btnCheque.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeCheques;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_CHEQUE); //$NON-NLS-1$
					}
				});
				btnCheque.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnBank = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnBank.setText(EngLangCommonKeys.STR_MODULE_BANK); //$NON-NLS-1$
				btnBank.setSize(379, 21);
				btnBank.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeBank;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_BANK); //$NON-NLS-1$
					}
				});
				btnBank.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnCash = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnCash.setText(EngLangCommonKeys.STR_MODULE_CASH); //$NON-NLS-1$
				btnCash.setSize(379, 21);
				btnCash.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeCash;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_CASH); //$NON-NLS-1$
					}
				});
				btnCash.setFont(SWTResourceManager.getFont("Tahoma", //$NON-NLS-1$
						10, 1, false, false));
			}
			{
				btnAccounting = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT | SWT.LEFT | SWT.BORDER);
				btnAccounting.setText(EngLangCommonKeys.STR_MODULE_ACCOUNTING); //$NON-NLS-1$
				btnAccounting.setSize(379, 21);
				btnAccounting.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeAccounting;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_ACCOUNTING); //$NON-NLS-1$
					}
				});
				btnAccounting.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			{
				btnAdmin = new Button(compModulesHelp, SWT.PUSH | SWT.FLAT|SWT.LEFT|SWT.BORDER);
				btnAdmin.setText(EngLangCommonKeys.STR_MODULE_ADMIN); //$NON-NLS-1$
				btnAdmin.setSize(379, 21);
				btnAdmin.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						compModulesTreeLayout.topControl = treeAdmin;
						compModulesTree.layout();
						lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_ADMIN); //$NON-NLS-1$
					}
				});
				btnAdmin.setFont(SWTResourceManager.getFont("Tahoma", 10, 1, false, false)); //$NON-NLS-1$
			}
			compModulesHelp.layout();
			GridLayout compModulesTabLayout = new GridLayout();
			compModulesTab.setBackground(SWTResourceManager.getColor(128, 128, 128));
			compModulesTab.setLayout(compModulesTabLayout);
			compModulesTabLayout.marginWidth = 0;
			compModulesTabLayout.makeColumnsEqualWidth = true;
			compModulesTabLayout.verticalSpacing = 0;
			compModulesTabLayout.marginHeight = 0;
			compModulesTabLayout.horizontalSpacing = 0;
			compModulesTab.layout();
			tabFavorites.setControl(compFavoritesTab);
			tabFavorites.setText(EngLangCommonKeys.STR_FAVORITES); //$NON-NLS-1$
			tabFavorites.setImage(SWTResourceManager.getImage("icons/favorites.gif")); //$NON-NLS-1$
			{
				{
					compHistoryTab = new Composite(tabfldMenu, SWT.NONE);
					GridLayout compHistoryTabLayout = new GridLayout();
					compHistoryTabLayout.makeColumnsEqualWidth = true;
					compHistoryTab.setLayout(compHistoryTabLayout);
					{
						lblHistory = new CLabel(compHistoryTab, SWT.NONE);
						lblHistory.setText(EngLangCommonKeys.STR_HISTORY); //$NON-NLS-1$
					}
					{
						treeHistory = new Tree(compHistoryTab, SWT.NONE);
						GridData treeHistoryLData = new GridData();
						treeHistory.addMouseListener(new MouseAdapter()
						{
							public void mouseDoubleClick(MouseEvent evt)
							{
								treeHistoryMouseDoubleClick();
							}
						});
						treeHistoryLData.grabExcessHorizontalSpace = true;
						treeHistoryLData.grabExcessVerticalSpace = true;
						treeHistoryLData.horizontalAlignment = GridData.FILL;
						treeHistoryLData.verticalAlignment = GridData.FILL;
						treeHistory.setLayoutData(treeHistoryLData);
					}
				}
			}
			GridData compFavoritesSelectionLData = new GridData();
			compFavoritesSelectionLData.verticalAlignment = GridData.CENTER;
			compFavoritesSelectionLData.horizontalAlignment = GridData.FILL;
			compFavoritesSelectionLData.widthHint = -1;
			compFavoritesSelectionLData.heightHint = 24;
			compFavoritesSelectionLData.horizontalIndent = 0;
			compFavoritesSelectionLData.horizontalSpan = 1;
			compFavoritesSelectionLData.verticalSpan = 1;
			compFavoritesSelectionLData.grabExcessHorizontalSpace = true;
			compFavoritesSelectionLData.grabExcessVerticalSpace = false;
			compFavoritesSelection.setLayoutData(compFavoritesSelectionLData);
			compFavoritesSelection.setSize(new org.eclipse.swt.graphics.Point(386, 24));
			GridData lblFavoritesTabLData = new GridData();
			lblFavoritesTab.setImage(SWTResourceManager.getImage("icons/favorites.gif")); //$NON-NLS-1$
			lblFavoritesTab.setBackground(SWTResourceManager.getColor(255, 255, 255));
			lblFavoritesTabLData.verticalAlignment = GridData.CENTER;
			lblFavoritesTabLData.horizontalAlignment = GridData.FILL;
			lblFavoritesTabLData.widthHint = -1;
			lblFavoritesTabLData.heightHint = 20;
			lblFavoritesTabLData.horizontalIndent = 0;
			lblFavoritesTabLData.horizontalSpan = 1;
			lblFavoritesTabLData.verticalSpan = 1;
			lblFavoritesTabLData.grabExcessHorizontalSpace = true;
			lblFavoritesTabLData.grabExcessVerticalSpace = false;
			lblFavoritesTab.setLayoutData(lblFavoritesTabLData);
			lblFavoritesTab.setText(EngLangCommonKeys.STR_FAVORITES); //$NON-NLS-1$
			lblFavoritesTab.setSize(new org.eclipse.swt.graphics.Point(358, 20));
			lblFavoritesTab.setLayout(null);
			GridLayout compFavoritesSelectionLayout = new GridLayout(2, true);
			compFavoritesSelection.setLayout(compFavoritesSelectionLayout);
			compFavoritesSelectionLayout.marginWidth = 2;
			compFavoritesSelectionLayout.marginHeight = 2;
			compFavoritesSelectionLayout.numColumns = 2;
			compFavoritesSelectionLayout.makeColumnsEqualWidth = false;
			compFavoritesSelectionLayout.horizontalSpacing = 0;
			compFavoritesSelectionLayout.verticalSpacing = 0;
			compFavoritesSelection.layout();
			GridData treeFavoritesLData = new GridData();
			treeFavoritesLData.verticalAlignment = GridData.FILL;
			treeFavoritesLData.horizontalAlignment = GridData.FILL;
			treeFavoritesLData.grabExcessVerticalSpace = true;
			treeFavorites.setLayoutData(treeFavoritesLData);
			treeFavorites.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					treeFavoritesMouseDoubleClick();
				}
			});
			GridLayout compFavoritesTabLayout = new GridLayout(1, true);
			compFavoritesTab.setLayout(compFavoritesTabLayout);
			compFavoritesTabLayout.marginWidth = 0;
			compFavoritesTabLayout.marginHeight = 0;
			compFavoritesTabLayout.numColumns = 1;
			compFavoritesTabLayout.makeColumnsEqualWidth = true;
			compFavoritesTabLayout.horizontalSpacing = 0;
			compFavoritesTabLayout.verticalSpacing = 0;
			compFavoritesTab.layout();
			tabfldMenu.setLayout(null);
			tabfldMenu.setSelection(0);
			tabfldMenu.setBackground(SWTResourceManager.getColor(224, 238, 238));
			tabfldMenu.setUnselectedCloseVisible(false);
			tabfldMenu.addCTabFolder2Listener(new CTabFolder2Adapter()
			{
				public void close(CTabFolderEvent evt)
				{
					((CTabItem) evt.item).setControl(null);
					if (tabfldMenu.getItemCount() == 1)
					{
						sashMainHorizontal.setMaximizedControl(compMainInRight);
					}
				}
			});
			compMainInRight.setBounds(200, 2, 592, 572);
			GridLayout compMainInRightLayout = new GridLayout();
			compMainInRight.setLayout(compMainInRightLayout);
			{
				toolbarMainTop = new ToolBar(compMainInRight, SWT.FLAT | SWT.RIGHT);
				toolbarMainTop.setLocation(new org.eclipse.swt.graphics.Point(20, 0));
				{
					toolNew = new ToolItem(toolbarMainTop, SWT.PUSH);
					toolNew.setText(EngLangCommonKeys.STR_NEW); //$NON-NLS-1$
					toolNew.setToolTipText(EngLangCommonKeys.STR_NEW); //$NON-NLS-1$
					toolNew.setImage(SWTResourceManager.getImage("icons/new_wiz.gif")); //$NON-NLS-1$
					toolNew.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolNewWidgetSelected(evt);
						}
					});
				}
				{
					toolSave = new ToolItem(toolbarMainTop, SWT.PUSH);
					toolSave.setText(EngLangCommonKeys.STR_SAVE); //$NON-NLS-1$
					toolSave.setToolTipText(EngLangCommonKeys.STR_SAVE); //$NON-NLS-1$
					toolSave.setImage(SWTResourceManager.getImage("icons/save.jpg")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolSaveWidgetSelected(evt);
						}
					});
				}
				{
					toolDelete = new ToolItem(toolbarMainTop, SWT.PUSH);
					toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
					toolDelete.setToolTipText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolDeleteWidgetSelected(evt);
						}
					});
				}
				{
					toolSearch = new ToolItem(toolbarMainTop, SWT.PUSH);
					toolSearch.setText(EngLangCommonKeys.STR_SEARCH); //$NON-NLS-1$
					toolSearch.setToolTipText(EngLangCommonKeys.STR_SEARCH); //$NON-NLS-1$
					toolSearch.setImage(SWTResourceManager.getImage("icons/search.jpg")); //$NON-NLS-1$
					toolSearch.setSelection(true);
					toolSearch.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolSearchWidgetSelected(evt);
						}
					});
				}
				{
					toolExportToExcel = new ToolItem(toolbarMainTop, SWT.NONE);
					toolExportToExcel.setText(EngLangCommonKeys.STR_EXPORT_TO_EXCEL); //$NON-NLS-1$
					toolExportToExcel.setImage(SWTResourceManager.getImage("icons/excel.jpeg")); //$NON-NLS-1$
					toolExportToExcel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							exportToExcel();
						}
					});
				}
				{
					toolPrint = new ToolItem(toolbarMainTop, SWT.NONE);
					toolPrint.setText(EngLangCommonKeys.STR_PRINT); //$NON-NLS-1$
					toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
					toolPrint.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							printTable();
						}
					});
				}
				//START >> toolBrowser
				toolBrowser = new ToolItem(toolbarMainTop, SWT.NONE);
				toolBrowser.setText(EngLangCommonKeys.STR_TURQUAZ_WEBSITE); //$NON-NLS-1$
				toolBrowser.setImage(SWTResourceManager.getImage("icons/browserview.gif")); //$NON-NLS-1$
				toolBrowser.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						openBrowserTab();
					}
				});
				//END << toolBrowser
			}
			{
				tabfldMain = new CTabFolder(compMainInRight, SWT.CLOSE | SWT.BORDER);
				GridData tabfldMainLData = new GridData();
				tabfldMain.setSimple(false);
				tabfldMainLData.verticalAlignment = GridData.FILL;
				tabfldMainLData.horizontalAlignment = GridData.FILL;
				tabfldMainLData.grabExcessVerticalSpace = true;
				tabfldMain.setLayoutData(tabfldMainLData);
				tabfldMain.addCTabFolder2Listener(new CTabFolder2Adapter()
				{
					public void close(CTabFolderEvent evt)
					{
						tabfldMainItemClosed((CTabItem) evt.item);
					}

					public void itemClosed(CTabFolderEvent evt)
					{
						tabfldMainItemClosed((CTabItem) evt.item);
					}
				});
				MenuFactory.addTabFolderMenu(tabfldMain);
				tabfldMain.addSelectionListener(new SelectionAdapter()
				{
					public void widgetDefaultSelected(SelectionEvent evt)
					{
						tabfldMainWidgetDefaultSelected(evt);
					}

					public void widgetSelected(SelectionEvent evt)
					{
						tabfldMainWidgetSelected(evt);
					}
				});
				tabfldMain.setLayout(null);
			}
			compMainInRightLayout.makeColumnsEqualWidth = true;
			compMainInRightLayout.verticalSpacing = 0;
			compMainInRightLayout.marginHeight = 0;
			compMainInRightLayout.marginWidth = 0;
			compMainInRight.layout();
			sashMainVertical.setLayout(null);
			{
			}
			GridLayout compMainInLayout = new GridLayout(1, true);
			compMainIn.setLayout(compMainInLayout);
			compMainInLayout.marginWidth = 1;
			compMainInLayout.marginHeight = 3;
			compMainInLayout.numColumns = 1;
			compMainInLayout.makeColumnsEqualWidth = true;
			compMainInLayout.horizontalSpacing = 2;
			compMainInLayout.verticalSpacing = 2;
			compMainIn.layout();
			GridLayout compMainLayout = new GridLayout(3, true);
			compMain.setLayout(compMainLayout);
			compMainLayout.marginWidth = 0;
			compMainLayout.marginHeight = 0;
			compMainLayout.numColumns = 3;
			compMainLayout.makeColumnsEqualWidth = false;
			compMainLayout.horizontalSpacing = 2;
			compMainLayout.verticalSpacing = 0;
			compMain.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			
			EngBLKeyEvents.setDefault();
			Map keyValues = EngBLKeyEvents.DeserializeKeys();
			EngBLKeyEvents.SerializeKeys();
			
			menuMain = new Menu(getShell(), SWT.BAR);
			menuMain = MenuManager.createMainMenu(menuMain);
			getShell().setMenuBar(menuMain);
			postInitGUI();
			//		initialize accounts
			EngTXCommon.doSelectTX(EngBLAccountingAccounts.class.getName(), "getAccounts", null);
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}

	public static int checkTabMenu(Composite comp)
	{
		CTabItem items[] = tabfldMenu.getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getControl().equals(comp))
			{
				tabfldMenu.setSelection(items[i]);
				return i;
			}
		}
		return -1;
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
		//init user permissions
		try
		{
			
			EngTXCommon.doSelectTX(EngBLPermissions.class.getName(), "init", null);
			//Add popup menu to add favorites
			popupTreeAddFavorites = new Menu(getShell(), SWT.POP_UP);
			final MenuItem item = new MenuItem(popupTreeAddFavorites, SWT.PUSH);
			item.setText(EngLangCommonKeys.STR_ADD_TO_FAVORITES); //$NON-NLS-1$
			//Add popu menu to remove favorites
			popupTreeRemoveFavorites = new Menu(getShell(), SWT.POP_UP);
			final MenuItem itemRemove = new MenuItem(popupTreeRemoveFavorites, SWT.PUSH);
			itemRemove.setText(EngLangCommonKeys.STR_REMOVE_FROM_FAVORITES); //$NON-NLS-1$
			item.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					if (item.getData() != null)
					{
						TreeItem selectedItem = (TreeItem) item.getData();
						TreeItem favoriteItem = new TreeItem(treeFavorites, SWT.NULL);
						favoriteItem.setText(selectedItem.getText());
						favoriteItem.setData(selectedItem.getData());
					}
				}
			});
			itemRemove.addListener(SWT.Selection, new Listener()
			{
				public void handleEvent(Event e)
				{
					if (itemRemove.getData() != null)
					{
						TreeItem selectedItem = (TreeItem) itemRemove.getData();
						selectedItem.dispose();
					}
				}
			});
			popupTreeAddFavorites.addListener(SWT.Show, new Listener()
			{
				public void handleEvent(Event event)
				{
					StackLayout stackLayout = (StackLayout) compModulesTree.getLayout();
					Tree topTree = (Tree) stackLayout.topControl;
					if (topTree.getSelection().length > 0)
					{
						TreeItem selectedItem = topTree.getSelection()[0];
						if (selectedItem.getItemCount() > 0)
						{
							//if it has childeren then do not show menu
							event.doit = false;
							popupTreeAddFavorites.setVisible(false);
							item.setData(null);
						}
						else
						{
							event.doit = true;
							item.setData(selectedItem);
						}
					}
					else
					{
						item.setData(null);
					}
				}
			});
			popupTreeRemoveFavorites.addListener(SWT.Show, new Listener()
			{
				public void handleEvent(Event event)
				{
					if (treeFavorites.getSelection().length == 0)
					{
						//					if it has childeren then do not show menu
						event.doit = false;
						popupTreeAddFavorites.setVisible(false);
						itemRemove.setData(null);
						return;
					}
					TreeItem selectedItem = treeFavorites.getSelection()[0];
					if (selectedItem.getItemCount() > 0)
					{
						//if it has childeren then do not show menu
						event.doit = false;
						popupTreeAddFavorites.setVisible(false);
						itemRemove.setData(null);
					}
					else
					{
						event.doit = true;
						itemRemove.setData(selectedItem);
						System.out.println("show"); //$NON-NLS-1$
					}
				}
			});
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		StackLayout compo4layout = (StackLayout) compModulesTree.getLayout();
		compo4layout.topControl = treeAccounting;
		lblActiveModul.setText(EngLangCommonKeys.STR_MODULE_ACCOUNTING); //$NON-NLS-1$
		sashMainHorizontal.setWeights(new int[]{20, 80});
		sashMainVertical.setMaximizedControl(sashMainHorizontal);
		tabfldMain.setTabHeight(20);
		tabfldMain.setSelectionBackground(new Color[]{Display.getDefault().getSystemColor(SWT.COLOR_WHITE)}, new int[]{});
		toolNew.setEnabled(false);
		toolSave.setEnabled(false);
		toolDelete.setEnabled(false);
		toolSearch.setEnabled(false);
		toolExportToExcel.setEnabled(false);
		toolPrint.setEnabled(false);
		//Create Trees
		treeInventory = TreeFactory.createInventoryTree(treeInventory);
		treeBank = TreeFactory.createBankTree(treeBank);
		treeAccounting = TreeFactory.createAccountingTree(treeAccounting);
		treeCurrent = TreeFactory.createCurrentTree(treeCurrent);
		treeAdmin = TreeFactory.createAdminTree(treeAdmin);
		treeConsignment = TreeFactory.createConsignmetTree(treeConsignment);
		treeBill = TreeFactory.createBillTree(treeBill);
		treeCash = TreeFactory.createCashTree(treeCash);
		treeCheques = TreeFactory.createChequesTree(treeCheques);
		addKeyEventAccounting(treeAccounting);
		addKeyEventInventory(treeInventory);
		addKeyEventBank(treeBank);
		addKeyEventCurrent(treeCurrent);
		addKeyEventAdmin(treeAdmin);
		addKeyEventConsignment(treeConsignment);
		addKeyEventBill(treeBill);
		addKeyEventCash(treeCash);
		addKeyEventCheque(treeCheques);
		fillFavoritesTree();
		/** ********Set Button Cursors************************ */
		Cursor cursor = new Cursor(getDisplay(), SWT.CURSOR_HAND);
		btnInventory.setCursor(cursor);
		btnAccounting.setCursor(cursor);
		btnAdmin.setCursor(cursor);
		btnBank.setCursor(cursor);
		btnConsignment.setCursor(cursor);
		btnBill.setCursor(cursor);
		btnCurrent.setCursor(cursor);
		btnCash.setCursor(cursor);
		btnCheque.setCursor(cursor);
		setPopUpMenus();
		//Set color for Main tab folder
		Display display = this.getDisplay();
		tabfldMain.setSelectionBackground(new Color[]{display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND),
				display.getSystemColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT), display.getSystemColor(SWT.COLOR_WIDGET_BACKGROUND)},
				new int[]{60, 100});
		tabfldMain.setSelectionForeground(display.getSystemColor(SWT.COLOR_TITLE_FOREGROUND));
		try
		{
			EngTXCommon.doSelectTX(EngBLInventoryCards.class.getName(), "getInventoryCards", null);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	public void setPopUpMenus()
	{
		//		SET POP UP Menus for trees
		treeAccounting.setMenu(popupTreeAddFavorites);
		treeAdmin.setMenu(popupTreeAddFavorites);
		treeBank.setMenu(popupTreeAddFavorites);
		treeInventory.setMenu(popupTreeAddFavorites);
		treeConsignment.setMenu(popupTreeAddFavorites);
		treeCurrent.setMenu(popupTreeAddFavorites);
		treeFavorites.setMenu(popupTreeRemoveFavorites);
		treeBill.setMenu(popupTreeAddFavorites);
		treeCash.setMenu(popupTreeAddFavorites);
		treeCheques.setMenu(popupTreeAddFavorites);
	}

	public void addKeyEventInventory(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeInventoryMouseDoubleClick();
			}
		});
	}

	public void addKeyEventBank(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeBankMouseDoubleClick();
			}
		});
	}

	public void addKeyEventAccounting(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeAccountingMouseDoubleClick();
			}
		});
	}

	public void addKeyEventCurrent(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeCurrentMouseDoubleClick();
			}
		});
	}

	public void addKeyEventAdmin(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeAdminMouseDoubleClick();
			}
		});
	}

	public void addKeyEventConsignment(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeConsignmentMouseDoubleClick();
			}
		});
	}

	public void addKeyEventBill(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeBillMouseDoubleClick();
			}
		});
	}

	public void addKeyEventCash(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeCashMouseDoubleClick();
			}
		});
	}

	public void addKeyEventCheque(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent evt)
			{
				if (evt.keyCode == SWT.CR)
					treeChequeMouseDoubleClick();
			}
		});
	}

	public void fillFavoritesTree()
	{
		try
		{
			File prop_dir = new File(System.getProperty("user.home") + "/.turquaz");
			if (!prop_dir.exists())
			{
				prop_dir.mkdir();
			}
			File file = new File(System.getProperty("user.home") + "/.turquaz/favorites.xml");
			if (!file.exists())
			{
				XMLOutputter outputter = new XMLOutputter();
				OutputStream output = null;
				output = new FileOutputStream(System.getProperty("user.home") + "/.turquaz/favorites.xml"); //$NON-NLS-1$
				Element root = new Element("tree");
				outputter.output(root, output);
				output.close();
			}
			EngBLXmlParser xmlParser = new EngBLXmlParser(System.getProperty("user.home") + "/.turquaz/favorites.xml"); //$NON-NLS-1$
			Map treeInfo = xmlParser.createMap();
			Iterator it = treeInfo.keySet().iterator();
			String text = ""; //$NON-NLS-1$
			String className = ""; //$NON-NLS-1$
			TreeItem treeItem;
			while (it.hasNext())
			{
				text = it.next().toString();
				className = treeInfo.get(text).toString();
				treeItem = new TreeItem(treeFavorites, SWT.NULL);
				treeItem.setText(text);
				treeItem.setData(className);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	/**
	 * This static method creates a new instance of this class and shows it inside a new Shell. It is a convenience method for showing the
	 * GUI, but it can be copied and used as a basis for your own code. * It is auto-generated code - the body of this method will be
	 * re-generated after any changes are made to the GUI. However, if you delete this method it will not be re-created.
	 */
	public static void showGUI2(Display display,Shell splashShell)
	{
		try
		{
			Shell shell = new Shell(display);
			
			final EngUIMainFrame inst = new EngUIMainFrame(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0, 0, 800, 580);
			shell.setImage(SWTResourceManager.getImage("icons/turquaz_paw.gif")); //$NON-NLS-1$
			TurqCompany company = (TurqCompany) EngTXCommon.doSelectTX(AdmBLCompanyInfo.class.getName(), "getCompany", null);
			shell.setText("Turquaz - " + company.getCompanyName()); //$NON-NLS-1$
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.addListener(SWT.Close, new Listener()
			{
				public void handleEvent(Event e)
				{
					if (inst.okToClose())
					{
						saveFavoritesTree();
						saveProperties();
						EngUITableProperties.saveToFile();
                        EngModulePrefs.saveToFile();
						EngBackUp.backUp("");
						System.exit(0);
					}
					else
					{
						e.doit = false;
					}
				}
			});
			shell.open();
			shell.setMaximized(true);
			splashShell.dispose();
			
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(EngUIMainFrame.class,e);
		}
	}

	/** Auto-generated event handler method */
	public boolean okToClose()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		msg.setMessage(EngLangCommonKeys.MSG_SURE_TO_EXIT); //$NON-NLS-1$
		if (msg.open() == SWT.OK)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void openBrowserTab()
	{
		CTabItem yeni = new CTabItem(tabfldMain, SWT.NULL);
		yeni.setText("Web Browser"); //$NON-NLS-1$
		yeni.setImage(SWTResourceManager.getImage("/icons/world.gif"));
		BrowserPanel panel = new BrowserPanel(tabfldMain, true, false);
		yeni.setControl(panel);
		tabfldMain.setSelection(yeni);
		arrangeIcons();
	}

	public static void openNewTab(String Name, String classname)
	{
		if (mapList.containsKey(classname))
		{
			//if the tab is already open
			tabfldMain.setSelection((CTabItem) mapList.get(classname));
			arrangeIcons();
		}
		else
		{
			CTabItem yeni = new CTabItem(tabfldMain, SWT.NULL);
			yeni.setText(Name);
			try
			{
				Class c = Class.forName(classname);
				Composite comp = (Composite) c.getConstructor(new Class[]{Composite.class, int.class}).newInstance(
						new Object[]{tabfldMain, Integer.valueOf(SWT.NULL + "")}); //$NON-NLS-1$
				yeni.setControl(comp);
				tabfldMain.setSelection(yeni);
				arrangeIcons();
				// put into the tab hashmap
				mapList.put(classname, yeni);
				//Add To History Tree
				boolean dontExistInHistory = true;
				TreeItem items[] = treeHistory.getItems();
				for (int i = 0; i < items.length; i++)
				{
					if (items[i].getData().equals(classname))
					{
						dontExistInHistory = false;
						break;
					}
				}
				if (dontExistInHistory)
				{
					TreeItem item = new TreeItem(treeHistory, SWT.NULL);
					item.setText(Name);
					item.setData(classname);
				}
			}
			catch (Exception ex)
			{
                EngBLLogger.log(EngUIMainFrame.class,ex);
			}
		}
		//Button tus = new Button(tabfldMain,1);
		//Form.setParent(tabfldMain);
	}

	public void openNewTab(TreeItem item)
	{
		// if the class name is set
		if (item.getData() != null)
		{
			openNewTab(item.getText(), item.getData().toString());
		}
	}

	/** Auto-generated event handler method */
	protected void EngUIMainFramePaintControl(PaintEvent evt)
	{
	}

	/** Auto-generated event handler method */
	public static void arrangeIcons()
	{
		try
		{
			if (tabfldMain.getSelection() == null)
			{
				toolExportToExcel.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(false);
				toolPrint.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(false);
				toolDelete.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(false);
				toolSearch.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(false);
				toolSave.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
				toolNew.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
				return;
			}
			if (tabfldMain.getSelection().getControl() == null)
			{
				toolExportToExcel.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(false);
				toolPrint.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(false);
				toolDelete.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(false);
				toolSearch.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(false);
				toolSave.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
				toolNew.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
				return;
			}
			if (tabfldMain.getSelection().getControl() instanceof SecureComposite)
			{
				SecureComposite c = (SecureComposite) tabfldMain.getSelection().getControl();
				int level = EngBLPermissions.getPermission(c.getClass().getName());
				//	System.out.println(level);
				if (level == 3)
				{
					toolNew.setEnabled(true);
					((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(true);
					toolSave.setEnabled(true);
					((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(true);
				}
				else if (level == 2)
				{
					toolNew.setEnabled(true);
					((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(true);
					toolSave.setEnabled(true);
					((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(true);
				}
				else if (level == 1)
				{
					toolNew.setEnabled(true);
					((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(true);
					toolSave.setEnabled(false);
					((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
				}
				else
				{
					toolNew.setEnabled(false);
					((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
					toolSave.setEnabled(false);
					((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
				}
			}
			else
			{
				toolNew.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
				toolSave.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
			}
			if (tabfldMain.getSelection().getControl() instanceof SearchComposite)
			{
				toolExportToExcel.setEnabled(true);
				((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(true);
				toolPrint.setEnabled(true);
				((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(true);
				toolDelete.setEnabled(true);
				((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(true);
				toolSearch.setEnabled(true);
				((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(true);
			}
			else
			{
				toolExportToExcel.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(false);
				toolPrint.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(false);
				toolDelete.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(false);
				toolSearch.setEnabled(false);
				((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(false);
			}
		}
		catch (ClassCastException ex)
		{
			toolNew.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
			toolSave.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
			toolDelete.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(false);
			toolSearch.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(false);
			toolExportToExcel.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(false);
			toolPrint.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(false);
		}
		catch (Exception ex)
		{
			toolNew.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitNew.getData()).setAvailable(false);
			toolSave.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitSave.getData()).setAvailable(false);
			toolDelete.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitDelete.getData()).setAvailable(false);
			toolSearch.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitSearch.getData()).setAvailable(false);
			toolExportToExcel.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitExcel.getData()).setAvailable(false);
			toolPrint.setEnabled(false);
			((TurqKeyEvent)MenuManager.mitPrint.getData()).setAvailable(false);
            EngBLLogger.log(EngUIMainFrame.class,ex);
		}
		finally
		{
			try
			{
				EngUIMainFrame.menuMain=new Menu(EngUIMainFrame.shell, SWT.BAR);
				MenuManager.createMainMenu(EngUIMainFrame.menuMain);
				EngUIMainFrame.shell.setMenuBar(EngUIMainFrame.menuMain);
			}
			catch(Exception ex)
			{
                EngBLLogger.log(EngUIMainFrame.class,ex);				
			}
		}
	}

	protected void tabfldMainWidgetSelected(SelectionEvent evt)
	{
		arrangeIcons();
	}

	/** Auto-generated event handler method */
	protected void tabfldMainWidgetDefaultSelected(SelectionEvent evt)
	{
		arrangeIcons();
	}

	/** Auto-generated event handler method */
	protected void treeInventoryMouseDoubleClick()
	{
		TreeItem item = treeInventory.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeAdminMouseDoubleClick()
	{
		TreeItem item = treeAdmin.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	public static void tabfldMainItemClosed(CTabItem item)
	{
		if (tabfldMain.getItemCount() == 1)
		{
			toolNew.setEnabled(false);
			toolSave.setEnabled(false);
			toolDelete.setEnabled(false);
			toolSearch.setEnabled(false);
			toolExportToExcel.setEnabled(false);
			toolPrint.setEnabled(false);
		}
		mapList.remove(item.getControl().getClass().getName());
		//System.out.println(evt.getSource());
	}

	/** Auto-generated event handler method */
	protected void toolNewWidgetSelected(SelectionEvent evt)
	{
		Composite c = (Composite) tabfldMain.getSelection().getControl();
		if (c instanceof SecureComposite)
		{
			((SecureComposite) c).newForm();
		}
	}

	/** Auto-generated event handler method */
	protected void toolSaveWidgetSelected(SelectionEvent evt)
	{
		Composite c = (Composite) tabfldMain.getSelection().getControl();
		if (c instanceof SecureComposite)
		{
			((SecureComposite) c).save();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		Composite c = (Composite) tabfldMain.getSelection().getControl();
		if (c instanceof SearchComposite)
		{
			((SearchComposite) c).delete();
		}
	}

	/** Auto-generated event handler method */
	protected void toolSearchWidgetSelected(SelectionEvent evt)
	{
		Composite c = (Composite) tabfldMain.getSelection().getControl();
		if (c instanceof SearchComposite)
		{
			((SearchComposite) c).search();
		}
	}

	/** Auto-generated event handler method */
	protected void treeAccountingMouseDoubleClick()
	{
		TreeItem item = treeAccounting.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeChequeMouseDoubleClick()
	{
		TreeItem item = treeCheques.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	/** Auto-generated event handler method */
	protected void treeBankMouseDoubleClick()
	{
		TreeItem item = treeBank.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	protected void treeBillMouseDoubleClick()
	{
		TreeItem item = treeBill.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeConsignmentMouseDoubleClick()
	{
		TreeItem item = treeConsignment.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeFavoritesMouseDoubleClick()
	{
		if (treeFavorites.getSelection().length == 0)
		{
			return;
		}
		TreeItem item = treeFavorites.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeHistoryMouseDoubleClick()
	{
		TreeItem item = treeHistory.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeCurrentMouseDoubleClick()
	{
		TreeItem item = treeCurrent.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeCashMouseDoubleClick()
	{
		TreeItem item = treeCash.getSelection()[0];
		if (item.getItemCount() == 0)
		{
			openNewTab(item);
		}
	}

	//Save Options of the user...
	public static void saveProperties()
	{
		try
		{
			FileInputStream input = new FileInputStream("config/turquaz.properties"); //$NON-NLS-1$
			Properties props = new Properties();
			props.load(input);
			input.close();
			// props.put("logo","dfaf");
			props.put("logoURL", EngConfiguration.logoURL); //$NON-NLS-1$
			FileOutputStream output = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
			props.store(output, "Turquaz Configuration"); //$NON-NLS-1$
			output.flush();
			output.close();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngUIMainFrame.class,ex);
		}
	}

	//save favorite items to the
	public static void saveFavoritesTree()
	{
		try
		{
			XMLOutputter outputter = new XMLOutputter();
			OutputStream output = null;
			output = new FileOutputStream(System.getProperty("user.home") + "/.turquaz/favorites.xml"); //$NON-NLS-1$
			TreeItem items[] = treeFavorites.getItems();
			Element root = new Element("tree"); //$NON-NLS-1$
			Element treeItem;
			for (int i = 0; i < items.length; i++)
			{
				treeItem = new Element("treeitem"); //$NON-NLS-1$
				treeItem.setAttribute("text", items[i].getText()); //$NON-NLS-1$
				treeItem.setAttribute("class", items[i].getData().toString()); //$NON-NLS-1$
				root.addContent(treeItem);
			}
			outputter.output(root, output);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngUIMainFrame.class,ex);
		}
		finally
		{
		}
	}

	/** Auto-generated event handler method */
	protected void rootWidgetDisposed(DisposeEvent evt)
	{
		this.dispose();
	}

	protected void exportToExcel()
	{
		SearchComposite sc = (SearchComposite) tabfldMain.getSelection().getControl();
		sc.exportToExcel();
	}

	protected void printTable()
	{
		SearchComposite sc = (SearchComposite) tabfldMain.getSelection().getControl();
		sc.printTable();
	}
}