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

	/**
	 * @return Returns the txtBankAccountNo.
	 */
	public Text getTxtBankAccountNo() {
		return txtBankAccountNo;
	}
	/**
	 * @return Returns the txtBankBranchName.
	 */
	public Text getTxtBankBranchName() {
		return txtBankBranchName;
	}
	/**
	 * @return Returns the txtBankName.
	 */
	public Text getTxtBankName() {
		return txtBankName;
	}
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
	
			GridData lblBankNameLData = new GridData();
			lblBankNameLData.verticalAlignment = GridData.CENTER;
			lblBankNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankNameLData.widthHint = -1;
			lblBankNameLData.heightHint = -1;
			lblBankNameLData.horizontalIndent = 0;
			lblBankNameLData.horizontalSpan = 1;
			lblBankNameLData.verticalSpan = 1;
			lblBankNameLData.grabExcessHorizontalSpace = false;
			lblBankNameLData.grabExcessVerticalSpace = false;
			lblBankName.setLayoutData(lblBankNameLData);
			lblBankName.setText("Bank Name");
	
			GridData txtBankNameLData = new GridData();
			txtBankNameLData.verticalAlignment = GridData.CENTER;
			txtBankNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankNameLData.widthHint = 254;
			txtBankNameLData.heightHint = 13;
			txtBankNameLData.horizontalIndent = 0;
			txtBankNameLData.horizontalSpan = 1;
			txtBankNameLData.verticalSpan = 1;
			txtBankNameLData.grabExcessHorizontalSpace = false;
			txtBankNameLData.grabExcessVerticalSpace = false;
			txtBankName.setLayoutData(txtBankNameLData);
			txtBankName.setTextLimit(50);
			txtBankName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankBranchNameLData = new GridData();
			lblBankBranchNameLData.verticalAlignment = GridData.CENTER;
			lblBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankBranchNameLData.widthHint = 95;
			lblBankBranchNameLData.heightHint = 19;
			lblBankBranchNameLData.horizontalIndent = 0;
			lblBankBranchNameLData.horizontalSpan = 1;
			lblBankBranchNameLData.verticalSpan = 1;
			lblBankBranchNameLData.grabExcessHorizontalSpace = false;
			lblBankBranchNameLData.grabExcessVerticalSpace = false;
			lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			lblBankBranchName.setText("Bank Branch Name");
			lblBankBranchName.setSize(new org.eclipse.swt.graphics.Point(95,19));
	
			GridData txtBankBranchNameLData = new GridData();
			txtBankBranchNameLData.verticalAlignment = GridData.CENTER;
			txtBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankBranchNameLData.widthHint = 254;
			txtBankBranchNameLData.heightHint = 13;
			txtBankBranchNameLData.horizontalIndent = 0;
			txtBankBranchNameLData.horizontalSpan = 1;
			txtBankBranchNameLData.verticalSpan = 1;
			txtBankBranchNameLData.grabExcessHorizontalSpace = false;
			txtBankBranchNameLData.grabExcessVerticalSpace = false;
			txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			txtBankBranchName.setTextLimit(50);
			txtBankBranchName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lvlBanckAccountNoLData = new GridData();
			lvlBanckAccountNoLData.verticalAlignment = GridData.CENTER;
			lvlBanckAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			lvlBanckAccountNoLData.widthHint = -1;
			lvlBanckAccountNoLData.heightHint = -1;
			lvlBanckAccountNoLData.horizontalIndent = 0;
			lvlBanckAccountNoLData.horizontalSpan = 1;
			lvlBanckAccountNoLData.verticalSpan = 1;
			lvlBanckAccountNoLData.grabExcessHorizontalSpace = false;
			lvlBanckAccountNoLData.grabExcessVerticalSpace = false;
			lvlBanckAccountNo.setLayoutData(lvlBanckAccountNoLData);
			lvlBanckAccountNo.setText("Bank Account No");
	
			GridData txtBankAccountNoLData = new GridData();
			txtBankAccountNoLData.verticalAlignment = GridData.CENTER;
			txtBankAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			txtBankAccountNoLData.widthHint = 254;
			txtBankAccountNoLData.heightHint = 13;
			txtBankAccountNoLData.horizontalIndent = 0;
			txtBankAccountNoLData.horizontalSpan = 1;
			txtBankAccountNoLData.verticalSpan = 1;
			txtBankAccountNoLData.grabExcessHorizontalSpace = false;
			txtBankAccountNoLData.grabExcessVerticalSpace = false;
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
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
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
