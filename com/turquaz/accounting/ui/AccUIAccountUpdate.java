package com.turquaz.accounting.ui;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAccountUpdate extends org.eclipse.swt.widgets.Dialog {
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private AccUIAddAccounts compAccountCard;
	private Shell dialogShell;
	private TurqAccountingAccount account;
 
    AccBLAccountUpdate blAccount = new AccBLAccountUpdate();
	public AccUIAccountUpdate(Shell parent, int style, TurqAccountingAccount acc) {
		super(parent, style);
		account = acc;
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
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compAccountCard = new AccUIAddAccounts(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(479,322));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = false;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText("Update");
			toolUpdate.setToolTipText("Update");
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText("Delete");
			toolDelete.setToolTipText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteimage);
	
			GridData compAccountCardLData = new GridData();
			compAccountCardLData.widthHint = 459;
			compAccountCardLData.heightHint = 250;
			compAccountCard.setLayoutData(compAccountCardLData);
			compAccountCard.setSize(new org.eclipse.swt.graphics.Point(459,250));
			compAccountCard.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolDeleteimage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 479,322);
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
    compAccountCard.getTxtAccAccountCode().setText(account.getAccountCode());
    compAccountCard.getTxtAccAcountName().setText(account.getAccountName());
    compAccountCard.getTxtParentAccount().setText(account.getTurqAccountingAccount().getAccountCode());
    compAccountCard.getTxtParentAccount().setData(account.getTurqAccountingAccount().getAccountingAccountsId());
	
	
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		try{
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		if(compAccountCard.verifyFields()){
		blAccount.updateAccount(account,compAccountCard.getTxtAccAcountName().getText().trim(),
								compAccountCard.getTxtAccAccountCode().getText().trim(),
								((Integer)compAccountCard.getTxtParentAccount().getData()).intValue());
		msg.setMessage("Updated Succesfully!");
		msg.open();		
		this.dialogShell.close();
		
		
		}
		
		
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
