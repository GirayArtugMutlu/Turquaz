package com.turquaz.bank.ui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.bank.bl.BankBLBankCardAdd;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class BankUIBankCardAdd extends SecureComposite {

	private Text txtBankAccountNo;
	private CLabel lvlBanckAccountNo;
	private Text txtBankBranchName;
	private CLabel lblBankBranchName;
	private Text txtBankName;
	private CLabel lblBankName;
	public BankUIBankCardAdd(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	private BankBLBankCardAdd bankBLBankCardAdd=new BankBLBankCardAdd();
	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			lblBankName = new CLabel(this,SWT.NULL);
			txtBankName = new Text(this,SWT.NULL);
			lblBankBranchName = new CLabel(this,SWT.NULL);
			txtBankBranchName = new Text(this,SWT.NULL);
			lvlBanckAccountNo = new CLabel(this,SWT.NULL);
			txtBankAccountNo = new Text(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(456,312));
	
			lblBankName.setText("Bank Name");
	
			GridData txtBankNameLData = new GridData();
			txtBankNameLData.widthHint = 254;
			txtBankNameLData.heightHint = 13;
			txtBankName.setLayoutData(txtBankNameLData);
			txtBankName.setTextLimit(50);
			txtBankName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankBranchNameLData = new GridData();
			lblBankBranchNameLData.widthHint = 95;
			lblBankBranchNameLData.heightHint = 19;
			lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			lblBankBranchName.setText("Bank Branch Name");
			lblBankBranchName.setSize(new org.eclipse.swt.graphics.Point(95,19));
	
			GridData txtBankBranchNameLData = new GridData();
			txtBankBranchNameLData.widthHint = 254;
			txtBankBranchNameLData.heightHint = 13;
			txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			txtBankBranchName.setTextLimit(50);
			txtBankBranchName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			lvlBanckAccountNo.setText("Bank Account No");
	
			GridData txtBankAccountNoLData = new GridData();
			txtBankAccountNoLData.widthHint = 254;
			txtBankAccountNoLData.heightHint = 13;
			txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
			txtBankAccountNo.setTextLimit(50);
			txtBankAccountNo.setSize(new org.eclipse.swt.graphics.Point(254,13));
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private boolean verifyfields()
	{
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		if (txtBankName.getText().trim().equals("")){
			msg.setMessage("Please Fill Bank Name!");
			msg.open();
			return false;
			}
		else if(txtBankBranchName.getText().trim().equals("")){
			msg.setMessage("Please Fill Bank Branch Name!");
			msg.open();
			return false;
			}
		else if (txtBankAccountNo.getText().trim().equals("")){
			msg.setMessage("Please Fill Bank Account No!");
			msg.open();
			return false;
			}
		else
			return true;
		
	}
	
	private void clearFields()
	{
		txtBankName.setText("");
		txtBankBranchName.setText("");
		txtBankAccountNo.setText("");
	}
	public void save()
	{
		try
		{
			if (verifyfields())
			{
				bankBLBankCardAdd.saveBankCard(txtBankName.getText().trim(),
												txtBankBranchName.getText().trim(),
													txtBankAccountNo.getText().trim());
													
				MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
				msg.setMessage("Succesfully Saved!");
				msg.open();
				clearFields();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void search(){
	}
	
	public void newForm(){
	}
	
	public void delete(){
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}
}
