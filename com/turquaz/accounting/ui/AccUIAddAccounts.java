package com.turquaz.accounting.ui;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;
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
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAddAccounts extends SecureComposite{

	/**
	 * @return Returns the txtAccAccountCode.
	 */
	public Text getTxtAccAccountCode() {
		return txtAccAccountCode;
	}
	/**
	 * @return Returns the txtAccAcountName.
	 */
	public Text getTxtAccAcountName() {
		return txtAccAcountName;
	}
	/**
	 * @return Returns the txtParentAccount.
	 */
	public TextWithButton getTxtParentAccount() {
		return txtParentAccount;
	}
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
	
			this.setSize(new org.eclipse.swt.graphics.Point(411,183));
	
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
			txtAccAcountNameLData.widthHint = 256;
			txtAccAcountNameLData.heightHint = 17;
			txtAccAcountNameLData.horizontalIndent = 0;
			txtAccAcountNameLData.horizontalSpan = 1;
			txtAccAcountNameLData.verticalSpan = 1;
			txtAccAcountNameLData.grabExcessHorizontalSpace = false;
			txtAccAcountNameLData.grabExcessVerticalSpace = false;
			txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			txtAccAcountName.setSize(new org.eclipse.swt.graphics.Point(256,17));
	
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
			txtAccAccountCodeLData.widthHint = 255;
			txtAccAccountCodeLData.heightHint = 17;
			txtAccAccountCodeLData.horizontalIndent = 0;
			txtAccAccountCodeLData.horizontalSpan = 1;
			txtAccAccountCodeLData.verticalSpan = 1;
			txtAccAccountCodeLData.grabExcessHorizontalSpace = false;
			txtAccAccountCodeLData.grabExcessVerticalSpace = false;
			txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			txtAccAccountCode.setSize(new org.eclipse.swt.graphics.Point(255,17));
			final Color txtAccAccountCodebackground = new Color(Display.getDefault(),255,255,255);
			txtAccAccountCode.setBackground(txtAccAccountCodebackground);
	
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
			txtParentAccountLData.verticalAlignment = GridData.CENTER;
			txtParentAccountLData.horizontalAlignment = GridData.BEGINNING;
			txtParentAccountLData.widthHint = 147;
			txtParentAccountLData.heightHint = 17;
			txtParentAccountLData.horizontalIndent = 0;
			txtParentAccountLData.horizontalSpan = 1;
			txtParentAccountLData.verticalSpan = 1;
			txtParentAccountLData.grabExcessHorizontalSpace = false;
			txtParentAccountLData.grabExcessVerticalSpace = false;
			txtParentAccount.setLayoutData(txtParentAccountLData);
			txtParentAccount.setSize(new org.eclipse.swt.graphics.Point(147,17));
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
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					txtAccAccountCodebackground.dispose();
				}
			});
	
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
	
	
	public boolean verifyFields(){
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
   
    boolean valid = false;
   
    if(txtAccAcountName.getText().trim().equals("")){
	  msg.setMessage("Please Fill Account Name!");
    msg.open();	
    return false;
	}
	
	else if(txtAccAccountCode.getText().trim().equals("")){
    msg.setMessage("Please Fill Account Code!");
    msg.open();	
    return false;
    }
    
	else if(txtParentAccount.getText().trim().equals("")){
	  msg.setMessage("Please Fill Parent Account");
    msg.open();	
    return false;
	}
	
	return true;
	
	}
	public void clearFields(){
	txtAccAccountCode.setText("");
	txtAccAcountName.setText("");
	txtParentAccount.setText("");
	txtParentAccount.setData("");
	
	}
	
	
	public void save(){
		try{
			
	if(verifyFields()){
	String accountName = txtAccAcountName.getText().trim();
	String accountCode = txtAccAccountCode.getText().trim();
    int parentId = ((Integer)txtParentAccount.getData()).intValue();
		
    blAccountAdd.saveAccount(accountName,accountCode,parentId);	
    MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage("Succesfully Saved!");
    msg.open();
    
    clearFields();
	}
	}
	catch(Exception ex){
		ex.printStackTrace();
		 MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		 msg.setMessage("An Error occured");
		 msg.open();
		
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
			Rectangle shellBounds = shell.computeTrim(0,0,411,183);
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
	
	
	Object[] obj = new AccUISearchAccountsDialog(this.getShell(),SWT.NULL).showDialog("");
		if (obj[0] != null) {
			txtParentAccount.setData(obj[1]);
			txtParentAccount.setText(obj[0].toString());
		}
	
	
	}
}
