package com.turquaz.engine.ui;

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
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;

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
	private MenuItem helpContMenuItem;
	private Menu menu20;
	private MenuItem copyMenuItem;
	private MenuItem pasteMenuItem;
	private MenuItem cutMenuItem;
	private MenuItem separator1;
	private MenuItem redoMenuItem;
	private MenuItem undoMenuItem;
	private Menu menu15;
	private MenuItem editMenuItem;
	private MenuItem saveMenuItem;
	private MenuItem closeMenuItem;
	private MenuItem separator11;
	private MenuItem packageItem;
	private MenuItem menuItem5;
	private MenuItem projectItem;
	private Menu menu5;
	private MenuItem newMenuItem;
	private Menu menu3;
	private CTabItem cTabItem3;
	private Composite composite3;
	private CTabItem cTabItem2;
	private Composite composite2;
	private CTabItem cTabItem1;
	private CTabFolder cTabFolder3;
	private Tree tree3;
	private ToolItem toolItem4;
	private ToolItem toolItem3;
	private ToolBar toolBar5;
	private CLabel cLabel4;
	private Composite composite9;
	private Composite composite7;
	private CTabItem cTabItem4;
	private Group stokTree1;
	private TreeItem treeItem14;
	private TreeItem treeItem13;
	private TreeItem treeItem12;
	private TreeItem treeItem11;
	private TreeItem treeItem10;
	private TreeItem treeItem9;
	private TreeItem treeItem8;
	private TreeItem treeItem6;
	private TreeItem treeItem15;
	private TreeItem treeItem5;
	private Tree tree4;
	private Composite composite4;
	private CCombo cCombo1;
	private CLabel cLabel5;
	private Composite composite11;
	private Composite composite10;
	private CTabItem cTabItem5;
	private CTabFolder cTabFolder2;
	private SashForm sashForm3;
	private SashForm sashForm2;
	private Composite composite6;
	private Label label2;
	private Composite composite8;
	private ToolItem toolItem12;
	private ToolItem toolItem11;
	private ToolItem toolItem10;
	private ToolItem runToolItem;
	private ToolItem debugToolItem;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private ToolItem toolItem9;
	private ToolItem toolItem7;
	private ToolItem toolItem2;
	private ToolItem toolItem1;
	private ToolItem toolItem13;
	private ToolItem separator3;
	private ToolItem toolItem8;
	private ToolItem toolItem5;
	private ToolItem toolItem6;
	private ToolItem newToolItem;
	private ToolBar toolBar2;
	private CoolItem coolItem3;
	private CoolBar coolBar1;
	private Composite composite1;
	private Label label1;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Menu fileMenu;
	private MenuItem fileMenuItem;
	private Menu menu1;

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
	
			label1 = new Label(this,SWT.SEPARATOR| SWT.HORIZONTAL);
			composite1 = new Composite(this,SWT.NULL);
			coolBar1 = new CoolBar(composite1,SWT.NULL);
			coolItem3 = new CoolItem(coolBar1,SWT.DROP_DOWN);
			toolBar2 = new ToolBar(coolBar1,SWT.FLAT);
			newToolItem = new ToolItem(toolBar2,SWT.DROP_DOWN);
			toolItem6 = new ToolItem(toolBar2,SWT.NULL);
			toolItem5 = new ToolItem(toolBar2,SWT.NULL);
			toolItem8 = new ToolItem(toolBar2,SWT.NULL);
			separator3 = new ToolItem(toolBar2,SWT.SEPARATOR);
			toolItem13 = new ToolItem(toolBar2,SWT.NULL);
			toolItem1 = new ToolItem(toolBar2,SWT.NULL);
			toolItem2 = new ToolItem(toolBar2,SWT.NULL);
			toolItem7 = new ToolItem(toolBar2,SWT.NULL);
			toolItem9 = new ToolItem(toolBar2,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.DROP_DOWN);
			toolBar1 = new ToolBar(coolBar1,SWT.FLAT);
			debugToolItem = new ToolItem(toolBar1,SWT.DROP_DOWN);
			runToolItem = new ToolItem(toolBar1,SWT.DROP_DOWN);
			toolItem10 = new ToolItem(toolBar1,SWT.NULL);
			toolItem11 = new ToolItem(toolBar1,SWT.NULL);
			toolItem12 = new ToolItem(toolBar1,SWT.NULL);
			composite8 = new Composite(this,SWT.NULL);
			label2 = new Label(composite8,SWT.SEPARATOR);
			composite6 = new Composite(composite8,SWT.NULL);
			sashForm2 = new SashForm(composite6,SWT.NULL);
			sashForm3 = new SashForm(sashForm2,SWT.NULL);
			cTabFolder2 = new CTabFolder(sashForm3,SWT.TOP| SWT.BORDER);
			cTabItem5 = new CTabItem(cTabFolder2,SWT.NULL);
			composite10 = new Composite(cTabFolder2,SWT.NULL);
			composite11 = new Composite(composite10,SWT.NULL);
			cLabel5 = new CLabel(composite11,SWT.LEFT);
			cCombo1 = new CCombo(composite11,SWT.FLAT| SWT.READ_ONLY| SWT.H_SCROLL| SWT.V_SCROLL);
			composite4 = new Composite(composite10,SWT.NULL);
			tree4 = new Tree(composite4,SWT.NULL);
			treeItem5 = new TreeItem(tree4,SWT.NULL);
			treeItem15 = new TreeItem(treeItem5,SWT.NULL);
			treeItem6 = new TreeItem(tree4,SWT.NULL);
			treeItem8 = new TreeItem(tree4,SWT.NULL);
			treeItem9 = new TreeItem(tree4,SWT.NULL);
			treeItem10 = new TreeItem(tree4,SWT.NULL);
			treeItem11 = new TreeItem(tree4,SWT.NULL);
			treeItem12 = new TreeItem(tree4,SWT.NULL);
			treeItem13 = new TreeItem(tree4,SWT.NULL);
			treeItem14 = new TreeItem(tree4,SWT.NULL);
			stokTree1 = new Group(composite4,SWT.NULL);
			cTabItem4 = new CTabItem(cTabFolder2,SWT.NULL);
			composite7 = new Composite(cTabFolder2,SWT.NULL);
			composite9 = new Composite(composite7,SWT.NULL);
			cLabel4 = new CLabel(composite9,SWT.NULL);
			toolBar5 = new ToolBar(composite9,SWT.FLAT);
			toolItem3 = new ToolItem(toolBar5,SWT.NULL);
			toolItem4 = new ToolItem(toolBar5,SWT.NULL);
			tree3 = new Tree(composite7,SWT.NULL);
			cTabFolder3 = new CTabFolder(sashForm3,SWT.BORDER);
			cTabItem1 = new CTabItem(cTabFolder3,SWT.NULL);
			composite2 = new Composite(cTabFolder3,SWT.NULL);
			cTabItem2 = new CTabItem(cTabFolder3,SWT.NULL);
			composite3 = new Composite(cTabFolder3,SWT.NULL);
			cTabItem3 = new CTabItem(cTabFolder3,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(489,349));
			this.addPaintListener( new PaintListener() {
				public void paintControl(PaintEvent evt) {
					EngUIMainFramePaintControl(evt);
				}
			});
	
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
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 25;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(489,25));
	
			coolBar1.setSize(new org.eclipse.swt.graphics.Point(489,22));
	
			coolItem3.setControl(toolBar2);
			coolItem3.setSize(new org.eclipse.swt.graphics.Point(212,22));
			coolItem3.setMinimumSize(new org.eclipse.swt.graphics.Point(212,22));
			coolItem3.setPreferredSize(new org.eclipse.swt.graphics.Point(212,22));
			coolItem3.setText("coolItem3");
	
	
			final org.eclipse.swt.graphics.Image newToolItemýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/emptyBox.gif"));
			newToolItem.setImage(newToolItemýmage);
			newToolItem.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					newToolItemWidgetSelected(evt);
				}
			});
	
			final org.eclipse.swt.graphics.Image toolItem6ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/build_exec.gif"));
			toolItem6.setImage(toolItem6ýmage);
	
	
			toolItem8.setEnabled(true);
			final org.eclipse.swt.graphics.Image toolItem8ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/print_edit.gif"));
			toolItem8.setImage(toolItem8ýmage);
	
	
			final org.eclipse.swt.graphics.Image toolItem13ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save_edit.gif"));
			toolItem13.setImage(toolItem13ýmage);
	
			final org.eclipse.swt.graphics.Image toolItem1ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/resource_persp.gif"));
			toolItem1.setImage(toolItem1ýmage);
	
			final org.eclipse.swt.graphics.Image toolItem2ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/saveas_edit.gif"));
			toolItem2.setImage(toolItem2ýmage);
	
			toolItem7.setImage(toolItem13ýmage);
	
			final org.eclipse.swt.graphics.Image toolItem9ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/prop_ps.gif"));
			toolItem9.setImage(toolItem9ýmage);
			toolBar2.setLayout(null);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setSize(new org.eclipse.swt.graphics.Point(141,22));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(141,22));
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(141,22));
	
	
			final org.eclipse.swt.graphics.Image debugToolItemýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/new_persp.gif"));
			debugToolItem.setImage(debugToolItemýmage);
			debugToolItem.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					debugToolItemWidgetSelected(evt);
				}
			});
	
			final org.eclipse.swt.graphics.Image runToolItemýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save.gif"));
			runToolItem.setImage(runToolItemýmage);
			runToolItem.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					runToolItemWidgetSelected(evt);
				}
			});
	
			final org.eclipse.swt.graphics.Image toolItem10ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/run_exec.gif"));
			toolItem10.setImage(toolItem10ýmage);
	
			toolItem11.setImage(toolItem1ýmage);
	
			toolItem12.setImage(toolItem8ýmage);
			toolBar1.setLayout(null);
			coolBar1.setLayout(null);
			FillLayout composite1Layout = new FillLayout(256);
			composite1.setLayout(composite1Layout);
			composite1Layout.type = SWT.HORIZONTAL;
			composite1.layout();
	
			GridData composite8LData = new GridData();
			composite8LData.verticalAlignment = GridData.FILL;
			composite8LData.horizontalAlignment = GridData.FILL;
			composite8LData.widthHint = -1;
			composite8LData.heightHint = -1;
			composite8LData.horizontalIndent = 0;
			composite8LData.horizontalSpan = 1;
			composite8LData.verticalSpan = 1;
			composite8LData.grabExcessHorizontalSpace = false;
			composite8LData.grabExcessVerticalSpace = true;
			composite8.setLayoutData(composite8LData);
			composite8.setSize(new org.eclipse.swt.graphics.Point(489,302));
	
			GridData label2LData = new GridData();
			label2LData.verticalAlignment = GridData.FILL;
			label2LData.horizontalAlignment = GridData.BEGINNING;
			label2LData.widthHint = 2;
			label2LData.heightHint = -1;
			label2LData.horizontalIndent = 0;
			label2LData.horizontalSpan = 1;
			label2LData.verticalSpan = 1;
			label2LData.grabExcessHorizontalSpace = false;
			label2LData.grabExcessVerticalSpace = true;
			label2.setLayoutData(label2LData);
			label2.setText("label2");
			label2.setSize(new org.eclipse.swt.graphics.Point(2,302));
	
			GridData composite6LData = new GridData();
			composite6LData.verticalAlignment = GridData.FILL;
			composite6LData.horizontalAlignment = GridData.FILL;
			composite6LData.widthHint = -1;
			composite6LData.heightHint = -1;
			composite6LData.horizontalIndent = 0;
			composite6LData.horizontalSpan = 1;
			composite6LData.verticalSpan = 1;
			composite6LData.grabExcessHorizontalSpace = true;
			composite6LData.grabExcessVerticalSpace = true;
			composite6.setLayoutData(composite6LData);
	
			GridData sashForm2LData = new GridData();
			sashForm2LData.verticalAlignment = GridData.FILL;
			sashForm2LData.horizontalAlignment = GridData.FILL;
			sashForm2LData.widthHint = -1;
			sashForm2LData.heightHint = -1;
			sashForm2LData.horizontalIndent = 0;
			sashForm2LData.horizontalSpan = 1;
			sashForm2LData.verticalSpan = 1;
			sashForm2LData.grabExcessHorizontalSpace = true;
			sashForm2LData.grabExcessVerticalSpace = true;
			sashForm2.setLayoutData(sashForm2LData);
			sashForm2.setOrientation(SWT.VERTICAL);
			sashForm2.setSize(new org.eclipse.swt.graphics.Point(481,296));
	
			sashForm3.setSize(new org.eclipse.swt.graphics.Point(481,296));
			sashForm3.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,481,296));
	
			cTabFolder2.setSize(new org.eclipse.swt.graphics.Point(231,291));
			cTabFolder2.setBounds(new org.eclipse.swt.graphics.Rectangle(0,0,236,296));
	
			cTabItem5.setControl(composite10);
			cTabItem5.setText("Modüller");
	
			composite10.setSize(new org.eclipse.swt.graphics.Point(232,272));
	
			GridData composite11LData = new GridData();
			composite11LData.verticalAlignment = GridData.CENTER;
			composite11LData.horizontalAlignment = GridData.FILL;
			composite11LData.widthHint = -1;
			composite11LData.heightHint = 16;
			composite11LData.horizontalIndent = 0;
			composite11LData.horizontalSpan = 5;
			composite11LData.verticalSpan = 1;
			composite11LData.grabExcessHorizontalSpace = true;
			composite11LData.grabExcessVerticalSpace = false;
			composite11.setLayoutData(composite11LData);
			composite11.setSize(new org.eclipse.swt.graphics.Point(232,16));
	
			cLabel5.setText("Aktif Modul");
			cLabel5.setSize(new org.eclipse.swt.graphics.Point(116,16));
			cLabel5.setLayout(null);
	
			final Color cCombo1background = new Color(Display.getDefault(),236,233,216);
			cCombo1.setBackground(cCombo1background);
			cCombo1.setSize(new org.eclipse.swt.graphics.Point(94,16));
			cCombo1.addPaintListener( new PaintListener() {
				public void paintControl(PaintEvent evt) {
					cCombo1PaintControl(evt);
				}
			});
			cCombo1.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					cCombo1WidgetSelected(evt);
				}
			});
			cCombo1.addDisposeListener( new DisposeListener() {
				public void widgetDisposed(DisposeEvent evt) {
					cCombo1WidgetDisposed(evt);
				}
			});
			FillLayout composite11Layout = new FillLayout(256);
			composite11.setLayout(composite11Layout);
			composite11Layout.type = SWT.HORIZONTAL;
			composite11.layout();
	
			GridData composite4LData = new GridData();
			composite4LData.verticalAlignment = GridData.FILL;
			composite4LData.horizontalAlignment = GridData.FILL;
			composite4LData.widthHint = -1;
			composite4LData.heightHint = -1;
			composite4LData.horizontalIndent = 0;
			composite4LData.horizontalSpan = 1;
			composite4LData.verticalSpan = 1;
			composite4LData.grabExcessHorizontalSpace = true;
			composite4LData.grabExcessVerticalSpace = true;
			composite4.setLayoutData(composite4LData);
	
			tree4.setSize(new org.eclipse.swt.graphics.Point(216,225));
			tree4.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tree4MouseDoubleClick(evt);
				}
			});
	
			treeItem5.setText("Stok Ekle");
	
			treeItem15.setText("treeItem15");
	
			treeItem6.setText("Stok Düzenle");
	
			treeItem8.setText("Stok Sil");
	
			treeItem9.setText("Stok Listesi");
	
			treeItem10.setText("Stok Fiþleri");
	
			treeItem11.setText("Stok Tanýmlarý");
	
			treeItem12.setText("Depolar");
	
			treeItem13.setText("Depo Tanýmlarý");
	
			treeItem14.setText("Depo Listesi");
			tree4.setLayout(null);
	
			StackLayout composite4Layout = new StackLayout();
			composite4.setLayout(composite4Layout);
			composite4Layout.marginWidth = 0;
			composite4Layout.marginHeight = 0;
			composite4Layout.topControl = null;
			composite4.layout();
			GridLayout composite10Layout = new GridLayout(1, true);
			composite10.setLayout(composite10Layout);
			composite10Layout.marginWidth = 0;
			composite10Layout.marginHeight = 5;
			composite10Layout.numColumns = 1;
			composite10Layout.makeColumnsEqualWidth = true;
			composite10Layout.horizontalSpacing = 5;
			composite10Layout.verticalSpacing = 5;
			composite10.layout();
	
			cTabItem4.setControl(composite7);
			cTabItem4.setText("Sýk Kullanýlanlar");
	
	
			GridData composite9LData = new GridData();
			composite9LData.verticalAlignment = GridData.CENTER;
			composite9LData.horizontalAlignment = GridData.FILL;
			composite9LData.widthHint = -1;
			composite9LData.heightHint = 24;
			composite9LData.horizontalIndent = 0;
			composite9LData.horizontalSpan = 1;
			composite9LData.verticalSpan = 1;
			composite9LData.grabExcessHorizontalSpace = true;
			composite9LData.grabExcessVerticalSpace = false;
			composite9.setLayoutData(composite9LData);
			composite9.setSize(new org.eclipse.swt.graphics.Point(232,24));
	
			GridData cLabel4LData = new GridData();
			cLabel4LData.verticalAlignment = GridData.CENTER;
			cLabel4LData.horizontalAlignment = GridData.FILL;
			cLabel4LData.widthHint = -1;
			cLabel4LData.heightHint = 20;
			cLabel4LData.horizontalIndent = 0;
			cLabel4LData.horizontalSpan = 1;
			cLabel4LData.verticalSpan = 1;
			cLabel4LData.grabExcessHorizontalSpace = true;
			cLabel4LData.grabExcessVerticalSpace = false;
			cLabel4.setLayoutData(cLabel4LData);
			cLabel4.setText("Sýk Kulanýlan Nesneler");
			cLabel4.setSize(new org.eclipse.swt.graphics.Point(182,20));
			cLabel4.setLayout(null);
	
			GridData toolBar5LData = new GridData();
			toolBar5LData.verticalAlignment = GridData.CENTER;
			toolBar5LData.horizontalAlignment = GridData.BEGINNING;
			toolBar5LData.widthHint = -1;
			toolBar5LData.heightHint = -1;
			toolBar5LData.horizontalIndent = 0;
			toolBar5LData.horizontalSpan = 1;
			toolBar5LData.verticalSpan = 1;
			toolBar5LData.grabExcessHorizontalSpace = false;
			toolBar5LData.grabExcessVerticalSpace = false;
			toolBar5.setLayoutData(toolBar5LData);
	
			toolItem3.setImage(debugToolItemýmage);
	
			final org.eclipse.swt.graphics.Image toolItem4ýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/new_wiz.gif"));
			toolItem4.setImage(toolItem4ýmage);
			toolBar5.setLayout(null);
			GridLayout composite9Layout = new GridLayout(2, true);
			composite9.setLayout(composite9Layout);
			composite9Layout.marginWidth = 2;
			composite9Layout.marginHeight = 2;
			composite9Layout.numColumns = 2;
			composite9Layout.makeColumnsEqualWidth = false;
			composite9Layout.horizontalSpacing = 0;
			composite9Layout.verticalSpacing = 0;
			composite9.layout();
	
			GridData tree3LData = new GridData();
			tree3LData.verticalAlignment = GridData.FILL;
			tree3LData.horizontalAlignment = GridData.FILL;
			tree3LData.widthHint = -1;
			tree3LData.heightHint = -1;
			tree3LData.horizontalIndent = 0;
			tree3LData.horizontalSpan = 1;
			tree3LData.verticalSpan = 1;
			tree3LData.grabExcessHorizontalSpace = false;
			tree3LData.grabExcessVerticalSpace = true;
			tree3.setLayoutData(tree3LData);
			tree3.setSize(new org.eclipse.swt.graphics.Point(216,232));
			GridLayout composite7Layout = new GridLayout(1, true);
			composite7.setLayout(composite7Layout);
			composite7Layout.marginWidth = 0;
			composite7Layout.marginHeight = 0;
			composite7Layout.numColumns = 1;
			composite7Layout.makeColumnsEqualWidth = true;
			composite7Layout.horizontalSpacing = 0;
			composite7Layout.verticalSpacing = 0;
			composite7.layout();
			cTabFolder2.setLayout(null);
			cTabFolder2.setSelection(0);
	
			cTabFolder3.setSize(new org.eclipse.swt.graphics.Point(237,291));
			cTabFolder3.setBounds(new org.eclipse.swt.graphics.Rectangle(239,0,242,296));
			cTabFolder3.addCTabFolderListener( new CTabFolderAdapter() {
				public void itemClosed(CTabFolderEvent evt) {
					cTabFolder3ÝtemClosed(evt);
				}
			});
	
			cTabItem1.setControl(composite2);
			cTabItem1.setText("cTabItem1");
	
			FormLayout composite2Layout = new FormLayout();
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 0;
			composite2Layout.marginHeight = 0;
			composite2.layout();
	
			cTabItem2.setControl(composite3);
			cTabItem2.setText("cTabItem2");
	
			FormLayout composite3Layout = new FormLayout();
			composite3.setLayout(composite3Layout);
			composite3Layout.marginWidth = 0;
			composite3Layout.marginHeight = 0;
			composite3.layout();
	
			cTabItem3.setText("cTabItem3");
			cTabFolder3.setLayout(null);
			cTabFolder3.setSelection(0);
			sashForm3.setLayout(null);
			sashForm2.setLayout(null);
			GridLayout composite6Layout = new GridLayout(1, true);
			composite6.setLayout(composite6Layout);
			composite6Layout.marginWidth = 1;
			composite6Layout.marginHeight = 3;
			composite6Layout.numColumns = 1;
			composite6Layout.makeColumnsEqualWidth = true;
			composite6Layout.horizontalSpacing = 2;
			composite6Layout.verticalSpacing = 2;
			composite6.layout();
			GridLayout composite8Layout = new GridLayout(3, true);
			composite8.setLayout(composite8Layout);
			composite8Layout.marginWidth = 0;
			composite8Layout.marginHeight = 0;
			composite8Layout.numColumns = 3;
			composite8Layout.makeColumnsEqualWidth = false;
			composite8Layout.horizontalSpacing = 2;
			composite8Layout.verticalSpacing = 0;
			composite8.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			menu1 = new Menu(getShell(),SWT.BAR);
			fileMenuItem = new MenuItem(menu1,SWT.CASCADE);
			menu3 = new Menu(fileMenuItem);
			newMenuItem = new MenuItem(menu3,SWT.CASCADE);
			menu5 = new Menu(newMenuItem);
			projectItem = new MenuItem(menu5,SWT.PUSH);
			menuItem5 = new MenuItem(menu5,SWT.SEPARATOR);
			packageItem = new MenuItem(menu5,SWT.PUSH);
			separator11 = new MenuItem(menu3,SWT.SEPARATOR);
			closeMenuItem = new MenuItem(menu3,SWT.PUSH);
			saveMenuItem = new MenuItem(menu3,SWT.PUSH);
			exitMenuItem = new MenuItem(menu3,SWT.PUSH);
			editMenuItem = new MenuItem(menu1,SWT.CASCADE);
			menu15 = new Menu(editMenuItem);
			undoMenuItem = new MenuItem(menu15,SWT.PUSH);
			redoMenuItem = new MenuItem(menu15,SWT.PUSH);
			separator1 = new MenuItem(menu15,SWT.SEPARATOR);
			cutMenuItem = new MenuItem(menu15,SWT.PUSH);
			pasteMenuItem = new MenuItem(menu15,SWT.PUSH);
			copyMenuItem = new MenuItem(menu15,SWT.PUSH);
			helpMenuItem = new MenuItem(menu1,SWT.CASCADE);
			menu20 = new Menu(helpMenuItem);
			helpContMenuItem = new MenuItem(menu20,SWT.PUSH);
	
			getShell().setMenuBar(menu1);
	
			fileMenuItem.setText("&File");
	
			fileMenuItem.setMenu(menu3);
	
			newMenuItem.setText("&New");
	
			newMenuItem.setMenu(menu5);
	
			projectItem.setText("Project");
	
	
			packageItem.setText("Package");
	
	
			closeMenuItem.setText("&Close");
	
			saveMenuItem.setText("&Save");
	
			exitMenuItem.setText("&Exit");
	
			editMenuItem.setText("&Edit");
	
			editMenuItem.setMenu(menu15);
	
			undoMenuItem.setText("Undo");
	
			redoMenuItem.setText("Redo");
	
			separator1.setText("menuItem27");
	
			cutMenuItem.setText("Cut");
	
			pasteMenuItem.setText("Paste");
	
			copyMenuItem.setText("Copy");
	
			helpMenuItem.setEnabled(true);
			helpMenuItem.setText("&Help");
	
			helpMenuItem.setMenu(menu20);
	
			helpContMenuItem.setText("Help &Contents");
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					newToolItemýmage.dispose();
					toolItem6ýmage.dispose();
					toolItem8ýmage.dispose();
					toolItem13ýmage.dispose();
					toolItem1ýmage.dispose();
					toolItem2ýmage.dispose();
					toolItem9ýmage.dispose();
					debugToolItemýmage.dispose();
					runToolItemýmage.dispose();
					toolItem10ýmage.dispose();
					cCombo1background.dispose();
					toolItem4ýmage.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
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
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			EngUIMainFrame inst = new EngUIMainFrame(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,489,329);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void newToolItemWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void debugToolItemWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void runToolItemWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void cCombo1PaintControl(PaintEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void cCombo1WidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void cCombo1WidgetDisposed(DisposeEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void tree4MouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void cTabFolder3ÝtemClosed(CTabFolderEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void EngUIMainFramePaintControl(PaintEvent evt){
		//TODO add your handler code here
	}
}
