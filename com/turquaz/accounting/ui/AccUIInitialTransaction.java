package com.turquaz.accounting.ui;

import java.math.BigDecimal;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.dal.TurqAccountingAccount;

import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.ui.comp.AccountPicker;
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
public class AccUIInitialTransaction extends org.eclipse.swt.widgets.Composite implements SecureComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private CLabel lblAccount;
	private CLabel lblDocumentNo;
	private Text txtDefinition;
	private CCombo comboDeptOrCredit;
	private CLabel lbDeptOrCredit;
	private CLabel lblDefinition;
	private Text txtDocumentNo;
	private DatePicker datePicker;
	private CLabel lblDate;
	private CurrencyText decInitialValue;
	private CLabel lblInitialValue;
	private AccountPicker accPicker;
	private AccBLTransactionAdd blTrans = new AccBLTransactionAdd();

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
		AccUIInitialTransaction inst = new AccUIInitialTransaction(shell, SWT.NULL);
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

	public AccUIInitialTransaction(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(454, 216);
            {
                lblAccount = new CLabel(this, SWT.NONE);
                lblAccount.setText(Messages.getString("AccUIInitialTransaction.0")); //$NON-NLS-1$
                GridData lblAccountLData = new GridData();
                lblAccountLData.widthHint = 118;
                lblAccountLData.heightHint = 22;
                lblAccount.setLayoutData(lblAccountLData);
            }
            {
                accPicker = new AccountPicker(this, SWT.NONE);
                GridData accPickerLData = new GridData();
                accPickerLData.heightHint = 23;
                accPickerLData.horizontalAlignment = GridData.FILL;
                accPicker.setLayoutData(accPickerLData);
            }
            {
                lblInitialValue = new CLabel(this, SWT.NONE);
                lblInitialValue.setText(Messages.getString("AccUIInitialTransaction.1")); //$NON-NLS-1$
                GridData lblInitialValueLData = new GridData();
                lblInitialValueLData.widthHint = 92;
                lblInitialValueLData.heightHint = 18;
                lblInitialValue.setLayoutData(lblInitialValueLData);
            }
            {
                decInitialValue = new CurrencyText(this, SWT.NONE);
                GridData decInitialValueLData = new GridData();
                decInitialValueLData.horizontalAlignment = GridData.FILL;
                decInitialValueLData.heightHint = 19;
                decInitialValue.setLayoutData(decInitialValueLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText(Messages.getString("AccUIInitialTransaction.2")); //$NON-NLS-1$
            }
            {
                datePicker = new DatePicker(this, SWT.NONE);
                GridData datePickerLData = new GridData();
                datePicker.setFont(SWTResourceManager.getFont(Messages.getString("AccUIInitialTransaction.3"), 8, 1, false, false)); //$NON-NLS-1$
                datePickerLData.widthHint = 165;
                datePickerLData.heightHint = 25;
                datePicker.setLayoutData(datePickerLData);
            }
            {
                lblDocumentNo = new CLabel(this, SWT.NONE);
                lblDocumentNo.setText(Messages.getString("AccUIInitialTransaction.4")); //$NON-NLS-1$
            }
            {
                txtDocumentNo = new Text(this, SWT.NONE);
                GridData txtDocumentNoLData = new GridData();
                txtDocumentNoLData.horizontalAlignment = GridData.FILL;
                txtDocumentNoLData.heightHint = 19;
                txtDocumentNo.setLayoutData(txtDocumentNoLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText(Messages.getString("AccUIInitialTransaction.5")); //$NON-NLS-1$
                GridData lblDefinitionLData = new GridData();
                lblDefinitionLData.widthHint = 86;
                lblDefinitionLData.heightHint = 20;
                lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
                lblDefinition.setLayoutData(lblDefinitionLData);
            }
            {
                txtDefinition = new Text(this, SWT.MULTI | SWT.V_SCROLL);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 237;
                txtDefinitionLData.heightHint = 52;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
            {
                lbDeptOrCredit = new CLabel(this, SWT.NONE);
                lbDeptOrCredit.setText(Messages
                    .getString("AccUITransactionRowAddDialog.1"));
                GridData lbDeptOrCreditLData = new GridData();
                lbDeptOrCreditLData.widthHint = 76;
                lbDeptOrCreditLData.heightHint = 18;
                lbDeptOrCredit.setLayoutData(lbDeptOrCreditLData);
            }
            {
                comboDeptOrCredit = new CCombo(this, SWT.READ_ONLY);
                comboDeptOrCredit.setText(Messages
                    .getString("AccUITransactionRowAddDialog.6"));
                comboDeptOrCredit.setBackground(SWTResourceManager.getColor(
                    255,
                    255,
                    255));
                comboDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(
                    71,
                    17));
                GridData comboDeptOrCreditLData = new GridData();
                comboDeptOrCreditLData.widthHint = 49;
                comboDeptOrCreditLData.heightHint = 17;
                comboDeptOrCredit.setLayoutData(comboDeptOrCreditLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void search(){
	    
	}
	public void save(){
	    MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	    
	    try{
	       Integer id = blTrans.saveAccTransaction(datePicker.getDate(),txtDocumentNo.getText().trim(),3,1,null,txtDefinition.getText().trim());
	       TurqAccountingTransactionColumn transRow = new TurqAccountingTransactionColumn();
	      
	      transRow.setTurqAccountingAccount((TurqAccountingAccount)accPicker.getData());	
	   	
	   	if(comboDeptOrCredit.getText().equals(Messages.getString("AccUITransactionRowAddDialog.6"))){ //$NON-NLS-1$
	   	transRow.setCreditAmount(new BigDecimal(0));
	    transRow.setDeptAmount(decInitialValue.getBigDecimalValue());
	    }
	   	
	   	else {
	   	transRow.setDeptAmount(new BigDecimal(0));
	   	transRow.setCreditAmount(decInitialValue.getBigDecimalValue());
	   	}	
	   	
	    blTrans.saveAccTransactionRow(transRow,id); 
	       
	        
	        msg.setMessage("Ba?ar?yla Kaydedildi!");
	        msg.open();
	        newForm();
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	        
	    }
	    
	}
	public void delete(){
	    
	}
	public void newForm(){
	    
	}

}
