package com.turquaz.current.ui;


import net.sf.hibernate.odmg.Transaction;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import com.turquaz.current.ui.CurUITransactionAdd;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCurrentTransaction;

import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CUrUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	private CurUITransactionAdd compTransactionAdd;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	TurqCurrentTransaction transaction;

	public CUrUITransactionUpdateDialog(Shell parent, int style,TurqCurrentTransaction trans) {
		super(parent, style);
		transaction = trans;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}


	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/public void open(){
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
			compTransactionAdd = new CurUITransactionAdd(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(546,284));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.FILL;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = true;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText("Update");
			final org.eclipse.swt.graphics.Image toolUpdateimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save_edit.gif"));
			toolUpdate.setImage(toolUpdateimage);
	
			toolDelete.setText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteimage);
	
			GridData compTransactionAddLData = new GridData();
			compTransactionAddLData.verticalAlignment = GridData.FILL;
			compTransactionAddLData.horizontalAlignment = GridData.FILL;
			compTransactionAddLData.widthHint = -1;
			compTransactionAddLData.heightHint = -1;
			compTransactionAddLData.horizontalIndent = 0;
			compTransactionAddLData.horizontalSpan = 1;
			compTransactionAddLData.verticalSpan = 1;
			compTransactionAddLData.grabExcessHorizontalSpace = true;
			compTransactionAddLData.grabExcessVerticalSpace = true;
			compTransactionAdd.setLayoutData(compTransactionAddLData);
			compTransactionAdd.setSize(new org.eclipse.swt.graphics.Point(536,231));
			compTransactionAdd.layout();
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
					toolUpdateimage.dispose();
					toolDeleteimage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 546,284);
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
/** Add your post-init code in here 	*/
	public void postInitGUI(){
	
	// if it is not cash trasaction 
	//close 
	if(transaction.getTurqCurrentTransactionType().getCurrentTransactionTypesId().intValue()!=4){
	dialogShell.close();
	}
	
	//else fill the composite
	
	compTransactionAdd.getTxtDocumentNo().setText(transaction.getTransactionsDocumentNo());
	compTransactionAdd.getComboCurrentCode().setText(transaction.getTurqCurrentCard().getCardsCurrentCode());
	if(transaction.getTransactionsTotalCredit().compareTo(transaction.getTransactionsTotalDept())==1){
	compTransactionAdd.getComboTransType().setText("Credit");
	compTransactionAdd.getDecTxtAmount().setText(transaction.getTransactionsTotalCredit().toString());
	
	}
	else{
	compTransactionAdd.getComboTransType().setText("Dept");
		compTransactionAdd.getDecTxtAmount().setText(transaction.getTransactionsTotalDept().toString());
	}
	
	
	}
	
	
	
}
