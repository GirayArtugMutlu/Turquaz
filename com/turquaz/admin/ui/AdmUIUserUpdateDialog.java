package com.turquaz.admin.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


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
import com.turquaz.admin.ui.AdmUIUserAdd;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
public class AdmUIUserUpdateDialog extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private AdmUIUserAdd compUserAdd;
	private CoolBar coolBar1;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ToolItem toolDelete;
	private ToolBar toolBar1;

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
		AdmUIUserUpdateDialog inst = new AdmUIUserUpdateDialog(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AdmUIUserUpdateDialog(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(558, 416);
			{
				coolBar1 = new CoolBar(this, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1LData.verticalAlignment = GridData.BEGINNING;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 34));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 34));
					coolItem1.setSize(45, 34);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText("Update");
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText("Delete");
							toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
						}
					}
				}
			}
			{
				compUserAdd = new AdmUIUserAdd(this, SWT.NONE);
				GridData compUserAddLData = new GridData();
				compUserAddLData.grabExcessHorizontalSpace = true;
				compUserAddLData.grabExcessVerticalSpace = true;
				compUserAddLData.horizontalAlignment = GridData.FILL;
				compUserAddLData.verticalAlignment = GridData.FILL;
				compUserAdd.setLayoutData(compUserAddLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
