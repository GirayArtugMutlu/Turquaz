package com.turquaz.engine.ui.contentassist;
import org.eclipse.jface.contentassist.SubjectControlContentAssistant;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;


public class ContentAsistantSnippet extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	private MenuItem aboutMenuItem;
	private MenuItem contentsMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private MenuItem exitMenuItem;
	private MenuItem closeFileMenuItem;
	private MenuItem saveFileMenuItem;
	private MenuItem newFileMenuItem;
	private MenuItem openFileMenuItem;
	private Text text1;
	private CLabel cLabel1;
	private Menu fileMenu;
	private MenuItem fileMenuItem;

	

	public ContentAsistantSnippet(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(new org.eclipse.swt.graphics.Point(400,300));
			
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 2;
			thisLayout.horizontalSpacing = 20;
			this.setLayout(thisLayout);
            {
                cLabel1 = new CLabel(this, SWT.NONE);
                cLabel1.setText("Example");
                GridData cLabel1LData = new GridData();
                cLabel1LData.widthHint = 49;
                cLabel1LData.heightHint = 19;
                cLabel1.setLayoutData(cLabel1LData);
            }
            {
                text1 = new Text(this, SWT.NONE);
                GridData text1LData = new GridData();
                text1LData.widthHint = 228;
                text1LData.heightHint = 21;
                text1.setLayoutData(text1LData);
            }
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("File");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							openFileMenuItem.setText("Open");
						}
						{
							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							newFileMenuItem.setText("New");
						}
						{
							saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							saveFileMenuItem.setText("Save");
						}
						{
							closeFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							closeFileMenuItem.setText("Close");
						}
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("Exit");
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("Help");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							contentsMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							contentsMenuItem.setText("Contents");
						}
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("About");
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Content Assistant Code Here...  
	public void postInitGUI(){
	    
	    TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(text1);
	    
	 	final SubjectControlContentAssistant asistant= TurquazContentAssistant.createContentAssistant(adapter);
	   
	     adapter.appendVerifyKeyListener(
	             new VerifyKeyListener() {
	                 public void verifyKey(VerifyEvent event) {

	                 // Check for Ctrl+Spacebar
	                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
	             
	                  asistant.showPossibleCompletions();              
	                   event.doit = false;

	                 }
	              }
	           });
	 	
	    
	}
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		ContentAsistantSnippet inst = new ContentAsistantSnippet(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			if (shell.getMenuBar() != null)
				shellBounds.height -= 22;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
