package com.turquaz.admin.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.engine.ui.component.SecureComposite;
public class AdmUIUserAdd extends Composite {
	private Table table1;
	private CCombo cCombo1;

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
		AdmUIUserAdd inst = new AdmUIUserAdd(shell, SWT.NULL);
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

	public AdmUIUserAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(218, 172);
			{
				table1 = new Table(this, SWT.NONE);
				GridData table1LData = new GridData();
				table1.setHeaderVisible(true);
				table1.setLinesVisible(true);
				table1LData.widthHint = 172;
				table1LData.heightHint = 72;
				table1.setLayoutData(table1LData);
			}
			{
				cCombo1 = new CCombo(this, SWT.NONE);
				cCombo1.setText("cCombo1");
				GridData cCombo1LData = new GridData();
				cCombo1LData.widthHint = 171;
				cCombo1LData.heightHint = 19;
				cCombo1.setLayoutData(cCombo1LData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(){
		
	}
	public void search(){
		
	}
	public void newForm(){
		
	}
	public void delete(){
		
	}

}
