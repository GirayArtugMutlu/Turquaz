package com.turquaz.accounting.ui;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.engine.ui.component.TextWithButton;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAddAccounts extends SecureComposite{

	private TextWithButton txtParentAccount;
	private AccBLAccountAdd blAccountAdd = new AccBLAccountAdd();
	private CLabel cLabel2;
	private Text txtAccAccountCode;
	private CLabel cLabel1;
	private Text txtAccAcountName;
	private Label label1;
	public AccUIAddAccounts(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			label1 = new Label(this,SWT.NULL);
			txtAccAcountName = new Text(this,SWT.NULL);
			cLabel1 = new CLabel(this,SWT.NULL);
			txtAccAccountCode = new Text(this,SWT.NULL);
			cLabel2 = new CLabel(this,SWT.NULL);
			txtParentAccount = new TextWithButton(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(448,326));
	
			GridData label1LData = new GridData();
			label1LData.verticalAlignment = GridData.CENTER;
			label1LData.horizontalAlignment = GridData.BEGINNING;
			label1LData.widthHint = 91;
			label1LData.heightHint = 18;
			label1LData.horizontalIndent = 0;
			label1LData.horizontalSpan = 1;
			label1LData.verticalSpan = 1;
			label1LData.grabExcessHorizontalSpace = false;
			label1LData.grabExcessVerticalSpace = false;
			label1.setLayoutData(label1LData);
			label1.setText("Account Name");
			label1.setSize(new org.eclipse.swt.graphics.Point(91,18));
	
			GridData txtAccAcountNameLData = new GridData();
			txtAccAcountNameLData.verticalAlignment = GridData.CENTER;
			txtAccAcountNameLData.horizontalAlignment = GridData.BEGINNING;
			txtAccAcountNameLData.widthHint = 143;
			txtAccAcountNameLData.heightHint = 19;
			txtAccAcountNameLData.horizontalIndent = 0;
			txtAccAcountNameLData.horizontalSpan = 1;
			txtAccAcountNameLData.verticalSpan = 1;
			txtAccAcountNameLData.grabExcessHorizontalSpace = false;
			txtAccAcountNameLData.grabExcessVerticalSpace = false;
			txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			txtAccAcountName.setSize(new org.eclipse.swt.graphics.Point(143,19));
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.BEGINNING;
			cLabel1LData.widthHint = 83;
			cLabel1LData.heightHint = 17;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Account Code");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(83,17));
	
			GridData txtAccAccountCodeLData = new GridData();
			txtAccAccountCodeLData.verticalAlignment = GridData.CENTER;
			txtAccAccountCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtAccAccountCodeLData.widthHint = 144;
			txtAccAccountCodeLData.heightHint = 17;
			txtAccAccountCodeLData.horizontalIndent = 0;
			txtAccAccountCodeLData.horizontalSpan = 1;
			txtAccAccountCodeLData.verticalSpan = 1;
			txtAccAccountCodeLData.grabExcessHorizontalSpace = false;
			txtAccAccountCodeLData.grabExcessVerticalSpace = false;
			txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			txtAccAccountCode.setSize(new org.eclipse.swt.graphics.Point(144,17));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.BEGINNING;
			cLabel2LData.widthHint = -1;
			cLabel2LData.heightHint = -1;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Parent Account");
	
			GridData txtParentAccountLData = new GridData();
			txtParentAccountLData.widthHint = 146;
			txtParentAccountLData.heightHint = 21;
			txtParentAccount.setLayoutData(txtParentAccountLData);
			txtParentAccount.setSize(new org.eclipse.swt.graphics.Point(146,21));
			txtParentAccount.setEnabled(true);
			txtParentAccount.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					txtParentAccountMouseUp(evt);
				}
			});
			txtParentAccount.layout();
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 20;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}
	
	public void save(){
		try{
			
	
	String accountName = txtAccAcountName.getText().trim();
	String accountCode = txtAccAccountCode.getText().trim();
    int parentId = Integer.parseInt(txtParentAccount.getText().trim());
		
    blAccountAdd.saveAccount(accountName,accountCode,parentId);	
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
		
	}
	public void search(){
	}
	public void delete(){
	
	}
	public void newForm(){
	}

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			AccUIAddAccounts inst = new AccUIAddAccounts(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,448,326);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void txtParentAccountMouseUp(MouseEvent evt){
	new AccUISearchAccountsDialog(this.getShell(),SWT.NULL).showDialog("");
	
	
	
	}
}
