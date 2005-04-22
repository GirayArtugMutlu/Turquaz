package com.turquaz.engine.ui.component;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MenuItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLKeyEvents;
import com.turquaz.engine.interfaces.SearchDialogInterface;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

public class SearchDialogMenu extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Menu menuActions;
	private MenuItem menuItem1;
	private Menu menu1;
	private ToolItem toolChoose;
	private ToolItem toolSearch;
	private ToolBar toolBar1;
	private MenuItem menuItemChoose;
	private MenuItem menuItemSearch;
	private SearchDialogInterface dialogInterface;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		SearchDialogMenu inst = new SearchDialogMenu(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public SearchDialogMenu(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	public SearchDialogMenu(org.eclipse.swt.widgets.Composite parent, int style, SearchDialogInterface dialogMenu) {
		super(parent, style);
		this.dialogInterface = dialogMenu;
		initGUI();
	}

	private void initGUI() {
		try {
			{
				menuActions = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menuActions);
				
				
				{
					menuItem1 = new MenuItem(menuActions, SWT.CASCADE);
					menuItem1.setText("\u0130\u015flemler");
					{
						menu1 = new Menu(menuItem1);
						menuItem1.setMenu(menu1);
						{
							menuItemSearch = new MenuItem(menu1, SWT.PUSH);
							
							TurqKeyEvent event=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(EngBLKeyEvents.SEARCH);
						
							menuItemSearch.setAccelerator(event.stateMask | event.keyCode);
							menuItemSearch.setText("Ara\t"+EngBLKeyEvents.getStringValue(event));

							menuItemSearch
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
								
									search();
								
								}
								});
							
						}
						{
							menuItemChoose = new MenuItem(menu1, SWT.PUSH);
						
							menuItemChoose.setText("Seç\tENTER");
							menuItemChoose.setAccelerator(SWT.CR);
							menuItemChoose
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
								
									choose();
								
								}
								});
						}
					}
				}
			}
			this.setLayout(new GridLayout());
			this.setSize(505, 33);
			{
				GridData toolBar1LData = new GridData();
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.grabExcessVerticalSpace = true;
				toolBar1LData.verticalAlignment = GridData.FILL;
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1 = new ToolBar(this, SWT.NONE);
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolSearch = new ToolItem(toolBar1, SWT.NONE);
					toolSearch.setImage(SWTResourceManager.getImage("icons/search.gif"));
					toolSearch.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
						
							search();
							
						
						}
					});
				}
				{
					toolChoose = new ToolItem(toolBar1, SWT.NONE);
					toolChoose.setImage(SWTResourceManager.getImage("icons/Ok16.gif"));
					toolChoose.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
						
							choose();
						}
					});
				}
			}
			menuActions.setVisible(false);
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void choose()
	{
	   if(dialogInterface != null)
		   dialogInterface.choose();
	
	}
	public void search()
	{
		 if(dialogInterface != null)
			   dialogInterface.search();
	}

}
