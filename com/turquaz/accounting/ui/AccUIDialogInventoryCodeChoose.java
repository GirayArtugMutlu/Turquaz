package com.turquaz.accounting.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIDialogInventoryCodeChoose extends org.eclipse.swt.widgets.Dialog {
	private TreeItem tim157;
	private TreeItem tim153;
	private TreeItem tim152;
	private TreeItem tim151;
	private TreeItem tim150;
	private Shell dialogShell;
	private Tree AccUIAccCodeTree;

	public AccUIDialogInventoryCodeChoose(Shell parent, int style) {
		super(parent, style);
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			AccUIAccCodeTree = new Tree(dialogShell,SWT.NULL);
			tim150 = new TreeItem(AccUIAccCodeTree,SWT.NULL);
			tim151 = new TreeItem(AccUIAccCodeTree,SWT.NULL);
			tim152 = new TreeItem(AccUIAccCodeTree,SWT.NULL);
			tim153 = new TreeItem(AccUIAccCodeTree,SWT.NULL);
			tim157 = new TreeItem(AccUIAccCodeTree,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(304,208));
	
			AccUIAccCodeTree.setSize(new org.eclipse.swt.graphics.Point(288,192));
	
			tim150.setText("150 -ilk madde ve malzeme");
	
			tim151.setText("151- yar? mamüller");
	
			tim152.setText("152 -Mamüller");
	
			tim153.setText("153 -Tacari Mallar");
	
			tim157.setText("157 -Di?er Stoklar");
			FillLayout dialogShellLayout = new FillLayout(256);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.type = SWT.HORIZONTAL;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.spacing = 0;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 304,208);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
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
			AccUIDialogInventoryCodeChoose inst = new AccUIDialogInventoryCodeChoose(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
