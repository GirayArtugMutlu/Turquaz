package com.turquaz.accounting.ui;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DecimalText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
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
	private CLabel lblAmount;
	private CLabel lbDeptOrCredit;
	private CCombo comboDeptOrCredit;
	private AccountPicker accountPicker;
	private CLabel lblAccount;
	private Shell dialogShell;
	private TurqAccountingTransactionColumn transactionRow;
	private int transactionType=0;

	public AccUITransactionRowAddDialog(Shell parent, int style, int transType) {
		super(parent, style);
		transactionType=transType;
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
			comboDeptOrCredit = new CCombo(dialogShell,SWT.READ_ONLY);
			lblAmount = new CLabel(dialogShell,SWT.NULL);
			decTextAmount = new DecimalText(dialogShell,SWT.NULL);
			btnCancel = new Button(dialogShell,SWT.PUSH| SWT.CENTER);
			btnOk = new Button(dialogShell,SWT.PUSH| SWT.CENTER);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(354,143));
	
			GridData lblAccountLData = new GridData();
			lblAccountLData.verticalAlignment = GridData.CENTER;
			lblAccountLData.horizontalAlignment = GridData.BEGINNING;
			lblAccountLData.widthHint = -1;
			lblAccountLData.heightHint = -1;
			lblAccountLData.horizontalIndent = 0;
			lblAccountLData.horizontalSpan = 1;
			lblAccountLData.verticalSpan = 1;
			lblAccountLData.grabExcessHorizontalSpace = false;
			lblAccountLData.grabExcessVerticalSpace = false;
			lblAccount.setLayoutData(lblAccountLData);
			lblAccount.setText(Messages.getString("AccUITransactionRowAddDialog.0")); //$NON-NLS-1$
	
			GridData accountPickerLData = new GridData();
			accountPickerLData.verticalAlignment = GridData.CENTER;
			accountPickerLData.horizontalAlignment = GridData.BEGINNING;
			accountPickerLData.widthHint = 204;
			accountPickerLData.heightHint = 20;
			accountPickerLData.horizontalIndent = 0;
			accountPickerLData.horizontalSpan = 1;
			accountPickerLData.verticalSpan = 1;
			accountPickerLData.grabExcessHorizontalSpace = false;
			accountPickerLData.grabExcessVerticalSpace = false;
			accountPicker.setLayoutData(accountPickerLData);
			accountPicker.setSize(new org.eclipse.swt.graphics.Point(204,20));
			accountPicker.layout();
	
			GridData lbDeptOrCreditLData = new GridData();
			lbDeptOrCreditLData.verticalAlignment = GridData.CENTER;
			lbDeptOrCreditLData.horizontalAlignment = GridData.BEGINNING;
			lbDeptOrCreditLData.widthHint = 62;
			lbDeptOrCreditLData.heightHint = 19;
			lbDeptOrCreditLData.horizontalIndent = 0;
			lbDeptOrCreditLData.horizontalSpan = 1;
			lbDeptOrCreditLData.verticalSpan = 1;
			lbDeptOrCreditLData.grabExcessHorizontalSpace = false;
			lbDeptOrCreditLData.grabExcessVerticalSpace = false;
			lbDeptOrCredit.setLayoutData(lbDeptOrCreditLData);
			lbDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.1")); //$NON-NLS-1$
			lbDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(62,19));
	
			GridData comboDeptOrCreditLData = new GridData();
			comboDeptOrCreditLData.verticalAlignment = GridData.CENTER;
			comboDeptOrCreditLData.horizontalAlignment = GridData.BEGINNING;
			comboDeptOrCreditLData.widthHint = 71;
			comboDeptOrCreditLData.heightHint = 17;
			comboDeptOrCreditLData.horizontalIndent = 0;
			comboDeptOrCreditLData.horizontalSpan = 1;
			comboDeptOrCreditLData.verticalSpan = 1;
			comboDeptOrCreditLData.grabExcessHorizontalSpace = false;
			comboDeptOrCreditLData.grabExcessVerticalSpace = false;
			comboDeptOrCredit.setLayoutData(comboDeptOrCreditLData);
			comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
			final Color comboDeptOrCreditbackground = new Color(Display.getDefault(),255,255,255);
			comboDeptOrCredit.setBackground(comboDeptOrCreditbackground);
			comboDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(71,17));
	
			GridData lblAmountLData = new GridData();
			lblAmountLData.verticalAlignment = GridData.CENTER;
			lblAmountLData.horizontalAlignment = GridData.BEGINNING;
			lblAmountLData.widthHint = -1;
			lblAmountLData.heightHint = -1;
			lblAmountLData.horizontalIndent = 0;
			lblAmountLData.horizontalSpan = 1;
			lblAmountLData.verticalSpan = 1;
			lblAmountLData.grabExcessHorizontalSpace = false;
			lblAmountLData.grabExcessVerticalSpace = false;
			lblAmount.setLayoutData(lblAmountLData);
			lblAmount.setText(Messages.getString("AccUITransactionRowAddDialog.3")); //$NON-NLS-1$
	
			GridData decTextAmountLData = new GridData();
			decTextAmountLData.verticalAlignment = GridData.CENTER;
			decTextAmountLData.horizontalAlignment = GridData.BEGINNING;
			decTextAmountLData.widthHint = 154;
			decTextAmountLData.heightHint = 18;
			decTextAmountLData.horizontalIndent = 0;
			decTextAmountLData.horizontalSpan = 1;
			decTextAmountLData.verticalSpan = 1;
			decTextAmountLData.grabExcessHorizontalSpace = false;
			decTextAmountLData.grabExcessVerticalSpace = false;
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
			btnCancel.setText(Messages.getString("AccUITransactionRowAddDialog.4")); //$NON-NLS-1$
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
			btnOk.setText(Messages.getString("AccUITransactionRowAddDialog.5")); //$NON-NLS-1$
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
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					comboDeptOrCreditbackground.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 354,143);
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
	Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
	transactionRow = null;
	if(transactionType==2){
	comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
	comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
	comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
	}
	else if(transactionType==1){
	comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
	comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.10")); //$NON-NLS-1$
	}
	else if(transactionType ==0){
	comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
	comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
	
	}
	
	
	}
	public Object showDialog(){
	this.open();
	return transactionRow;
	
	}

    boolean verifyFields(){

    MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);	
   if(accountPicker.getData()==null){
   		msg.setMessage(Messages.getString("AccUITransactionRowAddDialog.13"));	 //$NON-NLS-1$
   		msg.open();
   		return false;
   
   }
   else if(decTextAmount.getBigDecimalValue().toString().equals("0")){ //$NON-NLS-1$
   
   	msg.setMessage(Messages.getString("AccUITransactionRowAddDialog.15")); //$NON-NLS-1$
	msg.open();
	return false;
   
   } 
    
   return true;
    
   
   }
	/** Auto-generated event handler method */
	protected void btnOkMouseUp(MouseEvent evt){
	
	if(verifyFields()){
	transactionRow = new TurqAccountingTransactionColumn();
	
	transactionRow.setTurqAccountingAccount((TurqAccountingAccount)accountPicker.getData());	
	
	if(comboDeptOrCredit.getText().equals(Messages.getString("AccUITransactionRowAddDialog.6"))){ //$NON-NLS-1$
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
