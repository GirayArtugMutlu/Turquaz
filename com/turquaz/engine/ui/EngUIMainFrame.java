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


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Savepoint;
import java.util.Iterator;
import java.util.Map;

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

import org.eclipse.swt.custom.CTabFolderAdapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;

import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;

import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLXmlParser;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.component.TreeFactory;
import com.turquaz.engine.ui.component.TurqShell;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.comp.InvUITree;
import com.turquaz.admin.ui.comp.AdmUITree;
import com.turquaz.accounting.ui.comp.AccUITree;
import com.turquaz.bank.ui.comp.BankUITree;
import com.turquaz.current.ui.comp.CurUITree;
import com.turquaz.inventory.ui.InvUITransactionAdd;

/**
* @author  Onsel Armagan
* @version  $Id$
*/
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/










public class EngUIMainFrame extends org.eclipse.swt.widgets.Composite {
	private Tree treeCurrent;
	private Label label1;
	private Composite composite1;
	private Composite compModulesHelp;
	private Tree treeBank;
	private Tree treeAccounting;
	private CTabFolder tabfldMain;
	private ToolItem toolSearch;
	private ToolItem toolDelete;
	private ToolItem toolSave;
	private ToolItem toolNew;
	private ToolBar toolbarMainTop;
	private CoolItem coolRightMain;
	private CoolBar coolbarRightTop;
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
	private Composite compModulesTab;
	private CTabItem tabModules;
	private CTabFolder tabfldMenu;
	private SashForm sashMainHorizontal;
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
			sashMainHorizontal = new SashForm(sashMainVertical,SWT.NULL);
			tabfldMenu = new CTabFolder(sashMainHorizontal,SWT.TOP| SWT.BORDER);
			tabModules = new CTabItem(tabfldMenu,SWT.NULL);
			compModulesTab = new Composite(tabfldMenu,SWT.NULL);
			compModuleSelection = new Composite(compModulesTab,SWT.BORDER);
			lblModuleSelection = new CLabel(compModuleSelection,SWT.LEFT);
			comboModuleSelection = new CCombo(compModuleSelection,SWT.FLAT| SWT.READ_ONLY| SWT.H_SCROLL| SWT.V_SCROLL);
			compModulesTree = new Composite(compModulesTab,SWT.NULL);
			treeBank = new Tree(compModulesTree,SWT.NULL);
			treeInventory = new Tree(compModulesTree,SWT.NULL);
			treeAccounting = new Tree(compModulesTree,SWT.NULL);
			treeAdmin = new Tree(compModulesTree,SWT.NULL);
			treeCurrent = new Tree(compModulesTree,SWT.NULL);
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
			coolbarRightTop = new CoolBar(compMainInRight,SWT.NULL);
			coolRightMain = new CoolItem(coolbarRightTop,SWT.NULL);
			toolbarMainTop = new ToolBar(coolbarRightTop,SWT.FLAT);
			toolNew = new ToolItem(toolbarMainTop,SWT.PUSH);
			toolSave = new ToolItem(toolbarMainTop,SWT.PUSH);
			toolDelete = new ToolItem(toolbarMainTop,SWT.PUSH);
			toolSearch = new ToolItem(toolbarMainTop,SWT.PUSH);
			tabfldMain = new CTabFolder(compMainInRight,SWT.BORDER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(800,600));
			this.addPaintListener( new PaintListener() {
				public void paintControl(PaintEvent evt) {
					EngUIMainFramePaintControl(evt);
				}
			});
	
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
			lblSeperator.setText("label1");
	
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
			lblSeperatorLeft.setText("label2");
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
			tabModules.setText("Modules");
	
			compModulesTab.setSize(new org.eclipse.swt.graphics.Point(386,549));
	
			GridData compModuleSelectionLData = new GridData();
			compModuleSelectionLData.verticalAlignment = GridData.CENTER;
			compModuleSelectionLData.horizontalAlignment = GridData.FILL;
			compModuleSelectionLData.widthHint = -1;
			compModuleSelectionLData.heightHint = 16;
			compModuleSelectionLData.horizontalIndent = 0;
			compModuleSelectionLData.horizontalSpan = 5;
			compModuleSelectionLData.verticalSpan = 1;
			compModuleSelectionLData.grabExcessHorizontalSpace = true;
			compModuleSelectionLData.grabExcessVerticalSpace = false;
			compModuleSelection.setLayoutData(compModuleSelectionLData);
			compModuleSelection.setSize(new org.eclipse.swt.graphics.Point(382,16));
	
			lblModuleSelection.setText("Active Module");
			lblModuleSelection.setSize(new org.eclipse.swt.graphics.Point(191,16));
			lblModuleSelection.setLayout(null);
	
			final Color comboModuleSelectionbackground = new Color(Display.getDefault(),236,233,216);
			comboModuleSelection.setBackground(comboModuleSelectionbackground);
			comboModuleSelection.setSize(new org.eclipse.swt.graphics.Point(169,16));
			comboModuleSelection.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					comboModuleSelectionWidgetSelected(evt);
				}
			});
			comboModuleSelection.addDisposeListener( new DisposeListener() {
				public void widgetDisposed(DisposeEvent evt) {
					comboModuleSelectionWidgetDisposed(evt);
				}
			});
			FillLayout compModuleSelectionLayout = new FillLayout(256);
			compModuleSelection.setLayout(compModuleSelectionLayout);
			compModuleSelectionLayout.type = SWT.HORIZONTAL;
			compModuleSelectionLayout.marginWidth = 0;
			compModuleSelectionLayout.marginHeight = 0;
			compModuleSelectionLayout.spacing = 0;
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
					treeBankMouseDoubleClick(evt);
				}
			});
	
			treeInventory.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeInventory.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeInventoryMouseDoubleClick(evt);
				}
			});
	
			treeAccounting.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeAccounting.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeAccountingMouseDoubleClick(evt);
				}
			});
	
			treeAdmin.setSize(new org.eclipse.swt.graphics.Point(370,251));
			treeAdmin.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeAdminMouseDoubleClick(evt);
				}
			});
	
			treeCurrent.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeCurrentMouseDoubleClick(evt);
				}
			});
			StackLayout compModulesTreeLayout = new StackLayout();
			compModulesTree.setLayout(compModulesTreeLayout);
			compModulesTreeLayout.marginWidth = 0;
			compModulesTreeLayout.marginHeight = 0;
			compModulesTreeLayout.topControl = null;
			compModulesTree.layout();
	
			GridData label1LData = new GridData();
			label1LData.verticalAlignment = GridData.CENTER;
			label1LData.horizontalAlignment = GridData.FILL;
			label1LData.widthHint = -1;
			label1LData.heightHint = -1;
			label1LData.horizontalIndent = 0;
			label1LData.horizontalSpan = 1;
			label1LData.verticalSpan = 1;
			label1LData.grabExcessHorizontalSpace = false;
			label1LData.grabExcessVerticalSpace = false;
			label1.setLayoutData(label1LData);
			label1.setText("label1");
	
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
			tabFavorites.setText("Favorites");
	
	
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
			lblFavoritesTab.setText("Favorite Items");
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
			treeFavoritesLData.widthHint = -1;
			treeFavoritesLData.heightHint = -1;
			treeFavoritesLData.horizontalIndent = 0;
			treeFavoritesLData.horizontalSpan = 1;
			treeFavoritesLData.verticalSpan = 1;
			treeFavoritesLData.grabExcessHorizontalSpace = false;
			treeFavoritesLData.grabExcessVerticalSpace = true;
			treeFavorites.setLayoutData(treeFavoritesLData);
			treeFavorites.setSize(new org.eclipse.swt.graphics.Point(370,509));
			treeFavorites.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					treeFavoritesMouseDoubleClick(evt);
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
	
			compMainInRight.setSize(new org.eclipse.swt.graphics.Point(397,572));
			compMainInRight.setBounds(new org.eclipse.swt.graphics.Rectangle(395,0,397,572));
	
			GridData coolbarRightTopLData = new GridData();
			coolbarRightTopLData.verticalAlignment = GridData.CENTER;
			coolbarRightTopLData.horizontalAlignment = GridData.FILL;
			coolbarRightTopLData.widthHint = -1;
			coolbarRightTopLData.heightHint = 40;
			coolbarRightTopLData.horizontalIndent = 0;
			coolbarRightTopLData.horizontalSpan = 1;
			coolbarRightTopLData.verticalSpan = 1;
			coolbarRightTopLData.grabExcessHorizontalSpace = false;
			coolbarRightTopLData.grabExcessVerticalSpace = false;
			coolbarRightTop.setLayoutData(coolbarRightTopLData);
			coolbarRightTop.setSize(new org.eclipse.swt.graphics.Point(387,40));
	
			coolRightMain.setControl(toolbarMainTop);
			coolRightMain.setSize(new org.eclipse.swt.graphics.Point(127,36));
			coolRightMain.setPreferredSize(new org.eclipse.swt.graphics.Point(127,36));
			coolRightMain.setMinimumSize(new org.eclipse.swt.graphics.Point(127,36));
			coolRightMain.setText("coolItem3");
	
			toolbarMainTop.setLocation(new org.eclipse.swt.graphics.Point(20,0));
	
			toolNew.setEnabled(true);
			toolNew.setText("&Yeni");
			toolNew.setToolTipText("New");
			final org.eclipse.swt.graphics.Image toolNewimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/new_wiz.gif"));
			toolNew.setImage(toolNewimage);
			toolNew.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolNewWidgetSelected(evt);
				}
			});
	
			toolSave.setText("&Kaydet");
			toolSave.setToolTipText("Save");
			final org.eclipse.swt.graphics.Image toolSaveimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save.gif"));
			toolSave.setImage(toolSaveimage);
			toolSave.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolSaveWidgetSelected(evt);
				}
			});
	
			toolDelete.setText("&Sil");
			toolDelete.setToolTipText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteimage);
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			toolSearch.setText("&Ara");
			toolSearch.setToolTipText("Search");
			final org.eclipse.swt.graphics.Image toolSearchimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/run_exec.gif"));
			toolSearch.setImage(toolSearchimage);
			toolSearch.setSelection(true);
			toolSearch.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolSearchWidgetSelected(evt);
				}
			});
			toolbarMainTop.setLayout(null);
			coolbarRightTop.setLayout(null);
	
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
			tabfldMain.addCTabFolderListener( new CTabFolderAdapter() {
				public void itemClosed(CTabFolderEvent evt) {
					tabfldMainItemClosed(evt);
				}
			});
			tabfldMain.addSelectionListener( new SelectionAdapter() {
				public void widgetDefaultSelected(SelectionEvent evt) {
					tabfldMainWidgetDefaultSelected(evt);
				}
				public void widgetSelected(SelectionEvent evt) {
					tabfldMainWidgetSelected(evt);
				}
			});
			tabfldMain.setLayout(null);
			GridLayout compMainInRightLayout = new GridLayout(1, true);
			compMainInRight.setLayout(compMainInRightLayout);
			compMainInRightLayout.marginWidth = 5;
			compMainInRightLayout.marginHeight = 5;
			compMainInRightLayout.numColumns = 1;
			compMainInRightLayout.makeColumnsEqualWidth = true;
			compMainInRightLayout.horizontalSpacing = 5;
			compMainInRightLayout.verticalSpacing = 5;
			compMainInRight.layout();
			sashMainHorizontal.setLayout(null);
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
	
			mitFile.setText("&File");
	
			mitEdit.setText("&Edit");
	
			mitHelp.setEnabled(true);
			mitHelp.setText("&Help");
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					comboModuleSelectionbackground.dispose();
					toolNewimage.dispose();
					toolSaveimage.dispose();
					toolDeleteimage.dispose();
					toolSearchimage.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
		
	 //Set System variables
	 System.setProperty("company","0");
	 System.setProperty("user","admin");
	 
	 //init user permissions
	 EngBLPermissions.init();
	 
	 
	 //Add popup menu to add favorites
     popupTreeAddFavorites = new Menu(getShell(),SWT.POP_UP);
     final MenuItem item = new MenuItem (popupTreeAddFavorites, SWT.PUSH);
	 item.setText("Add to Favorites");
     
     //Add popu menu to remove favorites
     popupTreeRemoveFavorites = new Menu(getShell(),SWT.POP_UP);
   	 final MenuItem itemRemove = new MenuItem (popupTreeRemoveFavorites, SWT.PUSH);
	 itemRemove.setText ("Remove from Favorites");
	 
	
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
				System.out.println("disposed");
						
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
				    System.out.println("show");
				}
			
		}
	});
     
     
     
	 
	 
	 
	 
		
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		StackLayout compo4layout =(StackLayout)compModulesTree.getLayout();
		compo4layout.topControl = treeInventory;
		sashMainHorizontal.setWeights(new int[]{25,75});
	    
	    comboModuleSelection.add("Inventory");
		comboModuleSelection.add("Accounting");
		comboModuleSelection.add("Bank");
		comboModuleSelection.add("Administrator");
		comboModuleSelection.add("Current");
		
			
		tabfldMain.setTabHeight(25);
		tabfldMain.setSelectionBackground(new Color[]{Display.getDefault().getSystemColor(SWT.COLOR_WHITE)},
														   new int[]{});
		toolNew.setEnabled(false);
		toolSave.setEnabled(false);
		toolDelete.setEnabled(false);
		toolSearch.setEnabled(false);
		
		
		
		//Create Trees 		
	    treeInventory=TreeFactory.createInventoryTree(treeInventory);
		treeBank=TreeFactory.createBankTree(treeBank);
		treeAccounting = TreeFactory.createAccountingTree(treeAccounting);
		treeCurrent = TreeFactory.createCurrentTree(treeCurrent);
		treeAdmin =TreeFactory.createAdminTree(treeAdmin);		
		fillFavoritesTree();
				
		
		
		
		
		
		//SET POP UP Menus for trees
			
		treeAccounting.setMenu(popupTreeAddFavorites);
		treeAdmin.setMenu(popupTreeAddFavorites);
		treeBank.setMenu(popupTreeAddFavorites);
		treeInventory.setMenu(popupTreeAddFavorites);
		treeCurrent.setMenu(popupTreeAddFavorites);
		treeFavorites.setMenu(popupTreeRemoveFavorites);
		
		
		
														   
		
	}
	
	
	public void fillFavoritesTree(){
	
	
	EngBLXmlParser xmlParser = new EngBLXmlParser("favorites.xml");
	
	Map treeInfo = xmlParser.createMap();
	
	Iterator it = treeInfo.keySet().iterator();
	
	String text ="";
	String className ="";
	TreeItem treeItem;
	while(it.hasNext()){
		text = it.next().toString();
		className = treeInfo.get(text).toString();		
		treeItem = new TreeItem(treeFavorites,SWT.NULL);
		treeItem.setText(text);
		treeItem.setData(className);
		
	}
		
	
	}
	

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI2();
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
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.addListener(SWT.Close, new Listener() {
		public void handleEvent(Event e) {
			saveFavoritesTree();
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
	
			   if(text.equals("Inventory"))
			   {
				compo4layout.topControl = treeInventory;
		
			   }
			   else if(text.equals("Administrator")){
				compo4layout.topControl = treeAdmin;
	
			   }
			   else if(text.equals("Accounting"))
			   {
			   	compo4layout.topControl = treeAccounting;
			   }
			   else if(text.equals("Bank")){
			   	compo4layout.topControl = treeBank;
			   }
			   else if(text.equals("Current")){
			   	compo4layout.topControl = treeCurrent;
			   }
			   
			   compModulesTree.layout();
	}

   

	
	public void openNewTab (String Name, String classname){
		
				CTabItem yeni = new CTabItem (tabfldMain,SWT.NULL );
				yeni.setText(Name);
			    try{
			    
				Class c = Class.forName(classname);
				Composite comp =(Composite)c.getConstructor(new Class[]{Composite.class, int.class})
				.newInstance(new Object[]{tabfldMain,Integer.valueOf(SWT.NULL+"")});
				yeni.setControl(comp);
				tabfldMain.setSelection(yeni);
				arrangeIcons();
			    }
			    catch(Exception ex){
			    	ex.printStackTrace();
			    }
				
				//Button tus = new Button(tabfldMain,1);
				//Form.setParent(tabfldMain); 
			 
				
					
	}
	

	/** Auto-generated event handler method */
	protected void cTabFolder3ItemClosed(CTabFolderEvent evt){
		 if(tabfldMain.getItemCount()==1){
			toolNew.setEnabled(false);
			toolSave.setEnabled(false);
			toolDelete.setEnabled(false);
			toolSearch.setEnabled(false);
		 	
		 }
	}

	/** Auto-generated event handler method */
	protected void EngUIMainFramePaintControl(PaintEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	
	private void arrangeIcons(){
		Composite c = (Composite)tabfldMain.getSelection().getControl();
				if(c instanceof SecureComposite){
					int level = ((SecureComposite)c ).getPermission(c.getClass().getName());
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
				else
				{
					toolNew.setEnabled(false);
					toolSave.setEnabled(false);
					toolDelete.setEnabled(false);
					toolSearch.setEnabled(false);
				
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
	protected void comboModuleSelectionWidgetDisposed(DisposeEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void treeInventoryMouseDoubleClick(MouseEvent evt){
		TreeItem item = treeInventory.getSelection()[0];
		
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
		}
				
		
		
		
	}

	/** Auto-generated event handler method */
	protected void treeAdminMouseDoubleClick(MouseEvent evt){
		TreeItem item = treeAdmin.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
			}
	}

	/** Auto-generated event handler method */
	protected void tabfldMainItemClosed(CTabFolderEvent evt){
		if(tabfldMain.getItemCount()==1){
			toolNew.setEnabled(false);
			toolSave.setEnabled(false);
			toolDelete.setEnabled(false);
			toolSearch.setEnabled(false);
		}
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

	/**
	* This is an auto-generated method which you can alter,
	* e.g. to point to a different property file, to modify the key by
	* by prefixing the name of this class, etc.
	*
	* By default, it expects a file called "messages.properties" to exist in the
	* current package, and returns the value of the property defined
	* in that file for the given key
	*/
	public String getExternalizedString(String key){
		try {
			return java.util.ResourceBundle.getBundle("com.turquaz.engine.ui.EngUIMainFrameMessages").getString(key);
		} catch (java.util.MissingResourceException e) {
			return '!' + key + '!';
		}
	}

	/** Auto-generated event handler method */
	

	/** Auto-generated event handler method */
	

	/** Auto-generated event handler method */
	protected void treeAccountingMouseDoubleClick(MouseEvent evt){
			TreeItem item = treeAccounting.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
			}
	}

	/** Auto-generated event handler method */
	



	/** Auto-generated event handler method */
	protected void treeBankMouseDoubleClick(MouseEvent evt){
		TreeItem item = treeBank.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
		}
	}

	/** Auto-generated event handler method */
	protected void treeBankMouseDown(MouseEvent evt){
		
		
		
	}

	/** Auto-generated event handler method */
	protected void treeFavoritesMouseDoubleClick(MouseEvent evt){
		TreeItem item = treeFavorites.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
		}
	}

	/** Auto-generated event handler method */
	protected void treeCurrentMouseDoubleClick(MouseEvent evt){
		TreeItem item = treeCurrent.getSelection()[0];
		if(item.getItemCount()==0){
			openNewTab(item.getText(),item.getData().toString());
		}
	}

	
	//save favorite items to the 
	public static void saveFavoritesTree(){
		try{
		System.out.println("ssgsfg");
		  OutputStream output = null;
          PrintStream out = null;
          output = new FileOutputStream("favorites.xml");
          out = new PrintStream(output);
          TreeItem items[] = treeFavorites.getItems();
          out.println("<tree>");
          for(int i=0;i<items.length;i++){
          out.println("<treeitem text=\""+items[i].getText()+"\" class=\""+items[i].getData().toString()+"\"  >");
           
           out.println("</treeitem>");
          
          }
          out.println("</tree>");
          
          
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
}
