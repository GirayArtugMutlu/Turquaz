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
import org.eclipse.swt.SWT;

/**
* @author  Onsel Armagan
* @version  $id $
*/
public class EngUIMainFrame extends org.eclipse.swt.widgets.Composite {
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
	
	
			this.setSize(new org.eclipse.swt.graphics.Point(379,234));
			final Color EngUIMainFramebackground = new Color(Display.getDefault(),128,128,128);
			this.setBackground(EngUIMainFramebackground);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			menu1 = new Menu(getShell(),SWT.BAR);
			fileMenuItem = new MenuItem(menu1,SWT.CASCADE);
			fileMenu = new Menu(fileMenuItem);
			openFileMenuItem = new MenuItem(fileMenu,SWT.CASCADE);
			newFileMenuItem = new MenuItem(fileMenu,SWT.CASCADE);
			saveFileMenuItem = new MenuItem(fileMenu,SWT.CASCADE);
			closeFileMenuItem = new MenuItem(fileMenu,SWT.CASCADE);
			exitMenuItem = new MenuItem(fileMenu,SWT.CASCADE);
			helpMenuItem = new MenuItem(menu1,SWT.CASCADE);
			helpMenu = new Menu(helpMenuItem);
			contentsMenuItem = new MenuItem(helpMenu,SWT.CASCADE);
			aboutMenuItem = new MenuItem(helpMenu,SWT.CASCADE);
	
			getShell().setMenuBar(menu1);
	
			fileMenuItem.setText("File");
	
			fileMenuItem.setMenu(fileMenu);
	
			openFileMenuItem.setText("Open");
	
			newFileMenuItem.setText("New");
	
			saveFileMenuItem.setText("Save");
	
			closeFileMenuItem.setText("Close");
	
			exitMenuItem.setText("Exit");
	
			helpMenuItem.setText("Help");
	
			helpMenuItem.setMenu(helpMenu);
	
			contentsMenuItem.setText("Contents");
	
			aboutMenuItem.setText("About");
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					EngUIMainFramebackground.dispose();
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
			Rectangle shellBounds = shell.computeTrim(0,0,379,214);
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
}
