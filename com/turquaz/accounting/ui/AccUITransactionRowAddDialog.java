package com.turquaz.accounting.ui;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DecimalText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionRowAddDialog extends org.eclipse.swt.widgets.Dialog {
	private Button btnOk;
	private Button btnCancel;
	private DecimalText decTextAmount;
	private CLabel Amount;
	private CLabel lbDeptOrCredit;
	private CCombo comboDeptOrCredit;
	private AccountPicker accountPicker;
	private CLabel lblAccount;
	private Shell dialogShell;
	private TurqAccountingTransactionColumn transactionRow;

	public AccUITransactionRowAddDialog(Shell parent, int style) {
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
			lblAccount = new CLabel(dialogShell,SWT.NULL);
			accountPicker = new AccountPicker(dialogShell,SWT.NULL);
			lbDeptOrCredit = new CLabel(dialogShell,SWT.NULL);
			comboDeptOrCredit = new CCombo(dialogShell,SWT.NULL);
			Amount = new CLabel(dialogShell,SWT.NULL);
			decTextAmount = new DecimalText(dialogShell,SWT.NULL);
			btnCancel = new Button(dialogShell,SWT.PUSH| SWT.CENTER);
			btnOk = new Button(dialogShell,SWT.PUSH| SWT.CENTER);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(328,129));
	
			lblAccount.setText("Account");
	
			GridData accountPickerLData = new GridData();
			accountPickerLData.widthHint = 204;
			accountPickerLData.heightHint = 20;
			accountPicker.setLayoutData(accountPickerLData);
			accountPicker.setSize(new org.eclipse.swt.graphics.Point(204,20));
			accountPicker.layout();
	
			GridData lbDeptOrCreditLData = new GridData();
			lbDeptOrCreditLData.widthHint = 62;
			lbDeptOrCreditLData.heightHint = 19;
			lbDeptOrCredit.setLayoutData(lbDeptOrCreditLData);
			lbDeptOrCredit.setText("Dept/Credit");
			lbDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(62,19));
	
			GridData comboDeptOrCreditLData = new GridData();
			comboDeptOrCreditLData.widthHint = 71;
			comboDeptOrCreditLData.heightHint = 17;
			comboDeptOrCredit.setLayoutData(comboDeptOrCreditLData);
			comboDeptOrCredit.setText("Dept");
			comboDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(71,17));
	
			Amount.setText("lblAmount");
	
			GridData decTextAmountLData = new GridData();
			decTextAmountLData.widthHint = 154;
			decTextAmountLData.heightHint = 18;
			decTextAmount.setLayoutData(decTextAmountLData);
			decTextAmount.setSize(new org.eclipse.swt.graphics.Point(154,18));
	
			GridData btnCancelLData = new GridData();
			btnCancelLData.verticalAlignment = GridData.END;
			btnCancelLData.horizontalAlignment = GridData.BEGINNING;
			btnCancelLData.widthHint = 44;
			btnCancelLData.heightHint = 23;
			btnCancelLData.horizontalIndent = 0;
			btnCancelLData.horizontalSpan = 1;
			btnCancelLData.verticalSpan = 2;
			btnCancelLData.grabExcessHorizontalSpace = false;
			btnCancelLData.grabExcessVerticalSpace = true;
			btnCancel.setLayoutData(btnCancelLData);
			btnCancel.setText("Cancel");
			btnCancel.setSize(new org.eclipse.swt.graphics.Point(44,23));
			btnCancel.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnCancelMouseUp(evt);
				}
			});
	
			GridData btnOkLData = new GridData();
			btnOkLData.verticalAlignment = GridData.END;
			btnOkLData.horizontalAlignment = GridData.END;
			btnOkLData.widthHint = -1;
			btnOkLData.heightHint = -1;
			btnOkLData.horizontalIndent = 0;
			btnOkLData.horizontalSpan = 1;
			btnOkLData.verticalSpan = 2;
			btnOkLData.grabExcessHorizontalSpace = true;
			btnOkLData.grabExcessVerticalSpace = true;
			btnOk.setLayoutData(btnOkLData);
			btnOk.setText("OK");
			btnOk.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnOkMouseUp(evt);
				}
			});
			GridLayout dialogShellLayout = new GridLayout(2, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 2;
			dialogShellLayout.makeColumnsEqualWidth = false;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 328,129);
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
	transactionRow = null;
	}
	public Object showDialog(){
	this.open();
	return transactionRow;
	
	}

    boolean verifyFields(){
    
    return true;
    
    }
	/** Auto-generated event handler method */
	protected void btnOkMouseUp(MouseEvent evt){
	
	if(verifyFields()){
	transactionRow = new TurqAccountingTransactionColumn();
	
	transactionRow.setTurqAccountingAccount((TurqAccountingAccount)accountPicker.getData());	
	
	if(comboDeptOrCredit.getText().equals("Dept")){
	transactionRow.setCreditAmount(new BigDecimal(0));
    transactionRow.setDeptAmount(decTextAmount.getBigDecimalValue());
    }
	else {
	transactionRow.setDeptAmount(new BigDecimal(0));
	transactionRow.setCreditAmount(decTextAmount.getBigDecimalValue());
	}	
	
	
	
	this.dialogShell.dispose();
	
	}
	
	}

	/** Auto-generated event handler method */
	protected void btnCancelMouseUp(MouseEvent evt){
		this.dialogShell.dispose();
	}
}
