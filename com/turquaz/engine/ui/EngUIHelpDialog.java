package com.turquaz.engine.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.Hyperlink;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class EngUIHelpDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CLabel lblMessage;
	private Hyperlink hyperlinkTurquaz;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			EngUIHelpDialog inst = new EngUIHelpDialog(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EngUIHelpDialog(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
			dialogShell.setText("Yard?m");
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(344, 262);
            {
                lblMessage = new CLabel(dialogShell, SWT.NONE);
                lblMessage.setText("A?a??daki adreslerden yard?m alabilirsiniz.");
                GridData lblMessageLData = new GridData();
                lblMessageLData.horizontalAlignment = GridData.CENTER;
                lblMessageLData.widthHint = 212;
                lblMessageLData.heightHint = 35;
                lblMessageLData.grabExcessHorizontalSpace = true;
                lblMessage.setLayoutData(lblMessageLData);
            }
            {
                hyperlinkTurquaz = new Hyperlink(dialogShell, SWT.NONE);
                hyperlinkTurquaz.setText("Turquaz Forum");
                GridData hyperlinkTurquazLData = new GridData();
                hyperlinkTurquaz.addSelectionListener(new SelectionAdapter() {
                    public void widgetSelected(SelectionEvent evt) {
                       Program.launch("http://www.turquaz.com/forum");
                      //  Program.launch("mailto:onsel@turquaz.com");
                    }
                });
                hyperlinkTurquazLData.widthHint = 107;
                hyperlinkTurquazLData.heightHint = 18;
                hyperlinkTurquaz.setLayoutData(hyperlinkTurquazLData);
            }
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
	
}
