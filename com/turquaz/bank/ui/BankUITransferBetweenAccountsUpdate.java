package com.turquaz.bank.ui;

import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.dal.TurqBanksTransactionBill;

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
public class BankUITransferBetweenAccountsUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUITransferBetweenAccounts bankUITransfer;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar;
	TurqBanksTransactionBill transBill;
	boolean isUpdated = false;

	public BankUITransferBetweenAccountsUpdate(Shell parent, int style,TurqBanksTransactionBill transBill) {
		super(parent, style);
		this.transBill = transBill;
	}

	public boolean open() {
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
			dialogShell.setSize(580, 307);
            {
                toolBar = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBarLData = new GridData();
                toolBarLData.grabExcessHorizontalSpace = true;
                toolBarLData.horizontalAlignment = GridData.FILL;
                toolBar.setLayoutData(toolBarLData);
                {
                    toolUpdate = new ToolItem(toolBar, SWT.NONE);
                    toolUpdate.setText("Güncelle");
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
                    toolUpdate.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            
                        update();
                        }
                    });
                }
                {
                    toolDelete = new ToolItem(toolBar, SWT.NONE);
                    toolDelete.setText("Sil");
                    toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
                    toolDelete.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                        
                            delete();
                        
                        }
                    });
                }
                {
                    toolCancel = new ToolItem(toolBar, SWT.NONE);
                    toolCancel.setText("\u0130ptal");
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
                    toolCancel.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                        
                            dialogShell.close();
                        
                        }
                    });
                }
            }
            {
                bankUITransfer = new BankUITransferBetweenAccounts(
                    dialogShell,
                    SWT.NONE);
                GridData bankUITransferLData = new GridData();
                bankUITransferLData.grabExcessHorizontalSpace = true;
                bankUITransferLData.horizontalAlignment = GridData.FILL;
                bankUITransferLData.grabExcessVerticalSpace = true;
                bankUITransferLData.verticalAlignment = GridData.FILL;
                bankUITransfer.setLayoutData(bankUITransferLData);
            }
            postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void postInitGUI(){
	    if(transBill!=null)
	    {
	        
	    }
	}
	public void update(){
	    
	}
	
	public void delete(){
	    
	}
	
}
