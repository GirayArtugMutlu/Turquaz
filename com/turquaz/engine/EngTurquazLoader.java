/*
 * Created on Apr 6, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine;

import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.EngUIEntryFrame;
import com.turquaz.engine.ui.EngUIMainFrame;


/**
 * @author onsel
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngTurquazLoader
{
	private Shell shell;
	Display display;
	Shell invisibleShell;
	static boolean guiBuilt = false;
	
	private EngTurquazLoader(Display display){
    	
		this.display = display;
		Display.setAppName("Turquaz "+EngBLCommon.VERSION);
		
		/** Shell should not be visible in the taskbar */
		invisibleShell = new Shell(display, SWT.NULL);

		/** Shell containing the splash */
		shell = new Shell(invisibleShell, SWT.ON_TOP);
		EngUICommon.centreWindow(shell);
		
		/** Label containing the Splashimage */
		Label label = new Label(shell, SWT.NONE);
		label.setImage(new Image(display, getClass().getResourceAsStream("/icons/splash.jpg")));
		SWTResourceManager.registerResourceUser(label);

		/** Formlayout for Splash Contents */
		FormLayout layout = new FormLayout();
		shell.setLayout(layout);
		FormData labelData = new FormData();
		labelData.right = new FormAttachment(100, 0);
		labelData.bottom = new FormAttachment(100, 0);
		label.setLayoutData(labelData);

		/** Pack Shell */
		shell.pack();

		/** Problem on Linux: Shell is shown in Taskbar, so set title */
		shell.setText("Turquaz");
        EngUICommon.centreWindow(shell);
		
		shell.open();
        
	
		/** Load the application */
		this.display.asyncExec(new Runnable() {
			public void run() {
				EngUIMainFrame.showGUI2(EngTurquazLoader.this.display,invisibleShell);
				guiBuilt = true;
			}
		});

		/** Show splash while GUI is loading */
		while (!guiBuilt) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
 	
    }
	
	
	public static void startupProcess()
	{
		
		createWorkingDir();
		
		
		
	}
	public static void createWorkingDir()
	{
		File archiveDir = new File(System.getProperty("user.home")+"/.turquaz");
		if(!archiveDir.exists())
		{
			archiveDir.mkdirs();
		}		
	}
	public static void main(String[] args) {

		startupProcess();
		Display display = new Display();
		EngUIEntryFrame.showGUI(display);
		/** Things to do before launching RSSOwl */
	

		/** Start loading of Maincontroller */
		new EngTurquazLoader(display);
	}
}
