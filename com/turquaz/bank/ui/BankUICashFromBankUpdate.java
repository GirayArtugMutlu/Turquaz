package com.turquaz.bank.ui;

import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.Messages;

import org.eclipse.swt.widgets.ToolItem;
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
public class BankUICashFromBankUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUICashFromBank compCashTrans;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			BankUICashFromBankUpdate inst = new BankUICashFromBankUpdate(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BankUICashFromBankUpdate(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(555, 300);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setText(Messages.getString("BankUICashFromBankUpdate.0")); //$NON-NLS-1$
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                }
                {
                    toolDelete = new ToolItem(toolBar1, SWT.NONE);
                    toolDelete.setText(Messages.getString("BankUICashFromBankUpdate.2")); //$NON-NLS-1$
                    toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText(Messages.getString("BankUICashFromBankUpdate.4")); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                }
            }
            {
                compCashTrans = new BankUICashFromBank(
                    dialogShell,
                    SWT.NONE);
                GridData compCashTransLData = new GridData();
                compCashTransLData.grabExcessHorizontalSpace = true;
                compCashTransLData.horizontalAlignment = GridData.FILL;
                compCashTransLData.verticalAlignment = GridData.FILL;
                compCashTransLData.grabExcessVerticalSpace = true;
                compCashTrans.setLayoutData(compCashTransLData);
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
