package com.turquaz.engine.ui;

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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream; 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;

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
import org.eclipse.swt.custom.CCombo;
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

import com.turquaz.engine.ui.component.LiveSashForm;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLXmlParser;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.component.TreeFactory;



/**
* @author  Onsel Armagan
* @version  $Id$
*/
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



public class EngUIMainFrame extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
  
	private Tree treeCurrent;
	private Label label1;
	private Composite composite1;
	private Composite compModulesHelp;
	private Tree treeBank;
	private Tree treeAccounting;
	private static CTabFolder tabfldMain;
	private static ToolItem toolSearch;
	private static ToolItem toolDelete;
	private static ToolItem toolSave;
	private static ToolItem toolNew;
	private ToolBar toolbarMainTop;
	private Composite compMainInRight;
	private static Tree treeFavorites;
	private ToolBar toolbarFavoritesTab;
	private CLabel lblFavoritesTab;
	private Composite compFavoritesSelection;
	private Composite compFavoritesTab;
	private CTabItem tabFavorites;
	private Tree treeAdmin;
	private Tree treeInventory;
	private Composite compModulesTree;
	private CCombo comboModuleSelection;
	private CLabel lblModuleSelection;
	private Composite compModuleSelection;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Tree treeBill;
	private static ToolItem toolExportToExcel;
	private Tree treeConsignment;
	private Composite compModulesTab;
	private CTabItem tabModules;
	private CTabFolder tabfldMenu;
	private LiveSashForm sashMainHorizontal;
	private MenuItem mitEdit;
	private SashForm sashMainVertical;
	private Composite compMainIn;
	private Label lblSeperatorLeft;
	private Composite compMain;
	private Label lblSeperator;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem mitHelp;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Menu fileMenu;
	private MenuItem mitFile;
	private Menu menuMain;
	Menu popupTreeAddFavorites;
	Menu popupTreeRemoveFavorites;
	static Map mapList = new HashMap();

	public EngUIMainFrame(Composite parent, int style) {
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
	
			lblSeperator = new Label(this,SWT.SEPARATOR| SWT.HORIZONTAL);
			compMain = new Composite(this,SWT.NULL);
			lblSeperatorLeft = new Label(compMain,SWT.SEPARATOR);
			compMainIn = new Composite(compMain,SWT.NULL);
			sashMainVertical = new SashForm(compMainIn,SWT.NULL);
			sashMainHorizontal = new LiveSashForm(sashMainVertical, SWT.NONE);
			tabfldMenu = new CTabFolder(sashMainHorizontal,SWT.TOP| SWT.BORDER);
			tabModules = new CTabItem(tabfldMenu,SWT.NULL);
			compModulesTab = new Composite(tabfldMenu,SWT.NULL);
			compModuleSelection = new Composite(compModulesTab,SWT.BORDER);
			compModulesTree = new Composite(compModulesTab,SWT.NULL);
			treeBank = new Tree(compModulesTree,SWT.NULL);
			treeInventory = new Tree(compModulesTree,SWT.NULL);
			treeAccounting = new Tree(compModulesTree,SWT.NULL);
			treeAdmin = new Tree(compModulesTree,SWT.NULL);
			treeCurrent = new Tree(compModulesTree,SWT.NULL);
			{
				treeConsignment = new Tree(compModulesTree, SWT.NONE);
				treeConsignment.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						 treeConsignmentMouseDoubleClick();
					}
				});
			}
			{
				treeBill = new Tree(compModulesTree, SWT.NONE);
				treeBill.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick() {
						treeBillMouseDoubleClick();
					}
				});
			}
			label1 = new Label(compModulesTab,SWT.SEPARATOR| SWT.HORIZONTAL);
			compModulesHelp = new Composite(compModulesTab,SWT.NULL);
			composite1 = new Composite(compModulesHelp,SWT.NULL);
			tabFavorites = new CTabItem(tabfldMenu,SWT.NULL);
			compFavoritesTab = new Composite(tabfldMenu,SWT.NULL);
			compFavoritesSelection = new Composite(compFavoritesTab,SWT.NULL);
			lblFavoritesTab = new CLabel(compFavoritesSelection,SWT.NULL);
			toolbarFavoritesTab = new ToolBar(compFavoritesSelection,SWT.FLAT);
			treeFavorites = new Tree(compFavoritesTab,SWT.NULL);
			compMainInRight = new Composite(sashMainHorizontal,SWT.NULL);
			
	
			this.setSize(new org.eclipse.swt.graphics.Point(800,600));
			
	
			GridData lblSeperatorLData = new GridData();
			lblSeperatorLData.verticalAlignment = GridData.CENTER;
			lblSeperatorLData.horizontalAlignment = GridData.FILL;
			lblSeperatorLData.widthHint = -1;
			lblSeperatorLData.heightHint = -1;
			lblSeperatorLData.horizontalIndent = 0;
			lblSeperatorLData.horizontalSpan = 1;
			lblSeperatorLData.verticalSpan = 1;
			lblSeperatorLData.grabExcessHorizontalSpace = false;
			lblSeperatorLData.grabExcessVerticalSpace = false;
			lblSeperator.setLayoutData(lblSeperatorLData);
			lblSeperator.setText("label1"); //$NON-NLS-1$
	
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
			compMain.setSize(new org.eclipse.swt.graphics.Point(800,578));
	
			GridData lblSeperatorLeftLData = new GridData();
			lblSeperatorLeftLData.verticalAlignment = GridData.FILL;
			lblSeperatorLeftLData.horizontalAlignment = GridData.BEGINNING;
			lblSeperatorLeftLData.widthHint = 2;
			lblSeperatorLeftLData.heightHint = -1;
			lblSeperatorLeftLData.horizontalIndent = 0;
			lblSeperatorLeftLData.horizontalSpan = 1;
			lblSeperatorLeftLData.verticalSpan = 1;
			lblSeperatorLeftLData.grabExcessHorizontalSpace = false;
			lblSeperatorLeftLData.grabExcessVerticalSpace = true;
			lblSeperatorLeft.setLayoutData(lblSeperatorLeftLData);
			lblSeperatorLeft.setText("label2"); //$NON-NLS-1$
			lblSeperatorLeft.setSize(new org.eclipse.swt.graphics.Point(2,578));
	
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
			sashMainVerticalLData.widthHint = -1;
			sashMainVerticalLData.heightHint = -1;
			sashMainVerticalLData.horizontalIndent = 0;
			sashMainVerticalLData.horizontalSpan = 1;
			sashMainVerticalLData.verticalSpan = 1;
			sashMainVerticalLData.grabExcessHorizontalSpace = true;
			sashMainVerticalLData.grabExcessVerticalSpace = true;
			sashMainVertical.setLayoutData(sashMainVerticalLData);
			sashMainVertical.setOrientation(SWT.VERTICAL);
			sashMainVertical.setSize(new org.eclipse.swt.graphics.Point(792,572));
	
			sashMainHorizontal.setSize(new org.eclipse.swt.graphics.Point(792,572));
			sashMainHorizontal.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,792,572));
	
			tabfldMenu.setSize(new org.eclipse.swt.graphics.Point(386,566));
			tabfldMenu.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,392,572));
	
			tabModules.setControl(compModulesTab);
			tabModules.setText(Messages.getString("EngUIMainFrame.2")); //$NON-NLS-1$
			tabModules.setImage(SWTResourceManager.getImage("icons/Process16.gif")); //$NON-NLS-1$

			compModulesTab.setSize(new org.eclipse.swt.graphics.Point(386,549));
	
			GridData compModuleSelectionLData = new GridData();
			compModuleSelectionLData.horizontalAlignment = GridData.FILL;
			compModuleSelectionLData.heightHint = 22;
			compModuleSelectionLData.horizontalSpan = 5;
			compModuleSelectionLData.grabExcessHorizontalSpace = true;
			compModuleSelection.setLayoutData(compModuleSelectionLData);

			GridLayout compModuleSelectionLayout = new GridLayout();
			compModuleSelectionLayout.numColumns = 2;
			compModuleSelectionLayout.marginHeight = 0;
			compModuleSelectionLayout.horizontalSpacing = 0;
			compModuleSelectionLayout.marginWidth = 0;
			compModuleSelectionLayout.verticalSpacing = 0;
			compModuleSelection.setLayout(compModuleSelectionLayout);
			{
				lblModuleSelection = new CLabel(compModuleSelection, SWT.LEFT);
				lblModuleSelection.setText(Messages
					.getString("EngUIMainFrame.3")); //$NON-NLS-1$
				lblModuleSelection.setLayout(null);
				GridData lblModuleSelectionLData = new GridData();
				lblModuleSelectionLData.widthHint = 79;
				lblModuleSelectionLData.heightHint = 22;
				lblModuleSelection.setLayoutData(lblModuleSelectionLData);
			}
			{
				comboModuleSelection = new CCombo(compModuleSelection, SWT.FLAT | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
				comboModuleSelection.setBackground(SWTResourceManager.getColor(255, 255, 255));
				GridData comboModuleSelectionLData = new GridData();
				comboModuleSelection
					.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						comboModuleSelectionWidgetSelected(evt);
					}
					});
				comboModuleSelectionLData.heightHint = 20;
				comboModuleSelectionLData.horizontalAlignment = GridData.FILL;
				comboModuleSelectionLData.grabExcessHorizontalSpace = true;
				comboModuleSelection.setLayoutData(comboModuleSelectionLData);
				
			}
			compModuleSelection.layout();
	
			GridData compModulesTreeLData = new GridData();
			compModulesTreeLData.verticalAlignment = GridData.FILL;
			compModulesTreeLData.horizontalAlignment = GridData.FILL;
			compModulesTreeLData.widthHint = -1;
			compModulesTreeLData.heightHint = -1;
			compModulesTreeLData.horizontalIndent = 0;
			compModulesTreeLData.horizontalSpan = 1;
			compModulesTreeLData.verticalSpan = 1;
			compModulesTreeLData.grabExcessHorizontalSpace = false;
			compModulesTreeLData.grabExcessVerticalSpace = true;
			compModulesTree.setLayoutData(compModulesTreeLData);
			compModulesTree.setSize(new org.eclipse.swt.graphics.Point(386,267));
	
			treeBank.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeBank.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeBankMouseDoubleClick();
				}
			});
	
			treeInventory.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeInventory.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeInventoryMouseDoubleClick();
				}
			});
	
			treeAccounting.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeAccounting.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeAccountingMouseDoubleClick();
				}
			});
	
			treeAdmin.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeAdmin.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeAdminMouseDoubleClick();
				}
			});
	
			treeCurrent.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeCurrentMouseDoubleClick();
				}
			});
			StackLayout compModulesTreeLayout = new StackLayout();
			compModulesTree.setLayout(compModulesTreeLayout);
			compModulesTreeLayout.marginWidth = 0;
			compModulesTreeLayout.marginHeight = 0;
			compModulesTreeLayout.topControl = null;
			compModulesTree.layout();
	
			GridData label1LData = new GridData();
			label1LData.horizontalAlignment = GridData.FILL;
			label1LData.heightHint = 8;
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
			compModulesHelp.setSize(new org.eclipse.swt.graphics.Point(386,235));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.BEGINNING;
			composite1LData.widthHint = 123;
			composite1LData.heightHint = 225;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(123,225));
			FormLayout composite1Layout = new FormLayout();
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 0;
			composite1Layout.marginHeight = 0;
			composite1Layout.spacing = 0;
			composite1.layout();
			GridLayout compModulesHelpLayout = new GridLayout(1, true);
			compModulesHelp.setLayout(compModulesHelpLayout);
			compModulesHelpLayout.marginWidth = 5;
			compModulesHelpLayout.marginHeight = 5;
			compModulesHelpLayout.numColumns = 1;
			compModulesHelpLayout.makeColumnsEqualWidth = true;
			compModulesHelpLayout.horizontalSpacing = 5;
			compModulesHelpLayout.verticalSpacing = 5;
			compModulesHelp.layout();
			GridLayout compModulesTabLayout = new GridLayout(1, true);
			compModulesTab.setLayout(compModulesTabLayout);
			compModulesTabLayout.marginWidth = 0;
			compModulesTabLayout.marginHeight = 5;
			compModulesTabLayout.numColumns = 1;
			compModulesTabLayout.makeColumnsEqualWidth = true;
			compModulesTabLayout.horizontalSpacing = 5;
			compModulesTabLayout.verticalSpacing = 5;
			compModulesTab.layout();
	
			tabFavorites.setControl(compFavoritesTab);
			tabFavorites.setText(Messages.getString("EngUIMainFrame.5")); //$NON-NLS-1$
			tabFavorites.setImage(SWTResourceManager.getImage("icons/favorites.gif")); //$NON-NLS-1$

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
			compFavoritesSelection.setSize(new org.eclipse.swt.graphics.Point(386,24));
	
			GridData lblFavoritesTabLData = new GridData();
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
			lblFavoritesTab.setText(Messages.getString("EngUIMainFrame.6")); //$NON-NLS-1$
			lblFavoritesTab.setSize(new org.eclipse.swt.graphics.Point(358,20));
			lblFavoritesTab.setLayout(null);
	
			GridData toolbarFavoritesTabLData = new GridData();
			toolbarFavoritesTabLData.verticalAlignment = GridData.CENTER;
			toolbarFavoritesTabLData.horizontalAlignment = GridData.BEGINNING;
			toolbarFavoritesTabLData.widthHint = -1;
			toolbarFavoritesTabLData.heightHint = -1;
			toolbarFavoritesTabLData.horizontalIndent = 0;
			toolbarFavoritesTabLData.horizontalSpan = 1;
			toolbarFavoritesTabLData.verticalSpan = 1;
			toolbarFavoritesTabLData.grabExcessHorizontalSpace = false;
			toolbarFavoritesTabLData.grabExcessVerticalSpace = false;
			toolbarFavoritesTab.setLayoutData(toolbarFavoritesTabLData);
			toolbarFavoritesTab.setLayout(null);
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
			treeFavorites.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
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

			compMainInRight.setBounds(200, 2, 592, 572);

			
			
			GridLayout compMainInRightLayout = new GridLayout();
			compMainInRight.setLayout(compMainInRightLayout);
            {
                coolBar1 = new CoolBar(compMainInRight, SWT.NONE);
                GridData coolBar1LData = new GridData();
                coolBar1LData.grabExcessHorizontalSpace = true;
                coolBar1LData.horizontalAlignment = GridData.FILL;
                coolBar1.setLayoutData(coolBar1LData);
                {
                    coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                    coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 26));
                    coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 26));
                    coolItem1.setSize(45, 26);
                    {
                        toolbarMainTop = new ToolBar(coolBar1, SWT.FLAT
                            | SWT.RIGHT);
                        coolItem1.setControl(toolbarMainTop);
                        toolbarMainTop
                            .setLocation(new org.eclipse.swt.graphics.Point(
                                20,
                                0));

                        {
                            toolNew = new ToolItem(toolbarMainTop, SWT.PUSH);
                            toolNew.setText(Messages
                                .getString("EngUIMainFrame.8")); //$NON-NLS-1$
                            toolNew.setToolTipText(Messages
                                .getString("EngUIMainFrame.9")); //$NON-NLS-1$
                            toolNew.setImage(SWTResourceManager
                                .getImage("icons/new_wiz.gif"));

                            toolNew
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        toolNewWidgetSelected(evt);
                                    }
                                });
                        }
                        {
                            toolSave = new ToolItem(toolbarMainTop, SWT.PUSH);
                            toolSave.setText(Messages
                                .getString("EngUIMainFrame.11")); //$NON-NLS-1$
                            toolSave.setToolTipText(Messages
                                .getString("EngUIMainFrame.12")); //$NON-NLS-1$
                            toolSave.setImage(SWTResourceManager
                                .getImage("icons/save.jpg")); //$NON-NLS-1$
                            toolSave
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        toolSaveWidgetSelected(evt);
                                    }
                                });
                        }
                        {
                            toolDelete = new ToolItem(toolbarMainTop, SWT.PUSH);
                            toolDelete.setText(Messages
                                .getString("EngUIMainFrame.0")); //$NON-NLS-1$
                            toolDelete.setToolTipText(Messages
                                .getString("EngUIMainFrame.15")); //$NON-NLS-1$
                            toolDelete.setImage(SWTResourceManager
                                .getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                            toolDelete
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        toolDeleteWidgetSelected(evt);
                                    }
                                });
                        }
                        {
                            toolSearch = new ToolItem(toolbarMainTop, SWT.PUSH);
                            toolSearch.setText(Messages
                                .getString("EngUIMainFrame.17")); //$NON-NLS-1$
                            toolSearch.setToolTipText(Messages
                                .getString("EngUIMainFrame.18")); //$NON-NLS-1$
                            toolSearch.setImage(SWTResourceManager
                                .getImage("icons/search.jpg")); //$NON-NLS-1$
                            toolSearch.setSelection(true);
                            toolSearch
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        toolSearchWidgetSelected(evt);
                                    }
                                });
                        }
                        {
                            toolExportToExcel = new ToolItem(
                                toolbarMainTop,
                                SWT.NONE);
                            toolExportToExcel.setText(Messages
                                .getString("EngUIMainFrame.10")); //$NON-NLS-1$
                            toolExportToExcel.setImage(SWTResourceManager
                                .getImage("icons/excel.jpeg")); //$NON-NLS-1$
                            toolExportToExcel
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        exportToExcel();
                                    }
                                });
                        }
                    }
                }
            }
            tabfldMain = new CTabFolder(compMainInRight, SWT.CLOSE | SWT.BORDER);
			GridData tabfldMainLData = new GridData();
			
			tabfldMainLData.verticalAlignment = GridData.FILL;
			tabfldMainLData.horizontalAlignment = GridData.FILL;
			tabfldMainLData.widthHint = -1;
			tabfldMainLData.heightHint = -1;
			tabfldMainLData.horizontalIndent = 0;
			tabfldMainLData.horizontalSpan = 1;
			tabfldMainLData.verticalSpan = 1;
			tabfldMainLData.grabExcessHorizontalSpace = false;
			tabfldMainLData.grabExcessVerticalSpace = true;
			tabfldMain.setLayoutData(tabfldMainLData);
			tabfldMain.setSize(new org.eclipse.swt.graphics.Point(381,511));
			tabfldMain.addCTabFolder2Listener(new CTabFolder2Adapter() {
				public void close(CTabFolderEvent evt) {
					tabfldMainItemClosed(evt);
				}
				public void itemClosed(CTabFolderEvent evt) {
					tabfldMainItemClosed(evt);
				}
			});
			tabfldMain.addSelectionListener(new SelectionAdapter() {
				public void widgetDefaultSelected(SelectionEvent evt) {
					tabfldMainWidgetDefaultSelected(evt);
				}
				public void widgetSelected(SelectionEvent evt) {
					tabfldMainWidgetSelected(evt);
				}
			});
			tabfldMain.setLayout(null);
			compMainInRightLayout.makeColumnsEqualWidth = true;
			compMainInRightLayout.verticalSpacing = 0;
			compMainInRightLayout.marginHeight = 0;
			compMainInRight.layout();
			sashMainVertical.setLayout(null);
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
			menuMain = new Menu(getShell(),SWT.BAR);
			mitFile = new MenuItem(menuMain,SWT.CASCADE);
			mitEdit = new MenuItem(menuMain,SWT.CASCADE);
			mitHelp = new MenuItem(menuMain,SWT.CASCADE);
	
			getShell().setMenuBar(menuMain);
	
			mitFile.setText(Messages.getString("EngUIMainFrame.20")); //$NON-NLS-1$
	
			mitEdit.setText(Messages.getString("EngUIMainFrame.21")); //$NON-NLS-1$
	
			mitHelp.setEnabled(true);
			mitHelp.setText(Messages.getString("EngUIMainFrame.22")); //$NON-NLS-1$
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
	
	
	 
	 //init user permissions
	 EngBLPermissions.init();
	 
	 
	 //Add popup menu to add favorites
     popupTreeAddFavorites = new Menu(getShell(),SWT.POP_UP);
     final MenuItem item = new MenuItem (popupTreeAddFavorites, SWT.PUSH);
	 item.setText(Messages.getString("EngUIMainFrame.27")); //$NON-NLS-1$
     
     //Add popu menu to remove favorites
     popupTreeRemoveFavorites = new Menu(getShell(),SWT.POP_UP);
   	 final MenuItem itemRemove = new MenuItem (popupTreeRemoveFavorites, SWT.PUSH);
	 itemRemove.setText (Messages.getString("EngUIMainFrame.28")); //$NON-NLS-1$
	 
	
	 item.addListener(SWT.Selection, new Listener () {
				public void handleEvent (Event e) {					
					if(item.getData()!=null){
					
						TreeItem selectedItem = (TreeItem)item.getData();
						TreeItem favoriteItem = new TreeItem(treeFavorites,SWT.NULL);
						favoriteItem.setText(selectedItem.getText());
						favoriteItem.setData(selectedItem.getData());						
						
						
					}
					
									
				}
	   });
	 itemRemove.addListener (SWT.Selection, new Listener () {
		public void handleEvent (Event e) {					
			if(itemRemove.getData()!=null){
			
				TreeItem selectedItem = (TreeItem)itemRemove.getData();
				selectedItem.dispose();
				System.out.println("disposed"); //$NON-NLS-1$
						
			}
										
		}
});
     
     
     
     popupTreeAddFavorites.addListener (SWT.Show, new Listener () {
		public void handleEvent (Event event) {
		
			StackLayout stackLayout = (StackLayout)compModulesTree.getLayout();
			Tree topTree = (Tree)stackLayout.topControl;
			if(topTree.getSelection().length>0){
				TreeItem selectedItem = topTree.getSelection()[0];
				if(selectedItem.getItemCount()>0){
					//if it has childeren then do not show menu	
 					event.doit=false;
 					popupTreeAddFavorites.setVisible(false);
 					item.setData(null);
				}
				else{
					event.doit =true;
					item.setData(selectedItem);
				}
			}
			else {
				item.setData(null);
				
			}
			
			
		
		}
	});
	
	 popupTreeRemoveFavorites.addListener (SWT.Show, new Listener () {
		public void handleEvent (Event event) {
		
				TreeItem selectedItem = treeFavorites.getSelection()[0];
				if(selectedItem.getItemCount()>0){
					//if it has childeren then do not show menu	
 					event.doit=false;
 					popupTreeAddFavorites.setVisible(false);
 					itemRemove.setData(null);
 					
				}
				else{
					event.doit =true;
					itemRemove.setData(selectedItem);
				    System.out.println("show"); //$NON-NLS-1$
				}
			
		}
	});
     
     
     
	 
	 
	 
	 
		
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		StackLayout compo4layout =(StackLayout)compModulesTree.getLayout();
		compo4layout.topControl = treeAccounting;
		sashMainHorizontal.setWeights(new int[]{25,75});
	    
	    comboModuleSelection.add(Messages.getString("EngUIMainFrame.31")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.32")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.33")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.34")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.35")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.1")); //$NON-NLS-1$
		comboModuleSelection.add(Messages.getString("EngUIMainFrame.4"));	 //$NON-NLS-1$
		tabfldMain.setTabHeight(20);
		tabfldMain.setSelectionBackground(new Color[]{Display.getDefault().getSystemColor(SWT.COLOR_WHITE)},
														   new int[]{});
		toolNew.setEnabled(false);
		toolSave.setEnabled(false);
		toolDelete.setEnabled(false);
		toolSearch.setEnabled(false);
		toolExportToExcel.setEnabled(false);
		
		
		//Create Trees 		
	    treeInventory=TreeFactory.createInventoryTree(treeInventory);
		treeBank=TreeFactory.createBankTree(treeBank);
		treeAccounting = TreeFactory.createAccountingTree(treeAccounting);
		treeCurrent = TreeFactory.createCurrentTree(treeCurrent);
		treeAdmin =TreeFactory.createAdminTree(treeAdmin);		
		treeConsignment = TreeFactory.createConsignmetTree(treeConsignment);
		treeBill = TreeFactory.createBillTree(treeBill);
		
		
		addKeyEventAccounting(treeAccounting);
		addKeyEventInventory(treeInventory);
		addKeyEventBank(treeBank);
		addKeyEventCurrent(treeCurrent);
		addKeyEventAdmin(treeAdmin);
		addKeyEventConsignment(treeConsignment);
		addKeyEventBill(treeBill);
		fillFavoritesTree();
		
		
				
		
		
		
		
		
		//SET POP UP Menus for trees
			
		treeAccounting.setMenu(popupTreeAddFavorites);
		treeAdmin.setMenu(popupTreeAddFavorites);
		treeBank.setMenu(popupTreeAddFavorites);
		treeInventory.setMenu(popupTreeAddFavorites);
		treeConsignment.setMenu(popupTreeAddFavorites);
		treeCurrent.setMenu(popupTreeAddFavorites);
		treeFavorites.setMenu(popupTreeRemoveFavorites);
		
		
		
		
		
		
														   
		
	}
	
	public void addKeyEventInventory(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeInventoryMouseDoubleClick();
					
			}
		});
		
	}
	
	public void addKeyEventBank(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeBankMouseDoubleClick();
					
			}
		});
		
	}
	
	
	public void addKeyEventAccounting(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeAccountingMouseDoubleClick();
					
			}
		});
		
	}
	
	
	public void addKeyEventCurrent(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeCurrentMouseDoubleClick();
					
			}
		});
		
	}
	
	
	public void addKeyEventAdmin(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeAdminMouseDoubleClick();
					
			}
		});
		
	}
	
	
	public void addKeyEventConsignment(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeConsignmentMouseDoubleClick();
					
			}
		});
		
	}
	
	
	public void addKeyEventBill(Tree tree)
	{
		tree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {				
				if (evt.keyCode==SWT.CR)
					treeBillMouseDoubleClick();
					
			}
		});
		
	}
	public void fillFavoritesTree(){
	
	
	EngBLXmlParser xmlParser = new EngBLXmlParser("favorites.xml"); //$NON-NLS-1$
	
	Map treeInfo = xmlParser.createMap();
	
	Iterator it = treeInfo.keySet().iterator();
	
	String text =""; //$NON-NLS-1$
	String className =""; //$NON-NLS-1$
	TreeItem treeItem;
	while(it.hasNext()){
		text = it.next().toString();
		className = treeInfo.get(text).toString();		
		treeItem = new TreeItem(treeFavorites,SWT.NULL);
		treeItem.setText(text);
		treeItem.setData(className);
		
	}
		
	
	}
	

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI2(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			EngUIMainFrame inst = new EngUIMainFrame(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,800,580);
			shell.setImage(SWTResourceManager.getImage("icons/turquaz_paw.gif")); //$NON-NLS-1$
			shell.setText("Turquaz"); //$NON-NLS-1$
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.addListener(SWT.Close, new Listener() {
		public void handleEvent(Event e) {
			
			saveFavoritesTree();
			saveProperties();
			if(EngConfiguration.getString("serverAddress").equals("localhost")){
			EngDALConnection connection = new EngDALConnection();
			try{
			connection.connect();
			connection.execQuery("SHUTDOWN");
			}
			catch(Exception ex){
			    ex.printStackTrace();
			}
			}
		}
	});
			shell.open();		
			
			while (!shell.isDisposed()){
				
				if (!display.readAndDispatch())
					display.sleep();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Auto-generated event handler method */
	
	/** Auto-generated event handler method */
	protected void comboModuleSelectionWidgetSelected(SelectionEvent evt){
		
		String text = comboModuleSelection.getItem(comboModuleSelection.getSelectionIndex());
		StackLayout compo4layout =(StackLayout)compModulesTree.getLayout();
	
			   if(text.equals(Messages.getString("EngUIMainFrame.31"))) //$NON-NLS-1$
			   {
				compo4layout.topControl = treeInventory;
		
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.34"))){ //$NON-NLS-1$
				compo4layout.topControl = treeAdmin;
	
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.32"))) //$NON-NLS-1$
			   {
			   	compo4layout.topControl = treeAccounting;
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.33"))){ //$NON-NLS-1$
			   	compo4layout.topControl = treeBank;
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.35"))){ //$NON-NLS-1$
			   	compo4layout.topControl = treeCurrent;
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.1"))){ //$NON-NLS-1$
			 	compo4layout.topControl = treeConsignment;
			   }
			   else if(text.equals(Messages.getString("EngUIMainFrame.4"))){ //$NON-NLS-1$
			 	compo4layout.topControl = treeBill;
			   }
			   
			   compModulesTree.layout();
	}

   

	
	public static void openNewTab (String Name, String classname){
		
				if (mapList.containsKey(classname))
				{
					//if the tab is already open
					tabfldMain.setSelection((CTabItem)mapList.get(classname));
				}
				else
				{	
				CTabItem yeni = new CTabItem (tabfldMain,SWT.NULL );
				yeni.setText(Name);
			    try{
			    
				Class c = Class.forName(classname);
				Composite comp =(Composite)c.getConstructor(new Class[]{Composite.class, int.class})
				.newInstance(new Object[]{tabfldMain,Integer.valueOf(SWT.NULL+"")}); //$NON-NLS-1$
				yeni.setControl(comp);
				tabfldMain.setSelection(yeni);
				arrangeIcons();
				
				// put into the tab hashmap 
				mapList.put(classname,yeni);
			    }
			    catch(Exception ex){
			    	ex.printStackTrace();
			    }
				}
				
				//Button tus = new Button(tabfldMain,1);
				//Form.setParent(tabfldMain); 
			 
				
					
	}
	public void openNewTab(TreeItem item){
		// if the class name is set
		
		if(item.getData()!=null){
		openNewTab(item.getText(),item.getData().toString());	
		
		}
		
	}
	
   /** Auto-generated event handler method */
	protected void EngUIMainFramePaintControl(PaintEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	
	private static void arrangeIcons(){
		try{
		   if(tabfldMain.getSelection().getControl() instanceof SecureComposite){
		    
		   SecureComposite c = (SecureComposite)tabfldMain.getSelection().getControl();
		   int level =EngBLPermissions.getPermission(c.getClass().getName());
		 			System.out.println(level);
					if(level==3)
					{
						toolNew.setEnabled(true);
						toolSave.setEnabled(true);
						toolDelete.setEnabled(true);
						toolSearch.setEnabled(true);
					}
					else if (level==2){
						toolNew.setEnabled(true);
						toolSave.setEnabled(true);
						toolDelete.setEnabled(false);
						toolSearch.setEnabled(true);
					}
					else if(level==1){
						toolNew.setEnabled(true);
						toolSave.setEnabled(false);
						toolDelete.setEnabled(false);
						toolSearch.setEnabled(true);
					}
					else 
					{
						toolNew.setEnabled(false);
						toolSave.setEnabled(false);
						toolDelete.setEnabled(false);
						toolSearch.setEnabled(false);
				
					}
		    }
		 else{
		 	toolNew.setEnabled(false);
			toolSave.setEnabled(false);
			toolDelete.setEnabled(false);
			toolSearch.setEnabled(false);  
		}
		if(tabfldMain.getSelection().getControl() instanceof SearchComposite){
			
			toolExportToExcel.setEnabled(true);
			
			
		}
		else{
			toolExportToExcel.setEnabled(false);
		}
				
	}
	catch(ClassCastException ex){
		toolNew.setEnabled(false);
		toolSave.setEnabled(false);
		toolDelete.setEnabled(false);
		toolSearch.setEnabled(false);
		toolExportToExcel.setEnabled(false);
	}
	catch(Exception ex)
				{
					toolNew.setEnabled(false);
					toolSave.setEnabled(false);
					toolDelete.setEnabled(false);
					toolSearch.setEnabled(false);
					toolExportToExcel.setEnabled(false);
					ex.printStackTrace();
				}
		
		
	}
	
	protected void tabfldMainWidgetSelected(SelectionEvent evt){
	
		arrangeIcons();
	}

	/** Auto-generated event handler method */
	protected void tabfldMainWidgetDefaultSelected(SelectionEvent evt){
		arrangeIcons();
	}

	

	/** Auto-generated event handler method */
	protected void treeInventoryMouseDoubleClick(){
		TreeItem item = treeInventory.getSelection()[0];
		
		if(item.getItemCount()==0){
			openNewTab(item);
		}			
		
		
	}
	
	/** Auto-generated event handler method */
	protected void treeAdminMouseDoubleClick(){
		TreeItem item = treeAdmin.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
			}
	}

	/** Auto-generated event handler method */
	protected void tabfldMainItemClosed(CTabFolderEvent evt){
		if(tabfldMain.getItemCount()==1){
			toolNew.setEnabled(false);
			toolSave.setEnabled(false);
			toolDelete.setEnabled(false);
			toolSearch.setEnabled(false);
			toolExportToExcel.setEnabled(false);
		}
		mapList.remove(((CTabItem)evt.item).getControl().getClass().getName());
		
		//System.out.println(evt.getSource());
	}

	
	

	/** Auto-generated event handler method */
	protected void toolNewWidgetSelected(SelectionEvent evt){
		Composite c = (Composite)tabfldMain.getSelection().getControl();
		if(c instanceof SecureComposite){
		((SecureComposite)c).newForm();
		}
	}

	/** Auto-generated event handler method */
	protected void toolSaveWidgetSelected(SelectionEvent evt){
		Composite c = (Composite)tabfldMain.getSelection().getControl();
		if(c instanceof SecureComposite){
		((SecureComposite)c).save();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		Composite c = (Composite)tabfldMain.getSelection().getControl();
		if(c instanceof SecureComposite){
		((SecureComposite)c).delete();
		}
	}

	/** Auto-generated event handler method */
	protected void toolSearchWidgetSelected(SelectionEvent evt){
		Composite c = (Composite)tabfldMain.getSelection().getControl();
		if(c instanceof SecureComposite){
		((SecureComposite)c).search();
		}
	}



	/** Auto-generated event handler method */
	protected void treeAccountingMouseDoubleClick(){
			TreeItem item = treeAccounting.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	



	/** Auto-generated event handler method */
	protected void treeBankMouseDoubleClick(){
		TreeItem item = treeBank.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}
	
	protected void treeBillMouseDoubleClick(){
		TreeItem item = treeBill.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeConsignmentMouseDoubleClick(){
		TreeItem item = treeConsignment.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}


	/** Auto-generated event handler method */
	protected void treeFavoritesMouseDoubleClick(){
		TreeItem item = treeFavorites.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}

	/** Auto-generated event handler method */
	protected void treeCurrentMouseDoubleClick(){
		TreeItem item = treeCurrent.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item);
		}
	}

	//Save Options of the user...
	public static void saveProperties(){
	    try{
			FileInputStream input = new FileInputStream("config/turquaz.properties"); //$NON-NLS-1$
		    Properties props = new Properties();
		    props.load(input);
		    input.close();
		    
		   // props.put("logo","dfaf");
		   props.put("logoURL",EngConfiguration.logoURL);
		    
		    FileOutputStream output = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
		    props.save(output,"Turquaz Configuration"); //$NON-NLS-1$
		    
		    output.flush();
		    output.close();
		    
		    
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
	    
	    
	    
	}
	//save favorite items to the 
	public static void saveFavoritesTree(){
		try{
		
		XMLOutputter outputter = new XMLOutputter();
		  
		OutputStream output = null;
        
          output = new FileOutputStream("favorites.xml"); //$NON-NLS-1$
          
          TreeItem items[] = treeFavorites.getItems();
          
          Element root = new Element("tree");         //$NON-NLS-1$
         
      
         Element treeItem;
          for(int i=0;i<items.length;i++){
         
          	treeItem = new Element("treeitem"); //$NON-NLS-1$
          	treeItem.setAttribute("text",items[i].getText()); //$NON-NLS-1$
          	treeItem.setAttribute("class",items[i].getData().toString()); //$NON-NLS-1$
            root.addContent(treeItem);            
          
          }
          outputter.output(root,output);
          
          
		 }
		 catch(Exception ex){
		  ex.printStackTrace();
		 }
		 finally{
		
		 
		 }
		
	}

	/** Auto-generated event handler method */
	protected void rootWidgetDisposed(DisposeEvent evt){
		this.dispose();
	}
	protected void exportToExcel(){
		SearchComposite sc = (SearchComposite)tabfldMain.getSelection().getControl();
		sc.exportToExcel();
		
	}
	
	
}
