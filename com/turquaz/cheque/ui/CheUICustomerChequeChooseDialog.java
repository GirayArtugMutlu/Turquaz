package com.turquaz.cheque.ui;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
public class CheUICustomerChequeChooseDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Table tableCheques;

	public CheUICustomerChequeChooseDialog(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(521, 339);
            {
                tableCheques = new Table(dialogShell, SWT.CHECK);
                GridData tableChequesLData = new GridData();
                tableCheques.setLinesVisible(true);
                tableCheques.setHeaderVisible(true);
                tableChequesLData.heightHint = 205;
                tableChequesLData.horizontalAlignment = GridData.FILL;
                tableChequesLData.grabExcessHorizontalSpace = true;
                tableCheques.setLayoutData(tableChequesLData);
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
