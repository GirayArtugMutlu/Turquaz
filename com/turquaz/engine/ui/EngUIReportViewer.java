package com.turquaz.engine.ui;

import net.sf.jasperreports.engine.JasperPrint;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.layout.GridData;
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
public class EngUIReportViewer extends org.eclipse.swt.widgets.Composite {
	private ViewerComposite viewerComposite;
	JasperPrint jasperPrint;

	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI(JasperPrint jPrint) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		EngUIReportViewer inst = new EngUIReportViewer(shell, SWT.NULL,jPrint);
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

	public EngUIReportViewer(org.eclipse.swt.widgets.Composite parent, int style,JasperPrint jPrint) {
		super(parent, style);
		jasperPrint = jPrint;
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(739, 430);
            {
                viewerComposite = new ViewerComposite(this, SWT.NONE);
                GridData viewerCompositeLData = new GridData();
                viewerCompositeLData.grabExcessHorizontalSpace = true;
                viewerCompositeLData.grabExcessVerticalSpace = true;
                viewerCompositeLData.horizontalAlignment = GridData.FILL;
                viewerCompositeLData.verticalAlignment = GridData.FILL;
                viewerComposite.setLayoutData(viewerCompositeLData);
                viewerComposite.getReportViewer().setDocument(jasperPrint);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
