package com.turquaz.accounting.ui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAddAccounts extends org.eclipse.swt.widgets.Composite {

	private Text text3;
	private Composite composite1;
	private CLabel cLabel2;
	private Text text2;
	private CLabel cLabel1;
	private Text text1;
	private Label label1;
	public AccUIAddAccounts(Composite parent, int style) {
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
	
			label1 = new Label(this,SWT.NULL);
			text1 = new Text(this,SWT.NULL);
			cLabel1 = new CLabel(this,SWT.NULL);
			text2 = new Text(this,SWT.NULL);
			cLabel2 = new CLabel(this,SWT.NULL);
			composite1 = new Composite(this,SWT.NULL);
			text3 = new Text(composite1,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(448,326));
	
			GridData label1LData = new GridData();
			label1LData.widthHint = 77;
			label1LData.heightHint = 16;
			label1.setLayoutData(label1LData);
			label1.setText("Account Name");
			label1.setSize(new org.eclipse.swt.graphics.Point(77,16));
	
			GridData text1LData = new GridData();
			text1LData.widthHint = 79;
			text1LData.heightHint = 20;
			text1.setLayoutData(text1LData);
			text1.setText("text1");
			text1.setSize(new org.eclipse.swt.graphics.Point(79,20));
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.widthHint = 83;
			cLabel1LData.heightHint = 17;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Account Code");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(83,17));
	
			GridData text2LData = new GridData();
			text2LData.widthHint = 96;
			text2LData.heightHint = 16;
			text2.setLayoutData(text2LData);
			text2.setText("text2");
			text2.setSize(new org.eclipse.swt.graphics.Point(96,16));
	
			cLabel2.setText("Parent Account");
	
			GridData composite1LData = new GridData();
			composite1LData.widthHint = 118;
			composite1LData.heightHint = 33;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(118,33));
	
			GridData text3LData = new GridData();
			text3LData.widthHint = 82;
			text3LData.heightHint = 24;
			text3.setLayoutData(text3LData);
			text3.setText("text3");
			text3.setSize(new org.eclipse.swt.graphics.Point(82,24));
			GridLayout composite1Layout = new GridLayout(1, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 1;
			composite1Layout.makeColumnsEqualWidth = true;
			composite1Layout.horizontalSpacing = 0;
			composite1Layout.verticalSpacing = 0;
			composite1.layout();
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 20;
			this.layout();
	
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
			AccUIAddAccounts inst = new AccUIAddAccounts(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,448,326);
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
